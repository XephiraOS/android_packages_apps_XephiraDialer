package androidx.viewpager.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.coui.appcompat.uiutil.UIUtil;

/* loaded from: classes.dex */
public class PagerTabStrip extends PagerTitleStrip {

    /* renamed from: A, reason: collision with root package name */
    public int f11759A;

    /* renamed from: B, reason: collision with root package name */
    public final Paint f11760B;

    /* renamed from: C, reason: collision with root package name */
    public final Rect f11761C;

    /* renamed from: D, reason: collision with root package name */
    public int f11762D;

    /* renamed from: E, reason: collision with root package name */
    public boolean f11763E;

    /* renamed from: F, reason: collision with root package name */
    public boolean f11764F;

    /* renamed from: G, reason: collision with root package name */
    public int f11765G;

    /* renamed from: H, reason: collision with root package name */
    public boolean f11766H;

    /* renamed from: I, reason: collision with root package name */
    public float f11767I;

    /* renamed from: J, reason: collision with root package name */
    public float f11768J;

    /* renamed from: K, reason: collision with root package name */
    public int f11769K;

    /* renamed from: q, reason: collision with root package name */
    public int f11770q;

    /* renamed from: r, reason: collision with root package name */
    public int f11771r;

    /* renamed from: x, reason: collision with root package name */
    public int f11772x;

    /* renamed from: y, reason: collision with root package name */
    public int f11773y;

    /* renamed from: z, reason: collision with root package name */
    public int f11774z;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PagerTabStrip.this.f11779a.setCurrentItem(r0.getCurrentItem() - 1);
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewPager viewPager = PagerTabStrip.this.f11779a;
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
        }
    }

    public PagerTabStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.f11760B = paint;
        this.f11761C = new Rect();
        this.f11762D = 255;
        this.f11763E = false;
        this.f11764F = false;
        int i10 = this.f11792n;
        this.f11770q = i10;
        paint.setColor(i10);
        float f10 = context.getResources().getDisplayMetrics().density;
        this.f11771r = (int) ((3.0f * f10) + 0.5f);
        this.f11772x = (int) ((6.0f * f10) + 0.5f);
        this.f11773y = (int) (64.0f * f10);
        this.f11759A = (int) ((16.0f * f10) + 0.5f);
        this.f11765G = (int) ((1.0f * f10) + 0.5f);
        this.f11774z = (int) ((f10 * 32.0f) + 0.5f);
        this.f11769K = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
        setWillNotDraw(false);
        this.f11780b.setFocusable(true);
        this.f11780b.setOnClickListener(new a());
        this.f11782d.setFocusable(true);
        this.f11782d.setOnClickListener(new b());
        if (getBackground() == null) {
            this.f11763E = true;
        }
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    public void d(int i10, float f10, boolean z10) {
        Rect rect = this.f11761C;
        int height = getHeight();
        int left = this.f11781c.getLeft() - this.f11759A;
        int right = this.f11781c.getRight() + this.f11759A;
        int i11 = height - this.f11771r;
        rect.set(left, i11, right, height);
        super.d(i10, f10, z10);
        this.f11762D = (int) (Math.abs(f10 - 0.5f) * 2.0f * 255.0f);
        rect.union(this.f11781c.getLeft() - this.f11759A, i11, this.f11781c.getRight() + this.f11759A, height);
        invalidate(rect);
    }

    public boolean getDrawFullUnderline() {
        return this.f11763E;
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    public int getMinHeight() {
        return Math.max(super.getMinHeight(), this.f11774z);
    }

    public int getTabIndicatorColor() {
        return this.f11770q;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int left = this.f11781c.getLeft() - this.f11759A;
        int right = this.f11781c.getRight() + this.f11759A;
        int i10 = height - this.f11771r;
        this.f11760B.setColor((this.f11762D << 24) | (this.f11770q & UIUtil.CONSTANT_COLOR_MASK));
        float f10 = height;
        canvas.drawRect(left, i10, right, f10, this.f11760B);
        if (this.f11763E) {
            this.f11760B.setColor((this.f11770q & UIUtil.CONSTANT_COLOR_MASK) | (-16777216));
            canvas.drawRect(getPaddingLeft(), height - this.f11765G, getWidth() - getPaddingRight(), f10, this.f11760B);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 && this.f11766H) {
            return false;
        }
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        if (action != 0) {
            if (action != 1) {
                if (action == 2 && (Math.abs(x10 - this.f11767I) > this.f11769K || Math.abs(y10 - this.f11768J) > this.f11769K)) {
                    this.f11766H = true;
                }
            } else if (x10 < this.f11781c.getLeft() - this.f11759A) {
                ViewPager viewPager = this.f11779a;
                viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
            } else if (x10 > this.f11781c.getRight() + this.f11759A) {
                ViewPager viewPager2 = this.f11779a;
                viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
            }
        } else {
            this.f11767I = x10;
            this.f11768J = y10;
            this.f11766H = false;
        }
        return true;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        boolean z10;
        super.setBackgroundColor(i10);
        if (!this.f11764F) {
            if ((i10 & (-16777216)) == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.f11763E = z10;
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        boolean z10;
        super.setBackgroundDrawable(drawable);
        if (!this.f11764F) {
            if (drawable == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.f11763E = z10;
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        boolean z10;
        super.setBackgroundResource(i10);
        if (!this.f11764F) {
            if (i10 == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.f11763E = z10;
        }
    }

    public void setDrawFullUnderline(boolean z10) {
        this.f11763E = z10;
        this.f11764F = true;
        invalidate();
    }

    @Override // android.view.View
    public void setPadding(int i10, int i11, int i12, int i13) {
        int i14 = this.f11772x;
        if (i13 < i14) {
            i13 = i14;
        }
        super.setPadding(i10, i11, i12, i13);
    }

    public void setTabIndicatorColor(int i10) {
        this.f11770q = i10;
        this.f11760B.setColor(i10);
        invalidate();
    }

    public void setTabIndicatorColorResource(int i10) {
        setTabIndicatorColor(androidx.core.content.b.c(getContext(), i10));
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    public void setTextSpacing(int i10) {
        int i11 = this.f11773y;
        if (i10 < i11) {
            i10 = i11;
        }
        super.setTextSpacing(i10);
    }
}
