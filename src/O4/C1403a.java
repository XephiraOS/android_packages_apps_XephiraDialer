package o4;

import android.content.Context;
import android.graphics.Color;
import e4.C0977c;
import l4.C1292a;
import u4.C1606b;

/* compiled from: ElevationOverlayProvider.java */
/* renamed from: o4.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1403a {

    /* renamed from: f, reason: collision with root package name */
    public static final int f35754f = (int) Math.round(5.1000000000000005d);

    /* renamed from: a, reason: collision with root package name */
    public final boolean f35755a;

    /* renamed from: b, reason: collision with root package name */
    public final int f35756b;

    /* renamed from: c, reason: collision with root package name */
    public final int f35757c;

    /* renamed from: d, reason: collision with root package name */
    public final int f35758d;

    /* renamed from: e, reason: collision with root package name */
    public final float f35759e;

    public C1403a(Context context) {
        this(C1606b.b(context, C0977c.f30624A, false), C1292a.b(context, C0977c.f30705z, 0), C1292a.b(context, C0977c.f30703y, 0), C1292a.b(context, C0977c.f30697v, 0), context.getResources().getDisplayMetrics().density);
    }

    public float a(float f10) {
        if (this.f35759e <= 0.0f || f10 <= 0.0f) {
            return 0.0f;
        }
        return Math.min(((((float) Math.log1p(f10 / r2)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
    }

    public int b(int i10, float f10) {
        int i11;
        float a10 = a(f10);
        int alpha = Color.alpha(i10);
        int j10 = C1292a.j(B.a.w(i10, 255), this.f35756b, a10);
        if (a10 > 0.0f && (i11 = this.f35757c) != 0) {
            j10 = C1292a.i(j10, B.a.w(i11, f35754f));
        }
        return B.a.w(j10, alpha);
    }

    public int c(int i10, float f10) {
        if (this.f35755a && f(i10)) {
            return b(i10, f10);
        }
        return i10;
    }

    public int d(float f10) {
        return c(this.f35758d, f10);
    }

    public boolean e() {
        return this.f35755a;
    }

    public final boolean f(int i10) {
        if (B.a.w(i10, 255) == this.f35758d) {
            return true;
        }
        return false;
    }

    public C1403a(boolean z10, int i10, int i11, int i12, float f10) {
        this.f35755a = z10;
        this.f35756b = i10;
        this.f35757c = i11;
        this.f35758d = i12;
        this.f35759e = f10;
    }
}
