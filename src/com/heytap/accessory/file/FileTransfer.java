package com.heytap.accessory.file;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.heytap.accessory.BaseAgent;
import com.heytap.accessory.BaseJobAgent;
import com.heytap.accessory.bean.GeneralException;
import com.heytap.accessory.bean.PeerAgent;
import com.heytap.accessory.constant.AFConstants;
import com.heytap.accessory.file.h;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import m5.d;
import n5.C1371a;

/* loaded from: classes3.dex */
public class FileTransfer {
    public static final String ACTION_AFP_FILE_TRANSFER_REQUESTED = "com.heytap.accessory.ftconnection";
    private static final boolean COVERED_MODE = true;
    public static final int ERROR_CHANNEL_IO = 1;
    public static final int ERROR_COMMAND_DROPPED = 3;
    public static final int ERROR_CONNECTION_LOST = 5;
    public static final int ERROR_FATAL = 20001;
    public static final int ERROR_FILE_IO = 2;
    public static final int ERROR_NONE = 0;
    public static final int ERROR_NOT_SUPPORTED = 12;
    public static final int ERROR_PEER_AGENT_BUSY = 8;
    public static final int ERROR_PEER_AGENT_NO_RESPONSE = 4;
    public static final int ERROR_PEER_AGENT_REJECTED = 9;
    public static final int ERROR_REQUEST_NOT_QUEUED = -1;
    public static final int ERROR_SPACE_NOT_AVAILABLE = 11;
    public static final int ERROR_TRANSACTION_NOT_FOUND = 13;
    private static final String FILE_PROVIDER = "androidx.core.content.FileProvider";
    private static final String FILE_PROVIDER_V4 = "android.support.v4.content.FileProvider";
    private static final int FT_CANCEL_TRANS_ID = -1;
    private static final int FT_DEFAULT_CONNECTION_ID = 0;
    private static final int FT_DEFAULT_TRANS_ID = 0;
    private static final String TAG = "FileTransfer";
    private String mAgentName;
    private Object mCallingAgent;
    private h mCallingAgentInfo;
    private Context mContext;
    private EventListener mEventListener;
    private HandlerThread mFileTransferHandlerThread;
    private FileTransferManager mFileTransferManager;
    private b mHandler;
    c mLocalCallback;
    private final ConcurrentHashMap<Integer, Uri> mTransactionUriMap;
    private ConcurrentHashMap<Long, ConcurrentHashMap<Integer, h.a>> mTransactionsMap;
    private ConcurrentHashMap<Long, ConcurrentHashMap<Integer, Boolean>> mTransferRequestMap;

    /* loaded from: classes3.dex */
    public interface EventListener {
        void onCancelAllCompleted(int i10, int i11);

        void onProgressChanged(long j10, int i10, int i11);

        void onTransferCompleted(long j10, int i10, String str, int i11);

        void onTransferRequested(long j10, int i10, int i11, m5.d dVar);
    }

    /* loaded from: classes3.dex */
    public class a implements c {
        public a() {
        }

        @Override // com.heytap.accessory.file.FileTransfer.c
        public void a(int[] iArr, int i10) {
            for (int i11 : iArr) {
                for (Long l10 : FileTransfer.this.mTransactionsMap.keySet()) {
                    l10.longValue();
                    ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) FileTransfer.this.mTransactionsMap.get(l10);
                    if (concurrentHashMap != null && ((h.a) concurrentHashMap.get(Integer.valueOf(i11))) != null) {
                        FileTransfer.this.removeTransactionByTransId(i11);
                        FileTransfer.this.revokeUriPermission(i11);
                    }
                }
            }
            if (FileTransfer.this.mEventListener != null) {
                FileTransfer.this.handleOnCancelAllCompletedErrorCode(i10);
                FileTransfer.this.mEventListener.onCancelAllCompleted(-1, i10);
            }
        }

        @Override // com.heytap.accessory.file.FileTransfer.c
        public void b(long j10, int i10, String str) {
            C1371a.c(FileTransfer.TAG, "onTransferRequested");
        }

