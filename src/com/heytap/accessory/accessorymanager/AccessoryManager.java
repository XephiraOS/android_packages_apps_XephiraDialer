package com.heytap.accessory.accessorymanager;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.ResultReceiver;
import com.heytap.accessory.Config;
import com.heytap.accessory.Initializer;
import com.heytap.accessory.api.GenericAdapter;
import com.heytap.accessory.bean.AccountInfo;
import com.heytap.accessory.bean.FlowControlConfig;
import com.heytap.accessory.bean.PeerAccessory;
import com.heytap.accessory.bean.ServiceProfile;
import com.heytap.accessory.bean.TrafficControlConfig;
import com.heytap.accessory.constant.AFConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Pattern;
import n5.C1371a;
import r5.c;
import r5.f;

/* loaded from: classes3.dex */
public class AccessoryManager {
    public static final String ACTION_ACCESSORY_ATTACHED_EVENT = "com.heytap.accessory.device.action.ACCESSORY_ATTACHED";
    public static final String ACTION_ACCESSORY_DETACHED_EVENT = "com.heytap.accessory.device.action.ACCESSORY_DETACHED";
    private static final int KCS_LENGTH_16 = 16;
    private static final int RESULT_CODE_ERROR = 100;

    @Deprecated
    public static final int RETRY_MODE_DEFAULT = 0;

    @Deprecated
    public static final int RETRY_MODE_LIMITED = 1;

    @Deprecated
    public static final int RETRY_MODE_STICKY = 2;
    public static final int TRANSPORT_ALL = 255;
    public static final int TRANSPORT_BLE = 4;
    public static final int TRANSPORT_BT = 2;
    public static final int TRANSPORT_WIFI = 1;
    public static final int TRANSPORT_WIFI_LAN = 8;
    private static volatile AccessoryManager sOnlyInstance;
    private ConnectionEventReceiver mConnectionEventReceiver;
    private final Context mContext;
    private GenericAdapter mGenericAdapter;
    private boolean mIsConnected = false;
    private static final String VERSION = Config.getSdkVersionName();
    private static final String TAG = AccessoryManager.class.getSimpleName();

    /* loaded from: classes3.dex */
    public interface AccessoryEventListener {
        void onAccessoryConnected(PeerAccessory peerAccessory);

        void onAccessoryDisconnected(PeerAccessory peerAccessory, int i10);

        void onAccessoryDormant(PeerAccessory peerAccessory, boolean z10);

        void onError(PeerAccessory peerAccessory, int i10);
    }

    /* loaded from: classes3.dex */
    public static final class ConnectionEventReceiver extends ResultReceiver {

        /* renamed from: a, reason: collision with root package name */
        public AccessoryEventListener f25160a;

        /* renamed from: b, reason: collision with root package name */
        public CopyOnWriteArrayList<ConnectConfig> f25161b;

        public ConnectionEventReceiver(Handler handler, AccessoryEventListener accessoryEventListener) {
            super(handler);
            this.f25161b = new CopyOnWriteArrayList<>();
            this.f25160a = accessoryEventListener;
        }

        public void b() {
            C1371a.c(AccessoryManager.TAG, "clear connect config...");
            this.f25161b.clear();
        }

        public final void d(int i10, PeerAccessory peerAccessory, int i11) {
            boolean z10;
            if (i10 == 109) {
                String str = AccessoryManager.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append(" onReceiveResult: DEVICE_STATE_CHANGED: isDormant:");
                boolean z11 = false;
                if (peerAccessory.getStatus() == 1) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                sb.append(z10);
                C1371a.c(str, sb.toString());
                AccessoryEventListener accessoryEventListener = this.f25160a;
                if (peerAccessory.getStatus() == 1) {
                    z11 = true;
                }
                accessoryEventListener.onAccessoryDormant(peerAccessory, z11);
                return;
            }
            if (i10 == 114) {
                C1371a.c(AccessoryManager.TAG, " onReceiveResult: DEVICE_ATTACHED uidType:" + peerAccessory.getUUIDType());
                this.f25160a.onAccessoryConnected(peerAccessory);
                return;
            }
            if (i10 != 115) {
                C1371a.c(AccessoryManager.TAG, " onReceiveResult: onError and result code:" + i11);
                if (i(peerAccessory)) {
                    this.f25160a.onError(peerAccessory, i11);
                }
                j(peerAccessory);
                return;
            }
            C1371a.c(AccessoryManager.TAG, " onReceiveResult: DEVICE_DETACHED and error code 0x" + Integer.toHexString(i11) + " uidType:" + peerAccessory.getUUIDType());
            this.f25160a.onAccessoryDisconnected(peerAccessory, i11);
            j(peerAccessory);
        }

