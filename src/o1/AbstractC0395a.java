package O1;

import android.view.View;
import androidx.constraintlayout.widget.Barrier;
import androidx.databinding.ViewDataBinding;
import com.android.incallui.mvvm.view_model.CallCardViewModel;
import com.android.incallui.oplus.widgets.AdaptiveTextSizeTextView;
import com.android.incallui.oplus.widgets.LineFeedTextView;
import com.coui.appcompat.imageview.COUIRoundImageView;

/* compiled from: CallCardInfoBinding.java */
/* renamed from: O1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0395a extends ViewDataBinding {

    /* renamed from: G, reason: collision with root package name */
    public final Barrier f2526G;

    /* renamed from: H, reason: collision with root package name */
    public final androidx.databinding.o f2527H;

    /* renamed from: I, reason: collision with root package name */
    public final androidx.databinding.o f2528I;

    /* renamed from: J, reason: collision with root package name */
    public final androidx.databinding.o f2529J;

    /* renamed from: K, reason: collision with root package name */
    public final COUIRoundImageView f2530K;

    /* renamed from: L, reason: collision with root package name */
    public final LineFeedTextView f2531L;

    /* renamed from: M, reason: collision with root package name */
    public final AdaptiveTextSizeTextView f2532M;

    /* renamed from: N, reason: collision with root package name */
    public final AdaptiveTextSizeTextView f2533N;

    /* renamed from: O, reason: collision with root package name */
    public final androidx.databinding.o f2534O;

    /* renamed from: P, reason: collision with root package name */
    public CallCardViewModel f2535P;

    public AbstractC0395a(Object obj, View view, int i10, Barrier barrier, androidx.databinding.o oVar, androidx.databinding.o oVar2, androidx.databinding.o oVar3, COUIRoundImageView cOUIRoundImageView, LineFeedTextView lineFeedTextView, AdaptiveTextSizeTextView adaptiveTextSizeTextView, AdaptiveTextSizeTextView adaptiveTextSizeTextView2, androidx.databinding.o oVar4) {
        super(obj, view, i10);
        this.f2526G = barrier;
        this.f2527H = oVar;
        this.f2528I = oVar2;
        this.f2529J = oVar3;
        this.f2530K = cOUIRoundImageView;
        this.f2531L = lineFeedTextView;
        this.f2532M = adaptiveTextSizeTextView;
        this.f2533N = adaptiveTextSizeTextView2;
        this.f2534O = oVar4;
    }

    public abstract void i1(CallCardViewModel callCardViewModel);
}
