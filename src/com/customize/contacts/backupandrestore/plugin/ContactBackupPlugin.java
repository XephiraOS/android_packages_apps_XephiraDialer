package com.customize.contacts.backupandrestore.plugin;

import G7.c;
import H7.b;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.android.contacts.activities.RequestPermissionsActivityBase;
import com.android.contacts.compat.data.PreferenceWrapper;
import com.android.contacts.compat.data.f;
import com.android.contacts.framework.api.cloudsync.SyncFeature;
import com.android.contacts.framework.baseui.util.C0637b;
import com.android.contacts.framework.baseui.util.s;
import com.android.contacts.framework.vcard.d;
import com.android.incallui.OplusPhoneUtils;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.util.C0794e;
import com.customize.contacts.util.D;
import com.oplus.backup.sdk.common.host.BREngineConfig;
import com.oplus.backup.sdk.compat.DataSizeUtils;
import com.oplus.backup.sdk.component.BRPluginHandler;
import com.oplus.backup.sdk.host.listener.ProgressHelper;
import com.oplus.foundation.util.OsUtils;
import com.oplus.foundation.util.feature.FeatureUtil;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import o1.C1393c;
import r0.k;

/* loaded from: classes3.dex */
public class ContactBackupPlugin extends SpeedDialBackPlugin {
    public static final String BEGIN_CONTACTSETTINGS_DATA = "BEGIN:CONTACTSETTINGS_DATA";
    public static final String CONTACTSETTINGS_XML = "contactsettings_backup.xml";
    public static final String DATA_ENABLE = "DATA_ENABLE:";
    public static final String END_OF_LINE = "\r\n";
    public static final String KEY_CLOUD_SERVICE_RECOMMENDATION = "cloud_service_recommendation:";
    public static final String KEY_DISPLAY_ORDER = "displayOrder:";
    public static final String KEY_NUMBER_RECOGNITION_EXPERIENCE_IMPROVEMENT = "number_recognition_experience_improvement:";
    public static final String KEY_SORT_ORDER = "sortOrder:";
    private static final String TAG = "ContactBackupPlugin";
    private BRPluginHandler mBRPluginHandler;
    private BREngineConfig mBackupConfig;
    private Cursor mDataCursor;
    private FileDescriptor mFileDescriptor;
    private boolean mIsCancel;
    private boolean mIsPause;
    private int mMaxCount;
    private FileOutputStream mOutStream;
    private d mVCardComposer;
    private Writer mWriter;
    private final Object mLock = new Object();
    private int mCompletedCount = 0;

    /* loaded from: classes3.dex */
    public static class ContactsSettingsData {
        boolean mAssistedDialingEnable;
        boolean mDataEnable;
        int mSortOrder = -1;
        int mDisplayOrder = -1;
    }

    private void addCloudServiceRecommendationState(StringBuilder sb) {
        if (SyncFeature.f15571a.e()) {
            boolean b10 = SyncFeature.b(getContext());
            sb.append(KEY_CLOUD_SERVICE_RECOMMENDATION);
            sb.append(String.valueOf(b10));
            sb.append(END_OF_LINE);
            if (H7.a.b()) {
                b.b(TAG, "addCloudServiceRecommendationState: value: " + b10);
            }
        }
    }

    private void addNumberRecognitionExperienceImprovement(StringBuilder sb) {
        if (FeatureUtil.P()) {
            sb.append(KEY_NUMBER_RECOGNITION_EXPERIENCE_IMPROVEMENT);
            sb.append(s.e(getContext()));
            sb.append(END_OF_LINE);
        }
    }

    private void backupBusinessCalibrationTemplates(StringBuilder sb) {
        List<I.d<String, List<String>>> b10 = com.android.contacts.framework.api.businesshall.a.b();
        if (b10 != null) {
            for (I.d<String, List<String>> dVar : b10) {
                String str = dVar.f1295a;
                for (String str2 : dVar.f1296b) {
                    sb.append(str);
                    sb.append(str2);
                    sb.append(END_OF_LINE);
                }
            }
        }
    }

    private void backupBusinessSettings(StringBuilder sb) {
        ArrayList<I.d<String, Boolean>> e10 = com.android.contacts.framework.api.businesshall.a.e();
        if (e10 != null) {
            for (I.d<String, Boolean> dVar : e10) {
                sb.append(dVar.f1295a);
                sb.append(dVar.f1296b);
                sb.append(END_OF_LINE);
            }
        }
    }

