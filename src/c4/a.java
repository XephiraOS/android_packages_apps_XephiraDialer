package C4;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ThemeEnforcement;
import e4.C0977c;
import e4.C0979e;
import e4.l;
import e4.m;
import f4.C1001b;
import l4.C1292a;
import u4.C1607c;
import u4.C1608d;
import x4.g;
import x4.h;
import x4.i;
import x4.k;

/* compiled from: TooltipDrawable.java */
/* loaded from: classes3.dex */
public class a extends i implements TextDrawableHelper.TextDrawableDelegate {

    /* renamed from: x, reason: collision with root package name */
    public static final int f342x = l.f31017S;

    /* renamed from: y, reason: collision with root package name */
    public static final int f343y = C0977c.f30633E0;

    /* renamed from: a, reason: collision with root package name */
    public CharSequence f344a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f345b;

    /* renamed from: c, reason: collision with root package name */
    public final Paint.FontMetrics f346c;

    /* renamed from: d, reason: collision with root package name */
    public final TextDrawableHelper f347d;

    /* renamed from: e, reason: collision with root package name */
    public final View.OnLayoutChangeListener f348e;

    /* renamed from: f, reason: collision with root package name */
    public final Rect f349f;

    /* renamed from: g, reason: collision with root package name */
    public int f350g;

    /* renamed from: h, reason: collision with root package name */
    public int f351h;

    /* renamed from: i, reason: collision with root package name */
    public int f352i;

    /* renamed from: j, reason: collision with root package name */
    public int f353j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f354k;

    /* renamed from: l, reason: collision with root package name */
    public int f355l;

    /* renamed from: m, reason: collision with root package name */
    public int f356m;

    /* renamed from: n, reason: collision with root package name */
    public float f357n;

    /* renamed from: o, reason: collision with root package name */
    public float f358o;

    /* renamed from: p, reason: collision with root package name */
    public final float f359p;

    /* renamed from: q, reason: collision with root package name */
    public float f360q;

    /* renamed from: r, reason: collision with root package name */
    public float f361r;

