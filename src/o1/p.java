package O1;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.android.incallui.BR;
import com.android.incallui.oplus.answerview.protocol.AnswerDialogBtnBehavior;
import com.android.incallui.oplus.answerview.protocol.DeclineBtnBehavior;
import com.android.incallui.oplus.answerview.protocol.VideoAnswerBtnBehavior;
import com.android.incallui.oplus.answerview.protocol.VoiceAnswerBtnBehavior;
import com.android.incallui.oplus.answerview.view.AnswerMethodDialogButton;
import com.android.incallui.oplus.answerview.view.StaticAnswerImageView;
import com.android.incallui.oplus.answerview.view.StaticAnswerMethodLayout;
import com.android.incallui.oplus.answerview.view_model.StaticAnswerMethodModel;

/* compiled from: IncallStaticAnswerMethodBindingImpl.java */
/* loaded from: classes.dex */
public class p extends o {

    /* renamed from: N, reason: collision with root package name */
    public static final ViewDataBinding.i f2615N = null;

    /* renamed from: O, reason: collision with root package name */
    public static final SparseIntArray f2616O = null;

    /* renamed from: M, reason: collision with root package name */
    public long f2617M;

    public p(androidx.databinding.f fVar, View view) {
        this(fVar, view, ViewDataBinding.R0(fVar, view, 5, f2615N, f2616O));
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0103  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void A0() {
        /*
            Method dump skipped, instructions count: 410
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: O1.p.A0():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean M0() {
        synchronized (this) {
            try {
                if (this.f2617M != 0) {
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
            this.f2617M = 512L;
        }
        W0();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean S0(int i10, Object obj, int i11) {
        switch (i10) {
            case 0:
                return r1((com.android.incallui.mvvm.utils.y) obj, i11);
            case 1:
                return s1((com.android.incallui.mvvm.utils.y) obj, i11);
            case 2:
                return m1((com.android.incallui.mvvm.utils.h) obj, i11);
            case 3:
                return p1((com.android.incallui.mvvm.utils.y) obj, i11);
            case 4:
                return q1((com.android.incallui.mvvm.utils.y) obj, i11);
            case 5:
                return l1((com.android.incallui.mvvm.utils.y) obj, i11);
            case 6:
                return o1((com.android.incallui.mvvm.utils.y) obj, i11);
            case 7:
                return n1((com.android.incallui.mvvm.utils.y) obj, i11);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean d1(int i10, Object obj) {
        if (BR.mStaticAnswerMethodModel == i10) {
            k1((StaticAnswerMethodModel) obj);
            return true;
        }
        return false;
    }

    @Override // O1.o
    public void k1(StaticAnswerMethodModel staticAnswerMethodModel) {
        this.f2614L = staticAnswerMethodModel;
        synchronized (this) {
            this.f2617M |= 256;
        }
        r0(BR.mStaticAnswerMethodModel);
        super.W0();
    }

    public final boolean l1(com.android.incallui.mvvm.utils.y<AnswerDialogBtnBehavior> yVar, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2617M |= 32;
            }
            return true;
        }
        return false;
    }

    public final boolean m1(com.android.incallui.mvvm.utils.h<Boolean> hVar, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2617M |= 4;
            }
            return true;
        }
        return false;
    }

    public final boolean n1(com.android.incallui.mvvm.utils.y<Integer> yVar, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2617M |= 128;
            }
            return true;
        }
        return false;
    }

    public final boolean o1(com.android.incallui.mvvm.utils.y<Integer> yVar, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2617M |= 64;
            }
            return true;
        }
        return false;
    }

    public final boolean p1(com.android.incallui.mvvm.utils.y<DeclineBtnBehavior> yVar, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2617M |= 8;
            }
            return true;
        }
        return false;
    }

    public final boolean q1(com.android.incallui.mvvm.utils.y<VideoAnswerBtnBehavior> yVar, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2617M |= 16;
            }
            return true;
        }
        return false;
    }

    public final boolean r1(com.android.incallui.mvvm.utils.y<Integer> yVar, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2617M |= 1;
            }
            return true;
        }
        return false;
    }

    public final boolean s1(com.android.incallui.mvvm.utils.y<VoiceAnswerBtnBehavior> yVar, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2617M |= 2;
            }
            return true;
        }
        return false;
    }

    public p(androidx.databinding.f fVar, View view, Object[] objArr) {
        super(fVar, view, 8, (StaticAnswerMethodLayout) objArr[0], (StaticAnswerImageView) objArr[1], (AnswerMethodDialogButton) objArr[4], (StaticAnswerImageView) objArr[3], (StaticAnswerImageView) objArr[2]);
        this.f2617M = -1L;
        this.f2609G.setTag(null);
        this.f2610H.setTag(null);
        this.f2611I.setTag(null);
        this.f2612J.setTag(null);
        this.f2613K.setTag(null);
        c1(view);
        O0();
    }
}
