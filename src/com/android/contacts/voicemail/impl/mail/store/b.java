package com.android.contacts.voicemail.impl.mail.store;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64DataException;
import com.android.contacts.voicemail.impl.OmtpEvents;
import com.android.contacts.voicemail.impl.mail.AuthenticationFailedException;
import com.android.contacts.voicemail.impl.mail.FetchProfile;
import com.android.contacts.voicemail.impl.mail.MessagingException;
import com.android.contacts.voicemail.impl.mail.f;
import com.android.contacts.voicemail.impl.mail.h;
import com.android.contacts.voicemail.impl.mail.store.ImapStore;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import w1.C1644a;
import w1.C1645b;
import x1.AbstractC1675d;
import x1.e;
import x1.g;
import x1.i;
import y1.C1701a;

/* compiled from: ImapFolder.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: g, reason: collision with root package name */
    public static final String[] f18117g = {"deleted", "seen", "flagged", "answered"};

    /* renamed from: a, reason: collision with root package name */
    public final ImapStore f18118a;

    /* renamed from: b, reason: collision with root package name */
    public final String f18119b;

    /* renamed from: c, reason: collision with root package name */
    public int f18120c = -1;

    /* renamed from: d, reason: collision with root package name */
    public com.android.contacts.voicemail.impl.mail.store.a f18121d;

    /* renamed from: e, reason: collision with root package name */
    public String f18122e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f18123f;

    /* compiled from: ImapFolder.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(f fVar);
    }

    /* compiled from: ImapFolder.java */
    /* renamed from: com.android.contacts.voicemail.impl.mail.store.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0177b {

        /* renamed from: a, reason: collision with root package name */
        public final int f18124a;

        /* renamed from: b, reason: collision with root package name */
        public final int f18125b;

        public C0177b(int i10, int i11) {
            this.f18124a = i10;
            this.f18125b = i11;
        }
    }

    public b(ImapStore imapStore, String str) {
        this.f18118a = imapStore;
        this.f18119b = str;
    }

    public static com.android.contacts.voicemail.impl.mail.a c(Context context, InputStream inputStream, String str, int i10, a aVar) {
        InputStream d10 = w1.f.d(inputStream, str);
        C1644a c1644a = new C1644a();
        OutputStream c10 = c1644a.c();
        try {
            try {
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = d10.read(bArr);
                    if (-1 == read) {
                        break;
                    }
                    c10.write(bArr, 0, read);
                }
            } catch (Base64DataException unused) {
                c10.write("\n\nThere was an error while decoding the message.".getBytes());
            }
            return c1644a;
        } finally {
            c10.close();
        }
    }

    public static void s(e eVar, h hVar, String str) {
        e m10;
        int i10 = 0;
        if (eVar.g(0).d()) {
            w1.e eVar2 = new w1.e();
            int r10 = eVar.r();
            while (true) {
                if (i10 >= r10) {
                    break;
                }
                AbstractC1675d g10 = eVar.g(i10);
                if (g10.d()) {
                    C1645b c1645b = new C1645b();
                    if (str.equals("TEXT")) {
                        s(eVar.m(i10), c1645b, Integer.toString(i10 + 1));
                    } else {
                        s(eVar.m(i10), c1645b, str + "." + (i10 + 1));
                    }
                    eVar2.a(c1645b);
                    i10++;
                } else if (g10.e()) {
                    eVar2.h(eVar.n(i10).k().toLowerCase(Locale.US));
                }
            }
            hVar.d(eVar2);
            return;
        }
        i n10 = eVar.n(0);
        String lowerCase = (n10.k() + "/" + eVar.n(1).k()).toLowerCase(Locale.US);
        e m11 = eVar.m(2);
        i n11 = eVar.n(3);
        i n12 = eVar.n(5);
        int j10 = eVar.n(6).j();
        if (!w1.f.e(lowerCase, "message/rfc822")) {
            StringBuilder sb = new StringBuilder(lowerCase);
            int r11 = m11.r();
            for (int i11 = 1; i11 < r11; i11 += 2) {
                sb.append(String.format(";\n %s=\"%s\"", m11.n(i11 - 1).k(), m11.n(i11).k()));
            }
            hVar.h("Content-Type", sb.toString());
            if (n10.l("TEXT") && eVar.g(9).d()) {
                m10 = eVar.m(9);
            } else {
                m10 = eVar.m(8);
            }
            StringBuilder sb2 = new StringBuilder();
            if (m10.r() > 0) {
                String lowerCase2 = m10.n(0).k().toLowerCase(Locale.US);
                if (!TextUtils.isEmpty(lowerCase2)) {
                    sb2.append(lowerCase2);
                }
                e m12 = m10.m(1);
                if (!m12.q()) {
                    int r12 = m12.r();
                    for (int i12 = 1; i12 < r12; i12 += 2) {
                        Locale locale = Locale.US;
                        sb2.append(String.format(locale, ";\n %s=\"%s\"", m12.n(i12 - 1).k().toLowerCase(locale), m12.n(i12).k()));
                    }
                }
            }
            if (j10 > 0 && w1.f.c(sb2.toString(), "size") == null) {
                sb2.append(String.format(Locale.US, ";\n size=%d", Integer.valueOf(j10)));
            }
            if (sb2.length() > 0) {
                hVar.h("Content-Disposition", sb2.toString());
            }
            if (!n12.n()) {
                hVar.h("Content-Transfer-Encoding", n12.k());
            }
            if (!n11.n()) {
                hVar.h("Content-ID", n11.k());
            }
            if (j10 > 0) {
                if (hVar instanceof ImapStore.a) {
                    ((ImapStore.a) hVar).A(j10);
                } else if (hVar instanceof C1645b) {
                    ((C1645b) hVar).j(j10);
                } else {
                    throw new MessagingException("Unknown part type " + hVar.toString());
                }
            }
            hVar.h("X-Android-Attachment-StoreData", str);
            return;
        }
        throw new MessagingException("BODYSTRUCTURE message/rfc822 not yet supported.");
    }

    public final void a() {
        if (q()) {
            return;
        }
        throw new MessagingException("Folder " + this.f18119b + " is not open.");
    }

    public void b(boolean z10) {
        if (z10) {
            try {
                f();
            } catch (MessagingException e10) {
                H7.b.c("ImapFolder", "Messaging Exception" + e10);
            }
        }
        this.f18120c = -1;
        synchronized (this) {
            this.f18121d = null;
        }
    }

    public final void d() {
        com.android.contacts.voicemail.impl.mail.store.a aVar = this.f18121d;
        if (aVar != null) {
            aVar.d();
        }
    }

    public final void e() {
        List<g> i10 = this.f18121d.i(String.format(Locale.US, "SELECT \"%s\"", this.f18119b));
        this.f18122e = "mode_read_write";
        int i11 = -1;
        for (g gVar : i10) {
            if (gVar.x(1, "EXISTS")) {
                i11 = gVar.n(0).j();
            } else if (gVar.y()) {
                i t10 = gVar.t();
                if (t10.l("READ-ONLY")) {
                    this.f18122e = "mode_read_only";
                } else if (t10.l("READ-WRITE")) {
                    this.f18122e = "mode_read_write";
                }
            } else if (gVar.B()) {
                this.f18118a.e().U(OmtpEvents.DATA_MAILBOX_OPEN_FAILED);
                throw new MessagingException("Can't open mailbox: " + gVar.v());
            }
        }
        if (i11 != -1) {
            this.f18120c = i11;
            this.f18123f = true;
            return;
        }
        throw new MessagingException("Did not find message count during select");
    }

    public f[] f() {
        a();
        try {
            try {
                o(this.f18121d.i("EXPUNGE"));
                d();
                return null;
            } catch (IOException e10) {
                this.f18118a.e().U(OmtpEvents.DATA_GENERIC_IMAP_IOE);
                throw p(this.f18121d, e10);
            }
        } catch (Throwable th) {
            d();
            throw th;
        }
    }

    public void g(f[] fVarArr, FetchProfile fetchProfile, a aVar) {
        try {
            h(fVarArr, fetchProfile, aVar);
        } catch (RuntimeException e10) {
            H7.b.i("ImapFolder", "Exception detected: " + e10);
            throw e10;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x026f A[LOOP:1: B:31:0x00c9->B:38:0x026f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x026e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void h(com.android.contacts.voicemail.impl.mail.f[] r19, com.android.contacts.voicemail.impl.mail.FetchProfile r20, com.android.contacts.voicemail.impl.mail.store.b.a r21) {
        /*
            Method dump skipped, instructions count: 651
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.voicemail.impl.mail.store.b.h(com.android.contacts.voicemail.impl.mail.f[], com.android.contacts.voicemail.impl.mail.FetchProfile, com.android.contacts.voicemail.impl.mail.store.b$a):void");
    }

    public f i(String str) {
        a();
        for (String str2 : t("UID " + str)) {
            if (str2.equals(str)) {
                return new ImapStore.a(str, this);
            }
        }
        H7.b.c("ImapFolder", "UID " + str + " not found on server");
        return null;
    }

    public f[] j(String[] strArr) {
        if (strArr == null) {
            strArr = t("1:* NOT DELETED");
        }
        return k(strArr);
    }

    public f[] k(String[] strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(new ImapStore.a(str, this));
        }
        return (f[]) arrayList.toArray(f.f18092d);
    }

    public C0177b l() {
        try {
            try {
                for (g gVar : this.f18121d.i(String.format(Locale.US, "GETQUOTAROOT \"%s\"", this.f18119b))) {
                    if (gVar.x(0, "QUOTA")) {
                        e m10 = gVar.m(2);
                        for (int i10 = 0; i10 < m10.r(); i10 += 3) {
                            if (m10.n(i10).l("voice")) {
                                return new C0177b(m10.n(i10 + 1).i(-1), m10.n(i10 + 2).i(-1));
                            }
                        }
                    }
                }
                d();
                return null;
            } catch (IOException e10) {
                this.f18118a.e().U(OmtpEvents.DATA_GENERIC_IMAP_IOE);
                throw p(this.f18121d, e10);
            }
        } finally {
            d();
        }
    }

    public String[] m(List<g> list) {
        ArrayList arrayList = new ArrayList();
        for (g gVar : list) {
            if (gVar.x(0, "SEARCH")) {
                for (int i10 = 1; i10 < gVar.r(); i10++) {
                    i n10 = gVar.n(i10);
                    if (n10.e()) {
                        arrayList.add(n10.k());
                    }
                }
            }
        }
        return (String[]) arrayList.toArray(C1701a.f38120b);
    }

    public final void n(g gVar) {
        if (gVar.x(1, "EXISTS")) {
            this.f18120c = gVar.n(0).j();
        }
    }

    public final void o(List<g> list) {
        Iterator<g> it = list.iterator();
        while (it.hasNext()) {
            n(it.next());
        }
    }

    public final MessagingException p(com.android.contacts.voicemail.impl.mail.store.a aVar, IOException iOException) {
        H7.b.b("ImapFolder", "IO Exception detected: ioe = " + iOException);
        aVar.a();
        if (aVar == this.f18121d) {
            this.f18121d = null;
            b(false);
        }
        return new MessagingException(1, "IO Error", iOException);
    }

    public boolean q() {
        if (this.f18123f && this.f18121d != null) {
            return true;
        }
        return false;
    }

    public void r(String str) {
        try {
            if (!q()) {
                synchronized (this) {
                    this.f18121d = this.f18118a.c();
                    try {
                    } finally {
                        d();
                    }
                }
                try {
                    e();
                    return;
                } catch (IOException e10) {
                    throw p(this.f18121d, e10);
                }
            }
            throw new AssertionError("Duplicated open on ImapFolder");
        } catch (AuthenticationFailedException e11) {
            this.f18121d = null;
            b(false);
            throw e11;
        } catch (MessagingException e12) {
            this.f18123f = false;
            b(false);
            throw e12;
        }
    }

    public String[] t(String str) {
        a();
        try {
            try {
                try {
                    String[] m10 = m(this.f18121d.i("UID SEARCH " + str));
                    H7.b.b("ImapFolder", "searchForUids '" + str + "' results: " + m10.length);
                    d();
                    return m10;
                } catch (IOException e10) {
                    H7.b.b("ImapFolder", "IOException in search: " + str + ", ioe = " + e10);
                    this.f18118a.e().U(OmtpEvents.DATA_GENERIC_IMAP_IOE);
                    throw p(this.f18121d, e10);
                }
            } catch (ImapStore.ImapException e11) {
                H7.b.b("ImapFolder", "ImapException in search: " + str + ", me = " + e11);
                String[] strArr = C1701a.f38120b;
                d();
                return strArr;
            }
        } catch (Throwable th) {
            d();
            throw th;
        }
    }

    public void u(f[] fVarArr, String[] strArr, boolean z10) {
        String str;
        String str2;
        a();
        if (strArr.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (String str3 : strArr) {
                if (str3 == "seen") {
                    sb.append(" \\SEEN");
                } else if (str3 == "deleted") {
                    sb.append(" \\DELETED");
                } else if (str3 == "flagged") {
                    sb.append(" \\FLAGGED");
                } else if (str3 == "answered") {
                    sb.append(" \\ANSWERED");
                }
            }
            str = sb.substring(1);
        } else {
            str = "";
        }
        try {
            try {
                com.android.contacts.voicemail.impl.mail.store.a aVar = this.f18121d;
                Locale locale = Locale.US;
                String h10 = ImapStore.h(fVarArr);
                if (z10) {
                    str2 = "+";
                } else {
                    str2 = "-";
                }
                aVar.i(String.format(locale, "UID STORE %s %sFLAGS.SILENT (%s)", h10, str2, str));
                d();
            } catch (IOException e10) {
                this.f18118a.e().U(OmtpEvents.DATA_GENERIC_IMAP_IOE);
                throw p(this.f18121d, e10);
            }
        } catch (Throwable th) {
            d();
            throw th;
        }
    }
}
