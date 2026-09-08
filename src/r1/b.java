package R1;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.v;
import com.android.incallui.foldscreen.presentation.view.FlingUpAnswerMethodFoldLayout;
import com.android.incallui.foldscreen.presentation.viewmodel.FoldScreenCallButtonViewModel;
import com.android.incallui.oplus.answerview.protocol.AnswerDialogBtnBehavior;
import com.android.incallui.oplus.answerview.protocol.DeclineBtnBehavior;
import com.android.incallui.oplus.answerview.protocol.VoiceAnswerBtnBehavior;
import com.android.incallui.oplus.answerview.view.AnswerMethodDialogButton;
import com.android.incallui.oplus.answerview.view.GuideAnimatorView;
import com.android.incallui.oplus.answerview.view.SwipeAnswerImageView;
import g2.InterfaceC1034a;

/* compiled from: FoldAnswerButtonLayoutBindingImpl.java */
/* loaded from: classes.dex */
public class b extends a {

    /* renamed from: R, reason: collision with root package name */
    public static final ViewDataBinding.i f3264R = null;

    /* renamed from: S, reason: collision with root package name */
    public static final SparseIntArray f3265S;

    /* renamed from: P, reason: collision with root package name */
    public final FlingUpAnswerMethodFoldLayout f3266P;

    /* renamed from: Q, reason: collision with root package name */
    public long f3267Q;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f3265S = sparseIntArray;
        sparseIntArray.put(P1.d.f2847f, 4);
        sparseIntArray.put(P1.d.f2845d, 5);
        sparseIntArray.put(P1.d.f2850i, 6);
        sparseIntArray.put(P1.d.f2852k, 7);
    }

    public b(androidx.databinding.f fVar, View view) {
        this(fVar, view, ViewDataBinding.R0(fVar, view, 8, f3264R, f3265S));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void A0() {
        long j10;
        Boolean bool;
        VoiceAnswerBtnBehavior voiceAnswerBtnBehavior;
        AnswerDialogBtnBehavior answerDialogBtnBehavior;
        DeclineBtnBehavior declineBtnBehavior;
        v<Boolean> vVar;
        synchronized (this) {
            j10 = this.f3267Q;
            this.f3267Q = 0L;
        }
        InterfaceC1034a interfaceC1034a = this.f3263O;
        FoldScreenCallButtonViewModel foldScreenCallButtonViewModel = this.f3262N;
        long j11 = 10 & j10;
        long j12 = 13 & j10;
        DeclineBtnBehavior declineBtnBehavior2 = null;
        Boolean bool2 = null;
        if (j12 != 0) {
            if ((j10 & 12) != 0 && foldScreenCallButtonViewModel != null) {
                voiceAnswerBtnBehavior = foldScreenCallButtonViewModel.x();
                answerDialogBtnBehavior = foldScreenCallButtonViewModel.v();
                declineBtnBehavior = foldScreenCallButtonViewModel.w();
            } else {
                voiceAnswerBtnBehavior = null;
                answerDialogBtnBehavior = null;
                declineBtnBehavior = null;
            }
            if (foldScreenCallButtonViewModel != null) {
                vVar = foldScreenCallButtonViewModel.C();
            } else {
                vVar = null;
            }
            f1(0, vVar);
            if (vVar != null) {
                bool2 = vVar.getValue();
            }
            bool = bool2;
            declineBtnBehavior2 = declineBtnBehavior;
        } else {
            bool = null;
            voiceAnswerBtnBehavior = null;
            answerDialogBtnBehavior = null;
        }
        if ((j10 & 12) != 0) {
            com.android.incallui.mvvm.utils.d.b(this.f3255G, declineBtnBehavior2);
            com.android.incallui.mvvm.utils.d.b(this.f3257I, answerDialogBtnBehavior);
            com.android.incallui.mvvm.utils.d.b(this.f3260L, voiceAnswerBtnBehavior);
        }
        if (j12 != 0) {
            Z1.b.e(this.f3266P, bool);
        }
        if (j11 != 0) {
            Z1.b.l(this.f3266P, interfaceC1034a);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean M0() {
        synchronized (this) {
            try {
                if (this.f3267Q != 0) {
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
            this.f3267Q = 8L;
        }
        W0();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean S0(int i10, Object obj, int i11) {
        if (i10 != 0) {
            return false;
        }
        return i1((v) obj, i11);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean d1(int i10, Object obj) {
        if (P1.a.f2823b == i10) {
            j1((InterfaceC1034a) obj);
        } else if (P1.a.f2824c == i10) {
            k1((FoldScreenCallButtonViewModel) obj);
        } else {
            return false;
        }
        return true;
    }

    public final boolean i1(v<Boolean> vVar, int i10) {
        if (i10 == P1.a.f2822a) {
            synchronized (this) {
                this.f3267Q |= 1;
            }
            return true;
        }
        return false;
    }

    public void j1(InterfaceC1034a interfaceC1034a) {
        this.f3263O = interfaceC1034a;
        synchronized (this) {
            this.f3267Q |= 2;
        }
        r0(P1.a.f2823b);
        super.W0();
    }

    public void k1(FoldScreenCallButtonViewModel foldScreenCallButtonViewModel) {
        this.f3262N = foldScreenCallButtonViewModel;
        synchronized (this) {
            this.f3267Q |= 4;
        }
        r0(P1.a.f2824c);
        super.W0();
    }

    public b(androidx.databinding.f fVar, View view, Object[] objArr) {
        super(fVar, view, 1, (SwipeAnswerImageView) objArr[1], (GuideAnimatorView) objArr[5], (AnswerMethodDialogButton) objArr[3], (LinearLayout) objArr[4], (LinearLayout) objArr[6], (SwipeAnswerImageView) objArr[2], (GuideAnimatorView) objArr[7]);
        this.f3267Q = -1L;
        this.f3255G.setTag(null);
        this.f3257I.setTag(null);
        this.f3260L.setTag(null);
        FlingUpAnswerMethodFoldLayout flingUpAnswerMethodFoldLayout = (FlingUpAnswerMethodFoldLayout) objArr[0];
        this.f3266P = flingUpAnswerMethodFoldLayout;
        flingUpAnswerMethodFoldLayout.setTag(null);
        c1(view);
        O0();
    }
}
