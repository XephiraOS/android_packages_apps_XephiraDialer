package com.android.contacts.voicemail.impl.mail.store;

import android.util.ArraySet;
import android.util.Base64;
import com.android.contacts.voicemail.impl.OmtpEvents;
import com.android.contacts.voicemail.impl.mail.CertificateValidationException;
import com.android.contacts.voicemail.impl.mail.MessagingException;
import com.android.contacts.voicemail.impl.mail.e;
import com.android.contacts.voicemail.impl.mail.store.ImapStore;
import com.android.contacts.voicemail.impl.mail.store.imap.ImapResponseParser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.SSLException;
import x1.C1673b;
import x1.g;
import x1.k;

/* compiled from: ImapConnection.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    public String f18111b;

    /* renamed from: c, reason: collision with root package name */
    public ImapStore f18112c;

    /* renamed from: d, reason: collision with root package name */
    public e f18113d;

    /* renamed from: e, reason: collision with root package name */
    public ImapResponseParser f18114e;

    /* renamed from: a, reason: collision with root package name */
    public final String f18110a = "ImapConnection";

    /* renamed from: f, reason: collision with root package name */
    public Set<String> f18115f = new ArraySet();

    /* renamed from: g, reason: collision with root package name */
    public final AtomicInteger f18116g = new AtomicInteger(0);

    public a(ImapStore imapStore) {
        t(imapStore);
    }

    public static String c(String str) {
        return new String(Base64.decode(str, 0));
    }

    public static String g(String str) {
        return Base64.encodeToString(str.getBytes(), 2);
    }

    public void a() {
        if (this.f18113d != null) {
            n();
            this.f18113d.d();
            this.f18113d = null;
        }
        d();
        this.f18114e = null;
        this.f18112c = null;
    }

    public final void b() {
        d();
        this.f18114e = new ImapResponseParser(this.f18113d.g());
    }

    public void d() {
        ImapResponseParser imapResponseParser = this.f18114e;
        if (imapResponseParser != null) {
            imapResponseParser.a();
        }
    }

    public final void e() {
        C1673b.a aVar = new C1673b.a(this.f18112c, this.f18113d, C1673b.d(c(i("AUTHENTICATE DIGEST-MD5").get(0).n(0).k())));
        aVar.c(c(h(g(aVar.b()), true).get(0).n(0).k()));
        h("", false);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x009b, code lost:
    
        if (r3.equals("unknown user") == false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f() {
        /*
            Method dump skipped, instructions count: 356
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.voicemail.impl.mail.store.a.f():void");
    }

    public List<g> h(String str, boolean z10) {
        String str2;
        e eVar = this.f18113d;
        if (z10) {
            str2 = "[IMAP command redacted]";
        } else {
            str2 = str;
        }
        eVar.m(str, str2);
        return k();
    }

    public List<g> i(String str) {
        return j(str, false);
    }

    public List<g> j(String str, boolean z10) {
        s(str, z10);
        return k();
    }

    public List<g> k() {
        g m10;
        ArrayList arrayList = new ArrayList();
        do {
            m10 = this.f18114e.m(false);
            arrayList.add(m10);
            if (m10.B()) {
                break;
            }
        } while (!m10.w());
        if (!m10.y() && !m10.w()) {
            String gVar = m10.toString();
            String k10 = m10.u().k();
            String k11 = m10.v().k();
            String k12 = m10.s().k();
            String k13 = m10.t().k();
            d();
            throw new ImapStore.ImapException(gVar, k10, k11, k12, k13);
        }
        return arrayList;
    }

    public String l() {
        if (this.f18111b == null && this.f18112c.g() != null && this.f18112c.f() != null) {
            this.f18111b = "LOGIN " + this.f18112c.g() + " " + k.a(this.f18112c.f());
        }
        return this.f18111b;
    }

    public final boolean m(String str) {
        return this.f18115f.contains(str);
    }

    public void n() {
        try {
            s("LOGOUT", false);
            if (!this.f18114e.m(true).o(0, "BYE")) {
                H7.b.c("ImapConnection", "Server did not respond LOGOUT with BYE");
            }
            if (!this.f18114e.m(false).y()) {
                H7.b.c("ImapConnection", "Server did not respond OK after LOGOUT");
            }
        } catch (MessagingException | IOException e10) {
            H7.b.c("ImapConnection", "Error while logging out:" + e10);
        }
    }

    public final void o() {
        if (m("STARTTLS")) {
            i("STARTTLS");
            this.f18113d.k();
            b();
            q();
        }
    }

    public void p() {
        e eVar = this.f18113d;
        if (eVar != null && eVar.i()) {
            return;
        }
        try {
            try {
                try {
                    if (this.f18113d == null) {
                        this.f18113d = this.f18112c.a();
                    }
                    this.f18113d.j();
                    b();
                    if (this.f18114e.m(false).y()) {
                        q();
                        o();
                        f();
                        d();
                        return;
                    }
                    this.f18112c.e().U(OmtpEvents.DATA_INVALID_INITIAL_SERVER_RESPONSE);
                    throw new MessagingException(13, "Invalid server initial response");
                } catch (IOException e10) {
                    C1.a.a("ImapConnection", "open IOException " + e10);
                    this.f18112c.e().U(OmtpEvents.DATA_IOE_ON_OPEN);
                    throw e10;
                }
            } catch (SSLException e11) {
                C1.a.a("ImapConnection", "open SSLException " + e11);
                this.f18112c.e().U(OmtpEvents.DATA_SSL_EXCEPTION);
                throw new CertificateValidationException(e11.getMessage() + e11);
            }
        } catch (Throwable th) {
            d();
            throw th;
        }
    }

    public final void q() {
        List<g> i10 = i("CAPABILITY");
        this.f18115f.clear();
        Set<String> i11 = this.f18112c.e().I().i();
        for (g gVar : i10) {
            if (!gVar.B()) {
                for (int i12 = 0; i12 < gVar.r(); i12++) {
                    String k10 = gVar.n(i12).k();
                    if (i11 != null) {
                        if (!i11.contains(k10)) {
                            this.f18115f.add(k10);
                        }
                    } else {
                        this.f18115f.add(k10);
                    }
                }
            }
        }
        C1.a.a("ImapConnection", "Capabilities: " + this.f18115f.toString());
    }

    public g r() {
        return this.f18114e.m(false);
    }

    public String s(String str, boolean z10) {
        p();
        if (this.f18113d != null) {
            String num = Integer.toString(this.f18116g.incrementAndGet());
            String str2 = num + " " + str;
            e eVar = this.f18113d;
            if (z10) {
                str = "[IMAP command redacted]";
            }
            eVar.m(str2, str);
            return num;
        }
        throw new IOException("Null transport");
    }

    public void t(ImapStore imapStore) {
        this.f18112c = imapStore;
        this.f18111b = null;
    }
}
