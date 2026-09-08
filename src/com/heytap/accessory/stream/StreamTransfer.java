package com.heytap.accessory.stream;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import com.heytap.accessory.BaseAgent;
import com.heytap.accessory.BaseJobAgent;
import com.heytap.accessory.bean.GeneralException;
import com.heytap.accessory.bean.PeerAgent;
import com.heytap.accessory.bean.UnSupportException;
import com.heytap.accessory.constant.AFConstants;
import com.heytap.accessory.stream.StreamTransfer;
import java.io.FileDescriptor;
import java.io.InputStream;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import n5.C1371a;
import p5.C1441a;

/* loaded from: classes3.dex */
public class StreamTransfer {
    public static final String ACTION_STREAM_TRANSFER_REQUESTED = "com.heytap.accessory.streamconnection";
    public static final int ERROR_CANCEL_ACC_SLEEPING = 17;
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
    public static final int ERROR_RECEIVER_MEMORY_LACKING = 15;
    public static final int ERROR_RECEIVER_WAIT_TILL_TIMEOUT = 16;
    public static final int ERROR_REQUEST_NOT_QUEUED = -1;
    public static final int ERROR_SPACE_NOT_AVAILABLE = 11;
    public static final int ERROR_TRANSACTION_NOT_FOUND = 13;
    public static final String RECEIVE_PFD = "receivePfd";
    private static final int ST_CANCEL_TRANS_ID = -1;
    private static final int ST_DEFAULT_CONNECTION_ID = 0;
    private static final int ST_DEFAULT_TRANS_ID = 0;
    private static final String TAG = "StreamTransfer";
    private String mAgentName;
    private Object mCallingAgent;
    private C1441a mCallingAgentInfo;
    private Context mContext;
    private EventListener mEventListener;
    private c mHandler;
    private b mLocalCallback;
    private HandlerThread mStreamTransferHandlerThread;
    private final com.heytap.accessory.stream.a mStreamTransferManager;
    private ConcurrentHashMap<Long, ConcurrentHashMap<Integer, C1441a.C0341a>> mTransactionsMap;
    private final ConcurrentHashMap<Long, ConcurrentHashMap<Integer, Boolean>> mTransferRequestMap;

    /* loaded from: classes3.dex */
    public interface EventListener {
        void onCancelAllCompleted(int i10, int i11);

        void onStreamReceived(long j10, int i10, InputStream inputStream);

        void onTransferCompleted(long j10, int i10, int i11);

        void onTransferRequested(long j10, int i10, int i11);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(int[] iArr, int i10);

        void b(long j10, int i10);

        void onTransferCompleted(long j10, int i10, int i11);
    }

