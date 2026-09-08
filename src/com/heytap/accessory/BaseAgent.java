package com.heytap.accessory;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.heytap.accessory.BaseAdapter;
import com.heytap.accessory.BaseSocket;
import com.heytap.accessory.api.IPeerAgentAuthCallback;
import com.heytap.accessory.api.IPeerAgentCallback;
import com.heytap.accessory.bean.AuthenticationToken;
import com.heytap.accessory.bean.GeneralException;
import com.heytap.accessory.bean.PeerAccessory;
import com.heytap.accessory.bean.PeerAgent;
import com.heytap.accessory.bean.SdkUnsupportedException;
import com.heytap.accessory.bean.ServiceProfile;
import com.heytap.accessory.constant.AFConstants;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import n5.C1371a;

/* loaded from: classes3.dex */
public abstract class BaseAgent extends Service {
    public static final int AUTHENTICATION_FAILURE_PEER_AGENT_NOT_SUPPORTED = 10015;
    public static final int AUTHENTICATION_FAILURE_TOKEN_NOT_GENERATED = 10014;
    public static final int AUTHENTICATION_SUCCESS = 0;
    public static final int CONNECTION_ALREADY_EXIST = 10005;
    public static final int CONNECTION_DUPLICATE_REQUEST = 10009;
    public static final int CONNECTION_FAILURE_ACC_DORMANT = 10018;
    public static final int CONNECTION_FAILURE_CHANNELID_MISMATCH = 10011;
    public static final int CONNECTION_FAILURE_DEVICE_UNREACHABLE = 10004;
    public static final int CONNECTION_FAILURE_INVALID_PEERAGENT = 10008;
    public static final int CONNECTION_FAILURE_LOCAL_AGENT_NOT_FOUND = 10017;
    public static final int CONNECTION_FAILURE_NETWORK = 10012;
    public static final int CONNECTION_FAILURE_PEERAGENT_NO_RESPONSE = 10006;
    public static final int CONNECTION_FAILURE_PEERAGENT_REJECTED = 10007;
    public static final int CONNECTION_FAILURE_SERVICE_LIMIT_REACHED = 10010;
    public static final int CONNECTION_SUCCESS = 0;
    private static final int DEFAULT_GET_AGENT_ID_RETRY_COUNT = 2;
    public static final int ERROR_CONNECTION_INVALID_PARAM = 10013;
    public static final int ERROR_FATAL = 20001;
    public static final int ERROR_PERMISSION_DENIED = 20003;
    public static final int ERROR_PERMISSION_FAILED = 20004;
    public static final int ERROR_SDK_NOT_INITIALIZED = 20002;
    public static final int FIND_PEER_DEVICE_NOT_CONNECTED = 10001;
    public static final int FIND_PEER_DUPLICATE_REQUEST = 10003;
    public static final int FIND_PEER_SERVICE_NOT_FOUND = 10002;
    public static final int FIND_PEER_TIMEOUT = 10010;
    public static final int ON_PEER_INSTALLED = 0;
    public static final int ON_PEER_UNINSTALLED = 1;
    public static final int PEER_AGENT_AVAILABLE = 1;
    public static final int PEER_AGENT_FOUND = 0;
    public static final int PEER_AGENT_UNAVAILABLE = 2;
    public static final int SERVICE_RECORD_NOT_FOUND = 10016;
    private static final String TAG = "BaseAgent";
    BaseAdapter mAdapter;
    private b mAgentCallback;
    private String mAgentId;
    c mBackgroundWorker;
    private d mConnectionCallback;
    private BaseMessage mMessage;
    private String mName;
    private PeerAgentCallback mPeerAgentCallback;
    private AuthenticationCallback mPeerAuthCallback;
    private Set<PeerAgent> mPendingRequests;
    private Class<? extends BaseSocket> mSocketImpl;
    private List<BaseSocket> mSuccessfulConnections;
    private ServiceProfile mServiceProfile = null;
    private int mGetAgentIdRetryCount = 0;

    /* loaded from: classes3.dex */
    public class AuthenticationCallback extends IPeerAgentAuthCallback.Stub {
        @Override // com.heytap.accessory.api.IPeerAgentAuthCallback
        public void T5(Bundle bundle) {
            C1371a.i(BaseAgent.TAG, "Received Authentication response");
            c cVar = BaseAgent.this.mBackgroundWorker;
            if (cVar != null) {
                Message obtainMessage = cVar.obtainMessage(10);
                obtainMessage.setData(bundle);
                BaseAgent.this.mBackgroundWorker.sendMessage(obtainMessage);
                return;
            }
            C1371a.k(BaseAgent.TAG, "onPeerAgentAuthenticated: mBackgroundWorker is null!");
        }

        private AuthenticationCallback() {
        }
    }

    /* loaded from: classes3.dex */
    public class PeerAgentCallback extends IPeerAgentCallback.Stub {
        @Override // com.heytap.accessory.api.IPeerAgentCallback
        public void H7(Bundle bundle) {
            C1371a.i(BaseAgent.TAG, "Received peer agent update");
            bundle.setClassLoader(PeerAgent.class.getClassLoader());
            if (!bundle.containsKey(AFConstants.EXTRA_PEER_AGENTS)) {
                C1371a.d(BaseAgent.TAG, "No peer agents in PeerAgent update callback!");
                return;
            }
            ArrayList<PeerAgent> parcelableArrayList = bundle.getParcelableArrayList(AFConstants.EXTRA_PEER_AGENTS);
            int i10 = bundle.getInt(AFConstants.EXTRA_PEER_AGENT_STATUS);
            if (parcelableArrayList == null) {
                C1371a.d(BaseAgent.TAG, "Peer Update - invalid peer agent list from Accessory Framework");
                return;
            }
            if (i10 == 0 || i10 == 1) {
                C1371a.g(BaseAgent.TAG, parcelableArrayList.size() + " Peer agent(s) updated for:" + getClass().getName());
                for (PeerAgent peerAgent : parcelableArrayList) {
                    C1371a.g(BaseAgent.TAG, "Peer ID:" + peerAgent.getAgentId() + "Container Id:" + peerAgent.getAppName() + " Accessory" + peerAgent.getAccessory().getPeerId());
                }
                c cVar = BaseAgent.this.mBackgroundWorker;
                if (cVar != null) {
                    Message obtainMessage = cVar.obtainMessage();
                    obtainMessage.what = 4;
                    if (i10 == 0) {
                        obtainMessage.arg1 = 1;
                    } else {
                        obtainMessage.arg1 = 2;
                    }
                    obtainMessage.obj = parcelableArrayList.toArray(new PeerAgent[0]);
                    BaseAgent.this.mBackgroundWorker.sendMessage(obtainMessage);
                    return;
                }
                C1371a.k(BaseAgent.TAG, "onPeerAgentUpdated: mBackgroundWorker is null!");
                return;
            }
            C1371a.d(BaseAgent.TAG, "Peer Update - invalid peer status from Accessory Framework:" + i10);
        }

