package com.android.contacts.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.oplus.dialer.R;

/* loaded from: classes.dex */
public class PinnedHeaderListView extends AutoScrollListView implements AbsListView.OnScrollListener, AdapterView.OnItemSelectedListener {

    /* renamed from: f, reason: collision with root package name */
    public b f18220f;

    /* renamed from: g, reason: collision with root package name */
    public int f18221g;

    /* renamed from: h, reason: collision with root package name */
    public a[] f18222h;

    /* renamed from: i, reason: collision with root package name */
    public RectF f18223i;

    /* renamed from: j, reason: collision with root package name */
    public Rect f18224j;

    /* renamed from: k, reason: collision with root package name */
    public AbsListView.OnScrollListener f18225k;

    /* renamed from: l, reason: collision with root package name */
    public AdapterView.OnItemSelectedListener f18226l;

    /* renamed from: m, reason: collision with root package name */
    public int f18227m;

    /* renamed from: n, reason: collision with root package name */
    public int f18228n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f18229o;

    /* renamed from: p, reason: collision with root package name */
    public long f18230p;

    /* renamed from: q, reason: collision with root package name */
    public int f18231q;

    /* renamed from: r, reason: collision with root package name */
    public int f18232r;

    /* renamed from: x, reason: collision with root package name */
    public Paint f18233x;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public View f18234a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f18235b;

        /* renamed from: c, reason: collision with root package name */
        public int f18236c;

        /* renamed from: d, reason: collision with root package name */
        public int f18237d;

        /* renamed from: e, reason: collision with root package name */
        public int f18238e;

        /* renamed from: f, reason: collision with root package name */
        public int f18239f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f18240g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f18241h;

        /* renamed from: i, reason: collision with root package name */
        public int f18242i;

        /* renamed from: j, reason: collision with root package name */
        public int f18243j;

        /* renamed from: k, reason: collision with root package name */
        public long f18244k;

        public a() {
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(PinnedHeaderListView pinnedHeaderListView);

        int b();

        View c(int i10, View view, ViewGroup viewGroup);

        int d(int i10);
    }

