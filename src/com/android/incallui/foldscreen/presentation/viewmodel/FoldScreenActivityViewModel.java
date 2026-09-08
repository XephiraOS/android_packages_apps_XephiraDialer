package com.android.incallui.foldscreen.presentation.viewmodel;

import android.telecom.CallAudioState;
import android.telecom.VideoProfile;
import androidx.lifecycle.J;
import androidx.lifecycle.LiveData;
import com.android.contacts.framework.virtualsupport.utils.GrpcUtils;
import com.android.incallui.Call;
import com.android.incallui.InCallPresenter;
import com.android.incallui.Log;
import com.android.incallui.clean.domain.bean.CallUiType;
import com.android.incallui.clean.domain.interactor.LocalObservableField;
import com.android.incallui.clean.domain.interactor.NonNullObservableField;
import com.android.incallui.clean.domain.interactor.UseCase0;
import com.android.incallui.clean.domain.interactor.UseCase1;
import com.android.incallui.foldscreen.presentation.controller.RespondViaSmsManager;
import d.InterfaceC0944a;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.E;
import kotlinx.coroutines.InterfaceC1265l0;
import kotlinx.coroutines.M;
import kotlinx.coroutines.S;
import m9.q;
import p9.C1467a;
import p9.InterfaceC1470d;
import v9.l;
import v9.p;

/* compiled from: FoldScreenActivityViewModel.kt */
/* loaded from: classes.dex */
public final class FoldScreenActivityViewModel extends FoldScreenBaseViewModel {

    /* renamed from: B, reason: collision with root package name */
    public static final a f18457B = new a(null);

    /* renamed from: A, reason: collision with root package name */
    public final LocalObservableField<q> f18458A;

    /* renamed from: i, reason: collision with root package name */
    public final NonNullObservableField<Boolean> f18459i;

    /* renamed from: j, reason: collision with root package name */
    public final NonNullObservableField<Boolean> f18460j;

    /* renamed from: k, reason: collision with root package name */
    public final NonNullObservableField<q> f18461k;

    /* renamed from: l, reason: collision with root package name */
    public S1.a f18462l;

    /* renamed from: m, reason: collision with root package name */
    public InterfaceC1265l0 f18463m;

    /* renamed from: n, reason: collision with root package name */
    public final LocalObservableField<q> f18464n;

    /* renamed from: o, reason: collision with root package name */
    public final LocalObservableField<q> f18465o;

    /* renamed from: p, reason: collision with root package name */
    public InterfaceC1265l0 f18466p;

    /* renamed from: q, reason: collision with root package name */
    public InterfaceC1265l0 f18467q;

    /* renamed from: r, reason: collision with root package name */
    public final AtomicBoolean f18468r;

    /* renamed from: x, reason: collision with root package name */
    public final AtomicBoolean f18469x;

    /* renamed from: y, reason: collision with root package name */
    public final LocalObservableField<q> f18470y;

    /* renamed from: z, reason: collision with root package name */
    public final AtomicBoolean f18471z;

