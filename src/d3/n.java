package d3;

import java.util.Queue;
import s3.C1537h;
import s3.C1541l;

/* compiled from: ModelCache.java */
/* loaded from: classes.dex */
public class n<A, B> {

    /* renamed from: a, reason: collision with root package name */
    public final C1537h<b<A>, B> f29984a;

    /* compiled from: ModelCache.java */
    /* loaded from: classes.dex */
    public class a extends C1537h<b<A>, B> {
        public a(long j10) {
            super(j10);
        }

        @Override // s3.C1537h
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void j(b<A> bVar, B b10) {
            bVar.c();
        }
    }

    /* compiled from: ModelCache.java */
    /* loaded from: classes.dex */
    public static final class b<A> {

        /* renamed from: d, reason: collision with root package name */
        public static final Queue<b<?>> f29986d = C1541l.f(0);

        /* renamed from: a, reason: collision with root package name */
        public int f29987a;

        /* renamed from: b, reason: collision with root package name */
        public int f29988b;

        /* renamed from: c, reason: collision with root package name */
        public A f29989c;

        public static <A> b<A> a(A a10, int i10, int i11) {
            b<A> bVar;
            Queue<b<?>> queue = f29986d;
            synchronized (queue) {
                bVar = (b) queue.poll();
            }
            if (bVar == null) {
                bVar = new b<>();
            }
            bVar.b(a10, i10, i11);
            return bVar;
        }

        public final void b(A a10, int i10, int i11) {
            this.f29989c = a10;
            this.f29988b = i10;
            this.f29987a = i11;
        }

        public void c() {
            Queue<b<?>> queue = f29986d;
            synchronized (queue) {
                queue.offer(this);
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f29988b != bVar.f29988b || this.f29987a != bVar.f29987a || !this.f29989c.equals(bVar.f29989c)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f29987a * 31) + this.f29988b) * 31) + this.f29989c.hashCode();
        }
    }

    public n(long j10) {
        this.f29984a = new a(j10);
    }

    public B a(A a10, int i10, int i11) {
        b<A> a11 = b.a(a10, i10, i11);
        B g10 = this.f29984a.g(a11);
        a11.c();
        return g10;
    }

    public void b(A a10, int i10, int i11, B b10) {
        this.f29984a.k(b.a(a10, i10, i11), b10);
    }
}
