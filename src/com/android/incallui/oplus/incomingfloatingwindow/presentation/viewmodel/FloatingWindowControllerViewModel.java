package com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel;

import android.view.WindowManager;
import androidx.lifecycle.LiveData;
import com.android.incallui.Call;
import com.android.incallui.Log;
import com.android.incallui.R;
import com.android.incallui.clean.domain.interactor.LocalObservableField;
import com.android.incallui.clean.domain.interactor.NonNullObservableField;
import com.android.incallui.clean.domain.interactor.UseCase0;
import com.android.incallui.clean.domain.interactor.UseCase1;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import q2.d;
import v9.l;

/* compiled from: FloatingWindowControllerViewModel.kt */
/* loaded from: classes.dex */
public final class FloatingWindowControllerViewModel extends com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.a {

    /* renamed from: k, reason: collision with root package name */
    public static final a f18992k = new a(null);

    /* renamed from: g, reason: collision with root package name */
    public final Executor f18993g;

    /* renamed from: h, reason: collision with root package name */
    public int f18994h;

    /* renamed from: i, reason: collision with root package name */
    public final NonNullObservableField<Boolean> f18995i;

    /* renamed from: j, reason: collision with root package name */
    public final NonNullObservableField<d> f18996j;

    /* compiled from: FloatingWindowControllerViewModel.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public FloatingWindowControllerViewModel(Executor executor) {
        i.f(executor, "executor");
        this.f18993g = executor;
        this.f18994h = 2;
        this.f18995i = new NonNullObservableField<>(new LiveData[]{n().j()}, new LocalObservableField[]{p().m()}, new l<Boolean, Boolean>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.FloatingWindowControllerViewModel$floatingWindowTrigger$1
            {
                super(1);
            }

            public final Boolean b(boolean z10) {
                boolean z11 = false;
                if (FloatingWindowControllerViewModel.this.p().m().s0() == null) {
                    FloatingWindowControllerViewModel.this.G(1);
                    Log.d("FloatingWindowControllerViewModel", "floatingWindowTrigger: windType not init, ignore");
                } else if (FloatingWindowControllerViewModel.this.n().j().getValue() == null) {
                    FloatingWindowControllerViewModel.this.G(1);
                    Log.d("FloatingWindowControllerViewModel", "floatingWindowTrigger: no focus call, ignore");
                } else if (FloatingWindowControllerViewModel.this.p().n()) {
                    FloatingWindowControllerViewModel.this.G(1);
                    Log.d("FloatingWindowControllerViewModel", "floatingWindowTrigger: activity isForeground, ignore");
                } else {
                    Log.d("FloatingWindowControllerViewModel", "floatingWindowTrigger: true");
                    z11 = true;
                }
                return Boolean.valueOf(z11);
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                return b(bool.booleanValue());
            }
        });
        this.f18996j = new NonNullObservableField<>(new androidx.databinding.i[]{p().m()}, new l<Boolean, d>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.FloatingWindowControllerViewModel$windowLayoutParams$1
            {
                super(1);
            }

            public final d b(boolean z10) {
                return FloatingWindowControllerViewModel.z(FloatingWindowControllerViewModel.this, null, 1, null);
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ d invoke(Boolean bool) {
                return b(bool.booleanValue());
            }
        });
    }

    public static /* synthetic */ d z(FloatingWindowControllerViewModel floatingWindowControllerViewModel, Integer num, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = null;
        }
        return floatingWindowControllerViewModel.y(num);
    }

    public final void A(int i10) {
        this.f18994h = i10;
        this.f18995i.x0(Boolean.FALSE);
        UseCase0.e(n().q(), this.f18993g, null, 2, null);
    }

    public final boolean B() {
        return this.f18995i.s0().booleanValue();
    }

    public final boolean C() {
        Call value = n().j().getValue();
        int intValue = r().r().getValue().intValue();
        Integer s02 = p().m().s0();
        boolean z10 = false;
        if (B() && value != null && value.isActive() && d().f().b().intValue() == 1 && intValue == 1 && s02 != null && s02.intValue() == 1) {
            z10 = true;
        }
        if (Log.sDebug) {
            Log.d("FloatingWindowControllerViewModel", "needKeepScreenOff: " + z10);
        }
        return z10;
    }

    public final void D() {
        Call value;
        if (Log.sDebug) {
            Log.d("FloatingWindowControllerViewModel", "onHomeKeyPressed: ");
        }
        if (!B() || (value = n().j().getValue()) == null || Call.State.isRing(value.getState())) {
            return;
        }
        A(1);
    }

    public final void E() {
        if (Log.sDebug) {
            Log.d("FloatingWindowControllerViewModel", "onInCallActivityResume: ");
        }
        if (!B()) {
            return;
        }
        A(3);
    }

    public final void F() {
        if (Log.sDebug) {
            Log.d("FloatingWindowControllerViewModel", "resetWindowType: ");
        }
        UseCase0.e(p().g(), this.f18993g, null, 2, null);
    }

    public final void G(int i10) {
        this.f18994h = i10;
    }

    public final void H() {
        d().a().b();
        n().a().b();
        o().a().b();
        p().a().b();
        q().a().b();
        r().a().b();
    }

    public final void I(int i10) {
        this.f18996j.x0(y(Integer.valueOf(i10)));
    }

    public final void J() {
        if (Log.sDebug) {
            Log.d("FloatingWindowControllerViewModel", "hideFloatingWindow: ");
        }
        if (!B()) {
            return;
        }
        A(1);
    }

    public final boolean K() {
        p().c();
        return p().s();
    }

    public final boolean L() {
        p().d();
        return p().s();
    }

    public final void l() {
        A(3);
        UseCase1.e(p().j(), n().e().s0(), this.f18993g, null, 4, null);
        UseCase1.e(q().d(), p().m().s0(), this.f18993g, null, 4, null);
    }

    public final int s(int i10) {
        int i11;
        if (i10 != 48) {
            if (i10 != 80) {
                i11 = 0;
            } else {
                i11 = R.style.BottomEnterWindowAnimation;
            }
        } else {
            i11 = R.style.TopEnterWindowAnimation;
        }
        if (Log.sDebug) {
            Log.d("FloatingWindowControllerViewModel", "getEnterWindowAnimations: default");
        }
        return i11;
    }

    public final int t() {
        return this.f18994h;
    }

    public final NonNullObservableField<Boolean> u() {
        return this.f18995i;
    }

    public final int v() {
        Integer s02 = p().m().s0();
        int i10 = 48;
        if ((s02 == null || s02.intValue() != 1) && ((s02 == null || s02.intValue() != 4) && s02 != null && s02.intValue() == 5)) {
            i10 = 80;
        }
        if (Log.sDebug) {
            Log.d("FloatingWindowControllerViewModel", "getWindowGravity: " + i10);
        }
        return i10;
    }

    public final int w(Integer num) {
        if (num != null) {
            return num.intValue();
        }
        return -2;
    }

    public final NonNullObservableField<d> x() {
        return this.f18996j;
    }

    public final d y(Integer num) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, w(num), 2038, 25167144, -3);
        layoutParams.privateFlags = 2;
        int v10 = v();
        layoutParams.gravity = v10;
        layoutParams.windowAnimations = s(v10);
        layoutParams.screenOrientation = 3;
        layoutParams.layoutInDisplayCutoutMode = 1;
        return new d(layoutParams);
    }
}
