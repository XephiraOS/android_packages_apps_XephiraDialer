package com.coui.appcompat.expandable;

import android.R;
import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.HeterogeneousExpandableList;
import com.coui.appcompat.animation.COUIMoveEaseInterpolator;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class COUIExpandableListView extends ExpandableListView {
    private static final String TAG = "COUIExpandableListView";
    private InnerExpandableListAdapter adapter;
    private ExpandableListView.OnGroupClickListener mGroupClickListener;

    /* loaded from: classes.dex */
    public static class DummyView extends View {
        private Drawable divider;
        private int dividerHeight;
        private int dividerWidth;
        private List<View> views;

        public DummyView(Context context) {
            super(context);
            this.views = new ArrayList();
            COUIDarkModeUtil.setForceDarkAllow(this, false);
        }

        public void addFakeView(View view) {
            this.views.add(view);
        }

        public void clearViews() {
            this.views.clear();
        }

        @Override // android.view.View
        public void dispatchDraw(Canvas canvas) {
            canvas.save();
            Drawable drawable = this.divider;
            if (drawable != null) {
                drawable.setBounds(0, 0, this.dividerWidth, this.dividerHeight);
            }
            int size = this.views.size();
            int i10 = 0;
            for (int i11 = 0; i11 < size; i11++) {
                View view = this.views.get(i11);
                canvas.save();
                int measuredHeight = view.getMeasuredHeight();
                i10 += measuredHeight;
                canvas.clipRect(0, 0, getWidth(), measuredHeight);
                view.draw(canvas);
                canvas.restore();
                Drawable drawable2 = this.divider;
                if (drawable2 != null) {
                    i10 += this.dividerHeight;
                    drawable2.draw(canvas);
                    canvas.translate(0.0f, this.dividerHeight);
                }
                canvas.translate(0.0f, measuredHeight);
                if (i10 > canvas.getHeight()) {
                    break;
                }
            }
            canvas.restore();
        }

        @Override // android.view.View
        public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
            super.onLayout(z10, i10, i11, i12, i13);
            int i14 = i13 - i11;
            int size = this.views.size();
            int i15 = 0;
            for (int i16 = 0; i16 < size; i16++) {
                View view = this.views.get(i16);
                int measuredHeight = view.getMeasuredHeight();
                view.layout(i10, i11, view.getMeasuredWidth() + i10, measuredHeight + i11);
                i15 = i15 + measuredHeight + this.dividerHeight;
                if (i15 > i14) {
                    return;
                }
            }
        }

        public void setDivider(Drawable drawable, int i10, int i11) {
            if (drawable != null) {
                this.divider = drawable;
                this.dividerWidth = i10;
                this.dividerHeight = i11;
                drawable.setBounds(0, 0, i10, i11);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class ExpandAnimator extends ValueAnimator {
        private boolean isFirst;
        private WeakReference<COUIExpandableListView> reference;

        public ExpandAnimator(COUIExpandableListView cOUIExpandableListView, long j10, TimeInterpolator timeInterpolator) {
            this.reference = new WeakReference<>(cOUIExpandableListView);
            setDuration(j10);
            setInterpolator(timeInterpolator);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void endAnimator() {
            removeAllUpdateListeners();
            end();
        }

        public void setParam(final boolean z10, final boolean z11, final int i10, final View view, final GroupInfo groupInfo, int i11, int i12) {
            this.isFirst = true;
            setIntValues(i11, i12);
            removeAllUpdateListeners();
            addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.expandable.COUIExpandableListView.ExpandAnimator.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int i13;
                    COUIExpandableListView cOUIExpandableListView = (COUIExpandableListView) ExpandAnimator.this.reference.get();
                    if (cOUIExpandableListView == null) {
                        Log.e(COUIExpandableListView.TAG, "onAnimationUpdate: expandable list is null");
                        ExpandAnimator.this.endAnimator();
                        return;
                    }
                    int packedPositionGroup = ExpandableListView.getPackedPositionGroup(cOUIExpandableListView.getExpandableListPosition(cOUIExpandableListView.getFirstVisiblePosition()));
                    long expandableListPosition = cOUIExpandableListView.getExpandableListPosition(cOUIExpandableListView.getLastVisiblePosition());
                    int packedPositionGroup2 = ExpandableListView.getPackedPositionGroup(expandableListPosition);
                    int packedPositionChild = ExpandableListView.getPackedPositionChild(expandableListPosition);
                    if (!ExpandAnimator.this.isFirst && !z11 && (packedPositionGroup > (i13 = i10) || packedPositionGroup2 < i13)) {
                        Log.d(COUIExpandableListView.TAG, "onAnimationUpdate: all is screen out, first:" + packedPositionGroup + ",groupPos:" + i10 + ",last:" + packedPositionGroup2);
                        ExpandAnimator.this.endAnimator();
                        return;
                    }
                    if (!ExpandAnimator.this.isFirst && !z11 && z10 && packedPositionGroup2 == i10 && packedPositionChild == 0) {
                        Log.d(COUIExpandableListView.TAG, "onAnimationUpdate: expand is screen over, last:" + packedPositionGroup2);
                        ExpandAnimator.this.endAnimator();
                        return;
                    }
                    if (ExpandAnimator.this.isFirst || !z11 || !z10 || view.getBottom() <= cOUIExpandableListView.getBottom()) {
                        ExpandAnimator.this.isFirst = false;
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        groupInfo.dummyHeight = intValue;
                        view.getLayoutParams().height = intValue;
                        view.requestLayout();
                        return;
                    }
                    Log.d(COUIExpandableListView.TAG, "onAnimationUpdate3: " + view.getBottom() + "," + cOUIExpandableListView.getBottom());
                    ExpandAnimator.this.endAnimator();
                }
            });
        }
    }

    /* loaded from: classes.dex */
    public static class GroupInfo {
        boolean animating;
        int dummyHeight;
        DummyView dummyView;
        boolean expanding;
        boolean isLastChild;
        int totalHeight;

        private GroupInfo() {
            this.animating = false;
            this.expanding = false;
            this.isLastChild = false;
            this.dummyHeight = -1;
        }
    }

    /* loaded from: classes.dex */
    public static class InnerExpandableListAdapter extends BaseExpandableListAdapter {
        private static final long ANIMATION_DURATION = 400;
        private static final int EXPAND_THRESHOLD = 2;
        private static final int STATE_COLLAPSING = 2;
        private static final int STATE_EXPANDING = 1;
        private static final int STATE_IDLE = 0;
        private COUIExpandableListView expandableListView;
        private ExpandableListAdapter listAdapter;
        private final DataSetObserver mDataSetObserver;
        private SparseArray<GroupInfo> groupInfo = new SparseArray<>();
        private SparseArray<ExpandAnimator> animatorSparseArray = new SparseArray<>();
        private SparseArray<List<View>> cacheChildView = new SparseArray<>();
        private SparseArray<List<View>> showChildView = new SparseArray<>();

        /* loaded from: classes.dex */
        public class MyDataSetObserver extends DataSetObserver {
            public MyDataSetObserver() {
            }

            @Override // android.database.DataSetObserver
            public void onChanged() {
                InnerExpandableListAdapter.this.notifyDataSetChanged();
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                InnerExpandableListAdapter.this.notifyDataSetInvalidated();
            }
        }

        public InnerExpandableListAdapter(ExpandableListAdapter expandableListAdapter, COUIExpandableListView cOUIExpandableListView) {
            MyDataSetObserver myDataSetObserver = new MyDataSetObserver();
            this.mDataSetObserver = myDataSetObserver;
            this.expandableListView = cOUIExpandableListView;
            ExpandableListAdapter expandableListAdapter2 = this.listAdapter;
            if (expandableListAdapter2 != null) {
                expandableListAdapter2.unregisterDataSetObserver(myDataSetObserver);
            }
            this.listAdapter = expandableListAdapter;
            expandableListAdapter.registerDataSetObserver(myDataSetObserver);
        }

        private void addCache(View view, int i10, int i11) {
            int realChildType = getRealChildType(i10, i11);
            List<View> list = this.showChildView.get(realChildType);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(view);
            this.showChildView.put(realChildType, list);
        }

        private void collapseAnimationStart(final DummyView dummyView, final int i10, boolean z10, int i11) {
            int i12;
            GroupInfo groupInfo = getGroupInfo(i10);
            ExpandAnimator expandAnimator = this.animatorSparseArray.get(i10);
            if (expandAnimator == null) {
                expandAnimator = new ExpandAnimator(this.expandableListView, ANIMATION_DURATION, new COUIMoveEaseInterpolator());
                this.animatorSparseArray.put(i10, expandAnimator);
            } else {
                expandAnimator.removeAllListeners();
                expandAnimator.cancel();
            }
            ExpandAnimator expandAnimator2 = expandAnimator;
            int i13 = groupInfo.dummyHeight;
            if (i13 == -1) {
                i12 = i11;
            } else {
                i12 = i13;
            }
            expandAnimator2.setParam(false, z10, i10, dummyView, groupInfo, i12, 0);
            expandAnimator2.addListener(new EndAnimatorListener() { // from class: com.coui.appcompat.expandable.COUIExpandableListView.InnerExpandableListAdapter.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    dummyView.clearViews();
                    InnerExpandableListAdapter.this.stopAnimation(i10);
                    InnerExpandableListAdapter.this.expandableListView.originCollapseGroup(i10);
                    dummyView.setTag(0);
                }
            });
            expandAnimator2.start();
            dummyView.setTag(2);
        }

        private void expandAnimationStart(final DummyView dummyView, final int i10, boolean z10, int i11) {
            GroupInfo groupInfo = getGroupInfo(i10);
            ExpandAnimator expandAnimator = this.animatorSparseArray.get(i10);
            if (expandAnimator == null) {
                expandAnimator = new ExpandAnimator(this.expandableListView, ANIMATION_DURATION, new COUIMoveEaseInterpolator());
                this.animatorSparseArray.put(i10, expandAnimator);
            } else {
                expandAnimator.removeAllListeners();
                expandAnimator.cancel();
            }
            ExpandAnimator expandAnimator2 = expandAnimator;
            int i12 = groupInfo.dummyHeight;
            if (i12 == -1) {
                i12 = 0;
            }
            expandAnimator2.setParam(true, z10, i10, dummyView, groupInfo, i12, i11);
            expandAnimator2.addListener(new EndAnimatorListener() { // from class: com.coui.appcompat.expandable.COUIExpandableListView.InnerExpandableListAdapter.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    dummyView.clearViews();
                    InnerExpandableListAdapter.this.stopAnimation(i10);
                    InnerExpandableListAdapter.this.notifyDataSetChanged();
                    dummyView.setTag(0);
                }
            });
            expandAnimator2.start();
            dummyView.setTag(1);
        }

        private View getAnimationView(int i10, boolean z10, View view) {
            GroupInfo groupInfo = getGroupInfo(i10);
            int i11 = 0;
            if (!(view instanceof DummyView)) {
                view = new DummyView(this.expandableListView.getContext());
                view.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
            }
            DummyView dummyView = (DummyView) view;
            dummyView.clearViews();
            dummyView.setDivider(this.expandableListView.getDivider(), this.expandableListView.getMeasuredWidth(), this.expandableListView.getDividerHeight());
            int childAllHeight = getChildAllHeight(groupInfo.expanding, i10, dummyView);
            groupInfo.dummyView = dummyView;
            groupInfo.totalHeight = childAllHeight;
            Object tag = dummyView.getTag();
            if (tag != null) {
                i11 = ((Integer) tag).intValue();
            }
            boolean z11 = groupInfo.expanding;
            if (z11 && i11 != 1) {
                expandAnimationStart(dummyView, i10, z10, childAllHeight);
            } else if (!z11 && i11 != 2) {
                collapseAnimationStart(dummyView, i10, z10, childAllHeight);
            } else {
                Log.e(COUIExpandableListView.TAG, "getAnimationView: state is no match:" + i11);
            }
            return view;
        }

        private View getCacheView(int i10, int i11) {
            List<View> list = this.cacheChildView.get(getRealChildType(i10, i11));
            if (list != null && !list.isEmpty()) {
                return list.remove(0);
            }
            return null;
        }

        private int getChildAllHeight(boolean z10, int i10, DummyView dummyView) {
            int bottom;
            boolean z11;
            int i11;
            this.expandableListView.getChildCount();
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.expandableListView.getWidth(), 1073741824);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            if (z10 && this.expandableListView.getLayoutParams().height == -2) {
                bottom = this.expandableListView.getContext().getResources().getDisplayMetrics().heightPixels;
            } else {
                bottom = this.expandableListView.getBottom();
            }
            int i12 = bottom;
            int childrenCount = this.listAdapter.getChildrenCount(i10);
            int i13 = 0;
            for (int i14 = 0; i14 < childrenCount; i14++) {
                View cacheView = getCacheView(i10, i14);
                ExpandableListAdapter expandableListAdapter = this.listAdapter;
                if (i14 == childrenCount - 1) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                View childView = expandableListAdapter.getChildView(i10, i14, z11, cacheView, this.expandableListView);
                addCache(childView, i10, i14);
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) childView.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = (AbsListView.LayoutParams) generateDefaultLayoutParams();
                    childView.setLayoutParams(layoutParams);
                }
                int i15 = layoutParams.height;
                if (i15 > 0) {
                    i11 = View.MeasureSpec.makeMeasureSpec(i15, 1073741824);
                } else {
                    i11 = makeMeasureSpec2;
                }
                childView.setLayoutDirection(this.expandableListView.getLayoutDirection());
                childView.measure(makeMeasureSpec, i11);
                i13 += childView.getMeasuredHeight();
                dummyView.addFakeView(childView);
                if ((!z10 && i13 > i12) || (z10 && i13 > i12 * 2)) {
                    break;
                }
            }
            return i13;
        }

        private GroupInfo getGroupInfo(int i10) {
            GroupInfo groupInfo = this.groupInfo.get(i10);
            if (groupInfo == null) {
                GroupInfo groupInfo2 = new GroupInfo();
                this.groupInfo.put(i10, groupInfo2);
                return groupInfo2;
            }
            return groupInfo;
        }

        private int getRealChildType(int i10, int i11) {
            ExpandableListAdapter expandableListAdapter = this.listAdapter;
            if (!(expandableListAdapter instanceof HeterogeneousExpandableList)) {
                return 1;
            }
            int childType = ((HeterogeneousExpandableList) expandableListAdapter).getChildType(i10, i11) + 1;
            if (childType >= 0) {
                return childType;
            }
            throw new RuntimeException("getChildType must is greater than 0");
        }

        private boolean isAllAnimatorEnd() {
            int lastVisiblePosition = this.expandableListView.getLastVisiblePosition();
            for (int firstVisiblePosition = this.expandableListView.getFirstVisiblePosition(); firstVisiblePosition <= lastVisiblePosition; firstVisiblePosition++) {
                if (getGroupInfo(firstVisiblePosition).animating) {
                    return false;
                }
            }
            return true;
        }

        private boolean isGroupExpanded(int i10) {
            GroupInfo groupInfo = getGroupInfo(i10);
            if (this.expandableListView.isGroupExpanded(i10) && (!groupInfo.animating || groupInfo.expanding)) {
                return true;
            }
            return false;
        }

        private void resetCache() {
            for (int i10 = 0; i10 < this.showChildView.size(); i10++) {
                List<View> valueAt = this.showChildView.valueAt(i10);
                int keyAt = this.showChildView.keyAt(i10);
                List<View> list = this.cacheChildView.get(keyAt);
                if (list == null) {
                    list = new ArrayList<>();
                    this.cacheChildView.put(keyAt, list);
                }
                list.addAll(valueAt);
            }
            this.showChildView.clear();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean startCollapseAnimation(int i10) {
            DummyView dummyView;
            DummyView dummyView2;
            GroupInfo groupInfo = getGroupInfo(i10);
            boolean z10 = groupInfo.animating;
            if (z10 && groupInfo.expanding && (dummyView2 = groupInfo.dummyView) != null) {
                groupInfo.expanding = false;
                collapseAnimationStart(dummyView2, i10, groupInfo.isLastChild, groupInfo.dummyHeight);
                return false;
            }
            if (z10 && !groupInfo.expanding && (dummyView = groupInfo.dummyView) != null) {
                expandAnimationStart(dummyView, i10, groupInfo.isLastChild, groupInfo.totalHeight);
                groupInfo.expanding = true;
                return false;
            }
            groupInfo.animating = true;
            groupInfo.expanding = false;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean startExpandAnimation(int i10) {
            GroupInfo groupInfo = getGroupInfo(i10);
            if (groupInfo.animating && groupInfo.expanding) {
                return false;
            }
            groupInfo.animating = true;
            groupInfo.expanding = true;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void stopAnimation(int i10) {
            GroupInfo groupInfo = getGroupInfo(i10);
            groupInfo.dummyHeight = -1;
            groupInfo.animating = false;
            resetCache();
        }

        public ViewGroup.LayoutParams generateDefaultLayoutParams() {
            return new AbsListView.LayoutParams(-1, -2, 0);
        }

        @Override // android.widget.ExpandableListAdapter
        public Object getChild(int i10, int i11) {
            return this.listAdapter.getChild(i10, i10);
        }

        @Override // android.widget.ExpandableListAdapter
        public long getChildId(int i10, int i11) {
            return this.listAdapter.getChildId(i10, i11);
        }

        @Override // android.widget.BaseExpandableListAdapter, android.widget.HeterogeneousExpandableList
        public final int getChildType(int i10, int i11) {
            if (getGroupInfo(i10).animating) {
                return Integer.MIN_VALUE;
            }
            return getRealChildType(i10, i11);
        }

        @Override // android.widget.BaseExpandableListAdapter, android.widget.HeterogeneousExpandableList
        public final int getChildTypeCount() {
            ExpandableListAdapter expandableListAdapter = this.listAdapter;
            if (expandableListAdapter instanceof HeterogeneousExpandableList) {
                return ((HeterogeneousExpandableList) expandableListAdapter).getChildTypeCount() + 1;
            }
            return 2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:5:0x0012, code lost:
        
            if (r7 == (getGroupCount() - 1)) goto L9;
         */
        @Override // android.widget.ExpandableListAdapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final android.view.View getChildView(int r7, int r8, boolean r9, android.view.View r10, android.view.ViewGroup r11) {
            /*
                r6 = this;
                com.coui.appcompat.expandable.COUIExpandableListView$GroupInfo r0 = r6.getGroupInfo(r7)
                r0.isLastChild = r9
                boolean r0 = r0.animating
                if (r0 == 0) goto L1b
                if (r9 == 0) goto L15
                int r8 = r6.getGroupCount()
                r9 = 1
                int r8 = r8 - r9
                if (r7 != r8) goto L15
                goto L16
            L15:
                r9 = 0
            L16:
                android.view.View r6 = r6.getAnimationView(r7, r9, r10)
                return r6
            L1b:
                android.widget.ExpandableListAdapter r0 = r6.listAdapter
                r1 = r7
                r2 = r8
                r3 = r9
                r4 = r10
                r5 = r11
                android.view.View r6 = r0.getChildView(r1, r2, r3, r4, r5)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.expandable.COUIExpandableListView.InnerExpandableListAdapter.getChildView(int, int, boolean, android.view.View, android.view.ViewGroup):android.view.View");
        }

        @Override // android.widget.ExpandableListAdapter
        public final int getChildrenCount(int i10) {
            if (getGroupInfo(i10).animating) {
                return 1;
            }
            return this.listAdapter.getChildrenCount(i10);
        }

        @Override // android.widget.ExpandableListAdapter
        public Object getGroup(int i10) {
            return this.listAdapter.getGroup(i10);
        }

        @Override // android.widget.ExpandableListAdapter
        public int getGroupCount() {
            return this.listAdapter.getGroupCount();
        }

        @Override // android.widget.ExpandableListAdapter
        public long getGroupId(int i10) {
            return this.listAdapter.getGroupId(i10);
        }

        @Override // android.widget.ExpandableListAdapter
        public View getGroupView(int i10, boolean z10, View view, ViewGroup viewGroup) {
            return this.listAdapter.getGroupView(i10, z10, view, viewGroup);
        }

        @Override // android.widget.ExpandableListAdapter
        public boolean hasStableIds() {
            return this.listAdapter.hasStableIds();
        }

        @Override // android.widget.ExpandableListAdapter
        public boolean isChildSelectable(int i10, int i11) {
            if (getGroupInfo(i10).animating) {
                return false;
            }
            return this.listAdapter.isChildSelectable(i10, i11);
        }
    }

    public COUIExpandableListView(Context context) {
        this(context, null);
    }

    private void init() {
        setDivider(null);
        setChildDivider(null);
        setGroupIndicator(null);
        super.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() { // from class: com.coui.appcompat.expandable.COUIExpandableListView.1
            @Override // android.widget.ExpandableListView.OnGroupClickListener
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i10, long j10) {
                if (COUIExpandableListView.this.mGroupClickListener == null || !COUIExpandableListView.this.mGroupClickListener.onGroupClick(expandableListView, view, i10, j10)) {
                    COUIExpandableListView cOUIExpandableListView = COUIExpandableListView.this;
                    if (ExpandableListView.getPackedPositionGroup(cOUIExpandableListView.getExpandableListPosition(cOUIExpandableListView.getLastVisiblePosition())) == i10) {
                        COUIExpandableListView cOUIExpandableListView2 = COUIExpandableListView.this;
                        if (cOUIExpandableListView2.getChildAt(cOUIExpandableListView2.getChildCount() - 1).getBottom() >= COUIExpandableListView.this.getHeight() - COUIExpandableListView.this.getListPaddingBottom() && !expandableListView.isGroupExpanded(i10)) {
                            return false;
                        }
                    }
                    COUIExpandableListView.this.playSoundEffect(0);
                    if (expandableListView.isGroupExpanded(i10)) {
                        COUIExpandableListView.this.collapseGroup(i10);
                    } else {
                        COUIExpandableListView.this.expandGroup(i10);
                    }
                }
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void originCollapseGroup(int i10) {
        super.collapseGroup(i10);
    }

    @Override // android.widget.ExpandableListView
    public boolean collapseGroup(int i10) {
        boolean startCollapseAnimation = this.adapter.startCollapseAnimation(i10);
        if (startCollapseAnimation) {
            this.adapter.notifyDataSetChanged();
        }
        return startCollapseAnimation;
    }

    @Override // android.widget.ExpandableListView
    public boolean expandGroup(int i10) {
        if (this.adapter.startExpandAnimation(i10)) {
            boolean expandGroup = super.expandGroup(i10);
            if (!expandGroup) {
                this.adapter.stopAnimation(i10);
                return expandGroup;
            }
            return expandGroup;
        }
        return false;
    }

    @Override // android.widget.ExpandableListView
    public void setAdapter(ExpandableListAdapter expandableListAdapter) {
        InnerExpandableListAdapter innerExpandableListAdapter = new InnerExpandableListAdapter(expandableListAdapter, this);
        this.adapter = innerExpandableListAdapter;
        super.setAdapter(innerExpandableListAdapter);
    }

    @Override // android.widget.ExpandableListView
    public void setChildDivider(Drawable drawable) {
        if (drawable == null) {
            super.setChildDivider(null);
            return;
        }
        throw new RuntimeException("cannot set childDivider.");
    }

    @Override // android.widget.ListView
    public void setDivider(Drawable drawable) {
        if (drawable == null) {
            super.setDivider(null);
            return;
        }
        throw new RuntimeException("cannot set divider");
    }

    @Override // android.widget.ExpandableListView
    public void setGroupIndicator(Drawable drawable) {
        if (drawable == null) {
            super.setGroupIndicator(null);
            return;
        }
        throw new RuntimeException("cannot set groupIndicator.");
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams.height != -2) {
            super.setLayoutParams(layoutParams);
            return;
        }
        throw new RuntimeException("cannot set wrap_content");
    }

    @Override // android.widget.ExpandableListView
    public void setOnGroupClickListener(ExpandableListView.OnGroupClickListener onGroupClickListener) {
        this.mGroupClickListener = onGroupClickListener;
    }

    public COUIExpandableListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listViewStyle);
    }

    public COUIExpandableListView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        init();
    }

    /* loaded from: classes.dex */
    public static abstract class EndAnimatorListener implements Animator.AnimatorListener {
        private EndAnimatorListener() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }
}
