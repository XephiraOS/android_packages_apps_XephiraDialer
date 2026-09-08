package com.heytap.accessory;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.heytap.accessory.api.IServiceChannelCallback;
import com.heytap.accessory.api.IServiceConnectionCallback;
import com.heytap.accessory.api.ManagerConfig;
import com.heytap.accessory.bean.GeneralException;
import com.heytap.accessory.bean.PeerAgent;
import com.heytap.accessory.bean.TrafficReport;
import com.heytap.accessory.bean.UnSupportException;
import com.heytap.accessory.constant.AFConstants;
import com.heytap.accessory.utils.buffer.BufferException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import n5.C1371a;
import r5.C1510a;
import r5.h;
import r5.j;
import s5.C1551a;

/* loaded from: classes3.dex */
public abstract class BaseSocket {
    public static final int CONNECTION_LOST_DEVICE_DETACHED = 1;
    public static final int CONNECTION_LOST_PEER_DISCONNECTED = 0;
    public static final int CONNECTION_LOST_RETRANSMISSION_FAILED = 2;
    public static final int CONNECTION_LOST_UNKNOWN_REASON = 3;
    private static final String DATA_KEY = "_";
    public static final int ERROR_CANCELLED = 20008;
    public static final int ERROR_CONNECTION_ALREADY_CLOSED = 20005;
    public static final int ERROR_FATAL = 20001;
    public static final int ERROR_INSUFFICIENT_CREDITS = 20011;
    public static final int ERROR_INTERNAL_ERROR = 20003;
    public static final int ERROR_INVALID_CHANNEL = 20006;
    public static final int ERROR_INVALID_PARAMS = 20002;
    public static final int ERROR_INVALID_SESSION = 20009;
    public static final int ERROR_PERR_PEER_STATE_UNAVAILABLE = 20010;
    public static final int ERROR_WRITE_TIMEOUT = 20007;
    public static final int SEND_SUCCESS = 0;
    private static final int SOCKET_CONNECTED = 1;
    private static final int SOCKET_DISCONNECTED = 2;
    private static final int SOCKET_FORCE_CLOSED = 3;
    private static final String TAG = "BaseSocket";
    private BaseAdapter mAdapter;
    private List<Long> mAvailableChannelIdList;
    private PeerAgent mConnectedPeer;
    private String mConnectionId;
    private b mConnectionStatusCallback;
    private int mIsConnected = 2;
    private c mSocketHandler;
    private Map<String, TrafficReport> mTrafficReportMap;

    /* loaded from: classes3.dex */
    public final class ServiceChannelCallback extends IServiceChannelCallback.Stub {
        @Override // com.heytap.accessory.api.IServiceChannelCallback
        public void w7(Bundle bundle) {
            if (bundle.containsKey("errorcode")) {
                Message obtainMessage = BaseSocket.this.mSocketHandler.obtainMessage(3);
                obtainMessage.arg1 = bundle.getInt("errorcode");
                BaseSocket.this.mSocketHandler.sendMessage(obtainMessage);
                return;
            }
            C1371a.k(BaseSocket.TAG, "onChannelError with no error code!");
        }

        @Override // com.heytap.accessory.api.IServiceChannelCallback
        public void y4(Bundle bundle) {
            long j10 = bundle.getLong(AFConstants.EXTRA_CHANNEL_ID);
            Message obtainMessage = BaseSocket.this.mSocketHandler.obtainMessage(2);
            obtainMessage.arg1 = (int) j10;
            obtainMessage.obj = bundle;
            BaseSocket.this.mSocketHandler.sendMessage(obtainMessage);
        }

        public ServiceChannelCallback() {
        }
    }

    /* loaded from: classes3.dex */
    public final class ServiceConnectionCallback extends IServiceConnectionCallback.Stub {
        @Override // com.heytap.accessory.api.IServiceConnectionCallback
        public void a2(Bundle bundle) {
            if (bundle.containsKey("errorcode")) {
                Bundle bundle2 = new Bundle();
                bundle2.putLong(AFConstants.EXTRA_CONNECTION_ID, bundle.getLong(AFConstants.EXTRA_CONNECTION_ID));
                Message obtainMessage = BaseSocket.this.mSocketHandler.obtainMessage(1);
                obtainMessage.arg1 = bundle.getInt("errorcode");
                obtainMessage.obj = bundle2;
                BaseSocket.this.mSocketHandler.sendMessage(obtainMessage);
                return;
            }
            C1371a.d(BaseSocket.TAG, "onConnectionLost with no error code!");
        }

