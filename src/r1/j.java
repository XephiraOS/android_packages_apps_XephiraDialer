package R1;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.o;
import com.android.incallui.clean.presentation.view.InCallMarqueeTextView;
import com.android.incallui.foldscreen.presentation.viewmodel.FoldScreenCallCardViewModel;
import com.android.incallui.mvvm.utils.y;
import kotlin.Pair;

/* compiled from: FragmentFoldScreenCallCardBindingImpl.java */
/* loaded from: classes.dex */
public class j extends i {

    /* renamed from: Q, reason: collision with root package name */
    public static final ViewDataBinding.i f3299Q = null;

    /* renamed from: R, reason: collision with root package name */
    public static final SparseIntArray f3300R;

    /* renamed from: O, reason: collision with root package name */
    public final LinearLayout f3301O;

    /* renamed from: P, reason: collision with root package name */
    public long f3302P;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f3300R = sparseIntArray;
        sparseIntArray.put(P1.d.f2855n, 1);
        sparseIntArray.put(P1.d.f2853l, 7);
    }

    public j(androidx.databinding.f fVar, View view) {
        this(fVar, view, ViewDataBinding.R0(fVar, view, 8, f3299Q, f3300R));
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:121:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01c0  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void A0() {
        /*
            Method dump skipped, instructions count: 570
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: R1.j.A0():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean M0() {
        synchronized (this) {
            try {
                if (this.f3302P != 0) {
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
            this.f3302P = 256L;
        }
        W0();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean S0(int i10, Object obj, int i11) {
        switch (i10) {
            case 0:
                return p1((y) obj, i11);
            case 1:
                return q1((com.android.incallui.mvvm.utils.h) obj, i11);
            case 2:
                return m1((com.android.incallui.mvvm.utils.h) obj, i11);
            case 3:
                return r1((y) obj, i11);
            case 4:
                return l1((com.android.incallui.mvvm.utils.h) obj, i11);
            case 5:
                return n1((com.android.incallui.mvvm.utils.h) obj, i11);
            case 6:
                return o1((com.android.incallui.mvvm.utils.h) obj, i11);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean d1(int i10, Object obj) {
        if (P1.a.f2824c == i10) {
            k1((FoldScreenCallCardViewModel) obj);
            return true;
        }
        return false;
    }

    @Override // R1.i
    public void k1(FoldScreenCallCardViewModel foldScreenCallCardViewModel) {
        this.f3298N = foldScreenCallCardViewModel;
        synchronized (this) {
            this.f3302P |= 128;
        }
        r0(P1.a.f2824c);
        super.W0();
    }

    public final boolean l1(com.android.incallui.mvvm.utils.h<Drawable> hVar, int i10) {
        if (i10 == P1.a.f2822a) {
            synchronized (this) {
                this.f3302P |= 16;
            }
            return true;
        }
        return false;
    }

    public final boolean m1(com.android.incallui.mvvm.utils.h<String> hVar, int i10) {
        if (i10 == P1.a.f2822a) {
            synchronized (this) {
                this.f3302P |= 4;
            }
            return true;
        }
        return false;
    }

    public final boolean n1(com.android.incallui.mvvm.utils.h<String> hVar, int i10) {
        if (i10 == P1.a.f2822a) {
            synchronized (this) {
                this.f3302P |= 32;
            }
            return true;
        }
        return false;
    }

    public final boolean o1(com.android.incallui.mvvm.utils.h<Drawable> hVar, int i10) {
        if (i10 == P1.a.f2822a) {
            synchronized (this) {
                this.f3302P |= 64;
            }
            return true;
        }
        return false;
    }

    public final boolean p1(y<Pair<String, String>> yVar, int i10) {
        if (i10 == P1.a.f2822a) {
            synchronized (this) {
                this.f3302P |= 1;
            }
            return true;
        }
        return false;
    }

    public final boolean q1(com.android.incallui.mvvm.utils.h<H1.b> hVar, int i10) {
        if (i10 == P1.a.f2822a) {
            synchronized (this) {
                this.f3302P |= 2;
            }
            return true;
        }
        return false;
    }

    public final boolean r1(y<Boolean> yVar, int i10) {
        if (i10 == P1.a.f2822a) {
            synchronized (this) {
                this.f3302P |= 8;
            }
            return true;
        }
        return false;
    }

    public j(androidx.databinding.f fVar, View view, Object[] objArr) {
        super(fVar, view, 7, (InCallMarqueeTextView) objArr[6], (ImageView) objArr[5], (InCallMarqueeTextView) objArr[2], (InCallMarqueeTextView) objArr[3], (ImageView) objArr[4], (LinearLayout) objArr[7], new o((ViewStub) objArr[1]));
        this.f3302P = -1L;
        this.f3291G.setTag(null);
        this.f3292H.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f3301O = linearLayout;
        linearLayout.setTag(null);
        this.f3293I.setTag(null);
        this.f3294J.setTag(null);
        this.f3295K.setTag(null);
        this.f3297M.k(this);
        c1(view);
        O0();
    }
}
