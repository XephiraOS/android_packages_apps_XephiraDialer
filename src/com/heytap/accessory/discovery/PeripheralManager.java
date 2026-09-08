package com.heytap.accessory.discovery;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.heytap.accessory.api.IDiscoveryNativeService;
import com.heytap.accessory.api.IPeripheralCallback;
import com.heytap.accessory.api.IPeripheralService;
import com.heytap.accessory.api.ManagerConfig;
import com.heytap.accessory.bean.AdvertiseSetting;
import com.heytap.accessory.bean.AuthenticateMessage;
import com.heytap.accessory.bean.ConnectMessage;
import com.heytap.accessory.bean.DeviceInfo;
import com.heytap.accessory.bean.DiscoveryException;
import com.heytap.accessory.bean.Message;
import com.heytap.accessory.constant.AFConstants;
import com.heytap.accessory.discovery.BaseManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import n5.C1371a;

/* loaded from: classes3.dex */
public class PeripheralManager extends BaseManager {
    public static final int ADVERTISE_FAILED_ALREADY_STARTED = 3;
    public static final int ADVERTISE_FAILED_DATA_TOO_LARGE = 1;
    public static final int ADVERTISE_FAILED_FEATURE_UNSUPPORTED = 5;
    public static final int ADVERTISE_FAILED_INTERNAL_ERROR = 4;
    public static final int ADVERTISE_FAILED_SETUP_SERVER = 100;
    public static final int ADVERTISE_FAILED_TOO_MANY_ADVERTISERS = 2;
    public static final int CONNECT_RESULT_AGREE = 1;
    public static final int CONNECT_RESULT_AUTH_CUSTOMIZE = 4;
    public static final int CONNECT_RESULT_AUTH_PIN = 3;
    public static final int CONNECT_RESULT_REJECT = 2;
    public static final int ERROR_AUTHENTICATION_FAILED = 1;
    public static final int ERROR_DEVICE = 2;
    public static final int ERROR_NONE = 0;
    public static final int ERROR_PAIR_CONNECT_FAILED = 3;
    private static final String PREFIX = "ppl_";
    private static final String TAG = "PeripheralManager";
    private static volatile PeripheralManager sInstance;
    private Context mContext;
    private final Set<BaseManager.b> mManagerCallbackSet = new HashSet();
    private String mPackageName;
    private byte[] mPreRdi;
    private volatile IPeripheralService mService;

    /* loaded from: classes3.dex */
    public class PeripheralCallbackNative extends IPeripheralCallback.Stub {

        /* renamed from: f, reason: collision with root package name */
        public final IPeplCallback f25258f;

        public PeripheralCallbackNative(IPeplCallback iPeplCallback) {
            this.f25258f = iPeplCallback;
        }

        @Override // com.heytap.accessory.api.IPeripheralCallback
        public void K5(DeviceInfo deviceInfo, Message message) {
            Bundle bundle = message.getBundle();
            if (bundle == null) {
                C1371a.d(PeripheralManager.TAG, "onRequestConnect failed, bundle is null");
                return;
            }
            try {
                this.f25258f.onRequestConnect(deviceInfo, new ConnectMessage(bundle.getByteArray(Message.KEY_MSG_CONNECT_DATA)));
            } catch (Exception e10) {
                C1371a.f(PeripheralManager.TAG, e10);
            }
        }

        @Override // com.heytap.accessory.api.IPeripheralCallback
        public void P6() {
            Bundle bundle = new Bundle();
            bundle.putInt(Message.KEY_MSG_SCAN_TYPE, 1);
            k6(new Message(bundle));
        }

        @Override // com.heytap.accessory.api.IPeripheralCallback
        public void T1(DeviceInfo deviceInfo, Message message) {
            Bundle bundle = message.getBundle();
            if (bundle == null) {
                C1371a.d(PeripheralManager.TAG, "onRequestAuthenticate failed, bundle is null");
                return;
            }
            try {
                this.f25258f.onRequestAuthenticate(deviceInfo, new AuthenticateMessage(bundle.getByteArray(Message.KEY_MSG_AUTH_DATA)));
            } catch (Exception e10) {
                C1371a.f(PeripheralManager.TAG, e10);
            }
        }

