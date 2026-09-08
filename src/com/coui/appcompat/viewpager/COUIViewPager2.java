package com.coui.appcompat.viewpager;

import J.d;
import J.g;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.core.view.K;
import androidx.recyclerview.widget.COUIRecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.o;
import androidx.recyclerview.widget.t;
import androidx.viewpager2.adapter.a;
import androidx.viewpager2.widget.ViewPager2;
import com.coui.appcompat.scroll.COUlFrameRateScrollSceneHelper;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import m0.C1302a;

/* loaded from: classes3.dex */
public class COUIViewPager2 extends ViewGroup {
    private static final int DEFAULT_VIEWPAGER_INTERACTING_NESTED_SCROLL_VELOCITY_THRESHOLD = 500;
    public static final int OFFSCREEN_PAGE_LIMIT_DEFAULT = -1;
    public static final int ORIENTATION_HORIZONTAL = 0;
    public static final int ORIENTATION_VERTICAL = 1;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    static boolean sFeatureEnhancedA11yEnabled = true;
    AccessibilityProvider mAccessibilityProvider;
    int mCurrentItem;
    private RecyclerView.i mCurrentItemDataSetChangeObserver;
    boolean mCurrentItemDirty;
    private int mDuration;
    private COUICompositeOnPageChangeCallback mExternalPageChangeCallbacks;
    private COUIFakeDrag mFakeDragger;
    private COUlFrameRateScrollSceneHelper mFrameRateHelper;
    private Interpolator mInterpolator;
    private LinearLayoutManager mLayoutManager;
    private int mOffscreenPageLimit;
    private COUICompositeOnPageChangeCallback mPageChangeEventDispatcher;
    private COUIPageTransformerAdapter mPageTransformerAdapter;
    private t mPagerSnapHelper;
    private Parcelable mPendingAdapterState;
    private int mPendingCurrentItem;
    RecyclerViewImpl mRecyclerView;
    private RecyclerView.l mSavedItemAnimator;
    private boolean mSavedItemAnimatorPresent;
    COUIScrollEventAdapter mScrollEventAdapter;
    private final Rect mTmpChildRect;
    private final Rect mTmpContainerRect;
    private boolean mUserInputEnabled;

    /* loaded from: classes3.dex */
    public class BasicAccessibilityProvider extends AccessibilityProvider {
        public BasicAccessibilityProvider() {
            super();
        }

        @Override // com.coui.appcompat.viewpager.COUIViewPager2.AccessibilityProvider
        public boolean handlesLmPerformAccessibilityAction(int i10) {
            if ((i10 == 8192 || i10 == 4096) && !COUIViewPager2.this.isUserInputEnabled()) {
                return true;
            }
            return false;
        }

        @Override // com.coui.appcompat.viewpager.COUIViewPager2.AccessibilityProvider
        public boolean handlesRvGetAccessibilityClassName() {
            return true;
        }

        @Override // com.coui.appcompat.viewpager.COUIViewPager2.AccessibilityProvider
        public void onLmInitializeAccessibilityNodeInfo(d dVar) {
            if (!COUIViewPager2.this.isUserInputEnabled()) {
                dVar.a0(d.a.f1403r);
                dVar.a0(d.a.f1402q);
                dVar.E0(false);
            }
        }

        @Override // com.coui.appcompat.viewpager.COUIViewPager2.AccessibilityProvider
        public boolean onLmPerformAccessibilityAction(int i10) {
            if (handlesLmPerformAccessibilityAction(i10)) {
                return false;
            }
            throw new IllegalStateException();
        }

