package O1;

import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import com.android.incallui.R;
import com.android.incallui.oplus.answerview.view.AnswerMethodDialogButton;
import com.android.incallui.oplus.answerview.view.FlingUpAnswerMethodLayout;
import com.android.incallui.oplus.answerview.view.GuideAnimatorView;
import com.android.incallui.oplus.answerview.view.SwipeAnswerImageView;
import com.android.incallui.oplus.answerview.view_model.FlingUpAnswerMethodModel;

/* compiled from: IncallFlingUpAnswerMethodBinding.java */
/* loaded from: classes.dex */
public abstract class k extends ViewDataBinding {

    /* renamed from: G, reason: collision with root package name */
    public final FlingUpAnswerMethodLayout f2582G;

    /* renamed from: H, reason: collision with root package name */
    public final SwipeAnswerImageView f2583H;

    /* renamed from: I, reason: collision with root package name */
    public final GuideAnimatorView f2584I;

    /* renamed from: J, reason: collision with root package name */
    public final AnswerMethodDialogButton f2585J;

    /* renamed from: K, reason: collision with root package name */
    public final LinearLayout f2586K;

    /* renamed from: L, reason: collision with root package name */
    public final LinearLayout f2587L;

    /* renamed from: M, reason: collision with root package name */
    public final SwipeAnswerImageView f2588M;

    /* renamed from: N, reason: collision with root package name */
    public final GuideAnimatorView f2589N;

    /* renamed from: O, reason: collision with root package name */
    public final LinearLayout f2590O;

    /* renamed from: P, reason: collision with root package name */
    public final SwipeAnswerImageView f2591P;

    /* renamed from: Q, reason: collision with root package name */
    public final GuideAnimatorView f2592Q;

    /* renamed from: R, reason: collision with root package name */
    public FlingUpAnswerMethodModel f2593R;

    public k(Object obj, View view, int i10, FlingUpAnswerMethodLayout flingUpAnswerMethodLayout, SwipeAnswerImageView swipeAnswerImageView, GuideAnimatorView guideAnimatorView, AnswerMethodDialogButton answerMethodDialogButton, LinearLayout linearLayout, LinearLayout linearLayout2, SwipeAnswerImageView swipeAnswerImageView2, GuideAnimatorView guideAnimatorView2, LinearLayout linearLayout3, SwipeAnswerImageView swipeAnswerImageView3, GuideAnimatorView guideAnimatorView3) {
        super(obj, view, i10);
        this.f2582G = flingUpAnswerMethodLayout;
        this.f2583H = swipeAnswerImageView;
        this.f2584I = guideAnimatorView;
        this.f2585J = answerMethodDialogButton;
        this.f2586K = linearLayout;
        this.f2587L = linearLayout2;
        this.f2588M = swipeAnswerImageView2;
        this.f2589N = guideAnimatorView2;
        this.f2590O = linearLayout3;
        this.f2591P = swipeAnswerImageView3;
        this.f2592Q = guideAnimatorView3;
    }

    public static k i1(View view) {
        return j1(view, androidx.databinding.g.g());
    }

    @Deprecated
    public static k j1(View view, Object obj) {
        return (k) ViewDataBinding.y0(obj, view, R.layout.incall_fling_up_answer_method);
    }

    public abstract void k1(FlingUpAnswerMethodModel flingUpAnswerMethodModel);
}
