package O1;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewStub;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.android.incallui.BR;
import com.android.incallui.R;
import com.android.incallui.mvvm.view_model.CallCardViewModel;
import com.android.incallui.oplus.widgets.AdaptiveTextSizeTextView;
import com.android.incallui.oplus.widgets.LineFeedTextView;
import com.coui.appcompat.imageview.COUIRoundImageView;

/* compiled from: CallCardInfoBindingImpl.java */
/* renamed from: O1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0396b extends AbstractC0395a {

    /* renamed from: S, reason: collision with root package name */
    public static final ViewDataBinding.i f2536S = null;

    /* renamed from: T, reason: collision with root package name */
    public static final SparseIntArray f2537T;

    /* renamed from: Q, reason: collision with root package name */
    public final ConstraintLayout f2538Q;

    /* renamed from: R, reason: collision with root package name */
    public long f2539R;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f2537T = sparseIntArray;
        sparseIntArray.put(R.id.call_card_secondary_info, 1);
        sparseIntArray.put(R.id.call_card_notice, 3);
        sparseIntArray.put(R.id.call_card_location, 4);
        sparseIntArray.put(R.id.br_second_or_location, 5);
        sparseIntArray.put(R.id.call_card_primary_info_number, 6);
        sparseIntArray.put(R.id.call_card_primary_info_avatar, 7);
        sparseIntArray.put(R.id.call_card_primary_info_location, 8);
        sparseIntArray.put(R.id.call_card_conference_participant, 9);
    }

    public C0396b(androidx.databinding.f fVar, View view) {
        this(fVar, view, ViewDataBinding.R0(fVar, view, 10, f2536S, f2537T));
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:112:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0187  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void A0() {
        /*
            Method dump skipped, instructions count: 468
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: O1.C0396b.A0():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean M0() {
        synchronized (this) {
            try {
                if (this.f2539R != 0) {
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
            this.f2539R = 128L;
        }
        W0();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean S0(int i10, Object obj, int i11) {
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        if (i10 != 4) {
                            if (i10 != 5) {
                                return false;
                            }
                            return o1((com.android.incallui.mvvm.utils.h) obj, i11);
                        }
                        return m1((com.android.incallui.mvvm.utils.y) obj, i11);
                    }
                    return j1((com.android.incallui.mvvm.utils.y) obj, i11);
                }
                return k1((com.android.incallui.mvvm.utils.h) obj, i11);
            }
            return n1((com.android.incallui.mvvm.utils.y) obj, i11);
        }
        return l1((com.android.incallui.mvvm.utils.h) obj, i11);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean d1(int i10, Object obj) {
        if (BR.mCallCardViewModel == i10) {
            i1((CallCardViewModel) obj);
            return true;
        }
        return false;
    }

    @Override // O1.AbstractC0395a
    public void i1(CallCardViewModel callCardViewModel) {
        this.f2535P = callCardViewModel;
        synchronized (this) {
            this.f2539R |= 64;
        }
        r0(BR.mCallCardViewModel);
        super.W0();
    }

    public final boolean j1(com.android.incallui.mvvm.utils.y<Boolean> yVar, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2539R |= 8;
            }
            return true;
        }
        return false;
    }

    public final boolean k1(com.android.incallui.mvvm.utils.h<Boolean> hVar, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2539R |= 4;
            }
            return true;
        }
        return false;
    }

    public final boolean l1(com.android.incallui.mvvm.utils.h<Boolean> hVar, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2539R |= 1;
            }
            return true;
        }
        return false;
    }

    public final boolean m1(com.android.incallui.mvvm.utils.y<Integer> yVar, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2539R |= 16;
            }
            return true;
        }
        return false;
    }

    public final boolean n1(com.android.incallui.mvvm.utils.y<Integer> yVar, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2539R |= 2;
            }
            return true;
        }
        return false;
    }

    public final boolean o1(com.android.incallui.mvvm.utils.h<Boolean> hVar, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2539R |= 32;
            }
            return true;
        }
        return false;
    }

    public C0396b(androidx.databinding.f fVar, View view, Object[] objArr) {
        super(fVar, view, 6, (Barrier) objArr[5], new androidx.databinding.o((ViewStub) objArr[9]), new androidx.databinding.o((ViewStub) objArr[4]), new androidx.databinding.o((ViewStub) objArr[3]), (COUIRoundImageView) objArr[7], (LineFeedTextView) objArr[8], (AdaptiveTextSizeTextView) objArr[2], (AdaptiveTextSizeTextView) objArr[6], new androidx.databinding.o((ViewStub) objArr[1]));
        this.f2539R = -1L;
        this.f2527H.k(this);
        this.f2528I.k(this);
        this.f2529J.k(this);
        this.f2532M.setTag(null);
        this.f2534O.k(this);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f2538Q = constraintLayout;
        constraintLayout.setTag(null);
        c1(view);
        O0();
    }
}
