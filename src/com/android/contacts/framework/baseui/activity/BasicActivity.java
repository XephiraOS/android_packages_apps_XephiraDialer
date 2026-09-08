package com.android.contacts.framework.baseui.activity;

import C9.j;
import H7.b;
import N0.d;
import N0.e;
import N0.g;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Insets;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.X;
import com.android.contacts.framework.baseui.activity.BasicActivity;
import com.android.contacts.framework.baseui.util.B;
import com.android.contacts.framework.baseui.util.l;
import com.android.contacts.framework.baseui.util.n;
import com.android.contacts.framework.baseui.util.o;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.theme.COUIThemeOverlay;
import com.coui.responsiveui.config.ResponsiveUIConfig;
import com.coui.responsiveui.config.UIConfig;
import com.oplus.foundation.util.OsUtils;
import com.oplus.foundation.util.display.DisplayUtil;
import com.oplus.foundation.util.feature.CommonFeatureOption;
import kotlin.Result;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.k;
import y9.c;

/* compiled from: BasicActivity.kt */
/* loaded from: classes.dex */
public class BasicActivity extends AppCompatActivity {

    /* renamed from: a, reason: collision with root package name */
    public CoordinatorLayout f15662a;

    /* renamed from: b, reason: collision with root package name */
    public final c f15663b;

    /* renamed from: c, reason: collision with root package name */
    public final c f15664c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f15665d;

    /* renamed from: e, reason: collision with root package name */
    public int f15666e;

    /* renamed from: f, reason: collision with root package name */
    public int f15667f;

    /* renamed from: g, reason: collision with root package name */
    public Dialog f15668g;

    /* renamed from: h, reason: collision with root package name */
    public String f15669h;

    /* renamed from: i, reason: collision with root package name */
    public TextView f15670i;

    /* renamed from: j, reason: collision with root package name */
    public int f15671j;

    /* renamed from: k, reason: collision with root package name */
    public View f15672k;

    /* renamed from: l, reason: collision with root package name */
    public View f15673l;

    /* renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ j<Object>[] f15661n = {k.d(new MutablePropertyReference1Impl(BasicActivity.class, "listDefaultPaddingBottom", "getListDefaultPaddingBottom()I", 0)), k.d(new MutablePropertyReference1Impl(BasicActivity.class, "listEditModePaddingBottom", "getListEditModePaddingBottom()I", 0))};

    /* renamed from: m, reason: collision with root package name */
    public static final a f15660m = new a(null);