    /* loaded from: classes3.dex */
    public static class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }
    }

    public StreamTransfer(BaseAgent baseAgent, EventListener eventListener) {
        this(baseAgent, baseAgent.getApplicationContext(), eventListener);
    }

    private boolean checkReceiveParams(long j10, int i10) {
        if (containsTransactionKey(j10, i10)) {
            C1371a.c(TAG, "transactionId already exist");
            return false;
        }
        return true;
    }

    private boolean checkStreamUnSupport(PeerAgent peerAgent) {
        if (peerAgent != null && peerAgent.getAccessory() != null && peerAgent.getAccessory().supportStream()) {
            return false;
        }
        return true;
    }

    private synchronized boolean containsTransactionKey(long j10, int i10) {
        boolean z10;
        ConcurrentHashMap<Integer, C1441a.C0341a> concurrentHashMap;
        ConcurrentHashMap<Long, ConcurrentHashMap<Integer, C1441a.C0341a>> concurrentHashMap2 = this.mTransactionsMap;
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
                C1371a.d(TAG + hashCode(), "mTransferRequestMap not contains connectionId:" + j10 + ",transactionId:" + i10);
                z10 = false;
            }
        } catch (Throwable th) {
            throw th;
        }
        return z10;
    }

    private synchronized C1441a.C0341a getTransaction(long j10, int i10) {
        C1441a.C0341a c0341a;
        ConcurrentHashMap<Integer, C1441a.C0341a> concurrentHashMap;
        ConcurrentHashMap<Long, ConcurrentHashMap<Integer, C1441a.C0341a>> concurrentHashMap2 = this.mTransactionsMap;
        if (concurrentHashMap2 != null && (concurrentHashMap = concurrentHashMap2.get(Long.valueOf(j10))) != null) {
            c0341a = concurrentHashMap.get(Integer.valueOf(i10));
        } else {
            c0341a = null;
        }
        return c0341a;
    }

    private synchronized boolean getTransactionRequestState(long j10, int i10) {
        ConcurrentHashMap<Integer, Boolean> concurrentHashMap = this.mTransferRequestMap.get(Long.valueOf(j10));
        boolean z10 = false;
        if (concurrentHashMap == null) {
            return false;
        }
        Boolean bool = concurrentHashMap.get(Integer.valueOf(i10));
        if (bool != null) {
            if (bool.booleanValue()) {
                z10 = true;
            }
        }
        return z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnCancelAllCompletedErrorCode(int i10) {
        if (i10 != 12) {
            if (i10 != 13) {
                if (i10 != 17) {
                    C1371a.k(TAG, "onCancelAllCompleted() error_code: " + i10);
                    return;
                }
                C1371a.g(TAG, "onCancelAllCompleted() -> ERROR_CANCEL_ACC_SLEEPING");
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
                if (i10 != 15) {
                    if (i10 != 16) {
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
                    C1371a.g(TAG, "onTransferCompleted() -> ERROR_RECEIVER_WAIT_TILL_TIMEOUT");
                    return;
                }
                C1371a.g(TAG, "onTransferCompleted() -> ERROR_RECEIVER_MEMORY_LACKING");
                return;
            }
            C1371a.g(TAG, "onTransferCompleted() -> ERROR_PEER_AGENT_REJECTED");
            return;
        }
        C1371a.g(TAG, "onTransferCompleted() -> ERROR_PEER_AGENT_BUSY");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$cancelAll$2(String str) {
        try {
            synchronized (this) {
                try {
                    int d10 = this.mStreamTransferManager.d(str);
                    EventListener eventListener = this.mEventListener;
                    if (eventListener == null) {
                        C1371a.k(TAG, "[cancelAll] listener is null.");
                        return;
                    }
                    C1371a.c(TAG, "[cancelAll] cancel status " + d10);
                    if (d10 == 0) {
                        handleOnCancelAllCompletedErrorCode(12);
                        eventListener.onCancelAllCompleted(-1, 12);
                    } else if (d10 == 13) {
                        handleOnCancelAllCompletedErrorCode(13);
                        eventListener.onCancelAllCompleted(-1, 13);
                    } else if (d10 == 17) {
                        handleOnCancelAllCompletedErrorCode(17);
                        eventListener.onCancelAllCompleted(-1, 17);
                    }
                } finally {
                }
            }
        } catch (Exception e10) {
            C1371a.e(TAG, "[cancelAll]", e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$informIncomingSTRequest$4(int i10, long j10, C1441a c1441a, int i11) {
        this.mStreamTransferManager.m(this.mLocalCallback, i10);
        putTransactionRequest(j10, i10, true);
        c1441a.a().onTransferRequested(j10, i11, i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$receive$0(long j10, int i10) {
        EventListener eventListener;
        try {
            ParcelFileDescriptor f10 = this.mStreamTransferManager.f(this.mLocalCallback, j10, i10, true);
            if (f10 != null && (eventListener = this.mEventListener) != null) {
                eventListener.onStreamReceived(j10, i10, new ParcelFileDescriptor.AutoCloseInputStream(f10));
            }
        } catch (Exception e10) {
            C1371a.d(TAG, "receive ex:" + e10);
        } finally {
            putTransactionRequest(j10, i10, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$register$3() {
        try {
            this.mStreamTransferManager.u();
        } catch (GeneralException e10) {
            C1371a.d(TAG, "register ex:" + e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reject$1(long j10, int i10) {
        this.mStreamTransferManager.f(null, j10, i10, false);
    }

    private synchronized void putTransaction(long j10, int i10, C1441a.C0341a c0341a) {
        try {
            C1371a.g(TAG + hashCode(), "putTransaction: connectionId:" + j10 + ",transactionId:" + i10);
            ConcurrentHashMap<Long, ConcurrentHashMap<Integer, C1441a.C0341a>> concurrentHashMap = this.mTransactionsMap;
            if (concurrentHashMap != null) {
                ConcurrentHashMap<Integer, C1441a.C0341a> concurrentHashMap2 = concurrentHashMap.get(Long.valueOf(j10));
                if (concurrentHashMap2 == null) {
                    concurrentHashMap2 = new ConcurrentHashMap<>();
                    this.mTransactionsMap.put(Long.valueOf(j10), concurrentHashMap2);
                }
                if (c0341a != null) {
                    concurrentHashMap2.put(Integer.valueOf(i10), c0341a);
                }
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
            C1371a.c(TAG + hashCode(), "putTransactionRequest connectionId: " + j10 + " ,transactionId: " + i10 + " , " + z10 + " , " + getTransactionRequestState(j10, i10));
        } catch (Throwable th) {
            throw th;
        }
    }

    private boolean register() {
        if (this.mStreamTransferManager.n(this, this.mAgentName)) {
            HandlerThread handlerThread = new HandlerThread("StreamTransferHandlerThread");
            this.mStreamTransferHandlerThread = handlerThread;
            handlerThread.start();
            C1371a.c(TAG, "StreamTransferHandlerThread started");
            Looper looper = this.mStreamTransferHandlerThread.getLooper();
            if (looper != null) {
                this.mHandler = new c(looper);
            }
            if (this.mHandler != null) {
                ConcurrentHashMap<Long, ConcurrentHashMap<Integer, C1441a.C0341a>> concurrentHashMap = new ConcurrentHashMap<>();
                this.mTransactionsMap = concurrentHashMap;
                C1441a c1441a = new C1441a(this.mEventListener, this.mStreamTransferHandlerThread, this.mHandler, this.mLocalCallback, concurrentHashMap);
                this.mCallingAgentInfo = c1441a;
                com.heytap.accessory.stream.a.l(this.mAgentName, c1441a);
                this.mHandler.post(new Runnable() { // from class: o5.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        StreamTransfer.this.lambda$register$3();
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
        ConcurrentHashMap<Integer, C1441a.C0341a> concurrentHashMap;
        ConcurrentHashMap<Long, ConcurrentHashMap<Integer, C1441a.C0341a>> concurrentHashMap2 = this.mTransactionsMap;
        if (concurrentHashMap2 != null && (concurrentHashMap = concurrentHashMap2.get(Long.valueOf(j10))) != null) {
            concurrentHashMap.remove(Integer.valueOf(i10));
            if (concurrentHashMap.isEmpty()) {
                C1371a.g(TAG, "removeTransaction:" + j10 + " " + i10);
                this.mTransactionsMap.remove(Long.valueOf(j10));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void removeTransactionByTransId(int i10) {
        ConcurrentHashMap<Long, ConcurrentHashMap<Integer, C1441a.C0341a>> concurrentHashMap = this.mTransactionsMap;
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

    private boolean validateParam(PeerAgent peerAgent) {
        if (!checkStreamUnSupport(peerAgent)) {
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
            C1371a.d(TAG, "Using invalid instance of StreamTransfer, Please re-register.");
            return false;
        }
        throw new UnSupportException("the peer agent doesn't support the stream feature, please check");
    }

    public void cancel(long j10, int i10) {
        if (this.mCallingAgent != null && this.mEventListener != null) {
            if (!containsTransactionKey(j10, i10)) {
                C1371a.d(TAG, "Wrong transaction id used for cancel");
                return;
            }
            C1441a.C0341a transaction = getTransaction(j10, i10);
            if (transaction == null) {
                C1371a.c(TAG, "cancelStream aborted because service connection or transaction already closed.");
                return;
            }
            int i11 = transaction.f36020b;
            if (i11 == 0) {
                transaction.f36020b = -1;
                C1371a.c(TAG, "Cancel called before transaction id is genereated" + i10);
                return;
            }
            if (i11 == -1) {
                C1371a.c(TAG, "Cancel called again before transaction id is genereated" + i10);
                return;
            }
            this.mStreamTransferManager.k(j10, i11);
            return;
        }
        C1371a.c(TAG, "Using invalid instance of StreamTransfer(). Please re-register.");
    }

    public void cancelAll() {
        C1371a.c(TAG, "[StreamTransfer] cancelAll Stream");
        if (this.mCallingAgent != null && this.mEventListener != null) {
            final String string = this.mContext.createDeviceProtectedStorageContext().getSharedPreferences("AccessoryPreferences", 0).getString(this.mAgentName, null);
            if (string == null) {
                C1371a.d(TAG, "[cancelAll] Your service was not found. Please check your service config");
                return;
            } else {
                this.mHandler.post(new Runnable() { // from class: o5.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        StreamTransfer.this.lambda$cancelAll$2(string);
                    }
                });
                return;
            }
        }
        C1371a.c(TAG, "[cancelAll] Using invalid instance of Please re-register.");
    }

    public void close() {
        if (this.mCallingAgent != null && this.mEventListener != null) {
            C1371a.c(TAG, "stopStreamTransferService() called by : " + this.mAgentName);
            cancelAll();
            this.mStreamTransferManager.s(this.mAgentName);
            ConcurrentHashMap<Long, ConcurrentHashMap<Integer, C1441a.C0341a>> concurrentHashMap = this.mTransactionsMap;
            if (concurrentHashMap != null) {
                concurrentHashMap.clear();
            }
            c cVar = this.mHandler;
            if (cVar != null) {
                cVar.removeCallbacksAndMessages(null);
                this.mHandler.getLooper().quit();
                return;
            }
            return;
        }
        C1371a.c(TAG, "Using invalid instance of StreamTransfer(). Please re-register.");
    }

    public void informIncomingSTRequest(Context context, Intent intent) {
        final int intExtra = intent.getIntExtra("transId", -1);
        String stringExtra = intent.getStringExtra("agentClass");
        final long longExtra = intent.getLongExtra(AFConstants.EXTRA_CONNECTION_ID, 0L);
        final int parseInt = Integer.parseInt(intent.getStringExtra("contId"));
        if (stringExtra == null) {
            stringExtra = this.mContext.createDeviceProtectedStorageContext().getSharedPreferences("AccessoryPreferences", 0).getString(intent.getStringExtra("peerId"), null);
        }
        C1371a.c(TAG, "class now:" + stringExtra + " , " + hashCode());
        if (stringExtra == null) {
            C1371a.d(TAG, "Target agent was cleared. Re-registering");
            context.sendBroadcast(r5.b.a(context.getPackageName()));
            return;
        }
        if (this.mCallingAgent == null) {
            C1371a.d(TAG, "Calling agent was cleared");
            return;
        }
        if (!stringExtra.equalsIgnoreCase(this.mAgentName)) {
            C1371a.d(TAG, "Class name not matched with " + this.mAgentName);
            return;
        }
        final C1441a q10 = com.heytap.accessory.stream.a.q(stringExtra);
        if (q10 == null) {
            C1371a.d(TAG, "AgentInfo is NULL! Re-Registering");
            register();
            informIncomingSTRequest(context, intent);
        } else {
            if (q10.a() == null) {
                C1371a.d(TAG, "callback is not registered for " + stringExtra);
                return;
            }
            C1371a.c(TAG, "Informsing app of incoming stream transfer request on registered callback-tid: " + intExtra);
            this.mHandler.post(new Runnable() { // from class: o5.c
                @Override // java.lang.Runnable
                public final void run() {
                    StreamTransfer.this.lambda$informIncomingSTRequest$4(intExtra, longExtra, q10, parseInt);
                }
            });
        }
    }

    public void receive(final long j10, final int i10) {
        C1371a.g(TAG, "receive task connectionId: " + j10 + " ,transactionId:" + i10 + ",hashCode:, " + hashCode());
        if (this.mCallingAgent != null && this.mEventListener != null) {
            if (checkReceiveParams(j10, i10) && containsTransactionRequestKey(j10, i10)) {
                C1441a.C0341a c0341a = new C1441a.C0341a();
                c0341a.f36019a = j10;
                c0341a.f36020b = i10;
                putTransaction(j10, i10, c0341a);
                if (StreamInitializer.getStreamMsgPackageName(this.mContext) == null) {
                    C1371a.i(TAG, "Accessory Framework doesn't support content URI !!");
                }
                this.mHandler.post(new Runnable() { // from class: o5.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        StreamTransfer.this.lambda$receive$0(j10, i10);
                    }
                });
                return;
            }
            C1371a.c(TAG, "TransactionId: Given[" + i10 + "] not exist");
            putTransactionRequest(j10, i10, false);
            throw new IllegalArgumentException("Wrong filepath or transaction id used");
        }
        C1371a.c(TAG, "Using invalid instance of StreamTransfer(). Please re-register.");
        putTransactionRequest(j10, i10, false);
    }

    public void reject(final long j10, final int i10) {
        if (this.mCallingAgent != null && this.mEventListener != null) {
            if (checkReceiveParams(j10, i10) && containsTransactionRequestKey(j10, i10)) {
                new C1441a.C0341a().f36020b = i10;
                removeTransaction(j10, i10);
                this.mHandler.post(new Runnable() { // from class: o5.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        StreamTransfer.this.lambda$reject$1(j10, i10);
                    }
                });
                return;
            }
            throw new IllegalArgumentException("Wrong transaction id used in reject()");
        }
        C1371a.c(TAG, "Using invalid instance of StreamTransfer(). Please re-register.");
    }

    @Deprecated
    public int send(PeerAgent peerAgent, InputStream inputStream, int i10) {
        return send(peerAgent, inputStream, (FileDescriptor) null);
    }

    public StreamTransfer(BaseJobAgent baseJobAgent, EventListener eventListener) {
        this(baseJobAgent, baseJobAgent.getApplicationContext(), eventListener);
    }

    @Deprecated
    public int send(PeerAgent peerAgent, FileDescriptor fileDescriptor, int i10) {
        return send(peerAgent, (InputStream) null, fileDescriptor);
    }

    public StreamTransfer(Object obj, Context context, EventListener eventListener) {
        this.mTransferRequestMap = new ConcurrentHashMap<>();
        this.mTransactionsMap = new ConcurrentHashMap<>();
        this.mLocalCallback = new a();
        if (obj != null && eventListener != null) {
            this.mCallingAgent = obj;
            this.mContext = context;
            this.mAgentName = obj.getClass().getName();
            this.mEventListener = eventListener;
            C1371a.c(TAG, "new StreamTransfer: " + this.mAgentName + ", hashcode:" + hashCode());
            StreamInitializer.initialize(this.mContext);
            this.mStreamTransferManager = com.heytap.accessory.stream.a.i(this.mContext);
            if (register()) {
                return;
            }
            C1371a.c(TAG, "Agent already registered");
            C1441a q10 = com.heytap.accessory.stream.a.q(this.mAgentName);
            this.mCallingAgentInfo = q10;
            if (q10 != null) {
                this.mStreamTransferHandlerThread = q10.c();
                this.mHandler = (c) this.mCallingAgentInfo.b();
                this.mTransactionsMap = this.mCallingAgentInfo.e();
                this.mCallingAgentInfo.f(this.mEventListener);
                this.mCallingAgentInfo.g(this.mLocalCallback);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("StreamEventCallback parameter cannot be null");
    }

    public int send(PeerAgent peerAgent, InputStream inputStream) {
        return send(peerAgent, inputStream, (FileDescriptor) null);
    }

    public int send(PeerAgent peerAgent, FileDescriptor fileDescriptor) {
        return send(peerAgent, (InputStream) null, fileDescriptor);
    }

    private int send(PeerAgent peerAgent, InputStream inputStream, FileDescriptor fileDescriptor) {
        int c10;
        if (!validateParam(peerAgent)) {
            return -1;
        }
        if (StreamInitializer.getStreamMsgPackageName(this.mContext) == null) {
            C1371a.i(TAG, "STCore version not support content uri");
        } else if (inputStream == null && fileDescriptor == null) {
            C1371a.d(TAG, "input source is wrong!!");
            return -1;
        }
        C1441a.C0341a c0341a = new C1441a.C0341a();
        if (inputStream == null) {
            c10 = this.mStreamTransferManager.b(this.mContext, this.mAgentName, this.mLocalCallback, peerAgent, fileDescriptor);
        } else {
            c10 = this.mStreamTransferManager.c(this.mContext, this.mAgentName, this.mLocalCallback, peerAgent, inputStream);
        }
        C1371a.c(TAG, "received tx from STCore" + c10);
        c0341a.f36020b = c10;
        putTransaction(0L, c10, c0341a);
        return c10;
    }

    /* loaded from: classes3.dex */
    public class a implements b {
        public a() {
        }

        @Override // com.heytap.accessory.stream.StreamTransfer.b
        public void a(int[] iArr, int i10) {
            C1441a.C0341a c0341a;
            for (int i11 : iArr) {
                for (Long l10 : StreamTransfer.this.mTransactionsMap.keySet()) {
                    l10.longValue();
                    ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) StreamTransfer.this.mTransactionsMap.get(l10);
                    if (concurrentHashMap != null && (c0341a = (C1441a.C0341a) concurrentHashMap.get(Integer.valueOf(i11))) != null) {
                        StreamTransfer.this.removeTransactionByTransId(c0341a.f36020b);
                    }
                }
            }
            EventListener eventListener = StreamTransfer.this.mEventListener;
            if (eventListener != null) {
                StreamTransfer.this.handleOnCancelAllCompletedErrorCode(i10);
                eventListener.onCancelAllCompleted(-1, i10);
            }
        }

        @Override // com.heytap.accessory.stream.StreamTransfer.b
        public void onTransferCompleted(long j10, int i10, int i11) {
            ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) StreamTransfer.this.mTransactionsMap.get(0L);
            if (concurrentHashMap == null && (concurrentHashMap = (ConcurrentHashMap) StreamTransfer.this.mTransactionsMap.get(Long.valueOf(j10))) == null) {
                C1371a.d(StreamTransfer.TAG, "connectionId =" + j10 + "not exits");
                return;
            }
            if (((C1441a.C0341a) concurrentHashMap.get(Integer.valueOf(i10))) != null) {
                StreamTransfer.this.handleOnTransferCompletedErrorCode(i11);
                StreamTransfer.this.mEventListener.onTransferCompleted(j10, i10, i11);
                StreamTransfer.this.removeTransaction(j10, i10);
                StreamTransfer.this.removeTransactionRequest(j10, i10);
                return;
            }
            C1371a.k(StreamTransfer.TAG, "[StreamTransfer]txId:" + i10 + " not exist");
        }

        @Override // com.heytap.accessory.stream.StreamTransfer.b
        public void b(long j10, int i10) {
        }
    }
}