        @Override // com.heytap.accessory.api.IPeripheralCallback
        public void c3(Message message) {
            int i10 = message.getBundle().getInt(Message.KEY_MSG_ERROR_CODE);
            C1371a.g(PeripheralManager.TAG, "onAdvertiseFailureV2 scanType : " + message.getBundle().getInt(Message.KEY_MSG_SCAN_TYPE) + ", err: " + i10);
            try {
                this.f25258f.onAdvertiseFailure(message);
            } catch (Exception e10) {
                C1371a.f(PeripheralManager.TAG, e10);
            }
        }

        @Override // com.heytap.accessory.api.IPeripheralCallback
        public void k6(Message message) {
            C1371a.g(PeripheralManager.TAG, "onAdvertiseStoppedV2 scanType : " + message.getBundle().getInt(Message.KEY_MSG_SCAN_TYPE));
            try {
                this.f25258f.onAdvertiseStopped(message);
            } catch (Exception e10) {
                C1371a.f(PeripheralManager.TAG, e10);
            }
        }

        @Override // com.heytap.accessory.api.IPeripheralCallback
        public void onPairFailure(DeviceInfo deviceInfo, Message message) {
            Bundle bundle = message.getBundle();
            if (bundle == null) {
                C1371a.d(PeripheralManager.TAG, "onPairFailure failed, bundle is null");
                return;
            }
            try {
                this.f25258f.onPairFailure(deviceInfo, bundle.getInt(Message.KEY_MSG_ERROR_CODE));
            } catch (Exception e10) {
                C1371a.f(PeripheralManager.TAG, e10);
            }
        }

        @Override // com.heytap.accessory.api.IPeripheralCallback
        public void onPairSuccess(DeviceInfo deviceInfo) {
            try {
                this.f25258f.onPairSuccess(deviceInfo);
            } catch (Exception e10) {
                C1371a.f(PeripheralManager.TAG, e10);
            }
        }

        @Override // com.heytap.accessory.api.IPeripheralCallback
        public void q1() {
            C1371a.c(PeripheralManager.TAG, "onAdvertiseSuccess scanType : 1");
            Bundle bundle = new Bundle();
            bundle.putInt(Message.KEY_MSG_SCAN_TYPE, 1);
            try {
                this.f25258f.onAdvertiseSuccess(new Message(bundle));
            } catch (Exception e10) {
                C1371a.f(PeripheralManager.TAG, e10);
            }
        }

        @Override // com.heytap.accessory.api.IPeripheralCallback
        public void u3(Message message) {
            PeripheralManager.this.mPreRdi = message.getBundle().getByteArray(Message.KEY_MSG_RDI);
            String str = null;
            if (PeripheralManager.this.getFpCoreVersion() < 30003) {
                StringBuilder sb = new StringBuilder();
                sb.append("onAdvertiseSuccess preRdi : ");
                if (PeripheralManager.this.mPreRdi != null) {
                    str = r5.f.a(PeripheralManager.this.mPreRdi);
                }
                sb.append(str);
                C1371a.c(PeripheralManager.TAG, sb.toString());
                return;
            }
            int i10 = message.getBundle().getInt(Message.KEY_MSG_SCAN_TYPE);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onAdvertiseSuccessV2 scanType : ");
            sb2.append(i10);
            sb2.append(", preRdi : ");
            if (PeripheralManager.this.mPreRdi != null) {
                str = r5.f.a(PeripheralManager.this.mPreRdi);
            }
            sb2.append(str);
            C1371a.c(PeripheralManager.TAG, sb2.toString());
            try {
                this.f25258f.onAdvertiseSuccess(message);
            } catch (Exception e10) {
                C1371a.f(PeripheralManager.TAG, e10);
            }
        }

