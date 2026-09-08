package com.coui.appcompat.expandable;

import android.content.Context;
import android.database.Observable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.COUILinearLayoutManager;
import androidx.recyclerview.widget.COUIRecyclerView;
import androidx.recyclerview.widget.RecyclerView;
import com.coui.appcompat.expandable.ExpandableRecyclerConnector;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class COUIExpandableRecyclerView extends COUIRecyclerView {
    private COUIExpandableRecyclerAdapter mAdapter;
    private ExpandableRecyclerConnector mConnector;
    private OnChildClickListener mOnChildClickListener;
    private OnGroupClickListener mOnGroupClickListener;
    private OnGroupCollapseListener mOnGroupCollapseListener;
    private OnGroupExpandListener mOnGroupExpandListener;
    private RecyclerView.v mRecyclerListener;

    /* loaded from: classes.dex */
    public static abstract class Adapter implements COUIExpandableRecyclerAdapter {
        private COUIRecyclerViewDataObserver mObservable = new COUIRecyclerViewDataObserver();
        private boolean mHasStableIds = false;

        @Override // com.coui.appcompat.expandable.COUIExpandableRecyclerAdapter
        public boolean areAllItemsEnabled() {
            return true;
        }

        @Override // com.coui.appcompat.expandable.COUIExpandableRecyclerAdapter
        public long getChildId(int i10, int i11) {
            return i11;
        }

        @Override // com.coui.appcompat.expandable.COUIExpandableRecyclerAdapter
        public int getChildType(int i10, int i11) {
            return 0;
        }

        @Override // com.coui.appcompat.expandable.COUIExpandableRecyclerAdapter
        public long getCombinedChildId(long j10, long j11) {
            return ((j10 & 2147483647L) << 32) | Long.MIN_VALUE | j11;
        }

        @Override // com.coui.appcompat.expandable.COUIExpandableRecyclerAdapter
        public long getCombinedGroupId(long j10) {
            return (j10 & 2147483647L) << 32;
        }

        @Override // com.coui.appcompat.expandable.COUIExpandableRecyclerAdapter
        public long getGroupId(int i10) {
            return i10;
        }

        @Override // com.coui.appcompat.expandable.COUIExpandableRecyclerAdapter
        public int getGroupType(int i10) {
            return 0;
        }

        @Override // com.coui.appcompat.expandable.COUIExpandableRecyclerAdapter
        public int getGroupTypeCount() {
            return 1;
        }

        @Override // com.coui.appcompat.expandable.COUIExpandableRecyclerAdapter
        public boolean hasStableIds() {
            return this.mHasStableIds;
        }

        @Override // com.coui.appcompat.expandable.COUIExpandableRecyclerAdapter
        public boolean isChildSelectable(int i10, int i11) {
            return true;
        }

        @Override // com.coui.appcompat.expandable.COUIExpandableRecyclerAdapter
        public boolean isEmpty() {
            if (getGroupCount() == 0) {
                return true;
            }
            return false;
        }

        public final void notifyDataSetChanged() {
            this.mObservable.notifyChanged();
        }

        public final void notifyItemChanged(int i10) {
            this.mObservable.notifyItemRangeChanged(i10, 1);
        }

        public final void notifyItemInserted(int i10) {
            this.mObservable.notifyItemRangeInserted(i10, 1);
        }

        public final void notifyItemMoved(int i10, int i11) {
            this.mObservable.notifyItemMoved(i10, i11);
        }

        public final void notifyItemRangeChanged(int i10, int i11) {
            this.mObservable.notifyItemRangeChanged(i10, i11);
        }

        public final void notifyItemRangeInserted(int i10, int i11) {
            this.mObservable.notifyItemRangeInserted(i10, i11);
        }

        public final void notifyItemRangeRemoved(int i10, int i11) {
            this.mObservable.notifyItemRangeRemoved(i10, i11);
        }

        public final void notifyItemRemoved(int i10) {
            this.mObservable.notifyItemRangeRemoved(i10, 1);
        }

        @Override // com.coui.appcompat.expandable.COUIExpandableRecyclerAdapter
        public void registerAdapterDataObserver(RecyclerView.i iVar) {
            this.mObservable.registerObserver(iVar);
        }

        @Override // com.coui.appcompat.expandable.COUIExpandableRecyclerAdapter
        public void setHasStableIds(boolean z10) {
            this.mHasStableIds = z10;
        }

        @Override // com.coui.appcompat.expandable.COUIExpandableRecyclerAdapter
        public void unregisterAdapterDataObserver(RecyclerView.i iVar) {
            this.mObservable.unregisterObserver(iVar);
        }

        public final void notifyItemChanged(int i10, Object obj) {
            this.mObservable.notifyItemRangeChanged(i10, 1, obj);
        }

        public final void notifyItemRangeChanged(int i10, int i11, Object obj) {
            this.mObservable.notifyItemRangeChanged(i10, i11, obj);
        }

        @Override // com.coui.appcompat.expandable.COUIExpandableRecyclerAdapter
        public void onGroupCollapsed(int i10) {
        }

        @Override // com.coui.appcompat.expandable.COUIExpandableRecyclerAdapter
        public void onGroupExpanded(int i10) {
        }
    }

    /* loaded from: classes.dex */
    public static class COUIRecyclerViewDataObserver extends Observable<RecyclerView.i> {
        public boolean hasObservers() {
            return !((Observable) this).mObservers.isEmpty();
        }

        public void notifyChanged() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((RecyclerView.i) ((Observable) this).mObservers.get(size)).onChanged();
            }
        }

        public void notifyItemMoved(int i10, int i11) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((RecyclerView.i) ((Observable) this).mObservers.get(size)).onItemRangeMoved(i10, i11, 1);
            }
        }

        public void notifyItemRangeChanged(int i10, int i11) {
            notifyItemRangeChanged(i10, i11, null);
        }

        public void notifyItemRangeInserted(int i10, int i11) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((RecyclerView.i) ((Observable) this).mObservers.get(size)).onItemRangeInserted(i10, i11);
            }
        }

        public void notifyItemRangeRemoved(int i10, int i11) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((RecyclerView.i) ((Observable) this).mObservers.get(size)).onItemRangeRemoved(i10, i11);
            }
        }

        public void notifyItemRangeChanged(int i10, int i11, Object obj) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((RecyclerView.i) ((Observable) this).mObservers.get(size)).onItemRangeChanged(i10, i11, obj);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface OnChildClickListener {
        boolean onChildClick(COUIRecyclerView cOUIRecyclerView, View view, int i10, int i11, long j10);
    }

    /* loaded from: classes.dex */
    public interface OnGroupClickListener {
        boolean onGroupClick(COUIExpandableRecyclerView cOUIExpandableRecyclerView, View view, int i10, long j10);
    }

    /* loaded from: classes.dex */
    public interface OnGroupCollapseListener {
        void onGroupCollapse(int i10);
    }

    /* loaded from: classes.dex */
    public interface OnGroupExpandListener {
        void onGroupExpand(int i10);
    }

    public COUIExpandableRecyclerView(Context context) {
        super(context);
        setItemAnimator(null);
    }

    private long getChildOrGroupId(ExpandableRecyclerPosition expandableRecyclerPosition) {
        if (expandableRecyclerPosition.type == 1) {
            return this.mAdapter.getChildId(expandableRecyclerPosition.groupPos, expandableRecyclerPosition.childPos);
        }
        return this.mAdapter.getGroupId(expandableRecyclerPosition.groupPos);
    }

    private void initRecyclerListener() {
        RecyclerView.v vVar = new RecyclerView.v() { // from class: com.coui.appcompat.expandable.COUIExpandableRecyclerView.1
            @Override // androidx.recyclerview.widget.RecyclerView.v
            public void onViewRecycled(RecyclerView.B b10) {
                if (COUIExpandableRecyclerView.this.mAdapter != null) {
                    COUIExpandableRecyclerView.this.mAdapter.onViewRecycled(b10, COUIExpandableRecyclerView.this);
                }
            }
        };
        this.mRecyclerListener = vVar;
        addRecyclerListener(vVar);
    }

    public boolean collapseGroup(int i10) {
        if (!this.mConnector.startCollapseAnimation(i10)) {
            return false;
        }
        this.mConnector.collapseGroupAnimator();
        OnGroupCollapseListener onGroupCollapseListener = this.mOnGroupCollapseListener;
        if (onGroupCollapseListener != null) {
            onGroupCollapseListener.onGroupCollapse(i10);
            return true;
        }
        return true;
    }

    public boolean expandGroup(int i10) {
        OnGroupExpandListener onGroupExpandListener;
        boolean expandGroup = this.mConnector.expandGroup(i10);
        if (expandGroup && (onGroupExpandListener = this.mOnGroupExpandListener) != null) {
            onGroupExpandListener.onGroupExpand(i10);
        }
        return expandGroup;
    }

    public boolean handleClick(View view, int i10) {
        boolean z10;
        ExpandableRecyclerConnector.PositionMetadata unflattenedPos = this.mConnector.getUnflattenedPos(i10);
        long childOrGroupId = getChildOrGroupId(unflattenedPos.position);
        ExpandableRecyclerPosition expandableRecyclerPosition = unflattenedPos.position;
        if (expandableRecyclerPosition.type == 2) {
            OnGroupClickListener onGroupClickListener = this.mOnGroupClickListener;
            z10 = true;
            if (onGroupClickListener != null && onGroupClickListener.onGroupClick(this, view, expandableRecyclerPosition.groupPos, childOrGroupId)) {
                unflattenedPos.recycle();
                return true;
            }
            if (unflattenedPos.isExpanded()) {
                collapseGroup(unflattenedPos.position.groupPos);
            } else {
                expandGroup(unflattenedPos.position.groupPos);
            }
        } else {
            OnChildClickListener onChildClickListener = this.mOnChildClickListener;
            if (onChildClickListener != null) {
                return onChildClickListener.onChildClick(this, view, expandableRecyclerPosition.groupPos, expandableRecyclerPosition.childPos, childOrGroupId);
            }
            z10 = false;
        }
        unflattenedPos.recycle();
        return z10;
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeRecyclerListener(this.mRecyclerListener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        ArrayList<ExpandableRecyclerConnector.GroupMetadata> arrayList;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        ExpandableRecyclerConnector expandableRecyclerConnector = this.mConnector;
        if (expandableRecyclerConnector != null && (arrayList = savedState.expandedGroupMetadataList) != null) {
            expandableRecyclerConnector.setExpandedGroupMetadataList(arrayList);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public Parcelable onSaveInstanceState() {
        ArrayList<ExpandableRecyclerConnector.GroupMetadata> arrayList;
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        ExpandableRecyclerConnector expandableRecyclerConnector = this.mConnector;
        if (expandableRecyclerConnector != null) {
            arrayList = expandableRecyclerConnector.getExpandedGroupMetadataList();
        } else {
            arrayList = null;
        }
        return new SavedState(onSaveInstanceState, arrayList);
    }

    public void setAdapter(COUIExpandableRecyclerAdapter cOUIExpandableRecyclerAdapter) {
        this.mAdapter = cOUIExpandableRecyclerAdapter;
        ExpandableRecyclerConnector expandableRecyclerConnector = new ExpandableRecyclerConnector(cOUIExpandableRecyclerAdapter, this);
        this.mConnector = expandableRecyclerConnector;
        super.setAdapter(expandableRecyclerConnector);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setItemAnimator(RecyclerView.l lVar) {
        if (lVar == null) {
            super.setItemAnimator(null);
            initRecyclerListener();
            return;
        }
        throw new RuntimeException("not set ItemAnimator");
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView, androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(RecyclerView.o oVar) {
        if (oVar instanceof COUILinearLayoutManager) {
            if (((COUILinearLayoutManager) oVar).getOrientation() == 1) {
                super.setLayoutManager(oVar);
                return;
            }
            throw new RuntimeException("only vertical orientation");
        }
        throw new RuntimeException("only COUILinearLayoutManager");
    }

    public void setOnChildClickListener(OnChildClickListener onChildClickListener) {
        this.mOnChildClickListener = onChildClickListener;
    }

    public void setOnGroupClickListener(OnGroupClickListener onGroupClickListener) {
        this.mOnGroupClickListener = onGroupClickListener;
    }

    public void setOnGroupCollapseListener(OnGroupCollapseListener onGroupCollapseListener) {
        this.mOnGroupCollapseListener = onGroupCollapseListener;
    }

    public void setOnGroupExpandListener(OnGroupExpandListener onGroupExpandListener) {
        this.mOnGroupExpandListener = onGroupExpandListener;
    }

    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.coui.appcompat.expandable.COUIExpandableRecyclerView.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, ExpandableRecyclerConnector.class.getClassLoader());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        };
        ArrayList<ExpandableRecyclerConnector.GroupMetadata> expandedGroupMetadataList;

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeList(this.expandedGroupMetadataList);
        }

        public SavedState(Parcelable parcelable, ArrayList<ExpandableRecyclerConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.expandedGroupMetadataList = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            ArrayList<ExpandableRecyclerConnector.GroupMetadata> arrayList = new ArrayList<>();
            this.expandedGroupMetadataList = arrayList;
            parcel.readList(arrayList, ExpandableRecyclerConnector.class.getClassLoader());
        }

        private SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            ArrayList<ExpandableRecyclerConnector.GroupMetadata> arrayList = new ArrayList<>();
            this.expandedGroupMetadataList = arrayList;
            parcel.readList(arrayList, ExpandableRecyclerConnector.class.getClassLoader());
        }
    }

    public COUIExpandableRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setItemAnimator(null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        throw new RuntimeException("adapter instansof COUIExpandableRecyclerAdapter");
    }

    public COUIExpandableRecyclerView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        setItemAnimator(null);
    }
}
