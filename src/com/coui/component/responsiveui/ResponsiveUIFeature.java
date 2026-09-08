package com.coui.component.responsiveui;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.util.Log;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.InterfaceC0480c;
import androidx.lifecycle.InterfaceC0492o;
import androidx.lifecycle.v;
import com.coui.component.responsiveui.ResponsiveUIFeature;
import com.coui.component.responsiveui.status.FoldingState;
import com.coui.component.responsiveui.status.FoldingStateUtil;
import com.coui.component.responsiveui.status.WindowFeature;
import com.coui.component.responsiveui.status.WindowFeatureUtil;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: ResponsiveUIFeature.kt */
/* loaded from: classes3.dex */
public final class ResponsiveUIFeature implements IResponsiveUIFeature {
    public static final Companion Companion = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f19985c;

    /* renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap<Integer, IResponsiveUIFeature> f19986d;

    /* renamed from: a, reason: collision with root package name */
    public WeakReference<Activity> f19987a;

    /* renamed from: b, reason: collision with root package name */
    public v<WindowFeature> f19988b;

    /* compiled from: ResponsiveUIFeature.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public Companion() {
        }

        public final FoldingState getFoldingState(Context context) {
            i.f(context, "context");
            return FoldingStateUtil.getFoldingState(context);
        }

        public final IResponsiveUIFeature getOrCreate(ComponentActivity activity) {
            i.f(activity, "activity");
            int hashCode = activity.hashCode();
            IResponsiveUIFeature iResponsiveUIFeature = (IResponsiveUIFeature) ResponsiveUIFeature.f19986d.get(Integer.valueOf(hashCode));
            if (iResponsiveUIFeature == null) {
                ResponsiveUIFeature responsiveUIFeature = new ResponsiveUIFeature(activity, null);
                ResponsiveUIFeature.f19986d.put(Integer.valueOf(hashCode), responsiveUIFeature);
                return responsiveUIFeature;
            }
            return iResponsiveUIFeature;
        }

        public final boolean isSupportWindowFeature() {
            return WindowFeatureUtil.isSupportWindowFeature();
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    static {
        boolean z10;
        ResponsiveUILog responsiveUILog = ResponsiveUILog.INSTANCE;
        if (!responsiveUILog.getLOG_DEBUG() && !responsiveUILog.isLoggable("ResponsiveUIFeature", 3)) {
            z10 = false;
        } else {
            z10 = true;
        }
        f19985c = z10;
        f19986d = new ConcurrentHashMap<>();
    }

    public /* synthetic */ ResponsiveUIFeature(ComponentActivity componentActivity, f fVar) {
        this(componentActivity);
    }

    public static final void b(ResponsiveUIFeature this$0, WindowFeature windowFeature) {
        i.f(this$0, "this$0");
        i.f(windowFeature, "windowFeature");
        this$0.c(this$0.f19988b, windowFeature);
    }

    public static final FoldingState getFoldingState(Context context) {
        return Companion.getFoldingState(context);
    }

    public static final IResponsiveUIFeature getOrCreate(ComponentActivity componentActivity) {
        return Companion.getOrCreate(componentActivity);
    }

    public static final boolean isSupportWindowFeature() {
        return Companion.isSupportWindowFeature();
    }

    public final <T> void c(v<T> vVar, T t10) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            vVar.o(t10);
        } else {
            vVar.m(t10);
        }
    }

    @Override // com.coui.component.responsiveui.IResponsiveUIFeature
    public v<WindowFeature> getWindowFeatureLiveData() {
        return this.f19988b;
    }

    public ResponsiveUIFeature(ComponentActivity componentActivity) {
        this.f19987a = new WeakReference<>(componentActivity);
        this.f19988b = new v<>();
        if (WindowFeatureUtil.isSupportWindowFeature()) {
            WindowFeatureUtil.INSTANCE.trackWindowFeature(componentActivity, new Consumer() { // from class: A3.a
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ResponsiveUIFeature.b(ResponsiveUIFeature.this, (WindowFeature) obj);
                }
            });
        } else if (f19985c) {
            Log.w("ResponsiveUIFeature", "[init.isSupportWindowFeature] false");
        }
        componentActivity.getLifecycle().a(new InterfaceC0480c() { // from class: com.coui.component.responsiveui.ResponsiveUIFeature.2
            @Override // androidx.lifecycle.InterfaceC0480c
            public /* bridge */ /* synthetic */ void onCreate(InterfaceC0492o interfaceC0492o) {
                super.onCreate(interfaceC0492o);
            }

            @Override // androidx.lifecycle.InterfaceC0480c
            public void onDestroy(InterfaceC0492o owner) {
                i.f(owner, "owner");
                super.onDestroy(owner);
                Activity activity = (Activity) ResponsiveUIFeature.this.f19987a.get();
                if (activity != null) {
                    ResponsiveUIFeature.f19986d.remove(Integer.valueOf(activity.hashCode()));
                }
            }

            @Override // androidx.lifecycle.InterfaceC0480c
            public /* bridge */ /* synthetic */ void onPause(InterfaceC0492o interfaceC0492o) {
                super.onPause(interfaceC0492o);
            }

            @Override // androidx.lifecycle.InterfaceC0480c
            public /* bridge */ /* synthetic */ void onResume(InterfaceC0492o interfaceC0492o) {
                super.onResume(interfaceC0492o);
            }

            @Override // androidx.lifecycle.InterfaceC0480c
            public /* bridge */ /* synthetic */ void onStart(InterfaceC0492o interfaceC0492o) {
                super.onStart(interfaceC0492o);
            }

            @Override // androidx.lifecycle.InterfaceC0480c
            public /* bridge */ /* synthetic */ void onStop(InterfaceC0492o interfaceC0492o) {
                super.onStop(interfaceC0492o);
            }
        });
    }
}
