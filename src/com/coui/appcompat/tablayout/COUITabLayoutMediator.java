package com.coui.appcompat.tablayout;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.coui.appcompat.animation.COUIMoveEaseInterpolator;
import com.coui.appcompat.tablayout.COUITabLayout;
import com.coui.appcompat.viewpager.COUIViewPager2;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public final class COUITabLayoutMediator {
    private static final int ALL_CUSTOM_TAB_VIEW = 2;
    private static final int INVALID_VALUE = -1;
    private static final int NO_CUSTOM_TAB_VIEW = 0;
    private static final int PART_CUSTOM_TAB_VIEW = 1;
    private static final String SELECT_TAB_NAME = "TabLayout.selectTab(TabLayout.Tab, boolean)";
    private static final String SET_SCROLL_POSITION_NAME = "TabLayout.setScrollPosition(int, float, boolean, boolean)";
    private static Method sSelectTab;
    private static Method sSetScrollPosition;
    private RecyclerView.Adapter mAdapter;
    private boolean mAttached;
    private final boolean mAutoRefresh;
    private int mCustomTabViewType;
    private int mLayoutResAll;
    private SparseIntArray mLayoutResIdMap;
    private final OnConfigureTabCallback mOnConfigureTabCallback;
    private TabLayoutOnPageChangeCallback mOnPageChangeCallback;
    private COUITabLayout.OnTabSelectedListener mOnTabSelectedListener;
    private RecyclerView.i mPagerAdapterObserver;
    private final COUITabLayout mTabLayout;
    private final COUIViewPager2 mViewPager;

    /* loaded from: classes3.dex */
    public interface OnConfigureTabCallback {
        void onConfigureTab(COUITab cOUITab, int i10);
    }

    /* loaded from: classes3.dex */
    public class PagerAdapterObserver extends RecyclerView.i {
        public PagerAdapterObserver() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void onChanged() {
            COUITabLayoutMediator.this.populateTabsFromPagerAdapter();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void onItemRangeChanged(int i10, int i11) {
            COUITabLayoutMediator.this.populateTabsFromPagerAdapter();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void onItemRangeInserted(int i10, int i11) {
            COUITabLayoutMediator.this.populateTabsFromPagerAdapter();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void onItemRangeMoved(int i10, int i11, int i12) {
            COUITabLayoutMediator.this.populateTabsFromPagerAdapter();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void onItemRangeRemoved(int i10, int i11) {
            COUITabLayoutMediator.this.populateTabsFromPagerAdapter();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void onItemRangeChanged(int i10, int i11, Object obj) {
            COUITabLayoutMediator.this.populateTabsFromPagerAdapter();
        }
    }

    /* loaded from: classes3.dex */
    public static class TabLayoutOnPageChangeCallback extends ViewPager2.i {
        private int mPreviousScrollState;
        private int mScrollState;
        private final WeakReference<COUITabLayout> mTabLayoutRef;
        private final WeakReference<COUIViewPager2> mViewPager2Ref;

        public TabLayoutOnPageChangeCallback(COUITabLayout cOUITabLayout, COUIViewPager2 cOUIViewPager2) {
            this.mTabLayoutRef = new WeakReference<>(cOUITabLayout);
            this.mViewPager2Ref = new WeakReference<>(cOUIViewPager2);
            reset();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void onPageScrollStateChanged(int i10) {
            this.mPreviousScrollState = this.mScrollState;
            this.mScrollState = i10;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void onPageScrolled(int i10, float f10, int i11) {
            boolean z10;
            COUIViewPager2 cOUIViewPager2 = this.mViewPager2Ref.get();
            COUITabLayout cOUITabLayout = this.mTabLayoutRef.get();
            if (cOUITabLayout != null && cOUIViewPager2 != null && !cOUIViewPager2.isFakeDragging()) {
                int i12 = this.mScrollState;
                boolean z11 = true;
                if (i12 == 2 && this.mPreviousScrollState != 1) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                if (i12 == 2 && this.mPreviousScrollState == 0) {
                    z11 = false;
                }
                if (i12 == 0 && this.mPreviousScrollState == 0 && f10 != 0.0f) {
                    ((RecyclerView) cOUIViewPager2.getChildAt(0)).scrollBy(i11, 0);
                    cOUITabLayout.selectTab(cOUITabLayout.getTabAt(i10));
                } else {
                    COUITabLayoutMediator.setScrollPosition(cOUITabLayout, i10, f10, z10, z11);
                }
                if (f10 == 0.0f && i10 != cOUITabLayout.getSelectedTabPosition()) {
                    cOUITabLayout.selectTab(cOUITabLayout.getTabAt(i10));
                }
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void onPageSelected(int i10) {
            boolean z10;
            COUITabLayout cOUITabLayout = this.mTabLayoutRef.get();
            if (cOUITabLayout != null && cOUITabLayout.getSelectedTabPosition() != i10 && i10 < cOUITabLayout.getTabCount()) {
                int i11 = this.mScrollState;
                if (i11 != 0 && (i11 != 2 || this.mPreviousScrollState != 0)) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                COUITabLayoutMediator.selectTab(cOUITabLayout, cOUITabLayout.getTabAt(i10), z10);
            }
        }

        public void reset() {
            this.mScrollState = 0;
            this.mPreviousScrollState = 0;
        }
    }

    static {
        try {
            Class cls = Integer.TYPE;
            Class cls2 = Float.TYPE;
            Class cls3 = Boolean.TYPE;
            Method declaredMethod = COUITabLayout.class.getDeclaredMethod("setScrollPosition", cls, cls2, cls3, cls3);
            sSetScrollPosition = declaredMethod;
            declaredMethod.setAccessible(true);
            Method declaredMethod2 = COUITabLayout.class.getDeclaredMethod("selectTab", COUITab.class, cls3);
            sSelectTab = declaredMethod2;
            declaredMethod2.setAccessible(true);
        } catch (NoSuchMethodException unused) {
            throw new IllegalStateException("Can't reflect into method TabLayout.setScrollPosition(int, float, boolean, boolean)");
        }
    }

    public COUITabLayoutMediator(COUITabLayout cOUITabLayout, COUIViewPager2 cOUIViewPager2, OnConfigureTabCallback onConfigureTabCallback) {
        this(cOUITabLayout, cOUIViewPager2, true, onConfigureTabCallback);
    }

    public static void selectTab(COUITabLayout cOUITabLayout, COUITab cOUITab, boolean z10) {
        try {
            Method method = sSelectTab;
            if (method != null) {
                method.invoke(cOUITabLayout, cOUITab, Boolean.valueOf(z10));
            } else {
                throwMethodNotFound(SELECT_TAB_NAME);
            }
        } catch (Exception unused) {
            throwInvokeFailed(SELECT_TAB_NAME);
        }
    }

    public static void setScrollPosition(COUITabLayout cOUITabLayout, int i10, float f10, boolean z10, boolean z11) {
        try {
            Method method = sSetScrollPosition;
            if (method != null) {
                method.invoke(cOUITabLayout, Integer.valueOf(i10), Float.valueOf(f10), Boolean.valueOf(z10), Boolean.valueOf(z11));
            } else {
                throwMethodNotFound(SET_SCROLL_POSITION_NAME);
            }
        } catch (Exception unused) {
            throwInvokeFailed(SET_SCROLL_POSITION_NAME);
        }
    }

    private static void throwInvokeFailed(String str) {
        throw new IllegalStateException("Couldn't invoke method " + str);
    }

    private static void throwMethodNotFound(String str) {
        throw new IllegalStateException("Method " + str + " not found");
    }

    public void attach() {
        if (!this.mAttached) {
            RecyclerView.Adapter adapter = this.mViewPager.getAdapter();
            this.mAdapter = adapter;
            if (adapter != null) {
                this.mAttached = true;
                TabLayoutOnPageChangeCallback tabLayoutOnPageChangeCallback = new TabLayoutOnPageChangeCallback(this.mTabLayout, this.mViewPager);
                this.mOnPageChangeCallback = tabLayoutOnPageChangeCallback;
                this.mViewPager.registerOnPageChangeCallback(tabLayoutOnPageChangeCallback);
                ViewPagerOnTabSelectedListener viewPagerOnTabSelectedListener = new ViewPagerOnTabSelectedListener(this.mViewPager);
                this.mOnTabSelectedListener = viewPagerOnTabSelectedListener;
                this.mTabLayout.addOnTabSelectedListener(viewPagerOnTabSelectedListener);
                if (this.mAutoRefresh) {
                    PagerAdapterObserver pagerAdapterObserver = new PagerAdapterObserver();
                    this.mPagerAdapterObserver = pagerAdapterObserver;
                    this.mAdapter.registerAdapterDataObserver(pagerAdapterObserver);
                }
                populateTabsFromPagerAdapter();
                this.mTabLayout.setScrollPosition(this.mViewPager.getCurrentItem(), 0.0f, true);
                return;
            }
            throw new IllegalStateException("TabLayoutMediator attached before ViewPager2 has an adapter");
        }
        throw new IllegalStateException("TabLayoutMediator is already attached");
    }

    public void detach() {
        if (this.mAutoRefresh) {
            this.mAdapter.unregisterAdapterDataObserver(this.mPagerAdapterObserver);
        }
        this.mTabLayout.removeOnTabSelectedListener(this.mOnTabSelectedListener);
        this.mViewPager.unregisterOnPageChangeCallback(this.mOnPageChangeCallback);
        this.mPagerAdapterObserver = null;
        this.mOnTabSelectedListener = null;
        this.mOnPageChangeCallback = null;
        this.mAttached = false;
    }

    public void populateTabsFromPagerAdapter() {
        this.mTabLayout.removeAllTabs();
        RecyclerView.Adapter adapter = this.mAdapter;
        if (adapter != null) {
            int itemCount = adapter.getItemCount();
            for (int i10 = 0; i10 < itemCount; i10++) {
                COUITab newTab = this.mTabLayout.newTab();
                int i11 = this.mCustomTabViewType;
                if (i11 != 1) {
                    if (i11 == 2) {
                        newTab.setCustomView(this.mLayoutResAll);
                    }
                } else if (this.mLayoutResIdMap.get(i10, -1) != -1) {
                    newTab.setCustomView(this.mLayoutResIdMap.get(i10));
                }
                this.mOnConfigureTabCallback.onConfigureTab(newTab, i10);
                this.mTabLayout.addTab(newTab, false);
            }
            if (itemCount > 0) {
                int currentItem = this.mViewPager.getCurrentItem();
                COUITab tabAt = this.mTabLayout.getTabAt(currentItem);
                if (currentItem != this.mTabLayout.getSelectedTabPosition() && tabAt != null) {
                    tabAt.select();
                }
            }
        }
    }

    public void setTabCustomView(int i10) {
        this.mCustomTabViewType = 2;
        this.mLayoutResAll = i10;
        if (this.mAttached) {
            populateTabsFromPagerAdapter();
            this.mTabLayout.setScrollPosition(this.mViewPager.getCurrentItem(), 0.0f, true);
        }
    }

    public COUITabLayoutMediator(COUITabLayout cOUITabLayout, COUIViewPager2 cOUIViewPager2, boolean z10, OnConfigureTabCallback onConfigureTabCallback) {
        this.mTabLayout = cOUITabLayout;
        cOUITabLayout.setUpdateindicatorposition(true);
        this.mViewPager = cOUIViewPager2;
        this.mAutoRefresh = z10;
        this.mOnConfigureTabCallback = onConfigureTabCallback;
        this.mCustomTabViewType = 0;
        this.mLayoutResIdMap = new SparseIntArray();
    }

    public void setTabCustomView(int i10, int i11) {
        this.mCustomTabViewType = 1;
        this.mLayoutResIdMap.put(i11, i10);
        if (this.mAttached) {
            populateTabsFromPagerAdapter();
            this.mTabLayout.setScrollPosition(this.mViewPager.getCurrentItem(), 0.0f, true);
        }
    }

    /* loaded from: classes3.dex */
    public static class ViewPagerOnTabSelectedListener implements COUITabLayout.OnTabSelectedListener {
        private int[] mScrollDistanceAndDuration = new int[2];
        private PathInterpolator mScrollPathInterpolator = new COUIMoveEaseInterpolator();
        private final COUIViewPager2 mViewPager;

        public ViewPagerOnTabSelectedListener(COUIViewPager2 cOUIViewPager2) {
            this.mViewPager = cOUIViewPager2;
        }

        private void getScrollDistanceAndDuration(LinearLayoutManager linearLayoutManager, RecyclerView recyclerView, int i10) {
            View findViewByPosition;
            int[] iArr = this.mScrollDistanceAndDuration;
            iArr[0] = 0;
            iArr[1] = 0;
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            if (findFirstVisibleItemPosition == -1 || (findViewByPosition = linearLayoutManager.findViewByPosition(findFirstVisibleItemPosition)) == null) {
                return;
            }
            int leftDecorationWidth = linearLayoutManager.getLeftDecorationWidth(findViewByPosition);
            int rightDecorationWidth = linearLayoutManager.getRightDecorationWidth(findViewByPosition);
            ViewGroup.LayoutParams layoutParams = findViewByPosition.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                leftDecorationWidth += marginLayoutParams.leftMargin;
                rightDecorationWidth += marginLayoutParams.rightMargin;
            }
            int width = findViewByPosition.getWidth() + leftDecorationWidth + rightDecorationWidth;
            int left = (findViewByPosition.getLeft() - leftDecorationWidth) - recyclerView.getPaddingLeft();
            if (linearLayoutManager.getLayoutDirection() == 1) {
                width = -width;
            }
            int i11 = ((i10 - findFirstVisibleItemPosition) * width) + left;
            int[] iArr2 = this.mScrollDistanceAndDuration;
            iArr2[0] = i11;
            iArr2[1] = getScrollDuration(Math.abs(i11), Math.abs(width));
        }

        private int getScrollDuration(int i10, int i11) {
            float f10 = i11 * 3;
            if (i10 <= i11) {
                return 350;
            }
            float f11 = i10;
            if (f11 > f10) {
                return 650;
            }
            return (int) (((f11 / f10) * 300.0f) + 350.0f);
        }

        @Override // com.coui.appcompat.tablayout.COUITabLayout.OnTabSelectedListener
        public void onTabSelected(COUITab cOUITab) {
            RecyclerView.Adapter adapter;
            if (cOUITab.mView.getSelectedByClick() && (adapter = this.mViewPager.getAdapter()) != null && adapter.getItemCount() > 0) {
                int min = Math.min(Math.max(cOUITab.getPosition(), 0), adapter.getItemCount() - 1);
                if (this.mViewPager.getChildAt(0) instanceof RecyclerView) {
                    RecyclerView recyclerView = (RecyclerView) this.mViewPager.getChildAt(0);
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                    if (linearLayoutManager == null) {
                        return;
                    }
                    getScrollDistanceAndDuration(linearLayoutManager, recyclerView, min);
                    this.mViewPager.beginFakeDrag();
                    int[] iArr = this.mScrollDistanceAndDuration;
                    recyclerView.smoothScrollBy(iArr[0], 0, this.mScrollPathInterpolator, iArr[1]);
                }
            }
        }

        @Override // com.coui.appcompat.tablayout.COUITabLayout.OnTabSelectedListener
        public void onTabReselected(COUITab cOUITab) {
        }

        @Override // com.coui.appcompat.tablayout.COUITabLayout.OnTabSelectedListener
        public void onTabUnselected(COUITab cOUITab) {
        }
    }
}
