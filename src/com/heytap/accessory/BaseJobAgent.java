package com.heytap.accessory;

import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.PersistableBundle;
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
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;
import n5.C1371a;
import r5.h;

/* loaded from: classes3.dex */
public abstract class BaseJobAgent {
    public static final String ACTION_REGISTRATION_REQUIRED = "com.heytap.accessory.action.REGISTER_AGENT";
    public static final String ACTION_SERVICE_CONNECTION_REQUESTED = "com.heytap.accessory.action.SERVICE_CONNECTION_REQUESTED";
    public static final int AUTHENTICATION_FAILURE_PEER_AGENT_NOT_SUPPORTED = 1546;
    public static final int AUTHENTICATION_FAILURE_TOKEN_NOT_GENERATED = 1545;
    public static final int AUTHENTICATION_SUCCESS = 0;
    private static final int CLEANUP_WAIT_MAX_RETRY = 4;
    private static final long CLEANUP_WAIT_TIME = 500;
    public static final int CONNECTION_ALREADY_EXIST = 10005;
    public static final int CONNECTION_DUPLICATE_REQUEST = 10009;
    public static final int CONNECTION_FAILURE_ACC_DORMANT = 10014;
    public static final int CONNECTION_FAILURE_DEVICE_UNREACHABLE = 10004;
    public static final int CONNECTION_FAILURE_INVALID_PEER_AGENT = 10008;
    private static final int CONNECTION_FAILURE_LOCAL_AGENT_NOT_FOUND = 1034;
    public static final int CONNECTION_FAILURE_NETWORK = 10012;
    public static final int CONNECTION_FAILURE_PEERAGENT_NO_RESPONSE = 10006;
    public static final int CONNECTION_FAILURE_PEERAGENT_REJECTED = 10007;
    public static final int CONNECTION_FAILURE_SERVICE_LIMIT_REACHED = 10010;
    public static final int CONNECTION_SUCCESS = 0;
    private static final int DEFAULT_GET_AGENT_ID_RETRY_COUNT = 2;
    public static final int ERROR_AGENT_REQUEST_IN_PROGRESS = 2564;
    public static final int ERROR_CLASS_NOT_FOUND = 2561;
    public static final int ERROR_CONNECTION_INVALID_PARAM = 1025;
    public static final int ERROR_CONSTRUCTOR_EXCEPTION = 2563;
    public static final int ERROR_CONSTRUCTOR_NOT_FOUND = 2562;
    public static final int ERROR_FATAL = 20001;
    public static final int ERROR_SDK_NOT_INITIALIZED = 20002;
    public static final int FIND_PEER_DEVICE_NOT_CONNECTED = 10001;
    public static final int FIND_PEER_DUPLICATE_REQUEST = 10003;
    public static final int FIND_PEER_SERVICE_NOT_FOUND = 10002;
    public static final int FIND_PEER_TIMEOUT = 10010;
    public static final int PEER_AGENT_AVAILABLE = 1;
    private static final int PEER_AGENT_AVAILABLE_THIN = 105;
    public static final int PEER_AGENT_FOUND = 0;
    public static final int PEER_AGENT_UNAVAILABLE = 2;
    private static final int PEER_AGENT_UNAVAILABLE_THIN = 106;
    private static final int SERVICE_RECORD_NOT_FOUND = 10016;
    private static final String TAG = "BaseJobAgent";
    private static InstanceHandler sInstanceHandler;
    BaseAdapter mAdapter;
    private AgentCallbackImpl mAgentCallback;
    private String mAgentId;
    AgentHandler mBackgroundWorker;
    private ConnectionCallback mConnectionCallback;
    private Context mContext;
    private BaseMessage mMessage;
    private String mName;
    private PeerAgentCallback mPeerAgentCallback;
    private AuthenticationCallback mPeerAuthCallback;
    private Set<PeerAgent> mPendingRequests;
    private volatile boolean mProcessingCleanup;
    private Class<? extends BaseSocket> mSocketImpl;
    private List<BaseSocket> mSuccessfulConnections;
    private static final ReentrantLock INSTANCE_LOCK = new ReentrantLock();
    private static final Map<String, BaseJobAgent> BASE_JOB_AGENT_MAP = new ConcurrentHashMap();
    private final Object mLock = new Object();
    private ServiceProfile mServiceProfile = null;
    private int mGetAgentIdRetryCount = 0;

    /* loaded from: classes3.dex */
    public static class AgentCallbackImpl implements BaseAdapter.d {

        /* renamed from: a, reason: collision with root package name */
        public BaseJobAgent f25139a;

        public AgentCallbackImpl(BaseJobAgent baseJobAgent) {
            this.f25139a = baseJobAgent;
        }

        @Override // com.heytap.accessory.BaseAdapter.d
        public void a() {
            this.f25139a.mBackgroundWorker.sendEmptyMessage(15);
        }

        @Override // com.heytap.accessory.BaseAdapter.d
        public void b() {
            try {
                this.f25139a.registerMexAgent();
            } catch (GeneralException e10) {
                C1371a.d(BaseJobAgent.TAG, "onFrameworkConnected() - Failed to register agent with message! " + e10.getMessage());
            }
        }