        @Override // com.heytap.accessory.file.FileTransfer.c
        public void onProgressChanged(long j10, int i10, int i11) {
            ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) FileTransfer.this.mTransactionsMap.get(Long.valueOf(j10));
            if (concurrentHashMap == null) {
                C1371a.k(FileTransfer.TAG, "onProgressChanged invalid connectionId:" + j10);
                return;
            }
            if (((h.a) concurrentHashMap.get(Integer.valueOf(i10))) == null) {
                C1371a.k(FileTransfer.TAG, "onProgressChanged invalid transactionId:" + i10);
                return;
            }
            FileTransfer.this.mEventListener.onProgressChanged(j10, i10, i11);
        }

        @Override // com.heytap.accessory.file.FileTransfer.c
        public void onTransferCompleted(long j10, int i10, String str, int i11) {
            ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) FileTransfer.this.mTransactionsMap.get(Long.valueOf(j10));
            if (concurrentHashMap == null) {
                C1371a.k(FileTransfer.TAG, "onTransferCompleted detailsMap == null");
                return;
            }
            if (((h.a) concurrentHashMap.get(Integer.valueOf(i10))) != null) {
                EventListener eventListener = FileTransfer.this.mEventListener;
                if (eventListener != null) {
                    FileTransfer.this.handleOnTransferCompletedErrorCode(i11);
                    C1371a.k(FileTransfer.TAG, "[FileTransfer]txId:" + i10 + " onTransferCompleted");
                    eventListener.onTransferCompleted(j10, i10, str, i11);
                    FileTransfer.this.removeTransaction(j10, i10);
                    FileTransfer.this.removeTransactionRequest(j10, i10);
                    FileTransfer.this.revokeUriPermission(i10);
                    return;
                }
                C1371a.k(FileTransfer.TAG, "[FileTransfer]txId:" + i10 + " not exist");
                return;
            }
            C1371a.k(FileTransfer.TAG, "[FileTransfer]txId:" + i10 + " not exist");
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(int[] iArr, int i10);

        void b(long j10, int i10, String str);

        void onProgressChanged(long j10, int i10, int i11);

        void onTransferCompleted(long j10, int i10, String str, int i11);
    }

    public FileTransfer(BaseAgent baseAgent, EventListener eventListener) {
        this(baseAgent, baseAgent.getApplicationContext(), eventListener);
    }

    private boolean checkPeerAgentValid(PeerAgent peerAgent) {
        if (peerAgent == null) {
            C1371a.d(TAG, "peerAgent cannot be null");
            return false;
        }
        Object obj = this.mCallingAgent;
        if (obj != null && this.mEventListener != null) {
            if (obj instanceof BaseJobAgent) {
                if (((BaseJobAgent) obj).getSuccessfulConnections().isEmpty()) {
                    C1371a.d(TAG, "current baseJobAgent has not setup service connection, please connect service first");
                    return false;
                }
                return true;
            }
            if ((obj instanceof BaseAgent) && ((BaseAgent) obj).getSuccessfulConnections().isEmpty()) {
                C1371a.d(TAG, "current baseAgent has not setup service connection, please connect service first");
                return false;
            }
            return true;
        }
        C1371a.d(TAG, "Using invalid instance of FileTransfer(). Please re-register.");
        return false;
    }

    private boolean checkReceiveParams(String str, long j10, int i10) {
        boolean exists;
        if (TextUtils.isEmpty(str)) {
            C1371a.d(TAG, "filepath empty!");
        } else {
            if (!checkPathPermission(str)) {
                C1371a.d(TAG, "checkReceiveParams return false, cannot save file in third internal path!");
                return false;
            }
            File file = new File(str);
            if (file.isDirectory()) {
                C1371a.d(TAG, "given path is a directory");
            } else {
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    exists = parentFile.exists();
                    if (!exists) {
                        C1371a.d(TAG, "Parent Directory does not exist!");
                    }
                    if (!exists && containsTransactionKey(j10, i10)) {
                        C1371a.d(TAG, "transactionId already exist");
                        return false;
                    }
                    return exists;
                }
                C1371a.d(TAG, "getParentFile() is null ");
            }
        }
        exists = false;
        if (!exists) {
        }
        return exists;
    }

    private void checkSource(String str) {
        if (!TextUtils.isEmpty(str) && checkPathPermission(str)) {
            Uri parse = Uri.parse(str);
            if ("file".equalsIgnoreCase(parse.getScheme())) {
                str = parse.getPath();
                if (str != null) {
                    C1371a.i(TAG, "URI scheme is SCHEME_FILE  File Path : " + str);
                }
            } else if ("content".equalsIgnoreCase(parse.getScheme())) {
                Cursor query = this.mContext.getContentResolver().query(parse, new String[]{"_data"}, null, null, null);
                if (query != null) {
                    try {
                        if (query.moveToFirst() && (str = query.getString(0)) != null) {
                            C1371a.i(TAG, "URI ContentResolver is SCHEME_CONTENT File Path : " + str);
                        }
                    } catch (Throwable th) {
                        try {
                            query.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
                if (query != null) {
                    query.close();
                }
            }
            if (str == null) {
                C1371a.d(TAG, "srcToSend is null");
                return;
            }
            File file = new File(str);
            if (file.exists()) {
                if (!file.isDirectory()) {
                    if (file.length() != 0) {
                        C1371a.i(TAG, "File is valid !!");
                        return;
                    }
                    throw new IllegalArgumentException("File length is 0");
                }
                throw new IllegalArgumentException("File is a directory");
            }
            throw new IllegalArgumentException("File not exist");
        }
        throw new IllegalArgumentException("Wrong file path");
    }

    private synchronized boolean containsTransactionKey(long j10, int i10) {
        boolean z10;
        ConcurrentHashMap<Integer, h.a> concurrentHashMap;
        ConcurrentHashMap<Long, ConcurrentHashMap<Integer, h.a>> concurrentHashMap2 = this.mTransactionsMap;
        if (concurrentHashMap2 != null && (concurrentHashMap = concurrentHashMap2.get(Long.valueOf(j10))) != null) {
            z10 = concurrentHashMap.containsKey(Integer.valueOf(i10));
        } else {
            z10 = false;
        }
        return z10;
    }

    private synchronized boolean containsTransactionRequestKey(long j10, int i10) {
        boolean z10;
        try {
            ConcurrentHashMap<Integer, Boolean> concurrentHashMap = this.mTransferRequestMap.get(Long.valueOf(j10));
            if (concurrentHashMap != null) {
                z10 = concurrentHashMap.containsKey(Integer.valueOf(i10));
            } else {
                C1371a.c(TAG, "TransferRequest record null");
                z10 = false;
            }
        } catch (Throwable th) {
            throw th;
        }
        return z10;
    }

    private String getContentURIAuthority() {
        List<ProviderInfo> list;
        try {
            list = this.mContext.getPackageManager().queryContentProviders(this.mContext.getPackageName(), Process.myUid(), 0);
        } catch (Exception e10) {
            C1371a.e(TAG, "queryContentProviders failed!", e10);
            list = null;
        }
        if (list != null) {
            for (ProviderInfo providerInfo : list) {
                if (FILE_PROVIDER.equalsIgnoreCase(providerInfo.name)) {
                    C1371a.c(TAG, "Authority:" + providerInfo.authority);
                    return providerInfo.authority;
                }
                if (FILE_PROVIDER_V4.equalsIgnoreCase(providerInfo.name)) {
                    C1371a.c(TAG, "Authority:" + providerInfo.authority);
                    return providerInfo.authority;
                }
            }
        }
        return null;
    }

    private synchronized h.a getTransaction(long j10, int i10) {
        h.a aVar;
        ConcurrentHashMap<Integer, h.a> concurrentHashMap;
        ConcurrentHashMap<Long, ConcurrentHashMap<Integer, h.a>> concurrentHashMap2 = this.mTransactionsMap;
        if (concurrentHashMap2 != null && (concurrentHashMap = concurrentHashMap2.get(Long.valueOf(j10))) != null) {
            aVar = concurrentHashMap.get(Integer.valueOf(i10));
        } else {
            aVar = null;
        }
        return aVar;
    }

    private synchronized boolean getTransactionRequestState(long j10, int i10) {
        ConcurrentHashMap<Integer, Boolean> concurrentHashMap = this.mTransferRequestMap.get(Long.valueOf(j10));
        boolean z10 = false;
        if (concurrentHashMap == null) {
            return false;
        }
        Boolean bool = concurrentHashMap.get(Integer.valueOf(i10));
        if (bool != null) {
            z10 = bool.booleanValue();
        }
        return z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnCancelAllCompletedErrorCode(int i10) {
        if (i10 != 12) {
            if (i10 != 13) {
                C1371a.k(TAG, "onCancelAllCompleted() error_code: " + i10);
                return;
            }
            C1371a.g(TAG, "onCancelAllCompleted() -> ERROR_TRANSACTION_NOT_FOUND");
            return;
        }
        C1371a.g(TAG, "onCancelAllCompleted() -> ERROR_NOT_SUPPORTED");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnTransferCompletedErrorCode(int i10) {
        if (i10 != 8) {
            if (i10 != 9) {
                if (i10 != 11) {
                    if (i10 != 20001) {
                        switch (i10) {
                            case -1:
                                C1371a.g(TAG, "onTransferCompleted() -> ERROR_REQUEST_NOT_QUEUED");
                                return;
                            case 0:
                                C1371a.g(TAG, "onTransferCompleted() -> ERROR_NONE");
                                return;
                            case 1:
                                C1371a.g(TAG, "onTransferCompleted() -> ERROR_CHANNEL_IO");
                                return;
                            case 2:
                                C1371a.g(TAG, "onTransferCompleted() -> ERROR_FILE_IO");
                                return;
                            case 3:
                                C1371a.g(TAG, "onTransferCompleted() -> ERROR_COMMAND_DROPPED");
                                return;
                            case 4:
                                C1371a.g(TAG, "onTransferCompleted() -> ERROR_PEER_AGENT_NO_RESPONSE");
                                return;
                            case 5:
                                C1371a.g(TAG, "onTransferCompleted() -> ERROR_CONNECTION_LOST");
                                return;
                            default:
                                C1371a.k(TAG, "onTransferCompleted() error_code: " + i10);
                                return;
                        }
                    }
                    C1371a.g(TAG, "onTransferCompleted() -> ERROR_FATAL");
                    return;
                }
                C1371a.g(TAG, "onTransferCompleted() -> ERROR_SPACE_NOT_AVAILABLE");
                return;
            }
            C1371a.g(TAG, "onTransferCompleted() -> ERROR_PEER_AGENT_REJECTED");
            return;
        }
        C1371a.g(TAG, "onTransferCompleted() -> ERROR_PEER_AGENT_BUSY");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$cancel$3(long j10, int i10) {
        h.a transaction = getTransaction(j10, i10);
        if (transaction == null) {
            C1371a.c(TAG, "cancelFile aborted because service connection or transaction already closed.");
            return;
        }
        int i11 = transaction.f25333b;
        if (i11 == 0) {
            transaction.f25333b = -1;
            C1371a.c(TAG, "Cancel called before transaction id is generated" + i10);
            return;
        }
        if (i11 == -1) {
            C1371a.c(TAG, "Cancel called again before transaction id is generated" + i10);
            return;
        }
        this.mFileTransferManager.j(j10, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$cancelAll$4(String str) {
        int c10 = this.mFileTransferManager.c(str);
        C1371a.c(TAG, "cancel status " + c10);
        EventListener eventListener = this.mEventListener;
        if (eventListener == null) {
            C1371a.k(TAG, "[cancelAll] listener is null.");
            return;
        }
        if (c10 == 0) {
            handleOnCancelAllCompletedErrorCode(12);
            eventListener.onCancelAllCompleted(-1, 12);
        } else if (c10 == 13) {
            handleOnCancelAllCompletedErrorCode(13);
            eventListener.onCancelAllCompleted(-1, 13);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$informIncomingFTRequest$6(int i10, long j10, String str, long j11, String str2, h hVar, int i11) {
        this.mFileTransferManager.q(this.mLocalCallback, i10);
        putTransactionRequest(j10, i10, true);
        m5.d c10 = new d.b().f(str).g(j11).e(str2).c();
        C1371a.c(TAG, "receive file request");
        hVar.a().onTransferRequested(j10, i11, i10, c10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$receive$0(long j10, int i10, String str, String str2) {
        try {
            this.mFileTransferManager.l(this.mLocalCallback, j10, i10, str, str2);
            this.mTransactionUriMap.put(Integer.valueOf(i10), Uri.parse(str2));
        } finally {
            putTransactionRequest(j10, i10, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$receive$1(long j10, int i10, Uri uri) {
        try {
            this.mFileTransferManager.k(this.mLocalCallback, j10, i10, uri, true);
            this.mTransactionUriMap.put(Integer.valueOf(i10), uri);
        } finally {
            putTransactionRequest(j10, i10, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$register$5() {
        try {
            this.mFileTransferManager.y();
        } catch (GeneralException e10) {
            C1371a.d(TAG, "register ex:" + e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reject$2(long j10, int i10) {
        this.mFileTransferManager.k(null, j10, i10, null, false);
    }

    private synchronized void putTransaction(long j10, int i10, h.a aVar) {
        try {
            ConcurrentHashMap<Long, ConcurrentHashMap<Integer, h.a>> concurrentHashMap = this.mTransactionsMap;
            if (concurrentHashMap != null) {
                ConcurrentHashMap<Integer, h.a> concurrentHashMap2 = concurrentHashMap.get(Long.valueOf(j10));
                if (concurrentHashMap2 == null) {
                    concurrentHashMap2 = new ConcurrentHashMap<>();
                    this.mTransactionsMap.put(Long.valueOf(j10), concurrentHashMap2);
                }
                concurrentHashMap2.put(Integer.valueOf(i10), aVar);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private synchronized void putTransactionRequest(long j10, int i10, boolean z10) {
        try {
            ConcurrentHashMap<Integer, Boolean> concurrentHashMap = this.mTransferRequestMap.get(Long.valueOf(j10));
            if (concurrentHashMap == null) {
                concurrentHashMap = new ConcurrentHashMap<>();
            }
            concurrentHashMap.put(Integer.valueOf(i10), Boolean.valueOf(z10));
            this.mTransferRequestMap.put(Long.valueOf(j10), concurrentHashMap);
            C1371a.c(TAG, "TransferRequest : , connectionId: " + j10 + ", transactionId: " + i10 + ", isRequest: " + z10 + ", state: " + getTransactionRequestState(j10, i10) + ", hash: " + hashCode());
        } catch (Throwable th) {
            throw th;
        }
    }

    private boolean register() {
        if (this.mFileTransferManager.r(this, this.mAgentName)) {
            HandlerThread handlerThread = new HandlerThread("FileTransferHandlerThread");
            this.mFileTransferHandlerThread = handlerThread;
            handlerThread.start();
            C1371a.c(TAG, "FileTransferHandlerThread started");
            Looper looper = this.mFileTransferHandlerThread.getLooper();
            if (looper != null) {
                this.mHandler = new b(looper);
                ConcurrentHashMap<Long, ConcurrentHashMap<Integer, h.a>> concurrentHashMap = new ConcurrentHashMap<>();
                this.mTransactionsMap = concurrentHashMap;
                h hVar = new h(this.mEventListener, this.mFileTransferHandlerThread, this.mHandler, this.mLocalCallback, concurrentHashMap);
                this.mCallingAgentInfo = hVar;
                this.mFileTransferManager.n(this.mAgentName, hVar);
                this.mHandler.post(new Runnable() { // from class: com.heytap.accessory.file.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        FileTransfer.this.lambda$register$5();
                    }
                });
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void removeTransaction(long j10, int i10) {
        ConcurrentHashMap<Integer, h.a> concurrentHashMap;
        ConcurrentHashMap<Long, ConcurrentHashMap<Integer, h.a>> concurrentHashMap2 = this.mTransactionsMap;
        if (concurrentHashMap2 != null && (concurrentHashMap = concurrentHashMap2.get(Long.valueOf(j10))) != null) {
            concurrentHashMap.remove(Integer.valueOf(i10));
            if (concurrentHashMap.isEmpty()) {
                this.mTransactionsMap.remove(Long.valueOf(j10));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void removeTransactionByTransId(int i10) {
        ConcurrentHashMap<Long, ConcurrentHashMap<Integer, h.a>> concurrentHashMap = this.mTransactionsMap;
        if (concurrentHashMap != null) {
            Iterator<Long> it = concurrentHashMap.keySet().iterator();
            while (it.hasNext()) {
                removeTransaction(it.next().longValue(), i10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void removeTransactionRequest(long j10, int i10) {
        ConcurrentHashMap<Integer, Boolean> concurrentHashMap = this.mTransferRequestMap.get(Long.valueOf(j10));
        if (concurrentHashMap != null) {
            concurrentHashMap.remove(Integer.valueOf(i10));
            if (concurrentHashMap.isEmpty()) {
                this.mTransferRequestMap.remove(Long.valueOf(j10));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void revokeUriPermission(int i10) {
        String fileTransferPackageName = FTInitializer.getFileTransferPackageName(this.mContext);
        Uri uri = this.mTransactionUriMap.get(Integer.valueOf(i10));
        if (uri != null) {
            revokeUriPermission(fileTransferPackageName, uri, 3);
            return;
        }
        C1371a.k(TAG, "cannot find transactionId:" + i10);
    }

    public void cancel(final long j10, final int i10) {
        if (this.mCallingAgent != null && this.mEventListener != null) {
            if (containsTransactionKey(j10, i10)) {
                this.mHandler.post(new Runnable() { // from class: com.heytap.accessory.file.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        FileTransfer.this.lambda$cancel$3(j10, i10);
                    }
                });
                return;
            }
            throw new IllegalArgumentException("Wrong connection(" + j10 + ") transaction id(" + i10 + ") used for cancel.");
        }
        C1371a.c(TAG, "Using invalid instance of FileTransfer(). Please re-register.");
    }

    public void cancelAll() {
        if (this.mCallingAgent != null && this.mEventListener != null) {
            final String string = this.mContext.createDeviceProtectedStorageContext().getSharedPreferences("AccessoryPreferences", 0).getString(this.mAgentName, null);
            if (string == null) {
                C1371a.d(TAG, "Your service was not found. Please re-register");
                return;
            } else {
                this.mHandler.post(new Runnable() { // from class: com.heytap.accessory.file.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        FileTransfer.this.lambda$cancelAll$4(string);
                    }
                });
                return;
            }
        }
        C1371a.c(TAG, "Using invalid instance of Please re-register.");
    }

    public boolean checkPathPermission(String str) {
        C1371a.c(TAG, "checkPathPermission calling pkg: " + this.mContext.getPackageName() + " file Path:" + str);
        if (str.startsWith("/data/data")) {
            return str.contains(this.mContext.getPackageName());
        }
        return true;
    }

    public void close() {
        if (this.mCallingAgent != null && this.mEventListener != null) {
            C1371a.c(TAG, "stopFileTransferService() called by : " + this.mAgentName);
            this.mFileTransferManager.x(this.mAgentName);
            ConcurrentHashMap<Long, ConcurrentHashMap<Integer, h.a>> concurrentHashMap = this.mTransactionsMap;
            if (concurrentHashMap != null) {
                concurrentHashMap.clear();
            }
            b bVar = this.mHandler;
            if (bVar != null) {
                bVar.removeCallbacksAndMessages(null);
                this.mHandler.getLooper().quit();
                return;
            }
            return;
        }
        C1371a.c(TAG, "Using invalid instance of FileTransfer(). Please re-register.");
    }

    public void informIncomingFTRequest(Intent intent) {
        final int intExtra = intent.getIntExtra("transId", -1);
        String stringExtra = intent.getStringExtra("agentClass");
        final long longExtra = intent.getLongExtra(AFConstants.EXTRA_CONNECTION_ID, 0L);
        final int parseInt = Integer.parseInt(intent.getStringExtra("contId"));
        final long longExtra2 = intent.getLongExtra("fileSize", 0L);
        C1371a.c(TAG, "receive incoming FTRequest; transactionId = " + intExtra + "; connectionId = " + longExtra + "; implClass = " + stringExtra + "; fileSize = " + longExtra2 + "; peerAgentId = " + parseInt);
        StringBuilder sb = new StringBuilder();
        sb.append("class now:");
        sb.append(stringExtra);
        sb.append(" , ");
        sb.append(hashCode());
        C1371a.c(TAG, sb.toString());
        if (this.mCallingAgent == null) {
            C1371a.d(TAG, "Calling agent was cleared");
            return;
        }
        if (!stringExtra.equalsIgnoreCase(this.mAgentName)) {
            C1371a.d(TAG, "Class name not matched with " + this.mAgentName);
            return;
        }
        final h u10 = this.mFileTransferManager.u(stringExtra);
        if (u10 == null) {
            C1371a.d(TAG, "AgentInfo is NULL! Re-Registering");
            register();
            informIncomingFTRequest(intent);
        } else {
            if (u10.a() == null) {
                C1371a.d(TAG, "callback is not registered for " + stringExtra);
                return;
            }
            final String stringExtra2 = intent.getStringExtra("filePath");
            final String stringExtra3 = intent.getStringExtra("fileName");
            C1371a.c(TAG, "Informing app of incoming file transfer request on registered callback-tid: " + intExtra);
            this.mHandler.post(new Runnable() { // from class: com.heytap.accessory.file.g
                @Override // java.lang.Runnable
                public final void run() {
                    FileTransfer.this.lambda$informIncomingFTRequest$6(intExtra, longExtra, stringExtra3, longExtra2, stringExtra2, u10, parseInt);
                }
            });
        }
    }

    public boolean isInternalPath(String str) {
        return str.startsWith("/data/data");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void receive(final long r16, final int r18, final java.lang.String r19) {
        /*
            Method dump skipped, instructions count: 274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.heytap.accessory.file.FileTransfer.receive(long, int, java.lang.String):void");
    }

    public void reject(final long j10, final int i10) {
        C1371a.c(TAG, "file reject, connId: " + j10 + ", transId: " + i10);
        if (this.mCallingAgent != null && this.mEventListener != null) {
            if (checkReceiveParams("", j10, i10) && containsTransactionRequestKey(j10, i10)) {
                h.a aVar = new h.a();
                aVar.f25333b = i10;
                aVar.f25335d = "";
                removeTransaction(j10, i10);
                this.mHandler.post(new Runnable() { // from class: com.heytap.accessory.file.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        FileTransfer.this.lambda$reject$2(j10, i10);
                    }
                });
                return;
            }
            C1371a.d(TAG, "Wrong transaction id used in reject");
            return;
        }
        C1371a.k(TAG, "Using invalid instance of FileTransfer(). Please re-register.");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int send(com.heytap.accessory.bean.PeerAgent r16, java.lang.String r17) {
        /*
            r15 = this;
            r1 = r15
            r9 = r17
            java.lang.String r2 = "Cannot create the content URI !"
            boolean r0 = r15.checkPeerAgentValid(r16)
            r10 = -1
            if (r0 == 0) goto Ld4
            r15.checkSource(r9)
            android.content.Context r0 = r1.mContext
            java.lang.String r11 = com.heytap.accessory.file.FTInitializer.getFileTransferPackageName(r0)
            java.lang.String r0 = r15.getContentURIAuthority()
            r12 = 1
            r3 = 0
            java.lang.String r13 = "FileTransfer"
            if (r0 == 0) goto L68
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.IllegalArgumentException -> L4c
            r4.<init>()     // Catch: java.lang.IllegalArgumentException -> L4c
            java.lang.String r5 = "File:"
            r4.append(r5)     // Catch: java.lang.IllegalArgumentException -> L4c
            r4.append(r9)     // Catch: java.lang.IllegalArgumentException -> L4c
            java.lang.String r4 = r4.toString()     // Catch: java.lang.IllegalArgumentException -> L4c
            n5.C1371a.i(r13, r4)     // Catch: java.lang.IllegalArgumentException -> L4c
            java.io.File r4 = new java.io.File     // Catch: java.lang.IllegalArgumentException -> L4c
            r4.<init>(r9)     // Catch: java.lang.IllegalArgumentException -> L4c
            android.content.Context r5 = r1.mContext     // Catch: java.lang.IllegalArgumentException -> L4c
            android.net.Uri r4 = androidx.core.content.FileProvider.h(r5, r0, r4)     // Catch: java.lang.IllegalArgumentException -> L4c
            if (r4 != 0) goto L46
            n5.C1371a.d(r13, r2)     // Catch: java.lang.IllegalArgumentException -> L44
            goto L55
        L44:
            r0 = move-exception
            goto L4e
        L46:
            android.content.Context r0 = r1.mContext     // Catch: java.lang.IllegalArgumentException -> L44
            r0.grantUriPermission(r11, r4, r12)     // Catch: java.lang.IllegalArgumentException -> L44
            goto L55
        L4c:
            r0 = move-exception
            r4 = r3
        L4e:
            r15.revokeUriPermission(r11, r4, r12)
            n5.C1371a.e(r13, r2, r0)
            r4 = r3
        L55:
            if (r4 != 0) goto L66
            boolean r0 = r15.isInternalPath(r9)
            if (r0 != 0) goto L5e
            goto L66
        L5e:
            com.heytap.accessory.bean.UnSupportException r0 = new com.heytap.accessory.bean.UnSupportException
            java.lang.String r1 = "content uri needs to be implemented for sending from internal folders.Please check file-transfer sdk documentation for more details"
            r0.<init>(r1)
            throw r0
        L66:
            r0 = r4
            goto L6e
        L68:
            java.lang.String r0 = "FTCore version not support content uri"
            n5.C1371a.i(r13, r0)
            r0 = r3
        L6e:
            com.heytap.accessory.file.h$a r14 = new com.heytap.accessory.file.h$a
            r14.<init>()
            if (r0 == 0) goto L7b
            java.lang.String r2 = r0.toString()
            r7 = r2
            goto L7c
        L7b:
            r7 = r3
        L7c:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "FTCore strURI="
            r2.append(r3)
            r2.append(r7)
            java.lang.String r2 = r2.toString()
            n5.C1371a.i(r13, r2)
            com.heytap.accessory.file.FileTransferManager r2 = r1.mFileTransferManager
            android.content.Context r3 = r1.mContext
            java.lang.String r4 = r1.mAgentName
            com.heytap.accessory.file.FileTransfer$c r5 = r1.mLocalCallback
            r6 = r16
            r8 = r17
            int r2 = r2.a(r3, r4, r5, r6, r7, r8)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "received tx from FTCore"
            r3.append(r4)
            r3.append(r2)
            java.lang.String r3 = r3.toString()
            n5.C1371a.c(r13, r3)
            r14.f25333b = r2
            r14.f25335d = r9
            r3 = 0
            r15.putTransaction(r3, r2, r14)
            if (r2 != r10) goto Lc8
            java.lang.String r3 = "send file failed,revokeUriPermission"
            n5.C1371a.c(r13, r3)
            r15.revokeUriPermission(r11, r0, r12)
            goto Ld3
        Lc8:
            if (r0 == 0) goto Ld3
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, android.net.Uri> r1 = r1.mTransactionUriMap
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            r1.put(r3, r0)
        Ld3:
            return r2
        Ld4:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.heytap.accessory.file.FileTransfer.send(com.heytap.accessory.bean.PeerAgent, java.lang.String):int");
    }

    public FileTransfer(BaseJobAgent baseJobAgent, EventListener eventListener) {
        this(baseJobAgent, baseJobAgent.getApplicationContext(), eventListener);
    }

    public FileTransfer(Object obj, Context context, EventListener eventListener) {
        this.mTransactionUriMap = new ConcurrentHashMap<>();
        this.mTransactionsMap = new ConcurrentHashMap<>();
        this.mTransferRequestMap = new ConcurrentHashMap<>();
        this.mLocalCallback = new a();
        this.mContext = context;
        this.mCallingAgent = obj;
        this.mEventListener = eventListener;
        this.mAgentName = obj.getClass().getName();
        FTInitializer.init(this.mContext);
        this.mFileTransferManager = FileTransferManager.g(this.mContext);
        if (register()) {
            return;
        }
        C1371a.c(TAG, "Agent already registered");
        h u10 = this.mFileTransferManager.u(this.mAgentName);
        this.mCallingAgentInfo = u10;
        if (u10 != null) {
            this.mFileTransferHandlerThread = u10.e();
            this.mHandler = (b) this.mCallingAgentInfo.d();
            this.mTransactionsMap = this.mCallingAgentInfo.g();
            this.mCallingAgentInfo.b(this.mEventListener);
            this.mCallingAgentInfo.c(this.mLocalCallback);
        }
    }

    private void revokeUriPermission(String str, Uri uri, int i10) {
        if (!TextUtils.isEmpty(str) && uri != null) {
            C1371a.c(TAG, "revokeUriPermission packageName:" + str + " uri:" + uri);
            this.mContext.revokeUriPermission(str, uri, i10);
            return;
        }
        C1371a.j("revokeUriPermission failed, params invalid");
    }

    public int send(PeerAgent peerAgent, Uri uri) {
        return send(peerAgent, uri, "");
    }

    public int send(PeerAgent peerAgent, Uri uri, String str) {
        if (!checkPeerAgentValid(peerAgent)) {
            return -1;
        }
        C1371a.c(TAG, "peerAgent:" + peerAgent);
        String fileTransferPackageName = FTInitializer.getFileTransferPackageName(this.mContext);
        try {
        } catch (Exception e10) {
            C1371a.e(TAG, "Error grantUriPermission!!", e10);
        }
        if (uri == null) {
            C1371a.d(TAG, "File path is wrong!!");
            return -1;
        }
        C1371a.i(TAG, "File :" + uri);
        this.mContext.grantUriPermission(fileTransferPackageName, uri, 1);
        h.a aVar = new h.a();
        int b10 = this.mFileTransferManager.b(this.mContext, this.mAgentName, str, this.mLocalCallback, peerAgent, uri);
        C1371a.c(TAG, "received tx from FTCore" + b10);
        aVar.f25333b = b10;
        aVar.f25335d = uri != null ? uri.toString() : "";
        putTransaction(0L, b10, aVar);
        if (b10 == -1) {
            C1371a.c(TAG, "send file failed,revokeUriPermission");
            revokeUriPermission(fileTransferPackageName, uri, 1);
        } else if (uri != null) {
            this.mTransactionUriMap.put(Integer.valueOf(b10), uri);
        }
        return b10;
    }

    public void receive(final long j10, final int i10, final Uri uri) {
        C1371a.g(TAG, "receive receiveFileUri: " + uri + ", connectionId:" + j10 + ", transactionId:" + i10 + ", " + hashCode());
        if (uri == null) {
            C1371a.d(TAG, "Uri is invalid, receiveFileUri is null");
            putTransactionRequest(j10, i10, false);
            throw new IllegalArgumentException("Uri is invalid, receiveFileUri is null");
        }
        if (this.mCallingAgent == null || this.mEventListener == null) {
            C1371a.c(TAG, "Using invalid instance of FileTransfer(). Please re-register.");
            putTransactionRequest(j10, i10, false);
            return;
        }
        if (containsTransactionRequestKey(j10, i10)) {
            h.a aVar = new h.a();
            aVar.f25332a = j10;
            aVar.f25333b = i10;
            aVar.f25335d = uri.toString();
            putTransaction(j10, i10, aVar);
            String fileTransferPackageName = FTInitializer.getFileTransferPackageName(this.mContext);
            try {
                aVar.f25334c = uri.toString();
                this.mContext.grantUriPermission(fileTransferPackageName, uri, 2);
            } catch (Exception e10) {
                revokeUriPermission(fileTransferPackageName, uri, 2);
                C1371a.e(TAG, "Error grantUriPermission!!", e10);
            }
            this.mHandler.post(new Runnable() { // from class: com.heytap.accessory.file.e
                @Override // java.lang.Runnable
                public final void run() {
                    FileTransfer.this.lambda$receive$1(j10, i10, uri);
                }
            });
            return;
        }
        C1371a.c(TAG, "TransactionId: Given[" + i10 + "] not exist");
        putTransactionRequest(j10, i10, false);
        throw new IllegalArgumentException("Wrong filepath or transaction id used");
    }
}
