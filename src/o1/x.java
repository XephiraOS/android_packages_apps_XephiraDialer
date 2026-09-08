package O1;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.android.incallui.BR;
import com.android.incallui.R;
import com.android.incallui.mvvm.view_model.DialpadViewModel;
import com.android.incallui.mvvm.widget.SuitableSizeEditText;

/* compiled from: OplusDialpadFragmentBindingImpl.java */
/* loaded from: classes.dex */
public class x extends w {

    /* renamed from: L, reason: collision with root package name */
    public static final ViewDataBinding.i f2648L = null;

    /* renamed from: M, reason: collision with root package name */
    public static final SparseIntArray f2649M;

    /* renamed from: J, reason: collision with root package name */
    public final LinearLayout f2650J;

    /* renamed from: K, reason: collision with root package name */
    public long f2651K;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f2649M = sparseIntArray;
        sparseIntArray.put(R.id.rv_dialpad_buttons, 2);
    }

    public x(androidx.databinding.f fVar, View view) {
        this(fVar, view, ViewDataBinding.R0(fVar, view, 3, f2648L, f2649M));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void A0() {
        long j10;
        com.android.incallui.mvvm.utils.h<String> hVar;
        com.android.incallui.mvvm.utils.h<Boolean> hVar2;
        Boolean bool;
        synchronized (this) {
            j10 = this.f2651K;
            this.f2651K = 0L;
        }
        DialpadViewModel dialpadViewModel = this.f2647I;
        boolean z10 = false;
        String str = null;
        if ((15 & j10) != 0) {
            if ((j10 & 13) != 0) {
                if (dialpadViewModel != null) {
                    hVar2 = dialpadViewModel.j();
                } else {
                    hVar2 = null;
                }
                f1(0, hVar2);
                if (hVar2 != null) {
                    bool = hVar2.getValue();
                } else {
                    bool = null;
                }
                z10 = ViewDataBinding.Z0(bool);
            }
            if ((j10 & 14) != 0) {
                if (dialpadViewModel != null) {
                    hVar = dialpadViewModel.i();
                } else {
                    hVar = null;
                }
                f1(1, hVar);
                if (hVar != null) {
                    str = hVar.getValue();
                }
            }
        }
        if ((j10 & 14) != 0) {
            if (ViewDataBinding.I0() >= 4) {
                this.f2645G.setContentDescription(str);
            }
            com.android.incallui.mvvm.utils.d.r(this.f2645G, str);
        }
        if ((j10 & 13) != 0) {
            com.android.incallui.mvvm.utils.d.f(this.f2650J, z10);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean M0() {
        synchronized (this) {
            try {
                if (this.f2651K != 0) {
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
            this.f2651K = 8L;
        }
        W0();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean S0(int i10, Object obj, int i11) {
        if (i10 != 0) {
            if (i10 != 1) {
                return false;
            }
            return l1((com.android.incallui.mvvm.utils.h) obj, i11);
        }
        return m1((com.android.incallui.mvvm.utils.h) obj, i11);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean d1(int i10, Object obj) {
        if (BR.mDialpadViewModel == i10) {
            k1((DialpadViewModel) obj);
            return true;
        }
        return false;
    }

    @Override // O1.w
    public void k1(DialpadViewModel dialpadViewModel) {
        this.f2647I = dialpadViewModel;
        synchronized (this) {
            this.f2651K |= 4;
        }
        r0(BR.mDialpadViewModel);
        super.W0();
    }

    public final boolean l1(com.android.incallui.mvvm.utils.h<String> hVar, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2651K |= 2;
            }
            return true;
        }
        return false;
    }

    public final boolean m1(com.android.incallui.mvvm.utils.h<Boolean> hVar, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2651K |= 1;
            }
            return true;
        }
        return false;
    }

    public x(androidx.databinding.f fVar, View view, Object[] objArr) {
        super(fVar, view, 2, (SuitableSizeEditText) objArr[1], (RecyclerView) objArr[2]);
        this.f2651K = -1L;
        this.f2645G.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f2650J = linearLayout;
        linearLayout.setTag(null);
        c1(view);
        O0();
    }
}
