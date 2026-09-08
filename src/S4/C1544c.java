package s4;

import android.view.View;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import java.util.Objects;

/* compiled from: MaterialBackOrchestrator.java */
/* renamed from: s4.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1544c {

    /* renamed from: a, reason: collision with root package name */
    public final d f36785a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC1543b f36786b;

    /* renamed from: c, reason: collision with root package name */
    public final View f36787c;

    /* compiled from: MaterialBackOrchestrator.java */
    /* renamed from: s4.c$b */
    /* loaded from: classes3.dex */
    public static class b implements d {

        /* renamed from: a, reason: collision with root package name */
        public OnBackInvokedCallback f36788a;

        public b() {
        }

        @Override // s4.C1544c.d
        public void a(View view) {
            OnBackInvokedDispatcher findOnBackInvokedDispatcher = view.findOnBackInvokedDispatcher();
            if (findOnBackInvokedDispatcher == null) {
                return;
            }
            findOnBackInvokedDispatcher.unregisterOnBackInvokedCallback(this.f36788a);
            this.f36788a = null;
        }

        @Override // s4.C1544c.d
        public void b(InterfaceC1543b interfaceC1543b, View view, boolean z10) {
            OnBackInvokedDispatcher findOnBackInvokedDispatcher;
            int i10;
            if (this.f36788a != null || (findOnBackInvokedDispatcher = view.findOnBackInvokedDispatcher()) == null) {
                return;
            }
            OnBackInvokedCallback c10 = c(interfaceC1543b);
            this.f36788a = c10;
            if (z10) {
                i10 = 1000000;
            } else {
                i10 = 0;
            }
            findOnBackInvokedDispatcher.registerOnBackInvokedCallback(i10, c10);
        }

        public OnBackInvokedCallback c(final InterfaceC1543b interfaceC1543b) {
            Objects.requireNonNull(interfaceC1543b);
            return new OnBackInvokedCallback() { // from class: s4.d
                @Override // android.window.OnBackInvokedCallback
                public final void onBackInvoked() {
                    InterfaceC1543b.this.handleBackInvoked();
                }
            };
        }

        public boolean d() {
            if (this.f36788a != null) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: MaterialBackOrchestrator.java */
    /* renamed from: s4.c$c, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0357c extends b {

        /* compiled from: MaterialBackOrchestrator.java */
        /* renamed from: s4.c$c$a */
        /* loaded from: classes3.dex */
        public class a implements OnBackAnimationCallback {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ InterfaceC1543b f36789a;

            public a(InterfaceC1543b interfaceC1543b) {
                this.f36789a = interfaceC1543b;
            }

            @Override // android.window.OnBackAnimationCallback
            public void onBackCancelled() {
                if (!C0357c.this.d()) {
                    return;
                }
                this.f36789a.cancelBackProgress();
            }

            @Override // android.window.OnBackInvokedCallback
            public void onBackInvoked() {
                this.f36789a.handleBackInvoked();
            }

            @Override // android.window.OnBackAnimationCallback
            public void onBackProgressed(BackEvent backEvent) {
                if (!C0357c.this.d()) {
                    return;
                }
                this.f36789a.updateBackProgress(new androidx.activity.b(backEvent));
            }

            @Override // android.window.OnBackAnimationCallback
            public void onBackStarted(BackEvent backEvent) {
                if (!C0357c.this.d()) {
                    return;
                }
                this.f36789a.startBackProgress(new androidx.activity.b(backEvent));
            }
        }

        public C0357c() {
            super();
        }

        @Override // s4.C1544c.b
        public OnBackInvokedCallback c(InterfaceC1543b interfaceC1543b) {
            return new a(interfaceC1543b);
        }
    }

    /* compiled from: MaterialBackOrchestrator.java */
    /* renamed from: s4.c$d */
    /* loaded from: classes3.dex */
    public interface d {
        void a(View view);

        void b(InterfaceC1543b interfaceC1543b, View view, boolean z10);
    }

    public <T extends View & InterfaceC1543b> C1544c(T t10) {
        this(t10, t10);
    }

    public static d a() {
        return new C0357c();
    }

    public boolean b() {
        if (this.f36785a != null) {
            return true;
        }
        return false;
    }

    public void c() {
        d(false);
    }

    public final void d(boolean z10) {
        d dVar = this.f36785a;
        if (dVar != null) {
            dVar.b(this.f36786b, this.f36787c, z10);
        }
    }

    public void e() {
        d(true);
    }

    public void f() {
        d dVar = this.f36785a;
        if (dVar != null) {
            dVar.a(this.f36787c);
        }
    }

    public C1544c(InterfaceC1543b interfaceC1543b, View view) {
        this.f36785a = a();
        this.f36786b = interfaceC1543b;
        this.f36787c = view;
    }
}
