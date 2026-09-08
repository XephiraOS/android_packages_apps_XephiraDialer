package com.google.android.material.carousel;

import android.content.Context;
import com.google.android.material.carousel.b;
import e4.C0979e;
import j4.C1162a;
import j4.f;

/* compiled from: CarouselStrategyHelper.java */
/* loaded from: classes3.dex */
public final class a {
    public static float a(float f10, float f11, int i10) {
        return f10 + (Math.max(0, i10 - 1) * f11);
    }

    public static float b(float f10, float f11, int i10) {
        if (i10 > 0) {
            return f10 + (f11 / 2.0f);
        }
        return f10;
    }

    public static b c(Context context, float f10, float f11, C1162a c1162a) {
        float f12;
        float f13;
        float min = Math.min(f(context) + f10, c1162a.f33858f);
        float f14 = min / 2.0f;
        float f15 = 0.0f - f14;
        float b10 = b(0.0f, c1162a.f33854b, c1162a.f33855c);
        float j10 = j(0.0f, a(b10, c1162a.f33854b, (int) Math.floor(c1162a.f33855c / 2.0f)), c1162a.f33854b, c1162a.f33855c);
        float b11 = b(j10, c1162a.f33857e, c1162a.f33856d);
        float j11 = j(j10, a(b11, c1162a.f33857e, (int) Math.floor(c1162a.f33856d / 2.0f)), c1162a.f33857e, c1162a.f33856d);
        float b12 = b(j11, c1162a.f33858f, c1162a.f33859g);
        float j12 = j(j11, a(b12, c1162a.f33858f, c1162a.f33859g), c1162a.f33858f, c1162a.f33859g);
        float b13 = b(j12, c1162a.f33857e, c1162a.f33856d);
        float b14 = b(j(j12, a(b13, c1162a.f33857e, (int) Math.ceil(c1162a.f33856d / 2.0f)), c1162a.f33857e, c1162a.f33856d), c1162a.f33854b, c1162a.f33855c);
        float f16 = f14 + f11;
        float b15 = f.b(min, c1162a.f33858f, f10);
        float b16 = f.b(c1162a.f33854b, c1162a.f33858f, f10);
        float b17 = f.b(c1162a.f33857e, c1162a.f33858f, f10);
        b.C0210b a10 = new b.C0210b(c1162a.f33858f, f11).a(f15, b15, min);
        if (c1162a.f33855c > 0) {
            f12 = f16;
            a10.g(b10, b16, c1162a.f33854b, (int) Math.floor(r7 / 2.0f));
        } else {
            f12 = f16;
        }
        if (c1162a.f33856d > 0) {
            a10.g(b11, b17, c1162a.f33857e, (int) Math.floor(r4 / 2.0f));
        }
        a10.h(b12, 0.0f, c1162a.f33858f, c1162a.f33859g, true);
        if (c1162a.f33856d > 0) {
            f13 = 2.0f;
            a10.g(b13, b17, c1162a.f33857e, (int) Math.ceil(r4 / 2.0f));
        } else {
            f13 = 2.0f;
        }
        if (c1162a.f33855c > 0) {
            a10.g(b14, b16, c1162a.f33854b, (int) Math.ceil(r0 / f13));
        }
        a10.a(f12, b15, min);
        return a10.i();
    }

    public static b d(Context context, float f10, float f11, C1162a c1162a, int i10) {
        if (i10 == 1) {
            return c(context, f10, f11, c1162a);
        }
        return e(context, f10, f11, c1162a);
    }

    public static b e(Context context, float f10, float f11, C1162a c1162a) {
        float min = Math.min(f(context) + f10, c1162a.f33858f);
        float f12 = min / 2.0f;
        float f13 = 0.0f - f12;
        float b10 = b(0.0f, c1162a.f33858f, c1162a.f33859g);
        float j10 = j(0.0f, a(b10, c1162a.f33858f, c1162a.f33859g), c1162a.f33858f, c1162a.f33859g);
        float b11 = b(j10, c1162a.f33857e, c1162a.f33856d);
        float b12 = b(j(j10, b11, c1162a.f33857e, c1162a.f33856d), c1162a.f33854b, c1162a.f33855c);
        float f14 = f12 + f11;
        float b13 = f.b(min, c1162a.f33858f, f10);
        float b14 = f.b(c1162a.f33854b, c1162a.f33858f, f10);
        float b15 = f.b(c1162a.f33857e, c1162a.f33858f, f10);
        b.C0210b h10 = new b.C0210b(c1162a.f33858f, f11).a(f13, b13, min).h(b10, 0.0f, c1162a.f33858f, c1162a.f33859g, true);
        if (c1162a.f33856d > 0) {
            h10.b(b11, b15, c1162a.f33857e);
        }
        int i10 = c1162a.f33855c;
        if (i10 > 0) {
            h10.g(b12, b14, c1162a.f33854b, i10);
        }
        h10.a(f14, b13, min);
        return h10.i();
    }

    public static float f(Context context) {
        return context.getResources().getDimension(C0979e.f30729D);
    }

    public static float g(Context context) {
        return context.getResources().getDimension(C0979e.f30731E);
    }

    public static float h(Context context) {
        return context.getResources().getDimension(C0979e.f30733F);
    }

    public static int i(int[] iArr) {
        int i10 = Integer.MIN_VALUE;
        for (int i11 : iArr) {
            if (i11 > i10) {
                i10 = i11;
            }
        }
        return i10;
    }

    public static float j(float f10, float f11, float f12, int i10) {
        if (i10 > 0) {
            return f11 + (f12 / 2.0f);
        }
        return f10;
    }
}