        @Override // com.heytap.accessory.BaseAdapter.d
        public void c() {
            AgentHandler agentHandler = this.f25139a.mBackgroundWorker;
            if (agentHandler != null) {
                Message obtainMessage = agentHandler.obtainMessage(12);
                obtainMessage.arg1 = 20001;
                this.f25139a.mBackgroundWorker.sendMessage(obtainMessage);
                return;
            }
            C1371a.k(BaseJobAgent.TAG, "onFrameworkDisconnected: mBackgroundWorker is null!");
        }
    }

    /* loaded from: classes3.dex */
    public static class AgentHandler extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public BaseJobAgent f25140a;

        public AgentHandler(BaseJobAgent baseJobAgent, Looper looper) {
            super(looper);
            this.f25140a = baseJobAgent;
        }

        public void a() {
            getLooper().quit();
        }

        public final void b(Message message) {
            int i10 = message.arg1;
            if (i10 == 0) {
                this.f25140a.handleFindPeerErrorCode(0);
                this.f25140a.onFindPeerAgentsResponse((PeerAgent[]) message.obj, 0);
            } else {
                this.f25140a.handleFindPeerErrorCode(i10);
                this.f25140a.onFindPeerAgentsResponse(null, message.arg1);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            PeerAgent peerAgent;
            BaseJobAgent baseJobAgent = this.f25140a;
            if (baseJobAgent != null && baseJobAgent.mAdapter != null) {
                PeerAgent peerAgent2 = null;
                switch (message.what) {
                    case 0:
                        try {
                            baseJobAgent.bindToFramework();
                            return;
                        } catch (GeneralException e10) {
                            C1371a.e(BaseJobAgent.TAG, "Binding to Accessory Framework failed", e10);
                            this.f25140a.handleError(e10.getErrorCode(), null);
                            return;
                        }
                    case 1:
                        baseJobAgent.registerService();
                        return;
                    case 2:
                        baseJobAgent.requestPeerAgents();
                        return;
                    case 3:
                        b(message);
                        return;
                    case 4:
                        baseJobAgent.onPeerAgentsUpdated((PeerAgent[]) message.obj, message.arg1);
                        this.f25140a.handlePeerAgentUpdateErrorCode(message.arg1);
                        return;
                    case 5:
                        baseJobAgent.notifyConnectionRequest((Intent) message.obj);
                        return;
                    case 6:
                        C1371a.c(BaseJobAgent.TAG, "MESSAGE_CONNECTION_INDICATION_JOB");
                        IJobListener iJobListener = (IJobListener) message.obj;
                        JobParameters jobParameters = (JobParameters) message.getData().get("params");
                        this.f25140a.notifyConnectionRequest(jobParameters.getExtras());
                        iJobListener.onJobFinished(jobParameters);
                        return;
                    case 7:
                        baseJobAgent.requestConnection((PeerAgent) message.obj);
                        return;
                    case 8:
                        baseJobAgent.acceptServiceConnectionInternal((PeerAgent) message.obj);
                        return;
                    case 9:
                        baseJobAgent.rejectServiceConnectionInternal((PeerAgent) message.obj);
                        return;
                    case 10:
                        baseJobAgent.requestPeerAuthInternal((PeerAgent) message.obj);
                        return;
                    case 11:
                        baseJobAgent.handleAuthResponse(message.getData());
                        return;
                    case 12:
                        Object obj = message.obj;
                        if (obj instanceof PeerAgent) {
                            peerAgent2 = (PeerAgent) obj;
                        }
                        baseJobAgent.handleError(message.arg1, peerAgent2);
                        return;
                    case 13:
                        Object obj2 = message.obj;
                        if (obj2 instanceof PeerAgent) {
                            peerAgent = (PeerAgent) obj2;
                        } else {
                            peerAgent = null;
                        }
                        baseJobAgent.onServiceConnectionResponse(peerAgent, null, message.arg1);
                        this.f25140a.handleServiceConnectionErrorCode(message.arg1);
                        return;
                    case 14:
                        baseJobAgent.cleanup();
                        return;
                    case 15:
                        try {
                            baseJobAgent.loadAgentId();
                            return;
                        } catch (GeneralException e11) {
                            C1371a.e(BaseJobAgent.TAG, "Retrieving agent id failed", e11);
                            this.f25140a.handleError(e11.getErrorCode(), null);
                            return;
                        }
                    default:
                        C1371a.k(BaseJobAgent.TAG, "Invalid msg received: " + message.what);
                        return;
                }
            }
            C1371a.k(BaseJobAgent.TAG, "BaseAdapter is null, return!");
        }
    }

    /* loaded from: classes3.dex */
    public class AuthenticationCallback extends IPeerAgentAuthCallback.Stub {
        @Override // com.heytap.accessory.api.IPeerAgentAuthCallback
        public void T5(Bundle bundle) {
            C1371a.i(BaseJobAgent.TAG, "Received Authentication response");
            AgentHandler agentHandler = BaseJobAgent.this.mBackgroundWorker;
            if (agentHandler != null) {
                Message obtainMessage = agentHandler.obtainMessage(11);
                obtainMessage.setData(bundle);
                BaseJobAgent.this.mBackgroundWorker.sendMessage(obtainMessage);
                return;
            }
            C1371a.k(BaseJobAgent.TAG, "onPeerAgentAuthenticated: mBackgroundWorker is null!");
        }

        private AuthenticationCallback() {
        }
    }

