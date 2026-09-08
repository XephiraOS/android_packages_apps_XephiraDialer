package j;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.view.Q;
import androidx.core.view.S;
import androidx.core.view.T;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ViewPropertyAnimatorCompatSet.java */
/* loaded from: classes.dex */
public class h {

    /* renamed from: c, reason: collision with root package name */
    public Interpolator f33736c;

    /* renamed from: d, reason: collision with root package name */
    public S f33737d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f33738e;

    /* renamed from: b, reason: collision with root package name */
    public long f33735b = -1;

    /* renamed from: f, reason: collision with root package name */
    public final T f33739f = new a();

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList<Q> f33734a = new ArrayList<>();

    /* compiled from: ViewPropertyAnimatorCompatSet.java */
    /* loaded from: classes.dex */
    public class a extends T {

        /* renamed from: a, reason: collision with root package name */
        public boolean f33740a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f33741b = 0;

        public a() {
        }

        @Override // androidx.core.view.S
        public void b(View view) {
            int i10 = this.f33741b + 1;
            this.f33741b = i10;
            if (i10 == h.this.f33734a.size()) {
                S s10 = h.this.f33737d;
                if (s10 != null) {
                    s10.b(null);
                }
                d();
            }
        }

        @Override // androidx.core.view.T, androidx.core.view.S
        public void c(View view) {
            if (this.f33740a) {
                return;
            }
            this.f33740a = true;
            S s10 = h.this.f33737d;
            if (s10 != null) {
                s10.c(null);
            }
        }

        public void d() {
            this.f33741b = 0;
            this.f33740a = false;
            h.this.b();
        }
    }

    public void a() {
        if (!this.f33738e) {
            return;
        }
        Iterator<Q> it = this.f33734a.iterator();
        while (it.hasNext()) {
            it.next().c();
        }
        this.f33738e = false;
    }

    public void b() {
        this.f33738e = false;
    }

    public h c(Q q10) {
        if (!this.f33738e) {
            this.f33734a.add(q10);
        }
        return this;
    }

    public h d(Q q10, Q q11) {
        this.f33734a.add(q10);
        q11.k(q10.d());
        this.f33734a.add(q11);
        return this;
    }

    public h e(long j10) {
        if (!this.f33738e) {
            this.f33735b = j10;
        }
        return this;
    }

    public h f(Interpolator interpolator) {
        if (!this.f33738e) {
            this.f33736c = interpolator;
        }
        return this;
    }

    public h g(S s10) {
        if (!this.f33738e) {
            this.f33737d = s10;
        }
        return this;
    }

    public void h() {
        if (this.f33738e) {
            return;
        }
        Iterator<Q> it = this.f33734a.iterator();
        while (it.hasNext()) {
            Q next = it.next();
            long j10 = this.f33735b;
            if (j10 >= 0) {
                next.g(j10);
            }
            Interpolator interpolator = this.f33736c;
            if (interpolator != null) {
                next.h(interpolator);
            }
            if (this.f33737d != null) {
                next.i(this.f33739f);
            }
            next.m();
        }
        this.f33738e = true;
    }
}
