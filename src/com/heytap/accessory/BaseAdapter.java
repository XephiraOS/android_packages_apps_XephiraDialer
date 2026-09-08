package com.heytap.accessory;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.Process;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.TransactionTooLargeException;
import com.heytap.accessory.api.IDeathCallback;
import com.heytap.accessory.api.IFrameworkManager;
import com.heytap.accessory.api.IMsgExpCallback;
import com.heytap.accessory.api.IPeerAgentAuthCallback;
import com.heytap.accessory.api.IPeerAgentCallback;
import com.heytap.accessory.api.IServiceChannelCallback;
import com.heytap.accessory.api.IServiceConnectionCallback;
import com.heytap.accessory.api.IServiceConnectionIndicationCallback;
import com.heytap.accessory.api.ManagerConfig;
import com.heytap.accessory.bean.GeneralException;
import com.heytap.accessory.bean.PeerAgent;
import com.heytap.accessory.bean.ServiceProfile;
import com.heytap.accessory.constant.AFConstants;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import n5.C1371a;
import r5.g;
import r5.h;
import s5.C1551a;

/* loaded from: classes3.dex */
public final class BaseAdapter {
    public static final String ACTION_ACCESSORY_STATUS_CHANGED = "com.heytap.accessory.action.ACCESSORY_STATUS_CHANGED";
    public static final String ACTION_SERVICE_CONNECTION_REQUESTED = "com.heytap.accessory.action.SERVICE_CONNECTION_REQUESTED";
    private static final int BIND_SERVICE_MAX_ATTEMPTS = 5;
    public static final String ERROR_CODE_KEY = "errorcode";
    private static final int ERROR_FATAL = 20001;
    private static final int ERROR_PERMISSION_DENIED = 20003;
    private static final int ERROR_PERMISSION_FAILED = 20004;
    public static final String EXTRA_PEER_AGENT = "peerAgent";
    public static final String EXTRA_TRANSACTION_ID = "transactionId";
    public static final String INTERNAL_FILE_CONSUMER = "com.heytap.accessory.file.receiver.FileConsumerImpl";
    public static final String INTERNAL_STREAM_CONSUMER = "com.heytap.accessory.stream.receiver.StreamConsumerImpl";
    private static final String PACKAGE_NAME = "packageName";
    private static final String TAG = "BaseAdapter";
    private static volatile BaseAdapter sAdapter;
    private Handler mBackgroundHandler;
    private final c mConnection;
    private final Context mContext;
    private final IDeathCallback mDeathCallback;
    private ResultReceiver mProxyReceiver;
    private final ServiceConnectionIndicationCallback mScIndicationCallback;
    private volatile IFrameworkManager mServiceProxy;
    private volatile boolean mIsFtBounded = false;
    private volatile boolean mIsStBounded = false;
    private ServiceConnection mFtCConnection = new a();
    private ServiceConnection mStConnection = new b();
    private long mAppConnectionId = -1;
    private int mState = 0;
    private final Set<d> mAgentCallbacks = new HashSet();

    /* loaded from: classes3.dex */
    public static final class DeathCallbackStub extends IDeathCallback.Stub {

        /* renamed from: f, reason: collision with root package name */
        public final String f25130f;

        public DeathCallbackStub(String str) {
            this.f25130f = str;
        }

        @Override // com.heytap.accessory.api.IDeathCallback
        public String y() {
            return this.f25130f;
        }
    }

    /* loaded from: classes3.dex */
    public final class ServiceConnectionIndicationCallback extends IServiceConnectionIndicationCallback.Stub {
        public /* synthetic */ ServiceConnectionIndicationCallback(BaseAdapter baseAdapter, a aVar) {
            this();
        }

