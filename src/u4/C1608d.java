package u4;

import A.h;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;
import e4.m;

/* compiled from: TextAppearance.java */
/* renamed from: u4.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1608d {

    /* renamed from: a, reason: collision with root package name */
    public final ColorStateList f37322a;

    /* renamed from: b, reason: collision with root package name */
    public final ColorStateList f37323b;

    /* renamed from: c, reason: collision with root package name */
    public final ColorStateList f37324c;

    /* renamed from: d, reason: collision with root package name */
    public final String f37325d;

    /* renamed from: e, reason: collision with root package name */
    public final int f37326e;

    /* renamed from: f, reason: collision with root package name */
    public final int f37327f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f37328g;

    /* renamed from: h, reason: collision with root package name */
    public final float f37329h;

    /* renamed from: i, reason: collision with root package name */
    public final float f37330i;

    /* renamed from: j, reason: collision with root package name */
    public final float f37331j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f37332k;

    /* renamed from: l, reason: collision with root package name */
    public final float f37333l;

    /* renamed from: m, reason: collision with root package name */
    public ColorStateList f37334m;

    /* renamed from: n, reason: collision with root package name */
    public float f37335n;

    /* renamed from: o, reason: collision with root package name */
    public final int f37336o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f37337p = false;

    /* renamed from: q, reason: collision with root package name */
    public Typeface f37338q;

    /* compiled from: TextAppearance.java */
    /* renamed from: u4.d$a */
    /* loaded from: classes3.dex */
    public class a extends h.e {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f37339a;

        public a(f fVar) {
            this.f37339a = fVar;
        }

        @Override // A.h.e
        /* renamed from: h */
        public void f(int i10) {
            C1608d.this.f37337p = true;
            this.f37339a.onFontRetrievalFailed(i10);
        }

        @Override // A.h.e
        /* renamed from: i */
        public void g(Typeface typeface) {
            C1608d c1608d = C1608d.this;
            c1608d.f37338q = Typeface.create(typeface, c1608d.f37326e);
            C1608d.this.f37337p = true;
            this.f37339a.onFontRetrieved(C1608d.this.f37338q, false);
        }
    }

    /* compiled from: TextAppearance.java */
    /* renamed from: u4.d$b */
    /* loaded from: classes3.dex */
    public class b extends f {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f37341a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TextPaint f37342b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ f f37343c;

        public b(Context context, TextPaint textPaint, f fVar) {
            this.f37341a = context;
            this.f37342b = textPaint;
            this.f37343c = fVar;
        }

        @Override // u4.f
        public void onFontRetrievalFailed(int i10) {
            this.f37343c.onFontRetrievalFailed(i10);
        }

        @Override // u4.f
        public void onFontRetrieved(Typeface typeface, boolean z10) {
            C1608d.this.p(this.f37341a, this.f37342b, typeface);
            this.f37343c.onFontRetrieved(typeface, z10);
        }
    }

    public C1608d(Context context, int i10) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i10, m.Wa);
        l(obtainStyledAttributes.getDimension(m.Xa, 0.0f));
        k(C1607c.a(context, obtainStyledAttributes, m.ab));
        this.f37322a = C1607c.a(context, obtainStyledAttributes, m.bb);
        this.f37323b = C1607c.a(context, obtainStyledAttributes, m.cb);
        this.f37326e = obtainStyledAttributes.getInt(m.Za, 0);
        this.f37327f = obtainStyledAttributes.getInt(m.Ya, 1);
        int g10 = C1607c.g(obtainStyledAttributes, m.ib, m.hb);
        this.f37336o = obtainStyledAttributes.getResourceId(g10, 0);
        this.f37325d = obtainStyledAttributes.getString(g10);
        this.f37328g = obtainStyledAttributes.getBoolean(m.jb, false);
        this.f37324c = C1607c.a(context, obtainStyledAttributes, m.db);
        this.f37329h = obtainStyledAttributes.getFloat(m.eb, 0.0f);
        this.f37330i = obtainStyledAttributes.getFloat(m.fb, 0.0f);
        this.f37331j = obtainStyledAttributes.getFloat(m.gb, 0.0f);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(i10, m.f31500p6);
        int i11 = m.f31511q6;
        this.f37332k = obtainStyledAttributes2.hasValue(i11);
        this.f37333l = obtainStyledAttributes2.getFloat(i11, 0.0f);
        obtainStyledAttributes2.recycle();
    }

    public final void d() {
        String str;
        if (this.f37338q == null && (str = this.f37325d) != null) {
            this.f37338q = Typeface.create(str, this.f37326e);
        }
        if (this.f37338q == null) {
            int i10 = this.f37327f;
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        this.f37338q = Typeface.DEFAULT;
                    } else {
                        this.f37338q = Typeface.MONOSPACE;
                    }
                } else {
                    this.f37338q = Typeface.SERIF;
                }
            } else {
                this.f37338q = Typeface.SANS_SERIF;
            }
            this.f37338q = Typeface.create(this.f37338q, this.f37326e);
        }
    }

    public Typeface e() {
        d();
        return this.f37338q;
    }

    public Typeface f(Context context) {
        if (this.f37337p) {
            return this.f37338q;
        }
        if (!context.isRestricted()) {
            try {
                Typeface h10 = h.h(context, this.f37336o);
                this.f37338q = h10;
                if (h10 != null) {
                    this.f37338q = Typeface.create(h10, this.f37326e);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e10) {
                Log.d("TextAppearance", "Error loading font " + this.f37325d, e10);
            }
        }
        d();
        this.f37337p = true;
        return this.f37338q;
    }

    public void g(Context context, TextPaint textPaint, f fVar) {
        p(context, textPaint, e());
        h(context, new b(context, textPaint, fVar));
    }

    public void h(Context context, f fVar) {
        if (m(context)) {
            f(context);
        } else {
            d();
        }
        int i10 = this.f37336o;
        if (i10 == 0) {
            this.f37337p = true;
        }
        if (this.f37337p) {
            fVar.onFontRetrieved(this.f37338q, true);
            return;
        }
        try {
            h.j(context, i10, new a(fVar), null);
        } catch (Resources.NotFoundException unused) {
            this.f37337p = true;
            fVar.onFontRetrievalFailed(1);
        } catch (Exception e10) {
            Log.d("TextAppearance", "Error loading font " + this.f37325d, e10);
            this.f37337p = true;
            fVar.onFontRetrievalFailed(-3);
        }
    }

    public ColorStateList i() {
        return this.f37334m;
    }

    public float j() {
        return this.f37335n;
    }

    public void k(ColorStateList colorStateList) {
        this.f37334m = colorStateList;
    }

    public void l(float f10) {
        this.f37335n = f10;
    }

    public final boolean m(Context context) {
        Typeface typeface;
        if (e.a()) {
            return true;
        }
        int i10 = this.f37336o;
        if (i10 != 0) {
            typeface = h.c(context, i10);
        } else {
            typeface = null;
        }
        if (typeface != null) {
            return true;
        }
        return false;
    }

    public void n(Context context, TextPaint textPaint, f fVar) {
        int i10;
        int i11;
        o(context, textPaint, fVar);
        ColorStateList colorStateList = this.f37334m;
        if (colorStateList != null) {
            i10 = colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor());
        } else {
            i10 = -16777216;
        }
        textPaint.setColor(i10);
        float f10 = this.f37331j;
        float f11 = this.f37329h;
        float f12 = this.f37330i;
        ColorStateList colorStateList2 = this.f37324c;
        if (colorStateList2 != null) {
            i11 = colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor());
        } else {
            i11 = 0;
        }
        textPaint.setShadowLayer(f10, f11, f12, i11);
    }

    public void o(Context context, TextPaint textPaint, f fVar) {
        if (m(context)) {
            p(context, textPaint, f(context));
        } else {
            g(context, textPaint, fVar);
        }
    }

    public void p(Context context, TextPaint textPaint, Typeface typeface) {
        boolean z10;
        float f10;
        Typeface a10 = g.a(context, typeface);
        if (a10 != null) {
            typeface = a10;
        }
        textPaint.setTypeface(typeface);
        int i10 = this.f37326e & (~typeface.getStyle());
        if ((i10 & 1) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        textPaint.setFakeBoldText(z10);
        if ((i10 & 2) != 0) {
            f10 = -0.25f;
        } else {
            f10 = 0.0f;
        }
        textPaint.setTextSkewX(f10);
        textPaint.setTextSize(this.f37335n);
        if (this.f37332k) {
            textPaint.setLetterSpacing(this.f37333l);
        }
    }
}
