package com.google.android.material.imageview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.appcompat.widget.AppCompatImageView;
import e4.l;
import f.C0991a;
import x4.i;
import x4.n;
import x4.o;
import x4.r;

/* loaded from: classes3.dex */
public class ShapeableImageView extends AppCompatImageView implements r {

    /* renamed from: x, reason: collision with root package name */
    public static final int f23430x = l.f31013O;

    /* renamed from: a, reason: collision with root package name */
    public final o f23431a;

    /* renamed from: b, reason: collision with root package name */
    public final RectF f23432b;

    /* renamed from: c, reason: collision with root package name */
    public final RectF f23433c;

    /* renamed from: d, reason: collision with root package name */
    public final Paint f23434d;

    /* renamed from: e, reason: collision with root package name */
    public final Paint f23435e;

    /* renamed from: f, reason: collision with root package name */
    public final Path f23436f;

    /* renamed from: g, reason: collision with root package name */
    public ColorStateList f23437g;

    /* renamed from: h, reason: collision with root package name */
    public i f23438h;

    /* renamed from: i, reason: collision with root package name */
    public n f23439i;

    /* renamed from: j, reason: collision with root package name */
    public float f23440j;

    /* renamed from: k, reason: collision with root package name */
    public Path f23441k;

    /* renamed from: l, reason: collision with root package name */
    public int f23442l;

    /* renamed from: m, reason: collision with root package name */
    public int f23443m;

    /* renamed from: n, reason: collision with root package name */
    public int f23444n;

    /* renamed from: o, reason: collision with root package name */
    public int f23445o;

    /* renamed from: p, reason: collision with root package name */
    public int f23446p;

    /* renamed from: q, reason: collision with root package name */
    public int f23447q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f23448r;

    /* loaded from: classes3.dex */
    public class a extends ViewOutlineProvider {

        /* renamed from: a, reason: collision with root package name */
        public final Rect f23449a = new Rect();

