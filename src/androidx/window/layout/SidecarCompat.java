package androidx.window.layout;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.window.core.Version;
import androidx.window.layout.ExtensionInterfaceCompat;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarDisplayFeature;
import androidx.window.sidecar.SidecarInterface;
import androidx.window.sidecar.SidecarProvider;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.collections.o;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import m9.q;

/* compiled from: SidecarCompat.kt */
/* loaded from: classes.dex */
public final class SidecarCompat implements ExtensionInterfaceCompat {

    /* renamed from: f, reason: collision with root package name */
    public static final Companion f12030f = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    public final SidecarInterface f12031a;

    /* renamed from: b, reason: collision with root package name */
    public final SidecarAdapter f12032b;

    /* renamed from: c, reason: collision with root package name */
    public final Map<IBinder, Activity> f12033c;

    /* renamed from: d, reason: collision with root package name */
    public final Map<Activity, ComponentCallbacks> f12034d;

    /* renamed from: e, reason: collision with root package name */
    public ExtensionInterfaceCompat.ExtensionCallbackInterface f12035e;

    /* compiled from: SidecarCompat.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public final IBinder a(Activity activity) {
            Window window;
            WindowManager.LayoutParams attributes;
            if (activity != null && (window = activity.getWindow()) != null && (attributes = window.getAttributes()) != null) {
                return attributes.token;
            }
            return null;
        }

        public final SidecarInterface b(Context context) {
            i.f(context, "context");
            return SidecarProvider.getSidecarImpl(context.getApplicationContext());
        }

        public final Version c() {
            try {
                String apiVersion = SidecarProvider.getApiVersion();
                if (TextUtils.isEmpty(apiVersion)) {
                    return null;
                }
                return Version.f11924f.b(apiVersion);
            } catch (NoClassDefFoundError | UnsupportedOperationException unused) {
                return null;
            }
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    /* compiled from: SidecarCompat.kt */
    /* loaded from: classes.dex */
    public static final class DistinctElementCallback implements ExtensionInterfaceCompat.ExtensionCallbackInterface {

        /* renamed from: a, reason: collision with root package name */
        public final ExtensionInterfaceCompat.ExtensionCallbackInterface f12036a;

        /* renamed from: b, reason: collision with root package name */
        public final ReentrantLock f12037b;

        /* renamed from: c, reason: collision with root package name */
        public final WeakHashMap<Activity, WindowLayoutInfo> f12038c;

        public DistinctElementCallback(ExtensionInterfaceCompat.ExtensionCallbackInterface callbackInterface) {
            i.f(callbackInterface, "callbackInterface");
            this.f12036a = callbackInterface;
            this.f12037b = new ReentrantLock();
            this.f12038c = new WeakHashMap<>();
        }

