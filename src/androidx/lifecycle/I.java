package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: ViewModel.java */
/* loaded from: classes.dex */
public abstract class I {

    /* renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f10260a;

    /* renamed from: b, reason: collision with root package name */
    public final Set<Closeable> f10261b;

    /* renamed from: c, reason: collision with root package name */
    public volatile boolean f10262c;

    public I() {
        this.f10260a = new HashMap();
        this.f10261b = new LinkedHashSet();
        this.f10262c = false;
    }

    public static void c(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e10) {
                throw new RuntimeException(e10);
            }
        }
    }

    public final void b() {
        this.f10262c = true;
        Map<String, Object> map = this.f10260a;
        if (map != null) {
            synchronized (map) {
                try {
                    Iterator<Object> it = this.f10260a.values().iterator();
                    while (it.hasNext()) {
                        c(it.next());
                    }
                } finally {
                }
            }
        }
        Set<Closeable> set = this.f10261b;
        if (set != null) {
            synchronized (set) {
                try {
                    Iterator<Closeable> it2 = this.f10261b.iterator();
                    while (it2.hasNext()) {
                        c(it2.next());
                    }
                } finally {
                }
            }
        }
        e();
    }

    public <T> T d(String str) {
        T t10;
        Map<String, Object> map = this.f10260a;
        if (map == null) {
            return null;
        }
        synchronized (map) {
            t10 = (T) this.f10260a.get(str);
        }
        return t10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T f(String str, T t10) {
        Object obj;
        synchronized (this.f10260a) {
            try {
                obj = this.f10260a.get(str);
                if (obj == 0) {
                    this.f10260a.put(str, t10);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (obj != 0) {
            t10 = obj;
        }
        if (this.f10262c) {
            c(t10);
        }
        return t10;
    }

    public I(Closeable... closeableArr) {
        this.f10260a = new HashMap();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.f10261b = linkedHashSet;
        this.f10262c = false;
        linkedHashSet.addAll(Arrays.asList(closeableArr));
    }

    public void e() {
    }
}
