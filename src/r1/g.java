package R1;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.o;
import com.android.incallui.foldscreen.presentation.viewmodel.FoldScreenCallButtonViewModel;
import g2.InterfaceC1034a;

/* compiled from: FragmentFoldScreenCallButtonBinding.java */
/* loaded from: classes.dex */
public abstract class g extends ViewDataBinding {

    /* renamed from: G, reason: collision with root package name */
    public final o f3282G;

    /* renamed from: H, reason: collision with root package name */
    public final o f3283H;

    /* renamed from: I, reason: collision with root package name */
    public final o f3284I;

    /* renamed from: J, reason: collision with root package name */
    public FoldScreenCallButtonViewModel f3285J;

    /* renamed from: K, reason: collision with root package name */
    public InterfaceC1034a f3286K;

    public g(Object obj, View view, int i10, o oVar, o oVar2, o oVar3) {
        super(obj, view, i10);
        this.f3282G = oVar;
        this.f3283H = oVar2;
        this.f3284I = oVar3;
    }

    public static g i1(View view) {
        return j1(view, androidx.databinding.g.g());
    }

    @Deprecated
    public static g j1(View view, Object obj) {
        return (g) ViewDataBinding.y0(obj, view, P1.e.f2870g);
    }

    public abstract void k1(InterfaceC1034a interfaceC1034a);

    public abstract void l1(FoldScreenCallButtonViewModel foldScreenCallButtonViewModel);
}