        @Override // com.heytap.accessory.api.IServiceConnectionIndicationCallback
        public void D1(Bundle bundle) {
            String simpleName;
            boolean z10;
            C1371a.g(BaseAdapter.TAG, "onServiceConnectionRequested: " + bundle);
            byte[] byteArray = bundle.getByteArray("peerAgent");
            if (byteArray == null) {
                C1371a.d(BaseAdapter.TAG, "onServiceConnectionRequested receive peerAgents is null!");
                return;
            }
            Parcel obtain = Parcel.obtain();
            obtain.unmarshall(byteArray, 0, byteArray.length);
            obtain.setDataPosition(0);
            PeerAgent createFromParcel = PeerAgent.CREATOR.createFromParcel(obtain);
            obtain.recycle();
            long j10 = bundle.getLong("transactionId", 0L);
            String string = bundle.getString(AFConstants.EXTRA_AGENT_ID);
            String string2 = bundle.getString(AFConstants.EXTRA_AGENT_IMPL_CLASS);
            if (string2 == null) {
                C1371a.d(BaseAdapter.TAG, "Implementation class not available in intent. Ignoring request");
                return;
            }
            try {
                Class<?> cls = Class.forName(string2);
                if (!P7(BaseAdapter.this.mContext, cls.getName())) {
                    C1371a.k(BaseAdapter.TAG, "invalid implClass received");
                    return;
                }
                boolean a10 = r5.d.a(BaseJobAgent.class, cls);
                PackageInfo packageInfo = BaseAdapter.this.mContext.getPackageManager().getPackageInfo(BaseAdapter.this.mContext.getPackageName(), 0);
                int i10 = packageInfo.applicationInfo.targetSdkVersion;
                String str = BaseAdapter.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("implClass.getSuperclass() :");
                if (cls.getSuperclass() == null) {
                    simpleName = "null";
                } else {
                    simpleName = cls.getSuperclass().getSimpleName();
                }
                sb.append(simpleName);
                sb.append(", isV2 = ");
                sb.append(a10);
                sb.append(", sdkInt:");
                sb.append(Build.VERSION.SDK_INT);
                sb.append(", targetSdk:");
                sb.append(i10);
                C1371a.i(str, sb.toString());
                if (i10 >= 21) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (a10 && z10) {
                    C1371a.c(BaseAdapter.TAG, "scheduleSCJob");
                    Intent intent = new Intent();
                    intent.setPackage(BaseAdapter.this.mContext.getPackageName());
                    intent.putExtra("transactionId", j10);
                    intent.putExtra(AFConstants.EXTRA_AGENT_ID, string);
                    intent.putExtra("peerAgent", createFromParcel);
                    intent.setFlags(32);
                    BaseAdapter baseAdapter = BaseAdapter.this;
                    baseAdapter.handleConnectionRequest(baseAdapter.mContext, intent, string2);
                    return;
                }
                O7(packageInfo.packageName, createFromParcel, j10, string, string2, i10);
            } catch (PackageManager.NameNotFoundException e10) {
                C1371a.d(BaseAdapter.TAG, "Agent Impl name not found!" + e10);
            } catch (ClassNotFoundException e11) {
                C1371a.d(BaseAdapter.TAG, "Agent Impl class not found!" + e11);
            }
        }

        public final void O7(String str, PeerAgent peerAgent, long j10, String str2, String str3, int i10) {
            C1371a.g(BaseAdapter.TAG, " onServiceConnectionRequested: agentImplClass=" + str3);
            Intent intent = new Intent("com.heytap.accessory.action.SERVICE_CONNECTION_REQUESTED");
            intent.setPackage(BaseAdapter.this.mContext.getPackageName());
            intent.putExtra("transactionId", j10);
            intent.putExtra(AFConstants.EXTRA_AGENT_ID, str2);
            intent.putExtra("peerAgent", peerAgent);
            intent.putExtra(AFConstants.EXTRA_AGENT_IMPL_CLASS, str3);
            intent.setClassName(BaseAdapter.this.mContext, str3);
            if (i10 >= 26) {
                int a10 = g.a(BaseAdapter.this.mContext);
                if (!ManagerConfig.ACCESSORY_FRAMEWORK_PACKAGE.equals(str) && a10 != 1000) {
                    if (str3.equals(BaseAdapter.INTERNAL_FILE_CONSUMER)) {
                        C1371a.c(BaseAdapter.TAG, "bind file Service");
                        intent.setType("file_" + System.currentTimeMillis());
                        BaseAdapter.this.mContext.bindService(intent, BaseAdapter.this.mFtCConnection, 1);
                        return;
                    }
                    if (str3.equals(BaseAdapter.INTERNAL_STREAM_CONSUMER)) {
                        C1371a.c(BaseAdapter.TAG, "bind stream Service");
                        intent.setType("stream_" + System.currentTimeMillis());
                        BaseAdapter.this.mContext.bindService(intent, BaseAdapter.this.mStConnection, 1);
                        return;
                    }
                    C1371a.c(BaseAdapter.TAG, "startForegroundService");
                    BaseAdapter.this.mContext.startForegroundService(intent);
                    return;
                }
                C1371a.c(BaseAdapter.TAG, "startService directly in OAF APP or system app");
                BaseAdapter.this.mContext.startService(intent);
                return;
            }
            C1371a.c(BaseAdapter.TAG, "startService");
            BaseAdapter.this.mContext.startService(intent);
        }