        @Override // com.heytap.accessory.api.IPeerAgentCallback
        public void T2(Bundle bundle) {
            C1371a.i(BaseAgent.TAG, "FindPeer response received.");
            bundle.setClassLoader(PeerAgent.class.getClassLoader());
            if (bundle.containsKey("errorcode")) {
                int i10 = bundle.getInt("errorcode");
                C1371a.d(BaseAgent.TAG, "Peer Not Found(" + i10 + ") for: " + getClass().getName());
                c cVar = BaseAgent.this.mBackgroundWorker;
                if (cVar != null) {
                    Message obtainMessage = cVar.obtainMessage();
                    obtainMessage.what = 3;
                    obtainMessage.arg1 = i10;
                    BaseAgent.this.mBackgroundWorker.sendMessage(obtainMessage);
                    return;
                }
                C1371a.k(BaseAgent.TAG, "onPeersAgentsFound: mBackgroundWorker is null!");
                return;
            }
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(AFConstants.EXTRA_PEER_AGENTS);
            if (parcelableArrayList != null) {
                C1371a.g(BaseAgent.TAG, parcelableArrayList.size() + " Peer agent(s) found for:" + getClass().getName());
                C1371a.g(BaseAgent.TAG, "Peer agent(s) " + parcelableArrayList);
                c cVar2 = BaseAgent.this.mBackgroundWorker;
                if (cVar2 != null) {
                    Message obtainMessage2 = cVar2.obtainMessage();
                    obtainMessage2.what = 3;
                    obtainMessage2.arg1 = 0;
                    obtainMessage2.obj = parcelableArrayList.toArray(new PeerAgent[parcelableArrayList.size()]);
                    BaseAgent.this.mBackgroundWorker.sendMessage(obtainMessage2);
                    return;
                }
                C1371a.k(BaseAgent.TAG, "onPeerAgentsFound: mBackgroundWorker is null!");
                return;
            }
            C1371a.d(BaseAgent.TAG, "Find Peer - invalid response from Accessory Framework");
        }

