package androidx.activity;

import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.OnBackPressedDispatcher;
import androidx.lifecycle.InterfaceC0489l;
import androidx.lifecycle.InterfaceC0492o;
import androidx.lifecycle.Lifecycle;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import kotlin.collections.C1224e;
import v9.InterfaceC1637a;

/* compiled from: OnBackPressedDispatcher.kt */
/* loaded from: classes.dex */
public final class OnBackPressedDispatcher {

    /* renamed from: a, reason: collision with root package name */
    public final Runnable f7078a;

    /* renamed from: b, reason: collision with root package name */
    public final I.a<Boolean> f7079b;

    /* renamed from: c, reason: collision with root package name */
    public final C1224e<n> f7080c;

    /* renamed from: d, reason: collision with root package name */
    public n f7081d;

    /* renamed from: e, reason: collision with root package name */
    public OnBackInvokedCallback f7082e;

    /* renamed from: f, reason: collision with root package name */
    public OnBackInvokedDispatcher f7083f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f7084g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f7085h;

    /* compiled from: OnBackPressedDispatcher.kt */
    /* loaded from: classes.dex */
    public final class LifecycleOnBackPressedCancellable implements InterfaceC0489l, androidx.activity.c {

        /* renamed from: a, reason: collision with root package name */
        public final Lifecycle f7086a;

        /* renamed from: b, reason: collision with root package name */
        public final n f7087b;

        /* renamed from: c, reason: collision with root package name */
        public androidx.activity.c f7088c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ OnBackPressedDispatcher f7089d;

        public LifecycleOnBackPressedCancellable(OnBackPressedDispatcher onBackPressedDispatcher, Lifecycle lifecycle, n onBackPressedCallback) {
            kotlin.jvm.internal.i.f(lifecycle, "lifecycle");
            kotlin.jvm.internal.i.f(onBackPressedCallback, "onBackPressedCallback");
            this.f7089d = onBackPressedDispatcher;
            this.f7086a = lifecycle;
            this.f7087b = onBackPressedCallback;
            lifecycle.a(this);
        }

        @Override // androidx.activity.c
        public void cancel() {
            this.f7086a.d(this);
            this.f7087b.i(this);
            androidx.activity.c cVar = this.f7088c;
            if (cVar != null) {
                cVar.cancel();
            }
            this.f7088c = null;
        }

        @Override // androidx.lifecycle.InterfaceC0489l
        public void onStateChanged(InterfaceC0492o source, Lifecycle.Event event) {
            kotlin.jvm.internal.i.f(source, "source");
            kotlin.jvm.internal.i.f(event, "event");
            if (event == Lifecycle.Event.ON_START) {
                this.f7088c = this.f7089d.j(this.f7087b);
                return;
            }
            if (event == Lifecycle.Event.ON_STOP) {
                androidx.activity.c cVar = this.f7088c;
                if (cVar != null) {
                    cVar.cancel();
                    return;
                }
                return;
            }
            if (event == Lifecycle.Event.ON_DESTROY) {
                cancel();
            }
        }
    }

    /* compiled from: OnBackPressedDispatcher.kt */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f7090a = new a();

        public static final void c(InterfaceC1637a onBackInvoked) {
            kotlin.jvm.internal.i.f(onBackInvoked, "$onBackInvoked");
            onBackInvoked.invoke();
        }

        public final OnBackInvokedCallback b(final InterfaceC1637a<m9.q> onBackInvoked) {
            kotlin.jvm.internal.i.f(onBackInvoked, "onBackInvoked");
            return new OnBackInvokedCallback() { // from class: androidx.activity.o
                @Override // android.window.OnBackInvokedCallback
                public final void onBackInvoked() {
                    OnBackPressedDispatcher.a.c(InterfaceC1637a.this);
                }
            };
        }

        public final void d(Object dispatcher, int i10, Object callback) {
            kotlin.jvm.internal.i.f(dispatcher, "dispatcher");
            kotlin.jvm.internal.i.f(callback, "callback");
            ((OnBackInvokedDispatcher) dispatcher).registerOnBackInvokedCallback(i10, (OnBackInvokedCallback) callback);
        }

