package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.oplus.backup.sdk.common.utils.ModuleType;
import java.util.List;

/* loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.o implements RecyclerView.x.b {
    static final boolean DEBUG = false;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "LinearLayoutManager";
    public static final int VERTICAL = 1;
    final a mAnchorInfo;
    private int mInitialPrefetchItemCount;
    private boolean mLastStackFromEnd;
    private final b mLayoutChunkResult;
    private c mLayoutState;
    int mOrientation;
    s mOrientationHelper;
    SavedState mPendingSavedState;
    int mPendingScrollPosition;
    int mPendingScrollPositionOffset;
    private boolean mRecycleChildrenOnDetach;
    private int[] mReusableIntPair;
    private boolean mReverseLayout;
    boolean mShouldReverseLayout;
    private boolean mSmoothScrollbarEnabled;
    private boolean mStackFromEnd;

    /* loaded from: classes.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public int f10840a;

        /* renamed from: b, reason: collision with root package name */
        public int f10841b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f10842c;

        /* loaded from: classes.dex */
        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState() {
        }

        public boolean b() {
            if (this.f10840a >= 0) {
                return true;
            }
            return false;
        }

        public void d() {
            this.f10840a = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f10840a);
            parcel.writeInt(this.f10841b);
            parcel.writeInt(this.f10842c ? 1 : 0);
        }

        public SavedState(Parcel parcel) {
            this.f10840a = parcel.readInt();
            this.f10841b = parcel.readInt();
            this.f10842c = parcel.readInt() == 1;
        }

        public SavedState(SavedState savedState) {
            this.f10840a = savedState.f10840a;
            this.f10841b = savedState.f10841b;
            this.f10842c = savedState.f10842c;
        }
    }

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public s f10843a;

        /* renamed from: b, reason: collision with root package name */
        public int f10844b;

        /* renamed from: c, reason: collision with root package name */
        public int f10845c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f10846d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f10847e;

        public a() {
            e();
        }

        public void a() {
            int n10;
            if (this.f10846d) {
                n10 = this.f10843a.i();
            } else {
                n10 = this.f10843a.n();
            }
            this.f10845c = n10;
        }

        public void b(View view, int i10) {
            if (this.f10846d) {
                this.f10845c = this.f10843a.d(view) + this.f10843a.p();
            } else {
                this.f10845c = this.f10843a.g(view);
            }
            this.f10844b = i10;
        }

        public void c(View view, int i10) {
            int p10 = this.f10843a.p();
            if (p10 >= 0) {
                b(view, i10);
                return;
            }
            this.f10844b = i10;
            if (this.f10846d) {
                int i11 = (this.f10843a.i() - p10) - this.f10843a.d(view);
                this.f10845c = this.f10843a.i() - i11;
                if (i11 > 0) {
                    int e10 = this.f10845c - this.f10843a.e(view);
                    int n10 = this.f10843a.n();
                    int min = e10 - (n10 + Math.min(this.f10843a.g(view) - n10, 0));
                    if (min < 0) {
                        this.f10845c += Math.min(i11, -min);
                        return;
                    }
                    return;
                }
                return;
            }
            int g10 = this.f10843a.g(view);
            int n11 = g10 - this.f10843a.n();
            this.f10845c = g10;
            if (n11 > 0) {
                int i12 = (this.f10843a.i() - Math.min(0, (this.f10843a.i() - p10) - this.f10843a.d(view))) - (g10 + this.f10843a.e(view));
                if (i12 < 0) {
                    this.f10845c -= Math.min(n11, -i12);
                }
            }
        }

        public boolean d(View view, RecyclerView.y yVar) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            if (!layoutParams.c() && layoutParams.a() >= 0 && layoutParams.a() < yVar.b()) {
                return true;
            }
            return false;
        }

        public void e() {
            this.f10844b = -1;
            this.f10845c = Integer.MIN_VALUE;
            this.f10846d = false;
            this.f10847e = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f10844b + ", mCoordinate=" + this.f10845c + ", mLayoutFromEnd=" + this.f10846d + ", mValid=" + this.f10847e + '}';
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f10848a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f10849b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f10850c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f10851d;

        public void a() {
            this.f10848a = 0;
            this.f10849b = false;
            this.f10850c = false;
            this.f10851d = false;
        }
    }

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: b, reason: collision with root package name */
        public int f10853b;

        /* renamed from: c, reason: collision with root package name */
        public int f10854c;

        /* renamed from: d, reason: collision with root package name */
        public int f10855d;

        /* renamed from: e, reason: collision with root package name */
        public int f10856e;

        /* renamed from: f, reason: collision with root package name */
        public int f10857f;

        /* renamed from: g, reason: collision with root package name */
        public int f10858g;

        /* renamed from: k, reason: collision with root package name */
        public int f10862k;

        /* renamed from: m, reason: collision with root package name */
        public boolean f10864m;

        /* renamed from: a, reason: collision with root package name */
        public boolean f10852a = true;

        /* renamed from: h, reason: collision with root package name */
        public int f10859h = 0;

        /* renamed from: i, reason: collision with root package name */
        public int f10860i = 0;

        /* renamed from: j, reason: collision with root package name */
        public boolean f10861j = false;

        /* renamed from: l, reason: collision with root package name */
        public List<RecyclerView.B> f10863l = null;

        public void a() {
            b(null);
        }

        public void b(View view) {
            View f10 = f(view);
            if (f10 == null) {
                this.f10855d = -1;
            } else {
                this.f10855d = ((RecyclerView.LayoutParams) f10.getLayoutParams()).a();
            }
        }

        public boolean c(RecyclerView.y yVar) {
            int i10 = this.f10855d;
            if (i10 >= 0 && i10 < yVar.b()) {
                return true;
            }
            return false;
        }

        public View d(RecyclerView.u uVar) {
            if (this.f10863l != null) {
                return e();
            }
            View o10 = uVar.o(this.f10855d);
            this.f10855d += this.f10856e;
            return o10;
        }

        public final View e() {
            int size = this.f10863l.size();
            for (int i10 = 0; i10 < size; i10++) {
                View view = this.f10863l.get(i10).itemView;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                if (!layoutParams.c() && this.f10855d == layoutParams.a()) {
                    b(view);
                    return view;
                }
            }
            return null;
        }

        public View f(View view) {
            int a10;
            int size = this.f10863l.size();
            View view2 = null;
            int i10 = Integer.MAX_VALUE;
            for (int i11 = 0; i11 < size; i11++) {
                View view3 = this.f10863l.get(i11).itemView;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view3.getLayoutParams();
                if (view3 != view && !layoutParams.c() && (a10 = (layoutParams.a() - this.f10855d) * this.f10856e) >= 0 && a10 < i10) {
                    view2 = view3;
                    if (a10 == 0) {
                        break;
                    }
                    i10 = a10;
                }
            }
            return view2;
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    private int computeScrollExtent(RecyclerView.y yVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return v.a(yVar, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private int computeScrollOffset(RecyclerView.y yVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return v.b(yVar, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    private int computeScrollRange(RecyclerView.y yVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return v.c(yVar, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private View findFirstPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(0, getChildCount());
    }

    private View findLastPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(getChildCount() - 1, -1);
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToEnd() {
        if (this.mShouldReverseLayout) {
            return findFirstPartiallyOrCompletelyInvisibleChild();
        }
        return findLastPartiallyOrCompletelyInvisibleChild();
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToStart() {
        if (this.mShouldReverseLayout) {
            return findLastPartiallyOrCompletelyInvisibleChild();
        }
        return findFirstPartiallyOrCompletelyInvisibleChild();
    }

    private int fixLayoutEndGap(int i10, RecyclerView.u uVar, RecyclerView.y yVar, boolean z10) {
        int i11;
        int i12 = this.mOrientationHelper.i() - i10;
        if (i12 > 0) {
            int i13 = -scrollBy(-i12, uVar, yVar);
            int i14 = i10 + i13;
            if (z10 && (i11 = this.mOrientationHelper.i() - i14) > 0) {
                this.mOrientationHelper.s(i11);
                return i11 + i13;
            }
            return i13;
        }
        return 0;
    }

    private int fixLayoutStartGap(int i10, RecyclerView.u uVar, RecyclerView.y yVar, boolean z10) {
        int n10;
        int n11 = i10 - this.mOrientationHelper.n();
        if (n11 > 0) {
            int i11 = -scrollBy(n11, uVar, yVar);
            int i12 = i10 + i11;
            if (z10 && (n10 = i12 - this.mOrientationHelper.n()) > 0) {
                this.mOrientationHelper.s(-n10);
                return i11 - n10;
            }
            return i11;
        }
        return 0;
    }

    private View getChildClosestToEnd() {
        int childCount;
        if (this.mShouldReverseLayout) {
            childCount = 0;
        } else {
            childCount = getChildCount() - 1;
        }
        return getChildAt(childCount);
    }

    private View getChildClosestToStart() {
        int i10;
        if (this.mShouldReverseLayout) {
            i10 = getChildCount() - 1;
        } else {
            i10 = 0;
        }
        return getChildAt(i10);
    }

    private void layoutForPredictiveAnimations(RecyclerView.u uVar, RecyclerView.y yVar, int i10, int i11) {
        boolean z10;
        if (yVar.g() && getChildCount() != 0 && !yVar.e() && supportsPredictiveItemAnimations()) {
            List<RecyclerView.B> k10 = uVar.k();
            int size = k10.size();
            int position = getPosition(getChildAt(0));
            int i12 = 0;
            int i13 = 0;
            for (int i14 = 0; i14 < size; i14++) {
                RecyclerView.B b10 = k10.get(i14);
                if (!b10.isRemoved()) {
                    if (b10.getLayoutPosition() < position) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (z10 != this.mShouldReverseLayout) {
                        i12 += this.mOrientationHelper.e(b10.itemView);
                    } else {
                        i13 += this.mOrientationHelper.e(b10.itemView);
                    }
                }
            }
            this.mLayoutState.f10863l = k10;
            if (i12 > 0) {
                updateLayoutStateToFillStart(getPosition(getChildClosestToStart()), i10);
                c cVar = this.mLayoutState;
                cVar.f10859h = i12;
                cVar.f10854c = 0;
                cVar.a();
                fill(uVar, this.mLayoutState, yVar, false);
            }
            if (i13 > 0) {
                updateLayoutStateToFillEnd(getPosition(getChildClosestToEnd()), i11);
                c cVar2 = this.mLayoutState;
                cVar2.f10859h = i13;
                cVar2.f10854c = 0;
                cVar2.a();
                fill(uVar, this.mLayoutState, yVar, false);
            }
            this.mLayoutState.f10863l = null;
        }
    }

    private void logChildren() {
        Log.d(TAG, "internal representation of views on the screen");
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            Log.d(TAG, "item " + getPosition(childAt) + ", coord:" + this.mOrientationHelper.g(childAt));
        }
        Log.d(TAG, "==============");
    }

    private void recycleByLayoutState(RecyclerView.u uVar, c cVar) {
        if (cVar.f10852a && !cVar.f10864m) {
            int i10 = cVar.f10858g;
            int i11 = cVar.f10860i;
            if (cVar.f10857f == -1) {
                recycleViewsFromEnd(uVar, i10, i11);
            } else {
                recycleViewsFromStart(uVar, i10, i11);
            }
        }
    }

    private void recycleChildren(RecyclerView.u uVar, int i10, int i11) {
        if (i10 == i11) {
            return;
        }
        if (i11 > i10) {
            for (int i12 = i11 - 1; i12 >= i10; i12--) {
                removeAndRecycleViewAt(i12, uVar);
            }
            return;
        }
        while (i10 > i11) {
            removeAndRecycleViewAt(i10, uVar);
            i10--;
        }
    }

    private void recycleViewsFromEnd(RecyclerView.u uVar, int i10, int i11) {
        int childCount = getChildCount();
        if (i10 < 0) {
            return;
        }
        int h10 = (this.mOrientationHelper.h() - i10) + i11;
        if (this.mShouldReverseLayout) {
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = getChildAt(i12);
                if (this.mOrientationHelper.g(childAt) < h10 || this.mOrientationHelper.r(childAt) < h10) {
                    recycleChildren(uVar, 0, i12);
                    return;
                }
            }
            return;
        }
        int i13 = childCount - 1;
        for (int i14 = i13; i14 >= 0; i14--) {
            View childAt2 = getChildAt(i14);
            if (this.mOrientationHelper.g(childAt2) < h10 || this.mOrientationHelper.r(childAt2) < h10) {
                recycleChildren(uVar, i13, i14);
                return;
            }
        }
    }

    private void recycleViewsFromStart(RecyclerView.u uVar, int i10, int i11) {
        if (i10 < 0) {
            return;
        }
        int i12 = i10 - i11;
        int childCount = getChildCount();
        if (this.mShouldReverseLayout) {
            int i13 = childCount - 1;
            for (int i14 = i13; i14 >= 0; i14--) {
                View childAt = getChildAt(i14);
                if (this.mOrientationHelper.d(childAt) > i12 || this.mOrientationHelper.q(childAt) > i12) {
                    recycleChildren(uVar, i13, i14);
                    return;
                }
            }
            return;
        }
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt2 = getChildAt(i15);
            if (this.mOrientationHelper.d(childAt2) > i12 || this.mOrientationHelper.q(childAt2) > i12) {
                recycleChildren(uVar, 0, i15);
                return;
            }
        }
    }

    private void resolveShouldLayoutReverse() {
        if (this.mOrientation != 1 && isLayoutRTL()) {
            this.mShouldReverseLayout = !this.mReverseLayout;
        } else {
            this.mShouldReverseLayout = this.mReverseLayout;
        }
    }

    private boolean updateAnchorFromChildren(RecyclerView.u uVar, RecyclerView.y yVar, a aVar) {
        View findReferenceChild;
        boolean z10;
        boolean z11 = false;
        if (getChildCount() == 0) {
            return false;
        }
        View focusedChild = getFocusedChild();
        if (focusedChild != null && aVar.d(focusedChild, yVar)) {
            aVar.c(focusedChild, getPosition(focusedChild));
            return true;
        }
        boolean z12 = this.mLastStackFromEnd;
        boolean z13 = this.mStackFromEnd;
        if (z12 != z13 || (findReferenceChild = findReferenceChild(uVar, yVar, aVar.f10846d, z13)) == null) {
            return false;
        }
        aVar.b(findReferenceChild, getPosition(findReferenceChild));
        if (!yVar.e() && supportsPredictiveItemAnimations()) {
            int g10 = this.mOrientationHelper.g(findReferenceChild);
            int d10 = this.mOrientationHelper.d(findReferenceChild);
            int n10 = this.mOrientationHelper.n();
            int i10 = this.mOrientationHelper.i();
            if (d10 <= n10 && g10 < n10) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (g10 >= i10 && d10 > i10) {
                z11 = true;
            }
            if (z10 || z11) {
                if (aVar.f10846d) {
                    n10 = i10;
                }
                aVar.f10845c = n10;
            }
        }
        return true;
    }

    private boolean updateAnchorFromPendingData(RecyclerView.y yVar, a aVar) {
        int i10;
        boolean z10;
        int g10;
        boolean z11 = false;
        if (!yVar.e() && (i10 = this.mPendingScrollPosition) != -1) {
            if (i10 >= 0 && i10 < yVar.b()) {
                aVar.f10844b = this.mPendingScrollPosition;
                SavedState savedState = this.mPendingSavedState;
                if (savedState != null && savedState.b()) {
                    boolean z12 = this.mPendingSavedState.f10842c;
                    aVar.f10846d = z12;
                    if (z12) {
                        aVar.f10845c = this.mOrientationHelper.i() - this.mPendingSavedState.f10841b;
                    } else {
                        aVar.f10845c = this.mOrientationHelper.n() + this.mPendingSavedState.f10841b;
                    }
                    return true;
                }
                if (this.mPendingScrollPositionOffset == Integer.MIN_VALUE) {
                    View findViewByPosition = findViewByPosition(this.mPendingScrollPosition);
                    if (findViewByPosition != null) {
                        if (this.mOrientationHelper.e(findViewByPosition) > this.mOrientationHelper.o()) {
                            aVar.a();
                            return true;
                        }
                        if (this.mOrientationHelper.g(findViewByPosition) - this.mOrientationHelper.n() < 0) {
                            aVar.f10845c = this.mOrientationHelper.n();
                            aVar.f10846d = false;
                            return true;
                        }
                        if (this.mOrientationHelper.i() - this.mOrientationHelper.d(findViewByPosition) < 0) {
                            aVar.f10845c = this.mOrientationHelper.i();
                            aVar.f10846d = true;
                            return true;
                        }
                        if (aVar.f10846d) {
                            g10 = this.mOrientationHelper.d(findViewByPosition) + this.mOrientationHelper.p();
                        } else {
                            g10 = this.mOrientationHelper.g(findViewByPosition);
                        }
                        aVar.f10845c = g10;
                    } else {
                        if (getChildCount() > 0) {
                            if (this.mPendingScrollPosition < getPosition(getChildAt(0))) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            if (z10 == this.mShouldReverseLayout) {
                                z11 = true;
                            }
                            aVar.f10846d = z11;
                        }
                        aVar.a();
                    }
                    return true;
                }
                boolean z13 = this.mShouldReverseLayout;
                aVar.f10846d = z13;
                if (z13) {
                    aVar.f10845c = this.mOrientationHelper.i() - this.mPendingScrollPositionOffset;
                } else {
                    aVar.f10845c = this.mOrientationHelper.n() + this.mPendingScrollPositionOffset;
                }
                return true;
            }
            this.mPendingScrollPosition = -1;
            this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        }
        return false;
    }

    private void updateAnchorInfoForLayout(RecyclerView.u uVar, RecyclerView.y yVar, a aVar) {
        int i10;
        if (updateAnchorFromPendingData(yVar, aVar) || updateAnchorFromChildren(uVar, yVar, aVar)) {
            return;
        }
        aVar.a();
        if (this.mStackFromEnd) {
            i10 = yVar.b() - 1;
        } else {
            i10 = 0;
        }
        aVar.f10844b = i10;
    }

    private void updateLayoutState(int i10, int i11, boolean z10, RecyclerView.y yVar) {
        int i12;
        int n10;
        this.mLayoutState.f10864m = resolveIsInfinite();
        this.mLayoutState.f10857f = i10;
        int[] iArr = this.mReusableIntPair;
        boolean z11 = false;
        iArr[0] = 0;
        int i13 = 1;
        iArr[1] = 0;
        calculateExtraLayoutSpace(yVar, iArr);
        int max = Math.max(0, this.mReusableIntPair[0]);
        int max2 = Math.max(0, this.mReusableIntPair[1]);
        if (i10 == 1) {
            z11 = true;
        }
        c cVar = this.mLayoutState;
        if (z11) {
            i12 = max2;
        } else {
            i12 = max;
        }
        cVar.f10859h = i12;
        if (!z11) {
            max = max2;
        }
        cVar.f10860i = max;
        if (z11) {
            cVar.f10859h = i12 + this.mOrientationHelper.j();
            View childClosestToEnd = getChildClosestToEnd();
            c cVar2 = this.mLayoutState;
            if (this.mShouldReverseLayout) {
                i13 = -1;
            }
            cVar2.f10856e = i13;
            int position = getPosition(childClosestToEnd);
            c cVar3 = this.mLayoutState;
            cVar2.f10855d = position + cVar3.f10856e;
            cVar3.f10853b = this.mOrientationHelper.d(childClosestToEnd);
            n10 = this.mOrientationHelper.d(childClosestToEnd) - this.mOrientationHelper.i();
        } else {
            View childClosestToStart = getChildClosestToStart();
            this.mLayoutState.f10859h += this.mOrientationHelper.n();
            c cVar4 = this.mLayoutState;
            if (!this.mShouldReverseLayout) {
                i13 = -1;
            }
            cVar4.f10856e = i13;
            int position2 = getPosition(childClosestToStart);
            c cVar5 = this.mLayoutState;
            cVar4.f10855d = position2 + cVar5.f10856e;
            cVar5.f10853b = this.mOrientationHelper.g(childClosestToStart);
            n10 = (-this.mOrientationHelper.g(childClosestToStart)) + this.mOrientationHelper.n();
        }
        c cVar6 = this.mLayoutState;
        cVar6.f10854c = i11;
        if (z10) {
            cVar6.f10854c = i11 - n10;
        }
        cVar6.f10858g = n10;
    }

    private void updateLayoutStateToFillEnd(a aVar) {
        updateLayoutStateToFillEnd(aVar.f10844b, aVar.f10845c);
    }

    private void updateLayoutStateToFillStart(a aVar) {
        updateLayoutStateToFillStart(aVar.f10844b, aVar.f10845c);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void assertNotInLayoutOrScroll(String str) {
        if (this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    public void calculateExtraLayoutSpace(RecyclerView.y yVar, int[] iArr) {
        int i10;
        int extraLayoutSpace = getExtraLayoutSpace(yVar);
        if (this.mLayoutState.f10857f == -1) {
            i10 = 0;
        } else {
            i10 = extraLayoutSpace;
            extraLayoutSpace = 0;
        }
        iArr[0] = extraLayoutSpace;
        iArr[1] = i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean canScrollHorizontally() {
        if (this.mOrientation == 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean canScrollVertically() {
        if (this.mOrientation == 1) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void collectAdjacentPrefetchPositions(int i10, int i11, RecyclerView.y yVar, RecyclerView.o.c cVar) {
        int i12;
        if (this.mOrientation != 0) {
            i10 = i11;
        }
        if (getChildCount() != 0 && i10 != 0) {
            ensureLayoutState();
            if (i10 > 0) {
                i12 = 1;
            } else {
                i12 = -1;
            }
            updateLayoutState(i12, Math.abs(i10), true, yVar);
            collectPrefetchPositionsForLayoutState(yVar, this.mLayoutState, cVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void collectInitialPrefetchPositions(int i10, RecyclerView.o.c cVar) {
        boolean z10;
        int i11;
        SavedState savedState = this.mPendingSavedState;
        int i12 = -1;
        if (savedState != null && savedState.b()) {
            SavedState savedState2 = this.mPendingSavedState;
            z10 = savedState2.f10842c;
            i11 = savedState2.f10840a;
        } else {
            resolveShouldLayoutReverse();
            z10 = this.mShouldReverseLayout;
            i11 = this.mPendingScrollPosition;
            if (i11 == -1) {
                i11 = z10 ? i10 - 1 : 0;
            }
        }
        if (!z10) {
            i12 = 1;
        }
        for (int i13 = 0; i13 < this.mInitialPrefetchItemCount && i11 >= 0 && i11 < i10; i13++) {
            cVar.a(i11, 0);
            i11 += i12;
        }
    }

    public void collectPrefetchPositionsForLayoutState(RecyclerView.y yVar, c cVar, RecyclerView.o.c cVar2) {
        int i10 = cVar.f10855d;
        if (i10 >= 0 && i10 < yVar.b()) {
            cVar2.a(i10, Math.max(0, cVar.f10858g));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeHorizontalScrollExtent(RecyclerView.y yVar) {
        return computeScrollExtent(yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeHorizontalScrollOffset(RecyclerView.y yVar) {
        return computeScrollOffset(yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeHorizontalScrollRange(RecyclerView.y yVar) {
        return computeScrollRange(yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.x.b
    public PointF computeScrollVectorForPosition(int i10) {
        if (getChildCount() == 0) {
            return null;
        }
        boolean z10 = false;
        int i11 = 1;
        if (i10 < getPosition(getChildAt(0))) {
            z10 = true;
        }
        if (z10 != this.mShouldReverseLayout) {
            i11 = -1;
        }
        if (this.mOrientation == 0) {
            return new PointF(i11, 0.0f);
        }
        return new PointF(0.0f, i11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeVerticalScrollExtent(RecyclerView.y yVar) {
        return computeScrollExtent(yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeVerticalScrollOffset(RecyclerView.y yVar) {
        return computeScrollOffset(yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeVerticalScrollRange(RecyclerView.y yVar) {
        return computeScrollRange(yVar);
    }

    public int convertFocusDirectionToLayoutDirection(int i10) {
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 17) {
                    if (i10 != 33) {
                        if (i10 != 66) {
                            if (i10 == 130 && this.mOrientation == 1) {
                                return 1;
                            }
                            return Integer.MIN_VALUE;
                        }
                        if (this.mOrientation == 0) {
                            return 1;
                        }
                        return Integer.MIN_VALUE;
                    }
                    if (this.mOrientation == 1) {
                        return -1;
                    }
                    return Integer.MIN_VALUE;
                }
                if (this.mOrientation == 0) {
                    return -1;
                }
                return Integer.MIN_VALUE;
            }
            if (this.mOrientation != 1 && isLayoutRTL()) {
                return -1;
            }
            return 1;
        }
        if (this.mOrientation == 1 || !isLayoutRTL()) {
            return -1;
        }
        return 1;
    }

    public c createLayoutState() {
        return new c();
    }

    public void ensureLayoutState() {
        if (this.mLayoutState == null) {
            this.mLayoutState = createLayoutState();
        }
    }

    public int fill(RecyclerView.u uVar, c cVar, RecyclerView.y yVar, boolean z10) {
        int i10 = cVar.f10854c;
        int i11 = cVar.f10858g;
        if (i11 != Integer.MIN_VALUE) {
            if (i10 < 0) {
                cVar.f10858g = i11 + i10;
            }
            recycleByLayoutState(uVar, cVar);
        }
        int i12 = cVar.f10854c + cVar.f10859h;
        b bVar = this.mLayoutChunkResult;
        while (true) {
            if ((!cVar.f10864m && i12 <= 0) || !cVar.c(yVar)) {
                break;
            }
            bVar.a();
            layoutChunk(uVar, yVar, cVar, bVar);
            if (!bVar.f10849b) {
                cVar.f10853b += bVar.f10848a * cVar.f10857f;
                if (!bVar.f10850c || cVar.f10863l != null || !yVar.e()) {
                    int i13 = cVar.f10854c;
                    int i14 = bVar.f10848a;
                    cVar.f10854c = i13 - i14;
                    i12 -= i14;
                }
                int i15 = cVar.f10858g;
                if (i15 != Integer.MIN_VALUE) {
                    int i16 = i15 + bVar.f10848a;
                    cVar.f10858g = i16;
                    int i17 = cVar.f10854c;
                    if (i17 < 0) {
                        cVar.f10858g = i16 + i17;
                    }
                    recycleByLayoutState(uVar, cVar);
                }
                if (z10 && bVar.f10851d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i10 - cVar.f10854c;
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(0, getChildCount(), true, false);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public View findFirstVisibleChildClosestToEnd(boolean z10, boolean z11) {
        if (this.mShouldReverseLayout) {
            return findOneVisibleChild(0, getChildCount(), z10, z11);
        }
        return findOneVisibleChild(getChildCount() - 1, -1, z10, z11);
    }

    public View findFirstVisibleChildClosestToStart(boolean z10, boolean z11) {
        if (this.mShouldReverseLayout) {
            return findOneVisibleChild(getChildCount() - 1, -1, z10, z11);
        }
        return findOneVisibleChild(0, getChildCount(), z10, z11);
    }

    public int findFirstVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(0, getChildCount(), false, true);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, true, false);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findLastVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, false, true);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public View findOnePartiallyOrCompletelyInvisibleChild(int i10, int i11) {
        int i12;
        int i13;
        ensureLayoutState();
        if (i11 > i10 || i11 < i10) {
            if (this.mOrientationHelper.g(getChildAt(i10)) < this.mOrientationHelper.n()) {
                i12 = 16644;
                i13 = 16388;
            } else {
                i12 = 4161;
                i13 = 4097;
            }
            if (this.mOrientation == 0) {
                return this.mHorizontalBoundCheck.a(i10, i11, i12, i13);
            }
            return this.mVerticalBoundCheck.a(i10, i11, i12, i13);
        }
        return getChildAt(i10);
    }

    public View findOneVisibleChild(int i10, int i11, boolean z10, boolean z11) {
        int i12;
        ensureLayoutState();
        int i13 = ModuleType.TYPE_WEATHER;
        if (z10) {
            i12 = 24579;
        } else {
            i12 = 320;
        }
        if (!z11) {
            i13 = 0;
        }
        if (this.mOrientation == 0) {
            return this.mHorizontalBoundCheck.a(i10, i11, i12, i13);
        }
        return this.mVerticalBoundCheck.a(i10, i11, i12, i13);
    }

    public View findReferenceChild(RecyclerView.u uVar, RecyclerView.y yVar, boolean z10, boolean z11) {
        int i10;
        int i11;
        int i12;
        boolean z12;
        boolean z13;
        ensureLayoutState();
        int childCount = getChildCount();
        if (z11) {
            i11 = getChildCount() - 1;
            i10 = -1;
            i12 = -1;
        } else {
            i10 = childCount;
            i11 = 0;
            i12 = 1;
        }
        int b10 = yVar.b();
        int n10 = this.mOrientationHelper.n();
        int i13 = this.mOrientationHelper.i();
        View view = null;
        View view2 = null;
        View view3 = null;
        while (i11 != i10) {
            View childAt = getChildAt(i11);
            int position = getPosition(childAt);
            int g10 = this.mOrientationHelper.g(childAt);
            int d10 = this.mOrientationHelper.d(childAt);
            if (position >= 0 && position < b10) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).c()) {
                    if (view3 == null) {
                        view3 = childAt;
                    }
                } else {
                    if (d10 <= n10 && g10 < n10) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if (g10 >= i13 && d10 > i13) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    if (!z12 && !z13) {
                        return childAt;
                    }
                    if (z10) {
                        if (!z13) {
                            if (view != null) {
                            }
                            view = childAt;
                        }
                        view2 = childAt;
                    } else {
                        if (!z12) {
                            if (view != null) {
                            }
                            view = childAt;
                        }
                        view2 = childAt;
                    }
                }
            }
            i11 += i12;
        }
        if (view == null) {
            if (view2 != null) {
                return view2;
            }
            return view3;
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View findViewByPosition(int i10) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return null;
        }
        int position = i10 - getPosition(getChildAt(0));
        if (position >= 0 && position < childCount) {
            View childAt = getChildAt(position);
            if (getPosition(childAt) == i10) {
                return childAt;
            }
        }
        return super.findViewByPosition(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Deprecated
    public int getExtraLayoutSpace(RecyclerView.y yVar) {
        if (yVar.d()) {
            return this.mOrientationHelper.o();
        }
        return 0;
    }

    public int getInitialPrefetchItemCount() {
        return this.mInitialPrefetchItemCount;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.mRecycleChildrenOnDetach;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public boolean getStackFromEnd() {
        return this.mStackFromEnd;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    public boolean isLayoutRTL() {
        if (getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.mSmoothScrollbarEnabled;
    }

    public void layoutChunk(RecyclerView.u uVar, RecyclerView.y yVar, c cVar, b bVar) {
        boolean z10;
        int i10;
        int i11;
        int i12;
        int i13;
        int f10;
        boolean z11;
        View d10 = cVar.d(uVar);
        if (d10 == null) {
            bVar.f10849b = true;
            return;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) d10.getLayoutParams();
        if (cVar.f10863l == null) {
            boolean z12 = this.mShouldReverseLayout;
            if (cVar.f10857f == -1) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z12 == z11) {
                addView(d10);
            } else {
                addView(d10, 0);
            }
        } else {
            boolean z13 = this.mShouldReverseLayout;
            if (cVar.f10857f == -1) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z13 == z10) {
                addDisappearingView(d10);
            } else {
                addDisappearingView(d10, 0);
            }
        }
        measureChildWithMargins(d10, 0, 0);
        bVar.f10848a = this.mOrientationHelper.e(d10);
        if (this.mOrientation == 1) {
            if (isLayoutRTL()) {
                f10 = getWidth() - getPaddingRight();
                i13 = f10 - this.mOrientationHelper.f(d10);
            } else {
                i13 = getPaddingLeft();
                f10 = this.mOrientationHelper.f(d10) + i13;
            }
            if (cVar.f10857f == -1) {
                int i14 = cVar.f10853b;
                i12 = i14;
                i11 = f10;
                i10 = i14 - bVar.f10848a;
            } else {
                int i15 = cVar.f10853b;
                i10 = i15;
                i11 = f10;
                i12 = bVar.f10848a + i15;
            }
        } else {
            int paddingTop = getPaddingTop();
            int f11 = this.mOrientationHelper.f(d10) + paddingTop;
            if (cVar.f10857f == -1) {
                int i16 = cVar.f10853b;
                i11 = i16;
                i10 = paddingTop;
                i12 = f11;
                i13 = i16 - bVar.f10848a;
            } else {
                int i17 = cVar.f10853b;
                i10 = paddingTop;
                i11 = bVar.f10848a + i17;
                i12 = f11;
                i13 = i17;
            }
        }
        layoutDecoratedWithMargins(d10, i13, i10, i11, i12);
        if (layoutParams.c() || layoutParams.b()) {
            bVar.f10850c = true;
        }
        bVar.f10851d = d10.hasFocusable();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.u uVar) {
        super.onDetachedFromWindow(recyclerView, uVar);
        if (this.mRecycleChildrenOnDetach) {
            removeAndRecycleAllViews(uVar);
            uVar.c();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View onFocusSearchFailed(View view, int i10, RecyclerView.u uVar, RecyclerView.y yVar) {
        int convertFocusDirectionToLayoutDirection;
        View findPartiallyOrCompletelyInvisibleChildClosestToEnd;
        View childClosestToEnd;
        resolveShouldLayoutReverse();
        if (getChildCount() == 0 || (convertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i10)) == Integer.MIN_VALUE) {
            return null;
        }
        ensureLayoutState();
        updateLayoutState(convertFocusDirectionToLayoutDirection, (int) (this.mOrientationHelper.o() * MAX_SCROLL_FACTOR), false, yVar);
        c cVar = this.mLayoutState;
        cVar.f10858g = Integer.MIN_VALUE;
        cVar.f10852a = false;
        fill(uVar, cVar, yVar, true);
        if (convertFocusDirectionToLayoutDirection == -1) {
            findPartiallyOrCompletelyInvisibleChildClosestToEnd = findPartiallyOrCompletelyInvisibleChildClosestToStart();
        } else {
            findPartiallyOrCompletelyInvisibleChildClosestToEnd = findPartiallyOrCompletelyInvisibleChildClosestToEnd();
        }
        if (convertFocusDirectionToLayoutDirection == -1) {
            childClosestToEnd = getChildClosestToStart();
        } else {
            childClosestToEnd = getChildClosestToEnd();
        }
        if (childClosestToEnd.hasFocusable()) {
            if (findPartiallyOrCompletelyInvisibleChildClosestToEnd == null) {
                return null;
            }
            return childClosestToEnd;
        }
        return findPartiallyOrCompletelyInvisibleChildClosestToEnd;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(findFirstVisibleItemPosition());
            accessibilityEvent.setToIndex(findLastVisibleItemPosition());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onLayoutChildren(RecyclerView.u uVar, RecyclerView.y yVar) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int fixLayoutEndGap;
        int i15;
        View findViewByPosition;
        int g10;
        int i16;
        int i17 = -1;
        if ((this.mPendingSavedState != null || this.mPendingScrollPosition != -1) && yVar.b() == 0) {
            removeAndRecycleAllViews(uVar);
            return;
        }
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null && savedState.b()) {
            this.mPendingScrollPosition = this.mPendingSavedState.f10840a;
        }
        ensureLayoutState();
        this.mLayoutState.f10852a = false;
        resolveShouldLayoutReverse();
        View focusedChild = getFocusedChild();
        a aVar = this.mAnchorInfo;
        if (aVar.f10847e && this.mPendingScrollPosition == -1 && this.mPendingSavedState == null) {
            if (focusedChild != null && (this.mOrientationHelper.g(focusedChild) >= this.mOrientationHelper.i() || this.mOrientationHelper.d(focusedChild) <= this.mOrientationHelper.n())) {
                this.mAnchorInfo.c(focusedChild, getPosition(focusedChild));
            }
        } else {
            aVar.e();
            a aVar2 = this.mAnchorInfo;
            aVar2.f10846d = this.mShouldReverseLayout ^ this.mStackFromEnd;
            updateAnchorInfoForLayout(uVar, yVar, aVar2);
            this.mAnchorInfo.f10847e = true;
        }
        c cVar = this.mLayoutState;
        if (cVar.f10862k >= 0) {
            i10 = 1;
        } else {
            i10 = -1;
        }
        cVar.f10857f = i10;
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(yVar, iArr);
        int max = Math.max(0, this.mReusableIntPair[0]) + this.mOrientationHelper.n();
        int max2 = Math.max(0, this.mReusableIntPair[1]) + this.mOrientationHelper.j();
        if (yVar.e() && (i15 = this.mPendingScrollPosition) != -1 && this.mPendingScrollPositionOffset != Integer.MIN_VALUE && (findViewByPosition = findViewByPosition(i15)) != null) {
            if (this.mShouldReverseLayout) {
                i16 = this.mOrientationHelper.i() - this.mOrientationHelper.d(findViewByPosition);
                g10 = this.mPendingScrollPositionOffset;
            } else {
                g10 = this.mOrientationHelper.g(findViewByPosition) - this.mOrientationHelper.n();
                i16 = this.mPendingScrollPositionOffset;
            }
            int i18 = i16 - g10;
            if (i18 > 0) {
                max += i18;
            } else {
                max2 -= i18;
            }
        }
        a aVar3 = this.mAnchorInfo;
        if (!aVar3.f10846d ? !this.mShouldReverseLayout : this.mShouldReverseLayout) {
            i17 = 1;
        }
        onAnchorReady(uVar, yVar, aVar3, i17);
        detachAndScrapAttachedViews(uVar);
        this.mLayoutState.f10864m = resolveIsInfinite();
        this.mLayoutState.f10861j = yVar.e();
        this.mLayoutState.f10860i = 0;
        a aVar4 = this.mAnchorInfo;
        if (aVar4.f10846d) {
            updateLayoutStateToFillStart(aVar4);
            c cVar2 = this.mLayoutState;
            cVar2.f10859h = max;
            fill(uVar, cVar2, yVar, false);
            c cVar3 = this.mLayoutState;
            i12 = cVar3.f10853b;
            int i19 = cVar3.f10855d;
            int i20 = cVar3.f10854c;
            if (i20 > 0) {
                max2 += i20;
            }
            updateLayoutStateToFillEnd(this.mAnchorInfo);
            c cVar4 = this.mLayoutState;
            cVar4.f10859h = max2;
            cVar4.f10855d += cVar4.f10856e;
            fill(uVar, cVar4, yVar, false);
            c cVar5 = this.mLayoutState;
            i11 = cVar5.f10853b;
            int i21 = cVar5.f10854c;
            if (i21 > 0) {
                updateLayoutStateToFillStart(i19, i12);
                c cVar6 = this.mLayoutState;
                cVar6.f10859h = i21;
                fill(uVar, cVar6, yVar, false);
                i12 = this.mLayoutState.f10853b;
            }
        } else {
            updateLayoutStateToFillEnd(aVar4);
            c cVar7 = this.mLayoutState;
            cVar7.f10859h = max2;
            fill(uVar, cVar7, yVar, false);
            c cVar8 = this.mLayoutState;
            i11 = cVar8.f10853b;
            int i22 = cVar8.f10855d;
            int i23 = cVar8.f10854c;
            if (i23 > 0) {
                max += i23;
            }
            updateLayoutStateToFillStart(this.mAnchorInfo);
            c cVar9 = this.mLayoutState;
            cVar9.f10859h = max;
            cVar9.f10855d += cVar9.f10856e;
            fill(uVar, cVar9, yVar, false);
            c cVar10 = this.mLayoutState;
            i12 = cVar10.f10853b;
            int i24 = cVar10.f10854c;
            if (i24 > 0) {
                updateLayoutStateToFillEnd(i22, i11);
                c cVar11 = this.mLayoutState;
                cVar11.f10859h = i24;
                fill(uVar, cVar11, yVar, false);
                i11 = this.mLayoutState.f10853b;
            }
        }
        if (getChildCount() > 0) {
            if (this.mShouldReverseLayout ^ this.mStackFromEnd) {
                int fixLayoutEndGap2 = fixLayoutEndGap(i11, uVar, yVar, true);
                i13 = i12 + fixLayoutEndGap2;
                i14 = i11 + fixLayoutEndGap2;
                fixLayoutEndGap = fixLayoutStartGap(i13, uVar, yVar, false);
            } else {
                int fixLayoutStartGap = fixLayoutStartGap(i12, uVar, yVar, true);
                i13 = i12 + fixLayoutStartGap;
                i14 = i11 + fixLayoutStartGap;
                fixLayoutEndGap = fixLayoutEndGap(i14, uVar, yVar, false);
            }
            i12 = i13 + fixLayoutEndGap;
            i11 = i14 + fixLayoutEndGap;
        }
        layoutForPredictiveAnimations(uVar, yVar, i12, i11);
        if (!yVar.e()) {
            this.mOrientationHelper.t();
        } else {
            this.mAnchorInfo.e();
        }
        this.mLastStackFromEnd = this.mStackFromEnd;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onLayoutCompleted(RecyclerView.y yVar) {
        super.onLayoutCompleted(yVar);
        this.mPendingSavedState = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mAnchorInfo.e();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.mPendingSavedState = savedState;
            if (this.mPendingScrollPosition != -1) {
                savedState.d();
            }
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public Parcelable onSaveInstanceState() {
        if (this.mPendingSavedState != null) {
            return new SavedState(this.mPendingSavedState);
        }
        SavedState savedState = new SavedState();
        if (getChildCount() > 0) {
            ensureLayoutState();
            boolean z10 = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
            savedState.f10842c = z10;
            if (z10) {
                View childClosestToEnd = getChildClosestToEnd();
                savedState.f10841b = this.mOrientationHelper.i() - this.mOrientationHelper.d(childClosestToEnd);
                savedState.f10840a = getPosition(childClosestToEnd);
            } else {
                View childClosestToStart = getChildClosestToStart();
                savedState.f10840a = getPosition(childClosestToStart);
                savedState.f10841b = this.mOrientationHelper.g(childClosestToStart) - this.mOrientationHelper.n();
            }
        } else {
            savedState.d();
        }
        return savedState;
    }

    public void prepareForDrop(View view, View view2, int i10, int i11) {
        char c10;
        assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        ensureLayoutState();
        resolveShouldLayoutReverse();
        int position = getPosition(view);
        int position2 = getPosition(view2);
        if (position < position2) {
            c10 = 1;
        } else {
            c10 = 65535;
        }
        if (this.mShouldReverseLayout) {
            if (c10 == 1) {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.i() - (this.mOrientationHelper.g(view2) + this.mOrientationHelper.e(view)));
                return;
            } else {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.i() - this.mOrientationHelper.d(view2));
                return;
            }
        }
        if (c10 == 65535) {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.g(view2));
        } else {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.d(view2) - this.mOrientationHelper.e(view));
        }
    }

    public boolean resolveIsInfinite() {
        if (this.mOrientationHelper.l() == 0 && this.mOrientationHelper.h() == 0) {
            return true;
        }
        return false;
    }

    public int scrollBy(int i10, RecyclerView.u uVar, RecyclerView.y yVar) {
        int i11;
        if (getChildCount() == 0 || i10 == 0) {
            return 0;
        }
        ensureLayoutState();
        this.mLayoutState.f10852a = true;
        if (i10 > 0) {
            i11 = 1;
        } else {
            i11 = -1;
        }
        int abs = Math.abs(i10);
        updateLayoutState(i11, abs, true, yVar);
        c cVar = this.mLayoutState;
        int fill = cVar.f10858g + fill(uVar, cVar, yVar, false);
        if (fill < 0) {
            return 0;
        }
        if (abs > fill) {
            i10 = i11 * fill;
        }
        this.mOrientationHelper.s(-i10);
        this.mLayoutState.f10862k = i10;
        return i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int scrollHorizontallyBy(int i10, RecyclerView.u uVar, RecyclerView.y yVar) {
        if (this.mOrientation == 1) {
            return 0;
        }
        return scrollBy(i10, uVar, yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void scrollToPosition(int i10) {
        this.mPendingScrollPosition = i10;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.d();
        }
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i10, int i11) {
        this.mPendingScrollPosition = i10;
        this.mPendingScrollPositionOffset = i11;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.d();
        }
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int scrollVerticallyBy(int i10, RecyclerView.u uVar, RecyclerView.y yVar) {
        if (this.mOrientation == 0) {
            return 0;
        }
        return scrollBy(i10, uVar, yVar);
    }

    public void setInitialPrefetchItemCount(int i10) {
        this.mInitialPrefetchItemCount = i10;
    }

    public void setOrientation(int i10) {
        if (i10 != 0 && i10 != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i10);
        }
        assertNotInLayoutOrScroll(null);
        if (i10 != this.mOrientation || this.mOrientationHelper == null) {
            s b10 = s.b(this, i10);
            this.mOrientationHelper = b10;
            this.mAnchorInfo.f10843a = b10;
            this.mOrientation = i10;
            requestLayout();
        }
    }

    public void setRecycleChildrenOnDetach(boolean z10) {
        this.mRecycleChildrenOnDetach = z10;
    }

    public void setReverseLayout(boolean z10) {
        assertNotInLayoutOrScroll(null);
        if (z10 == this.mReverseLayout) {
            return;
        }
        this.mReverseLayout = z10;
        requestLayout();
    }

    public void setSmoothScrollbarEnabled(boolean z10) {
        this.mSmoothScrollbarEnabled = z10;
    }

    public void setStackFromEnd(boolean z10) {
        assertNotInLayoutOrScroll(null);
        if (this.mStackFromEnd == z10) {
            return;
        }
        this.mStackFromEnd = z10;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean shouldMeasureTwice() {
        if (getHeightMode() != 1073741824 && getWidthMode() != 1073741824 && hasFlexibleChildInBothOrientations()) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.y yVar, int i10) {
        o oVar = new o(recyclerView.getContext());
        oVar.setTargetPosition(i10);
        startSmoothScroll(oVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean supportsPredictiveItemAnimations() {
        if (this.mPendingSavedState == null && this.mLastStackFromEnd == this.mStackFromEnd) {
            return true;
        }
        return false;
    }

    public void validateChildOrder() {
        Log.d(TAG, "validating child count " + getChildCount());
        boolean z10 = true;
        if (getChildCount() < 1) {
            return;
        }
        int position = getPosition(getChildAt(0));
        int g10 = this.mOrientationHelper.g(getChildAt(0));
        if (this.mShouldReverseLayout) {
            for (int i10 = 1; i10 < getChildCount(); i10++) {
                View childAt = getChildAt(i10);
                int position2 = getPosition(childAt);
                int g11 = this.mOrientationHelper.g(childAt);
                if (position2 < position) {
                    logChildren();
                    StringBuilder sb = new StringBuilder();
                    sb.append("detected invalid position. loc invalid? ");
                    if (g11 >= g10) {
                        z10 = false;
                    }
                    sb.append(z10);
                    throw new RuntimeException(sb.toString());
                }
                if (g11 > g10) {
                    logChildren();
                    throw new RuntimeException("detected invalid location");
                }
            }
            return;
        }
        for (int i11 = 1; i11 < getChildCount(); i11++) {
            View childAt2 = getChildAt(i11);
            int position3 = getPosition(childAt2);
            int g12 = this.mOrientationHelper.g(childAt2);
            if (position3 < position) {
                logChildren();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("detected invalid position. loc invalid? ");
                if (g12 >= g10) {
                    z10 = false;
                }
                sb2.append(z10);
                throw new RuntimeException(sb2.toString());
            }
            if (g12 < g10) {
                logChildren();
                throw new RuntimeException("detected invalid location");
            }
        }
    }

    public LinearLayoutManager(Context context, int i10, boolean z10) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new a();
        this.mLayoutChunkResult = new b();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        setOrientation(i10);
        setReverseLayout(z10);
    }

    private void updateLayoutStateToFillEnd(int i10, int i11) {
        this.mLayoutState.f10854c = this.mOrientationHelper.i() - i11;
        c cVar = this.mLayoutState;
        cVar.f10856e = this.mShouldReverseLayout ? -1 : 1;
        cVar.f10855d = i10;
        cVar.f10857f = 1;
        cVar.f10853b = i11;
        cVar.f10858g = Integer.MIN_VALUE;
    }

    private void updateLayoutStateToFillStart(int i10, int i11) {
        this.mLayoutState.f10854c = i11 - this.mOrientationHelper.n();
        c cVar = this.mLayoutState;
        cVar.f10855d = i10;
        cVar.f10856e = this.mShouldReverseLayout ? 1 : -1;
        cVar.f10857f = -1;
        cVar.f10853b = i11;
        cVar.f10858g = Integer.MIN_VALUE;
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new a();
        this.mLayoutChunkResult = new b();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        RecyclerView.o.d properties = RecyclerView.o.getProperties(context, attributeSet, i10, i11);
        setOrientation(properties.f10900a);
        setReverseLayout(properties.f10902c);
        setStackFromEnd(properties.f10903d);
    }

    public void onAnchorReady(RecyclerView.u uVar, RecyclerView.y yVar, a aVar, int i10) {
    }
}
