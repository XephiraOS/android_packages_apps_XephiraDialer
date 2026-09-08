package com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel;

import android.util.Log;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.LiveData;
import com.android.incallui.Call;
import com.android.incallui.InCallPresenter;
import com.android.incallui.clean.domain.interactor.LocalObservableField;
import com.android.incallui.clean.domain.interactor.NonNullObservableField;
import com.android.incallui.clean.domain.interactor.UseCase0;
import com.android.incallui.clean.domain.interactor.UseCase1;
import com.android.incallui.clean.domain.interactor.e;
import kotlin.Pair;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import m9.q;
import q2.C1481a;
import v9.l;

/* compiled from: FloatingWindowCommandViewModel.kt */
/* loaded from: classes.dex */
public final class FloatingWindowCommandViewModel extends c implements q2.c {

    /* renamed from: t, reason: collision with root package name */
    public static final a f18981t = new a(null);

    /* renamed from: j, reason: collision with root package name */
    public final LocalObservableField<q> f18982j;

    /* renamed from: k, reason: collision with root package name */
    public final LocalObservableField<q> f18983k;

    /* renamed from: l, reason: collision with root package name */
    public final LocalObservableField<q> f18984l;

    /* renamed from: m, reason: collision with root package name */
    public final LocalObservableField<q> f18985m;

    /* renamed from: n, reason: collision with root package name */
    public final LocalObservableField<q> f18986n;

    /* renamed from: o, reason: collision with root package name */
    public final LocalObservableField<q> f18987o;

    /* renamed from: p, reason: collision with root package name */
    public final LocalObservableField<q> f18988p;

    /* renamed from: q, reason: collision with root package name */
    public final LocalObservableField<q> f18989q;

    /* renamed from: r, reason: collision with root package name */
    public final NonNullObservableField<q> f18990r;

    /* renamed from: s, reason: collision with root package name */
    public final LocalObservableField<q> f18991s;