        public void f(ConnectConfig connectConfig) {
            Iterator<ConnectConfig> it = this.f25161b.iterator();
            while (it.hasNext()) {
                ConnectConfig next = it.next();
                if (next.getAddress().equals(connectConfig.getAddress()) && next.getTransportType() == connectConfig.getTransportType() && next.getUidType() == connectConfig.getUidType()) {
                    C1371a.c(AccessoryManager.TAG, "connect config duplicate.....");
                    return;
                }
            }
            this.f25161b.add(connectConfig);
            C1371a.c(AccessoryManager.TAG, "add config :" + connectConfig);
        }

        public final boolean h(ConnectConfig connectConfig, PeerAccessory peerAccessory) {
            if (connectConfig.getAddress().equals(peerAccessory.getAddress()) && connectConfig.getTransportType() == peerAccessory.getTransportType() && connectConfig.getUidType() == peerAccessory.getUUIDType()) {
                return true;
            }
            return false;
        }

        public boolean i(PeerAccessory peerAccessory) {
            Iterator<ConnectConfig> it = this.f25161b.iterator();
            while (it.hasNext()) {
                if (h(it.next(), peerAccessory)) {
                    C1371a.k(AccessoryManager.TAG, "accessory is available, notify...");
                    return true;
                }
            }
            return false;
        }

        public void j(PeerAccessory peerAccessory) {
            ArrayList arrayList = new ArrayList();
            Iterator<ConnectConfig> it = this.f25161b.iterator();
            while (it.hasNext()) {
                ConnectConfig next = it.next();
                if (h(next, peerAccessory)) {
                    C1371a.c(AccessoryManager.TAG, "remove connect config success.....");
                    arrayList.add(next);
                }
            }
            this.f25161b.removeAll(arrayList);
        }

        @Override // android.os.ResultReceiver
        public void onReceiveResult(int i10, Bundle bundle) {
            if (bundle != null) {
                C1371a.c(AccessoryManager.TAG, " onReceiveResult: resultCode= " + i10);
                PeerAccessory peerAccessory = null;
                if (i10 == 20001) {
                    C1371a.k(AccessoryManager.TAG, "Accessory Framework has died or disconnected");
                    if (AccessoryManager.sOnlyInstance != null) {
                        AccessoryManager.sOnlyInstance.mIsConnected = false;
                    }
                    b();
                    this.f25160a.onError(null, 20001);
                    return;
                }
                bundle.setClassLoader(PeerAccessory.class.getClassLoader());
                byte[] byteArray = bundle.getByteArray(AFConstants.EXTRA_ACCESSORY);
                if (byteArray == null) {
                    return;
                }
                try {
                    Parcel obtain = Parcel.obtain();
                    if (obtain != null) {
                        obtain.unmarshall(byteArray, 0, byteArray.length);
                        obtain.setDataPosition(0);
                        peerAccessory = PeerAccessory.CREATOR.createFromParcel(obtain);
                        C1371a.c(AccessoryManager.TAG, "onReceiveResult, peerAcc: " + peerAccessory.toShortString());
                    }
                    if (obtain != null) {
                        obtain.recycle();
                    }
                    if (peerAccessory == null) {
                        C1371a.k(AccessoryManager.TAG, "onReceiveResult No accessory bundle, return...");
                        return;
                    } else if (this.f25160a == null) {
                        C1371a.k(AccessoryManager.TAG, "onReceiveResult callback is null.");
                        return;
                    } else {
                        d(i10, peerAccessory, bundle.getInt("errorcode"));
                        return;
                    }
                } catch (Throwable th) {
                    C1371a.e(AccessoryManager.TAG, "unmarshalling peerAccessory failed", th);
                    return;
                }
            }
            C1371a.k(AccessoryManager.TAG, "onReceiveResult: resultData is null");
        }
    }

