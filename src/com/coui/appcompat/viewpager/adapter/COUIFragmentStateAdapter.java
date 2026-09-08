package com.coui.appcompat.viewpager.adapter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.core.view.K;
import androidx.fragment.app.B;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.InterfaceC0489l;
import androidx.lifecycle.InterfaceC0492o;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.a;
import androidx.viewpager2.widget.ViewPager2;
import com.coui.appcompat.viewpager.COUIViewPager2;
import java.util.Iterator;
import p.C1416b;
import p.C1420f;

/* loaded from: classes3.dex */
public abstract class COUIFragmentStateAdapter extends RecyclerView.Adapter<FragmentViewHolder> implements a {
    private static final long GRACE_WINDOW_TIME_MS = 10000;
    private static final String KEY_PREFIX_FRAGMENT = "f#";
    private static final String KEY_PREFIX_STATE = "s#";
    final FragmentManager mFragmentManager;
    private FragmentMaxLifecycleEnforcer mFragmentMaxLifecycleEnforcer;
    final C1420f<Fragment> mFragments;
    private boolean mHasStaleFragments;
    boolean mIsInGracePeriod;
    private final C1420f<Integer> mItemIdToViewHolder;
    final Lifecycle mLifecycle;
    private final C1420f<Fragment.SavedState> mSavedStates;

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
    public class FragmentMaxLifecycleEnforcer {
        private RecyclerView.i mDataObserver;
        private InterfaceC0489l mLifecycleObserver;
        private ViewPager2.i mPageChangeCallback;
        private long mPrimaryItemId = -1;
        private COUIViewPager2 mViewPager;

        public FragmentMaxLifecycleEnforcer() {
        }

        private COUIViewPager2 inferViewPager(RecyclerView recyclerView) {
            ViewParent parent = recyclerView.getParent();
            if (parent instanceof COUIViewPager2) {
                return (COUIViewPager2) parent;
            }
            throw new IllegalStateException("Expected COUIViewPager instance. Got: " + parent);
        }

        public void register(RecyclerView recyclerView) {
            this.mViewPager = inferViewPager(recyclerView);
            ViewPager2.i iVar = new ViewPager2.i() { // from class: com.coui.appcompat.viewpager.adapter.COUIFragmentStateAdapter.FragmentMaxLifecycleEnforcer.1
                @Override // androidx.viewpager2.widget.ViewPager2.i
                public void onPageScrollStateChanged(int i10) {
                    FragmentMaxLifecycleEnforcer.this.updateFragmentMaxLifecycle(false);
                }

                @Override // androidx.viewpager2.widget.ViewPager2.i
                public void onPageSelected(int i10) {
                    FragmentMaxLifecycleEnforcer.this.updateFragmentMaxLifecycle(false);
                }
            };
            this.mPageChangeCallback = iVar;
            this.mViewPager.registerOnPageChangeCallback(iVar);
            DataSetChangeObserver dataSetChangeObserver = new DataSetChangeObserver() { // from class: com.coui.appcompat.viewpager.adapter.COUIFragmentStateAdapter.FragmentMaxLifecycleEnforcer.2
                @Override // com.coui.appcompat.viewpager.adapter.COUIFragmentStateAdapter.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.i
                public void onChanged() {
                    FragmentMaxLifecycleEnforcer.this.updateFragmentMaxLifecycle(true);
                }
            };
            this.mDataObserver = dataSetChangeObserver;
            COUIFragmentStateAdapter.this.registerAdapterDataObserver(dataSetChangeObserver);
            InterfaceC0489l interfaceC0489l = new InterfaceC0489l() { // from class: com.coui.appcompat.viewpager.adapter.COUIFragmentStateAdapter.FragmentMaxLifecycleEnforcer.3
                @Override // androidx.lifecycle.InterfaceC0489l
                public void onStateChanged(InterfaceC0492o interfaceC0492o, Lifecycle.Event event) {
                    FragmentMaxLifecycleEnforcer.this.updateFragmentMaxLifecycle(false);
                }
            };
            this.mLifecycleObserver = interfaceC0489l;
            COUIFragmentStateAdapter.this.mLifecycle.a(interfaceC0489l);
        }

