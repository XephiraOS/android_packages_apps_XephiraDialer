package O1;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.android.incallui.R;
import com.android.incallui.mvvm.view_model.BackgroundViewModel;
import com.android.incallui.mvvm.view_model.OplusInCallViewModel;

/* compiled from: OplusIncallScreenBinding.java */
/* loaded from: classes.dex */
public abstract class I extends ViewDataBinding {

    /* renamed from: G, reason: collision with root package name */
    public final ConstraintLayout f2514G;

    /* renamed from: H, reason: collision with root package name */
    public final FrameLayout f2515H;

    /* renamed from: I, reason: collision with root package name */
    public final ImageView f2516I;

    /* renamed from: J, reason: collision with root package name */
    public final FrameLayout f2517J;

    /* renamed from: K, reason: collision with root package name */
    public final FrameLayout f2518K;

    /* renamed from: L, reason: collision with root package name */
    public final FrameLayout f2519L;

    /* renamed from: M, reason: collision with root package name */
    public final FrameLayout f2520M;

    /* renamed from: N, reason: collision with root package name */
    public OplusInCallViewModel f2521N;

    /* renamed from: O, reason: collision with root package name */
    public BackgroundViewModel f2522O;

    public I(Object obj, View view, int i10, ConstraintLayout constraintLayout, FrameLayout frameLayout, ImageView imageView, FrameLayout frameLayout2, FrameLayout frameLayout3, FrameLayout frameLayout4, FrameLayout frameLayout5) {
        super(obj, view, i10);
        this.f2514G = constraintLayout;
        this.f2515H = frameLayout;
        this.f2516I = imageView;
        this.f2517J = frameLayout2;
        this.f2518K = frameLayout3;
        this.f2519L = frameLayout4;
        this.f2520M = frameLayout5;
    }

    public static I i1(View view) {
        return j1(view, androidx.databinding.g.g());
    }

    @Deprecated
    public static I j1(View view, Object obj) {
        return (I) ViewDataBinding.y0(obj, view, R.layout.oplus_incall_screen);
    }

    public abstract void k1(BackgroundViewModel backgroundViewModel);

    public abstract void l1(OplusInCallViewModel oplusInCallViewModel);
}
