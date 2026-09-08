package com.customize.contacts.backupandrestore.plugin;

import H7.b;
import R0.d;
import android.content.ContentProviderOperation;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CallLog;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.business.calllog.breenocall.backupandrestore.BreenoCallLogRestorer;
import com.customize.contacts.manager.C0786a;
import com.oplus.backup.sdk.common.host.BREngineConfig;
import com.oplus.backup.sdk.component.BRPluginHandler;
import com.oplus.backup.sdk.component.plugin.RestorePlugin;
import com.oplus.backup.sdk.host.listener.ProgressHelper;
import com.oplus.foundation.util.feature.AppMetaFeatures;
import com.oplus.foundation.util.io.c;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import w0.C1643c;
import w0.l;

/* loaded from: classes3.dex */
public class CallLogRestorePlugin extends RestorePlugin implements c {
    private static final int COL_CALL_ID = 0;
    private static final int COL_DATE_ID = 2;
    private static final int COL_NUMBER_ID = 1;
    private static final int COL_VIRTUAL_CALL_ID = 3;
    private static final String SEPARATOR = "//";
    private static final String TAG = "CallLogRestorePlugin";
    private BRPluginHandler mBRPluginHandler;
    private ArrayList<ContentProviderOperation> mCallLogRestoreOps;
    private LinkedList<Q0.c> mCallRecordingInfoList;
    private ArrayList<ContentProviderOperation> mCallRecordingRestoreOps;
    private boolean mIsCancel;
    private boolean mIsPause;
    private BREngineConfig mRestoreConfig;
    private LinkedList<l> mRttTranscriptInfoList;
    private ArrayList<ContentProviderOperation> mRttTranscriptRestoreOps;
    private ArrayList<ContentValues> mTedRecodList;
    private static final String[] CALL_LOG_PROJECTION = {BreenoCallContract.BaseColumns._ID, "number", BreenoCallContract.BaseColumns.DATE};
    private static final String[] CALL_LOG_PROJECTION_WITH_VIRTUAL_ID = {BreenoCallContract.BaseColumns._ID, "number", BreenoCallContract.BaseColumns.DATE, "virtual_call_id"};
    private static final Uri mInsertCallUri = d.a(CallLog.Calls.CONTENT_URI);
    private static final Uri mInsertCallRecordUri = d.a(com.android.contacts.framework.baseui.calllog.a.f15766a);
    private final Object mLock = new Object();
    private ArrayList<CallLogInfor> mCallLogInfoArrayList = new ArrayList<>();
    private int mCompletedCount = 0;
    private int mMaxCount = -1;
    private final HashSet<String> mCallLogHashSet = new HashSet<>();
    private final HashSet<String> mCallLogVirtualIdHashSet = new HashSet<>();
    private int mFactor = 1;
    private int mRttFactor = 1;
    private final BreenoCallLogRestorer mBreenoCallLogRestorer = new BreenoCallLogRestorer();

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0024: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]) (LINE:37), block:B:59:0x0024 */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00f2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.oplus.foundation.util.io.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String getFileContent(java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.backupandrestore.plugin.CallLogRestorePlugin.getFileContent(java.lang.String):java.lang.String");
    }

    @Override // com.oplus.backup.sdk.component.plugin.IBRPlugin
    public void onCancel(Bundle bundle) {
        b.e(TAG, "onCancel --------------");
        this.mIsCancel = true;
        this.mIsPause = false;
        synchronized (this.mLock) {
            this.mLock.notifyAll();
            b.e(TAG, "onCancel mLock.notifyAll()");
        }
    }

    @Override // com.oplus.backup.sdk.component.plugin.IBRPlugin
    public void onContinue(Bundle bundle) {
        this.mIsPause = false;
        synchronized (this.mLock) {
            this.mLock.notifyAll();
            b.e(TAG, "onContinue mLock.notifyAll()");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0031, code lost:
    
        if (r10.moveToFirst() != false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0033, code lost:
    
        r11 = r10.getString(1);
        r0 = r10.getString(2);
        r8.mCallLogHashSet.add(r11 + com.customize.contacts.backupandrestore.plugin.CallLogRestorePlugin.SEPARATOR + r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005a, code lost:
    
        if (com.customize.contacts.FeatureOption.p() == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005c, code lost:
    
        r8.mCallLogVirtualIdHashSet.add(r10.getString(3));
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006d, code lost:
    
        if (r10.moveToNext() != false) goto L40;
     */
    @Override // com.oplus.backup.sdk.component.plugin.AbstractPlugin
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onCreate(android.content.Context r9, com.oplus.backup.sdk.component.BRPluginHandler r10, com.oplus.backup.sdk.common.host.BREngineConfig r11) {
        /*
            r8 = this;
            java.lang.String r0 = "onCreate Start "
            java.lang.String r1 = "CallLogRestorePlugin"
            H7.b.e(r1, r0)
            super.onCreate(r9, r10, r11)
            r8.mBRPluginHandler = r10
            r8.mRestoreConfig = r11
            android.content.ContentResolver r2 = r9.getContentResolver()     // Catch: java.lang.Exception -> L1e
            android.net.Uri r3 = android.provider.CallLog.Calls.CONTENT_URI     // Catch: java.lang.Exception -> L1e
            boolean r10 = com.customize.contacts.FeatureOption.p()     // Catch: java.lang.Exception -> L1e
            if (r10 == 0) goto L20
            java.lang.String[] r10 = com.customize.contacts.backupandrestore.plugin.CallLogRestorePlugin.CALL_LOG_PROJECTION_WITH_VIRTUAL_ID     // Catch: java.lang.Exception -> L1e
        L1c:
            r4 = r10
            goto L23
        L1e:
            r10 = move-exception
            goto L81
        L20:
            java.lang.String[] r10 = com.customize.contacts.backupandrestore.plugin.CallLogRestorePlugin.CALL_LOG_PROJECTION     // Catch: java.lang.Exception -> L1e
            goto L1c
        L23:
            java.lang.String r7 = "date DESC"
            r5 = 0
            r6 = 0
            android.database.Cursor r10 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Exception -> L1e
            if (r10 == 0) goto L7b
            boolean r11 = r10.moveToFirst()     // Catch: java.lang.Throwable -> L67
            if (r11 == 0) goto L7b
        L33:
            r11 = 1
            java.lang.String r11 = r10.getString(r11)     // Catch: java.lang.Throwable -> L67
            r0 = 2
            java.lang.String r0 = r10.getString(r0)     // Catch: java.lang.Throwable -> L67
            java.util.HashSet<java.lang.String> r2 = r8.mCallLogHashSet     // Catch: java.lang.Throwable -> L67
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L67
            r3.<init>()     // Catch: java.lang.Throwable -> L67
            r3.append(r11)     // Catch: java.lang.Throwable -> L67
            java.lang.String r11 = "//"
            r3.append(r11)     // Catch: java.lang.Throwable -> L67
            r3.append(r0)     // Catch: java.lang.Throwable -> L67
            java.lang.String r11 = r3.toString()     // Catch: java.lang.Throwable -> L67
            r2.add(r11)     // Catch: java.lang.Throwable -> L67
            boolean r11 = com.customize.contacts.FeatureOption.p()     // Catch: java.lang.Throwable -> L67
            if (r11 == 0) goto L69
            java.util.HashSet<java.lang.String> r11 = r8.mCallLogVirtualIdHashSet     // Catch: java.lang.Throwable -> L67
            r0 = 3
            java.lang.String r0 = r10.getString(r0)     // Catch: java.lang.Throwable -> L67
            r11.add(r0)     // Catch: java.lang.Throwable -> L67
            goto L69
        L67:
            r11 = move-exception
            goto L70
        L69:
            boolean r11 = r10.moveToNext()     // Catch: java.lang.Throwable -> L67
            if (r11 != 0) goto L33
            goto L7b
        L70:
            if (r10 == 0) goto L7a
            r10.close()     // Catch: java.lang.Throwable -> L76
            goto L7a
        L76:
            r10 = move-exception
            r11.addSuppressed(r10)     // Catch: java.lang.Exception -> L1e
        L7a:
            throw r11     // Catch: java.lang.Exception -> L1e
        L7b:
            if (r10 == 0) goto L95
            r10.close()     // Catch: java.lang.Exception -> L1e
            goto L95
        L81:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = "Exception e: "
            r11.append(r0)
            r11.append(r10)
            java.lang.String r10 = r11.toString()
            H7.b.c(r1, r10)
        L95:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            com.oplus.backup.sdk.common.host.BREngineConfig r11 = r8.mRestoreConfig
            java.lang.String r11 = r11.getRestoreRootPath()
            r10.append(r11)
            java.lang.String r11 = java.io.File.separator
            r10.append(r11)
            java.lang.String r11 = "CallRecord"
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            com.android.contacts.business.calllog.breenocall.backupandrestore.BreenoCallLogRestorer r11 = r8.mBreenoCallLogRestorer
            r11.onCreate(r9, r10)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "onCreate End : mCallLogHashSet.size() = "
            r9.append(r10)
            java.util.HashSet<java.lang.String> r8 = r8.mCallLogHashSet
            int r8 = r8.size()
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            H7.b.e(r1, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.backupandrestore.plugin.CallLogRestorePlugin.onCreate(android.content.Context, com.oplus.backup.sdk.component.BRPluginHandler, com.oplus.backup.sdk.common.host.BREngineConfig):void");
    }

    @Override // com.oplus.backup.sdk.component.plugin.IBRPlugin
    public Bundle onDestroy(Bundle bundle) {
        int i10;
        int i11;
        b.e(TAG, "onDestroy start");
        ArrayList<CallLogInfor> arrayList = this.mCallLogInfoArrayList;
        if (arrayList != null) {
            arrayList.clear();
        }
        ArrayList<ContentValues> arrayList2 = this.mTedRecodList;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
        if (this.mCallLogRestoreOps != null) {
            this.mCallLogRestoreOps = null;
        }
        LinkedList<Q0.c> linkedList = this.mCallRecordingInfoList;
        if (linkedList != null) {
            i10 = linkedList.size();
            this.mCallRecordingInfoList = null;
        } else {
            i10 = 0;
        }
        if (this.mCallRecordingRestoreOps != null) {
            this.mCallRecordingRestoreOps = null;
        }
        this.mBreenoCallLogRestorer.onDestroy();
        if (C1643c.w()) {
            LinkedList<l> linkedList2 = this.mRttTranscriptInfoList;
            if (linkedList2 != null) {
                linkedList2.clear();
                this.mRttTranscriptInfoList = null;
            }
            ArrayList<ContentProviderOperation> arrayList3 = this.mCallLogRestoreOps;
            if (arrayList3 != null) {
                arrayList3.clear();
                this.mCallLogRestoreOps = null;
            }
        }
        if (AppMetaFeatures.b()) {
            Intent intent = new Intent("com.android.contacts.local.ACTION_CALLLOGS_RESTORE_FINISHED");
            intent.putExtra("recording_count", i10);
            X.a.b(getContext()).d(intent);
        }
        Bundle bundle2 = new Bundle();
        if (this.mIsCancel) {
            i11 = 3;
        } else {
            i11 = 1;
        }
        ProgressHelper.putBRResult(bundle2, i11);
        ProgressHelper.putMaxCount(bundle2, this.mMaxCount);
        ProgressHelper.putCompletedCount(bundle2, this.mCompletedCount);
        C0786a.j().b();
        b.e(TAG, "onDestroy =" + bundle2);
        return bundle2;
    }

    @Override // com.oplus.backup.sdk.component.plugin.IBRPlugin
    public void onPause(Bundle bundle) {
        this.mIsPause = true;
    }

    @Override // com.oplus.backup.sdk.component.plugin.IBRPlugin
    public Bundle onPrepare(Bundle bundle) {
        b.e(TAG, "onPrepare Start ");
        StringBuilder sb = new StringBuilder();
        sb.append(this.mRestoreConfig.getRestoreRootPath());
        String str = File.separator;
        sb.append(str);
        sb.append(BRConstant.FOLDER_CALLRECORD);
        sb.append(str);
        sb.append(BRConstant.CALL_LOG_XML);
        String sb2 = sb.toString();
        String str2 = this.mRestoreConfig.getRestoreRootPath() + str + BRConstant.FOLDER_CALLRECORD + str + BRConstant.CALL_RECORDING_XML;
        String fileContent = getFileContent(sb2);
        String fileContent2 = getFileContent(str2);
        this.mCallLogRestoreOps = new ArrayList<>();
        this.mCallRecordingRestoreOps = new ArrayList<>();
        this.mTedRecodList = new ArrayList<>();
        if (fileContent != null) {
            ArrayList<CallLogInfor> parse = CallLogXmlParser.parse(fileContent);
            if (!parse.isEmpty()) {
                this.mCallLogInfoArrayList.addAll(parse);
            }
        } else {
            this.mCallLogInfoArrayList = new ArrayList<>();
        }
        if (fileContent2 != null) {
            this.mCallRecordingInfoList = CallRecordXmlParser.parse(fileContent2);
        } else {
            this.mCallRecordingInfoList = new LinkedList<>();
        }
        int size = this.mCallLogInfoArrayList.size();
        this.mMaxCount = size;
        if (size != 0) {
            this.mFactor = (int) Math.ceil(this.mCallRecordingInfoList.size() / this.mMaxCount);
        }
        this.mBreenoCallLogRestorer.onPrepare(this, this.mMaxCount);
        if (C1643c.w()) {
            this.mRttTranscriptRestoreOps = new ArrayList<>();
            String fileContent3 = getFileContent(this.mRestoreConfig.getRestoreRootPath() + str + BRConstant.FOLDER_CALLRECORD + str + "rtt_record_backup.xml");
            if (fileContent3 != null) {
                this.mRttTranscriptInfoList = C1643c.x(fileContent3);
            }
            if (this.mRttTranscriptInfoList == null) {
                this.mRttTranscriptInfoList = new LinkedList<>();
            }
            if (this.mMaxCount != 0) {
                this.mRttFactor = (int) Math.ceil(this.mRttTranscriptInfoList.size() / this.mMaxCount);
            }
        }
        Bundle bundle2 = new Bundle();
        ProgressHelper.putMaxCount(bundle2, this.mMaxCount);
        b.e(TAG, "onPrepare End result = " + bundle2);
        b.b(TAG, "the call log size " + this.mCallLogInfoArrayList.size() + ", the  call recording size : " + this.mCallRecordingInfoList.size() + " the factor is : " + this.mFactor);
        return bundle2;
    }

    @Override // com.oplus.backup.sdk.component.plugin.IBRPlugin
    public Bundle onPreview(Bundle bundle) {
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x03d7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x035c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x02a9  */
    @Override // com.oplus.backup.sdk.component.plugin.IBRPlugin
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onRestore(android.os.Bundle r27) {
        /*
            Method dump skipped, instructions count: 1162
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.backupandrestore.plugin.CallLogRestorePlugin.onRestore(android.os.Bundle):void");
    }
}
