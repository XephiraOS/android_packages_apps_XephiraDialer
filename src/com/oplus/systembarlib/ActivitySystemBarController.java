package com.oplus.systembarlib;

import android.R;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.K;
import androidx.core.view.X;
import androidx.core.view.z;
import androidx.lifecycle.InterfaceC0491n;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.x;
import java.util.ArrayList;
import java.util.Iterator;
import v9.InterfaceC1637a;

/* compiled from: ActivitySystemBarController.kt */
/* loaded from: classes3.dex */
public final class ActivitySystemBarController implements e, InterfaceC0491n, h {

    /* renamed from: g, reason: collision with root package name */
    public static final a f28979g = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f28980a = new o(null, 1, null);

    /* renamed from: b, reason: collision with root package name */
    public AppCompatActivity f28981b;

    /* renamed from: c, reason: collision with root package name */
    public b f28982c;

    /* renamed from: d, reason: collision with root package name */
    public final m9.d f28983d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList<m> f28984e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f28985f;

    /* compiled from: ActivitySystemBarController.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: ActivitySystemBarController.kt */
    /* loaded from: classes3.dex */
    public interface b {
        com.oplus.systembarlib.b e();
    }

    public ActivitySystemBarController() {
        m9.d b10;
        b10 = kotlin.a.b(new InterfaceC1637a<String>() { // from class: com.oplus.systembarlib.ActivitySystemBarController$activityName$2
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            public final String invoke() {
                AppCompatActivity appCompatActivity;
                appCompatActivity = ActivitySystemBarController.this.f28981b;
                if (appCompatActivity == null) {
                    kotlin.jvm.internal.i.q("innerActivity");
                    appCompatActivity = null;
                }
                return appCompatActivity.getClass().getSimpleName();
            }
        });
        this.f28983d = b10;
        this.f28984e = new ArrayList<>();
    }

    public static final X h(ActivitySystemBarController this$0, View view, X windowInsets) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.e(windowInsets, "windowInsets");
        this$0.d(windowInsets);
        return K.V(view, windowInsets);
    }

    @Override // com.oplus.systembarlib.h
    public boolean B() {
        return this.f28980a.B();
    }

    @Override // com.oplus.systembarlib.h
    public void b0() {
        this.f28980a.b0();
    }

    public void c(Window window) {
        this.f28980a.c(window);
    }

    public final void d(X x10) {
        SystemBarLog.b("ActivitySystemBarController", "dispatchWindowInsetsUpdate. <" + e() + '>');
        b bVar = this.f28982c;
        if (bVar == null) {
            kotlin.jvm.internal.i.q("innerSystemBarStyleGetter");
            bVar = null;
        }
        bVar.e().b(x10);
        Iterator<T> it = this.f28984e.iterator();
        while (it.hasNext()) {
            ((m) it.next()).F0(x10);
        }
    }

    public final String e() {
        Object value = this.f28983d.getValue();
        kotlin.jvm.internal.i.e(value, "<get-activityName>(...)");
        return (String) value;
    }

    public final ViewGroup f() {
        AppCompatActivity appCompatActivity = this.f28981b;
        if (appCompatActivity == null) {
            kotlin.jvm.internal.i.q("innerActivity");
            appCompatActivity = null;
        }
        View findViewById = appCompatActivity.findViewById(R.id.content);
        kotlin.jvm.internal.i.e(findViewById, "innerActivity.findViewById(android.R.id.content)");
        return (ViewGroup) findViewById;
    }

    public void g(AppCompatActivity activity, b styleGetter) {
        AppCompatActivity appCompatActivity;
        kotlin.jvm.internal.i.f(activity, "activity");
        kotlin.jvm.internal.i.f(styleGetter, "styleGetter");
        this.f28982c = styleGetter;
        this.f28981b = activity;
        b bVar = null;
        if (activity == null) {
            kotlin.jvm.internal.i.q("innerActivity");
            appCompatActivity = null;
        } else {
            appCompatActivity = activity;
        }
        appCompatActivity.getLifecycle().a(this);
        l lVar = l.f29015a;
        AppCompatActivity appCompatActivity2 = this.f28981b;
        if (appCompatActivity2 == null) {
            kotlin.jvm.internal.i.q("innerActivity");
            appCompatActivity2 = null;
        }
        this.f28985f = lVar.a(appCompatActivity2);
        c(activity.getWindow());
        l(e());
        b bVar2 = this.f28982c;
        if (bVar2 == null) {
            kotlin.jvm.internal.i.q("innerSystemBarStyleGetter");
        } else {
            bVar = bVar2;
        }
        bVar.e().a();
        K.z0(f(), new z() { // from class: com.oplus.systembarlib.a
            @Override // androidx.core.view.z
            public final X onApplyWindowInsets(View view, X x10) {
                X h10;
                h10 = ActivitySystemBarController.h(ActivitySystemBarController.this, view, x10);
                return h10;
            }
        });
    }

    @Override // com.oplus.systembarlib.f
    public void h0(int i10) {
        this.f28980a.h0(i10);
    }

    public void i(Configuration config) {
        kotlin.jvm.internal.i.f(config, "config");
        l lVar = l.f29015a;
        AppCompatActivity appCompatActivity = this.f28981b;
        if (appCompatActivity == null) {
            kotlin.jvm.internal.i.q("innerActivity");
            appCompatActivity = null;
        }
        boolean a10 = lVar.a(appCompatActivity);
        if (this.f28985f != a10) {
            this.f28985f = a10;
            SystemBarLog.b("ActivitySystemBarController", "onConfigChangedForSystemBar. <" + e() + "> dark mode changed, isDarkMode=" + this.f28985f);
            X C10 = K.C(f());
            if (C10 != null) {
                d(C10);
            }
        }
    }

    public void j(m listener) {
        kotlin.jvm.internal.i.f(listener, "listener");
        if (this.f28984e.contains(listener)) {
            SystemBarLog.b("ActivitySystemBarController", "registerSystemBarChangeListener. <" + e() + "> already added.");
            return;
        }
        this.f28984e.add(listener);
    }

    public void k(int i10, int i11, int i12, int i13) {
        ViewGroup f10 = f();
        if (f10.getLeft() != i10 || f10.getTop() != i11 || f10.getRight() != i12 || f10.getBottom() != i13) {
            f10.setPadding(i10, i11, i12, i13);
        }
    }

    public void l(String tag) {
        kotlin.jvm.internal.i.f(tag, "tag");
        this.f28980a.d(tag);
    }

    @x(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        AppCompatActivity appCompatActivity = null;
        c(null);
        this.f28984e.clear();
        AppCompatActivity appCompatActivity2 = this.f28981b;
        if (appCompatActivity2 == null) {
            kotlin.jvm.internal.i.q("innerActivity");
        } else {
            appCompatActivity = appCompatActivity2;
        }
        appCompatActivity.getLifecycle().d(this);
    }

    @x(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        X C10 = K.C(f());
        if (C10 != null) {
            d(C10);
        }
    }

    @Override // com.oplus.systembarlib.g
    public void v(boolean z10) {
        this.f28980a.v(z10);
    }
}
