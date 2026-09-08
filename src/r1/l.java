package R1;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import com.android.incallui.clean.presentation.view.InCallMarqueeTextView;
import com.android.incallui.foldscreen.presentation.viewmodel.FoldScreenCallCardViewModel;
import com.android.incallui.mvvm.utils.y;

/* compiled from: FragmentFoldScreenCallCardSecondaryBindingImpl.java */
/* loaded from: classes.dex */
public class l extends k {

    /* renamed from: M, reason: collision with root package name */
    public static final ViewDataBinding.i f3307M = null;

    /* renamed from: N, reason: collision with root package name */
    public static final SparseIntArray f3308N;

    /* renamed from: K, reason: collision with root package name */
    public final LinearLayout f3309K;

    /* renamed from: L, reason: collision with root package name */
    public long f3310L;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f3308N = sparseIntArray;
        sparseIntArray.put(P1.d.f2854m, 3);
    }

    public l(androidx.databinding.f fVar, View view) {
        this(fVar, view, ViewDataBinding.R0(fVar, view, 4, f3307M, f3308N));
    }

    private boolean k1(y<Boolean> yVar, int i10) {
        if (i10 == P1.a.f2822a) {
            synchronized (this) {
                this.f3310L |= 2;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x006f  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void A0() {
        /*
            Method dump skipped, instructions count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: R1.l.A0():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean M0() {
        synchronized (this) {
            try {
                if (this.f3310L != 0) {
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
            this.f3310L = 16L;
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
                return j1((com.android.incallui.mvvm.utils.h) obj, i11);
            }
            return k1((y) obj, i11);
        }
        return i1((com.android.incallui.mvvm.utils.h) obj, i11);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean d1(int i10, Object obj) {
        if (P1.a.f2824c == i10) {
            l1((FoldScreenCallCardViewModel) obj);
            return true;
        }
        return false;
    }

    public final boolean i1(com.android.incallui.mvvm.utils.h<String> hVar, int i10) {
        if (i10 == P1.a.f2822a) {
            synchronized (this) {
                this.f3310L |= 1;
            }
            return true;
        }
        return false;
    }

    public final boolean j1(com.android.incallui.mvvm.utils.h<Drawable> hVar, int i10) {
        if (i10 == P1.a.f2822a) {
            synchronized (this) {
                this.f3310L |= 4;
            }
            return true;
        }
        return false;
    }

    public void l1(FoldScreenCallCardViewModel foldScreenCallCardViewModel) {
        this.f3306J = foldScreenCallCardViewModel;
        synchronized (this) {
            this.f3310L |= 8;
        }
        r0(P1.a.f2824c);
        super.W0();
    }

    public l(androidx.databinding.f fVar, View view, Object[] objArr) {
        super(fVar, view, 3, (InCallMarqueeTextView) objArr[2], (ImageView) objArr[1], (View) objArr[3]);
        this.f3310L = -1L;
        this.f3303G.setTag(null);
        this.f3304H.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f3309K = linearLayout;
        linearLayout.setTag(null);
        c1(view);
        O0();
    }
}
