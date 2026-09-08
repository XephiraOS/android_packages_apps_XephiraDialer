package h6;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import c6.AbstractC0558a;
import c6.o;
import c6.q;
import com.customize.contacts.backupandrestore.plugin.ContactBackupPlugin;
import com.oplus.anim.C0820a;
import com.oplus.anim.EffectiveAnimationDrawable;
import com.oplus.anim.model.DocumentData;
import com.oplus.anim.model.layer.Layer;
import com.oplus.anim.r;
import e6.C0984c;
import f6.C1014a;
import f6.C1015b;
import f6.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import l6.h;
import m6.C1336b;
import p.C1420f;

/* compiled from: TextLayer.java */
/* loaded from: classes3.dex */
public class f extends com.oplus.anim.model.layer.a {

    /* renamed from: D, reason: collision with root package name */
    public final StringBuilder f32076D;

    /* renamed from: E, reason: collision with root package name */
    public final RectF f32077E;

    /* renamed from: F, reason: collision with root package name */
    public final Matrix f32078F;

    /* renamed from: G, reason: collision with root package name */
    public final Paint f32079G;

    /* renamed from: H, reason: collision with root package name */
    public final Paint f32080H;

    /* renamed from: I, reason: collision with root package name */
    public final Map<e6.d, List<b6.d>> f32081I;

    /* renamed from: J, reason: collision with root package name */
    public final C1420f<String> f32082J;

    /* renamed from: K, reason: collision with root package name */
    public final List<d> f32083K;

    /* renamed from: L, reason: collision with root package name */
    public final o f32084L;

    /* renamed from: M, reason: collision with root package name */
    public final EffectiveAnimationDrawable f32085M;

    /* renamed from: N, reason: collision with root package name */
    public final C0820a f32086N;

    /* renamed from: O, reason: collision with root package name */
    public AbstractC0558a<Integer, Integer> f32087O;

    /* renamed from: P, reason: collision with root package name */
    public AbstractC0558a<Integer, Integer> f32088P;

    /* renamed from: Q, reason: collision with root package name */
    public AbstractC0558a<Integer, Integer> f32089Q;

    /* renamed from: R, reason: collision with root package name */
    public AbstractC0558a<Integer, Integer> f32090R;

    /* renamed from: S, reason: collision with root package name */
    public AbstractC0558a<Float, Float> f32091S;

    /* renamed from: T, reason: collision with root package name */
    public AbstractC0558a<Float, Float> f32092T;

    /* renamed from: U, reason: collision with root package name */
    public AbstractC0558a<Float, Float> f32093U;

    /* renamed from: V, reason: collision with root package name */
    public AbstractC0558a<Float, Float> f32094V;

    /* renamed from: W, reason: collision with root package name */
    public AbstractC0558a<Float, Float> f32095W;

    /* renamed from: X, reason: collision with root package name */
    public AbstractC0558a<Typeface, Typeface> f32096X;

    /* compiled from: TextLayer.java */
    /* loaded from: classes3.dex */
    public class a extends Paint {
        public a(int i10) {
            super(i10);
            setStyle(Paint.Style.FILL);
        }
    }

    /* compiled from: TextLayer.java */
    /* loaded from: classes3.dex */
    public class b extends Paint {
        public b(int i10) {
            super(i10);
            setStyle(Paint.Style.STROKE);
        }
    }

    /* compiled from: TextLayer.java */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f32099a;