    /* compiled from: FoldScreenActivityViewModel.kt */
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
    public FoldScreenActivityViewModel(Y1.a useCaseProvider) {
        super(useCaseProvider);
        i.f(useCaseProvider, "useCaseProvider");
        this.f18459i = new NonNullObservableField<>((LiveData<?>[]) new LiveData[]{k().b()}, new l<Boolean, Boolean>() { // from class: com.android.incallui.foldscreen.presentation.viewmodel.FoldScreenActivityViewModel$shouldKeepScreenOn$1
            {
                super(1);
            }

            public final Boolean b(boolean z10) {
                return Boolean.valueOf(i.b(FoldScreenActivityViewModel.this.k().b().getValue(), Boolean.TRUE));
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                return b(bool.booleanValue());
            }
        });
        this.f18460j = new NonNullObservableField<>(new androidx.databinding.i[]{i().d()}, new l<Boolean, Boolean>() { // from class: com.android.incallui.foldscreen.presentation.viewmodel.FoldScreenActivityViewModel$activityDestroyTrigger$1
            {
                super(1);
            }

            public final Boolean b(boolean z10) {
                boolean z11;
                if (FoldScreenActivityViewModel.this.i().d().s0() == CallUiType.TYPE_DEFAULT) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                return Boolean.valueOf(z11);
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                return b(bool.booleanValue());
            }
        });
        this.f18461k = new NonNullObservableField<>((LiveData<?>[]) new LiveData[]{i().c()}, new l<Boolean, q>() { // from class: com.android.incallui.foldscreen.presentation.viewmodel.FoldScreenActivityViewModel$autoCloseSmsRespondDialog$1
            {
                super(1);
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ q invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return q.f35511a;
            }

            public final void invoke(boolean z10) {
                InCallPresenter.InCallState value = FoldScreenActivityViewModel.this.i().c().getValue();
                if (value == null || !value.isIncoming()) {
                    RespondViaSmsManager.f18413a.k(false);
                }
            }
        });
        this.f18464n = new LocalObservableField<>((LiveData<?>[]) new LiveData[]{k().b(), i().c(), h().d()}, new l<Boolean, q>() { // from class: com.android.incallui.foldscreen.presentation.viewmodel.FoldScreenActivityViewModel$changeAudioRoute$1

            /* compiled from: FoldScreenActivityViewModel.kt */
            @InterfaceC1470d(c = "com.android.incallui.foldscreen.presentation.viewmodel.FoldScreenActivityViewModel$changeAudioRoute$1$1", f = "FoldScreenActivityViewModel.kt", l = {86}, m = "invokeSuspend")
            /* renamed from: com.android.incallui.foldscreen.presentation.viewmodel.FoldScreenActivityViewModel$changeAudioRoute$1$1, reason: invalid class name */
            /* loaded from: classes.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
                final /* synthetic */ long $delayTime;
                int label;
                final /* synthetic */ FoldScreenActivityViewModel this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(long j10, FoldScreenActivityViewModel foldScreenActivityViewModel, kotlin.coroutines.c<? super AnonymousClass1> cVar) {
                    super(2, cVar);
                    this.$delayTime = j10;
                    this.this$0 = foldScreenActivityViewModel;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
                    return new AnonymousClass1(this.$delayTime, this.this$0, cVar);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object c10;
                    c10 = kotlin.coroutines.intrinsics.b.c();
                    int i10 = this.label;
                    if (i10 != 0) {
                        if (i10 == 1) {
                            kotlin.b.b(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        kotlin.b.b(obj);
                        long j10 = this.$delayTime;
                        this.label = 1;
                        if (M.a(j10, this) == c10) {
                            return c10;
                        }
                    }
                    Log.d("FoldScreenActivityViewModel", "changeAudioRoute: turnOnSpeaker");
                    UseCase0.f(this.this$0.h().i(), J.a(this.this$0), null, 2, null);
                    return q.f35511a;
                }

                @Override // v9.p
                public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
                    return ((AnonymousClass1) create(e10, cVar)).invokeSuspend(q.f35511a);
                }
            }

            {
                super(1);
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ q invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return q.f35511a;
            }

            public final void invoke(boolean z10) {
                InterfaceC1265l0 d10;
                S1.a q10 = FoldScreenActivityViewModel.this.q();
                InCallPresenter.InCallState c10 = q10 != null ? q10.c() : null;
                if (!FoldScreenActivityViewModel.this.C()) {
                    Log.d("FoldScreenActivityViewModel", "changeAudioRoute: condition not change, ignore");
                    return;
                }
                if (!FoldScreenActivityViewModel.this.w()) {
                    Log.d("FoldScreenActivityViewModel", "changeAudioRoute: no need turnOnSpeaker anymore");
                    InterfaceC1265l0 t10 = FoldScreenActivityViewModel.this.t();
                    if (t10 != null) {
                        InterfaceC1265l0.a.a(t10, null, 1, null);
                        return;
                    }
                    return;
                }
                InterfaceC1265l0 t11 = FoldScreenActivityViewModel.this.t();
                if (t11 != null && !t11.X()) {
                    Log.d("FoldScreenActivityViewModel", "changeAudioRoute: delayTurnOnSpeakerJob is processing");
                    return;
                }
                long j10 = 1000;
                if (c10 != null && c10.isIncoming()) {
                    UseCase1<CallAudioState, Boolean> o10 = FoldScreenActivityViewModel.this.h().o();
                    S1.a q11 = FoldScreenActivityViewModel.this.q();
                    if (o10.b(q11 != null ? q11.b() : null).booleanValue()) {
                        j10 = GrpcUtils.CREATE_CHANNEL_TIME_OUT;
                    }
                }
                Log.d("FoldScreenActivityViewModel", "changeAudioRoute: delay " + j10 + " ms turnOnSpeaker");
                FoldScreenActivityViewModel foldScreenActivityViewModel = FoldScreenActivityViewModel.this;
                d10 = C1248i.d(J.a(foldScreenActivityViewModel), S.a(), null, new AnonymousClass1(j10, FoldScreenActivityViewModel.this, null), 2, null);
                foldScreenActivityViewModel.A(d10);
            }
        });
        this.f18465o = new LocalObservableField<>((LiveData<?>[]) new LiveData[]{k().b()}, new l<Boolean, q>() { // from class: com.android.incallui.foldscreen.presentation.viewmodel.FoldScreenActivityViewModel$updateInCallNotification$1
            {
                super(1);
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ q invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return q.f35511a;
            }

            public final void invoke(boolean z10) {
                FoldScreenActivityViewModel.this.i().h().b();
            }
        });
        this.f18468r = new AtomicBoolean(false);
        this.f18469x = new AtomicBoolean(false);
        this.f18470y = new LocalObservableField<>((LiveData<?>[]) new LiveData[]{k().b(), j().y()}, new l<Boolean, q>() { // from class: com.android.incallui.foldscreen.presentation.viewmodel.FoldScreenActivityViewModel$autoPauseOrResumeVideoCall$1

            /* compiled from: FoldScreenActivityViewModel.kt */
            @InterfaceC1470d(c = "com.android.incallui.foldscreen.presentation.viewmodel.FoldScreenActivityViewModel$autoPauseOrResumeVideoCall$1$1", f = "FoldScreenActivityViewModel.kt", l = {183}, m = "invokeSuspend")
            /* renamed from: com.android.incallui.foldscreen.presentation.viewmodel.FoldScreenActivityViewModel$autoPauseOrResumeVideoCall$1$1, reason: invalid class name */
            /* loaded from: classes.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
                int label;
                final /* synthetic */ FoldScreenActivityViewModel this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(FoldScreenActivityViewModel foldScreenActivityViewModel, kotlin.coroutines.c<? super AnonymousClass1> cVar) {
                    super(2, cVar);
                    this.this$0 = foldScreenActivityViewModel;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
                    return new AnonymousClass1(this.this$0, cVar);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object c10;
                    c10 = kotlin.coroutines.intrinsics.b.c();
                    int i10 = this.label;
                    if (i10 != 0) {
                        if (i10 == 1) {
                            kotlin.b.b(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        kotlin.b.b(obj);
                        this.label = 1;
                        if (M.a(500L, this) == c10) {
                            return c10;
                        }
                    }
                    Log.d("FoldScreenActivityViewModel", "autoPauseOrResumeVideoCall: pause video call");
                    this.this$0.j().q().b(C1467a.a(true));
                    this.this$0.x().set(true);
                    return q.f35511a;
                }

                @Override // v9.p
                public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
                    return ((AnonymousClass1) create(e10, cVar)).invokeSuspend(q.f35511a);
                }
            }

            /* compiled from: FoldScreenActivityViewModel.kt */
            @InterfaceC1470d(c = "com.android.incallui.foldscreen.presentation.viewmodel.FoldScreenActivityViewModel$autoPauseOrResumeVideoCall$1$2", f = "FoldScreenActivityViewModel.kt", l = {206}, m = "invokeSuspend")
            /* renamed from: com.android.incallui.foldscreen.presentation.viewmodel.FoldScreenActivityViewModel$autoPauseOrResumeVideoCall$1$2, reason: invalid class name */
            /* loaded from: classes.dex */
            public static final class AnonymousClass2 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
                int label;
                final /* synthetic */ FoldScreenActivityViewModel this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass2(FoldScreenActivityViewModel foldScreenActivityViewModel, kotlin.coroutines.c<? super AnonymousClass2> cVar) {
                    super(2, cVar);
                    this.this$0 = foldScreenActivityViewModel;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
                    return new AnonymousClass2(this.this$0, cVar);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object c10;
                    c10 = kotlin.coroutines.intrinsics.b.c();
                    int i10 = this.label;
                    if (i10 != 0) {
                        if (i10 == 1) {
                            kotlin.b.b(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        kotlin.b.b(obj);
                        this.label = 1;
                        if (M.a(500L, this) == c10) {
                            return c10;
                        }
                    }
                    Log.d("FoldScreenActivityViewModel", "autoPauseOrResumeVideoCall: resume video call");
                    this.this$0.j().q().b(C1467a.a(false));
                    this.this$0.x().set(false);
                    return q.f35511a;
                }

                @Override // v9.p
                public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
                    return ((AnonymousClass2) create(e10, cVar)).invokeSuspend(q.f35511a);
                }
            }

            {
                super(1);
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ q invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return q.f35511a;
            }

            public final void invoke(boolean z10) {
                InterfaceC1265l0 d10;
                InterfaceC1265l0 d11;
                Boolean value = FoldScreenActivityViewModel.this.k().b().getValue();
                Boolean bool = Boolean.TRUE;
                boolean b10 = i.b(value, bool);
                boolean compareAndSet = FoldScreenActivityViewModel.this.u().compareAndSet(!b10, b10);
                boolean b11 = i.b(FoldScreenActivityViewModel.this.j().y().getValue(), bool);
                boolean booleanValue = FoldScreenActivityViewModel.this.j().z().b().booleanValue();
                if (!b11) {
                    Log.d("FoldScreenActivityViewModel", "autoPauseOrResumeVideoCall: not video call, ignore");
                    InterfaceC1265l0 r10 = FoldScreenActivityViewModel.this.r();
                    if (r10 != null) {
                        InterfaceC1265l0.a.a(r10, null, 1, null);
                    }
                    InterfaceC1265l0 s10 = FoldScreenActivityViewModel.this.s();
                    if (s10 != null) {
                        InterfaceC1265l0.a.a(s10, null, 1, null);
                    }
                    FoldScreenActivityViewModel.this.x().set(false);
                    return;
                }
                if (!compareAndSet) {
                    Log.d("FoldScreenActivityViewModel", "autoPauseOrResumeVideoCall: fold condition not change, ignore");
                    return;
                }
                if (b10) {
                    InterfaceC1265l0 s11 = FoldScreenActivityViewModel.this.s();
                    if (s11 != null) {
                        InterfaceC1265l0.a.a(s11, null, 1, null);
                    }
                    if (booleanValue) {
                        Log.d("FoldScreenActivityViewModel", "autoPauseOrResumeVideoCall: video call has been paused, ignore");
                        return;
                    }
                    InterfaceC1265l0 r11 = FoldScreenActivityViewModel.this.r();
                    if (r11 != null && !r11.X()) {
                        Log.d("FoldScreenActivityViewModel", "autoPauseOrResumeVideoCall: delayPauseVideoJob is processing, ignore");
                        return;
                    }
                    FoldScreenActivityViewModel foldScreenActivityViewModel = FoldScreenActivityViewModel.this;
                    d11 = C1248i.d(J.a(foldScreenActivityViewModel), S.c(), null, new AnonymousClass1(FoldScreenActivityViewModel.this, null), 2, null);
                    foldScreenActivityViewModel.y(d11);
                    return;
                }
                InterfaceC1265l0 r12 = FoldScreenActivityViewModel.this.r();
                if (r12 != null) {
                    InterfaceC1265l0.a.a(r12, null, 1, null);
                }
                if (!booleanValue) {
                    Log.d("FoldScreenActivityViewModel", "autoPauseOrResumeVideoCall: video call has been resumed, ignore");
                    FoldScreenActivityViewModel.this.x().set(false);
                    return;
                }
                if (!FoldScreenActivityViewModel.this.x().get()) {
                    Log.d("FoldScreenActivityViewModel", "autoPauseOrResumeVideoCall: video call not paused by flipped action, ignore");
                    return;
                }
                InterfaceC1265l0 s12 = FoldScreenActivityViewModel.this.s();
                if (s12 != null && !s12.X()) {
                    Log.d("FoldScreenActivityViewModel", "autoPauseOrResumeVideoCall: delayResumeVideoJob is processing, ignore");
                    return;
                }
                FoldScreenActivityViewModel foldScreenActivityViewModel2 = FoldScreenActivityViewModel.this;
                d10 = C1248i.d(J.a(foldScreenActivityViewModel2), S.c(), null, new AnonymousClass2(FoldScreenActivityViewModel.this, null), 2, null);
                foldScreenActivityViewModel2.z(d10);
            }
        });
        this.f18471z = new AtomicBoolean(i.b(k().b().getValue(), Boolean.FALSE));
        this.f18458A = new LocalObservableField<>((LiveData<?>[]) new LiveData[]{k().b()}, new l<Boolean, q>() { // from class: com.android.incallui.foldscreen.presentation.viewmodel.FoldScreenActivityViewModel$answerCallWhenFoldFlat$1
            {
                super(1);
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ q invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return q.f35511a;
            }

            public final void invoke(boolean z10) {
                boolean b10 = i.b(FoldScreenActivityViewModel.this.k().b().getValue(), Boolean.FALSE);
                boolean compareAndSet = FoldScreenActivityViewModel.this.p().compareAndSet(!b10, b10);
                if (Log.sDebug) {
                    Log.d("FoldScreenActivityViewModel", "answerCallWhenFoldFlat: isFlatted = " + b10 + ", isConditionChange = " + compareAndSet);
                }
                if (b10 && compareAndSet) {
                    if (!FoldScreenActivityViewModel.this.l().b().b().booleanValue()) {
                        if (Log.sDebug) {
                            Log.d("FoldScreenActivityViewModel", "answerCallWhenFoldFlat: not allowed, ignore");
                            return;
                        }
                        return;
                    }
                    Call b11 = FoldScreenActivityViewModel.this.j().j().b();
                    if (b11 == null) {
                        if (Log.sDebug) {
                            Log.d("FoldScreenActivityViewModel", "answerCallWhenFoldFlat: no incoming call, ignore");
                        }
                    } else if (VideoProfile.isTransmissionEnabled(b11.getVideoState())) {
                        if (Log.sDebug) {
                            Log.d("FoldScreenActivityViewModel", "answerCallWhenFoldFlat: incoming call is video call, ignore");
                        }
                    } else {
                        if (Log.sDebug) {
                            Log.d("FoldScreenActivityViewModel", "answerCallWhenFoldFlat: answer incoming call");
                        }
                        FoldScreenActivityViewModel.this.j().c().b(0);
                    }
                }
            }
        });
    }