    /* loaded from: classes3.dex */
    public class ConnectionCallback implements BaseSocket.b {
        @Override // com.heytap.accessory.BaseSocket.b
        public void a(PeerAgent peerAgent, BaseSocket baseSocket) {
            BaseJobAgent.this.mSuccessfulConnections.add(baseSocket);
            C1371a.g(BaseJobAgent.TAG, "Connection success with peer:" + peerAgent.getAgentId());
            BaseJobAgent.this.onServiceConnectionResponse(peerAgent, baseSocket, 0);
            BaseJobAgent.this.handleServiceConnectionErrorCode(0);
        }

        private ConnectionCallback() {
        }

        @Override // com.heytap.accessory.BaseSocket.b
        public void a(PeerAgent peerAgent, int i10) {
            if (i10 == 20001) {
                C1371a.k(BaseJobAgent.TAG, "Framework disconnected during connection process!");
                BaseJobAgent.this.handleError(i10, peerAgent);
                return;
            }
            AgentHandler agentHandler = BaseJobAgent.this.mBackgroundWorker;
            if (agentHandler != null) {
                if (i10 == BaseJobAgent.CONNECTION_FAILURE_LOCAL_AGENT_NOT_FOUND) {
                    agentHandler.sendMessage(agentHandler.obtainMessage(1));
                    i10 = 10008;
                }
                C1371a.d(BaseJobAgent.TAG, "Connection attempt failed wih peer:" + peerAgent.getAgentId() + " reason:" + i10);
                Message obtainMessage = agentHandler.obtainMessage(13);
                obtainMessage.arg1 = i10;
                obtainMessage.obj = peerAgent;
                agentHandler.sendMessage(obtainMessage);
                return;
            }
            C1371a.k(BaseJobAgent.TAG, "onConnectionFailure: mBackgroundWorker is null!");
        }
    }

    /* loaded from: classes3.dex */
    public static class InstanceCreator {

        /* renamed from: a, reason: collision with root package name */
        public Context f25143a;

        /* renamed from: b, reason: collision with root package name */
        public String f25144b;

        /* renamed from: c, reason: collision with root package name */
        public RequestAgentCallback f25145c;

        public InstanceCreator(Context context, String str, RequestAgentCallback requestAgentCallback) {
            this.f25143a = context;
            this.f25144b = str;
            this.f25145c = requestAgentCallback;
        }

        public void b() {
            if (BaseJobAgent.sInstanceHandler == null) {
                HandlerThread handlerThread = new HandlerThread("instance");
                handlerThread.start();
                InstanceHandler unused = BaseJobAgent.sInstanceHandler = new InstanceHandler(handlerThread.getLooper());
            }
            Message obtainMessage = BaseJobAgent.sInstanceHandler.obtainMessage(1);
            obtainMessage.obj = this;
            obtainMessage.sendToTarget();
        }
    }