        public final synchronized boolean P7(Context context, String str) {
            boolean z10;
            try {
                r5.e c10 = r5.e.c(context);
                if (c10 != null) {
                    ServiceProfile b10 = c10.b(str);
                    if (b10 != null) {
                        if (str.equalsIgnoreCase(b10.getServiceImpl())) {
                            z10 = true;
                        }
                    } else {
                        C1371a.d(BaseAdapter.TAG, "fetch service profile description failed !!");
                    }
                } else {
                    C1371a.d(BaseAdapter.TAG, "config  util default instance  creation failed !!");
                }
                z10 = false;
            } finally {
            }
            return z10;
        }

        public ServiceConnectionIndicationCallback() {
        }
    }

    /* loaded from: classes3.dex */
    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            C1371a.c(BaseAdapter.TAG, "Connected to consumer FT service");
            BaseAdapter.this.mIsFtBounded = true;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            C1371a.c(BaseAdapter.TAG, "File transfer connection closed");
            BaseAdapter.this.mIsFtBounded = false;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ServiceConnection {
        public b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            C1371a.c(BaseAdapter.TAG, "Connected to consumer FT service");
            BaseAdapter.this.mIsStBounded = true;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            C1371a.c(BaseAdapter.TAG, "File transfer connection closed");
            BaseAdapter.this.mIsStBounded = false;
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements ServiceConnection {
        public /* synthetic */ c(a aVar) {
            this();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (BaseAdapter.sAdapter) {
                if (iBinder != null) {
                    try {
                        C1371a.c(BaseAdapter.TAG, "Accessory service connected");
                        BaseAdapter.sAdapter.mServiceProxy = IFrameworkManager.Stub.N7(iBinder);
                        if (!BaseAdapter.access$1100()) {
                            return;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                BaseAdapter.sAdapter.notifyAll();
                BaseAdapter.sAdapter.notifyConnection();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (BaseAdapter.sAdapter) {
                C1371a.k(BaseAdapter.TAG, "Accessory service disconnected");
                BaseAdapter.sAdapter.setState(0);
                BaseAdapter.sAdapter.cleanup(false);
            }
        }

        public c() {
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a();

        void b();

        void c();
    }

    private BaseAdapter(Context context, Handler handler) {
        this.mContext = context;
        a aVar = null;
        this.mConnection = new c(aVar);
        this.mDeathCallback = new DeathCallbackStub(context.getPackageName());
        this.mScIndicationCallback = new ServiceConnectionIndicationCallback(this, aVar);
        this.mBackgroundHandler = handler;
    }

    public static /* synthetic */ boolean access$1100() {
        return makeFrameworkConnection();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void cleanup(boolean z10) {
        if (z10) {
            try {
                tearFrameworkConnection();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (sAdapter.mState == 1) {
            this.mContext.unbindService(this.mConnection);
        }
        sAdapter.mAppConnectionId = -1L;
        setState(0);
        sAdapter.mServiceProxy = null;
        Iterator<d> it = sAdapter.mAgentCallbacks.iterator();
        while (it.hasNext()) {
            it.next().c();
        }
    }

    private synchronized void doBindFramework() {
        try {
            if (sAdapter.mServiceProxy == null) {
                setState(0);
                try {
                    C1371a.g(TAG, "adapter context packageName - " + this.mContext.getPackageName());
                    Intent intent = new Intent("com.heytap.accessory.action.FRAMEWORK_MANAGER");
                    if (Initializer.useOAFApp()) {
                        intent.setPackage(ManagerConfig.ACCESSORY_FRAMEWORK_PACKAGE);
                    } else {
                        intent.setPackage(this.mContext.getPackageName());
                    }
                    intent.putExtra("accessory_framework_request_package", this.mContext.getPackageName());
                    for (int i10 = 1; needToRebind(i10); i10++) {
                        if (this.mContext.bindService(intent, sAdapter.mConnection, 33)) {
                            try {
                                C1371a.g(TAG, "getDefaultAdapter: About start waiting");
                                sAdapter.wait(10000L);
                            } catch (InterruptedException e10) {
                                setState(-1);
                                throw new GeneralException(20001, "Failed to Bind to Accessory Framework - Action interrupted!", e10);
                            }
                        } else {
                            C1371a.d(TAG, "getDefaultAdapter: Binding to Accessory service failed!");
                            setState(-1);
                            throw new GeneralException(20001, "Is the Accessory Service Framework installed?!");
                        }
                    }
                    if (sAdapter.mServiceProxy != null) {
                        C1371a.g(TAG, "Application is now connected to Accessory Framework!");
                    } else {
                        C1371a.d(TAG, "Unable to bind to Accessory Service");
                        setState(-1);
                        throw new GeneralException(20001, "Unable to bind to Accessory Service!");
                    }
                } catch (SecurityException unused) {
                    C1371a.d(TAG, "getDefaultAdapter: Permission denied! Binding to Accessory service failed!");
                    setState(-1);
                    if (h.a(this.mContext)) {
                        throw new GeneralException(20004, "Permission validation failed to bind to  Accessory Service! Please re-install the application and try again.");
                    }
                    throw new GeneralException(20003, "Permission denied to bind to Accessory Service! Please add permission and try again.");
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static BaseAdapter getDefaultAdapter(Context context) {
        if (sAdapter == null) {
            synchronized (BaseAdapter.class) {
                try {
                    if (sAdapter == null) {
                        sAdapter = new BaseAdapter(context.getApplicationContext(), null);
                    }
                } finally {
                }
            }
        }
        return sAdapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleConnectionRequest(Context context, Intent intent, String str) {
        C1371a.c(TAG, "handleConnectionRequest ");
        BaseJobAgent.requestAgent(context, str, new com.heytap.accessory.d(1, intent));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bindToFramework$0() {
        try {
            doBindFramework();
        } catch (GeneralException e10) {
            C1371a.e(TAG, "bindToFramework failed!", e10);
        }
    }

    private static boolean makeFrameworkConnection() {
        Bundle p52;
        try {
            p52 = sAdapter.mServiceProxy.p5(Process.myPid(), sAdapter.mContext.getPackageName(), sAdapter.mDeathCallback, Config.getSdkVersionCode(), sAdapter.mScIndicationCallback);
        } catch (Exception e10) {
            C1371a.e(TAG, "Unable to setup client Identity.", e10);
            sAdapter.setState(-1);
            sAdapter.notifyDisconnection(e10);
        }
        if (p52 == null) {
            C1371a.d(TAG, "Unable to setup client Identity.Invalid response from Framework");
            return false;
        }
        sAdapter.mAppConnectionId = p52.getLong(AFConstants.EXTRA_CLIENT_ID, -1L);
        if (sAdapter.mAppConnectionId == -1) {
            sAdapter.setState(-1);
            C1371a.d(TAG, "Unable to setup client Identity.Error:" + p52.getInt("errorcode"));
            return false;
        }
        String str = TAG;
        C1371a.g(str, "Received AppConnectionId:" + sAdapter.mAppConnectionId);
        sAdapter.setState(1);
        int i10 = p52.getInt(AFConstants.EXTRA_KEY_PROCESS_ID);
        if (i10 == Process.myPid()) {
            sAdapter.mProxyReceiver = sAdapter.mServiceProxy.F3(sAdapter.mAppConnectionId);
            C1371a.g(str, "Running in OAF process, Updated my proxy: " + sAdapter.mProxyReceiver);
        }
        h.l(i10);
        h.j(p52.getInt(AFConstants.EXTRA_KEY_MAX_HEADER_LEN));
        h.i(p52.getInt(AFConstants.EXTRA_KEY_MAX_FOOTER_LEN));
        h.k(p52.getInt(AFConstants.EXTRA_KEY_MAX_MSG_HEADER_LEN));
        h.h(p52.getInt("framework_compatible_version"));
        return true;
    }

    private boolean needToRebind(int i10) {
        if (sAdapter.mAppConnectionId == -1 && getState() == 0 && i10 <= 5) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void notifyConnection() {
        Iterator<d> it = sAdapter.mAgentCallbacks.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    private synchronized void notifyDisconnection(Exception exc) {
        try {
            if (exc instanceof TransactionTooLargeException) {
                C1371a.l(TAG, "Remote call failed, binder transaction buffer low", exc);
                cleanup(true);
            } else {
                C1371a.l(TAG, "Remote call failed", exc);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private synchronized void tearFrameworkConnection() {
        if (this.mServiceProxy == null) {
            C1371a.g(TAG, "Binding to framework does not exists");
        } else {
            try {
                try {
                    this.mServiceProxy.b7(this.mAppConnectionId);
                } catch (RemoteException e10) {
                    C1371a.l(TAG, "Failed to tear framework connection", e10);
                }
            } finally {
                cleanup(false);
            }
        }
    }

    public Bundle acceptServiceConnection(String str, PeerAgent peerAgent, long j10, IServiceConnectionCallback iServiceConnectionCallback, IServiceChannelCallback iServiceChannelCallback) {
        if (sAdapter.mServiceProxy == null) {
            bindToFramework();
        }
        try {
            Bundle v22 = this.mServiceProxy.v2(this.mAppConnectionId, str, peerAgent, j10, iServiceConnectionCallback, iServiceChannelCallback);
            if (v22 != null) {
                if (!v22.containsKey("errorcode")) {
                    if (v22.getString(AFConstants.EXTRA_CONNECTION_ID) != null) {
                        return v22;
                    }
                    C1371a.d(TAG, "acceptServiceConnection:Invalid response from Accessory Framework- connectionId: null");
                    throw new RuntimeException("acceptServiceConnection:Invalid response from Accessory Framework- connectionId:");
                }
                throw new GeneralException(v22.getInt("errorcode"), "Failed to accept connection request!");
            }
            C1371a.d(TAG, "acceptServiceConnection:Invalid response from Accessory Framework:null");
            throw new RuntimeException("acceptServiceConnection:Invalid response from Accessory Framework:");
        } catch (RemoteException e10) {
            C1371a.l(TAG, "Failed to accept service connection", e10);
            notifyDisconnection(e10);
            throw new GeneralException(20001, "acceptServiceConnection:Remote call failed");
        }
    }

    public int authenticatePeeragent(String str, PeerAgent peerAgent, IPeerAgentAuthCallback iPeerAgentAuthCallback, long j10) {
        if (sAdapter.mServiceProxy == null) {
            bindToFramework();
        }
        try {
            return this.mServiceProxy.A5(this.mAppConnectionId, str, peerAgent, iPeerAgentAuthCallback, j10);
        } catch (RemoteException e10) {
            C1371a.l(TAG, "Failed to request peer authentication", e10);
            this.notifyDisconnection(e10);
            throw new GeneralException(20001, "authenticatePeeragent:Remote call failed");
        }
    }

    public void bindToFramework() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            String str = TAG;
            C1371a.k(str, "It's in main thread,need to switch to sub thread!");
            Handler handler = this.mBackgroundHandler;
            if (handler == null) {
                C1371a.c(str, "BackgroundHandler is null, so just return!");
                return;
            } else {
                handler.post(new Runnable() { // from class: com.heytap.accessory.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        BaseAdapter.this.lambda$bindToFramework$0();
                    }
                });
                return;
            }
        }
        try {
            doBindFramework();
        } catch (GeneralException e10) {
            C1371a.e(TAG, "bindToFramework failed!", e10);
        }
    }

    public synchronized int checkAuthentication() {
        if (sAdapter.mServiceProxy == null) {
            bindToFramework();
        }
        try {
            if (sAdapter.mServiceProxy == null) {
                return 1009;
            }
            return sAdapter.mServiceProxy.J3(Config.getSdkVersionCode());
        } catch (RemoteException e10) {
            C1371a.l(TAG, "Service authenticate failed", e10);
            notifyDisconnection(e10);
            throw new GeneralException(20001, "authenticate:Remote call failed");
        }
    }

    public void cleanupAgent(String str) {
        if (sAdapter.mServiceProxy == null) {
            C1371a.k(TAG, "Binding to framework does not exists");
            return;
        }
        try {
            this.mServiceProxy.f5(this.mAppConnectionId, str);
        } catch (RemoteException e10) {
            C1371a.l(TAG, "Failed to cleanup agent details", e10);
        }
    }

    public void cleanupChannel(String str, int i10) {
        if (sAdapter.mServiceProxy == null) {
            C1371a.k(TAG, "cleanupChannel failed, Binding to framework does not exists");
            return;
        }
        try {
            this.mServiceProxy.L0(this.mAppConnectionId, str, i10);
        } catch (RemoteException e10) {
            C1371a.l(TAG, "Failed to cleanupChannelCache", e10);
            throw new GeneralException(20001, "authenticatePeeragent:Remote call failed");
        }
    }

    public int closeServiceConnection(String str) {
        if (sAdapter.mServiceProxy == null) {
            return BaseSocket.ERROR_CONNECTION_ALREADY_CLOSED;
        }
        try {
            return this.mServiceProxy.p2(this.mAppConnectionId, str);
        } catch (RemoteException e10) {
            C1371a.l(TAG, "Failed to close service connection", e10);
            this.notifyDisconnection(e10);
            throw new GeneralException(20001, "closeServiceConnection:Remote call failed");
        }
    }

    public int findPeerAgents(String str, IPeerAgentCallback iPeerAgentCallback) {
        if (sAdapter.mServiceProxy == null) {
            bindToFramework();
        }
        try {
            if (sAdapter.mServiceProxy != null) {
                return sAdapter.mServiceProxy.j5(this.mAppConnectionId, -1L, str, iPeerAgentCallback);
            }
            throw new GeneralException(20001, "findPeerAgents:mServiceProxy is null");
        } catch (RemoteException e10) {
            C1371a.l(TAG, "Failed to initiate peer discovery", e10);
            notifyDisconnection(e10);
            throw new GeneralException(20001, "findPeerAgents:Remote call failed");
        }
    }

    public Bundle getAgentDetails(String str) {
        if (sAdapter.mServiceProxy == null) {
            bindToFramework();
        }
        try {
            return this.mServiceProxy.v0(this.mAppConnectionId, str);
        } catch (RemoteException e10) {
            C1371a.l(TAG, "Failed to get agent details", e10);
            this.notifyDisconnection(e10);
            throw new GeneralException(20001, "getAgentDetails: Remote call failed");
        }
    }

    public String getAgentId(String str, String str2) {
        if (sAdapter.mServiceProxy == null) {
            bindToFramework();
        }
        try {
            if (sAdapter.mServiceProxy != null) {
                return sAdapter.mServiceProxy.x3(this.mAppConnectionId, str, str2);
            }
            throw new GeneralException(20001, "getAgentId:mServiceProxy is null");
        } catch (RemoteException e10) {
            C1371a.l(TAG, "Failed to fetch agent ID", e10);
            notifyDisconnection(e10);
            throw new GeneralException(20001, "getAgentId:Remote call failed");
        }
    }

    public synchronized String getLocalAgentId(String str) {
        Bundle bundle;
        try {
            if (sAdapter.mServiceProxy == null) {
                bindToFramework();
            } else if (this.mAppConnectionId == -1 && !makeFrameworkConnection()) {
                return null;
            }
            try {
                if (sAdapter.mServiceProxy != null) {
                    bundle = sAdapter.mServiceProxy.D5(this.mAppConnectionId, str);
                } else {
                    bundle = null;
                }
                if (bundle == null) {
                    C1371a.e(TAG, "getLocalAgentId failed", new RuntimeException("Get Local agent ID:Invalid response from accessory framework - null"));
                } else if (bundle.containsKey("errorcode")) {
                    int i10 = bundle.getInt("errorcode");
                    C1371a.e(TAG, "getLocalAgentId failed", new GeneralException(i10, "Failed to fetch localAgent ID, errorCode = " + i10));
                } else {
                    String string = bundle.getString(AFConstants.EXTRA_AGENT_ID);
                    if (string == null) {
                        C1371a.e(TAG, "getLocalAgentId failed", new RuntimeException("Get Local agent ID:Invalid response - localAgentID:null"));
                    } else {
                        return string;
                    }
                }
                return null;
            } catch (RemoteException e10) {
                C1371a.l(TAG, "Failed to fetch localAgent ID", e10);
                notifyDisconnection(e10);
                throw new GeneralException(20001, "getLocalAgentId:Remote call failed");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public String getPackageName() {
        return this.mContext.getPackageName();
    }

    public synchronized int getState() {
        return this.mState;
    }

    public int getVersion() {
        if (sAdapter.mServiceProxy == null) {
            bindToFramework();
        }
        try {
            if (sAdapter.mServiceProxy != null) {
                return sAdapter.mServiceProxy.getVersion();
            }
            throw new GeneralException(20001, "getVersion:mServiceProxy is null");
        } catch (RemoteException e10) {
            C1371a.l(TAG, "Failed to get version", e10);
            notifyDisconnection(e10);
            throw new GeneralException(20001, "getVersion:Remote call failed");
        }
    }

    public boolean isSocketConnected(String str) {
        if (sAdapter.mServiceProxy == null) {
            bindToFramework();
        }
        try {
            return this.mServiceProxy.t6(this.mAppConnectionId, str);
        } catch (RemoteException e10) {
            C1371a.l(TAG, "Failed to fetch socket connection status", e10);
            this.notifyDisconnection(e10);
            throw new GeneralException(20001, "isSocketConnected:Remote call failed");
        }
    }

    public synchronized void recycle(byte[] bArr) {
        if (sAdapter.mProxyReceiver != null) {
            Bundle bundle = new Bundle();
            bundle.putByteArray(AFConstants.EXTRA_READ_BYTES, bArr);
            sAdapter.mProxyReceiver.send(0, bundle);
        }
    }

    public synchronized void registerAgentCallback(d dVar) {
        this.mAgentCallbacks.add(dVar);
        C1371a.c(TAG, "Agent callback added. Current size - " + this.mAgentCallbacks.size());
    }

    public void registerMexCallback(String str, IMsgExpCallback iMsgExpCallback) {
        if (sAdapter.mServiceProxy == null) {
            bindToFramework();
        }
        try {
            if (sAdapter.mServiceProxy != null) {
                sAdapter.mServiceProxy.U1(this.mAppConnectionId, str, iMsgExpCallback);
            }
        } catch (RemoteException e10) {
            C1371a.l(TAG, "Failed to register mex callback", e10);
            notifyDisconnection(e10);
            throw new GeneralException(20001, "registerMexCallback: Remote call failed");
        }
    }

    public synchronized void registerServices(byte[] bArr) {
        if (sAdapter.mServiceProxy == null) {
            bindToFramework();
        }
        try {
            if (sAdapter.mServiceProxy != null) {
                sAdapter.mServiceProxy.m5(this.mAppConnectionId, bArr);
            }
            Iterator<d> it = this.mAgentCallbacks.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        } catch (RemoteException e10) {
            C1371a.l(TAG, "Service registration call failed", e10);
            notifyDisconnection(e10);
            throw new GeneralException(20001, "registerServices:Remote call failed");
        }
    }

    public void rejectServiceConnection(String str, PeerAgent peerAgent, long j10) {
        if (sAdapter.mServiceProxy == null) {
            bindToFramework();
        }
        try {
            this.mServiceProxy.q0(this.mAppConnectionId, str, peerAgent, j10);
        } catch (RemoteException e10) {
            C1371a.l(TAG, "Failed to reject service connection", e10);
            notifyDisconnection(e10);
            throw new GeneralException(20001, "rejectServiceConnection:Remote call failed");
        }
    }

    public int requestServiceConnection(String str, PeerAgent peerAgent, IServiceConnectionCallback iServiceConnectionCallback, IServiceChannelCallback iServiceChannelCallback) {
        if (sAdapter.mServiceProxy == null) {
            bindToFramework();
        }
        try {
            return this.mServiceProxy.S1(this.mAppConnectionId, str, peerAgent, iServiceConnectionCallback, iServiceChannelCallback);
        } catch (RemoteException e10) {
            C1371a.l(TAG, "Failed to request service connection", e10);
            this.notifyDisconnection(e10);
            throw new GeneralException(20001, "requestServiceConnection:Remote call failed");
        }
    }

    public int send(f fVar) {
        if (sAdapter.mServiceProxy == null) {
            bindToFramework();
        }
        try {
            C1371a.i(TAG, "sendData,connectionId:" + fVar.c() + ",channelId:" + fVar.a() + ",dataLen:" + fVar.d().length + ",compatibleVersion:" + h.b());
            if (sAdapter.mServiceProxy != null) {
                if (h.b() >= 1) {
                    return this.mServiceProxy.Q5(fVar.g().getAccessoryId(), fVar.g().getAgentId(), this.mAppConnectionId, fVar.c(), fVar.a(), fVar.d(), fVar.i(), fVar.e(), fVar.f(), fVar.b(), fVar.h());
                }
                return this.mServiceProxy.s7(this.mAppConnectionId, fVar.c(), fVar.a(), fVar.d(), fVar.i(), fVar.e(), fVar.f(), fVar.b());
            }
            throw new GeneralException(20001, "send: sAdapter.mServiceProxy == null");
        } catch (RemoteException e10) {
            C1371a.l(TAG, "Failed send data for connection:" + fVar.c(), e10);
            notifyDisconnection(e10);
            throw new GeneralException(20001, "send: Remote call failed");
        }
    }

    public int sendMessage(String str, PeerAgent peerAgent, boolean z10, C1551a c1551a, int i10) {
        String agentId = peerAgent.getAgentId();
        long accessoryId = peerAgent.getAccessoryId();
        byte[] b10 = c1551a.b();
        int c10 = c1551a.c();
        if (sAdapter.mServiceProxy == null) {
            bindToFramework();
        }
        if (sAdapter.mServiceProxy != null) {
            try {
                return sAdapter.mServiceProxy.Y5(this.mAppConnectionId, str, agentId, accessoryId, b10, z10, i10, c10);
            } catch (RemoteException e10) {
                C1371a.k(TAG, "Failed to send messages " + e10);
                notifyDisconnection(e10);
                throw new GeneralException(20001, "sendMessage: Remote call failed");
            }
        }
        throw new GeneralException(20001, "proxy is null, bind oaf service failed. try agent. ");
    }

    public void sendMessageDeliveryStatus(long j10, String str, int i10, int i11) {
        if (sAdapter.mServiceProxy == null) {
            bindToFramework();
        }
        try {
            if (sAdapter.mServiceProxy != null) {
                sAdapter.mServiceProxy.u6(this.mAppConnectionId, j10, str, i10, i11);
            }
        } catch (RemoteException e10) {
            C1371a.l(TAG, "Failed to send message delivery status", e10);
            notifyDisconnection(e10);
            throw new GeneralException(20001, "sendMessageDeliveryStatus: Remote call failed");
        }
    }

    public synchronized void setState(int i10) {
        this.mState = i10;
    }

    public synchronized void unbindTransferService() {
        try {
            if (this.mIsFtBounded) {
                this.mIsFtBounded = false;
                C1371a.c(TAG, "unbindService mFtCConnection");
                this.mContext.unbindService(this.mFtCConnection);
            }
            if (this.mIsStBounded) {
                this.mIsStBounded = false;
                C1371a.c(TAG, "unbindService mStConnection");
                this.mContext.unbindService(this.mStConnection);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void unregisterAgentCallback(d dVar) {
        this.mAgentCallbacks.remove(dVar);
        String str = TAG;
        C1371a.c(str, "Agent callback removed. Current size - " + this.mAgentCallbacks.size());
        if (this.mAgentCallbacks.isEmpty()) {
            C1371a.g(str, "All clients have unregistered.Disconnection from Accessory Framework.");
            cleanup(true);
        }
    }

    public void unregisterMexCallback(String str) {
        if (sAdapter.mServiceProxy != null) {
            try {
                sAdapter.mServiceProxy.t0(this.mAppConnectionId, str);
            } catch (RemoteException e10) {
                C1371a.l(TAG, "Failed to unregister mex callback", e10);
                notifyDisconnection(e10);
                throw new GeneralException(20001, "unregisterMexCallback: Remote call failed");
            }
        }
    }

    public synchronized void unregisterServices() {
        try {
            if (sAdapter.mServiceProxy == null) {
                bindToFramework();
            }
            Bundle bundle = new Bundle();
            bundle.putString("packageName", getPackageName());
            try {
                if (sAdapter.mServiceProxy != null) {
                    sAdapter.mServiceProxy.s1(this.mAppConnectionId, bundle);
                    C1371a.c(TAG, "unregisterServiceProfile success");
                }
            } catch (RemoteException e10) {
                C1371a.l(TAG, "unregisterServices call failed", e10);
                notifyDisconnection(e10);
                throw new GeneralException(20001, "unregisterServices:Remote call failed");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static synchronized BaseAdapter getDefaultAdapter(Context context, Handler handler) {
        BaseAdapter baseAdapter;
        synchronized (BaseAdapter.class) {
            try {
                Context applicationContext = context.getApplicationContext();
                if (sAdapter == null) {
                    sAdapter = new BaseAdapter(applicationContext, handler);
                }
                baseAdapter = sAdapter;
            } catch (Throwable th) {
                throw th;
            }
        }
        return baseAdapter;
    }

    public synchronized boolean checkAuthentication(String str) {
        if (sAdapter.mServiceProxy == null) {
            bindToFramework();
        }
        try {
            if (sAdapter.mServiceProxy == null) {
                return false;
            }
            return sAdapter.mServiceProxy.c(Config.getSdkVersionCode(), str);
        } catch (RemoteException e10) {
            C1371a.l(TAG, "Service authenticate failed", e10);
            notifyDisconnection(e10);
            throw new GeneralException(20001, "authenticate:Remote call failed");
        }
    }

    public synchronized void registerServices(Bundle bundle) {
        try {
            if (sAdapter.mServiceProxy == null) {
                bindToFramework();
            }
            bundle.putString("packageName", getPackageName());
            try {
                if (sAdapter.mServiceProxy != null) {
                    sAdapter.mServiceProxy.g1(this.mAppConnectionId, bundle);
                }
                Iterator<d> it = this.mAgentCallbacks.iterator();
                while (it.hasNext()) {
                    it.next().a();
                }
            } catch (RemoteException e10) {
                C1371a.l(TAG, "registerServices call failed", e10);
                notifyDisconnection(e10);
                throw new GeneralException(20001, "registerServices:Remote call failed");
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
