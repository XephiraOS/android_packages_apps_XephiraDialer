package androidx.emoji2.text;

import android.content.Context;
import androidx.emoji2.text.EmojiCompatInitializer;
import androidx.emoji2.text.e;
import androidx.lifecycle.InterfaceC0480c;
import androidx.lifecycle.InterfaceC0492o;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ProcessLifecycleInitializer;
import g0.C1029a;
import g0.InterfaceC1030b;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes.dex */
public class EmojiCompatInitializer implements InterfaceC1030b<Boolean> {

    /* loaded from: classes.dex */
    public static class a extends e.c {
        public a(Context context) {
            super(new b(context));
            b(1);
        }
    }

    /* loaded from: classes.dex */
    public static class b implements e.h {

        /* renamed from: a, reason: collision with root package name */
        public final Context f9743a;

        /* loaded from: classes.dex */
        public class a extends e.i {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e.i f9744a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ThreadPoolExecutor f9745b;

            public a(e.i iVar, ThreadPoolExecutor threadPoolExecutor) {
                this.f9744a = iVar;
                this.f9745b = threadPoolExecutor;
            }

            @Override // androidx.emoji2.text.e.i
            public void a(Throwable th) {
                try {
                    this.f9744a.a(th);
                } finally {
                    this.f9745b.shutdown();
                }
            }

            @Override // androidx.emoji2.text.e.i
            public void b(m mVar) {
                try {
                    this.f9744a.b(mVar);
                } finally {
                    this.f9745b.shutdown();
                }
            }
        }

        public b(Context context) {
            this.f9743a = context.getApplicationContext();
        }

        @Override // androidx.emoji2.text.e.h
        public void a(final e.i iVar) {
            final ThreadPoolExecutor b10 = androidx.emoji2.text.b.b("EmojiCompatInitializer");
            b10.execute(new Runnable() { // from class: androidx.emoji2.text.f
                @Override // java.lang.Runnable
                public final void run() {
                    EmojiCompatInitializer.b.this.d(iVar, b10);
                }
            });
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void d(e.i iVar, ThreadPoolExecutor threadPoolExecutor) {
            try {
                j a10 = androidx.emoji2.text.c.a(this.f9743a);
                if (a10 != null) {
                    a10.c(threadPoolExecutor);
                    a10.a().a(new a(iVar, threadPoolExecutor));
                    return;
                }
                throw new RuntimeException("EmojiCompat font provider not available on this device.");
            } catch (Throwable th) {
                iVar.a(th);
                threadPoolExecutor.shutdown();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            try {
                F.h.a("EmojiCompat.EmojiCompatInitializer.run");
                if (e.i()) {
                    e.c().l();
                }
            } finally {
                F.h.b();
            }
        }
    }

    @Override // g0.InterfaceC1030b
    public List<Class<? extends InterfaceC1030b<?>>> a() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    @Override // g0.InterfaceC1030b
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Boolean b(Context context) {
        e.h(new a(context));
        d(context);
        return Boolean.TRUE;
    }

    public void d(Context context) {
        final Lifecycle lifecycle = ((InterfaceC0492o) C1029a.e(context).f(ProcessLifecycleInitializer.class)).getLifecycle();
        lifecycle.a(new InterfaceC0480c() { // from class: androidx.emoji2.text.EmojiCompatInitializer.1
            @Override // androidx.lifecycle.InterfaceC0480c
            public void onResume(InterfaceC0492o interfaceC0492o) {
                EmojiCompatInitializer.this.e();
                lifecycle.d(this);
            }
        });
    }

    public void e() {
        androidx.emoji2.text.b.d().postDelayed(new c(), 500L);
    }
}
