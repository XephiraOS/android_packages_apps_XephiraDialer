package androidx.emoji2.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;

/* compiled from: TypefaceEmojiRasterizer.java */
/* loaded from: classes.dex */
public class o {

    /* renamed from: d, reason: collision with root package name */
    public static final ThreadLocal<O.a> f9834d = new ThreadLocal<>();

    /* renamed from: a, reason: collision with root package name */
    public final int f9835a;

    /* renamed from: b, reason: collision with root package name */
    public final m f9836b;

    /* renamed from: c, reason: collision with root package name */
    public volatile int f9837c = 0;

    public o(m mVar, int i10) {
        this.f9836b = mVar;
        this.f9835a = i10;
    }

    public void a(Canvas canvas, float f10, float f11, Paint paint) {
        Typeface g10 = this.f9836b.g();
        Typeface typeface = paint.getTypeface();
        paint.setTypeface(g10);
        canvas.drawText(this.f9836b.c(), this.f9835a * 2, 2, f10, f11, paint);
        paint.setTypeface(typeface);
    }

    public int b(int i10) {
        return g().h(i10);
    }

    public int c() {
        return g().i();
    }

    public int d() {
        return this.f9837c & 3;
    }

    public int e() {
        return g().k();
    }

    public int f() {
        return g().l();
    }

    public final O.a g() {
        ThreadLocal<O.a> threadLocal = f9834d;
        O.a aVar = threadLocal.get();
        if (aVar == null) {
            aVar = new O.a();
            threadLocal.set(aVar);
        }
        this.f9836b.d().j(aVar, this.f9835a);
        return aVar;
    }

    public short h() {
        return g().m();
    }

    public int i() {
        return g().n();
    }

    public boolean j() {
        return g().j();
    }

    public boolean k() {
        if ((this.f9837c & 4) > 0) {
            return true;
        }
        return false;
    }

    public void l(boolean z10) {
        int d10 = d();
        if (z10) {
            this.f9837c = d10 | 4;
        } else {
            this.f9837c = d10;
        }
    }

    public void m(boolean z10) {
        int i10;
        int i11 = this.f9837c & 4;
        if (z10) {
            i10 = i11 | 2;
        } else {
            i10 = i11 | 1;
        }
        this.f9837c = i10;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        sb.append(Integer.toHexString(f()));
        sb.append(", codepoints:");
        int c10 = c();
        for (int i10 = 0; i10 < c10; i10++) {
            sb.append(Integer.toHexString(b(i10)));
            sb.append(" ");
        }
        return sb.toString();
    }
}