        @Override // com.heytap.accessory.api.IPeripheralCallback
        public void x4(int i10) {
            Bundle bundle = new Bundle();
            bundle.putInt(Message.KEY_MSG_SCAN_TYPE, 1);
            bundle.putInt(Message.KEY_MSG_ERROR_CODE, i10);
            c3(new Message(bundle));
        }
    }

    /* loaded from: classes3.dex */
    public class a implements j {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AdvertiseSetting f25260a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IPeplCallback f25261b;

        public a(AdvertiseSetting advertiseSetting, IPeplCallback iPeplCallback) {
            this.f25260a = advertiseSetting;
            this.f25261b = iPeplCallback;
        }

        @Override // com.heytap.accessory.discovery.j
        public void run() {
            PeripheralManager.this.startAdvertisingInternal(this.f25260a, this.f25261b);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements j {
        public b() {
        }

        @Override // com.heytap.accessory.discovery.j
        public void run() {
            PeripheralManager.this.stopAdvertisingInternal();
        }
    }

    private PeripheralManager() {
    }

    private boolean bindService(Context context) {
        if (this.mService != null) {
            C1371a.g(TAG, "already bind service");
            return true;
        }
        Intent intent = new Intent(AFConstants.SCAN_SERVICE_INTENT);
        intent.setPackage(ManagerConfig.ACCESSORY_FRAMEWORK_PACKAGE);
        intent.putExtra(AFConstants.KEY_SUB_SERVICE, 2);
        return context.bindService(intent, this, 33);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private synchronized boolean bindServiceSync(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
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
        return true;
    }

    public static PeripheralManager getInstance() {
        if (sInstance == null) {
            synchronized (PeripheralManager.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new PeripheralManager();
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
    public void startAdvertisingInternal(AdvertiseSetting advertiseSetting, IPeplCallback iPeplCallback) {
        C1371a.g(TAG, "startAdvertisingInternal, scanType:" + advertiseSetting.getScanType());
        if (this.mService == null) {
            C1371a.d(TAG, CentralManager.SERVICE_IS_NULL);
            return;
        }
        try {
            advertiseSetting.setFpCoreVersion(getFpCoreVersion());
            if (this.mPreRdi != null) {
                byte[] bArr = {0, 0, 0, 0, 0, 0};
                if (advertiseSetting.getRdi() != null) {
                    if (Arrays.equals(advertiseSetting.getRdi(), bArr)) {
                    }
                }
                advertiseSetting.resetRdi(this.mPreRdi);
            }
            this.mService.w5(advertiseSetting, new PeripheralCallbackNative(iPeplCallback));
        } catch (Exception e10) {
            C1371a.f(TAG, e10);
            Bundle bundle = new Bundle();
            bundle.putInt(Message.KEY_MSG_ERROR_CODE, 100);
            bundle.putInt(Message.KEY_MSG_SCAN_TYPE, advertiseSetting.getScanType());
            iPeplCallback.onAdvertiseFailure(new Message());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopAdvertisingInternal() {
        if (this.mService == null) {
            C1371a.d(TAG, CentralManager.SERVICE_IS_NULL);
            return;
        }
        try {
            this.mService.t3();
        } catch (Exception e10) {
            C1371a.f(TAG, e10);
        }
    }

    public void createGroup(IPeplCallback iPeplCallback) {
        C1371a.g(TAG, "disable createGroup without debug");
    }

    public String expGetModelId() {
        C1371a.c(TAG, "onet request model id");
        if (this.mService == null) {
            C1371a.d(TAG, "mService is null, onet request failed");
            return null;
        }
        return this.mService.v1();
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

    public synchronized boolean init(Context context) {
        C1371a.g(TAG, "init");
        boolean z10 = true;
        if (this.mService != null) {
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
    }

    public void initAsync(Context context, IManagerCallback iManagerCallback) {
        C1371a.g(TAG, "initAsync");
        if (this.mService != null) {
            iManagerCallback.onInited();
            return;
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
        synchronized (this) {
            try {
                this.mService = iDiscoveryNativeService.v3();
                notifyAll();
            } catch (RemoteException e10) {
                e10.printStackTrace();
            }
        }
        new ArrayList();
        synchronized (this.mManagerCallbackSet) {
            list = (List) this.mManagerCallbackSet.stream().filter(new Predicate() { // from class: com.heytap.accessory.discovery.s
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    boolean lambda$onSubServiceConnected$0;
                    lambda$onSubServiceConnected$0 = PeripheralManager.lambda$onSubServiceConnected$0((BaseManager.b) obj);
                    return lambda$onSubServiceConnected$0;
                }
            }).map(new Function() { // from class: com.heytap.accessory.discovery.t
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
        C1371a.g(TAG, "onSubServiceDisconnected");
        this.mService = null;
        new ArrayList();
        synchronized (this.mManagerCallbackSet) {
            List list = (List) this.mManagerCallbackSet.stream().map(new Function() { // from class: com.heytap.accessory.discovery.r
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    IManagerCallback iManagerCallback;
                    iManagerCallback = ((BaseManager.b) obj).f25222b;
                    return iManagerCallback;
                }
            }).collect(Collectors.toList());
            this.mManagerCallbackSet.clear();
            list.forEach(new i());
        }
    }

    public synchronized void release(Context context) {
        release();
    }

    public boolean responseAuthenticate(DeviceInfo deviceInfo, boolean z10) {
        C1371a.g(TAG, "responseAuthenticate, deviceInfo: " + deviceInfo + ", agree: " + z10);
        if (this.mService != null) {
            try {
                this.mService.J4(deviceInfo, z10);
                return true;
            } catch (Exception e10) {
                C1371a.f(TAG, e10);
                throw DiscoveryException.create(1, e10.getMessage());
            }
        }
        throw DiscoveryException.create(2, "responseAuthenticate failed, service is null");
    }

    public boolean responseConnect(DeviceInfo deviceInfo, int i10) {
        C1371a.g(TAG, "responseConnect, deviceInfo: " + deviceInfo + ", result: " + i10);
        if (deviceInfo != null) {
            if (i10 >= 1 && i10 <= 4) {
                if (this.mService != null) {
                    try {
                        this.mService.H4(deviceInfo, i10);
                        return true;
                    } catch (Exception e10) {
                        C1371a.f(TAG, e10);
                        throw DiscoveryException.create(1, e10.getMessage());
                    }
                }
                throw DiscoveryException.create(2, "responseConnect failed, service is null");
            }
            throw DiscoveryException.create(3, "unknown connect result: " + i10);
        }
        throw DiscoveryException.create(3, "deviceInfo shouldn't be null");
    }

    public void saveModelId(byte[] bArr, byte[] bArr2) {
        try {
            C1371a.g(TAG, "save modelId and remoteDeviceId");
            Bundle bundle = new Bundle();
            bundle.putInt(AFConstants.KEY_BUSINESS_TYPE, 3);
            bundle.putByteArray("model_id", bArr2);
            bundle.putByteArray(AFConstants.KEY_REMOTE_DEVICE_ID, bArr);
            this.mService.Q(bundle);
        } catch (RemoteException e10) {
            C1371a.d(TAG, e10.toString());
            e10.printStackTrace();
        }
    }

    public int startAdvertise(AdvertiseSetting advertiseSetting, IPeplCallback iPeplCallback) {
        if (this.mService != null) {
            startAdvertisingInternal(advertiseSetting, iPeplCallback);
            return 0;
        }
        Context context = this.mContext;
        if (context != null) {
            runOnBackGround(context, new a(advertiseSetting, iPeplCallback));
            return 0;
        }
        throw DiscoveryException.create(2, "startAdvertise failed, service and context is null");
    }

    public void stopAdvertise() {
        if (this.mService != null) {
            stopAdvertisingInternal();
            return;
        }
        Context context = this.mContext;
        if (context != null) {
            runOnBackGround(context, new b());
            return;
        }
        throw DiscoveryException.create(2, "stopAdvertise failed, service and context is null");
    }

    public synchronized void release() {
        try {
            C1371a.g(TAG, "release");
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
