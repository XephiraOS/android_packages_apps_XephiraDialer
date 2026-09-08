package androidx.recyclerview.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: SnapHelper.java */
/* loaded from: classes.dex */
public abstract class x extends RecyclerView.q {
    static final float MILLISECONDS_PER_INCH = 100.0f;
    private Scroller mGravityScroller;
    RecyclerView mRecyclerView;
    private final RecyclerView.s mScrollListener = new a();

    /* compiled from: SnapHelper.java */
    /* loaded from: classes.dex */
    public class a extends RecyclerView.s {

        /* renamed from: a, reason: collision with root package name */
        public boolean f11207a = false;

        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void onScrollStateChanged(RecyclerView recyclerView, int i10) {
            super.onScrollStateChanged(recyclerView, i10);
            if (i10 == 0 && this.f11207a) {
                this.f11207a = false;
                x.this.snapToTargetExistingView();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void onScrolled(RecyclerView recyclerView, int i10, int i11) {
            if (i10 != 0 || i11 != 0) {
                this.f11207a = true;
            }
        }
    }

    /* compiled from: SnapHelper.java */
    /* loaded from: classes.dex */
    public class b extends o {
        public b(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.o
        public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return x.MILLISECONDS_PER_INCH / displayMetrics.densityDpi;
        }

        @Override // androidx.recyclerview.widget.o, androidx.recyclerview.widget.RecyclerView.x
        public void onTargetFound(View view, RecyclerView.y yVar, RecyclerView.x.a aVar) {
            x xVar = x.this;
            RecyclerView recyclerView = xVar.mRecyclerView;
            if (recyclerView == null) {
                return;
            }
            int[] calculateDistanceToFinalSnap = xVar.calculateDistanceToFinalSnap(recyclerView.getLayoutManager(), view);
            int i10 = calculateDistanceToFinalSnap[0];
            int i11 = calculateDistanceToFinalSnap[1];
            int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i10), Math.abs(i11)));
            if (calculateTimeForDeceleration > 0) {
                aVar.d(i10, i11, calculateTimeForDeceleration, this.mDecelerateInterpolator);
            }
        }
    }

    private void destroyCallbacks() {
        this.mRecyclerView.removeOnScrollListener(this.mScrollListener);
        this.mRecyclerView.setOnFlingListener(null);
    }

    private void setupCallbacks() {
        if (this.mRecyclerView.getOnFlingListener() == null) {
            this.mRecyclerView.addOnScrollListener(this.mScrollListener);
            this.mRecyclerView.setOnFlingListener(this);
            return;
        }
        throw new IllegalStateException("An instance of OnFlingListener already set.");
    }

    private boolean snapFromFling(RecyclerView.o oVar, int i10, int i11) {
        RecyclerView.x createScroller;
        int findTargetSnapPosition;
        if (!(oVar instanceof RecyclerView.x.b) || (createScroller = createScroller(oVar)) == null || (findTargetSnapPosition = findTargetSnapPosition(oVar, i10, i11)) == -1) {
            return false;
        }
        createScroller.setTargetPosition(findTargetSnapPosition);
        oVar.startSmoothScroll(createScroller);
        return true;
    }

    public void attachToRecyclerView(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            destroyCallbacks();
        }
        this.mRecyclerView = recyclerView;
        if (recyclerView != null) {
            setupCallbacks();
            this.mGravityScroller = new Scroller(this.mRecyclerView.getContext(), new DecelerateInterpolator());
            snapToTargetExistingView();
        }
    }

    public abstract int[] calculateDistanceToFinalSnap(RecyclerView.o oVar, View view);

    public int[] calculateScrollDistance(int i10, int i11) {
        this.mGravityScroller.fling(0, 0, i10, i11, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return new int[]{this.mGravityScroller.getFinalX(), this.mGravityScroller.getFinalY()};
    }

    public RecyclerView.x createScroller(RecyclerView.o oVar) {
        return createSnapScroller(oVar);
    }

    @Deprecated
    public o createSnapScroller(RecyclerView.o oVar) {
        if (!(oVar instanceof RecyclerView.x.b)) {
            return null;
        }
        return new b(this.mRecyclerView.getContext());
    }

    public abstract View findSnapView(RecyclerView.o oVar);

    public abstract int findTargetSnapPosition(RecyclerView.o oVar, int i10, int i11);

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public boolean onFling(int i10, int i11) {
        RecyclerView.o layoutManager = this.mRecyclerView.getLayoutManager();
        if (layoutManager == null || this.mRecyclerView.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.mRecyclerView.getMinFlingVelocity();
        if ((Math.abs(i11) <= minFlingVelocity && Math.abs(i10) <= minFlingVelocity) || !snapFromFling(layoutManager, i10, i11)) {
            return false;
        }
        return true;
    }

    public void snapToTargetExistingView() {
        RecyclerView.o layoutManager;
        View findSnapView;
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || (findSnapView = findSnapView(layoutManager)) == null) {
            return;
        }
        int[] calculateDistanceToFinalSnap = calculateDistanceToFinalSnap(layoutManager, findSnapView);
        int i10 = calculateDistanceToFinalSnap[0];
        if (i10 != 0 || calculateDistanceToFinalSnap[1] != 0) {
            this.mRecyclerView.smoothScrollBy(i10, calculateDistanceToFinalSnap[1]);
        }
    }
}
