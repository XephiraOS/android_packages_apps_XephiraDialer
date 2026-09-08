package com.customize.contacts.backupandrestore.plugin;

import H7.b;
import R0.c;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.android.contacts.framework.vcard.VCardEntry;
import com.android.contacts.framework.vcard.i;
import com.android.contacts.framework.vcard.m;
import com.android.contacts.model.Account;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.backupandrestore.plugin.ContactBackupPlugin;
import com.customize.contacts.backupandrestore.plugin.helper.DuplicatedCheckHelper;
import com.customize.contacts.cleaner.RawCleanerJobService;
import com.customize.contacts.importcontact.o;
import com.customize.contacts.manager.C0786a;
import com.customize.contacts.util.C0794e;
import com.customize.contacts.util.C0798i;
import com.customize.contacts.util.D;
import com.oplus.backup.sdk.common.host.BREngineConfig;
import com.oplus.backup.sdk.component.BRPluginHandler;
import com.oplus.backup.sdk.host.listener.ProgressHelper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import o1.C1393c;

/* loaded from: classes3.dex */
public class ContactRestorePlugin extends SpeedDialRestorePlugin {
    private static final String TAG = "ContactRestorePlugin";
    private BRPluginHandler mBRPluginHandler;
    private String mFileName;
    private boolean mIsCancel;
    private boolean mIsPause;
    private int mMaxCount;
    private BREngineConfig mRestoreConfig;
    private m mVcardParser;
    private final Object mLock = new Object();
    private int mCompletedCount = 0;
    private ContactBackupPlugin.ContactsSettingsData mContactsSettingsData = null;
    private boolean mNeedUpdateAssistedDialingSwitch = false;

    /* loaded from: classes3.dex */
    public class RestoreVCardEntryCommitter extends o {
        private long mStart;

        public RestoreVCardEntryCommitter(Context context) {
            super(context);
        }

        private void dealCheckedVCardEntries() {
            List<DuplicatedCheckHelper.VCardEntryWithIds> checkSameDisplayNameRaws = DuplicatedCheckHelper.INSTANCE.checkSameDisplayNameRaws();
            b.e(ContactRestorePlugin.TAG, "dealCheckedVCardEntries: list.size: " + checkSameDisplayNameRaws.size());
            for (DuplicatedCheckHelper.VCardEntryWithIds vCardEntryWithIds : checkSameDisplayNameRaws) {
                if (vCardEntryWithIds.mState == 1) {
                    processOneVCardEntry(null);
                } else {
                    processOneVCardEntry(vCardEntryWithIds.mVCardEntry);
                }
            }
        }

        private void processOneVCardEntry(VCardEntry vCardEntry) {
            if (vCardEntry != null) {
                super.onEntryCreated(vCardEntry);
                ContactRestorePlugin.this.restorePhotoFile(this.mContext, vCardEntry);
            }
            ContactRestorePlugin.this.mCompletedCount++;
            Bundle bundle = new Bundle();
            ProgressHelper.putMaxCount(bundle, ContactRestorePlugin.this.mMaxCount);
            ProgressHelper.putCompletedCount(bundle, ContactRestorePlugin.this.mCompletedCount);
            ContactRestorePlugin.this.mBRPluginHandler.updateProgress(bundle);
        }

        @Override // com.customize.contacts.importcontact.o, com.android.contacts.framework.vcard.h, com.android.contacts.framework.vcard.k
        public void onEnd() {
            dealCheckedVCardEntries();
            super.onEnd();
            b.b(ContactRestorePlugin.TAG, "onEnd: cost: " + (System.currentTimeMillis() - this.mStart));
        }