    /* loaded from: classes3.dex */
    public static final class NetworkQualityCallbackReceiver extends ResultReceiver {
        public NetworkQualityCallbackReceiver(Handler handler, a aVar) {
            super(handler);
        }

        @Override // android.os.ResultReceiver
        public void onReceiveResult(int i10, Bundle bundle) {
            super.onReceiveResult(i10, bundle);
            bundle.putInt("result_code", i10);
            throw null;
        }
    }

    /* loaded from: classes3.dex */
    public interface a {
    }

    private AccessoryManager(Context context, AccessoryEventListener accessoryEventListener) {
        this.mContext = context;
        Initializer.initAFMAccessory(context);
        if (accessoryEventListener != null) {
            this.mConnectionEventReceiver = new ConnectionEventReceiver(null, accessoryEventListener);
        } else {
            C1371a.c(TAG, "getInstance: eventCallback is null..");
        }
        if (!this.mIsConnected) {
            C1371a.c(TAG, "mOnlyInstance.mIsConnected is false");
            bindOaf(context, accessoryEventListener);
        }
    }

    private void bindOaf(Context context, AccessoryEventListener accessoryEventListener) {
        String str = TAG;
        C1371a.g(str, "try to bind OAF");
        GenericAdapter q10 = GenericAdapter.q(context);
        this.mGenericAdapter = q10;
        if (q10 != null && q10.t()) {
            this.mIsConnected = true;
            if (accessoryEventListener != null) {
                this.mGenericAdapter.y(this.mConnectionEventReceiver);
                C1371a.c(str, "registerAccessoryCallback success");
            }
        }
    }

    private void checkKscValid(byte[] bArr) {
        if (bArr == null || bArr.length == 16) {
        } else {
            throw new IllegalArgumentException("ksc length must be 16");
        }
    }

    public static AccessoryManager getInstance(Context context, AccessoryEventListener accessoryEventListener) {
        if (context != null) {
            String str = TAG;
            C1371a.g(str, "AccessoryManager sdk version: " + VERSION);
            if (sOnlyInstance == null) {
                synchronized (AccessoryManager.class) {
                    try {
                        if (sOnlyInstance == null) {
                            sOnlyInstance = new AccessoryManager(context, accessoryEventListener);
                        }
                    } finally {
                    }
                }
            }
            synchronized (AccessoryManager.class) {
                try {
                    if (!sOnlyInstance.mIsConnected) {
                        C1371a.g(str, "try to bind Oaf service");
                        sOnlyInstance.bindOaf(context, accessoryEventListener);
                    }
                } finally {
                }
            }
            return sOnlyInstance;
        }
        throw new IllegalArgumentException("Invalid argument input context.");
    }

    public static void release() {
        C1371a.c(TAG, "release");
        sOnlyInstance = null;
        if (sOnlyInstance != null) {
            sOnlyInstance.releaseInternal();
            sOnlyInstance = null;
        }
    }

    private void releaseInternal() {
        if (this.mIsConnected) {
            GenericAdapter genericAdapter = this.mGenericAdapter;
            if (genericAdapter != null) {
                genericAdapter.z();
            }
            this.mIsConnected = false;
        }
    }

    private void validateTransportDetails(String str, int i10) {
        if (str != null && str.length() != 0) {
            if (i10 != 1) {
                if (i10 != 2 && i10 != 4) {
                    if (i10 != 8) {
                        throw new IllegalArgumentException("Invalid transport type:" + i10);
                    }
                    return;
                }
                if (Pattern.compile("^([0-9A-F]{2}[:-]){5}([0-9A-F]{2})$").matcher(str).matches()) {
                    return;
                }
                throw new IllegalArgumentException("Invalid BT Address:" + f.d(str));
            }
            return;
        }
        throw new IllegalArgumentException("Invalid transport address");
    }

    public boolean checkKscExist(byte[] bArr, byte[] bArr2) {
        if (this.mGenericAdapter == null) {
            this.mGenericAdapter = GenericAdapter.q(this.mContext);
        }
        int k10 = this.mGenericAdapter.k(bArr, bArr2);
        C1371a.c(TAG, "checkKscExist, deviceId: " + f.f(bArr) + ", alias: " + f.f(bArr2) + ", result: " + k10);
        return k10 == 0;
    }

