package androidx.recyclerview.widget;

import android.os.Handler;
import android.os.Looper;
import androidx.recyclerview.widget.j;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* compiled from: AsyncListDiffer.java */
/* loaded from: classes.dex */
public class d<T> {

    /* renamed from: h, reason: collision with root package name */
    public static final Executor f11020h = new c();

    /* renamed from: a, reason: collision with root package name */
    public final q f11021a;

    /* renamed from: b, reason: collision with root package name */
    public final androidx.recyclerview.widget.c<T> f11022b;

    /* renamed from: c, reason: collision with root package name */
    public Executor f11023c;

    /* renamed from: e, reason: collision with root package name */
    public List<T> f11025e;

    /* renamed from: g, reason: collision with root package name */
    public int f11027g;

    /* renamed from: d, reason: collision with root package name */
    public final List<b<T>> f11024d = new CopyOnWriteArrayList();

    /* renamed from: f, reason: collision with root package name */
    public List<T> f11026f = Collections.emptyList();

    /* compiled from: AsyncListDiffer.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f11028a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f11029b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f11030c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Runnable f11031d;

        /* compiled from: AsyncListDiffer.java */
        /* renamed from: androidx.recyclerview.widget.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0136a extends j.b {
            public C0136a() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.recyclerview.widget.j.b
            public boolean a(int i10, int i11) {
                Object obj = a.this.f11028a.get(i10);
                Object obj2 = a.this.f11029b.get(i11);
                if (obj != null && obj2 != null) {
                    return d.this.f11022b.b().areContentsTheSame(obj, obj2);
                }
                if (obj == null && obj2 == null) {
                    return true;
                }
                throw new AssertionError();
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.recyclerview.widget.j.b
            public boolean b(int i10, int i11) {
                Object obj = a.this.f11028a.get(i10);
                Object obj2 = a.this.f11029b.get(i11);
                if (obj != null && obj2 != null) {
                    return d.this.f11022b.b().areItemsTheSame(obj, obj2);
                }
                if (obj == null && obj2 == null) {
                    return true;
                }
                return false;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.recyclerview.widget.j.b
            public Object c(int i10, int i11) {
                Object obj = a.this.f11028a.get(i10);
                Object obj2 = a.this.f11029b.get(i11);
                if (obj != null && obj2 != null) {
                    return d.this.f11022b.b().getChangePayload(obj, obj2);
                }
                throw new AssertionError();
            }

            @Override // androidx.recyclerview.widget.j.b
            public int d() {
                return a.this.f11029b.size();
            }

            @Override // androidx.recyclerview.widget.j.b
            public int e() {
                return a.this.f11028a.size();
            }
        }

        /* compiled from: AsyncListDiffer.java */
        /* loaded from: classes.dex */
        public class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ j.e f11034a;

            public b(j.e eVar) {
                this.f11034a = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                d dVar = d.this;
                if (dVar.f11027g == aVar.f11030c) {
                    dVar.c(aVar.f11029b, this.f11034a, aVar.f11031d);
                }
            }
        }

        public a(List list, List list2, int i10, Runnable runnable) {
            this.f11028a = list;
            this.f11029b = list2;
            this.f11030c = i10;
            this.f11031d = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f11023c.execute(new b(j.b(new C0136a())));
        }
    }

    /* compiled from: AsyncListDiffer.java */
    /* loaded from: classes.dex */
    public interface b<T> {
        void a(List<T> list, List<T> list2);
    }

    /* compiled from: AsyncListDiffer.java */
    /* loaded from: classes.dex */
    public static class c implements Executor {

        /* renamed from: a, reason: collision with root package name */
        public final Handler f11036a = new Handler(Looper.getMainLooper());

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f11036a.post(runnable);
        }
    }

    public d(q qVar, androidx.recyclerview.widget.c<T> cVar) {
        this.f11021a = qVar;
        this.f11022b = cVar;
        if (cVar.c() != null) {
            this.f11023c = cVar.c();
        } else {
            this.f11023c = f11020h;
        }
    }

    public void a(b<T> bVar) {
        this.f11024d.add(bVar);
    }

    public List<T> b() {
        return this.f11026f;
    }

    public void c(List<T> list, j.e eVar, Runnable runnable) {
        List<T> list2 = this.f11026f;
        this.f11025e = list;
        this.f11026f = Collections.unmodifiableList(list);
        eVar.b(this.f11021a);
        d(list2, runnable);
    }

    public final void d(List<T> list, Runnable runnable) {
        Iterator<b<T>> it = this.f11024d.iterator();
        while (it.hasNext()) {
            it.next().a(list, this.f11026f);
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    public void e(List<T> list) {
        f(list, null);
    }

    public void f(List<T> list, Runnable runnable) {
        int i10 = this.f11027g + 1;
        this.f11027g = i10;
        List<T> list2 = this.f11025e;
        if (list == list2) {
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        List<T> list3 = this.f11026f;
        if (list == null) {
            int size = list2.size();
            this.f11025e = null;
            this.f11026f = Collections.emptyList();
            this.f11021a.c(0, size);
            d(list3, runnable);
            return;
        }
        if (list2 == null) {
            this.f11025e = list;
            this.f11026f = Collections.unmodifiableList(list);
            this.f11021a.b(0, list.size());
            d(list3, runnable);
            return;
        }
        this.f11022b.a().execute(new a(list2, list, i10, runnable));
    }
}
