package com.heytap.accessory.discovery;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import com.heytap.accessory.Config;
import com.heytap.accessory.Initializer;
import com.heytap.accessory.api.IDeathCallback;
import com.heytap.accessory.api.IDiscoveryNativeService;
import com.heytap.accessory.api.IServiceConnectionIndicationCallback;
import com.heytap.accessory.api.ManagerConfig;
import com.heytap.accessory.bean.SdkUnsupportedException;
import com.heytap.accessory.constant.DiscoveryServiceConstants;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import n5.C1371a;

/* loaded from: classes3.dex */
public abstract class BaseManager implements ServiceConnection {
    private static final String BACKGROUND_THREAD_NAME = "BGT";
    public static final int FASTPAIR_CORE_VERSION_10200 = 10200;
    private static final String TAG = "BaseManager";
    private long mAppConnectionId;
    private Executor mBgThreadPool = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.heytap.accessory.discovery.d
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread lambda$new$0;
            lambda$new$0 = BaseManager.lambda$new$0(runnable);
            return lambda$new$0;
        }
    });
    private IDeathCallback mDeathCallback;
    private int mFpCoreVersion;
    private ServiceConnectionIndicationCallback mScIndicationCallback;
    private int mServiceVersion;

    /* loaded from: classes3.dex */
    public static final class DeathCallbackStub extends IDeathCallback.Stub {

        /* renamed from: f, reason: collision with root package name */
        public String f25219f;

        public DeathCallbackStub(String str) {
            if (str != null) {
                this.f25219f = str;
                return;
            }
            throw new IllegalArgumentException("Invalid packageName:null");
        }

        @Override // com.heytap.accessory.api.IDeathCallback
        public String y() {
            return this.f25219f;
        }
    }

    /* loaded from: classes3.dex */
    public final class ServiceConnectionIndicationCallback extends IServiceConnectionIndicationCallback.Stub {
        @Override // com.heytap.accessory.api.IServiceConnectionIndicationCallback
        public void D1(Bundle bundle) {
            C1371a.g(BaseManager.TAG, "onServiceConnectionRequested: " + bundle);
        }

        public ServiceConnectionIndicationCallback() {
            C1371a.g(BaseManager.TAG, "ServiceConnectionIndicationCallback");
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public boolean f25221a;

        /* renamed from: b, reason: collision with root package name */
        public IManagerCallback f25222b;

        public b(boolean z10, IManagerCallback iManagerCallback) {
            this.f25221a = z10;
            this.f25222b = iManagerCallback;
        }
    }

    public static void initAFMAccessory(Context context) {
        int i10;
        if (context != null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(ManagerConfig.ACCESSORY_FRAMEWORK_PACKAGE, 0);
                if (packageInfo == null) {
                    i10 = -1;
                } else {
                    i10 = packageInfo.versionCode;
                }
                Initializer.initContext(context);
                Initializer.setOAFSdkVersion(i10);
                C1371a.g(TAG, "AF version: " + i10);
                return;
            } catch (PackageManager.NameNotFoundException unused) {
                C1371a.d(TAG, "AF not installed");
                throw new SdkUnsupportedException("AF not installed", 2);
            }
        }
        throw new IllegalArgumentException("Illegal argument: context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Thread lambda$new$0(Runnable runnable) {
        return new Thread(runnable, BACKGROUND_THREAD_NAME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onServiceConnected$1(IDiscoveryNativeService iDiscoveryNativeService) {
        makeDiscoveryConnection(iDiscoveryNativeService);
        onSubServiceConnected(iDiscoveryNativeService);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$runOnBackGround$2(Context context) {
        C1371a.g(TAG, "runOnBackGround MSG_BIND_SERVICE andSdk(" + Build.VERSION.SDK_INT + ")");
        onSubBindService(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$runOnBackGround$3(j jVar) {
        C1371a.g(TAG, "runOnBackGround MSG_RUN_RUNNABLE andSdk(" + Build.VERSION.SDK_INT + ")");
        if (jVar != null) {
            jVar.run();
        }
    }

    private void makeDiscoveryConnection(IDiscoveryNativeService iDiscoveryNativeService) {
        try {
            Bundle n52 = iDiscoveryNativeService.n5(Process.myPid(), getPackageName(), this.mDeathCallback, Config.getSdkVersionCode(), this.mScIndicationCallback);
            if (n52 == null) {
                C1371a.d(TAG, "onServiceConnected failed,AUTHCODE_EXPECTED invalid response");
                return;
            }
            long j10 = n52.getLong(DiscoveryServiceConstants.EXTRA_CLIENT_ID, -1L);
            this.mAppConnectionId = j10;
            if (j10 == -1) {
                C1371a.d(TAG, "onServiceConnected failed, invalid AppConnectionId, error: " + n52.getInt(DiscoveryServiceConstants.EXTRA_ERROR_CODE, 0));
                return;
            }
            this.mServiceVersion = n52.getInt(DiscoveryServiceConstants.EXTRA_SERVICE_VERSION, 1);
            this.mFpCoreVersion = n52.getInt(DiscoveryServiceConstants.EXTRA_FP_CORE_VERSION, 1);
            C1371a.g(TAG, "Received AppConnectionId: " + this.mAppConnectionId + ", serviceVersion: " + this.mServiceVersion + ", fpcoreVersion: " + this.mFpCoreVersion);
        } catch (Exception e10) {
            C1371a.f(TAG, e10);
        }
    }

    public int getFpCoreVersion() {
        return this.mFpCoreVersion;
    }

    public abstract String getPackageName();

    public int getServiceVersion() {
        return this.mServiceVersion;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        String str = TAG;
        C1371a.g(str, "trace-onServiceConnected, ComponentName: " + componentName + ", service: " + iBinder);
        final IDiscoveryNativeService N72 = IDiscoveryNativeService.Stub.N7(iBinder);
        if (N72 == null) {
            C1371a.d(str, "onServiceConnected failed, service is null");
            return;
        }
        this.mDeathCallback = new DeathCallbackStub(getPackageName());
        this.mScIndicationCallback = new ServiceConnectionIndicationCallback();
        this.mBgThreadPool.execute(new Runnable() { // from class: com.heytap.accessory.discovery.c
            @Override // java.lang.Runnable
            public final void run() {
                BaseManager.this.lambda$onServiceConnected$1(N72);
            }
        });
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        C1371a.g(TAG, "trace-onServiceDisconnected, ComponentName: " + componentName);
        onSubServiceDisconnected();
    }

    public abstract void onSubBindService(Context context);

    public abstract void onSubServiceConnected(IDiscoveryNativeService iDiscoveryNativeService);

    public abstract void onSubServiceDisconnected();

    public void runOnBackGround(final Context context, final j jVar) {
        C1371a.g(TAG, "runOnBackGround");
        this.mBgThreadPool.execute(new Runnable() { // from class: com.heytap.accessory.discovery.a
            @Override // java.lang.Runnable
            public final void run() {
                BaseManager.this.lambda$runOnBackGround$2(context);
            }
        });
        this.mBgThreadPool.execute(new Runnable() { // from class: com.heytap.accessory.discovery.b
            @Override // java.lang.Runnable
            public final void run() {
                BaseManager.lambda$runOnBackGround$3(j.this);
            }
        });
    }
}