        @Override // com.customize.contacts.importcontact.o, com.android.contacts.framework.vcard.h, com.android.contacts.framework.vcard.k
        public void onEntryCreated(VCardEntry vCardEntry) {
            synchronized (ContactRestorePlugin.this.mLock) {
                while (ContactRestorePlugin.this.mIsPause) {
                    try {
                        b.e(ContactRestorePlugin.TAG, "on pause wait lock here");
                        ContactRestorePlugin.this.mLock.wait();
                    } catch (InterruptedException e10) {
                        b.e(ContactRestorePlugin.TAG, "onEntryCreated e = " + e10);
                    }
                }
            }
            DuplicatedCheckHelper duplicatedCheckHelper = DuplicatedCheckHelper.INSTANCE;
            if (!duplicatedCheckHelper.isCacheEmpty()) {
                ArrayList<Long> sameDisplayNameRawIds = duplicatedCheckHelper.getSameDisplayNameRawIds(vCardEntry.N());
                if (sameDisplayNameRawIds != null && !sameDisplayNameRawIds.isEmpty()) {
                    if (duplicatedCheckHelper.addToVCardEntryWithIdsList(vCardEntry, sameDisplayNameRawIds) >= 50) {
                        dealCheckedVCardEntries();
                    }
                } else {
                    processOneVCardEntry(vCardEntry);
                }
            } else {
                processOneVCardEntry(vCardEntry);
            }
            if (ContactRestorePlugin.this.mIsCancel && ContactRestorePlugin.this.mVcardParser != null) {
                ContactRestorePlugin.this.mVcardParser.b();
            }
        }

        @Override // com.android.contacts.framework.vcard.h, com.android.contacts.framework.vcard.k
        public void onStart() {
            this.mStart = System.currentTimeMillis();
        }
    }

