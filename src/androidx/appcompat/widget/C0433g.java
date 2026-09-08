package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.appcompat.widget.A;
import e.C0961a;
import f.C0991a;

/* compiled from: AppCompatDrawableManager.java */
/* renamed from: androidx.appcompat.widget.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0433g {

    /* renamed from: b, reason: collision with root package name */
    public static final PorterDuff.Mode f7856b = PorterDuff.Mode.SRC_IN;

    /* renamed from: c, reason: collision with root package name */
    public static C0433g f7857c;

    /* renamed from: a, reason: collision with root package name */
    public A f7858a;

    /* compiled from: AppCompatDrawableManager.java */
    /* renamed from: androidx.appcompat.widget.g$a */
    /* loaded from: classes.dex */
    public class a implements A.c {

        /* renamed from: a, reason: collision with root package name */
        public final int[] f7859a = {e.e.f30165R, e.e.f30163P, e.e.f30167a};

        /* renamed from: b, reason: collision with root package name */
        public final int[] f7860b = {e.e.f30181o, e.e.f30149B, e.e.f30186t, e.e.f30182p, e.e.f30183q, e.e.f30185s, e.e.f30184r};

        /* renamed from: c, reason: collision with root package name */
        public final int[] f7861c = {e.e.f30162O, e.e.f30164Q, e.e.f30177k, e.e.f30158K, e.e.f30159L, e.e.f30160M, e.e.f30161N};

        /* renamed from: d, reason: collision with root package name */
        public final int[] f7862d = {e.e.f30189w, e.e.f30175i, e.e.f30188v};

        /* renamed from: e, reason: collision with root package name */
        public final int[] f7863e = {e.e.f30157J, e.e.f30166S};

        /* renamed from: f, reason: collision with root package name */
        public final int[] f7864f = {e.e.f30169c, e.e.f30173g, e.e.f30170d, e.e.f30174h};

        /* JADX WARN: Removed duplicated region for block: B:12:0x0060 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x004b  */
        @Override // androidx.appcompat.widget.A.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean a(android.content.Context r7, int r8, android.graphics.drawable.Drawable r9) {
            /*
                r6 = this;
                android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.C0433g.a()
                int[] r1 = r6.f7859a
                boolean r1 = r6.f(r1, r8)
                r2 = 1
                r3 = 0
                r4 = -1
                if (r1 == 0) goto L14
                int r6 = e.C0961a.f30125x
            L11:
                r1 = r2
            L12:
                r8 = r4
                goto L49
            L14:
                int[] r1 = r6.f7861c
                boolean r1 = r6.f(r1, r8)
                if (r1 == 0) goto L1f
                int r6 = e.C0961a.f30123v
                goto L11
            L1f:
                int[] r1 = r6.f7862d
                boolean r6 = r6.f(r1, r8)
                r1 = 16842801(0x1010031, float:2.3693695E-38)
                if (r6 == 0) goto L2e
                android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
            L2c:
                r6 = r1
                goto L11
            L2e:
                int r6 = e.e.f30187u
                if (r8 != r6) goto L41
                r6 = 1109603123(0x42233333, float:40.8)
                int r6 = java.lang.Math.round(r6)
                r8 = 16842800(0x1010030, float:2.3693693E-38)
                r1 = r2
                r5 = r8
                r8 = r6
                r6 = r5
                goto L49
            L41:
                int r6 = e.e.f30178l
                if (r8 != r6) goto L46
                goto L2c
            L46:
                r6 = r3
                r1 = r6
                goto L12
            L49:
                if (r1 == 0) goto L60
                android.graphics.drawable.Drawable r9 = r9.mutate()
                int r6 = androidx.appcompat.widget.F.c(r7, r6)
                android.graphics.PorterDuffColorFilter r6 = androidx.appcompat.widget.C0433g.e(r6, r0)
                r9.setColorFilter(r6)
                if (r8 == r4) goto L5f
                r9.setAlpha(r8)
            L5f:
                return r2
            L60:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0433g.a.a(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
        }

        @Override // androidx.appcompat.widget.A.c
        public PorterDuff.Mode b(int i10) {
            if (i10 == e.e.f30155H) {
                return PorterDuff.Mode.MULTIPLY;
            }
            return null;
        }

        @Override // androidx.appcompat.widget.A.c
        public Drawable c(A a10, Context context, int i10) {
            if (i10 == e.e.f30176j) {
                return new LayerDrawable(new Drawable[]{a10.i(context, e.e.f30175i), a10.i(context, e.e.f30177k)});
            }
            if (i10 == e.e.f30191y) {
                return l(a10, context, e.d.f30145i);
            }
            if (i10 == e.e.f30190x) {
                return l(a10, context, e.d.f30146j);
            }
            if (i10 == e.e.f30192z) {
                return l(a10, context, e.d.f30147k);
            }
            return null;
        }

        @Override // androidx.appcompat.widget.A.c
        public ColorStateList d(Context context, int i10) {
            if (i10 == e.e.f30179m) {
                return C0991a.a(context, e.c.f30133e);
            }
            if (i10 == e.e.f30156I) {
                return C0991a.a(context, e.c.f30136h);
            }
            if (i10 == e.e.f30155H) {
                return k(context);
            }
            if (i10 == e.e.f30172f) {
                return j(context);
            }
            if (i10 == e.e.f30168b) {
                return g(context);
            }
            if (i10 == e.e.f30171e) {
                return i(context);
            }
            if (i10 != e.e.f30151D && i10 != e.e.f30152E) {
                if (f(this.f7860b, i10)) {
                    return F.e(context, C0961a.f30125x);
                }
                if (f(this.f7863e, i10)) {
                    return C0991a.a(context, e.c.f30132d);
                }
                if (f(this.f7864f, i10)) {
                    return C0991a.a(context, e.c.f30131c);
                }
                if (i10 == e.e.f30148A) {
                    return C0991a.a(context, e.c.f30134f);
                }
                return null;
            }
            return C0991a.a(context, e.c.f30135g);
        }

        @Override // androidx.appcompat.widget.A.c
        public boolean e(Context context, int i10, Drawable drawable) {
            if (i10 == e.e.f30150C) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                Drawable findDrawableByLayerId = layerDrawable.findDrawableByLayerId(R.id.background);
                int i11 = C0961a.f30125x;
                m(findDrawableByLayerId, F.c(context, i11), C0433g.f7856b);
                m(layerDrawable.findDrawableByLayerId(R.id.secondaryProgress), F.c(context, i11), C0433g.f7856b);
                m(layerDrawable.findDrawableByLayerId(R.id.progress), F.c(context, C0961a.f30123v), C0433g.f7856b);
                return true;
            }
            if (i10 != e.e.f30191y && i10 != e.e.f30190x && i10 != e.e.f30192z) {
                return false;
            }
            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
            m(layerDrawable2.findDrawableByLayerId(R.id.background), F.b(context, C0961a.f30125x), C0433g.f7856b);
            Drawable findDrawableByLayerId2 = layerDrawable2.findDrawableByLayerId(R.id.secondaryProgress);
            int i12 = C0961a.f30123v;
            m(findDrawableByLayerId2, F.c(context, i12), C0433g.f7856b);
            m(layerDrawable2.findDrawableByLayerId(R.id.progress), F.c(context, i12), C0433g.f7856b);
            return true;
        }

        public final boolean f(int[] iArr, int i10) {
            for (int i11 : iArr) {
                if (i11 == i10) {
                    return true;
                }
            }
            return false;
        }

        public final ColorStateList g(Context context) {
            return h(context, 0);
        }

        public final ColorStateList h(Context context, int i10) {
            int c10 = F.c(context, C0961a.f30124w);
            return new ColorStateList(new int[][]{F.f7704b, F.f7707e, F.f7705c, F.f7711i}, new int[]{F.b(context, C0961a.f30122u), B.a.q(c10, i10), B.a.q(c10, i10), i10});
        }

        public final ColorStateList i(Context context) {
            return h(context, F.c(context, C0961a.f30121t));
        }

        public final ColorStateList j(Context context) {
            return h(context, F.c(context, C0961a.f30122u));
        }

        public final ColorStateList k(Context context) {
            int[][] iArr = new int[3];
            int[] iArr2 = new int[3];
            int i10 = C0961a.f30127z;
            ColorStateList e10 = F.e(context, i10);
            if (e10 != null && e10.isStateful()) {
                int[] iArr3 = F.f7704b;
                iArr[0] = iArr3;
                iArr2[0] = e10.getColorForState(iArr3, 0);
                iArr[1] = F.f7708f;
                iArr2[1] = F.c(context, C0961a.f30123v);
                iArr[2] = F.f7711i;
                iArr2[2] = e10.getDefaultColor();
            } else {
                iArr[0] = F.f7704b;
                iArr2[0] = F.b(context, i10);
                iArr[1] = F.f7708f;
                iArr2[1] = F.c(context, C0961a.f30123v);
                iArr[2] = F.f7711i;
                iArr2[2] = F.c(context, i10);
            }
            return new ColorStateList(iArr, iArr2);
        }

        public final LayerDrawable l(A a10, Context context, int i10) {
            BitmapDrawable bitmapDrawable;
            BitmapDrawable bitmapDrawable2;
            BitmapDrawable bitmapDrawable3;
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(i10);
            Drawable i11 = a10.i(context, e.e.f30153F);
            Drawable i12 = a10.i(context, e.e.f30154G);
            if ((i11 instanceof BitmapDrawable) && i11.getIntrinsicWidth() == dimensionPixelSize && i11.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable = (BitmapDrawable) i11;
                bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
            } else {
                Bitmap createBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                i11.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                i11.draw(canvas);
                bitmapDrawable = new BitmapDrawable(createBitmap);
                bitmapDrawable2 = new BitmapDrawable(createBitmap);
            }
            bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
            if ((i12 instanceof BitmapDrawable) && i12.getIntrinsicWidth() == dimensionPixelSize && i12.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable3 = (BitmapDrawable) i12;
            } else {
                Bitmap createBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(createBitmap2);
                i12.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                i12.draw(canvas2);
                bitmapDrawable3 = new BitmapDrawable(createBitmap2);
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
            layerDrawable.setId(0, R.id.background);
            layerDrawable.setId(1, R.id.secondaryProgress);
            layerDrawable.setId(2, R.id.progress);
            return layerDrawable;
        }

        public final void m(Drawable drawable, int i10, PorterDuff.Mode mode) {
            Drawable mutate = drawable.mutate();
            if (mode == null) {
                mode = C0433g.f7856b;
            }
            mutate.setColorFilter(C0433g.e(i10, mode));
        }
    }

    public static synchronized C0433g b() {
        C0433g c0433g;
        synchronized (C0433g.class) {
            try {
                if (f7857c == null) {
                    h();
                }
                c0433g = f7857c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return c0433g;
    }

    public static synchronized PorterDuffColorFilter e(int i10, PorterDuff.Mode mode) {
        PorterDuffColorFilter k10;
        synchronized (C0433g.class) {
            k10 = A.k(i10, mode);
        }
        return k10;
    }

    public static synchronized void h() {
        synchronized (C0433g.class) {
            if (f7857c == null) {
                C0433g c0433g = new C0433g();
                f7857c = c0433g;
                c0433g.f7858a = A.g();
                f7857c.f7858a.t(new a());
            }
        }
    }

    public static void i(Drawable drawable, I i10, int[] iArr) {
        A.v(drawable, i10, iArr);
    }

    public synchronized Drawable c(Context context, int i10) {
        return this.f7858a.i(context, i10);
    }

    public synchronized Drawable d(Context context, int i10, boolean z10) {
        return this.f7858a.j(context, i10, z10);
    }

    public synchronized ColorStateList f(Context context, int i10) {
        return this.f7858a.l(context, i10);
    }

    public synchronized void g(Context context) {
        this.f7858a.r(context);
    }
}
