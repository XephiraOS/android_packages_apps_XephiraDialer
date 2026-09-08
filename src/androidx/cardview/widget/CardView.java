package androidx.cardview.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import n.C1348a;
import n.b;
import n.c;
import n.d;
import o.C1383a;
import o.InterfaceC1384b;
import o.InterfaceC1385c;

/* loaded from: classes.dex */
public class CardView extends FrameLayout {

    /* renamed from: h, reason: collision with root package name */
    public static final int[] f7949h = {R.attr.colorBackground};

    /* renamed from: i, reason: collision with root package name */
    public static final InterfaceC1385c f7950i;

    /* renamed from: a, reason: collision with root package name */
    public boolean f7951a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f7952b;

    /* renamed from: c, reason: collision with root package name */
    public int f7953c;

    /* renamed from: d, reason: collision with root package name */
    public int f7954d;

    /* renamed from: e, reason: collision with root package name */
    public final Rect f7955e;

    /* renamed from: f, reason: collision with root package name */
    public final Rect f7956f;

    /* renamed from: g, reason: collision with root package name */
    public final InterfaceC1384b f7957g;

    /* loaded from: classes.dex */
    public class a implements InterfaceC1384b {

        /* renamed from: a, reason: collision with root package name */
        public Drawable f7958a;

        public a() {
        }

        @Override // o.InterfaceC1384b
        public Drawable getCardBackground() {
            return this.f7958a;
        }

        @Override // o.InterfaceC1384b
        public View getCardView() {
            return CardView.this;
        }

        @Override // o.InterfaceC1384b
        public boolean getPreventCornerOverlap() {
            return CardView.this.getPreventCornerOverlap();
        }

        @Override // o.InterfaceC1384b
        public boolean getUseCompatPadding() {
            return CardView.this.getUseCompatPadding();
        }

        @Override // o.InterfaceC1384b
        public void setCardBackground(Drawable drawable) {
            this.f7958a = drawable;
            CardView.this.setBackgroundDrawable(drawable);
        }

        @Override // o.InterfaceC1384b
        public void setShadowPadding(int i10, int i11, int i12, int i13) {
            CardView.this.f7956f.set(i10, i11, i12, i13);
            CardView cardView = CardView.this;
            Rect rect = cardView.f7955e;
            CardView.super.setPadding(i10 + rect.left, i11 + rect.top, i12 + rect.right, i13 + rect.bottom);
        }
    }

    static {
        C1383a c1383a = new C1383a();
        f7950i = c1383a;
        c1383a.initStatic();
    }

    public CardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C1348a.f35512a);
    }

    public void f(int i10, int i11, int i12, int i13) {
        this.f7955e.set(i10, i11, i12, i13);
        f7950i.f(this.f7957g);
    }

    public ColorStateList getCardBackgroundColor() {
        return f7950i.i(this.f7957g);
    }

    public float getCardElevation() {
        return f7950i.g(this.f7957g);
    }

    public int getContentPaddingBottom() {
        return this.f7955e.bottom;
    }

    public int getContentPaddingLeft() {
        return this.f7955e.left;
    }

    public int getContentPaddingRight() {
        return this.f7955e.right;
    }

    public int getContentPaddingTop() {
        return this.f7955e.top;
    }

    public float getMaxCardElevation() {
        return f7950i.j(this.f7957g);
    }

    public boolean getPreventCornerOverlap() {
        return this.f7952b;
    }

    public float getRadius() {
        return f7950i.e(this.f7957g);
    }

    public boolean getUseCompatPadding() {
        return this.f7951a;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        if (!(f7950i instanceof C1383a)) {
            int mode = View.MeasureSpec.getMode(i10);
            if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                i10 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(r0.b(this.f7957g)), View.MeasureSpec.getSize(i10)), mode);
            }
            int mode2 = View.MeasureSpec.getMode(i11);
            if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                i11 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(r0.l(this.f7957g)), View.MeasureSpec.getSize(i11)), mode2);
            }
            super.onMeasure(i10, i11);
            return;
        }
        super.onMeasure(i10, i11);
    }

    public void setCardBackgroundColor(int i10) {
        f7950i.m(this.f7957g, ColorStateList.valueOf(i10));
    }

    public void setCardElevation(float f10) {
        f7950i.h(this.f7957g, f10);
    }

    public void setMaxCardElevation(float f10) {
        f7950i.k(this.f7957g, f10);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i10) {
        this.f7954d = i10;
        super.setMinimumHeight(i10);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i10) {
        this.f7953c = i10;
        super.setMinimumWidth(i10);
    }

    public void setPreventCornerOverlap(boolean z10) {
        if (z10 != this.f7952b) {
            this.f7952b = z10;
            f7950i.d(this.f7957g);
        }
    }

    public void setRadius(float f10) {
        f7950i.n(this.f7957g, f10);
    }

    public void setUseCompatPadding(boolean z10) {
        if (this.f7951a != z10) {
            this.f7951a = z10;
            f7950i.a(this.f7957g);
        }
    }

    public CardView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        int color;
        ColorStateList valueOf;
        Rect rect = new Rect();
        this.f7955e = rect;
        this.f7956f = new Rect();
        a aVar = new a();
        this.f7957g = aVar;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.f35516a, i10, c.f35515a);
        int i11 = d.f35519d;
        if (obtainStyledAttributes.hasValue(i11)) {
            valueOf = obtainStyledAttributes.getColorStateList(i11);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(f7949h);
            int color2 = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color2, fArr);
            if (fArr[2] > 0.5f) {
                color = getResources().getColor(b.f35514b);
            } else {
                color = getResources().getColor(b.f35513a);
            }
            valueOf = ColorStateList.valueOf(color);
        }
        ColorStateList colorStateList = valueOf;
        float dimension = obtainStyledAttributes.getDimension(d.f35520e, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(d.f35521f, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(d.f35522g, 0.0f);
        this.f7951a = obtainStyledAttributes.getBoolean(d.f35524i, false);
        this.f7952b = obtainStyledAttributes.getBoolean(d.f35523h, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(d.f35525j, 0);
        rect.left = obtainStyledAttributes.getDimensionPixelSize(d.f35527l, dimensionPixelSize);
        rect.top = obtainStyledAttributes.getDimensionPixelSize(d.f35529n, dimensionPixelSize);
        rect.right = obtainStyledAttributes.getDimensionPixelSize(d.f35528m, dimensionPixelSize);
        rect.bottom = obtainStyledAttributes.getDimensionPixelSize(d.f35526k, dimensionPixelSize);
        float f10 = dimension2 > dimension3 ? dimension2 : dimension3;
        this.f7953c = obtainStyledAttributes.getDimensionPixelSize(d.f35517b, 0);
        this.f7954d = obtainStyledAttributes.getDimensionPixelSize(d.f35518c, 0);
        obtainStyledAttributes.recycle();
        f7950i.c(aVar, context, colorStateList, dimension, dimension2, f10);
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        f7950i.m(this.f7957g, colorStateList);
    }

    @Override // android.view.View
    public void setPadding(int i10, int i11, int i12, int i13) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int i10, int i11, int i12, int i13) {
    }
}
