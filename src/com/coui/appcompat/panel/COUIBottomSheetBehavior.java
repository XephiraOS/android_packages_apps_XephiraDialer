package com.coui.appcompat.panel;

import J.d;
import J.g;
import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.animation.PathInterpolator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.K;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.c;
import androidx.dynamicanimation.animation.c;
import c9.C0572d;
import c9.C0574f;
import com.android.incallui.OplusPhoneUtils;
import com.coui.appcompat.animation.COUIOutEaseInterpolator;
import com.coui.appcompat.log.COUILog;
import com.coui.appcompat.uiutil.UIUtil;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import e4.C0977c;
import e4.C0979e;
import e4.l;
import e4.m;
import i8.InterfaceC1105a;
import i8.g;
import i8.j;
import i8.k;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import u4.C1607c;
import x4.i;
import x4.n;

/* loaded from: classes.dex */
public class COUIBottomSheetBehavior<V extends View> extends BottomSheetBehavior<V> implements InterfaceC1105a, i8.b {
    private static final int CORNER_ANIMATION_DURATION = 500;
    private static boolean DEBUG = false;
    private static final float DEFAULT_PHYSICS_DAMPING_RATIO = 0.6f;
    private static final float DEFAULT_PHYSICS_FREQUENCY = 16.0f;
    private static final float DEFAULT_TRANSLATE_HIDING_ANIMATOR_DURATION = 333.0f;
    private static final int DEF_STYLE_RES;
    private static final int DRAG_TO_HIDDEN_SPEED_THRESHOLD = 5000;
    private static final float HIDE_FRICTION = 0.1f;
    private static final float HIDE_THRESHOLD = 0.5f;
    public static final int PEEK_HEIGHT_AUTO = -1;
    private static final float PHYSICS_UNSET = Float.MIN_VALUE;
    private static final String PROPERTY_OFFSET_TOP_AND_BOTTOM = "offsetTopAndBottom";
    private static final int PULL_UP_DY_THRESHOLD = -100;
    private static final float PULL_UP_FRICTION = 0.5f;
    private static final int PULL_UP_SPEED_THRESHOLD = 10000;
    public static final int SAVE_ALL = -1;
    public static final int SAVE_FIT_TO_CONTENTS = 2;
    public static final int SAVE_HIDEABLE = 4;
    public static final int SAVE_NONE = 0;
    public static final int SAVE_PEEK_HEIGHT = 1;
    public static final int SAVE_SKIP_COLLAPSED = 8;
    private static final int SIGNIFICANT_VEL_THRESHOLD = 500;
    public static final int STATE_COLLAPSED = 4;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_EXPANDED = 3;
    public static final int STATE_HALF_EXPANDED = 6;
    public static final int STATE_HIDDEN = 5;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "BottomSheetBehavior";
    private static final int VERTICAL_SLIDING_PARAMETER_THRESHOLD = 2;
    int activePointerId;
    private float alphaRadio;
    private final ArrayList<COUIBottomSheetCallback> callbacks;
    int collapsedOffset;
    private final c.AbstractC0115c dragCallback;
    private boolean draggable;
    float elevation;
    int expandedOffset;
    private boolean fitToContents;
    int fitToContentsOffset;
    private boolean gestureInsetBottomIgnored;
    int halfExpandedOffset;
    float halfExpandedRatio;
    boolean hideable;
    private boolean ignoreEvents;
    private Map<View, Integer> importantForAccessibilityMap;
    private int initialX;
    private int initialY;
    private ValueAnimator interpolatorAnimator;
    private boolean isShapeExpanded;
    private int lastNestedScrollDy;
    private Rect mBarRect;
    COUIPanelDragListener mCOUIPanelDragListener;
    private boolean mCanHideKeyboard;
    private Context mContext;
    private g mDragBehavior;
    private View mDragChild;
    private float mDragCurrentValue;
    private float mDragDampingRatio;
    private float mDragFrequency;
    private j mDragValueHolder;
    private boolean mGlobalDrag;
    boolean mHalfExpandOffsetUseParentRootViewHeight;
    private boolean mIsHandlePanel;
    private boolean mIsIgnoreExpandedOffsetChange;
    private boolean mIsInTinyScreen;
    private int mLastOffsetInFling;
    private k mPhysicalAnimator;
    private boolean mPhysicsEnable;
    private COUIPanelPullUpListener mPullUpListener;
    private i materialShapeDrawable;
    private float maximumVelocity;
    private boolean nestedScrolled;
    WeakReference<View> nestedScrollingChildRef;
    int parentHeight;
    int parentMarginTop;
    int parentRootViewHeight;
    int parentWidth;
    private int peekHeight;
    private boolean peekHeightAuto;
    private int peekHeightMin;
    private int saveFlags;
    private COUIBottomSheetBehavior<V>.SettleRunnable settleRunnable;
    private n shapeAppearanceModelDefault;
    private boolean shapeThemingEnabled;
    private boolean skipCollapsed;
    int state;
    boolean touchingScrollingChild;
    private boolean updateImportantForAccessibilityOnSiblings;
    private VelocityTracker velocityTracker;
    androidx.customview.widget.c viewDragHelper;
    WeakReference<V> viewRef;

    /* loaded from: classes.dex */
    public static abstract class COUIBottomSheetCallback {
        public abstract void onSlide(View view, float f10);