    public final void A(InterfaceC1265l0 interfaceC1265l0) {
        this.f18463m = interfaceC1265l0;
    }

    public final boolean B() {
        Call b10 = j().j().b();
        boolean z10 = false;
        if (b10 != null && b10.isNotShowInCallUIForIncoming()) {
            z10 = true;
        }
        return !z10;
    }

    public final boolean C() {
        boolean b10 = i.b(k().b().getValue(), Boolean.TRUE);
        InCallPresenter.InCallState value = i().c().getValue();
        CallAudioState value2 = h().d().getValue();
        int intValue = h().f().b().intValue();
        S1.a aVar = this.f18462l;
        this.f18462l = new S1.a(value, value2, intValue, b10);
        Log.d("FoldScreenActivityViewModel", "updateChangeAudioRouteCondition: isFlipped = " + b10 + ", inCallState = " + value + ", callAudioState = " + value2 + "callAudioRoute = " + intValue);
        return !i.b(aVar, r5);
    }

    @Override // androidx.lifecycle.I
    public void e() {
        super.e();
        this.f18459i.close();
        this.f18460j.close();
        this.f18464n.close();
        this.f18465o.close();
        this.f18470y.close();
        this.f18461k.close();
        this.f18458A.close();
    }

    public final void m() {
        UseCase0.f(l().a(), J.a(this), null, 2, null);
    }

