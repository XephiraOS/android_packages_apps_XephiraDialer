package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ChildHelper.java */
/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public final b f11057a;

    /* renamed from: b, reason: collision with root package name */
    public final a f11058b = new a();

    /* renamed from: c, reason: collision with root package name */
    public final List<View> f11059c = new ArrayList();

    /* compiled from: ChildHelper.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public long f11060a = 0;

        /* renamed from: b, reason: collision with root package name */
        public a f11061b;

        public void a(int i10) {
            if (i10 >= 64) {
                a aVar = this.f11061b;
                if (aVar != null) {
                    aVar.a(i10 - 64);
                    return;
                }
                return;
            }
            this.f11060a &= ~(1 << i10);
        }

        public int b(int i10) {
            a aVar = this.f11061b;
            if (aVar == null) {
                if (i10 >= 64) {
                    return Long.bitCount(this.f11060a);
                }
                return Long.bitCount(((1 << i10) - 1) & this.f11060a);
            }
            if (i10 < 64) {
                return Long.bitCount(((1 << i10) - 1) & this.f11060a);
            }
            return aVar.b(i10 - 64) + Long.bitCount(this.f11060a);
        }

        public final void c() {
            if (this.f11061b == null) {
                this.f11061b = new a();
            }
        }

        public boolean d(int i10) {
            if (i10 >= 64) {
                c();
                return this.f11061b.d(i10 - 64);
            }
            if (((1 << i10) & this.f11060a) != 0) {
                return true;
            }
            return false;
        }

        public void e(int i10, boolean z10) {
            boolean z11;
            if (i10 >= 64) {
                c();
                this.f11061b.e(i10 - 64, z10);
                return;
            }
            long j10 = this.f11060a;
            if ((Long.MIN_VALUE & j10) != 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            long j11 = (1 << i10) - 1;
            this.f11060a = ((j10 & (~j11)) << 1) | (j10 & j11);
            if (z10) {
                h(i10);
            } else {
                a(i10);
            }
            if (z11 || this.f11061b != null) {
                c();
                this.f11061b.e(0, z11);
            }
        }

        public boolean f(int i10) {
            boolean z10;
            if (i10 >= 64) {
                c();
                return this.f11061b.f(i10 - 64);
            }
            long j10 = 1 << i10;
            long j11 = this.f11060a;
            if ((j11 & j10) != 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            long j12 = j11 & (~j10);
            this.f11060a = j12;
            long j13 = j10 - 1;
            this.f11060a = (j12 & j13) | Long.rotateRight((~j13) & j12, 1);
            a aVar = this.f11061b;
            if (aVar != null) {
                if (aVar.d(0)) {
                    h(63);
                }
                this.f11061b.f(0);
            }
            return z10;
        }

        public void g() {
            this.f11060a = 0L;
            a aVar = this.f11061b;
            if (aVar != null) {
                aVar.g();
            }
        }

        public void h(int i10) {
            if (i10 >= 64) {
                c();
                this.f11061b.h(i10 - 64);
            } else {
                this.f11060a |= 1 << i10;
            }
        }

        public String toString() {
            if (this.f11061b == null) {
                return Long.toBinaryString(this.f11060a);
            }
            return this.f11061b.toString() + "xx" + Long.toBinaryString(this.f11060a);
        }
    }

    /* compiled from: ChildHelper.java */
    /* loaded from: classes.dex */
    public interface b {
        View a(int i10);

        void b(View view);

        int c();

        void d();

        int e(View view);

        RecyclerView.B f(View view);

        void g(int i10);

        void h(View view);

        void i(View view, int i10);

        void j(int i10);

        void k(View view, int i10, ViewGroup.LayoutParams layoutParams);
    }

    public h(b bVar) {
        this.f11057a = bVar;
    }

    public void a(View view, int i10, boolean z10) {
        int h10;
        if (i10 < 0) {
            h10 = this.f11057a.c();
        } else {
            h10 = h(i10);
        }
        this.f11058b.e(h10, z10);
        if (z10) {
            l(view);
        }
        this.f11057a.i(view, h10);
    }

    public void b(View view, boolean z10) {
        a(view, -1, z10);
    }

    public void c(View view, int i10, ViewGroup.LayoutParams layoutParams, boolean z10) {
        int h10;
        if (i10 < 0) {
            h10 = this.f11057a.c();
        } else {
            h10 = h(i10);
        }
        this.f11058b.e(h10, z10);
        if (z10) {
            l(view);
        }
        this.f11057a.k(view, h10, layoutParams);
    }

    public void d(int i10) {
        int h10 = h(i10);
        this.f11058b.f(h10);
        this.f11057a.g(h10);
    }

    public View e(int i10) {
        int size = this.f11059c.size();
        for (int i11 = 0; i11 < size; i11++) {
            View view = this.f11059c.get(i11);
            RecyclerView.B f10 = this.f11057a.f(view);
            if (f10.getLayoutPosition() == i10 && !f10.isInvalid() && !f10.isRemoved()) {
                return view;
            }
        }
        return null;
    }

    public View f(int i10) {
        return this.f11057a.a(h(i10));
    }

    public int g() {
        return this.f11057a.c() - this.f11059c.size();
    }

    public final int h(int i10) {
        if (i10 < 0) {
            return -1;
        }
        int c10 = this.f11057a.c();
        int i11 = i10;
        while (i11 < c10) {
            int b10 = i10 - (i11 - this.f11058b.b(i11));
            if (b10 == 0) {
                while (this.f11058b.d(i11)) {
                    i11++;
                }
                return i11;
            }
            i11 += b10;
        }
        return -1;
    }

    public View i(int i10) {
        return this.f11057a.a(i10);
    }

    public int j() {
        return this.f11057a.c();
    }

    public void k(View view) {
        int e10 = this.f11057a.e(view);
        if (e10 >= 0) {
            this.f11058b.h(e10);
            l(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    public final void l(View view) {
        this.f11059c.add(view);
        this.f11057a.b(view);
    }

    public int m(View view) {
        int e10 = this.f11057a.e(view);
        if (e10 == -1 || this.f11058b.d(e10)) {
            return -1;
        }
        return e10 - this.f11058b.b(e10);
    }

    public boolean n(View view) {
        return this.f11059c.contains(view);
    }

    public void o() {
        this.f11058b.g();
        for (int size = this.f11059c.size() - 1; size >= 0; size--) {
            this.f11057a.h(this.f11059c.get(size));
            this.f11059c.remove(size);
        }
        this.f11057a.d();
    }

    public void p(View view) {
        int e10 = this.f11057a.e(view);
        if (e10 < 0) {
            return;
        }
        if (this.f11058b.f(e10)) {
            t(view);
        }
        this.f11057a.j(e10);
    }

    public void q(int i10) {
        int h10 = h(i10);
        View a10 = this.f11057a.a(h10);
        if (a10 == null) {
            return;
        }
        if (this.f11058b.f(h10)) {
            t(a10);
        }
        this.f11057a.j(h10);
    }

    public boolean r(View view) {
        int e10 = this.f11057a.e(view);
        if (e10 == -1) {
            t(view);
            return true;
        }
        if (this.f11058b.d(e10)) {
            this.f11058b.f(e10);
            t(view);
            this.f11057a.j(e10);
            return true;
        }
        return false;
    }

    public void s(View view) {
        int e10 = this.f11057a.e(view);
        if (e10 >= 0) {
            if (this.f11058b.d(e10)) {
                this.f11058b.a(e10);
                t(view);
                return;
            } else {
                throw new RuntimeException("trying to unhide a view that was not hidden" + view);
            }
        }
        throw new IllegalArgumentException("view is not a child, cannot hide " + view);
    }

    public final boolean t(View view) {
        if (this.f11059c.remove(view)) {
            this.f11057a.h(view);
            return true;
        }
        return false;
    }

    public String toString() {
        return this.f11058b.toString() + ", hidden list:" + this.f11059c.size();
    }
}
