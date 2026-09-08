package R1;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.v;
import com.android.incallui.foldscreen.presentation.viewmodel.FoldScreenCallButtonViewModel;
import com.android.incallui.mvvm.widget.SuitableSizeTextView;
import com.oplus.anim.EffectiveAnimationView;

/* compiled from: FoldScreenVideoAnimLayoutBindingImpl.java */
/* loaded from: classes.dex */
public class f extends e {

    /* renamed from: L, reason: collision with root package name */
    public static final ViewDataBinding.i f3278L = null;

    /* renamed from: M, reason: collision with root package name */
    public static final SparseIntArray f3279M = null;

    /* renamed from: J, reason: collision with root package name */
    public final LinearLayout f3280J;

    /* renamed from: K, reason: collision with root package name */
    public long f3281K;

    public f(androidx.databinding.f fVar, View view) {
        this(fVar, view, ViewDataBinding.R0(fVar, view, 3, f3278L, f3279M));
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0038  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void A0() {
        /*
            r13 = this;
            monitor-enter(r13)
            long r0 = r13.f3281K     // Catch: java.lang.Throwable -> L64
            r2 = 0
            r13.f3281K = r2     // Catch: java.lang.Throwable -> L64
            monitor-exit(r13)     // Catch: java.lang.Throwable -> L64
            com.android.incallui.foldscreen.presentation.viewmodel.FoldScreenCallButtonViewModel r4 = r13.f3277I
            r5 = 15
            long r5 = r5 & r0
            int r5 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            r6 = 14
            r8 = 13
            r10 = 0
            if (r5 == 0) goto L4e
            long r11 = r0 & r8
            int r5 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
            if (r5 == 0) goto L31
            if (r4 == 0) goto L23
            androidx.lifecycle.v r5 = r4.A()
            goto L24
        L23:
            r5 = r10
        L24:
            r11 = 0
            r13.f1(r11, r5)
            if (r5 == 0) goto L31
            java.lang.Object r5 = r5.getValue()
            java.lang.Integer r5 = (java.lang.Integer) r5
            goto L32
        L31:
            r5 = r10
        L32:
            long r11 = r0 & r6
            int r11 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
            if (r11 == 0) goto L4f
            if (r4 == 0) goto L3f
            androidx.lifecycle.v r4 = r4.z()
            goto L40
        L3f:
            r4 = r10
        L40:
            r11 = 1
            r13.f1(r11, r4)
            if (r4 == 0) goto L4f
            java.lang.Object r4 = r4.getValue()
            r10 = r4
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            goto L4f
        L4e:
            r5 = r10
        L4f:
            long r6 = r6 & r0
            int r4 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r4 == 0) goto L59
            com.oplus.anim.EffectiveAnimationView r4 = r13.f3275G
            Z1.b.g(r4, r10)
        L59:
            long r0 = r0 & r8
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L63
            com.android.incallui.mvvm.widget.SuitableSizeTextView r13 = r13.f3276H
            Z1.b.d(r13, r5)
        L63:
            return
        L64:
            r0 = move-exception
            monitor-exit(r13)     // Catch: java.lang.Throwable -> L64
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: R1.f.A0():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean M0() {
        synchronized (this) {
            try {
                if (this.f3281K != 0) {
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
            this.f3281K = 8L;
        }
        W0();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean S0(int i10, Object obj, int i11) {
        if (i10 != 0) {
            if (i10 != 1) {
                return false;
            }
            return i1((v) obj, i11);
        }
        return j1((v) obj, i11);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean d1(int i10, Object obj) {
        if (P1.a.f2824c == i10) {
            k1((FoldScreenCallButtonViewModel) obj);
            return true;
        }
        return false;
    }

    public final boolean i1(v<Boolean> vVar, int i10) {
        if (i10 == P1.a.f2822a) {
            synchronized (this) {
                this.f3281K |= 2;
            }
            return true;
        }
        return false;
    }

    public final boolean j1(v<Integer> vVar, int i10) {
        if (i10 == P1.a.f2822a) {
            synchronized (this) {
                this.f3281K |= 1;
            }
            return true;
        }
        return false;
    }

    public void k1(FoldScreenCallButtonViewModel foldScreenCallButtonViewModel) {
        this.f3277I = foldScreenCallButtonViewModel;
        synchronized (this) {
            this.f3281K |= 4;
        }
        r0(P1.a.f2824c);
        super.W0();
    }

    public f(androidx.databinding.f fVar, View view, Object[] objArr) {
        super(fVar, view, 2, (EffectiveAnimationView) objArr[1], (SuitableSizeTextView) objArr[2]);
        this.f3281K = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f3280J = linearLayout;
        linearLayout.setTag(null);
        this.f3275G.setTag(null);
        this.f3276H.setTag(null);
        c1(view);
        O0();
    }
}
