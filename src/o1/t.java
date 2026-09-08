package O1;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.android.incallui.BR;
import com.android.incallui.R;
import e2.C0967b;

/* compiled from: ItemDialpadButtonBindingImpl.java */
/* loaded from: classes.dex */
public class t extends s {

    /* renamed from: O, reason: collision with root package name */
    public static final ViewDataBinding.i f2633O = null;

    /* renamed from: P, reason: collision with root package name */
    public static final SparseIntArray f2634P;

    /* renamed from: L, reason: collision with root package name */
    public final FrameLayout f2635L;

    /* renamed from: M, reason: collision with root package name */
    public final AppCompatImageView f2636M;

    /* renamed from: N, reason: collision with root package name */
    public long f2637N;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f2634P = sparseIntArray;
        sparseIntArray.put(R.id.tv_circle, 5);
    }

    public t(androidx.databinding.f fVar, View view) {
        this(fVar, view, ViewDataBinding.R0(fVar, view, 6, f2633O, f2634P));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void A0() {
        long j10;
        boolean z10;
        String str;
        String str2;
        Integer num;
        String str3;
        boolean z11;
        synchronized (this) {
            j10 = this.f2637N;
            this.f2637N = 0L;
        }
        C0967b c0967b = this.f2632K;
        long j11 = j10 & 3;
        boolean z12 = false;
        char c10 = 0;
        String str4 = null;
        if (j11 != 0) {
            if (c0967b != null) {
                String c11 = c0967b.c();
                boolean e10 = c0967b.e();
                char d10 = c0967b.d();
                z10 = c0967b.f();
                num = c0967b.b();
                str3 = c0967b.a();
                z11 = e10;
                c10 = d10;
                str = c11;
            } else {
                z10 = false;
                str = null;
                str3 = null;
                num = null;
                z11 = false;
            }
            String str5 = str3;
            str2 = String.valueOf(c10);
            z12 = z11;
            str4 = str5;
        } else {
            z10 = false;
            str = null;
            str2 = null;
            num = null;
        }
        if (j11 != 0) {
            if (ViewDataBinding.I0() >= 4) {
                this.f2628G.setContentDescription(str4);
            }
            com.android.incallui.mvvm.utils.d.g(this.f2636M, num);
            L.c.e(this.f2630I, str);
            com.android.incallui.mvvm.utils.d.s(this.f2630I, z12);
            L.c.e(this.f2631J, str2);
            com.android.incallui.mvvm.utils.d.s(this.f2631J, z10);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean M0() {
        synchronized (this) {
            try {
                if (this.f2637N != 0) {
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
            this.f2637N = 2L;
        }
        W0();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean S0(int i10, Object obj, int i11) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean d1(int i10, Object obj) {
        if (BR.dialpadButtonInfo == i10) {
            i1((C0967b) obj);
            return true;
        }
        return false;
    }

    @Override // O1.s
    public void i1(C0967b c0967b) {
        this.f2632K = c0967b;
        synchronized (this) {
            this.f2637N |= 1;
        }
        r0(BR.dialpadButtonInfo);
        super.W0();
    }

    public t(androidx.databinding.f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (ConstraintLayout) objArr[1], (AppCompatImageView) objArr[5], (AppCompatTextView) objArr[4], (AppCompatTextView) objArr[3]);
        this.f2637N = -1L;
        this.f2628G.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f2635L = frameLayout;
        frameLayout.setTag(null);
        AppCompatImageView appCompatImageView = (AppCompatImageView) objArr[2];
        this.f2636M = appCompatImageView;
        appCompatImageView.setTag(null);
        this.f2630I.setTag(null);
        this.f2631J.setTag(null);
        c1(view);
        O0();
    }
}
