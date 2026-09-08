package com.heytap.accessory.discovery;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.heytap.accessory.Config;
import com.heytap.accessory.api.ICentralService;
import com.heytap.accessory.api.IDirectPairCallback;
import com.heytap.accessory.api.IDisPairCallback;
import com.heytap.accessory.api.IDisScanCallback;
import com.heytap.accessory.api.IDiscoveryNativeService;
import com.heytap.accessory.api.ILanCacheIpServiceCallback;
import com.heytap.accessory.api.INsdDevicesCallback;
import com.heytap.accessory.api.IPermissionCallback;
import com.heytap.accessory.api.ManagerConfig;
import com.heytap.accessory.bean.DeviceInfo;
import com.heytap.accessory.bean.DirectPairInfo;
import com.heytap.accessory.bean.DiscoveryException;
import com.heytap.accessory.bean.Message;
import com.heytap.accessory.bean.PairSetting;
import com.heytap.accessory.bean.ScanSetting;
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
public class CentralManager extends BaseManager {
    public static final int AUTHENTICATION_MODE_CUSTOMIZE = 2;
    public static final int AUTHENTICATION_MODE_PIN = 1;
    public static final int ERROR_AUTHENTICATION_FAILED = -1;
    public static final int ERROR_DEVICE = -2;
    public static final int ERROR_NONE = 0;
    public static final int ERROR_PAIR_CONNECT_FAILED = -3;
    private static final String PREFIX = "ctl_";
    public static final String SERVICE_IS_NULL = "service is null";
    private static final String TAG = "CentralManager";
    private static volatile CentralManager sInstance;
    private Context mContext;
    private final Set<BaseManager.b> mManagerCallbackSet = new HashSet();
    private String mPackageName;
    private volatile ICentralService mService;

    /* loaded from: classes3.dex */
    public static class DirectPairCallbackNative extends IDirectPairCallback.Stub {

        /* renamed from: f, reason: collision with root package name */
        public final IDirectCallback f25223f;

        public DirectPairCallbackNative(IDirectCallback iDirectCallback) {
            this.f25223f = iDirectCallback;
        }

        @Override // com.heytap.accessory.api.IDirectPairCallback
        public void onPairFailure(DeviceInfo deviceInfo, Message message) {
            this.f25223f.onPairFailure(deviceInfo, message);
        }

        @Override // com.heytap.accessory.api.IDirectPairCallback
        public void onPairSuccess(DeviceInfo deviceInfo, Message message) {
            this.f25223f.onPairSuccess(deviceInfo, message);
        }
    }

    /* loaded from: classes3.dex */
    public class GrantPermissionCallbackNative extends IPermissionCallback.Stub {
        public GrantPermissionCallbackNative(n nVar) {
        }

        @Override // com.heytap.accessory.api.IPermissionCallback
        public void P5() {
            throw null;
        }

        @Override // com.heytap.accessory.api.IPermissionCallback
        public void e0(int i10) {
            throw null;
        }
    }

    /* loaded from: classes3.dex */
    public static class ILanCacheIpNative extends ILanCacheIpServiceCallback.Stub {
        public ILanCacheIpNative(k kVar) {
        }

        @Override // com.heytap.accessory.api.ILanCacheIpServiceCallback
        public void W6(DeviceInfo deviceInfo, Message message) {
            throw null;
        }
    }

    /* loaded from: classes3.dex */
    public static class INsdDevicesNative extends INsdDevicesCallback.Stub {
        public INsdDevicesNative(l lVar) {
        }

        @Override // com.heytap.accessory.api.INsdDevicesCallback
        public void L1(List<DeviceInfo> list) {
            throw null;
        }
    }

    /* loaded from: classes3.dex */
    public class PairCallbackNative extends IDisPairCallback.Stub {

        /* renamed from: f, reason: collision with root package name */
        public final IPairCallback f25225f;

        public PairCallbackNative(IPairCallback iPairCallback) {
            this.f25225f = iPairCallback;
        }

