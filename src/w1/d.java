package w1;

import N9.k;
import O9.m;
import S9.i;
import com.android.contacts.voicemail.impl.mail.Address;
import com.android.contacts.voicemail.impl.mail.MessagingException;
import com.android.contacts.voicemail.impl.mail.g;
import com.android.contacts.voicemail.impl.mail.h;
import com.customize.contacts.backupandrestore.plugin.ContactBackupPlugin;
import com.heytap.reflect.BuildConfig;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.Stack;
import java.util.regex.Pattern;

/* compiled from: MimeMessage.java */
/* loaded from: classes.dex */
public class d extends com.android.contacts.voicemail.impl.mail.f {

    /* renamed from: o, reason: collision with root package name */
    public static final Random f37581o = new Random();

    /* renamed from: p, reason: collision with root package name */
    public static final SimpleDateFormat f37582p = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.US);

    /* renamed from: q, reason: collision with root package name */
    public static final Pattern f37583q = Pattern.compile("^<?([^>]+)>?$");

    /* renamed from: r, reason: collision with root package name */
    public static final Pattern f37584r = Pattern.compile("\r?\n");

    /* renamed from: f, reason: collision with root package name */
    public Address[] f37586f;

    /* renamed from: g, reason: collision with root package name */
    public Address[] f37587g;

    /* renamed from: h, reason: collision with root package name */
    public Address[] f37588h;

    /* renamed from: i, reason: collision with root package name */
    public Address[] f37589i;

    /* renamed from: j, reason: collision with root package name */
    public Address[] f37590j;

    /* renamed from: k, reason: collision with root package name */
    public Date f37591k;

    /* renamed from: l, reason: collision with root package name */
    public com.android.contacts.voicemail.impl.mail.a f37592l;

    /* renamed from: m, reason: collision with root package name */
    public int f37593m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f37594n = false;

    /* renamed from: e, reason: collision with root package name */
    public c f37585e = null;

    /* compiled from: MimeMessage.java */
    /* loaded from: classes.dex */
    public class a implements R9.a {

        /* renamed from: a, reason: collision with root package name */
        public final Stack<Object> f37595a = new Stack<>();

        public a() {
        }

        @Override // R9.a
        public void a(S9.b bVar) {
            n(h.class);
            h hVar = (h) this.f37595a.peek();
            try {
                e eVar = new e(hVar.e());
                hVar.d(eVar);
                this.f37595a.push(eVar);
            } catch (MessagingException e10) {
                throw new Error(e10);
            }
        }

        @Override // R9.a
        public void b() {
            n(com.android.contacts.voicemail.impl.mail.b.class);
            this.f37595a.pop();
        }

        @Override // R9.a
        public void c() {
            n(d.class);
            this.f37595a.pop();
        }

        @Override // R9.a
        public void d() {
            n(h.class);
        }

        @Override // R9.a
        public void e() {
            n(h.class);
        }

        @Override // R9.a
        public void f() {
            n(e.class);
            try {
                C1645b c1645b = new C1645b();
                ((e) this.f37595a.peek()).a(c1645b);
                this.f37595a.push(c1645b);
            } catch (MessagingException e10) {
                throw new Error(e10);
            }
        }

        @Override // R9.a
        public void g(S9.b bVar, InputStream inputStream) {
            n(h.class);
            try {
                ((h) this.f37595a.peek()).d(f.b(inputStream, bVar.b()));
            } catch (MessagingException e10) {
                throw new Error(e10);
            }
        }

        @Override // R9.a
        public void h(i iVar) {
            n(h.class);
            try {
                String[] split = iVar.a().toString().split(":", 2);
                ((h) this.f37595a.peek()).f(split[0], split[1].trim());
            } catch (MessagingException e10) {
                throw new Error(e10);
            }
        }

        @Override // R9.a
        public void i(InputStream inputStream) {
            n(e.class);
            do {
            } while (inputStream.read() != -1);
        }

        @Override // R9.a
        public void j(InputStream inputStream) {
            n(e.class);
            StringBuilder sb = new StringBuilder();
            while (true) {
                int read = inputStream.read();
                if (read != -1) {
                    sb.append((char) read);
                } else {
                    try {
                        ((e) this.f37595a.peek()).g(sb.toString());
                        return;
                    } catch (MessagingException e10) {
                        throw new Error(e10);
                    }
                }
            }
        }

        @Override // R9.a
        public void k() {
            if (this.f37595a.isEmpty()) {
                this.f37595a.push(d.this);
                return;
            }
            n(h.class);
            try {
                d dVar = new d();
                ((h) this.f37595a.peek()).d(dVar);
                this.f37595a.push(dVar);
            } catch (MessagingException e10) {
                throw new Error(e10);
            }
        }

        @Override // R9.a
        public void l(InputStream inputStream) {
            throw new UnsupportedOperationException("Not supported");
        }

        @Override // R9.a
        public void m() {
            this.f37595a.pop();
        }

        public final void n(Class<?> cls) {
            if (cls.isInstance(this.f37595a.peek())) {
                return;
            }
            throw new IllegalStateException("Internal stack error: Expected '" + cls.getName() + "' found '" + this.f37595a.peek().getClass().getName() + "'");
        }
    }

    public static String s() {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (int i10 = 0; i10 < 24; i10++) {
            sb.append("0123456789abcdefghijklmnopqrstuv".charAt(f37581o.nextInt() & 31));
        }
        sb.append(".");
        sb.append(Long.toString(System.currentTimeMillis()));
        sb.append("@email.android.com>");
        return sb.toString();
    }

    @Override // com.android.contacts.voicemail.impl.mail.h
    public String a() {
        return f.c(e(), null);
    }

    @Override // com.android.contacts.voicemail.impl.mail.h
    public com.android.contacts.voicemail.impl.mail.a b() {
        return this.f37592l;
    }

    @Override // com.android.contacts.voicemail.impl.mail.h
    public int c() {
        return this.f37593m;
    }

    @Override // com.android.contacts.voicemail.impl.mail.h
    public void d(com.android.contacts.voicemail.impl.mail.a aVar) {
        this.f37592l = aVar;
        if (aVar instanceof g) {
            g gVar = (g) aVar;
            gVar.e(this);
            h("Content-Type", gVar.c());
            h("MIME-Version", BuildConfig.VERSION_NAME);
        }
    }

    @Override // com.android.contacts.voicemail.impl.mail.h
    public String e() {
        String t10 = t("Content-Type");
        if (t10 == null) {
            return "text/plain";
        }
        return t10;
    }

    @Override // com.android.contacts.voicemail.impl.mail.h
    public void f(String str, String str2) {
        v().a(str, str2);
    }

    @Override // com.android.contacts.voicemail.impl.mail.h
    public String[] g(String str) {
        return v().f(str);
    }

    @Override // com.android.contacts.voicemail.impl.mail.h
    public void h(String str, String str2) {
        v().h(str, str2);
    }

    @Override // com.android.contacts.voicemail.impl.mail.f
    public Long i() {
        try {
            String t10 = t("Content-Duration");
            if (t10 == null) {
                H7.b.i("MimeMessage.getDuration", "message missing Content-Duration header");
                return null;
            }
            try {
                return Long.valueOf(t10);
            } catch (NumberFormatException unused) {
                H7.b.i("MimeMessage.getDuration", "cannot parse duration " + t10);
                return null;
            }
        } catch (MessagingException e10) {
            H7.b.c("MimeMessage.getDuration", "cannot retrieve header: " + e10);
            return null;
        }
    }

    @Override // com.android.contacts.voicemail.impl.mail.f
    public Address[] l() {
        if (this.f37586f == null) {
            String f10 = f.f(t("From"));
            if (f10 == null || f10.length() == 0) {
                f10 = f.f(t("Sender"));
            }
            this.f37586f = Address.h(f10);
        }
        return this.f37586f;
    }

    @Override // com.android.contacts.voicemail.impl.mail.f
    public Date m() {
        if (this.f37591k == null) {
            try {
                this.f37591k = ((k) m.d("Date: " + f.g(t("Date")))).getDate();
            } catch (Exception unused) {
                C1.a.e("MimeMessage", "Message missing Date header");
            }
        }
        if (this.f37591k == null) {
            try {
                this.f37591k = ((k) m.d("Date: " + f.g(t("Delivery-date")))).getDate();
            } catch (Exception unused2) {
                C1.a.e("MimeMessage", "Message also missing Delivery-Date header");
            }
        }
        return this.f37591k;
    }

    public String t(String str) {
        return v().e(str);
    }

    public String u() {
        String t10 = t("Message-ID");
        if (t10 == null && !this.f37594n) {
            String s10 = s();
            y(s10);
            return s10;
        }
        return t10;
    }

    public final c v() {
        if (this.f37585e == null) {
            this.f37585e = new c();
        }
        return this.f37585e;
    }

    public final R9.b w() {
        v().d();
        this.f37594n = true;
        this.f37586f = null;
        this.f37587g = null;
        this.f37588h = null;
        this.f37589i = null;
        this.f37590j = null;
        this.f37591k = null;
        this.f37592l = null;
        R9.b bVar = new R9.b();
        bVar.b(new a());
        return bVar;
    }

    @Override // com.android.contacts.voicemail.impl.mail.h
    public void writeTo(OutputStream outputStream) {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream), 1024);
        u();
        v().i(outputStream);
        bufferedWriter.write(ContactBackupPlugin.END_OF_LINE);
        bufferedWriter.flush();
        com.android.contacts.voicemail.impl.mail.a aVar = this.f37592l;
        if (aVar != null) {
            aVar.writeTo(outputStream);
        }
    }

    public void x(InputStream inputStream) {
        w().a(new P9.b(inputStream));
    }

    public void y(String str) {
        h("Message-ID", str);
    }
}
