package com.oplus.foundation.appsupport.ui.activity;

import B.b;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.X;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.InterfaceC0492o;
import com.coui.appcompat.theme.COUIThemeOverlay;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.coui.responsiveui.config.ResponsiveUIConfig;
import com.coui.responsiveui.config.UIConfig;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.oplus.foundation.appsupport.ui.uiconfig.UIConfigObserverImpl;
import com.oplus.systembarlib.ActivitySystemBarController;
import com.oplus.systembarlib.e;
import com.oplus.systembarlib.i;
import com.oplus.systembarlib.m;
import com.oplus.systembarlib.p;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import kotlin.LazyThreadSafetyMode;
import m7.C1341b;
import m9.d;
import r7.C1514c;
import r7.InterfaceC1512a;
import r7.InterfaceC1515d;
import t7.C1595a;
import u7.InterfaceC1611a;
import v9.InterfaceC1637a;

/* compiled from: BaseUIActivity.kt */
/* loaded from: classes3.dex */
public abstract class BaseUIActivity<BD extends ViewDataBinding> extends AppCompatActivity implements InterfaceC1512a, InterfaceC1515d, InterfaceC1611a, e, ActivitySystemBarController.b, m {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UIConfigObserverImpl f28187a = new UIConfigObserverImpl();

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C1595a f28188b = new C1595a();

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ActivitySystemBarController f28189c = new ActivitySystemBarController();

    /* renamed from: d, reason: collision with root package name */
    public final d f28190d;

    /* renamed from: e, reason: collision with root package name */
    public final d f28191e;

    /* compiled from: BaseUIActivity.kt */
    /* loaded from: classes3.dex */
    public static final class a extends i {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BaseUIActivity<BD> f28192b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(BaseUIActivity<BD> baseUIActivity) {
            super(baseUIActivity);
            this.f28192b = baseUIActivity;
        }

        @Override // com.oplus.systembarlib.i, com.oplus.systembarlib.b
        public void b(X windowInsets) {
            kotlin.jvm.internal.i.f(windowInsets, "windowInsets");
            super.b(windowInsets);
            int i10 = 0;
            b g10 = p.g(windowInsets, false, 1, null);
            BaseUIActivity<BD> baseUIActivity = this.f28192b;
            if (baseUIActivity.B()) {
                i10 = g10.f210d;
            }
            baseUIActivity.u0(g10.f207a, g10.f208b, g10.f209c, i10);
        }
    }

    public BaseUIActivity() {
        d a10;
        d b10;
        a10 = kotlin.a.a(LazyThreadSafetyMode.f34163c, new InterfaceC1637a<BD>(this) { // from class: com.oplus.foundation.appsupport.ui.activity.BaseUIActivity$dataBinding$2
            final /* synthetic */ BaseUIActivity<BD> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Incorrect return type in method signature: ()TBD; */
            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final ViewDataBinding invoke() {
                BaseUIActivity<BD> baseUIActivity = this.this$0;
                LayoutInflater layoutInflater = baseUIActivity.getLayoutInflater();
                kotlin.jvm.internal.i.e(layoutInflater, "layoutInflater");
                Type genericSuperclass = baseUIActivity.getClass().getGenericSuperclass();
                kotlin.jvm.internal.i.d(genericSuperclass, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
                Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
                kotlin.jvm.internal.i.e(actualTypeArguments, "this.javaClass.genericSu…Type).actualTypeArguments");
                ArrayList arrayList = new ArrayList();
                for (Type type : actualTypeArguments) {
                    if (type instanceof Class) {
                        arrayList.add(type);
                    }
                }
                Object invoke = ((Class) arrayList.get(0)).getDeclaredMethod("inflate", LayoutInflater.class).invoke(null, layoutInflater);
                kotlin.jvm.internal.i.d(invoke, "null cannot be cast to non-null type VDB of com.oplus.foundation.appsupport.databinding.ViewDataBindingExtKt.getViewDataBinding");
                return (ViewDataBinding) invoke;
            }
        });
        this.f28190d = a10;
        b10 = kotlin.a.b(new InterfaceC1637a<AppBarLayout>(this) { // from class: com.oplus.foundation.appsupport.ui.activity.BaseUIActivity$appBarLayout$2
            final /* synthetic */ BaseUIActivity<BD> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final AppBarLayout invoke() {
                return (AppBarLayout) this.this$0.findViewById(m7.e.f35179a);
            }
        });
        this.f28191e = b10;
    }

    @Override // u7.InterfaceC1611a
    public void A0(boolean z10) {
        C1514c.b(this);
    }

    @Override // com.oplus.systembarlib.h
    public boolean B() {
        return this.f28189c.B();
    }

    @Override // r7.InterfaceC1512a
    public String C0() {
        return InterfaceC1512a.C0349a.c(this);
    }

    @Override // r7.InterfaceC1512a
    public TextView E0() {
        return InterfaceC1512a.C0349a.j(this);
    }

    @Override // com.oplus.systembarlib.m
    public void F0(X windowInsets) {
        kotlin.jvm.internal.i.f(windowInsets, "windowInsets");
        Log.i("BaseUIFragment", "onSystemBarChanged statusBarHeight:" + p.i(windowInsets, false, 1, null) + ", navHeight:" + p.g(windowInsets, false, 1, null));
        View K02 = g0().K0();
        kotlin.jvm.internal.i.e(K02, "dataBinding.root");
        r0(K02, windowInsets);
    }

    @Override // r7.InterfaceC1512a
    public int J() {
        return InterfaceC1512a.C0349a.f(this);
    }

    @Override // r7.InterfaceC1512a
    public int J0() {
        return InterfaceC1512a.C0349a.d(this);
    }

    @Override // r7.InterfaceC1512a
    public boolean S() {
        return false;
    }

    @Override // r7.InterfaceC1512a
    public boolean V() {
        return InterfaceC1512a.C0349a.m(this);
    }

    @Override // r7.InterfaceC1512a
    public CollapsingToolbarLayout W0() {
        return InterfaceC1512a.C0349a.a(this);
    }

    @Override // r7.InterfaceC1512a
    public ViewGroup X0() {
        return InterfaceC1512a.C0349a.i(this);
    }

    @Override // r7.InterfaceC1512a
    public int a0() {
        return InterfaceC1512a.C0349a.e(this);
    }

    @Override // r7.InterfaceC1512a
    public AppBarLayout a1() {
        return (AppBarLayout) this.f28191e.getValue();
    }

    @Override // com.oplus.systembarlib.h
    public void b0() {
        this.f28189c.b0();
    }

    @Override // com.oplus.systembarlib.ActivitySystemBarController.b
    public com.oplus.systembarlib.b e() {
        return new a(this);
    }

    public final BD g0() {
        return (BD) this.f28190d.getValue();
    }

    @Override // r7.InterfaceC1512a
    public COUIToolbar getToolbar() {
        return InterfaceC1512a.C0349a.k(this);
    }

    @Override // com.oplus.systembarlib.f
    public void h0(int i10) {
        this.f28189c.h0(i10);
    }

    @Override // r7.InterfaceC1512a
    public boolean i0() {
        return InterfaceC1512a.C0349a.b(this);
    }

    @Override // u7.InterfaceC1611a
    public void j0(boolean z10) {
        InterfaceC1611a.C0368a.a(this, z10);
    }

    public int k0() {
        return InterfaceC1512a.C0349a.l(this);
    }

    public void l0(Context context, InterfaceC1512a appBarConfig) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(appBarConfig, "appBarConfig");
        this.f28188b.b(context, appBarConfig);
    }

