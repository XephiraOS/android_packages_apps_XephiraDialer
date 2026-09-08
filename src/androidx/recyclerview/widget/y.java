package androidx.recyclerview.widget;

import android.view.View;

/* compiled from: ViewBoundsCheck.java */
/* loaded from: classes.dex */
public class y {

    /* renamed from: a, reason: collision with root package name */
    public final b f11210a;

    /* renamed from: b, reason: collision with root package name */
    public a f11211b = new a();

    /* compiled from: ViewBoundsCheck.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f11212a = 0;

        /* renamed from: b, reason: collision with root package name */
        public int f11213b;

        /* renamed from: c, reason: collision with root package name */
        public int f11214c;

        /* renamed from: d, reason: collision with root package name */
        public int f11215d;

        /* renamed from: e, reason: collision with root package name */
        public int f11216e;

        public void a(int i10) {
            this.f11212a = i10 | this.f11212a;
        }

        public boolean b() {
            int i10 = this.f11212a;
            if ((i10 & 7) != 0 && (i10 & c(this.f11215d, this.f11213b)) == 0) {
                return false;
            }
            int i11 = this.f11212a;
            if ((i11 & 112) != 0 && (i11 & (c(this.f11215d, this.f11214c) << 4)) == 0) {
                return false;
            }
            int i12 = this.f11212a;
            if ((i12 & 1792) != 0 && (i12 & (c(this.f11216e, this.f11213b) << 8)) == 0) {
                return false;
            }
            int i13 = this.f11212a;
            if ((i13 & 28672) != 0 && ((c(this.f11216e, this.f11214c) << 12) & i13) == 0) {
                return false;
            }
            return true;
        }

        public int c(int i10, int i11) {
            if (i10 > i11) {
                return 1;
            }
            if (i10 == i11) {
                return 2;
            }
            return 4;
        }

        public void d() {
            this.f11212a = 0;
        }

        public void e(int i10, int i11, int i12, int i13) {
            this.f11213b = i10;
            this.f11214c = i11;
            this.f11215d = i12;
            this.f11216e = i13;
        }
    }

    /* compiled from: ViewBoundsCheck.java */
    /* loaded from: classes.dex */
    public interface b {
        View a(int i10);

        int b(View view);

        int c();

        int d();

        int e(View view);
    }

    public y(b bVar) {
        this.f11210a = bVar;
    }

    public View a(int i10, int i11, int i12, int i13) {
        int i14;
        int c10 = this.f11210a.c();
        int d10 = this.f11210a.d();
        if (i11 > i10) {
            i14 = 1;
        } else {
            i14 = -1;
        }
        View view = null;
        while (i10 != i11) {
            View a10 = this.f11210a.a(i10);
            this.f11211b.e(c10, d10, this.f11210a.b(a10), this.f11210a.e(a10));
            if (i12 != 0) {
                this.f11211b.d();
                this.f11211b.a(i12);
                if (this.f11211b.b()) {
                    return a10;
                }
            }
            if (i13 != 0) {
                this.f11211b.d();
                this.f11211b.a(i13);
                if (this.f11211b.b()) {
                    view = a10;
                }
            }
            i10 += i14;
        }
        return view;
    }

    public boolean b(View view, int i10) {
        this.f11211b.e(this.f11210a.c(), this.f11210a.d(), this.f11210a.b(view), this.f11210a.e(view));
        if (i10 != 0) {
            this.f11211b.d();
            this.f11211b.a(i10);
            return this.f11211b.b();
        }
        return false;
    }
}
