package androidx.lifecycle;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: ViewModelStore.kt */
/* loaded from: classes.dex */
public class M {

    /* renamed from: a, reason: collision with root package name */
    public final Map<String, I> f10311a = new LinkedHashMap();

    public final void a() {
        Iterator<I> it = this.f10311a.values().iterator();
        while (it.hasNext()) {
            it.next().b();
        }
        this.f10311a.clear();
    }

    public final I b(String key) {
        kotlin.jvm.internal.i.f(key, "key");
        return this.f10311a.get(key);
    }

    public final Set<String> c() {
        return new HashSet(this.f10311a.keySet());
    }

    public final void d(String key, I viewModel) {
        kotlin.jvm.internal.i.f(key, "key");
        kotlin.jvm.internal.i.f(viewModel, "viewModel");
        I put = this.f10311a.put(key, viewModel);
        if (put != null) {
            put.e();
        }
    }
}