    public void m0(AppCompatActivity activity, ActivitySystemBarController.b styleGetter) {
        kotlin.jvm.internal.i.f(activity, "activity");
        kotlin.jvm.internal.i.f(styleGetter, "styleGetter");
        this.f28189c.g(activity, styleGetter);
    }

    @Override // r7.InterfaceC1512a
    public String n() {
        return InterfaceC1512a.C0349a.h(this);
    }

    public void n0(Activity activity, InterfaceC0492o owner) {
        kotlin.jvm.internal.i.f(activity, "activity");
        kotlin.jvm.internal.i.f(owner, "owner");
        this.f28187a.d(activity, owner);
    }

    public void o0(Configuration config) {
        kotlin.jvm.internal.i.f(config, "config");
        this.f28189c.i(config);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        kotlin.jvm.internal.i.f(newConfig, "newConfig");
        o0(newConfig);
        q0(newConfig);
        super.onConfigurationChanged(newConfig);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        C1514c.e(this, k0(), this);
    }

    public void onContentViewInflated(View contentView) {
        kotlin.jvm.internal.i.f(contentView, "contentView");
        this.f28188b.c(contentView);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        A7.a.b(getResources().getBoolean(C1341b.f35173a));
        n0(this, this);
        l0(this, this);
        t0(this);
        m0(this, this);
        s0(this);
        COUIThemeOverlay.getInstance().applyThemeOverlays(this);
        View K02 = g0().K0();
        kotlin.jvm.internal.i.e(K02, "dataBinding.root");
        onContentViewInflated(K02);
        g0().b1(this);
        setContentView(g0().K0());
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        kotlin.jvm.internal.i.f(item, "item");
        if (item.getItemId() == 16908332) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        ResponsiveUIConfig.getDefault(this);
        super.onStart();
    }

    public void q0(Configuration newConfig) {
        kotlin.jvm.internal.i.f(newConfig, "newConfig");
        this.f28187a.h(newConfig);
    }

    public void r0(View contentView, X windowInsets) {
        kotlin.jvm.internal.i.f(contentView, "contentView");
        kotlin.jvm.internal.i.f(windowInsets, "windowInsets");
        this.f28188b.d(contentView, windowInsets);
    }

    public void s0(m listener) {
        kotlin.jvm.internal.i.f(listener, "listener");
        this.f28189c.j(listener);
    }

    public void t0(InterfaceC1611a listener) {
        kotlin.jvm.internal.i.f(listener, "listener");
        this.f28187a.i(listener);
    }

    public void u0(int i10, int i11, int i12, int i13) {
        this.f28189c.k(i10, i11, i12, i13);
    }

    @Override // com.oplus.systembarlib.g
    public void v(boolean z10) {
        this.f28189c.v(z10);
    }

    @Override // r7.InterfaceC1512a
    public boolean w() {
        return InterfaceC1512a.C0349a.g(this);
    }

    @Override // u7.InterfaceC1611a
    public void w0(UIConfig uIConfig, UIConfig uIConfig2) {
        InterfaceC1611a.C0368a.b(this, uIConfig, uIConfig2);
    }

    @Override // r7.InterfaceC1515d
    public void I0(int i10) {
    }
}
