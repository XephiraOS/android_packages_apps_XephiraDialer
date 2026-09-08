package androidx.viewpager.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.SingleLineTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.core.widget.k;
import androidx.viewpager.widget.ViewPager;
import com.coui.appcompat.uiutil.UIUtil;
import java.lang.ref.WeakReference;
import java.util.Locale;

@ViewPager.e
/* loaded from: classes.dex */
public class PagerTitleStrip extends ViewGroup {

    /* renamed from: o, reason: collision with root package name */
    public static final int[] f11777o = {R.attr.textAppearance, R.attr.textSize, R.attr.textColor, R.attr.gravity};

    /* renamed from: p, reason: collision with root package name */
    public static final int[] f11778p = {R.attr.textAllCaps};

    /* renamed from: a, reason: collision with root package name */
    public ViewPager f11779a;

    /* renamed from: b, reason: collision with root package name */
    public TextView f11780b;

    /* renamed from: c, reason: collision with root package name */
    public TextView f11781c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f11782d;

    /* renamed from: e, reason: collision with root package name */
    public int f11783e;

    /* renamed from: f, reason: collision with root package name */
    public float f11784f;

    /* renamed from: g, reason: collision with root package name */
    public int f11785g;

    /* renamed from: h, reason: collision with root package name */
    public int f11786h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f11787i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f11788j;

    /* renamed from: k, reason: collision with root package name */
    public final a f11789k;

    /* renamed from: l, reason: collision with root package name */
    public WeakReference<androidx.viewpager.widget.a> f11790l;

    /* renamed from: m, reason: collision with root package name */
    public int f11791m;

    /* renamed from: n, reason: collision with root package name */
    public int f11792n;

    /* loaded from: classes.dex */
    public class a extends DataSetObserver implements ViewPager.i, ViewPager.h {

        /* renamed from: a, reason: collision with root package name */
        public int f11793a;