        public final void e(Object dispatcher, Object callback) {
            kotlin.jvm.internal.i.f(dispatcher, "dispatcher");
            kotlin.jvm.internal.i.f(callback, "callback");
            ((OnBackInvokedDispatcher) dispatcher).unregisterOnBackInvokedCallback((OnBackInvokedCallback) callback);
        }
    }

    /* compiled from: OnBackPressedDispatcher.kt */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final b f7091a = new b();

        /* compiled from: OnBackPressedDispatcher.kt */
        /* loaded from: classes.dex */
        public static final class a implements OnBackAnimationCallback {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ v9.l<androidx.activity.b, m9.q> f7092a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ v9.l<androidx.activity.b, m9.q> f7093b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ InterfaceC1637a<m9.q> f7094c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ InterfaceC1637a<m9.q> f7095d;

            /* JADX WARN: Multi-variable type inference failed */
            public a(v9.l<? super androidx.activity.b, m9.q> lVar, v9.l<? super androidx.activity.b, m9.q> lVar2, InterfaceC1637a<m9.q> interfaceC1637a, InterfaceC1637a<m9.q> interfaceC1637a2) {
                this.f7092a = lVar;
                this.f7093b = lVar2;
                this.f7094c = interfaceC1637a;
                this.f7095d = interfaceC1637a2;
            }

            @Override // android.window.OnBackAnimationCallback
            public void onBackCancelled() {
                this.f7095d.invoke();
            }

            @Override // android.window.OnBackInvokedCallback
            public void onBackInvoked() {
                this.f7094c.invoke();
            }

            @Override // android.window.OnBackAnimationCallback
            public void onBackProgressed(BackEvent backEvent) {
                kotlin.jvm.internal.i.f(backEvent, "backEvent");
                this.f7093b.invoke(new androidx.activity.b(backEvent));
            }

            @Override // android.window.OnBackAnimationCallback
            public void onBackStarted(BackEvent backEvent) {
                kotlin.jvm.internal.i.f(backEvent, "backEvent");
                this.f7092a.invoke(new androidx.activity.b(backEvent));
            }
        }

        public final OnBackInvokedCallback a(v9.l<? super androidx.activity.b, m9.q> onBackStarted, v9.l<? super androidx.activity.b, m9.q> onBackProgressed, InterfaceC1637a<m9.q> onBackInvoked, InterfaceC1637a<m9.q> onBackCancelled) {
            kotlin.jvm.internal.i.f(onBackStarted, "onBackStarted");
            kotlin.jvm.internal.i.f(onBackProgressed, "onBackProgressed");
            kotlin.jvm.internal.i.f(onBackInvoked, "onBackInvoked");
            kotlin.jvm.internal.i.f(onBackCancelled, "onBackCancelled");
            return new a(onBackStarted, onBackProgressed, onBackInvoked, onBackCancelled);
        }
    }

    /* compiled from: OnBackPressedDispatcher.kt */
    /* loaded from: classes.dex */
    public final class c implements androidx.activity.c {

        /* renamed from: a, reason: collision with root package name */
        public final n f7096a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OnBackPressedDispatcher f7097b;

        public c(OnBackPressedDispatcher onBackPressedDispatcher, n onBackPressedCallback) {
            kotlin.jvm.internal.i.f(onBackPressedCallback, "onBackPressedCallback");
            this.f7097b = onBackPressedDispatcher;
            this.f7096a = onBackPressedCallback;
        }

        @Override // androidx.activity.c
        public void cancel() {
            this.f7097b.f7080c.remove(this.f7096a);
            if (kotlin.jvm.internal.i.b(this.f7097b.f7081d, this.f7096a)) {
                this.f7096a.c();
                this.f7097b.f7081d = null;
            }
            this.f7096a.i(this);
            InterfaceC1637a<m9.q> b10 = this.f7096a.b();
            if (b10 != null) {
                b10.invoke();
            }
            this.f7096a.k(null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OnBackPressedDispatcher() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final void h(n onBackPressedCallback) {
        kotlin.jvm.internal.i.f(onBackPressedCallback, "onBackPressedCallback");
        j(onBackPressedCallback);
    }

    public final void i(InterfaceC0492o owner, n onBackPressedCallback) {
        kotlin.jvm.internal.i.f(owner, "owner");
        kotlin.jvm.internal.i.f(onBackPressedCallback, "onBackPressedCallback");
        Lifecycle lifecycle = owner.getLifecycle();
        if (lifecycle.b() == Lifecycle.State.DESTROYED) {
            return;
        }
        onBackPressedCallback.a(new LifecycleOnBackPressedCancellable(this, lifecycle, onBackPressedCallback));
        q();
        onBackPressedCallback.k(new OnBackPressedDispatcher$addCallback$1(this));
    }

    public final androidx.activity.c j(n onBackPressedCallback) {
        kotlin.jvm.internal.i.f(onBackPressedCallback, "onBackPressedCallback");
        this.f7080c.add(onBackPressedCallback);
        c cVar = new c(this, onBackPressedCallback);
        onBackPressedCallback.a(cVar);
        q();
        onBackPressedCallback.k(new OnBackPressedDispatcher$addCancellableCallback$1(this));
        return cVar;
    }

    public final void k() {
        n nVar;
        C1224e<n> c1224e = this.f7080c;
        ListIterator<n> listIterator = c1224e.listIterator(c1224e.size());
        while (true) {
            if (listIterator.hasPrevious()) {
                nVar = listIterator.previous();
                if (nVar.g()) {
                    break;
                }
            } else {
                nVar = null;
                break;
            }
        }
        n nVar2 = nVar;
        this.f7081d = null;
        if (nVar2 != null) {
            nVar2.c();
        }
    }

    public final void l() {
        n nVar;
        C1224e<n> c1224e = this.f7080c;
        ListIterator<n> listIterator = c1224e.listIterator(c1224e.size());
        while (true) {
            if (listIterator.hasPrevious()) {
                nVar = listIterator.previous();
                if (nVar.g()) {
                    break;
                }
            } else {
                nVar = null;
                break;
            }
        }
        n nVar2 = nVar;
        this.f7081d = null;
        if (nVar2 != null) {
            nVar2.d();
            return;
        }
        Runnable runnable = this.f7078a;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void m(androidx.activity.b bVar) {
        n nVar;
        C1224e<n> c1224e = this.f7080c;
        ListIterator<n> listIterator = c1224e.listIterator(c1224e.size());
        while (true) {
            if (listIterator.hasPrevious()) {
                nVar = listIterator.previous();
                if (nVar.g()) {
                    break;
                }
            } else {
                nVar = null;
                break;
            }
        }
        n nVar2 = nVar;
        if (nVar2 != null) {
            nVar2.e(bVar);
        }
    }

    public final void n(androidx.activity.b bVar) {
        n nVar;
        C1224e<n> c1224e = this.f7080c;
        ListIterator<n> listIterator = c1224e.listIterator(c1224e.size());
        while (true) {
            if (listIterator.hasPrevious()) {
                nVar = listIterator.previous();
                if (nVar.g()) {
                    break;
                }
            } else {
                nVar = null;
                break;
            }
        }
        n nVar2 = nVar;
        this.f7081d = nVar2;
        if (nVar2 != null) {
            nVar2.f(bVar);
        }
    }

    public final void o(OnBackInvokedDispatcher invoker) {
        kotlin.jvm.internal.i.f(invoker, "invoker");
        this.f7083f = invoker;
        p(this.f7085h);
    }

    public final void p(boolean z10) {
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.f7083f;
        OnBackInvokedCallback onBackInvokedCallback = this.f7082e;
        if (onBackInvokedDispatcher != null && onBackInvokedCallback != null) {
            if (z10 && !this.f7084g) {
                a.f7090a.d(onBackInvokedDispatcher, 0, onBackInvokedCallback);
                this.f7084g = true;
            } else if (!z10 && this.f7084g) {
                a.f7090a.e(onBackInvokedDispatcher, onBackInvokedCallback);
                this.f7084g = false;
            }
        }
    }

    public final void q() {
        boolean z10 = this.f7085h;
        C1224e<n> c1224e = this.f7080c;
        boolean z11 = false;
        if (!(c1224e instanceof Collection) || !c1224e.isEmpty()) {
            Iterator<n> it = c1224e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().g()) {
                    z11 = true;
                    break;
                }
            }
        }
        this.f7085h = z11;
        if (z11 != z10) {
            I.a<Boolean> aVar = this.f7079b;
            if (aVar != null) {
                aVar.accept(Boolean.valueOf(z11));
            }
            p(z11);
        }
    }

    public OnBackPressedDispatcher(Runnable runnable, I.a<Boolean> aVar) {
        this.f7078a = runnable;
        this.f7079b = aVar;
        this.f7080c = new C1224e<>();
        this.f7082e = b.f7091a.a(new v9.l<androidx.activity.b, m9.q>() { // from class: androidx.activity.OnBackPressedDispatcher.1
            {
                super(1);
            }

            public final void b(androidx.activity.b backEvent) {
                kotlin.jvm.internal.i.f(backEvent, "backEvent");
                OnBackPressedDispatcher.this.n(backEvent);
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ m9.q invoke(androidx.activity.b bVar) {
                b(bVar);
                return m9.q.f35511a;
            }
        }, new v9.l<androidx.activity.b, m9.q>() { // from class: androidx.activity.OnBackPressedDispatcher.2
            {
                super(1);
            }

            public final void b(androidx.activity.b backEvent) {
                kotlin.jvm.internal.i.f(backEvent, "backEvent");
                OnBackPressedDispatcher.this.m(backEvent);
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ m9.q invoke(androidx.activity.b bVar) {
                b(bVar);
                return m9.q.f35511a;
            }
        }, new InterfaceC1637a<m9.q>() { // from class: androidx.activity.OnBackPressedDispatcher.3
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            public /* bridge */ /* synthetic */ m9.q invoke() {
                invoke2();
                return m9.q.f35511a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                OnBackPressedDispatcher.this.l();
            }
        }, new InterfaceC1637a<m9.q>() { // from class: androidx.activity.OnBackPressedDispatcher.4
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            public /* bridge */ /* synthetic */ m9.q invoke() {
                invoke2();
                return m9.q.f35511a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                OnBackPressedDispatcher.this.k();
            }
        });
    }

    public /* synthetic */ OnBackPressedDispatcher(Runnable runnable, int i10, kotlin.jvm.internal.f fVar) {
        this((i10 & 1) != 0 ? null : runnable);
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this(runnable, null);
    }
}
