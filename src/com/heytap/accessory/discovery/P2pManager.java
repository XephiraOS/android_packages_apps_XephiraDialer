package com.heytap.accessory.discovery;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.heytap.accessory.api.IDiscoveryNativeService;
import com.heytap.accessory.api.IWifiP2pChangeReceiver;
import com.heytap.accessory.api.IWifiP2pService;
import com.heytap.accessory.api.ManagerConfig;
import com.heytap.accessory.bean.DeviceInfo;
import com.heytap.accessory.bean.DiscoveryException;
import com.heytap.accessory.constant.AFConstants;
import com.heytap.accessory.discovery.BaseManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import n5.C1371a;

/* loaded from: classes3.dex */
public class P2pManager extends BaseManager {
    private static final String PREFIX = "p2p_";
    private static final String TAG = "P2pManager";
    private static volatile P2pManager sInstance;
    private Context mContext;
    private volatile IP2pCallback mIP2pCallback;
    private String mPackageName;
    private volatile IDiscoveryNativeService mProxy;
    private volatile IWifiP2pService mService;
    private final Set<BaseManager.b> mManagerCallbackSet = new HashSet();
    private WifiP2pChangeReceiver mReceiver = new WifiP2pChangeReceiver(this, null);

    /* loaded from: classes3.dex */
    public class WifiP2pChangeReceiver extends IWifiP2pChangeReceiver.Stub {
        public WifiP2pChangeReceiver() {
        }

        @Override // com.heytap.accessory.api.IWifiP2pChangeReceiver
        public void onStateChange(DeviceInfo deviceInfo, int i10, int i11) {
            if (P2pManager.this.mIP2pCallback != null) {
                P2pManager.this.mIP2pCallback.onStateChange(deviceInfo, i10, i11);
            } else {
                C1371a.k(P2pManager.TAG, "onStateChange failed, IP2pCallback is null");
            }
        }

