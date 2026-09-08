package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: PagerSnapHelper.java */
/* loaded from: classes.dex */
public class t extends x {
    private static final int MAX_SCROLL_ON_FLING_DURATION = 100;
    private s mHorizontalHelper;
    private s mVerticalHelper;

    /* compiled from: PagerSnapHelper.java */
    /* loaded from: classes.dex */
    public class a extends o {
        public a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.o
        public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }

        @Override // androidx.recyclerview.widget.o
        public int calculateTimeForScrolling(int i10) {
            return Math.min(100, super.calculateTimeForScrolling(i10));
        }

        @Override // androidx.recyclerview.widget.o, androidx.recyclerview.widget.RecyclerView.x
        public void onTargetFound(View view, RecyclerView.y yVar, RecyclerView.x.a aVar) {
            t tVar = t.this;
            int[] calculateDistanceToFinalSnap = tVar.calculateDistanceToFinalSnap(tVar.mRecyclerView.getLayoutManager(), view);
            int i10 = calculateDistanceToFinalSnap[0];
            int i11 = calculateDistanceToFinalSnap[1];
            int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i10), Math.abs(i11)));
            if (calculateTimeForDeceleration > 0) {
                aVar.d(i10, i11, calculateTimeForDeceleration, this.mDecelerateInterpolator);
            }
        }
    }

    private int distanceToCenter(View view, s sVar) {
        return (sVar.g(view) + (sVar.e(view) / 2)) - (sVar.n() + (sVar.o() / 2));
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
            int abs = Math.abs((sVar.g(childAt) + (sVar.e(childAt) / 2)) - n10);
            if (abs < i10) {
                view = childAt;
                i10 = abs;
            }
        }
        return view;
    }

    private s getHorizontalHelper(RecyclerView.o oVar) {
        s sVar = this.mHorizontalHelper;
        if (sVar == null || sVar.f11200a != oVar) {
            this.mHorizontalHelper = s.a(oVar);
        }
        return this.mHorizontalHelper;
    }

    private s getOrientationHelper(RecyclerView.o oVar) {
        if (oVar.canScrollVertically()) {
            return getVerticalHelper(oVar);
        }
        if (oVar.canScrollHorizontally()) {
            return getHorizontalHelper(oVar);
        }
        return null;
    }

    private s getVerticalHelper(RecyclerView.o oVar) {
        s sVar = this.mVerticalHelper;
        if (sVar == null || sVar.f11200a != oVar) {
            this.mVerticalHelper = s.c(oVar);
        }
        return this.mVerticalHelper;
    }

    private boolean isForwardFling(RecyclerView.o oVar, int i10, int i11) {
        if (oVar.canScrollHorizontally()) {
            if (i10 <= 0) {
                return false;
            }
            return true;
        }
        if (i11 <= 0) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean isReverseLayout(RecyclerView.o oVar) {
        PointF computeScrollVectorForPosition;
        int itemCount = oVar.getItemCount();
        if (!(oVar instanceof RecyclerView.x.b) || (computeScrollVectorForPosition = ((RecyclerView.x.b) oVar).computeScrollVectorForPosition(itemCount - 1)) == null) {
            return false;
        }
        if (computeScrollVectorForPosition.x >= 0.0f && computeScrollVectorForPosition.y >= 0.0f) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.x
    public int[] calculateDistanceToFinalSnap(RecyclerView.o oVar, View view) {
        int[] iArr = new int[2];
        if (oVar.canScrollHorizontally()) {
            iArr[0] = distanceToCenter(view, getHorizontalHelper(oVar));
        } else {
            iArr[0] = 0;
        }
        if (oVar.canScrollVertically()) {
            iArr[1] = distanceToCenter(view, getVerticalHelper(oVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.x
    public RecyclerView.x createScroller(RecyclerView.o oVar) {
        if (!(oVar instanceof RecyclerView.x.b)) {
            return null;
        }
        return new a(this.mRecyclerView.getContext());
    }

    @Override // androidx.recyclerview.widget.x
    public View findSnapView(RecyclerView.o oVar) {
        if (oVar.canScrollVertically()) {
            return findCenterView(oVar, getVerticalHelper(oVar));
        }
        if (oVar.canScrollHorizontally()) {
            return findCenterView(oVar, getHorizontalHelper(oVar));
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.x
    public int findTargetSnapPosition(RecyclerView.o oVar, int i10, int i11) {
        s orientationHelper;
        int i12;
        int itemCount = oVar.getItemCount();
        if (itemCount == 0 || (orientationHelper = getOrientationHelper(oVar)) == null) {
            return -1;
        }
        int childCount = oVar.getChildCount();
        View view = null;
        int i13 = Integer.MAX_VALUE;
        int i14 = Integer.MIN_VALUE;
        View view2 = null;
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = oVar.getChildAt(i15);
            if (childAt != null) {
                int distanceToCenter = distanceToCenter(childAt, orientationHelper);
                if (distanceToCenter <= 0 && distanceToCenter > i14) {
                    view2 = childAt;
                    i14 = distanceToCenter;
                }
                if (distanceToCenter >= 0 && distanceToCenter < i13) {
                    view = childAt;
                    i13 = distanceToCenter;
                }
            }
        }
        boolean isForwardFling = isForwardFling(oVar, i10, i11);
        if (isForwardFling && view != null) {
            return oVar.getPosition(view);
        }
        if (!isForwardFling && view2 != null) {
            return oVar.getPosition(view2);
        }
        if (isForwardFling) {
            view = view2;
        }
        if (view == null) {
            return -1;
        }
        int position = oVar.getPosition(view);
        if (isReverseLayout(oVar) == isForwardFling) {
            i12 = -1;
        } else {
            i12 = 1;
        }
        int i16 = position + i12;
        if (i16 < 0 || i16 >= itemCount) {
            return -1;
        }
        return i16;
    }
}