    public PinnedHeaderListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18223i = new RectF();
        this.f18224j = new Rect();
        this.f18228n = 100;
        setFocusable(false);
        g(context);
    }

    public final void c(Canvas canvas, a aVar, long j10) {
        if (aVar.f18240g) {
            int i10 = (int) (aVar.f18244k - j10);
            if (i10 <= 0) {
                aVar.f18236c = aVar.f18243j;
                aVar.f18235b = aVar.f18241h;
                aVar.f18240g = false;
            } else {
                int i11 = aVar.f18243j;
                aVar.f18236c = i11 + (((aVar.f18242i - i11) * i10) / this.f18228n);
            }
        }
        if (aVar.f18235b) {
            View view = aVar.f18234a;
            int save = canvas.save();
            canvas.translate(this.f18231q, aVar.f18236c);
            if (aVar.f18239f == 2) {
                this.f18223i.set(0.0f, 0.0f, this.f18232r, view.getHeight());
                canvas.saveLayerAlpha(this.f18223i, aVar.f18238e, 31);
            }
            view.draw(canvas);
            if (!i(this)) {
                canvas.drawLine(0.0f, view.getHeight(), this.f18232r, view.getHeight(), this.f18233x);
            }
            canvas.restoreToCount(save);
        }
    }

    public final void d(int i10) {
        int makeMeasureSpec;
        int i11;
        View view = this.f18222h[i10].f18234a;
        if (view.isLayoutRequested()) {
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.f18232r, 1073741824);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null && (i11 = layoutParams.height) > 0) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i11, 1073741824);
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(makeMeasureSpec2, makeMeasureSpec);
            int measuredHeight = view.getMeasuredHeight();
            this.f18222h[i10].f18237d = measuredHeight;
            view.layout(0, 0, this.f18232r, measuredHeight);
        }
    }

    @Override // com.android.contacts.widget.AutoScrollListView, com.coui.appcompat.list.COUIListView, android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        long j10;
        int i10;
        int i11;
        int i12;
        if (this.f18229o) {
            j10 = System.currentTimeMillis();
        } else {
            j10 = 0;
        }
        int bottom = getBottom();
        boolean z10 = false;
        int i13 = 0;
        for (int i14 = 0; i14 < this.f18221g; i14++) {
            a aVar = this.f18222h[i14];
            if (aVar.f18235b) {
                int i15 = aVar.f18239f;
                if (i15 == 1 && (i12 = aVar.f18236c) < bottom) {
                    z10 = true;
                    bottom = i12;
                } else {
                    if ((i15 == 0 || i15 == 2) && (i11 = aVar.f18236c + aVar.f18237d) > i13) {
                        i13 = i11;
                    }
                    z10 = true;
                }
            }
        }
        if (z10) {
            canvas.save();
            this.f18224j.set(0, i13, getWidth(), bottom);
            canvas.clipRect(this.f18224j);
        }
        super.dispatchDraw(canvas);
        if (z10) {
            canvas.restore();
            int i16 = this.f18221g;
            while (true) {
                i16--;
                if (i16 < 0) {
                    break;
                }
                a aVar2 = this.f18222h[i16];
                if (aVar2.f18235b && ((i10 = aVar2.f18239f) == 0 || i10 == 2)) {
                    c(canvas, aVar2, j10);
                }
            }
            for (int i17 = 0; i17 < this.f18221g; i17++) {
                a aVar3 = this.f18222h[i17];
                if (aVar3.f18235b && aVar3.f18239f == 1) {
                    c(canvas, aVar3, j10);
                }
            }
        }
        h();
    }

    public int e(int i10) {
        d(i10);
        return this.f18222h[i10].f18234a.getHeight();
    }

    public int f(int i10) {
        do {
            int pointToPosition = pointToPosition(getPaddingLeft() + 1, i10);
            if (pointToPosition != -1) {
                return pointToPosition;
            }
            i10--;
        } while (i10 > 0);
        return 0;
    }

    public final void g(Context context) {
        Paint paint = new Paint();
        this.f18233x = paint;
        paint.setColor(COUIContextUtil.getAttrColor(context, R.attr.couiColorDivider));
        this.f18233x.setStrokeWidth(getResources().getDimensionPixelSize(R.dimen.DP_1));
        this.f18233x.setStyle(Paint.Style.STROKE);
    }

    @Override // android.widget.AbsListView, android.view.View
    public float getTopFadingEdgeStrength() {
        if (this.f18221g > 0) {
            return 0.0f;
        }
        return super.getTopFadingEdgeStrength();
    }

    public int getTotalTopPinnedHeaderHeight() {
        int i10 = this.f18221g;
        while (true) {
            i10--;
            if (i10 >= 0) {
                a aVar = this.f18222h[i10];
                if (aVar.f18235b && aVar.f18239f == 0) {
                    return aVar.f18236c + aVar.f18237d;
                }
            } else {
                return 0;
            }
        }
    }

    public final void h() {
        this.f18229o = false;
        for (int i10 = 0; i10 < this.f18221g; i10++) {
            if (this.f18222h[i10].f18240g) {
                this.f18229o = true;
                invalidate();
                return;
            }
        }
    }

    public final boolean i(AbsListView absListView) {
        View childAt;
        boolean z10 = true;
        if (absListView == null || (childAt = absListView.getChildAt(0)) == null) {
            return true;
        }
        if (absListView.getFirstVisiblePosition() != 0) {
            return false;
        }
        if (childAt.getTop() != absListView.getPaddingTop()) {
            z10 = false;
        }
        return z10;
    }

    public void j(int i10, int i11, boolean z10) {
        int bottom;
        int i12;
        d(i10);
        View childAt = getChildAt(i11 - getFirstVisiblePosition());
        if (childAt == null) {
            return;
        }
        a aVar = this.f18222h[i10];
        aVar.f18235b = true;
        aVar.f18239f = 2;
        aVar.f18238e = 255;
        aVar.f18240g = false;
        int totalTopPinnedHeaderHeight = getTotalTopPinnedHeaderHeight();
        aVar.f18236c = totalTopPinnedHeaderHeight;
        if (z10 && (bottom = childAt.getBottom() - totalTopPinnedHeaderHeight) < (i12 = aVar.f18237d)) {
            int i13 = bottom - i12;
            aVar.f18238e = ((i12 + i13) * 255) / i12;
            aVar.f18236c = totalTopPinnedHeaderHeight + i13;
        }
    }

    public void k(int i10, boolean z10) {
        a aVar = this.f18222h[i10];
        if (aVar.f18235b && ((z10 || aVar.f18240g) && aVar.f18239f == 1)) {
            aVar.f18242i = aVar.f18236c;
            if (!aVar.f18240g) {
                aVar.f18235b = true;
                aVar.f18243j = getBottom() + aVar.f18237d;
            }
            aVar.f18240g = true;
            aVar.f18244k = this.f18230p;
            aVar.f18241h = false;
            return;
        }
        aVar.f18235b = false;
    }

    public void l(int i10, int i11, boolean z10) {
        int i12;
        d(i10);
        a aVar = this.f18222h[i10];
        aVar.f18239f = 1;
        if (aVar.f18240g) {
            aVar.f18244k = this.f18230p;
            aVar.f18242i = aVar.f18236c;
            aVar.f18243j = i11;
        } else {
            if (z10 && ((i12 = aVar.f18236c) != i11 || !aVar.f18235b)) {
                if (aVar.f18235b) {
                    aVar.f18242i = i12;
                } else {
                    aVar.f18235b = true;
                    aVar.f18242i = aVar.f18237d + i11;
                }
                aVar.f18240g = true;
                aVar.f18241h = true;
                aVar.f18244k = this.f18230p;
                aVar.f18243j = i11;
                return;
            }
            aVar.f18235b = true;
            aVar.f18236c = i11;
        }
    }

    @Override // com.android.contacts.widget.AutoScrollListView, android.widget.ListView, android.widget.AbsListView
    public void layoutChildren() {
        try {
            super.layoutChildren();
        } catch (Throwable th) {
            H7.b.c("PinnedHeaderListView", "e = " + th);
        }
    }

    public void m(int i10, int i11, boolean z10) {
        d(i10);
        a aVar = this.f18222h[i10];
        aVar.f18235b = true;
        aVar.f18236c = i11;
        aVar.f18239f = 0;
        aVar.f18240g = false;
    }

    public final boolean n(int i10) {
        if (this.f18220f.d(i10) == -1) {
            return false;
        }
        for (int i11 = 0; i11 < i10; i11++) {
            boolean z10 = this.f18222h[i11].f18235b;
        }
        return true;
    }

    @Override // com.customize.contacts.widget.MultiChoiceListView, com.coui.appcompat.list.COUIListView, android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int i10;
        if (this.f18227m == 0) {
            int y10 = (int) motionEvent.getY();
            int i11 = this.f18221g;
            while (true) {
                i11--;
                if (i11 < 0) {
                    break;
                }
                a aVar = this.f18222h[i11];
                if (aVar.f18235b && (i10 = aVar.f18236c) <= y10 && i10 + aVar.f18237d > y10) {
                    if (motionEvent.getAction() == 0) {
                        return n(i11);
                    }
                    return true;
                }
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
        int height = getHeight();
        int i11 = 0;
        int i12 = 0;
        while (true) {
            if (i11 >= this.f18221g) {
                break;
            }
            a aVar = this.f18222h[i11];
            if (aVar.f18235b) {
                int i13 = aVar.f18239f;
                if (i13 == 0) {
                    i12 = aVar.f18236c + aVar.f18237d;
                } else if (i13 == 1) {
                    height = aVar.f18236c;
                    break;
                }
            }
            i11++;
        }
        View selectedView = getSelectedView();
        if (selectedView != null) {
            if (selectedView.getTop() < i12) {
                setSelectionFromTop(i10, i12);
            } else if (selectedView.getBottom() > height) {
                setSelectionFromTop(i10, height - selectedView.getHeight());
            }
        }
        AdapterView.OnItemSelectedListener onItemSelectedListener = this.f18226l;
        if (onItemSelectedListener != null) {
            onItemSelectedListener.onItemSelected(adapterView, view, i10, j10);
        }
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int paddingLeft = getPaddingLeft();
        this.f18231q = paddingLeft;
        this.f18232r = ((i12 - i10) - paddingLeft) - getPaddingRight();
        a[] aVarArr = this.f18222h;
        if (aVarArr != null) {
            for (a aVar : aVarArr) {
                View view = aVar.f18234a;
                if (view != null) {
                    view.forceLayout();
                }
            }
        }
        super.onLayout(z10, i10, i11, i12, i13);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
        AdapterView.OnItemSelectedListener onItemSelectedListener = this.f18226l;
        if (onItemSelectedListener != null) {
            onItemSelectedListener.onNothingSelected(adapterView);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
        b bVar = this.f18220f;
        if (bVar != null) {
            int b10 = bVar.b();
            if (b10 != this.f18221g) {
                this.f18221g = b10;
                a[] aVarArr = this.f18222h;
                if (aVarArr == null) {
                    this.f18222h = new a[b10];
                } else if (aVarArr.length < b10) {
                    a[] aVarArr2 = new a[b10];
                    this.f18222h = aVarArr2;
                    System.arraycopy(aVarArr, 0, aVarArr2, 0, aVarArr.length);
                }
            }
            for (int i13 = 0; i13 < this.f18221g; i13++) {
                a[] aVarArr3 = this.f18222h;
                if (aVarArr3[i13] == null) {
                    aVarArr3[i13] = new a();
                }
                a aVar = this.f18222h[i13];
                aVar.f18234a = this.f18220f.c(i13, aVar.f18234a, this);
            }
            this.f18230p = System.currentTimeMillis() + this.f18228n;
            this.f18220f.a(this);
            h();
        }
        AbsListView.OnScrollListener onScrollListener = this.f18225k;
        if (onScrollListener != null) {
            onScrollListener.onScroll(this, i10, i11, i12);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i10) {
        this.f18227m = i10;
        AbsListView.OnScrollListener onScrollListener = this.f18225k;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(this, i10);
        }
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.f18226l = onItemSelectedListener;
        super.setOnItemSelectedListener(this);
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.f18225k = onScrollListener;
        super.setOnScrollListener(this);
    }

    public void setPinnedHeaderAnimationDuration(int i10) {
        this.f18228n = i10;
    }

    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        this.f18220f = (b) listAdapter;
        super.setAdapter(listAdapter);
    }
}
