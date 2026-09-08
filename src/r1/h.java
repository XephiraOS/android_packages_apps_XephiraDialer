package R1;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.o;
import androidx.lifecycle.v;
import com.android.incallui.foldscreen.presentation.viewmodel.FoldScreenCallButtonViewModel;
import g2.InterfaceC1034a;

/* compiled from: FragmentFoldScreenCallButtonBindingImpl.java */
/* loaded from: classes.dex */
public class h extends g {

    /* renamed from: N, reason: collision with root package name */
    public static final ViewDataBinding.i f3287N = null;

    /* renamed from: O, reason: collision with root package name */
    public static final SparseIntArray f3288O;

    /* renamed from: L, reason: collision with root package name */
    public final FrameLayout f3289L;

    /* renamed from: M, reason: collision with root package name */
    public long f3290M;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f3288O = sparseIntArray;
        sparseIntArray.put(P1.d.f2842a, 1);
        sparseIntArray.put(P1.d.f2843b, 2);
        sparseIntArray.put(P1.d.f2863v, 3);
    }

    public h(androidx.databinding.f fVar, View view) {
        this(fVar, view, ViewDataBinding.R0(fVar, view, 4, f3287N, f3288O));
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005e  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void A0() {
        /*
            Method dump skipped, instructions count: 302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: R1.h.A0():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean M0() {
        synchronized (this) {
            try {
                if (this.f3290M != 0) {
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
            this.f3290M = 32L;
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
                return n1((v) obj, i11);
            }
            return m1((v) obj, i11);
        }
        return o1((v) obj, i11);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean d1(int i10, Object obj) {
        if (P1.a.f2823b == i10) {
            k1((InterfaceC1034a) obj);
        } else if (P1.a.f2824c == i10) {
            l1((FoldScreenCallButtonViewModel) obj);
        } else {
            return false;
        }
        return true;
    }

    @Override // R1.g
    public void k1(InterfaceC1034a interfaceC1034a) {
        this.f3286K = interfaceC1034a;
        synchronized (this) {
            this.f3290M |= 8;
        }
        r0(P1.a.f2823b);
        super.W0();
    }

    @Override // R1.g
    public void l1(FoldScreenCallButtonViewModel foldScreenCallButtonViewModel) {
        this.f3285J = foldScreenCallButtonViewModel;
        synchronized (this) {
            this.f3290M |= 16;
        }
        r0(P1.a.f2824c);
        super.W0();
    }

    public final boolean m1(v<Integer> vVar, int i10) {
        if (i10 == P1.a.f2822a) {
            synchronized (this) {
                this.f3290M |= 2;
            }
            return true;
        }
        return false;
    }

    public final boolean n1(v<Integer> vVar, int i10) {
        if (i10 == P1.a.f2822a) {
            synchronized (this) {
                this.f3290M |= 4;
            }
            return true;
        }
        return false;
    }

    public final boolean o1(v<Integer> vVar, int i10) {
        if (i10 == P1.a.f2822a) {
            synchronized (this) {
                this.f3290M |= 1;
            }
            return true;
        }
        return false;
    }

    public h(androidx.databinding.f fVar, View view, Object[] objArr) {
        super(fVar, view, 3, new o((ViewStub) objArr[1]), new o((ViewStub) objArr[2]), new o((ViewStub) objArr[3]));
        this.f3290M = -1L;
        this.f3282G.k(this);
        this.f3283H.k(this);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f3289L = frameLayout;
        frameLayout.setTag(null);
        this.f3284I.k(this);
        c1(view);
        O0();
    }
}
