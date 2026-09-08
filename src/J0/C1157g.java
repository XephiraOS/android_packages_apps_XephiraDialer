package j0;

import A.k;
import B.d;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.util.AttributeSet;
import com.coui.appcompat.uiutil.UIUtil;
import com.oplus.backup.sdk.common.utils.Constants;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p.C1415a;

/* compiled from: VectorDrawableCompat.java */
/* renamed from: j0.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1157g extends AbstractC1156f {

    /* renamed from: k, reason: collision with root package name */
    public static final PorterDuff.Mode f33774k = PorterDuff.Mode.SRC_IN;

    /* renamed from: b, reason: collision with root package name */
    public h f33775b;

    /* renamed from: c, reason: collision with root package name */
    public PorterDuffColorFilter f33776c;

    /* renamed from: d, reason: collision with root package name */
    public ColorFilter f33777d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f33778e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f33779f;

    /* renamed from: g, reason: collision with root package name */
    public Drawable.ConstantState f33780g;

    /* renamed from: h, reason: collision with root package name */
    public final float[] f33781h;

    /* renamed from: i, reason: collision with root package name */
    public final Matrix f33782i;

    /* renamed from: j, reason: collision with root package name */
    public final Rect f33783j;

    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: j0.g$b */
    /* loaded from: classes.dex */
    public static class b extends f {
        public b() {
        }

        private void f(TypedArray typedArray, XmlPullParser xmlPullParser) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f33810b = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f33809a = B.d.d(string2);
            }
            this.f33811c = k.k(typedArray, xmlPullParser, "fillType", 2, 0);
        }

        @Override // j0.C1157g.f
        public boolean c() {
            return true;
        }

        public void e(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (!k.r(xmlPullParser, "pathData")) {
                return;
            }
            TypedArray s10 = k.s(resources, theme, attributeSet, C1151a.f33747d);
            f(s10, xmlPullParser);
            s10.recycle();
        }

        public b(b bVar) {
            super(bVar);
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: j0.g$e */
    /* loaded from: classes.dex */
    public static abstract class e {
        public e() {
        }

        public boolean a() {
            return false;
        }

        public boolean b(int[] iArr) {
            return false;
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: j0.g$h */
    /* loaded from: classes.dex */
    public static class h extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        public int f33830a;

        /* renamed from: b, reason: collision with root package name */
        public C0319g f33831b;

        /* renamed from: c, reason: collision with root package name */
        public ColorStateList f33832c;

        /* renamed from: d, reason: collision with root package name */
        public PorterDuff.Mode f33833d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f33834e;

        /* renamed from: f, reason: collision with root package name */
        public Bitmap f33835f;

        /* renamed from: g, reason: collision with root package name */
        public ColorStateList f33836g;

        /* renamed from: h, reason: collision with root package name */
        public PorterDuff.Mode f33837h;

        /* renamed from: i, reason: collision with root package name */
        public int f33838i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f33839j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f33840k;

        /* renamed from: l, reason: collision with root package name */
        public Paint f33841l;

        public h(h hVar) {
            this.f33832c = null;
            this.f33833d = C1157g.f33774k;
            if (hVar != null) {
                this.f33830a = hVar.f33830a;
                C0319g c0319g = new C0319g(hVar.f33831b);
                this.f33831b = c0319g;
                if (hVar.f33831b.f33818e != null) {
                    c0319g.f33818e = new Paint(hVar.f33831b.f33818e);
                }
                if (hVar.f33831b.f33817d != null) {
                    this.f33831b.f33817d = new Paint(hVar.f33831b.f33817d);
                }
                this.f33832c = hVar.f33832c;
                this.f33833d = hVar.f33833d;
                this.f33834e = hVar.f33834e;
            }
        }

        public boolean a(int i10, int i11) {
            if (i10 == this.f33835f.getWidth() && i11 == this.f33835f.getHeight()) {
                return true;
            }
            return false;
        }

        public boolean b() {
            if (!this.f33840k && this.f33836g == this.f33832c && this.f33837h == this.f33833d && this.f33839j == this.f33834e && this.f33838i == this.f33831b.getRootAlpha()) {
                return true;
            }
            return false;
        }

        public void c(int i10, int i11) {
            if (this.f33835f == null || !a(i10, i11)) {
                this.f33835f = Bitmap.createBitmap(i10, i11, Bitmap.Config.ARGB_8888);
                this.f33840k = true;
            }
        }

        public void d(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f33835f, (Rect) null, rect, e(colorFilter));
        }

        public Paint e(ColorFilter colorFilter) {
            if (!f() && colorFilter == null) {
                return null;
            }
            if (this.f33841l == null) {
                Paint paint = new Paint();
                this.f33841l = paint;
                paint.setFilterBitmap(true);
            }
            this.f33841l.setAlpha(this.f33831b.getRootAlpha());
            this.f33841l.setColorFilter(colorFilter);
            return this.f33841l;
        }

        public boolean f() {
            if (this.f33831b.getRootAlpha() < 255) {
                return true;
            }
            return false;
        }

        public boolean g() {
            return this.f33831b.f();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f33830a;
        }

        public boolean h(int[] iArr) {
            boolean g10 = this.f33831b.g(iArr);
            this.f33840k |= g10;
            return g10;
        }

        public void i() {
            this.f33836g = this.f33832c;
            this.f33837h = this.f33833d;
            this.f33838i = this.f33831b.getRootAlpha();
            this.f33839j = this.f33834e;
            this.f33840k = false;
        }

        public void j(int i10, int i11) {
            this.f33835f.eraseColor(0);
            this.f33831b.b(new Canvas(this.f33835f), i10, i11, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new C1157g(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new C1157g(this);
        }

        public h() {
            this.f33832c = null;
            this.f33833d = C1157g.f33774k;
            this.f33831b = new C0319g();
        }
    }

    public C1157g() {
        this.f33779f = true;
        this.f33781h = new float[9];
        this.f33782i = new Matrix();
        this.f33783j = new Rect();
        this.f33775b = new h();
    }

    public static int a(int i10, float f10) {
        return (i10 & UIUtil.CONSTANT_COLOR_MASK) | (((int) (Color.alpha(i10) * f10)) << 24);
    }

    public static C1157g b(Resources resources, int i10, Resources.Theme theme) {
        C1157g c1157g = new C1157g();
        c1157g.f33773a = A.h.f(resources, i10, theme);
        c1157g.f33780g = new i(c1157g.f33773a.getConstantState());
        return c1157g;
    }

    public static PorterDuff.Mode f(int i10, PorterDuff.Mode mode) {
        if (i10 != 3) {
            if (i10 != 5) {
                if (i10 != 9) {
                    switch (i10) {
                        case 14:
                            return PorterDuff.Mode.MULTIPLY;
                        case 15:
                            return PorterDuff.Mode.SCREEN;
                        case 16:
                            return PorterDuff.Mode.ADD;
                        default:
                            return mode;
                    }
                }
                return PorterDuff.Mode.SRC_ATOP;
            }
            return PorterDuff.Mode.SRC_IN;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    @Override // j0.AbstractC1156f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    public Object c(String str) {
        return this.f33775b.f33831b.f33829p.get(str);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f33773a;
        if (drawable != null) {
            C.a.b(drawable);
            return false;
        }
        return false;
    }

    @Override // j0.AbstractC1156f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public final void d(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        h hVar = this.f33775b;
        C0319g c0319g = hVar.f33831b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(c0319g.f33821h);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z10 = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                d dVar = (d) arrayDeque.peek();
                if (Constants.MessagerConstants.PATH_KEY.equals(name)) {
                    c cVar = new c();
                    cVar.g(resources, attributeSet, theme, xmlPullParser);
                    dVar.f33797b.add(cVar);
                    if (cVar.getPathName() != null) {
                        c0319g.f33829p.put(cVar.getPathName(), cVar);
                    }
                    hVar.f33830a = cVar.f33812d | hVar.f33830a;
                    z10 = false;
                } else if ("clip-path".equals(name)) {
                    b bVar = new b();
                    bVar.e(resources, attributeSet, theme, xmlPullParser);
                    dVar.f33797b.add(bVar);
                    if (bVar.getPathName() != null) {
                        c0319g.f33829p.put(bVar.getPathName(), bVar);
                    }
                    hVar.f33830a = bVar.f33812d | hVar.f33830a;
                } else if ("group".equals(name)) {
                    d dVar2 = new d();
                    dVar2.c(resources, attributeSet, theme, xmlPullParser);
                    dVar.f33797b.add(dVar2);
                    arrayDeque.push(dVar2);
                    if (dVar2.getGroupName() != null) {
                        c0319g.f33829p.put(dVar2.getGroupName(), dVar2);
                    }
                    hVar.f33830a = dVar2.f33806k | hVar.f33830a;
                }
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (!z10) {
        } else {
            throw new XmlPullParserException("no path defined");
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f33773a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.f33783j);
        if (this.f33783j.width() > 0 && this.f33783j.height() > 0) {
            ColorFilter colorFilter = this.f33777d;
            if (colorFilter == null) {
                colorFilter = this.f33776c;
            }
            canvas.getMatrix(this.f33782i);
            this.f33782i.getValues(this.f33781h);
            float abs = Math.abs(this.f33781h[0]);
            float abs2 = Math.abs(this.f33781h[4]);
            float abs3 = Math.abs(this.f33781h[1]);
            float abs4 = Math.abs(this.f33781h[3]);
            if (abs3 != 0.0f || abs4 != 0.0f) {
                abs = 1.0f;
                abs2 = 1.0f;
            }
            int min = Math.min(2048, (int) (this.f33783j.width() * abs));
            int min2 = Math.min(2048, (int) (this.f33783j.height() * abs2));
            if (min > 0 && min2 > 0) {
                int save = canvas.save();
                Rect rect = this.f33783j;
                canvas.translate(rect.left, rect.top);
                if (e()) {
                    canvas.translate(this.f33783j.width(), 0.0f);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.f33783j.offsetTo(0, 0);
                this.f33775b.c(min, min2);
                if (!this.f33779f) {
                    this.f33775b.j(min, min2);
                } else if (!this.f33775b.b()) {
                    this.f33775b.j(min, min2);
                    this.f33775b.i();
                }
                this.f33775b.d(canvas, colorFilter, this.f33783j);
                canvas.restoreToCount(save);
            }
        }
    }

    public final boolean e() {
        if (isAutoMirrored() && C.a.f(this) == 1) {
            return true;
        }
        return false;
    }

    public void g(boolean z10) {
        this.f33779f = z10;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f33773a;
        if (drawable != null) {
            return C.a.d(drawable);
        }
        return this.f33775b.f33831b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f33773a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return this.f33775b.getChangingConfigurations() | super.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f33773a;
        if (drawable != null) {
            return C.a.e(drawable);
        }
        return this.f33777d;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f33773a != null) {
            return new i(this.f33773a.getConstantState());
        }
        this.f33775b.f33830a = getChangingConfigurations();
        return this.f33775b;
    }

    @Override // j0.AbstractC1156f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f33773a;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return (int) this.f33775b.f33831b.f33823j;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f33773a;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return (int) this.f33775b.f33831b.f33822i;
    }

    @Override // j0.AbstractC1156f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // j0.AbstractC1156f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f33773a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // j0.AbstractC1156f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // j0.AbstractC1156f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // j0.AbstractC1156f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public final void h(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
        h hVar = this.f33775b;
        C0319g c0319g = hVar.f33831b;
        hVar.f33833d = f(k.k(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList g10 = k.g(typedArray, xmlPullParser, theme, "tint", 1);
        if (g10 != null) {
            hVar.f33832c = g10;
        }
        hVar.f33834e = k.e(typedArray, xmlPullParser, "autoMirrored", 5, hVar.f33834e);
        c0319g.f33824k = k.j(typedArray, xmlPullParser, "viewportWidth", 7, c0319g.f33824k);
        float j10 = k.j(typedArray, xmlPullParser, "viewportHeight", 8, c0319g.f33825l);
        c0319g.f33825l = j10;
        if (c0319g.f33824k > 0.0f) {
            if (j10 > 0.0f) {
                c0319g.f33822i = typedArray.getDimension(3, c0319g.f33822i);
                float dimension = typedArray.getDimension(2, c0319g.f33823j);
                c0319g.f33823j = dimension;
                if (c0319g.f33822i > 0.0f) {
                    if (dimension > 0.0f) {
                        c0319g.setAlpha(k.j(typedArray, xmlPullParser, "alpha", 4, c0319g.getAlpha()));
                        String string = typedArray.getString(0);
                        if (string != null) {
                            c0319g.f33827n = string;
                            c0319g.f33829p.put(string, c0319g);
                            return;
                        }
                        return;
                    }
                    throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
                }
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
            }
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
        throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
    }

    public PorterDuffColorFilter i(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList != null && mode != null) {
            return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        Drawable drawable = this.f33773a;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable drawable = this.f33773a;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f33773a;
        if (drawable != null) {
            return C.a.h(drawable);
        }
        return this.f33775b.f33834e;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        h hVar;
        ColorStateList colorStateList;
        Drawable drawable = this.f33773a;
        if (drawable != null) {
            return drawable.isStateful();
        }
        if (!super.isStateful() && ((hVar = this.f33775b) == null || (!hVar.g() && ((colorStateList = this.f33775b.f33832c) == null || !colorStateList.isStateful())))) {
            return false;
        }
        return true;
    }

    @Override // j0.AbstractC1156f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f33773a;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f33778e && super.mutate() == this) {
            this.f33775b = new h(this.f33775b);
            this.f33778e = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f33773a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean z10;
        PorterDuff.Mode mode;
        Drawable drawable = this.f33773a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        h hVar = this.f33775b;
        ColorStateList colorStateList = hVar.f33832c;
        if (colorStateList != null && (mode = hVar.f33833d) != null) {
            this.f33776c = i(this.f33776c, colorStateList, mode);
            invalidateSelf();
            z10 = true;
        } else {
            z10 = false;
        }
        if (hVar.g() && hVar.h(iArr)) {
            invalidateSelf();
            return true;
        }
        return z10;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j10) {
        Drawable drawable = this.f33773a;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j10);
        } else {
            super.scheduleSelf(runnable, j10);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        Drawable drawable = this.f33773a;
        if (drawable != null) {
            drawable.setAlpha(i10);
        } else if (this.f33775b.f33831b.getRootAlpha() != i10) {
            this.f33775b.f33831b.setRootAlpha(i10);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z10) {
        Drawable drawable = this.f33773a;
        if (drawable != null) {
            C.a.j(drawable, z10);
        } else {
            this.f33775b.f33834e = z10;
        }
    }

    @Override // j0.AbstractC1156f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i10) {
        super.setChangingConfigurations(i10);
    }

    @Override // j0.AbstractC1156f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i10, PorterDuff.Mode mode) {
        super.setColorFilter(i10, mode);
    }

    @Override // j0.AbstractC1156f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z10) {
        super.setFilterBitmap(z10);
    }

    @Override // j0.AbstractC1156f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f10, float f11) {
        super.setHotspot(f10, f11);
    }

    @Override // j0.AbstractC1156f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i10, int i11, int i12, int i13) {
        super.setHotspotBounds(i10, i11, i12, i13);
    }

    @Override // j0.AbstractC1156f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i10) {
        Drawable drawable = this.f33773a;
        if (drawable != null) {
            C.a.n(drawable, i10);
        } else {
            setTintList(ColorStateList.valueOf(i10));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f33773a;
        if (drawable != null) {
            C.a.o(drawable, colorStateList);
            return;
        }
        h hVar = this.f33775b;
        if (hVar.f33832c != colorStateList) {
            hVar.f33832c = colorStateList;
            this.f33776c = i(this.f33776c, colorStateList, hVar.f33833d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f33773a;
        if (drawable != null) {
            C.a.p(drawable, mode);
            return;
        }
        h hVar = this.f33775b;
        if (hVar.f33833d != mode) {
            hVar.f33833d = mode;
            this.f33776c = i(this.f33776c, hVar.f33832c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        Drawable drawable = this.f33773a;
        if (drawable != null) {
            return drawable.setVisible(z10, z11);
        }
        return super.setVisible(z10, z11);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f33773a;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: j0.g$i */
    /* loaded from: classes.dex */
    public static class i extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        public final Drawable.ConstantState f33842a;

        public i(Drawable.ConstantState constantState) {
            this.f33842a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f33842a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f33842a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            C1157g c1157g = new C1157g();
            c1157g.f33773a = (VectorDrawable) this.f33842a.newDrawable();
            return c1157g;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            C1157g c1157g = new C1157g();
            c1157g.f33773a = (VectorDrawable) this.f33842a.newDrawable(resources);
            return c1157g;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            C1157g c1157g = new C1157g();
            c1157g.f33773a = (VectorDrawable) this.f33842a.newDrawable(resources, theme);
            return c1157g;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f33773a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f33777d = colorFilter;
            invalidateSelf();
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: j0.g$f */
    /* loaded from: classes.dex */
    public static abstract class f extends e {

        /* renamed from: a, reason: collision with root package name */
        public d.b[] f33809a;

        /* renamed from: b, reason: collision with root package name */
        public String f33810b;

        /* renamed from: c, reason: collision with root package name */
        public int f33811c;

        /* renamed from: d, reason: collision with root package name */
        public int f33812d;

        public f() {
            super();
            this.f33809a = null;
            this.f33811c = 0;
        }

        public boolean c() {
            return false;
        }

        public void d(Path path) {
            path.reset();
            d.b[] bVarArr = this.f33809a;
            if (bVarArr != null) {
                d.b.h(bVarArr, path);
            }
        }

        public d.b[] getPathData() {
            return this.f33809a;
        }

        public String getPathName() {
            return this.f33810b;
        }

        public void setPathData(d.b[] bVarArr) {
            if (!B.d.b(this.f33809a, bVarArr)) {
                this.f33809a = B.d.f(bVarArr);
            } else {
                B.d.k(this.f33809a, bVarArr);
            }
        }

        public f(f fVar) {
            super();
            this.f33809a = null;
            this.f33811c = 0;
            this.f33810b = fVar.f33810b;
            this.f33812d = fVar.f33812d;
            this.f33809a = B.d.f(fVar.f33809a);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        Drawable drawable = this.f33773a;
        if (drawable != null) {
            C.a.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        h hVar = this.f33775b;
        hVar.f33831b = new C0319g();
        TypedArray s10 = k.s(resources, theme, attributeSet, C1151a.f33744a);
        h(s10, xmlPullParser, theme);
        s10.recycle();
        hVar.f33830a = getChangingConfigurations();
        hVar.f33840k = true;
        d(resources, xmlPullParser, attributeSet, theme);
        this.f33776c = i(this.f33776c, hVar.f33832c, hVar.f33833d);
    }

    public C1157g(h hVar) {
        this.f33779f = true;
        this.f33781h = new float[9];
        this.f33782i = new Matrix();
        this.f33783j = new Rect();
        this.f33775b = hVar;
        this.f33776c = i(this.f33776c, hVar.f33832c, hVar.f33833d);
    }

    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: j0.g$c */
    /* loaded from: classes.dex */
    public static class c extends f {

        /* renamed from: e, reason: collision with root package name */
        public int[] f33784e;

        /* renamed from: f, reason: collision with root package name */
        public A.d f33785f;

        /* renamed from: g, reason: collision with root package name */
        public float f33786g;

        /* renamed from: h, reason: collision with root package name */
        public A.d f33787h;

        /* renamed from: i, reason: collision with root package name */
        public float f33788i;

        /* renamed from: j, reason: collision with root package name */
        public float f33789j;

        /* renamed from: k, reason: collision with root package name */
        public float f33790k;

        /* renamed from: l, reason: collision with root package name */
        public float f33791l;

        /* renamed from: m, reason: collision with root package name */
        public float f33792m;

        /* renamed from: n, reason: collision with root package name */
        public Paint.Cap f33793n;

        /* renamed from: o, reason: collision with root package name */
        public Paint.Join f33794o;

        /* renamed from: p, reason: collision with root package name */
        public float f33795p;

        public c() {
            this.f33786g = 0.0f;
            this.f33788i = 1.0f;
            this.f33789j = 1.0f;
            this.f33790k = 0.0f;
            this.f33791l = 1.0f;
            this.f33792m = 0.0f;
            this.f33793n = Paint.Cap.BUTT;
            this.f33794o = Paint.Join.MITER;
            this.f33795p = 4.0f;
        }

        @Override // j0.C1157g.e
        public boolean a() {
            if (!this.f33787h.i() && !this.f33785f.i()) {
                return false;
            }
            return true;
        }

        @Override // j0.C1157g.e
        public boolean b(int[] iArr) {
            return this.f33785f.j(iArr) | this.f33787h.j(iArr);
        }

        public final Paint.Cap e(int i10, Paint.Cap cap) {
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 != 2) {
                        return cap;
                    }
                    return Paint.Cap.SQUARE;
                }
                return Paint.Cap.ROUND;
            }
            return Paint.Cap.BUTT;
        }

        public final Paint.Join f(int i10, Paint.Join join) {
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 != 2) {
                        return join;
                    }
                    return Paint.Join.BEVEL;
                }
                return Paint.Join.ROUND;
            }
            return Paint.Join.MITER;
        }

        public void g(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray s10 = k.s(resources, theme, attributeSet, C1151a.f33746c);
            h(s10, xmlPullParser, theme);
            s10.recycle();
        }

        public float getFillAlpha() {
            return this.f33789j;
        }

        public int getFillColor() {
            return this.f33787h.e();
        }

        public float getStrokeAlpha() {
            return this.f33788i;
        }

        public int getStrokeColor() {
            return this.f33785f.e();
        }

        public float getStrokeWidth() {
            return this.f33786g;
        }

        public float getTrimPathEnd() {
            return this.f33791l;
        }

        public float getTrimPathOffset() {
            return this.f33792m;
        }

        public float getTrimPathStart() {
            return this.f33790k;
        }

        public final void h(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.f33784e = null;
            if (!k.r(xmlPullParser, "pathData")) {
                return;
            }
            String string = typedArray.getString(0);
            if (string != null) {
                this.f33810b = string;
            }
            String string2 = typedArray.getString(2);
            if (string2 != null) {
                this.f33809a = B.d.d(string2);
            }
            this.f33787h = k.i(typedArray, xmlPullParser, theme, "fillColor", 1, 0);
            this.f33789j = k.j(typedArray, xmlPullParser, "fillAlpha", 12, this.f33789j);
            this.f33793n = e(k.k(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.f33793n);
            this.f33794o = f(k.k(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.f33794o);
            this.f33795p = k.j(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.f33795p);
            this.f33785f = k.i(typedArray, xmlPullParser, theme, "strokeColor", 3, 0);
            this.f33788i = k.j(typedArray, xmlPullParser, "strokeAlpha", 11, this.f33788i);
            this.f33786g = k.j(typedArray, xmlPullParser, "strokeWidth", 4, this.f33786g);
            this.f33791l = k.j(typedArray, xmlPullParser, "trimPathEnd", 6, this.f33791l);
            this.f33792m = k.j(typedArray, xmlPullParser, "trimPathOffset", 7, this.f33792m);
            this.f33790k = k.j(typedArray, xmlPullParser, "trimPathStart", 5, this.f33790k);
            this.f33811c = k.k(typedArray, xmlPullParser, "fillType", 13, this.f33811c);
        }

        public void setFillAlpha(float f10) {
            this.f33789j = f10;
        }

        public void setFillColor(int i10) {
            this.f33787h.k(i10);
        }

        public void setStrokeAlpha(float f10) {
            this.f33788i = f10;
        }

        public void setStrokeColor(int i10) {
            this.f33785f.k(i10);
        }

        public void setStrokeWidth(float f10) {
            this.f33786g = f10;
        }

        public void setTrimPathEnd(float f10) {
            this.f33791l = f10;
        }

        public void setTrimPathOffset(float f10) {
            this.f33792m = f10;
        }

        public void setTrimPathStart(float f10) {
            this.f33790k = f10;
        }

        public c(c cVar) {
            super(cVar);
            this.f33786g = 0.0f;
            this.f33788i = 1.0f;
            this.f33789j = 1.0f;
            this.f33790k = 0.0f;
            this.f33791l = 1.0f;
            this.f33792m = 0.0f;
            this.f33793n = Paint.Cap.BUTT;
            this.f33794o = Paint.Join.MITER;
            this.f33795p = 4.0f;
            this.f33784e = cVar.f33784e;
            this.f33785f = cVar.f33785f;
            this.f33786g = cVar.f33786g;
            this.f33788i = cVar.f33788i;
            this.f33787h = cVar.f33787h;
            this.f33811c = cVar.f33811c;
            this.f33789j = cVar.f33789j;
            this.f33790k = cVar.f33790k;
            this.f33791l = cVar.f33791l;
            this.f33792m = cVar.f33792m;
            this.f33793n = cVar.f33793n;
            this.f33794o = cVar.f33794o;
            this.f33795p = cVar.f33795p;
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: j0.g$g, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0319g {

        /* renamed from: q, reason: collision with root package name */
        public static final Matrix f33813q = new Matrix();

        /* renamed from: a, reason: collision with root package name */
        public final Path f33814a;

        /* renamed from: b, reason: collision with root package name */
        public final Path f33815b;

        /* renamed from: c, reason: collision with root package name */
        public final Matrix f33816c;

        /* renamed from: d, reason: collision with root package name */
        public Paint f33817d;

        /* renamed from: e, reason: collision with root package name */
        public Paint f33818e;

        /* renamed from: f, reason: collision with root package name */
        public PathMeasure f33819f;

        /* renamed from: g, reason: collision with root package name */
        public int f33820g;

        /* renamed from: h, reason: collision with root package name */
        public final d f33821h;

        /* renamed from: i, reason: collision with root package name */
        public float f33822i;

        /* renamed from: j, reason: collision with root package name */
        public float f33823j;

        /* renamed from: k, reason: collision with root package name */
        public float f33824k;

        /* renamed from: l, reason: collision with root package name */
        public float f33825l;

        /* renamed from: m, reason: collision with root package name */
        public int f33826m;

        /* renamed from: n, reason: collision with root package name */
        public String f33827n;

        /* renamed from: o, reason: collision with root package name */
        public Boolean f33828o;

        /* renamed from: p, reason: collision with root package name */
        public final C1415a<String, Object> f33829p;

        public C0319g() {
            this.f33816c = new Matrix();
            this.f33822i = 0.0f;
            this.f33823j = 0.0f;
            this.f33824k = 0.0f;
            this.f33825l = 0.0f;
            this.f33826m = 255;
            this.f33827n = null;
            this.f33828o = null;
            this.f33829p = new C1415a<>();
            this.f33821h = new d();
            this.f33814a = new Path();
            this.f33815b = new Path();
        }

        public static float a(float f10, float f11, float f12, float f13) {
            return (f10 * f13) - (f11 * f12);
        }

        public void b(Canvas canvas, int i10, int i11, ColorFilter colorFilter) {
            c(this.f33821h, f33813q, canvas, i10, i11, colorFilter);
        }

        public final void c(d dVar, Matrix matrix, Canvas canvas, int i10, int i11, ColorFilter colorFilter) {
            dVar.f33796a.set(matrix);
            dVar.f33796a.preConcat(dVar.f33805j);
            canvas.save();
            for (int i12 = 0; i12 < dVar.f33797b.size(); i12++) {
                e eVar = dVar.f33797b.get(i12);
                if (eVar instanceof d) {
                    c((d) eVar, dVar.f33796a, canvas, i10, i11, colorFilter);
                } else if (eVar instanceof f) {
                    d(dVar, (f) eVar, canvas, i10, i11, colorFilter);
                }
            }
            canvas.restore();
        }

        public final void d(d dVar, f fVar, Canvas canvas, int i10, int i11, ColorFilter colorFilter) {
            Path.FillType fillType;
            Path.FillType fillType2;
            float f10 = i10 / this.f33824k;
            float f11 = i11 / this.f33825l;
            float min = Math.min(f10, f11);
            Matrix matrix = dVar.f33796a;
            this.f33816c.set(matrix);
            this.f33816c.postScale(f10, f11);
            float e10 = e(matrix);
            if (e10 == 0.0f) {
                return;
            }
            fVar.d(this.f33814a);
            Path path = this.f33814a;
            this.f33815b.reset();
            if (fVar.c()) {
                Path path2 = this.f33815b;
                if (fVar.f33811c == 0) {
                    fillType2 = Path.FillType.WINDING;
                } else {
                    fillType2 = Path.FillType.EVEN_ODD;
                }
                path2.setFillType(fillType2);
                this.f33815b.addPath(path, this.f33816c);
                canvas.clipPath(this.f33815b);
                return;
            }
            c cVar = (c) fVar;
            float f12 = cVar.f33790k;
            if (f12 != 0.0f || cVar.f33791l != 1.0f) {
                float f13 = cVar.f33792m;
                float f14 = (f12 + f13) % 1.0f;
                float f15 = (cVar.f33791l + f13) % 1.0f;
                if (this.f33819f == null) {
                    this.f33819f = new PathMeasure();
                }
                this.f33819f.setPath(this.f33814a, false);
                float length = this.f33819f.getLength();
                float f16 = f14 * length;
                float f17 = f15 * length;
                path.reset();
                if (f16 > f17) {
                    this.f33819f.getSegment(f16, length, path, true);
                    this.f33819f.getSegment(0.0f, f17, path, true);
                } else {
                    this.f33819f.getSegment(f16, f17, path, true);
                }
                path.rLineTo(0.0f, 0.0f);
            }
            this.f33815b.addPath(path, this.f33816c);
            if (cVar.f33787h.l()) {
                A.d dVar2 = cVar.f33787h;
                if (this.f33818e == null) {
                    Paint paint = new Paint(1);
                    this.f33818e = paint;
                    paint.setStyle(Paint.Style.FILL);
                }
                Paint paint2 = this.f33818e;
                if (dVar2.h()) {
                    Shader f18 = dVar2.f();
                    f18.setLocalMatrix(this.f33816c);
                    paint2.setShader(f18);
                    paint2.setAlpha(Math.round(cVar.f33789j * 255.0f));
                } else {
                    paint2.setShader(null);
                    paint2.setAlpha(255);
                    paint2.setColor(C1157g.a(dVar2.e(), cVar.f33789j));
                }
                paint2.setColorFilter(colorFilter);
                Path path3 = this.f33815b;
                if (cVar.f33811c == 0) {
                    fillType = Path.FillType.WINDING;
                } else {
                    fillType = Path.FillType.EVEN_ODD;
                }
                path3.setFillType(fillType);
                canvas.drawPath(this.f33815b, paint2);
            }
            if (cVar.f33785f.l()) {
                A.d dVar3 = cVar.f33785f;
                if (this.f33817d == null) {
                    Paint paint3 = new Paint(1);
                    this.f33817d = paint3;
                    paint3.setStyle(Paint.Style.STROKE);
                }
                Paint paint4 = this.f33817d;
                Paint.Join join = cVar.f33794o;
                if (join != null) {
                    paint4.setStrokeJoin(join);
                }
                Paint.Cap cap = cVar.f33793n;
                if (cap != null) {
                    paint4.setStrokeCap(cap);
                }
                paint4.setStrokeMiter(cVar.f33795p);
                if (dVar3.h()) {
                    Shader f19 = dVar3.f();
                    f19.setLocalMatrix(this.f33816c);
                    paint4.setShader(f19);
                    paint4.setAlpha(Math.round(cVar.f33788i * 255.0f));
                } else {
                    paint4.setShader(null);
                    paint4.setAlpha(255);
                    paint4.setColor(C1157g.a(dVar3.e(), cVar.f33788i));
                }
                paint4.setColorFilter(colorFilter);
                paint4.setStrokeWidth(cVar.f33786g * min * e10);
                canvas.drawPath(this.f33815b, paint4);
            }
        }

        public final float e(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float hypot = (float) Math.hypot(fArr[0], fArr[1]);
            float hypot2 = (float) Math.hypot(fArr[2], fArr[3]);
            float a10 = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max(hypot, hypot2);
            if (max <= 0.0f) {
                return 0.0f;
            }
            return Math.abs(a10) / max;
        }

        public boolean f() {
            if (this.f33828o == null) {
                this.f33828o = Boolean.valueOf(this.f33821h.a());
            }
            return this.f33828o.booleanValue();
        }

        public boolean g(int[] iArr) {
            return this.f33821h.b(iArr);
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public int getRootAlpha() {
            return this.f33826m;
        }

        public void setAlpha(float f10) {
            setRootAlpha((int) (f10 * 255.0f));
        }

        public void setRootAlpha(int i10) {
            this.f33826m = i10;
        }

        public C0319g(C0319g c0319g) {
            this.f33816c = new Matrix();
            this.f33822i = 0.0f;
            this.f33823j = 0.0f;
            this.f33824k = 0.0f;
            this.f33825l = 0.0f;
            this.f33826m = 255;
            this.f33827n = null;
            this.f33828o = null;
            C1415a<String, Object> c1415a = new C1415a<>();
            this.f33829p = c1415a;
            this.f33821h = new d(c0319g.f33821h, c1415a);
            this.f33814a = new Path(c0319g.f33814a);
            this.f33815b = new Path(c0319g.f33815b);
            this.f33822i = c0319g.f33822i;
            this.f33823j = c0319g.f33823j;
            this.f33824k = c0319g.f33824k;
            this.f33825l = c0319g.f33825l;
            this.f33820g = c0319g.f33820g;
            this.f33826m = c0319g.f33826m;
            this.f33827n = c0319g.f33827n;
            String str = c0319g.f33827n;
            if (str != null) {
                c1415a.put(str, this);
            }
            this.f33828o = c0319g.f33828o;
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: j0.g$d */
    /* loaded from: classes.dex */
    public static class d extends e {

        /* renamed from: a, reason: collision with root package name */
        public final Matrix f33796a;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList<e> f33797b;

        /* renamed from: c, reason: collision with root package name */
        public float f33798c;

        /* renamed from: d, reason: collision with root package name */
        public float f33799d;

        /* renamed from: e, reason: collision with root package name */
        public float f33800e;

        /* renamed from: f, reason: collision with root package name */
        public float f33801f;

        /* renamed from: g, reason: collision with root package name */
        public float f33802g;

        /* renamed from: h, reason: collision with root package name */
        public float f33803h;

        /* renamed from: i, reason: collision with root package name */
        public float f33804i;

        /* renamed from: j, reason: collision with root package name */
        public final Matrix f33805j;

        /* renamed from: k, reason: collision with root package name */
        public int f33806k;

        /* renamed from: l, reason: collision with root package name */
        public int[] f33807l;

        /* renamed from: m, reason: collision with root package name */
        public String f33808m;

        public d(d dVar, C1415a<String, Object> c1415a) {
            super();
            f bVar;
            this.f33796a = new Matrix();
            this.f33797b = new ArrayList<>();
            this.f33798c = 0.0f;
            this.f33799d = 0.0f;
            this.f33800e = 0.0f;
            this.f33801f = 1.0f;
            this.f33802g = 1.0f;
            this.f33803h = 0.0f;
            this.f33804i = 0.0f;
            Matrix matrix = new Matrix();
            this.f33805j = matrix;
            this.f33808m = null;
            this.f33798c = dVar.f33798c;
            this.f33799d = dVar.f33799d;
            this.f33800e = dVar.f33800e;
            this.f33801f = dVar.f33801f;
            this.f33802g = dVar.f33802g;
            this.f33803h = dVar.f33803h;
            this.f33804i = dVar.f33804i;
            this.f33807l = dVar.f33807l;
            String str = dVar.f33808m;
            this.f33808m = str;
            this.f33806k = dVar.f33806k;
            if (str != null) {
                c1415a.put(str, this);
            }
            matrix.set(dVar.f33805j);
            ArrayList<e> arrayList = dVar.f33797b;
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                e eVar = arrayList.get(i10);
                if (eVar instanceof d) {
                    this.f33797b.add(new d((d) eVar, c1415a));
                } else {
                    if (eVar instanceof c) {
                        bVar = new c((c) eVar);
                    } else if (eVar instanceof b) {
                        bVar = new b((b) eVar);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f33797b.add(bVar);
                    String str2 = bVar.f33810b;
                    if (str2 != null) {
                        c1415a.put(str2, bVar);
                    }
                }
            }
        }

        @Override // j0.C1157g.e
        public boolean a() {
            for (int i10 = 0; i10 < this.f33797b.size(); i10++) {
                if (this.f33797b.get(i10).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // j0.C1157g.e
        public boolean b(int[] iArr) {
            boolean z10 = false;
            for (int i10 = 0; i10 < this.f33797b.size(); i10++) {
                z10 |= this.f33797b.get(i10).b(iArr);
            }
            return z10;
        }

        public void c(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray s10 = k.s(resources, theme, attributeSet, C1151a.f33745b);
            e(s10, xmlPullParser);
            s10.recycle();
        }

        public final void d() {
            this.f33805j.reset();
            this.f33805j.postTranslate(-this.f33799d, -this.f33800e);
            this.f33805j.postScale(this.f33801f, this.f33802g);
            this.f33805j.postRotate(this.f33798c, 0.0f, 0.0f);
            this.f33805j.postTranslate(this.f33803h + this.f33799d, this.f33804i + this.f33800e);
        }

        public final void e(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f33807l = null;
            this.f33798c = k.j(typedArray, xmlPullParser, "rotation", 5, this.f33798c);
            this.f33799d = typedArray.getFloat(1, this.f33799d);
            this.f33800e = typedArray.getFloat(2, this.f33800e);
            this.f33801f = k.j(typedArray, xmlPullParser, "scaleX", 3, this.f33801f);
            this.f33802g = k.j(typedArray, xmlPullParser, "scaleY", 4, this.f33802g);
            this.f33803h = k.j(typedArray, xmlPullParser, "translateX", 6, this.f33803h);
            this.f33804i = k.j(typedArray, xmlPullParser, "translateY", 7, this.f33804i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.f33808m = string;
            }
            d();
        }

        public String getGroupName() {
            return this.f33808m;
        }

        public Matrix getLocalMatrix() {
            return this.f33805j;
        }

        public float getPivotX() {
            return this.f33799d;
        }

        public float getPivotY() {
            return this.f33800e;
        }

        public float getRotation() {
            return this.f33798c;
        }

        public float getScaleX() {
            return this.f33801f;
        }

        public float getScaleY() {
            return this.f33802g;
        }

        public float getTranslateX() {
            return this.f33803h;
        }

        public float getTranslateY() {
            return this.f33804i;
        }

        public void setPivotX(float f10) {
            if (f10 != this.f33799d) {
                this.f33799d = f10;
                d();
            }
        }

        public void setPivotY(float f10) {
            if (f10 != this.f33800e) {
                this.f33800e = f10;
                d();
            }
        }

        public void setRotation(float f10) {
            if (f10 != this.f33798c) {
                this.f33798c = f10;
                d();
            }
        }

        public void setScaleX(float f10) {
            if (f10 != this.f33801f) {
                this.f33801f = f10;
                d();
            }
        }

        public void setScaleY(float f10) {
            if (f10 != this.f33802g) {
                this.f33802g = f10;
                d();
            }
        }

        public void setTranslateX(float f10) {
            if (f10 != this.f33803h) {
                this.f33803h = f10;
                d();
            }
        }

        public void setTranslateY(float f10) {
            if (f10 != this.f33804i) {
                this.f33804i = f10;
                d();
            }
        }

        public d() {
            super();
            this.f33796a = new Matrix();
            this.f33797b = new ArrayList<>();
            this.f33798c = 0.0f;
            this.f33799d = 0.0f;
            this.f33800e = 0.0f;
            this.f33801f = 1.0f;
            this.f33802g = 1.0f;
            this.f33803h = 0.0f;
            this.f33804i = 0.0f;
            this.f33805j = new Matrix();
            this.f33808m = null;
        }
    }
}
