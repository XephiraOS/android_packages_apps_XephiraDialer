package G;

import G.f;
import G.g;
import android.graphics.Typeface;
import java.util.concurrent.Executor;

/* compiled from: CallbackWrapper.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final g.c f1031a;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f1032b;

    /* compiled from: CallbackWrapper.java */
    /* renamed from: G.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0020a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g.c f1033a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Typeface f1034b;

        public RunnableC0020a(g.c cVar, Typeface typeface) {
            this.f1033a = cVar;
            this.f1034b = typeface;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1033a.b(this.f1034b);
        }
    }

    /* compiled from: CallbackWrapper.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g.c f1036a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f1037b;

        public b(g.c cVar, int i10) {
            this.f1036a = cVar;
            this.f1037b = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1036a.a(this.f1037b);
        }
    }

    public a(g.c cVar, Executor executor) {
        this.f1031a = cVar;
        this.f1032b = executor;
    }

    public final void a(int i10) {
        this.f1032b.execute(new b(this.f1031a, i10));
    }

    public void b(f.e eVar) {
        if (eVar.a()) {
            c(eVar.f1065a);
        } else {
            a(eVar.f1066b);
        }
    }

    public final void c(Typeface typeface) {
        this.f1032b.execute(new RunnableC0020a(this.f1031a, typeface));
    }
}
