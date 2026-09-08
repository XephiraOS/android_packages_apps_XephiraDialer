package O1;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.InterfaceC0492o;
import com.android.incallui.BR;
import com.android.incallui.R;
import com.android.incallui.mvvm.view_model.CallCardViewModel;
import com.android.incallui.mvvm.widget.MaxWidthLinearLayout;
import com.android.incallui.mvvm.widget.SuitableSizeTextView;
import kotlin.Pair;

/* compiled from: IncallCallCardLayoutBindingImpl.java */
/* renamed from: O1.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0404j extends AbstractC0403i {

    /* renamed from: P, reason: collision with root package name */
    public static final ViewDataBinding.i f2579P;

    /* renamed from: Q, reason: collision with root package name */
    public static final SparseIntArray f2580Q;

    /* renamed from: O, reason: collision with root package name */
    public long f2581O;

    static {
        ViewDataBinding.i iVar = new ViewDataBinding.i(7);
        f2579P = iVar;
        iVar.a(0, new String[]{"call_card_info"}, new int[]{3}, new int[]{R.layout.call_card_info});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f2580Q = sparseIntArray;
        sparseIntArray.put(R.id.oplus_call_card_verification, 4);
        sparseIntArray.put(R.id.call_card_primary_call_state_card_icon, 5);
        sparseIntArray.put(R.id.call_card_primary_call_state_hd_icon, 6);
    }

    public C0404j(androidx.databinding.f fVar, View view) {
        this(fVar, view, ViewDataBinding.R0(fVar, view, 7, f2579P, f2580Q));
    }

    private boolean n1(com.android.incallui.mvvm.utils.h<Boolean> hVar, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2581O |= 8;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0119  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void A0() {
        /*
            Method dump skipped, instructions count: 307
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: O1.C0404j.A0():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean M0() {
        synchronized (this) {
            try {
                if (this.f2581O != 0) {
                    return true;
                }
                if (this.f2571G.M0()) {
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
            this.f2581O = 64L;
        }
        this.f2571G.O0();
        W0();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean S0(int i10, Object obj, int i11) {
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        if (i10 != 4) {
                            return false;
                        }
                        return m1((com.android.incallui.mvvm.utils.y) obj, i11);
                    }
                    return n1((com.android.incallui.mvvm.utils.h) obj, i11);
                }
                return p1((com.android.incallui.mvvm.utils.y) obj, i11);
            }
            return o1((com.android.incallui.mvvm.utils.y) obj, i11);
        }
        return l1((AbstractC0395a) obj, i11);
    }

    @Override // androidx.databinding.ViewDataBinding
    public void b1(InterfaceC0492o interfaceC0492o) {
        super.b1(interfaceC0492o);
        this.f2571G.b1(interfaceC0492o);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean d1(int i10, Object obj) {
        if (BR.mCallCardViewModel == i10) {
            k1((CallCardViewModel) obj);
            return true;
        }
        return false;
    }

    @Override // O1.AbstractC0403i
    public void k1(CallCardViewModel callCardViewModel) {
        this.f2578N = callCardViewModel;
        synchronized (this) {
            this.f2581O |= 32;
        }
        r0(BR.mCallCardViewModel);
        super.W0();
    }

    public final boolean l1(AbstractC0395a abstractC0395a, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2581O |= 1;
            }
            return true;
        }
        return false;
    }

    public final boolean m1(com.android.incallui.mvvm.utils.y<Pair<String, String>> yVar, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2581O |= 16;
            }
            return true;
        }
        return false;
    }

    public final boolean o1(com.android.incallui.mvvm.utils.y<Integer> yVar, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2581O |= 2;
            }
            return true;
        }
        return false;
    }

    public final boolean p1(com.android.incallui.mvvm.utils.y<Integer> yVar, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2581O |= 4;
            }
            return true;
        }
        return false;
    }

    public C0404j(androidx.databinding.f fVar, View view, Object[] objArr) {
        super(fVar, view, 5, (AbstractC0395a) objArr[3], (LinearLayout) objArr[1], (ImageView) objArr[5], (SuitableSizeTextView) objArr[2], (ImageView) objArr[6], (MaxWidthLinearLayout) objArr[0], (SuitableSizeTextView) objArr[4]);
        this.f2581O = -1L;
        a1(this.f2571G);
        this.f2572H.setTag(null);
        this.f2574J.setTag(null);
        this.f2576L.setTag(null);
        c1(view);
        O0();
    }
}