    private void backupContactsSettings(boolean z10) {
        Writer writer;
        b.e(TAG, "backupContactsSettings");
        ContactsSettingsData contactsSettingsData = getContactsSettingsData(getContext());
        if (!this.mIsCancel) {
            synchronized (this.mLock) {
                while (this.mIsPause) {
                    try {
                        b.e(TAG, "backupContactsSettings on pause wait lock here");
                        this.mLock.wait();
                    } catch (InterruptedException e10) {
                        b.c(TAG, "backupContactsSettings: e = " + e10);
                    }
                }
            }
            if (contactsSettingsData != null) {
                try {
                    try {
                        try {
                            this.mWriter.write(addContactsSettingsData(contactsSettingsData, z10));
                            this.mWriter.flush();
                            this.mFileDescriptor.sync();
                            writer = this.mWriter;
                        } catch (Throwable th) {
                            Writer writer2 = this.mWriter;
                            if (writer2 != null) {
                                writer2.close();
                                this.mWriter = null;
                            }
                            throw th;
                        }
                    } catch (IOException e11) {
                        b.c(TAG, "IOException" + e11);
                        Writer writer3 = this.mWriter;
                        if (writer3 != null) {
                            writer3.close();
                        } else {
                            return;
                        }
                    } catch (Exception e12) {
                        b.c(TAG, "Exception" + e12);
                        Writer writer4 = this.mWriter;
                        if (writer4 != null) {
                            writer4.close();
                        } else {
                            return;
                        }
                    }
                    if (writer != null) {
                        writer.close();
                        this.mWriter = null;
                    }
                } catch (Exception e13) {
                    b.c(TAG, "backupContactsSettings: Exception e = " + e13);
                }
            }
        }
    }

    private void dealBusinessData(StringBuilder sb) {
        if (FeatureOption.g() && !RequestPermissionsActivityBase.e2(getContext())) {
            backupBusinessSettings(sb);
            backupBusinessCalibrationTemplates(sb);
        }
    }

