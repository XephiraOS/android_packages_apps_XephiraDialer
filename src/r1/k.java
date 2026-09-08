package R1;

import android.view.View;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import com.android.incallui.clean.presentation.view.InCallMarqueeTextView;
import com.android.incallui.foldscreen.presentation.viewmodel.FoldScreenCallCardViewModel;

/* compiled from: FragmentFoldScreenCallCardSecondaryBinding.java */
/* loaded from: classes.dex */
public abstract class k extends ViewDataBinding {

    /* renamed from: G, reason: collision with root package name */
    public final InCallMarqueeTextView f3303G;

    /* renamed from: H, reason: collision with root package name */
    public final ImageView f3304H;

    /* renamed from: I, reason: collision with root package name */
    public final View f3305I;

    /* renamed from: J, reason: collision with root package name */
    public FoldScreenCallCardViewModel f3306J;

    public k(Object obj, View view, int i10, InCallMarqueeTextView inCallMarqueeTextView, ImageView imageView, View view2) {
        super(obj, view, i10);
        this.f3303G = inCallMarqueeTextView;
        this.f3304H = imageView;
        this.f3305I = view2;
    }
}
