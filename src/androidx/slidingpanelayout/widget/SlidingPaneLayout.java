package androidx.slidingpanelayout.widget;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import androidx.core.view.C0446a;
import androidx.core.view.K;
import androidx.core.view.X;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.c;
import androidx.slidingpanelayout.widget.FoldingFeatureObserver;
import androidx.transition.ChangeBounds;
import androidx.transition.y;
import androidx.window.layout.FoldingFeature;
import androidx.window.layout.WindowInfoTracker;
import com.android.incallui.OplusPhoneUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class SlidingPaneLayout extends ViewGroup {

    /* renamed from: D, reason: collision with root package name */
    public static boolean f11428D = true;

    /* renamed from: A, reason: collision with root package name */
    public FoldingFeature f11429A;

    /* renamed from: B, reason: collision with root package name */
    public FoldingFeatureObserver.a f11430B;

    /* renamed from: C, reason: collision with root package name */
    public FoldingFeatureObserver f11431C;

    /* renamed from: a, reason: collision with root package name */
    public int f11432a;

    /* renamed from: b, reason: collision with root package name */
    public int f11433b;

    /* renamed from: c, reason: collision with root package name */
    public Drawable f11434c;

    /* renamed from: d, reason: collision with root package name */
    public Drawable f11435d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f11436e;

    /* renamed from: f, reason: collision with root package name */
    public View f11437f;

    /* renamed from: g, reason: collision with root package name */
    public float f11438g;

    /* renamed from: h, reason: collision with root package name */
    public float f11439h;

    /* renamed from: i, reason: collision with root package name */
    public int f11440i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f11441j;

    /* renamed from: k, reason: collision with root package name */
    public int f11442k;

    /* renamed from: l, reason: collision with root package name */
    public float f11443l;

    /* renamed from: m, reason: collision with root package name */
    public float f11444m;

    /* renamed from: n, reason: collision with root package name */
    public final List<e> f11445n;

    /* renamed from: o, reason: collision with root package name */
    public e f11446o;

    /* renamed from: p, reason: collision with root package name */
    public final androidx.customview.widget.c f11447p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f11448q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f11449r;

    /* renamed from: x, reason: collision with root package name */
    public final Rect f11450x;

    /* renamed from: y, reason: collision with root package name */
    public final ArrayList<c> f11451y;

    /* renamed from: z, reason: collision with root package name */
    public int f11452z;

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public boolean f11458a;

        /* renamed from: b, reason: collision with root package name */
        public int f11459b;

        /* loaded from: classes.dex */
        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f11458a ? 1 : 0);
            parcel.writeInt(this.f11459b);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f11458a = parcel.readInt() != 0;
            this.f11459b = parcel.readInt();
        }
    }

    /* loaded from: classes.dex */
    public class a implements FoldingFeatureObserver.a {
        public a() {
        }

        @Override // androidx.slidingpanelayout.widget.FoldingFeatureObserver.a
        public void a(FoldingFeature foldingFeature) {
            SlidingPaneLayout.this.f11429A = foldingFeature;
            ChangeBounds changeBounds = new ChangeBounds();
            changeBounds.setDuration(300L);
            changeBounds.setInterpolator(K.a.a(0.2f, 0.0f, 0.0f, 1.0f));
            y.a(SlidingPaneLayout.this, changeBounds);
            SlidingPaneLayout.this.requestLayout();
        }
    }

    /* loaded from: classes.dex */
    public class b extends C0446a {

        /* renamed from: a, reason: collision with root package name */
        public final Rect f11461a = new Rect();

        public b() {
        }

        public final void copyNodeInfoNoChildren(J.d dVar, J.d dVar2) {
            Rect rect = this.f11461a;
            dVar2.l(rect);
            dVar.d0(rect);
            dVar.M0(dVar2.U());
            dVar.x0(dVar2.w());
            dVar.h0(dVar2.o());
            dVar.l0(dVar2.r());
            dVar.n0(dVar2.J());
            dVar.i0(dVar2.H());
            dVar.p0(dVar2.K());
            dVar.q0(dVar2.L());
            dVar.b0(dVar2.E());
            dVar.F0(dVar2.R());
            dVar.u0(dVar2.O());
            dVar.a(dVar2.i());
            dVar.w0(dVar2.v());
        }

        public boolean filter(View view) {
            return SlidingPaneLayout.this.k(view);
        }

        @Override // androidx.core.view.C0446a
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName("androidx.slidingpanelayout.widget.SlidingPaneLayout");
        }

        @Override // androidx.core.view.C0446a
        public void onInitializeAccessibilityNodeInfo(View view, J.d dVar) {
            J.d W10 = J.d.W(dVar);
            super.onInitializeAccessibilityNodeInfo(view, W10);
            copyNodeInfoNoChildren(dVar, W10);
            W10.Z();
            dVar.h0("androidx.slidingpanelayout.widget.SlidingPaneLayout");
            dVar.H0(view);
            Object B10 = K.B(view);
            if (B10 instanceof View) {
                dVar.z0((View) B10);
            }
            int childCount = SlidingPaneLayout.this.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = SlidingPaneLayout.this.getChildAt(i10);
                if (!filter(childAt) && childAt.getVisibility() == 0) {
                    K.t0(childAt, 1);
                    dVar.c(childAt);
                }
            }
        }

        @Override // androidx.core.view.C0446a
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (!filter(view)) {
                return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final View f11463a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SlidingPaneLayout f11464b;

        @Override // java.lang.Runnable
        public void run() {
            if (this.f11463a.getParent() == this.f11464b) {
                this.f11463a.setLayerType(0, null);
                this.f11464b.j(this.f11463a);
            }
            this.f11464b.f11451y.remove(this);
        }
    }

    /* loaded from: classes.dex */
    public class d extends c.AbstractC0115c {
        public d() {
        }

        public final boolean a() {
            SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
            if (slidingPaneLayout.f11441j || slidingPaneLayout.getLockMode() == 3) {
                return false;
            }
            if (SlidingPaneLayout.this.m() && SlidingPaneLayout.this.getLockMode() == 1) {
                return false;
            }
            if (!SlidingPaneLayout.this.m() && SlidingPaneLayout.this.getLockMode() == 2) {
                return false;
            }
            return true;
        }

        @Override // androidx.customview.widget.c.AbstractC0115c
        public int clampViewPositionHorizontal(View view, int i10, int i11) {
            LayoutParams layoutParams = (LayoutParams) SlidingPaneLayout.this.f11437f.getLayoutParams();
            if (SlidingPaneLayout.this.l()) {
                int width = SlidingPaneLayout.this.getWidth() - ((SlidingPaneLayout.this.getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin) + SlidingPaneLayout.this.f11437f.getWidth());
                return Math.max(Math.min(i10, width), width - SlidingPaneLayout.this.f11440i);
            }
            int paddingLeft = SlidingPaneLayout.this.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            return Math.min(Math.max(i10, paddingLeft), SlidingPaneLayout.this.f11440i + paddingLeft);
        }

        @Override // androidx.customview.widget.c.AbstractC0115c
        public int clampViewPositionVertical(View view, int i10, int i11) {
            return view.getTop();
        }

        @Override // androidx.customview.widget.c.AbstractC0115c
        public int getViewHorizontalDragRange(View view) {
            return SlidingPaneLayout.this.f11440i;
        }

        @Override // androidx.customview.widget.c.AbstractC0115c
        public void onEdgeDragStarted(int i10, int i11) {
            if (!a()) {
                return;
            }
            SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
            slidingPaneLayout.f11447p.c(slidingPaneLayout.f11437f, i11);
        }

        @Override // androidx.customview.widget.c.AbstractC0115c
        public void onEdgeTouched(int i10, int i11) {
            if (!a()) {
                return;
            }
            SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
            slidingPaneLayout.f11447p.c(slidingPaneLayout.f11437f, i11);
        }

        @Override // androidx.customview.widget.c.AbstractC0115c
        public void onViewCaptured(View view, int i10) {
            SlidingPaneLayout.this.u();
        }

        @Override // androidx.customview.widget.c.AbstractC0115c
        public void onViewDragStateChanged(int i10) {
            if (SlidingPaneLayout.this.f11447p.B() == 0) {
                SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
                if (slidingPaneLayout.f11438g == 1.0f) {
                    slidingPaneLayout.x(slidingPaneLayout.f11437f);
                    SlidingPaneLayout slidingPaneLayout2 = SlidingPaneLayout.this;
                    slidingPaneLayout2.d(slidingPaneLayout2.f11437f);
                    SlidingPaneLayout.this.f11448q = false;
                    return;
                }
                slidingPaneLayout.e(slidingPaneLayout.f11437f);
                SlidingPaneLayout.this.f11448q = true;
            }
        }

        @Override // androidx.customview.widget.c.AbstractC0115c
        public void onViewPositionChanged(View view, int i10, int i11, int i12, int i13) {
            SlidingPaneLayout.this.p(i10);
            SlidingPaneLayout.this.invalidate();
        }

        @Override // androidx.customview.widget.c.AbstractC0115c
        public void onViewReleased(View view, float f10, float f11) {
            int paddingLeft;
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (SlidingPaneLayout.this.l()) {
                int paddingRight = SlidingPaneLayout.this.getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                if (f10 < 0.0f || (f10 == 0.0f && SlidingPaneLayout.this.f11438g > 0.5f)) {
                    paddingRight += SlidingPaneLayout.this.f11440i;
                }
                paddingLeft = (SlidingPaneLayout.this.getWidth() - paddingRight) - SlidingPaneLayout.this.f11437f.getWidth();
            } else {
                paddingLeft = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + SlidingPaneLayout.this.getPaddingLeft();
                if (f10 > 0.0f || (f10 == 0.0f && SlidingPaneLayout.this.f11438g > 0.5f)) {
                    paddingLeft += SlidingPaneLayout.this.f11440i;
                }
            }
            SlidingPaneLayout.this.f11447p.P(paddingLeft, view.getTop());
            SlidingPaneLayout.this.invalidate();
        }

        @Override // androidx.customview.widget.c.AbstractC0115c
        public boolean tryCaptureView(View view, int i10) {
            if (!a()) {
                return false;
            }
            return ((LayoutParams) view.getLayoutParams()).f11455b;
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(View view);

        void b(View view);

        void onPanelSlide(View view, float f10);
    }

    /* loaded from: classes.dex */
    public static class f extends FrameLayout {
        public f(View view) {
            super(view.getContext());
            addView(view);
        }

        @Override // android.view.View
        public boolean onGenericMotionEvent(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return true;
        }
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static Activity g(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    private B.b getSystemGestureInsets() {
        X C10;
        if (f11428D && (C10 = K.C(this)) != null) {
            return C10.i();
        }
        return null;
    }

    public static Rect h(FoldingFeature foldingFeature, View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i10 = iArr[0];
        Rect rect = new Rect(i10, iArr[1], view.getWidth() + i10, iArr[1] + view.getWidth());
        Rect rect2 = new Rect(foldingFeature.a());
        boolean intersect = rect2.intersect(rect);
        if ((rect2.width() == 0 && rect2.height() == 0) || !intersect) {
            return null;
        }
        rect2.offset(-iArr[0], -iArr[1]);
        return rect2;
    }

    public static int i(View view) {
        if (view instanceof f) {
            return K.y(((f) view).getChildAt(0));
        }
        return K.y(view);
    }

    public static int o(View view, int i10, int i11) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (((ViewGroup.MarginLayoutParams) layoutParams).width == 0 && layoutParams.f11454a > 0.0f) {
            return ViewGroup.getChildMeasureSpec(i10, i11, ((ViewGroup.MarginLayoutParams) layoutParams).height);
        }
        return View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 1073741824);
    }

    private void setFoldingFeatureObserver(FoldingFeatureObserver foldingFeatureObserver) {
        this.f11431C = foldingFeatureObserver;
        foldingFeatureObserver.f(this.f11430B);
    }

    public static boolean y(View view) {
        if (view.isOpaque()) {
            return true;
        }
        return false;
    }

    public void a(e eVar) {
        this.f11445n.add(eVar);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() == 1) {
            super.addView(new f(view), i10, layoutParams);
        } else {
            super.addView(view, i10, layoutParams);
        }
    }

    public boolean b() {
        return c(0);
    }

    public final boolean c(int i10) {
        if (!this.f11436e) {
            this.f11448q = false;
        }
        if (!this.f11449r && !v(1.0f, i10)) {
            return false;
        }
        this.f11448q = false;
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if ((layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams)) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f11447p.n(true)) {
            if (!this.f11436e) {
                this.f11447p.a();
            } else {
                K.Z(this);
            }
        }
    }

    public void d(View view) {
        Iterator<e> it = this.f11445n.iterator();
        while (it.hasNext()) {
            it.next().b(view);
        }
        sendAccessibilityEvent(32);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Drawable drawable;
        View view;
        int i10;
        int i11;
        super.draw(canvas);
        if (l()) {
            drawable = this.f11435d;
        } else {
            drawable = this.f11434c;
        }
        if (getChildCount() > 1) {
            view = getChildAt(1);
        } else {
            view = null;
        }
        if (view != null && drawable != null) {
            int top = view.getTop();
            int bottom = view.getBottom();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (l()) {
                i11 = view.getRight();
                i10 = intrinsicWidth + i11;
            } else {
                int left = view.getLeft();
                int i12 = left - intrinsicWidth;
                i10 = left;
                i11 = i12;
            }
            drawable.setBounds(i11, top, i10, bottom);
            drawable.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j10) {
        if (l() ^ m()) {
            this.f11447p.N(1);
            B.b systemGestureInsets = getSystemGestureInsets();
            if (systemGestureInsets != null) {
                androidx.customview.widget.c cVar = this.f11447p;
                cVar.M(Math.max(cVar.x(), systemGestureInsets.f207a));
            }
        } else {
            this.f11447p.N(2);
            B.b systemGestureInsets2 = getSystemGestureInsets();
            if (systemGestureInsets2 != null) {
                androidx.customview.widget.c cVar2 = this.f11447p;
                cVar2.M(Math.max(cVar2.x(), systemGestureInsets2.f209c));
            }
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int save = canvas.save();
        if (this.f11436e && !layoutParams.f11455b && this.f11437f != null) {
            canvas.getClipBounds(this.f11450x);
            if (l()) {
                Rect rect = this.f11450x;
                rect.left = Math.max(rect.left, this.f11437f.getRight());
            } else {
                Rect rect2 = this.f11450x;
                rect2.right = Math.min(rect2.right, this.f11437f.getLeft());
            }
            canvas.clipRect(this.f11450x);
        }
        boolean drawChild = super.drawChild(canvas, view, j10);
        canvas.restoreToCount(save);
        return drawChild;
    }

    public void e(View view) {
        Iterator<e> it = this.f11445n.iterator();
        while (it.hasNext()) {
            it.next().a(view);
        }
        sendAccessibilityEvent(32);
    }

    public void f(View view) {
        Iterator<e> it = this.f11445n.iterator();
        while (it.hasNext()) {
            it.next().onPanelSlide(view, this.f11438g);
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    @Deprecated
    public int getCoveredFadeColor() {
        return this.f11433b;
    }

    public final int getLockMode() {
        return this.f11452z;
    }

    public int getParallaxDistance() {
        return this.f11442k;
    }

    @Deprecated
    public int getSliderFadeColor() {
        return this.f11432a;
    }

    public void j(View view) {
        K.x0(view, ((LayoutParams) view.getLayoutParams()).f11457d);
    }

    public boolean k(View view) {
        if (view == null) {
            return false;
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!this.f11436e || !layoutParams.f11456c || this.f11438g <= 0.0f) {
            return false;
        }
        return true;
    }

    public boolean l() {
        if (K.v(this) == 1) {
            return true;
        }
        return false;
    }

    public boolean m() {
        if (this.f11436e && this.f11438g != 0.0f) {
            return false;
        }
        return true;
    }

    public boolean n() {
        return this.f11436e;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Activity g10;
        super.onAttachedToWindow();
        this.f11449r = true;
        if (this.f11431C != null && (g10 = g(getContext())) != null) {
            this.f11431C.e(g10);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f11449r = true;
        FoldingFeatureObserver foldingFeatureObserver = this.f11431C;
        if (foldingFeatureObserver != null) {
            foldingFeatureObserver.g();
        }
        int size = this.f11451y.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f11451y.get(i10).run();
        }
        this.f11451y.clear();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z10;
        View childAt;
        int actionMasked = motionEvent.getActionMasked();
        if (!this.f11436e && actionMasked == 0 && getChildCount() > 1 && (childAt = getChildAt(1)) != null) {
            this.f11448q = this.f11447p.F(childAt, (int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (this.f11436e && (!this.f11441j || actionMasked == 0)) {
            if (actionMasked != 3 && actionMasked != 1) {
                if (actionMasked != 0) {
                    if (actionMasked == 2) {
                        float x10 = motionEvent.getX();
                        float y10 = motionEvent.getY();
                        float abs = Math.abs(x10 - this.f11443l);
                        float abs2 = Math.abs(y10 - this.f11444m);
                        if (abs > this.f11447p.A() && abs2 > abs) {
                            this.f11447p.b();
                            this.f11441j = true;
                            return false;
                        }
                    }
                } else {
                    this.f11441j = false;
                    float x11 = motionEvent.getX();
                    float y11 = motionEvent.getY();
                    this.f11443l = x11;
                    this.f11444m = y11;
                    if (this.f11447p.F(this.f11437f, (int) x11, (int) y11) && k(this.f11437f)) {
                        z10 = true;
                        if (this.f11447p.Q(motionEvent) && !z10) {
                            return false;
                        }
                    }
                }
                z10 = false;
                return this.f11447p.Q(motionEvent) ? true : true;
            }
            this.f11447p.b();
            return false;
        }
        this.f11447p.b();
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int paddingLeft;
        int paddingRight;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        boolean z11;
        float f10;
        boolean l10 = l();
        int i21 = i12 - i10;
        if (l10) {
            paddingLeft = getPaddingRight();
        } else {
            paddingLeft = getPaddingLeft();
        }
        if (l10) {
            paddingRight = getPaddingLeft();
        } else {
            paddingRight = getPaddingRight();
        }
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.f11449r) {
            if (this.f11436e && this.f11448q) {
                f10 = 0.0f;
            } else {
                f10 = 1.0f;
            }
            this.f11438g = f10;
        }
        int i22 = paddingLeft;
        int i23 = 0;
        while (i23 < childCount) {
            View childAt = getChildAt(i23);
            if (childAt.getVisibility() == 8) {
                i14 = i22;
            } else {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                if (layoutParams.f11455b) {
                    int i24 = i21 - paddingRight;
                    int min = (Math.min(paddingLeft, i24) - i22) - (((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin);
                    this.f11440i = min;
                    if (l10) {
                        i20 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                    } else {
                        i20 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    }
                    if (i22 + i20 + min + (measuredWidth / 2) > i24) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    layoutParams.f11456c = z11;
                    int i25 = (int) (min * this.f11438g);
                    this.f11438g = i25 / min;
                    i14 = i22 + i20 + i25;
                    i15 = 0;
                } else if (this.f11436e && (i16 = this.f11442k) != 0) {
                    i15 = (int) ((1.0f - this.f11438g) * i16);
                    i14 = paddingLeft;
                } else {
                    i14 = paddingLeft;
                    i15 = 0;
                }
                if (l10) {
                    i18 = (i21 - i14) + i15;
                    i17 = i18 - measuredWidth;
                } else {
                    i17 = i14 - i15;
                    i18 = i17 + measuredWidth;
                }
                childAt.layout(i17, paddingTop, i18, childAt.getMeasuredHeight() + paddingTop);
                FoldingFeature foldingFeature = this.f11429A;
                if (foldingFeature != null && foldingFeature.c() == FoldingFeature.Orientation.f12006c && this.f11429A.b()) {
                    i19 = this.f11429A.a().width();
                } else {
                    i19 = 0;
                }
                paddingLeft += childAt.getWidth() + Math.abs(i19);
            }
            i23++;
            i22 = i14;
        }
        if (this.f11449r) {
            if (this.f11436e && this.f11442k != 0) {
                s(this.f11438g);
            }
            x(this.f11437f);
        }
        this.f11449r = false;
    }

    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r8v12 */
    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int paddingTop;
        int i12;
        int i13;
        int measuredWidth;
        int i14;
        int i15;
        int makeMeasureSpec;
        boolean z10;
        int i16;
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int size2 = View.MeasureSpec.getSize(i11);
        ?? r82 = 0;
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 != 1073741824) {
                i12 = 0;
            } else {
                i12 = (size2 - getPaddingTop()) - getPaddingBottom();
            }
            paddingTop = i12;
        } else {
            paddingTop = (size2 - getPaddingTop()) - getPaddingBottom();
            i12 = 0;
        }
        int max = Math.max((size - getPaddingLeft()) - getPaddingRight(), 0);
        int childCount = getChildCount();
        if (childCount > 2) {
            Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
        }
        this.f11437f = null;
        int i17 = 0;
        boolean z11 = false;
        int i18 = max;
        float f10 = 0.0f;
        while (true) {
            i13 = 8;
            if (i17 >= childCount) {
                break;
            }
            View childAt = getChildAt(i17);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int i19 = size;
            if (childAt.getVisibility() == 8) {
                layoutParams.f11456c = r82;
            } else {
                float f11 = layoutParams.f11454a;
                if (f11 > 0.0f) {
                    f10 += f11;
                    if (((ViewGroup.MarginLayoutParams) layoutParams).width == 0) {
                    }
                }
                int max2 = Math.max(max - (((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin), (int) r82);
                int i20 = ((ViewGroup.MarginLayoutParams) layoutParams).width;
                if (i20 == -2) {
                    if (mode == 0) {
                        i16 = mode;
                    } else {
                        i16 = Integer.MIN_VALUE;
                    }
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(max2, i16);
                } else if (i20 == -1) {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(max2, mode);
                } else {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i20, 1073741824);
                }
                childAt.measure(makeMeasureSpec, ViewGroup.getChildMeasureSpec(i11, getPaddingTop() + getPaddingBottom(), ((ViewGroup.MarginLayoutParams) layoutParams).height));
                int measuredWidth2 = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (measuredHeight > i12) {
                    if (mode2 == Integer.MIN_VALUE) {
                        i12 = Math.min(measuredHeight, paddingTop);
                    } else if (mode2 == 0) {
                        i12 = measuredHeight;
                    }
                }
                i18 -= measuredWidth2;
                if (i17 != 0) {
                    if (i18 < 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    layoutParams.f11455b = z10;
                    z11 |= z10;
                    if (z10) {
                        this.f11437f = childAt;
                    }
                }
            }
            i17++;
            size = i19;
            r82 = 0;
        }
        int i21 = size;
        int i22 = i18;
        if (z11 || f10 > 0.0f) {
            int i23 = 0;
            while (i23 < childCount) {
                View childAt2 = getChildAt(i23);
                if (childAt2.getVisibility() != i13) {
                    LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                    if (((ViewGroup.MarginLayoutParams) layoutParams2).width == 0 && layoutParams2.f11454a > 0.0f) {
                        measuredWidth = 0;
                    } else {
                        measuredWidth = childAt2.getMeasuredWidth();
                    }
                    if (z11) {
                        i14 = max - (((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin);
                        i15 = View.MeasureSpec.makeMeasureSpec(i14, 1073741824);
                    } else if (layoutParams2.f11454a > 0.0f) {
                        i14 = measuredWidth + ((int) ((layoutParams2.f11454a * Math.max(0, i22)) / f10));
                        i15 = View.MeasureSpec.makeMeasureSpec(i14, 1073741824);
                    } else {
                        i14 = measuredWidth;
                        i15 = 0;
                    }
                    int o10 = o(childAt2, i11, getPaddingTop() + getPaddingBottom());
                    if (measuredWidth != i14) {
                        childAt2.measure(i15, o10);
                        int measuredHeight2 = childAt2.getMeasuredHeight();
                        if (measuredHeight2 > i12) {
                            if (mode2 == Integer.MIN_VALUE) {
                                measuredHeight2 = Math.min(measuredHeight2, paddingTop);
                            } else if (mode2 != 0) {
                            }
                            i12 = measuredHeight2;
                        }
                    }
                }
                i23++;
                i13 = 8;
            }
        }
        ArrayList<Rect> w10 = w();
        if (w10 != null && !z11) {
            for (int i24 = 0; i24 < childCount; i24++) {
                View childAt3 = getChildAt(i24);
                if (childAt3.getVisibility() != 8) {
                    Rect rect = w10.get(i24);
                    LayoutParams layoutParams3 = (LayoutParams) childAt3.getLayoutParams();
                    int i25 = ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin;
                    int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(childAt3.getMeasuredHeight(), 1073741824);
                    childAt3.measure(View.MeasureSpec.makeMeasureSpec(rect.width(), Integer.MIN_VALUE), makeMeasureSpec2);
                    if ((childAt3.getMeasuredWidthAndState() & OplusPhoneUtils.FLAG_RECEIVER_INCLUDE_BACKGROUND) != 1 && (i(childAt3) == 0 || rect.width() >= i(childAt3))) {
                        childAt3.measure(View.MeasureSpec.makeMeasureSpec(rect.width(), 1073741824), makeMeasureSpec2);
                    } else {
                        childAt3.measure(View.MeasureSpec.makeMeasureSpec(max - i25, 1073741824), makeMeasureSpec2);
                        if (i24 != 0) {
                            layoutParams3.f11455b = true;
                            this.f11437f = childAt3;
                            z11 = true;
                        }
                    }
                }
            }
        }
        setMeasuredDimension(i21, i12 + getPaddingTop() + getPaddingBottom());
        this.f11436e = z11;
        if (this.f11447p.B() != 0 && !z11) {
            this.f11447p.a();
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.f11458a) {
            q();
        } else {
            b();
        }
        this.f11448q = savedState.f11458a;
        setLockMode(savedState.f11459b);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        boolean z10;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (n()) {
            z10 = m();
        } else {
            z10 = this.f11448q;
        }
        savedState.f11458a = z10;
        savedState.f11459b = this.f11452z;
        return savedState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        if (i10 != i12) {
            this.f11449r = true;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f11436e) {
            return super.onTouchEvent(motionEvent);
        }
        this.f11447p.G(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1 && k(this.f11437f)) {
                float x10 = motionEvent.getX();
                float y10 = motionEvent.getY();
                float f10 = x10 - this.f11443l;
                float f11 = y10 - this.f11444m;
                int A10 = this.f11447p.A();
                if ((f10 * f10) + (f11 * f11) < A10 * A10 && this.f11447p.F(this.f11437f, (int) x10, (int) y10)) {
                    c(0);
                }
            }
        } else {
            float x11 = motionEvent.getX();
            float y11 = motionEvent.getY();
            this.f11443l = x11;
            this.f11444m = y11;
        }
        return true;
    }

    public void p(int i10) {
        int paddingLeft;
        int i11;
        if (this.f11437f == null) {
            this.f11438g = 0.0f;
            return;
        }
        boolean l10 = l();
        LayoutParams layoutParams = (LayoutParams) this.f11437f.getLayoutParams();
        int width = this.f11437f.getWidth();
        if (l10) {
            i10 = (getWidth() - i10) - width;
        }
        if (l10) {
            paddingLeft = getPaddingRight();
        } else {
            paddingLeft = getPaddingLeft();
        }
        if (l10) {
            i11 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        } else {
            i11 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
        }
        float f10 = (i10 - (paddingLeft + i11)) / this.f11440i;
        this.f11438g = f10;
        if (this.f11442k != 0) {
            s(f10);
        }
        f(this.f11437f);
    }

    public boolean q() {
        return r(0);
    }

    public final boolean r(int i10) {
        if (!this.f11436e) {
            this.f11448q = true;
        }
        if (!this.f11449r && !v(0.0f, i10)) {
            return false;
        }
        this.f11448q = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (view.getParent() instanceof f) {
            super.removeView((View) view.getParent());
        } else {
            super.removeView(view);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        boolean z10;
        super.requestChildFocus(view, view2);
        if (!isInTouchMode() && !this.f11436e) {
            if (view == this.f11437f) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.f11448q = z10;
        }
    }

    public final void s(float f10) {
        boolean l10 = l();
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt != this.f11437f) {
                float f11 = 1.0f - this.f11439h;
                int i11 = this.f11442k;
                this.f11439h = f10;
                int i12 = ((int) (f11 * i11)) - ((int) ((1.0f - f10) * i11));
                if (l10) {
                    i12 = -i12;
                }
                childAt.offsetLeftAndRight(i12);
            }
        }
    }

    @Deprecated
    public void setCoveredFadeColor(int i10) {
        this.f11433b = i10;
    }

    public final void setLockMode(int i10) {
        this.f11452z = i10;
    }

    @Deprecated
    public void setPanelSlideListener(e eVar) {
        e eVar2 = this.f11446o;
        if (eVar2 != null) {
            t(eVar2);
        }
        if (eVar != null) {
            a(eVar);
        }
        this.f11446o = eVar;
    }

    public void setParallaxDistance(int i10) {
        this.f11442k = i10;
        requestLayout();
    }

    @Deprecated
    public void setShadowDrawable(Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(Drawable drawable) {
        this.f11434c = drawable;
    }

    public void setShadowDrawableRight(Drawable drawable) {
        this.f11435d = drawable;
    }

    @Deprecated
    public void setShadowResource(int i10) {
        setShadowDrawableLeft(getResources().getDrawable(i10));
    }

    public void setShadowResourceLeft(int i10) {
        setShadowDrawableLeft(androidx.core.content.b.e(getContext(), i10));
    }

    public void setShadowResourceRight(int i10) {
        setShadowDrawableRight(androidx.core.content.b.e(getContext(), i10));
    }

    @Deprecated
    public void setSliderFadeColor(int i10) {
        this.f11432a = i10;
    }

    public void t(e eVar) {
        this.f11445n.remove(eVar);
    }

    public void u() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    public boolean v(float f10, int i10) {
        int paddingLeft;
        if (!this.f11436e) {
            return false;
        }
        boolean l10 = l();
        LayoutParams layoutParams = (LayoutParams) this.f11437f.getLayoutParams();
        if (l10) {
            paddingLeft = (int) (getWidth() - (((getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin) + (f10 * this.f11440i)) + this.f11437f.getWidth()));
        } else {
            paddingLeft = (int) (getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + (f10 * this.f11440i));
        }
        androidx.customview.widget.c cVar = this.f11447p;
        View view = this.f11437f;
        if (!cVar.R(view, paddingLeft, view.getTop())) {
            return false;
        }
        u();
        K.Z(this);
        return true;
    }

    public final ArrayList<Rect> w() {
        Rect h10;
        FoldingFeature foldingFeature = this.f11429A;
        if (foldingFeature == null || !foldingFeature.b() || this.f11429A.a().left == 0 || this.f11429A.a().top != 0 || (h10 = h(this.f11429A, this)) == null) {
            return null;
        }
        Rect rect = new Rect(getPaddingLeft(), getPaddingTop(), Math.max(getPaddingLeft(), h10.left), getHeight() - getPaddingBottom());
        int width = getWidth() - getPaddingRight();
        return new ArrayList<>(Arrays.asList(rect, new Rect(Math.min(width, h10.right), getPaddingTop(), width, getHeight() - getPaddingBottom())));
    }

    public void x(View view) {
        int paddingLeft;
        int width;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        boolean z10;
        int i15;
        int i16;
        View view2 = view;
        boolean l10 = l();
        if (l10) {
            paddingLeft = getWidth() - getPaddingRight();
        } else {
            paddingLeft = getPaddingLeft();
        }
        if (l10) {
            width = getPaddingLeft();
        } else {
            width = getWidth() - getPaddingRight();
        }
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view2 != null && y(view)) {
            i10 = view.getLeft();
            i11 = view.getRight();
            i12 = view.getTop();
            i13 = view.getBottom();
        } else {
            i10 = 0;
            i11 = 0;
            i12 = 0;
            i13 = 0;
        }
        int childCount = getChildCount();
        int i17 = 0;
        while (i17 < childCount) {
            View childAt = getChildAt(i17);
            if (childAt != view2) {
                if (childAt.getVisibility() == 8) {
                    z10 = l10;
                } else {
                    if (l10) {
                        i14 = width;
                    } else {
                        i14 = paddingLeft;
                    }
                    int max = Math.max(i14, childAt.getLeft());
                    int max2 = Math.max(paddingTop, childAt.getTop());
                    z10 = l10;
                    if (l10) {
                        i15 = paddingLeft;
                    } else {
                        i15 = width;
                    }
                    int min = Math.min(i15, childAt.getRight());
                    int min2 = Math.min(height, childAt.getBottom());
                    if (max >= i10 && max2 >= i12 && min <= i11 && min2 <= i13) {
                        i16 = 4;
                    } else {
                        i16 = 0;
                    }
                    childAt.setVisibility(i16);
                }
                i17++;
                view2 = view;
                l10 = z10;
            } else {
                return;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: e, reason: collision with root package name */
        public static final int[] f11453e = {R.attr.layout_weight};

        /* renamed from: a, reason: collision with root package name */
        public float f11454a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f11455b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f11456c;

        /* renamed from: d, reason: collision with root package name */
        public Paint f11457d;

        public LayoutParams() {
            super(-1, -1);
            this.f11454a = 0.0f;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f11454a = 0.0f;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f11454a = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f11454a = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f11453e);
            this.f11454a = obtainStyledAttributes.getFloat(0, 0.0f);
            obtainStyledAttributes.recycle();
        }
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f11432a = 0;
        this.f11438g = 1.0f;
        this.f11445n = new CopyOnWriteArrayList();
        this.f11449r = true;
        this.f11450x = new Rect();
        this.f11451y = new ArrayList<>();
        this.f11430B = new a();
        float f10 = context.getResources().getDisplayMetrics().density;
        setWillNotDraw(false);
        K.j0(this, new b());
        K.t0(this, 1);
        androidx.customview.widget.c o10 = androidx.customview.widget.c.o(this, 0.5f, new d());
        this.f11447p = o10;
        o10.O(f10 * 400.0f);
        setFoldingFeatureObserver(new FoldingFeatureObserver(WindowInfoTracker.a(context), androidx.core.content.b.h(context)));
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }
}
