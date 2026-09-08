package androidx.lifecycle;

import android.os.Handler;
import androidx.lifecycle.Lifecycle;

/* compiled from: ServiceLifecycleDispatcher.kt */
/* loaded from: classes.dex */
public class G {

    /* renamed from: a, reason: collision with root package name */
    public final q f10254a;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f10255b;

    /* renamed from: c, reason: collision with root package name */
    public a f10256c;

    /* compiled from: ServiceLifecycleDispatcher.kt */
    /* loaded from: classes.dex */
    public static final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final q f10257a;

        /* renamed from: b, reason: collision with root package name */
        public final Lifecycle.Event f10258b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f10259c;

        public a(q registry, Lifecycle.Event event) {
            kotlin.jvm.internal.i.f(registry, "registry");
            kotlin.jvm.internal.i.f(event, "event");
            this.f10257a = registry;
            this.f10258b = event;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f10259c) {
                this.f10257a.i(this.f10258b);
                this.f10259c = true;
            }
        }
    }

    public G(InterfaceC0492o provider) {
        kotlin.jvm.internal.i.f(provider, "provider");
        this.f10254a = new q(provider);
        this.f10255b = new Handler();
    }

    public Lifecycle a() {
        return this.f10254a;
    }

    public void b() {
        f(Lifecycle.Event.ON_START);
    }

    public void c() {
        f(Lifecycle.Event.ON_CREATE);
    }

    public void d() {
        f(Lifecycle.Event.ON_STOP);
        f(Lifecycle.Event.ON_DESTROY);
    }

    public void e() {
        f(Lifecycle.Event.ON_START);
    }

    public final void f(Lifecycle.Event event) {
        a aVar = this.f10256c;
        if (aVar != null) {
            aVar.run();
        }
        a aVar2 = new a(this.f10254a, event);
        this.f10256c = aVar2;
        Handler handler = this.f10255b;
        kotlin.jvm.internal.i.c(aVar2);
        handler.postAtFrontOfQueue(aVar2);
    }
}
