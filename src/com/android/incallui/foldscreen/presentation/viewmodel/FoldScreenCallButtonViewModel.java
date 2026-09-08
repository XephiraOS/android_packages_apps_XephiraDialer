package com.android.incallui.foldscreen.presentation.viewmodel;

import D2.g;
import android.os.SystemClock;
import androidx.lifecycle.J;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.v;
import com.android.incallui.Call;
import com.android.incallui.Log;
import com.android.incallui.R;
import com.android.incallui.clean.domain.interactor.LocalObservableField;
import com.android.incallui.clean.domain.interactor.UseCase1;
import com.android.incallui.oplus.answerview.protocol.AnswerDialogBtnBehavior;
import com.android.incallui.oplus.answerview.protocol.DeclineBtnBehavior;
import com.android.incallui.oplus.answerview.protocol.VoiceAnswerBtnBehavior;
import d.InterfaceC0944a;
import java.util.ArrayList;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import m9.q;
import v9.l;

/* compiled from: FoldScreenCallButtonViewModel.kt */
/* loaded from: classes.dex */
public final class FoldScreenCallButtonViewModel extends FoldScreenBaseViewModel {

    /* renamed from: y, reason: collision with root package name */
    public static final a f18477y = new a(null);

    /* renamed from: i, reason: collision with root package name */
    public final v<Boolean> f18478i;

    /* renamed from: j, reason: collision with root package name */
    public final v<Integer> f18479j;

    /* renamed from: k, reason: collision with root package name */
    public final v<Integer> f18480k;

    /* renamed from: l, reason: collision with root package name */
    public final v<Boolean> f18481l;

    /* renamed from: m, reason: collision with root package name */
    public final v<Integer> f18482m;

    /* renamed from: n, reason: collision with root package name */
    public final v<Integer> f18483n;

    /* renamed from: o, reason: collision with root package name */
    public final v<Boolean> f18484o;

    /* renamed from: p, reason: collision with root package name */
    public final LocalObservableField<q> f18485p;

    /* renamed from: q, reason: collision with root package name */
    public final VoiceAnswerBtnBehavior f18486q;

    /* renamed from: r, reason: collision with root package name */
    public final DeclineBtnBehavior f18487r;

    /* renamed from: x, reason: collision with root package name */
    public final AnswerDialogBtnBehavior f18488x;

