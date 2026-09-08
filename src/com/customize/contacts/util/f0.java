package com.customize.contacts.util;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

/* compiled from: SmoothScrollToTopTask.java */
/* loaded from: classes3.dex */
public class f0 implements Runnable, AbsListView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    public final int f22119a;

    /* renamed from: b, reason: collision with root package name */
    public final int f22120b;

    /* renamed from: c, reason: collision with root package name */
    public final ListView f22121c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f22122d = false;

    /* renamed from: e, reason: collision with root package name */
    public int f22123e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f22124f = 0;

    /* renamed from: g, reason: collision with root package name */
    public boolean f22125g = false;

    public f0(ListView listView, int i10, int i11) {
        this.f22121c = listView;
        this.f22120b = i10;
        this.f22119a = i11;
        d();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b() {
        /*
            r7 = this;
            android.widget.ListView r0 = r7.f22121c
            r1 = 0
            android.view.View r0 = r0.getChildAt(r1)
            android.widget.ListView r2 = r7.f22121c
            int r2 = r2.getFirstVisiblePosition()
            r3 = r1
            r4 = r3
        Lf:
            if (r2 != 0) goto L12
            goto L33
        L12:
            int r5 = r7.c(r4)
            android.widget.ListView r6 = r7.f22121c
            int r6 = r6.getDividerHeight()
            int r5 = r5 + r6
            int r3 = r3 + r5
            int r4 = r4 + 1
            int r5 = r7.f22120b
            if (r5 != 0) goto L2f
            android.widget.ListView r5 = r7.f22121c
            int r5 = r5.getHeight()
            if (r3 >= r5) goto L33
            if (r4 < r2) goto Lf
            goto L33
        L2f:
            if (r4 >= r5) goto L33
            if (r4 < r2) goto Lf
        L33:
            if (r2 <= r4) goto L36
            goto L3c
        L36:
            if (r0 == 0) goto L3c
            int r1 = r0.getTop()
        L3c:
            int r0 = r7.f22120b
            if (r4 < r0) goto L4e
            if (r2 != r0) goto L4b
            android.widget.ListView r0 = r7.f22121c
            int r0 = r0.getPaddingTop()
        L48:
            int r0 = r0 + r3
            int r0 = r0 - r1
            goto L55
        L4b:
            int r0 = r3 - r1
            goto L55
        L4e:
            android.widget.ListView r0 = r7.f22121c
            int r0 = r0.getPaddingTop()
            goto L48
        L55:
            boolean r1 = H7.a.b()
            if (r1 == 0) goto L71
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "distance="
            r1.append(r2)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "SmoothScrollToTopTask"
            H7.b.b(r2, r1)
        L71:
            r7.f22124f = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.util.f0.b():void");
    }

    public final int c(int i10) {
        if (this.f22121c.getAdapter().getCount() != 0 && this.f22121c.getAdapter().getCount() >= i10) {
            try {
                View view = this.f22121c.getAdapter().getView(i10, null, this.f22121c);
                if (view == null) {
                    return 0;
                }
                if (view.getMeasuredHeight() > 0) {
                    return view.getMeasuredHeight();
                }
                view.measure(View.MeasureSpec.makeMeasureSpec((this.f22121c.getWidth() - this.f22121c.getPaddingStart()) - this.f22121c.getPaddingEnd(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
                int measuredHeight = view.getMeasuredHeight();
                if (H7.a.b()) {
                    H7.b.b("SmoothScrollToTopTask", "itemHeight " + i10 + " = " + measuredHeight);
                }
                return measuredHeight;
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public final void d() {
        ListView listView = this.f22121c;
        if (listView != null) {
            listView.setOnScrollListener(this);
        }
    }

    public void e() {
        ListView listView = this.f22121c;
        if (listView != null && listView.getScrollY() == 0) {
            if (this.f22125g) {
                H7.b.c("SmoothScrollToTopTask", "still running now");
                return;
            }
            this.f22125g = true;
            ListView listView2 = this.f22121c;
            if (listView2 != null && listView2.getAdapter() != null && this.f22121c.getAdapter().getCount() > 0) {
                View childAt = this.f22121c.getChildAt(0);
                if (childAt == null) {
                    H7.b.c("SmoothScrollToTopTask", "firstVisiView is null");
                    f();
                    return;
                }
                int firstVisiblePosition = this.f22121c.getFirstVisiblePosition();
                if (H7.a.b()) {
                    H7.b.b("SmoothScrollToTopTask", "firstVisiblePosition=" + firstVisiblePosition + " firstVisiViewTop=" + childAt.getTop() + " listPaddingTop=" + this.f22121c.getPaddingTop() + " dividerHeight=" + this.f22121c.getDividerHeight() + " listViewHeight=" + this.f22121c.getHeight());
                }
                if (firstVisiblePosition == 0 && childAt.getTop() == this.f22121c.getPaddingTop()) {
                    H7.b.c("SmoothScrollToTopTask", "already at top");
                    f();
                    return;
                } else {
                    b();
                    this.f22121c.postOnAnimation(this);
                    return;
                }
            }
            H7.b.c("SmoothScrollToTopTask", "mListView is null");
            f();
            return;
        }
        H7.b.c("SmoothScrollToTopTask", "mListView is OVERSCROLL or OVERFLING");
    }

    public final void f() {
        this.f22125g = false;
        this.f22124f = 0;
        this.f22122d = false;
        ListView listView = this.f22121c;
        if (listView != null) {
            listView.setSelection(0);
            ListView listView2 = this.f22121c;
            listView2.dispatchWindowVisibilityChanged(listView2.getVisibility());
            if (this.f22121c.getScrollY() == 0 && this.f22123e == 0) {
                try {
                    this.f22121c.smoothScrollBy(0, 0);
                } catch (Exception e10) {
                    H7.b.c("SmoothScrollToTopTask", " stop error" + e10);
                }
            }
        }
    }

    public void g() {
        H7.b.b("SmoothScrollToTopTask", "unregisterOnScrollListener SmoothScrollToTop");
        ListView listView = this.f22121c;
        if (listView != null) {
            listView.setOnScrollListener(null);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i10) {
        this.f22123e = i10;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f22121c.smoothScrollBy(0, 0);
        int firstVisiblePosition = this.f22121c.getFirstVisiblePosition();
        int i10 = this.f22120b;
        if (firstVisiblePosition > i10) {
            this.f22121c.setSelectionFromTop(i10, 0);
            this.f22121c.postOnAnimation(this);
        } else {
            this.f22121c.smoothScrollBy(-this.f22124f, this.f22119a);
            this.f22121c.postDelayed(new Runnable() { // from class: com.customize.contacts.util.e0
                @Override // java.lang.Runnable
                public final void run() {
                    f0.this.f();
                }
            }, this.f22119a);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
    }
}
