package O1;

import android.view.View;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import com.android.incallui.R;
import com.android.incallui.mvvm.command_model.ActionButtonCommandModel;
import com.android.incallui.mvvm.command_model.GlobalCommandModel;
import com.android.incallui.mvvm.view_model.ActionButtonViewModel;
import com.android.incallui.mvvm.view_model.OplusInCallViewModel;
import com.android.incallui.oplus.callbutton.callbuttonview.FunctionButtonLayout;
import com.android.incallui.oplus.widgets.ScaleImageView;

/* compiled from: FragmentActionButtonBinding.java */
/* renamed from: O1.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0401g extends ViewDataBinding {

    /* renamed from: G, reason: collision with root package name */
    public final ImageView f2554G;

    /* renamed from: H, reason: collision with root package name */
    public final FunctionButtonLayout f2555H;

    /* renamed from: I, reason: collision with root package name */
    public final ImageView f2556I;

    /* renamed from: J, reason: collision with root package name */
    public final ImageView f2557J;

    /* renamed from: K, reason: collision with root package name */
    public final ImageView f2558K;

    /* renamed from: L, reason: collision with root package name */
    public final FunctionButtonLayout f2559L;

    /* renamed from: M, reason: collision with root package name */
    public final ImageView f2560M;

    /* renamed from: N, reason: collision with root package name */
    public final ImageView f2561N;

    /* renamed from: O, reason: collision with root package name */
    public final ScaleImageView f2562O;

    /* renamed from: P, reason: collision with root package name */
    public ActionButtonViewModel f2563P;

    /* renamed from: Q, reason: collision with root package name */
    public OplusInCallViewModel f2564Q;

    /* renamed from: R, reason: collision with root package name */
    public ActionButtonCommandModel f2565R;

    /* renamed from: S, reason: collision with root package name */
    public GlobalCommandModel f2566S;

    public AbstractC0401g(Object obj, View view, int i10, ImageView imageView, FunctionButtonLayout functionButtonLayout, ImageView imageView2, ImageView imageView3, ImageView imageView4, FunctionButtonLayout functionButtonLayout2, ImageView imageView5, ImageView imageView6, ScaleImageView scaleImageView) {
        super(obj, view, i10);
        this.f2554G = imageView;
        this.f2555H = functionButtonLayout;
        this.f2556I = imageView2;
        this.f2557J = imageView3;
        this.f2558K = imageView4;
        this.f2559L = functionButtonLayout2;
        this.f2560M = imageView5;
        this.f2561N = imageView6;
        this.f2562O = scaleImageView;
    }

    public static AbstractC0401g i1(View view) {
        return j1(view, androidx.databinding.g.g());
    }

    @Deprecated
    public static AbstractC0401g j1(View view, Object obj) {
        return (AbstractC0401g) ViewDataBinding.y0(obj, view, R.layout.fragment_action_button);
    }

    public abstract void k1(ActionButtonCommandModel actionButtonCommandModel);

    public abstract void l1(GlobalCommandModel globalCommandModel);

    public abstract void m1(OplusInCallViewModel oplusInCallViewModel);

    public abstract void n1(ActionButtonViewModel actionButtonViewModel);
}
