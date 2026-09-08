package com.coui.appcompat.preference;

import android.content.Context;
import android.view.View;
import androidx.preference.PreferenceScreen;
import androidx.preference.h;
import androidx.recyclerview.widget.COUIRecyclerView;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class COUIPreferenceItemDecoration extends COUIRecyclerView.a {
    private final int[] mChildLocation;
    private final int[] mItemLocation;
    private PreferenceScreen mPreferenceScreen;

    public COUIPreferenceItemDecoration(Context context, PreferenceScreen preferenceScreen) {
        super(context);
        this.mItemLocation = new int[2];
        this.mChildLocation = new int[2];
        this.mPreferenceScreen = preferenceScreen;
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.a
    public int getDividerInsetEnd(RecyclerView recyclerView, int i10) {
        int width;
        int width2;
        if (this.mPreferenceScreen == null) {
            return super.getDividerInsetEnd(recyclerView, i10);
        }
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter instanceof h) {
            View childAt = recyclerView.getChildAt(i10);
            Object j10 = ((h) adapter).j(recyclerView.getChildAdapterPosition(childAt));
            if (j10 != null && (j10 instanceof COUIRecyclerView.b)) {
                boolean z10 = true;
                if (childAt.getLayoutDirection() != 1) {
                    z10 = false;
                }
                COUIRecyclerView.b bVar = (COUIRecyclerView.b) j10;
                View dividerEndAlignView = bVar.getDividerEndAlignView();
                if (dividerEndAlignView != null) {
                    childAt.getLocationInWindow(this.mItemLocation);
                    dividerEndAlignView.getLocationInWindow(this.mChildLocation);
                    if (z10) {
                        width = this.mChildLocation[0] + dividerEndAlignView.getPaddingEnd();
                        width2 = this.mItemLocation[0];
                    } else {
                        width = this.mItemLocation[0] + childAt.getWidth();
                        width2 = (this.mChildLocation[0] + dividerEndAlignView.getWidth()) - dividerEndAlignView.getPaddingEnd();
                    }
                    return width - width2;
                }
                return bVar.getDividerEndInset();
            }
        }
        return super.getDividerInsetStart(recyclerView, i10);
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.a
    public int getDividerInsetStart(RecyclerView recyclerView, int i10) {
        int paddingStart;
        int i11;
        if (this.mPreferenceScreen == null) {
            return super.getDividerInsetStart(recyclerView, i10);
        }
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter instanceof h) {
            View childAt = recyclerView.getChildAt(i10);
            Object j10 = ((h) adapter).j(recyclerView.getChildAdapterPosition(childAt));
            if (j10 != null && (j10 instanceof COUIRecyclerView.b)) {
                boolean z10 = true;
                if (childAt.getLayoutDirection() != 1) {
                    z10 = false;
                }
                COUIRecyclerView.b bVar = (COUIRecyclerView.b) j10;
                View dividerStartAlignView = bVar.getDividerStartAlignView();
                if (dividerStartAlignView != null) {
                    childAt.getLocationInWindow(this.mItemLocation);
                    dividerStartAlignView.getLocationInWindow(this.mChildLocation);
                    if (z10) {
                        paddingStart = this.mItemLocation[0] + childAt.getWidth();
                        i11 = (this.mChildLocation[0] + dividerStartAlignView.getWidth()) - dividerStartAlignView.getPaddingStart();
                    } else {
                        paddingStart = this.mChildLocation[0] + dividerStartAlignView.getPaddingStart();
                        i11 = this.mItemLocation[0];
                    }
                    return paddingStart - i11;
                }
                return bVar.getDividerStartInset();
            }
        }
        return super.getDividerInsetStart(recyclerView, i10);
    }

    public PreferenceScreen getPreferenceScreen() {
        return this.mPreferenceScreen;
    }

    public void onDestroy() {
        this.mPreferenceScreen = null;
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.a
    public boolean shouldDrawDivider(RecyclerView recyclerView, int i10) {
        Object j10;
        if (this.mPreferenceScreen == null) {
            return false;
        }
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (!(adapter instanceof h) || (j10 = ((h) adapter).j(recyclerView.getChildAdapterPosition(recyclerView.getChildAt(i10)))) == null || !(j10 instanceof COUIRecyclerView.b)) {
            return false;
        }
        return ((COUIRecyclerView.b) j10).drawDivider();
    }
}
