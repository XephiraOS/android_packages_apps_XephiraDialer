package O1;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.android.incallui.R;
import com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.FloatingWindowCommandViewModel;
import com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.FloatingWindowViewModel;

/* compiled from: OplusIncallFloatingViewBinding.java */
/* loaded from: classes.dex */
public abstract class G extends ViewDataBinding {

    /* renamed from: G, reason: collision with root package name */
    public final androidx.databinding.o f2504G;

    /* renamed from: H, reason: collision with root package name */
    public final androidx.databinding.o f2505H;

    /* renamed from: I, reason: collision with root package name */
    public final androidx.databinding.o f2506I;

    /* renamed from: J, reason: collision with root package name */
    public final androidx.databinding.o f2507J;

    /* renamed from: K, reason: collision with root package name */
    public FloatingWindowViewModel f2508K;

    /* renamed from: L, reason: collision with root package name */
    public FloatingWindowCommandViewModel f2509L;

    public G(Object obj, View view, int i10, androidx.databinding.o oVar, androidx.databinding.o oVar2, androidx.databinding.o oVar3, androidx.databinding.o oVar4) {
        super(obj, view, i10);
        this.f2504G = oVar;
        this.f2505H = oVar2;
        this.f2506I = oVar3;
        this.f2507J = oVar4;
    }

    public static G i1(View view) {
        return j1(view, androidx.databinding.g.g());
    }

    @Deprecated
    public static G j1(View view, Object obj) {
        return (G) ViewDataBinding.y0(obj, view, R.layout.oplus_incall_floating_view);
    }

    public abstract void k1(FloatingWindowCommandViewModel floatingWindowCommandViewModel);

    public abstract void l1(FloatingWindowViewModel floatingWindowViewModel);
}