        static {
            int[] iArr = new int[DocumentData.Justification.values().length];
            f32099a = iArr;
            try {
                iArr[DocumentData.Justification.LEFT_ALIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32099a[DocumentData.Justification.RIGHT_ALIGN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32099a[DocumentData.Justification.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public f(EffectiveAnimationDrawable effectiveAnimationDrawable, Layer layer) {
        super(effectiveAnimationDrawable, layer);
        C1015b c1015b;
        C1015b c1015b2;
        C1014a c1014a;
        C1014a c1014a2;
        this.f32076D = new StringBuilder(2);
        this.f32077E = new RectF();
        this.f32078F = new Matrix();
        this.f32079G = new a(1);
        this.f32080H = new b(1);
        this.f32081I = new HashMap();
        this.f32082J = new C1420f<>();
        this.f32083K = new ArrayList();
        this.f32085M = effectiveAnimationDrawable;
        this.f32086N = layer.b();
        o a10 = layer.s().a();
        this.f32084L = a10;
        a10.a(this);
        j(a10);
        k t10 = layer.t();
        if (t10 != null && (c1014a2 = t10.f31757a) != null) {
            AbstractC0558a<Integer, Integer> a11 = c1014a2.a();
            this.f32087O = a11;
            a11.a(this);
            j(this.f32087O);
        }
        if (t10 != null && (c1014a = t10.f31758b) != null) {
            AbstractC0558a<Integer, Integer> a12 = c1014a.a();
            this.f32089Q = a12;
            a12.a(this);
            j(this.f32089Q);
        }
        if (t10 != null && (c1015b2 = t10.f31759c) != null) {
            AbstractC0558a<Float, Float> a13 = c1015b2.a();
            this.f32091S = a13;
            a13.a(this);
            j(this.f32091S);
        }
        if (t10 != null && (c1015b = t10.f31760d) != null) {
            AbstractC0558a<Float, Float> a14 = c1015b.a();
            this.f32093U = a14;
            a14.a(this);
            j(this.f32093U);
        }
    }

    public final String P(String str, int i10) {
        int codePointAt = str.codePointAt(i10);
        int charCount = Character.charCount(codePointAt) + i10;
        while (charCount < str.length()) {
            int codePointAt2 = str.codePointAt(charCount);
            if (!d0(codePointAt2)) {
                break;
            }
            charCount += Character.charCount(codePointAt2);
            codePointAt = (codePointAt * 31) + codePointAt2;
        }
        long j10 = codePointAt;
        if (this.f32082J.c(j10)) {
            return this.f32082J.d(j10);
        }
        this.f32076D.setLength(0);
        while (i10 < charCount) {
            int codePointAt3 = str.codePointAt(i10);
            this.f32076D.appendCodePoint(codePointAt3);
            i10 += Character.charCount(codePointAt3);
        }
        String sb = this.f32076D.toString();
        this.f32082J.h(j10, sb);
        return sb;
    }

    public final void Q(DocumentData documentData, Matrix matrix) {
        int intValue;
        AbstractC0558a<Integer, Integer> abstractC0558a = this.f32088P;
        if (abstractC0558a != null) {
            this.f32079G.setColor(abstractC0558a.h().intValue());
        } else {
            AbstractC0558a<Integer, Integer> abstractC0558a2 = this.f32087O;
            if (abstractC0558a2 != null) {
                this.f32079G.setColor(abstractC0558a2.h().intValue());
            } else {
                this.f32079G.setColor(documentData.f25953h);
            }
        }
        AbstractC0558a<Integer, Integer> abstractC0558a3 = this.f32090R;
        if (abstractC0558a3 != null) {
            this.f32080H.setColor(abstractC0558a3.h().intValue());
        } else {
            AbstractC0558a<Integer, Integer> abstractC0558a4 = this.f32089Q;
            if (abstractC0558a4 != null) {
                this.f32080H.setColor(abstractC0558a4.h().intValue());
            } else {
                this.f32080H.setColor(documentData.f25954i);
            }
        }
        if (this.f26105x.h() == null) {
            intValue = 100;
        } else {
            intValue = this.f26105x.h().h().intValue();
        }
        int i10 = (intValue * 255) / 100;
        this.f32079G.setAlpha(i10);
        this.f32080H.setAlpha(i10);
        AbstractC0558a<Float, Float> abstractC0558a5 = this.f32092T;
        if (abstractC0558a5 != null) {
            this.f32080H.setStrokeWidth(abstractC0558a5.h().floatValue());
            return;
        }
        AbstractC0558a<Float, Float> abstractC0558a6 = this.f32091S;
        if (abstractC0558a6 != null) {
            this.f32080H.setStrokeWidth(abstractC0558a6.h().floatValue());
        } else {
            this.f32080H.setStrokeWidth(documentData.f25955j * h.e());
        }
    }

    public final void R(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    public final void S(e6.d dVar, float f10, DocumentData documentData, Canvas canvas) {
        List<b6.d> a02 = a0(dVar);
        for (int i10 = 0; i10 < a02.size(); i10++) {
            Path d10 = a02.get(i10).d();
            d10.computeBounds(this.f32077E, false);
            this.f32078F.reset();
            this.f32078F.preTranslate(0.0f, (-documentData.f25952g) * h.e());
            this.f32078F.preScale(f10, f10);
            d10.transform(this.f32078F);
            if (documentData.f25956k) {
                V(d10, this.f32079G, canvas);
                V(d10, this.f32080H, canvas);
            } else {
                V(d10, this.f32080H, canvas);
                V(d10, this.f32079G, canvas);
            }
        }
    }

    public final void T(String str, DocumentData documentData, Canvas canvas) {
        if (documentData.f25956k) {
            R(str, this.f32079G, canvas);
            R(str, this.f32080H, canvas);
        } else {
            R(str, this.f32080H, canvas);
            R(str, this.f32079G, canvas);
        }
    }

    public final void U(String str, DocumentData documentData, Canvas canvas, float f10) {
        int i10 = 0;
        while (i10 < str.length()) {
            String P10 = P(str, i10);
            i10 += P10.length();
            T(P10, documentData, canvas);
            canvas.translate(this.f32079G.measureText(P10) + f10, 0.0f);
        }
    }

    public final void V(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    public final void W(String str, DocumentData documentData, C0984c c0984c, Canvas canvas, float f10, float f11, float f12) {
        for (int i10 = 0; i10 < str.length(); i10++) {
            e6.d d10 = this.f32086N.c().d(e6.d.c(str.charAt(i10), c0984c.a(), c0984c.c()));
            if (d10 != null) {
                S(d10, f11, documentData, canvas);
                canvas.translate((((float) d10.b()) * f11 * h.e()) + f12, 0.0f);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void X(com.oplus.anim.model.DocumentData r19, e6.C0984c r20, android.graphics.Canvas r21) {
        /*
            r18 = this;
            r7 = r18
            r8 = r19
            r9 = r20
            r10 = r21
            android.graphics.Typeface r0 = r7.c0(r9)
            if (r0 != 0) goto Lf
            return
        Lf:
            java.lang.String r1 = r8.f25946a
            com.oplus.anim.EffectiveAnimationDrawable r2 = r7.f32085M
            r2.b0()
            android.graphics.Paint r2 = r7.f32079G
            r2.setTypeface(r0)
            c6.a<java.lang.Float, java.lang.Float> r0 = r7.f32095W
            if (r0 == 0) goto L2a
            java.lang.Object r0 = r0.h()
            java.lang.Float r0 = (java.lang.Float) r0
            float r0 = r0.floatValue()
            goto L2c
        L2a:
            float r0 = r8.f25948c
        L2c:
            android.graphics.Paint r2 = r7.f32079G
            float r3 = l6.h.e()
            float r3 = r3 * r0
            r2.setTextSize(r3)
            android.graphics.Paint r2 = r7.f32080H
            android.graphics.Paint r3 = r7.f32079G
            android.graphics.Typeface r3 = r3.getTypeface()
            r2.setTypeface(r3)
            android.graphics.Paint r2 = r7.f32080H
            android.graphics.Paint r3 = r7.f32079G
            float r3 = r3.getTextSize()
            r2.setTextSize(r3)
            int r2 = r8.f25950e
            float r2 = (float) r2
            r3 = 1092616192(0x41200000, float:10.0)
            float r2 = r2 / r3
            c6.a<java.lang.Float, java.lang.Float> r3 = r7.f32094V
            if (r3 == 0) goto L62
            java.lang.Object r3 = r3.h()
            java.lang.Float r3 = (java.lang.Float) r3
            float r3 = r3.floatValue()
        L60:
            float r2 = r2 + r3
            goto L71
        L62:
            c6.a<java.lang.Float, java.lang.Float> r3 = r7.f32093U
            if (r3 == 0) goto L71
            java.lang.Object r3 = r3.h()
            java.lang.Float r3 = (java.lang.Float) r3
            float r3 = r3.floatValue()
            goto L60
        L71:
            float r3 = l6.h.e()
            float r2 = r2 * r3
            float r2 = r2 * r0
            r0 = 1120403456(0x42c80000, float:100.0)
            float r11 = r2 / r0
            java.util.List r12 = r7.b0(r1)
            int r13 = r12.size()
            r14 = 0
            r0 = -1
            r15 = r0
            r6 = r14
        L87:
            if (r6 >= r13) goto Ld3
            java.lang.Object r0 = r12.get(r6)
            r1 = r0
            java.lang.String r1 = (java.lang.String) r1
            android.graphics.PointF r0 = r8.f25958m
            if (r0 != 0) goto L97
            r0 = 0
        L95:
            r2 = r0
            goto L9a
        L97:
            float r0 = r0.x
            goto L95
        L9a:
            r4 = 0
            r16 = 0
            r0 = r18
            r3 = r20
            r5 = r11
            r17 = r6
            r6 = r16
            java.util.List r0 = r0.f0(r1, r2, r3, r4, r5, r6)
            r1 = r14
        Lab:
            int r2 = r0.size()
            if (r1 >= r2) goto Ld0
            java.lang.Object r2 = r0.get(r1)
            h6.f$d r2 = (h6.f.d) r2
            int r15 = r15 + 1
            r21.save()
            float r3 = h6.f.d.a(r2)
            r7.e0(r10, r8, r15, r3)
            java.lang.String r2 = h6.f.d.b(r2)
            r7.U(r2, r8, r10, r11)
            r21.restore()
            int r1 = r1 + 1
            goto Lab
        Ld0:
            int r6 = r17 + 1
            goto L87
        Ld3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: h6.f.X(com.oplus.anim.model.DocumentData, e6.c, android.graphics.Canvas):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Y(com.oplus.anim.model.DocumentData r21, android.graphics.Matrix r22, e6.C0984c r23, android.graphics.Canvas r24) {
        /*
            r20 = this;
            r8 = r20
            r9 = r21
            c6.a<java.lang.Float, java.lang.Float> r0 = r8.f32095W
            if (r0 == 0) goto L13
            java.lang.Object r0 = r0.h()
            java.lang.Float r0 = (java.lang.Float) r0
            float r0 = r0.floatValue()
            goto L15
        L13:
            float r0 = r9.f25948c
        L15:
            r1 = 1120403456(0x42c80000, float:100.0)
            float r10 = r0 / r1
            float r11 = l6.h.g(r22)
            java.lang.String r0 = r9.f25946a
            java.util.List r12 = r8.b0(r0)
            int r13 = r12.size()
            int r0 = r9.f25950e
            float r0 = (float) r0
            r1 = 1092616192(0x41200000, float:10.0)
            float r0 = r0 / r1
            c6.a<java.lang.Float, java.lang.Float> r1 = r8.f32094V
            if (r1 == 0) goto L3e
            java.lang.Object r1 = r1.h()
            java.lang.Float r1 = (java.lang.Float) r1
            float r1 = r1.floatValue()
        L3b:
            float r0 = r0 + r1
        L3c:
            r14 = r0
            goto L4d
        L3e:
            c6.a<java.lang.Float, java.lang.Float> r1 = r8.f32093U
            if (r1 == 0) goto L3c
            java.lang.Object r1 = r1.h()
            java.lang.Float r1 = (java.lang.Float) r1
            float r1 = r1.floatValue()
            goto L3b
        L4d:
            r15 = 0
            r0 = -1
            r7 = r0
            r6 = r15
        L51:
            if (r6 >= r13) goto Lb2
            java.lang.Object r0 = r12.get(r6)
            r1 = r0
            java.lang.String r1 = (java.lang.String) r1
            android.graphics.PointF r0 = r9.f25958m
            if (r0 != 0) goto L61
            r0 = 0
        L5f:
            r2 = r0
            goto L64
        L61:
            float r0 = r0.x
            goto L5f
        L64:
            r16 = 1
            r0 = r20
            r3 = r23
            r4 = r10
            r5 = r14
            r17 = r6
            r6 = r16
            java.util.List r6 = r0.f0(r1, r2, r3, r4, r5, r6)
            r5 = r15
        L75:
            int r0 = r6.size()
            if (r5 >= r0) goto Laf
            java.lang.Object r0 = r6.get(r5)
            h6.f$d r0 = (h6.f.d) r0
            int r7 = r7 + 1
            r24.save()
            float r1 = h6.f.d.a(r0)
            r4 = r24
            r8.e0(r4, r9, r7, r1)
            java.lang.String r1 = h6.f.d.b(r0)
            r0 = r20
            r2 = r21
            r3 = r23
            r16 = r5
            r5 = r11
            r18 = r6
            r6 = r10
            r19 = r7
            r7 = r14
            r0.W(r1, r2, r3, r4, r5, r6, r7)
            r24.restore()
            int r5 = r16 + 1
            r6 = r18
            r7 = r19
            goto L75
        Laf:
            int r6 = r17 + 1
            goto L51
        Lb2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: h6.f.Y(com.oplus.anim.model.DocumentData, android.graphics.Matrix, e6.c, android.graphics.Canvas):void");
    }

    public final d Z(int i10) {
        for (int size = this.f32083K.size(); size < i10; size++) {
            this.f32083K.add(new d(null));
        }
        return this.f32083K.get(i10 - 1);
    }

    public final List<b6.d> a0(e6.d dVar) {
        if (this.f32081I.containsKey(dVar)) {
            return this.f32081I.get(dVar);
        }
        List<g6.k> a10 = dVar.a();
        int size = a10.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.add(new b6.d(this.f32085M, this, a10.get(i10), this.f32086N));
        }
        this.f32081I.put(dVar, arrayList);
        return arrayList;
    }

    public final List<String> b0(String str) {
        return Arrays.asList(str.replaceAll(ContactBackupPlugin.END_OF_LINE, "\r").replaceAll("\u0003", "\r").replaceAll("\n", "\r").split("\r"));
    }

    public final Typeface c0(C0984c c0984c) {
        Typeface h10;
        AbstractC0558a<Typeface, Typeface> abstractC0558a = this.f32096X;
        if (abstractC0558a != null && (h10 = abstractC0558a.h()) != null) {
            return h10;
        }
        Typeface c02 = this.f32085M.c0(c0984c);
        if (c02 != null) {
            return c02;
        }
        return c0984c.d();
    }

    public final boolean d0(int i10) {
        if (Character.getType(i10) != 16 && Character.getType(i10) != 27 && Character.getType(i10) != 6 && Character.getType(i10) != 28 && Character.getType(i10) != 8 && Character.getType(i10) != 19) {
            return false;
        }
        return true;
    }

    @Override // com.oplus.anim.model.layer.a, b6.e
    public void e(RectF rectF, Matrix matrix, boolean z10) {
        super.e(rectF, matrix, z10);
        rectF.set(0.0f, 0.0f, this.f32086N.b().width(), this.f32086N.b().height());
    }

    public final void e0(Canvas canvas, DocumentData documentData, int i10, float f10) {
        float f11;
        float f12;
        PointF pointF = documentData.f25957l;
        PointF pointF2 = documentData.f25958m;
        float e10 = h.e();
        float f13 = 0.0f;
        if (pointF == null) {
            f11 = 0.0f;
        } else {
            f11 = (documentData.f25951f * e10) + pointF.y;
        }
        float f14 = (i10 * documentData.f25951f * e10) + f11;
        if (pointF == null) {
            f12 = 0.0f;
        } else {
            f12 = pointF.x;
        }
        if (pointF2 != null) {
            f13 = pointF2.x;
        }
        int i11 = c.f32099a[documentData.f25949d.ordinal()];
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 == 3) {
                    canvas.translate((f12 + (f13 / 2.0f)) - (f10 / 2.0f), f14);
                    return;
                }
                return;
            }
            canvas.translate((f12 + f13) - f10, f14);
            return;
        }
        canvas.translate(f12, f14);
    }

    public final List<d> f0(String str, float f10, C0984c c0984c, float f11, float f12, boolean z10) {
        float measureText;
        int i10 = 0;
        int i11 = 0;
        boolean z11 = false;
        int i12 = 0;
        float f13 = 0.0f;
        float f14 = 0.0f;
        float f15 = 0.0f;
        for (int i13 = 0; i13 < str.length(); i13++) {
            char charAt = str.charAt(i13);
            if (z10) {
                e6.d d10 = this.f32086N.c().d(e6.d.c(charAt, c0984c.a(), c0984c.c()));
                if (d10 != null) {
                    measureText = ((float) d10.b()) * f11 * h.e();
                }
            } else {
                measureText = this.f32079G.measureText(str.substring(i13, i13 + 1));
            }
            float f16 = measureText + f12;
            if (charAt == ' ') {
                z11 = true;
                f15 = f16;
            } else if (z11) {
                z11 = false;
                i12 = i13;
                f14 = f16;
            } else {
                f14 += f16;
            }
            f13 += f16;
            if (f10 > 0.0f && f13 >= f10 && charAt != ' ') {
                i10++;
                d Z9 = Z(i10);
                if (i12 == i11) {
                    Z9.c(str.substring(i11, i13).trim(), (f13 - f16) - ((r9.length() - r7.length()) * f15));
                    i11 = i13;
                    i12 = i11;
                    f13 = f16;
                    f14 = f13;
                } else {
                    Z9.c(str.substring(i11, i12 - 1).trim(), ((f13 - f14) - ((r7.length() - r13.length()) * f15)) - f15);
                    f13 = f14;
                    i11 = i12;
                }
            }
        }
        if (f13 > 0.0f) {
            i10++;
            Z(i10).c(str.substring(i11), f13);
        }
        return this.f32083K.subList(0, i10);
    }

    @Override // com.oplus.anim.model.layer.a, e6.f
    public <T> void i(T t10, C1336b<T> c1336b) {
        super.i(t10, c1336b);
        if (t10 == r.f26173a) {
            AbstractC0558a<Integer, Integer> abstractC0558a = this.f32088P;
            if (abstractC0558a != null) {
                H(abstractC0558a);
            }
            if (c1336b == null) {
                this.f32088P = null;
                return;
            }
            q qVar = new q(c1336b);
            this.f32088P = qVar;
            qVar.a(this);
            j(this.f32088P);
            return;
        }
        if (t10 == r.f26174b) {
            AbstractC0558a<Integer, Integer> abstractC0558a2 = this.f32090R;
            if (abstractC0558a2 != null) {
                H(abstractC0558a2);
            }
            if (c1336b == null) {
                this.f32090R = null;
                return;
            }
            q qVar2 = new q(c1336b);
            this.f32090R = qVar2;
            qVar2.a(this);
            j(this.f32090R);
            return;
        }
        if (t10 == r.f26191s) {
            AbstractC0558a<Float, Float> abstractC0558a3 = this.f32092T;
            if (abstractC0558a3 != null) {
                H(abstractC0558a3);
            }
            if (c1336b == null) {
                this.f32092T = null;
                return;
            }
            q qVar3 = new q(c1336b);
            this.f32092T = qVar3;
            qVar3.a(this);
            j(this.f32092T);
            return;
        }
        if (t10 == r.f26192t) {
            AbstractC0558a<Float, Float> abstractC0558a4 = this.f32094V;
            if (abstractC0558a4 != null) {
                H(abstractC0558a4);
            }
            if (c1336b == null) {
                this.f32094V = null;
                return;
            }
            q qVar4 = new q(c1336b);
            this.f32094V = qVar4;
            qVar4.a(this);
            j(this.f32094V);
            return;
        }
        if (t10 == r.f26163F) {
            AbstractC0558a<Float, Float> abstractC0558a5 = this.f32095W;
            if (abstractC0558a5 != null) {
                H(abstractC0558a5);
            }
            if (c1336b == null) {
                this.f32095W = null;
                return;
            }
            q qVar5 = new q(c1336b);
            this.f32095W = qVar5;
            qVar5.a(this);
            j(this.f32095W);
            return;
        }
        if (t10 == r.f26170M) {
            AbstractC0558a<Typeface, Typeface> abstractC0558a6 = this.f32096X;
            if (abstractC0558a6 != null) {
                H(abstractC0558a6);
            }
            if (c1336b == null) {
                this.f32096X = null;
                return;
            }
            q qVar6 = new q(c1336b);
            this.f32096X = qVar6;
            qVar6.a(this);
            j(this.f32096X);
            return;
        }
        if (t10 == r.f26172O) {
            this.f32084L.q(c1336b);
        }
    }

    @Override // com.oplus.anim.model.layer.a
    public void u(Canvas canvas, Matrix matrix, int i10) {
        DocumentData h10 = this.f32084L.h();
        C0984c c0984c = this.f32086N.g().get(h10.f25947b);
        if (c0984c == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        Q(h10, matrix);
        if (this.f32085M.s1()) {
            Y(h10, matrix, c0984c, canvas);
        } else {
            X(h10, c0984c, canvas);
        }
        canvas.restore();
    }

    /* compiled from: TextLayer.java */
    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public String f32100a;

        /* renamed from: b, reason: collision with root package name */
        public float f32101b;

        public d() {
            this.f32100a = "";
            this.f32101b = 0.0f;
        }

        public void c(String str, float f10) {
            this.f32100a = str;
            this.f32101b = f10;
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }
}