        public /* synthetic */ WifiP2pChangeReceiver(P2pManager p2pManager, a aVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public class a implements j {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IP2pStateChangeListener f25255a;

        public a(IP2pStateChangeListener iP2pStateChangeListener) {
            this.f25255a = iP2pStateChangeListener;
        }

        @Override // com.heytap.accessory.discovery.j
        public void run() {
            P2pManager.this.setP2pChangeListenerInternal(this.f25255a);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements j {
        public b() {
        }

        @Override // com.heytap.accessory.discovery.j
        public void run() {
            P2pManager.this.removeP2pChangeListenerInternal();
        }
    }

    private P2pManager() {
    }

    private boolean bindService(Context context) {
        if (this.mService != null) {
            C1371a.g(TAG, "already bind service");
            return true;
        }
        Intent intent = new Intent(AFConstants.SCAN_SERVICE_INTENT);
        intent.setPackage(ManagerConfig.ACCESSORY_FRAMEWORK_PACKAGE);
        intent.putExtra(AFConstants.KEY_SUB_SERVICE, 3);
        return context.bindService(intent, this, 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private synchronized boolean bindServiceSync(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z10 = false;
        if (!bindService(context)) {
            C1371a.d(TAG, "bindServiceSync failed");
            return false;
        }
        try {
            try {
                wait(9000L);
            } finally {
                C1371a.g(TAG, "bind service cost: " + (System.currentTimeMillis() - currentTimeMillis));
            }
        } catch (InterruptedException e10) {
            C1371a.d(TAG, "bindServiceSync failed, InterruptedException: " + e10.getMessage());
            e10.printStackTrace();
        }
        if (this.mService != null) {
            z10 = true;
        }
        return z10;
    }

    public static P2pManager getInstance() {
        if (sInstance == null) {
            synchronized (P2pManager.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new P2pManager();
                    }
                } finally {
                }
            }
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$onSubServiceConnected$0(BaseManager.b bVar) {
        boolean z10 = !bVar.f25221a;
        bVar.f25221a = true;
        return z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeP2pChangeListenerInternal() {
        if (this.mService == null) {
            C1371a.d(TAG, "inner scan service is null");
            return;
        }
        try {
            this.mService.l3(this.mContext.getPackageName());
        } catch (Exception e10) {
            C1371a.f(TAG, e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setP2pChangeListenerInternal(IP2pStateChangeListener iP2pStateChangeListener) {
        if (this.mService == null) {
            C1371a.d(TAG, "inner scan service is null");
            return;
        }
        try {
            this.mService.Z2(this.mContext.getPackageName(), iP2pStateChangeListener);
        } catch (Exception e10) {
            C1371a.f(TAG, e10);
        }
    }

    public List<DeviceInfo> getConnectedDevices() {
        C1371a.g(TAG, "getConnectedDevices");
        if (this.mService != null) {
            return this.mService.X5();
        }
        if (this.mProxy == null && this.mContext != null) {
            C1371a.g(TAG, "getConnectedDevices, just bind service");
            runOnBackGround(this.mContext, null);
        }
        throw new RemoteException("Service not connected.");
    }

    @Override // com.heytap.accessory.discovery.BaseManager
    public /* bridge */ /* synthetic */ int getFpCoreVersion() {
        return super.getFpCoreVersion();
    }

    @Override // com.heytap.accessory.discovery.BaseManager
    public String getPackageName() {
        return PREFIX + this.mPackageName;
    }

    @Override // com.heytap.accessory.discovery.BaseManager
    public /* bridge */ /* synthetic */ int getServiceVersion() {
        return super.getServiceVersion();
    }

    public synchronized boolean init(Context context, IP2pCallback iP2pCallback) {
        try {
            C1371a.g(TAG, "init");
            if (this.mIP2pCallback != iP2pCallback) {
                this.mIP2pCallback = iP2pCallback;
            }
            boolean z10 = true;
            if (this.mService != null) {
                return true;
            }
            if (this.mProxy != null) {
                this.mService = this.mProxy.B5();
                if (this.mService != null) {
                    synchronized (this) {
                        this.mService.z2(this.mReceiver);
                    }
                }
                return true;
            }
            Context applicationContext = context.getApplicationContext();
            this.mContext = applicationContext;
            BaseManager.initAFMAccessory(applicationContext);
            this.mPackageName = this.mContext.getPackageName();
            if (!bindServiceSync(this.mContext)) {
                return false;
            }
            if (this.mService == null) {
                z10 = false;
            }
            return z10;
        } catch (Throwable th) {
            throw th;
        }
    }

    public void initAsync(Context context, IP2pCallback iP2pCallback, IManagerCallback iManagerCallback) {
        C1371a.g(TAG, "initAsync");
        if (this.mIP2pCallback != iP2pCallback) {
            this.mIP2pCallback = iP2pCallback;
        }
        if (this.mService != null) {
            iManagerCallback.onInited();
            return;
        }
        try {
            if (this.mProxy != null) {
                this.mService = this.mProxy.B5();
                if (this.mService != null) {
                    if (this.mService != null) {
                        synchronized (this) {
                            this.mService.z2(this.mReceiver);
                        }
                    }
                    iManagerCallback.onInited();
                    return;
                }
            } else {
                C1371a.g(TAG, "current proxy is null, go bind OAFP2pManager");
            }
        } catch (RemoteException e10) {
            C1371a.k(TAG, "initAsync getWfiP2pService failed，" + e10);
        }
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        BaseManager.initAFMAccessory(applicationContext);
        this.mPackageName = this.mContext.getPackageName();
        synchronized (this.mManagerCallbackSet) {
            this.mManagerCallbackSet.add(new BaseManager.b(false, iManagerCallback));
        }
        if (!bindService(this.mContext)) {
            C1371a.d(TAG, "initAsync, bind ScanService failed");
            onSubServiceDisconnected();
        }
    }

    public String joinP2p(DeviceInfo deviceInfo) {
        C1371a.g(TAG, "joinP2p");
        if (this.mService != null) {
            if (deviceInfo != null) {
                return this.mService.i5(deviceInfo);
            }
            throw new NullPointerException("device null exception");
        }
        throw new RemoteException("Service not connected.");
    }

    public void leaveP2p(DeviceInfo deviceInfo) {
        C1371a.g(TAG, "leaveP2p");
        if (this.mService != null) {
            if (deviceInfo != null) {
                this.mService.V4(deviceInfo);
                return;
            }
            throw new NullPointerException("device null exception");
        }
        throw new RemoteException("Service not connected.");
    }

    @Override // com.heytap.accessory.discovery.BaseManager, android.content.ServiceConnection
    public /* bridge */ /* synthetic */ void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        super.onServiceConnected(componentName, iBinder);
    }

    @Override // com.heytap.accessory.discovery.BaseManager, android.content.ServiceConnection
    public /* bridge */ /* synthetic */ void onServiceDisconnected(ComponentName componentName) {
        super.onServiceDisconnected(componentName);
    }

    @Override // com.heytap.accessory.discovery.BaseManager
    public void onSubBindService(Context context) {
        bindServiceSync(context);
    }

    @Override // com.heytap.accessory.discovery.BaseManager
    public void onSubServiceConnected(IDiscoveryNativeService iDiscoveryNativeService) {
        List list;
        C1371a.g(TAG, "onSubServiceConnected");
        this.mProxy = iDiscoveryNativeService;
        synchronized (this) {
            try {
                try {
                    this.mService = this.mProxy.B5();
                    if (this.mService != null) {
                        this.mService.z2(this.mReceiver);
                    }
                    notifyAll();
                } catch (RemoteException e10) {
                    C1371a.l(TAG, "", e10);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        new ArrayList();
        synchronized (this.mManagerCallbackSet) {
            list = (List) this.mManagerCallbackSet.stream().filter(new Predicate() { // from class: com.heytap.accessory.discovery.o
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    boolean lambda$onSubServiceConnected$0;
                    lambda$onSubServiceConnected$0 = P2pManager.lambda$onSubServiceConnected$0((BaseManager.b) obj);
                    return lambda$onSubServiceConnected$0;
                }
            }).map(new Function() { // from class: com.heytap.accessory.discovery.p
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    IManagerCallback iManagerCallback;
                    iManagerCallback = ((BaseManager.b) obj).f25222b;
                    return iManagerCallback;
                }
            }).collect(Collectors.toList());
        }
        list.forEach(new g());
    }

    @Override // com.heytap.accessory.discovery.BaseManager
    public void onSubServiceDisconnected() {
        List list;
        this.mService = null;
        new ArrayList();
        synchronized (this.mManagerCallbackSet) {
            list = (List) this.mManagerCallbackSet.stream().map(new Function() { // from class: com.heytap.accessory.discovery.q
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    IManagerCallback iManagerCallback;
                    iManagerCallback = ((BaseManager.b) obj).f25222b;
                    return iManagerCallback;
                }
            }).collect(Collectors.toList());
            this.mManagerCallbackSet.clear();
        }
        list.forEach(new i());
    }

    public synchronized void release(Context context) {
        release();
    }

    public void removeP2pChangeListener() {
        Context context;
        if (this.mService != null) {
            removeP2pChangeListenerInternal();
            return;
        }
        if (this.mProxy == null && (context = this.mContext) != null) {
            runOnBackGround(context, new b());
        }
        throw DiscoveryException.create(2, "start inner Scan failed, service and context is null");
    }

    public void setP2pChangeListener(IP2pStateChangeListener iP2pStateChangeListener) {
        Context context;
        if (this.mService != null) {
            setP2pChangeListenerInternal(iP2pStateChangeListener);
            return;
        }
        if (this.mProxy == null && (context = this.mContext) != null) {
            runOnBackGround(context, new a(iP2pStateChangeListener));
        }
        throw DiscoveryException.create(2, "start inner Scan failed, service and context is null");
    }

    public synchronized void release() {
        try {
            C1371a.g(TAG, "release");
            if (this.mService != null) {
                this.mService.K7(this.mReceiver);
            }
            Context context = this.mContext;
            if (context != null) {
                context.unbindService(this);
            }
            this.mService = null;
            this.mContext = null;
            synchronized (this.mManagerCallbackSet) {
                this.mManagerCallbackSet.clear();
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
