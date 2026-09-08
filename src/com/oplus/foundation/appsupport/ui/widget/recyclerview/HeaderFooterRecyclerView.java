package com.oplus.foundation.appsupport.ui.widget.recyclerview;

import H7.b;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import x7.C1687d;

/* compiled from: HeaderFooterRecyclerView.kt */
/* loaded from: classes3.dex */
public class HeaderFooterRecyclerView extends DragSelectRecyclerView {

    /* renamed from: O, reason: collision with root package name */
    public static final a f28259O = new a(null);

    /* renamed from: N, reason: collision with root package name */
    public C1687d f28260N;

    /* compiled from: HeaderFooterRecyclerView.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeaderFooterRecyclerView(Context context) {
        super(context);
        i.f(context, "context");
        D();
    }

    public static /* synthetic */ void z(HeaderFooterRecyclerView headerFooterRecyclerView, View view, ViewGroup.LayoutParams layoutParams, int i10, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 2) != 0) {
                layoutParams = null;
            }
            if ((i11 & 4) != 0) {
                i10 = -1;
            }
            headerFooterRecyclerView.y(view, layoutParams, i10);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addHeaderView");
    }

    public final RecyclerView.LayoutParams A() {
        return new RecyclerView.LayoutParams(-1, -2);
    }

    public final void B() {
        C1687d c1687d = this.f28260N;
        if (c1687d == null) {
            i.q("headerFooterAdapter");
            c1687d = null;
        }
        c1687d.notifyDataSetChanged();
    }

    public final boolean C(View view, boolean z10) {
        i.f(view, "view");
        if (isComputingLayout()) {
            return false;
        }
        C1687d c1687d = this.f28260N;
        if (c1687d == null) {
            i.q("headerFooterAdapter");
            c1687d = null;
        }
        return c1687d.B(view, z10);
    }

    public final void D() {
        C1687d c1687d = new C1687d(super.getAdapter(), this);
        this.f28260N = c1687d;
        super.setAdapter(c1687d);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public RecyclerView.Adapter<RecyclerView.B> getAdapter() {
        C1687d c1687d = this.f28260N;
        if (c1687d == null) {
            i.q("headerFooterAdapter");
            c1687d = null;
        }
        return c1687d.n();
    }

    public final List<View> getFooterViews() {
        C1687d c1687d = this.f28260N;
        if (c1687d == null) {
            i.q("headerFooterAdapter");
            c1687d = null;
        }
        return c1687d.p();
    }

    public final int getFootersCount() {
        C1687d c1687d = this.f28260N;
        if (c1687d == null) {
            i.q("headerFooterAdapter");
            c1687d = null;
        }
        return c1687d.q();
    }

    public final List<View> getHeaderViews() {
        C1687d c1687d = this.f28260N;
        if (c1687d == null) {
            i.q("headerFooterAdapter");
            c1687d = null;
        }
        return c1687d.s();
    }

    public final int getHeadersCount() {
        C1687d c1687d = this.f28260N;
        if (c1687d == null) {
            i.q("headerFooterAdapter");
            c1687d = null;
        }
        return c1687d.t();
    }

    public final C1687d getWrapHeaderAdapter() {
        C1687d c1687d = this.f28260N;
        if (c1687d == null) {
            i.q("headerFooterAdapter");
            return null;
        }
        return c1687d;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter<RecyclerView.B> adapter) {
        C1687d c1687d = this.f28260N;
        if (c1687d == null) {
            i.q("headerFooterAdapter");
            c1687d = null;
        }
        c1687d.C(adapter);
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView, androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(RecyclerView.o oVar) {
        if ((oVar instanceof GridLayoutManager) && !(oVar instanceof HeaderFooterGridLayoutManager)) {
            Context context = getContext();
            i.e(context, "context");
            int o10 = ((GridLayoutManager) oVar).o();
            C1687d c1687d = this.f28260N;
            if (c1687d == null) {
                i.q("headerFooterAdapter");
                c1687d = null;
            }
            super.setLayoutManager(new HeaderFooterGridLayoutManager(context, o10, c1687d));
            return;
        }
        super.setLayoutManager(oVar);
    }

    public final void x(View view) {
        i.f(view, "view");
        z(this, view, null, 0, 6, null);
    }

    public final void y(View view, ViewGroup.LayoutParams layoutParams, int i10) {
        LinearLayoutManager linearLayoutManager;
        boolean z10;
        i.f(view, "view");
        if (isComputingLayout()) {
            b.i("HeaderFooterRecyclerView", "addHeaderView, isComputingLayout");
            return;
        }
        if (view.getParent() != null) {
            b.i("HeaderFooterRecyclerView", "addHeaderView, the " + view + " has a parent. You must call removeView() on the child's parent first.");
            return;
        }
        if (view.getLayoutParams() == null && layoutParams == null) {
            view.setLayoutParams(A());
        }
        RecyclerView.o layoutManager = getLayoutManager();
        C1687d c1687d = null;
        if (layoutManager instanceof LinearLayoutManager) {
            linearLayoutManager = (LinearLayoutManager) layoutManager;
        } else {
            linearLayoutManager = null;
        }
        if (linearLayoutManager != null && linearLayoutManager.findFirstCompletelyVisibleItemPosition() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        C1687d c1687d2 = this.f28260N;
        if (c1687d2 == null) {
            i.q("headerFooterAdapter");
        } else {
            c1687d = c1687d2;
        }
        c1687d.m(view, i10);
        if (z10) {
            smoothScrollToPosition(0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeaderFooterRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        i.f(context, "context");
        D();
    }
}
