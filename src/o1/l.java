package O1;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import com.android.incallui.BR;
import com.android.incallui.R;
import com.android.incallui.oplus.answerview.protocol.AnswerDialogBtnBehavior;
import com.android.incallui.oplus.answerview.protocol.DeclineBtnBehavior;
import com.android.incallui.oplus.answerview.protocol.VideoAnswerBtnBehavior;
import com.android.incallui.oplus.answerview.protocol.VoiceAnswerBtnBehavior;
import com.android.incallui.oplus.answerview.protocol.VoiceGuideViewBehavior;
import com.android.incallui.oplus.answerview.view.AnswerMethodDialogButton;
import com.android.incallui.oplus.answerview.view.FlingUpAnswerMethodLayout;
import com.android.incallui.oplus.answerview.view.GuideAnimatorView;
import com.android.incallui.oplus.answerview.view.SwipeAnswerImageView;
import com.android.incallui.oplus.answerview.view_model.FlingUpAnswerMethodModel;

/* compiled from: IncallFlingUpAnswerMethodBindingImpl.java */
/* loaded from: classes.dex */
public class l extends k {

    /* renamed from: T, reason: collision with root package name */
    public static final ViewDataBinding.i f2594T = null;

    /* renamed from: U, reason: collision with root package name */
    public static final SparseIntArray f2595U;

    /* renamed from: S, reason: collision with root package name */
    public long f2596S;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f2595U = sparseIntArray;
        sparseIntArray.put(R.id.decline_guide_view, 9);
        sparseIntArray.put(R.id.video_guide_view, 10);
    }

    public l(androidx.databinding.f fVar, View view) {
        this(fVar, view, ViewDataBinding.R0(fVar, view, 11, f2594T, f2595U));
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x012b  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void A0() {
        /*
            Method dump skipped, instructions count: 458
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: O1.l.A0():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean M0() {
        synchronized (this) {
            try {
                if (this.f2596S != 0) {
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
            this.f2596S = 1024L;
        }
        W0();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean S0(int i10, Object obj, int i11) {
        switch (i10) {
            case 0:
                return p1((com.android.incallui.mvvm.utils.y) obj, i11);
            case 1:
                return o1((com.android.incallui.mvvm.utils.y) obj, i11);
            case 2:
                return m1((com.android.incallui.mvvm.utils.h) obj, i11);
            case 3:
                return s1((com.android.incallui.mvvm.utils.y) obj, i11);
            case 4:
                return l1((com.android.incallui.mvvm.utils.y) obj, i11);
            case 5:
                return n1((com.android.incallui.mvvm.utils.y) obj, i11);
            case 6:
                return r1((com.android.incallui.mvvm.utils.y) obj, i11);
            case 7:
                return q1((com.android.incallui.mvvm.utils.y) obj, i11);
            case 8:
                return t1((com.android.incallui.mvvm.utils.y) obj, i11);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean d1(int i10, Object obj) {
        if (BR.mFlingUpAnswerMethodModel == i10) {
            k1((FlingUpAnswerMethodModel) obj);
            return true;
        }
        return false;
    }

    @Override // O1.k
    public void k1(FlingUpAnswerMethodModel flingUpAnswerMethodModel) {
        this.f2593R = flingUpAnswerMethodModel;
        synchronized (this) {
            this.f2596S |= 512;
        }
        r0(BR.mFlingUpAnswerMethodModel);
        super.W0();
    }

    public final boolean l1(com.android.incallui.mvvm.utils.y<AnswerDialogBtnBehavior> yVar, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2596S |= 16;
            }
            return true;
        }
        return false;
    }

    public final boolean m1(com.android.incallui.mvvm.utils.h<Boolean> hVar, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2596S |= 4;
            }
            return true;
        }
        return false;
    }

    public final boolean n1(com.android.incallui.mvvm.utils.y<Integer> yVar, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2596S |= 32;
            }
            return true;
        }
        return false;
    }

    public final boolean o1(com.android.incallui.mvvm.utils.y<Integer> yVar, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2596S |= 2;
            }
            return true;
        }
        return false;
    }

    public final boolean p1(com.android.incallui.mvvm.utils.y<DeclineBtnBehavior> yVar, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2596S |= 1;
            }
            return true;
        }
        return false;
    }

    public final boolean q1(com.android.incallui.mvvm.utils.y<VideoAnswerBtnBehavior> yVar, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2596S |= 128;
            }
            return true;
        }
        return false;
    }

    public final boolean r1(com.android.incallui.mvvm.utils.y<Integer> yVar, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2596S |= 64;
            }
            return true;
        }
        return false;
    }

    public final boolean s1(com.android.incallui.mvvm.utils.y<VoiceAnswerBtnBehavior> yVar, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2596S |= 8;
            }
            return true;
        }
        return false;
    }

    public final boolean t1(com.android.incallui.mvvm.utils.y<VoiceGuideViewBehavior> yVar, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2596S |= 256;
            }
            return true;
        }
        return false;
    }

    public l(androidx.databinding.f fVar, View view, Object[] objArr) {
        super(fVar, view, 9, (FlingUpAnswerMethodLayout) objArr[0], (SwipeAnswerImageView) objArr[2], (GuideAnimatorView) objArr[9], (AnswerMethodDialogButton) objArr[8], (LinearLayout) objArr[1], (LinearLayout) objArr[6], (SwipeAnswerImageView) objArr[7], (GuideAnimatorView) objArr[10], (LinearLayout) objArr[3], (SwipeAnswerImageView) objArr[5], (GuideAnimatorView) objArr[4]);
        this.f2596S = -1L;
        this.f2582G.setTag(null);
        this.f2583H.setTag(null);
        this.f2585J.setTag(null);
        this.f2586K.setTag(null);
        this.f2587L.setTag(null);
        this.f2588M.setTag(null);
        this.f2590O.setTag(null);
        this.f2591P.setTag(null);
        this.f2592Q.setTag(null);
        c1(view);
        O0();
    }
}