    private boolean dealBusinessData(String str) {
        if (!FeatureOption.g()) {
            return false;
        }
        boolean restoreBusinessSettings = restoreBusinessSettings(str);
        if (restoreBusinessSettings) {
            b.e(TAG, "restoreBusinessSettingsResult succeeded");
        }
        boolean restoreBusinessCustomizedCommand = restoreBusinessCustomizedCommand(str);
        if (restoreBusinessCustomizedCommand) {
            b.e(TAG, "restoreBusinessCustomizedCommandResult succeeded");
        }
        if (!restoreBusinessSettings && !restoreBusinessCustomizedCommand) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v12, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v8 */
    private int getContactCount() {
        StringBuilder sb;
        int i10 = 0;
        BufferedReader bufferedReader = null;
        ?? r32 = 0;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.mRestoreConfig.getRestoreRootPath());
                String str = File.separator;
                sb2.append(str);
                sb2.append("Contact");
                sb2.append(str);
                sb2.append(BRConstant.NAME_CONTACT);
                this.mFileName = sb2.toString();
                BufferedReader bufferedReader3 = new BufferedReader(new InputStreamReader(new FileInputStream(getFileDescriptor(this.mFileName))));
                while (true) {
                    try {
                        String readLine = bufferedReader3.readLine();
                        if (readLine != null) {
                            r32 = "END:VCARD";
                            if (readLine.contains("END:VCARD")) {
                                i10++;
                            }
                        } else {
                            try {
                                break;
                            } catch (IOException e10) {
                                e = e10;
                                sb = new StringBuilder();
                                sb.append("IOException e: ");
                                sb.append(e);
                                b.c(TAG, sb.toString());
                                return i10;
                            }
                        }
                    } catch (Exception e11) {
                        e = e11;
                        bufferedReader2 = bufferedReader3;
                        b.c(TAG, "IOException e: " + e);
                        bufferedReader = bufferedReader2;
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                                bufferedReader = bufferedReader2;
                            } catch (IOException e12) {
                                e = e12;
                                sb = new StringBuilder();
                                sb.append("IOException e: ");
                                sb.append(e);
                                b.c(TAG, sb.toString());
                                return i10;
                            }
                        }
                        return i10;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader3;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e13) {
                                b.c(TAG, "IOException e: " + e13);
                            }
                        }
                        throw th;
                    }
                }
                bufferedReader3.close();
                bufferedReader = r32;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e14) {
            e = e14;
        }
        return i10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:94:0x0180, code lost:
    
        r5.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:138:0x026a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:145:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0251 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0238 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.customize.contacts.backupandrestore.plugin.ContactBackupPlugin.ContactsSettingsData getContactsSettingsData() {
        /*
            Method dump skipped, instructions count: 642
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.backupandrestore.plugin.ContactRestorePlugin.getContactsSettingsData():com.customize.contacts.backupandrestore.plugin.ContactBackupPlugin$ContactsSettingsData");
    }

    private Account getDefaultAccount() {
        return new Account(R0.a.f3165a, R0.a.f3166b);
    }

    private i getEntryConstructor() {
        i iVar = new i(-1073741824, getDefaultAccount());
        RestoreVCardEntryCommitter restoreVCardEntryCommitter = new RestoreVCardEntryCommitter(getContext());
        iVar.h(getContext().getContentResolver());
        iVar.f(restoreVCardEntryCommitter);
        return iVar;
    }

    private String getFolder() {
        return this.mRestoreConfig.getRestoreRootPath() + File.separator + "Contact";
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x014d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x017f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0128 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x017f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x017f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0172 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x017f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00bc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0185 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void readOneVCard(int r9, com.android.contacts.framework.vcard.l r10, int[] r11) {
        /*
            Method dump skipped, instructions count: 440
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.backupandrestore.plugin.ContactRestorePlugin.readOneVCard(int, com.android.contacts.framework.vcard.l, int[]):void");
    }

    private boolean restoreBusinessCustomizedCommand(String str) {
        return com.android.contacts.framework.api.businesshall.a.g(str);
    }

    private boolean restoreBusinessSettings(String str) {
        return com.android.contacts.framework.api.businesshall.a.l(str);
    }

    private void restoreContactsSettingsData() {
        if (!this.mIsCancel && this.mContactsSettingsData != null) {
            b.b(TAG, "restoreContactsSettingsData");
            synchronized (this.mLock) {
                while (this.mIsPause) {
                    try {
                        b.b(TAG, "restoreContactsSettingsData on pause wait lock here");
                        this.mLock.wait();
                    } catch (InterruptedException e10) {
                        b.c(TAG, "restoreContactsSettingsData e = " + e10);
                    }
                }
            }
            setContactsSettingsData(getContext(), this.mContactsSettingsData);
            this.mContactsSettingsData = null;
        }
    }

    public String getRootPath() {
        return this.mRestoreConfig.getRestoreRootPath();
    }

    @Override // com.customize.contacts.backupandrestore.plugin.SpeedDialRestorePlugin, com.oplus.backup.sdk.component.plugin.IBRPlugin
    public void onCancel(Bundle bundle) {
        super.onCancel(bundle);
        this.mIsCancel = true;
        this.mIsPause = false;
        synchronized (this.mLock) {
            this.mLock.notifyAll();
            b.e(TAG, "onCancel mLock.notifyAll()");
        }
    }

    @Override // com.customize.contacts.backupandrestore.plugin.SpeedDialRestorePlugin, com.oplus.backup.sdk.component.plugin.IBRPlugin
    public void onContinue(Bundle bundle) {
        super.onContinue(bundle);
        this.mIsPause = false;
        synchronized (this.mLock) {
            this.mLock.notifyAll();
            b.e(TAG, "onContinue mLock.notifyAll()");
        }
    }

    @Override // com.customize.contacts.backupandrestore.plugin.SpeedDialRestorePlugin, com.oplus.backup.sdk.component.plugin.AbstractPlugin
    public void onCreate(Context context, BRPluginHandler bRPluginHandler, BREngineConfig bREngineConfig) {
        super.onCreate(context, bRPluginHandler, bREngineConfig);
        this.mBRPluginHandler = bRPluginHandler;
        this.mRestoreConfig = bREngineConfig;
    }

    @Override // com.customize.contacts.backupandrestore.plugin.SpeedDialRestorePlugin, com.oplus.backup.sdk.component.plugin.IBRPlugin
    public Bundle onDestroy(Bundle bundle) {
        int i10;
        super.onDestroy(bundle);
        try {
            C0798i.c(getContext());
            C0798i.b(getContext());
        } catch (Exception e10) {
            b.b(TAG, "send CHANGE_ACTION for Calendar error" + e10);
        }
        Q3.b.c();
        Bundle bundle2 = new Bundle();
        if (this.mIsCancel) {
            i10 = 3;
        } else {
            i10 = 1;
        }
        ProgressHelper.putBRResult(bundle2, i10);
        ProgressHelper.putMaxCount(bundle2, this.mMaxCount);
        ProgressHelper.putCompletedCount(bundle2, this.mCompletedCount);
        b.e(TAG, "onDestroy =" + bundle2);
        RawCleanerJobService.b(getContext(), false, true);
        C0786a.j().g();
        DuplicatedCheckHelper.INSTANCE.destroy();
        return bundle2;
    }

    @Override // com.customize.contacts.backupandrestore.plugin.SpeedDialRestorePlugin, com.oplus.backup.sdk.component.plugin.IBRPlugin
    public void onPause(Bundle bundle) {
        super.onPause(bundle);
        this.mIsPause = true;
    }

    @Override // com.customize.contacts.backupandrestore.plugin.SpeedDialRestorePlugin, com.oplus.backup.sdk.component.plugin.IBRPlugin
    public Bundle onPrepare(Bundle bundle) {
        super.onPrepare(bundle);
        this.mContactsSettingsData = getContactsSettingsData();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            this.mMaxCount = getContactCount();
            DuplicatedCheckHelper.INSTANCE.init(getContext(), getDefaultAccount());
        } catch (Exception e10) {
            b.c(TAG, "Exception e: " + e10);
        }
        b.b(TAG, "onPrepare time: " + (SystemClock.elapsedRealtime() - elapsedRealtime) + ",mCount: " + this.mMaxCount);
        Bundle bundle2 = new Bundle();
        ProgressHelper.putMaxCount(bundle2, this.mMaxCount);
        return bundle2;
    }

    @Override // com.customize.contacts.backupandrestore.plugin.SpeedDialRestorePlugin, com.oplus.backup.sdk.component.plugin.IBRPlugin
    public Bundle onPreview(Bundle bundle) {
        super.onPreview(bundle);
        return null;
    }

    @Override // com.customize.contacts.backupandrestore.plugin.SpeedDialRestorePlugin, com.oplus.backup.sdk.component.plugin.IBRPlugin
    public void onRestore(Bundle bundle) {
        super.onRestore(bundle);
        restoreContactsSettingsData();
        C0786a.j().h();
        if (this.mMaxCount > 0 && !this.mIsCancel && this.mCompletedCount == 0) {
            readOneVCard(-1073741824, getEntryConstructor(), new int[]{-1073741824, -1073741823});
        }
        X.a.b(getContext()).d(new Intent("oplus.intent.action.ACTION_RESTORE_FILTER"));
        com.android.contacts.framework.api.infocollection.a.c();
    }

    public void restorePhotoFile(Context context, VCardEntry vCardEntry) {
        if (vCardEntry != null && vCardEntry.J() != null) {
            Iterator it = new ArrayList(vCardEntry.J()).iterator();
            while (it.hasNext()) {
                VCardEntry.b bVar = (VCardEntry.b) it.next();
                List<String> h10 = bVar.h();
                if (TextUtils.equals("vnd.android.cursor.item/omoji_photo", bVar.i()) && h10 != null && !TextUtils.isEmpty(h10.get(0))) {
                    Uri parse = Uri.parse(h10.get(0));
                    StringBuilder sb = new StringBuilder();
                    sb.append(getRootPath());
                    String str = File.separator;
                    sb.append(str);
                    sb.append("Contact");
                    sb.append(str);
                    String g10 = D.g(parse, sb.toString());
                    if (!TextUtils.isEmpty(g10)) {
                        try {
                            FileDescriptor fileDescriptor = getFileDescriptor(g10);
                            if (fileDescriptor != null) {
                                D.b(new FileInputStream(fileDescriptor), context.getContentResolver().openAssetFileDescriptor(parse, "w").createOutputStream());
                            }
                        } catch (IOException | IllegalStateException e10) {
                            b.c(TAG, "Failed to restore photo: " + parse + " because: " + e10);
                        } catch (Throwable th) {
                            b.c(TAG, "Failed to restore photo th: " + th);
                        }
                    }
                }
            }
        }
    }

    public void setContactsSettingsData(Context context, ContactBackupPlugin.ContactsSettingsData contactsSettingsData) {
        String str;
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("filter.onlyPhone", contactsSettingsData.mDataEnable).apply();
        if (FeatureOption.o()) {
            C1393c c1393c = new C1393c(context);
            int i10 = contactsSettingsData.mSortOrder;
            if (i10 != -1) {
                c1393c.o(i10);
            }
            int i11 = contactsSettingsData.mDisplayOrder;
            if (i11 != -1) {
                c1393c.m(i11);
            }
        }
        if (this.mNeedUpdateAssistedDialingSwitch) {
            String str2 = c.a.f3199e;
            if (contactsSettingsData.mAssistedDialingEnable) {
                str = "true";
            } else {
                str = "false";
            }
            G0.c.t(context, 0, str2, str);
            C0794e.l(contactsSettingsData.mAssistedDialingEnable);
        }
    }
}
