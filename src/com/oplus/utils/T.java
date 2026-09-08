package com.oplus.utils;

import android.app.Activity;
import android.database.DataSetObserver;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

/* compiled from: SmoothScrollToTopTask.java */
/* loaded from: classes3.dex */
public class T implements Runnable, AbsListView.OnScrollListener {

    /* renamed from: i, reason: collision with root package name */
    public static T f29092i;

    /* renamed from: a, reason: collision with root package name */
    public final int f29093a;

    /* renamed from: b, reason: collision with root package name */
    public final int f29094b;

    /* renamed from: c, reason: collision with root package name */
    public final ListView f29095c;

    /* renamed from: f, reason: collision with root package name */
    public boolean f29098f;

    /* renamed from: g, reason: collision with root package name */
    public int f29099g;

    /* renamed from: d, reason: collision with root package name */
    public int f29096d = 0;

    /* renamed from: e, reason: collision with root package name */
    public boolean f29097e = false;

    /* renamed from: h, reason: collision with root package name */
    public DataSetObserver f29100h = new a();

    /* compiled from: SmoothScrollToTopTask.java */
    /* loaded from: classes3.dex */
    public class a extends DataSetObserver {
        public a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            T.this.h();
        }
    }

    /* compiled from: SmoothScrollToTopTask.java */
    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            T.this.h();
        }
    }

    public T(ListView listView, int i10, int i11) {
        this.f29098f = false;
        this.f29099g = 0;
        this.f29095c = listView;
        this.f29094b = i10;
        this.f29093a = i11;
        this.f29099g = 0;
        if (listView != null && listView.getAdapter() != null) {
            listView.getAdapter().registerDataSetObserver(this.f29100h);
            this.f29098f = true;
            f();
        }
    }

    public static void c() {
        T t10 = f29092i;
        if (t10 != null) {
            try {
                t10.i();
                f29092i.j();
            } catch (Exception unused) {
            }
            f29092i = null;
        }
    }

    public static void e(Activity activity, ListView listView) {
        if (C0846g.c()) {
            Log.d("SmoothScrollToTopTask", "com.color.clicktop...");
        }
        if (activity != null && !activity.hasWindowFocus()) {
            return;
        }
        if (f29092i == null) {
            f29092i = new T(listView, 10, 600);
        }
        f29092i.g();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b() {
        /*
            r7 = this;
            android.widget.ListView r0 = r7.f29095c
            r1 = 0
            android.view.View r0 = r0.getChildAt(r1)
            android.widget.ListView r2 = r7.f29095c
            int r2 = r2.getFirstVisiblePosition()
            r3 = r1
            r4 = r3
        Lf:
            if (r2 != 0) goto L12
            goto L33
        L12:
            int r5 = r7.d(r4)
            android.widget.ListView r6 = r7.f29095c
            int r6 = r6.getDividerHeight()
            int r5 = r5 + r6
            int r3 = r3 + r5
            int r4 = r4 + 1
            int r5 = r7.f29094b
            if (r5 != 0) goto L2f
            android.widget.ListView r5 = r7.f29095c
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
            int r0 = r7.f29094b
            if (r4 < r0) goto L4e
            if (r2 != r0) goto L4b
            android.widget.ListView r0 = r7.f29095c
            int r0 = r0.getPaddingTop()
        L48:
            int r0 = r0 + r3
            int r0 = r0 - r1
            goto L55
        L4b:
            int r0 = r3 - r1
            goto L55
        L4e:
            android.widget.ListView r0 = r7.f29095c
            int r0 = r0.getPaddingTop()
            goto L48
        L55:
            boolean r1 = com.oplus.utils.C0846g.c()
            if (r1 == 0) goto L71
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "distance="
            r1.append(r2)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "SmoothScrollToTopTask"
            android.util.Log.d(r2, r1)
        L71:
            r7.f29096d = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.utils.T.b():void");
    }

    public final int d(int i10) {
        if (this.f29095c.getAdapter().getCount() != 0 && this.f29095c.getAdapter().getCount() >= i10) {
            try {
                View view = this.f29095c.getAdapter().getView(i10, null, this.f29095c);
                if (view == null) {
                    return 0;
                }
                view.measure(View.MeasureSpec.makeMeasureSpec((this.f29095c.getWidth() - this.f29095c.getPaddingStart()) - this.f29095c.getPaddingEnd(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
                int measuredHeight = view.getMeasuredHeight();
                if (C0846g.c()) {
                    Log.d("SmoothScrollToTopTask", "itemHeight " + i10 + " = " + measuredHeight);
                }
                return measuredHeight;
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public void f() {
        ListView listView = this.f29095c;
        if (listView != null) {
            listView.setOnScrollListener(this);
        }
    }

    public void g() {
        ListView listView = this.f29095c;
        if (listView != null && listView.getScrollY() == 0) {
            if (this.f29097e) {
                Log.e("SmoothScrollToTopTask", "still running now");
                return;
            }
            this.f29097e = true;
            ListView listView2 = this.f29095c;
            if (listView2 != null && listView2.getAdapter() != null && this.f29095c.getAdapter().getCount() > 0) {
                View childAt = this.f29095c.getChildAt(0);
                if (childAt == null) {
                    Log.e("SmoothScrollToTopTask", "firstVisiView is null");
                    h();
                    return;
                }
                int firstVisiblePosition = this.f29095c.getFirstVisiblePosition();
                if (C0846g.c()) {
                    Log.d("SmoothScrollToTopTask", "firstVisiblePosition=" + firstVisiblePosition + " firstVisiViewTop=" + childAt.getTop() + " listPaddingTop=" + this.f29095c.getPaddingTop() + " dividerHeight=" + this.f29095c.getDividerHeight() + " listViewHeight=" + this.f29095c.getHeight());
                }
                if (firstVisiblePosition == 0 && childAt.getTop() == this.f29095c.getPaddingTop()) {
                    Log.e("SmoothScrollToTopTask", "already at top");
                    h();
                    return;
                } else {
                    b();
                    this.f29095c.postOnAnimation(this);
                    c();
                    return;
                }
            }
            Log.e("SmoothScrollToTopTask", "mListView is null");
            h();
            return;
        }
        Log.e("SmoothScrollToTopTask", "mListView is OVERSCROLL or OVERFLING");
    }

    public final void h() {
        this.f29097e = false;
        this.f29096d = 0;
        ListView listView = this.f29095c;
        if (listView != null && listView.getScrollY() == 0 && this.f29099g == 0) {
            try {
                this.f29095c.setSelection(0);
                this.f29095c.smoothScrollBy(0, 0);
            } catch (Exception e10) {
                Log.e("SmoothScrollToTopTask", " stop error" + e10);
            }
        }
    }

    public void i() {
        ListView listView = this.f29095c;
        if (listView != null && listView.getAdapter() != null && this.f29100h != null && this.f29098f) {
            try {
                this.f29095c.getAdapter().unregisterDataSetObserver(this.f29100h);
            } catch (Exception unused) {
            }
            this.f29098f = false;
        }
    }

    public void j() {
        ListView listView = this.f29095c;
        if (listView != null) {
            listView.setOnScrollListener(null);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i10) {
        this.f29099g = i10;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f29095c.smoothScrollBy(0, 0);
        int firstVisiblePosition = this.f29095c.getFirstVisiblePosition();
        int i10 = this.f29094b;
        if (firstVisiblePosition > i10) {
            this.f29095c.setSelectionFromTop(i10, 0);
            this.f29095c.postOnAnimation(this);
        } else {
            this.f29095c.smoothScrollBy(-this.f29096d, this.f29093a);
            this.f29095c.postDelayed(new b(), this.f29093a);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
    }
}
