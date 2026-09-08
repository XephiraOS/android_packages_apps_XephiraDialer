package com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel;

import androidx.databinding.ObservableBoolean;
import com.android.incallui.clean.domain.interactor.LocalObservableField;
import com.android.incallui.clean.domain.interactor.NonNullObservableField;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import q2.C1481a;
import s2.C1527c;

/* compiled from: FloatingWindowEventBus.kt */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: i, reason: collision with root package name */
    public static final a f19047i = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final FloatingWindowControllerViewModel f19048a;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f19049b;

    /* renamed from: c, reason: collision with root package name */
    public final C1527c f19050c;

    /* renamed from: d, reason: collision with root package name */
    public final LocalObservableField<Integer> f19051d;

    /* renamed from: e, reason: collision with root package name */
    public final NonNullObservableField<Boolean> f19052e;

    /* renamed from: f, reason: collision with root package name */
    public final NonNullObservableField<Float> f19053f;

    /* renamed from: g, reason: collision with root package name */
    public final LocalObservableField<C1481a> f19054g;

    /* renamed from: h, reason: collision with root package name */
    public final ObservableBoolean f19055h;

    /* compiled from: FloatingWindowEventBus.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public b(FloatingWindowControllerViewModel controllerViewModel, Executor executor) {
        i.f(controllerViewModel, "controllerViewModel");
        i.f(executor, "executor");
        this.f19048a = controllerViewModel;
        this.f19049b = executor;
        C1527c d10 = u2.b.f37312a.d();
        this.f19050c = d10;
        this.f19051d = new LocalObservableField<>(d10.m().s0(), null, null, null, 14, null);
        this.f19052e = new NonNullObservableField<>(Boolean.FALSE, null, null, null, 14, null);
        this.f19053f = new NonNullObservableField<>(Float.valueOf(0.0f), null, null, null, 14, null);
        this.f19054g = new LocalObservableField<>(null, null, null, null, 15, null);
        this.f19055h = new ObservableBoolean();
    }

    public final FloatingWindowControllerViewModel a() {
        return this.f19048a;
    }

    public final Executor b() {
        return this.f19049b;
    }

    public final ObservableBoolean c() {
        return this.f19055h;
    }

    public final LocalObservableField<Integer> d() {
        return this.f19051d;
    }

    public final LocalObservableField<C1481a> e() {
        return this.f19054g;
    }

    public final NonNullObservableField<Float> f() {
        return this.f19053f;
    }

    public final NonNullObservableField<Boolean> g() {
        return this.f19052e;
    }
}