    /* compiled from: BasicActivity.kt */
    /* loaded from: classes.dex */
    public static abstract class DialogFragmentListener implements Parcelable {
        public abstract Dialog b(int i10, Bundle bundle);

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int i10) {
            i.f(dest, "dest");
            if (H7.a.b()) {
                b.b("BasicActivity", "dest =" + dest + ", flags = " + i10);
            }
        }
    }

    /* compiled from: BasicActivity.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public BasicActivity() {
        y9.a aVar = y9.a.f38157a;
        this.f15663b = aVar.a();
        this.f15664c = aVar.a();
    }

    public static final WindowInsets U0(BasicActivity this$0, View view, WindowInsets insets) {
        i.f(this$0, "this$0");
        i.f(view, "<anonymous parameter 0>");
        i.f(insets, "insets");
        Insets insets2 = insets.getInsets(X.k.f());
        i.e(insets2, "insets.getInsets(WindowI…Compat.Type.systemBars())");
        this$0.f15671j = insets2.bottom;
        if (H7.a.b()) {
            b.b("BasicActivity", "onApplyWindowInsets navigationBarHeight = " + this$0.f15671j);
        }
        this$0.O0(this$0.f15671j);
        return insets;
    }

    public boolean D0() {
        return false;
    }

    public boolean H0() {
        return false;
    }

    public boolean K0() {
        return false;
    }

    public final boolean L0() {
        return this.f15665d;
    }

    public boolean M0() {
        return false;
    }

    public final String N0() {
        try {
            Result.a aVar = Result.f34166a;
            Uri n10 = androidx.core.app.a.n(this);
            if (n10 == null) {
                return null;
            }
            return n10.getAuthority();
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            Throwable d10 = Result.d(Result.b(kotlin.b.a(th)));
            if (d10 == null) {
                return null;
            }
            StackTraceElement stackTraceElement = d10.getStackTrace()[0];
            int lineNumber = stackTraceElement.getLineNumber();
            String methodName = stackTraceElement.getMethodName();
            b.c(stackTraceElement.getClassName(), "line:" + lineNumber + " " + methodName + " " + d10.getMessage());
            return null;
        }
    }

    public void O0(int i10) {
        View view;
        if (T0() && (view = this.f15672k) != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (view.getHeight() != i10 || layoutParams.height != i10) {
                layoutParams.height = i10;
                view.setLayoutParams(layoutParams);
            }
            View view2 = this.f15673l;
            if (view2 != null) {
                ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                    if (view.getVisibility() == 0) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
                        if (marginLayoutParams.bottomMargin != i10) {
                            marginLayoutParams.bottomMargin = i10;
                            view2.setLayoutParams(layoutParams2);
                            return;
                        }
                    }
                    if (view.getVisibility() == 8) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                        if (marginLayoutParams2.bottomMargin != 0) {
                            marginLayoutParams2.bottomMargin = 0;
                            view2.setLayoutParams(layoutParams2);
                        }
                    }
                }
            }
        }
    }

    public boolean Q0() {
        return true;
    }

    public boolean R0() {
        return true;
    }

    public boolean T0() {
        return OsUtils.f28280f;
    }

    public void Y0() {
        if (this.f15668g == null) {
            this.f15668g = l.a(this);
        }
    }

    public final void b1(CoordinatorLayout coordinatorLayout) {
        this.f15662a = coordinatorLayout;
    }

    public void c1(int i10) {
        this.f15663b.b(this, f15661n[0], Integer.valueOf(i10));
    }

    public void d1(int i10) {
        this.f15664c.b(this, f15661n[1], Integer.valueOf(i10));
    }

    public void e1(ListView listView, boolean z10) {
        int n02;
        if (listView != null) {
            int paddingTop = listView.getPaddingTop();
            if (z10) {
                n02 = o0();
            } else {
                n02 = n0();
            }
            listView.setPadding(0, paddingTop, 0, n02);
        }
    }

    public void f1(Activity activity, boolean z10, boolean z11) {
        i.f(activity, "activity");
        if (z10 && !z11) {
            if (n.b()) {
                if (CommonFeatureOption.h()) {
                    j1();
                } else {
                    i1();
                }
            } else {
                l1(activity, z11);
            }
        } else {
            l1(activity, z11);
        }
        B.c(this, getWindow(), 1);
        COUIThemeOverlay.getInstance().applyThemeOverlays(this);
    }

    public void g1(FrameLayout frameLayout) {
        if (frameLayout != null && frameLayout.getVisibility() == 0) {
            h1();
        } else if (frameLayout != null && frameLayout.getVisibility() == 8) {
            if (n.b()) {
                if (CommonFeatureOption.h()) {
                    j1();
                } else {
                    i1();
                }
            } else {
                j1();
            }
        }
        B.c(this, getWindow(), 1);
        COUIThemeOverlay.getInstance().applyThemeOverlays(this);
    }

    public void h1() {
        getWindow().getDecorView().setSystemUiVisibility(1024);
        if (T0()) {
            View view = this.f15672k;
            if (view != null && view.getVisibility() == 8) {
                View view2 = this.f15672k;
                if (view2 != null) {
                    view2.setVisibility(0);
                }
                O0(this.f15671j);
            }
            if (A7.a.a()) {
                View view3 = this.f15672k;
                if (view3 != null) {
                    view3.setBackgroundColor(getColor(e.f1860i));
                    return;
                }
                return;
            }
            View view4 = this.f15672k;
            if (view4 != null) {
                view4.setBackgroundColor(COUIContextUtil.getAttrColor(this, N0.c.f1842c));
                return;
            }
            return;
        }
        if (A7.a.a()) {
            getWindow().setNavigationBarColor(getColor(e.f1860i));
        } else {
            getWindow().setNavigationBarColor(COUIContextUtil.getAttrColor(this, N0.c.f1842c));
        }
    }

    public void i1() {
        getWindow().getDecorView().setSystemUiVisibility(1536);
        getWindow().setNavigationBarContrastEnforced(false);
        if (T0()) {
            View view = this.f15672k;
            if (view == null || view.getVisibility() != 8) {
                View view2 = this.f15672k;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
                O0(this.f15671j);
                return;
            }
            return;
        }
        getWindow().setNavigationBarColor(0);
    }

    public void j1() {
        getWindow().getDecorView().setSystemUiVisibility(1024);
        if (T0()) {
            View view = this.f15672k;
            if (view != null && view.getVisibility() == 8) {
                View view2 = this.f15672k;
                if (view2 != null) {
                    view2.setVisibility(0);
                }
                O0(this.f15671j);
            }
            View view3 = this.f15672k;
            if (view3 != null) {
                view3.setBackgroundColor(q0());
                return;
            }
            return;
        }
        getWindow().setNavigationBarColor(q0());
    }

    public boolean k0() {
        return true;
    }

    public final void k1(boolean z10) {
        int n02;
        TextView textView = this.f15670i;
        if (textView != null) {
            if (z10) {
                n02 = o0();
            } else {
                n02 = n0();
            }
            textView.setHeight(n02);
        }
    }

    public void l0() {
        UIConfig.Status status;
        int i10;
        UIConfig value = ResponsiveUIConfig.getDefault(this).getUiConfig().getValue();
        if (value != null) {
            status = value.getStatus();
        } else {
            status = null;
        }
        if (status == UIConfig.Status.UNFOLD) {
            i10 = 2;
        } else {
            i10 = 5;
        }
        setRequestedOrientation(i10);
    }

    public void l1(Activity activity, boolean z10) {
        i.f(activity, "activity");
        if (o1()) {
            if (z10) {
                h1();
                return;
            } else {
                j1();
                return;
            }
        }
        h1();
    }

    public final CoordinatorLayout m0() {
        return this.f15662a;
    }

    public void m1(FrameLayout frameLayout, boolean z10) {
        if (z10) {
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
        } else if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
    }

    public int n0() {
        return ((Number) this.f15663b.a(this, f15661n[0])).intValue();
    }

    public int o0() {
        return ((Number) this.f15664c.a(this, f15661n[1])).intValue();
    }

    public boolean o1() {
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        UIConfig.Status status;
        int i10;
        i.f(newConfig, "newConfig");
        ResponsiveUIConfig.getDefault(this).onActivityConfigChanged(newConfig);
        super.onConfigurationChanged(newConfig);
        if (!D0() && !isInMultiWindowMode()) {
            UIConfig value = ResponsiveUIConfig.getDefault(this).getUiConfig().getValue();
            if (value != null) {
                status = value.getStatus();
            } else {
                status = null;
            }
            if (status == UIConfig.Status.UNFOLD) {
                i10 = 2;
            } else {
                i10 = 5;
            }
            setRequestedOrientation(i10);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (R0() && com.android.contacts.framework.api.setdefault.a.b(this)) {
            b.e("BasicActivity", "needStartSetDefault return !!! ");
            return;
        }
        DisplayUtil.v(this);
        this.f15665d = o.e(this);
        this.f15666e = DisplayUtil.g(this);
        this.f15667f = getResources().getDimensionPixelSize(N0.f.f1894t);
        A7.a.b(getResources().getBoolean(d.f1850a));
        Z0.e.l();
        this.f15669h = N0();
        if (M0()) {
            B.d(this, getWindow(), 2, this.f15665d);
            COUIThemeOverlay.getInstance().applyThemeOverlays(this);
        } else {
            B.d(this, getWindow(), 1, this.f15665d);
            COUIThemeOverlay.getInstance().applyThemeOverlays(this);
        }
        l0();
        if (OsUtils.f28280f) {
            getWindow().getDecorView().setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: O0.c
                @Override // android.view.View.OnApplyWindowInsetsListener
                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    WindowInsets U02;
                    U02 = BasicActivity.U0(BasicActivity.this, view, windowInsets);
                    return U02;
                }
            });
        }
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i10, Bundle bundle) {
        DialogFragmentListener dialogFragmentListener;
        if (bundle != null && (dialogFragmentListener = (DialogFragmentListener) bundle.getParcelable("dialog_fragment")) != null) {
            return dialogFragmentListener.b(i10, bundle);
        }
        return onCreateDialog(i10);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Dialog dialog = this.f15668g;
        if (dialog != null) {
            dialog.dismiss();
        }
        this.f15668g = null;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.f15669h = N0();
        if (com.android.contacts.framework.api.setdefault.a.b(this)) {
            C7.e.b(this);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (o1()) {
            f1(this, n.b(), K0());
        } else {
            f1(this, false, K0());
        }
        if (k0() && l.e(this)) {
            Y0();
        }
    }

    @Override // android.app.Activity
    public void onTopResumedActivityChanged(boolean z10) {
        super.onTopResumedActivityChanged(z10);
        if (z10 && R0()) {
            com.android.contacts.framework.api.setdefault.a.f15616a.a(this);
        }
    }

    public final int q0() {
        if (H0()) {
            if (A7.a.a()) {
                return getColor(e.f1857f);
            }
            return COUIContextUtil.getAttrColor(this, N0.c.f1841b);
        }
        return getColor(e.f1857f);
    }

    public final String r0() {
        return this.f15669h;
    }

    public final int s0() {
        return this.f15666e;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i10) {
        if (Q0()) {
            View b10 = B.b(this, H0());
            super.setContentView(b10);
            ViewParent parent = b10.getParent();
            i.d(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup = (ViewGroup) parent;
            View inflate = LayoutInflater.from(this).inflate(i10, viewGroup, false);
            ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = DisplayUtil.g(this);
                if (T0()) {
                    marginLayoutParams.bottomMargin = this.f15671j;
                    this.f15672k = new View(this);
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, this.f15671j);
                    layoutParams2.gravity = 80;
                    viewGroup.addView(this.f15672k, layoutParams2);
                    this.f15673l = inflate;
                }
                viewGroup.addView(inflate, 0, layoutParams);
            } else {
                super.setContentView(i10);
            }
        } else {
            View inflate2 = LayoutInflater.from(this).inflate(i10, (ViewGroup) null, false);
            super.setContentView(inflate2);
            ViewGroup.LayoutParams layoutParams3 = inflate2.getLayoutParams();
            if (T0() && (layoutParams3 instanceof ViewGroup.MarginLayoutParams)) {
                ViewParent parent2 = inflate2.getParent();
                i.d(parent2, "null cannot be cast to non-null type android.view.ViewGroup");
                ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin = this.f15671j;
                this.f15672k = new View(this);
                FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, this.f15671j);
                layoutParams4.gravity = 80;
                ((ViewGroup) parent2).addView(this.f15672k, layoutParams4);
                this.f15673l = inflate2;
            }
        }
        u0();
        B0();
        z0();
        y0();
        x0();
    }

    public final int t0() {
        return this.f15667f;
    }

    public void u0() {
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) findViewById(N0.i.f1934l);
        this.f15662a = coordinatorLayout;
        if (coordinatorLayout != null) {
            if (H0()) {
                coordinatorLayout.setStatusBarBackgroundResource(g.f1910j);
            } else {
                coordinatorLayout.setStatusBarBackgroundResource(g.f1902b);
            }
        }
    }

    public final void v0(ListView listView) {
        TextView textView = new TextView(this);
        this.f15670i = textView;
        textView.setHeight(n0());
        TextView textView2 = this.f15670i;
        if (textView2 != null) {
            textView2.setImportantForAccessibility(2);
        }
        if (listView != null) {
            listView.addFooterView(this.f15670i);
        }
    }

    public final void x0() {
        c1(getResources().getDimensionPixelSize(N0.f.f1880f));
        d1(getResources().getDimensionPixelSize(N0.f.f1875a));
    }

    public void z0() {
        View findViewById;
        if (A7.a.a() && (findViewById = findViewById(N0.i.f1936n)) != null) {
            findViewById.setVisibility(8);
        }
    }

    public void B0() {
    }

    public void n1() {
    }

    public void y0() {
    }
}