        public void unregister(RecyclerView recyclerView) {
            inferViewPager(recyclerView).unregisterOnPageChangeCallback(this.mPageChangeCallback);
            COUIFragmentStateAdapter.this.unregisterAdapterDataObserver(this.mDataObserver);
            COUIFragmentStateAdapter.this.mLifecycle.d(this.mLifecycleObserver);
            this.mViewPager = null;
        }

        public void updateFragmentMaxLifecycle(boolean z10) {
            int currentItem;
            Fragment d10;
            boolean z11;
            if (COUIFragmentStateAdapter.this.shouldDelayFragmentTransactions() || this.mViewPager.getScrollState() != 0 || COUIFragmentStateAdapter.this.mFragments.f() || COUIFragmentStateAdapter.this.getItemCount() == 0 || (currentItem = this.mViewPager.getCurrentItem()) >= COUIFragmentStateAdapter.this.getItemCount()) {
                return;
            }
            long itemId = COUIFragmentStateAdapter.this.getItemId(currentItem);
            if ((itemId != this.mPrimaryItemId || z10) && (d10 = COUIFragmentStateAdapter.this.mFragments.d(itemId)) != null && d10.isAdded()) {
                this.mPrimaryItemId = itemId;
                B p10 = COUIFragmentStateAdapter.this.mFragmentManager.p();
                Fragment fragment = null;
                for (int i10 = 0; i10 < COUIFragmentStateAdapter.this.mFragments.k(); i10++) {
                    long g10 = COUIFragmentStateAdapter.this.mFragments.g(i10);
                    Fragment l10 = COUIFragmentStateAdapter.this.mFragments.l(i10);
                    if (l10.isAdded()) {
                        if (g10 != this.mPrimaryItemId) {
                            p10.w(l10, Lifecycle.State.STARTED);
                        } else {
                            fragment = l10;
                        }
                        if (g10 == this.mPrimaryItemId) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        l10.setMenuVisibility(z11);
                    }
                }
                if (fragment != null) {
                    p10.w(fragment, Lifecycle.State.RESUMED);
                }
                if (!p10.q()) {
                    p10.k();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class FragmentViewHolder extends RecyclerView.B {
        private FragmentViewHolder(FrameLayout frameLayout) {
            super(frameLayout);
        }

        public static FragmentViewHolder create(ViewGroup viewGroup) {
            FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            frameLayout.setId(K.i());
            frameLayout.setSaveEnabled(false);
            return new FragmentViewHolder(frameLayout);
        }

        public FrameLayout getContainer() {
            return (FrameLayout) this.itemView;
        }
    }

    public COUIFragmentStateAdapter(FragmentActivity fragmentActivity) {
        this(fragmentActivity.getSupportFragmentManager(), fragmentActivity.getLifecycle());
    }

    private static String createKey(String str, long j10) {
        return str + j10;
    }

    private void ensureFragment(int i10) {
        long itemId = getItemId(i10);
        if (!this.mFragments.c(itemId)) {
            Fragment createFragment = createFragment(i10);
            createFragment.setInitialSavedState(this.mSavedStates.d(itemId));
            this.mFragments.h(itemId, createFragment);
        }
    }

    private boolean isFragmentViewBound(long j10) {
        View view;
        if (this.mItemIdToViewHolder.c(j10)) {
            return true;
        }
        Fragment d10 = this.mFragments.d(j10);
        if (d10 != null && (view = d10.getView()) != null && view.getParent() != null) {
            return true;
        }
        return false;
    }

    private static boolean isValidKey(String str, String str2) {
        if (str.startsWith(str2) && str.length() > str2.length()) {
            return true;
        }
        return false;
    }

    private Long itemForViewHolder(int i10) {
        Long l10 = null;
        for (int i11 = 0; i11 < this.mItemIdToViewHolder.k(); i11++) {
            if (this.mItemIdToViewHolder.l(i11).intValue() == i10) {
                if (l10 == null) {
                    l10 = Long.valueOf(this.mItemIdToViewHolder.g(i11));
                } else {
                    throw new IllegalStateException("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
                }
            }
        }
        return l10;
    }

    private static long parseIdFromKey(String str, String str2) {
        return Long.parseLong(str.substring(str2.length()));
    }

    private void removeFragment(long j10) {
        ViewParent parent;
        Fragment d10 = this.mFragments.d(j10);
        if (d10 == null) {
            return;
        }
        if (d10.getView() != null && (parent = d10.getView().getParent()) != null) {
            ((FrameLayout) parent).removeAllViews();
        }
        if (!containsItem(j10)) {
            this.mSavedStates.i(j10);
        }
        if (!d10.isAdded()) {
            this.mFragments.i(j10);
            return;
        }
        if (shouldDelayFragmentTransactions()) {
            this.mHasStaleFragments = true;
            return;
        }
        if (d10.isAdded() && containsItem(j10)) {
            this.mSavedStates.h(j10, this.mFragmentManager.x1(d10));
        }
        this.mFragmentManager.p().r(d10).k();
        this.mFragments.i(j10);
    }

    private void scheduleGracePeriodEnd() {
        final Handler handler = new Handler(Looper.getMainLooper());
        final Runnable runnable = new Runnable() { // from class: com.coui.appcompat.viewpager.adapter.COUIFragmentStateAdapter.4
            @Override // java.lang.Runnable
            public void run() {
                COUIFragmentStateAdapter cOUIFragmentStateAdapter = COUIFragmentStateAdapter.this;
                cOUIFragmentStateAdapter.mIsInGracePeriod = false;
                cOUIFragmentStateAdapter.gcFragments();
            }
        };
        this.mLifecycle.a(new InterfaceC0489l() { // from class: com.coui.appcompat.viewpager.adapter.COUIFragmentStateAdapter.5
            @Override // androidx.lifecycle.InterfaceC0489l
            public void onStateChanged(InterfaceC0492o interfaceC0492o, Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    handler.removeCallbacks(runnable);
                    interfaceC0492o.getLifecycle().d(this);
                }
            }
        });
        handler.postDelayed(runnable, GRACE_WINDOW_TIME_MS);
    }

    private void scheduleViewAttach(final Fragment fragment, final FrameLayout frameLayout) {
        this.mFragmentManager.m1(new FragmentManager.k() { // from class: com.coui.appcompat.viewpager.adapter.COUIFragmentStateAdapter.3
            @Override // androidx.fragment.app.FragmentManager.k
            public void onFragmentViewCreated(FragmentManager fragmentManager, Fragment fragment2, View view, Bundle bundle) {
                if (fragment2 == fragment) {
                    fragmentManager.I1(this);
                    COUIFragmentStateAdapter.this.addViewToContainer(view, frameLayout);
                }
            }
        }, false);
    }

    public void addViewToContainer(View view, FrameLayout frameLayout) {
        if (frameLayout.getChildCount() <= 1) {
            if (view.getParent() == frameLayout) {
                return;
            }
            if (frameLayout.getChildCount() > 0) {
                frameLayout.removeAllViews();
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            frameLayout.addView(view);
            return;
        }
        throw new IllegalStateException("Design assumption violated.");
    }

    public boolean containsItem(long j10) {
        if (j10 >= 0 && j10 < getItemCount()) {
            return true;
        }
        return false;
    }

    public abstract Fragment createFragment(int i10);

    public void gcFragments() {
        if (this.mHasStaleFragments && !shouldDelayFragmentTransactions()) {
            C1416b c1416b = new C1416b();
            for (int i10 = 0; i10 < this.mFragments.k(); i10++) {
                long g10 = this.mFragments.g(i10);
                if (!containsItem(g10)) {
                    c1416b.add(Long.valueOf(g10));
                    this.mItemIdToViewHolder.i(g10);
                }
            }
            if (!this.mIsInGracePeriod) {
                this.mHasStaleFragments = false;
                for (int i11 = 0; i11 < this.mFragments.k(); i11++) {
                    long g11 = this.mFragments.g(i11);
                    if (!isFragmentViewBound(g11)) {
                        c1416b.add(Long.valueOf(g11));
                    }
                }
            }
            Iterator<E> it = c1416b.iterator();
            while (it.hasNext()) {
                removeFragment(((Long) it.next()).longValue());
            }
        }
    }

    public Fragment getFragmentWithPosition(int i10) {
        return this.mFragments.d(getItemId(i10));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        if (this.mFragmentMaxLifecycleEnforcer == null) {
            FragmentMaxLifecycleEnforcer fragmentMaxLifecycleEnforcer = new FragmentMaxLifecycleEnforcer();
            this.mFragmentMaxLifecycleEnforcer = fragmentMaxLifecycleEnforcer;
            fragmentMaxLifecycleEnforcer.register(recyclerView);
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        this.mFragmentMaxLifecycleEnforcer.unregister(recyclerView);
        this.mFragmentMaxLifecycleEnforcer = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final boolean onFailedToRecycleView(FragmentViewHolder fragmentViewHolder) {
        return true;
    }

    public void placeFragmentInViewHolder(final FragmentViewHolder fragmentViewHolder) {
        Fragment d10 = this.mFragments.d(fragmentViewHolder.getItemId());
        if (d10 != null) {
            FrameLayout container = fragmentViewHolder.getContainer();
            View view = d10.getView();
            if (!d10.isAdded() && view != null) {
                throw new IllegalStateException("Design assumption violated.");
            }
            if (d10.isAdded() && view == null) {
                scheduleViewAttach(d10, container);
                return;
            }
            if (d10.isAdded() && view.getParent() != null) {
                if (view.getParent() != container) {
                    addViewToContainer(view, container);
                    return;
                }
                return;
            }
            if (d10.isAdded()) {
                addViewToContainer(view, container);
                return;
            }
            if (!shouldDelayFragmentTransactions()) {
                scheduleViewAttach(d10, container);
                this.mFragmentManager.p().e(d10, "f" + fragmentViewHolder.getItemId()).w(d10, Lifecycle.State.STARTED).k();
                this.mFragmentMaxLifecycleEnforcer.updateFragmentMaxLifecycle(false);
                return;
            }
            if (this.mFragmentManager.L0()) {
                return;
            }
            this.mLifecycle.a(new InterfaceC0489l() { // from class: com.coui.appcompat.viewpager.adapter.COUIFragmentStateAdapter.2
                @Override // androidx.lifecycle.InterfaceC0489l
                public void onStateChanged(InterfaceC0492o interfaceC0492o, Lifecycle.Event event) {
                    if (COUIFragmentStateAdapter.this.shouldDelayFragmentTransactions()) {
                        return;
                    }
                    interfaceC0492o.getLifecycle().d(this);
                    if (K.N(fragmentViewHolder.getContainer())) {
                        COUIFragmentStateAdapter.this.placeFragmentInViewHolder(fragmentViewHolder);
                    }
                }
            });
            return;
        }
        throw new IllegalStateException("Design assumption violated.");
    }

    @Override // androidx.viewpager2.adapter.a
    public final void restoreState(Parcelable parcelable) {
        if (this.mSavedStates.f() && this.mFragments.f()) {
            Bundle bundle = (Bundle) parcelable;
            if (bundle.getClassLoader() == null) {
                bundle.setClassLoader(getClass().getClassLoader());
            }
            for (String str : bundle.keySet()) {
                if (isValidKey(str, KEY_PREFIX_FRAGMENT)) {
                    this.mFragments.h(parseIdFromKey(str, KEY_PREFIX_FRAGMENT), this.mFragmentManager.v0(bundle, str));
                } else if (isValidKey(str, KEY_PREFIX_STATE)) {
                    long parseIdFromKey = parseIdFromKey(str, KEY_PREFIX_STATE);
                    Fragment.SavedState savedState = (Fragment.SavedState) bundle.getParcelable(str);
                    if (containsItem(parseIdFromKey)) {
                        this.mSavedStates.h(parseIdFromKey, savedState);
                    }
                } else {
                    throw new IllegalArgumentException("Unexpected key in savedState: " + str);
                }
            }
            if (!this.mFragments.f()) {
                this.mHasStaleFragments = true;
                this.mIsInGracePeriod = true;
                gcFragments();
                scheduleGracePeriodEnd();
                return;
            }
            return;
        }
        throw new IllegalStateException("Expected the adapter to be 'fresh' while restoring state.");
    }

    @Override // androidx.viewpager2.adapter.a
    public final Parcelable saveState() {
        Bundle bundle = new Bundle(this.mFragments.k() + this.mSavedStates.k());
        for (int i10 = 0; i10 < this.mFragments.k(); i10++) {
            long g10 = this.mFragments.g(i10);
            Fragment d10 = this.mFragments.d(g10);
            if (d10 != null && d10.isAdded()) {
                this.mFragmentManager.l1(bundle, createKey(KEY_PREFIX_FRAGMENT, g10), d10);
            }
        }
        for (int i11 = 0; i11 < this.mSavedStates.k(); i11++) {
            long g11 = this.mSavedStates.g(i11);
            if (containsItem(g11)) {
                bundle.putParcelable(createKey(KEY_PREFIX_STATE, g11), this.mSavedStates.d(g11));
            }
        }
        return bundle;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void setHasStableIds(boolean z10) {
        throw new UnsupportedOperationException("Stable Ids are required for the adapter to function properly, and the adapter takes care of setting the flag.");
    }

    public boolean shouldDelayFragmentTransactions() {
        return this.mFragmentManager.T0();
    }

    public COUIFragmentStateAdapter(Fragment fragment) {
        this(fragment.getChildFragmentManager(), fragment.getLifecycle());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(final FragmentViewHolder fragmentViewHolder, int i10) {
        long itemId = fragmentViewHolder.getItemId();
        int id = fragmentViewHolder.getContainer().getId();
        Long itemForViewHolder = itemForViewHolder(id);
        if (itemForViewHolder != null && itemForViewHolder.longValue() != itemId) {
            removeFragment(itemForViewHolder.longValue());
            this.mItemIdToViewHolder.i(itemForViewHolder.longValue());
        }
        this.mItemIdToViewHolder.h(itemId, Integer.valueOf(id));
        ensureFragment(i10);
        final FrameLayout container = fragmentViewHolder.getContainer();
        if (K.N(container)) {
            if (container.getParent() == null) {
                container.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.coui.appcompat.viewpager.adapter.COUIFragmentStateAdapter.1
                    @Override // android.view.View.OnLayoutChangeListener
                    public void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
                        if (container.getParent() != null) {
                            container.removeOnLayoutChangeListener(this);
                            COUIFragmentStateAdapter.this.placeFragmentInViewHolder(fragmentViewHolder);
                        }
                    }
                });
            } else {
                throw new IllegalStateException("Design assumption violated.");
            }
        }
        gcFragments();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final FragmentViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return FragmentViewHolder.create(viewGroup);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(FragmentViewHolder fragmentViewHolder) {
        placeFragmentInViewHolder(fragmentViewHolder);
        gcFragments();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(FragmentViewHolder fragmentViewHolder) {
        Long itemForViewHolder = itemForViewHolder(fragmentViewHolder.getContainer().getId());
        if (itemForViewHolder != null) {
            removeFragment(itemForViewHolder.longValue());
            this.mItemIdToViewHolder.i(itemForViewHolder.longValue());
        }
    }

    public COUIFragmentStateAdapter(FragmentManager fragmentManager, Lifecycle lifecycle) {
        this.mFragments = new C1420f<>();
        this.mSavedStates = new C1420f<>();
        this.mItemIdToViewHolder = new C1420f<>();
        this.mIsInGracePeriod = false;
        this.mHasStaleFragments = false;
        this.mFragmentManager = fragmentManager;
        this.mLifecycle = lifecycle;
        super.setHasStableIds(true);
    }
}
