package x1;

import android.util.ArrayMap;
import android.util.Base64;
import com.android.contacts.voicemail.impl.mail.MessagingException;
import com.android.contacts.voicemail.impl.mail.store.ImapStore;
import com.heytap.accessory.constant.FastPairConstants;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Map;

/* compiled from: DigestMd5Utils.java */
/* renamed from: x1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1673b {

    /* compiled from: DigestMd5Utils.java */
    /* renamed from: x1.b$a */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f37818a;

        /* renamed from: b, reason: collision with root package name */
        public String f37819b;

        /* renamed from: c, reason: collision with root package name */
        public String f37820c;

        /* renamed from: d, reason: collision with root package name */
        public String f37821d;

        /* renamed from: g, reason: collision with root package name */
        public String f37824g;

        /* renamed from: f, reason: collision with root package name */
        public String f37823f = a();

        /* renamed from: e, reason: collision with root package name */
        public String f37822e = "00000001";

        /* renamed from: h, reason: collision with root package name */
        public String f37825h = "auth";

        /* compiled from: DigestMd5Utils.java */
        /* renamed from: x1.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0374a {

            /* renamed from: a, reason: collision with root package name */
            public StringBuilder f37826a;

            public C0374a a(String str, String str2) {
                if (this.f37826a.length() != 0) {
                    this.f37826a.append(",");
                }
                StringBuilder sb = this.f37826a;
                sb.append(str);
                sb.append("=");
                sb.append(str2);
                return this;
            }

            public C0374a b(String str, String str2) {
                if (this.f37826a.length() != 0) {
                    this.f37826a.append(",");
                }
                StringBuilder sb = this.f37826a;
                sb.append(str);
                sb.append("=\"");
                sb.append(str2);
                sb.append("\"");
                return this;
            }

            public String toString() {
                return this.f37826a.toString();
            }

            public C0374a() {
                this.f37826a = new StringBuilder();
            }
        }

        public a(ImapStore imapStore, com.android.contacts.voicemail.impl.mail.e eVar, Map<String, String> map) {
            this.f37818a = imapStore.g();
            this.f37819b = imapStore.f();
            this.f37820c = map.getOrDefault("realm", "");
            this.f37821d = map.get("nonce");
            this.f37824g = "imap/" + eVar.f();
        }

        public static String a() {
            byte[] bArr = new byte[8];
            new SecureRandom().nextBytes(bArr);
            return Base64.encodeToString(bArr, 2);
        }

        public String b() {
            String c10 = C1673b.c(this, false);
            C0374a c0374a = new C0374a();
            c0374a.a("CHARSET", "utf-8").b("username", this.f37818a).b("realm", this.f37820c).b("nonce", this.f37821d).a("nc", this.f37822e).b("cnonce", this.f37823f).b("digest-uri", this.f37824g).a("response", c10).a("qop", this.f37825h);
            return c0374a.toString();
        }

        public void c(String str) {
            if (str.startsWith("rspauth=")) {
                if (str.substring(8).equals(C1673b.c(this, true))) {
                    return;
                } else {
                    throw new MessagingException("invalid response-auth return from the server.");
                }
            }
            throw new MessagingException("response-auth expected");
        }
    }

    /* compiled from: DigestMd5Utils.java */
    /* renamed from: x1.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0375b {

        /* renamed from: a, reason: collision with root package name */
        public final String f37827a;

        /* renamed from: b, reason: collision with root package name */
        public int f37828b = 0;

        /* renamed from: c, reason: collision with root package name */
        public Map<String, String> f37829c = new ArrayMap();

        public C0375b(String str) {
            this.f37827a = str;
        }

        public final void a(char c10) {
            if (j() == c10) {
                return;
            }
            throw new IllegalStateException("unexpected character " + this.f37827a.charAt(this.f37828b));
        }

        public final void b(char c10) {
            while (i() != c10) {
                this.f37828b++;
            }
        }

        public Map<String, String> c() {
            while (this.f37828b < this.f37827a.length()) {
                try {
                    e();
                    if (this.f37828b != this.f37827a.length()) {
                        a(',');
                    }
                } catch (IndexOutOfBoundsException e10) {
                    H7.b.c("DigestMd5Utils", e10.toString());
                    return null;
                }
            }
            return this.f37829c;
        }

        public final String d() {
            int i10 = this.f37828b;
            b('=');
            return this.f37827a.substring(i10, this.f37828b);
        }

        public final void e() {
            String d10 = d();
            a('=');
            this.f37829c.put(d10, h());
        }

        public final String f() {
            a('\"');
            StringBuilder sb = new StringBuilder();
            while (true) {
                char j10 = j();
                if (j10 == '\\') {
                    sb.append(j());
                } else {
                    if (j10 == '\"') {
                        return sb.toString();
                    }
                    sb.append(j10);
                }
            }
        }

        public final String g() {
            StringBuilder sb = new StringBuilder();
            while (true) {
                char j10 = j();
                if (j10 == '\\') {
                    sb.append(j());
                } else {
                    if (j10 == ',') {
                        this.f37828b--;
                        break;
                    }
                    sb.append(j10);
                }
                if (this.f37828b == this.f37827a.length()) {
                    break;
                }
            }
            return sb.toString();
        }

        public final String h() {
            if (i() == '\"') {
                return f();
            }
            return g();
        }

        public final char i() {
            return this.f37827a.charAt(this.f37828b);
        }

        public final char j() {
            char i10 = i();
            this.f37828b++;
            return i10;
        }
    }

    public static byte[] a(String str, String str2) {
        return b(str + ":" + str2);
    }

    public static byte[] b(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes(StandardCharsets.ISO_8859_1));
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException e10) {
            throw new AssertionError(e10);
        }
    }

    public static String c(a aVar, boolean z10) {
        StringBuilder sb = new StringBuilder();
        if (!z10) {
            sb.append("AUTHENTICATE");
        }
        sb.append(":");
        sb.append(aVar.f37824g);
        return e(a(e(b(new String(b(aVar.f37818a + ":" + aVar.f37820c + ":" + aVar.f37819b), StandardCharsets.ISO_8859_1) + ":" + aVar.f37821d + ":" + aVar.f37823f)), aVar.f37821d + ":" + aVar.f37822e + ":" + aVar.f37823f + ":" + aVar.f37825h + ":" + e(b(sb.toString()))));
    }

    public static Map<String, String> d(String str) {
        Map<String, String> c10 = new C0375b(str).c();
        if (c10.containsKey("nonce")) {
            return c10;
        }
        throw new MessagingException("nonce missing from server DIGEST-MD5 challenge");
    }

    public static String e(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b10 : bArr) {
            int i10 = b10 & FastPairConstants.GO_INTENT_NOT_SET;
            sb.append("0123456789abcdef".charAt(i10 / 16));
            sb.append("0123456789abcdef".charAt(i10 % 16));
        }
        return sb.toString();
    }
}
