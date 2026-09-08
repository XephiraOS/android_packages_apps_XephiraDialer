package R1;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.o;
import com.android.incallui.clean.presentation.view.InCallMarqueeTextView;
import com.android.incallui.foldscreen.presentation.viewmodel.FoldScreenCallCardViewModel;

/* compiled from: FragmentFoldScreenCallCardBinding.java */
/* loaded from: classes.dex */
public abstract class i extends ViewDataBinding {

    /* renamed from: G, reason: collision with root package name */
    public final InCallMarqueeTextView f3291G;

    /* renamed from: H, reason: collision with root package name */
    public final ImageView f3292H;

    /* renamed from: I, reason: collision with root package name */
    public final InCallMarqueeTextView f3293I;

    /* renamed from: J, reason: collision with root package name */
    public final InCallMarqueeTextView f3294J;

    /* renamed from: K, reason: collision with root package name */
    public final ImageView f3295K;

    /* renamed from: L, reason: collision with root package name */
    public final LinearLayout f3296L;

    /* renamed from: M, reason: collision with root package name */
    public final o f3297M;

    /* renamed from: N, reason: collision with root package name */
    public FoldScreenCallCardViewModel f3298N;

    public i(Object obj, View view, int i10, InCallMarqueeTextView inCallMarqueeTextView, ImageView imageView, InCallMarqueeTextView inCallMarqueeTextView2, InCallMarqueeTextView inCallMarqueeTextView3, ImageView imageView2, LinearLayout linearLayout, o oVar) {
        super(obj, view, i10);
        this.f3291G = inCallMarqueeTextView;
        this.f3292H = imageView;
        this.f3293I = inCallMarqueeTextView2;
        this.f3294J = inCallMarqueeTextView3;
        this.f3295K = imageView2;
        this.f3296L = linearLayout;
        this.f3297M = oVar;
    }

    public static i i1(View view) {
        return j1(view, androidx.databinding.g.g());
    }

    @Deprecated
    public static i j1(View view, Object obj) {
        return (i) ViewDataBinding.y0(obj, view, P1.e.f2871h);
    }

    public abstract void k1(FoldScreenCallCardViewModel foldScreenCallCardViewModel);
}