    /* loaded from: classes3.dex */
    public static class InstanceHandler extends Handler {
        public InstanceHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 != 1) {
                if (i10 == 2) {
                    BaseJobAgent baseJobAgent = (BaseJobAgent) message.obj;
                    if (BaseJobAgent.BASE_JOB_AGENT_MAP.get(baseJobAgent.getClass().getName()) == baseJobAgent) {
                        baseJobAgent.destroy();
                        return;
                    } else {
                        C1371a.k(BaseJobAgent.TAG, "Stale agent entry. Agent already destroyed. Ignoring...");
                        return;
                    }
                }
                return;
            }
            InstanceCreator instanceCreator = (InstanceCreator) message.obj;
            Context context = instanceCreator.f25143a;
            String str = instanceCreator.f25144b;
            RequestAgentCallback requestAgentCallback = instanceCreator.f25145c;
            C1371a.c(BaseJobAgent.TAG, "CREATE_AGENT: " + str);
            int i11 = message.arg1;
            BaseJobAgent baseJobAgent2 = (BaseJobAgent) BaseJobAgent.BASE_JOB_AGENT_MAP.get(str);
            if (baseJobAgent2 != null) {
                C1371a.c(BaseJobAgent.TAG, "CREATE_AGENT, but sAgentMap already exist");
                if (baseJobAgent2.isProcessingCleanup()) {
                    if (i11 == 4) {
                        requestAgentCallback.onError(BaseJobAgent.ERROR_AGENT_REQUEST_IN_PROGRESS, "Class could not be initialized: " + str + ". Error occurred while releasing agent.");
                        return;
                    }
                    Message obtainMessage = obtainMessage(1);
                    obtainMessage.arg1 = i11 + 1;
                    obtainMessage.obj = instanceCreator;
                    sendMessageDelayed(obtainMessage, 500L);
                    return;
                }
                if (requestAgentCallback != null) {
                    requestAgentCallback.onAgentAvailable(baseJobAgent2);
                    return;
                }
                return;
            }
            BaseJobAgent.INSTANCE_LOCK.lock();
            C1371a.c(BaseJobAgent.TAG, "CREATE_AGENT, create it by reflection: " + str);
            try {
                try {
                    try {
                        Constructor<?> declaredConstructor = Class.forName(str).getDeclaredConstructor(Context.class);
                        declaredConstructor.setAccessible(true);
                        declaredConstructor.newInstance(context);
                        BaseJobAgent.INSTANCE_LOCK.unlock();
                        BaseJobAgent baseJobAgent3 = (BaseJobAgent) BaseJobAgent.BASE_JOB_AGENT_MAP.get(str);
                        if (baseJobAgent3 == null) {
                            requestAgentCallback.onError(BaseJobAgent.ERROR_CONSTRUCTOR_EXCEPTION, "Class could not be initialized: " + str + ". Call super inside constructor.");
                            return;
                        }
                        if (requestAgentCallback != null) {
                            requestAgentCallback.onAgentAvailable(baseJobAgent3);
                        }
                    } catch (ClassNotFoundException e10) {
                        e10.printStackTrace();
                        requestAgentCallback.onError(BaseJobAgent.ERROR_CLASS_NOT_FOUND, "Class not found: " + str);
                    }
                } catch (NoSuchMethodException e11) {
                    e11.printStackTrace();
                    requestAgentCallback.onError(BaseJobAgent.ERROR_CONSTRUCTOR_NOT_FOUND, "Constructor with Context argument not found: " + str);
                } catch (Exception e12) {
                    C1371a.l(BaseJobAgent.TAG, "CREATE_AGENT failed", e12);
                    requestAgentCallback.onError(BaseJobAgent.ERROR_CONSTRUCTOR_EXCEPTION, "Class instantiation error: " + str);
                }
            } finally {
                BaseJobAgent.INSTANCE_LOCK.unlock();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class PeerAgentCallback extends IPeerAgentCallback.Stub {
        @Override // com.heytap.accessory.api.IPeerAgentCallback
        public void H7(Bundle bundle) {
            C1371a.i(BaseJobAgent.TAG, "Received peer agent update");
            bundle.setClassLoader(PeerAgent.class.getClassLoader());
            if (!bundle.containsKey(AFConstants.EXTRA_PEER_AGENTS)) {
                C1371a.d(BaseJobAgent.TAG, "No peer agents in PeerAgent update callback!");
                return;
            }
            ArrayList<PeerAgent> parcelableArrayList = bundle.getParcelableArrayList(AFConstants.EXTRA_PEER_AGENTS);
            int i10 = bundle.getInt(AFConstants.EXTRA_PEER_AGENT_STATUS);
            if (parcelableArrayList == null) {
                C1371a.d(BaseJobAgent.TAG, "Peer Update - invalid peer agent list from Accessory Framework");
                return;
            }
            if (i10 != 105 && i10 != 106) {
                C1371a.d(BaseJobAgent.TAG, "Peer Update - invalid peer status from Accessory Framework:" + i10);
                return;
            }
            C1371a.g(BaseJobAgent.TAG, parcelableArrayList.size() + " Peer agent(s) updated for:" + getClass().getName());
            for (PeerAgent peerAgent : parcelableArrayList) {
                C1371a.g(BaseJobAgent.TAG, "Peer ID:" + peerAgent.getAgentId() + "Container Id:" + peerAgent.getAppName() + " Accessory" + peerAgent.getAccessory().getPeerId());
            }
            AgentHandler agentHandler = BaseJobAgent.this.mBackgroundWorker;
            if (agentHandler != null) {
                Message obtainMessage = agentHandler.obtainMessage();
                obtainMessage.what = 4;
                if (i10 == 105) {
                    obtainMessage.arg1 = 1;
                } else {
                    obtainMessage.arg1 = 2;
                }
                obtainMessage.obj = parcelableArrayList.toArray(new PeerAgent[0]);
                BaseJobAgent.this.mBackgroundWorker.sendMessage(obtainMessage);
                return;
            }
            C1371a.k(BaseJobAgent.TAG, "onPeerAgentUpdated: mBackgroundWorker is null!");
        }

        @Override // com.heytap.accessory.api.IPeerAgentCallback
        public void T2(Bundle bundle) {
            C1371a.i(BaseJobAgent.TAG, "FindPeer response received.");
            bundle.setClassLoader(PeerAgent.class.getClassLoader());
            if (bundle.containsKey("errorcode")) {
                int i10 = bundle.getInt("errorcode");
                C1371a.d(BaseJobAgent.TAG, "Peer Not Found(" + i10 + ") for: " + getClass().getName());
                AgentHandler agentHandler = BaseJobAgent.this.mBackgroundWorker;
                if (agentHandler != null) {
                    Message obtainMessage = agentHandler.obtainMessage();
                    obtainMessage.what = 3;
                    obtainMessage.arg1 = i10;
                    BaseJobAgent.this.mBackgroundWorker.sendMessage(obtainMessage);
                    return;
                }
                C1371a.k(BaseJobAgent.TAG, "onPeersAgentsFound: mBackgroundWorker is null!");
                return;
            }
            ArrayList<PeerAgent> parcelableArrayList = bundle.getParcelableArrayList(AFConstants.EXTRA_PEER_AGENTS);
            if (parcelableArrayList == null) {
                C1371a.d(BaseJobAgent.TAG, "Find Peer - invalid response from Accessory Framework");
                return;
            }
            C1371a.g(BaseJobAgent.TAG, parcelableArrayList.size() + " Peer agent(s) found for:" + getClass().getName());
            for (PeerAgent peerAgent : parcelableArrayList) {
                C1371a.g(BaseJobAgent.TAG, "Peer ID:" + peerAgent.getAgentId() + "Container Id:" + peerAgent.getAppName() + " Accessory" + peerAgent.getAccessory().getPeerId() + " Transport:" + peerAgent.getAccessory().getTransportType());
            }
            AgentHandler agentHandler2 = BaseJobAgent.this.mBackgroundWorker;
            if (agentHandler2 != null) {
                Message obtainMessage2 = agentHandler2.obtainMessage();
                obtainMessage2.what = 3;
                obtainMessage2.arg1 = 0;
                obtainMessage2.obj = parcelableArrayList.toArray(new PeerAgent[0]);
                BaseJobAgent.this.mBackgroundWorker.sendMessage(obtainMessage2);
                return;
            }
            C1371a.k(BaseJobAgent.TAG, "onPeerAgentsFound: mBackgroundWorker is null!");
        }

        private PeerAgentCallback() {
        }
    }

    /* loaded from: classes3.dex */
    public interface RequestAgentCallback {
        void onAgentAvailable(BaseJobAgent baseJobAgent);

        void onError(int i10, String str);
    }

    public BaseJobAgent(String str, Context context) {
        if (INSTANCE_LOCK.isHeldByCurrentThread()) {
            this.mName = str;
            this.mContext = context;
            initializeAgent();
        } else {
            throw new IllegalArgumentException("Constructor should not be called for initializing " + str + ". Call requestAgent API instead");
        }
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

    /* JADX INFO: Access modifiers changed from: private */
    public void destroy() {
        C1371a.c(TAG, "BaseJobAgent - onDestroy:" + getClass().getSimpleName());
        synchronized (this.mLock) {
            this.mProcessingCleanup = true;
        }
        AgentHandler agentHandler = this.mBackgroundWorker;
        if (agentHandler != null) {
            agentHandler.obtainMessage(14).sendToTarget();
        }
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

    private void handleAuthErrorCode(int i10) {
        if (i10 != 0) {
            if (i10 != 1545) {
                if (i10 != 1546) {
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
            StringBuilder sb = new StringBuilder();
            sb.append("Authentication failed error:");
            i10 = AUTHENTICATION_FAILURE_TOKEN_NOT_GENERATED;
            sb.append(AUTHENTICATION_FAILURE_TOKEN_NOT_GENERATED);
            sb.append(" Peer Id:");
            sb.append(peerAgent.getAgentId());
            C1371a.d(TAG, sb.toString());
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Authentication success status: ");
            i10 = 0;
            sb2.append(0);
            sb2.append(" for peer: ");
            sb2.append(peerAgent.getAgentId());
            C1371a.g(TAG, sb2.toString());
        }
        onAuthenticationResponse(peerAgent, new AuthenticationToken(i11, byteArray), i10);
        handleAuthErrorCode(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleFindPeerErrorCode(int i10) {
        if (i10 != 0) {
            if (i10 != 10010) {
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
            C1371a.g(TAG, "onFindPeerAgentsResponse() -> FIND_PEER_TIMEOUT");
            return;
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
                AgentHandler agentHandler = this.mBackgroundWorker;
                if (agentHandler != null) {
                    Message obtainMessage = agentHandler.obtainMessage(12);
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

    public static void handleLowMemory() {
        Map<String, BaseJobAgent> map = BASE_JOB_AGENT_MAP;
        synchronized (map) {
            try {
                Iterator<BaseJobAgent> it = map.values().iterator();
                while (it.hasNext()) {
                    it.next().handleAgentLowMemory();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void handleOnErrorCode(int i10) {
        if (i10 != 1025) {
            if (i10 != 20001) {
                if (i10 != 20002) {
                    C1371a.k(TAG, "onError() errorCode: " + i10);
                    return;
                }
                C1371a.g(TAG, "onError() -> ERROR_SDK_NOT_INITIALIZED");
                return;
            }
            C1371a.g(TAG, "onError() -> ERROR_FATAL");
            return;
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
            C1371a.g(TAG, "onServiceConnectionResponse() -> CONNECTION_FAILURE_NETWORK");
            return;
        }
        C1371a.g(TAG, "onServiceConnectionResponse() -> CONNECTION_SUCCESS");
    }

    private void initializeAgent() {
        try {
            new h(getApplicationContext());
        } catch (GeneralException e10) {
            e10.printStackTrace();
        }
        C1371a.c(TAG, "BaseJobAgent - initialize:" + getClass().getSimpleName());
        this.mSuccessfulConnections = Collections.synchronizedList(new ArrayList());
        this.mPendingRequests = Collections.synchronizedSet(new HashSet());
        HandlerThread handlerThread = new HandlerThread(this.mName);
        handlerThread.start();
        Looper looper = handlerThread.getLooper();
        if (looper != null) {
            this.mBackgroundWorker = new AgentHandler(this, looper);
            try {
                Initializer.initBufferPool(getApplicationContext());
            } catch (SdkUnsupportedException e11) {
                C1371a.e(TAG, "SDK initialization failed!", e11);
                Message obtainMessage = this.mBackgroundWorker.obtainMessage(12);
                obtainMessage.arg1 = 20002;
                this.mBackgroundWorker.sendMessage(obtainMessage);
            }
            putAgent(getClass().getName(), this);
            this.mAdapter = BaseAdapter.getDefaultAdapter(getApplicationContext(), this.mBackgroundWorker);
            this.mPeerAuthCallback = new AuthenticationCallback();
            this.mPeerAgentCallback = new PeerAgentCallback();
            this.mConnectionCallback = new ConnectionCallback();
            this.mAgentCallback = new AgentCallbackImpl(this);
            this.mBackgroundWorker.sendEmptyMessage(0);
            fetchServiceProfile();
            return;
        }
        C1371a.d(TAG, "Unable to start Agent thread.");
        throw new RuntimeException("Unable to start Agent.Worker thread creation failed");
    }

    private BaseSocket instantiateSocket() {
        validateSocketImplementation(this.mSocketImpl);
        try {
            C1371a.c(TAG, "Instantiating BaseSocket: " + this.mSocketImpl.getName());
            if (!Modifier.toString(this.mSocketImpl.getModifiers()).contains("static") && this.mSocketImpl.getEnclosingClass() != null && BaseJobAgent.class.isAssignableFrom(this.mSocketImpl.getEnclosingClass())) {
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
    public boolean isProcessingCleanup() {
        boolean z10;
        synchronized (this.mLock) {
            z10 = this.mProcessingCleanup;
        }
        return z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAgentId() {
        String localAgentId = getLocalAgentId();
        if (localAgentId == null) {
            handleError(20001, null);
            return;
        }
        SharedPreferences.Editor edit = this.mContext.createDeviceProtectedStorageContext().getSharedPreferences("AccessoryPreferences", 0).edit();
        edit.putString(localAgentId, getClass().getName());
        edit.putString(getClass().getName(), localAgentId);
        edit.apply();
        C1371a.c(TAG, "save AgentId className:" + getClass().getName() + ",agentId: " + localAgentId);
        this.mAgentId = localAgentId;
        registerMexAgent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyConnectionRequest(Intent intent) {
        if (intent == null) {
            C1371a.d(TAG, "Invalid service connection indication.Intent:null.Ignoring reqeuset");
            return;
        }
        notifyConnectionRequest(intent.getLongExtra("transactionId", 0L), intent.getStringExtra(AFConstants.EXTRA_AGENT_ID), (PeerAgent) intent.getParcelableExtra("peerAgent"));
    }

    private static void putAgent(String str, BaseJobAgent baseJobAgent) {
        Map<String, BaseJobAgent> map = BASE_JOB_AGENT_MAP;
        if (!map.containsKey(str)) {
            map.put(str, baseJobAgent);
        }
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

    public static void requestAgent(Context context, String str, RequestAgentCallback requestAgentCallback) {
        C1371a.c(TAG, "requestAgent");
        new InstanceCreator(context, str, requestAgentCallback).b();
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
        } catch (Exception e10) {
            if (e10 instanceof GeneralException) {
                handleError(((GeneralException) e10).getErrorCode(), null);
            }
            C1371a.d(TAG, "Find Peer request failed!" + e10);
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
        if (cls != null) {
            try {
                if (!Modifier.toString(cls.getModifiers()).contains("static") && cls.getEnclosingClass() != null) {
                    cls.getDeclaredConstructor(cls.getEnclosingClass());
                    return;
                } else {
                    cls.getDeclaredConstructor(null);
                    return;
                }
            } catch (NoSuchMethodException e10) {
                C1371a.e(TAG, "exception: " + e10.getMessage(), e10);
                throw new RuntimeException("Invalid implementation of BaseSocket. Provider a public default constructor in the implementation class");
            }
        }
        throw new IllegalArgumentException("Invalid socketClass param");
    }

    public void acceptServiceConnectionRequest(PeerAgent peerAgent) {
        try {
            Initializer.initBufferPool(getApplicationContext());
            if (!this.mPendingRequests.remove(peerAgent)) {
                return;
            }
            C1371a.g(TAG, "Trying to Accept service connection request from peer:" + peerAgent.getAgentId() + " Transaction:" + peerAgent.getTransactionId());
            AgentHandler agentHandler = this.mBackgroundWorker;
            if (agentHandler != null) {
                Message obtainMessage = agentHandler.obtainMessage(8);
                obtainMessage.obj = peerAgent;
                this.mBackgroundWorker.sendMessage(obtainMessage);
                return;
            }
            C1371a.k(TAG, "acceptServiceConnection: mBackgroundWorker is null!");
        } catch (SdkUnsupportedException e10) {
            C1371a.d(TAG, "exception: " + e10.getMessage());
            handleError(20002, peerAgent);
        }
    }

    public void authenticatePeerAgent(PeerAgent peerAgent) {
        if (peerAgent != null) {
            try {
                Initializer.initBufferPool(getApplicationContext());
                C1371a.g(TAG, "Authentication requested for peer:" + peerAgent.getAgentId());
                AgentHandler agentHandler = this.mBackgroundWorker;
                if (agentHandler != null) {
                    Message obtainMessage = agentHandler.obtainMessage(10);
                    obtainMessage.obj = peerAgent;
                    this.mBackgroundWorker.sendMessage(obtainMessage);
                    return;
                }
                C1371a.k(TAG, "authenticatePeerAgent: mBackgroundWorker is null!");
                return;
            } catch (SdkUnsupportedException e10) {
                C1371a.d(TAG, "exception: " + e10.getMessage());
                handleError(20002, peerAgent);
                return;
            }
        }
        throw new IllegalArgumentException("Illegal argument peerAgent:" + peerAgent);
    }

    public void cleanup() {
        C1371a.k(TAG, "Performing agent cleanup");
        try {
            if (this.mAdapter != null) {
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
            }
        } catch (Exception e10) {
            C1371a.d(TAG, "cleanup excute exception: " + e10.getMessage());
        }
        AgentHandler agentHandler = this.mBackgroundWorker;
        if (agentHandler != null) {
            agentHandler.a();
            this.mBackgroundWorker = null;
        }
        BASE_JOB_AGENT_MAP.remove(getClass().getName());
        synchronized (this.mLock) {
            this.mProcessingCleanup = false;
        }
    }

    public final synchronized void findPeerAgents() {
        try {
            C1371a.c(TAG, "findPeer request received by:" + getClass().getName());
            try {
                Initializer.initBufferPool(getApplicationContext());
                AgentHandler agentHandler = this.mBackgroundWorker;
                if (agentHandler != null) {
                    Message obtainMessage = agentHandler.obtainMessage();
                    obtainMessage.what = 2;
                    this.mBackgroundWorker.sendMessage(obtainMessage);
                } else {
                    C1371a.k(TAG, "findPeerAgents: mBackgroundWorker is null!");
                }
            } catch (SdkUnsupportedException e10) {
                C1371a.e(TAG, "exception: ", e10);
                handleError(20002, null);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public Handler getAgentHandler() {
        return this.mBackgroundWorker;
    }

    public Context getApplicationContext() {
        return this.mContext.getApplicationContext();
    }

    public String getId() {
        String localAgentId = getLocalAgentId();
        if (localAgentId == null) {
            handleError(20001, null);
        }
        return localAgentId;
    }

    public String getLocalAgentId() {
        if (this.mAdapter == null) {
            C1371a.k(TAG, "BaseAdapter is null,just return!");
            return null;
        }
        C1371a.c(TAG, "mGetAgentIdRetryCount = " + this.mGetAgentIdRetryCount);
        if (this.mGetAgentIdRetryCount >= 2) {
            this.mGetAgentIdRetryCount = 0;
            C1371a.d(TAG, "Failed to retrieve service record, retry 2");
            return null;
        }
        try {
            String localAgentId = this.mAdapter.getLocalAgentId(getClass().getName());
            C1371a.g(TAG, "Agent ID retrieved successfully for " + getClass().getName() + " Agent ID:" + localAgentId);
            return localAgentId;
        } catch (GeneralException e10) {
            if (e10.getErrorCode() == 10016) {
                this.mGetAgentIdRetryCount++;
                C1371a.k(TAG, "Service record was not found in Accessory Framework.Registering service again!");
                try {
                    registerService();
                    C1371a.g(TAG, "Trying to fetch agent ID after re-registration");
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

    public void handleAgentLowMemory() {
        this.mBackgroundWorker.sendEmptyMessage(18);
    }

    public void handleConnectionRequest(Intent intent) {
        Message obtainMessage = this.mBackgroundWorker.obtainMessage();
        obtainMessage.what = 5;
        obtainMessage.obj = intent;
        this.mBackgroundWorker.sendMessage(obtainMessage);
    }

    public void handleError(int i10, PeerAgent peerAgent) {
        if (i10 != 10008) {
            if (i10 != 20001) {
                if (i10 != 20002) {
                    C1371a.k(TAG, "Unknown error: " + i10);
                    return;
                }
                C1371a.d(TAG, "Oplus Accessory SDK cannot be initialized");
                onError(null, "Oplus Accessory SDK cannot be initialized. Device or Build not compatible.", i10);
                handleOnErrorCode(i10);
                return;
            }
            cleanupConnections(true);
            onError(null, "Oplus Accessory Framework has died!!", i10);
            handleOnErrorCode(i10);
            return;
        }
        onServiceConnectionResponse(peerAgent, null, 10008);
        handleServiceConnectionErrorCode(10008);
    }

    public void onAuthenticationResponse(PeerAgent peerAgent, AuthenticationToken authenticationToken, int i10) {
        C1371a.c(TAG, "Peer authentication response received:" + i10);
    }

    public void onError(PeerAgent peerAgent, String str, int i10) {
        if (peerAgent == null) {
            C1371a.d(TAG, "ACCEPT_STATE_ERROR: " + i10 + ": " + str + " PeerAgent: null");
            return;
        }
        C1371a.d(TAG, "ACCEPT_STATE_ERROR: " + i10 + ": " + str + " PeerAgent: " + peerAgent.getAgentId());
    }

    public void onFindPeerAgentsResponse(PeerAgent[] peerAgentArr, int i10) {
        C1371a.d(TAG, "Invalid implementation of BaseJobAgent.onFindPeerAgentsResponse(PeerAgent[], int) should be overrided!");
    }

    public void onLowMemory() {
        C1371a.c(TAG, "Service Low Memory");
    }

    public void onPeerAgentsUpdated(PeerAgent[] peerAgentArr, int i10) {
        C1371a.d(TAG, "Invalid implementation of BaseJobAgent.onPeerAgentsUpdated(PeerAgent[], int) should be overrided!");
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

    public String registerMessageInstance(BaseMessage baseMessage) {
        this.mMessage = baseMessage;
        return this.mAgentId;
    }

    public void registerServiceProfile(ServiceProfile serviceProfile) {
        if (serviceProfile == null) {
            return;
        }
        this.mServiceProfile = serviceProfile;
        e eVar = new e(getApplicationContext());
        Future<Void> c10 = eVar.c(serviceProfile);
        eVar.f();
        try {
            c10.get();
        } catch (InterruptedException unused) {
            C1371a.d(TAG, "Regisration failed! : InterruptedException");
        } catch (ExecutionException unused2) {
            C1371a.d(TAG, "Registration failed! : ExecutionException");
        }
        r5.e.c(getApplicationContext()).d(serviceProfile);
    }

    public void rejectServiceConnectionRequest(PeerAgent peerAgent) {
        if (peerAgent != null) {
            try {
                Initializer.initBufferPool(getApplicationContext());
                if (this.mPendingRequests.remove(peerAgent)) {
                    C1371a.g(TAG, "Trying to reject connection request from peer:" + peerAgent.getAgentId() + " Transaction:" + peerAgent.getTransactionId());
                    AgentHandler agentHandler = this.mBackgroundWorker;
                    if (agentHandler != null) {
                        Message obtainMessage = agentHandler.obtainMessage(9);
                        obtainMessage.obj = peerAgent;
                        this.mBackgroundWorker.sendMessage(obtainMessage);
                        return;
                    }
                    C1371a.k(TAG, "rejectServiceConnection: mBackgroundWorker is null!");
                    return;
                }
                C1371a.k(TAG, "Rejecting service connection with invalid peer agent:" + peerAgent);
                handleInvalidPeerAction(peerAgent);
                return;
            } catch (SdkUnsupportedException e10) {
                C1371a.d(TAG, "exception: " + e10.getMessage());
                handleError(20002, peerAgent);
                return;
            }
        }
        throw new IllegalArgumentException("Illegal argument peerAgent:" + peerAgent);
    }

    public void releaseAgent() {
        Message obtainMessage = sInstanceHandler.obtainMessage(2);
        obtainMessage.obj = this;
        obtainMessage.sendToTarget();
    }

    public final void requestServiceConnection(PeerAgent peerAgent) {
        try {
            Initializer.initBufferPool(getApplicationContext());
            C1371a.g(TAG, "Service connection requested for peer:" + peerAgent.getAgentId());
            AgentHandler agentHandler = this.mBackgroundWorker;
            if (agentHandler != null) {
                Message obtainMessage = agentHandler.obtainMessage(7);
                obtainMessage.obj = peerAgent;
                this.mBackgroundWorker.sendMessage(obtainMessage);
                return;
            }
            C1371a.k(TAG, "requestServiceConection: mBackgroundWorker is null!");
        } catch (SdkUnsupportedException e10) {
            C1371a.d(TAG, "exception: " + e10.getMessage());
            handleError(20002, peerAgent);
        }
    }

    public boolean runOnBackgroundThread(Runnable runnable) {
        return this.mBackgroundWorker.post(runnable);
    }

    public void unregisterServiceProfile() {
        if (this.mServiceProfile == null) {
            C1371a.d(TAG, "unregisterServiceProfile, but serviceProfile already removed!");
            return;
        }
        try {
            this.mAdapter.unregisterServices();
        } catch (Exception e10) {
            if (e10 instanceof GeneralException) {
                handleError(((GeneralException) e10).getErrorCode(), null);
            }
            C1371a.d(TAG, "unregisterServiceProfile failed!" + e10);
        }
        r5.e.c(getApplicationContext()).e(this.mServiceProfile);
    }

    public void handleConnectionRequest(JobParameters jobParameters, IJobListener iJobListener) {
        Message obtainMessage = this.mBackgroundWorker.obtainMessage();
        obtainMessage.what = 6;
        obtainMessage.obj = iJobListener;
        Bundle bundle = new Bundle();
        bundle.putParcelable("params", jobParameters);
        obtainMessage.setData(bundle);
        this.mBackgroundWorker.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyConnectionRequest(PersistableBundle persistableBundle) {
        if (persistableBundle == null) {
            C1371a.d(TAG, "Invalid service connection indication.Intent:null.Ignoring reqeuset");
            return;
        }
        long j10 = persistableBundle.getLong("transactionId", 0L);
        String[] stringArray = persistableBundle.getStringArray("peerAgent");
        if (stringArray == null) {
            C1371a.d(TAG, "Invalid initiator peer agent. Ignoring connection request");
        } else {
            notifyConnectionRequest(j10, persistableBundle.getString(AFConstants.EXTRA_AGENT_ID), new PeerAgent((List<String>) Arrays.asList(stringArray)));
        }
    }

    public BaseJobAgent(String str, Context context, Class<? extends BaseSocket> cls) {
        if (INSTANCE_LOCK.isHeldByCurrentThread()) {
            this.mName = str;
            this.mContext = context;
            validateSocketImplementation(cls);
            this.mSocketImpl = cls;
            C1371a.c(TAG, "Thread Name:" + this.mName + "BaseSocket Imple class:" + cls.getName());
            initializeAgent();
            return;
        }
        throw new IllegalArgumentException("Constructor should not be called for initializing " + str + ". Call requestAgent API instead");
    }

    private void notifyConnectionRequest(long j10, String str, PeerAgent peerAgent) {
        if (peerAgent == null) {
            C1371a.d(TAG, "Invalid initiator peer agent:null. Ignoring connection request");
            return;
        }
        if (str == null) {
            C1371a.d(TAG, "Invalid local agent Id:null .Ignoring connection request");
            return;
        }
        peerAgent.setTransactionId(j10);
        C1371a.g(TAG, "Connection initiated by peer: " + peerAgent.getAgentId() + " on Accessory: " + peerAgent.getAccessory().getPeerId() + " Transaction: " + j10);
        this.mPendingRequests.add(peerAgent);
        onServiceConnectionRequested(peerAgent);
    }
}
