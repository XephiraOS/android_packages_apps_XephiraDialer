package O1;

import android.view.View;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.FloatingWindowCommandViewModel;
import com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.FloatingWindowViewModel;
import com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.NaviLandscapeFloatingWindowViewModel;
import com.android.incallui.oplus.widgets.AutoWrapTextView;

/* compiled from: OplusIncallFloatingNaviLandscapeViewBinding.java */
/* loaded from: classes.dex */
public abstract class C extends ViewDataBinding {

    /* renamed from: G, reason: collision with root package name */
    public final TextSwitcher f2457G;

    /* renamed from: H, reason: collision with root package name */
    public final TextSwitcher f2458H;

    /* renamed from: I, reason: collision with root package name */
    public final AutoWrapTextView f2459I;

    /* renamed from: J, reason: collision with root package name */
    public final TextView f2460J;

    /* renamed from: K, reason: collision with root package name */
    public final ImageView f2461K;

    /* renamed from: L, reason: collision with root package name */
    public final ImageView f2462L;

    /* renamed from: M, reason: collision with root package name */
    public final ImageSwitcher f2463M;

    /* renamed from: N, reason: collision with root package name */
    public final ImageView f2464N;

    /* renamed from: O, reason: collision with root package name */
    public final LinearLayout f2465O;

    /* renamed from: P, reason: collision with root package name */
    public final TextView f2466P;

    /* renamed from: Q, reason: collision with root package name */
    public final TextView f2467Q;

    /* renamed from: R, reason: collision with root package name */
    public final ImageView f2468R;

    /* renamed from: S, reason: collision with root package name */
    public final ImageSwitcher f2469S;

    /* renamed from: T, reason: collision with root package name */
    public final ImageView f2470T;

    /* renamed from: U, reason: collision with root package name */
    public final LinearLayout f2471U;

    /* renamed from: V, reason: collision with root package name */
    public final TextView f2472V;

    /* renamed from: W, reason: collision with root package name */
    public NaviLandscapeFloatingWindowViewModel f2473W;

    /* renamed from: X, reason: collision with root package name */
    public FloatingWindowViewModel f2474X;

    /* renamed from: Y, reason: collision with root package name */
    public FloatingWindowCommandViewModel f2475Y;

    public C(Object obj, View view, int i10, TextSwitcher textSwitcher, TextSwitcher textSwitcher2, AutoWrapTextView autoWrapTextView, TextView textView, ImageView imageView, ImageView imageView2, ImageSwitcher imageSwitcher, ImageView imageView3, LinearLayout linearLayout, TextView textView2, TextView textView3, ImageView imageView4, ImageSwitcher imageSwitcher2, ImageView imageView5, LinearLayout linearLayout2, TextView textView4) {
        super(obj, view, i10);
        this.f2457G = textSwitcher;
        this.f2458H = textSwitcher2;
        this.f2459I = autoWrapTextView;
        this.f2460J = textView;
        this.f2461K = imageView;
        this.f2462L = imageView2;
        this.f2463M = imageSwitcher;
        this.f2464N = imageView3;
        this.f2465O = linearLayout;
        this.f2466P = textView2;
        this.f2467Q = textView3;
        this.f2468R = imageView4;
        this.f2469S = imageSwitcher2;
        this.f2470T = imageView5;
        this.f2471U = linearLayout2;
        this.f2472V = textView4;
    }

    public abstract void i1(NaviLandscapeFloatingWindowViewModel naviLandscapeFloatingWindowViewModel);
}