    public final void n() {
        Log.d("FoldScreenActivityViewModel", "declineVideoUpgradeRequest: ");
        j().f().b();
    }

    public final NonNullObservableField<Boolean> o() {
        return this.f18460j;
    }

    public final AtomicBoolean p() {
        return this.f18471z;
    }

    public final S1.a q() {
        return this.f18462l;
    }

    public final InterfaceC1265l0 r() {
        return this.f18466p;
    }

    public final InterfaceC1265l0 s() {
        return this.f18467q;
    }

    public final InterfaceC1265l0 t() {
        return this.f18463m;
    }

    public final AtomicBoolean u() {
        return this.f18469x;
    }

    public final NonNullObservableField<Boolean> v() {
        return this.f18459i;
    }

    public final boolean w() {
        InCallPresenter.InCallState c10;
        S1.a aVar = this.f18462l;
        if (aVar == null || !aVar.d()) {
            return false;
        }
        if ((aVar.c() != InCallPresenter.InCallState.INCALL && ((c10 = aVar.c()) == null || !c10.isDialing())) || !j().o().b().booleanValue() || h().l().b(Integer.valueOf(aVar.a())).booleanValue() || h().j().b(Integer.valueOf(aVar.a())).booleanValue() || !h().k().b(Integer.valueOf(aVar.a())).booleanValue()) {
            return false;
        }
        return true;
    }

    public final AtomicBoolean x() {
        return this.f18468r;
    }

    public final void y(InterfaceC1265l0 interfaceC1265l0) {
        this.f18466p = interfaceC1265l0;
    }

    public final void z(InterfaceC1265l0 interfaceC1265l0) {
        this.f18467q = interfaceC1265l0;
    }
}
