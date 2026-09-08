package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* compiled from: GapWorker.java */
/* loaded from: classes.dex */
public final class l implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public static final ThreadLocal<l> f11174e = new ThreadLocal<>();

    /* renamed from: f, reason: collision with root package name */
    public static Comparator<c> f11175f = new a();

    /* renamed from: b, reason: collision with root package name */
    public long f11177b;

    /* renamed from: c, reason: collision with root package name */
    public long f11178c;

    /* renamed from: a, reason: collision with root package name */
    public ArrayList<RecyclerView> f11176a = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<c> f11179d = new ArrayList<>();

    /* compiled from: GapWorker.java */
    /* loaded from: classes.dex */
    public class a implements Comparator<c> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(c cVar, c cVar2) {
            boolean z10;
            boolean z11;
            RecyclerView recyclerView = cVar.f11187d;
            if (recyclerView == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (cVar2.f11187d == null) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z10 != z11) {
                if (recyclerView == null) {
                    return 1;
                }
                return -1;
            }
            boolean z12 = cVar.f11184a;
            if (z12 != cVar2.f11184a) {
                if (!z12) {
                    return 1;
                }
                return -1;
            }
            int i10 = cVar2.f11185b - cVar.f11185b;
            if (i10 != 0) {
                return i10;
            }
            int i11 = cVar.f11186c - cVar2.f11186c;
            if (i11 == 0) {
                return 0;
            }
            return i11;
        }
    }

    /* compiled from: GapWorker.java */
    /* loaded from: classes.dex */
    public static class b implements RecyclerView.o.c {

        /* renamed from: a, reason: collision with root package name */
        public int f11180a;

        /* renamed from: b, reason: collision with root package name */
        public int f11181b;

        /* renamed from: c, reason: collision with root package name */
        public int[] f11182c;

        /* renamed from: d, reason: collision with root package name */
        public int f11183d;

        @Override // androidx.recyclerview.widget.RecyclerView.o.c
        public void a(int i10, int i11) {
            if (i10 >= 0) {
                if (i11 >= 0) {
                    int i12 = this.f11183d;
                    int i13 = i12 * 2;
                    int[] iArr = this.f11182c;
                    if (iArr == null) {
                        int[] iArr2 = new int[4];
                        this.f11182c = iArr2;
                        Arrays.fill(iArr2, -1);
                    } else if (i13 >= iArr.length) {
                        int[] iArr3 = new int[i12 * 4];
                        this.f11182c = iArr3;
                        System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                    }
                    int[] iArr4 = this.f11182c;
                    iArr4[i13] = i10;
                    iArr4[i13 + 1] = i11;
                    this.f11183d++;
                    return;
                }
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            throw new IllegalArgumentException("Layout positions must be non-negative");
        }

        public void b() {
            int[] iArr = this.f11182c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f11183d = 0;
        }

        public void c(RecyclerView recyclerView, boolean z10) {
            this.f11183d = 0;
            int[] iArr = this.f11182c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.o oVar = recyclerView.mLayout;
            if (recyclerView.mAdapter != null && oVar != null && oVar.isItemPrefetchEnabled()) {
                if (z10) {
                    if (!recyclerView.mAdapterHelper.p()) {
                        oVar.collectInitialPrefetchPositions(recyclerView.mAdapter.getItemCount(), this);
                    }
                } else if (!recyclerView.hasPendingAdapterUpdates()) {
                    oVar.collectAdjacentPrefetchPositions(this.f11180a, this.f11181b, recyclerView.mState, this);
                }
                int i10 = this.f11183d;
                if (i10 > oVar.mPrefetchMaxCountObserved) {
                    oVar.mPrefetchMaxCountObserved = i10;
                    oVar.mPrefetchMaxObservedInInitialPrefetch = z10;
                    recyclerView.mRecycler.K();
                }
            }
        }

        public boolean d(int i10) {
            if (this.f11182c != null) {
                int i11 = this.f11183d * 2;
                for (int i12 = 0; i12 < i11; i12 += 2) {
                    if (this.f11182c[i12] == i10) {
                        return true;
                    }
                }
            }
            return false;
        }

        public void e(int i10, int i11) {
            this.f11180a = i10;
            this.f11181b = i11;
        }
    }

    /* compiled from: GapWorker.java */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public boolean f11184a;

        /* renamed from: b, reason: collision with root package name */
        public int f11185b;

        /* renamed from: c, reason: collision with root package name */
        public int f11186c;

        /* renamed from: d, reason: collision with root package name */
        public RecyclerView f11187d;

        /* renamed from: e, reason: collision with root package name */
        public int f11188e;

        public void a() {
            this.f11184a = false;
            this.f11185b = 0;
            this.f11186c = 0;
            this.f11187d = null;
            this.f11188e = 0;
        }
    }

    public static boolean e(RecyclerView recyclerView, int i10) {
        int j10 = recyclerView.mChildHelper.j();
        for (int i11 = 0; i11 < j10; i11++) {
            RecyclerView.B childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.i(i11));
            if (childViewHolderInt.mPosition == i10 && !childViewHolderInt.isInvalid()) {
                return true;
            }
        }
        return false;
    }

    public void a(RecyclerView recyclerView) {
        this.f11176a.add(recyclerView);
    }

    public final void b() {
        c cVar;
        boolean z10;
        int size = this.f11176a.size();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            RecyclerView recyclerView = this.f11176a.get(i11);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.mPrefetchRegistry.c(recyclerView, false);
                i10 += recyclerView.mPrefetchRegistry.f11183d;
            }
        }
        this.f11179d.ensureCapacity(i10);
        int i12 = 0;
        for (int i13 = 0; i13 < size; i13++) {
            RecyclerView recyclerView2 = this.f11176a.get(i13);
            if (recyclerView2.getWindowVisibility() == 0) {
                b bVar = recyclerView2.mPrefetchRegistry;
                int abs = Math.abs(bVar.f11180a) + Math.abs(bVar.f11181b);
                for (int i14 = 0; i14 < bVar.f11183d * 2; i14 += 2) {
                    if (i12 >= this.f11179d.size()) {
                        cVar = new c();
                        this.f11179d.add(cVar);
                    } else {
                        cVar = this.f11179d.get(i12);
                    }
                    int[] iArr = bVar.f11182c;
                    int i15 = iArr[i14 + 1];
                    if (i15 <= abs) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    cVar.f11184a = z10;
                    cVar.f11185b = abs;
                    cVar.f11186c = i15;
                    cVar.f11187d = recyclerView2;
                    cVar.f11188e = iArr[i14];
                    i12++;
                }
            }
        }
        Collections.sort(this.f11179d, f11175f);
    }

    public final void c(c cVar, long j10) {
        long j11;
        if (cVar.f11184a) {
            j11 = Long.MAX_VALUE;
        } else {
            j11 = j10;
        }
        RecyclerView.B i10 = i(cVar.f11187d, cVar.f11188e, j11);
        if (i10 != null && i10.mNestedRecyclerView != null && i10.isBound() && !i10.isInvalid()) {
            h(i10.mNestedRecyclerView.get(), j10);
        }
    }

    public final void d(long j10) {
        for (int i10 = 0; i10 < this.f11179d.size(); i10++) {
            c cVar = this.f11179d.get(i10);
            if (cVar.f11187d != null) {
                c(cVar, j10);
                cVar.a();
            } else {
                return;
            }
        }
    }

    public void f(RecyclerView recyclerView, int i10, int i11) {
        if (recyclerView.isAttachedToWindow() && this.f11177b == 0) {
            this.f11177b = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.mPrefetchRegistry.e(i10, i11);
    }

    public void g(long j10) {
        b();
        d(j10);
    }

    public final void h(RecyclerView recyclerView, long j10) {
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.mDataSetHasChangedAfterLayout && recyclerView.mChildHelper.j() != 0) {
            recyclerView.removeAndRecycleViews();
        }
        b bVar = recyclerView.mPrefetchRegistry;
        bVar.c(recyclerView, true);
        if (bVar.f11183d != 0) {
            try {
                F.h.a("RV Nested Prefetch");
                recyclerView.mState.f(recyclerView.mAdapter);
                for (int i10 = 0; i10 < bVar.f11183d * 2; i10 += 2) {
                    i(recyclerView, bVar.f11182c[i10], j10);
                }
            } finally {
                F.h.b();
            }
        }
    }

    public final RecyclerView.B i(RecyclerView recyclerView, int i10, long j10) {
        if (e(recyclerView, i10)) {
            return null;
        }
        RecyclerView.u uVar = recyclerView.mRecycler;
        try {
            recyclerView.onEnterLayoutOrScroll();
            RecyclerView.B I10 = uVar.I(i10, false, j10);
            if (I10 != null) {
                if (I10.isBound() && !I10.isInvalid()) {
                    uVar.B(I10.itemView);
                } else {
                    uVar.a(I10, false);
                }
            }
            recyclerView.onExitLayoutOrScroll(false);
            return I10;
        } catch (Throwable th) {
            recyclerView.onExitLayoutOrScroll(false);
            throw th;
        }
    }

    public void j(RecyclerView recyclerView) {
        this.f11176a.remove(recyclerView);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            F.h.a("RV Prefetch");
            if (!this.f11176a.isEmpty()) {
                int size = this.f11176a.size();
                long j10 = 0;
                for (int i10 = 0; i10 < size; i10++) {
                    RecyclerView recyclerView = this.f11176a.get(i10);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j10 = Math.max(recyclerView.getDrawingTime(), j10);
                    }
                }
                if (j10 != 0) {
                    g(TimeUnit.MILLISECONDS.toNanos(j10) + this.f11178c);
                    this.f11177b = 0L;
                    F.h.b();
                }
            }
        } finally {
            this.f11177b = 0L;
            F.h.b();
        }
    }
}
