package O1;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.android.incallui.BR;
import com.android.incallui.R;
import com.android.incallui.mvvm.view_model.BackgroundViewModel;
import com.android.incallui.mvvm.view_model.OplusInCallViewModel;

/* compiled from: OplusIncallScreenBindingImpl.java */
/* loaded from: classes.dex */
public class J extends I {

    /* renamed from: Q, reason: collision with root package name */
    public static final ViewDataBinding.i f2523Q = null;

    /* renamed from: R, reason: collision with root package name */
    public static final SparseIntArray f2524R;

    /* renamed from: P, reason: collision with root package name */
    public long f2525P;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f2524R = sparseIntArray;
        sparseIntArray.put(R.id.video_show_frame_layout, 3);
        sparseIntArray.put(R.id.fl_screen_background, 4);
        sparseIntArray.put(R.id.vp_screen_center, 5);
        sparseIntArray.put(R.id.vp_screen_bottom, 6);
    }

    public J(androidx.databinding.f fVar, View view) {
        this(fVar, view, ViewDataBinding.R0(fVar, view, 7, f2523Q, f2524R));
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005b  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void A0() {
        /*
            Method dump skipped, instructions count: 200
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: O1.J.A0():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean M0() {
        synchronized (this) {
            try {
                if (this.f2525P != 0) {
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
            this.f2525P = 64L;
        }
        W0();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean S0(int i10, Object obj, int i11) {
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        return false;
                    }
                    return p1((com.android.incallui.mvvm.utils.y) obj, i11);
                }
                return n1((com.android.incallui.mvvm.utils.y) obj, i11);
            }
            return o1((com.android.incallui.mvvm.utils.y) obj, i11);
        }
        return m1((com.android.incallui.mvvm.utils.y) obj, i11);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean d1(int i10, Object obj) {
        if (BR.mBackgroundViewModel == i10) {
            k1((BackgroundViewModel) obj);
        } else if (BR.mViewModel == i10) {
            l1((OplusInCallViewModel) obj);
        } else {
            return false;
        }
        return true;
    }

    @Override // O1.I
    public void k1(BackgroundViewModel backgroundViewModel) {
        this.f2522O = backgroundViewModel;
        synchronized (this) {
            this.f2525P |= 16;
        }
        r0(BR.mBackgroundViewModel);
        super.W0();
    }

    @Override // O1.I
    public void l1(OplusInCallViewModel oplusInCallViewModel) {
        this.f2521N = oplusInCallViewModel;
        synchronized (this) {
            this.f2525P |= 32;
        }
        r0(BR.mViewModel);
        super.W0();
    }

    public final boolean m1(com.android.incallui.mvvm.utils.y<Drawable> yVar, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2525P |= 1;
            }
            return true;
        }
        return false;
    }

    public final boolean n1(com.android.incallui.mvvm.utils.y<ColorDrawable> yVar, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2525P |= 4;
            }
            return true;
        }
        return false;
    }

    public final boolean o1(com.android.incallui.mvvm.utils.y<Drawable> yVar, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2525P |= 2;
            }
            return true;
        }
        return false;
    }

    public final boolean p1(com.android.incallui.mvvm.utils.y<Integer> yVar, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2525P |= 8;
            }
            return true;
        }
        return false;
    }

    public J(androidx.databinding.f fVar, View view, Object[] objArr) {
        super(fVar, view, 4, (ConstraintLayout) objArr[0], (FrameLayout) objArr[4], (ImageView) objArr[1], (FrameLayout) objArr[3], (FrameLayout) objArr[6], (FrameLayout) objArr[5], (FrameLayout) objArr[2]);
        this.f2525P = -1L;
        this.f2514G.setTag(null);
        this.f2516I.setTag(null);
        this.f2520M.setTag(null);
        c1(view);
        O0();
    }
}
