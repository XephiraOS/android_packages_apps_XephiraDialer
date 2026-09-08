package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

/* compiled from: ScrollEventAdapter.java */
/* loaded from: classes.dex */
public final class e extends RecyclerView.s {

    /* renamed from: a, reason: collision with root package name */
    public ViewPager2.i f11868a;

    /* renamed from: b, reason: collision with root package name */
    public final ViewPager2 f11869b;

    /* renamed from: c, reason: collision with root package name */
    public final RecyclerView f11870c;

    /* renamed from: d, reason: collision with root package name */
    public final LinearLayoutManager f11871d;

    /* renamed from: e, reason: collision with root package name */
    public int f11872e;

    /* renamed from: f, reason: collision with root package name */
    public int f11873f;

    /* renamed from: g, reason: collision with root package name */
    public a f11874g;

    /* renamed from: h, reason: collision with root package name */
    public int f11875h;

    /* renamed from: i, reason: collision with root package name */
    public int f11876i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f11877j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f11878k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f11879l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f11880m;

    /* compiled from: ScrollEventAdapter.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public int f11881a;

        /* renamed from: b, reason: collision with root package name */
        public float f11882b;

        /* renamed from: c, reason: collision with root package name */
        public int f11883c;

        public void a() {
            this.f11881a = -1;
            this.f11882b = 0.0f;
            this.f11883c = 0;
        }
    }

    public e(ViewPager2 viewPager2) {
        this.f11869b = viewPager2;
        RecyclerView recyclerView = viewPager2.f11827j;
        this.f11870c = recyclerView;
        this.f11871d = (LinearLayoutManager) recyclerView.getLayoutManager();
        this.f11874g = new a();
        resetState();
    }

    public final void dispatchScrolled(int i10, float f10, int i11) {
        ViewPager2.i iVar = this.f11868a;
        if (iVar != null) {
            iVar.onPageScrolled(i10, f10, i11);
        }
    }

    public final void dispatchSelected(int i10) {
        ViewPager2.i iVar = this.f11868a;
        if (iVar != null) {
            iVar.onPageSelected(i10);
        }
    }

    public final void dispatchStateChanged(int i10) {
        if ((this.f11872e == 3 && this.f11873f == 0) || this.f11873f == i10) {
            return;
        }
        this.f11873f = i10;
        ViewPager2.i iVar = this.f11868a;
        if (iVar != null) {
            iVar.onPageScrollStateChanged(i10);
        }
    }

    public final int getPosition() {
        return this.f11871d.findFirstVisibleItemPosition();
    }

    public double getRelativeScrollPosition() {
        updateScrollEventValues();
        a aVar = this.f11874g;
        return aVar.f11881a + aVar.f11882b;
    }

    public int getScrollState() {
        return this.f11873f;
    }

    public boolean isFakeDragging() {
        return this.f11880m;
    }

    public boolean isIdle() {
        if (this.f11873f == 0) {
            return true;
        }
        return false;
    }

    public final boolean isInAnyDraggingState() {
        int i10 = this.f11872e;
        if (i10 == 1 || i10 == 4) {
            return true;
        }
        return false;
    }

    public void notifyDataSetChangeHappened() {
        this.f11879l = true;
    }

    public void notifyProgrammaticScroll(int i10, boolean z10) {
        int i11;
        if (z10) {
            i11 = 2;
        } else {
            i11 = 3;
        }
        this.f11872e = i11;
        boolean z11 = false;
        this.f11880m = false;
        if (this.f11876i != i10) {
            z11 = true;
        }
        this.f11876i = i10;
        dispatchStateChanged(2);
        if (z11) {
            dispatchSelected(i10);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public void onScrollStateChanged(RecyclerView recyclerView, int i10) {
        if ((this.f11872e != 1 || this.f11873f != 1) && i10 == 1) {
            startDrag(false);
            return;
        }
        if (isInAnyDraggingState() && i10 == 2) {
            if (this.f11878k) {
                dispatchStateChanged(2);
                this.f11877j = true;
                return;
            }
            return;
        }
        if (isInAnyDraggingState() && i10 == 0) {
            updateScrollEventValues();
            if (!this.f11878k) {
                int i11 = this.f11874g.f11881a;
                if (i11 != -1) {
                    dispatchScrolled(i11, 0.0f, 0);
                }
            } else {
                a aVar = this.f11874g;
                if (aVar.f11883c == 0) {
                    int i12 = this.f11875h;
                    int i13 = aVar.f11881a;
                    if (i12 != i13) {
                        dispatchSelected(i13);
                    }
                }
            }
            dispatchStateChanged(0);
            resetState();
        }
        if (this.f11872e == 2 && i10 == 0 && this.f11879l) {
            updateScrollEventValues();
            a aVar2 = this.f11874g;
            if (aVar2.f11883c == 0) {
                int i14 = this.f11876i;
                int i15 = aVar2.f11881a;
                if (i14 != i15) {
                    if (i15 == -1) {
                        i15 = 0;
                    }
                    dispatchSelected(i15);
                }
                dispatchStateChanged(0);
                resetState();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001d, code lost:
    
        if (r5 == r3.f11869b.d()) goto L12;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
    @Override // androidx.recyclerview.widget.RecyclerView.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onScrolled(androidx.recyclerview.widget.RecyclerView r4, int r5, int r6) {
        /*
            r3 = this;
            r4 = 1
            r3.f11878k = r4
            r3.updateScrollEventValues()
            boolean r0 = r3.f11877j
            r1 = -1
            r2 = 0
            if (r0 == 0) goto L37
            r3.f11877j = r2
            if (r6 > 0) goto L1f
            if (r6 != 0) goto L29
            if (r5 >= 0) goto L16
            r5 = r4
            goto L17
        L16:
            r5 = r2
        L17:
            androidx.viewpager2.widget.ViewPager2 r6 = r3.f11869b
            boolean r6 = r6.d()
            if (r5 != r6) goto L29
        L1f:
            androidx.viewpager2.widget.e$a r5 = r3.f11874g
            int r6 = r5.f11883c
            if (r6 == 0) goto L29
            int r5 = r5.f11881a
            int r5 = r5 + r4
            goto L2d
        L29:
            androidx.viewpager2.widget.e$a r5 = r3.f11874g
            int r5 = r5.f11881a
        L2d:
            r3.f11876i = r5
            int r6 = r3.f11875h
            if (r6 == r5) goto L45
            r3.dispatchSelected(r5)
            goto L45
        L37:
            int r5 = r3.f11872e
            if (r5 != 0) goto L45
            androidx.viewpager2.widget.e$a r5 = r3.f11874g
            int r5 = r5.f11881a
            if (r5 != r1) goto L42
            r5 = r2
        L42:
            r3.dispatchSelected(r5)
        L45:
            androidx.viewpager2.widget.e$a r5 = r3.f11874g
            int r6 = r5.f11881a
            if (r6 != r1) goto L4c
            r6 = r2
        L4c:
            float r0 = r5.f11882b
            int r5 = r5.f11883c
            r3.dispatchScrolled(r6, r0, r5)
            androidx.viewpager2.widget.e$a r5 = r3.f11874g
            int r6 = r5.f11881a
            int r0 = r3.f11876i
            if (r6 == r0) goto L5d
            if (r0 != r1) goto L6b
        L5d:
            int r5 = r5.f11883c
            if (r5 != 0) goto L6b
            int r5 = r3.f11873f
            if (r5 == r4) goto L6b
            r3.dispatchStateChanged(r2)
            r3.resetState()
        L6b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager2.widget.e.onScrolled(androidx.recyclerview.widget.RecyclerView, int, int):void");
    }

    public final void resetState() {
        this.f11872e = 0;
        this.f11873f = 0;
        this.f11874g.a();
        this.f11875h = -1;
        this.f11876i = -1;
        this.f11877j = false;
        this.f11878k = false;
        this.f11880m = false;
        this.f11879l = false;
    }

    public void setOnPageChangeCallback(ViewPager2.i iVar) {
        this.f11868a = iVar;
    }

    public final void startDrag(boolean z10) {
        int i10;
        this.f11880m = z10;
        if (z10) {
            i10 = 4;
        } else {
            i10 = 1;
        }
        this.f11872e = i10;
        int i11 = this.f11876i;
        if (i11 != -1) {
            this.f11875h = i11;
            this.f11876i = -1;
        } else if (this.f11875h == -1) {
            this.f11875h = getPosition();
        }
        dispatchStateChanged(1);
    }

    public final void updateScrollEventValues() {
        int top;
        float f10;
        a aVar = this.f11874g;
        int findFirstVisibleItemPosition = this.f11871d.findFirstVisibleItemPosition();
        aVar.f11881a = findFirstVisibleItemPosition;
        if (findFirstVisibleItemPosition == -1) {
            aVar.a();
            return;
        }
        View findViewByPosition = this.f11871d.findViewByPosition(findFirstVisibleItemPosition);
        if (findViewByPosition == null) {
            aVar.a();
            return;
        }
        int leftDecorationWidth = this.f11871d.getLeftDecorationWidth(findViewByPosition);
        int rightDecorationWidth = this.f11871d.getRightDecorationWidth(findViewByPosition);
        int topDecorationHeight = this.f11871d.getTopDecorationHeight(findViewByPosition);
        int bottomDecorationHeight = this.f11871d.getBottomDecorationHeight(findViewByPosition);
        ViewGroup.LayoutParams layoutParams = findViewByPosition.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            leftDecorationWidth += marginLayoutParams.leftMargin;
            rightDecorationWidth += marginLayoutParams.rightMargin;
            topDecorationHeight += marginLayoutParams.topMargin;
            bottomDecorationHeight += marginLayoutParams.bottomMargin;
        }
        int height = findViewByPosition.getHeight() + topDecorationHeight + bottomDecorationHeight;
        int width = findViewByPosition.getWidth() + leftDecorationWidth + rightDecorationWidth;
        if (this.f11871d.getOrientation() == 0) {
            top = (findViewByPosition.getLeft() - leftDecorationWidth) - this.f11870c.getPaddingLeft();
            if (this.f11869b.d()) {
                top = -top;
            }
            height = width;
        } else {
            top = (findViewByPosition.getTop() - topDecorationHeight) - this.f11870c.getPaddingTop();
        }
        int i10 = -top;
        aVar.f11883c = i10;
        if (i10 < 0) {
            if (new androidx.viewpager2.widget.a(this.f11871d).d()) {
                throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
            }
            throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", Integer.valueOf(aVar.f11883c)));
        }
        if (height == 0) {
            f10 = 0.0f;
        } else {
            f10 = i10 / height;
        }
        aVar.f11882b = f10;
    }
}