    /* compiled from: TooltipDrawable.java */
    /* renamed from: C4.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class ViewOnLayoutChangeListenerC0008a implements View.OnLayoutChangeListener {
        public ViewOnLayoutChangeListenerC0008a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            a.this.o(view);
        }
    }

    public a(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f346c = new Paint.FontMetrics();
        TextDrawableHelper textDrawableHelper = new TextDrawableHelper(this);
        this.f347d = textDrawableHelper;
        this.f348e = new ViewOnLayoutChangeListenerC0008a();
        this.f349f = new Rect();
        this.f357n = 1.0f;
        this.f358o = 1.0f;
        this.f359p = 0.5f;
        this.f360q = 0.5f;
        this.f361r = 1.0f;
        this.f345b = context;
        textDrawableHelper.getTextPaint().density = context.getResources().getDisplayMetrics().density;
        textDrawableHelper.getTextPaint().setTextAlign(Paint.Align.CENTER);
    }

    private float c() {
        this.f347d.getTextPaint().getFontMetrics(this.f346c);
        Paint.FontMetrics fontMetrics = this.f346c;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    public static a e(Context context, AttributeSet attributeSet, int i10, int i11) {
        a aVar = new a(context, attributeSet, i10, i11);
        aVar.j(attributeSet, i10, i11);
        return aVar;
    }

    private void j(AttributeSet attributeSet, int i10, int i11) {
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(this.f345b, attributeSet, m.Mc, i10, i11, new int[0]);
        this.f355l = this.f345b.getResources().getDimensionPixelSize(C0979e.f30768W0);
        boolean z10 = obtainStyledAttributes.getBoolean(m.Vc, true);
        this.f354k = z10;
        if (z10) {
            setShapeAppearanceModel(getShapeAppearanceModel().v().s(f()).m());
        } else {
            this.f355l = 0;
        }
        m(obtainStyledAttributes.getText(m.Tc));
        C1608d h10 = C1607c.h(this.f345b, obtainStyledAttributes, m.Nc);
        if (h10 != null) {
            int i12 = m.Oc;
            if (obtainStyledAttributes.hasValue(i12)) {
                h10.k(C1607c.a(this.f345b, obtainStyledAttributes, i12));
            }
        }
        n(h10);
        setFillColor(ColorStateList.valueOf(obtainStyledAttributes.getColor(m.Uc, C1292a.i(B.a.w(C1292a.c(this.f345b, R.attr.colorBackground, a.class.getCanonicalName()), 229), B.a.w(C1292a.c(this.f345b, C0977c.f30687q, a.class.getCanonicalName()), 153)))));
        setStrokeColor(ColorStateList.valueOf(C1292a.c(this.f345b, C0977c.f30697v, a.class.getCanonicalName())));
        this.f350g = obtainStyledAttributes.getDimensionPixelSize(m.Pc, 0);
        this.f351h = obtainStyledAttributes.getDimensionPixelSize(m.Rc, 0);
        this.f352i = obtainStyledAttributes.getDimensionPixelSize(m.Sc, 0);
        this.f353j = obtainStyledAttributes.getDimensionPixelSize(m.Qc, 0);
        obtainStyledAttributes.recycle();
    }

    public final float b() {
        int i10;
        if (((this.f349f.right - getBounds().right) - this.f356m) - this.f353j < 0) {
            i10 = ((this.f349f.right - getBounds().right) - this.f356m) - this.f353j;
        } else if (((this.f349f.left - getBounds().left) - this.f356m) + this.f353j > 0) {
            i10 = ((this.f349f.left - getBounds().left) - this.f356m) + this.f353j;
        } else {
            return 0.0f;
        }
        return i10;
    }

    public final float d(Rect rect) {
        return rect.centerY() - c();
    }

    @Override // x4.i, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.save();
        float b10 = b();
        float f10 = (float) (-((this.f355l * Math.sqrt(2.0d)) - this.f355l));
        canvas.scale(this.f357n, this.f358o, getBounds().left + (getBounds().width() * 0.5f), getBounds().top + (getBounds().height() * this.f360q));
        canvas.translate(b10, f10);
        super.draw(canvas);
        h(canvas);
        canvas.restore();
    }

    public final g f() {
        float f10 = -b();
        float width = ((float) (getBounds().width() - (this.f355l * Math.sqrt(2.0d)))) / 2.0f;
        return new k(new h(this.f355l), Math.min(Math.max(f10, -width), width));
    }

    public void g(View view) {
        if (view == null) {
            return;
        }
        view.removeOnLayoutChangeListener(this.f348e);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) Math.max(this.f347d.getTextPaint().getTextSize(), this.f352i);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) Math.max((this.f350g * 2) + i(), this.f351h);
    }

    public final void h(Canvas canvas) {
        if (this.f344a == null) {
            return;
        }
        int d10 = (int) d(getBounds());
        if (this.f347d.getTextAppearance() != null) {
            this.f347d.getTextPaint().drawableState = getState();
            this.f347d.updateTextPaintDrawState(this.f345b);
            this.f347d.getTextPaint().setAlpha((int) (this.f361r * 255.0f));
        }
        CharSequence charSequence = this.f344a;
        canvas.drawText(charSequence, 0, charSequence.length(), r0.centerX(), d10, this.f347d.getTextPaint());
    }

    public final float i() {
        CharSequence charSequence = this.f344a;
        if (charSequence == null) {
            return 0.0f;
        }
        return this.f347d.getTextWidth(charSequence.toString());
    }

    public void k(View view) {
        if (view == null) {
            return;
        }
        o(view);
        view.addOnLayoutChangeListener(this.f348e);
    }

    public void l(float f10) {
        this.f360q = 1.2f;
        this.f357n = f10;
        this.f358o = f10;
        this.f361r = C1001b.b(0.0f, 1.0f, 0.19f, 1.0f, f10);
        invalidateSelf();
    }

    public void m(CharSequence charSequence) {
        if (!TextUtils.equals(this.f344a, charSequence)) {
            this.f344a = charSequence;
            this.f347d.setTextWidthDirty(true);
            invalidateSelf();
        }
    }

    public void n(C1608d c1608d) {
        this.f347d.setTextAppearance(c1608d, this.f345b);
    }

    public final void o(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        this.f356m = iArr[0];
        view.getWindowVisibleDisplayFrame(this.f349f);
    }

    @Override // x4.i, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.f354k) {
            setShapeAppearanceModel(getShapeAppearanceModel().v().s(f()).m());
        }
    }

    @Override // x4.i, android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    @Override // com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public void onTextSizeChange() {
        invalidateSelf();
    }
}
