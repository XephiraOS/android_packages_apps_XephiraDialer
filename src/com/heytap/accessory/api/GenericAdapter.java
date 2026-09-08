package com.heytap.accessory.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.ResultReceiver;
import com.android.contacts.framework.virtualsupport.utils.GrpcUtils;
import com.heytap.accessory.Config;
import com.heytap.accessory.Initializer;
import com.heytap.accessory.accessorymanager.ConnectConfig;
import com.heytap.accessory.api.ICMDeathCallback;
import com.heytap.accessory.api.IGenFrameworkManager;
import com.heytap.accessory.bean.AccountInfo;
import com.heytap.accessory.bean.FlowControlConfig;
import com.heytap.accessory.bean.PeerAccessory;
import com.heytap.accessory.bean.ServiceProfile;
import com.heytap.accessory.bean.TrafficControlConfig;
import com.heytap.accessory.constant.AFConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import n5.C1371a;
import r5.f;

/* loaded from: classes3.dex */
public class GenericAdapter {

    /* renamed from: e, reason: collision with root package name */
    public static final String f25172e = "GenericAdapter";

    /* renamed from: f, reason: collision with root package name */
    public static volatile GenericAdapter f25173f;

    /* renamed from: g, reason: collision with root package name */
    public static ICMDeathCallback f25174g;

    /* renamed from: h, reason: collision with root package name */
    public static CountDownLatch f25175h;

    /* renamed from: i, reason: collision with root package name */
    public static ServiceConnection f25176i = new a();

    /* renamed from: a, reason: collision with root package name */
    public ResultReceiver f25177a;

    /* renamed from: b, reason: collision with root package name */
    public long f25178b = -1;

    /* renamed from: c, reason: collision with root package name */
    public Context f25179c;

    /* renamed from: d, reason: collision with root package name */
    public IGenFrameworkManager f25180d;

    /* loaded from: classes3.dex */
    public static final class ICMDeathCallbackStub extends ICMDeathCallback.Stub {

        /* renamed from: f, reason: collision with root package name */
        public String f25181f;

        public ICMDeathCallbackStub(String str) {
            if (str != null) {
                this.f25181f = str;
                return;
            }
            throw new IllegalArgumentException("Invalid packageName:null");
        }

        @Override // com.heytap.accessory.api.ICMDeathCallback
        public String y() {
            return this.f25181f;
        }
    }

