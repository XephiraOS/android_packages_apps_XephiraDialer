package com.coui.appcompat.scroll;

import android.content.Context;
import android.graphics.PointF;
import android.view.View;
import androidx.recyclerview.widget.COUIRecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.s;

/* loaded from: classes.dex */
public class COUIFlingLocateHelper {
    private static final int CENTER_ALIGN = 2;
    private static final int INVALID_ALIGN = 0;
    private static final int INVALID_POSITION = -1;
    private static final float ONE = 1.0f;
    private static final int START_ALIGN = 1;
    private static final String TAG = "COUIFlingLocateHelper";
    private Context mContext;
    private s mHorizontalHelper;
    private RecyclerView.o mLayoutManager;
    private OnCalculatePreChildDistanceListener mOnCalculatePreChildDistanceListener;
    private COUIRecyclerView mRecyclerView;
    private int mHorizontalItemAlign = 0;
    private boolean mEnableSnapToCenter = true;
    private RecyclerView.s mAlignScrollListener = new RecyclerView.s() { // from class: com.coui.appcompat.scroll.COUIFlingLocateHelper.1
        boolean mScrolled = false;

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void onScrollStateChanged(RecyclerView recyclerView, int i10) {
            super.onScrollStateChanged(recyclerView, i10);
            if (i10 == 0 && this.mScrolled) {
                this.mScrolled = false;
                COUIFlingLocateHelper.this.snapToTargetExistingView();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void onScrolled(RecyclerView recyclerView, int i10, int i11) {
            if (i10 != 0 || i11 != 0) {
                this.mScrolled = true;
            }
        }
    };

    /* loaded from: classes.dex */
    public interface OnCalculatePreChildDistanceListener {
        int onCalculatePreChildDistance();

        int onCalculateTargetPosition(int i10, int i11);
    }

    private float computeDistancePerChild(RecyclerView.o oVar, s sVar) {
        int childCount = oVar.getChildCount();
        if (childCount == 0) {
            return 1.0f;
        }
        View view = null;
        int i10 = Integer.MIN_VALUE;
        int i11 = Integer.MAX_VALUE;
        View view2 = null;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = oVar.getChildAt(i12);
            int position = oVar.getPosition(childAt);
            if (position != -1 && position != oVar.getItemCount() - 1 && position != 0) {
                if (position < i11) {
                    view = childAt;
                    i11 = position;
                }
                if (position > i10) {
                    view2 = childAt;
                    i10 = position;
                }
            }
        }
        if (view == null || view2 == null) {
            return 1.0f;
        }
        int max = Math.max(sVar.d(view), sVar.d(view2)) - Math.min(sVar.g(view), sVar.g(view2));
        if (max == 0) {
            return 1.0f;
        }
        return (max * 1.0f) / ((i10 - i11) + 1);
    }

    private View findCenterView(RecyclerView.o oVar, s sVar) {
        int childCount = oVar.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        int n10 = sVar.n() + (sVar.o() / 2);
        int i10 = Integer.MAX_VALUE;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = oVar.getChildAt(i11);
            int abs = Math.abs((oVar.getDecoratedLeft(childAt) + (oVar.getDecoratedMeasuredWidth(childAt) / 2)) - n10);
            if (abs < i10) {
                view = childAt;
                i10 = abs;
            }
        }
        return view;
    }