    /* compiled from: FoldScreenCallButtonViewModel.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @InterfaceC0944a
    public FoldScreenCallButtonViewModel(Y1.a useCaseProvider) {
        super(useCaseProvider);
        i.f(useCaseProvider, "useCaseProvider");
        this.f18478i = j().w();
        this.f18479j = new v<>(8);
        this.f18480k = new v<>(8);
        this.f18481l = new v<>(Boolean.TRUE);
        this.f18482m = new v<>(8);
        this.f18483n = new v<>();
        this.f18484o = new v<>(Boolean.FALSE);
        this.f18485p = new LocalObservableField<>((LiveData<?>[]) new LiveData[]{j().w(), j().y(), j().x()}, new l<Boolean, q>() { // from class: com.android.incallui.foldscreen.presentation.viewmodel.FoldScreenCallButtonViewModel$onCallButtonChange$1
            {
                super(1);
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ q invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return q.f35511a;
            }

            public final void invoke(boolean z10) {
                Boolean value = FoldScreenCallButtonViewModel.this.j().y().getValue();
                Boolean value2 = FoldScreenCallButtonViewModel.this.j().w().getValue();
                Boolean value3 = FoldScreenCallButtonViewModel.this.j().x().getValue();
                Log.d("FoldScreenCallButtonViewModel", "onCallButtonChange : " + value2 + ", isVideoCall : " + value + ", isDisconnecting : " + value3);
                Boolean bool = Boolean.TRUE;
                if (i.b(value3, bool)) {
                    FoldScreenCallButtonViewModel.this.F();
                    return;
                }
                if (i.b(value2, bool) && i.b(value, bool)) {
                    FoldScreenCallButtonViewModel.this.I();
                    return;
                }
                if (i.b(value2, bool) && i.b(value, Boolean.FALSE)) {
                    FoldScreenCallButtonViewModel.this.K();
                    return;
                }
                Boolean bool2 = Boolean.FALSE;
                if (i.b(value2, bool2) && i.b(value, bool)) {
                    FoldScreenCallButtonViewModel.this.H();
                } else if (i.b(value2, bool2) && i.b(value, bool2)) {
                    FoldScreenCallButtonViewModel.this.J();
                }
            }
        });
        this.f18486q = VoiceAnswerBtnBehavior.f18759a;
        this.f18487r = DeclineBtnBehavior.f18747a;
        this.f18488x = AnswerDialogBtnBehavior.SMS_DECLINE_IN_NORMAL_MODE;
    }

    public final v<Integer> A() {
        return this.f18483n;
    }

    public final v<Integer> B() {
        return this.f18482m;
    }

    public final v<Boolean> C() {
        return this.f18478i;
    }

    public final void D(int i10, int i11) {
        Call b10 = j().j().b();
        if (b10 != null && !b10.getIsCdmaPhone()) {
            Call b11 = j().g().b();
            if (b11 != null) {
                j().s().b(Integer.valueOf(i10));
                j().d().b(b10, b11);
                return;
            }
            Call b12 = j().l().b(8, 0);
            Call b13 = j().l().b(8, 1);
            if (b12 != null && b13 != null) {
                if (Log.sDebug) {
                    Log.d("FoldScreenCallButtonViewModel", "onAnswer hasDoubleBackgroundCall ...");
                }
                j().s().b(Integer.valueOf(i10));
                j().d().b(b12, b13);
                return;
            }
            UseCase1.f(h().e(), Integer.valueOf(i11), J.a(this), null, 4, null);
            j().c().b(Integer.valueOf(i10));
            return;
        }
        UseCase1.f(h().e(), Integer.valueOf(i11), J.a(this), null, 4, null);
        j().c().b(Integer.valueOf(i10));
    }

    public final void E() {
        j().e().b(null);
    }

    public final void F() {
        this.f18479j.m(8);
        this.f18480k.m(8);
        this.f18482m.m(8);
    }

    public final void G() {
        j().u().b();
    }

    public final void H() {
        this.f18479j.m(8);
        this.f18480k.m(8);
        this.f18482m.m(0);
        this.f18483n.m(Integer.valueOf(R.string.fold_screen_continue_video_call));
        this.f18484o.m(Boolean.TRUE);
    }

    public final void I() {
        this.f18479j.m(8);
        this.f18480k.m(8);
        this.f18482m.m(0);
        this.f18483n.m(Integer.valueOf(R.string.fold_screen_answer_call));
        this.f18484o.m(Boolean.TRUE);
    }

    public final void J() {
        this.f18479j.m(8);
        this.f18480k.m(0);
        this.f18482m.m(8);
        this.f18481l.m(Boolean.TRUE);
    }

    public final void K() {
        this.f18479j.m(0);
        this.f18480k.m(8);
        this.f18482m.m(8);
    }

    @Override // androidx.lifecycle.I
    public void e() {
        super.e();
        this.f18485p.close();
    }

    public final void r() {
        if (Log.sDebug) {
            g.b("FoldScreenCallButtonViewModel", "EndCallButton click!!!");
        }
        if (j().i().b() != null) {
            if (Log.sDebug) {
                g.f("FoldScreenCallButtonViewModel", "EndCallButton click error, because a disconnecting Call exits, return!!!");
                return;
            }
            return;
        }
        boolean booleanValue = j().n().b().booleanValue();
        Call b10 = j().h().b();
        if (b10 != null && b10.isFakeAnswerState() && !booleanValue) {
            if (Log.sDebug) {
                g.b("FoldScreenCallButtonViewModel", "EndCallButton click, end call is fake answer state return!");
                return;
            }
            return;
        }
        if (b10 != null && (b10.getState() == 9 || b10.getState() == 10)) {
            if (Log.sDebug) {
                g.b("FoldScreenCallButtonViewModel", "EndCallButton click, canNotResposeEndClick return!");
                return;
            }
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - j().k().b().longValue();
        if (elapsedRealtime < 1500) {
            if (Log.sDebug) {
                g.b("FoldScreenCallButtonViewModel", "EndCallButton click, in caurd time return = " + elapsedRealtime);
                return;
            }
            return;
        }
        j().t().b(Long.valueOf(SystemClock.elapsedRealtime()));
        v<Boolean> vVar = this.f18481l;
        Boolean bool = Boolean.FALSE;
        vVar.m(bool);
        i().i().m(Boolean.TRUE);
        if (b10 != null && b10.isFakeAnswerState() && booleanValue) {
            if (Log.sDebug) {
                g.b("FoldScreenCallButtonViewModel", "use rejectCall instead of endCall when it is fake answer state and catch switch error!");
            }
            com.android.incallui.clean.domain.interactor.f<String, Boolean, String, q> r10 = j().r();
            String id = b10.getId();
            i.e(id, "currentCall.id");
            r10.a(id, bool, null);
            return;
        }
        j().p().b();
    }

    public final v<Integer> s() {
        return this.f18479j;
    }

    public final v<Integer> t() {
        return this.f18480k;
    }

    public final v<Boolean> u() {
        return this.f18481l;
    }

    public final AnswerDialogBtnBehavior v() {
        return this.f18488x;
    }

    public final DeclineBtnBehavior w() {
        return this.f18487r;
    }

    public final VoiceAnswerBtnBehavior x() {
        return this.f18486q;
    }

    public final ArrayList<String> y() {
        return j().m().b();
    }

    public final v<Boolean> z() {
        return this.f18484o;
    }
}