        public abstract void onStateChanged(View view, int i10);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface SaveFlags {
    }

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.coui.appcompat.panel.COUIBottomSheetBehavior.SavedState.1
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }
        };
        boolean fitToContents;
        boolean hideable;
        int peekHeight;
        boolean skipCollapsed;
        final int state;

        public SavedState(Parcel parcel) {
            this(parcel, (ClassLoader) null);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.state);
            parcel.writeInt(this.peekHeight);
            parcel.writeInt(this.fitToContents ? 1 : 0);
            parcel.writeInt(this.hideable ? 1 : 0);
            parcel.writeInt(this.skipCollapsed ? 1 : 0);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.state = parcel.readInt();
            this.peekHeight = parcel.readInt();
            this.fitToContents = parcel.readInt() == 1;
            this.hideable = parcel.readInt() == 1;
            this.skipCollapsed = parcel.readInt() == 1;
        }

        public SavedState(Parcelable parcelable, COUIBottomSheetBehavior<?> cOUIBottomSheetBehavior) {
            super(parcelable);
            this.state = cOUIBottomSheetBehavior.state;
            this.peekHeight = ((COUIBottomSheetBehavior) cOUIBottomSheetBehavior).peekHeight;
            this.fitToContents = ((COUIBottomSheetBehavior) cOUIBottomSheetBehavior).fitToContents;
            this.hideable = cOUIBottomSheetBehavior.hideable;
            this.skipCollapsed = ((COUIBottomSheetBehavior) cOUIBottomSheetBehavior).skipCollapsed;
        }

        @Deprecated
        public SavedState(Parcelable parcelable, int i10) {
            super(parcelable);
            this.state = i10;
        }
    }

    /* loaded from: classes.dex */
    public class SettleRunnable implements Runnable {
        private boolean isPosted;
        int targetState;
        private final View view;

        public SettleRunnable(View view, int i10) {
            this.view = view;
            this.targetState = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx.customview.widget.c cVar = COUIBottomSheetBehavior.this.viewDragHelper;
            if (cVar != null && cVar.n(true)) {
                COUIBottomSheetBehavior.this.calculatePanelOutsideAlpha(this.view);
                K.a0(this.view, this);
            } else {
                COUIBottomSheetBehavior.this.setStateInternal(this.targetState);
            }
            this.isPosted = false;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface State {
    }

    static {
        boolean z10;
        if (!COUILog.LOG_DEBUG && !COUILog.isLoggable(TAG, 3)) {
            z10 = false;
        } else {
            z10 = true;
        }
        DEBUG = z10;
        DEF_STYLE_RES = l.f31028k;
    }

    public COUIBottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i10;
        this.saveFlags = 0;
        this.fitToContents = true;
        this.updateImportantForAccessibilityOnSiblings = false;
        this.settleRunnable = null;
        this.halfExpandedRatio = 0.5f;
        this.elevation = -1.0f;
        this.draggable = true;
        this.state = 4;
        this.mHalfExpandOffsetUseParentRootViewHeight = true;
        this.callbacks = new ArrayList<>();
        this.mLastOffsetInFling = 0;
        this.alphaRadio = 0.0f;
        this.mDragFrequency = 16.0f;
        this.mDragDampingRatio = 0.6f;
        this.mPhysicsEnable = false;
        this.mDragChild = null;
        this.mIsInTinyScreen = false;
        this.mIsHandlePanel = false;
        this.mBarRect = new Rect();
        this.mGlobalDrag = true;
        this.dragCallback = new c.AbstractC0115c() { // from class: com.coui.appcompat.panel.COUIBottomSheetBehavior.7
            private boolean releasedLow(View view) {
                int top = view.getTop();
                COUIBottomSheetBehavior cOUIBottomSheetBehavior = COUIBottomSheetBehavior.this;
                if (top > (cOUIBottomSheetBehavior.parentHeight + cOUIBottomSheetBehavior.getExpandedOffset()) / 2) {
                    return true;
                }
                return false;
            }

            @Override // androidx.customview.widget.c.AbstractC0115c
            public int clampViewPositionHorizontal(View view, int i11, int i12) {
                return view.getLeft();
            }

            @Override // androidx.customview.widget.c.AbstractC0115c
            public int clampViewPositionVertical(View view, int i11, int i12) {
                int i13;
                if (COUIBottomSheetBehavior.this.mPullUpListener != null) {
                    COUIBottomSheetBehavior.this.mPullUpListener.onDraggingPanel();
                }
                int i14 = 0;
                if (COUIBottomSheetBehavior.this.state == 1) {
                    if (view.getTop() <= COUIBottomSheetBehavior.this.getExpandedOffset()) {
                        if (COUIBottomSheetBehavior.this.mPhysicsEnable && COUIBottomSheetBehavior.this.mDragBehavior.S()) {
                            COUIBottomSheetBehavior.this.mDragBehavior.O(0.0f);
                            COUIBottomSheetBehavior.this.mDragChild = null;
                        }
                        if (COUIBottomSheetBehavior.this.mPullUpListener != null && COUIBottomSheetBehavior.this.getExpandedOffset() > 0) {
                            COUIBottomSheetBehavior.this.mIsIgnoreExpandedOffsetChange = true;
                            i14 = COUIBottomSheetBehavior.this.mPullUpListener.onDragging(i12, COUIBottomSheetBehavior.this.getExpandedOffset());
                        }
                    } else {
                        int top = view.getTop();
                        if (COUIBottomSheetBehavior.this.mPhysicsEnable) {
                            COUIBottomSheetBehavior.this.dragToNewTop(view, top + i12);
                        } else if (COUIBottomSheetBehavior.this.getYVelocity() > 10000.0f) {
                            i11 = ((int) ((i12 * 0.5f) + 0.5f)) + top;
                        }
                    }
                }
                COUIBottomSheetBehavior.this.calculatePanelOutsideAlpha(view);
                int expandedOffset = COUIBottomSheetBehavior.this.getExpandedOffset() - i14;
                COUIBottomSheetBehavior cOUIBottomSheetBehavior = COUIBottomSheetBehavior.this;
                if (cOUIBottomSheetBehavior.hideable) {
                    i13 = cOUIBottomSheetBehavior.parentHeight;
                } else {
                    i13 = cOUIBottomSheetBehavior.collapsedOffset;
                }
                return E.a.b(i11, expandedOffset, i13);
            }

            @Override // androidx.customview.widget.c.AbstractC0115c
            public int getViewVerticalDragRange(View view) {
                COUIBottomSheetBehavior cOUIBottomSheetBehavior = COUIBottomSheetBehavior.this;
                if (cOUIBottomSheetBehavior.hideable) {
                    return cOUIBottomSheetBehavior.parentHeight;
                }
                return cOUIBottomSheetBehavior.collapsedOffset;
            }

            @Override // androidx.customview.widget.c.AbstractC0115c
            public void onViewDragStateChanged(int i11) {
                if (i11 == 1 && COUIBottomSheetBehavior.this.draggable) {
                    COUIBottomSheetBehavior.this.setStateInternal(1);
                }
            }

            @Override // androidx.customview.widget.c.AbstractC0115c
            public void onViewPositionChanged(View view, int i11, int i12, int i13, int i14) {
                COUIBottomSheetBehavior.this.dispatchOnSlide(i12);
            }

            @Override // androidx.customview.widget.c.AbstractC0115c
            public void onViewReleased(View view, float f10, float f11) {
                int i11;
                float f12;
                if (COUIBottomSheetBehavior.this.mPhysicsEnable && COUIBottomSheetBehavior.this.mDragBehavior.S()) {
                    COUIBottomSheetBehavior.this.mDragBehavior.O(0.0f);
                    COUIBottomSheetBehavior.this.mDragChild = null;
                }
                COUIBottomSheetBehavior.this.mIsIgnoreExpandedOffsetChange = false;
                if (COUIBottomSheetBehavior.this.mPullUpListener != null) {
                    COUIBottomSheetBehavior.this.mPullUpListener.onReleasedDrag();
                    if (view instanceof COUIPanelPercentFrameLayout) {
                        f12 = ((COUIPanelPercentFrameLayout) view).getRatio();
                    } else {
                        f12 = 1.0f;
                    }
                    COUIBottomSheetBehavior cOUIBottomSheetBehavior = COUIBottomSheetBehavior.this;
                    if (((int) (((cOUIBottomSheetBehavior.parentHeight - cOUIBottomSheetBehavior.getMarginBottom(view)) / f12) - (view.getHeight() / f12))) <= COUIBottomSheetBehavior.this.getExpandedOffset() && view.getTop() < COUIBottomSheetBehavior.this.getExpandedOffset()) {
                        COUIBottomSheetBehavior.this.mPullUpListener.onReleased(COUIBottomSheetBehavior.this.getExpandedOffset());
                        return;
                    }
                }
                int i12 = 6;
                if (f11 < 0.0f) {
                    if (COUIBottomSheetBehavior.this.fitToContents) {
                        i11 = COUIBottomSheetBehavior.this.fitToContentsOffset;
                    } else {
                        int top = view.getTop();
                        COUIBottomSheetBehavior cOUIBottomSheetBehavior2 = COUIBottomSheetBehavior.this;
                        int i13 = cOUIBottomSheetBehavior2.halfExpandedOffset;
                        if (top > i13) {
                            i11 = i13;
                            COUIBottomSheetBehavior.this.startSettlingAnimation(view, i12, i11, true);
                        }
                        i11 = cOUIBottomSheetBehavior2.expandedOffset;
                    }
                    i12 = 3;
                    COUIBottomSheetBehavior.this.startSettlingAnimation(view, i12, i11, true);
                }
                COUIBottomSheetBehavior cOUIBottomSheetBehavior3 = COUIBottomSheetBehavior.this;
                if (cOUIBottomSheetBehavior3.hideable && cOUIBottomSheetBehavior3.shouldHide(view, f11)) {
                    COUIPanelDragListener cOUIPanelDragListener = COUIBottomSheetBehavior.this.mCOUIPanelDragListener;
                    if (cOUIPanelDragListener != null && cOUIPanelDragListener.onDragWhileEditing()) {
                        COUIBottomSheetBehavior cOUIBottomSheetBehavior4 = COUIBottomSheetBehavior.this;
                        int i14 = cOUIBottomSheetBehavior4.fitToContentsOffset;
                        cOUIBottomSheetBehavior4.mCanHideKeyboard = false;
                        i11 = i14;
                    } else if ((Math.abs(f10) < Math.abs(f11) && f11 > 500.0f) || releasedLow(view)) {
                        COUIBottomSheetBehavior cOUIBottomSheetBehavior5 = COUIBottomSheetBehavior.this;
                        int i15 = cOUIBottomSheetBehavior5.parentRootViewHeight;
                        cOUIBottomSheetBehavior5.mCanHideKeyboard = true;
                        i11 = i15;
                        i12 = 5;
                    } else if (COUIBottomSheetBehavior.this.fitToContents) {
                        i11 = COUIBottomSheetBehavior.this.fitToContentsOffset;
                    } else if (Math.abs(view.getTop() - COUIBottomSheetBehavior.this.expandedOffset) < Math.abs(view.getTop() - COUIBottomSheetBehavior.this.halfExpandedOffset)) {
                        i11 = COUIBottomSheetBehavior.this.expandedOffset;
                    } else {
                        i11 = COUIBottomSheetBehavior.this.halfExpandedOffset;
                    }
                    i12 = 3;
                } else if (f11 != 0.0f && Math.abs(f10) <= Math.abs(f11)) {
                    if (COUIBottomSheetBehavior.this.fitToContents) {
                        COUIBottomSheetBehavior cOUIBottomSheetBehavior6 = COUIBottomSheetBehavior.this;
                        COUIPanelDragListener cOUIPanelDragListener2 = cOUIBottomSheetBehavior6.mCOUIPanelDragListener;
                        if (cOUIPanelDragListener2 != null) {
                            if (cOUIPanelDragListener2.onDragWhileEditing()) {
                                i11 = COUIBottomSheetBehavior.this.fitToContentsOffset;
                                i12 = 3;
                            } else {
                                i11 = COUIBottomSheetBehavior.this.parentRootViewHeight;
                                i12 = 5;
                            }
                        } else {
                            i11 = cOUIBottomSheetBehavior6.collapsedOffset;
                        }
                    } else {
                        int top2 = view.getTop();
                        if (Math.abs(top2 - COUIBottomSheetBehavior.this.halfExpandedOffset) < Math.abs(top2 - COUIBottomSheetBehavior.this.collapsedOffset)) {
                            i11 = COUIBottomSheetBehavior.this.halfExpandedOffset;
                        } else {
                            i11 = COUIBottomSheetBehavior.this.collapsedOffset;
                        }
                    }
                    i12 = 4;
                } else {
                    int top3 = view.getTop();
                    if (COUIBottomSheetBehavior.this.fitToContents) {
                        if (Math.abs(top3 - COUIBottomSheetBehavior.this.fitToContentsOffset) < Math.abs(top3 - COUIBottomSheetBehavior.this.collapsedOffset)) {
                            i11 = COUIBottomSheetBehavior.this.fitToContentsOffset;
                            i12 = 3;
                        } else {
                            i11 = COUIBottomSheetBehavior.this.collapsedOffset;
                            i12 = 4;
                        }
                    } else {
                        COUIBottomSheetBehavior cOUIBottomSheetBehavior7 = COUIBottomSheetBehavior.this;
                        int i16 = cOUIBottomSheetBehavior7.halfExpandedOffset;
                        if (top3 < i16) {
                            if (top3 < Math.abs(top3 - cOUIBottomSheetBehavior7.collapsedOffset)) {
                                i11 = COUIBottomSheetBehavior.this.expandedOffset;
                                i12 = 3;
                            } else {
                                i11 = COUIBottomSheetBehavior.this.halfExpandedOffset;
                            }
                        } else if (Math.abs(top3 - i16) < Math.abs(top3 - COUIBottomSheetBehavior.this.collapsedOffset)) {
                            i11 = COUIBottomSheetBehavior.this.halfExpandedOffset;
                        } else {
                            i11 = COUIBottomSheetBehavior.this.collapsedOffset;
                            i12 = 4;
                        }
                    }
                }
                COUIBottomSheetBehavior.this.startSettlingAnimation(view, i12, i11, true);
            }

            @Override // androidx.customview.widget.c.AbstractC0115c
            public boolean tryCaptureView(View view, int i11) {
                View view2;
                COUIBottomSheetBehavior cOUIBottomSheetBehavior = COUIBottomSheetBehavior.this;
                int i12 = cOUIBottomSheetBehavior.state;
                if (i12 == 1 || cOUIBottomSheetBehavior.touchingScrollingChild) {
                    return false;
                }
                if (i12 == 3 && cOUIBottomSheetBehavior.activePointerId == i11) {
                    WeakReference<View> weakReference = cOUIBottomSheetBehavior.nestedScrollingChildRef;
                    if (weakReference != null) {
                        view2 = weakReference.get();
                    } else {
                        view2 = null;
                    }
                    if (view2 != null && view2.canScrollVertically(-1)) {
                        return false;
                    }
                }
                WeakReference<V> weakReference2 = COUIBottomSheetBehavior.this.viewRef;
                if (weakReference2 == null || weakReference2.get() != view) {
                    return false;
                }
                return true;
            }
        };
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.f31188N0);
        this.shapeThemingEnabled = obtainStyledAttributes.hasValue(m.f31429j1);
        int i11 = m.f31232R0;
        boolean hasValue = obtainStyledAttributes.hasValue(i11);
        if (hasValue) {
            createMaterialShapeDrawable(context, attributeSet, hasValue, C1607c.a(context, obtainStyledAttributes, i11));
        } else {
            createMaterialShapeDrawable(context, attributeSet, hasValue);
        }
        createShapeValueAnimator();
        this.elevation = obtainStyledAttributes.getDimension(m.f31221Q0, -1.0f);
        int i12 = m.f31298X0;
        TypedValue peekValue = obtainStyledAttributes.peekValue(i12);
        if (peekValue != null && (i10 = peekValue.data) == -1) {
            setPanelPeekHeight(i10);
        } else {
            setPanelPeekHeight(obtainStyledAttributes.getDimensionPixelSize(i12, -1));
        }
        setHideable(obtainStyledAttributes.getBoolean(m.f31287W0, false));
        setGestureInsetBottomIgnored(obtainStyledAttributes.getBoolean(m.f31341b1, false));
        setFitToContents(obtainStyledAttributes.getBoolean(m.f31265U0, true));
        setPanelSkipCollapsed(obtainStyledAttributes.getBoolean(m.f31330a1, false));
        setDraggable(obtainStyledAttributes.getBoolean(m.f31243S0, true));
        setSaveFlags(obtainStyledAttributes.getInt(m.f31309Y0, -1));
        setHalfExpandedRatio(obtainStyledAttributes.getFloat(m.f31276V0, 0.5f));
        int i13 = m.f31254T0;
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(i13);
        if (peekValue2 != null && peekValue2.type == 16) {
            setExpandedOffset(peekValue2.data);
        } else {
            setExpandedOffset(obtainStyledAttributes.getDimensionPixelOffset(i13, 0));
        }
        obtainStyledAttributes.recycle();
        this.maximumVelocity = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
        this.mCanHideKeyboard = false;
    }

    private void addAccessibilityActionForState(V v10, d.a aVar, final int i10) {
        K.e0(v10, aVar, null, new J.g() { // from class: com.coui.appcompat.panel.COUIBottomSheetBehavior.8
            @Override // J.g
            public boolean perform(View view, g.a aVar2) {
                COUIBottomSheetBehavior.this.setPanelState(i10);
                return true;
            }
        });
    }

    private void calculateCollapsedOffset() {
        int calculatePeekHeight = calculatePeekHeight();
        if (this.fitToContents) {
            this.collapsedOffset = Math.max(this.parentHeight - calculatePeekHeight, this.fitToContentsOffset);
        } else {
            this.collapsedOffset = this.parentHeight - calculatePeekHeight;
        }
    }

    private void calculateHalfExpandedOffset() {
        this.halfExpandedOffset = (int) (this.parentHeight * (1.0f - this.halfExpandedRatio));
        if (DEBUG) {
            Log.d(TAG, "calculateHalfExpandedOffset: halfExpandedRatio=" + this.halfExpandedRatio + " halfExpandedOffset=" + this.halfExpandedOffset);
        }
        if (this.mHalfExpandOffsetUseParentRootViewHeight && this.mIsHandlePanel && this.halfExpandedRatio == 0.5f) {
            this.halfExpandedOffset = (this.parentRootViewHeight / 2) - this.parentMarginTop;
            if (DEBUG) {
                Log.d(TAG, "calculateHalfExpandedOffset: modified halfExpandedOffset=" + this.halfExpandedOffset);
            }
        }
        if (this.mIsHandlePanel) {
            this.halfExpandedOffset = Math.max(this.halfExpandedOffset, this.expandedOffset);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void calculatePanelOutsideAlpha(View view) {
        float top = 1.0f - ((view.getTop() - getExpandedOffset()) / this.parentHeight);
        this.alphaRadio = top;
        COUIPanelPullUpListener cOUIPanelPullUpListener = this.mPullUpListener;
        if (cOUIPanelPullUpListener != null) {
            cOUIPanelPullUpListener.onOffsetChanged(top);
        }
    }

    private int calculatePeekHeight() {
        if (this.peekHeightAuto) {
            return Math.max(this.peekHeightMin, this.parentHeight - ((this.parentWidth * 9) / 16));
        }
        return this.peekHeight;
    }

    private void createMaterialShapeDrawable(Context context, AttributeSet attributeSet, boolean z10) {
        createMaterialShapeDrawable(context, attributeSet, z10, null);
    }

    private void createShapeValueAnimator() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.interpolatorAnimator = ofFloat;
        ofFloat.setDuration(500L);
        this.interpolatorAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.panel.COUIBottomSheetBehavior.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (COUIBottomSheetBehavior.this.materialShapeDrawable != null) {
                    COUIBottomSheetBehavior.this.materialShapeDrawable.setInterpolation(floatValue);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dragToNewTop(View view, float f10) {
        if (this.mDragBehavior.S()) {
            this.mDragBehavior.T(f10);
            return;
        }
        this.mDragChild = view;
        float top = view.getTop();
        this.mDragValueHolder.c(top);
        this.mDragBehavior.J(top, top);
        this.mDragCurrentValue = top;
    }

    public static <V extends View> COUIBottomSheetBehavior<V> from(V v10) {
        ViewGroup.LayoutParams layoutParams = v10.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.e) {
            CoordinatorLayout.Behavior f10 = ((CoordinatorLayout.e) layoutParams).f();
            if (f10 instanceof COUIBottomSheetBehavior) {
                return (COUIBottomSheetBehavior) f10;
            }
            throw new IllegalArgumentException("The view is not associated with COUIBottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getMarginBottom(View view) {
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getYVelocity() {
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.maximumVelocity);
        return this.velocityTracker.getYVelocity(this.activePointerId);
    }

    private boolean isClickedOnBar(View view, int i10, int i11) {
        View findViewById;
        if (!(view instanceof COUIPanelPercentFrameLayout) || (findViewById = view.findViewById(C0574f.f12918l)) == null) {
            return false;
        }
        findViewById.getHitRect(this.mBarRect);
        return this.mBarRect.contains(i10, i11);
    }

    private void reset() {
        this.activePointerId = -1;
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
            this.peekHeight = savedState.peekHeight;
        }
        if (i10 == -1 || (i10 & 2) == 2) {
            this.fitToContents = savedState.fitToContents;
        }
        if (i10 == -1 || (i10 & 4) == 4) {
            this.hideable = savedState.hideable;
        }
        if (i10 == -1 || (i10 & 8) == 8) {
            this.skipCollapsed = savedState.skipCollapsed;
        }
    }

    private void setSystemGestureInsets(CoordinatorLayout coordinatorLayout) {
        WindowInsets rootWindowInsets;
        if (!isGestureInsetBottomIgnored() && (rootWindowInsets = coordinatorLayout.getRootWindowInsets()) != null) {
            this.peekHeight += rootWindowInsets.getSystemGestureInsets().bottom;
        }
    }

    private void settleToStatePendingLayout(final int i10) {
        final V v10 = this.viewRef.get();
        if (v10 == null) {
            return;
        }
        ViewParent parent = v10.getParent();
        if (parent != null && parent.isLayoutRequested() && K.N(v10)) {
            v10.post(new Runnable() { // from class: com.coui.appcompat.panel.COUIBottomSheetBehavior.1
                @Override // java.lang.Runnable
                public void run() {
                    COUIBottomSheetBehavior.this.settleToState(v10, i10);
                }
            });
        } else {
            settleToState(v10, i10);
        }
    }

    private void startDragToHiddenAnimation(final View view) {
        androidx.dynamicanimation.animation.d dVar = new androidx.dynamicanimation.animation.d(PROPERTY_OFFSET_TOP_AND_BOTTOM) { // from class: com.coui.appcompat.panel.COUIBottomSheetBehavior.5
            @Override // androidx.dynamicanimation.animation.d
            public float getValue(Object obj) {
                COUIBottomSheetBehavior.this.mLastOffsetInFling = 0;
                return COUIBottomSheetBehavior.this.mLastOffsetInFling;
            }

            @Override // androidx.dynamicanimation.animation.d
            public void setValue(Object obj, float f10) {
                int i10 = (int) f10;
                ((View) obj).offsetTopAndBottom(i10 - COUIBottomSheetBehavior.this.mLastOffsetInFling);
                COUIBottomSheetBehavior.this.dispatchOnSlide(view.getTop());
                COUIBottomSheetBehavior.this.mLastOffsetInFling = i10;
            }
        };
        if (DEBUG) {
            COUILog.d(TAG, "startDragToHiddenAnimation parentRootViewHeight:" + this.parentRootViewHeight + ",child.getTop():" + view.getTop());
        }
        new androidx.dynamicanimation.animation.b(view, dVar).w(getYVelocity()).t(5000.0f).v(0.0f).u(Math.max(this.parentRootViewHeight - view.getTop(), 0)).a(new c.q() { // from class: com.coui.appcompat.panel.COUIBottomSheetBehavior.6
            @Override // androidx.dynamicanimation.animation.c.q
            public void onAnimationEnd(androidx.dynamicanimation.animation.c cVar, boolean z10, float f10, float f11) {
                COUIBottomSheetBehavior.this.setStateInternal(5);
            }
        }).p();
    }

    private void startPanelTranslateAnimation(final View view, int i10, int i11, float f10, PathInterpolator pathInterpolator) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(i10, i11);
        ofFloat.setDuration(f10);
        ofFloat.setInterpolator(pathInterpolator);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.panel.COUIBottomSheetBehavior.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                view.offsetTopAndBottom(floatValue - COUIBottomSheetBehavior.this.mLastOffsetInFling);
                COUIBottomSheetBehavior.this.dispatchOnSlide(view.getTop());
                COUIBottomSheetBehavior.this.mLastOffsetInFling = floatValue;
                if (COUIBottomSheetBehavior.this.mPullUpListener != null) {
                    COUIBottomSheetBehavior.this.calculatePanelOutsideAlpha(view);
                }
            }
        });
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.coui.appcompat.panel.COUIBottomSheetBehavior.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                COUIBottomSheetBehavior.this.setStateInternal(5);
            }
        });
        this.mLastOffsetInFling = view.getTop();
        view.offsetTopAndBottom(view.getTop());
        ofFloat.start();
    }

    private void startSettleRunnable(View view, int i10) {
        if (this.settleRunnable == null) {
            this.settleRunnable = new SettleRunnable(view, i10);
        }
        if (!((SettleRunnable) this.settleRunnable).isPosted) {
            COUIBottomSheetBehavior<V>.SettleRunnable settleRunnable = this.settleRunnable;
            settleRunnable.targetState = i10;
            K.a0(view, settleRunnable);
            ((SettleRunnable) this.settleRunnable).isPosted = true;
            return;
        }
        this.settleRunnable.targetState = i10;
    }

    private void updateAccessibilityActions() {
        V v10;
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference == null || (v10 = weakReference.get()) == null) {
            return;
        }
        K.c0(v10, 524288);
        K.c0(v10, 262144);
        K.c0(v10, OplusPhoneUtils.PROPERTY_HIGH_DEF_AUDIO_EVS);
        if (this.hideable && this.state != 5) {
            addAccessibilityActionForState((COUIBottomSheetBehavior<V>) v10, d.a.f1410y, 5);
        }
        int i10 = this.state;
        int i11 = 6;
        if (i10 != 3) {
            if (i10 != 4) {
                if (i10 == 6) {
                    addAccessibilityActionForState((COUIBottomSheetBehavior<V>) v10, d.a.f1409x, 4);
                    addAccessibilityActionForState((COUIBottomSheetBehavior<V>) v10, d.a.f1408w, 3);
                    return;
                }
                return;
            }
            if (this.fitToContents) {
                i11 = 3;
            }
            addAccessibilityActionForState((COUIBottomSheetBehavior<V>) v10, d.a.f1408w, i11);
            return;
        }
        if (this.fitToContents) {
            i11 = 4;
        }
        addAccessibilityActionForState((COUIBottomSheetBehavior<V>) v10, d.a.f1409x, i11);
    }

    private void updateDrawableForTargetState(int i10) {
        boolean z10;
        ValueAnimator valueAnimator;
        float f10;
        if (i10 == 2) {
            return;
        }
        if (i10 == 3) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (this.isShapeExpanded != z10) {
            this.isShapeExpanded = z10;
            if (this.materialShapeDrawable != null && (valueAnimator = this.interpolatorAnimator) != null) {
                if (valueAnimator.isRunning()) {
                    this.interpolatorAnimator.reverse();
                    return;
                }
                if (z10) {
                    f10 = 0.0f;
                } else {
                    f10 = 1.0f;
                }
                this.interpolatorAnimator.setFloatValues(1.0f - f10, f10);
                this.interpolatorAnimator.start();
            }
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
        }
    }

    public void addBottomSheetCallback(COUIBottomSheetCallback cOUIBottomSheetCallback) {
        if (!this.callbacks.contains(cOUIBottomSheetCallback)) {
            this.callbacks.add(cOUIBottomSheetCallback);
        }
    }

    public void applyPhysics(float f10, float f11) {
        if (f10 != PHYSICS_UNSET && f11 != PHYSICS_UNSET) {
            this.mPhysicsEnable = true;
            this.mDragFrequency = f10;
            this.mDragDampingRatio = f11;
            this.mPhysicalAnimator = k.e(this.mContext);
            this.mDragValueHolder = new j(0.0f);
            i8.g gVar = (i8.g) ((i8.g) new i8.g().I(this.mDragValueHolder)).z(this.mDragFrequency, this.mDragDampingRatio).b(null);
            this.mDragBehavior = gVar;
            this.mPhysicalAnimator.c(gVar);
            this.mPhysicalAnimator.a(this.mDragBehavior, this);
            this.mPhysicalAnimator.b(this.mDragBehavior, this);
            return;
        }
        this.mPhysicsEnable = false;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public void disableShapeAnimations() {
        this.interpolatorAnimator = null;
    }

    public void dispatchOnSlide(int i10) {
        float f10;
        float f11;
        V v10 = this.viewRef.get();
        if (v10 != null && !this.callbacks.isEmpty()) {
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
            float f12 = f10 / f11;
            for (int i14 = 0; i14 < this.callbacks.size(); i14++) {
                this.callbacks.get(i14).onSlide(v10, f12);
            }
        }
    }

    public View findScrollingChild(View view) {
        if (K.P(view) && view.getVisibility() == 0) {
            return view;
        }
        if ((view instanceof ViewGroup) && view.getVisibility() == 0) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View findScrollingChild = findScrollingChild(viewGroup.getChildAt(i10));
                if (findScrollingChild != null) {
                    return findScrollingChild;
                }
            }
            return null;
        }
        return null;
    }

    public COUIPanelDragListener getCOUIPanelDragListener() {
        return this.mCOUIPanelDragListener;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public int getExpandedOffset() {
        if (this.fitToContents) {
            return this.fitToContentsOffset;
        }
        return this.expandedOffset;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public float getHalfExpandedRatio() {
        return this.halfExpandedRatio;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public int getPeekHeight() {
        if (this.peekHeightAuto) {
            return -1;
        }
        return this.peekHeight;
    }

    public int getPeekHeightMin() {
        return this.peekHeightMin;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public int getSaveFlags() {
        return this.saveFlags;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public boolean getSkipCollapsed() {
        return this.skipCollapsed;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public int getState() {
        return this.state;
    }

    public boolean isCanHideKeyboard() {
        return this.mCanHideKeyboard;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public boolean isDraggable() {
        return this.draggable;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public boolean isFitToContents() {
        return this.fitToContents;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public boolean isGestureInsetBottomIgnored() {
        return this.gestureInsetBottomIgnored;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public boolean isHideable() {
        return this.hideable;
    }

    @Override // i8.b
    public void onAnimationUpdate(i8.c cVar) {
        if (cVar.n() != null) {
            this.mDragCurrentValue = ((Float) cVar.n()).floatValue();
        }
        if (this.mDragChild != null) {
            K.U(this.mDragChild, -((int) (r2.getTop() - this.mDragCurrentValue)));
            dispatchOnSlide(this.mDragChild.getTop());
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(CoordinatorLayout.e eVar) {
        super.onAttachedToLayoutParams(eVar);
        this.viewRef = null;
        this.viewDragHelper = null;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.viewRef = null;
        this.viewDragHelper = null;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
        boolean z10;
        View view;
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
                if (actionMasked != 1) {
                    if (actionMasked == 3) {
                        this.touchingScrollingChild = false;
                        this.activePointerId = -1;
                        if (this.ignoreEvents) {
                            this.ignoreEvents = false;
                            return false;
                        }
                    }
                } else {
                    COUIPanelPullUpListener cOUIPanelPullUpListener = this.mPullUpListener;
                    if (cOUIPanelPullUpListener != null) {
                        cOUIPanelPullUpListener.onCancel();
                    }
                }
            } else {
                this.initialX = (int) motionEvent.getX();
                int y10 = (int) motionEvent.getY();
                this.initialY = y10;
                if (!this.mGlobalDrag && !isClickedOnBar(v10, this.initialX, y10)) {
                    this.ignoreEvents = true;
                    return false;
                }
                this.ignoreEvents = false;
                if (this.state != 2) {
                    WeakReference<View> weakReference = this.nestedScrollingChildRef;
                    if (weakReference != null) {
                        view = weakReference.get();
                    } else {
                        view = null;
                    }
                    if (view != null && coordinatorLayout.z(view, this.initialX, this.initialY)) {
                        this.activePointerId = motionEvent.getPointerId(UIUtil.getAdjustmentPointerIndex(motionEvent, motionEvent.getActionIndex()));
                        this.touchingScrollingChild = true;
                    }
                }
                if (this.activePointerId == -1 && !coordinatorLayout.z(v10, this.initialX, this.initialY)) {
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
            if (view2 != null) {
                if (actionMasked != 2 || this.ignoreEvents || this.state == 1 || coordinatorLayout.z(view2, this.initialX, this.initialY) || this.viewDragHelper == null || Math.abs(this.initialY - motionEvent.getY()) <= this.viewDragHelper.A()) {
                    return false;
                }
                return true;
            }
            if (actionMasked != 2 || this.ignoreEvents || this.state == 1 || this.viewDragHelper == null || Math.abs(this.initialY - motionEvent.getY()) <= this.viewDragHelper.A()) {
                return false;
            }
            return true;
        }
        this.ignoreEvents = true;
        return false;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v10, int i10) {
        boolean z10;
        boolean z11;
        float f10;
        i iVar;
        if (K.s(coordinatorLayout) && !K.s(v10)) {
            v10.setFitsSystemWindows(true);
        }
        float f11 = 1.0f;
        if (this.viewRef == null) {
            this.peekHeightMin = coordinatorLayout.getResources().getDimensionPixelSize(C0979e.f30786h);
            setSystemGestureInsets(coordinatorLayout);
            this.viewRef = new WeakReference<>(v10);
            if (this.shapeThemingEnabled && (iVar = this.materialShapeDrawable) != null) {
                K.n0(v10, iVar);
            }
            i iVar2 = this.materialShapeDrawable;
            if (iVar2 != null) {
                float f12 = this.elevation;
                if (f12 == -1.0f) {
                    f12 = K.r(v10);
                }
                iVar2.setElevation(f12);
                if (this.state == 3) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                this.isShapeExpanded = z11;
                i iVar3 = this.materialShapeDrawable;
                if (z11) {
                    f10 = 0.0f;
                } else {
                    f10 = 1.0f;
                }
                iVar3.setInterpolation(f10);
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
        this.parentRootViewHeight = coordinatorLayout.getRootView().getHeight();
        this.parentMarginTop = COUIViewMarginUtil.getMargin(coordinatorLayout, 1);
        if (DEBUG) {
            Log.d(TAG, "onLayoutChild: parentHeight=" + this.parentHeight + " parentRootViewHeight=" + this.parentRootViewHeight + " marginTop=" + this.parentMarginTop);
        }
        if (v10 instanceof COUIPanelPercentFrameLayout) {
            COUIPanelPercentFrameLayout cOUIPanelPercentFrameLayout = (COUIPanelPercentFrameLayout) v10;
            f11 = cOUIPanelPercentFrameLayout.getRatio();
            z10 = cOUIPanelPercentFrameLayout.getHasAnchor();
        } else {
            z10 = false;
        }
        if (!this.mIsIgnoreExpandedOffsetChange) {
            int marginBottom = getMarginBottom(v10);
            if (z10) {
                this.fitToContentsOffset = 0;
            } else {
                this.fitToContentsOffset = (int) Math.max(0.0f, ((this.parentHeight - marginBottom) / f11) - (v10.getHeight() / f11));
            }
            if (this.mIsHandlePanel) {
                this.expandedOffset = this.fitToContentsOffset;
            }
        }
        if (DEBUG) {
            Log.d(TAG, "updateFollowHandPanelLocation fitToContentsOffset:" + this.fitToContentsOffset + " expandOffset=" + this.expandedOffset + " mIsHandlePanel=" + this.mIsHandlePanel);
        }
        this.mIsIgnoreExpandedOffsetChange = false;
        calculateHalfExpandedOffset();
        calculateCollapsedOffset();
        int i11 = this.state;
        if (i11 == 3) {
            K.U(v10, getExpandedOffset());
        } else if (i11 == 6) {
            K.U(v10, this.halfExpandedOffset);
        } else if (this.hideable && i11 == 5) {
            K.U(v10, this.parentHeight);
        } else if (i11 == 4) {
            K.U(v10, this.collapsedOffset);
        } else if (i11 == 1 || i11 == 2) {
            K.U(v10, top - v10.getTop());
        }
        if (DEBUG) {
            Log.e(TAG, "behavior parentHeight: " + this.parentHeight + " marginBottom: " + getMarginBottom(v10) + "\n mDesignBottomSheetFrameLayout.getRatio()" + f11 + " fitToContentsOffset: " + this.fitToContentsOffset + " H: " + v10.getMeasuredHeight() + "\n Y: " + v10.getY() + " getExpandedOffset" + getExpandedOffset());
        }
        this.nestedScrollingChildRef = new WeakReference<>(findScrollingChild(v10));
        return true;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v10, View view, float f10, float f11) {
        WeakReference<View> weakReference = this.nestedScrollingChildRef;
        if (weakReference == null || view != weakReference.get()) {
            return false;
        }
        if (this.state == 3 && !super.onNestedPreFling(coordinatorLayout, v10, view, f10, f11)) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
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
        if (view != view2) {
            return;
        }
        int top = v10.getTop();
        int i13 = top - i11;
        if (i11 > 0) {
            if (i13 < getExpandedOffset()) {
                iArr[1] = top - getExpandedOffset();
                calculatePanelOutsideAlpha(v10);
                if (this.mPhysicsEnable) {
                    dragToNewTop(v10, getExpandedOffset());
                } else {
                    K.U(v10, -iArr[1]);
                }
                setStateInternal(3);
            } else {
                if (!this.draggable) {
                    return;
                }
                calculatePanelOutsideAlpha(v10);
                iArr[1] = i11;
                if (this.mPhysicsEnable) {
                    dragToNewTop(v10, i13);
                } else {
                    K.U(v10, -i11);
                }
                setStateInternal(1);
            }
        } else if (i11 < 0 && !view.canScrollVertically(-1)) {
            if (i13 > this.collapsedOffset && !this.hideable) {
                calculatePanelOutsideAlpha(v10);
                int i14 = this.collapsedOffset;
                int i15 = top - i14;
                iArr[1] = i15;
                if (this.mPhysicsEnable) {
                    dragToNewTop(v10, i14);
                } else {
                    K.U(v10, -i15);
                }
                setStateInternal(4);
            } else {
                if (!this.draggable) {
                    return;
                }
                iArr[1] = i11;
                if (i11 < PULL_UP_DY_THRESHOLD) {
                    i11 = (int) (i11 * 0.5f);
                }
                calculatePanelOutsideAlpha(v10);
                if (this.mPhysicsEnable) {
                    dragToNewTop(v10, i13);
                } else {
                    K.U(v10, -i11);
                }
                setStateInternal(1);
            }
        }
        if (!this.mPhysicsEnable) {
            dispatchOnSlide(v10.getTop());
        }
        this.lastNestedScrollDy = i11;
        this.nestedScrolled = true;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v10, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, v10, savedState.getSuperState());
        restoreOptionalState(savedState);
        int i10 = savedState.state;
        if (i10 != 1 && i10 != 2) {
            this.state = i10;
        } else {
            this.state = 4;
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v10) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, v10), (COUIBottomSheetBehavior<?>) this);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v10, View view, View view2, int i10, int i11) {
        this.lastNestedScrollDy = 0;
        this.nestedScrolled = false;
        if ((i10 & 2) == 0) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v10, View view, int i10) {
        int i11;
        if (this.mPhysicsEnable && this.mDragBehavior.S()) {
            this.mDragBehavior.O(0.0f);
            this.mDragChild = null;
        }
        int i12 = 3;
        if (v10.getTop() == getExpandedOffset()) {
            setStateInternal(3);
            return;
        }
        WeakReference<View> weakReference = this.nestedScrollingChildRef;
        if (weakReference != null && view == weakReference.get() && this.nestedScrolled) {
            if (this.lastNestedScrollDy > 0) {
                if (this.fitToContents) {
                    i11 = this.fitToContentsOffset;
                } else {
                    int top = v10.getTop();
                    int i13 = this.halfExpandedOffset;
                    if (top > i13) {
                        i12 = 6;
                        i11 = i13;
                    } else {
                        i11 = this.expandedOffset;
                    }
                }
            } else if (this.hideable && shouldHide(v10, getYVelocity())) {
                COUIPanelDragListener cOUIPanelDragListener = this.mCOUIPanelDragListener;
                if (cOUIPanelDragListener != null && cOUIPanelDragListener.onDragWhileEditing()) {
                    i11 = this.fitToContentsOffset;
                    this.mCanHideKeyboard = false;
                } else {
                    i11 = this.parentRootViewHeight;
                    this.mCanHideKeyboard = true;
                    i12 = 5;
                }
            } else if (this.lastNestedScrollDy == 0) {
                int top2 = v10.getTop();
                if (this.fitToContents) {
                    if (Math.abs(top2 - this.fitToContentsOffset) < Math.abs(top2 - this.collapsedOffset)) {
                        i11 = this.fitToContentsOffset;
                    } else {
                        i11 = this.collapsedOffset;
                        i12 = 4;
                    }
                } else {
                    int i14 = this.halfExpandedOffset;
                    if (top2 < i14) {
                        if (top2 < Math.abs(top2 - this.collapsedOffset)) {
                            i11 = this.expandedOffset;
                        } else {
                            i11 = this.halfExpandedOffset;
                        }
                    } else if (Math.abs(top2 - i14) < Math.abs(top2 - this.collapsedOffset)) {
                        i11 = this.halfExpandedOffset;
                    } else {
                        i11 = this.collapsedOffset;
                        i12 = 4;
                    }
                    i12 = 6;
                }
            } else {
                if (this.fitToContents) {
                    COUIPanelDragListener cOUIPanelDragListener2 = this.mCOUIPanelDragListener;
                    if (cOUIPanelDragListener2 != null) {
                        if (cOUIPanelDragListener2.onDragWhileEditing()) {
                            i11 = this.fitToContentsOffset;
                        } else {
                            i11 = this.parentRootViewHeight;
                            i12 = 5;
                        }
                    } else {
                        i11 = this.collapsedOffset;
                    }
                } else {
                    int top3 = v10.getTop();
                    if (Math.abs(top3 - this.halfExpandedOffset) < Math.abs(top3 - this.collapsedOffset)) {
                        i11 = this.halfExpandedOffset;
                        i12 = 6;
                    } else {
                        i11 = this.collapsedOffset;
                    }
                }
                i12 = 4;
            }
            startSettlingAnimation(v10, i12, i11, false);
            this.nestedScrolled = false;
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
        if (!v10.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.state == 1 && actionMasked == 0) {
            return true;
        }
        androidx.customview.widget.c cVar = this.viewDragHelper;
        if (cVar != null) {
            try {
                cVar.G(motionEvent);
            } catch (Exception e10) {
                e10.printStackTrace();
                return true;
            }
        }
        if (actionMasked == 0) {
            reset();
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        if (actionMasked == 2 && !this.ignoreEvents && this.viewDragHelper != null && Math.abs(this.initialY - motionEvent.getY()) > this.viewDragHelper.A()) {
            this.viewDragHelper.c(v10, motionEvent.getPointerId(UIUtil.getAdjustmentPointerIndex(motionEvent, motionEvent.getActionIndex())));
        }
        return !this.ignoreEvents;
    }

    public void removeBottomSheetCallback(COUIBottomSheetCallback cOUIBottomSheetCallback) {
        this.callbacks.remove(cOUIBottomSheetCallback);
    }

    @Deprecated
    public void setBottomSheetCallback(COUIBottomSheetCallback cOUIBottomSheetCallback) {
        if (DEBUG) {
            Log.w(TAG, "BottomSheetBehavior now supports multiple callbacks. `setBottomSheetCallback()` removes all existing callbacks, including ones set internally by library authors, which may result in unintended behavior. This may change in the future. Please use `addBottomSheetCallback()` and `removeBottomSheetCallback()` instead to set your own callbacks.");
        }
        this.callbacks.clear();
        if (cOUIBottomSheetCallback != null) {
            this.callbacks.add(cOUIBottomSheetCallback);
        }
    }

    public void setCanHideKeyboard(boolean z10) {
        this.mCanHideKeyboard = z10;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public void setDraggable(boolean z10) {
        this.draggable = z10;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public void setExpandedOffset(int i10) {
        if (i10 >= 0) {
            this.expandedOffset = i10;
            return;
        }
        throw new IllegalArgumentException("offset must be greater than or equal to 0");
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
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
        updateAccessibilityActions();
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public void setGestureInsetBottomIgnored(boolean z10) {
        this.gestureInsetBottomIgnored = z10;
    }

    public void setGlobalDrag(boolean z10) {
        this.mGlobalDrag = z10;
    }

    public void setHalfExpandOffsetUseParentRootViewHeight(boolean z10) {
        this.mHalfExpandOffsetUseParentRootViewHeight = z10;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
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

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public void setHideable(boolean z10) {
        if (this.hideable != z10) {
            this.hideable = z10;
            if (!z10 && this.state == 5) {
                setPanelState(4);
            }
            updateAccessibilityActions();
        }
    }

    public void setIsHandlePanel(boolean z10) {
        this.mIsHandlePanel = z10;
    }

    public void setIsInTinyScreen(boolean z10) {
        this.mIsInTinyScreen = z10;
    }

    public void setPanelDragListener(COUIPanelDragListener cOUIPanelDragListener) {
        this.mCOUIPanelDragListener = cOUIPanelDragListener;
    }

    public void setPanelPeekHeight(int i10) {
        setPanelPeekHeight(i10, false);
    }

    public void setPanelSkipCollapsed(boolean z10) {
        this.skipCollapsed = z10;
    }

    public void setPanelState(int i10) {
        if (i10 == this.state) {
            return;
        }
        if (this.viewRef == null) {
            if (i10 == 4 || i10 == 3 || i10 == 6 || (this.hideable && i10 == 5)) {
                this.state = i10;
                return;
            }
            return;
        }
        settleToStatePendingLayout(i10);
    }

    public void setPullUpListener(COUIPanelPullUpListener cOUIPanelPullUpListener) {
        this.mPullUpListener = cOUIPanelPullUpListener;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public void setSaveFlags(int i10) {
        this.saveFlags = i10;
    }

    public void setStateInternal(int i10) {
        V v10;
        if (this.state == i10) {
            return;
        }
        this.state = i10;
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference == null || (v10 = weakReference.get()) == null) {
            return;
        }
        if (i10 == 3) {
            updateImportantForAccessibility(true);
        } else if (i10 == 6 || i10 == 5 || i10 == 4) {
            updateImportantForAccessibility(false);
        }
        updateDrawableForTargetState(i10);
        for (int i11 = 0; i11 < this.callbacks.size(); i11++) {
            this.callbacks.get(i11).onStateChanged(v10, i10);
        }
        updateAccessibilityActions();
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public void setUpdateImportantForAccessibilityOnSiblings(boolean z10) {
        this.updateImportantForAccessibilityOnSiblings = z10;
    }

    public void settleToState(View view, int i10) {
        int i11;
        int i12;
        if (i10 == 4) {
            i11 = this.collapsedOffset;
        } else if (i10 == 6) {
            i11 = this.halfExpandedOffset;
            if (this.fitToContents && i11 <= (i12 = this.fitToContentsOffset)) {
                i10 = 3;
                i11 = i12;
            }
        } else if (i10 == 3) {
            i11 = getExpandedOffset();
        } else if (this.hideable && i10 == 5) {
            i11 = this.parentRootViewHeight;
        } else {
            throw new IllegalArgumentException("Illegal state argument: " + i10);
        }
        startSettlingAnimation(view, i10, i11, false);
    }

    public boolean shouldHide(View view, float f10) {
        if (this.skipCollapsed) {
            return true;
        }
        if (view.getTop() < this.collapsedOffset) {
            return false;
        }
        if (Math.abs((view.getTop() + (f10 * 0.1f)) - this.collapsedOffset) / calculatePeekHeight() > 0.5f) {
            return true;
        }
        return false;
    }

    public void startSettlingAnimation(View view, int i10, int i11, boolean z10) {
        boolean R10;
        if (z10 && getState() == 1) {
            R10 = this.viewDragHelper.P(view.getLeft(), i11);
        } else {
            R10 = this.viewDragHelper.R(view, view.getLeft(), i11);
        }
        if (R10) {
            setStateInternal(2);
            updateDrawableForTargetState(i10);
            float yVelocity = getYVelocity();
            if (this.mIsInTinyScreen) {
                if (i10 == 5) {
                    startPanelTranslateAnimation(view, 0, this.mContext.getResources().getDimensionPixelOffset(C0572d.f12901x), DEFAULT_TRANSLATE_HIDING_ANIMATOR_DURATION, new COUIOutEaseInterpolator());
                    return;
                } else {
                    startSettleRunnable(view, i10);
                    return;
                }
            }
            if (i10 == 5 && yVelocity > 10000.0f) {
                startDragToHiddenAnimation(view);
                return;
            } else {
                startSettleRunnable(view, i10);
                return;
            }
        }
        setStateInternal(i10);
    }

    private void createMaterialShapeDrawable(Context context, AttributeSet attributeSet, boolean z10, ColorStateList colorStateList) {
        if (this.shapeThemingEnabled) {
            this.shapeAppearanceModelDefault = n.e(context, attributeSet, C0977c.f30669h, DEF_STYLE_RES).m();
            i iVar = new i(this.shapeAppearanceModelDefault);
            this.materialShapeDrawable = iVar;
            iVar.initializeElevationOverlay(context);
            if (z10 && colorStateList != null) {
                this.materialShapeDrawable.setFillColor(colorStateList);
                return;
            }
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.colorBackground, typedValue, true);
            this.materialShapeDrawable.setTint(typedValue.data);
        }
    }

    private void setPanelPeekHeight(int i10, boolean z10) {
        V v10;
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
        if (this.viewRef != null) {
            calculateCollapsedOffset();
            if (this.state != 4 || (v10 = this.viewRef.get()) == null) {
                return;
            }
            if (z10) {
                settleToStatePendingLayout(this.state);
            } else {
                v10.requestLayout();
            }
        }
    }

    public void onAnimationCancel(i8.c cVar) {
    }

    @Override // i8.InterfaceC1105a
    public void onAnimationEnd(i8.c cVar) {
    }

    @Override // i8.InterfaceC1105a
    public void onAnimationStart(i8.c cVar) {
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v10, View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
    }
}
