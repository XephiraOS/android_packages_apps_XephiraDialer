package O1;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.android.incallui.R;
import com.android.incallui.oplus.answerview.view.GuideAnimatorView;
import com.android.incallui.oplus.answerview.view.RideModeAnswerMethodLayout;
import com.android.incallui.oplus.answerview.view.SwipeAnswerImageView;
import com.android.incallui.oplus.answerview.view_model.RideModeAnswerMethodModel;

/* compiled from: IncallRideModeAnswerMethodBinding.java */
/* loaded from: classes.dex */
public abstract class m extends ViewDataBinding {

    /* renamed from: G, reason: collision with root package name */
    public final GuideAnimatorView f2597G;

    /* renamed from: H, reason: collision with root package name */
    public final GuideAnimatorView f2598H;

    /* renamed from: I, reason: collision with root package name */
    public final TextView f2599I;

    /* renamed from: J, reason: collision with root package name */
    public final SwipeAnswerImageView f2600J;

    /* renamed from: K, reason: collision with root package name */
    public final TextView f2601K;

    /* renamed from: L, reason: collision with root package name */
    public final SwipeAnswerImageView f2602L;

    /* renamed from: M, reason: collision with root package name */
    public final RideModeAnswerMethodLayout f2603M;

    /* renamed from: N, reason: collision with root package name */
    public final ImageView f2604N;

    /* renamed from: O, reason: collision with root package name */
    public RideModeAnswerMethodModel f2605O;

    public m(Object obj, View view, int i10, GuideAnimatorView guideAnimatorView, GuideAnimatorView guideAnimatorView2, TextView textView, SwipeAnswerImageView swipeAnswerImageView, TextView textView2, SwipeAnswerImageView swipeAnswerImageView2, RideModeAnswerMethodLayout rideModeAnswerMethodLayout, ImageView imageView) {
        super(obj, view, i10);
        this.f2597G = guideAnimatorView;
        this.f2598H = guideAnimatorView2;
        this.f2599I = textView;
        this.f2600J = swipeAnswerImageView;
        this.f2601K = textView2;
        this.f2602L = swipeAnswerImageView2;
        this.f2603M = rideModeAnswerMethodLayout;
        this.f2604N = imageView;
    }

    public static m i1(View view) {
        return j1(view, androidx.databinding.g.g());
    }

    @Deprecated
    public static m j1(View view, Object obj) {
        return (m) ViewDataBinding.y0(obj, view, R.layout.incall_ride_mode_answer_method);
    }

    public abstract void k1(RideModeAnswerMethodModel rideModeAnswerMethodModel);
}
