package O1;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.android.incallui.BR;
import com.android.incallui.R;
import com.android.incallui.mvvm.view_model.CallButtonViewModel;
import com.android.incallui.oplus.widgets.OplusGoneIncallUIImageView;

/* compiled from: OplusCallButtonFragmentBindingImpl.java */
/* loaded from: classes.dex */
public class v extends u {

    /* renamed from: L, reason: collision with root package name */
    public static final ViewDataBinding.i f2642L = null;

    /* renamed from: M, reason: collision with root package name */
    public static final SparseIntArray f2643M;

    /* renamed from: K, reason: collision with root package name */
    public long f2644K;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f2643M = sparseIntArray;
        sparseIntArray.put(R.id.endButton, 2);
    }

    public v(androidx.databinding.f fVar, View view) {
        this(fVar, view, ViewDataBinding.R0(fVar, view, 3, f2642L, f2643M));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void A0() {
        long j10;
        com.android.incallui.mvvm.utils.y<Integer> yVar;
        synchronized (this) {
            j10 = this.f2644K;
            this.f2644K = 0L;
        }
        CallButtonViewModel callButtonViewModel = this.f2641J;
        long j11 = j10 & 7;
        int i10 = 0;
        if (j11 != 0) {
            Integer num = null;
            if (callButtonViewModel != null) {
                yVar = callButtonViewModel.h();
            } else {
                yVar = null;
            }
            f1(0, yVar);
            if (yVar != null) {
                num = yVar.getValue();
            }
            i10 = ViewDataBinding.Y0(num);
        }
        if (j11 != 0) {
            com.android.incallui.mvvm.utils.d.n(this.f2639H, i10);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean M0() {
        synchronized (this) {
            try {
                if (this.f2644K != 0) {
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
            this.f2644K = 4L;
        }
        W0();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean S0(int i10, Object obj, int i11) {
        if (i10 != 0) {
            return false;
        }
        return l1((com.android.incallui.mvvm.utils.y) obj, i11);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean d1(int i10, Object obj) {
        if (BR.mCallButtonViewModel == i10) {
            k1((CallButtonViewModel) obj);
            return true;
        }
        return false;
    }

    @Override // O1.u
    public void k1(CallButtonViewModel callButtonViewModel) {
        this.f2641J = callButtonViewModel;
        synchronized (this) {
            this.f2644K |= 2;
        }
        r0(BR.mCallButtonViewModel);
        super.W0();
    }

    public final boolean l1(com.android.incallui.mvvm.utils.y<Integer> yVar, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2644K |= 1;
            }
            return true;
        }
        return false;
    }

    public v(androidx.databinding.f fVar, View view, Object[] objArr) {
        super(fVar, view, 1, (FrameLayout) objArr[0], (RecyclerView) objArr[1], (OplusGoneIncallUIImageView) objArr[2]);
        this.f2644K = -1L;
        this.f2638G.setTag(null);
        this.f2639H.setTag(null);
        c1(view);
        O0();
    }
}
