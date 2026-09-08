package com.oplus.blacklistapp.framework.baseui;

import C6.a;
import C6.e;
import C6.g;
import X8.c;
import android.content.Context;
import android.graphics.Insets;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.X;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.theme.COUIThemeOverlay;
import com.oplus.blacklistapp.framework.baseui.BasicActivity;
import com.oplus.blacklistapp.framework.baseui.util.CommonFeatureOption;
import kotlin.jvm.internal.i;

/* compiled from: BasicActivity.kt */
/* loaded from: classes3.dex */
public class BasicActivity extends AppCompatActivity {

    /* renamed from: a, reason: collision with root package name */
    public int f27240a;

    /* renamed from: b, reason: collision with root package name */
    public View f27241b;

    /* renamed from: c, reason: collision with root package name */
    public View f27242c;

    public static final WindowInsets r0(BasicActivity this$0, View view, WindowInsets insets) {
        i.f(this$0, "this$0");
        i.f(view, "<anonymous parameter 0>");
        i.f(insets, "insets");
        Insets insets2 = insets.getInsets(X.k.f());
        i.e(insets2, "insets.getInsets(WindowI…Compat.Type.systemBars())");
        this$0.f27240a = insets2.bottom;
        View view2 = this$0.f27242c;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                int i10 = marginLayoutParams.bottomMargin;
                int i11 = this$0.f27240a;
                if (i10 != i11) {
                    marginLayoutParams.bottomMargin = i11;
                    view2.setLayoutParams(layoutParams);
                }
            }
            View view3 = this$0.f27241b;
            if (view3 != null && view3.getHeight() != this$0.f27240a) {
                ViewGroup.LayoutParams layoutParams2 = view3.getLayoutParams();
                layoutParams2.height = this$0.f27240a;
                view3.setLayoutParams(layoutParams2);
            }
        }
        return insets;
    }

    public final int k0() {
        if (m0()) {
            return COUIContextUtil.getAttrColor(this, c.f4382h);
        }
        return COUIContextUtil.getAttrColor(this, c.f4380g);
    }

    public View l0(Context context) {
        i.f(context, "context");
        int a10 = a.a(context);
        ImageView imageView = new ImageView(context);
        imageView.setBackgroundColor(k0());
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, a10));
        return imageView;
    }

    public boolean m0() {
        return true;
    }

    public boolean n0() {
        return false;
    }

    public boolean o0() {
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g.a(this, k0());
        COUIThemeOverlay.getInstance().applyThemeOverlays(this);
        getWindow().getDecorView().setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: C6.b
            @Override // android.view.View.OnApplyWindowInsetsListener
            public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                WindowInsets r02;
                r02 = BasicActivity.r0(BasicActivity.this, view, windowInsets);
                return r02;
            }
        });
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        s0(n0());
    }

    public boolean q0() {
        return true;
    }

    public void s0(boolean z10) {
        if (!z10) {
            if (C6.c.b()) {
                if (CommonFeatureOption.d()) {
                    v0();
                } else {
                    u0();
                }
            } else {
                v0();
            }
        } else {
            t0();
        }
        g.c(this);
        COUIThemeOverlay.getInstance().applyThemeOverlays(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i10) {
        if (o0()) {
            View l02 = l0(this);
            super.setContentView(l02);
            ViewParent parent = l02.getParent();
            i.d(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup = (ViewGroup) parent;
            View inflate = LayoutInflater.from(this).inflate(i10, viewGroup, false);
            ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = a.a(this);
                if (q0()) {
                    marginLayoutParams.bottomMargin = this.f27240a;
                    this.f27241b = new View(this);
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, this.f27240a);
                    layoutParams2.gravity = 80;
                    viewGroup.addView(this.f27241b, layoutParams2);
                    this.f27242c = inflate;
                }
                viewGroup.addView(inflate, 0, layoutParams);
                return;
            }
            super.setContentView(i10);
            return;
        }
        View inflate2 = LayoutInflater.from(this).inflate(i10, (ViewGroup) null, false);
        super.setContentView(inflate2);
        ViewGroup.LayoutParams layoutParams3 = inflate2.getLayoutParams();
        if (q0() && (layoutParams3 instanceof ViewGroup.MarginLayoutParams)) {
            ViewParent parent2 = inflate2.getParent();
            i.d(parent2, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin = this.f27240a;
            this.f27241b = new View(this);
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, this.f27240a);
            layoutParams4.gravity = 80;
            ((ViewGroup) parent2).addView(this.f27241b, layoutParams4);
            this.f27242c = inflate2;
        }
    }

    public void t0() {
        getWindow().getDecorView().setSystemUiVisibility(1024);
        View view = this.f27241b;
        if (view != null) {
            view.setBackgroundColor(getColor(e.f386a));
        }
    }

    public void u0() {
        getWindow().getDecorView().setSystemUiVisibility(1536);
        getWindow().setNavigationBarContrastEnforced(false);
        View view = this.f27241b;
        if (view != null) {
            view.setBackgroundColor(k0());
        }
    }

    public void v0() {
        getWindow().getDecorView().setSystemUiVisibility(1024);
        View view = this.f27241b;
        if (view != null) {
            view.setBackgroundColor(k0());
        }
    }
}
