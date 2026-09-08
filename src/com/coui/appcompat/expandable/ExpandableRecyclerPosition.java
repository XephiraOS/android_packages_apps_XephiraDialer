package com.coui.appcompat.expandable;

import android.widget.ExpandableListView;
import java.util.ArrayList;

/* loaded from: classes.dex */
class ExpandableRecyclerPosition {
    public static final int CHILD = 1;
    public static final int GROUP = 2;
    private static final int MAX_POOL_SIZE = 5;
    private static ArrayList<ExpandableRecyclerPosition> sPool = new ArrayList<>(5);
    public int childPos;
    int flatListPos;
    public int groupPos;
    public int type;

    private ExpandableRecyclerPosition() {
    }

    private static ExpandableRecyclerPosition getRecycledOrCreate() {
        synchronized (sPool) {
            if (sPool.size() > 0) {
                ExpandableRecyclerPosition remove = sPool.remove(0);
                remove.resetState();
                return remove;
            }
            return new ExpandableRecyclerPosition();
        }
    }

    public static ExpandableRecyclerPosition obtain(int i10, int i11, int i12, int i13) {
        ExpandableRecyclerPosition recycledOrCreate = getRecycledOrCreate();
        recycledOrCreate.type = i10;
        recycledOrCreate.groupPos = i11;
        recycledOrCreate.childPos = i12;
        recycledOrCreate.flatListPos = i13;
        return recycledOrCreate;
    }

    public static ExpandableRecyclerPosition obtainChildPosition(int i10, int i11) {
        return obtain(1, i10, i11, 0);
    }

    public static ExpandableRecyclerPosition obtainGroupPosition(int i10) {
        return obtain(2, i10, 0, 0);
    }

    public static ExpandableRecyclerPosition obtainPosition(long j10) {
        if (j10 == 4294967295L) {
            return null;
        }
        ExpandableRecyclerPosition recycledOrCreate = getRecycledOrCreate();
        recycledOrCreate.groupPos = ExpandableListView.getPackedPositionGroup(j10);
        if (ExpandableListView.getPackedPositionType(j10) == 1) {
            recycledOrCreate.type = 1;
            recycledOrCreate.childPos = ExpandableListView.getPackedPositionChild(j10);
        } else {
            recycledOrCreate.type = 2;
        }
        return recycledOrCreate;
    }

    private void resetState() {
        this.groupPos = 0;
        this.childPos = 0;
        this.flatListPos = 0;
        this.type = 0;
    }

    public long getPackedPosition() {
        if (this.type == 1) {
            return ExpandableListView.getPackedPositionForChild(this.groupPos, this.childPos);
        }
        return ExpandableListView.getPackedPositionForGroup(this.groupPos);
    }

    public void recycle() {
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
