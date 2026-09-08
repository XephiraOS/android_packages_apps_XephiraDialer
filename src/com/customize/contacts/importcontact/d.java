package com.customize.contacts.importcontact;

import android.content.Context;
import android.text.TextUtils;
import com.android.contacts.model.Account;
import com.customize.contacts.manager.C0786a;
import com.customize.contacts.util.D;
import java.util.Iterator;
import java.util.List;

/* compiled from: ContactImporter.java */
/* loaded from: classes3.dex */
public class d implements a, Runnable {

    /* renamed from: a, reason: collision with root package name */
    public int f21417a;

    /* renamed from: b, reason: collision with root package name */
    public final List<String> f21418b;

    /* renamed from: c, reason: collision with root package name */
    public final Account f21419c;

    /* renamed from: d, reason: collision with root package name */
    public final Context f21420d;

    /* renamed from: e, reason: collision with root package name */
    public final g f21421e;

    /* renamed from: g, reason: collision with root package name */
    public boolean f21423g;

    /* renamed from: j, reason: collision with root package name */
    public c f21426j;

    /* renamed from: k, reason: collision with root package name */
    public l f21427k;

    /* renamed from: h, reason: collision with root package name */
    public boolean f21424h = false;

    /* renamed from: f, reason: collision with root package name */
    public boolean f21422f = false;

    /* renamed from: i, reason: collision with root package name */
    public boolean f21425i = false;

    public d(Context context, List<String> list, Account account, g gVar, int i10, boolean z10) {
        this.f21420d = context;
        this.f21421e = gVar;
        this.f21419c = account;
        this.f21418b = list;
        this.f21417a = i10;
        this.f21423g = z10;
    }

    @Override // com.customize.contacts.importcontact.p
    public void a(String str, int i10) {
        this.f21421e.l(str, i10);
        if (this.f21427k != null) {
            this.f21427k.a(str, this.f21421e.b());
        }
    }

    @Override // com.customize.contacts.importcontact.a
    public void b(int i10) {
        this.f21421e.j(i10);
        l lVar = this.f21427k;
        if (lVar != null) {
            lVar.b(i10);
        }
    }

    @Override // com.customize.contacts.importcontact.p
    public void c(int i10) {
        this.f21421e.k(i10);
    }

    public void d() {
        this.f21422f = true;
        j();
        c cVar = this.f21426j;
        if (cVar != null) {
            cVar.d();
        }
    }

    public String e() {
        return "ContactImporter";
    }

    public final boolean f(int i10) {
        if (7 != i10 && 11 != i10 && 9 != i10 && 8 != i10 && 7 != i10) {
            return false;
        }
        return true;
    }

    public void g(String str, int i10) {
        this.f21421e.i(i10);
    }

    public int h(String str) {
        int a10 = D.a(this.f21420d, str);
        if (888 != a10) {
            H7.b.b("ContactImporter", "onReadContactFile fileStatue:" + a10 + " and file not available");
            return a10;
        }
        String f10 = D.f(this.f21420d, str);
        int h10 = D.h(this.f21420d, f10);
        if (-1 == h10) {
            h10 = this.f21417a;
        }
        if (-1 == h10) {
            return 0;
        }
        boolean z10 = this.f21423g;
        if (!z10) {
            this.f21426j = b.a(this.f21420d, f10, this.f21419c, h10);
        } else {
            this.f21426j = b.b(this.f21420d, f10, this.f21419c, h10, z10);
        }
        c cVar = this.f21426j;
        if (cVar == null) {
            return 0;
        }
        cVar.h(this);
        this.f21426j.g(this.f21424h);
        return this.f21426j.f();
    }

    public final void i() {
        this.f21421e.g();
        if (this.f21427k != null) {
            this.f21427k.f(this.f21421e.d());
        }
    }

    public final void j() {
        this.f21421e.e();
        l lVar = this.f21427k;
        if (lVar != null) {
            lVar.d();
        }
    }

    public final void k() {
        if (this.f21427k != null) {
            this.f21427k.c(this.f21421e.d());
        }
        this.f21421e.h();
    }

    public final void l() {
        if (this.f21427k != null) {
            int d10 = this.f21421e.d();
            this.f21427k.e(this.f21421e.f(), d10);
        }
        this.f21421e.h();
    }

    public final void m() {
        g gVar = this.f21421e;
        if (gVar != null) {
            gVar.m();
        }
        l lVar = this.f21427k;
        if (lVar != null) {
            lVar.onStart();
        }
    }

    public void n(k kVar) {
        if (this.f21427k == null) {
            this.f21427k = new l();
        }
        this.f21427k.h(kVar);
    }

    public void o(boolean z10) {
        this.f21424h = z10;
        c cVar = this.f21426j;
        if (cVar != null) {
            cVar.g(z10);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            C0786a.j().f();
            List<String> list = this.f21418b;
            if (list != null && !list.isEmpty()) {
                m();
                Iterator<String> it = this.f21418b.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String next = it.next();
                    if (H7.a.b()) {
                        H7.b.b("ContactImporter", "import: fileName = " + next);
                    }
                    if (!this.f21422f && !this.f21425i) {
                        if (!TextUtils.isEmpty(next)) {
                            int h10 = h(next);
                            if (H7.a.b()) {
                                H7.b.b("ContactImporter", "import fileName = " + next + " result : " + h10);
                            }
                            if (f(h10)) {
                                if (H7.a.b()) {
                                    H7.b.b("ContactImporter", "import fileName = " + next + " fatal error happen!");
                                }
                                this.f21425i = true;
                                g(next, h10);
                            }
                        }
                    }
                }
                if (this.f21422f) {
                    i();
                } else if (this.f21425i) {
                    l();
                } else {
                    k();
                }
                C0786a.j().e();
                l lVar = this.f21427k;
                if (lVar != null) {
                    lVar.g();
                    return;
                }
                return;
            }
            i();
            l lVar2 = this.f21427k;
            if (lVar2 != null) {
                lVar2.g();
            }
            C0786a.j().e();
        } catch (Throwable th) {
            C0786a.j().e();
            throw th;
        }
    }
}