    /* loaded from: classes3.dex */
    public class a implements ServiceConnection {
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (GenericAdapter.f25173f) {
                try {
                    GenericAdapter.f25173f.f25180d = IGenFrameworkManager.Stub.N7(iBinder);
                    Bundle bundle = new Bundle();
                    String packageName = GenericAdapter.f25173f.f25179c.getPackageName();
                    C1371a.c(GenericAdapter.f25172e, "onServiceConnected: packageName: " + packageName);
                    bundle.putString(AFConstants.EXTRA_PACKAGE_NAME, packageName);
                    bundle.putInt("sdkVersionCode", Config.getSdkVersionCode());
                    C1371a.g(GenericAdapter.f25172e, "Getting CMxmlreader instance");
                    if (GenericAdapter.f25173f.f25180d != null) {
                        try {
                            Bundle s42 = GenericAdapter.f25173f.f25180d.s4(-1L, 1, bundle);
                            if (s42 == null) {
                                C1371a.g(GenericAdapter.f25172e, "response is null");
                            } else if (s42.containsKey(AFConstants.EXTRA_CLIENT_ID)) {
                                GenericAdapter.f25173f.f25178b = s42.getLong(AFConstants.EXTRA_CLIENT_ID);
                                GenericAdapter.f25173f.f25180d.F4(GenericAdapter.f25173f.f25178b, GenericAdapter.f25174g);
                            }
                        } catch (Exception e10) {
                            C1371a.d(GenericAdapter.f25172e, "exception: " + e10.getMessage());
                        }
                        if (GenericAdapter.f25173f.f25177a != null) {
                            GenericAdapter.f25173f.y(GenericAdapter.f25173f.f25177a);
                        }
                    }
                    C1371a.c(GenericAdapter.f25172e, "Client ID:" + GenericAdapter.f25173f.f25178b);
                    if (GenericAdapter.f25175h != null) {
                        GenericAdapter.f25175h.countDown();
                    }
                    C1371a.g(GenericAdapter.f25172e, "onServiceConnected: Just notified");
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (GenericAdapter.f25173f) {
                try {
                    C1371a.g(GenericAdapter.f25172e, "Disconnected from Generic service");
                    GenericAdapter.f25173f.f25180d = null;
                    GenericAdapter.f25173f.f25178b = -1L;
                    if (GenericAdapter.f25173f.f25177a != null) {
                        GenericAdapter.f25173f.f25177a.send(20001, new Bundle());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public GenericAdapter(Context context) {
        this.f25179c = context;
        f25174g = new ICMDeathCallbackStub(context.getPackageName());
    }

    public static GenericAdapter q(Context context) {
        if (f25173f == null) {
            synchronized (GenericAdapter.class) {
                try {
                    if (f25173f == null) {
                        f25173f = new GenericAdapter(context);
                    }
                } finally {
                }
            }
        }
        if (f25173f.f25180d == null) {
            f25175h = new CountDownLatch(1);
            Intent intent = new Intent(ManagerConfig.INTENT_BASE_FRAMEWORK_SERVICE);
            if (Initializer.useOAFApp()) {
                intent.setPackage(ManagerConfig.ACCESSORY_FRAMEWORK_PACKAGE);
            } else {
                intent.setPackage(context.getPackageName());
            }
            if (!context.bindService(intent, f25176i, 33)) {
                C1371a.k(f25172e, "bind INTENT_BASE_FRAMEWORK_SERVICE failed!");
                if (f25173f.f25177a != null) {
                    f25173f.f25177a.send(20001, new Bundle());
                }
                return f25173f;
            }
            try {
                C1371a.c(f25172e, "start count down latch");
                f25175h.await(GrpcUtils.CREATE_CHANNEL_TIME_OUT, TimeUnit.MILLISECONDS);
            } catch (Exception unused) {
                C1371a.d(f25172e, "bind GAdapter error.");
            }
        }
        return f25173f;
    }

    public synchronized int A(byte[] bArr, byte[] bArr2) {
        Bundle bundle;
        bundle = new Bundle();
        bundle.putByteArray(AFConstants.EXTRA_CONNECT_PARAM_DEVICE_ID, bArr);
        bundle.putByteArray(AFConstants.EXTRA_CONNECT_PARAM_KSC_ALIAS, bArr2);
        try {
        } catch (RemoteException e10) {
            C1371a.d(f25172e, "exception: " + e10.getMessage());
            return -1;
        }
        return B(this.f25180d, this.f25178b, 21, bundle).getInt("statusCode");
    }

    public final synchronized Bundle B(IGenFrameworkManager iGenFrameworkManager, long j10, int i10, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (iGenFrameworkManager == null) {
            String str = f25172e;
            C1371a.k(str, "proxy is null, rebind service please");
            bundle2.putInt("statusCode", -1);
            C1371a.k(str, "proxy is null, maybe you need to bind oaf service.");
            return bundle2;
        }
        Bundle s42 = this.f25180d.s4(j10, i10, bundle);
        if (s42 != null) {
            return s42;
        }
        throw new RemoteException("command not support:" + i10 + ", please update oaf.");
    }

    public synchronized int C(boolean z10) {
        Bundle bundle;
        bundle = new Bundle();
        bundle.putBoolean(AFConstants.EXTRA_DORMANT_STATE, z10);
        try {
        } catch (RemoteException e10) {
            C1371a.d(f25172e, "exception: connect " + e10.getMessage());
            e10.printStackTrace();
            return -1;
        }
        return B(this.f25180d, this.f25178b, 11, bundle).getInt("statusCode");
    }

    public synchronized int D(FlowControlConfig flowControlConfig) {
        Bundle bundle;
        bundle = flowControlConfig.getBundle();
        C1371a.g(f25172e + "[TCTrack]", " setFlowControlConfig(new) = " + flowControlConfig);
        try {
        } catch (RemoteException e10) {
            C1371a.d(f25172e, "exception: " + e10.getMessage());
            return -1;
        }
        return B(this.f25180d, this.f25178b, 30, bundle).getInt("statusCode");
    }

    public synchronized int E(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        Bundle bundle;
        bundle = new Bundle();
        bundle.putByteArray(AFConstants.EXTRA_CONNECT_PARAM_DEVICE_ID, bArr);
        bundle.putByteArray(AFConstants.EXTRA_CONNECT_PARAM_KSC_ALIAS, bArr2);
        bundle.putByteArray(AFConstants.EXTRA_CONNECT_PARAM_KSC, bArr3);
        C1371a.c(f25172e, "adapter setKsc, deviceId:" + f.f(bArr) + ", alias:" + f.f(bArr2));
        try {
        } catch (RemoteException e10) {
            C1371a.d(f25172e, "exception: " + e10.getMessage());
            return -1;
        }
        return B(this.f25180d, this.f25178b, 9, bundle).getInt("statusCode");
    }

    @Deprecated
    public synchronized int F(TrafficControlConfig trafficControlConfig) {
        Bundle bundle;
        bundle = trafficControlConfig.getBundle();
        C1371a.g(f25172e + "[TCTrack]", "setTrafficControlConfig(old) = " + trafficControlConfig);
        try {
        } catch (RemoteException e10) {
            C1371a.d(f25172e, "exception: " + e10.getMessage());
            return -1;
        }
        return B(this.f25180d, this.f25178b, 30, bundle).getInt("statusCode");
    }

    public synchronized int k(byte[] bArr, byte[] bArr2) {
        Bundle bundle;
        bundle = new Bundle();
        bundle.putByteArray(AFConstants.EXTRA_CONNECT_PARAM_DEVICE_ID, bArr);
        bundle.putByteArray(AFConstants.EXTRA_CONNECT_PARAM_KSC_ALIAS, bArr2);
        try {
        } catch (RemoteException e10) {
            C1371a.d(f25172e, "exception: " + e10.getMessage());
            return -1;
        }
        return B(this.f25180d, this.f25178b, 20, bundle).getInt("statusCode");
    }

    public synchronized int l(ConnectConfig connectConfig) {
        int i10;
        Bundle bundle = new Bundle();
        bundle.putAll(connectConfig.getBundle());
        try {
            i10 = B(this.f25180d, this.f25178b, 8, bundle).getInt("statusCode");
        } catch (RemoteException e10) {
            C1371a.d(f25172e, "exception: connect " + e10.getMessage());
            e10.printStackTrace();
            i10 = -1;
        }
        return i10;
    }

    public synchronized int m(String str, int i10, int i11) {
        int i12;
        Bundle bundle = new Bundle();
        bundle.putString("address", str);
        bundle.putInt("transportType", i10);
        bundle.putInt(AFConstants.EXTRA_UUID, i11);
        try {
            i12 = B(this.f25180d, this.f25178b, 3, bundle).getInt("statusCode");
        } catch (RemoteException e10) {
            C1371a.d(f25172e, "exception: disconnect " + e10.getMessage());
            e10.printStackTrace();
            i12 = -1;
        }
        return i12;
    }

    public synchronized List<AccountInfo> n() {
        Bundle B10;
        Bundle bundle = new Bundle();
        C1371a.c(f25172e, "adapter getAccountInfoArray = " + bundle);
        ArrayList arrayList = new ArrayList();
        try {
            B10 = B(this.f25180d, this.f25178b, 10, bundle);
            B10.setClassLoader(AccountInfo.class.getClassLoader());
        } catch (RemoteException e10) {
            C1371a.d(f25172e, "exception: " + e10.getMessage());
        }
        if (B10.getInt(AFConstants.EXTRA_CONNECT_PARAM_ACCOUNT_SIZE) == 0) {
            return arrayList;
        }
        arrayList = B10.getParcelableArrayList(AFConstants.EXTRA_CONNECT_PARAM_ACCOUNT_LIST);
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        return arrayList;
    }

    public synchronized List<ServiceProfile> o(long j10) {
        ArrayList arrayList;
        Object obj;
        try {
            arrayList = new ArrayList();
            Bundle bundle = new Bundle();
            bundle.putLong("accessoryId", j10);
            try {
                Bundle B10 = B(this.f25180d, this.f25178b, 12, bundle);
                B10.setClassLoader(ServiceProfile.class.getClassLoader());
                if (B10.getInt("statusCode", -1) == 0) {
                    arrayList = B10.getParcelableArrayList("remoteServices");
                }
                String str = f25172e;
                StringBuilder sb = new StringBuilder();
                sb.append("return accessoryId:");
                sb.append(j10);
                sb.append(" services size:");
                if (arrayList != null) {
                    obj = Integer.valueOf(arrayList.size());
                } else {
                    obj = "null";
                }
                sb.append(obj);
                C1371a.c(str, sb.toString());
            } catch (RemoteException e10) {
                C1371a.d(f25172e, "getAvailableServices exception: " + e10.getMessage());
            }
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
        } catch (Throwable th) {
            throw th;
        }
        return arrayList;
    }

    public synchronized List<PeerAccessory> p() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        try {
            Bundle B10 = B(this.f25180d, this.f25178b, 4, new Bundle());
            B10.setClassLoader(PeerAccessory.class.getClassLoader());
            if (B10.getInt("statusCode", -1) == 0) {
                arrayList = B10.getParcelableArrayList("connectedAccessories");
            }
        } catch (RemoteException e10) {
            C1371a.d(f25172e, "exception: " + e10.getMessage());
        }
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        return arrayList;
    }

    public synchronized byte[] r() {
        byte[] byteArray;
        try {
            try {
                byteArray = B(this.f25180d, this.f25178b, 22, new Bundle()).getByteArray("extra_local_device_id");
                if (byteArray == null) {
                    C1371a.k(f25172e, "getPresentDeviceId null");
                } else {
                    C1371a.c(f25172e, "getPresentDeviceId success");
                }
            } catch (RemoteException e10) {
                C1371a.d(f25172e, "getPresentDeviceId exception: " + e10.getMessage());
                return null;
            }
        } catch (Throwable th) {
            throw th;
        }
        return byteArray;
    }

    public synchronized int s() {
        return B(this.f25180d, this.f25178b, 23, new Bundle()).getInt(AFConstants.EXTRA_LOCAL_DEVICE_TYPE);
    }

    public synchronized boolean t() {
        boolean z10;
        if (this.f25180d != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        return z10;
    }

    public synchronized boolean u() {
        boolean z10;
        if (f25173f.f25177a != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        return z10;
    }

    public synchronized boolean v() {
        boolean z10;
        z10 = false;
        try {
            int i10 = B(this.f25180d, this.f25178b, 31, new Bundle()).getInt(AFConstants.EXTRA_OAF_SWITCH_STATE, -1);
            C1371a.c(f25172e, "isQuickConnectSwitchOpened state:" + i10);
            if (i10 != 0) {
                z10 = true;
            }
        } catch (RemoteException e10) {
            C1371a.d(f25172e, "exception: isQuickConnectSwitchOpened " + e10.getMessage());
            e10.printStackTrace();
        }
        return z10;
    }

    public final ResultReceiver w(ResultReceiver resultReceiver) {
        Parcel obtain = Parcel.obtain();
        resultReceiver.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        ResultReceiver resultReceiver2 = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(obtain);
        obtain.recycle();
        return resultReceiver2;
    }

    public synchronized void x(ConnectConfig connectConfig, ResultReceiver resultReceiver) {
        try {
            Bundle bundle = new Bundle();
            bundle.putAll(connectConfig.getBundle());
            bundle.putParcelable("networkQualityResultReceiver", w(resultReceiver));
            B(this.f25180d, this.f25178b, 32, bundle);
        } catch (RemoteException e10) {
            C1371a.d(f25172e, "getPresentDeviceId exception: " + e10.getMessage());
        }
    }

    public synchronized boolean y(ResultReceiver resultReceiver) {
        C1371a.c(f25172e, "Register callback");
        Bundle bundle = new Bundle();
        f25173f.f25177a = resultReceiver;
        bundle.putParcelable("resultReceiver", w(resultReceiver));
        try {
            if (B(this.f25180d, this.f25178b, 6, bundle).getInt("statusCode", -1) == 0) {
                return true;
            }
        } catch (RemoteException e10) {
            C1371a.d(f25172e, "exception: " + e10.getMessage());
        }
        return false;
    }

    public synchronized void z() {
        Bundle bundle = new Bundle();
        if (f25173f.f25180d != null) {
            try {
                if (B(f25173f.f25180d, f25173f.f25178b, 5, bundle).getInt("statusCode", -1) == 0) {
                    C1371a.c(f25172e, "Framework connection terminated successfully.");
                }
            } catch (RemoteException e10) {
                C1371a.d(f25172e, "exception: " + e10.getMessage());
            }
            if (f25173f.f25179c != null) {
                try {
                    f25173f.f25179c.unbindService(f25176i);
                } catch (Exception e11) {
                    C1371a.d(f25172e, "exception: unbind");
                    e11.printStackTrace();
                }
            }
            f25173f.f25180d = null;
            f25173f.f25178b = -1L;
            f25173f.f25177a = null;
        }
    }
}
