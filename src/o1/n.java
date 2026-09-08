package O1;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.android.incallui.BR;
import com.android.incallui.R;
import com.android.incallui.oplus.answerview.protocol.RideModeAnswerViewBehavior;
import com.android.incallui.oplus.answerview.protocol.RideModeDeclineViewBehavior;
import com.android.incallui.oplus.answerview.view.GuideAnimatorView;
import com.android.incallui.oplus.answerview.view.RideModeAnswerMethodLayout;
import com.android.incallui.oplus.answerview.view.SwipeAnswerImageView;
import com.android.incallui.oplus.answerview.view_model.RideModeAnswerMethodModel;

/* compiled from: IncallRideModeAnswerMethodBindingImpl.java */
/* loaded from: classes.dex */
public class n extends m {

    /* renamed from: Q, reason: collision with root package name */
    public static final ViewDataBinding.i f2606Q = null;

    /* renamed from: R, reason: collision with root package name */
    public static final SparseIntArray f2607R;

    /* renamed from: P, reason: collision with root package name */
    public long f2608P;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f2607R = sparseIntArray;
        sparseIntArray.put(R.id.ride_mode_icon, 5);
        sparseIntArray.put(R.id.decline_guide_view, 6);
        sparseIntArray.put(R.id.answer_guide_view, 7);
    }

    public n(androidx.databinding.f fVar, View view) {
        this(fVar, view, ViewDataBinding.R0(fVar, view, 8, f2606Q, f2607R));
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x005a  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void A0() {
        /*
            Method dump skipped, instructions count: 275
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: O1.n.A0():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean M0() {
        synchronized (this) {
            try {
                if (this.f2608P != 0) {
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
            this.f2608P = 64L;
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
                            return false;
                        }
                        return o1((com.android.incallui.mvvm.utils.y) obj, i11);
                    }
                    return m1((com.android.incallui.mvvm.utils.y) obj, i11);
                }
                return p1((com.android.incallui.mvvm.utils.h) obj, i11);
            }
            return n1((com.android.incallui.mvvm.utils.y) obj, i11);
        }
        return l1((com.android.incallui.mvvm.utils.y) obj, i11);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean d1(int i10, Object obj) {
        if (BR.mRideModeAnswerMethodModel == i10) {
            k1((RideModeAnswerMethodModel) obj);
            return true;
        }
        return false;
    }

    @Override // O1.m
    public void k1(RideModeAnswerMethodModel rideModeAnswerMethodModel) {
        this.f2605O = rideModeAnswerMethodModel;
        synchronized (this) {
            this.f2608P |= 32;
        }
        r0(BR.mRideModeAnswerMethodModel);
        super.W0();
    }

    public final boolean l1(com.android.incallui.mvvm.utils.y<String> yVar, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2608P |= 1;
            }
            return true;
        }
        return false;
    }

    public final boolean m1(com.android.incallui.mvvm.utils.y<Integer> yVar, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2608P |= 8;
            }
            return true;
        }
        return false;
    }

    public final boolean n1(com.android.incallui.mvvm.utils.y<Integer> yVar, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2608P |= 2;
            }
            return true;
        }
        return false;
    }

    public final boolean o1(com.android.incallui.mvvm.utils.y<RideModeAnswerViewBehavior> yVar, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2608P |= 16;
            }
            return true;
        }
        return false;
    }

    public final boolean p1(com.android.incallui.mvvm.utils.h<RideModeDeclineViewBehavior> hVar, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2608P |= 4;
            }
            return true;
        }
        return false;
    }

    public n(androidx.databinding.f fVar, View view, Object[] objArr) {
        super(fVar, view, 5, (GuideAnimatorView) objArr[7], (GuideAnimatorView) objArr[6], (TextView) objArr[4], (SwipeAnswerImageView) objArr[3], (TextView) objArr[2], (SwipeAnswerImageView) objArr[1], (RideModeAnswerMethodLayout) objArr[0], (ImageView) objArr[5]);
        this.f2608P = -1L;
        this.f2599I.setTag(null);
        this.f2600J.setTag(null);
        this.f2601K.setTag(null);
        this.f2602L.setTag(null);
        this.f2603M.setTag(null);
        c1(view);
        O0();
    }
}
