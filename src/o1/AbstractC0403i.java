package O1;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import com.android.incallui.R;
import com.android.incallui.mvvm.view_model.CallCardViewModel;
import com.android.incallui.mvvm.widget.MaxWidthLinearLayout;
import com.android.incallui.mvvm.widget.SuitableSizeTextView;

/* compiled from: IncallCallCardLayoutBinding.java */
/* renamed from: O1.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0403i extends ViewDataBinding {

    /* renamed from: G, reason: collision with root package name */
    public final AbstractC0395a f2571G;

    /* renamed from: H, reason: collision with root package name */
    public final LinearLayout f2572H;

    /* renamed from: I, reason: collision with root package name */
    public final ImageView f2573I;

    /* renamed from: J, reason: collision with root package name */
    public final SuitableSizeTextView f2574J;

    /* renamed from: K, reason: collision with root package name */
    public final ImageView f2575K;

    /* renamed from: L, reason: collision with root package name */
    public final MaxWidthLinearLayout f2576L;

    /* renamed from: M, reason: collision with root package name */
    public final SuitableSizeTextView f2577M;

    /* renamed from: N, reason: collision with root package name */
    public CallCardViewModel f2578N;

    public AbstractC0403i(Object obj, View view, int i10, AbstractC0395a abstractC0395a, LinearLayout linearLayout, ImageView imageView, SuitableSizeTextView suitableSizeTextView, ImageView imageView2, MaxWidthLinearLayout maxWidthLinearLayout, SuitableSizeTextView suitableSizeTextView2) {
        super(obj, view, i10);
        this.f2571G = abstractC0395a;
        this.f2572H = linearLayout;
        this.f2573I = imageView;
        this.f2574J = suitableSizeTextView;
        this.f2575K = imageView2;
        this.f2576L = maxWidthLinearLayout;
        this.f2577M = suitableSizeTextView2;
    }

    public static AbstractC0403i i1(View view) {
        return j1(view, androidx.databinding.g.g());
    }

    @Deprecated
    public static AbstractC0403i j1(View view, Object obj) {
        return (AbstractC0403i) ViewDataBinding.y0(obj, view, R.layout.incall_call_card_layout);
    }

    public abstract void k1(CallCardViewModel callCardViewModel);
}
