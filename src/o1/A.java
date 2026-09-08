package O1;

import android.view.View;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.android.incallui.oplus.incomingfloatingwindow.presentation.view.FloatingWindowConstraintLayout;
import com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.DriveModeFloatingWindowViewModel;
import com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.FloatingWindowCommandViewModel;
import com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.FloatingWindowViewModel;
import com.android.incallui.oplus.widgets.AutoWrapTextView;

/* compiled from: OplusIncallFloatingDriverModeViewBinding.java */
/* loaded from: classes.dex */
public abstract class A extends ViewDataBinding {

    /* renamed from: G, reason: collision with root package name */
    public final TextSwitcher f2434G;

    /* renamed from: H, reason: collision with root package name */
    public final TextView f2435H;

    /* renamed from: I, reason: collision with root package name */
    public final AutoWrapTextView f2436I;

    /* renamed from: J, reason: collision with root package name */
    public final TextView f2437J;

    /* renamed from: K, reason: collision with root package name */
    public final ImageView f2438K;

    /* renamed from: L, reason: collision with root package name */
    public final ImageView f2439L;

    /* renamed from: M, reason: collision with root package name */
    public final ImageSwitcher f2440M;

    /* renamed from: N, reason: collision with root package name */
    public final ImageView f2441N;

    /* renamed from: O, reason: collision with root package name */
    public final LinearLayout f2442O;

    /* renamed from: P, reason: collision with root package name */
    public final FloatingWindowConstraintLayout f2443P;

    /* renamed from: Q, reason: collision with root package name */
    public final ImageView f2444Q;

    /* renamed from: R, reason: collision with root package name */
    public final ImageSwitcher f2445R;

    /* renamed from: S, reason: collision with root package name */
    public final ImageView f2446S;

    /* renamed from: T, reason: collision with root package name */
    public final LinearLayout f2447T;

    /* renamed from: U, reason: collision with root package name */
    public final TextView f2448U;

    /* renamed from: V, reason: collision with root package name */
    public DriveModeFloatingWindowViewModel f2449V;

    /* renamed from: W, reason: collision with root package name */
    public FloatingWindowViewModel f2450W;

    /* renamed from: X, reason: collision with root package name */
    public FloatingWindowCommandViewModel f2451X;

    public A(Object obj, View view, int i10, TextSwitcher textSwitcher, TextView textView, AutoWrapTextView autoWrapTextView, TextView textView2, ImageView imageView, ImageView imageView2, ImageSwitcher imageSwitcher, ImageView imageView3, LinearLayout linearLayout, FloatingWindowConstraintLayout floatingWindowConstraintLayout, ImageView imageView4, ImageSwitcher imageSwitcher2, ImageView imageView5, LinearLayout linearLayout2, TextView textView3) {
        super(obj, view, i10);
        this.f2434G = textSwitcher;
        this.f2435H = textView;
        this.f2436I = autoWrapTextView;
        this.f2437J = textView2;
        this.f2438K = imageView;
        this.f2439L = imageView2;
        this.f2440M = imageSwitcher;
        this.f2441N = imageView3;
        this.f2442O = linearLayout;
        this.f2443P = floatingWindowConstraintLayout;
        this.f2444Q = imageView4;
        this.f2445R = imageSwitcher2;
        this.f2446S = imageView5;
        this.f2447T = linearLayout2;
        this.f2448U = textView3;
    }

    public abstract void i1(DriveModeFloatingWindowViewModel driveModeFloatingWindowViewModel);
}
