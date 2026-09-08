package c6;

import android.view.animation.Interpolator;
import com.oplus.anim.N;
import java.util.ArrayList;
import java.util.List;
import m6.C1336b;
import m6.C1337c;

/* compiled from: BaseKeyframeAnimation.java */
/* renamed from: c6.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC0558a<K, A> {

    /* renamed from: c, reason: collision with root package name */
    public final d<K> f12799c;

    /* renamed from: e, reason: collision with root package name */
    public C1336b<A> f12801e;

    /* renamed from: a, reason: collision with root package name */
    public final List<b> f12797a = new ArrayList(1);

    /* renamed from: b, reason: collision with root package name */
    public boolean f12798b = false;

    /* renamed from: d, reason: collision with root package name */
    public float f12800d = 0.0f;

    /* renamed from: f, reason: collision with root package name */
    public A f12802f = null;

    /* renamed from: g, reason: collision with root package name */
    public float f12803g = -1.0f;

    /* renamed from: h, reason: collision with root package name */
    public float f12804h = -1.0f;

    /* compiled from: BaseKeyframeAnimation.java */
    /* renamed from: c6.a$b */
    /* loaded from: classes3.dex */
    public interface b {
        void a();
    }

    /* compiled from: BaseKeyframeAnimation.java */
    /* renamed from: c6.a$c */
    /* loaded from: classes3.dex */
    public static final class c<T> implements d<T> {
        public c() {
        }

        @Override // c6.AbstractC0558a.d
        public boolean a(float f10) {
            throw new IllegalStateException("not implemented");
        }

        @Override // c6.AbstractC0558a.d
        public C1337c<T> b() {
            throw new IllegalStateException("not implemented");
        }

        @Override // c6.AbstractC0558a.d
        public boolean c(float f10) {
            return false;
        }

        @Override // c6.AbstractC0558a.d
        public float d() {
            return 1.0f;
        }

        @Override // c6.AbstractC0558a.d
        public float e() {
            return 0.0f;
        }

        @Override // c6.AbstractC0558a.d
        public boolean isEmpty() {
            return true;
        }
    }

    /* compiled from: BaseKeyframeAnimation.java */
    /* renamed from: c6.a$d */
    /* loaded from: classes3.dex */
    public interface d<T> {
        boolean a(float f10);

        C1337c<T> b();

        boolean c(float f10);

        float d();

        float e();

        boolean isEmpty();
    }

    /* compiled from: BaseKeyframeAnimation.java */
    /* renamed from: c6.a$e */
    /* loaded from: classes3.dex */
    public static final class e<T> implements d<T> {

        /* renamed from: a, reason: collision with root package name */
        public final List<? extends C1337c<T>> f12805a;

        /* renamed from: c, reason: collision with root package name */
        public C1337c<T> f12807c = null;

        /* renamed from: d, reason: collision with root package name */
        public float f12808d = -1.0f;

        /* renamed from: b, reason: collision with root package name */
        public C1337c<T> f12806b = f(0.0f);

        public e(List<? extends C1337c<T>> list) {
            this.f12805a = list;
        }

        @Override // c6.AbstractC0558a.d
        public boolean a(float f10) {
            C1337c<T> c1337c = this.f12807c;
            C1337c<T> c1337c2 = this.f12806b;
            if (c1337c == c1337c2 && this.f12808d == f10) {
                return true;
            }
            this.f12807c = c1337c2;
            this.f12808d = f10;
            return false;
        }

        @Override // c6.AbstractC0558a.d
        public C1337c<T> b() {
            return this.f12806b;
        }

        @Override // c6.AbstractC0558a.d
        public boolean c(float f10) {
            if (this.f12806b.a(f10)) {
                return !this.f12806b.i();
            }
            this.f12806b = f(f10);
            return true;
        }

        @Override // c6.AbstractC0558a.d
        public float d() {
            return this.f12805a.get(r1.size() - 1).c();
        }

        @Override // c6.AbstractC0558a.d
        public float e() {
            return this.f12805a.get(0).f();
        }

        public final C1337c<T> f(float f10) {
            List<? extends C1337c<T>> list = this.f12805a;
            C1337c<T> c1337c = list.get(list.size() - 1);
            if (f10 >= c1337c.f()) {
                return c1337c;
            }
            for (int size = this.f12805a.size() - 2; size >= 1; size--) {
                C1337c<T> c1337c2 = this.f12805a.get(size);
                if (this.f12806b != c1337c2 && c1337c2.a(f10)) {
                    return c1337c2;
                }
            }
            return this.f12805a.get(0);
        }

        @Override // c6.AbstractC0558a.d
        public boolean isEmpty() {
            return false;
        }
    }

    /* compiled from: BaseKeyframeAnimation.java */
    /* renamed from: c6.a$f */
    /* loaded from: classes3.dex */
    public static final class f<T> implements d<T> {

        /* renamed from: a, reason: collision with root package name */
        public final C1337c<T> f12809a;

        /* renamed from: b, reason: collision with root package name */
        public float f12810b = -1.0f;

        public f(List<? extends C1337c<T>> list) {
            this.f12809a = list.get(0);
        }

        @Override // c6.AbstractC0558a.d
        public boolean a(float f10) {
            if (this.f12810b == f10) {
                return true;
            }
            this.f12810b = f10;
            return false;
        }

        @Override // c6.AbstractC0558a.d
        public C1337c<T> b() {
            return this.f12809a;
        }

        @Override // c6.AbstractC0558a.d
        public boolean c(float f10) {
            return !this.f12809a.i();
        }

        @Override // c6.AbstractC0558a.d
        public float d() {
            return this.f12809a.c();
        }

        @Override // c6.AbstractC0558a.d
        public float e() {
            return this.f12809a.f();
        }

        @Override // c6.AbstractC0558a.d
        public boolean isEmpty() {
            return false;
        }
    }

    public AbstractC0558a(List<? extends C1337c<K>> list) {
        this.f12799c = o(list);
    }

    public static <T> d<T> o(List<? extends C1337c<T>> list) {
        if (list.isEmpty()) {
            return new c();
        }
        if (list.size() == 1) {
            return new f(list);
        }
        return new e(list);
    }

    public void a(b bVar) {
        this.f12797a.add(bVar);
    }

    public C1337c<K> b() {
        N.a("BaseKeyframeAnimation#getCurrentKeyframe");
        C1337c<K> b10 = this.f12799c.b();
        N.b("BaseKeyframeAnimation#getCurrentKeyframe");
        return b10;
    }

    public float c() {
        if (this.f12804h == -1.0f) {
            this.f12804h = this.f12799c.d();
        }
        return this.f12804h;
    }

    public float d() {
        C1337c<K> b10 = b();
        if (b10 != null && !b10.i()) {
            return b10.f35157d.getInterpolation(e());
        }
        return 0.0f;
    }

    public float e() {
        if (this.f12798b) {
            return 0.0f;
        }
        C1337c<K> b10 = b();
        if (b10.i()) {
            return 0.0f;
        }
        return (this.f12800d - b10.f()) / (b10.c() - b10.f());
    }

    public float f() {
        return this.f12800d;
    }

    public final float g() {
        if (this.f12803g == -1.0f) {
            this.f12803g = this.f12799c.e();
        }
        return this.f12803g;
    }

    public A h() {
        A i10;
        float e10 = e();
        if (this.f12801e == null && this.f12799c.a(e10)) {
            return this.f12802f;
        }
        C1337c<K> b10 = b();
        Interpolator interpolator = b10.f35158e;
        if (interpolator != null && b10.f35159f != null) {
            i10 = j(b10, e10, interpolator.getInterpolation(e10), b10.f35159f.getInterpolation(e10));
        } else {
            i10 = i(b10, d());
        }
        this.f12802f = i10;
        return i10;
    }

    public abstract A i(C1337c<K> c1337c, float f10);

    public A j(C1337c<K> c1337c, float f10, float f11, float f12) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }

    public void k() {
        for (int i10 = 0; i10 < this.f12797a.size(); i10++) {
            this.f12797a.get(i10).a();
        }
    }

    public void l() {
        this.f12798b = true;
    }

    public void m(float f10) {
        if (this.f12799c.isEmpty()) {
            return;
        }
        if (f10 < g()) {
            f10 = g();
        } else if (f10 > c()) {
            f10 = c();
        }
        if (f10 == this.f12800d) {
            return;
        }
        this.f12800d = f10;
        if (this.f12799c.c(f10)) {
            k();
        }
    }

    public void n(C1336b<A> c1336b) {
        C1336b<A> c1336b2 = this.f12801e;
        if (c1336b2 != null) {
            c1336b2.c(null);
        }
        this.f12801e = c1336b;
        if (c1336b != null) {
            c1336b.c(this);
        }
    }
}
