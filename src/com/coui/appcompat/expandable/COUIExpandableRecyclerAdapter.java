package com.coui.appcompat.expandable;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public interface COUIExpandableRecyclerAdapter {
    boolean areAllItemsEnabled();

    Object getChild(int i10, int i11);

    long getChildId(int i10, int i11);

    int getChildType(int i10, int i11);

    int getChildrenCount(int i10);

    long getCombinedChildId(long j10, long j11);

    long getCombinedGroupId(long j10);

    Object getGroup(int i10);

    int getGroupCount();

    long getGroupId(int i10);

    int getGroupType(int i10);

    int getGroupTypeCount();

    boolean hasStableIds();

    boolean isChildSelectable(int i10, int i11);

    boolean isEmpty();

    void onBindChildView(int i10, int i11, boolean z10, RecyclerView.B b10);

    void onBindGroupView(int i10, boolean z10, RecyclerView.B b10);

    RecyclerView.B onCreateChildView(ViewGroup viewGroup, int i10);

    RecyclerView.B onCreateGroupView(ViewGroup viewGroup, int i10);

    void onGroupCollapsed(int i10);

    void onGroupExpanded(int i10);

    void registerAdapterDataObserver(RecyclerView.i iVar);

    void setHasStableIds(boolean z10);

    void unregisterAdapterDataObserver(RecyclerView.i iVar);

    default void onRestoreView(RecyclerView.B b10, int i10) {
    }

    default void onViewRecycled(RecyclerView.B b10, RecyclerView recyclerView) {
    }
}