        @Override // com.heytap.accessory.api.IServiceConnectionCallback
        public void r5(Bundle bundle) {
            Message obtainMessage = BaseSocket.this.mSocketHandler.obtainMessage(4);
            obtainMessage.arg1 = bundle.getInt("errorcode", 10012);
            obtainMessage.obj = bundle.getString(AFConstants.EXTRA_CONNECTION_ID, null);
            obtainMessage.setData(bundle);
            BaseSocket.this.mSocketHandler.sendMessage(obtainMessage);
        }

        public ServiceConnectionCallback() {
            C1371a.c(BaseSocket.TAG, "ServiceConnectionCallback new");
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(PeerAgent peerAgent, int i10);

        void a(PeerAgent peerAgent, BaseSocket baseSocket);
    }

    /* loaded from: classes3.dex */
    public static final class c extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public BaseSocket f25156a;

        public c(BaseSocket baseSocket, Looper looper) {
            super(looper);
            this.f25156a = baseSocket;
        }

        public synchronized void a() {
            super.getLooper().quit();
            this.f25156a = null;
        }

        @Override // android.os.Handler
        public synchronized void handleMessage(Message message) {
            long[] jArr;
            try {
                int i10 = message.what;
                if (i10 != 1) {
                    if (i10 == 2) {
                        this.f25156a.handleIncomingData(message.arg1, (Bundle) message.obj);
                    } else if (i10 != 4) {
                        C1371a.d(BaseSocket.TAG, "Invalid message: " + message.what);
                    } else {
                        Bundle data = message.getData();
                        if (data != null) {
                            jArr = data.getLongArray(AFConstants.EXTRA_CHANNEL_ID);
                        } else {
                            jArr = null;
                        }
                        this.f25156a.handleConnectionResponse((String) message.obj, jArr, message.arg1);
                    }
                } else {
                    Bundle bundle = (Bundle) message.obj;
                    if (bundle != null) {
                        this.f25156a.handleConnectionLoss(bundle.getLong(AFConstants.EXTRA_CONNECTION_ID), message.arg1);
                    } else {
                        C1371a.d(BaseSocket.TAG, "MESSAGE_SERVICE_CONNECTION_LOSS: (bundle==null)");
                        this.f25156a.handleConnectionLoss(0L, message.arg1);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public BaseSocket(String str) {
    }

    private void cacheTrafficReport(String str, int i10, TrafficReport trafficReport) {
        if (this.mTrafficReportMap == null) {
            this.mTrafficReportMap = new HashMap();
        }
        this.mTrafficReportMap.put(getDataKey(str, i10), trafficReport);
    }

    private boolean checkCompressedUnSupport(PeerAgent peerAgent) {
        if (peerAgent != null && peerAgent.getAccessory() != null && peerAgent.getAccessory().supportCompression()) {
            return false;
        }
        return true;
    }

    private void cleanupSocket() {
        this.mSocketHandler.removeCallbacksAndMessages(null);
        this.mSocketHandler.a();
        C1371a.c(TAG, "SocketHandler quit");
        unbindTransferServiceWhenDisconnect();
    }

    private void dispatchDataToOAF(int i10, byte[] bArr, int i11, boolean z10, int i12, boolean z11) {
        try {
            if (this.mIsConnected == 1) {
                C1551a c10 = s5.b.c(h.d() + bArr.length + i11 + h.c() + 24);
                c10.f(h.d());
                c10.a(bArr, 0, bArr.length);
                int send = this.mAdapter.send(new f(this.mConnectedPeer, this.mConnectionId, i10, c10.b(), z10, c10.d(), c10.c(), i12, z11));
                if (send != 0) {
                    if (send != 20005) {
                        if (send == 20008) {
                            C1371a.d(TAG, "write failed: user cancelled");
                            return;
                        }
                        if (send != 20006) {
                            if (send != 20007) {
                                return;
                            }
                            C1371a.d(TAG, "Write failed: Timed out!");
                            close();
                            throw new IOException("Write failed: Timed out!");
                        }
                        C1371a.d(TAG, "Write failed. Attempt to write on invalid channel:" + i10);
                        throw new IOException("Write failed. Attempt to write on invalid channel:" + i10);
                    }
                    this.mIsConnected = 2;
                    C1371a.d(TAG, "Write failed: Connection closed");
                    throw new IOException("Write failed:Connection already closed");
                }
                return;
            }
            C1371a.k(TAG, "Data send failed, connection closed!");
            throw new IOException("Failed to send, connection closed!");
        } catch (GeneralException e10) {
            C1371a.e(TAG, "Send failed!", e10);
            throw new IOException("Send Failed", e10);
        } catch (BufferException e11) {
            C1371a.d(TAG, "BufferException: " + e11.getLocalizedMessage());
        }
    }

    private static String getDataKey(String str, int i10) {
        return str + DATA_KEY + i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleConnectionLoss(long j10, int i10) {
        if (i10 == 20001) {
            this.mIsConnected = 3;
        } else {
            this.mIsConnected = 2;
        }
        onServiceConnectionLost(j10, i10);
        handleServiceConnectionLostErrorCode(i10);
        cleanupSocket();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleConnectionResponse(String str, long[] jArr, int i10) {
        if (this.mConnectionStatusCallback != null) {
            if (str == null) {
                C1371a.k(TAG, "connectionId is null so cleaning up");
                this.mConnectionStatusCallback.a(this.mConnectedPeer, i10);
                cleanupSocket();
                return;
            }
            this.mConnectionId = str;
            this.mIsConnected = 1;
            C1371a.g(TAG, "onServiceConnectionResponse:" + this.mConnectedPeer);
            this.mAvailableChannelIdList = C1510a.a(jArr);
            this.mConnectionStatusCallback.a(this.mConnectedPeer, this);
            return;
        }
        C1371a.k(TAG, "Connection status callback not found! Ignoring response");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleIncomingData(int i10, Bundle bundle) {
        if (this.mIsConnected != 1) {
            C1371a.k(TAG, "Ignoring data, socket is not yet established");
            return;
        }
        byte[] byteArray = bundle.getByteArray(AFConstants.EXTRA_READ_BYTES);
        if (byteArray == null) {
            C1371a.d(TAG, "Failed to reassemble! - null data received!");
            return;
        }
        int i11 = bundle.getInt(AFConstants.EXTRA_READ_LENGHT);
        int i12 = bundle.getInt(AFConstants.EXTRA_READ_OFFSET);
        cacheTrafficReport(this.mConnectionId, i10, TrafficReport.createFromBundle(bundle));
        if (!ManagerConfig.ACCESSORY_FRAMEWORK_PACKAGE.equals(this.mAdapter.getPackageName())) {
            C1371a.c(TAG, "handleIncomingData: " + byteArray.length + " [" + i12 + ", " + i11 + "]");
        }
        try {
            byte[] b10 = s5.b.e(i11).b();
            j.a(byteArray, i12, b10, 0, i11);
            onReceive(Long.parseLong(this.mConnectionId), i10, b10);
        } catch (Exception e10) {
            e10.printStackTrace();
        } finally {
            this.mAdapter.recycle(byteArray);
        }
    }

    private void handleServiceConnectionLostErrorCode(int i10) {
        if (i10 != 20001) {
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 != 2) {
                        if (i10 != 3) {
                            C1371a.k(TAG, "onServiceConnectionLost() error_code: " + i10);
                            return;
                        }
                        C1371a.g(TAG, "onServiceConnectionLost() -> CONNECTION_LOST_UNKNOWN_REASON");
                        return;
                    }
                    C1371a.g(TAG, "onServiceConnectionLost() -> CONNECTION_LOST_RETRANSMISSION_FAILED");
                    return;
                }
                C1371a.g(TAG, "onServiceConnectionLost() -> CONNECTION_LOST_DEVICE_DETACHED");
                return;
            }
            C1371a.g(TAG, "onServiceConnectionLost() -> CONNECTION_LOST_PEER_DISCONNECTED");
            return;
        }
        C1371a.g(TAG, "onServiceConnectionLost() -> ERROR_FATAL");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$acceptServiceConnection$1(BaseAdapter baseAdapter, String str, PeerAgent peerAgent) {
        int length;
        try {
            Bundle acceptServiceConnection = baseAdapter.acceptServiceConnection(str, peerAgent, peerAgent.getTransactionId(), new ServiceConnectionCallback(), new ServiceChannelCallback());
            String string = acceptServiceConnection.getString(AFConstants.EXTRA_CONNECTION_ID);
            long[] longArray = acceptServiceConnection.getLongArray(AFConstants.EXTRA_CHANNEL_ID);
            String str2 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("Connection accepted successfully. connection Id:");
            sb.append(string);
            sb.append(" channel Id count:");
            if (longArray == null) {
                length = 0;
            } else {
                length = longArray.length;
            }
            sb.append(length);
            C1371a.c(str2, sb.toString());
            handleConnectionResponse(string, longArray, 0);
        } catch (GeneralException e10) {
            C1371a.d(TAG, "Failed to accept service connection: " + e10.getMessage());
            handleConnectionResponse(null, null, e10.getErrorCode());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initiateServiceConnection$0(String str, PeerAgent peerAgent) {
        int errorCode;
        try {
            errorCode = this.mAdapter.requestServiceConnection(str, peerAgent, new ServiceConnectionCallback(), new ServiceChannelCallback());
        } catch (GeneralException e10) {
            C1371a.e(TAG, "Failed to initiate connection!", e10);
            errorCode = e10.getErrorCode();
        }
        if (errorCode == 0) {
            C1371a.g(TAG, "Connection request enqued successfully for peer:" + peerAgent.getAgentId());
            return;
        }
        C1371a.g(TAG, "Connection request failed for peer:" + peerAgent.getAgentId() + " Reason:" + errorCode + " Cleaning up now");
        b bVar = this.mConnectionStatusCallback;
        if (bVar != null) {
            bVar.a(peerAgent, errorCode);
        }
        cleanupSocket();
    }

    private void requestClose() {
        try {
            int closeServiceConnection = this.mAdapter.closeServiceConnection(this.mConnectionId);
            if (closeServiceConnection == 20005) {
                C1371a.g(TAG, "Connection is already closed");
            } else if (closeServiceConnection == 0) {
                C1371a.g(TAG, "Connection " + this.mConnectionId + " close requested successfully");
            }
        } catch (GeneralException e10) {
            C1371a.e(TAG, "Failed to close connection!", e10);
        }
    }

    private synchronized void sendData(int i10, byte[] bArr, int i11, int i12, boolean z10, boolean z11) {
        if (i10 >= 0) {
            if (this.mIsConnected == 1) {
                if (bArr != null && bArr.length != 0) {
                    if (bArr.length <= this.mConnectedPeer.getMaxAllowedDataSize()) {
                        dispatchDataToOAF(i10, bArr, i12, z10, i11, z11);
                    } else {
                        C1371a.d(TAG, "Data too long:" + bArr.length + " , " + this.mConnectedPeer.getMaxAllowedDataSize());
                        throw new IOException("Data Too long! size:" + bArr.length + " Max allowed Size:" + this.mConnectedPeer.getMaxAllowedDataSize() + ". check PeerAgent.getMaxAllowedDataSize()");
                    }
                } else {
                    C1371a.d(TAG, "sendData: data is null");
                    throw new IOException("Invalid data to send");
                }
            } else {
                C1371a.d(TAG, "Send failed. Socket already closed");
                throw new IOException("Send failed. Socket already closed");
            }
        } else {
            C1371a.d(TAG, "Send Failed : there is no service channel at the index");
            throw new IOException("end Failed : there is no service channel at the index");
        }
    }

    private boolean startSocketHandler(String str, String str2) {
        HandlerThread handlerThread = new HandlerThread("Socket:" + str + DATA_KEY + str2);
        String str3 = TAG;
        C1371a.c(str3, "socketHandlerThread start");
        handlerThread.start();
        Looper looper = handlerThread.getLooper();
        if (looper == null) {
            C1371a.d(str3, "Failed get Looper for Socket: initiator:" + str + " Peer Id:" + str2);
            return false;
        }
        this.mSocketHandler = new c(this, looper);
        return true;
    }

    private void unbindTransferServiceWhenDisconnect() {
        String canonicalName = getClass().getCanonicalName();
        if (this.mAdapter != null) {
            if (BaseAdapter.INTERNAL_FILE_CONSUMER.equals(canonicalName) || BaseAdapter.INTERNAL_STREAM_CONSUMER.equals(canonicalName)) {
                this.mAdapter.unbindTransferService();
            }
        }
    }

    public void acceptServiceConnection(final String str, final PeerAgent peerAgent, final BaseAdapter baseAdapter, b bVar) {
        this.mConnectedPeer = peerAgent;
        this.mAdapter = baseAdapter;
        this.mConnectionStatusCallback = bVar;
        startSocketHandler(str, peerAgent.getAgentId());
        this.mSocketHandler.post(new Runnable() { // from class: com.heytap.accessory.c
            @Override // java.lang.Runnable
            public final void run() {
                BaseSocket.this.lambda$acceptServiceConnection$1(baseAdapter, str, peerAgent);
            }
        });
    }

    public void cleanupChannel(String str, int i10) {
        try {
            this.mAdapter.cleanupChannel(str, i10);
        } catch (GeneralException e10) {
            C1371a.e(TAG, "cleanupChannel failed." + i10, e10);
        }
    }

    public void close() {
        if (this.mIsConnected == 1) {
            this.mIsConnected = 2;
            C1371a.g(TAG, this.mAdapter.getPackageName() + " requested to close socket for Peer:" + this.mConnectedPeer.getAgentId());
            requestClose();
            return;
        }
        C1371a.g(TAG, "Connection is already closed");
    }

    public void forceClose() {
        if (this.mIsConnected == 1) {
            this.mIsConnected = 3;
            Message obtainMessage = this.mSocketHandler.obtainMessage(1);
            obtainMessage.arg1 = 20001;
            Bundle bundle = new Bundle();
            try {
                bundle.putLong(AFConstants.EXTRA_CONNECTION_ID, Long.parseLong(this.mConnectionId));
            } catch (NumberFormatException e10) {
                C1371a.m(TAG, e10);
            }
            obtainMessage.obj = bundle;
            this.mSocketHandler.sendMessage(obtainMessage);
            C1371a.g(TAG, "Socket:" + this.mConnectionId + " has been force closed!");
        }
    }

    public long getConnectedAccessoryId() {
        return getConnectedPeerAgent().getAccessoryId();
    }

    public PeerAgent getConnectedPeerAgent() {
        return this.mConnectedPeer;
    }

    public String getConnectionId() {
        return this.mConnectionId;
    }

    public int getServiceChannelId(int i10) {
        if (this.mAvailableChannelIdList == null) {
            C1371a.d(TAG, "Failed because mAvailableChannelIdList is null");
            return -1;
        }
        if (i10 >= 0 && i10 < getServiceChannelSize()) {
            return this.mAvailableChannelIdList.get(i10).intValue();
        }
        C1371a.d(TAG, "Failed because of wrong index");
        return -1;
    }

    public int getServiceChannelSize() {
        List<Long> list = this.mAvailableChannelIdList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public TrafficReport getTrafficReport(String str, int i10) {
        if (this.mTrafficReportMap == null) {
            return null;
        }
        return this.mTrafficReportMap.get(getDataKey(str, i10));
    }

    public void initiateServiceConnection(final String str, final PeerAgent peerAgent, BaseAdapter baseAdapter, b bVar) {
        this.mConnectedPeer = peerAgent;
        this.mConnectionStatusCallback = bVar;
        this.mAdapter = baseAdapter;
        startSocketHandler(str, peerAgent.getAgentId());
        this.mSocketHandler.post(new Runnable() { // from class: com.heytap.accessory.b
            @Override // java.lang.Runnable
            public final void run() {
                BaseSocket.this.lambda$initiateServiceConnection$0(str, peerAgent);
            }
        });
    }

    public boolean isConnected() {
        if (this.mIsConnected == 1) {
            return true;
        }
        return false;
    }

    public abstract void onError(int i10, String str, int i11);

    public abstract void onReceive(long j10, int i10, byte[] bArr);

    public abstract void onServiceConnectionLost(long j10, int i10);

    public synchronized void secureSend(int i10, byte[] bArr) {
        C1371a.c(TAG, "secureSend:" + bArr.length + " bytes");
        sendData(i10, bArr, 2, getConnectedPeerAgent().getAccessory().getEncryptionPaddingLength(), true, false);
    }

    public void send(int i10, byte[] bArr) {
        sendData(i10, bArr, 3, 0, false, false);
    }

    public void sendAlign(int i10, byte[] bArr) {
        sendData(i10, bArr, 1, 0, false, true);
    }

    public void sendCompressed(int i10, byte[] bArr) {
        if (!checkCompressedUnSupport(getConnectedPeerAgent())) {
            sendData(i10, bArr, 1, 0, false, false);
        } else {
            C1371a.g(TAG, "current peer is note supported compression");
            throw new UnSupportException("the peer agent doesn't support the compression feature, please check");
        }
    }

    public void sendUncompressed(int i10, byte[] bArr) {
        sendData(i10, bArr, 2, 0, false, false);
    }

    public void send(int i10, C1551a c1551a) {
        sendData(i10, c1551a, 3, false);
    }

    public void sendAlign(int i10, C1551a c1551a) {
        sendData(i10, c1551a, 3, true);
    }

    public void sendUncompressed(int i10, C1551a c1551a) {
        sendData(i10, c1551a, 2, false);
    }

    public void sendCompressed(int i10, C1551a c1551a) {
        sendData(i10, c1551a, 1, false);
    }

    private void sendData(int i10, C1551a c1551a, int i11, boolean z10) {
        if (i10 >= 0) {
            if (c1551a != null && c1551a.b().length != 0) {
                if (c1551a.b().length <= this.mConnectedPeer.getMaxAllowedDataSize()) {
                    if (this.mIsConnected == 1) {
                        try {
                            int send = this.mAdapter.send(new f(this.mConnectedPeer, this.mConnectionId, i10, c1551a.b(), false, c1551a.d(), c1551a.c(), i11, z10));
                            if (send != 0) {
                                if (send == 20005) {
                                    this.mIsConnected = 2;
                                    C1371a.d(TAG, "Write failed: Connection closed");
                                    throw new IOException("Write failed:Connection already closed");
                                }
                                if (send == 20006) {
                                    C1371a.d(TAG, "Write failed. Attempt to write on invalid channel:" + i10);
                                    throw new IOException("Write failed. Attempt to write on invalid channel:" + i10);
                                }
                                if (send != 20007) {
                                    C1371a.d(TAG, "Write failed. status:" + send);
                                    return;
                                }
                                C1371a.d(TAG, "Write failed: Timed out!");
                                close();
                                throw new IOException("Write failed: Timed out!");
                            }
                            return;
                        } catch (GeneralException e10) {
                            C1371a.e(TAG, "Send failed!", e10);
                            throw new IOException("Send Failed", e10);
                        }
                    }
                    throw new IOException("Send failed. AF Socket already closed");
                }
                C1371a.d(TAG, "Data too long:" + c1551a.b().length);
                throw new IOException("Data Too long! size:" + c1551a.b().length + " Max allowed Size:" + this.mConnectedPeer.getMaxAllowedDataSize() + ". check PeerAgent.getMaxAllowedDataSize()");
            }
            C1371a.d(TAG, "sendData: data is null");
            throw new IOException("Invalid data to send");
        }
        C1371a.d(TAG, "Send Failed : there is no service channel at the index");
        throw new IOException("invalid channelId:" + i10);
    }
}
