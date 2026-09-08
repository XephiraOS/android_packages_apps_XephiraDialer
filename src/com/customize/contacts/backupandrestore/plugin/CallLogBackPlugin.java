package com.customize.contacts.backupandrestore.plugin;

import H7.b;
import Q0.c;
import R0.b;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CallLog;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.business.calllog.breenocall.backupandrestore.BreenoCallLogBackuper;
import com.android.contacts.framework.baseui.util.C0637b;
import com.android.incallui.OplusAutoRedialNotificationUI;
import com.customize.contacts.FeatureOption;
import com.oplus.backup.sdk.common.host.BREngineConfig;
import com.oplus.backup.sdk.compat.DataSizeUtils;
import com.oplus.backup.sdk.component.BRPluginHandler;
import com.oplus.backup.sdk.component.plugin.BackupPlugin;
import com.oplus.backup.sdk.host.listener.ProgressHelper;
import com.oplus.foundation.util.feature.AppMetaFeatures;
import com.oplus.foundation.util.io.d;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import w0.C1642b;
import w0.C1643c;
import w0.g;
import w0.k;
import w0.l;

/* loaded from: classes3.dex */
public class CallLogBackPlugin extends BackupPlugin implements d {
    private static final int COL_CALL_ID = 0;
    private static final int COL_COUNTRYISO_ID = 9;
    private static final int COL_DATE_ID = 2;
    private static final int COL_DURATION_ID = 3;
    private static final int COL_FEATURES_ID = 11;
    private static final int COL_ISNEW_ID = 10;
    private static final int COL_LABEL_ID = 7;
    private static final int COL_MARK_NUMBER_ID = 0;
    private static final int COL_MARK_TYPE_ID = 1;
    private static final int COL_NAME_ID = 5;
    private static final int COL_NUMBER_ID = 1;
    private static final int COL_NUMBER_TYPE_ID = 6;
    private static final int COL_RING_TIME_ID = 8;
    private static final int COL_TED_DATA_TYPE_ID = 3;
    private static final int COL_TED_IS_MANUAL_ID = 2;
    private static final int COL_TED_OPERATION_TYPE_ID = 4;
    private static final int COL_TED_UPLOADED_ID = 5;
    private static final int COL_TYPE_ID = 4;
    private static final int COL_VIRTUAL_CALL_ID = 12;
    private static final int COL_VIRTUAL_CALL_TYPE_ID = 13;
    private static final String TAG = "CallLogBackPlugin";
    private BRPluginHandler mBRPluginHandler;
    private BREngineConfig mBackupConfig;
    private Cursor mCallLogCursor;
    private CallLogXMLComposer mCallLogXMl;
    private Cursor mCallRecordingCursor;
    private LinkedList<c> mCallRecordingInfoList;
    private CallRecordingXMLComposer mCallRecordingXML;
    private ArrayList<CallLogInfor> mCallsInfoList;
    private boolean mIsCancel;
    private boolean mIsPause;
    private HashMap<String, TedMarkInfo> mMarkInfoMap;
    private Cursor mRttTranscriptCursor;
    private LinkedList<l> mRttTranscriptInfoList;
    private g mRttTranscriptXML;
    private String mTargetPath;
    private Cursor mTedMarkTypeCursor;
    private static final String[] CALL_LOG_PROJECTION = {BreenoCallContract.BaseColumns._ID, "number", BreenoCallContract.BaseColumns.DATE, "duration", OplusAutoRedialNotificationUI.TYPE, "name", "numbertype", "numberlabel", "ring_time", "countryiso", "new", "features"};
    private static final String[] CALL_LOG_PROJECTION_WITH_VIRTUAL_INFO = {BreenoCallContract.BaseColumns._ID, "number", BreenoCallContract.BaseColumns.DATE, "duration", OplusAutoRedialNotificationUI.TYPE, "name", "numbertype", "numberlabel", "ring_time", "countryiso", "new", "features", "virtual_call_id", "virtual_call_type"};
    private static final String[] MARK_TYPE_PROJECTION = {"phone", "classify", "is_manual", "data_type", "operation_type", "uploaded"};
    private int mCompletedCount = 0;
    private int mCallRecordingCompleteCount = 0;
    private int mRttTranscriptCompleteCount = 0;
    private int mMaxCount = -1;
    private int mCallRecordMaxCount = -1;
    private int mTedMarkTypeMaxCount = -1;
    private int mRttTranscriptMaxCount = -1;
    private final Object mLock = new Object();
    private final Object mProgressLock = new Object();
    private boolean mIsIndiaArea = false;
    private int mFactor = 1;
    private int mRttFactor = 1;
    private final BreenoCallLogBackuper mBreenoCallLogBackuper = new BreenoCallLogBackuper();

