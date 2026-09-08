package androidx.viewpager2.widget;

import androidx.recyclerview.widget.RecyclerView;

/* compiled from: FakeDrag.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final ViewPager2 f11863a;

    /* renamed from: b, reason: collision with root package name */
    public final e f11864b;

    /* renamed from: c, reason: collision with root package name */
    public final RecyclerView f11865c;

    public c(ViewPager2 viewPager2, e eVar, RecyclerView recyclerView) {
        this.f11863a = viewPager2;
        this.f11864b = eVar;
        this.f11865c = recyclerView;
    }

    public boolean a() {
        return this.f11864b.isFakeDragging();
    }
}