    private View findStartView(RecyclerView.o oVar, s sVar) {
        int n10;
        int g10;
        boolean z10;
        int childCount = oVar.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        if (oVar instanceof LinearLayoutManager) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) oVar;
            boolean z11 = true;
            if (linearLayoutManager.findFirstCompletelyVisibleItemPosition() == oVar.getItemCount() - 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (linearLayoutManager.findLastCompletelyVisibleItemPosition() != oVar.getItemCount() - 1) {
                z11 = false;
            }
            if (z10 || z11) {
                return null;
            }
        }
        if (isRtlMode(this.mContext)) {
            n10 = sVar.i();
        } else {
            n10 = sVar.n();
        }
        int i10 = Integer.MAX_VALUE;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = oVar.getChildAt(i11);
            if (isRtlMode(this.mContext)) {
                g10 = sVar.d(childAt);
            } else {
                g10 = sVar.g(childAt);
            }
            int abs = Math.abs(g10 - n10);
            if (abs < i10) {
                view = childAt;
                i10 = abs;
            }
        }
        return view;
    }

    private s getHorizontalHelper(RecyclerView.o oVar) {
        s sVar = this.mHorizontalHelper;
        if (sVar == null || sVar.k() != oVar) {
            this.mHorizontalHelper = s.a(oVar);
        }
        return this.mHorizontalHelper;
    }

    private RecyclerView.o getLayoutManager() {
        RecyclerView.o oVar = this.mLayoutManager;
        if (oVar == null || oVar != this.mRecyclerView.getLayoutManager()) {
            this.mLayoutManager = this.mRecyclerView.getLayoutManager();
        }
        return this.mLayoutManager;
    }

    private boolean isRtlMode(Context context) {
        if (context == null || context.getResources().getConfiguration().getLayoutDirection() != 1) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void snapToTargetExistingView() {
        RecyclerView.o layoutManager;
        View findSnapView;
        int g10;
        int n10;
        if ((!this.mEnableSnapToCenter && this.mHorizontalItemAlign == 2) || (layoutManager = getLayoutManager()) == null || (findSnapView = findSnapView(layoutManager)) == null) {
            return;
        }
        int i10 = this.mHorizontalItemAlign;
        if (i10 == 2) {
            int n11 = getHorizontalHelper(layoutManager).n() + (getHorizontalHelper(layoutManager).o() / 2);
            int itemCount = layoutManager.getItemCount() - 1;
            if (layoutManager.getPosition(findSnapView) == 0) {
                if (isRtlMode(this.mContext)) {
                    n11 = getHorizontalHelper(layoutManager).i() - (getHorizontalHelper(layoutManager).e(findSnapView) / 2);
                } else {
                    n11 = getHorizontalHelper(layoutManager).n() + (getHorizontalHelper(layoutManager).e(findSnapView) / 2);
                }
            }
            if (layoutManager.getPosition(findSnapView) == itemCount) {
                if (isRtlMode(this.mContext)) {
                    n11 = getHorizontalHelper(layoutManager).n() + (getHorizontalHelper(layoutManager).e(findSnapView) / 2);
                } else {
                    n11 = getHorizontalHelper(layoutManager).i() - (getHorizontalHelper(layoutManager).e(findSnapView) / 2);
                }
            }
            int g11 = (getHorizontalHelper(layoutManager).g(findSnapView) + (getHorizontalHelper(layoutManager).e(findSnapView) / 2)) - n11;
            if (Math.abs(g11) > 1.0f) {
                this.mRecyclerView.smoothScrollBy(g11, 0);
                return;
            }
            return;
        }
        if (i10 == 1) {
            if (isRtlMode(this.mContext)) {
                g10 = getHorizontalHelper(layoutManager).d(findSnapView);
                n10 = getHorizontalHelper(layoutManager).i();
            } else {
                g10 = getHorizontalHelper(layoutManager).g(findSnapView);
                n10 = getHorizontalHelper(layoutManager).n();
            }
            int i11 = g10 - n10;
            if (Math.abs(i11) > 1.0f) {
                this.mRecyclerView.smoothScrollBy(i11, 0);
            }
        }
    }

    public void attachToRecyclerView(COUIRecyclerView cOUIRecyclerView) {
        this.mRecyclerView = cOUIRecyclerView;
        this.mContext = cOUIRecyclerView.getContext();
    }

    public void cancelHorizontalItemAlign() {
        this.mHorizontalItemAlign = 0;
        this.mRecyclerView.removeOnScrollListener(this.mAlignScrollListener);
    }

    public View findSnapView(RecyclerView.o oVar) {
        if (oVar.canScrollHorizontally()) {
            int i10 = this.mHorizontalItemAlign;
            if (i10 == 2) {
                return findCenterView(oVar, getHorizontalHelper(oVar));
            }
            if (i10 == 1) {
                return findStartView(oVar, getHorizontalHelper(oVar));
            }
        }
        return null;
    }

    public int getHorizontalItemAlign() {
        return this.mHorizontalItemAlign;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int getTargetViewDistance(int i10) {
        View findSnapView;
        float f10;
        int i11;
        int i12;
        int n10;
        int g10;
        int i13;
        View view;
        int position;
        int g11;
        int position2;
        RecyclerView.o layoutManager = getLayoutManager();
        int itemCount = layoutManager.getItemCount();
        if (itemCount == 0 || (findSnapView = findSnapView(layoutManager)) == null) {
            return -1;
        }
        int position3 = layoutManager.getPosition(findSnapView);
        int i14 = itemCount - 1;
        PointF computeScrollVectorForPosition = ((RecyclerView.x.b) layoutManager).computeScrollVectorForPosition(i14);
        if (computeScrollVectorForPosition == null) {
            return -1;
        }
        if (layoutManager.canScrollHorizontally()) {
            OnCalculatePreChildDistanceListener onCalculatePreChildDistanceListener = this.mOnCalculatePreChildDistanceListener;
            if (onCalculatePreChildDistanceListener != null) {
                f10 = onCalculatePreChildDistanceListener.onCalculatePreChildDistance();
            } else {
                f10 = computeDistancePerChild(layoutManager, getHorizontalHelper(layoutManager));
            }
            i11 = Math.round(i10 / f10);
            if (computeScrollVectorForPosition.x < 0.0f) {
                i11 = -i11;
            }
        } else {
            f10 = 1.0f;
            i11 = 0;
        }
        OnCalculatePreChildDistanceListener onCalculatePreChildDistanceListener2 = this.mOnCalculatePreChildDistanceListener;
        if (onCalculatePreChildDistanceListener2 != null) {
            i12 = onCalculatePreChildDistanceListener2.onCalculateTargetPosition(position3, i11);
        } else {
            i12 = i11 + position3;
        }
        if (i12 != position3 && i12 >= 0 && i12 < itemCount) {
            int i15 = this.mHorizontalItemAlign;
            if (i15 == 2) {
                if (layoutManager.getPosition(findSnapView) == 0 && layoutManager.getChildCount() != 0) {
                    view = layoutManager.getChildAt(layoutManager.getChildCount() - 1);
                } else {
                    view = null;
                }
                if (layoutManager.getPosition(findSnapView) == i14 && layoutManager.getChildCount() != 0) {
                    view = layoutManager.getChildAt(0);
                }
                int n11 = getHorizontalHelper(layoutManager).n() + (getHorizontalHelper(layoutManager).o() / 2);
                if (view != null) {
                    if (isRtlMode(this.mContext)) {
                        position2 = -((int) ((i12 - layoutManager.getPosition(view)) * f10));
                    } else {
                        position2 = (int) ((i12 - layoutManager.getPosition(view)) * f10);
                    }
                    g11 = getHorizontalHelper(layoutManager).g(view) + (getHorizontalHelper(layoutManager).e(view) / 2) + position2;
                } else {
                    if (isRtlMode(this.mContext)) {
                        position = -((int) ((i12 - layoutManager.getPosition(findSnapView)) * f10));
                    } else {
                        position = (int) ((i12 - layoutManager.getPosition(findSnapView)) * f10);
                    }
                    g11 = getHorizontalHelper(layoutManager).g(findSnapView) + (getHorizontalHelper(layoutManager).e(findSnapView) / 2) + position;
                }
                return g11 - n11;
            }
            if (i15 == 1) {
                if (isRtlMode(this.mContext)) {
                    n10 = getHorizontalHelper(layoutManager).i();
                } else {
                    n10 = getHorizontalHelper(layoutManager).n();
                }
                if (isRtlMode(this.mContext)) {
                    g10 = getHorizontalHelper(layoutManager).d(findSnapView);
                } else {
                    g10 = getHorizontalHelper(layoutManager).g(findSnapView);
                }
                int i16 = i12 - position3;
                if (isRtlMode(this.mContext)) {
                    i13 = -((int) (i16 * f10));
                } else {
                    i13 = (int) (i16 * f10);
                }
                return (g10 + i13) - n10;
            }
        }
        return -1;
    }

    public void setEnableSnapToCenter(boolean z10) {
        this.mEnableSnapToCenter = z10;
    }

    public void setHorizontalItemAlign(int i10) {
        this.mHorizontalItemAlign = i10;
        this.mRecyclerView.addOnScrollListener(this.mAlignScrollListener);
    }

    public void setOnCalculatePreChildDistanceListener(OnCalculatePreChildDistanceListener onCalculatePreChildDistanceListener) {
        this.mOnCalculatePreChildDistanceListener = onCalculatePreChildDistanceListener;
    }

    public void trySnapToTargetExistingView() {
        if (this.mHorizontalItemAlign != 0) {
            snapToTargetExistingView();
        }
    }
}