        @Override // androidx.window.layout.ExtensionInterfaceCompat.ExtensionCallbackInterface
        public void a(Activity activity, WindowLayoutInfo newLayout) {
            i.f(activity, "activity");
            i.f(newLayout, "newLayout");
            ReentrantLock reentrantLock = this.f12037b;
            reentrantLock.lock();
            try {
                if (i.b(newLayout, this.f12038c.get(activity))) {
                    return;
                }
                this.f12038c.put(activity, newLayout);
                reentrantLock.unlock();
                this.f12036a.a(activity, newLayout);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    /* compiled from: SidecarCompat.kt */
    /* loaded from: classes.dex */
    public static final class DistinctSidecarElementCallback implements SidecarInterface.SidecarCallback {

        /* renamed from: a, reason: collision with root package name */
        public final SidecarAdapter f12039a;

        /* renamed from: b, reason: collision with root package name */
        public final SidecarInterface.SidecarCallback f12040b;

        /* renamed from: c, reason: collision with root package name */
        public final ReentrantLock f12041c;

        /* renamed from: d, reason: collision with root package name */
        public SidecarDeviceState f12042d;

        /* renamed from: e, reason: collision with root package name */
        public final WeakHashMap<IBinder, SidecarWindowLayoutInfo> f12043e;

        public DistinctSidecarElementCallback(SidecarAdapter sidecarAdapter, SidecarInterface.SidecarCallback callbackInterface) {
            i.f(sidecarAdapter, "sidecarAdapter");
            i.f(callbackInterface, "callbackInterface");
            this.f12039a = sidecarAdapter;
            this.f12040b = callbackInterface;
            this.f12041c = new ReentrantLock();
            this.f12043e = new WeakHashMap<>();
        }

        public void onDeviceStateChanged(SidecarDeviceState newDeviceState) {
            i.f(newDeviceState, "newDeviceState");
            ReentrantLock reentrantLock = this.f12041c;
            reentrantLock.lock();
            try {
                if (this.f12039a.a(this.f12042d, newDeviceState)) {
                    return;
                }
                this.f12042d = newDeviceState;
                this.f12040b.onDeviceStateChanged(newDeviceState);
                q qVar = q.f35511a;
            } finally {
                reentrantLock.unlock();
            }
        }

        public void onWindowLayoutChanged(IBinder token, SidecarWindowLayoutInfo newLayout) {
            i.f(token, "token");
            i.f(newLayout, "newLayout");
            synchronized (this.f12041c) {
                if (this.f12039a.d(this.f12043e.get(token), newLayout)) {
                    return;
                }
                this.f12043e.put(token, newLayout);
                this.f12040b.onWindowLayoutChanged(token, newLayout);
            }
        }
    }

    /* compiled from: SidecarCompat.kt */
    /* loaded from: classes.dex */
    public static final class FirstAttachAdapter implements View.OnAttachStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public final SidecarCompat f12044a;

        /* renamed from: b, reason: collision with root package name */
        public final WeakReference<Activity> f12045b;

        public FirstAttachAdapter(SidecarCompat sidecarCompat, Activity activity) {
            i.f(sidecarCompat, "sidecarCompat");
            i.f(activity, "activity");
            this.f12044a = sidecarCompat;
            this.f12045b = new WeakReference<>(activity);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            i.f(view, "view");
            view.removeOnAttachStateChangeListener(this);
            Activity activity = this.f12045b.get();
            IBinder a10 = SidecarCompat.f12030f.a(activity);
            if (activity == null || a10 == null) {
                return;
            }
            this.f12044a.i(a10, activity);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            i.f(view, "view");
        }
    }

    /* compiled from: SidecarCompat.kt */
    /* loaded from: classes.dex */
    public final class TranslatingCallback implements SidecarInterface.SidecarCallback {
        public TranslatingCallback() {
        }

        public void onDeviceStateChanged(SidecarDeviceState newDeviceState) {
            SidecarInterface g10;
            i.f(newDeviceState, "newDeviceState");
            Collection<Activity> values = SidecarCompat.this.f12033c.values();
            SidecarCompat sidecarCompat = SidecarCompat.this;
            for (Activity activity : values) {
                IBinder a10 = SidecarCompat.f12030f.a(activity);
                SidecarWindowLayoutInfo sidecarWindowLayoutInfo = null;
                if (a10 != null && (g10 = sidecarCompat.g()) != null) {
                    sidecarWindowLayoutInfo = g10.getWindowLayoutInfo(a10);
                }
                ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallbackInterface = sidecarCompat.f12035e;
                if (extensionCallbackInterface != null) {
                    extensionCallbackInterface.a(activity, sidecarCompat.f12032b.e(sidecarWindowLayoutInfo, newDeviceState));
                }
            }
        }

        public void onWindowLayoutChanged(IBinder windowToken, SidecarWindowLayoutInfo newLayout) {
            SidecarDeviceState sidecarDeviceState;
            i.f(windowToken, "windowToken");
            i.f(newLayout, "newLayout");
            Activity activity = (Activity) SidecarCompat.this.f12033c.get(windowToken);
            if (activity != null) {
                SidecarAdapter sidecarAdapter = SidecarCompat.this.f12032b;
                SidecarInterface g10 = SidecarCompat.this.g();
                if (g10 == null || (sidecarDeviceState = g10.getDeviceState()) == null) {
                    sidecarDeviceState = new SidecarDeviceState();
                }
                WindowLayoutInfo e10 = sidecarAdapter.e(newLayout, sidecarDeviceState);
                ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallbackInterface = SidecarCompat.this.f12035e;
                if (extensionCallbackInterface != null) {
                    extensionCallbackInterface.a(activity, e10);
                    return;
                }
                return;
            }
            Log.w("SidecarCompat", "Unable to resolve activity from window token. Missing a call to #onWindowLayoutChangeListenerAdded()?");
        }
    }

    public SidecarCompat(SidecarInterface sidecarInterface, SidecarAdapter sidecarAdapter) {
        i.f(sidecarAdapter, "sidecarAdapter");
        this.f12031a = sidecarInterface;
        this.f12032b = sidecarAdapter;
        this.f12033c = new LinkedHashMap();
        this.f12034d = new LinkedHashMap();
    }

    @Override // androidx.window.layout.ExtensionInterfaceCompat
    public void a(Activity activity) {
        i.f(activity, "activity");
        IBinder a10 = f12030f.a(activity);
        if (a10 != null) {
            i(a10, activity);
        } else {
            activity.getWindow().getDecorView().addOnAttachStateChangeListener(new FirstAttachAdapter(this, activity));
        }
    }

    @Override // androidx.window.layout.ExtensionInterfaceCompat
    public void b(ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallback) {
        i.f(extensionCallback, "extensionCallback");
        this.f12035e = new DistinctElementCallback(extensionCallback);
        SidecarInterface sidecarInterface = this.f12031a;
        if (sidecarInterface != null) {
            sidecarInterface.setSidecarCallback(new DistinctSidecarElementCallback(this.f12032b, new TranslatingCallback()));
        }
    }

    @Override // androidx.window.layout.ExtensionInterfaceCompat
    public void c(Activity activity) {
        boolean z10;
        SidecarInterface sidecarInterface;
        i.f(activity, "activity");
        IBinder a10 = f12030f.a(activity);
        if (a10 == null) {
            return;
        }
        SidecarInterface sidecarInterface2 = this.f12031a;
        if (sidecarInterface2 != null) {
            sidecarInterface2.onWindowLayoutChangeListenerRemoved(a10);
        }
        k(activity);
        if (this.f12033c.size() == 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f12033c.remove(a10);
        if (z10 && (sidecarInterface = this.f12031a) != null) {
            sidecarInterface.onDeviceStateListenersChanged(true);
        }
    }

    public final SidecarInterface g() {
        return this.f12031a;
    }

    public final WindowLayoutInfo h(Activity activity) {
        SidecarWindowLayoutInfo sidecarWindowLayoutInfo;
        SidecarDeviceState sidecarDeviceState;
        List h10;
        i.f(activity, "activity");
        IBinder a10 = f12030f.a(activity);
        if (a10 == null) {
            h10 = o.h();
            return new WindowLayoutInfo(h10);
        }
        SidecarInterface sidecarInterface = this.f12031a;
        if (sidecarInterface != null) {
            sidecarWindowLayoutInfo = sidecarInterface.getWindowLayoutInfo(a10);
        } else {
            sidecarWindowLayoutInfo = null;
        }
        SidecarAdapter sidecarAdapter = this.f12032b;
        SidecarInterface sidecarInterface2 = this.f12031a;
        if (sidecarInterface2 == null || (sidecarDeviceState = sidecarInterface2.getDeviceState()) == null) {
            sidecarDeviceState = new SidecarDeviceState();
        }
        return sidecarAdapter.e(sidecarWindowLayoutInfo, sidecarDeviceState);
    }

    public final void i(IBinder windowToken, Activity activity) {
        SidecarInterface sidecarInterface;
        i.f(windowToken, "windowToken");
        i.f(activity, "activity");
        this.f12033c.put(windowToken, activity);
        SidecarInterface sidecarInterface2 = this.f12031a;
        if (sidecarInterface2 != null) {
            sidecarInterface2.onWindowLayoutChangeListenerAdded(windowToken);
        }
        if (this.f12033c.size() == 1 && (sidecarInterface = this.f12031a) != null) {
            sidecarInterface.onDeviceStateListenersChanged(false);
        }
        ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallbackInterface = this.f12035e;
        if (extensionCallbackInterface != null) {
            extensionCallbackInterface.a(activity, h(activity));
        }
        j(activity);
    }

    public final void j(final Activity activity) {
        if (this.f12034d.get(activity) == null) {
            ComponentCallbacks componentCallbacks = new ComponentCallbacks() { // from class: androidx.window.layout.SidecarCompat$registerConfigurationChangeListener$configChangeObserver$1
                @Override // android.content.ComponentCallbacks
                public void onConfigurationChanged(Configuration newConfig) {
                    i.f(newConfig, "newConfig");
                    ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallbackInterface = SidecarCompat.this.f12035e;
                    if (extensionCallbackInterface != null) {
                        Activity activity2 = activity;
                        extensionCallbackInterface.a(activity2, SidecarCompat.this.h(activity2));
                    }
                }

                @Override // android.content.ComponentCallbacks
                public void onLowMemory() {
                }
            };
            this.f12034d.put(activity, componentCallbacks);
            activity.registerComponentCallbacks(componentCallbacks);
        }
    }

    public final void k(Activity activity) {
        activity.unregisterComponentCallbacks(this.f12034d.get(activity));
        this.f12034d.remove(activity);
    }

    public boolean l() {
        Method method;
        Class<?> cls;
        Method method2;
        Class<?> cls2;
        Method method3;
        Class<?> cls3;
        Method method4;
        Class<?> cls4;
        Class<?> cls5;
        Class<?> cls6;
        Class<?> cls7;
        Class<?> cls8;
        try {
            SidecarInterface sidecarInterface = this.f12031a;
            if (sidecarInterface != null && (cls8 = sidecarInterface.getClass()) != null) {
                method = cls8.getMethod("setSidecarCallback", SidecarInterface.SidecarCallback.class);
            } else {
                method = null;
            }
            if (method != null) {
                cls = method.getReturnType();
            } else {
                cls = null;
            }
            Class cls9 = Void.TYPE;
            if (i.b(cls, cls9)) {
                SidecarInterface sidecarInterface2 = this.f12031a;
                if (sidecarInterface2 != null) {
                    sidecarInterface2.getDeviceState();
                }
                SidecarInterface sidecarInterface3 = this.f12031a;
                if (sidecarInterface3 != null) {
                    sidecarInterface3.onDeviceStateListenersChanged(true);
                }
                SidecarInterface sidecarInterface4 = this.f12031a;
                if (sidecarInterface4 != null && (cls7 = sidecarInterface4.getClass()) != null) {
                    method2 = cls7.getMethod("getWindowLayoutInfo", IBinder.class);
                } else {
                    method2 = null;
                }
                if (method2 != null) {
                    cls2 = method2.getReturnType();
                } else {
                    cls2 = null;
                }
                if (i.b(cls2, SidecarWindowLayoutInfo.class)) {
                    SidecarInterface sidecarInterface5 = this.f12031a;
                    if (sidecarInterface5 != null && (cls6 = sidecarInterface5.getClass()) != null) {
                        method3 = cls6.getMethod("onWindowLayoutChangeListenerAdded", IBinder.class);
                    } else {
                        method3 = null;
                    }
                    if (method3 != null) {
                        cls3 = method3.getReturnType();
                    } else {
                        cls3 = null;
                    }
                    if (i.b(cls3, cls9)) {
                        SidecarInterface sidecarInterface6 = this.f12031a;
                        if (sidecarInterface6 != null && (cls5 = sidecarInterface6.getClass()) != null) {
                            method4 = cls5.getMethod("onWindowLayoutChangeListenerRemoved", IBinder.class);
                        } else {
                            method4 = null;
                        }
                        if (method4 != null) {
                            cls4 = method4.getReturnType();
                        } else {
                            cls4 = null;
                        }
                        if (i.b(cls4, cls9)) {
                            SidecarDeviceState sidecarDeviceState = new SidecarDeviceState();
                            try {
                                sidecarDeviceState.posture = 3;
                            } catch (NoSuchFieldError unused) {
                                SidecarDeviceState.class.getMethod("setPosture", Integer.TYPE).invoke(sidecarDeviceState, 3);
                                Object invoke = SidecarDeviceState.class.getMethod("getPosture", null).invoke(sidecarDeviceState, null);
                                if (invoke != null) {
                                    if (((Integer) invoke).intValue() != 3) {
                                        throw new Exception("Invalid device posture getter/setter");
                                    }
                                } else {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                                }
                            }
                            SidecarDisplayFeature sidecarDisplayFeature = new SidecarDisplayFeature();
                            Rect rect = sidecarDisplayFeature.getRect();
                            i.e(rect, "displayFeature.rect");
                            sidecarDisplayFeature.setRect(rect);
                            sidecarDisplayFeature.getType();
                            sidecarDisplayFeature.setType(1);
                            SidecarWindowLayoutInfo sidecarWindowLayoutInfo = new SidecarWindowLayoutInfo();
                            try {
                                List list = sidecarWindowLayoutInfo.displayFeatures;
                                return true;
                            } catch (NoSuchFieldError unused2) {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(sidecarDisplayFeature);
                                SidecarWindowLayoutInfo.class.getMethod("setDisplayFeatures", List.class).invoke(sidecarWindowLayoutInfo, arrayList);
                                Object invoke2 = SidecarWindowLayoutInfo.class.getMethod("getDisplayFeatures", null).invoke(sidecarWindowLayoutInfo, null);
                                if (invoke2 != null) {
                                    if (i.b(arrayList, (List) invoke2)) {
                                        return true;
                                    }
                                    throw new Exception("Invalid display feature getter/setter");
                                }
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<androidx.window.sidecar.SidecarDisplayFeature>");
                            }
                        }
                        throw new NoSuchMethodException("Illegal return type for 'onWindowLayoutChangeListenerRemoved': " + cls4);
                    }
                    throw new NoSuchMethodException("Illegal return type for 'onWindowLayoutChangeListenerAdded': " + cls3);
                }
                throw new NoSuchMethodException("Illegal return type for 'getWindowLayoutInfo': " + cls2);
            }
            throw new NoSuchMethodException("Illegal return type for 'setSidecarCallback': " + cls);
        } catch (Throwable unused3) {
            return false;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SidecarCompat(Context context) {
        this(f12030f.b(context), new SidecarAdapter(null, 1, null));
        i.f(context, "context");
    }
}
