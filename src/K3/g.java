package k3;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import o3.C1401e;
import p3.AbstractC1433c;
import q3.InterfaceC1483b;
import r3.C1508b;
import s3.C1540k;
import s3.C1541l;

/* compiled from: GifFrameLoader.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public final W2.a f34113a;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f34114b;

    /* renamed from: c, reason: collision with root package name */
    public final List<b> f34115c;

    /* renamed from: d, reason: collision with root package name */
    public final com.bumptech.glide.i f34116d;

    /* renamed from: e, reason: collision with root package name */
    public final a3.d f34117e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f34118f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f34119g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f34120h;

    /* renamed from: i, reason: collision with root package name */
    public com.bumptech.glide.h<Bitmap> f34121i;

    /* renamed from: j, reason: collision with root package name */
    public a f34122j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f34123k;

    /* renamed from: l, reason: collision with root package name */
    public a f34124l;

    /* renamed from: m, reason: collision with root package name */
    public Bitmap f34125m;

    /* renamed from: n, reason: collision with root package name */
    public X2.g<Bitmap> f34126n;

    /* renamed from: o, reason: collision with root package name */
    public a f34127o;

    /* renamed from: p, reason: collision with root package name */
    public int f34128p;

    /* renamed from: q, reason: collision with root package name */
    public int f34129q;

    /* renamed from: r, reason: collision with root package name */
    public int f34130r;

    /* compiled from: GifFrameLoader.java */
    /* loaded from: classes.dex */
    public static class a extends AbstractC1433c<Bitmap> {

        /* renamed from: d, reason: collision with root package name */
        public final Handler f34131d;

        /* renamed from: e, reason: collision with root package name */
        public final int f34132e;

        /* renamed from: f, reason: collision with root package name */
        public final long f34133f;

        /* renamed from: g, reason: collision with root package name */
        public Bitmap f34134g;

        public a(Handler handler, int i10, long j10) {
            this.f34131d = handler;
            this.f34132e = i10;
            this.f34133f = j10;
        }

        @Override // p3.InterfaceC1438h
        public void h(Drawable drawable) {
            this.f34134g = null;
        }

        public Bitmap j() {
            return this.f34134g;
        }

        @Override // p3.InterfaceC1438h
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public void a(Bitmap bitmap, InterfaceC1483b<? super Bitmap> interfaceC1483b) {
            this.f34134g = bitmap;
            this.f34131d.sendMessageAtTime(this.f34131d.obtainMessage(1, this), this.f34133f);
        }
    }

    /* compiled from: GifFrameLoader.java */
    /* loaded from: classes.dex */
    public interface b {
        void a();
    }

    /* compiled from: GifFrameLoader.java */
    /* loaded from: classes.dex */
    public class c implements Handler.Callback {
        public c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 1) {
                g.this.m((a) message.obj);
                return true;
            }
            if (i10 == 2) {
                g.this.f34116d.m((a) message.obj);
                return false;
            }
            return false;
        }
    }

    public g(com.bumptech.glide.b bVar, W2.a aVar, int i10, int i11, X2.g<Bitmap> gVar, Bitmap bitmap) {
        this(bVar.f(), com.bumptech.glide.b.t(bVar.h()), aVar, null, i(com.bumptech.glide.b.t(bVar.h()), i10, i11), gVar, bitmap);
    }

    public static X2.b g() {
        return new C1508b(Double.valueOf(Math.random()));
    }

    public static com.bumptech.glide.h<Bitmap> i(com.bumptech.glide.i iVar, int i10, int i11) {
        return iVar.k().a(C1401e.j0(Z2.c.f5871b).h0(true).c0(true).T(i10, i11));
    }

    public void a() {
        this.f34115c.clear();
        n();
        q();
        a aVar = this.f34122j;
        if (aVar != null) {
            this.f34116d.m(aVar);
            this.f34122j = null;
        }
        a aVar2 = this.f34124l;
        if (aVar2 != null) {
            this.f34116d.m(aVar2);
            this.f34124l = null;
        }
        a aVar3 = this.f34127o;
        if (aVar3 != null) {
            this.f34116d.m(aVar3);
            this.f34127o = null;
        }
        this.f34113a.clear();
        this.f34123k = true;
    }

    public ByteBuffer b() {
        return this.f34113a.f().asReadOnlyBuffer();
    }

    public Bitmap c() {
        a aVar = this.f34122j;
        if (aVar != null) {
            return aVar.j();
        }
        return this.f34125m;
    }

    public int d() {
        a aVar = this.f34122j;
        if (aVar != null) {
            return aVar.f34132e;
        }
        return -1;
    }

    public Bitmap e() {
        return this.f34125m;
    }

    public int f() {
        return this.f34113a.c();
    }

    public int h() {
        return this.f34130r;
    }

    public int j() {
        return this.f34113a.i() + this.f34128p;
    }

    public int k() {
        return this.f34129q;
    }

    public final void l() {
        boolean z10;
        if (this.f34118f && !this.f34119g) {
            if (this.f34120h) {
                if (this.f34127o == null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                C1540k.a(z10, "Pending target must be null when starting from the first frame");
                this.f34113a.g();
                this.f34120h = false;
            }
            a aVar = this.f34127o;
            if (aVar != null) {
                this.f34127o = null;
                m(aVar);
                return;
            }
            this.f34119g = true;
            long uptimeMillis = SystemClock.uptimeMillis() + this.f34113a.d();
            this.f34113a.a();
            this.f34124l = new a(this.f34114b, this.f34113a.h(), uptimeMillis);
            this.f34121i.a(C1401e.k0(g())).v0(this.f34113a).q0(this.f34124l);
        }
    }

    public void m(a aVar) {
        this.f34119g = false;
        if (this.f34123k) {
            this.f34114b.obtainMessage(2, aVar).sendToTarget();
            return;
        }
        if (!this.f34118f) {
            if (this.f34120h) {
                this.f34114b.obtainMessage(2, aVar).sendToTarget();
                return;
            } else {
                this.f34127o = aVar;
                return;
            }
        }
        if (aVar.j() != null) {
            n();
            a aVar2 = this.f34122j;
            this.f34122j = aVar;
            for (int size = this.f34115c.size() - 1; size >= 0; size--) {
                this.f34115c.get(size).a();
            }
            if (aVar2 != null) {
                this.f34114b.obtainMessage(2, aVar2).sendToTarget();
            }
        }
        l();
    }

    public final void n() {
        Bitmap bitmap = this.f34125m;
        if (bitmap != null) {
            this.f34117e.c(bitmap);
            this.f34125m = null;
        }
    }

    public void o(X2.g<Bitmap> gVar, Bitmap bitmap) {
        this.f34126n = (X2.g) C1540k.d(gVar);
        this.f34125m = (Bitmap) C1540k.d(bitmap);
        this.f34121i = this.f34121i.a(new C1401e().d0(gVar));
        this.f34128p = C1541l.h(bitmap);
        this.f34129q = bitmap.getWidth();
        this.f34130r = bitmap.getHeight();
    }

    public final void p() {
        if (this.f34118f) {
            return;
        }
        this.f34118f = true;
        this.f34123k = false;
        l();
    }

    public final void q() {
        this.f34118f = false;
    }

    public void r(b bVar) {
        if (!this.f34123k) {
            if (!this.f34115c.contains(bVar)) {
                boolean isEmpty = this.f34115c.isEmpty();
                this.f34115c.add(bVar);
                if (isEmpty) {
                    p();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
    }

    public void s(b bVar) {
        this.f34115c.remove(bVar);
        if (this.f34115c.isEmpty()) {
            q();
        }
    }

    public g(a3.d dVar, com.bumptech.glide.i iVar, W2.a aVar, Handler handler, com.bumptech.glide.h<Bitmap> hVar, X2.g<Bitmap> gVar, Bitmap bitmap) {
        this.f34115c = new ArrayList();
        this.f34116d = iVar;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new c()) : handler;
        this.f34117e = dVar;
        this.f34114b = handler;
        this.f34121i = hVar;
        this.f34113a = aVar;
        o(gVar, bitmap);
    }
}
