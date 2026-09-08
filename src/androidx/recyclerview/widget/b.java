package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

/* compiled from: AdapterListUpdateCallback.java */
/* loaded from: classes.dex */
public final class b implements q {

    /* renamed from: a, reason: collision with root package name */
    public final RecyclerView.Adapter f11011a;

    public b(RecyclerView.Adapter adapter) {
        this.f11011a = adapter;
    }

    @Override // androidx.recyclerview.widget.q
    public void a(int i10, int i11) {
        this.f11011a.notifyItemMoved(i10, i11);
    }

    @Override // androidx.recyclerview.widget.q
    public void b(int i10, int i11) {
        this.f11011a.notifyItemRangeInserted(i10, i11);
    }

    @Override // androidx.recyclerview.widget.q
    public void c(int i10, int i11) {
        this.f11011a.notifyItemRangeRemoved(i10, i11);
    }

    @Override // androidx.recyclerview.widget.q
    public void d(int i10, int i11, Object obj) {
        this.f11011a.notifyItemRangeChanged(i10, i11, obj);
    }
}