    /* compiled from: FloatingWindowCommandViewModel.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FloatingWindowCommandViewModel(final b eventBus) {
        super("FloatingWindowCommandViewModel", eventBus);
        i.f(eventBus, "eventBus");
        this.f18982j = new LocalObservableField<>(new androidx.databinding.i[]{p().m()}, new l<Boolean, q>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.FloatingWindowCommandViewModel$updateFocusWindowType$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ q invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return q.f35511a;
            }

            public final void invoke(boolean z10) {
                Integer s02 = FloatingWindowCommandViewModel.this.p().m().s0();
                if (s02 != null) {
                    eventBus.d().x0(s02);
                }
            }
        });
        this.f18983k = new LocalObservableField<>(new androidx.databinding.i[]{n().e()}, new l<Boolean, q>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.FloatingWindowCommandViewModel$registerHomeReceiver$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ q invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return q.f35511a;
            }

            public final void invoke(boolean z10) {
                if (FloatingWindowCommandViewModel.this.n().e().s0().isIncoming()) {
                    UseCase0.e(FloatingWindowCommandViewModel.this.p().f(), eventBus.b(), null, 2, null);
                }
            }
        });
        this.f18984l = new LocalObservableField<>(new LiveData[]{n().j()}, new ObservableBoolean[]{o().c()}, new l<Boolean, q>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.FloatingWindowCommandViewModel$updateContactInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ q invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return q.f35511a;
            }

            public final void invoke(boolean z10) {
                UseCase1.e(FloatingWindowCommandViewModel.this.o().l(), FloatingWindowCommandViewModel.this.n().j().getValue(), eventBus.b(), null, 4, null);
            }
        });
        this.f18985m = new LocalObservableField<>((LiveData<?>[]) new LiveData[]{n().f()}, new l<Boolean, q>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.FloatingWindowCommandViewModel$updateNotification$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ q invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return q.f35511a;
            }

            public final void invoke(boolean z10) {
                Pair<Call, InCallPresenter.InCallState> value = FloatingWindowCommandViewModel.this.n().f().getValue();
                Call c10 = value != null ? value.c() : null;
                Pair<Call, InCallPresenter.InCallState> value2 = FloatingWindowCommandViewModel.this.n().f().getValue();
                InCallPresenter.InCallState d10 = value2 != null ? value2.d() : null;
                if (c10 == null) {
                    return;
                }
                if ((d10 == null || !d10.isIncoming()) && (d10 == null || !d10.isDialing())) {
                    return;
                }
                UseCase1.e(FloatingWindowCommandViewModel.this.p().k(), c10, eventBus.b(), null, 4, null);
            }
        });
        this.f18986n = new LocalObservableField<>((LiveData<?>[]) new LiveData[]{n().f()}, new l<Boolean, q>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.FloatingWindowCommandViewModel$updateCallTimer$1
            {
                super(1);
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ q invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return q.f35511a;
            }

            public final void invoke(boolean z10) {
                Pair<Call, InCallPresenter.InCallState> value = FloatingWindowCommandViewModel.this.n().f().getValue();
                Call c10 = value != null ? value.c() : null;
                Pair<Call, InCallPresenter.InCallState> value2 = FloatingWindowCommandViewModel.this.n().f().getValue();
                InCallPresenter.InCallState d10 = value2 != null ? value2.d() : null;
                if (d10 == InCallPresenter.InCallState.INCALL && c10 != null && c10.isActive()) {
                    FloatingWindowCommandViewModel.this.n().r().b();
                } else if (d10 == InCallPresenter.InCallState.NO_CALLS) {
                    FloatingWindowCommandViewModel.this.n().h().b();
                } else {
                    FloatingWindowCommandViewModel.this.n().t().b();
                }
            }
        });
        this.f18987o = new LocalObservableField<>(new androidx.databinding.i[]{n().e()}, new l<Boolean, q>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.FloatingWindowCommandViewModel$showNumberMarkView$1
            {
                super(1);
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ q invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return q.f35511a;
            }

            public final void invoke(boolean z10) {
                if (FloatingWindowCommandViewModel.this.n().e().s0() == InCallPresenter.InCallState.NO_CALLS) {
                    FloatingWindowCommandViewModel.this.p().i().b();
                }
            }
        });
        this.f18988p = new LocalObservableField<>(new LiveData[]{n().j(), r().r(), d().d()}, new LocalObservableField[]{eventBus.d()}, new l<Boolean, q>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.FloatingWindowCommandViewModel$updatePSensor$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ q invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return q.f35511a;
            }

            public final void invoke(boolean z10) {
                UseCase0.e(FloatingWindowCommandViewModel.this.p().l(), eventBus.b(), null, 2, null);
            }
        });
        this.f18989q = new LocalObservableField<>((LiveData<?>[]) new LiveData[]{n().f()}, new l<Boolean, q>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.FloatingWindowCommandViewModel$startRinging$1
            {
                super(1);
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ q invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return q.f35511a;
            }

            public final void invoke(boolean z10) {
                Pair<Call, InCallPresenter.InCallState> value = FloatingWindowCommandViewModel.this.n().f().getValue();
                Call c10 = value != null ? value.c() : null;
                Pair<Call, InCallPresenter.InCallState> value2 = FloatingWindowCommandViewModel.this.n().f().getValue();
                InCallPresenter.InCallState d10 = value2 != null ? value2.d() : null;
                if (c10 == null || d10 != InCallPresenter.InCallState.INCOMING || FloatingWindowCommandViewModel.this.p().q()) {
                    return;
                }
                FloatingWindowCommandViewModel.this.n().s().a(c10, 0, "FloatingWindow");
            }
        });
        this.f18990r = new NonNullObservableField<>((LiveData<?>[]) new LiveData[]{n().f()}, new l<Boolean, q>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.FloatingWindowCommandViewModel$shouldShowPrimaryVerification$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ q invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return q.f35511a;
            }

            public final void invoke(boolean z10) {
                Pair<Call, InCallPresenter.InCallState> value = FloatingWindowCommandViewModel.this.n().f().getValue();
                Call c10 = value != null ? value.c() : null;
                Pair<Call, InCallPresenter.InCallState> value2 = FloatingWindowCommandViewModel.this.n().f().getValue();
                eventBus.g().x0(Boolean.valueOf(FloatingWindowCommandViewModel.this.n().x(c10, value2 != null ? value2.d() : null)));
            }
        });
        this.f18991s = new LocalObservableField<>((LiveData<?>[]) new LiveData[]{n().f()}, new l<Boolean, q>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.FloatingWindowCommandViewModel$autoTurnOnSpeaker$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ q invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return q.f35511a;
            }

            public final void invoke(boolean z10) {
                Pair<Call, InCallPresenter.InCallState> value = FloatingWindowCommandViewModel.this.n().f().getValue();
                Call c10 = value != null ? value.c() : null;
                Pair<Call, InCallPresenter.InCallState> value2 = FloatingWindowCommandViewModel.this.n().f().getValue();
                InCallPresenter.InCallState d10 = value2 != null ? value2.d() : null;
                if (d10 == null || !d10.isDialing() || c10 == null || !c10.needTurnOnSpeaker()) {
                    return;
                }
                e.d(FloatingWindowCommandViewModel.this.d().c(), c10, Boolean.TRUE, eventBus.b(), null, 8, null);
            }
        });
    }

    @Override // q2.c
    public void a() {
        n().i().b();
    }

    @Override // q2.c
    public void b() {
        UseCase0.e(d().g(), t().b(), null, 2, null);
    }

    @Override // q2.c
    public void c() {
        d().h().b();
    }

    @Override // q2.c
    public void e() {
        n().k().b();
    }

    @Override // q2.c
    public void f(C1481a anim) {
        i.f(anim, "anim");
        t().e().x0(anim);
    }

    @Override // q2.c
    public void g(boolean z10, Integer num) {
        if (p().p(num, z10)) {
            return;
        }
        t().c().t0(!t().c().s0());
        d().e().b(num);
        n().c().b(Boolean.valueOf(z10));
        e.d(q().b(), t().d().s0(), Boolean.valueOf(z10), t().b(), null, 8, null);
        if (p().r()) {
            l();
        }
    }

    @Override // q2.c
    public void h(q2.b bVar, Integer num) {
        if (bVar != null) {
            bVar.b(this, num);
        }
    }

    @Override // q2.c
    public void i(float f10) {
        t().f().x0(Float.valueOf(f10));
    }

    @Override // q2.c
    public void j() {
        d().i().b();
        e.d(q().e(), t().d().s0(), d().f().b(), t().b(), null, 8, null);
    }

    @Override // q2.c
    public void k(Integer num) {
        if (p().p(num, false)) {
            return;
        }
        d().e().b(num);
        n().c().b(Boolean.FALSE);
    }

    @Override // q2.c
    public void l() {
        Log.d("FloatingWindowCommandViewModel", "switchToInCallActivity: ");
        t().a().l();
    }

    @Override // q2.c
    public void m() {
        Log.d("FloatingWindowCommandViewModel", "flingHideFloatingWindow: ");
        t().a().A(2);
    }

    @Override // com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.c
    public void u() {
        super.u();
        o().b().b();
        UseCase0.e(p().e(), t().b(), null, 2, null);
    }

    @Override // com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.c
    public void v() {
        super.v();
        o().h().b();
        this.f18982j.close();
        this.f18990r.close();
        this.f18983k.close();
        this.f18984l.close();
        this.f18985m.close();
        this.f18986n.close();
        this.f18987o.close();
        this.f18988p.close();
        this.f18989q.close();
        this.f18991s.close();
    }
}
