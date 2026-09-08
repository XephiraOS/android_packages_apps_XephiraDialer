package c4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: BaseSpringSystem.java */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: c, reason: collision with root package name */
    public final k f12751c;

    /* renamed from: a, reason: collision with root package name */
    public final Map<String, g> f12749a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final Set<g> f12750b = new CopyOnWriteArraySet();

    /* renamed from: d, reason: collision with root package name */
    public final CopyOnWriteArraySet<m> f12752d = new CopyOnWriteArraySet<>();

    /* renamed from: e, reason: collision with root package name */
    public boolean f12753e = true;

    public b(k kVar) {
        if (kVar != null) {
            this.f12751c = kVar;
            kVar.a(this);
            return;
        }
        throw new IllegalArgumentException("springLooper is required");
    }

    public void a(String str) {
        g gVar = this.f12749a.get(str);
        if (gVar != null) {
            this.f12750b.add(gVar);
            if (e()) {
                this.f12753e = false;
                this.f12751c.b();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("springId " + str + " does not reference a registered spring");
    }

    public void b(double d10) {
        for (g gVar : this.f12750b) {
            if (gVar.s()) {
                gVar.b(d10 / 1000.0d);
            } else {
                this.f12750b.remove(gVar);
            }
        }
    }

    public g c() {
        g gVar = new g(this);
        g(gVar);
        return gVar;
    }

    public List<g> d() {
        List arrayList;
        Collection<g> values = this.f12749a.values();
        if (values instanceof List) {
            arrayList = (List) values;
        } else {
            arrayList = new ArrayList(values);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public boolean e() {
        return this.f12753e;
    }

    public void f(double d10) {
        Iterator<m> it = this.f12752d.iterator();
        while (it.hasNext()) {
            it.next().b(this);
        }
        b(d10);
        if (this.f12750b.isEmpty()) {
            this.f12753e = true;
        }
        Iterator<m> it2 = this.f12752d.iterator();
        while (it2.hasNext()) {
            it2.next().a(this);
        }
        if (this.f12753e) {
            this.f12751c.c();
        }
    }

    public void g(g gVar) {
        if (gVar != null) {
            if (!this.f12749a.containsKey(gVar.f())) {
                this.f12749a.put(gVar.f(), gVar);
                return;
            }
            throw new IllegalArgumentException("spring is already registered");
        }
        throw new IllegalArgumentException("spring is required");
    }
}
