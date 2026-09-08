package com.android.contacts.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.android.contacts.widget.PinnedHeaderListView;

/* compiled from: PinnedHeaderListAdapter.java */
/* loaded from: classes.dex */
public abstract class a extends com.android.contacts.framework.baseui.widget.a implements PinnedHeaderListView.b {

    /* renamed from: g, reason: collision with root package name */
    public boolean f18250g;

    /* renamed from: h, reason: collision with root package name */
    public boolean[] f18251h;

    public a(Context context) {
        super(context);
    }

    public boolean E(int i10) {
        if (this.f18250g && v(i10) && !y(i10)) {
            return true;
        }
        return false;
    }

    public void F(boolean z10) {
        this.f18250g = z10;
    }

    public void a(PinnedHeaderListView pinnedHeaderListView) {
        int s10;
        boolean z10;
        if (!this.f18250g) {
            return;
        }
        int r10 = r();
        boolean[] zArr = this.f18251h;
        if (zArr == null || zArr.length != r10) {
            this.f18251h = new boolean[r10];
        }
        for (int i10 = 0; i10 < r10; i10++) {
            boolean E10 = E(i10);
            this.f18251h[i10] = E10;
            if (!E10) {
                pinnedHeaderListView.k(i10, true);
            }
        }
        int headerViewsCount = pinnedHeaderListView.getHeaderViewsCount();
        int i11 = 0;
        int i12 = -1;
        for (int i13 = 0; i13 < r10; i13++) {
            if (this.f18251h[i13]) {
                if (i13 > s(pinnedHeaderListView.f(i11) - headerViewsCount)) {
                    break;
                }
                pinnedHeaderListView.m(i13, i11, false);
                i11 += pinnedHeaderListView.e(i13);
                i12 = i13;
            }
        }
        int height = pinnedHeaderListView.getHeight();
        int i14 = r10;
        int i15 = 0;
        while (true) {
            r10--;
            if (r10 <= i12) {
                break;
            }
            if (this.f18251h[r10]) {
                int f10 = pinnedHeaderListView.f(height - i15) - headerViewsCount;
                if (f10 < 0 || (s10 = s(f10 - 1)) == -1 || r10 <= s10) {
                    break;
                }
                i15 += pinnedHeaderListView.e(r10);
                if (f10 < t(r10)) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                pinnedHeaderListView.l(r10, height - i15, z10);
                i14 = r10;
            }
        }
        for (int i16 = i12 + 1; i16 < i14; i16++) {
            if (this.f18251h[i16]) {
                pinnedHeaderListView.k(i16, y(i16));
            }
        }
    }

    public int b() {
        if (this.f18250g) {
            return r();
        }
        return 0;
    }

    public View c(int i10, View view, ViewGroup viewGroup) {
        Integer num;
        if (!v(i10)) {
            return null;
        }
        if (view == null || (num = (Integer) view.getTag()) == null || num.intValue() != 0) {
            view = null;
        }
        if (view == null) {
            view = z(k(), i10, null, viewGroup);
            view.setTag(0);
            view.setFocusable(false);
            view.setEnabled(false);
        }
        f(view, i10, l(i10));
        return view;
    }

    @Override // com.android.contacts.widget.PinnedHeaderListView.b
    public int d(int i10) {
        return t(i10);
    }
}