        public a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.h
        public void onAdapterChanged(ViewPager viewPager, androidx.viewpager.widget.a aVar, androidx.viewpager.widget.a aVar2) {
            PagerTitleStrip.this.b(aVar, aVar2);
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
            pagerTitleStrip.c(pagerTitleStrip.f11779a.getCurrentItem(), PagerTitleStrip.this.f11779a.getAdapter());
            PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
            float f10 = pagerTitleStrip2.f11784f;
            if (f10 < 0.0f) {
                f10 = 0.0f;
            }
            pagerTitleStrip2.d(pagerTitleStrip2.f11779a.getCurrentItem(), f10, true);
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void onPageScrollStateChanged(int i10) {
            this.f11793a = i10;
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void onPageScrolled(int i10, float f10, int i11) {
            if (f10 > 0.5f) {
                i10++;
            }
            PagerTitleStrip.this.d(i10, f10, false);
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void onPageSelected(int i10) {
            if (this.f11793a == 0) {
                PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
                pagerTitleStrip.c(pagerTitleStrip.f11779a.getCurrentItem(), PagerTitleStrip.this.f11779a.getAdapter());
                PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
                float f10 = pagerTitleStrip2.f11784f;
                if (f10 < 0.0f) {
                    f10 = 0.0f;
                }
                pagerTitleStrip2.d(pagerTitleStrip2.f11779a.getCurrentItem(), f10, true);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends SingleLineTransformationMethod {

        /* renamed from: a, reason: collision with root package name */
        public Locale f11795a;

        public b(Context context) {
            this.f11795a = context.getResources().getConfiguration().locale;
        }

        @Override // android.text.method.ReplacementTransformationMethod, android.text.method.TransformationMethod
        public CharSequence getTransformation(CharSequence charSequence, View view) {
            CharSequence transformation = super.getTransformation(charSequence, view);
            if (transformation != null) {
                return transformation.toString().toUpperCase(this.f11795a);
            }
            return null;
        }
    }

    public PagerTitleStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11783e = -1;
        this.f11784f = -1.0f;
        this.f11789k = new a();
        TextView textView = new TextView(context);
        this.f11780b = textView;
        addView(textView);
        TextView textView2 = new TextView(context);
        this.f11781c = textView2;
        addView(textView2);
        TextView textView3 = new TextView(context);
        this.f11782d = textView3;
        addView(textView3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f11777o);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            k.p(this.f11780b, resourceId);
            k.p(this.f11781c, resourceId);
            k.p(this.f11782d, resourceId);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            a(0, dimensionPixelSize);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            int color = obtainStyledAttributes.getColor(2, 0);
            this.f11780b.setTextColor(color);
            this.f11781c.setTextColor(color);
            this.f11782d.setTextColor(color);
        }
        this.f11786h = obtainStyledAttributes.getInteger(3, 80);
        obtainStyledAttributes.recycle();
        this.f11792n = this.f11781c.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(0.6f);
        TextView textView4 = this.f11780b;
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        textView4.setEllipsize(truncateAt);
        this.f11781c.setEllipsize(truncateAt);
        this.f11782d.setEllipsize(truncateAt);
        if (resourceId != 0) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, f11778p);
            boolean z10 = obtainStyledAttributes2.getBoolean(0, false);
            obtainStyledAttributes2.recycle();
            if (z10) {
                setSingleLineAllCaps(this.f11780b);
                setSingleLineAllCaps(this.f11781c);
                setSingleLineAllCaps(this.f11782d);
                this.f11785g = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
            }
        }
        this.f11780b.setSingleLine();
        this.f11781c.setSingleLine();
        this.f11782d.setSingleLine();
        this.f11785g = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
    }

    private static void setSingleLineAllCaps(TextView textView) {
        textView.setTransformationMethod(new b(textView.getContext()));
    }

    public void a(int i10, float f10) {
        this.f11780b.setTextSize(i10, f10);
        this.f11781c.setTextSize(i10, f10);
        this.f11782d.setTextSize(i10, f10);
    }

    public void b(androidx.viewpager.widget.a aVar, androidx.viewpager.widget.a aVar2) {
        if (aVar != null) {
            aVar.unregisterDataSetObserver(this.f11789k);
            this.f11790l = null;
        }
        if (aVar2 != null) {
            aVar2.registerDataSetObserver(this.f11789k);
            this.f11790l = new WeakReference<>(aVar2);
        }
        ViewPager viewPager = this.f11779a;
        if (viewPager != null) {
            this.f11783e = -1;
            this.f11784f = -1.0f;
            c(viewPager.getCurrentItem(), aVar2);
            requestLayout();
        }
    }

    public void c(int i10, androidx.viewpager.widget.a aVar) {
        int i11;
        CharSequence charSequence;
        CharSequence charSequence2;
        if (aVar != null) {
            i11 = aVar.getCount();
        } else {
            i11 = 0;
        }
        this.f11787i = true;
        CharSequence charSequence3 = null;
        if (i10 >= 1 && aVar != null) {
            charSequence = aVar.getPageTitle(i10 - 1);
        } else {
            charSequence = null;
        }
        this.f11780b.setText(charSequence);
        TextView textView = this.f11781c;
        if (aVar != null && i10 < i11) {
            charSequence2 = aVar.getPageTitle(i10);
        } else {
            charSequence2 = null;
        }
        textView.setText(charSequence2);
        int i12 = i10 + 1;
        if (i12 < i11 && aVar != null) {
            charSequence3 = aVar.getPageTitle(i12);
        }
        this.f11782d.setText(charSequence3);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.8f)), Integer.MIN_VALUE);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), Integer.MIN_VALUE);
        this.f11780b.measure(makeMeasureSpec, makeMeasureSpec2);
        this.f11781c.measure(makeMeasureSpec, makeMeasureSpec2);
        this.f11782d.measure(makeMeasureSpec, makeMeasureSpec2);
        this.f11783e = i10;
        if (!this.f11788j) {
            d(i10, this.f11784f, false);
        }
        this.f11787i = false;
    }

    public void d(int i10, float f10, boolean z10) {
        int i11;
        int i12;
        int i13;
        int i14;
        if (i10 != this.f11783e) {
            c(i10, this.f11779a.getAdapter());
        } else if (!z10 && f10 == this.f11784f) {
            return;
        }
        this.f11788j = true;
        int measuredWidth = this.f11780b.getMeasuredWidth();
        int measuredWidth2 = this.f11781c.getMeasuredWidth();
        int measuredWidth3 = this.f11782d.getMeasuredWidth();
        int i15 = measuredWidth2 / 2;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i16 = paddingRight + i15;
        int i17 = (width - (paddingLeft + i15)) - i16;
        float f11 = 0.5f + f10;
        if (f11 > 1.0f) {
            f11 -= 1.0f;
        }
        int i18 = ((width - i16) - ((int) (i17 * f11))) - i15;
        int i19 = measuredWidth2 + i18;
        int baseline = this.f11780b.getBaseline();
        int baseline2 = this.f11781c.getBaseline();
        int baseline3 = this.f11782d.getBaseline();
        int max = Math.max(Math.max(baseline, baseline2), baseline3);
        int i20 = max - baseline;
        int i21 = max - baseline2;
        int i22 = max - baseline3;
        int max2 = Math.max(Math.max(this.f11780b.getMeasuredHeight() + i20, this.f11781c.getMeasuredHeight() + i21), this.f11782d.getMeasuredHeight() + i22);
        int i23 = this.f11786h & 112;
        if (i23 != 16) {
            if (i23 != 80) {
                i12 = i20 + paddingTop;
                i13 = i21 + paddingTop;
                i14 = paddingTop + i22;
                TextView textView = this.f11781c;
                textView.layout(i18, i13, i19, textView.getMeasuredHeight() + i13);
                int min = Math.min(paddingLeft, (i18 - this.f11785g) - measuredWidth);
                TextView textView2 = this.f11780b;
                textView2.layout(min, i12, measuredWidth + min, textView2.getMeasuredHeight() + i12);
                int max3 = Math.max((width - paddingRight) - measuredWidth3, i19 + this.f11785g);
                TextView textView3 = this.f11782d;
                textView3.layout(max3, i14, max3 + measuredWidth3, textView3.getMeasuredHeight() + i14);
                this.f11784f = f10;
                this.f11788j = false;
            }
            i11 = (height - paddingBottom) - max2;
        } else {
            i11 = (((height - paddingTop) - paddingBottom) - max2) / 2;
        }
        i12 = i20 + i11;
        i13 = i21 + i11;
        i14 = i11 + i22;
        TextView textView4 = this.f11781c;
        textView4.layout(i18, i13, i19, textView4.getMeasuredHeight() + i13);
        int min2 = Math.min(paddingLeft, (i18 - this.f11785g) - measuredWidth);
        TextView textView22 = this.f11780b;
        textView22.layout(min2, i12, measuredWidth + min2, textView22.getMeasuredHeight() + i12);
        int max32 = Math.max((width - paddingRight) - measuredWidth3, i19 + this.f11785g);
        TextView textView32 = this.f11782d;
        textView32.layout(max32, i14, max32 + measuredWidth3, textView32.getMeasuredHeight() + i14);
        this.f11784f = f10;
        this.f11788j = false;
    }

    public int getMinHeight() {
        Drawable background = getBackground();
        if (background != null) {
            return background.getIntrinsicHeight();
        }
        return 0;
    }

    public int getTextSpacing() {
        return this.f11785g;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        androidx.viewpager.widget.a aVar;
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof ViewPager) {
            ViewPager viewPager = (ViewPager) parent;
            androidx.viewpager.widget.a adapter = viewPager.getAdapter();
            viewPager.setInternalPageChangeListener(this.f11789k);
            viewPager.addOnAdapterChangeListener(this.f11789k);
            this.f11779a = viewPager;
            WeakReference<androidx.viewpager.widget.a> weakReference = this.f11790l;
            if (weakReference != null) {
                aVar = weakReference.get();
            } else {
                aVar = null;
            }
            b(aVar, adapter);
            return;
        }
        throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewPager viewPager = this.f11779a;
        if (viewPager != null) {
            b(viewPager.getAdapter(), null);
            this.f11779a.setInternalPageChangeListener(null);
            this.f11779a.removeOnAdapterChangeListener(this.f11789k);
            this.f11779a = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        if (this.f11779a != null) {
            float f10 = this.f11784f;
            if (f10 < 0.0f) {
                f10 = 0.0f;
            }
            d(this.f11783e, f10, true);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int max;
        if (View.MeasureSpec.getMode(i10) == 1073741824) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(i11, paddingTop, -2);
            int size = View.MeasureSpec.getSize(i10);
            int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i10, (int) (size * 0.2f), -2);
            this.f11780b.measure(childMeasureSpec2, childMeasureSpec);
            this.f11781c.measure(childMeasureSpec2, childMeasureSpec);
            this.f11782d.measure(childMeasureSpec2, childMeasureSpec);
            if (View.MeasureSpec.getMode(i11) == 1073741824) {
                max = View.MeasureSpec.getSize(i11);
            } else {
                max = Math.max(getMinHeight(), this.f11781c.getMeasuredHeight() + paddingTop);
            }
            setMeasuredDimension(size, View.resolveSizeAndState(max, i11, this.f11781c.getMeasuredState() << 16));
            return;
        }
        throw new IllegalStateException("Must measure with an exact width");
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!this.f11787i) {
            super.requestLayout();
        }
    }

    public void setGravity(int i10) {
        this.f11786h = i10;
        requestLayout();
    }

    public void setNonPrimaryAlpha(float f10) {
        int i10 = ((int) (f10 * 255.0f)) & 255;
        this.f11791m = i10;
        int i11 = (i10 << 24) | (this.f11792n & UIUtil.CONSTANT_COLOR_MASK);
        this.f11780b.setTextColor(i11);
        this.f11782d.setTextColor(i11);
    }

    public void setTextColor(int i10) {
        this.f11792n = i10;
        this.f11781c.setTextColor(i10);
        int i11 = (this.f11791m << 24) | (this.f11792n & UIUtil.CONSTANT_COLOR_MASK);
        this.f11780b.setTextColor(i11);
        this.f11782d.setTextColor(i11);
    }

    public void setTextSpacing(int i10) {
        this.f11785g = i10;
        requestLayout();
    }
}
