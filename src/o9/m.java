package O9;

import S9.s;

/* compiled from: DefaultFieldParser.java */
/* loaded from: classes4.dex */
public class m extends n {

    /* renamed from: c, reason: collision with root package name */
    public static final L9.a<N9.o> f2770c = new m();

    public m() {
        super(r.f2781d);
        c("Content-Type", k.f2760h);
        c("Content-Length", g.f2752d);
        c("Content-Transfer-Encoding", j.f2758d);
        c("Content-Disposition", d.f2744f);
        c("Content-ID", e.f2748d);
        c("Content-MD5", i.f2756d);
        c("Content-Description", c.f2742d);
        c("Content-Language", f.f2750d);
        c("Content-Location", h.f2754d);
        c("MIME-Version", q.f2777f);
        L9.a<N9.k> aVar = l.f2766f;
        c("Date", aVar);
        c("Resent-Date", aVar);
        L9.a<N9.m> aVar2 = p.f2775d;
        c("From", aVar2);
        c("Resent-From", aVar2);
        L9.a<N9.l> aVar3 = o.f2773d;
        c("Sender", aVar3);
        c("Resent-Sender", aVar3);
        L9.a<N9.a> aVar4 = b.f2740d;
        c("To", aVar4);
        c("Resent-To", aVar4);
        c("Cc", aVar4);
        c("Resent-Cc", aVar4);
        c("Bcc", aVar4);
        c("Resent-Bcc", aVar4);
        c("Reply-To", aVar4);
    }

    public static N9.o d(String str) {
        return e(str, K9.c.f1690b);
    }

    public static N9.o e(String str, K9.c cVar) {
        return f2770c.a(s.f3684d.d(T9.d.c(str)), cVar);
    }
}
