package androidx.swiperefreshlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.ListView;
import androidx.core.view.C0466v;
import androidx.core.view.C0469y;
import androidx.core.view.InterfaceC0465u;
import androidx.core.view.K;
import h0.C1070a;
import h0.C1071b;

/* loaded from: classes.dex */
public class SwipeRefreshLayout extends ViewGroup implements InterfaceC0465u {

    /* renamed from: R, reason: collision with root package name */
    public static final String f11466R = "SwipeRefreshLayout";

    /* renamed from: S, reason: collision with root package name */
    public static final int[] f11467S = {R.attr.enabled};

    /* renamed from: A, reason: collision with root package name */
    public int f11468A;

    /* renamed from: B, reason: collision with root package name */
    public float f11469B;

    /* renamed from: C, reason: collision with root package name */
    public int f11470C;

    /* renamed from: D, reason: collision with root package name */
    public int f11471D;

    /* renamed from: E, reason: collision with root package name */
    public int f11472E;

    /* renamed from: F, reason: collision with root package name */
    public C1071b f11473F;

    /* renamed from: G, reason: collision with root package name */
    public Animation f11474G;

    /* renamed from: H, reason: collision with root package name */
    public Animation f11475H;

    /* renamed from: I, reason: collision with root package name */
    public Animation f11476I;

    /* renamed from: J, reason: collision with root package name */
    public Animation f11477J;

    /* renamed from: K, reason: collision with root package name */
    public Animation f11478K;

    /* renamed from: L, reason: collision with root package name */
    public boolean f11479L;

    /* renamed from: M, reason: collision with root package name */
    public int f11480M;

    /* renamed from: N, reason: collision with root package name */
    public boolean f11481N;

    /* renamed from: O, reason: collision with root package name */
    public Animation.AnimationListener f11482O;

    /* renamed from: P, reason: collision with root package name */
    public final Animation f11483P;

    /* renamed from: Q, reason: collision with root package name */
    public final Animation f11484Q;

    /* renamed from: a, reason: collision with root package name */
    public View f11485a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f11486b;

    /* renamed from: c, reason: collision with root package name */
    public int f11487c;

    /* renamed from: d, reason: collision with root package name */
    public float f11488d;

    /* renamed from: e, reason: collision with root package name */
    public float f11489e;

    /* renamed from: f, reason: collision with root package name */
    public final C0469y f11490f;

    /* renamed from: g, reason: collision with root package name */
    public final C0466v f11491g;

    /* renamed from: h, reason: collision with root package name */
    public final int[] f11492h;

    /* renamed from: i, reason: collision with root package name */
    public final int[] f11493i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f11494j;

    /* renamed from: k, reason: collision with root package name */
    public int f11495k;

    /* renamed from: l, reason: collision with root package name */
    public int f11496l;

    /* renamed from: m, reason: collision with root package name */
    public float f11497m;

    /* renamed from: n, reason: collision with root package name */
    public float f11498n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f11499o;

    /* renamed from: p, reason: collision with root package name */
    public int f11500p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f11501q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f11502r;

    /* renamed from: x, reason: collision with root package name */
    public final DecelerateInterpolator f11503x;

    /* renamed from: y, reason: collision with root package name */
    public C1070a f11504y;

    /* renamed from: z, reason: collision with root package name */
    public int f11505z;

