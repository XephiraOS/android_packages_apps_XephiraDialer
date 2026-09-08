package com.google.android.material.bottomsheet;

import J.d;
import J.g;
import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.RoundedCorner;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.K;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.c;
import com.android.incallui.OplusPhoneUtils;
import com.google.android.material.internal.ViewUtils;
import e4.C0977c;
import e4.C0979e;
import e4.k;
import e4.l;
import e4.m;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import s4.C1546e;
import s4.InterfaceC1543b;
import u4.C1607c;
import x4.i;
import x4.n;

/* loaded from: classes3.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> implements InterfaceC1543b {
    private static final int CORNER_ANIMATION_DURATION = 500;
    static final int DEFAULT_SIGNIFICANT_VEL_THRESHOLD = 500;
    private static final int DEF_STYLE_RES = l.f31028k;
    private static final float HIDE_FRICTION = 0.1f;
    private static final float HIDE_THRESHOLD = 0.5f;
    private static final int INVALID_POSITION = -1;
    private static final int NO_MAX_SIZE = -1;
    public static final int PEEK_HEIGHT_AUTO = -1;
    public static final int SAVE_ALL = -1;
    public static final int SAVE_FIT_TO_CONTENTS = 2;
    public static final int SAVE_HIDEABLE = 4;
    public static final int SAVE_NONE = 0;
    public static final int SAVE_PEEK_HEIGHT = 1;
    public static final int SAVE_SKIP_COLLAPSED = 8;
    public static final int STATE_COLLAPSED = 4;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_EXPANDED = 3;
    public static final int STATE_HALF_EXPANDED = 6;
    public static final int STATE_HIDDEN = 5;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "BottomSheetBehavior";
    static final int VIEW_INDEX_ACCESSIBILITY_DELEGATE_VIEW = 1;
    private static final int VIEW_INDEX_BOTTOM_SHEET = 0;
    WeakReference<View> accessibilityDelegateViewRef;
    int activePointerId;
    private ColorStateList backgroundTint;
    C1546e bottomContainerBackHelper;
    private final ArrayList<g> callbacks;
    private int childHeight;
    int collapsedOffset;
    private final c.AbstractC0115c dragCallback;
    private boolean draggable;
    float elevation;
    final SparseIntArray expandHalfwayActionIds;
    private boolean expandedCornersRemoved;
    int expandedOffset;
    private boolean fitToContents;
    int fitToContentsOffset;
    private int gestureInsetBottom;
    private boolean gestureInsetBottomIgnored;
    int halfExpandedOffset;
    float halfExpandedRatio;
    private float hideFriction;
    boolean hideable;
    private boolean ignoreEvents;
    private Map<View, Integer> importantForAccessibilityMap;
    private int initialY;
    private int insetBottom;
    private int insetTop;
    private ValueAnimator interpolatorAnimator;
    private int lastNestedScrollDy;
    int lastStableState;
    private boolean marginLeftSystemWindowInsets;
    private boolean marginRightSystemWindowInsets;
    private boolean marginTopSystemWindowInsets;
    private i materialShapeDrawable;
    private int maxHeight;
    private int maxWidth;
    private float maximumVelocity;
    private boolean nestedScrolled;
    WeakReference<View> nestedScrollingChildRef;
    private boolean paddingBottomSystemWindowInsets;
    private boolean paddingLeftSystemWindowInsets;
    private boolean paddingRightSystemWindowInsets;
    private boolean paddingTopSystemWindowInsets;
    int parentHeight;
    int parentWidth;
    private int peekHeight;
    private boolean peekHeightAuto;
    private int peekHeightGestureInsetBuffer;
    private int peekHeightMin;
    private int saveFlags;
    private n shapeAppearanceModelDefault;
    private boolean shouldRemoveExpandedCorners;
    private int significantVelocityThreshold;
    private boolean skipCollapsed;
    int state;
    private final BottomSheetBehavior<V>.h stateSettlingTracker;
    boolean touchingScrollingChild;
    private boolean updateImportantForAccessibilityOnSiblings;
    private VelocityTracker velocityTracker;
    androidx.customview.widget.c viewDragHelper;
    WeakReference<V> viewRef;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f22808a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f22809b;

        public a(View view, int i10) {
            this.f22808a = view;
            this.f22809b = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            BottomSheetBehavior.this.startSettling(this.f22808a, this.f22809b, false);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomSheetBehavior.this.setStateInternal(5);
            WeakReference<V> weakReference = BottomSheetBehavior.this.viewRef;
            if (weakReference != null && weakReference.get() != null) {
                BottomSheetBehavior.this.viewRef.get().requestLayout();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (BottomSheetBehavior.this.materialShapeDrawable != null) {
                BottomSheetBehavior.this.materialShapeDrawable.setInterpolation(floatValue);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements ViewUtils.OnApplyWindowInsetsListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f22813a;

        public d(boolean z10) {
            this.f22813a = z10;
        }

        /* JADX WARN: Code restructure failed: missing block: B:42:0x00a4, code lost:
        
            if (r6 != false) goto L35;
         */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0089  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x009b  */
        @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public androidx.core.view.X onApplyWindowInsets(android.view.View r11, androidx.core.view.X r12, com.google.android.material.internal.ViewUtils.RelativePadding r13) {
            /*
                r10 = this;
                int r0 = androidx.core.view.X.k.f()
                B.b r0 = r12.f(r0)
                int r1 = androidx.core.view.X.k.c()
                B.b r1 = r12.f(r1)
                com.google.android.material.bottomsheet.BottomSheetBehavior r2 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r3 = r0.f208b
                com.google.android.material.bottomsheet.BottomSheetBehavior.access$302(r2, r3)
                boolean r2 = com.google.android.material.internal.ViewUtils.isLayoutRtl(r11)
                int r3 = r11.getPaddingBottom()
                int r4 = r11.getPaddingLeft()
                int r5 = r11.getPaddingRight()
                com.google.android.material.bottomsheet.BottomSheetBehavior r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.access$400(r6)
                if (r6 == 0) goto L41
                com.google.android.material.bottomsheet.BottomSheetBehavior r3 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r6 = r12.j()
                com.google.android.material.bottomsheet.BottomSheetBehavior.access$502(r3, r6)
                int r3 = r13.bottom
                com.google.android.material.bottomsheet.BottomSheetBehavior r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.access$500(r6)
                int r3 = r3 + r6
            L41:
                com.google.android.material.bottomsheet.BottomSheetBehavior r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.access$600(r6)
                if (r6 == 0) goto L53
                if (r2 == 0) goto L4e
                int r4 = r13.end
                goto L50
            L4e:
                int r4 = r13.start
            L50:
                int r6 = r0.f207a
                int r4 = r4 + r6
            L53:
                com.google.android.material.bottomsheet.BottomSheetBehavior r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.access$700(r6)
                if (r6 == 0) goto L66
                if (r2 == 0) goto L60
                int r13 = r13.start
                goto L62
            L60:
                int r13 = r13.end
            L62:
                int r2 = r0.f209c
                int r5 = r13 + r2
            L66:
                android.view.ViewGroup$LayoutParams r13 = r11.getLayoutParams()
                android.view.ViewGroup$MarginLayoutParams r13 = (android.view.ViewGroup.MarginLayoutParams) r13
                com.google.android.material.bottomsheet.BottomSheetBehavior r2 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r2 = com.google.android.material.bottomsheet.BottomSheetBehavior.access$800(r2)
                r6 = 1
                r7 = 0
                if (r2 == 0) goto L80
                int r2 = r13.leftMargin
                int r8 = r0.f207a
                if (r2 == r8) goto L80
                r13.leftMargin = r8
                r2 = r6
                goto L81
            L80:
                r2 = r7
            L81:
                com.google.android.material.bottomsheet.BottomSheetBehavior r8 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r8 = com.google.android.material.bottomsheet.BottomSheetBehavior.access$900(r8)
                if (r8 == 0) goto L92
                int r8 = r13.rightMargin
                int r9 = r0.f209c
                if (r8 == r9) goto L92
                r13.rightMargin = r9
                goto L93
            L92:
                r6 = r2
            L93:
                com.google.android.material.bottomsheet.BottomSheetBehavior r2 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r2 = com.google.android.material.bottomsheet.BottomSheetBehavior.access$1000(r2)
                if (r2 == 0) goto La4
                int r2 = r13.topMargin
                int r0 = r0.f208b
                if (r2 == r0) goto La4
                r13.topMargin = r0
                goto La6
            La4:
                if (r6 == 0) goto La9
            La6:
                r11.setLayoutParams(r13)
            La9:
                int r13 = r11.getPaddingTop()
                r11.setPadding(r4, r13, r5, r3)
                boolean r11 = r10.f22813a
                if (r11 == 0) goto Lbb
                com.google.android.material.bottomsheet.BottomSheetBehavior r11 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r13 = r1.f210d
                com.google.android.material.bottomsheet.BottomSheetBehavior.access$1102(r11, r13)
            Lbb:
                com.google.android.material.bottomsheet.BottomSheetBehavior r11 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r11 = com.google.android.material.bottomsheet.BottomSheetBehavior.access$400(r11)
                if (r11 != 0) goto Lc7
                boolean r11 = r10.f22813a
                if (r11 == 0) goto Lcc
            Lc7:
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                com.google.android.material.bottomsheet.BottomSheetBehavior.access$1200(r10, r7)
            Lcc:
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.d.onApplyWindowInsets(android.view.View, androidx.core.view.X, com.google.android.material.internal.ViewUtils$RelativePadding):androidx.core.view.X");
        }
    }

    /* loaded from: classes3.dex */
    public class e extends c.AbstractC0115c {

        /* renamed from: a, reason: collision with root package name */
        public long f22815a;

        public e() {
        }

        @Override // androidx.customview.widget.c.AbstractC0115c
        public int clampViewPositionHorizontal(View view, int i10, int i11) {
            return view.getLeft();
        }

        @Override // androidx.customview.widget.c.AbstractC0115c
        public int clampViewPositionVertical(View view, int i10, int i11) {
            return E.a.b(i10, BottomSheetBehavior.this.getExpandedOffset(), getViewVerticalDragRange(view));
        }

        @Override // androidx.customview.widget.c.AbstractC0115c
        public int getViewVerticalDragRange(View view) {
            if (BottomSheetBehavior.this.canBeHiddenByDragging()) {
                return BottomSheetBehavior.this.parentHeight;
            }
            return BottomSheetBehavior.this.collapsedOffset;
        }

        @Override // androidx.customview.widget.c.AbstractC0115c
        public void onViewDragStateChanged(int i10) {
            if (i10 == 1 && BottomSheetBehavior.this.draggable) {
                BottomSheetBehavior.this.setStateInternal(1);
            }
        }

        @Override // androidx.customview.widget.c.AbstractC0115c
        public void onViewPositionChanged(View view, int i10, int i11, int i12, int i13) {
            BottomSheetBehavior.this.dispatchOnSlide(i11);
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0034, code lost:
        
            if (r7.f22816b.shouldExpandOnUpwardDrag(r0, (r9 * 100.0f) / r10.parentHeight) != false) goto L6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x003b, code lost:
        
            if (r9 > r7.f22816b.halfExpandedOffset) goto L63;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0090, code lost:
        
            if (java.lang.Math.abs(r8.getTop() - r7.f22816b.getExpandedOffset()) < java.lang.Math.abs(r8.getTop() - r7.f22816b.halfExpandedOffset)) goto L6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00cf, code lost:
        
            if (r7.f22816b.shouldSkipHalfExpandedStateWhenDragging() == false) goto L63;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x00f1, code lost:
        
            if (java.lang.Math.abs(r9 - r7.f22816b.fitToContentsOffset) < java.lang.Math.abs(r9 - r7.f22816b.collapsedOffset)) goto L6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x010d, code lost:
        
            if (r7.f22816b.shouldSkipHalfExpandedStateWhenDragging() != false) goto L39;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x0127, code lost:
        
            if (r7.f22816b.shouldSkipHalfExpandedStateWhenDragging() == false) goto L63;
         */
        @Override // androidx.customview.widget.c.AbstractC0115c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onViewReleased(android.view.View r8, float r9, float r10) {
            /*
                Method dump skipped, instructions count: 308
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.e.onViewReleased(android.view.View, float, float):void");
        }

        public final boolean releasedLow(View view) {
            int top = view.getTop();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            if (top > (bottomSheetBehavior.parentHeight + bottomSheetBehavior.getExpandedOffset()) / 2) {
                return true;
            }
            return false;
        }

        @Override // androidx.customview.widget.c.AbstractC0115c
        public boolean tryCaptureView(View view, int i10) {
            View view2;
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i11 = bottomSheetBehavior.state;
            if (i11 == 1 || bottomSheetBehavior.touchingScrollingChild) {
                return false;
            }
            if (i11 == 3 && bottomSheetBehavior.activePointerId == i10) {
                WeakReference<View> weakReference = bottomSheetBehavior.nestedScrollingChildRef;
                if (weakReference != null) {
                    view2 = weakReference.get();
                } else {
                    view2 = null;
                }
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            this.f22815a = System.currentTimeMillis();
            WeakReference<V> weakReference2 = BottomSheetBehavior.this.viewRef;
            if (weakReference2 == null || weakReference2.get() != view) {
                return false;
            }
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class f implements J.g {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f22817a;

        public f(int i10) {
            this.f22817a = i10;
        }

        @Override // J.g
        public boolean perform(View view, g.a aVar) {
            BottomSheetBehavior.this.setState(this.f22817a);
            return true;
        }
    }

    public BottomSheetBehavior() {
        this.saveFlags = 0;
        this.fitToContents = true;
        this.updateImportantForAccessibilityOnSiblings = false;
        this.maxWidth = -1;
        this.maxHeight = -1;
        this.stateSettlingTracker = new h(this, null);
        this.halfExpandedRatio = 0.5f;
        this.elevation = -1.0f;
        this.draggable = true;
        this.state = 4;
        this.lastStableState = 4;
        this.hideFriction = 0.1f;
        this.callbacks = new ArrayList<>();
        this.initialY = -1;
        this.expandHalfwayActionIds = new SparseIntArray();
        this.dragCallback = new e();
    }

    private int addAccessibilityActionForState(View view, int i10, int i11) {
        return K.b(view, view.getResources().getString(i10), createAccessibilityViewCommandForState(i11));
    }

    private void calculateCollapsedOffset() {
        int calculatePeekHeight = calculatePeekHeight();
        if (this.fitToContents) {
            this.collapsedOffset = Math.max(this.parentHeight - calculatePeekHeight, this.fitToContentsOffset);
        } else {
            this.collapsedOffset = this.parentHeight - calculatePeekHeight;
        }
    }

    private float calculateCornerInterpolation(float f10, RoundedCorner roundedCorner) {
        if (roundedCorner != null) {
            float radius = roundedCorner.getRadius();
            if (radius > 0.0f && f10 > 0.0f) {
                return radius / f10;
            }
        }
        return 0.0f;
    }

    private void calculateHalfExpandedOffset() {
        this.halfExpandedOffset = (int) (this.parentHeight * (1.0f - this.halfExpandedRatio));
    }

    private float calculateInterpolationWithCornersRemoved() {
        WeakReference<V> weakReference;
        WindowInsets rootWindowInsets;
        if (this.materialShapeDrawable != null && (weakReference = this.viewRef) != null && weakReference.get() != null) {
            V v10 = this.viewRef.get();
            if (isAtTopOfScreen() && (rootWindowInsets = v10.getRootWindowInsets()) != null) {
                return Math.max(calculateCornerInterpolation(this.materialShapeDrawable.getTopLeftCornerResolvedSize(), rootWindowInsets.getRoundedCorner(0)), calculateCornerInterpolation(this.materialShapeDrawable.getTopRightCornerResolvedSize(), rootWindowInsets.getRoundedCorner(1)));
            }
            return 0.0f;
        }
        return 0.0f;
    }

    private int calculatePeekHeight() {
        int i10;
        int i11;
        int i12;
        if (this.peekHeightAuto) {
            i10 = Math.min(Math.max(this.peekHeightMin, this.parentHeight - ((this.parentWidth * 9) / 16)), this.childHeight);
            i11 = this.insetBottom;
        } else {
            if (!this.gestureInsetBottomIgnored && !this.paddingBottomSystemWindowInsets && (i12 = this.gestureInsetBottom) > 0) {
                return Math.max(this.peekHeight, i12 + this.peekHeightGestureInsetBuffer);
            }
            i10 = this.peekHeight;
            i11 = this.insetBottom;
        }
        return i10 + i11;
    }

    private float calculateSlideOffsetWithTop(int i10) {
        float f10;
        float f11;
        int i11 = this.collapsedOffset;
        if (i10 <= i11 && i11 != getExpandedOffset()) {
            int i12 = this.collapsedOffset;
            f10 = i12 - i10;
            f11 = i12 - getExpandedOffset();
        } else {
            int i13 = this.collapsedOffset;
            f10 = i13 - i10;
            f11 = this.parentHeight - i13;
        }
        return f10 / f11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canBeHiddenByDragging() {
        if (isHideable() && isHideableWhenDragging()) {
            return true;
        }
        return false;
    }

    private void clearAccessibilityAction(View view, int i10) {
        if (view == null) {
            return;
        }
        K.c0(view, 524288);
        K.c0(view, 262144);
        K.c0(view, OplusPhoneUtils.PROPERTY_HIGH_DEF_AUDIO_EVS);
        int i11 = this.expandHalfwayActionIds.get(i10, -1);
        if (i11 != -1) {
            K.c0(view, i11);
            this.expandHalfwayActionIds.delete(i10);
        }
    }

    private J.g createAccessibilityViewCommandForState(int i10) {
        return new f(i10);
    }

    private void createMaterialShapeDrawableIfNeeded(Context context) {
        if (this.shapeAppearanceModelDefault == null) {
            return;
        }
        i iVar = new i(this.shapeAppearanceModelDefault);
        this.materialShapeDrawable = iVar;
        iVar.initializeElevationOverlay(context);
        ColorStateList colorStateList = this.backgroundTint;
        if (colorStateList != null) {
            this.materialShapeDrawable.setFillColor(colorStateList);
            return;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.colorBackground, typedValue, true);
        this.materialShapeDrawable.setTint(typedValue.data);
    }

    private void createShapeValueAnimator() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(calculateInterpolationWithCornersRemoved(), 1.0f);
        this.interpolatorAnimator = ofFloat;
        ofFloat.setDuration(500L);
        this.interpolatorAnimator.addUpdateListener(new c());
    }

    public static <V extends View> BottomSheetBehavior<V> from(V v10) {
        ViewGroup.LayoutParams layoutParams = v10.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.e) {
            CoordinatorLayout.Behavior f10 = ((CoordinatorLayout.e) layoutParams).f();
            if (f10 instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) f10;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    private int getChildMeasureSpec(int i10, int i11, int i12, int i13) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i10, i11, i13);
        if (i12 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode != 1073741824) {
            if (size != 0) {
                i12 = Math.min(size, i12);
            }
            return View.MeasureSpec.makeMeasureSpec(i12, Integer.MIN_VALUE);
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(size, i12), 1073741824);
    }

    private int getTopOffsetForState(int i10) {
        if (i10 != 3) {
            if (i10 != 4) {
                if (i10 != 5) {
                    if (i10 == 6) {
                        return this.halfExpandedOffset;
                    }
                    throw new IllegalArgumentException("Invalid state to get top offset: " + i10);
                }
                return this.parentHeight;
            }
            return this.collapsedOffset;
        }
        return getExpandedOffset();
    }

    private float getYVelocity() {
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.maximumVelocity);
        return this.velocityTracker.getYVelocity(this.activePointerId);
    }

    private boolean isAtTopOfScreen() {
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        int[] iArr = new int[2];
        this.viewRef.get().getLocationOnScreen(iArr);
        if (iArr[1] != 0) {
            return false;
        }
        return true;
    }

    private boolean isExpandedAndShouldRemoveCorners() {
        if (this.state == 3 && (this.shouldRemoveExpandedCorners || isAtTopOfScreen())) {
            return true;
        }
        return false;
    }

    private boolean isLayouting(V v10) {
        ViewParent parent = v10.getParent();
        if (parent != null && parent.isLayoutRequested() && K.N(v10)) {
            return true;
        }
        return false;
    }

    private void replaceAccessibilityActionForState(View view, d.a aVar, int i10) {
        K.e0(view, aVar, null, createAccessibilityViewCommandForState(i10));
    }

    private void reset() {
        this.activePointerId = -1;
        this.initialY = -1;
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.velocityTracker = null;
        }
    }

    private void restoreOptionalState(SavedState savedState) {
        int i10 = this.saveFlags;
        if (i10 == 0) {
            return;
        }
        if (i10 == -1 || (i10 & 1) == 1) {
            this.peekHeight = savedState.f22804b;
        }
        if (i10 == -1 || (i10 & 2) == 2) {
            this.fitToContents = savedState.f22805c;
        }
        if (i10 == -1 || (i10 & 4) == 4) {
            this.hideable = savedState.f22806d;
        }
        if (i10 == -1 || (i10 & 8) == 8) {
            this.skipCollapsed = savedState.f22807e;
        }
    }

    private void runAfterLayout(V v10, Runnable runnable) {
        if (isLayouting(v10)) {
            v10.post(runnable);
        } else {
            runnable.run();
        }
    }

    private void setWindowInsetsListener(View view) {
        boolean z10;
        if (!isGestureInsetBottomIgnored() && !this.peekHeightAuto) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!this.paddingBottomSystemWindowInsets && !this.paddingLeftSystemWindowInsets && !this.paddingRightSystemWindowInsets && !this.marginLeftSystemWindowInsets && !this.marginRightSystemWindowInsets && !this.marginTopSystemWindowInsets && !z10) {
            return;
        }
        ViewUtils.doOnApplyWindowInsets(view, new d(z10));
    }

    private boolean shouldHandleDraggingWithHelper() {
        if (this.viewDragHelper != null && (this.draggable || this.state == 1)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startSettling(View view, int i10, boolean z10) {
        int topOffsetForState = getTopOffsetForState(i10);
        androidx.customview.widget.c cVar = this.viewDragHelper;
        if (cVar != null && (!z10 ? cVar.R(view, view.getLeft(), topOffsetForState) : cVar.P(view.getLeft(), topOffsetForState))) {
            setStateInternal(2);
            updateDrawableForTargetState(i10, true);
            this.stateSettlingTracker.c(i10);
            return;
        }
        setStateInternal(i10);
    }

    private void updateAccessibilityActions() {
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference != null) {
            updateAccessibilityActions(weakReference.get(), 0);
        }
        WeakReference<View> weakReference2 = this.accessibilityDelegateViewRef;
        if (weakReference2 != null) {
            updateAccessibilityActions(weakReference2.get(), 1);
        }
    }

    private void updateDrawableForTargetState(int i10, boolean z10) {
        boolean isExpandedAndShouldRemoveCorners;
        ValueAnimator valueAnimator;
        if (i10 != 2 && this.expandedCornersRemoved != (isExpandedAndShouldRemoveCorners = isExpandedAndShouldRemoveCorners()) && this.materialShapeDrawable != null) {
            this.expandedCornersRemoved = isExpandedAndShouldRemoveCorners;
            float f10 = 1.0f;
            if (z10 && (valueAnimator = this.interpolatorAnimator) != null) {
                if (valueAnimator.isRunning()) {
                    this.interpolatorAnimator.reverse();
                    return;
                }
                float interpolation = this.materialShapeDrawable.getInterpolation();
                if (isExpandedAndShouldRemoveCorners) {
                    f10 = calculateInterpolationWithCornersRemoved();
                }
                this.interpolatorAnimator.setFloatValues(interpolation, f10);
                this.interpolatorAnimator.start();
                return;
            }
            ValueAnimator valueAnimator2 = this.interpolatorAnimator;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.interpolatorAnimator.cancel();
            }
            i iVar = this.materialShapeDrawable;
            if (this.expandedCornersRemoved) {
                f10 = calculateInterpolationWithCornersRemoved();
            }
            iVar.setInterpolation(f10);
        }
    }

    private void updateImportantForAccessibility(boolean z10) {
        Map<View, Integer> map;
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = weakReference.get().getParent();
        if (!(parent instanceof CoordinatorLayout)) {
            return;
        }
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
        int childCount = coordinatorLayout.getChildCount();
        if (z10) {
            if (this.importantForAccessibilityMap == null) {
                this.importantForAccessibilityMap = new HashMap(childCount);
            } else {
                return;
            }
        }
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = coordinatorLayout.getChildAt(i10);
            if (childAt != this.viewRef.get()) {
                if (z10) {
                    this.importantForAccessibilityMap.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                    if (this.updateImportantForAccessibilityOnSiblings) {
                        K.t0(childAt, 4);
                    }
                } else if (this.updateImportantForAccessibilityOnSiblings && (map = this.importantForAccessibilityMap) != null && map.containsKey(childAt)) {
                    K.t0(childAt, this.importantForAccessibilityMap.get(childAt).intValue());
                }
            }
        }
        if (!z10) {
            this.importantForAccessibilityMap = null;
        } else if (this.updateImportantForAccessibilityOnSiblings) {
            this.viewRef.get().sendAccessibilityEvent(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePeekHeight(boolean z10) {
        V v10;
        if (this.viewRef != null) {
            calculateCollapsedOffset();
            if (this.state == 4 && (v10 = this.viewRef.get()) != null) {
                if (z10) {
                    setState(4);
                } else {
                    v10.requestLayout();
                }
            }
        }
    }

    public void addBottomSheetCallback(g gVar) {
        if (!this.callbacks.contains(gVar)) {
            this.callbacks.add(gVar);
        }
    }

    public float calculateSlideOffset() {
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference != null && weakReference.get() != null) {
            return calculateSlideOffsetWithTop(this.viewRef.get().getTop());
        }
        return -1.0f;
    }

    @Override // s4.InterfaceC1543b
    public void cancelBackProgress() {
        C1546e c1546e = this.bottomContainerBackHelper;
        if (c1546e == null) {
            return;
        }
        c1546e.f();
    }

    public void disableShapeAnimations() {
        this.interpolatorAnimator = null;
    }

    void dispatchOnSlide(int i10) {
        V v10 = this.viewRef.get();
        if (v10 != null && !this.callbacks.isEmpty()) {
            float calculateSlideOffsetWithTop = calculateSlideOffsetWithTop(i10);
            for (int i11 = 0; i11 < this.callbacks.size(); i11++) {
                this.callbacks.get(i11).onSlide(v10, calculateSlideOffsetWithTop);
            }
        }
    }

    View findScrollingChild(View view) {
        if (view.getVisibility() != 0) {
            return null;
        }
        if (K.P(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View findScrollingChild = findScrollingChild(viewGroup.getChildAt(i10));
                if (findScrollingChild != null) {
                    return findScrollingChild;
                }
            }
        }
        return null;
    }

    public C1546e getBackHelper() {
        return this.bottomContainerBackHelper;
    }

    public int getExpandedOffset() {
        int i10;
        if (this.fitToContents) {
            return this.fitToContentsOffset;
        }
        int i11 = this.expandedOffset;
        if (this.paddingTopSystemWindowInsets) {
            i10 = 0;
        } else {
            i10 = this.insetTop;
        }
        return Math.max(i11, i10);
    }

    public float getHalfExpandedRatio() {
        return this.halfExpandedRatio;
    }

    public float getHideFriction() {
        return this.hideFriction;
    }

    public int getLastStableState() {
        return this.lastStableState;
    }

    public i getMaterialShapeDrawable() {
        return this.materialShapeDrawable;
    }

    public int getMaxHeight() {
        return this.maxHeight;
    }

    public int getMaxWidth() {
        return this.maxWidth;
    }

    public int getPeekHeight() {
        if (this.peekHeightAuto) {
            return -1;
        }
        return this.peekHeight;
    }

    int getPeekHeightMin() {
        return this.peekHeightMin;
    }

    public int getSaveFlags() {
        return this.saveFlags;
    }

    public int getSignificantVelocityThreshold() {
        return this.significantVelocityThreshold;
    }

    public boolean getSkipCollapsed() {
        return this.skipCollapsed;
    }

    public int getState() {
        return this.state;
    }

    @Override // s4.InterfaceC1543b
    public void handleBackInvoked() {
        C1546e c1546e = this.bottomContainerBackHelper;
        if (c1546e == null) {
            return;
        }
        androidx.activity.b c10 = c1546e.c();
        int i10 = 4;
        if (c10 != null) {
            if (this.hideable) {
                this.bottomContainerBackHelper.h(c10, new b());
                return;
            } else {
                this.bottomContainerBackHelper.i(c10, null);
                setState(4);
                return;
            }
        }
        if (this.hideable) {
            i10 = 5;
        }
        setState(i10);
    }

    public boolean isDraggable() {
        return this.draggable;
    }

    public boolean isFitToContents() {
        return this.fitToContents;
    }

    public boolean isGestureInsetBottomIgnored() {
        return this.gestureInsetBottomIgnored;
    }

    public boolean isHideable() {
        return this.hideable;
    }

    public boolean isHideableWhenDragging() {
        return true;
    }

    public boolean isNestedScrollingCheckEnabled() {
        return true;
    }

    public boolean isShouldRemoveExpandedCorners() {
        return this.shouldRemoveExpandedCorners;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(CoordinatorLayout.e eVar) {
        super.onAttachedToLayoutParams(eVar);
        this.viewRef = null;
        this.viewDragHelper = null;
        this.bottomContainerBackHelper = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.viewRef = null;
        this.viewDragHelper = null;
        this.bottomContainerBackHelper = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
        boolean z10;
        View view;
        int i10;
        androidx.customview.widget.c cVar;
        if (v10.isShown() && this.draggable) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                reset();
            }
            if (this.velocityTracker == null) {
                this.velocityTracker = VelocityTracker.obtain();
            }
            this.velocityTracker.addMovement(motionEvent);
            View view2 = null;
            if (actionMasked != 0) {
                if (actionMasked == 1 || actionMasked == 3) {
                    this.touchingScrollingChild = false;
                    this.activePointerId = -1;
                    if (this.ignoreEvents) {
                        this.ignoreEvents = false;
                        return false;
                    }
                }
            } else {
                int x10 = (int) motionEvent.getX();
                this.initialY = (int) motionEvent.getY();
                if (this.state != 2) {
                    WeakReference<View> weakReference = this.nestedScrollingChildRef;
                    if (weakReference != null) {
                        view = weakReference.get();
                    } else {
                        view = null;
                    }
                    if (view != null && coordinatorLayout.z(view, x10, this.initialY)) {
                        this.activePointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                        this.touchingScrollingChild = true;
                    }
                }
                if (this.activePointerId == -1 && !coordinatorLayout.z(v10, x10, this.initialY)) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                this.ignoreEvents = z10;
            }
            if (!this.ignoreEvents && (cVar = this.viewDragHelper) != null && cVar.Q(motionEvent)) {
                return true;
            }
            WeakReference<View> weakReference2 = this.nestedScrollingChildRef;
            if (weakReference2 != null) {
                view2 = weakReference2.get();
            }
            if (actionMasked != 2 || view2 == null || this.ignoreEvents || this.state == 1 || coordinatorLayout.z(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.viewDragHelper == null || (i10 = this.initialY) == -1 || Math.abs(i10 - motionEvent.getY()) <= this.viewDragHelper.A()) {
                return false;
            }
            return true;
        }
        this.ignoreEvents = true;
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v10, int i10) {
        if (K.s(coordinatorLayout) && !K.s(v10)) {
            v10.setFitsSystemWindows(true);
        }
        if (this.viewRef == null) {
            this.peekHeightMin = coordinatorLayout.getResources().getDimensionPixelSize(C0979e.f30786h);
            setWindowInsetsListener(v10);
            K.G0(v10, new com.google.android.material.bottomsheet.d(v10));
            this.viewRef = new WeakReference<>(v10);
            this.bottomContainerBackHelper = new C1546e(v10);
            i iVar = this.materialShapeDrawable;
            if (iVar != null) {
                K.n0(v10, iVar);
                i iVar2 = this.materialShapeDrawable;
                float f10 = this.elevation;
                if (f10 == -1.0f) {
                    f10 = K.r(v10);
                }
                iVar2.setElevation(f10);
            } else {
                ColorStateList colorStateList = this.backgroundTint;
                if (colorStateList != null) {
                    K.o0(v10, colorStateList);
                }
            }
            updateAccessibilityActions();
            if (K.t(v10) == 0) {
                K.t0(v10, 1);
            }
        }
        if (this.viewDragHelper == null) {
            this.viewDragHelper = androidx.customview.widget.c.p(coordinatorLayout, this.dragCallback);
        }
        int top = v10.getTop();
        coordinatorLayout.G(v10, i10);
        this.parentWidth = coordinatorLayout.getWidth();
        this.parentHeight = coordinatorLayout.getHeight();
        int height = v10.getHeight();
        this.childHeight = height;
        int i11 = this.parentHeight;
        int i12 = i11 - height;
        int i13 = this.insetTop;
        if (i12 < i13) {
            if (this.paddingTopSystemWindowInsets) {
                int i14 = this.maxHeight;
                if (i14 != -1) {
                    i11 = Math.min(i11, i14);
                }
                this.childHeight = i11;
            } else {
                int i15 = i11 - i13;
                int i16 = this.maxHeight;
                if (i16 != -1) {
                    i15 = Math.min(i15, i16);
                }
                this.childHeight = i15;
            }
        }
        this.fitToContentsOffset = Math.max(0, this.parentHeight - this.childHeight);
        calculateHalfExpandedOffset();
        calculateCollapsedOffset();
        int i17 = this.state;
        if (i17 == 3) {
            K.U(v10, getExpandedOffset());
        } else if (i17 == 6) {
            K.U(v10, this.halfExpandedOffset);
        } else if (this.hideable && i17 == 5) {
            K.U(v10, this.parentHeight);
        } else if (i17 == 4) {
            K.U(v10, this.collapsedOffset);
        } else if (i17 == 1 || i17 == 2) {
            K.U(v10, top - v10.getTop());
        }
        updateDrawableForTargetState(this.state, false);
        this.nestedScrollingChildRef = new WeakReference<>(findScrollingChild(v10));
        for (int i18 = 0; i18 < this.callbacks.size(); i18++) {
            this.callbacks.get(i18).onLayout(v10);
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, V v10, int i10, int i11, int i12, int i13) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) v10.getLayoutParams();
        v10.measure(getChildMeasureSpec(i10, coordinatorLayout.getPaddingLeft() + coordinatorLayout.getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i11, this.maxWidth, marginLayoutParams.width), getChildMeasureSpec(i12, coordinatorLayout.getPaddingTop() + coordinatorLayout.getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i13, this.maxHeight, marginLayoutParams.height));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v10, View view, float f10, float f11) {
        WeakReference<View> weakReference;
        if (!isNestedScrollingCheckEnabled() || (weakReference = this.nestedScrollingChildRef) == null || view != weakReference.get()) {
            return false;
        }
        if (this.state == 3 && !super.onNestedPreFling(coordinatorLayout, v10, view, f10, f11)) {
            return false;
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v10, View view, int i10, int i11, int[] iArr, int i12) {
        View view2;
        if (i12 == 1) {
            return;
        }
        WeakReference<View> weakReference = this.nestedScrollingChildRef;
        if (weakReference != null) {
            view2 = weakReference.get();
        } else {
            view2 = null;
        }
        if (isNestedScrollingCheckEnabled() && view != view2) {
            return;
        }
        int top = v10.getTop();
        int i13 = top - i11;
        if (i11 > 0) {
            if (i13 < getExpandedOffset()) {
                int expandedOffset = top - getExpandedOffset();
                iArr[1] = expandedOffset;
                K.U(v10, -expandedOffset);
                setStateInternal(3);
            } else {
                if (!this.draggable) {
                    return;
                }
                iArr[1] = i11;
                K.U(v10, -i11);
                setStateInternal(1);
            }
        } else if (i11 < 0 && !view.canScrollVertically(-1)) {
            if (i13 > this.collapsedOffset && !canBeHiddenByDragging()) {
                int i14 = top - this.collapsedOffset;
                iArr[1] = i14;
                K.U(v10, -i14);
                setStateInternal(4);
            } else {
                if (!this.draggable) {
                    return;
                }
                iArr[1] = i11;
                K.U(v10, -i11);
                setStateInternal(1);
            }
        }
        dispatchOnSlide(v10.getTop());
        this.lastNestedScrollDy = i11;
        this.nestedScrolled = true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v10, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, v10, savedState.getSuperState());
        restoreOptionalState(savedState);
        int i10 = savedState.f22803a;
        if (i10 != 1 && i10 != 2) {
            this.state = i10;
            this.lastStableState = i10;
        } else {
            this.state = 4;
            this.lastStableState = 4;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v10) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, v10), (BottomSheetBehavior<?>) this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v10, View view, View view2, int i10, int i11) {
        this.lastNestedScrollDy = 0;
        this.nestedScrolled = false;
        if ((i10 & 2) == 0) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0035, code lost:
    
        if (r4.getTop() <= r2.halfExpandedOffset) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a9, code lost:
    
        r0 = 6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0065, code lost:
    
        if (java.lang.Math.abs(r3 - r2.fitToContentsOffset) < java.lang.Math.abs(r3 - r2.collapsedOffset)) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x007b, code lost:
    
        if (shouldSkipHalfExpandedStateWhenDragging() != false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x008b, code lost:
    
        if (java.lang.Math.abs(r3 - r1) < java.lang.Math.abs(r3 - r2.collapsedOffset)) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00a7, code lost:
    
        if (java.lang.Math.abs(r3 - r2.halfExpandedOffset) < java.lang.Math.abs(r3 - r2.collapsedOffset)) goto L51;
     */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onStopNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout r3, V r4, android.view.View r5, int r6) {
        /*
            r2 = this;
            int r3 = r4.getTop()
            int r6 = r2.getExpandedOffset()
            r0 = 3
            if (r3 != r6) goto Lf
            r2.setStateInternal(r0)
            return
        Lf:
            boolean r3 = r2.isNestedScrollingCheckEnabled()
            if (r3 == 0) goto L24
            java.lang.ref.WeakReference<android.view.View> r3 = r2.nestedScrollingChildRef
            if (r3 == 0) goto L23
            java.lang.Object r3 = r3.get()
            if (r5 != r3) goto L23
            boolean r3 = r2.nestedScrolled
            if (r3 != 0) goto L24
        L23:
            return
        L24:
            int r3 = r2.lastNestedScrollDy
            r5 = 6
            if (r3 <= 0) goto L39
            boolean r3 = r2.fitToContents
            if (r3 == 0) goto L2f
            goto Laa
        L2f:
            int r3 = r4.getTop()
            int r6 = r2.halfExpandedOffset
            if (r3 <= r6) goto Laa
            goto La9
        L39:
            boolean r3 = r2.hideable
            if (r3 == 0) goto L49
            float r3 = r2.getYVelocity()
            boolean r3 = r2.shouldHide(r4, r3)
            if (r3 == 0) goto L49
            r0 = 5
            goto Laa
        L49:
            int r3 = r2.lastNestedScrollDy
            r6 = 4
            if (r3 != 0) goto L8e
            int r3 = r4.getTop()
            boolean r1 = r2.fitToContents
            if (r1 == 0) goto L68
            int r5 = r2.fitToContentsOffset
            int r5 = r3 - r5
            int r5 = java.lang.Math.abs(r5)
            int r1 = r2.collapsedOffset
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r5 >= r3) goto L92
            goto Laa
        L68:
            int r1 = r2.halfExpandedOffset
            if (r3 >= r1) goto L7e
            int r1 = r2.collapsedOffset
            int r1 = r3 - r1
            int r1 = java.lang.Math.abs(r1)
            if (r3 >= r1) goto L77
            goto Laa
        L77:
            boolean r3 = r2.shouldSkipHalfExpandedStateWhenDragging()
            if (r3 == 0) goto La9
            goto L92
        L7e:
            int r0 = r3 - r1
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.collapsedOffset
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L92
            goto La9
        L8e:
            boolean r3 = r2.fitToContents
            if (r3 == 0) goto L94
        L92:
            r0 = r6
            goto Laa
        L94:
            int r3 = r4.getTop()
            int r0 = r2.halfExpandedOffset
            int r0 = r3 - r0
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.collapsedOffset
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L92
        La9:
            r0 = r5
        Laa:
            r3 = 0
            r2.startSettling(r4, r0, r3)
            r2.nestedScrolled = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.onStopNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, int):void");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
        if (!v10.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.state == 1 && actionMasked == 0) {
            return true;
        }
        if (shouldHandleDraggingWithHelper()) {
            this.viewDragHelper.G(motionEvent);
        }
        if (actionMasked == 0) {
            reset();
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        if (shouldHandleDraggingWithHelper() && actionMasked == 2 && !this.ignoreEvents && Math.abs(this.initialY - motionEvent.getY()) > this.viewDragHelper.A()) {
            this.viewDragHelper.c(v10, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.ignoreEvents;
    }

    public void removeBottomSheetCallback(g gVar) {
        this.callbacks.remove(gVar);
    }

    public void setAccessibilityDelegateView(View view) {
        WeakReference<View> weakReference;
        if (view == null && (weakReference = this.accessibilityDelegateViewRef) != null) {
            clearAccessibilityAction(weakReference.get(), 1);
            this.accessibilityDelegateViewRef = null;
        } else {
            this.accessibilityDelegateViewRef = new WeakReference<>(view);
            updateAccessibilityActions(view, 1);
        }
    }

    @Deprecated
    public void setBottomSheetCallback(g gVar) {
        Log.w(TAG, "BottomSheetBehavior now supports multiple callbacks. `setBottomSheetCallback()` removes all existing callbacks, including ones set internally by library authors, which may result in unintended behavior. This may change in the future. Please use `addBottomSheetCallback()` and `removeBottomSheetCallback()` instead to set your own callbacks.");
        this.callbacks.clear();
        if (gVar != null) {
            this.callbacks.add(gVar);
        }
    }

    public void setDraggable(boolean z10) {
        this.draggable = z10;
    }

    public void setExpandedOffset(int i10) {
        if (i10 >= 0) {
            this.expandedOffset = i10;
            updateDrawableForTargetState(this.state, true);
            return;
        }
        throw new IllegalArgumentException("offset must be greater than or equal to 0");
    }

    public void setFitToContents(boolean z10) {
        int i10;
        if (this.fitToContents == z10) {
            return;
        }
        this.fitToContents = z10;
        if (this.viewRef != null) {
            calculateCollapsedOffset();
        }
        if (this.fitToContents && this.state == 6) {
            i10 = 3;
        } else {
            i10 = this.state;
        }
        setStateInternal(i10);
        updateDrawableForTargetState(this.state, true);
        updateAccessibilityActions();
    }

    public void setGestureInsetBottomIgnored(boolean z10) {
        this.gestureInsetBottomIgnored = z10;
    }

    public void setHalfExpandedRatio(float f10) {
        if (f10 > 0.0f && f10 < 1.0f) {
            this.halfExpandedRatio = f10;
            if (this.viewRef != null) {
                calculateHalfExpandedOffset();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
    }

    public void setHideFriction(float f10) {
        this.hideFriction = f10;
    }

    public void setHideable(boolean z10) {
        if (this.hideable != z10) {
            this.hideable = z10;
            if (!z10 && this.state == 5) {
                setState(4);
            }
            updateAccessibilityActions();
        }
    }

    public void setHideableInternal(boolean z10) {
        this.hideable = z10;
    }

    public void setMaxHeight(int i10) {
        this.maxHeight = i10;
    }

    public void setMaxWidth(int i10) {
        this.maxWidth = i10;
    }

    public void setPeekHeight(int i10) {
        setPeekHeight(i10, false);
    }

    public void setSaveFlags(int i10) {
        this.saveFlags = i10;
    }

    public void setShouldRemoveExpandedCorners(boolean z10) {
        if (this.shouldRemoveExpandedCorners != z10) {
            this.shouldRemoveExpandedCorners = z10;
            updateDrawableForTargetState(getState(), true);
        }
    }

    public void setSignificantVelocityThreshold(int i10) {
        this.significantVelocityThreshold = i10;
    }

    public void setSkipCollapsed(boolean z10) {
        this.skipCollapsed = z10;
    }

    public void setState(int i10) {
        String str;
        int i11;
        if (i10 != 1 && i10 != 2) {
            if (!this.hideable && i10 == 5) {
                Log.w(TAG, "Cannot set state: " + i10);
                return;
            }
            if (i10 == 6 && this.fitToContents && getTopOffsetForState(i10) <= this.fitToContentsOffset) {
                i11 = 3;
            } else {
                i11 = i10;
            }
            WeakReference<V> weakReference = this.viewRef;
            if (weakReference != null && weakReference.get() != null) {
                V v10 = this.viewRef.get();
                runAfterLayout(v10, new a(v10, i11));
                return;
            } else {
                setStateInternal(i10);
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("STATE_");
        if (i10 == 1) {
            str = "DRAGGING";
        } else {
            str = "SETTLING";
        }
        sb.append(str);
        sb.append(" should not be set externally.");
        throw new IllegalArgumentException(sb.toString());
    }

    void setStateInternal(int i10) {
        V v10;
        if (this.state == i10) {
            return;
        }
        this.state = i10;
        if (i10 == 4 || i10 == 3 || i10 == 6 || (this.hideable && i10 == 5)) {
            this.lastStableState = i10;
        }
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference == null || (v10 = weakReference.get()) == null) {
            return;
        }
        if (i10 == 3) {
            updateImportantForAccessibility(true);
        } else if (i10 == 6 || i10 == 5 || i10 == 4) {
            updateImportantForAccessibility(false);
        }
        updateDrawableForTargetState(i10, true);
        for (int i11 = 0; i11 < this.callbacks.size(); i11++) {
            this.callbacks.get(i11).onStateChanged(v10, i10);
        }
        updateAccessibilityActions();
    }

    public void setUpdateImportantForAccessibilityOnSiblings(boolean z10) {
        this.updateImportantForAccessibilityOnSiblings = z10;
    }

    public boolean shouldExpandOnUpwardDrag(long j10, float f10) {
        return false;
    }

    boolean shouldHide(View view, float f10) {
        if (this.skipCollapsed) {
            return true;
        }
        if (!isHideableWhenDragging() || view.getTop() < this.collapsedOffset) {
            return false;
        }
        if (Math.abs((view.getTop() + (f10 * this.hideFriction)) - this.collapsedOffset) / calculatePeekHeight() > 0.5f) {
            return true;
        }
        return false;
    }

    public boolean shouldSkipHalfExpandedStateWhenDragging() {
        return false;
    }

    public boolean shouldSkipSmoothAnimation() {
        return true;
    }

    @Override // s4.InterfaceC1543b
    public void startBackProgress(androidx.activity.b bVar) {
        C1546e c1546e = this.bottomContainerBackHelper;
        if (c1546e == null) {
            return;
        }
        c1546e.j(bVar);
    }

    @Override // s4.InterfaceC1543b
    public void updateBackProgress(androidx.activity.b bVar) {
        C1546e c1546e = this.bottomContainerBackHelper;
        if (c1546e == null) {
            return;
        }
        c1546e.l(bVar);
    }

    /* loaded from: classes3.dex */
    public class h {

        /* renamed from: a, reason: collision with root package name */
        public int f22819a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f22820b;

        /* renamed from: c, reason: collision with root package name */
        public final Runnable f22821c;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                h.this.f22820b = false;
                androidx.customview.widget.c cVar = BottomSheetBehavior.this.viewDragHelper;
                if (cVar != null && cVar.n(true)) {
                    h hVar = h.this;
                    hVar.c(hVar.f22819a);
                    return;
                }
                h hVar2 = h.this;
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.state == 2) {
                    bottomSheetBehavior.setStateInternal(hVar2.f22819a);
                }
            }
        }

        public h() {
            this.f22821c = new a();
        }

        public void c(int i10) {
            WeakReference<V> weakReference = BottomSheetBehavior.this.viewRef;
            if (weakReference != null && weakReference.get() != null) {
                this.f22819a = i10;
                if (!this.f22820b) {
                    K.a0(BottomSheetBehavior.this.viewRef.get(), this.f22821c);
                    this.f22820b = true;
                }
            }
        }

        public /* synthetic */ h(BottomSheetBehavior bottomSheetBehavior, a aVar) {
            this();
        }
    }

    public final void setPeekHeight(int i10, boolean z10) {
        if (i10 == -1) {
            if (this.peekHeightAuto) {
                return;
            } else {
                this.peekHeightAuto = true;
            }
        } else {
            if (!this.peekHeightAuto && this.peekHeight == i10) {
                return;
            }
            this.peekHeightAuto = false;
            this.peekHeight = Math.max(0, i10);
        }
        updatePeekHeight(z10);
    }

    /* loaded from: classes3.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public final int f22803a;

        /* renamed from: b, reason: collision with root package name */
        public int f22804b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f22805c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f22806d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f22807e;

        /* loaded from: classes3.dex */
        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f22803a = parcel.readInt();
            this.f22804b = parcel.readInt();
            this.f22805c = parcel.readInt() == 1;
            this.f22806d = parcel.readInt() == 1;
            this.f22807e = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f22803a);
            parcel.writeInt(this.f22804b);
            parcel.writeInt(this.f22805c ? 1 : 0);
            parcel.writeInt(this.f22806d ? 1 : 0);
            parcel.writeInt(this.f22807e ? 1 : 0);
        }

        public SavedState(Parcelable parcelable, BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.f22803a = bottomSheetBehavior.state;
            this.f22804b = ((BottomSheetBehavior) bottomSheetBehavior).peekHeight;
            this.f22805c = ((BottomSheetBehavior) bottomSheetBehavior).fitToContents;
            this.f22806d = bottomSheetBehavior.hideable;
            this.f22807e = ((BottomSheetBehavior) bottomSheetBehavior).skipCollapsed;
        }
    }

    private void updateAccessibilityActions(View view, int i10) {
        if (view == null) {
            return;
        }
        clearAccessibilityAction(view, i10);
        if (!this.fitToContents && this.state != 6) {
            this.expandHalfwayActionIds.put(i10, addAccessibilityActionForState(view, k.f30975c, 6));
        }
        if (this.hideable && isHideableWhenDragging() && this.state != 5) {
            replaceAccessibilityActionForState(view, d.a.f1410y, 5);
        }
        int i11 = this.state;
        if (i11 == 3) {
            replaceAccessibilityActionForState(view, d.a.f1409x, this.fitToContents ? 4 : 6);
            return;
        }
        if (i11 == 4) {
            replaceAccessibilityActionForState(view, d.a.f1408w, this.fitToContents ? 3 : 6);
        } else {
            if (i11 != 6) {
                return;
            }
            replaceAccessibilityActionForState(view, d.a.f1409x, 4);
            replaceAccessibilityActionForState(view, d.a.f1408w, 3);
        }
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i10;
        this.saveFlags = 0;
        this.fitToContents = true;
        this.updateImportantForAccessibilityOnSiblings = false;
        this.maxWidth = -1;
        this.maxHeight = -1;
        this.stateSettlingTracker = new h(this, null);
        this.halfExpandedRatio = 0.5f;
        this.elevation = -1.0f;
        this.draggable = true;
        this.state = 4;
        this.lastStableState = 4;
        this.hideFriction = 0.1f;
        this.callbacks = new ArrayList<>();
        this.initialY = -1;
        this.expandHalfwayActionIds = new SparseIntArray();
        this.dragCallback = new e();
        this.peekHeightGestureInsetBuffer = context.getResources().getDimensionPixelSize(C0979e.f30724A0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.f31188N0);
        int i11 = m.f31232R0;
        if (obtainStyledAttributes.hasValue(i11)) {
            this.backgroundTint = C1607c.a(context, obtainStyledAttributes, i11);
        }
        if (obtainStyledAttributes.hasValue(m.f31429j1)) {
            this.shapeAppearanceModelDefault = n.e(context, attributeSet, C0977c.f30669h, DEF_STYLE_RES).m();
        }
        createMaterialShapeDrawableIfNeeded(context);
        createShapeValueAnimator();
        this.elevation = obtainStyledAttributes.getDimension(m.f31221Q0, -1.0f);
        int i12 = m.f31199O0;
        if (obtainStyledAttributes.hasValue(i12)) {
            setMaxWidth(obtainStyledAttributes.getDimensionPixelSize(i12, -1));
        }
        int i13 = m.f31210P0;
        if (obtainStyledAttributes.hasValue(i13)) {
            setMaxHeight(obtainStyledAttributes.getDimensionPixelSize(i13, -1));
        }
        int i14 = m.f31298X0;
        TypedValue peekValue = obtainStyledAttributes.peekValue(i14);
        if (peekValue != null && (i10 = peekValue.data) == -1) {
            setPeekHeight(i10);
        } else {
            setPeekHeight(obtainStyledAttributes.getDimensionPixelSize(i14, -1));
        }
        setHideable(obtainStyledAttributes.getBoolean(m.f31287W0, false));
        setGestureInsetBottomIgnored(obtainStyledAttributes.getBoolean(m.f31341b1, false));
        setFitToContents(obtainStyledAttributes.getBoolean(m.f31265U0, true));
        setSkipCollapsed(obtainStyledAttributes.getBoolean(m.f31330a1, false));
        setDraggable(obtainStyledAttributes.getBoolean(m.f31243S0, true));
        setSaveFlags(obtainStyledAttributes.getInt(m.f31309Y0, 0));
        setHalfExpandedRatio(obtainStyledAttributes.getFloat(m.f31276V0, 0.5f));
        int i15 = m.f31254T0;
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(i15);
        if (peekValue2 != null && peekValue2.type == 16) {
            setExpandedOffset(peekValue2.data);
        } else {
            setExpandedOffset(obtainStyledAttributes.getDimensionPixelOffset(i15, 0));
        }
        setSignificantVelocityThreshold(obtainStyledAttributes.getInt(m.f31319Z0, 500));
        this.paddingBottomSystemWindowInsets = obtainStyledAttributes.getBoolean(m.f31385f1, false);
        this.paddingLeftSystemWindowInsets = obtainStyledAttributes.getBoolean(m.f31396g1, false);
        this.paddingRightSystemWindowInsets = obtainStyledAttributes.getBoolean(m.f31407h1, false);
        this.paddingTopSystemWindowInsets = obtainStyledAttributes.getBoolean(m.f31418i1, true);
        this.marginLeftSystemWindowInsets = obtainStyledAttributes.getBoolean(m.f31352c1, false);
        this.marginRightSystemWindowInsets = obtainStyledAttributes.getBoolean(m.f31363d1, false);
        this.marginTopSystemWindowInsets = obtainStyledAttributes.getBoolean(m.f31374e1, false);
        this.shouldRemoveExpandedCorners = obtainStyledAttributes.getBoolean(m.f31440k1, true);
        obtainStyledAttributes.recycle();
        this.maximumVelocity = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    /* loaded from: classes3.dex */
    public static abstract class g {
        public abstract void onSlide(View view, float f10);

        public abstract void onStateChanged(View view, int i10);

        public void onLayout(View view) {
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v10, View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
    }
}