    /* loaded from: classes3.dex */
    public class WriteCRXMLThread extends Thread {
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            if (!C0637b.h()) {
                if (CallLogBackPlugin.this.mCallsInfoList != null) {
                    ArrayList arrayList = new ArrayList(CallLogBackPlugin.this.mCallsInfoList);
                    for (int i10 = 0; i10 < arrayList.size(); i10++) {
                        CallLogBackPlugin.this.mCallLogXMl.addOneCallLog((CallLogInfor) arrayList.get(i10));
                    }
                }
                if (CallLogBackPlugin.this.mCallRecordingInfoList != null) {
                    Iterator it = new LinkedList(CallLogBackPlugin.this.mCallRecordingInfoList).iterator();
                    while (it.hasNext()) {
                        CallLogBackPlugin.this.mCallRecordingXML.addOneCallRecording((c) it.next());
                    }
                }
                CallLogBackPlugin.this.mBreenoCallLogBackuper.onWriteToXml();
                if (C1643c.w() && CallLogBackPlugin.this.mRttTranscriptInfoList != null && CallLogBackPlugin.this.mRttTranscriptXML != null) {
                    Iterator it2 = new LinkedList(CallLogBackPlugin.this.mRttTranscriptInfoList).iterator();
                    while (it2.hasNext()) {
                        CallLogBackPlugin.this.mRttTranscriptXML.c((l) it2.next());
                    }
                }
            }
            synchronized (CallLogBackPlugin.this.mLock) {
                try {
                    CallLogBackPlugin.this.mCallsInfoList = null;
                    CallLogBackPlugin.this.mCallRecordingInfoList = null;
                    if (C1643c.w()) {
                        CallLogBackPlugin.this.mRttTranscriptInfoList = null;
                    }
                    CallLogBackPlugin.this.mLock.notifyAll();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        private WriteCRXMLThread() {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:176:0x0364  */
    @Override // com.oplus.backup.sdk.component.plugin.IBRPlugin
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onBackup(android.os.Bundle r25) {
        /*
            Method dump skipped, instructions count: 949
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.backupandrestore.plugin.CallLogBackPlugin.onBackup(android.os.Bundle):void");
    }

    @Override // com.oplus.backup.sdk.component.plugin.IBRPlugin
    public void onCancel(Bundle bundle) {
        this.mIsCancel = true;
        this.mIsPause = false;
        synchronized (this.mProgressLock) {
            this.mProgressLock.notifyAll();
            b.e(TAG, "onCancel mProgressLock.notifyAll()");
        }
    }

    @Override // com.oplus.backup.sdk.component.plugin.IBRPlugin
    public void onContinue(Bundle bundle) {
        this.mIsPause = false;
        synchronized (this.mProgressLock) {
            this.mProgressLock.notifyAll();
            b.e(TAG, "onContinue mProgressLock.notifyAll()");
        }
    }

    @Override // com.oplus.backup.sdk.component.plugin.AbstractPlugin
    public void onCreate(Context context, BRPluginHandler bRPluginHandler, BREngineConfig bREngineConfig) {
        String[] strArr;
        int count;
        int count2;
        int count3;
        super.onCreate(context, bRPluginHandler, bREngineConfig);
        this.mBRPluginHandler = bRPluginHandler;
        this.mBackupConfig = bREngineConfig;
        int i10 = 0;
        if (C0637b.h()) {
            this.mMaxCount = 0;
            this.mTedMarkTypeMaxCount = 0;
            b.b("ContactsNumberMaskUtil", "Contacts CallLogBackPlugin onCreate return because numbermaskswitch open cannot backup");
            return;
        }
        try {
            ContentResolver contentResolver = context.getContentResolver();
            Uri uri = CallLog.Calls.CONTENT_URI;
            if (FeatureOption.p()) {
                strArr = CALL_LOG_PROJECTION_WITH_VIRTUAL_INFO;
            } else {
                strArr = CALL_LOG_PROJECTION;
            }
            Cursor query = contentResolver.query(uri, strArr, "type > 0  OR abs(type ) = 20 OR abs(type ) = 21 OR abs(type ) = 22 OR abs(type ) = 23 OR abs(type ) = 19 OR abs(type ) = 24 OR abs(type ) = 25 OR abs(type ) = 26 OR abs(type ) = 27 OR abs(type ) = 49 OR abs(type ) = 50 OR abs(type ) = 56 OR abs(type ) = 51 OR abs(type ) = 52 OR abs(type ) = 53", null, "date DESC");
            this.mCallLogCursor = query;
            if (query == null) {
                count = 0;
            } else {
                count = query.getCount();
            }
            this.mMaxCount = count;
            if (AppMetaFeatures.b()) {
                Cursor query2 = context.getContentResolver().query(com.android.contacts.framework.baseui.calllog.a.f15766a, com.android.contacts.framework.baseui.calllog.a.f15770e, null, null);
                this.mCallRecordingCursor = query2;
                if (query2 == null) {
                    count3 = 0;
                } else {
                    count3 = query2.getCount();
                }
                this.mCallRecordMaxCount = count3;
                if (this.mMaxCount != 0) {
                    this.mFactor = (int) Math.ceil(count3 / r3);
                }
            }
            this.mBreenoCallLogBackuper.onCreate(context, this.mMaxCount, this.mBackupConfig.getBackupRootPath() + File.separator + BRConstant.FOLDER_CALLRECORD);
            if (C1643c.w()) {
                Cursor query3 = context.getContentResolver().query(Uri.parse("content://call_log/transcript"), k.a(), null, null);
                this.mRttTranscriptCursor = query3;
                if (query3 == null) {
                    count2 = 0;
                } else {
                    count2 = query3.getCount();
                }
                this.mRttTranscriptMaxCount = count2;
                if (this.mMaxCount != 0) {
                    this.mRttFactor = (int) Math.ceil(count2 / r2);
                }
            }
        } catch (Exception e10) {
            b.c(TAG, "Exception e: " + e10);
        }
        b.b(TAG, "the call log size : " + this.mMaxCount + "the call recording cursor size is : " + this.mCallRecordMaxCount + " the factor is : " + this.mFactor + "the rtt factor is : " + this.mRttFactor);
        if (B3.a.u()) {
            try {
                if (M7.d.b(b.a.f3181a, "CN").equals("IN")) {
                    this.mIsIndiaArea = true;
                }
                Cursor query4 = context.getContentResolver().query(TedMarkInfo.TED_URI, MARK_TYPE_PROJECTION, null, null, null);
                this.mTedMarkTypeCursor = query4;
                if (query4 != null) {
                    i10 = query4.getCount();
                }
                this.mTedMarkTypeMaxCount = i10;
            } catch (Exception e11) {
                H7.b.c(TAG, "Exception e: " + e11);
            }
        }
        this.mCallsInfoList = new ArrayList<>();
        this.mCallRecordingInfoList = new LinkedList<>();
        this.mMarkInfoMap = new HashMap<>();
        if (C1643c.w()) {
            this.mRttTranscriptInfoList = new LinkedList<>();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:84:0x0021, code lost:
    
        if (r4.mIsCancel == false) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0035, code lost:
    
        if (r4.mIsCancel == false) goto L96;
     */
    @Override // com.oplus.backup.sdk.component.plugin.IBRPlugin
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.os.Bundle onDestroy(android.os.Bundle r5) {
        /*
            Method dump skipped, instructions count: 466
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.backupandrestore.plugin.CallLogBackPlugin.onDestroy(android.os.Bundle):android.os.Bundle");
    }

    @Override // com.oplus.backup.sdk.component.plugin.IBRPlugin
    public void onPause(Bundle bundle) {
        this.mIsPause = true;
    }

    @Override // com.oplus.backup.sdk.component.plugin.IBRPlugin
    public Bundle onPrepare(Bundle bundle) {
        if (C0637b.h()) {
            Bundle bundle2 = new Bundle();
            ProgressHelper.putMaxCount(bundle2, 0);
            return bundle2;
        }
        if (this.mMaxCount > 0) {
            CallLogXMLComposer callLogXMLComposer = new CallLogXMLComposer();
            this.mCallLogXMl = callLogXMLComposer;
            callLogXMLComposer.startCompose();
        }
        if (this.mCallRecordMaxCount > 0) {
            CallRecordingXMLComposer callRecordingXMLComposer = new CallRecordingXMLComposer();
            this.mCallRecordingXML = callRecordingXMLComposer;
            callRecordingXMLComposer.startCompose();
        }
        this.mBreenoCallLogBackuper.onPrepare();
        if (C1643c.w() && this.mRttTranscriptMaxCount > 0) {
            g gVar = (g) C1642b.a(g.class);
            this.mRttTranscriptXML = gVar;
            if (gVar != null) {
                gVar.a();
            }
        }
        Bundle bundle3 = new Bundle();
        ProgressHelper.putMaxCount(bundle3, this.mMaxCount);
        H7.b.e(TAG, "onPrepare end=" + bundle3);
        return bundle3;
    }

    @Override // com.oplus.backup.sdk.component.plugin.IBRPlugin
    public Bundle onPreview(Bundle bundle) {
        if (C0637b.h()) {
            Bundle bundle2 = new Bundle();
            ProgressHelper.putMaxCount(bundle2, 0);
            ProgressHelper.putPreviewDataSize(bundle2, 0L);
            return bundle2;
        }
        Bundle bundle3 = new Bundle();
        ProgressHelper.putMaxCount(bundle3, this.mMaxCount);
        ProgressHelper.putPreviewDataSize(bundle3, DataSizeUtils.estimateSize(272, this.mMaxCount));
        H7.b.e(TAG, "onPreview =" + bundle3);
        return bundle3;
    }

    @Override // com.oplus.foundation.util.io.d
    public void writeToFile(String str, byte[] bArr) {
        StringBuilder sb;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(getFileDescriptor(str));
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e10) {
            e = e10;
        } catch (NullPointerException e11) {
            e = e11;
        }
        try {
            fileOutputStream.write(bArr, 0, bArr.length);
            fileOutputStream.flush();
            fileOutputStream.getFD().sync();
            try {
                fileOutputStream.close();
            } catch (IOException e12) {
                e = e12;
                sb = new StringBuilder();
                sb.append("Exception e: ");
                sb.append(e);
                H7.b.c(TAG, sb.toString());
            }
        } catch (IOException e13) {
            e = e13;
            fileOutputStream2 = fileOutputStream;
            H7.b.c(TAG, "Exception e: " + e);
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e14) {
                    e = e14;
                    sb = new StringBuilder();
                    sb.append("Exception e: ");
                    sb.append(e);
                    H7.b.c(TAG, sb.toString());
                }
            }
        } catch (NullPointerException e15) {
            e = e15;
            fileOutputStream2 = fileOutputStream;
            H7.b.c(TAG, "Exception e1: " + e);
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e16) {
                    e = e16;
                    sb = new StringBuilder();
                    sb.append("Exception e: ");
                    sb.append(e);
                    H7.b.c(TAG, sb.toString());
                }
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e17) {
                    H7.b.c(TAG, "Exception e: " + e17);
                }
            }
            throw th;
        }
    }
}