        public a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            if (ShapeableImageView.this.f23439i == null) {
                return;
            }
            if (ShapeableImageView.this.f23438h == null) {
                ShapeableImageView.this.f23438h = new i(ShapeableImageView.this.f23439i);
            }
            ShapeableImageView.this.f23432b.round(this.f23449a);
            ShapeableImageView.this.f23438h.setBounds(this.f23449a);
            ShapeableImageView.this.f23438h.getOutline(outline);
        }
    }

    public ShapeableImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private boolean m() {
        if (getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    public int getContentPaddingBottom() {
        return this.f23445o;
    }

    public final int getContentPaddingEnd() {
        int i10 = this.f23447q;
        if (i10 != Integer.MIN_VALUE) {
            return i10;
        }
        if (m()) {
            return this.f23442l;
        }
        return this.f23444n;
    }

    public int getContentPaddingLeft() {
        int i10;
        int i11;
        if (l()) {
            if (m() && (i11 = this.f23447q) != Integer.MIN_VALUE) {
                return i11;
            }
            if (!m() && (i10 = this.f23446p) != Integer.MIN_VALUE) {
                return i10;
            }
        }
        return this.f23442l;
    }

    public int getContentPaddingRight() {
        int i10;
        int i11;
        if (l()) {
            if (m() && (i11 = this.f23446p) != Integer.MIN_VALUE) {
                return i11;
            }
            if (!m() && (i10 = this.f23447q) != Integer.MIN_VALUE) {
                return i10;
            }
        }
        return this.f23444n;
    }

    public final int getContentPaddingStart() {
        int i10 = this.f23446p;
        if (i10 != Integer.MIN_VALUE) {
            return i10;
        }
        if (m()) {
            return this.f23444n;
        }
        return this.f23442l;
    }

    public int getContentPaddingTop() {
        return this.f23443m;
    }

    @Override // android.view.View
    public int getPaddingBottom() {
        return super.getPaddingBottom() - getContentPaddingBottom();
    }

    @Override // android.view.View
    public int getPaddingEnd() {
        return super.getPaddingEnd() - getContentPaddingEnd();
    }

    @Override // android.view.View
    public int getPaddingLeft() {
        return super.getPaddingLeft() - getContentPaddingLeft();
    }

    @Override // android.view.View
    public int getPaddingRight() {
        return super.getPaddingRight() - getContentPaddingRight();
    }

    @Override // android.view.View
    public int getPaddingStart() {
        return super.getPaddingStart() - getContentPaddingStart();
    }

    @Override // android.view.View
    public int getPaddingTop() {
        return super.getPaddingTop() - getContentPaddingTop();
    }

    public n getShapeAppearanceModel() {
        return this.f23439i;
    }

    public ColorStateList getStrokeColor() {
        return this.f23437g;
    }

    public float getStrokeWidth() {
        return this.f23440j;
    }

    public final void k(Canvas canvas) {
        if (this.f23437g == null) {
            return;
        }
        this.f23434d.setStrokeWidth(this.f23440j);
        int colorForState = this.f23437g.getColorForState(getDrawableState(), this.f23437g.getDefaultColor());
        if (this.f23440j > 0.0f && colorForState != 0) {
            this.f23434d.setColor(colorForState);
            canvas.drawPath(this.f23436f, this.f23434d);
        }
    }

    public final boolean l() {
        if (this.f23446p == Integer.MIN_VALUE && this.f23447q == Integer.MIN_VALUE) {
            return false;
        }
        return true;
    }

    public final void n(int i10, int i11) {
        this.f23432b.set(getPaddingLeft(), getPaddingTop(), i10 - getPaddingRight(), i11 - getPaddingBottom());
        this.f23431a.d(this.f23439i, 1.0f, this.f23432b, this.f23436f);
        this.f23441k.rewind();
        this.f23441k.addPath(this.f23436f);
        this.f23433c.set(0.0f, 0.0f, i10, i11);
        this.f23441k.addRect(this.f23433c, Path.Direction.CCW);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.f23441k, this.f23435e);
        k(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (this.f23448r || !isLayoutDirectionResolved()) {
            return;
        }
        this.f23448r = true;
        if (!isPaddingRelative() && !l()) {
            setPadding(super.getPaddingLeft(), super.getPaddingTop(), super.getPaddingRight(), super.getPaddingBottom());
        } else {
            setPaddingRelative(super.getPaddingStart(), super.getPaddingTop(), super.getPaddingEnd(), super.getPaddingBottom());
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        n(i10, i11);
    }

    @Override // android.view.View
    public void setPadding(int i10, int i11, int i12, int i13) {
        super.setPadding(i10 + getContentPaddingLeft(), i11 + getContentPaddingTop(), i12 + getContentPaddingRight(), i13 + getContentPaddingBottom());
    }

    @Override // android.view.View
    public void setPaddingRelative(int i10, int i11, int i12, int i13) {
        super.setPaddingRelative(i10 + getContentPaddingStart(), i11 + getContentPaddingTop(), i12 + getContentPaddingEnd(), i13 + getContentPaddingBottom());
    }

    @Override // x4.r
    public void setShapeAppearanceModel(n nVar) {
        this.f23439i = nVar;
        i iVar = this.f23438h;
        if (iVar != null) {
            iVar.setShapeAppearanceModel(nVar);
        }
        n(getWidth(), getHeight());
        invalidate();
        invalidateOutline();
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        this.f23437g = colorStateList;
        invalidate();
    }

    public void setStrokeColorResource(int i10) {
        setStrokeColor(C0991a.a(getContext(), i10));
    }

    public void setStrokeWidth(float f10) {
        if (this.f23440j != f10) {
            this.f23440j = f10;
            invalidate();
        }
    }

    public void setStrokeWidthResource(int i10) {
        setStrokeWidth(getResources().getDimensionPixelSize(i10));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ShapeableImageView(android.content.Context r7, android.util.AttributeSet r8, int r9) {
        /*
            r6 = this;
            int r0 = com.google.android.material.imageview.ShapeableImageView.f23430x
            android.content.Context r7 = B4.a.c(r7, r8, r9, r0)
            r6.<init>(r7, r8, r9)
            x4.o r7 = x4.o.k()
            r6.f23431a = r7
            android.graphics.Path r7 = new android.graphics.Path
            r7.<init>()
            r6.f23436f = r7
            r7 = 0
            r6.f23448r = r7
            android.content.Context r1 = r6.getContext()
            android.graphics.Paint r2 = new android.graphics.Paint
            r2.<init>()
            r6.f23435e = r2
            r3 = 1
            r2.setAntiAlias(r3)
            r4 = -1
            r2.setColor(r4)
            android.graphics.PorterDuffXfermode r4 = new android.graphics.PorterDuffXfermode
            android.graphics.PorterDuff$Mode r5 = android.graphics.PorterDuff.Mode.DST_OUT
            r4.<init>(r5)
            r2.setXfermode(r4)
            android.graphics.RectF r2 = new android.graphics.RectF
            r2.<init>()
            r6.f23432b = r2
            android.graphics.RectF r2 = new android.graphics.RectF
            r2.<init>()
            r6.f23433c = r2
            android.graphics.Path r2 = new android.graphics.Path
            r2.<init>()
            r6.f23441k = r2
            int[] r2 = e4.m.f31360c9
            android.content.res.TypedArray r2 = r1.obtainStyledAttributes(r8, r2, r9, r0)
            r4 = 2
            r5 = 0
            r6.setLayerType(r4, r5)
            int r4 = e4.m.f31448k9
            android.content.res.ColorStateList r4 = u4.C1607c.a(r1, r2, r4)
            r6.f23437g = r4
            int r4 = e4.m.f31459l9
            int r4 = r2.getDimensionPixelSize(r4, r7)
            float r4 = (float) r4
            r6.f23440j = r4
            int r4 = e4.m.f31371d9
            int r7 = r2.getDimensionPixelSize(r4, r7)
            r6.f23442l = r7
            r6.f23443m = r7
            r6.f23444n = r7
            r6.f23445o = r7
            int r4 = e4.m.f31404g9
            int r4 = r2.getDimensionPixelSize(r4, r7)
            r6.f23442l = r4
            int r4 = e4.m.f31437j9
            int r4 = r2.getDimensionPixelSize(r4, r7)
            r6.f23443m = r4
            int r4 = e4.m.f31415h9
            int r4 = r2.getDimensionPixelSize(r4, r7)
            r6.f23444n = r4
            int r4 = e4.m.f31382e9
            int r7 = r2.getDimensionPixelSize(r4, r7)
            r6.f23445o = r7
            int r7 = e4.m.f31426i9
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            int r7 = r2.getDimensionPixelSize(r7, r4)
            r6.f23446p = r7
            int r7 = e4.m.f31393f9
            int r7 = r2.getDimensionPixelSize(r7, r4)
            r6.f23447q = r7
            r2.recycle()
            android.graphics.Paint r7 = new android.graphics.Paint
            r7.<init>()
            r6.f23434d = r7
            android.graphics.Paint$Style r2 = android.graphics.Paint.Style.STROKE
            r7.setStyle(r2)
            r7.setAntiAlias(r3)
            x4.n$b r7 = x4.n.e(r1, r8, r9, r0)
            x4.n r7 = r7.m()
            r6.f23439i = r7
            com.google.android.material.imageview.ShapeableImageView$a r7 = new com.google.android.material.imageview.ShapeableImageView$a
            r7.<init>()
            r6.setOutlineProvider(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.imageview.ShapeableImageView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
