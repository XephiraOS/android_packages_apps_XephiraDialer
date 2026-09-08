package com.bumptech.glide.manager;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import com.bumptech.glide.manager.n;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import s3.C1541l;

/* compiled from: LifecycleRequestManagerRetriever.java */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final Map<Lifecycle, com.bumptech.glide.i> f19699a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final n.b f19700b;

    /* compiled from: LifecycleRequestManagerRetriever.java */
    /* loaded from: classes.dex */
    public final class b implements o {

        /* renamed from: a, reason: collision with root package name */
        public final FragmentManager f19703a;

        public b(FragmentManager fragmentManager) {
            this.f19703a = fragmentManager;
        }

        @Override // com.bumptech.glide.manager.o
        public Set<com.bumptech.glide.i> a() {
            HashSet hashSet = new HashSet();
            b(this.f19703a, hashSet);
            return hashSet;
        }

        public final void b(FragmentManager fragmentManager, Set<com.bumptech.glide.i> set) {
            List<Fragment> y02 = fragmentManager.y0();
            int size = y02.size();
            for (int i10 = 0; i10 < size; i10++) {
                Fragment fragment = y02.get(i10);
                b(fragment.getChildFragmentManager(), set);
                com.bumptech.glide.i a10 = l.this.a(fragment.getLifecycle());
                if (a10 != null) {
                    set.add(a10);
                }
            }
        }
    }

    public l(n.b bVar) {
        this.f19700b = bVar;
    }

    public com.bumptech.glide.i a(Lifecycle lifecycle) {
        C1541l.a();
        return this.f19699a.get(lifecycle);
    }

    public com.bumptech.glide.i b(Context context, com.bumptech.glide.b bVar, Lifecycle lifecycle, FragmentManager fragmentManager, boolean z10) {
        C1541l.a();
        com.bumptech.glide.i a10 = a(lifecycle);
        if (a10 == null) {
            LifecycleLifecycle lifecycleLifecycle = new LifecycleLifecycle(lifecycle);
            com.bumptech.glide.i a11 = this.f19700b.a(bVar, lifecycleLifecycle, new b(fragmentManager), context);
            this.f19699a.put(lifecycle, a11);
            lifecycleLifecycle.a(new a(lifecycle));
            if (z10) {
                a11.onStart();
            }
            return a11;
        }
        return a10;
    }

    /* compiled from: LifecycleRequestManagerRetriever.java */
    /* loaded from: classes.dex */
    public class a implements k {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Lifecycle f19701a;

        public a(Lifecycle lifecycle) {
            this.f19701a = lifecycle;
        }

        @Override // com.bumptech.glide.manager.k
        public void b() {
            l.this.f19699a.remove(this.f19701a);
        }

        @Override // com.bumptech.glide.manager.k
        public void e() {
        }

        @Override // com.bumptech.glide.manager.k
        public void onStart() {
        }
    }
}