        private PeerAgentCallback() {
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements BaseAdapter.d {

        /* renamed from: a, reason: collision with root package name */
        public BaseAgent f25136a;

        public b(BaseAgent baseAgent) {
            this.f25136a = baseAgent;
        }

        @Override // com.heytap.accessory.BaseAdapter.d
        public void a() {
            c cVar = this.f25136a.mBackgroundWorker;
            if (cVar != null) {
                cVar.sendEmptyMessage(14);
            } else {
                C1371a.k(BaseAgent.TAG, "onAgentRegistered: mBackgroundWorker is null!");
            }
        }

        @Override // com.heytap.accessory.BaseAdapter.d
        public void b() {
            try {
                this.f25136a.registerMexAgent();
            } catch (GeneralException e10) {
                C1371a.d(BaseAgent.TAG, "onFrameworkConnected() - Failed to register agent with message! " + e10.getMessage());
            }
        }

        @Override // com.heytap.accessory.BaseAdapter.d
        public void c() {
            c cVar = this.f25136a.mBackgroundWorker;
            if (cVar != null) {
                Message obtainMessage = cVar.obtainMessage(11);
                obtainMessage.arg1 = 20001;
                this.f25136a.mBackgroundWorker.sendMessage(obtainMessage);
                return;
            }
            C1371a.k(BaseAgent.TAG, "onFrameworkDisconnected: mBackgroundWorker is null!");
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public BaseAgent f25137a;

        public c(BaseAgent baseAgent, Looper looper) {
            super(looper);
            this.f25137a = baseAgent;
        }

        public void a() {
            getLooper().quit();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            PeerAgent peerAgent;
            PeerAgent peerAgent2 = null;
            switch (message.what) {
                case 0:
                    try {
                        this.f25137a.bindToFramework();
                        return;
                    } catch (GeneralException e10) {
                        C1371a.e(BaseAgent.TAG, "Binding to Accessory Framework failed", e10);
                        this.f25137a.handleError(e10.getErrorCode(), null);
                        return;
                    }
                case 1:
                    this.f25137a.registerService();
                    return;
                case 2:
                    this.f25137a.requestPeerAgents();
                    return;
                case 3:
                    int i10 = message.arg1;
                    if (i10 == 0) {
                        BaseAgent baseAgent = this.f25137a;
                        if (baseAgent instanceof NativeAgent) {
                            ((NativeAgent) baseAgent).b(i10, Arrays.asList((PeerAgent[]) message.obj));
                            return;
                        } else {
                            baseAgent.onFindPeerAgentsResponse((PeerAgent[]) message.obj, 0);
                            this.f25137a.handleFindPeerErrorCode(0);
                            return;
                        }
                    }
                    this.f25137a.onFindPeerAgentsResponse(null, i10);
                    this.f25137a.handleFindPeerErrorCode(message.arg1);
                    return;
                case 4:
                    this.f25137a.onPeerAgentsUpdated((PeerAgent[]) message.obj, message.arg1);
                    this.f25137a.handlePeerAgentUpdateErrorCode(message.arg1);
                    return;
                case 5:
                    this.f25137a.notifyConnectionRequest((Intent) message.obj);
                    return;
                case 6:
                    this.f25137a.requestConnection((PeerAgent) message.obj);
                    return;
                case 7:
                    this.f25137a.acceptServiceConnectionInternal((PeerAgent) message.obj);
                    return;
                case 8:
                    this.f25137a.rejectServiceConnectionInternal((PeerAgent) message.obj);
                    return;
                case 9:
                    this.f25137a.requestPeerAuthInternal((PeerAgent) message.obj);
                    return;
                case 10:
                    this.f25137a.handleAuthResponse(message.getData());
                    return;
                case 11:
                    Object obj = message.obj;
                    if (obj instanceof PeerAgent) {
                        peerAgent2 = (PeerAgent) obj;
                    }
                    this.f25137a.handleError(message.arg1, peerAgent2);
                    return;
                case 12:
                    Object obj2 = message.obj;
                    if (obj2 instanceof PeerAgent) {
                        peerAgent = (PeerAgent) obj2;
                    } else {
                        peerAgent = null;
                    }
                    this.f25137a.onServiceConnectionResponse(peerAgent, null, message.arg1);
                    this.f25137a.handleServiceConnectionErrorCode(message.arg1);
                    return;
                case 13:
                    this.f25137a.cleanup();
                    return;
                case 14:
                    try {
                        this.f25137a.loadAgentId();
                        return;
                    } catch (GeneralException e11) {
                        C1371a.e(BaseAgent.TAG, "Retrieving agent id failed", e11);
                        this.f25137a.handleError(e11.getErrorCode(), null);
                        return;
                    }
                case 15:
                    this.f25137a.handleAccessoryStatusChanged((Intent) message.obj);
                    return;
                default:
                    C1371a.k(BaseAgent.TAG, "Invalid msg received: " + message.what);
                    return;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements BaseSocket.b {
        @Override // com.heytap.accessory.BaseSocket.b
        public void a(PeerAgent peerAgent, BaseSocket baseSocket) {
            BaseAgent.this.mSuccessfulConnections.add(baseSocket);
            C1371a.c(BaseAgent.TAG, "Connection success with peer:" + peerAgent.getAgentId());
            BaseAgent.this.onServiceConnectionResponse(peerAgent, baseSocket, 0);
            BaseAgent.this.handleServiceConnectionErrorCode(0);
        }

        private d() {
        }

        @Override // com.heytap.accessory.BaseSocket.b
        public void a(PeerAgent peerAgent, int i10) {
            if (i10 == 20001) {
                C1371a.k(BaseAgent.TAG, "Framework disconnected during connection process!");
                BaseAgent.this.handleError(i10, peerAgent);
                return;
            }
            c cVar = BaseAgent.this.mBackgroundWorker;
            if (cVar != null) {
                if (i10 == 10017) {
                    BaseAgent.this.mBackgroundWorker.sendMessage(cVar.obtainMessage(1));
                    i10 = 10008;
                }
                C1371a.d(BaseAgent.TAG, "Connection attempt failed wih peer:" + peerAgent.getAgentId() + " reason:" + i10);
                Message obtainMessage = BaseAgent.this.mBackgroundWorker.obtainMessage(12);
                obtainMessage.arg1 = i10;
                obtainMessage.obj = peerAgent;
                BaseAgent.this.mBackgroundWorker.sendMessage(obtainMessage);
                return;
            }
            C1371a.k(BaseAgent.TAG, "onConnectionFailure: mBackgroundWorker is null!");
        }
    }

    public BaseAgent(String str) {
        this.mName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acceptServiceConnectionInternal(PeerAgent peerAgent) {
        String localAgentId = getLocalAgentId();
        if (localAgentId == null) {
            handleError(20001, peerAgent);
        } else {
            instantiateSocket().acceptServiceConnection(localAgentId, peerAgent, this.mAdapter, this.mConnectionCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindToFramework() {
        this.mAdapter.registerAgentCallback(this.mAgentCallback);
        this.mAdapter.bindToFramework();
        loadAgentId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cleanup() {
        C1371a.k(TAG, "Performing agent cleanup");
        cleanupConnections(false);
        String localAgentId = getLocalAgentId();
        if (localAgentId != null) {
            this.mAdapter.cleanupAgent(localAgentId);
        }
        this.mAdapter.unregisterAgentCallback(this.mAgentCallback);
        BaseMessage baseMessage = this.mMessage;
        if (baseMessage != null) {
            baseMessage.unregisterAgent();
        }
        c cVar = this.mBackgroundWorker;
        if (cVar != null) {
            cVar.a();
            this.mBackgroundWorker = null;
        }
    }

    private void cleanupConnections(boolean z10) {
        synchronized (this.mSuccessfulConnections) {
            try {
                for (BaseSocket baseSocket : this.mSuccessfulConnections) {
                    if (z10) {
                        baseSocket.forceClose();
                    } else {
                        baseSocket.close();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.mSuccessfulConnections.clear();
        Initializer.clearSdkConfig();
    }

    private synchronized void fetchServiceProfile() {
        try {
            r5.e c10 = r5.e.c(getApplicationContext());
            if (c10 != null) {
                ServiceProfile b10 = c10.b(getClass().getName());
                this.mServiceProfile = b10;
                if (b10 == null) {
                    C1371a.d(TAG, "fetch service profile description failed !!");
                }
            } else {
                C1371a.d(TAG, "config  util defualt instance  creation failed !!");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void handleAccessoryStatusChanged(Intent intent) {
        intent.getIntExtra("accessoryStatus", 0);
    }

    private void handleAuthErrorCode(int i10) {
        if (i10 != 0) {
            if (i10 != 10014) {
                if (i10 != 10015) {
                    C1371a.k(TAG, "onAuthenticationResponse() errorCode: " + i10);
                    return;
                }
                C1371a.g(TAG, "onAuthenticationResponse() -> AUTHENTICATION_FAILURE_PEER_AGENT_NOT_SUPPORTED");
                return;
            }
            C1371a.g(TAG, "onAuthenticationResponse() -> AUTHENTICATION_FAILURE_TOKEN_NOT_GENERATED");
            return;
        }
        C1371a.g(TAG, "onAuthenticationResponse() -> AUTHENTICATION_SUCCESS");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAuthResponse(Bundle bundle) {
        int i10;
        bundle.setClassLoader(PeerAgent.class.getClassLoader());
        byte[] byteArray = bundle.getByteArray(AFConstants.EXTRA_PEER_AUTH_KEY);
        int i11 = bundle.getInt(AFConstants.EXTRA_CERTIFICATE_TYPE);
        PeerAgent peerAgent = (PeerAgent) bundle.getParcelable("peerAgent");
        long j10 = bundle.getLong("transactionId");
        if (peerAgent == null) {
            C1371a.d(TAG, "Invalid response from framework! No peer agent in auth response.Ignoring response");
            return;
        }
        peerAgent.setTransactionId(j10);
        if (byteArray == null) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("Authentication failed error:");
            i10 = 10014;
            sb.append(10014);
            sb.append(" Peer Id:");
            sb.append(peerAgent.getAgentId());
            C1371a.d(str, sb.toString());
        } else {
            String str2 = TAG;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Authentication success status: ");
            i10 = 0;
            sb2.append(0);
            sb2.append(" for peer: ");
            sb2.append(peerAgent.getAgentId());
            C1371a.g(str2, sb2.toString());
        }
        onAuthenticationResponse(peerAgent, new AuthenticationToken(i11, byteArray), i10);
        handleAuthErrorCode(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleFindPeerErrorCode(int i10) {
        if (i10 != 0) {
            switch (i10) {
                case 10001:
                    C1371a.g(TAG, "onFindPeerAgentsResponse() -> FIND_PEER_DEVICE_NOT_CONNECTED");
                    return;
                case 10002:
                    C1371a.g(TAG, "onFindPeerAgentsResponse() -> FIND_PEER_SERVICE_NOT_FOUND");
                    return;
                case 10003:
                    C1371a.g(TAG, "onFindPeerAgentsResponse() -> FIND_PEER_DUPLICATE_REQUEST");
                    return;
                default:
                    C1371a.k(TAG, "onFindPeerAgentsResponse() errorCode: " + i10);
                    return;
            }
        }
        C1371a.g(TAG, "onFindPeerAgentsResponse() -> PEER_AGENT_FOUND");
    }

    private void handleInvalidPeerAction(PeerAgent peerAgent) {
        synchronized (this.mPendingRequests) {
            try {
                Iterator<PeerAgent> it = this.mPendingRequests.iterator();
                while (it.hasNext()) {
                    rejectServiceConnectionInternal(it.next());
                }
                c cVar = this.mBackgroundWorker;
                if (cVar != null) {
                    Message obtainMessage = cVar.obtainMessage(11);
                    obtainMessage.arg1 = 10008;
                    obtainMessage.obj = peerAgent;
                    this.mBackgroundWorker.sendMessage(obtainMessage);
                } else {
                    C1371a.k(TAG, "handle Invalid PeerAction: mBackgroundWorker is null!");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void handleOnErrorCode(int i10) {
        if (i10 != 10013) {
            switch (i10) {
                case 20001:
                    C1371a.g(TAG, "onError() -> ERROR_FATAL");
                    return;
                case 20002:
                    C1371a.g(TAG, "onError() -> ERROR_SDK_NOT_INITIALIZED");
                    return;
                case 20003:
                    C1371a.g(TAG, "onError() -> ERROR_PERMISSION_DENIED");
                    return;
                case ERROR_PERMISSION_FAILED /* 20004 */:
                    C1371a.g(TAG, "onError() -> ERROR_PERMISSION_FAILED");
                    return;
                default:
                    C1371a.k(TAG, "onError() errorCode: " + i10);
                    return;
            }
        }
        C1371a.g(TAG, "onError() -> ERROR_CONNECTION_INVALID_PARAM");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlePeerAgentUpdateErrorCode(int i10) {
        if (i10 != 1) {
            if (i10 != 2) {
                C1371a.k(TAG, "onPeerAgentUpdated() errorCode: " + i10);
                return;
            }
            C1371a.g(TAG, "onPeerAgentUpdated() -> PEER_AGENT_UNAVAILABLE");
            return;
        }
        C1371a.g(TAG, "onPeerAgentUpdated() -> PEER_AGENT_AVAILABLE");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleServiceConnectionErrorCode(int i10) {
        if (i10 != 0) {
            if (i10 != 10012) {
                if (i10 != 10018) {
                    switch (i10) {
                        case 10004:
                            C1371a.g(TAG, "onServiceConnectionResponse() -> CONNECTION_FAILURE_DEVICE_UNREACHABLE");
                            return;
                        case 10005:
                            C1371a.g(TAG, "onServiceConnectionResponse() -> CONNECTION_ALREADY_EXIST");
                            return;
                        case 10006:
                            C1371a.g(TAG, "onServiceConnectionResponse() -> CONNECTION_FAILURE_PEERAGENT_NO_RESPONSE");
                            return;
                        case 10007:
                            C1371a.g(TAG, "onServiceConnectionResponse() -> CONNECTION_FAILURE_PEERAGENT_REJECTED");
                            return;
                        case 10008:
                            C1371a.g(TAG, "onServiceConnectionResponse() -> CONNECTION_FAILURE_INVALID_PEER_AGENT");
                            return;
                        case 10009:
                            C1371a.g(TAG, "onServiceConnectionResponse() -> CONNECTION_DUPLICATE_REQUEST");
                            return;
                        case 10010:
                            C1371a.g(TAG, "onServiceConnectionResponse() -> CONNECTION_FAILURE_SERVICE_LIMIT_REACHED");
                            return;
                        default:
                            C1371a.k(TAG, "onServiceConnectionResponse() errorCode: " + i10);
                            return;
                    }
                }
                C1371a.g(TAG, "onServiceConnectionResponse() -> CONNECTION_FAILURE_ACC_DORMANT");
                return;
            }
            C1371a.g(TAG, "onServiceConnectionResponse() -> CONNECTION_FAILURE_NETWORK");
            return;
        }
        C1371a.g(TAG, "onServiceConnectionResponse() -> CONNECTION_SUCCESS");
    }

    private BaseSocket instantiateSocket() {
        validateSocketImplementation(this.mSocketImpl);
        try {
            C1371a.c(TAG, "Instantiating BaseSocket: " + this.mSocketImpl.getName());
            if (!Modifier.toString(this.mSocketImpl.getModifiers()).contains("static") && this.mSocketImpl.getEnclosingClass() != null && BaseAgent.class.isAssignableFrom(this.mSocketImpl.getEnclosingClass())) {
                Class<? extends BaseSocket> cls = this.mSocketImpl;
                Constructor<? extends BaseSocket> declaredConstructor = cls.getDeclaredConstructor(cls.getEnclosingClass());
                declaredConstructor.setAccessible(true);
                return declaredConstructor.newInstance(this);
            }
            Constructor<? extends BaseSocket> declaredConstructor2 = this.mSocketImpl.getDeclaredConstructor(null);
            declaredConstructor2.setAccessible(true);
            return declaredConstructor2.newInstance(null);
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | InvocationTargetException e10) {
            C1371a.d(TAG, "Invalid implementation of BaseSocket. Provider a public default constructor." + e10.getClass().getSimpleName() + " " + e10.getMessage());
            throw new RuntimeException("Invalid implementation of BaseSocket. Provider a public default constructor.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAgentId() {
        String localAgentId = getLocalAgentId();
        if (localAgentId == null) {
            handleError(20001, null);
            return;
        }
        SharedPreferences.Editor edit = createDeviceProtectedStorageContext().getSharedPreferences("AccessoryPreferences", 0).edit();
        edit.putString(localAgentId, getClass().getName());
        edit.putString(getClass().getName(), localAgentId);
        C1371a.c(TAG, "save AgentId className:" + getClass().getName() + ",agentId: " + localAgentId);
        edit.apply();
        this.mAgentId = localAgentId;
        registerMexAgent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyConnectionRequest(Intent intent) {
        if (intent == null) {
            C1371a.d(TAG, "Invalid service connection indication.Intent:null.Ignoring reqeuset");
            return;
        }
        long longExtra = intent.getLongExtra("transactionId", 0L);
        PeerAgent peerAgent = (PeerAgent) intent.getParcelableExtra("peerAgent");
        String stringExtra = intent.getStringExtra(AFConstants.EXTRA_AGENT_ID);
        if (peerAgent == null) {
            C1371a.d(TAG, "Invalid initiator peer agent: null. Ignoring connection request");
            return;
        }
        if (stringExtra == null) {
            C1371a.d(TAG, "Invalid local agentId,Ignoring connection request");
            return;
        }
        peerAgent.setTransactionId(longExtra);
        C1371a.g(TAG, "Connection initiated by peer: " + peerAgent.getAgentId() + " on Accessory: " + peerAgent.getAccessory().getPeerId() + " Transaction: " + longExtra);
        this.mPendingRequests.add(peerAgent);
        onServiceConnectionRequested(peerAgent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerMexAgent() {
        String str;
        BaseMessage baseMessage = this.mMessage;
        if (baseMessage != null && (str = this.mAgentId) != null) {
            baseMessage.registerAgent(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerService() {
        e eVar = new e(getApplicationContext());
        Future<Void> e10 = eVar.e();
        eVar.f();
        try {
            e10.get();
        } catch (InterruptedException unused) {
            C1371a.d(TAG, "Regisration failed! : InterruptedException");
        } catch (ExecutionException unused2) {
            C1371a.d(TAG, "Registration failed! : ExecutionException");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rejectServiceConnectionInternal(PeerAgent peerAgent) {
        String localAgentId = getLocalAgentId();
        if (localAgentId == null) {
            handleError(20001, peerAgent);
            return;
        }
        try {
            this.mAdapter.rejectServiceConnection(localAgentId, peerAgent, peerAgent.getTransactionId());
        } catch (GeneralException e10) {
            C1371a.e(TAG, "Failed to reject Service connection!", e10);
            handleError(e10.getErrorCode(), peerAgent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestConnection(PeerAgent peerAgent) {
        String localAgentId = getLocalAgentId();
        if (localAgentId == null) {
            C1371a.d(TAG, "Failed to retrieve service description.Ignoring service connection request");
            handleError(20001, peerAgent);
        } else {
            instantiateSocket().initiateServiceConnection(localAgentId, peerAgent, this.mAdapter, this.mConnectionCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestPeerAgents() {
        String localAgentId = getLocalAgentId();
        if (localAgentId == null) {
            C1371a.k(TAG, "getLocalAgentId failed!");
            onFindPeerAgentsResponse(null, 10004);
            return;
        }
        try {
            int findPeerAgents = this.mAdapter.findPeerAgents(localAgentId, this.mPeerAgentCallback);
            if (findPeerAgents == 0) {
                C1371a.c(TAG, "Find peer request successfully enqueued.");
            } else {
                C1371a.k(TAG, "Find peer request failed:" + findPeerAgents + " for service " + getClass().getName());
                onFindPeerAgentsResponse(null, findPeerAgents);
                handleFindPeerErrorCode(findPeerAgents);
            }
        } catch (GeneralException e10) {
            C1371a.d(TAG, "Find Peer request failed!");
            handleError(e10.getErrorCode(), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestPeerAuthInternal(PeerAgent peerAgent) {
        String localAgentId = getLocalAgentId();
        if (localAgentId == null) {
            handleError(20001, peerAgent);
            return;
        }
        try {
            int authenticatePeeragent = this.mAdapter.authenticatePeeragent(localAgentId, peerAgent, this.mPeerAuthCallback, peerAgent.getTransactionId());
            if (authenticatePeeragent == 0) {
                C1371a.g(TAG, "Auth. request for peer: " + peerAgent.getAgentId() + " done successfully");
            } else {
                C1371a.d(TAG, "Auth. request for peer: " + peerAgent.getAgentId() + " failed as reason: " + authenticatePeeragent);
                onAuthenticationResponse(peerAgent, null, authenticatePeeragent);
                handleAuthErrorCode(authenticatePeeragent);
            }
        } catch (GeneralException e10) {
            C1371a.e(TAG, "Failed to request peer authentication!", e10);
            handleError(e10.getErrorCode(), peerAgent);
        }
    }

    private void validateSocketImplementation(Class<? extends BaseSocket> cls) {
        try {
            if (!Modifier.toString(cls.getModifiers()).contains("static") && cls.getEnclosingClass() != null) {
                cls.getDeclaredConstructor(cls.getEnclosingClass());
            } else {
                cls.getDeclaredConstructor(null);
            }
        } catch (NoSuchMethodException e10) {
            C1371a.e(TAG, "exception: " + e10.getMessage(), e10);
            throw new RuntimeException("Invalid implemetation of BaseSocket. Provider a public default constructor in the implementation class.");
        }
    }

    public void acceptServiceConnectionRequest(PeerAgent peerAgent) {
        try {
            Initializer.initBufferPool(getApplicationContext());
            if (this.mPendingRequests.remove(peerAgent)) {
                String str = TAG;
                C1371a.g(str, "Trying to Accept service connection request from peer:" + peerAgent.getAgentId() + " Transaction:" + peerAgent.getTransactionId());
                c cVar = this.mBackgroundWorker;
                if (cVar != null) {
                    Message obtainMessage = cVar.obtainMessage(7);
                    obtainMessage.obj = peerAgent;
                    this.mBackgroundWorker.sendMessage(obtainMessage);
                    return;
                }
                C1371a.k(str, "acceptServiceConnection: mBackgroundWorker is null!");
                return;
            }
            C1371a.k(TAG, "Accepting service connection with invalid peer agent:" + peerAgent.toString());
            handleInvalidPeerAction(peerAgent);
        } catch (SdkUnsupportedException e10) {
            C1371a.d(TAG, "exception: " + e10.getMessage());
            handleError(20002, peerAgent);
        }
    }

    public void authenticatePeerAgent(PeerAgent peerAgent) {
        try {
            Initializer.initBufferPool(getApplicationContext());
            String str = TAG;
            C1371a.g(str, "Authentication requested for peer:" + peerAgent.getAgentId());
            c cVar = this.mBackgroundWorker;
            if (cVar != null) {
                Message obtainMessage = cVar.obtainMessage(9);
                obtainMessage.obj = peerAgent;
                this.mBackgroundWorker.sendMessage(obtainMessage);
                return;
            }
            C1371a.k(str, "authenticatePeerAgent: mBackgroundWorker is null!");
        } catch (SdkUnsupportedException e10) {
            C1371a.d(TAG, "exception: " + e10.getMessage());
            handleError(20002, peerAgent);
        }
    }

    public int checkAuthentication() {
        try {
            BaseAdapter baseAdapter = this.mAdapter;
            if (baseAdapter != null) {
                return baseAdapter.checkAuthentication();
            }
            return 1009;
        } catch (GeneralException e10) {
            C1371a.d(TAG, "check authentication error " + e10);
            return 1009;
        }
    }

    public void dispatchStartCommand(Intent intent, int i10, int i11) {
        c cVar = this.mBackgroundWorker;
        if (cVar != null) {
            Message obtainMessage = cVar.obtainMessage();
            obtainMessage.what = i11;
            obtainMessage.arg1 = i10;
            obtainMessage.obj = intent;
            this.mBackgroundWorker.sendMessage(obtainMessage);
            return;
        }
        C1371a.k(TAG, "onStartCommand: mBackgroundWorker is null!");
    }

    public final synchronized void findPeerAgents() {
        try {
            String str = TAG;
            C1371a.c(str, "findPeer request received by:" + getClass().getName());
            try {
                Initializer.initBufferPool(getApplicationContext());
                c cVar = this.mBackgroundWorker;
                if (cVar != null) {
                    Message obtainMessage = cVar.obtainMessage();
                    obtainMessage.what = 2;
                    this.mBackgroundWorker.sendMessage(obtainMessage);
                } else {
                    C1371a.k(str, "findPeerAgents: mBackgroundWorker is null!");
                }
            } catch (SdkUnsupportedException e10) {
                C1371a.d(TAG, "exception: " + e10.getMessage());
                handleError(20002, null);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public Handler getAgentHandler() {
        return this.mBackgroundWorker;
    }

    public String getId() {
        String localAgentId = getLocalAgentId();
        if (localAgentId == null) {
            handleError(20001, null);
        }
        return localAgentId;
    }

    public String getLocalAgentId() {
        String str = TAG;
        C1371a.c(str, "mGetAgentIdRetryCount = " + this.mGetAgentIdRetryCount);
        if (this.mGetAgentIdRetryCount >= 2) {
            this.mGetAgentIdRetryCount = 0;
            C1371a.d(str, "Failed to retrieve service record, retry 2");
            return null;
        }
        try {
            String localAgentId = this.mAdapter.getLocalAgentId(getClass().getName());
            C1371a.g(str, "Agent ID retrieved successfully for " + getClass().getName() + " Agent ID:" + localAgentId);
            return localAgentId;
        } catch (GeneralException e10) {
            if (e10.getErrorCode() == 10016) {
                String str2 = TAG;
                C1371a.k(str2, "Service record was not found in Accessory Framework.Registering service again!");
                this.mGetAgentIdRetryCount++;
                try {
                    registerService();
                    C1371a.g(str2, "Trying to fetch agent ID after re-registration");
                    return this.mAdapter.getLocalAgentId(getClass().getName());
                } catch (GeneralException unused) {
                    C1371a.e(TAG, "Failed to retrieve service record after re-registration", e10);
                    return null;
                }
            }
            C1371a.e(TAG, "Failed to retrieve service record", e10);
            return null;
        }
    }

    public PeerAccessory getPeerAccessory(long j10) {
        PeerAgent connectedPeerAgent;
        C1371a.c(TAG, "getPeerAccessory with connectionId:" + j10);
        for (BaseSocket baseSocket : this.mSuccessfulConnections) {
            if (String.valueOf(j10).equals(baseSocket.getConnectionId()) && (connectedPeerAgent = baseSocket.getConnectedPeerAgent()) != null) {
                return connectedPeerAgent.getAccessory();
            }
        }
        C1371a.k(TAG, "cannot find PeerAccessory with connectionId:" + j10);
        return null;
    }

    public int getServiceChannelId(int i10) {
        if (this.mServiceProfile == null) {
            C1371a.d(TAG, "Failed because Service Profile is null");
            return -1;
        }
        if (i10 >= 0 && i10 < getServiceChannelSize()) {
            return this.mServiceProfile.getServiceChannelList().get(i10).getChannelId();
        }
        C1371a.d(TAG, "Failed because of wrong index");
        return -1;
    }

    public int getServiceChannelSize() {
        ServiceProfile serviceProfile = this.mServiceProfile;
        if (serviceProfile == null) {
            C1371a.d(TAG, "Failed because Service Profile is null");
            return -1;
        }
        return serviceProfile.getServiceChannelList().size();
    }

    public ServiceProfile getServiceProfile() {
        return this.mServiceProfile;
    }

    public String getServiceProfileId() {
        ServiceProfile serviceProfile = this.mServiceProfile;
        if (serviceProfile == null) {
            C1371a.d(TAG, "Failed because Service Profile is null");
            return null;
        }
        return serviceProfile.getId();
    }

    public String getServiceProfileName() {
        ServiceProfile serviceProfile = this.mServiceProfile;
        if (serviceProfile == null) {
            C1371a.d(TAG, "Failed because Service Profile is null");
            return null;
        }
        return serviceProfile.getName();
    }

    public List<BaseSocket> getSuccessfulConnections() {
        return this.mSuccessfulConnections;
    }

    public int getVersion() {
        try {
            BaseAdapter baseAdapter = this.mAdapter;
            if (baseAdapter != null) {
                return baseAdapter.getVersion();
            }
            return 0;
        } catch (GeneralException e10) {
            C1371a.d(TAG, "getVersion error " + e10);
            return 0;
        }
    }

    public void handleError(int i10, PeerAgent peerAgent) {
        if (i10 != 10008) {
            switch (i10) {
                case 20001:
                    cleanupConnections(true);
                    onError(null, "Accessory Framework has died!!", i10);
                    handleOnErrorCode(i10);
                    return;
                case 20002:
                    C1371a.d(TAG, "Accessory SDK cannot be initialized");
                    onError(null, "Accessory SDK cannot be initialized. Device or Build not compatible.", i10);
                    handleOnErrorCode(i10);
                    return;
                case 20003:
                case ERROR_PERMISSION_FAILED /* 20004 */:
                    onError(null, "Permission error!", i10);
                    handleOnErrorCode(i10);
                    return;
                default:
                    C1371a.k(TAG, "Unknown error: " + i10);
                    return;
            }
        }
        onServiceConnectionResponse(peerAgent, null, 10008);
        handleServiceConnectionErrorCode(10008);
    }

    public void onAuthenticationResponse(PeerAgent peerAgent, AuthenticationToken authenticationToken, int i10) {
        C1371a.c(TAG, "Peer authentication response received:" + i10);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        String str = TAG;
        C1371a.c(str, "BaseAgent - onCreate:" + getClass().getSimpleName());
        this.mSuccessfulConnections = Collections.synchronizedList(new ArrayList());
        this.mPendingRequests = Collections.synchronizedSet(new HashSet());
        HandlerThread handlerThread = new HandlerThread(this.mName);
        handlerThread.start();
        Looper looper = handlerThread.getLooper();
        if (looper != null) {
            this.mBackgroundWorker = new c(this, looper);
            try {
                Initializer.initBufferPool(getApplicationContext());
            } catch (SdkUnsupportedException e10) {
                C1371a.e(TAG, "SDK initialization failed!", e10);
                Message obtainMessage = this.mBackgroundWorker.obtainMessage(11);
                obtainMessage.arg1 = 20002;
                this.mBackgroundWorker.sendMessage(obtainMessage);
            }
            this.mAdapter = BaseAdapter.getDefaultAdapter(getApplicationContext(), this.mBackgroundWorker);
            this.mPeerAuthCallback = new AuthenticationCallback();
            this.mPeerAgentCallback = new PeerAgentCallback();
            this.mConnectionCallback = new d();
            this.mAgentCallback = new b(this);
            this.mBackgroundWorker.sendEmptyMessage(0);
            fetchServiceProfile();
            return;
        }
        C1371a.d(str, "Unable to start Agent thread.");
        throw new RuntimeException("Unable to start Agent.Worker thread creation failed");
    }

    @Override // android.app.Service
    public void onDestroy() {
        C1371a.c(TAG, "BaseAgent - onDestroy:" + getClass().getSimpleName());
        c cVar = this.mBackgroundWorker;
        if (cVar != null) {
            cVar.obtainMessage(13).sendToTarget();
        }
        super.onDestroy();
    }

    public void onError(PeerAgent peerAgent, String str, int i10) {
        if (peerAgent == null) {
            C1371a.d(TAG, "ACCEPT_STATE_ERROR: " + i10 + ": " + str + " PeerAgent: null");
            return;
        }
        C1371a.d(TAG, "ACCEPT_STATE_ERROR: " + i10 + ": " + str + " PeerAgent: " + peerAgent.getAgentId());
    }

    public void onFindPeerAgentsResponse(PeerAgent[] peerAgentArr, int i10) {
        C1371a.d(TAG, "Invalid implementation of BaseAgent.onFindPeerAgentsResponse(PeerAgent[], int) should be overrided!");
    }

    public void onPeerAgentsUpdated(PeerAgent[] peerAgentArr, int i10) {
        C1371a.d(TAG, "Invalid implementation of BaseAgent.onPeerAgentsUpdated(PeerAgent[], int) should be overrided!");
    }

    public void onServiceConnectionRequested(PeerAgent peerAgent) {
        if (peerAgent != null) {
            C1371a.i(TAG, "Accepting connection request by default from Peer:" + peerAgent.getAgentId() + " Transaction:" + peerAgent.getTransactionId());
            acceptServiceConnectionRequest(peerAgent);
            return;
        }
        C1371a.k(TAG, "onServiceConnectionRequested but peerAgent null!");
    }

    public void onServiceConnectionResponse(PeerAgent peerAgent, BaseSocket baseSocket, int i10) {
        C1371a.k(TAG, "No Implementaion for onServiceConnectionResponse(PeerAgent peerAgent, BaseSocket socket, int result)!");
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        String action;
        if (intent != null && (action = intent.getAction()) != null) {
            if ("com.heytap.accessory.action.SERVICE_CONNECTION_REQUESTED".equalsIgnoreCase(action)) {
                C1371a.c(TAG, "Received incoming connection request");
                dispatchStartCommand(intent, i11, 5);
                return 2;
            }
            if (BaseAdapter.ACTION_ACCESSORY_STATUS_CHANGED.equalsIgnoreCase(action)) {
                C1371a.c(TAG, "Received accessory status changed");
                dispatchStartCommand(intent, i11, 15);
                return 2;
            }
            if (BaseMessage.ACTION_ACCESSORY_MESSAGE_RECEIVED.equalsIgnoreCase(action)) {
                C1371a.c(TAG, "Received push msg action");
                try {
                    registerMexAgent();
                    return 2;
                } catch (GeneralException e10) {
                    C1371a.k(TAG, "registerMexAgent failed:" + e10);
                    return 2;
                }
            }
            C1371a.c(TAG, "ignore action:" + action);
            return 2;
        }
        return 2;
    }

    @Override // android.app.Service, android.content.ComponentCallbacks2
    public void onTrimMemory(int i10) {
        s5.b.a(i10);
        super.onTrimMemory(i10);
    }

    public String registerMessageInstance(BaseMessage baseMessage) {
        this.mMessage = baseMessage;
        return this.mAgentId;
    }

    public void rejectServiceConnectionRequest(PeerAgent peerAgent) {
        try {
            Initializer.initBufferPool(getApplicationContext());
            if (this.mPendingRequests.remove(peerAgent)) {
                String str = TAG;
                C1371a.g(str, "Trying to reject connection request from peer:" + peerAgent.getAgentId() + " Transaction:" + peerAgent.getTransactionId());
                c cVar = this.mBackgroundWorker;
                if (cVar != null) {
                    Message obtainMessage = cVar.obtainMessage(8);
                    obtainMessage.obj = peerAgent;
                    this.mBackgroundWorker.sendMessage(obtainMessage);
                    return;
                }
                C1371a.k(str, "rejectServiceConnection: mBackgroundWorker is null!");
                return;
            }
            C1371a.k(TAG, "Rejecting service connection with invalid peer agent:" + peerAgent.toString());
            handleInvalidPeerAction(peerAgent);
        } catch (SdkUnsupportedException e10) {
            C1371a.d(TAG, "exception: " + e10.getMessage());
            handleError(20002, peerAgent);
        }
    }

    public final void requestServiceConnection(PeerAgent peerAgent) {
        try {
            Initializer.initBufferPool(getApplicationContext());
            String str = TAG;
            C1371a.g(str, "Service connection requested for peer:" + peerAgent.getAgentId());
            c cVar = this.mBackgroundWorker;
            if (cVar != null) {
                Message obtainMessage = cVar.obtainMessage(6);
                obtainMessage.obj = peerAgent;
                this.mBackgroundWorker.sendMessage(obtainMessage);
                return;
            }
            C1371a.k(str, "requestServiceConection: mBackgroundWorker is null!");
        } catch (SdkUnsupportedException e10) {
            C1371a.d(TAG, "exception: " + e10.getMessage());
            handleError(20002, peerAgent);
        }
    }

    public boolean runOnBackgroundThread(Runnable runnable) {
        c cVar = this.mBackgroundWorker;
        if (cVar != null) {
            return cVar.post(runnable);
        }
        C1371a.k(TAG, "runOnBackgroundThread: mBackgroundWorker is null!");
        return false;
    }

    public boolean checkAuthentication(String str) {
        try {
            return this.mAdapter.checkAuthentication(str);
        } catch (GeneralException e10) {
            C1371a.d(TAG, "check authentication method error " + e10);
            return false;
        }
    }

    public BaseAgent(String str, Class<? extends BaseSocket> cls) {
        validateSocketImplementation(cls);
        this.mName = str;
        this.mSocketImpl = cls;
        C1371a.c(TAG, "Thread Name:" + this.mName + "BaseSocket Imple class:" + cls.getName());
    }
}
