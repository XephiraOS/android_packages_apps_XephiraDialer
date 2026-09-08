package com.coui.appcompat.expandable;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import androidx.recyclerview.widget.COUILinearLayoutManager;
import androidx.recyclerview.widget.COUIRecyclerView;
import androidx.recyclerview.widget.RecyclerView;
import com.coui.appcompat.animation.COUIMoveEaseInterpolator;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ExpandableRecyclerConnector extends RecyclerView.Adapter {
    private static final long ANIMATION_DURATION = 400;
    private static final int ANIMATION_TYPE = Integer.MIN_VALUE;
    private static final int EXPAND_THRESHOLD = 2;
    private static final int STATE_COLLAPSING = 2;
    private static final int STATE_EXPANDING = 1;
    private static final int STATE_IDLE = 0;
    private static final String TAG = "ExpandRecyclerConnector";
    private COUIExpandableRecyclerView expandableRecyclerView;
    private COUIExpandableRecyclerAdapter mExpandableListAdapter;
    private int mTotalExpChildrenCount;
    private SparseArray<GroupInfo> groupInfo = new SparseArray<>();
    private SparseArray<ExpandAnimator> animatorSparseArray = new SparseArray<>();
    private SparseArray<List<RecyclerView.B>> cacheChildView = new SparseArray<>();
    private SparseArray<List<RecyclerView.B>> showChildView = new SparseArray<>();
    private int mMaxExpGroupCount = Integer.MAX_VALUE;
    private final RecyclerView.i mDataSetObserver = new MyDataSetObserver();
    private SparseArray<Integer> typeMap = new SparseArray<>();
    private ArrayList<GroupMetadata> mExpGroupMetadataList = new ArrayList<>();

    /* loaded from: classes.dex */
    public static class AnimationViewHolder extends RecyclerView.B implements COUIRecyclerView.b {
        public AnimationViewHolder(View view) {
            super(view);
            view.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
        }

        @Override // androidx.recyclerview.widget.COUIRecyclerView.b
        public /* bridge */ /* synthetic */ boolean drawDivider() {
            return super.drawDivider();
        }

        @Override // androidx.recyclerview.widget.COUIRecyclerView.b
        public /* bridge */ /* synthetic */ View getDividerEndAlignView() {
            return super.getDividerEndAlignView();
        }

        @Override // androidx.recyclerview.widget.COUIRecyclerView.b
        public /* bridge */ /* synthetic */ int getDividerEndInset() {
            return super.getDividerEndInset();
        }

        @Override // androidx.recyclerview.widget.COUIRecyclerView.b
        public /* bridge */ /* synthetic */ View getDividerStartAlignView() {
            return super.getDividerStartAlignView();
        }

        @Override // androidx.recyclerview.widget.COUIRecyclerView.b
        public /* bridge */ /* synthetic */ int getDividerStartInset() {
            return super.getDividerStartInset();
        }
    }

    /* loaded from: classes.dex */
    public static class DummyView extends View {
        private List<RecyclerView.B> holders;
        private COUIExpandableRecyclerView mCOUIExpandableRecyclerView;
        private List<View> views;

        public DummyView(Context context, COUIExpandableRecyclerView cOUIExpandableRecyclerView) {
            super(context);
            this.views = new ArrayList();
            this.holders = new ArrayList();
            this.mCOUIExpandableRecyclerView = cOUIExpandableRecyclerView;
            COUIDarkModeUtil.setForceDarkAllow(this, false);
        }

        public void addFakeView(View view, RecyclerView.B b10) {
            this.views.add(view);
            this.holders.add(b10);
        }

        public void clearViews() {
            this.views.clear();
            this.holders.clear();
        }

        @Override // android.view.View
        public void dispatchDraw(Canvas canvas) {
            canvas.save();
            int size = this.views.size();
            int i10 = 0;
            for (int i11 = 0; i11 < size; i11++) {
                View view = this.views.get(i11);
                canvas.save();
                int measuredHeight = view.getMeasuredHeight();
                i10 += measuredHeight;
                canvas.clipRect(0, 0, getWidth(), measuredHeight);
                view.draw(canvas);
                if (i11 != size - 1) {
                    int itemDecorationCount = this.mCOUIExpandableRecyclerView.getItemDecorationCount();
                    for (int i12 = 0; i12 < itemDecorationCount; i12++) {
                        RecyclerView.n itemDecorationAt = this.mCOUIExpandableRecyclerView.getItemDecorationAt(i12);
                        if (itemDecorationAt instanceof COUIRecyclerView.a) {
                            ((COUIRecyclerView.a) itemDecorationAt).drawExpandableDivider(canvas, this.holders.get(i11));
                        }
                    }
                }
                canvas.restore();
                canvas.translate(0.0f, measuredHeight);
                if (i10 > canvas.getHeight()) {
                    break;
                }
            }
            canvas.restore();
        }

        @Override // android.view.View
        public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
            int i14 = i13 - i11;
            int size = this.views.size();
            int i15 = 0;
            for (int i16 = 0; i16 < size; i16++) {
                View view = this.views.get(i16);
                int measuredHeight = view.getMeasuredHeight();
                i15 += measuredHeight;
                view.layout(i10, i11, view.getMeasuredWidth() + i10, measuredHeight + i11);
                if (i15 > i14) {
                    return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class ExpandAnimator extends ValueAnimator {
        private boolean isFirst;
        private WeakReference<COUIExpandableRecyclerView> reference;

        public ExpandAnimator(COUIExpandableRecyclerView cOUIExpandableRecyclerView, long j10, TimeInterpolator timeInterpolator) {
            this.reference = new WeakReference<>(cOUIExpandableRecyclerView);
            setDuration(j10);
            setInterpolator(timeInterpolator);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void endAnimator() {
            removeAllUpdateListeners();
            end();
        }

        public void setParam(final boolean z10, final boolean z11, final int i10, final View view, final GroupInfo groupInfo, final int i11, final int i12) {
            Log.d(ExpandableRecyclerConnector.TAG, "setParam: " + z10 + ", isLastChild:" + z11 + " ,flatPos:" + i10 + " ,start:" + i11 + " ,end:" + i12);
            final int abs = Math.abs(i12 - i11);
            this.isFirst = true;
            setIntValues(i11, i12);
            removeAllUpdateListeners();
            addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.expandable.ExpandableRecyclerConnector.ExpandAnimator.1
                private void setDummyViewAlpha(int i13) {
                    int abs2;
                    if (abs != 0) {
                        if (z10) {
                            abs2 = Math.abs(i13 - i11);
                        } else {
                            abs2 = Math.abs(i13 - i12);
                        }
                        view.setAlpha(abs2 / abs);
                    }
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int i13;
                    COUIExpandableRecyclerView cOUIExpandableRecyclerView = (COUIExpandableRecyclerView) ExpandAnimator.this.reference.get();
                    if (cOUIExpandableRecyclerView == null) {
                        ExpandAnimator.this.endAnimator();
                        return;
                    }
                    int findFirstVisibleItemPosition = ((COUILinearLayoutManager) cOUIExpandableRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
                    int findLastVisibleItemPosition = ((COUILinearLayoutManager) cOUIExpandableRecyclerView.getLayoutManager()).findLastVisibleItemPosition();
                    if (!ExpandAnimator.this.isFirst && !z11 && (findFirstVisibleItemPosition > (i13 = i10) || findLastVisibleItemPosition < i13)) {
                        Log.d(ExpandableRecyclerConnector.TAG, "onAnimationUpdate1: " + findFirstVisibleItemPosition + "," + findLastVisibleItemPosition + "," + i10);
                        ExpandAnimator.this.endAnimator();
                        return;
                    }
                    if (!ExpandAnimator.this.isFirst && !z11 && z10 && i10 == findLastVisibleItemPosition) {
                        Log.d(ExpandableRecyclerConnector.TAG, "onAnimationUpdate2: " + findLastVisibleItemPosition + "," + i10);
                        ExpandAnimator.this.endAnimator();
                        return;
                    }
                    if (view == null) {
                        Log.d(ExpandableRecyclerConnector.TAG, "onAnimationUpdate4: view == null");
                        ExpandAnimator.this.endAnimator();
                        return;
                    }
                    if (ExpandAnimator.this.isFirst || !z11 || !z10 || view.getBottom() <= cOUIExpandableRecyclerView.getBottom()) {
                        ExpandAnimator.this.isFirst = false;
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        groupInfo.dummyHeight = intValue;
                        view.getLayoutParams().height = intValue;
                        setDummyViewAlpha(intValue);
                        cOUIExpandableRecyclerView.requestLayout();
                        return;
                    }
                    Log.d(ExpandableRecyclerConnector.TAG, "onAnimationUpdate3: " + view.getBottom() + "," + cOUIExpandableRecyclerView.getBottom());
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
        int totalHeight;

        private GroupInfo() {
            this.animating = false;
            this.expanding = false;
            this.totalHeight = -1;
            this.dummyHeight = -1;
        }
    }

    /* loaded from: classes.dex */
    public static class GroupMetadata implements Parcelable, Comparable<GroupMetadata> {
        public static final Parcelable.Creator<GroupMetadata> CREATOR = new Parcelable.Creator<GroupMetadata>() { // from class: com.coui.appcompat.expandable.ExpandableRecyclerConnector.GroupMetadata.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public GroupMetadata createFromParcel(Parcel parcel) {
                return GroupMetadata.obtain(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public GroupMetadata[] newArray(int i10) {
                return new GroupMetadata[i10];
            }
        };
        static final int REFRESH = -1;
        int flPos;
        long gId;
        int gPos;
        int lastChildFlPos;

        private GroupMetadata() {
        }

        public static GroupMetadata obtain(int i10, int i11, int i12, long j10) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.flPos = i10;
            groupMetadata.lastChildFlPos = i11;
            groupMetadata.gPos = i12;
            groupMetadata.gId = j10;
            return groupMetadata;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.flPos);
            parcel.writeInt(this.lastChildFlPos);
            parcel.writeInt(this.gPos);
            parcel.writeLong(this.gId);
        }

        @Override // java.lang.Comparable
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata != null) {
                return this.gPos - groupMetadata.gPos;
            }
            throw new IllegalArgumentException();
        }
    }

    /* loaded from: classes.dex */
    public static class PositionMetadata {
        private static final int MAX_POOL_SIZE = 5;
        private static ArrayList<PositionMetadata> sPool = new ArrayList<>(5);
        public int groupInsertIndex;
        public GroupMetadata groupMetadata;
        public ExpandableRecyclerPosition position;

        private PositionMetadata() {
        }

        private static PositionMetadata getRecycledOrCreate() {
            synchronized (sPool) {
                if (sPool.size() > 0) {
                    PositionMetadata remove = sPool.remove(0);
                    remove.resetState();
                    return remove;
                }
                return new PositionMetadata();
            }
        }

        public static PositionMetadata obtain(int i10, int i11, int i12, int i13, GroupMetadata groupMetadata, int i14) {
            PositionMetadata recycledOrCreate = getRecycledOrCreate();
            recycledOrCreate.position = ExpandableRecyclerPosition.obtain(i11, i12, i13, i10);
            recycledOrCreate.groupMetadata = groupMetadata;
            recycledOrCreate.groupInsertIndex = i14;
            return recycledOrCreate;
        }

        private void resetState() {
            ExpandableRecyclerPosition expandableRecyclerPosition = this.position;
            if (expandableRecyclerPosition != null) {
                expandableRecyclerPosition.recycle();
                this.position = null;
            }
            this.groupMetadata = null;
            this.groupInsertIndex = 0;
        }

        public boolean isExpanded() {
            if (this.groupMetadata != null) {
                return true;
            }
            return false;
        }

        public void recycle() {
            resetState();
            synchronized (sPool) {
                try {
                    if (sPool.size() < 5) {
                        sPool.add(this);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public ExpandableRecyclerConnector(COUIExpandableRecyclerAdapter cOUIExpandableRecyclerAdapter, COUIExpandableRecyclerView cOUIExpandableRecyclerView) {
        this.expandableRecyclerView = cOUIExpandableRecyclerView;
        setExpandableListAdapter(cOUIExpandableRecyclerAdapter);
    }

    private void addCache(RecyclerView.B b10, int i10, int i11) {
        int realChildType = getRealChildType(i10, i11);
        List<RecyclerView.B> list = this.showChildView.get(realChildType);
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(b10);
        this.showChildView.put(realChildType, list);
    }

    private void collapseAnimationStart(final DummyView dummyView, int i10, final int i11, int i12) {
        boolean z10;
        int i13;
        Log.d(TAG, "collapseAnimationStart:" + i10 + " ,groupPos:" + i11 + " , height:" + i12);
        GroupInfo groupInfo = getGroupInfo(i11);
        ExpandAnimator expandAnimator = this.animatorSparseArray.get(i11);
        if (expandAnimator == null) {
            expandAnimator = new ExpandAnimator(this.expandableRecyclerView, ANIMATION_DURATION, new COUIMoveEaseInterpolator());
            this.animatorSparseArray.put(i11, expandAnimator);
        } else {
            expandAnimator.removeAllListeners();
            expandAnimator.cancel();
        }
        if (i10 == getItemCount() - 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        int i14 = groupInfo.dummyHeight;
        if (i14 == -1) {
            i13 = i12;
        } else {
            i13 = i14;
        }
        expandAnimator.setParam(false, z10, i10, dummyView, groupInfo, i13, 0);
        expandAnimator.addListener(new EndAnimatorListener() { // from class: com.coui.appcompat.expandable.ExpandableRecyclerConnector.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                DummyView dummyView2 = dummyView;
                if (dummyView2 != null) {
                    dummyView2.clearViews();
                    ExpandableRecyclerConnector.this.stopAnimation(i11);
                    ExpandableRecyclerConnector.this.collapseGroup(i11);
                    dummyView.setTag(0);
                }
            }
        });
        expandAnimator.start();
        if (dummyView != null) {
            dummyView.setTag(2);
        }
    }

    private void expandAnimationStart(final DummyView dummyView, final int i10, final int i11, int i12) {
        boolean z10;
        int i13;
        Log.d(TAG, "expandAnimationStart:" + i10 + " ,groupPos:" + i11 + " , height:" + i12);
        GroupInfo groupInfo = getGroupInfo(i11);
        ExpandAnimator expandAnimator = this.animatorSparseArray.get(i11);
        if (expandAnimator == null) {
            expandAnimator = new ExpandAnimator(this.expandableRecyclerView, ANIMATION_DURATION, new COUIMoveEaseInterpolator());
            this.animatorSparseArray.put(i11, expandAnimator);
        } else {
            expandAnimator.removeAllListeners();
            expandAnimator.cancel();
        }
        if (i10 == getItemCount() - 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        int i14 = groupInfo.dummyHeight;
        if (i14 == -1) {
            i13 = 0;
        } else {
            i13 = i14;
        }
        expandAnimator.setParam(true, z10, i10, dummyView, groupInfo, i13, i12);
        expandAnimator.addListener(new EndAnimatorListener() { // from class: com.coui.appcompat.expandable.ExpandableRecyclerConnector.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                DummyView dummyView2 = dummyView;
                if (dummyView2 != null) {
                    dummyView2.clearViews();
                    ExpandableRecyclerConnector.this.stopAnimation(i11);
                    ExpandableRecyclerConnector.this.refreshExpGroupMetadataList(true, true);
                    ExpandableRecyclerConnector expandableRecyclerConnector = ExpandableRecyclerConnector.this;
                    expandableRecyclerConnector.notifyItemRangeChanged(i10 - 1, (expandableRecyclerConnector.getItemCount() - i10) + 1);
                    dummyView.setTag(0);
                }
            }
        });
        expandAnimator.start();
        if (dummyView != null) {
            dummyView.setTag(1);
        }
    }

    private RecyclerView.B getCacheViewHolder(int i10, int i11) {
        List<RecyclerView.B> list = this.cacheChildView.get(getRealChildType(i10, i11));
        if (list != null && !list.isEmpty()) {
            return list.remove(0);
        }
        return null;
    }

    private int getChildAllHeight(boolean z10, int i10, DummyView dummyView, int i11) {
        int i12;
        int bottom;
        int i13;
        int childCount = this.expandableRecyclerView.getLayoutManager().getChildCount();
        if (childCount > 0) {
            i12 = this.expandableRecyclerView.getLayoutManager().getChildAt(childCount - 1).getBottom();
        } else {
            i12 = 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.expandableRecyclerView.getWidth(), 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        if (z10 && this.expandableRecyclerView.getLayoutParams().height == -2) {
            bottom = this.expandableRecyclerView.getContext().getResources().getDisplayMetrics().heightPixels;
        } else {
            bottom = this.expandableRecyclerView.getBottom();
        }
        int childrenCount = this.mExpandableListAdapter.getChildrenCount(i10);
        int i14 = 0;
        for (int i15 = 0; i15 < childrenCount; i15++) {
            RecyclerView.B cacheViewHolder = getCacheViewHolder(i10, i15);
            if (cacheViewHolder == null) {
                cacheViewHolder = this.mExpandableListAdapter.onCreateChildView(this.expandableRecyclerView, getRealChildType(i10, i15));
            }
            addCache(cacheViewHolder, i10, i15);
            View view = cacheViewHolder.itemView;
            this.mExpandableListAdapter.onBindChildView(i10, i15, false, cacheViewHolder);
            this.mExpandableListAdapter.onRestoreView(cacheViewHolder, i11);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i16 = layoutParams.height;
            if (i16 > 0) {
                i13 = View.MeasureSpec.makeMeasureSpec(i16, 1073741824);
            } else {
                i13 = makeMeasureSpec2;
            }
            view.setLayoutDirection(this.expandableRecyclerView.getLayoutDirection());
            view.measure(makeMeasureSpec, i13);
            i14 += view.getMeasuredHeight();
            dummyView.addFakeView(view, cacheViewHolder);
            if ((!z10 && i14 + i12 > bottom) || (z10 && i14 > (bottom - i12) * 2)) {
                break;
            }
        }
        return i14;
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
        return this.mExpandableListAdapter.getChildType(i10, i11) + this.mExpandableListAdapter.getGroupTypeCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshExpGroupMetadataList(boolean z10, boolean z11) {
        int childCount;
        ArrayList<GroupMetadata> arrayList = this.mExpGroupMetadataList;
        int size = arrayList.size();
        int i10 = 0;
        this.mTotalExpChildrenCount = 0;
        if (z11) {
            boolean z12 = false;
            for (int i11 = size - 1; i11 >= 0; i11--) {
                GroupMetadata groupMetadata = arrayList.get(i11);
                int findGroupPosition = findGroupPosition(groupMetadata.gId, groupMetadata.gPos);
                if (findGroupPosition != groupMetadata.gPos) {
                    if (findGroupPosition == -1) {
                        arrayList.remove(i11);
                        size--;
                    }
                    groupMetadata.gPos = findGroupPosition;
                    if (!z12) {
                        z12 = true;
                    }
                }
            }
            if (z12) {
                Collections.sort(arrayList);
            }
        }
        int i12 = 0;
        int i13 = 0;
        while (i10 < size) {
            GroupMetadata groupMetadata2 = arrayList.get(i10);
            int i14 = groupMetadata2.lastChildFlPos;
            if (i14 != -1 && !z10) {
                childCount = i14 - groupMetadata2.flPos;
            } else {
                childCount = getChildCount(groupMetadata2.gPos);
            }
            this.mTotalExpChildrenCount += childCount;
            int i15 = groupMetadata2.gPos;
            int i16 = i12 + (i15 - i13);
            groupMetadata2.flPos = i16;
            i12 = i16 + childCount;
            groupMetadata2.lastChildFlPos = i12;
            i10++;
            i13 = i15;
        }
    }

    private void resetCache() {
        for (int i10 = 0; i10 < this.showChildView.size(); i10++) {
            List<RecyclerView.B> valueAt = this.showChildView.valueAt(i10);
            int keyAt = this.showChildView.keyAt(i10);
            List<RecyclerView.B> list = this.cacheChildView.get(keyAt);
            if (list == null) {
                list = new ArrayList<>();
                this.cacheChildView.put(keyAt, list);
            }
            list.addAll(valueAt);
        }
        this.showChildView.clear();
    }

    private boolean startExpandAnimation(int i10) {
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
        groupInfo.animating = false;
        groupInfo.dummyHeight = -1;
        resetCache();
    }

    public boolean collapseGroup(int i10) {
        ExpandableRecyclerPosition obtain = ExpandableRecyclerPosition.obtain(2, i10, -1, -1);
        PositionMetadata flattenedPos = getFlattenedPos(obtain);
        obtain.recycle();
        if (flattenedPos == null) {
            return false;
        }
        return collapseGroup(flattenedPos);
    }

    public void collapseGroupAnimator() {
        refreshExpGroupMetadataList(true, true);
        notifyItemRangeChanged(0, getItemCount());
    }

    public boolean expandGroup(int i10) {
        ExpandableRecyclerPosition obtain = ExpandableRecyclerPosition.obtain(2, i10, -1, -1);
        PositionMetadata flattenedPos = getFlattenedPos(obtain);
        obtain.recycle();
        if (flattenedPos == null) {
            return false;
        }
        return expandGroup(flattenedPos);
    }

    public int findGroupPosition(long j10, int i10) {
        int groupCount;
        boolean z10;
        boolean z11;
        COUIExpandableRecyclerAdapter cOUIExpandableRecyclerAdapter = this.mExpandableListAdapter;
        if (cOUIExpandableRecyclerAdapter == null || (groupCount = cOUIExpandableRecyclerAdapter.getGroupCount()) == 0 || j10 == Long.MIN_VALUE) {
            return -1;
        }
        int i11 = groupCount - 1;
        int min = Math.min(i11, Math.max(0, i10));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        int i12 = min;
        int i13 = i12;
        boolean z12 = false;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (cOUIExpandableRecyclerAdapter.getGroupId(min) == j10) {
                return min;
            }
            if (i12 == i11) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (i13 == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z10 && z11) {
                break;
            }
            if (!z11 && (!z12 || z10)) {
                if (z10 || (!z12 && !z11)) {
                    i13--;
                    z12 = true;
                    min = i13;
                }
            } else {
                i12++;
                z12 = false;
                min = i12;
            }
        }
        return -1;
    }

    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new AbsListView.LayoutParams(-1, -2, 0);
    }

    public int getChildCount(int i10) {
        if (getGroupInfo(i10).animating) {
            return 1;
        }
        return this.mExpandableListAdapter.getChildrenCount(i10);
    }

    public ArrayList<GroupMetadata> getExpandedGroupMetadataList() {
        return this.mExpGroupMetadataList;
    }

    public PositionMetadata getFlattenedPos(ExpandableRecyclerPosition expandableRecyclerPosition) {
        ArrayList<GroupMetadata> arrayList = this.mExpGroupMetadataList;
        int size = arrayList.size();
        int i10 = size - 1;
        if (size == 0) {
            int i11 = expandableRecyclerPosition.groupPos;
            return PositionMetadata.obtain(i11, expandableRecyclerPosition.type, i11, expandableRecyclerPosition.childPos, null, 0);
        }
        int i12 = 0;
        int i13 = 0;
        while (i13 <= i10) {
            int i14 = ((i10 - i13) / 2) + i13;
            GroupMetadata groupMetadata = arrayList.get(i14);
            int i15 = expandableRecyclerPosition.groupPos;
            int i16 = groupMetadata.gPos;
            if (i15 > i16) {
                i13 = i14 + 1;
            } else if (i15 < i16) {
                i10 = i14 - 1;
            } else if (i15 == i16) {
                int i17 = expandableRecyclerPosition.type;
                if (i17 == 2) {
                    return PositionMetadata.obtain(groupMetadata.flPos, i17, i15, expandableRecyclerPosition.childPos, groupMetadata, i14);
                }
                if (i17 != 1) {
                    return null;
                }
                int i18 = groupMetadata.flPos;
                int i19 = expandableRecyclerPosition.childPos;
                return PositionMetadata.obtain(i18 + i19 + 1, i17, i15, i19, groupMetadata, i14);
            }
            i12 = i14;
        }
        if (expandableRecyclerPosition.type != 2) {
            return null;
        }
        if (i13 > i12) {
            GroupMetadata groupMetadata2 = arrayList.get(i13 - 1);
            int i20 = groupMetadata2.lastChildFlPos;
            int i21 = expandableRecyclerPosition.groupPos;
            return PositionMetadata.obtain(i20 + (i21 - groupMetadata2.gPos), expandableRecyclerPosition.type, i21, expandableRecyclerPosition.childPos, null, i13);
        }
        if (i10 >= i12) {
            return null;
        }
        int i22 = i10 + 1;
        GroupMetadata groupMetadata3 = arrayList.get(i22);
        int i23 = groupMetadata3.flPos;
        int i24 = groupMetadata3.gPos;
        int i25 = expandableRecyclerPosition.groupPos;
        return PositionMetadata.obtain(i23 - (i24 - i25), expandableRecyclerPosition.type, i25, expandableRecyclerPosition.childPos, null, i22);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mExpandableListAdapter.getGroupCount() + this.mTotalExpChildrenCount;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i10) {
        long combinedChildId;
        PositionMetadata unflattenedPos = getUnflattenedPos(i10);
        long groupId = this.mExpandableListAdapter.getGroupId(unflattenedPos.position.groupPos);
        ExpandableRecyclerPosition expandableRecyclerPosition = unflattenedPos.position;
        int i11 = expandableRecyclerPosition.type;
        if (i11 == 2) {
            combinedChildId = this.mExpandableListAdapter.getCombinedGroupId(groupId);
        } else if (i11 == 1) {
            combinedChildId = this.mExpandableListAdapter.getCombinedChildId(groupId, this.mExpandableListAdapter.getChildId(expandableRecyclerPosition.groupPos, expandableRecyclerPosition.childPos));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        unflattenedPos.recycle();
        return combinedChildId;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i10) {
        int realChildType;
        PositionMetadata unflattenedPos = getUnflattenedPos(i10);
        ExpandableRecyclerPosition expandableRecyclerPosition = unflattenedPos.position;
        if (expandableRecyclerPosition.type == 2) {
            realChildType = this.mExpandableListAdapter.getGroupType(expandableRecyclerPosition.groupPos);
        } else if (getGroupInfo(expandableRecyclerPosition.groupPos).animating) {
            realChildType = Integer.MIN_VALUE;
        } else {
            realChildType = getRealChildType(expandableRecyclerPosition.groupPos, expandableRecyclerPosition.childPos);
        }
        this.typeMap.put(realChildType, Integer.valueOf(expandableRecyclerPosition.type));
        unflattenedPos.recycle();
        return realChildType;
    }

    public PositionMetadata getUnflattenedPos(int i10) {
        int i11;
        ArrayList<GroupMetadata> arrayList = this.mExpGroupMetadataList;
        int size = arrayList.size();
        int i12 = size - 1;
        if (size == 0) {
            return PositionMetadata.obtain(i10, 2, i10, -1, null, 0);
        }
        int i13 = 0;
        int i14 = i12;
        int i15 = 0;
        while (i13 <= i14) {
            int i16 = ((i14 - i13) / 2) + i13;
            GroupMetadata groupMetadata = arrayList.get(i16);
            int i17 = groupMetadata.lastChildFlPos;
            if (i10 > i17) {
                i13 = i16 + 1;
            } else {
                int i18 = groupMetadata.flPos;
                if (i10 < i18) {
                    i14 = i16 - 1;
                } else {
                    if (i10 == i18) {
                        return PositionMetadata.obtain(i10, 2, groupMetadata.gPos, -1, groupMetadata, i16);
                    }
                    if (i10 <= i17) {
                        return PositionMetadata.obtain(i10, 1, groupMetadata.gPos, i10 - (i18 + 1), groupMetadata, i16);
                    }
                }
            }
            i15 = i16;
        }
        if (i13 > i15) {
            GroupMetadata groupMetadata2 = arrayList.get(i13 - 1);
            i11 = (i10 - groupMetadata2.lastChildFlPos) + groupMetadata2.gPos;
        } else if (i14 < i15) {
            i13 = i14 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i13);
            i11 = groupMetadata3.gPos - (groupMetadata3.flPos - i10);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return PositionMetadata.obtain(i10, 2, i11, -1, null, i13);
    }

    public boolean isAllAnimatorEnd() {
        int findLastVisibleItemPosition = ((COUILinearLayoutManager) this.expandableRecyclerView.getLayoutManager()).findLastVisibleItemPosition();
        for (int findFirstVisibleItemPosition = ((COUILinearLayoutManager) this.expandableRecyclerView.getLayoutManager()).findFirstVisibleItemPosition(); findFirstVisibleItemPosition <= findLastVisibleItemPosition; findFirstVisibleItemPosition++) {
            if (getGroupInfo(findFirstVisibleItemPosition).animating) {
                return false;
            }
        }
        return true;
    }

    public boolean isGroupExpanded(int i10) {
        GroupInfo groupInfo = getGroupInfo(i10);
        for (int size = this.mExpGroupMetadataList.size() - 1; size >= 0; size--) {
            if (this.mExpGroupMetadataList.get(size).gPos == i10 && (!groupInfo.animating || groupInfo.expanding)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.B b10, final int i10) {
        PositionMetadata unflattenedPos = getUnflattenedPos(i10);
        int i11 = unflattenedPos.position.groupPos;
        GroupInfo groupInfo = getGroupInfo(i11);
        b10.itemView.setOnClickListener(null);
        ExpandableRecyclerPosition expandableRecyclerPosition = unflattenedPos.position;
        int i12 = expandableRecyclerPosition.type;
        if (i12 == 2) {
            this.mExpandableListAdapter.onBindGroupView(i11, unflattenedPos.isExpanded(), b10);
            this.mExpandableListAdapter.onRestoreView(b10, i10);
            b10.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.expandable.ExpandableRecyclerConnector.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ExpandableRecyclerConnector.this.expandableRecyclerView.handleClick(view, i10);
                }
            });
        } else {
            boolean z10 = false;
            int i13 = 0;
            if (groupInfo.animating) {
                DummyView dummyView = (DummyView) b10.itemView;
                dummyView.clearViews();
                int childAllHeight = getChildAllHeight(groupInfo.expanding, i11, dummyView, i10);
                groupInfo.totalHeight = childAllHeight;
                groupInfo.dummyView = dummyView;
                Object tag = dummyView.getTag();
                if (tag != null) {
                    i13 = ((Integer) tag).intValue();
                }
                boolean z11 = groupInfo.expanding;
                if (z11 && i13 != 1) {
                    expandAnimationStart(dummyView, i10, i11, childAllHeight);
                } else if (!z11 && i13 != 2) {
                    collapseAnimationStart(dummyView, i10, i11, childAllHeight);
                } else {
                    Log.e(TAG, "onBindViewHolder: state is no match:" + i13);
                }
            } else if (i12 == 1) {
                if (unflattenedPos.groupMetadata.lastChildFlPos == i10) {
                    z10 = true;
                }
                this.mExpandableListAdapter.onBindChildView(i11, expandableRecyclerPosition.childPos, z10, b10);
                this.mExpandableListAdapter.onRestoreView(b10, i10);
                if (this.mExpandableListAdapter.isChildSelectable(i11, unflattenedPos.position.childPos)) {
                    b10.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.expandable.ExpandableRecyclerConnector.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ExpandableRecyclerConnector.this.expandableRecyclerView.handleClick(view, i10);
                        }
                    });
                }
            } else {
                throw new RuntimeException("Flat list position is of unknown type");
            }
        }
        unflattenedPos.recycle();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.B onCreateViewHolder(ViewGroup viewGroup, int i10) {
        int i11;
        Integer num = this.typeMap.get(i10);
        if (num != null) {
            i11 = num.intValue();
        } else {
            i11 = 0;
        }
        if (i10 == Integer.MIN_VALUE) {
            return new AnimationViewHolder(new DummyView(viewGroup.getContext(), this.expandableRecyclerView));
        }
        if (i11 == 2) {
            return this.mExpandableListAdapter.onCreateGroupView(viewGroup, i10);
        }
        if (i11 == 1) {
            return this.mExpandableListAdapter.onCreateChildView(viewGroup, i10);
        }
        throw new RuntimeException("Flat list position is of unknown type");
    }

    public void setExpandableListAdapter(COUIExpandableRecyclerAdapter cOUIExpandableRecyclerAdapter) {
        COUIExpandableRecyclerAdapter cOUIExpandableRecyclerAdapter2 = this.mExpandableListAdapter;
        if (cOUIExpandableRecyclerAdapter2 != null) {
            cOUIExpandableRecyclerAdapter2.unregisterAdapterDataObserver(this.mDataSetObserver);
        }
        this.mExpandableListAdapter = cOUIExpandableRecyclerAdapter;
        setHasStableIds(cOUIExpandableRecyclerAdapter.hasStableIds());
        cOUIExpandableRecyclerAdapter.registerAdapterDataObserver(this.mDataSetObserver);
    }

    public void setExpandedGroupMetadataList(ArrayList<GroupMetadata> arrayList) {
        COUIExpandableRecyclerAdapter cOUIExpandableRecyclerAdapter;
        if (arrayList != null && (cOUIExpandableRecyclerAdapter = this.mExpandableListAdapter) != null) {
            int groupCount = cOUIExpandableRecyclerAdapter.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).gPos >= groupCount) {
                    return;
                }
            }
            this.mExpGroupMetadataList = arrayList;
            refreshExpGroupMetadataList(true, false);
        }
    }

    public void setMaxExpGroupCount(int i10) {
        this.mMaxExpGroupCount = i10;
    }

    public boolean startCollapseAnimation(int i10) {
        View view;
        DummyView dummyView;
        ExpandableRecyclerPosition obtain = ExpandableRecyclerPosition.obtain(2, i10, -1, -1);
        PositionMetadata flattenedPos = getFlattenedPos(obtain);
        obtain.recycle();
        if (flattenedPos != null) {
            view = ((COUILinearLayoutManager) this.expandableRecyclerView.getLayoutManager()).findViewByPosition(flattenedPos.position.flatListPos);
        } else {
            view = null;
        }
        if (view != null && view.getBottom() >= this.expandableRecyclerView.getHeight() - this.expandableRecyclerView.getPaddingBottom()) {
            GroupMetadata groupMetadata = flattenedPos.groupMetadata;
            int i11 = groupMetadata.flPos;
            this.mExpGroupMetadataList.remove(groupMetadata);
            refreshExpGroupMetadataList(false, false);
            notifyItemChanged(i11);
            this.mExpandableListAdapter.onGroupCollapsed(flattenedPos.groupMetadata.gPos);
            return false;
        }
        GroupInfo groupInfo = getGroupInfo(i10);
        boolean z10 = groupInfo.animating;
        if (z10 && groupInfo.expanding) {
            groupInfo.expanding = false;
            if (flattenedPos != null && (dummyView = groupInfo.dummyView) != null) {
                collapseAnimationStart(dummyView, flattenedPos.groupMetadata.flPos, i10, groupInfo.dummyHeight);
            }
            return false;
        }
        if (z10 && !groupInfo.expanding) {
            if (flattenedPos != null) {
                expandAnimationStart(groupInfo.dummyView, flattenedPos.groupMetadata.flPos, i10, groupInfo.totalHeight);
            }
            groupInfo.expanding = true;
            return false;
        }
        groupInfo.animating = true;
        groupInfo.expanding = false;
        return true;
    }

    /* loaded from: classes.dex */
    public class MyDataSetObserver extends RecyclerView.i {
        public MyDataSetObserver() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void onChanged() {
            ExpandableRecyclerConnector.this.refreshExpGroupMetadataList(true, true);
            ExpandableRecyclerConnector.this.notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void onItemRangeChanged(int i10, int i11) {
            ExpandableRecyclerConnector.this.refreshExpGroupMetadataList(true, true);
            ExpandableRecyclerConnector.this.notifyItemRangeChanged(i10, i11);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void onItemRangeInserted(int i10, int i11) {
            ExpandableRecyclerConnector.this.refreshExpGroupMetadataList(true, true);
            ExpandableRecyclerConnector.this.notifyItemRangeInserted(i10, i11);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void onItemRangeMoved(int i10, int i11, int i12) {
            ExpandableRecyclerConnector.this.refreshExpGroupMetadataList(true, true);
            ExpandableRecyclerConnector.this.notifyItemMoved(i10, i11);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void onItemRangeRemoved(int i10, int i11) {
            ExpandableRecyclerConnector.this.refreshExpGroupMetadataList(true, true);
            ExpandableRecyclerConnector.this.notifyItemRangeRemoved(i10, i11);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void onItemRangeChanged(int i10, int i11, Object obj) {
            onItemRangeChanged(i10, i11);
        }
    }

    public boolean collapseGroup(PositionMetadata positionMetadata) {
        GroupMetadata groupMetadata = positionMetadata.groupMetadata;
        if (groupMetadata == null) {
            return false;
        }
        this.mExpGroupMetadataList.remove(groupMetadata);
        refreshExpGroupMetadataList(false, false);
        notifyItemRangeChanged(0, getItemCount());
        this.mExpandableListAdapter.onGroupCollapsed(positionMetadata.groupMetadata.gPos);
        return true;
    }

    public boolean expandGroup(PositionMetadata positionMetadata) {
        if (positionMetadata.position.groupPos >= 0) {
            if (this.mMaxExpGroupCount == 0 || positionMetadata.groupMetadata != null) {
                return false;
            }
            if (this.mExpGroupMetadataList.size() >= this.mMaxExpGroupCount) {
                GroupMetadata groupMetadata = this.mExpGroupMetadataList.get(0);
                int indexOf = this.mExpGroupMetadataList.indexOf(groupMetadata);
                collapseGroup(groupMetadata.gPos);
                int i10 = positionMetadata.groupInsertIndex;
                if (i10 > indexOf) {
                    positionMetadata.groupInsertIndex = i10 - 1;
                }
            }
            int i11 = positionMetadata.position.groupPos;
            GroupMetadata obtain = GroupMetadata.obtain(-1, -1, i11, this.mExpandableListAdapter.getGroupId(i11));
            View findViewByPosition = ((COUILinearLayoutManager) this.expandableRecyclerView.getLayoutManager()).findViewByPosition(positionMetadata.position.flatListPos);
            if (findViewByPosition != null && findViewByPosition.getBottom() >= this.expandableRecyclerView.getHeight() - this.expandableRecyclerView.getPaddingBottom()) {
                this.mExpGroupMetadataList.add(positionMetadata.groupInsertIndex, obtain);
                refreshExpGroupMetadataList(false, false);
                this.mExpandableListAdapter.onGroupExpanded(obtain.gPos);
                notifyItemChanged(obtain.flPos);
                return false;
            }
            if (!startExpandAnimation(obtain.gPos)) {
                return false;
            }
            this.mExpGroupMetadataList.add(positionMetadata.groupInsertIndex, obtain);
            refreshExpGroupMetadataList(false, false);
            notifyItemRangeChanged(0, getItemCount());
            this.mExpandableListAdapter.onGroupExpanded(obtain.gPos);
            return true;
        }
        throw new RuntimeException("Need group");
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
