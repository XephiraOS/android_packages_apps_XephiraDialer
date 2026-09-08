package R1;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.android.incallui.foldscreen.presentation.viewmodel.FoldScreenCallButtonViewModel;
import com.android.incallui.mvvm.widget.SuitableSizeTextView;
import com.oplus.anim.EffectiveAnimationView;

/* compiled from: FoldScreenVideoAnimLayoutBinding.java */
/* loaded from: classes.dex */
public abstract class e extends ViewDataBinding {

    /* renamed from: G, reason: collision with root package name */
    public final EffectiveAnimationView f3275G;

    /* renamed from: H, reason: collision with root package name */
    public final SuitableSizeTextView f3276H;

    /* renamed from: I, reason: collision with root package name */
    public FoldScreenCallButtonViewModel f3277I;

    public e(Object obj, View view, int i10, EffectiveAnimationView effectiveAnimationView, SuitableSizeTextView suitableSizeTextView) {
        super(obj, view, i10);
        this.f3275G = effectiveAnimationView;
        this.f3276H = suitableSizeTextView;
    }
}
