package p7;

import android.util.Log;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.o;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.m;
import kotlinx.coroutines.flow.n;

/* compiled from: SelectManager.kt */
/* renamed from: p7.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1462c<E> {

    /* renamed from: a, reason: collision with root package name */
    public final CoroutineDispatcher f36090a;

    /* renamed from: b, reason: collision with root package name */
    public final i<C1463d<E>> f36091b;

    /* renamed from: c, reason: collision with root package name */
    public final m<C1463d<E>> f36092c;

    /* renamed from: d, reason: collision with root package name */
    public final Set<E> f36093d;

    /* renamed from: e, reason: collision with root package name */
    public final Set<E> f36094e;

    /* renamed from: f, reason: collision with root package name */
    public List<? extends E> f36095f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f36096g;

    public C1462c(CoroutineDispatcher workerDispatcher) {
        List h10;
        List<? extends E> h11;
        kotlin.jvm.internal.i.f(workerDispatcher, "workerDispatcher");
        this.f36090a = workerDispatcher;
        h10 = o.h();
        i<C1463d<E>> a10 = n.a(new C1463d(h10, false, null, null, null, 30, null));
        this.f36091b = a10;
        this.f36092c = a10;
        this.f36093d = new LinkedHashSet();
        this.f36094e = new LinkedHashSet();
        h11 = o.h();
        this.f36095f = h11;
    }

    public final boolean a() {
        return this.f36096g;
    }

    public final Set<E> b() {
        return this.f36093d;
    }

    public final Set<E> c() {
        return this.f36094e;
    }

    public void d(boolean z10) {
        this.f36093d.clear();
        this.f36094e.clear();
        this.f36096g = z10;
        e();
    }

    public void e() {
        throw null;
    }

    public void f() {
        Log.i("SelectManager", "resetSelectManager");
        this.f36096g = false;
        this.f36094e.clear();
        this.f36093d.clear();
        e();
    }
}
