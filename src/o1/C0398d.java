package O1;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.android.incallui.BR;
import com.android.incallui.mvvm.view_model.CallCardViewModel;
import com.android.incallui.mvvm.widget.SuitableSizeTextView;

/* compiled from: CallCardNoticeTextViewBindingImpl.java */
/* renamed from: O1.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0398d extends AbstractC0397c {

    /* renamed from: J, reason: collision with root package name */
    public static final ViewDataBinding.i f2542J = null;

    /* renamed from: K, reason: collision with root package name */
    public static final SparseIntArray f2543K = null;

    /* renamed from: I, reason: collision with root package name */
    public long f2544I;

    public C0398d(androidx.databinding.f fVar, View view) {
        this(fVar, view, ViewDataBinding.R0(fVar, view, 1, f2542J, f2543K));
    }

    private boolean j1(com.android.incallui.mvvm.utils.y<Boolean> yVar, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2544I |= 2;
            }
            return true;
        }
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void A0() {
        long j10;
        boolean z10;
        int i10;
        com.android.incallui.mvvm.utils.y<String> yVar;
        com.android.incallui.mvvm.utils.y<Boolean> yVar2;
        Boolean bool;
        com.android.incallui.mvvm.utils.y<Integer> yVar3;
        Integer num;
        synchronized (this) {
            j10 = this.f2544I;
            this.f2544I = 0L;
        }
        CallCardViewModel callCardViewModel = this.f2541H;
        int i11 = 0;
        boolean z11 = false;
        String str = null;
        if ((31 & j10) != 0) {
            if ((j10 & 25) != 0) {
                if (callCardViewModel != null) {
                    yVar3 = callCardViewModel.s();
                } else {
                    yVar3 = null;
                }
                f1(0, yVar3);
                if (yVar3 != null) {
                    num = yVar3.getValue();
                } else {
                    num = null;
                }
                i10 = ViewDataBinding.Y0(num);
            } else {
                i10 = 0;
            }
            if ((j10 & 26) != 0) {
                if (callCardViewModel != null) {
                    yVar2 = callCardViewModel.j();
                } else {
                    yVar2 = null;
                }
                f1(1, yVar2);
                if (yVar2 != null) {
                    bool = yVar2.getValue();
                } else {
                    bool = null;
                }
                z11 = ViewDataBinding.Z0(bool);
            }
            if ((j10 & 28) != 0) {
                if (callCardViewModel != null) {
                    yVar = callCardViewModel.i();
                } else {
                    yVar = null;
                }
                f1(2, yVar);
                if (yVar != null) {
                    str = yVar.getValue();
                }
            }
            z10 = z11;
            i11 = i10;
        } else {
            z10 = false;
        }
        if ((j10 & 28) != 0) {
            L.c.e(this.f2540G, str);
        }
        if ((j10 & 25) != 0) {
            com.android.incallui.mvvm.utils.d.j(this.f2540G, i11);
            com.android.incallui.mvvm.utils.d.h(this.f2540G, i11);
        }
        if ((j10 & 26) != 0) {
            com.android.incallui.mvvm.utils.d.s(this.f2540G, z10);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean M0() {
        synchronized (this) {
            try {
                if (this.f2544I != 0) {
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
            this.f2544I = 16L;
        }
        W0();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean S0(int i10, Object obj, int i11) {
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    return false;
                }
                return i1((com.android.incallui.mvvm.utils.y) obj, i11);
            }
            return j1((com.android.incallui.mvvm.utils.y) obj, i11);
        }
        return k1((com.android.incallui.mvvm.utils.y) obj, i11);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean d1(int i10, Object obj) {
        if (BR.mCallCardViewModel == i10) {
            l1((CallCardViewModel) obj);
            return true;
        }
        return false;
    }

    public final boolean i1(com.android.incallui.mvvm.utils.y<String> yVar, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2544I |= 4;
            }
            return true;
        }
        return false;
    }

    public final boolean k1(com.android.incallui.mvvm.utils.y<Integer> yVar, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2544I |= 1;
            }
            return true;
        }
        return false;
    }

    public void l1(CallCardViewModel callCardViewModel) {
        this.f2541H = callCardViewModel;
        synchronized (this) {
            this.f2544I |= 8;
        }
        r0(BR.mCallCardViewModel);
        super.W0();
    }

    public C0398d(androidx.databinding.f fVar, View view, Object[] objArr) {
        super(fVar, view, 3, (SuitableSizeTextView) objArr[0]);
        this.f2544I = -1L;
        this.f2540G.setTag(null);
        c1(view);
        O0();
    }
}
