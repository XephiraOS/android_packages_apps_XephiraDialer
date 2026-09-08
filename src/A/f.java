package A;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import com.android.incallui.OplusAutoRedialNotificationUI;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import z.C1720c;

/* compiled from: GradientColorInflaterCompat.java */
/* loaded from: classes.dex */
public final class f {
    public static a a(a aVar, int i10, int i11, boolean z10, int i12) {
        if (aVar != null) {
            return aVar;
        }
        if (z10) {
            return new a(i10, i12, i11);
        }
        return new a(i10, i11);
    }

    public static Shader b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        String name = xmlPullParser.getName();
        if (name.equals("gradient")) {
            TypedArray s10 = k.s(resources, theme, attributeSet, C1720c.f38203B);
            float j10 = k.j(s10, xmlPullParser, "startX", C1720c.f38212K, 0.0f);
            float j11 = k.j(s10, xmlPullParser, "startY", C1720c.f38213L, 0.0f);
            float j12 = k.j(s10, xmlPullParser, "endX", C1720c.f38214M, 0.0f);
            float j13 = k.j(s10, xmlPullParser, "endY", C1720c.f38215N, 0.0f);
            float j14 = k.j(s10, xmlPullParser, "centerX", C1720c.f38207F, 0.0f);
            float j15 = k.j(s10, xmlPullParser, "centerY", C1720c.f38208G, 0.0f);
            int k10 = k.k(s10, xmlPullParser, OplusAutoRedialNotificationUI.TYPE, C1720c.f38206E, 0);
            int f10 = k.f(s10, xmlPullParser, "startColor", C1720c.f38204C, 0);
            boolean r10 = k.r(xmlPullParser, "centerColor");
            int f11 = k.f(s10, xmlPullParser, "centerColor", C1720c.f38211J, 0);
            int f12 = k.f(s10, xmlPullParser, "endColor", C1720c.f38205D, 0);
            int k11 = k.k(s10, xmlPullParser, "tileMode", C1720c.f38210I, 0);
            float j16 = k.j(s10, xmlPullParser, "gradientRadius", C1720c.f38209H, 0.0f);
            s10.recycle();
            a a10 = a(c(resources, xmlPullParser, attributeSet, theme), f10, f12, r10, f11);
            if (k10 != 1) {
                if (k10 != 2) {
                    return new LinearGradient(j10, j11, j12, j13, a10.f30a, a10.f31b, d(k11));
                }
                return new SweepGradient(j14, j15, a10.f30a, a10.f31b);
            }
            if (j16 > 0.0f) {
                return new RadialGradient(j14, j15, j16, a10.f30a, a10.f31b, d(k11));
            }
            throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid gradient color tag " + name);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0080, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException(r10.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static A.f.a c(android.content.res.Resources r9, org.xmlpull.v1.XmlPullParser r10, android.util.AttributeSet r11, android.content.res.Resources.Theme r12) {
        /*
            int r0 = r10.getDepth()
            r1 = 1
            int r0 = r0 + r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 20
            r2.<init>(r3)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r3)
        L12:
            int r3 = r10.next()
            if (r3 == r1) goto L81
            int r5 = r10.getDepth()
            if (r5 >= r0) goto L21
            r6 = 3
            if (r3 == r6) goto L81
        L21:
            r6 = 2
            if (r3 == r6) goto L25
            goto L12
        L25:
            if (r5 > r0) goto L12
            java.lang.String r3 = r10.getName()
            java.lang.String r5 = "item"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L34
            goto L12
        L34:
            int[] r3 = z.C1720c.f38216O
            android.content.res.TypedArray r3 = A.k.s(r9, r12, r11, r3)
            int r5 = z.C1720c.f38217P
            boolean r6 = r3.hasValue(r5)
            int r7 = z.C1720c.f38218Q
            boolean r8 = r3.hasValue(r7)
            if (r6 == 0) goto L66
            if (r8 == 0) goto L66
            r6 = 0
            int r5 = r3.getColor(r5, r6)
            r6 = 0
            float r6 = r3.getFloat(r7, r6)
            r3.recycle()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            r4.add(r3)
            java.lang.Float r3 = java.lang.Float.valueOf(r6)
            r2.add(r3)
            goto L12
        L66:
            org.xmlpull.v1.XmlPullParserException r9 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r10 = r10.getPositionDescription()
            r11.append(r10)
            java.lang.String r10 = ": <item> tag requires a 'color' attribute and a 'offset' attribute!"
            r11.append(r10)
            java.lang.String r10 = r11.toString()
            r9.<init>(r10)
            throw r9
        L81:
            int r9 = r4.size()
            if (r9 <= 0) goto L8d
            A.f$a r9 = new A.f$a
            r9.<init>(r4, r2)
            return r9
        L8d:
            r9 = 0
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: A.f.c(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):A.f$a");
    }

    public static Shader.TileMode d(int i10) {
        if (i10 != 1) {
            if (i10 != 2) {
                return Shader.TileMode.CLAMP;
            }
            return Shader.TileMode.MIRROR;
        }
        return Shader.TileMode.REPEAT;
    }

    /* compiled from: GradientColorInflaterCompat.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int[] f30a;

        /* renamed from: b, reason: collision with root package name */
        public final float[] f31b;

        public a(List<Integer> list, List<Float> list2) {
            int size = list.size();
            this.f30a = new int[size];
            this.f31b = new float[size];
            for (int i10 = 0; i10 < size; i10++) {
                this.f30a[i10] = list.get(i10).intValue();
                this.f31b[i10] = list2.get(i10).floatValue();
            }
        }

        public a(int i10, int i11) {
            this.f30a = new int[]{i10, i11};
            this.f31b = new float[]{0.0f, 1.0f};
        }

        public a(int i10, int i11, int i12) {
            this.f30a = new int[]{i10, i11, i12};
            this.f31b = new float[]{0.0f, 0.5f, 1.0f};
        }
    }
}