    private void startBackupContactsSettingsXml() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.mBackupConfig.getBackupRootPath());
        String str = File.separator;
        sb.append(str);
        sb.append("Contact");
        try {
            this.mFileDescriptor = getFileDescriptor(sb.toString() + str + CONTACTSETTINGS_XML);
            this.mWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.mFileDescriptor)));
        } catch (Exception unused) {
            b.c(TAG, "new Buffer Writer fail");
        }
    }

    public String addContactsSettingsData(ContactsSettingsData contactsSettingsData, boolean z10) {
        StringBuilder sb = new StringBuilder();
        sb.append(BEGIN_CONTACTSETTINGS_DATA);
        sb.append(END_OF_LINE);
        sb.append(DATA_ENABLE);
        sb.append(String.valueOf(contactsSettingsData.mDataEnable));
        sb.append(END_OF_LINE);
        sb.append(KEY_SORT_ORDER);
        sb.append(contactsSettingsData.mSortOrder);
        sb.append(END_OF_LINE);
        sb.append(KEY_DISPLAY_ORDER);
        sb.append(contactsSettingsData.mDisplayOrder);
        sb.append(END_OF_LINE);
        sb.append("oplus_customize_assisted_dialing_switch");
        sb.append(String.valueOf(contactsSettingsData.mAssistedDialingEnable));
        sb.append(END_OF_LINE);
        String a10 = k.a("oplus_customize_assisted_dialing_switch", z10);
        if (!"oplus_customize_assisted_dialing_switch".equals(a10)) {
            sb.append(a10);
            sb.append(String.valueOf(contactsSettingsData.mAssistedDialingEnable));
            sb.append(END_OF_LINE);
        }
        dealBusinessData(sb);
        addCloudServiceRecommendationState(sb);
        addNumberRecognitionExperienceImprovement(sb);
        return sb.toString();
    }

    public void backupPhotos(Context context, ArrayList<String> arrayList) {
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!TextUtils.isEmpty(next)) {
                Uri parse = Uri.parse(next);
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
                            D.b(context.getContentResolver().openAssetFileDescriptor(parse, "r").createInputStream(), new FileOutputStream(fileDescriptor));
                        }
                    } catch (IOException | IllegalStateException e10) {
                        b.c(TAG, "Failed to copy file: because: " + e10);
                    } catch (Throwable th) {
                        b.c(TAG, "Failed to copy file: th: " + th);
                    }
                }
            }
        }
    }

    public ContactsSettingsData getContactsSettingsData(Context context) {
        ContactsSettingsData contactsSettingsData = new ContactsSettingsData();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        if (defaultSharedPreferences == null) {
            contactsSettingsData.mDataEnable = false;
        } else {
            contactsSettingsData.mDataEnable = new PreferenceWrapper(defaultSharedPreferences).a("filter.onlyPhone", false);
        }
        C1393c c1393c = new C1393c(getContext());
        contactsSettingsData.mSortOrder = c1393c.h();
        contactsSettingsData.mDisplayOrder = c1393c.g();
        contactsSettingsData.mAssistedDialingEnable = C0794e.h();
        return contactsSettingsData;
    }

    public String getRootPath() {
        return this.mBackupConfig.getBackupRootPath();
    }

    @Override // com.customize.contacts.backupandrestore.plugin.SpeedDialBackPlugin, com.oplus.backup.sdk.component.plugin.IBRPlugin
    public void onBackup(Bundle bundle) {
        boolean z10;
        super.onBackup(bundle);
        b.e(TAG, "onBackup onStart ------------");
        if (C0637b.h()) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        int oldPhoneOSVersion = this.mBackupConfig.getOldPhoneOSVersion();
        String oldPhoneAndroidVersion = this.mBackupConfig.getOldPhoneAndroidVersion();
        b.e(TAG, "onPreview osVersion = " + oldPhoneOSVersion + ", androidVersion = " + oldPhoneAndroidVersion);
        if (OsUtils.d(oldPhoneOSVersion) && !"a11".equals(oldPhoneAndroidVersion)) {
            z10 = true;
        } else {
            z10 = false;
        }
        backupContactsSettings(z10);
        d dVar = this.mVCardComposer;
        if (dVar != null) {
            int count = dVar.j().getCount();
            for (int i10 = 1; !this.mIsCancel && i10 <= count; i10++) {
                synchronized (this.mLock) {
                    while (this.mIsPause) {
                        try {
                            b.e(TAG, "on pause wait lock here");
                            this.mLock.wait();
                        } catch (InterruptedException e10) {
                            b.c(TAG, "e = " + e10);
                        }
                    }
                }
                String f10 = this.mVCardComposer.f(this.mDataCursor, true, z10, arrayList);
                backupPhotos(getContext(), arrayList);
                arrayList.clear();
                if (f10 != null && !f10.isEmpty() && this.mOutStream != null) {
                    try {
                        byte[] bytes = f10.getBytes();
                        this.mOutStream.write(bytes, 0, bytes.length);
                        this.mCompletedCount++;
                    } catch (IOException e11) {
                        b.c(TAG, "" + e11);
                    }
                }
                Bundle bundle2 = new Bundle();
                ProgressHelper.putMaxCount(bundle2, this.mMaxCount);
                ProgressHelper.putCompletedCount(bundle2, this.mCompletedCount);
                this.mBRPluginHandler.updateProgress(bundle2);
            }
        }
        com.android.contacts.framework.api.infocollection.a.c();
    }

    @Override // com.customize.contacts.backupandrestore.plugin.SpeedDialBackPlugin, com.oplus.backup.sdk.component.plugin.IBRPlugin
    public void onCancel(Bundle bundle) {
        super.onCancel(bundle);
        this.mIsCancel = true;
        this.mIsPause = false;
        synchronized (this.mLock) {
            this.mLock.notifyAll();
            b.e(TAG, "onCancel mLock.notifyAll()");
        }
    }

    @Override // com.customize.contacts.backupandrestore.plugin.SpeedDialBackPlugin, com.oplus.backup.sdk.component.plugin.IBRPlugin
    public void onContinue(Bundle bundle) {
        super.onContinue(bundle);
        this.mIsPause = false;
        synchronized (this.mLock) {
            this.mLock.notifyAll();
            b.e(TAG, "onContinue mLock.notifyAll()");
        }
    }

    @Override // com.customize.contacts.backupandrestore.plugin.SpeedDialBackPlugin, com.oplus.backup.sdk.component.plugin.AbstractPlugin
    public void onCreate(Context context, BRPluginHandler bRPluginHandler, BREngineConfig bREngineConfig) {
        super.onCreate(context, bRPluginHandler, bREngineConfig);
        b.e(TAG, "onCreate() -------------------- start");
        this.mBRPluginHandler = bRPluginHandler;
        this.mBackupConfig = bREngineConfig;
        if (C0637b.h()) {
            b.e("ContactsNumberMaskUtil", "Contacts ContactBackupPlugin onCreate return because number mask switch open cannot backup");
            return;
        }
        String[] strArr = {R0.a.f3165a, R0.a.f3166b};
        try {
            this.mVCardComposer = new d(context, -1073741824, true);
            boolean l10 = this.mVCardComposer.l(Uri.parse("content://com.android.contacts/" + f.c("all_contacts") + "?group_by=true"), new String[]{"contact_id"}, "account_name = ? AND account_type = ?", strArr, null, ContactsContract.RawContactsEntity.CONTENT_URI.buildUpon().appendQueryParameter("for_export_only", OplusPhoneUtils.DeviceState.LOCK_DEVICE).build());
            if (l10) {
                this.mMaxCount = this.mVCardComposer.i();
            } else {
                this.mVCardComposer = null;
            }
            b.e(TAG, "onCreate() mVCardComposer " + this.mVCardComposer);
            if (this.mVCardComposer != null) {
                Uri parse = Uri.parse("content://com.android.contacts/raw_contact_all_entities");
                String str = "SELECT contact_id FROM " + f.c("view_all_contacts") + " WHERE  1 ";
                Cursor e10 = c.e(context.getContentResolver(), parse, d.b.f16519a, "contact_id IN (" + str + ") AND (account_name = ? AND account_type = ?)", strArr, "contact_id , _id");
                this.mDataCursor = e10;
                if (e10 == null || !e10.moveToFirst()) {
                    b.b(TAG, "mDataCursor is null or moveToFirst failed");
                    this.mMaxCount = 0;
                }
            }
            b.e(TAG, "onCreate() end : " + l10 + ", mMaxCount: " + this.mMaxCount);
        } catch (Exception e11) {
            b.c(TAG, "Exception: " + e11);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ae  */
    @Override // com.customize.contacts.backupandrestore.plugin.SpeedDialBackPlugin, com.oplus.backup.sdk.component.plugin.IBRPlugin
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.os.Bundle onDestroy(android.os.Bundle r6) {
        /*
            r5 = this;
            java.lang.String r0 = "Exception e: "
            java.lang.String r1 = "ContactBackupPlugin"
            super.onDestroy(r6)
            r6 = 0
            java.io.Writer r2 = r5.mWriter     // Catch: java.lang.Exception -> L12
            if (r2 == 0) goto L27
            r2.close()     // Catch: java.lang.Exception -> L12
            r5.mWriter = r6     // Catch: java.lang.Exception -> L12
            goto L27
        L12:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "e = "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            H7.b.c(r1, r2)
        L27:
            com.android.contacts.framework.vcard.d r2 = r5.mVCardComposer
            if (r2 == 0) goto L30
            r2.r()
            r5.mVCardComposer = r6
        L30:
            android.database.Cursor r2 = r5.mDataCursor
            if (r2 == 0) goto L39
            r2.close()
            r5.mDataCursor = r6
        L39:
            boolean r6 = r5.mIsCancel
            if (r6 != 0) goto La3
            java.io.FileOutputStream r6 = r5.mOutStream
            if (r6 == 0) goto La3
            r6.flush()     // Catch: java.lang.Throwable -> L67 java.io.IOException -> L69
            java.io.FileOutputStream r6 = r5.mOutStream     // Catch: java.lang.Throwable -> L67 java.io.IOException -> L69
            java.io.FileDescriptor r6 = r6.getFD()     // Catch: java.lang.Throwable -> L67 java.io.IOException -> L69
            r6.sync()     // Catch: java.lang.Throwable -> L67 java.io.IOException -> L69
            java.io.FileOutputStream r6 = r5.mOutStream     // Catch: java.io.IOException -> L53
            r6.close()     // Catch: java.io.IOException -> L53
            goto La3
        L53:
            r6 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
        L59:
            r2.append(r0)
            r2.append(r6)
            java.lang.String r6 = r2.toString()
            H7.b.c(r1, r6)
            goto La3
        L67:
            r6 = move-exception
            goto L89
        L69:
            r6 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L67
            r2.<init>()     // Catch: java.lang.Throwable -> L67
            r2.append(r0)     // Catch: java.lang.Throwable -> L67
            r2.append(r6)     // Catch: java.lang.Throwable -> L67
            java.lang.String r6 = r2.toString()     // Catch: java.lang.Throwable -> L67
            H7.b.c(r1, r6)     // Catch: java.lang.Throwable -> L67
            java.io.FileOutputStream r6 = r5.mOutStream     // Catch: java.io.IOException -> L82
            r6.close()     // Catch: java.io.IOException -> L82
            goto La3
        L82:
            r6 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            goto L59
        L89:
            java.io.FileOutputStream r5 = r5.mOutStream     // Catch: java.io.IOException -> L8f
            r5.close()     // Catch: java.io.IOException -> L8f
            goto La2
        L8f:
            r5 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r5)
            java.lang.String r5 = r2.toString()
            H7.b.c(r1, r5)
        La2:
            throw r6
        La3:
            android.os.Bundle r6 = new android.os.Bundle
            r6.<init>()
            boolean r0 = r5.mIsCancel
            if (r0 == 0) goto Lae
            r0 = 3
            goto Laf
        Lae:
            r0 = 1
        Laf:
            com.oplus.backup.sdk.host.listener.ProgressHelper.putBRResult(r6, r0)
            int r0 = r5.mMaxCount
            com.oplus.backup.sdk.host.listener.ProgressHelper.putMaxCount(r6, r0)
            int r5 = r5.mCompletedCount
            com.oplus.backup.sdk.host.listener.ProgressHelper.putCompletedCount(r6, r5)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r0 = "onDestroy: result ="
            r5.append(r0)
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            H7.b.e(r1, r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.backupandrestore.plugin.ContactBackupPlugin.onDestroy(android.os.Bundle):android.os.Bundle");
    }

    @Override // com.customize.contacts.backupandrestore.plugin.SpeedDialBackPlugin, com.oplus.backup.sdk.component.plugin.IBRPlugin
    public void onPause(Bundle bundle) {
        super.onPause(bundle);
        this.mIsPause = true;
    }

    @Override // com.customize.contacts.backupandrestore.plugin.SpeedDialBackPlugin, com.oplus.backup.sdk.component.plugin.IBRPlugin
    public Bundle onPrepare(Bundle bundle) {
        super.onPrepare(bundle);
        if (C0637b.h()) {
            Bundle bundle2 = new Bundle();
            ProgressHelper.putMaxCount(bundle2, 0);
            return bundle2;
        }
        if (this.mMaxCount > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.mBackupConfig.getBackupRootPath());
            String str = File.separator;
            sb.append(str);
            sb.append("Contact");
            try {
                this.mOutStream = new FileOutputStream(getFileDescriptor(sb.toString() + str + BRConstant.NAME_CONTACT));
            } catch (Exception e10) {
                b.c(TAG, "FileOutputStream error" + e10);
                this.mOutStream = null;
            }
        }
        startBackupContactsSettingsXml();
        Bundle bundle3 = new Bundle();
        ProgressHelper.putMaxCount(bundle3, this.mMaxCount);
        b.e(TAG, "onPrepareBundle = " + bundle3);
        return bundle3;
    }

    @Override // com.customize.contacts.backupandrestore.plugin.SpeedDialBackPlugin, com.oplus.backup.sdk.component.plugin.IBRPlugin
    public Bundle onPreview(Bundle bundle) {
        super.onPreview(bundle);
        if (C0637b.h()) {
            Bundle bundle2 = new Bundle();
            ProgressHelper.putMaxCount(bundle2, 0);
            ProgressHelper.putPreviewDataSize(bundle2, 0L);
            return bundle2;
        }
        Bundle bundle3 = new Bundle();
        ProgressHelper.putMaxCount(bundle3, this.mMaxCount);
        ProgressHelper.putPreviewDataSize(bundle3, DataSizeUtils.estimateSize(1, this.mMaxCount));
        b.e(TAG, "onPreview preview = " + bundle3);
        return bundle3;
    }
}
