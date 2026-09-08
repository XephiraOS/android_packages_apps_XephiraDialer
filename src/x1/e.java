package x1;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ImapList.java */
/* loaded from: classes.dex */
public class e extends AbstractC1675d {

    /* renamed from: d, reason: collision with root package name */
    public static final e f37833d = new a();

    /* renamed from: c, reason: collision with root package name */
    public ArrayList<AbstractC1675d> f37834c = new ArrayList<>();

    @Override // x1.AbstractC1675d
    public void b() {
        ArrayList<AbstractC1675d> arrayList = this.f37834c;
        if (arrayList != null) {
            Iterator<AbstractC1675d> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
            this.f37834c = null;
        }
        super.b();
    }

    @Override // x1.AbstractC1675d
    public final boolean d() {
        return true;
    }

    @Override // x1.AbstractC1675d
    public final boolean e() {
        return false;
    }

    public void f(AbstractC1675d abstractC1675d) {
        if (abstractC1675d != null) {
            this.f37834c.add(abstractC1675d);
            return;
        }
        throw new RuntimeException("Can't add null");
    }

    public final AbstractC1675d g(int i10) {
        if (i10 >= this.f37834c.size()) {
            return AbstractC1675d.f37831b;
        }
        return this.f37834c.get(i10);
    }

    public final AbstractC1675d h(String str, boolean z10) {
        for (int i10 = 1; i10 < r(); i10 += 2) {
            if (p(i10 - 1, str, z10)) {
                return this.f37834c.get(i10);
            }
        }
        return null;
    }

    public final e i(String str) {
        return j(str, false);
    }

    public final e j(String str, boolean z10) {
        AbstractC1675d h10 = h(str, z10);
        if (h10 != null) {
            return (e) h10;
        }
        return f37833d;
    }

    public final i k(String str) {
        return l(str, false);
    }

    public final i l(String str, boolean z10) {
        AbstractC1675d h10 = h(str, z10);
        if (h10 != null) {
            return (i) h10;
        }
        return i.f37842g;
    }

    public final e m(int i10) {
        AbstractC1675d g10 = g(i10);
        if (g10.d()) {
            return (e) g10;
        }
        return f37833d;
    }

    public final i n(int i10) {
        AbstractC1675d g10 = g(i10);
        if (g10.e()) {
            return (i) g10;
        }
        return i.f37842g;
    }

    public final boolean o(int i10, String str) {
        return p(i10, str, false);
    }

    public final boolean p(int i10, String str, boolean z10) {
        if (!z10) {
            return n(i10).l(str);
        }
        return n(i10).p(str);
    }

    public final boolean q() {
        if (r() == 0) {
            return true;
        }
        return false;
    }

    public final int r() {
        return this.f37834c.size();
    }

    public String toString() {
        return this.f37834c.toString();
    }

    /* compiled from: ImapList.java */
    /* loaded from: classes.dex */
    public class a extends e {
        @Override // x1.e
        public void f(AbstractC1675d abstractC1675d) {
            throw new RuntimeException();
        }

        @Override // x1.e, x1.AbstractC1675d
        public void b() {
        }
    }
}