    /* loaded from: classes.dex */
    public class b extends Animation {
        public b() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f10, Transformation transformation) {
            SwipeRefreshLayout.this.setAnimationProgress(f10);
        }
    }

    /* loaded from: classes.dex */
    public class c extends Animation {
        public c() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f10, Transformation transformation) {
            SwipeRefreshLayout.this.setAnimationProgress(1.0f - f10);
        }
    }

    /* loaded from: classes.dex */
    public class d extends Animation {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f11509a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f11510b;

        public d(int i10, int i11) {
            this.f11509a = i10;
            this.f11510b = i11;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f10, Transformation transformation) {
            SwipeRefreshLayout.this.f11473F.setAlpha((int) (this.f11509a + ((this.f11510b - r0) * f10)));
        }
    }

    /* loaded from: classes.dex */
    public class f extends Animation {
        public f() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f10, Transformation transformation) {
            int i10;
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (!swipeRefreshLayout.f11481N) {
                i10 = swipeRefreshLayout.f11471D - Math.abs(swipeRefreshLayout.f11470C);
            } else {
                i10 = swipeRefreshLayout.f11471D;
            }
            SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
            SwipeRefreshLayout.this.setTargetOffsetTopAndBottom((swipeRefreshLayout2.f11468A + ((int) ((i10 - r1) * f10))) - swipeRefreshLayout2.f11504y.getTop());
            SwipeRefreshLayout.this.f11473F.e(1.0f - f10);
        }
    }

    /* loaded from: classes.dex */
    public class g extends Animation {
        public g() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f10, Transformation transformation) {
            SwipeRefreshLayout.this.i(f10);
        }
    }

    /* loaded from: classes.dex */
    public class h extends Animation {
        public h() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f10, Transformation transformation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            float f11 = swipeRefreshLayout.f11469B;
            swipeRefreshLayout.setAnimationProgress(f11 + ((-f11) * f10));
            SwipeRefreshLayout.this.i(f10);
        }
    }

    /* loaded from: classes.dex */
    public interface i {
    }

    /* loaded from: classes.dex */
    public interface j {
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11486b = false;
        this.f11488d = -1.0f;
        this.f11492h = new int[2];
        this.f11493i = new int[2];
        this.f11500p = -1;
        this.f11505z = -1;
        this.f11482O = new a();
        this.f11483P = new f();
        this.f11484Q = new g();
        this.f11487c = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f11495k = getResources().getInteger(R.integer.config_mediumAnimTime);
        setWillNotDraw(false);
        this.f11503x = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f11480M = (int) (displayMetrics.density * 40.0f);
        d();
        setChildrenDrawingOrderEnabled(true);
        int i10 = (int) (displayMetrics.density * 64.0f);
        this.f11471D = i10;
        this.f11488d = i10;
        this.f11490f = new C0469y(this);
        this.f11491g = new C0466v(this);
        setNestedScrollingEnabled(true);
        int i11 = -this.f11480M;
        this.f11496l = i11;
        this.f11470C = i11;
        i(1.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f11467S);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
    }

    private void setColorViewAlpha(int i10) {
        this.f11504y.getBackground().setAlpha(i10);
        this.f11473F.setAlpha(i10);
    }

    public final void a(int i10, Animation.AnimationListener animationListener) {
        this.f11468A = i10;
        this.f11483P.reset();
        this.f11483P.setDuration(200L);
        this.f11483P.setInterpolator(this.f11503x);
        if (animationListener != null) {
            this.f11504y.b(animationListener);
        }
        this.f11504y.clearAnimation();
        this.f11504y.startAnimation(this.f11483P);
    }

    public final void b(int i10, Animation.AnimationListener animationListener) {
        if (this.f11501q) {
            r(i10, animationListener);
            return;
        }
        this.f11468A = i10;
        this.f11484Q.reset();
        this.f11484Q.setDuration(200L);
        this.f11484Q.setInterpolator(this.f11503x);
        if (animationListener != null) {
            this.f11504y.b(animationListener);
        }
        this.f11504y.clearAnimation();
        this.f11504y.startAnimation(this.f11484Q);
    }

    public boolean c() {
        View view = this.f11485a;
        if (view instanceof ListView) {
            return androidx.core.widget.i.a((ListView) view, -1);
        }
        return view.canScrollVertically(-1);
    }

    public final void d() {
        this.f11504y = new C1070a(getContext(), -328966);
        C1071b c1071b = new C1071b(getContext());
        this.f11473F = c1071b;
        c1071b.l(1);
        this.f11504y.setImageDrawable(this.f11473F);
        this.f11504y.setVisibility(8);
        addView(this.f11504y);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f10, float f11, boolean z10) {
        return this.f11491g.a(f10, f11, z10);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f10, float f11) {
        return this.f11491g.b(f10, f11);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i10, int i11, int[] iArr, int[] iArr2) {
        return this.f11491g.c(i10, i11, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i10, int i11, int i12, int i13, int[] iArr) {
        return this.f11491g.f(i10, i11, i12, i13, iArr);
    }

    public final void e() {
        if (this.f11485a == null) {
            for (int i10 = 0; i10 < getChildCount(); i10++) {
                View childAt = getChildAt(i10);
                if (!childAt.equals(this.f11504y)) {
                    this.f11485a = childAt;
                    return;
                }
            }
        }
    }

    public final void f(float f10) {
        e eVar;
        if (f10 > this.f11488d) {
            l(true, true);
            return;
        }
        this.f11486b = false;
        this.f11473F.j(0.0f, 0.0f);
        if (!this.f11501q) {
            eVar = new e();
        } else {
            eVar = null;
        }
        b(this.f11496l, eVar);
        this.f11473F.d(false);
    }

    public final boolean g(Animation animation) {
        if (animation != null && animation.hasStarted() && !animation.hasEnded()) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i10, int i11) {
        int i12 = this.f11505z;
        if (i12 < 0) {
            return i11;
        }
        if (i11 == i10 - 1) {
            return i12;
        }
        if (i11 >= i12) {
            return i11 + 1;
        }
        return i11;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f11490f.a();
    }

    public int getProgressCircleDiameter() {
        return this.f11480M;
    }

    public int getProgressViewEndOffset() {
        return this.f11471D;
    }

    public int getProgressViewStartOffset() {
        return this.f11470C;
    }

    public final void h(float f10) {
        this.f11473F.d(true);
        float min = Math.min(1.0f, Math.abs(f10 / this.f11488d));
        float max = (((float) Math.max(min - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float abs = Math.abs(f10) - this.f11488d;
        int i10 = this.f11472E;
        if (i10 <= 0) {
            if (this.f11481N) {
                i10 = this.f11471D - this.f11470C;
            } else {
                i10 = this.f11471D;
            }
        }
        float f11 = i10;
        double max2 = Math.max(0.0f, Math.min(abs, f11 * 2.0f) / f11) / 4.0f;
        float pow = ((float) (max2 - Math.pow(max2, 2.0d))) * 2.0f;
        int i11 = this.f11470C + ((int) ((f11 * min) + (f11 * pow * 2.0f)));
        if (this.f11504y.getVisibility() != 0) {
            this.f11504y.setVisibility(0);
        }
        if (!this.f11501q) {
            this.f11504y.setScaleX(1.0f);
            this.f11504y.setScaleY(1.0f);
        }
        if (this.f11501q) {
            setAnimationProgress(Math.min(1.0f, f10 / this.f11488d));
        }
        if (f10 < this.f11488d) {
            if (this.f11473F.getAlpha() > 76 && !g(this.f11476I)) {
                p();
            }
        } else if (this.f11473F.getAlpha() < 255 && !g(this.f11477J)) {
            o();
        }
        this.f11473F.j(0.0f, Math.min(0.8f, max * 0.8f));
        this.f11473F.e(Math.min(1.0f, max));
        this.f11473F.g((((max * 0.4f) - 0.25f) + (pow * 2.0f)) * 0.5f);
        setTargetOffsetTopAndBottom(i11 - this.f11496l);
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return this.f11491g.k();
    }

    public void i(float f10) {
        setTargetOffsetTopAndBottom((this.f11468A + ((int) ((this.f11470C - r0) * f10))) - this.f11504y.getTop());
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.f11491g.m();
    }

    public final void j(MotionEvent motionEvent) {
        int i10;
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f11500p) {
            if (actionIndex == 0) {
                i10 = 1;
            } else {
                i10 = 0;
            }
            this.f11500p = motionEvent.getPointerId(i10);
        }
    }

    public void k() {
        this.f11504y.clearAnimation();
        this.f11473F.stop();
        this.f11504y.setVisibility(8);
        setColorViewAlpha(255);
        if (this.f11501q) {
            setAnimationProgress(0.0f);
        } else {
            setTargetOffsetTopAndBottom(this.f11470C - this.f11496l);
        }
        this.f11496l = this.f11504y.getTop();
    }

    public final void l(boolean z10, boolean z11) {
        if (this.f11486b != z10) {
            this.f11479L = z11;
            e();
            this.f11486b = z10;
            if (z10) {
                a(this.f11496l, this.f11482O);
            } else {
                q(this.f11482O);
            }
        }
    }

    public final Animation m(int i10, int i11) {
        d dVar = new d(i10, i11);
        dVar.setDuration(300L);
        this.f11504y.b(null);
        this.f11504y.clearAnimation();
        this.f11504y.startAnimation(dVar);
        return dVar;
    }

    public final void n(float f10) {
        float f11 = this.f11498n;
        float f12 = f10 - f11;
        int i10 = this.f11487c;
        if (f12 > i10 && !this.f11499o) {
            this.f11497m = f11 + i10;
            this.f11499o = true;
            this.f11473F.setAlpha(76);
        }
    }

    public final void o() {
        this.f11477J = m(this.f11473F.getAlpha(), 255);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        k();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        e();
        int actionMasked = motionEvent.getActionMasked();
        if (this.f11502r && actionMasked == 0) {
            this.f11502r = false;
        }
        if (!isEnabled() || this.f11502r || c() || this.f11486b || this.f11494j) {
            return false;
        }
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked == 6) {
                            j(motionEvent);
                        }
                    }
                } else {
                    int i10 = this.f11500p;
                    if (i10 == -1) {
                        Log.e(f11466R, "Got ACTION_MOVE event but don't have an active pointer id.");
                        return false;
                    }
                    int findPointerIndex = motionEvent.findPointerIndex(i10);
                    if (findPointerIndex < 0) {
                        return false;
                    }
                    n(motionEvent.getY(findPointerIndex));
                }
            }
            this.f11499o = false;
            this.f11500p = -1;
        } else {
            setTargetOffsetTopAndBottom(this.f11470C - this.f11504y.getTop());
            int pointerId = motionEvent.getPointerId(0);
            this.f11500p = pointerId;
            this.f11499o = false;
            int findPointerIndex2 = motionEvent.findPointerIndex(pointerId);
            if (findPointerIndex2 < 0) {
                return false;
            }
            this.f11498n = motionEvent.getY(findPointerIndex2);
        }
        return this.f11499o;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() == 0) {
            return;
        }
        if (this.f11485a == null) {
            e();
        }
        View view = this.f11485a;
        if (view == null) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
        int measuredWidth2 = this.f11504y.getMeasuredWidth();
        int measuredHeight2 = this.f11504y.getMeasuredHeight();
        int i14 = measuredWidth / 2;
        int i15 = measuredWidth2 / 2;
        int i16 = this.f11496l;
        this.f11504y.layout(i14 - i15, i16, i14 + i15, measuredHeight2 + i16);
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (this.f11485a == null) {
            e();
        }
        View view = this.f11485a;
        if (view == null) {
            return;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        this.f11504y.measure(View.MeasureSpec.makeMeasureSpec(this.f11480M, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f11480M, 1073741824));
        this.f11505z = -1;
        for (int i12 = 0; i12 < getChildCount(); i12++) {
            if (getChildAt(i12) == this.f11504y) {
                this.f11505z = i12;
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f10, float f11, boolean z10) {
        return dispatchNestedFling(f10, f11, z10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f10, float f11) {
        return dispatchNestedPreFling(f10, f11);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr) {
        if (i11 > 0) {
            float f10 = this.f11489e;
            if (f10 > 0.0f) {
                float f11 = i11;
                if (f11 > f10) {
                    iArr[1] = i11 - ((int) f10);
                    this.f11489e = 0.0f;
                } else {
                    this.f11489e = f10 - f11;
                    iArr[1] = i11;
                }
                h(this.f11489e);
            }
        }
        if (this.f11481N && i11 > 0 && this.f11489e == 0.0f && Math.abs(i11 - iArr[1]) > 0) {
            this.f11504y.setVisibility(8);
        }
        int[] iArr2 = this.f11492h;
        if (dispatchNestedPreScroll(i10 - iArr[0], i11 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13) {
        dispatchNestedScroll(i10, i11, i12, i13, this.f11493i);
        if (i13 + this.f11493i[1] < 0 && !c()) {
            float abs = this.f11489e + Math.abs(r11);
            this.f11489e = abs;
            h(abs);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i10) {
        this.f11490f.b(view, view2, i10);
        startNestedScroll(i10 & 2);
        this.f11489e = 0.0f;
        this.f11494j = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i10) {
        if (isEnabled() && !this.f11502r && !this.f11486b && (i10 & 2) != 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        this.f11490f.d(view);
        this.f11494j = false;
        float f10 = this.f11489e;
        if (f10 > 0.0f) {
            f(f10);
            this.f11489e = 0.0f;
        }
        stopNestedScroll();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (this.f11502r && actionMasked == 0) {
            this.f11502r = false;
        }
        if (!isEnabled() || this.f11502r || c() || this.f11486b || this.f11494j) {
            return false;
        }
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked == 3) {
                        return false;
                    }
                    if (actionMasked != 5) {
                        if (actionMasked == 6) {
                            j(motionEvent);
                        }
                    } else {
                        int actionIndex = motionEvent.getActionIndex();
                        if (actionIndex < 0) {
                            Log.e(f11466R, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                            return false;
                        }
                        this.f11500p = motionEvent.getPointerId(actionIndex);
                    }
                } else {
                    int findPointerIndex = motionEvent.findPointerIndex(this.f11500p);
                    if (findPointerIndex < 0) {
                        Log.e(f11466R, "Got ACTION_MOVE event but have an invalid active pointer id.");
                        return false;
                    }
                    float y10 = motionEvent.getY(findPointerIndex);
                    n(y10);
                    if (this.f11499o) {
                        float f10 = (y10 - this.f11497m) * 0.5f;
                        if (f10 <= 0.0f) {
                            return false;
                        }
                        h(f10);
                    }
                }
            } else {
                int findPointerIndex2 = motionEvent.findPointerIndex(this.f11500p);
                if (findPointerIndex2 < 0) {
                    Log.e(f11466R, "Got ACTION_UP event but don't have an active pointer id.");
                    return false;
                }
                if (this.f11499o) {
                    float y11 = (motionEvent.getY(findPointerIndex2) - this.f11497m) * 0.5f;
                    this.f11499o = false;
                    f(y11);
                }
                this.f11500p = -1;
                return false;
            }
        } else {
            this.f11500p = motionEvent.getPointerId(0);
            this.f11499o = false;
        }
        return true;
    }

    public final void p() {
        this.f11476I = m(this.f11473F.getAlpha(), 76);
    }

    public void q(Animation.AnimationListener animationListener) {
        c cVar = new c();
        this.f11475H = cVar;
        cVar.setDuration(150L);
        this.f11504y.b(animationListener);
        this.f11504y.clearAnimation();
        this.f11504y.startAnimation(this.f11475H);
    }

    public final void r(int i10, Animation.AnimationListener animationListener) {
        this.f11468A = i10;
        this.f11469B = this.f11504y.getScaleX();
        h hVar = new h();
        this.f11478K = hVar;
        hVar.setDuration(150L);
        if (animationListener != null) {
            this.f11504y.b(animationListener);
        }
        this.f11504y.clearAnimation();
        this.f11504y.startAnimation(this.f11478K);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z10) {
        View view = this.f11485a;
        if (view == null || K.P(view)) {
            super.requestDisallowInterceptTouchEvent(z10);
        }
    }

    public final void s(Animation.AnimationListener animationListener) {
        this.f11504y.setVisibility(0);
        this.f11473F.setAlpha(255);
        b bVar = new b();
        this.f11474G = bVar;
        bVar.setDuration(this.f11495k);
        if (animationListener != null) {
            this.f11504y.b(animationListener);
        }
        this.f11504y.clearAnimation();
        this.f11504y.startAnimation(this.f11474G);
    }

    public void setAnimationProgress(float f10) {
        this.f11504y.setScaleX(f10);
        this.f11504y.setScaleY(f10);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(int... iArr) {
        e();
        this.f11473F.f(iArr);
    }

    public void setColorSchemeResources(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i10 = 0; i10 < iArr.length; i10++) {
            iArr2[i10] = androidx.core.content.b.c(context, iArr[i10]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i10) {
        this.f11488d = i10;
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        if (!z10) {
            k();
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z10) {
        this.f11491g.n(z10);
    }

    @Deprecated
    public void setProgressBackgroundColor(int i10) {
        setProgressBackgroundColorSchemeResource(i10);
    }

    public void setProgressBackgroundColorSchemeColor(int i10) {
        this.f11504y.setBackgroundColor(i10);
    }

    public void setProgressBackgroundColorSchemeResource(int i10) {
        setProgressBackgroundColorSchemeColor(androidx.core.content.b.c(getContext(), i10));
    }

    public void setRefreshing(boolean z10) {
        int i10;
        if (z10 && this.f11486b != z10) {
            this.f11486b = z10;
            if (!this.f11481N) {
                i10 = this.f11471D + this.f11470C;
            } else {
                i10 = this.f11471D;
            }
            setTargetOffsetTopAndBottom(i10 - this.f11496l);
            this.f11479L = false;
            s(this.f11482O);
            return;
        }
        l(z10, false);
    }

    public void setSize(int i10) {
        if (i10 != 0 && i10 != 1) {
            return;
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        if (i10 == 0) {
            this.f11480M = (int) (displayMetrics.density * 56.0f);
        } else {
            this.f11480M = (int) (displayMetrics.density * 40.0f);
        }
        this.f11504y.setImageDrawable(null);
        this.f11473F.l(i10);
        this.f11504y.setImageDrawable(this.f11473F);
    }

    public void setSlingshotDistance(int i10) {
        this.f11472E = i10;
    }

    public void setTargetOffsetTopAndBottom(int i10) {
        this.f11504y.bringToFront();
        K.U(this.f11504y, i10);
        this.f11496l = this.f11504y.getTop();
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i10) {
        return this.f11491g.p(i10);
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        this.f11491g.r();
    }

    /* loaded from: classes.dex */
    public class a implements Animation.AnimationListener {
        public a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (swipeRefreshLayout.f11486b) {
                swipeRefreshLayout.f11473F.setAlpha(255);
                SwipeRefreshLayout.this.f11473F.start();
                SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
                if (swipeRefreshLayout2.f11479L) {
                    swipeRefreshLayout2.getClass();
                }
                SwipeRefreshLayout swipeRefreshLayout3 = SwipeRefreshLayout.this;
                swipeRefreshLayout3.f11496l = swipeRefreshLayout3.f11504y.getTop();
                return;
            }
            swipeRefreshLayout.k();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes.dex */
    public class e implements Animation.AnimationListener {
        public e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (!swipeRefreshLayout.f11501q) {
                swipeRefreshLayout.q(null);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public void setOnChildScrollUpCallback(i iVar) {
    }

    public void setOnRefreshListener(j jVar) {
    }
}
