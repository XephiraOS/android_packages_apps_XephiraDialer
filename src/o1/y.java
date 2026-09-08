package O1;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.DefaultFloatingWindowViewModel;
import com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.FloatingWindowCommandViewModel;
import com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.FloatingWindowViewModel;
import com.android.incallui.oplus.widgets.AutoWrapTextView;

/* compiled from: OplusIncallFloatingDefaultViewBinding.java */
/* loaded from: classes.dex */
public abstract class y extends ViewDataBinding {

    /* renamed from: G, reason: collision with root package name */
    public final ImageView f2652G;

    /* renamed from: H, reason: collision with root package name */
    public final TextSwitcher f2653H;

    /* renamed from: I, reason: collision with root package name */
    public final TextSwitcher f2654I;

    /* renamed from: J, reason: collision with root package name */
    public final AutoWrapTextView f2655J;

    /* renamed from: K, reason: collision with root package name */
    public final TextView f2656K;

    /* renamed from: L, reason: collision with root package name */
    public final ImageView f2657L;

    /* renamed from: M, reason: collision with root package name */
    public final ImageView f2658M;

    /* renamed from: N, reason: collision with root package name */
    public final ImageSwitcher f2659N;

    /* renamed from: O, reason: collision with root package name */
    public final ImageView f2660O;

    /* renamed from: P, reason: collision with root package name */
    public final ImageSwitcher f2661P;

    /* renamed from: Q, reason: collision with root package name */
    public final ImageView f2662Q;

    /* renamed from: R, reason: collision with root package name */
    public final TextView f2663R;

    /* renamed from: S, reason: collision with root package name */
    public final TextView f2664S;

    /* renamed from: T, reason: collision with root package name */
    public final FrameLayout f2665T;

    /* renamed from: U, reason: collision with root package name */
    public DefaultFloatingWindowViewModel f2666U;

    /* renamed from: V, reason: collision with root package name */
    public FloatingWindowViewModel f2667V;

    /* renamed from: W, reason: collision with root package name */
    public FloatingWindowCommandViewModel f2668W;

    public y(Object obj, View view, int i10, ImageView imageView, TextSwitcher textSwitcher, TextSwitcher textSwitcher2, AutoWrapTextView autoWrapTextView, TextView textView, ImageView imageView2, ImageView imageView3, ImageSwitcher imageSwitcher, ImageView imageView4, ImageSwitcher imageSwitcher2, ImageView imageView5, TextView textView2, TextView textView3, FrameLayout frameLayout) {
        super(obj, view, i10);
        this.f2652G = imageView;
        this.f2653H = textSwitcher;
        this.f2654I = textSwitcher2;
        this.f2655J = autoWrapTextView;
        this.f2656K = textView;
        this.f2657L = imageView2;
        this.f2658M = imageView3;
        this.f2659N = imageSwitcher;
        this.f2660O = imageView4;
        this.f2661P = imageSwitcher2;
        this.f2662Q = imageView5;
        this.f2663R = textView2;
        this.f2664S = textView3;
        this.f2665T = frameLayout;
    }

    public abstract void i1(DefaultFloatingWindowViewModel defaultFloatingWindowViewModel);
}
