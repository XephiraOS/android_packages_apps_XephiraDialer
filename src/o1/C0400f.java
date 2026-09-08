package O1;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import com.android.incallui.BR;
import com.android.incallui.R;
import com.android.incallui.mvvm.view_model.CallCardViewModel;
import com.android.incallui.mvvm.widget.SuitableSizeTextView;

/* compiled from: CallCardSecondaryInfoLayoutBindingImpl.java */
/* renamed from: O1.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0400f extends AbstractC0399e {

    /* renamed from: N, reason: collision with root package name */
    public static final ViewDataBinding.i f2551N = null;

    /* renamed from: O, reason: collision with root package name */
    public static final SparseIntArray f2552O;

    /* renamed from: M, reason: collision with root package name */
    public long f2553M;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f2552O = sparseIntArray;
        sparseIntArray.put(R.id.call_card_secondary_info_name, 2);
        sparseIntArray.put(R.id.call_card_secondary_sim_icon, 3);
        sparseIntArray.put(R.id.call_card_secondary_info_connectionLabel, 4);
    }

    public C0400f(androidx.databinding.f fVar, View view) {
        this(fVar, view, ViewDataBinding.R0(fVar, view, 5, f2551N, f2552O));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void A0() {
        long j10;
        int i10;
        com.android.incallui.mvvm.utils.y<Integer> yVar;
        com.android.incallui.mvvm.utils.y<Integer> yVar2;
        Integer num;
        synchronized (this) {
            j10 = this.f2553M;
            this.f2553M = 0L;
        }
        CallCardViewModel callCardViewModel = this.f2550L;
        int i11 = 0;
        if ((15 & j10) != 0) {
            Integer num2 = null;
            if ((j10 & 13) != 0) {
                if (callCardViewModel != null) {
                    yVar2 = callCardViewModel.r();
                } else {
                    yVar2 = null;
                }
                f1(0, yVar2);
                if (yVar2 != null) {
                    num = yVar2.getValue();
                } else {
                    num = null;
                }
                i10 = ViewDataBinding.Y0(num);
            } else {
                i10 = 0;
            }
            if ((j10 & 14) != 0) {
                if (callCardViewModel != null) {
                    yVar = callCardViewModel.A();
                } else {
                    yVar = null;
                }
                f1(1, yVar);
                if (yVar != null) {
                    num2 = yVar.getValue();
                }
                i11 = ViewDataBinding.Y0(num2);
            }
        } else {
            i10 = 0;
        }
        if ((14 & j10) != 0) {
            com.android.incallui.mvvm.utils.d.j(this.f2545G, i11);
        }
        if ((j10 & 13) != 0) {
            com.android.incallui.mvvm.utils.d.j(this.f2549K, i10);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean M0() {
        synchronized (this) {
            try {
                if (this.f2553M != 0) {
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
            this.f2553M = 8L;
        }
        W0();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean S0(int i10, Object obj, int i11) {
        if (i10 != 0) {
            if (i10 != 1) {
                return false;
            }
            return j1((com.android.incallui.mvvm.utils.y) obj, i11);
        }
        return i1((com.android.incallui.mvvm.utils.y) obj, i11);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean d1(int i10, Object obj) {
        if (BR.mCallCardViewModel == i10) {
            k1((CallCardViewModel) obj);
            return true;
        }
        return false;
    }

    public final boolean i1(com.android.incallui.mvvm.utils.y<Integer> yVar, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2553M |= 1;
            }
            return true;
        }
        return false;
    }

    public final boolean j1(com.android.incallui.mvvm.utils.y<Integer> yVar, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2553M |= 2;
            }
            return true;
        }
        return false;
    }

    public void k1(CallCardViewModel callCardViewModel) {
        this.f2550L = callCardViewModel;
        synchronized (this) {
            this.f2553M |= 4;
        }
        r0(BR.mCallCardViewModel);
        super.W0();
    }

    public C0400f(androidx.databinding.f fVar, View view, Object[] objArr) {
        super(fVar, view, 2, (LinearLayout) objArr[0], (SuitableSizeTextView) objArr[4], (SuitableSizeTextView) objArr[2], (ImageView) objArr[3], (View) objArr[1]);
        this.f2553M = -1L;
        this.f2545G.setTag(null);
        this.f2549K.setTag(null);
        c1(view);
        O0();
    }
}
