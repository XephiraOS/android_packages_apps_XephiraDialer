package R1;

import V1.a;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.v;
import com.android.incallui.foldscreen.presentation.viewmodel.FoldScreenCallButtonViewModel;
import com.android.incallui.oplus.widgets.ScaleImageView;

/* compiled from: FoldCallButtonLayoutBindingImpl.java */
/* loaded from: classes.dex */
public class d extends c implements a.InterfaceC0074a {

    /* renamed from: L, reason: collision with root package name */
    public static final ViewDataBinding.i f3270L = null;

    /* renamed from: M, reason: collision with root package name */
    public static final SparseIntArray f3271M = null;

    /* renamed from: I, reason: collision with root package name */
    public final FrameLayout f3272I;

    /* renamed from: J, reason: collision with root package name */
    public final View.OnClickListener f3273J;

    /* renamed from: K, reason: collision with root package name */
    public long f3274K;

    public d(androidx.databinding.f fVar, View view) {
        this(fVar, view, ViewDataBinding.R0(fVar, view, 2, f3270L, f3271M));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void A0() {
        long j10;
        v<Boolean> vVar;
        synchronized (this) {
            j10 = this.f3274K;
            this.f3274K = 0L;
        }
        FoldScreenCallButtonViewModel foldScreenCallButtonViewModel = this.f3269H;
        long j11 = 7 & j10;
        boolean z10 = false;
        if (j11 != 0) {
            Boolean bool = null;
            if (foldScreenCallButtonViewModel != null) {
                vVar = foldScreenCallButtonViewModel.u();
            } else {
                vVar = null;
            }
            f1(0, vVar);
            if (vVar != null) {
                bool = vVar.getValue();
            }
            z10 = ViewDataBinding.Z0(bool);
        }
        if ((j10 & 4) != 0) {
            this.f3268G.setOnClickListener(this.f3273J);
        }
        if (j11 != 0) {
            com.android.incallui.mvvm.utils.d.f(this.f3268G, z10);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean M0() {
        synchronized (this) {
            try {
                if (this.f3274K != 0) {
                    return true;
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void O0() {
        synchronized (this) {
            this.f3274K = 4L;
        }
        W0();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean S0(int i10, Object obj, int i11) {
        if (i10 != 0) {
            return false;
        }
        return i1((v) obj, i11);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean d1(int i10, Object obj) {
        if (P1.a.f2824c == i10) {
            j1((FoldScreenCallButtonViewModel) obj);
            return true;
        }
        return false;
    }

    @Override // V1.a.InterfaceC0074a
    public final void i0(int i10, View view) {
        FoldScreenCallButtonViewModel foldScreenCallButtonViewModel = this.f3269H;
        if (foldScreenCallButtonViewModel != null) {
            foldScreenCallButtonViewModel.r();
        }
    }

    public final boolean i1(v<Boolean> vVar, int i10) {
        if (i10 == P1.a.f2822a) {
            synchronized (this) {
                this.f3274K |= 1;
            }
            return true;
        }
        return false;
    }

    public void j1(FoldScreenCallButtonViewModel foldScreenCallButtonViewModel) {
        this.f3269H = foldScreenCallButtonViewModel;
        synchronized (this) {
            this.f3274K |= 2;
        }
        r0(P1.a.f2824c);
        super.W0();
    }

    public d(androidx.databinding.f fVar, View view, Object[] objArr) {
        super(fVar, view, 1, (ScaleImageView) objArr[1]);
        this.f3274K = -1L;
        this.f3268G.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f3272I = frameLayout;
        frameLayout.setTag(null);
        c1(view);
        this.f3273J = new V1.a(this, 1);
        O0();
    }
}