    public void connect(ConnectConfig connectConfig) {
        validateTransportDetails(connectConfig.getAddress(), connectConfig.getTransportType());
        if (this.mGenericAdapter == null) {
            this.mGenericAdapter = GenericAdapter.q(this.mContext);
        }
        ConnectionEventReceiver connectionEventReceiver = this.mConnectionEventReceiver;
        if (connectionEventReceiver != null) {
            this.mGenericAdapter.y(connectionEventReceiver);
            this.mConnectionEventReceiver.f(connectConfig);
        }
        int l10 = this.mGenericAdapter.l(connectConfig);
        if (l10 == 0) {
            C1371a.c(TAG, "Connect requested successfully for address:" + f.d(connectConfig.getAddress()) + " Transport Type:" + connectConfig.getTransportType());
            return;
        }
        if (l10 == 3) {
            C1371a.d(TAG, "connect not support");
            return;
        }
        throw new IOException("Connect request failed：" + l10);
    }

    public void disconnect(byte[] bArr) {
        C1371a.c(TAG, "disconnect oaf channel, deviceId:" + f.f(bArr));
        List<PeerAccessory> connectedAccessories = getConnectedAccessories();
        ArrayList<PeerAccessory> arrayList = new ArrayList();
        for (PeerAccessory peerAccessory : connectedAccessories) {
            if (c.a(bArr, peerAccessory.getDeviceId())) {
                arrayList.add(peerAccessory);
            }
        }
        if (arrayList.isEmpty()) {
            C1371a.k(TAG, "disconnect oaf channel ignore. no device found:" + f.f(bArr) + ", connected acc count: " + connectedAccessories.size());
        }
        for (PeerAccessory peerAccessory2 : arrayList) {
            disconnect(peerAccessory2.getAddress(), peerAccessory2.getTransportType(), peerAccessory2.getUUIDType());
        }
    }

    public List<AccountInfo> getAccountInfoArray() {
        if (this.mGenericAdapter == null) {
            this.mGenericAdapter = GenericAdapter.q(this.mContext);
        }
        return this.mGenericAdapter.n();
    }

    public List<ServiceProfile> getAvailableServices(long j10) {
        C1371a.c(TAG, "getAvailableServices,accessoryId:" + j10);
        if (this.mGenericAdapter == null) {
            this.mGenericAdapter = GenericAdapter.q(this.mContext);
        }
        return this.mGenericAdapter.o(j10);
    }

    public List<PeerAccessory> getConnectedAccessories() {
        C1371a.c(TAG, "getConnectedAccessories");
        if (this.mGenericAdapter == null) {
            this.mGenericAdapter = GenericAdapter.q(this.mContext);
        }
        return this.mGenericAdapter.p();
    }

    public byte[] getLocalDeviceId() {
        if (this.mGenericAdapter == null) {
            this.mGenericAdapter = GenericAdapter.q(this.mContext);
        }
        byte[] r10 = this.mGenericAdapter.r();
        if (r10 == null) {
            C1371a.k(TAG, "loadLocalDeviceId is null");
        } else {
            C1371a.g(TAG, "loadLocalDeviceId success");
        }
        return r10;
    }

    public int getLocalDeviceType() {
        if (this.mGenericAdapter == null) {
            this.mGenericAdapter = GenericAdapter.q(this.mContext);
        }
        try {
            return this.mGenericAdapter.s();
        } catch (RemoteException e10) {
            throw new IOException(e10);
        }
    }

    public boolean hasBoundFramework() {
        if (this.mGenericAdapter == null) {
            this.mGenericAdapter = GenericAdapter.q(this.mContext);
        }
        return this.mGenericAdapter.t();
    }

    public boolean isAccessoryEnabled() {
        if (this.mGenericAdapter == null) {
            this.mGenericAdapter = GenericAdapter.q(this.mContext);
        }
        return this.mGenericAdapter.v();
    }

    @Deprecated
    public byte[] loadLocalDeviceId() {
        return getLocalDeviceId();
    }

    public void queryNetworkQuality(ConnectConfig connectConfig, a aVar) {
        if (connectConfig == null) {
            C1371a.k(TAG, "queryNetworkQuality config is null, return");
            return;
        }
        validateTransportDetails(connectConfig.getAddress(), connectConfig.getTransportType());
        if (this.mGenericAdapter == null) {
            this.mGenericAdapter = GenericAdapter.q(this.mContext);
        }
        this.mGenericAdapter.x(connectConfig, new NetworkQualityCallbackReceiver(null, aVar));
    }