        @Override // com.heytap.accessory.api.IDisPairCallback
        public void R1(DeviceInfo deviceInfo, Message message) {
            C1371a.g(CentralManager.TAG, "onPairMessage, deviceInfo: " + deviceInfo);
            Bundle bundle = message.getBundle();
            if (bundle == null) {
                C1371a.d(CentralManager.TAG, "onPairMessage failed, bundle is null");
                return;
            }
            bundle.putInt(Message.SDK_VERSION, Config.getSdkVersionCode());
            try {
                int fpCoreVersion = CentralManager.this.getFpCoreVersion();
                C1371a.g(CentralManager.TAG, "getFpCoreVersion: " + fpCoreVersion);
                if (fpCoreVersion < 10200) {
                    bundle.putByteArray(Message.KEY_MSG_AUTH_DATA, this.f25225f.onPairData(deviceInfo, bundle));
                } else if (fpCoreVersion >= 10200) {
                    if (!bundle.containsKey(Message.KEY_MSG_AUTH_MODE) && !bundle.containsKey(Message.KEY_MSG_AUTH_LIMIT_LENGTH)) {
                        if (bundle.containsKey(Message.KEY_MSG_TYPE_PAIR_TYPE_RECEIVED)) {
                            bundle.putInt(Message.KEY_MSG_TYPE_PAIR_TYPE_RECEIVED, this.f25225f.onPairTypeReceived(deviceInfo, bundle));
                        }
                    }
                    bundle.putByteArray(Message.KEY_MSG_AUTH_DATA, this.f25225f.onPairData(deviceInfo, bundle));
                }
            } catch (Exception e10) {
                C1371a.f(CentralManager.TAG, e10);
            }
        }

        @Override // com.heytap.accessory.api.IDisPairCallback
        public void onPairFailure(DeviceInfo deviceInfo, Message message) {
            C1371a.g(CentralManager.TAG, "onPairFailure, deviceInfo: " + deviceInfo);
            try {
                this.f25225f.onPairFailure(deviceInfo, message.getBundle());
            } catch (Exception e10) {
                C1371a.f(CentralManager.TAG, e10);
            }
        }

