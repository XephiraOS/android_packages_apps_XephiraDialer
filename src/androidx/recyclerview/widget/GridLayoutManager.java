package androidx.recyclerview.widget;

import J.d;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {

    /* renamed from: a, reason: collision with root package name */
    public boolean f10829a;

    /* renamed from: b, reason: collision with root package name */
    public int f10830b;

    /* renamed from: c, reason: collision with root package name */
    public int[] f10831c;

    /* renamed from: d, reason: collision with root package name */
    public View[] f10832d;

    /* renamed from: e, reason: collision with root package name */
    public final SparseIntArray f10833e;

    /* renamed from: f, reason: collision with root package name */
    public final SparseIntArray f10834f;

    /* renamed from: g, reason: collision with root package name */
    public b f10835g;

    /* renamed from: h, reason: collision with root package name */
    public final Rect f10836h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f10837i;

    /* loaded from: classes.dex */
    public static final class a extends b {
        @Override // androidx.recyclerview.widget.GridLayoutManager.b
        public int getSpanIndex(int i10, int i11) {
            return i10 % i11;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.b
        public int getSpanSize(int i10) {
            return 1;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class b {
        final SparseIntArray mSpanIndexCache = new SparseIntArray();
        final SparseIntArray mSpanGroupIndexCache = new SparseIntArray();
        private boolean mCacheSpanIndices = false;
        private boolean mCacheSpanGroupIndices = false;

        public static int findFirstKeyLessThan(SparseIntArray sparseIntArray, int i10) {
            int size = sparseIntArray.size() - 1;
            int i11 = 0;
            while (i11 <= size) {
                int i12 = (i11 + size) >>> 1;
                if (sparseIntArray.keyAt(i12) < i10) {
                    i11 = i12 + 1;
                } else {
                    size = i12 - 1;
                }
            }
            int i13 = i11 - 1;
            if (i13 >= 0 && i13 < sparseIntArray.size()) {
                return sparseIntArray.keyAt(i13);
            }
            return -1;
        }

        public int getCachedSpanGroupIndex(int i10, int i11) {
            if (!this.mCacheSpanGroupIndices) {
                return getSpanGroupIndex(i10, i11);
            }
            int i12 = this.mSpanGroupIndexCache.get(i10, -1);
            if (i12 != -1) {
                return i12;
            }
            int spanGroupIndex = getSpanGroupIndex(i10, i11);
            this.mSpanGroupIndexCache.put(i10, spanGroupIndex);
            return spanGroupIndex;
        }

        public int getCachedSpanIndex(int i10, int i11) {
            if (!this.mCacheSpanIndices) {
                return getSpanIndex(i10, i11);
            }
            int i12 = this.mSpanIndexCache.get(i10, -1);
            if (i12 != -1) {
                return i12;
            }
            int spanIndex = getSpanIndex(i10, i11);
            this.mSpanIndexCache.put(i10, spanIndex);
            return spanIndex;
        }

        public int getSpanGroupIndex(int i10, int i11) {
            int i12;
            int i13;
            int i14;
            int findFirstKeyLessThan;
            if (this.mCacheSpanGroupIndices && (findFirstKeyLessThan = findFirstKeyLessThan(this.mSpanGroupIndexCache, i10)) != -1) {
                i12 = this.mSpanGroupIndexCache.get(findFirstKeyLessThan);
                i13 = findFirstKeyLessThan + 1;
                i14 = getCachedSpanIndex(findFirstKeyLessThan, i11) + getSpanSize(findFirstKeyLessThan);
                if (i14 == i11) {
                    i12++;
                    i14 = 0;
                }
            } else {
                i12 = 0;
                i13 = 0;
                i14 = 0;
            }
            int spanSize = getSpanSize(i10);
            while (i13 < i10) {
                int spanSize2 = getSpanSize(i13);
                i14 += spanSize2;
                if (i14 == i11) {
                    i12++;
                    i14 = 0;
                } else if (i14 > i11) {
                    i12++;
                    i14 = spanSize2;
                }
                i13++;
            }
            if (i14 + spanSize > i11) {
                return i12 + 1;
            }
            return i12;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x002b -> B:10:0x0030). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x002d -> B:10:0x0030). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x002f -> B:10:0x0030). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int getSpanIndex(int r6, int r7) {
            /*
                r5 = this;
                int r0 = r5.getSpanSize(r6)
                r1 = 0
                if (r0 != r7) goto L8
                return r1
            L8:
                boolean r2 = r5.mCacheSpanIndices
                if (r2 == 0) goto L20
                android.util.SparseIntArray r2 = r5.mSpanIndexCache
                int r2 = findFirstKeyLessThan(r2, r6)
                if (r2 < 0) goto L20
                android.util.SparseIntArray r3 = r5.mSpanIndexCache
                int r3 = r3.get(r2)
                int r4 = r5.getSpanSize(r2)
                int r3 = r3 + r4
                goto L30
            L20:
                r2 = r1
                r3 = r2
            L22:
                if (r2 >= r6) goto L33
                int r4 = r5.getSpanSize(r2)
                int r3 = r3 + r4
                if (r3 != r7) goto L2d
                r3 = r1
                goto L30
            L2d:
                if (r3 <= r7) goto L30
                r3 = r4
            L30:
                int r2 = r2 + 1
                goto L22
            L33:
                int r0 = r0 + r3
                if (r0 > r7) goto L37
                return r3
            L37:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.b.getSpanIndex(int, int):int");
        }

        public abstract int getSpanSize(int i10);

        public void invalidateSpanGroupIndexCache() {
            this.mSpanGroupIndexCache.clear();
        }

        public void invalidateSpanIndexCache() {
            this.mSpanIndexCache.clear();
        }

        public boolean isSpanGroupIndexCacheEnabled() {
            return this.mCacheSpanGroupIndices;
        }

        public boolean isSpanIndexCacheEnabled() {
            return this.mCacheSpanIndices;
        }

        public void setSpanGroupIndexCacheEnabled(boolean z10) {
            if (!z10) {
                this.mSpanGroupIndexCache.clear();
            }
            this.mCacheSpanGroupIndices = z10;
        }

        public void setSpanIndexCacheEnabled(boolean z10) {
            if (!z10) {
                this.mSpanGroupIndexCache.clear();
            }
            this.mCacheSpanIndices = z10;
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f10829a = false;
        this.f10830b = -1;
        this.f10833e = new SparseIntArray();
        this.f10834f = new SparseIntArray();
        this.f10835g = new a();
        this.f10836h = new Rect();
        v(RecyclerView.o.getProperties(context, attributeSet, i10, i11).f10901b);
    }

    public static int[] h(int[] iArr, int i10, int i11) {
        int i12;
        if (iArr == null || iArr.length != i10 + 1 || iArr[iArr.length - 1] != i11) {
            iArr = new int[i10 + 1];
        }
        int i13 = 0;
        iArr[0] = 0;
        int i14 = i11 / i10;
        int i15 = i11 % i10;
        int i16 = 0;
        for (int i17 = 1; i17 <= i10; i17++) {
            i13 += i15;
            if (i13 > 0 && i10 - i13 < i15) {
                i12 = i14 + 1;
                i13 -= i10;
            } else {
                i12 = i14;
            }
            i16 += i12;
            iArr[i17] = i16;
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void collectPrefetchPositionsForLayoutState(RecyclerView.y yVar, LinearLayoutManager.c cVar, RecyclerView.o.c cVar2) {
        int i10 = this.f10830b;
        for (int i11 = 0; i11 < this.f10830b && cVar.c(yVar) && i10 > 0; i11++) {
            int i12 = cVar.f10855d;
            cVar2.a(i12, Math.max(0, cVar.f10858g));
            i10 -= this.f10835g.getSpanSize(i12);
            cVar.f10855d += cVar.f10856e;
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int computeHorizontalScrollOffset(RecyclerView.y yVar) {
        if (this.f10837i) {
            return j(yVar);
        }
        return super.computeHorizontalScrollOffset(yVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int computeHorizontalScrollRange(RecyclerView.y yVar) {
        if (this.f10837i) {
            return k(yVar);
        }
        return super.computeHorizontalScrollRange(yVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int computeVerticalScrollOffset(RecyclerView.y yVar) {
        if (this.f10837i) {
            return j(yVar);
        }
        return super.computeVerticalScrollOffset(yVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int computeVerticalScrollRange(RecyclerView.y yVar) {
        if (this.f10837i) {
            return k(yVar);
        }
        return super.computeVerticalScrollRange(yVar);
    }

    public final void e(RecyclerView.u uVar, RecyclerView.y yVar, int i10, boolean z10) {
        int i11;
        int i12;
        int i13;
        int i14 = 0;
        if (z10) {
            i13 = 1;
            i12 = i10;
            i11 = 0;
        } else {
            i11 = i10 - 1;
            i12 = -1;
            i13 = -1;
        }
        while (i11 != i12) {
            View view = this.f10832d[i11];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int r10 = r(uVar, yVar, getPosition(view));
            layoutParams.f10839f = r10;
            layoutParams.f10838e = i14;
            i14 += r10;
            i11 += i13;
        }
    }

    public final void f() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i10).getLayoutParams();
            int a10 = layoutParams.a();
            this.f10833e.put(a10, layoutParams.f());
            this.f10834f.put(a10, layoutParams.e());
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public View findReferenceChild(RecyclerView.u uVar, RecyclerView.y yVar, boolean z10, boolean z11) {
        int i10;
        int i11;
        int childCount = getChildCount();
        int i12 = 1;
        if (z11) {
            i11 = getChildCount() - 1;
            i10 = -1;
            i12 = -1;
        } else {
            i10 = childCount;
            i11 = 0;
        }
        int b10 = yVar.b();
        ensureLayoutState();
        int n10 = this.mOrientationHelper.n();
        int i13 = this.mOrientationHelper.i();
        View view = null;
        View view2 = null;
        while (i11 != i10) {
            View childAt = getChildAt(i11);
            int position = getPosition(childAt);
            if (position >= 0 && position < b10 && q(uVar, yVar, position) == 0) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).c()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else {
                    if (this.mOrientationHelper.g(childAt) < i13 && this.mOrientationHelper.d(childAt) >= n10) {
                        return childAt;
                    }
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i11 += i12;
        }
        if (view == null) {
            return view2;
        }
        return view;
    }

    public final void g(int i10) {
        this.f10831c = h(this.f10831c, this.f10830b, i10);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        if (this.mOrientation == 0) {
            return new LayoutParams(-2, -1);
        }
        return new LayoutParams(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int getColumnCountForAccessibility(RecyclerView.u uVar, RecyclerView.y yVar) {
        if (this.mOrientation == 1) {
            return this.f10830b;
        }
        if (yVar.b() < 1) {
            return 0;
        }
        return p(uVar, yVar, yVar.b() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int getRowCountForAccessibility(RecyclerView.u uVar, RecyclerView.y yVar) {
        if (this.mOrientation == 0) {
            return this.f10830b;
        }
        if (yVar.b() < 1) {
            return 0;
        }
        return p(uVar, yVar, yVar.b() - 1) + 1;
    }

    public final void i() {
        this.f10833e.clear();
        this.f10834f.clear();
    }

    public final int j(RecyclerView.y yVar) {
        int max;
        if (getChildCount() != 0 && yVar.b() != 0) {
            ensureLayoutState();
            boolean isSmoothScrollbarEnabled = isSmoothScrollbarEnabled();
            View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled, true);
            View findFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled, true);
            if (findFirstVisibleChildClosestToStart != null && findFirstVisibleChildClosestToEnd != null) {
                int cachedSpanGroupIndex = this.f10835g.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToStart), this.f10830b);
                int cachedSpanGroupIndex2 = this.f10835g.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToEnd), this.f10830b);
                int min = Math.min(cachedSpanGroupIndex, cachedSpanGroupIndex2);
                int max2 = Math.max(cachedSpanGroupIndex, cachedSpanGroupIndex2);
                int cachedSpanGroupIndex3 = this.f10835g.getCachedSpanGroupIndex(yVar.b() - 1, this.f10830b) + 1;
                if (this.mShouldReverseLayout) {
                    max = Math.max(0, (cachedSpanGroupIndex3 - max2) - 1);
                } else {
                    max = Math.max(0, min);
                }
                if (!isSmoothScrollbarEnabled) {
                    return max;
                }
                return Math.round((max * (Math.abs(this.mOrientationHelper.d(findFirstVisibleChildClosestToEnd) - this.mOrientationHelper.g(findFirstVisibleChildClosestToStart)) / ((this.f10835g.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToEnd), this.f10830b) - this.f10835g.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToStart), this.f10830b)) + 1))) + (this.mOrientationHelper.n() - this.mOrientationHelper.g(findFirstVisibleChildClosestToStart)));
            }
        }
        return 0;
    }

    public final int k(RecyclerView.y yVar) {
        if (getChildCount() != 0 && yVar.b() != 0) {
            ensureLayoutState();
            View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled(), true);
            View findFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled(), true);
            if (findFirstVisibleChildClosestToStart != null && findFirstVisibleChildClosestToEnd != null) {
                if (!isSmoothScrollbarEnabled()) {
                    return this.f10835g.getCachedSpanGroupIndex(yVar.b() - 1, this.f10830b) + 1;
                }
                int d10 = this.mOrientationHelper.d(findFirstVisibleChildClosestToEnd) - this.mOrientationHelper.g(findFirstVisibleChildClosestToStart);
                int cachedSpanGroupIndex = this.f10835g.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToStart), this.f10830b);
                return (int) ((d10 / ((this.f10835g.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToEnd), this.f10830b) - cachedSpanGroupIndex) + 1)) * (this.f10835g.getCachedSpanGroupIndex(yVar.b() - 1, this.f10830b) + 1));
            }
        }
        return 0;
    }

    public final void l(RecyclerView.u uVar, RecyclerView.y yVar, LinearLayoutManager.a aVar, int i10) {
        boolean z10;
        if (i10 == 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        int q10 = q(uVar, yVar, aVar.f10844b);
        if (z10) {
            while (q10 > 0) {
                int i11 = aVar.f10844b;
                if (i11 > 0) {
                    int i12 = i11 - 1;
                    aVar.f10844b = i12;
                    q10 = q(uVar, yVar, i12);
                } else {
                    return;
                }
            }
            return;
        }
        int b10 = yVar.b() - 1;
        int i13 = aVar.f10844b;
        while (i13 < b10) {
            int i14 = i13 + 1;
            int q11 = q(uVar, yVar, i14);
            if (q11 <= q10) {
                break;
            }
            i13 = i14;
            q10 = q11;
        }
        aVar.f10844b = i13;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x009f, code lost:
    
        r21.f10849b = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a1, code lost:
    
        return;
     */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void layoutChunk(androidx.recyclerview.widget.RecyclerView.u r18, androidx.recyclerview.widget.RecyclerView.y r19, androidx.recyclerview.widget.LinearLayoutManager.c r20, androidx.recyclerview.widget.LinearLayoutManager.b r21) {
        /*
            Method dump skipped, instructions count: 557
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.layoutChunk(androidx.recyclerview.widget.RecyclerView$u, androidx.recyclerview.widget.RecyclerView$y, androidx.recyclerview.widget.LinearLayoutManager$c, androidx.recyclerview.widget.LinearLayoutManager$b):void");
    }

    public final void m() {
        View[] viewArr = this.f10832d;
        if (viewArr == null || viewArr.length != this.f10830b) {
            this.f10832d = new View[this.f10830b];
        }
    }

    public int n(int i10, int i11) {
        if (this.mOrientation == 1 && isLayoutRTL()) {
            int[] iArr = this.f10831c;
            int i12 = this.f10830b;
            return iArr[i12 - i10] - iArr[(i12 - i10) - i11];
        }
        int[] iArr2 = this.f10831c;
        return iArr2[i11 + i10] - iArr2[i10];
    }

    public int o() {
        return this.f10830b;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void onAnchorReady(RecyclerView.u uVar, RecyclerView.y yVar, LinearLayoutManager.a aVar, int i10) {
        super.onAnchorReady(uVar, yVar, aVar, i10);
        x();
        if (yVar.b() > 0 && !yVar.e()) {
            l(uVar, yVar, aVar, i10);
        }
        m();
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x00d1, code lost:
    
        if (r13 == r7) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00f1, code lost:
    
        if (r13 == r10) goto L70;
     */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x010f  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View onFocusSearchFailed(android.view.View r24, int r25, androidx.recyclerview.widget.RecyclerView.u r26, androidx.recyclerview.widget.RecyclerView.y r27) {
        /*
            Method dump skipped, instructions count: 317
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.onFocusSearchFailed(android.view.View, int, androidx.recyclerview.widget.RecyclerView$u, androidx.recyclerview.widget.RecyclerView$y):android.view.View");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.u uVar, RecyclerView.y yVar, View view, J.d dVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, dVar);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        int p10 = p(uVar, yVar, layoutParams2.a());
        if (this.mOrientation == 0) {
            dVar.k0(d.f.a(layoutParams2.e(), layoutParams2.f(), p10, 1, false, false));
        } else {
            dVar.k0(d.f.a(p10, 1, layoutParams2.e(), layoutParams2.f(), false, false));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onItemsAdded(RecyclerView recyclerView, int i10, int i11) {
        this.f10835g.invalidateSpanIndexCache();
        this.f10835g.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onItemsChanged(RecyclerView recyclerView) {
        this.f10835g.invalidateSpanIndexCache();
        this.f10835g.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onItemsMoved(RecyclerView recyclerView, int i10, int i11, int i12) {
        this.f10835g.invalidateSpanIndexCache();
        this.f10835g.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onItemsRemoved(RecyclerView recyclerView, int i10, int i11) {
        this.f10835g.invalidateSpanIndexCache();
        this.f10835g.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onItemsUpdated(RecyclerView recyclerView, int i10, int i11, Object obj) {
        this.f10835g.invalidateSpanIndexCache();
        this.f10835g.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void onLayoutChildren(RecyclerView.u uVar, RecyclerView.y yVar) {
        if (yVar.e()) {
            f();
        }
        super.onLayoutChildren(uVar, yVar);
        i();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void onLayoutCompleted(RecyclerView.y yVar) {
        super.onLayoutCompleted(yVar);
        this.f10829a = false;
    }

    public final int p(RecyclerView.u uVar, RecyclerView.y yVar, int i10) {
        if (!yVar.e()) {
            return this.f10835g.getCachedSpanGroupIndex(i10, this.f10830b);
        }
        int f10 = uVar.f(i10);
        if (f10 == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i10);
            return 0;
        }
        return this.f10835g.getCachedSpanGroupIndex(f10, this.f10830b);
    }

    public final int q(RecyclerView.u uVar, RecyclerView.y yVar, int i10) {
        if (!yVar.e()) {
            return this.f10835g.getCachedSpanIndex(i10, this.f10830b);
        }
        int i11 = this.f10834f.get(i10, -1);
        if (i11 != -1) {
            return i11;
        }
        int f10 = uVar.f(i10);
        if (f10 == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i10);
            return 0;
        }
        return this.f10835g.getCachedSpanIndex(f10, this.f10830b);
    }

    public final int r(RecyclerView.u uVar, RecyclerView.y yVar, int i10) {
        if (!yVar.e()) {
            return this.f10835g.getSpanSize(i10);
        }
        int i11 = this.f10833e.get(i10, -1);
        if (i11 != -1) {
            return i11;
        }
        int f10 = uVar.f(i10);
        if (f10 == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i10);
            return 1;
        }
        return this.f10835g.getSpanSize(f10);
    }

    public final void s(float f10, int i10) {
        g(Math.max(Math.round(f10 * this.f10830b), i10));
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int scrollHorizontallyBy(int i10, RecyclerView.u uVar, RecyclerView.y yVar) {
        x();
        m();
        return super.scrollHorizontallyBy(i10, uVar, yVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int scrollVerticallyBy(int i10, RecyclerView.u uVar, RecyclerView.y yVar) {
        x();
        m();
        return super.scrollVerticallyBy(i10, uVar, yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void setMeasuredDimension(Rect rect, int i10, int i11) {
        int chooseSize;
        int chooseSize2;
        if (this.f10831c == null) {
            super.setMeasuredDimension(rect, i10, i11);
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation == 1) {
            chooseSize2 = RecyclerView.o.chooseSize(i11, rect.height() + paddingTop, getMinimumHeight());
            int[] iArr = this.f10831c;
            chooseSize = RecyclerView.o.chooseSize(i10, iArr[iArr.length - 1] + paddingLeft, getMinimumWidth());
        } else {
            chooseSize = RecyclerView.o.chooseSize(i10, rect.width() + paddingLeft, getMinimumWidth());
            int[] iArr2 = this.f10831c;
            chooseSize2 = RecyclerView.o.chooseSize(i11, iArr2[iArr2.length - 1] + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(chooseSize, chooseSize2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void setStackFromEnd(boolean z10) {
        if (!z10) {
            super.setStackFromEnd(false);
            return;
        }
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public boolean supportsPredictiveItemAnimations() {
        if (this.mPendingSavedState == null && !this.f10829a) {
            return true;
        }
        return false;
    }

    public final void t(View view, int i10, boolean z10) {
        int i11;
        int i12;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect = layoutParams.f10877b;
        int i13 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        int i14 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        int n10 = n(layoutParams.f10838e, layoutParams.f10839f);
        if (this.mOrientation == 1) {
            i12 = RecyclerView.o.getChildMeasureSpec(n10, i10, i14, ((ViewGroup.MarginLayoutParams) layoutParams).width, false);
            i11 = RecyclerView.o.getChildMeasureSpec(this.mOrientationHelper.o(), getHeightMode(), i13, ((ViewGroup.MarginLayoutParams) layoutParams).height, true);
        } else {
            int childMeasureSpec = RecyclerView.o.getChildMeasureSpec(n10, i10, i13, ((ViewGroup.MarginLayoutParams) layoutParams).height, false);
            int childMeasureSpec2 = RecyclerView.o.getChildMeasureSpec(this.mOrientationHelper.o(), getWidthMode(), i14, ((ViewGroup.MarginLayoutParams) layoutParams).width, true);
            i11 = childMeasureSpec;
            i12 = childMeasureSpec2;
        }
        u(view, i12, i11, z10);
    }

    public final void u(View view, int i10, int i11, boolean z10) {
        boolean shouldMeasureChild;
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (z10) {
            shouldMeasureChild = shouldReMeasureChild(view, i10, i11, layoutParams);
        } else {
            shouldMeasureChild = shouldMeasureChild(view, i10, i11, layoutParams);
        }
        if (shouldMeasureChild) {
            view.measure(i10, i11);
        }
    }

    public void v(int i10) {
        if (i10 == this.f10830b) {
            return;
        }
        this.f10829a = true;
        if (i10 >= 1) {
            this.f10830b = i10;
            this.f10835g.invalidateSpanIndexCache();
            requestLayout();
        } else {
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i10);
        }
    }

    public void w(b bVar) {
        this.f10835g = bVar;
    }

    public final void x() {
        int height;
        int paddingTop;
        if (getOrientation() == 1) {
            height = getWidth() - getPaddingRight();
            paddingTop = getPaddingLeft();
        } else {
            height = getHeight() - getPaddingBottom();
            paddingTop = getPaddingTop();
        }
        g(height - paddingTop);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends RecyclerView.LayoutParams {

        /* renamed from: e, reason: collision with root package name */
        public int f10838e;

        /* renamed from: f, reason: collision with root package name */
        public int f10839f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f10838e = -1;
            this.f10839f = 0;
        }

        public int e() {
            return this.f10838e;
        }

        public int f() {
            return this.f10839f;
        }

        public LayoutParams(int i10, int i11) {
            super(i10, i11);
            this.f10838e = -1;
            this.f10839f = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f10838e = -1;
            this.f10839f = 0;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f10838e = -1;
            this.f10839f = 0;
        }
    }

    public GridLayoutManager(Context context, int i10) {
        super(context);
        this.f10829a = false;
        this.f10830b = -1;
        this.f10833e = new SparseIntArray();
        this.f10834f = new SparseIntArray();
        this.f10835g = new a();
        this.f10836h = new Rect();
        v(i10);
    }

    public GridLayoutManager(Context context, int i10, int i11, boolean z10) {
        super(context, i11, z10);
        this.f10829a = false;
        this.f10830b = -1;
        this.f10833e = new SparseIntArray();
        this.f10834f = new SparseIntArray();
        this.f10835g = new a();
        this.f10836h = new Rect();
        v(i10);
    }
}