        @Override // com.coui.appcompat.viewpager.COUIViewPager2.AccessibilityProvider
        public CharSequence onRvGetAccessibilityClassName() {
            if (handlesRvGetAccessibilityClassName()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class DataSetChangeObserver extends RecyclerView.i {
        private DataSetChangeObserver() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public abstract void onChanged();

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public final void onItemRangeChanged(int i10, int i11) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public final void onItemRangeInserted(int i10, int i11) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public final void onItemRangeMoved(int i10, int i11, int i12) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public final void onItemRangeRemoved(int i10, int i11) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public final void onItemRangeChanged(int i10, int i11, Object obj) {
            onChanged();
        }
    }

    /* loaded from: classes3.dex */
    public class LinearLayoutManagerImpl extends LinearLayoutManager {
        public LinearLayoutManagerImpl(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public void calculateExtraLayoutSpace(RecyclerView.y yVar, int[] iArr) {
            int offscreenPageLimit = COUIViewPager2.this.getOffscreenPageLimit();
            if (offscreenPageLimit == -1) {
                super.calculateExtraLayoutSpace(yVar, iArr);
                return;
            }
            int pageSize = COUIViewPager2.this.getPageSize() * offscreenPageLimit;
            iArr[0] = pageSize;
            iArr[1] = pageSize;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.o
        public void onInitializeAccessibilityNodeInfo(RecyclerView.u uVar, RecyclerView.y yVar, d dVar) {
            super.onInitializeAccessibilityNodeInfo(uVar, yVar, dVar);
            COUIViewPager2.this.mAccessibilityProvider.onLmInitializeAccessibilityNodeInfo(dVar);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.o
        public void onScrollStateChanged(int i10) {
            super.onScrollStateChanged(i10);
            if (i10 == 0) {
                COUIViewPager2.this.mFrameRateHelper.setFrameRate(false);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.o
        public boolean performAccessibilityAction(RecyclerView.u uVar, RecyclerView.y yVar, int i10, Bundle bundle) {
            if (COUIViewPager2.this.mAccessibilityProvider.handlesLmPerformAccessibilityAction(i10)) {
                return COUIViewPager2.this.mAccessibilityProvider.onLmPerformAccessibilityAction(i10);
            }
            return super.performAccessibilityAction(uVar, yVar, i10, bundle);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.o
        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z10, boolean z11) {
            return false;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
        public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.y yVar, int i10) {
            LinearSmoothScrollerImpl linearSmoothScrollerImpl = new LinearSmoothScrollerImpl(recyclerView.getContext());
            linearSmoothScrollerImpl.setTargetPosition(i10);
            startSmoothScroll(linearSmoothScrollerImpl);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.o
        public void startSmoothScroll(RecyclerView.x xVar) {
            super.startSmoothScroll(xVar);
            COUIViewPager2.this.mFrameRateHelper.setFrameRate(true);
        }
    }

    /* loaded from: classes3.dex */
    public class LinearSmoothScrollerImpl extends o {
        public LinearSmoothScrollerImpl(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.o, androidx.recyclerview.widget.RecyclerView.x
        public void onTargetFound(View view, RecyclerView.y yVar, RecyclerView.x.a aVar) {
            int calculateDxToMakeVisible = calculateDxToMakeVisible(view, getHorizontalSnapPreference());
            int calculateDyToMakeVisible = calculateDyToMakeVisible(view, getVerticalSnapPreference());
            if (calculateTimeForDeceleration((int) Math.sqrt((calculateDxToMakeVisible * calculateDxToMakeVisible) + (calculateDyToMakeVisible * calculateDyToMakeVisible))) > 0) {
                aVar.d(-calculateDxToMakeVisible, -calculateDyToMakeVisible, COUIViewPager2.this.mDuration, COUIViewPager2.this.mInterpolator);
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface OffscreenPageLimit {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface Orientation {
    }

    /* loaded from: classes3.dex */
    public class PageAwareAccessibilityProvider extends AccessibilityProvider {
        private final g mActionPageBackward;
        private final g mActionPageForward;
        private RecyclerView.i mAdapterDataObserver;

        public PageAwareAccessibilityProvider() {
            super();
            this.mActionPageForward = new g() { // from class: com.coui.appcompat.viewpager.COUIViewPager2.PageAwareAccessibilityProvider.1
                @Override // J.g
                public boolean perform(View view, g.a aVar) {
                    PageAwareAccessibilityProvider.this.setCurrentItemFromAccessibilityCommand(((COUIViewPager2) view).getCurrentItem() + 1);
                    return true;
                }
            };
            this.mActionPageBackward = new g() { // from class: com.coui.appcompat.viewpager.COUIViewPager2.PageAwareAccessibilityProvider.2
                @Override // J.g
                public boolean perform(View view, g.a aVar) {
                    PageAwareAccessibilityProvider.this.setCurrentItemFromAccessibilityCommand(((COUIViewPager2) view).getCurrentItem() - 1);
                    return true;
                }
            };
        }

        private void addCollectionInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            int i10;
            int i11;
            if (COUIViewPager2.this.getAdapter() != null) {
                if (COUIViewPager2.this.getOrientation() == 1) {
                    i10 = COUIViewPager2.this.getAdapter().getItemCount();
                    i11 = 0;
                } else {
                    i11 = COUIViewPager2.this.getAdapter().getItemCount();
                    i10 = 0;
                }
            } else {
                i10 = 0;
                i11 = 0;
            }
            d.O0(accessibilityNodeInfo).j0(d.e.b(i10, i11, false, 0));
        }

        private void addScrollActions(AccessibilityNodeInfo accessibilityNodeInfo) {
            int itemCount;
            RecyclerView.Adapter adapter = COUIViewPager2.this.getAdapter();
            if (adapter != null && (itemCount = adapter.getItemCount()) != 0 && COUIViewPager2.this.isUserInputEnabled()) {
                if (COUIViewPager2.this.mCurrentItem > 0) {
                    accessibilityNodeInfo.addAction(8192);
                }
                if (COUIViewPager2.this.mCurrentItem < itemCount - 1) {
                    accessibilityNodeInfo.addAction(4096);
                }
                accessibilityNodeInfo.setScrollable(true);
            }
        }

        @Override // com.coui.appcompat.viewpager.COUIViewPager2.AccessibilityProvider
        public boolean handlesGetAccessibilityClassName() {
            return true;
        }

        @Override // com.coui.appcompat.viewpager.COUIViewPager2.AccessibilityProvider
        public boolean handlesPerformAccessibilityAction(int i10, Bundle bundle) {
            if (i10 != 8192 && i10 != 4096) {
                return false;
            }
            return true;
        }

        @Override // com.coui.appcompat.viewpager.COUIViewPager2.AccessibilityProvider
        public void onAttachAdapter(RecyclerView.Adapter<?> adapter) {
            updatePageAccessibilityActions();
            if (adapter != null) {
                adapter.registerAdapterDataObserver(this.mAdapterDataObserver);
            }
        }

        @Override // com.coui.appcompat.viewpager.COUIViewPager2.AccessibilityProvider
        public void onDetachAdapter(RecyclerView.Adapter<?> adapter) {
            if (adapter != null) {
                adapter.unregisterAdapterDataObserver(this.mAdapterDataObserver);
            }
        }

        @Override // com.coui.appcompat.viewpager.COUIViewPager2.AccessibilityProvider
        public String onGetAccessibilityClassName() {
            if (handlesGetAccessibilityClassName()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }

        @Override // com.coui.appcompat.viewpager.COUIViewPager2.AccessibilityProvider
        public void onInitialize(COUICompositeOnPageChangeCallback cOUICompositeOnPageChangeCallback, RecyclerView recyclerView) {
            K.t0(recyclerView, 2);
            this.mAdapterDataObserver = new DataSetChangeObserver() { // from class: com.coui.appcompat.viewpager.COUIViewPager2.PageAwareAccessibilityProvider.3
                @Override // com.coui.appcompat.viewpager.COUIViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.i
                public void onChanged() {
                    PageAwareAccessibilityProvider.this.updatePageAccessibilityActions();
                }
            };
            if (K.t(COUIViewPager2.this) == 0) {
                K.t0(COUIViewPager2.this, 1);
            }
        }

        @Override // com.coui.appcompat.viewpager.COUIViewPager2.AccessibilityProvider
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            addCollectionInfo(accessibilityNodeInfo);
            addScrollActions(accessibilityNodeInfo);
        }

        @Override // com.coui.appcompat.viewpager.COUIViewPager2.AccessibilityProvider
        public boolean onPerformAccessibilityAction(int i10, Bundle bundle) {
            int currentItem;
            if (handlesPerformAccessibilityAction(i10, bundle)) {
                if (i10 == 8192) {
                    currentItem = COUIViewPager2.this.getCurrentItem() - 1;
                } else {
                    currentItem = COUIViewPager2.this.getCurrentItem() + 1;
                }
                setCurrentItemFromAccessibilityCommand(currentItem);
                return true;
            }
            throw new IllegalStateException();
        }

        @Override // com.coui.appcompat.viewpager.COUIViewPager2.AccessibilityProvider
        public void onRestorePendingState() {
            updatePageAccessibilityActions();
        }

        @Override // com.coui.appcompat.viewpager.COUIViewPager2.AccessibilityProvider
        public void onRvInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setSource(COUIViewPager2.this);
            accessibilityEvent.setClassName(onGetAccessibilityClassName());
        }

        @Override // com.coui.appcompat.viewpager.COUIViewPager2.AccessibilityProvider
        public void onSetLayoutDirection() {
            updatePageAccessibilityActions();
        }

        @Override // com.coui.appcompat.viewpager.COUIViewPager2.AccessibilityProvider
        public void onSetNewCurrentItem() {
            updatePageAccessibilityActions();
        }

        @Override // com.coui.appcompat.viewpager.COUIViewPager2.AccessibilityProvider
        public void onSetOrientation() {
            updatePageAccessibilityActions();
        }

        @Override // com.coui.appcompat.viewpager.COUIViewPager2.AccessibilityProvider
        public void onSetUserInputEnabled() {
            updatePageAccessibilityActions();
        }

        public void setCurrentItemFromAccessibilityCommand(int i10) {
            if (COUIViewPager2.this.isUserInputEnabled()) {
                COUIViewPager2.this.setCurrentItemInternal(i10, true);
            }
        }

        public void updatePageAccessibilityActions() {
            int itemCount;
            int i10;
            COUIViewPager2 cOUIViewPager2 = COUIViewPager2.this;
            int i11 = R.id.accessibilityActionPageLeft;
            K.c0(cOUIViewPager2, R.id.accessibilityActionPageLeft);
            K.c0(cOUIViewPager2, R.id.accessibilityActionPageRight);
            K.c0(cOUIViewPager2, R.id.accessibilityActionPageUp);
            K.c0(cOUIViewPager2, R.id.accessibilityActionPageDown);
            if (COUIViewPager2.this.getAdapter() == null || (itemCount = COUIViewPager2.this.getAdapter().getItemCount()) == 0 || !COUIViewPager2.this.isUserInputEnabled()) {
                return;
            }
            if (COUIViewPager2.this.getOrientation() == 0) {
                boolean isRtl = COUIViewPager2.this.isRtl();
                if (isRtl) {
                    i10 = 16908360;
                } else {
                    i10 = 16908361;
                }
                if (isRtl) {
                    i11 = 16908361;
                }
                if (COUIViewPager2.this.mCurrentItem < itemCount - 1) {
                    K.e0(cOUIViewPager2, new d.a(i10, null), null, this.mActionPageForward);
                }
                if (COUIViewPager2.this.mCurrentItem > 0) {
                    K.e0(cOUIViewPager2, new d.a(i11, null), null, this.mActionPageBackward);
                    return;
                }
                return;
            }
            if (COUIViewPager2.this.mCurrentItem < itemCount - 1) {
                K.e0(cOUIViewPager2, new d.a(R.id.accessibilityActionPageDown, null), null, this.mActionPageForward);
            }
            if (COUIViewPager2.this.mCurrentItem > 0) {
                K.e0(cOUIViewPager2, new d.a(R.id.accessibilityActionPageUp, null), null, this.mActionPageBackward);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class PagerSnapHelperImpl extends t {
        public PagerSnapHelperImpl() {
        }

        @Override // androidx.recyclerview.widget.t, androidx.recyclerview.widget.x
        public View findSnapView(RecyclerView.o oVar) {
            if (COUIViewPager2.this.isFakeDragging()) {
                return null;
            }
            return super.findSnapView(oVar);
        }
    }

    /* loaded from: classes3.dex */
    public class RecyclerViewImpl extends COUIRecyclerView {
        public RecyclerViewImpl(Context context) {
            super(context);
            super.setDispatchEventWhileOverScrolling(true);
            setDispatchEventWhileScrollingThreshold(COUIViewPager2.DEFAULT_VIEWPAGER_INTERACTING_NESTED_SCROLL_VELOCITY_THRESHOLD);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
        public CharSequence getAccessibilityClassName() {
            if (COUIViewPager2.this.mAccessibilityProvider.handlesRvGetAccessibilityClassName()) {
                return COUIViewPager2.this.mAccessibilityProvider.onRvGetAccessibilityClassName();
            }
            return super.getAccessibilityClassName();
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setFromIndex(COUIViewPager2.this.mCurrentItem);
            accessibilityEvent.setToIndex(COUIViewPager2.this.mCurrentItem);
            COUIViewPager2.this.mAccessibilityProvider.onRvInitializeAccessibilityEvent(accessibilityEvent);
        }

        @Override // androidx.recyclerview.widget.COUIRecyclerView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (COUIViewPager2.this.isUserInputEnabled() && super.onInterceptTouchEvent(motionEvent)) {
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.COUIRecyclerView, androidx.recyclerview.widget.RecyclerView, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (COUIViewPager2.this.isUserInputEnabled() && super.onTouchEvent(motionEvent)) {
                return true;
            }
            return false;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface ScrollState {
    }

    /* loaded from: classes3.dex */
    public static class SmoothScrollToPosition implements Runnable {
        private final int mPosition;
        private final RecyclerView mRecyclerView;

        public SmoothScrollToPosition(int i10, RecyclerView recyclerView) {
            this.mPosition = i10;
            this.mRecyclerView = recyclerView;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mRecyclerView.smoothScrollToPosition(this.mPosition);
        }
    }

    public COUIViewPager2(Context context) {
        super(context);
        this.mTmpContainerRect = new Rect();
        this.mTmpChildRect = new Rect();
        this.mExternalPageChangeCallbacks = new COUICompositeOnPageChangeCallback(3);
        this.mCurrentItemDirty = false;
        this.mCurrentItemDataSetChangeObserver = new DataSetChangeObserver() { // from class: com.coui.appcompat.viewpager.COUIViewPager2.1
            @Override // com.coui.appcompat.viewpager.COUIViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.i
            public void onChanged() {
                COUIViewPager2 cOUIViewPager2 = COUIViewPager2.this;
                cOUIViewPager2.mCurrentItemDirty = true;
                cOUIViewPager2.mScrollEventAdapter.notifyDataSetChangeHappened();
            }
        };
        this.mPendingCurrentItem = -1;
        this.mSavedItemAnimator = null;
        this.mSavedItemAnimatorPresent = false;
        this.mUserInputEnabled = true;
        this.mOffscreenPageLimit = -1;
        this.mInterpolator = new LinearInterpolator();
        this.mDuration = DEFAULT_VIEWPAGER_INTERACTING_NESTED_SCROLL_VELOCITY_THRESHOLD;
        initialize(context, null);
    }

    private RecyclerView.p enforceChildFillListener() {
        return new RecyclerView.p() { // from class: com.coui.appcompat.viewpager.COUIViewPager2.4
            @Override // androidx.recyclerview.widget.RecyclerView.p
            public void onChildViewAttachedToWindow(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                if (((ViewGroup.MarginLayoutParams) layoutParams).width == -1 && ((ViewGroup.MarginLayoutParams) layoutParams).height == -1) {
                } else {
                    throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.p
            public void onChildViewDetachedFromWindow(View view) {
            }
        };
    }

    private void initialize(Context context, AttributeSet attributeSet) {
        AccessibilityProvider basicAccessibilityProvider;
        if (sFeatureEnhancedA11yEnabled) {
            basicAccessibilityProvider = new PageAwareAccessibilityProvider();
        } else {
            basicAccessibilityProvider = new BasicAccessibilityProvider();
        }
        this.mAccessibilityProvider = basicAccessibilityProvider;
        RecyclerViewImpl recyclerViewImpl = new RecyclerViewImpl(context);
        this.mRecyclerView = recyclerViewImpl;
        recyclerViewImpl.setId(K.i());
        this.mRecyclerView.setDescendantFocusability(131072);
        LinearLayoutManagerImpl linearLayoutManagerImpl = new LinearLayoutManagerImpl(context);
        this.mLayoutManager = linearLayoutManagerImpl;
        this.mRecyclerView.setLayoutManager(linearLayoutManagerImpl);
        this.mRecyclerView.setScrollingTouchSlop(1);
        setOrientation(context, attributeSet);
        this.mRecyclerView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.mRecyclerView.addOnChildAttachStateChangeListener(enforceChildFillListener());
        COUIScrollEventAdapter cOUIScrollEventAdapter = new COUIScrollEventAdapter(this);
        this.mScrollEventAdapter = cOUIScrollEventAdapter;
        this.mFakeDragger = new COUIFakeDrag(this, cOUIScrollEventAdapter, this.mRecyclerView);
        PagerSnapHelperImpl pagerSnapHelperImpl = new PagerSnapHelperImpl();
        this.mPagerSnapHelper = pagerSnapHelperImpl;
        pagerSnapHelperImpl.attachToRecyclerView(this.mRecyclerView);
        this.mRecyclerView.addOnScrollListener(this.mScrollEventAdapter);
        COUICompositeOnPageChangeCallback cOUICompositeOnPageChangeCallback = new COUICompositeOnPageChangeCallback(3);
        this.mPageChangeEventDispatcher = cOUICompositeOnPageChangeCallback;
        this.mScrollEventAdapter.setOnPageChangeCallback(cOUICompositeOnPageChangeCallback);
        ViewPager2.i iVar = new ViewPager2.i() { // from class: com.coui.appcompat.viewpager.COUIViewPager2.2
            @Override // androidx.viewpager2.widget.ViewPager2.i
            public void onPageScrollStateChanged(int i10) {
                if (i10 == 0) {
                    COUIViewPager2.this.updateCurrentItem();
                }
            }

            @Override // androidx.viewpager2.widget.ViewPager2.i
            public void onPageSelected(int i10) {
                COUIViewPager2 cOUIViewPager2 = COUIViewPager2.this;
                if (cOUIViewPager2.mCurrentItem != i10) {
                    cOUIViewPager2.mCurrentItem = i10;
                    cOUIViewPager2.mAccessibilityProvider.onSetNewCurrentItem();
                }
            }
        };
        ViewPager2.i iVar2 = new ViewPager2.i() { // from class: com.coui.appcompat.viewpager.COUIViewPager2.3
            @Override // androidx.viewpager2.widget.ViewPager2.i
            public void onPageSelected(int i10) {
                COUIViewPager2.this.clearFocus();
                if (COUIViewPager2.this.hasFocus()) {
                    COUIViewPager2.this.mRecyclerView.requestFocus(2);
                }
            }
        };
        this.mPageChangeEventDispatcher.addOnPageChangeCallback(iVar);
        this.mPageChangeEventDispatcher.addOnPageChangeCallback(iVar2);
        this.mAccessibilityProvider.onInitialize(this.mPageChangeEventDispatcher, this.mRecyclerView);
        this.mPageChangeEventDispatcher.addOnPageChangeCallback(this.mExternalPageChangeCallbacks);
        COUIPageTransformerAdapter cOUIPageTransformerAdapter = new COUIPageTransformerAdapter(this.mLayoutManager);
        this.mPageTransformerAdapter = cOUIPageTransformerAdapter;
        this.mPageChangeEventDispatcher.addOnPageChangeCallback(cOUIPageTransformerAdapter);
        RecyclerViewImpl recyclerViewImpl2 = this.mRecyclerView;
        attachViewToParent(recyclerViewImpl2, 0, recyclerViewImpl2.getLayoutParams());
        this.mFrameRateHelper = new COUlFrameRateScrollSceneHelper(true);
    }

    private void registerCurrentItemDataSetTracker(RecyclerView.Adapter<?> adapter) {
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.mCurrentItemDataSetChangeObserver);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void restorePendingState() {
        RecyclerView.Adapter adapter;
        if (this.mPendingCurrentItem == -1 || (adapter = getAdapter()) == 0) {
            return;
        }
        Parcelable parcelable = this.mPendingAdapterState;
        if (parcelable != null) {
            if (adapter instanceof a) {
                ((a) adapter).restoreState(parcelable);
            }
            this.mPendingAdapterState = null;
        }
        int max = Math.max(0, Math.min(this.mPendingCurrentItem, adapter.getItemCount() - 1));
        this.mCurrentItem = max;
        this.mPendingCurrentItem = -1;
        this.mRecyclerView.scrollToPosition(max);
        this.mAccessibilityProvider.onRestorePendingState();
    }

    private void setOrientation(Context context, AttributeSet attributeSet) {
        int[] iArr = C1302a.f34798g;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        saveAttributeDataForStyleable(context, iArr, attributeSet, obtainStyledAttributes, 0, 0);
        try {
            setOrientation(obtainStyledAttributes.getInt(C1302a.f34799h, 0));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void unregisterCurrentItemDataSetTracker(RecyclerView.Adapter<?> adapter) {
        if (adapter != null) {
            adapter.unregisterAdapterDataObserver(this.mCurrentItemDataSetChangeObserver);
        }
    }

    public void addItemDecoration(RecyclerView.n nVar) {
        this.mRecyclerView.addItemDecoration(nVar);
    }

    public boolean beginFakeDrag() {
        return this.mFakeDragger.beginFakeDrag();
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i10) {
        return this.mRecyclerView.canScrollHorizontally(i10);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i10) {
        return this.mRecyclerView.canScrollVertically(i10);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        Parcelable parcelable = sparseArray.get(getId());
        if (parcelable instanceof SavedState) {
            int i10 = ((SavedState) parcelable).mRecyclerViewId;
            sparseArray.put(this.mRecyclerView.getId(), sparseArray.get(i10));
            sparseArray.remove(i10);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        restorePendingState();
    }

    public void enableFrameRate(boolean z10) {
        this.mFrameRateHelper.enableFrameRate(z10);
    }

    public boolean endFakeDrag() {
        return this.mFakeDragger.endFakeDrag();
    }

    public boolean fakeDragBy(float f10) {
        return this.mFakeDragger.fakeDragBy(f10);
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        if (this.mAccessibilityProvider.handlesGetAccessibilityClassName()) {
            return this.mAccessibilityProvider.onGetAccessibilityClassName();
        }
        return super.getAccessibilityClassName();
    }

    public RecyclerView.Adapter getAdapter() {
        return this.mRecyclerView.getAdapter();
    }

    public int getCurrentItem() {
        return this.mCurrentItem;
    }

    public int getDuration() {
        return this.mDuration;
    }

    public Interpolator getInterpolator() {
        return this.mInterpolator;
    }

    public RecyclerView.n getItemDecorationAt(int i10) {
        return this.mRecyclerView.getItemDecorationAt(i10);
    }

    public int getItemDecorationCount() {
        return this.mRecyclerView.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public int getOrientation() {
        return this.mLayoutManager.getOrientation();
    }

    public int getPageSize() {
        int height;
        int paddingBottom;
        RecyclerViewImpl recyclerViewImpl = this.mRecyclerView;
        if (getOrientation() == 0) {
            height = recyclerViewImpl.getWidth() - recyclerViewImpl.getPaddingLeft();
            paddingBottom = recyclerViewImpl.getPaddingRight();
        } else {
            height = recyclerViewImpl.getHeight() - recyclerViewImpl.getPaddingTop();
            paddingBottom = recyclerViewImpl.getPaddingBottom();
        }
        return height - paddingBottom;
    }

    public int getScrollState() {
        return this.mScrollEventAdapter.getScrollState();
    }

    public void invalidateItemDecorations() {
        this.mRecyclerView.invalidateItemDecorations();
    }

    public boolean isFakeDragging() {
        return this.mFakeDragger.isFakeDragging();
    }

    public boolean isRtl() {
        if (this.mLayoutManager.getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    public boolean isUserInputEnabled() {
        return this.mUserInputEnabled;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        this.mAccessibilityProvider.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int measuredWidth = this.mRecyclerView.getMeasuredWidth();
        int measuredHeight = this.mRecyclerView.getMeasuredHeight();
        this.mTmpContainerRect.left = getPaddingLeft();
        this.mTmpContainerRect.right = (i12 - i10) - getPaddingRight();
        this.mTmpContainerRect.top = getPaddingTop();
        this.mTmpContainerRect.bottom = (i13 - i11) - getPaddingBottom();
        Gravity.apply(8388659, measuredWidth, measuredHeight, this.mTmpContainerRect, this.mTmpChildRect);
        RecyclerViewImpl recyclerViewImpl = this.mRecyclerView;
        Rect rect = this.mTmpChildRect;
        recyclerViewImpl.layout(rect.left, rect.top, rect.right, rect.bottom);
        if (this.mCurrentItemDirty) {
            updateCurrentItem();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        measureChild(this.mRecyclerView, i10, i11);
        int measuredWidth = this.mRecyclerView.getMeasuredWidth();
        int measuredHeight = this.mRecyclerView.getMeasuredHeight();
        int measuredState = this.mRecyclerView.getMeasuredState();
        int paddingLeft = measuredWidth + getPaddingLeft() + getPaddingRight();
        int paddingTop = measuredHeight + getPaddingTop() + getPaddingBottom();
        setMeasuredDimension(View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i10, measuredState), View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i11, measuredState << 16));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mPendingCurrentItem = savedState.mCurrentItem;
        this.mPendingAdapterState = savedState.mAdapterState;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.mRecyclerViewId = this.mRecyclerView.getId();
        int i10 = this.mPendingCurrentItem;
        if (i10 == -1) {
            i10 = this.mCurrentItem;
        }
        savedState.mCurrentItem = i10;
        Parcelable parcelable = this.mPendingAdapterState;
        if (parcelable != null) {
            savedState.mAdapterState = parcelable;
        } else {
            Object adapter = this.mRecyclerView.getAdapter();
            if (adapter instanceof a) {
                savedState.mAdapterState = ((a) adapter).saveState();
            }
        }
        return savedState;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        throw new IllegalStateException(getClass().getSimpleName() + " does not support direct child views");
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i10, Bundle bundle) {
        if (this.mAccessibilityProvider.handlesPerformAccessibilityAction(i10, bundle)) {
            return this.mAccessibilityProvider.onPerformAccessibilityAction(i10, bundle);
        }
        return super.performAccessibilityAction(i10, bundle);
    }

    public void registerOnPageChangeCallback(ViewPager2.i iVar) {
        this.mExternalPageChangeCallbacks.addOnPageChangeCallback(iVar);
    }

    public void removeItemDecoration(RecyclerView.n nVar) {
        this.mRecyclerView.removeItemDecoration(nVar);
    }

    public void removeItemDecorationAt(int i10) {
        this.mRecyclerView.removeItemDecorationAt(i10);
    }

    public void requestTransform() {
        if (this.mPageTransformerAdapter.getPageTransformer() == null) {
            return;
        }
        double relativeScrollPosition = this.mScrollEventAdapter.getRelativeScrollPosition();
        int i10 = (int) relativeScrollPosition;
        float f10 = (float) (relativeScrollPosition - i10);
        this.mPageTransformerAdapter.onPageScrolled(i10, f10, Math.round(getPageSize() * f10));
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        RecyclerView.Adapter adapter2 = this.mRecyclerView.getAdapter();
        this.mAccessibilityProvider.onDetachAdapter(adapter2);
        unregisterCurrentItemDataSetTracker(adapter2);
        this.mRecyclerView.setAdapter(adapter);
        this.mCurrentItem = 0;
        restorePendingState();
        this.mAccessibilityProvider.onAttachAdapter(adapter);
        registerCurrentItemDataSetTracker(adapter);
    }

    public void setCurrentItem(int i10) {
        setCurrentItem(i10, true);
    }

    public void setCurrentItemInternal(int i10, boolean z10) {
        int i11;
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter == null) {
            if (this.mPendingCurrentItem != -1) {
                this.mPendingCurrentItem = Math.max(i10, 0);
                return;
            }
            return;
        }
        if (adapter.getItemCount() <= 0) {
            return;
        }
        int min = Math.min(Math.max(i10, 0), adapter.getItemCount() - 1);
        if (min == this.mCurrentItem && this.mScrollEventAdapter.isIdle()) {
            return;
        }
        int i12 = this.mCurrentItem;
        if (min == i12 && z10) {
            return;
        }
        double d10 = i12;
        this.mCurrentItem = min;
        this.mAccessibilityProvider.onSetNewCurrentItem();
        if (!this.mScrollEventAdapter.isIdle()) {
            d10 = this.mScrollEventAdapter.getRelativeScrollPosition();
        }
        this.mScrollEventAdapter.notifyProgrammaticScroll(min, z10);
        if (!z10) {
            this.mRecyclerView.scrollToPosition(min);
            return;
        }
        double d11 = min;
        if (Math.abs(d11 - d10) > 3.0d) {
            RecyclerViewImpl recyclerViewImpl = this.mRecyclerView;
            if (d11 > d10) {
                i11 = min - 3;
            } else {
                i11 = min + 3;
            }
            recyclerViewImpl.scrollToPosition(i11);
            RecyclerViewImpl recyclerViewImpl2 = this.mRecyclerView;
            recyclerViewImpl2.post(new SmoothScrollToPosition(min, recyclerViewImpl2));
            return;
        }
        this.mRecyclerView.smoothScrollToPosition(min);
    }

    public void setDispatchEventWhileOverScrolling(boolean z10) {
        this.mRecyclerView.setDispatchEventWhileOverScrolling(z10);
    }

    public void setDispatchEventWhileScrolling(boolean z10) {
        RecyclerViewImpl recyclerViewImpl = this.mRecyclerView;
        if (recyclerViewImpl != null) {
            recyclerViewImpl.setDispatchEventWhileScrolling(z10);
        }
    }

    public void setDuration(int i10) {
        this.mDuration = i10;
    }

    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    @Override // android.view.View
    public void setLayoutDirection(int i10) {
        super.setLayoutDirection(i10);
        this.mAccessibilityProvider.onSetLayoutDirection();
    }

    public void setOffscreenPageLimit(int i10) {
        if (i10 < 1 && i10 != -1) {
            throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
        }
        this.mOffscreenPageLimit = i10;
        this.mRecyclerView.requestLayout();
    }

    public void setOverScrollEnable(boolean z10) {
        this.mRecyclerView.setOverScrollEnable(z10);
    }

    public void setPageTransformer(ViewPager2.k kVar) {
        if (kVar != null) {
            if (!this.mSavedItemAnimatorPresent) {
                this.mSavedItemAnimator = this.mRecyclerView.getItemAnimator();
                this.mSavedItemAnimatorPresent = true;
            }
            this.mRecyclerView.setItemAnimator(null);
        } else if (this.mSavedItemAnimatorPresent) {
            this.mRecyclerView.setItemAnimator(this.mSavedItemAnimator);
            this.mSavedItemAnimator = null;
            this.mSavedItemAnimatorPresent = false;
        }
        if (kVar == this.mPageTransformerAdapter.getPageTransformer()) {
            return;
        }
        this.mPageTransformerAdapter.setPageTransformer(kVar);
        requestTransform();
    }

    public void setUserInputEnabled(boolean z10) {
        this.mUserInputEnabled = z10;
        this.mAccessibilityProvider.onSetUserInputEnabled();
    }

    public void snapToPage() {
        View findSnapView = this.mPagerSnapHelper.findSnapView(this.mLayoutManager);
        if (findSnapView == null) {
            return;
        }
        int[] calculateDistanceToFinalSnap = this.mPagerSnapHelper.calculateDistanceToFinalSnap(this.mLayoutManager, findSnapView);
        int i10 = calculateDistanceToFinalSnap[0];
        if (i10 != 0 || calculateDistanceToFinalSnap[1] != 0) {
            this.mRecyclerView.smoothScrollBy(i10, calculateDistanceToFinalSnap[1]);
        }
    }

    public void snapToPageOpen() {
        snapToPage();
    }

    public void unregisterOnPageChangeCallback(ViewPager2.i iVar) {
        this.mExternalPageChangeCallbacks.removeOnPageChangeCallback(iVar);
    }

    public void updateCurrentItem() {
        t tVar = this.mPagerSnapHelper;
        if (tVar != null) {
            View findSnapView = tVar.findSnapView(this.mLayoutManager);
            if (findSnapView == null) {
                return;
            }
            int position = this.mLayoutManager.getPosition(findSnapView);
            if (position != this.mCurrentItem && getScrollState() == 0) {
                this.mPageChangeEventDispatcher.onPageSelected(position);
            }
            this.mCurrentItemDirty = false;
            return;
        }
        throw new IllegalStateException("Design assumption violated.");
    }

    /* loaded from: classes3.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.coui.appcompat.viewpager.COUIViewPager2.SavedState.1
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
                return createFromParcel(parcel, (ClassLoader) null);
            }
        };
        Parcelable mAdapterState;
        int mCurrentItem;
        int mRecyclerViewId;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            readValues(parcel, classLoader);
        }

        private void readValues(Parcel parcel, ClassLoader classLoader) {
            this.mRecyclerViewId = parcel.readInt();
            this.mCurrentItem = parcel.readInt();
            this.mAdapterState = parcel.readParcelable(classLoader);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.mRecyclerViewId);
            parcel.writeInt(this.mCurrentItem);
            parcel.writeParcelable(this.mAdapterState, i10);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            readValues(parcel, null);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public void addItemDecoration(RecyclerView.n nVar, int i10) {
        this.mRecyclerView.addItemDecoration(nVar, i10);
    }

    public void setCurrentItem(int i10, boolean z10) {
        if (!isFakeDragging()) {
            setCurrentItemInternal(i10, z10);
            return;
        }
        throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
    }

    public void setOrientation(int i10) {
        this.mLayoutManager.setOrientation(i10);
        this.mAccessibilityProvider.onSetOrientation();
    }

    public COUIViewPager2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTmpContainerRect = new Rect();
        this.mTmpChildRect = new Rect();
        this.mExternalPageChangeCallbacks = new COUICompositeOnPageChangeCallback(3);
        this.mCurrentItemDirty = false;
        this.mCurrentItemDataSetChangeObserver = new DataSetChangeObserver() { // from class: com.coui.appcompat.viewpager.COUIViewPager2.1
            @Override // com.coui.appcompat.viewpager.COUIViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.i
            public void onChanged() {
                COUIViewPager2 cOUIViewPager2 = COUIViewPager2.this;
                cOUIViewPager2.mCurrentItemDirty = true;
                cOUIViewPager2.mScrollEventAdapter.notifyDataSetChangeHappened();
            }
        };
        this.mPendingCurrentItem = -1;
        this.mSavedItemAnimator = null;
        this.mSavedItemAnimatorPresent = false;
        this.mUserInputEnabled = true;
        this.mOffscreenPageLimit = -1;
        this.mInterpolator = new LinearInterpolator();
        this.mDuration = DEFAULT_VIEWPAGER_INTERACTING_NESTED_SCROLL_VELOCITY_THRESHOLD;
        initialize(context, attributeSet);
    }

    /* loaded from: classes3.dex */
    public abstract class AccessibilityProvider {
        private AccessibilityProvider() {
        }

        public boolean handlesGetAccessibilityClassName() {
            return false;
        }

        public boolean handlesLmPerformAccessibilityAction(int i10) {
            return false;
        }

        public boolean handlesPerformAccessibilityAction(int i10, Bundle bundle) {
            return false;
        }

        public boolean handlesRvGetAccessibilityClassName() {
            return false;
        }

        public String onGetAccessibilityClassName() {
            throw new IllegalStateException("Not implemented.");
        }

        public boolean onLmPerformAccessibilityAction(int i10) {
            throw new IllegalStateException("Not implemented.");
        }

        public boolean onPerformAccessibilityAction(int i10, Bundle bundle) {
            throw new IllegalStateException("Not implemented.");
        }

        public CharSequence onRvGetAccessibilityClassName() {
            throw new IllegalStateException("Not implemented.");
        }

        public void onRestorePendingState() {
        }

        public void onSetLayoutDirection() {
        }

        public void onSetNewCurrentItem() {
        }

        public void onSetOrientation() {
        }

        public void onSetUserInputEnabled() {
        }

        public void onAttachAdapter(RecyclerView.Adapter<?> adapter) {
        }

        public void onDetachAdapter(RecyclerView.Adapter<?> adapter) {
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        }

        public void onLmInitializeAccessibilityNodeInfo(d dVar) {
        }

        public void onRvInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        }

        public void onInitialize(COUICompositeOnPageChangeCallback cOUICompositeOnPageChangeCallback, RecyclerView recyclerView) {
        }
    }

    public COUIViewPager2(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mTmpContainerRect = new Rect();
        this.mTmpChildRect = new Rect();
        this.mExternalPageChangeCallbacks = new COUICompositeOnPageChangeCallback(3);
        this.mCurrentItemDirty = false;
        this.mCurrentItemDataSetChangeObserver = new DataSetChangeObserver() { // from class: com.coui.appcompat.viewpager.COUIViewPager2.1
            @Override // com.coui.appcompat.viewpager.COUIViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.i
            public void onChanged() {
                COUIViewPager2 cOUIViewPager2 = COUIViewPager2.this;
                cOUIViewPager2.mCurrentItemDirty = true;
                cOUIViewPager2.mScrollEventAdapter.notifyDataSetChangeHappened();
            }
        };
        this.mPendingCurrentItem = -1;
        this.mSavedItemAnimator = null;
        this.mSavedItemAnimatorPresent = false;
        this.mUserInputEnabled = true;
        this.mOffscreenPageLimit = -1;
        this.mInterpolator = new LinearInterpolator();
        this.mDuration = DEFAULT_VIEWPAGER_INTERACTING_NESTED_SCROLL_VELOCITY_THRESHOLD;
        initialize(context, attributeSet);
    }

    public COUIViewPager2(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.mTmpContainerRect = new Rect();
        this.mTmpChildRect = new Rect();
        this.mExternalPageChangeCallbacks = new COUICompositeOnPageChangeCallback(3);
        this.mCurrentItemDirty = false;
        this.mCurrentItemDataSetChangeObserver = new DataSetChangeObserver() { // from class: com.coui.appcompat.viewpager.COUIViewPager2.1
            @Override // com.coui.appcompat.viewpager.COUIViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.i
            public void onChanged() {
                COUIViewPager2 cOUIViewPager2 = COUIViewPager2.this;
                cOUIViewPager2.mCurrentItemDirty = true;
                cOUIViewPager2.mScrollEventAdapter.notifyDataSetChangeHappened();
            }
        };
        this.mPendingCurrentItem = -1;
        this.mSavedItemAnimator = null;
        this.mSavedItemAnimatorPresent = false;
        this.mUserInputEnabled = true;
        this.mOffscreenPageLimit = -1;
        this.mInterpolator = new LinearInterpolator();
        this.mDuration = DEFAULT_VIEWPAGER_INTERACTING_NESTED_SCROLL_VELOCITY_THRESHOLD;
        initialize(context, attributeSet);
    }
}