        @Override // com.heytap.accessory.api.IDisPairCallback
        public void onPairSuccess(DeviceInfo deviceInfo, Message message) {
            C1371a.g(CentralManager.TAG, "onPairSuccess, deviceInfo: " + deviceInfo);
            try {
                this.f25225f.onPairSuccess(deviceInfo, message.getBundle());
            } catch (Exception e10) {
                C1371a.f(CentralManager.TAG, e10);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class ScanCallbackNative extends IDisScanCallback.Stub {

        /* renamed from: f, reason: collision with root package name */
        public final IScanCallback f25227f;

        public ScanCallbackNative(IScanCallback iScanCallback) {
            this.f25227f = iScanCallback;
        }

        @Override // com.heytap.accessory.api.IDisScanCallback
        public void onCancel() {
            try {
                this.f25227f.onCancel();
            } catch (Exception e10) {
                C1371a.f(CentralManager.TAG, e10);
            }
        }

        @Override // com.heytap.accessory.api.IDisScanCallback
        public void onDeviceFound(DeviceInfo deviceInfo) {
            try {
                this.f25227f.onDeviceFound(deviceInfo);
            } catch (Exception e10) {
                C1371a.f(CentralManager.TAG, e10);
            }
        }

        @Override // com.heytap.accessory.api.IDisScanCallback
        public void y5(int i10) {
            try {
                this.f25227f.onCancel(i10);
            } catch (Exception e10) {
                C1371a.f(CentralManager.TAG, e10);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a implements j {
        public a() {
        }

        @Override // com.heytap.accessory.discovery.j
        public void run() {
            CentralManager.this.startInnerScanInternal();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements j {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ScanSetting f25230a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f25231b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ IScanCallback f25232c;

        public b(ScanSetting scanSetting, List list, IScanCallback iScanCallback) {
            this.f25230a = scanSetting;
            this.f25231b = list;
            this.f25232c = iScanCallback;
        }

        @Override // com.heytap.accessory.discovery.j
        public void run() {
            CentralManager.this.startScanInternal(this.f25230a, this.f25231b, this.f25232c);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements j {
        public c() {
        }

        @Override // com.heytap.accessory.discovery.j
        public void run() {
            CentralManager.this.cancelScanInternal();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements j {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DeviceInfo f25235a;

        public d(DeviceInfo deviceInfo) {
            this.f25235a = deviceInfo;
        }

        @Override // com.heytap.accessory.discovery.j
        public void run() {
            CentralManager.this.cancelPairInternal(this.f25235a);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements j {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f25237a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f25238b;

        public e(int i10, boolean z10) {
            this.f25237a = i10;
            this.f25238b = z10;
        }

        @Override // com.heytap.accessory.discovery.j
        public void run() {
            CentralManager.this.enableDiscoverabilityInternal(this.f25237a, this.f25238b);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements j {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f25240a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f25241b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f25242c;

        public f(int i10, boolean z10, long j10) {
            this.f25240a = i10;
            this.f25241b = z10;
            this.f25242c = j10;
        }

        @Override // com.heytap.accessory.discovery.j
        public void run() {
            CentralManager.this.expEnableDiscoverabilityInternal(this.f25240a, this.f25241b, this.f25242c);
        }
    }

    /* loaded from: classes3.dex */
    public class g implements j {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DirectPairInfo f25244a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IDirectCallback f25245b;

        public g(DirectPairInfo directPairInfo, IDirectCallback iDirectCallback) {
            this.f25244a = directPairInfo;
            this.f25245b = iDirectCallback;
        }

        @Override // com.heytap.accessory.discovery.j
        public void run() {
            CentralManager.this.directPairInternal(this.f25244a, this.f25245b);
        }
    }

    /* loaded from: classes3.dex */
    public class h implements j {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f25247a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f25248b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f25249c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ IQRCodeCallback f25250d;

        public h(String str, int i10, String str2, IQRCodeCallback iQRCodeCallback) {
            this.f25247a = str;
            this.f25248b = i10;
            this.f25249c = str2;
            this.f25250d = iQRCodeCallback;
        }

        @Override // com.heytap.accessory.discovery.j
        public void run() {
            CentralManager.this.startQRCodeContentInternal(this.f25247a, this.f25248b, this.f25249c, this.f25250d);
        }
    }

    /* loaded from: classes3.dex */
    public class i implements j {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f25252a;

        public i(boolean z10) {
            this.f25252a = z10;
        }

        @Override // com.heytap.accessory.discovery.j
        public void run() {
            try {
                CentralManager.this.mService.c2(this.f25252a);
            } catch (RemoteException e10) {
                C1371a.f(CentralManager.TAG, e10);
            }
        }
    }

    private CentralManager() {
    }

    private boolean bindService(Context context) {
        if (this.mService != null) {
            C1371a.g(TAG, "already bind service");
            return true;
        }
        Intent intent = new Intent(AFConstants.SCAN_SERVICE_INTENT);
        intent.setPackage(ManagerConfig.ACCESSORY_FRAMEWORK_PACKAGE);
        intent.putExtra(AFConstants.KEY_SUB_SERVICE, 1);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelPairInternal(DeviceInfo deviceInfo) {
        if (this.mService == null) {
            C1371a.d(TAG, SERVICE_IS_NULL);
            return;
        }
        try {
            this.mService.a3(deviceInfo);
        } catch (Exception e10) {
            C1371a.f(TAG, e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelScanInternal() {
        if (this.mService == null) {
            C1371a.d(TAG, SERVICE_IS_NULL);
            return;
        }
        try {
            this.mService.d0();
        } catch (Exception e10) {
            C1371a.f(TAG, e10);
        }
    }

    private void checkLocationIsAvailableInternal(n nVar) {
        if (this.mService == null) {
            C1371a.d(TAG, SERVICE_IS_NULL);
            return;
        }
        try {
            this.mService.a7(new GrantPermissionCallbackNative(nVar));
        } catch (Exception e10) {
            C1371a.f(TAG, e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int directPairInternal(DirectPairInfo directPairInfo, IDirectCallback iDirectCallback) {
        int i10;
        if (this.mService == null) {
            C1371a.d(TAG, SERVICE_IS_NULL);
            return 1;
        }
        try {
            i10 = this.mService.M2(directPairInfo, new DirectPairCallbackNative(iDirectCallback));
        } catch (Exception e10) {
            C1371a.f(TAG, e10);
            i10 = 7;
        }
        if (i10 != 0) {
            C1371a.d(TAG, "directPair failed, err: " + i10);
            Message message = new Message();
            message.getBundle().putInt(Message.KEY_MSG_ERROR_CODE, i10);
            iDirectCallback.onPairFailure(new DeviceInfo(), message);
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enableDiscoverabilityInternal(int i10, boolean z10) {
        if (this.mService == null) {
            C1371a.d(TAG, SERVICE_IS_NULL);
            return;
        }
        try {
            this.mService.k0(i10, z10);
        } catch (Exception e10) {
            C1371a.f(TAG, e10);
        }
    }

    private int enableOnetScanInternal(boolean z10, IScanCallback iScanCallback) {
        if (this.mService == null) {
            C1371a.d(TAG, SERVICE_IS_NULL);
            return 1;
        }
        try {
            return this.mService.c5(z10, new ScanCallbackNative(iScanCallback));
        } catch (RemoteException e10) {
            e10.printStackTrace();
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void expEnableDiscoverabilityInternal(int i10, boolean z10, long j10) {
        if (this.mService == null) {
            C1371a.d(TAG, SERVICE_IS_NULL);
            return;
        }
        try {
            this.mService.Y1(i10, z10, j10);
        } catch (Exception e10) {
            C1371a.f(TAG, e10);
        }
    }

    public static CentralManager getInstance() {
        if (sInstance == null) {
            synchronized (CentralManager.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new CentralManager();
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

    private Bundle packFilterBundle(List<IScanFilter> list) {
        Bundle bundle = new Bundle();
        if (list != null) {
            for (IScanFilter iScanFilter : list) {
                bundle.putParcelable(iScanFilter.getKey(), iScanFilter);
            }
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int startInnerScanInternal() {
        int i10;
        if (this.mService == null) {
            C1371a.d(TAG, "inner scan service is null");
            return 1;
        }
        try {
            i10 = this.mService.l7();
        } catch (Exception e10) {
            C1371a.f(TAG, e10);
            i10 = 2;
        }
        if (i10 != 0) {
            C1371a.d(TAG, "start inner Scan failed, err: " + i10);
        }
        return i10;
    }

    private int startPairInternal(PairSetting pairSetting, DeviceInfo deviceInfo, IPairCallback iPairCallback) {
        int i10;
        if (this.mService == null) {
            C1371a.d(TAG, SERVICE_IS_NULL);
            return 1;
        }
        try {
            deviceInfo.setLocalSupportKeyType(pairSetting.getKeyType());
            deviceInfo.setActiveTrigger(pairSetting.getActiveTrigger());
            i10 = this.mService.Y3(pairSetting, deviceInfo, new PairCallbackNative(iPairCallback));
        } catch (Exception e10) {
            C1371a.f(TAG, e10);
            i10 = 7;
        }
        if (i10 != 0) {
            C1371a.d(TAG, "startPair failed, err: " + i10);
            Bundle bundle = new Bundle();
            bundle.putInt(Message.KEY_MSG_ERROR_CODE, i10);
            iPairCallback.onPairFailure(deviceInfo, bundle);
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startQRCodeContentInternal(String str, int i10, String str2, IQRCodeCallback iQRCodeCallback) {
        if (this.mService == null) {
            C1371a.d(TAG, "inner scan service is null");
            if (iQRCodeCallback != null) {
                try {
                    iQRCodeCallback.onFailure(1);
                    return;
                } catch (RemoteException e10) {
                    e10.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString(AFConstants.PARAM_QR_TYPE, str);
            bundle.putInt("deviceType", i10);
            bundle.putString("model_id", str2);
            this.mService.i1(bundle, iQRCodeCallback);
        } catch (Exception e11) {
            C1371a.f(TAG, e11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int startScanInternal(ScanSetting scanSetting, List<IScanFilter> list, IScanCallback iScanCallback) {
        int i10;
        if (this.mService == null) {
            C1371a.d(TAG, SERVICE_IS_NULL);
            return 1;
        }
        try {
            int fpCoreVersion = getFpCoreVersion();
            scanSetting.setFpCoreVersion(fpCoreVersion);
            if (fpCoreVersion >= 30003) {
                i10 = this.mService.W5(scanSetting, packFilterBundle(list), new ScanCallbackNative(iScanCallback)).getBundle().getInt(Message.KEY_MSG_ERROR_CODE);
                if (i10 == 0) {
                    C1371a.c(TAG, "startScan successfully " + iScanCallback);
                }
            } else if (scanSetting.getScanType() == 1) {
                C1371a.c(TAG, "startScan successfully");
                scanSetting.resetScanType(0);
                i10 = this.mService.m4(scanSetting, packFilterBundle(list), new ScanCallbackNative(iScanCallback));
            } else {
                C1371a.k(TAG, "startScan with incompatible scanType:" + scanSetting.getScanType());
                i10 = 6;
            }
        } catch (Exception e10) {
            C1371a.f(TAG, e10);
            i10 = 2;
        }
        if (i10 != 0) {
            C1371a.d(TAG, "startScan failed, err: " + i10);
            iScanCallback.onCancel();
        }
        return i10;
    }

    public void cancelPair(DeviceInfo deviceInfo) {
        C1371a.g(TAG, "cancelPair, deviceInfo: " + deviceInfo);
        if (this.mService != null) {
            cancelPairInternal(deviceInfo);
            return;
        }
        Context context = this.mContext;
        if (context != null) {
            runOnBackGround(context, new d(deviceInfo));
            return;
        }
        throw DiscoveryException.create(2, "cancelPair failed, service and context is null");
    }

    public void cancelScan() {
        if (this.mService != null) {
            cancelScanInternal();
            return;
        }
        Context context = this.mContext;
        if (context != null) {
            runOnBackGround(context, new c());
            return;
        }
        throw DiscoveryException.create(2, "cancelScan failed, service and context is null");
    }

    public boolean checkDiscoverability(int i10) {
        if (this.mService != null) {
            try {
                return this.mService.a6(i10);
            } catch (Exception e10) {
                C1371a.f(TAG, e10);
                throw DiscoveryException.create(1, e10.getMessage());
            }
        }
        throw DiscoveryException.create(2, "checkDiscoverability failed, service is null");
    }

    public void checkLocationIsAvailable(n nVar) {
        C1371a.g(TAG, "checkPresentIsAvailable");
        if (nVar != null) {
            if (this.mService != null) {
                checkLocationIsAvailableInternal(nVar);
                return;
            }
            throw DiscoveryException.create(2, "checkLocationIsAvailable fail");
        }
        throw DiscoveryException.create(3, "grantCallback shouldn't be null");
    }

    public int directPair(DirectPairInfo directPairInfo, IDirectCallback iDirectCallback) {
        if (this.mService != null) {
            return directPairInternal(directPairInfo, iDirectCallback);
        }
        Context context = this.mContext;
        if (context != null) {
            runOnBackGround(context, new g(directPairInfo, iDirectCallback));
            return 0;
        }
        throw DiscoveryException.create(2, "directPair failed, service is null");
    }

    @Deprecated
    public int earlyPair(DeviceInfo deviceInfo) {
        throw DiscoveryException.create(1, "earlyPair is disable!");
    }

    public void enableDiscoverability(int i10, boolean z10) {
        C1371a.g(TAG, "enableDiscoverability, major: " + i10 + ", enable: " + z10);
        if (this.mService != null) {
            enableDiscoverabilityInternal(i10, z10);
            return;
        }
        Context context = this.mContext;
        if (context != null) {
            runOnBackGround(context, new e(i10, z10));
            return;
        }
        throw DiscoveryException.create(2, "enableDiscoverability failed, service and context is null");
    }

    public int enableOnetScan(boolean z10, IScanCallback iScanCallback) {
        C1371a.g(TAG, "enableOnetScan");
        if (z10 && iScanCallback == null) {
            throw DiscoveryException.create(3, "callback shouldn't be null");
        }
        if (this.mService != null) {
            return enableOnetScanInternal(z10, iScanCallback);
        }
        throw DiscoveryException.create(2, "enableOnetScan fail");
    }

    public boolean enableScreenOffSenselessScan(boolean z10) {
        C1371a.c(TAG, "senseless scan enableBlackScreenSenselessScan - isEnable: " + z10);
        if (this.mService != null) {
            try {
                return this.mService.c2(z10);
            } catch (RemoteException e10) {
                C1371a.f(TAG, e10);
                return false;
            }
        }
        Context context = this.mContext;
        if (context != null) {
            runOnBackGround(context, new i(z10));
            return true;
        }
        throw DiscoveryException.create(2, "enableBlackScreenSenselessScan failed, service and context is null");
    }

    public void expEnableDiscoverability(int i10, boolean z10, long j10) {
        C1371a.g(TAG, "enableDiscoverability, major: " + i10 + ", enable: " + z10 + ", delayMillis: " + j10);
        if (this.mService != null) {
            expEnableDiscoverabilityInternal(i10, z10, j10);
            return;
        }
        Context context = this.mContext;
        if (context != null) {
            runOnBackGround(context, new f(i10, z10, j10));
            return;
        }
        throw DiscoveryException.create(2, "ExpEnableDiscoverability failed, service and context is null");
    }

    public void findPairedLanDevices(l lVar) {
        if (this.mService != null) {
            try {
                this.mService.w2(new INsdDevicesNative(lVar));
                return;
            } catch (Exception e10) {
                C1371a.f(TAG, e10);
                return;
            }
        }
        throw DiscoveryException.create(2, "directPair failed, service is not alive");
    }

    @Override // com.heytap.accessory.discovery.BaseManager
    public /* bridge */ /* synthetic */ int getFpCoreVersion() {
        return super.getFpCoreVersion();
    }

    public void getLanCacheIp(String str, k kVar) {
        if (this.mService != null) {
            try {
                this.mService.s0(str, new ILanCacheIpNative(kVar));
                return;
            } catch (Exception e10) {
                C1371a.f(TAG, e10);
                return;
            }
        }
        throw DiscoveryException.create(2, "directPair failed, service isn't alive");
    }

    public String getModelIdResource(int i10, String str, String str2) {
        String str3 = null;
        if (this.mService == null) {
            C1371a.d(TAG, "getModelIdResource, service is null");
            return null;
        }
        try {
            str3 = this.mService.Q0(i10, str, str2);
            C1371a.g(TAG, "modelIdResource uri is: " + str3 + " callingPackageName is: " + str2);
            return str3;
        } catch (Exception e10) {
            C1371a.f(TAG, e10);
            return str3;
        }
    }

    @Override // com.heytap.accessory.discovery.BaseManager
    public String getPackageName() {
        return PREFIX + this.mPackageName;
    }

    public void getQRCodeContent(String str, int i10, String str2, IQRCodeCallback iQRCodeCallback) {
        if (this.mService != null) {
            startQRCodeContentInternal(str, i10, str2, iQRCodeCallback);
            return;
        }
        Context context = this.mContext;
        if (context != null) {
            runOnBackGround(context, new h(str, i10, str2, iQRCodeCallback));
        }
        throw DiscoveryException.create(2, "start inner Scan failed, service and context is null");
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
                this.mService = iDiscoveryNativeService.v4();
                notifyAll();
            } catch (RemoteException e10) {
                e10.printStackTrace();
            }
        }
        new ArrayList();
        synchronized (this.mManagerCallbackSet) {
            list = (List) this.mManagerCallbackSet.stream().filter(new Predicate() { // from class: com.heytap.accessory.discovery.e
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    boolean lambda$onSubServiceConnected$0;
                    lambda$onSubServiceConnected$0 = CentralManager.lambda$onSubServiceConnected$0((BaseManager.b) obj);
                    return lambda$onSubServiceConnected$0;
                }
            }).map(new Function() { // from class: com.heytap.accessory.discovery.f
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    IManagerCallback iManagerCallback;
                    iManagerCallback = ((BaseManager.b) obj).f25222b;
                    return iManagerCallback;
                }
            }).collect(Collectors.toList());
        }
        list.forEach(new com.heytap.accessory.discovery.g());
    }

    @Override // com.heytap.accessory.discovery.BaseManager
    public void onSubServiceDisconnected() {
        List list;
        C1371a.g(TAG, "onSubServiceDisconnected");
        this.mService = null;
        new ArrayList();
        synchronized (this.mManagerCallbackSet) {
            list = (List) this.mManagerCallbackSet.stream().map(new Function() { // from class: com.heytap.accessory.discovery.h
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    IManagerCallback iManagerCallback;
                    iManagerCallback = ((BaseManager.b) obj).f25222b;
                    return iManagerCallback;
                }
            }).collect(Collectors.toList());
            this.mManagerCallbackSet.clear();
        }
        list.forEach(new com.heytap.accessory.discovery.i());
    }

    public synchronized void release(Context context) {
        release();
    }

    public void saveModelId(byte[] bArr, byte[] bArr2) {
        try {
            C1371a.g(TAG, "save modelId and remoteDeviceId");
            Bundle bundle = new Bundle();
            bundle.putInt(AFConstants.KEY_BUSINESS_TYPE, 1);
            bundle.putByteArray("model_id", bArr2);
            bundle.putByteArray(AFConstants.KEY_REMOTE_DEVICE_ID, bArr);
            this.mService.Q(bundle);
        } catch (RemoteException e10) {
            C1371a.d(TAG, e10.toString());
            e10.printStackTrace();
        }
    }

    public int startInnerScan() {
        if (this.mService != null) {
            return startInnerScanInternal();
        }
        Context context = this.mContext;
        if (context != null) {
            runOnBackGround(context, new a());
            return 0;
        }
        throw DiscoveryException.create(2, "start inner Scan failed, service and context is null");
    }

    public int startPair(DeviceInfo deviceInfo, IPairCallback iPairCallback) {
        return startPair(new PairSetting.Builder().build(), deviceInfo, iPairCallback);
    }

    public int startScan(ScanSetting scanSetting, List<IScanFilter> list, IScanCallback iScanCallback) {
        if (this.mService != null) {
            return startScanInternal(scanSetting, list, iScanCallback);
        }
        Context context = this.mContext;
        if (context != null) {
            runOnBackGround(context, new b(scanSetting, list, iScanCallback));
            return 0;
        }
        throw DiscoveryException.create(2, "startScan failed, service and context is null");
    }

    public synchronized void release() {
        C1371a.g(TAG, "release");
        if (this.mService == null) {
            return;
        }
        this.mContext.unbindService(this);
        this.mService = null;
        this.mContext = null;
        synchronized (this.mManagerCallbackSet) {
            this.mManagerCallbackSet.clear();
        }
    }

    public int startPair(PairSetting pairSetting, DeviceInfo deviceInfo, IPairCallback iPairCallback) {
        C1371a.g(TAG, "startPair, deviceInfo: " + deviceInfo + " setting: " + pairSetting);
        if (this.mService != null) {
            return startPairInternal(pairSetting, deviceInfo, iPairCallback);
        }
        throw DiscoveryException.create(2, "startPair failed, service and context is null");
    }

    public void cancelScan(IScanCallback iScanCallback) {
        C1371a.g(TAG, "call legacy cancelScan");
        cancelScan();
    }

    public void saveModelId(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        try {
            C1371a.g(TAG, "save modelId and remoteDeviceId");
            Bundle bundle = new Bundle();
            bundle.putInt(AFConstants.KEY_BUSINESS_TYPE, 2);
            bundle.putByteArray("model_id", bArr3);
            bundle.putByteArray(AFConstants.KEY_REMOTE_DEVICE_ID, bArr2);
            bundle.putByteArray(AFConstants.KEY_LOCAL_DEVICE_ID, bArr);
            this.mService.Q(bundle);
        } catch (RemoteException e10) {
            C1371a.d(TAG, e10.toString());
            e10.printStackTrace();
        }
    }
}