    public boolean removeKsc(byte[] bArr, byte[] bArr2) {
        if (this.mGenericAdapter == null) {
            this.mGenericAdapter = GenericAdapter.q(this.mContext);
        }
        int A10 = this.mGenericAdapter.A(bArr, bArr2);
        C1371a.c(TAG, "checkKscExist, deviceId: " + f.f(bArr) + ", alias: " + f.f(bArr2) + ", result: " + A10);
        return A10 == 0;
    }

    public synchronized boolean setAccessoryDormant(boolean z10) {
        boolean z11;
        try {
            if (this.mGenericAdapter == null) {
                this.mGenericAdapter = GenericAdapter.q(this.mContext);
            }
            int C10 = this.mGenericAdapter.C(z10);
            if (C10 == 0) {
                C1371a.g(TAG, "acc status successfully set");
            } else {
                C1371a.k(TAG, "acc status set failed");
            }
            if (C10 == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
        } catch (Throwable th) {
            throw th;
        }
        return z11;
    }

    public int setFlowControlConfig(FlowControlConfig flowControlConfig) {
        if (this.mGenericAdapter == null) {
            this.mGenericAdapter = GenericAdapter.q(this.mContext);
        }
        int D10 = this.mGenericAdapter.D(flowControlConfig);
        if (D10 == 0) {
            C1371a.g(TAG, "setFlowControlConfig success:" + flowControlConfig);
        } else {
            C1371a.k(TAG, "setFlowControlConfig failed: " + D10);
        }
        return D10;
    }

    public boolean setKsc(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        String str = TAG;
        C1371a.c(str, "setKsc, " + f.f(bArr3));
        checkKscValid(bArr3);
        if (this.mGenericAdapter == null) {
            this.mGenericAdapter = GenericAdapter.q(this.mContext);
        }
        int E10 = this.mGenericAdapter.E(bArr, bArr2, bArr3);
        if (E10 == 0) {
            C1371a.g(str, "ksc successfully set");
        } else if (E10 == 4) {
            C1371a.k(str, "ksc set duplicate: " + E10);
        } else {
            C1371a.k(str, "ksc set error: " + E10);
        }
        if (E10 == 0) {
            return true;
        }
        return false;
    }

    @Deprecated
    public int setTrafficControlConfig(TrafficControlConfig trafficControlConfig) {
        if (this.mGenericAdapter == null) {
            this.mGenericAdapter = GenericAdapter.q(this.mContext);
        }
        int F10 = this.mGenericAdapter.F(trafficControlConfig);
        if (F10 == 0) {
            C1371a.k(TAG, "setTrafficControlConfig(deprecated. instead of setFlowControlConfig) success:" + trafficControlConfig);
        } else {
            C1371a.k(TAG, "setTrafficControlConfig(deprecated. instead of setFlowControlConfig) failed: " + F10);
        }
        return F10;
    }

    public boolean checkKscExist(byte[] bArr) {
        return checkKscExist(null, bArr);
    }

    public boolean removeKsc(byte[] bArr) {
        return removeKsc(null, bArr);
    }

    public void disconnect(String str, int i10) {
        disconnect(str, i10, 0);
    }

    public void disconnect(String str, int i10, int i11) {
        ConnectionEventReceiver connectionEventReceiver;
        String str2 = TAG;
        C1371a.c(str2, "disconnect oaf channel:" + f.d(str) + " Transport:" + i10 + " UUname:" + i11);
        validateTransportDetails(str, i10);
        if (this.mGenericAdapter == null) {
            this.mGenericAdapter = GenericAdapter.q(this.mContext);
        }
        if (!this.mGenericAdapter.u() && (connectionEventReceiver = this.mConnectionEventReceiver) != null) {
            this.mGenericAdapter.y(connectionEventReceiver);
        }
        if (this.mGenericAdapter.m(str, i10, i11) == 0) {
            C1371a.c(str2, "Disconnect requested successfully for address:" + f.d(str) + " Transport Type:" + i10);
            return;
        }
        throw new IOException("Disconnect request failed");
    }
}
