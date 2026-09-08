package x1;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: ImapString.java */
/* loaded from: classes.dex */
public abstract class i extends AbstractC1675d {

    /* renamed from: f, reason: collision with root package name */
    public static final byte[] f37841f = new byte[0];

    /* renamed from: g, reason: collision with root package name */
    public static final i f37842g = new a();

    /* renamed from: h, reason: collision with root package name */
    public static final SimpleDateFormat f37843h = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss Z", Locale.US);

    /* renamed from: c, reason: collision with root package name */
    public boolean f37844c;

    /* renamed from: d, reason: collision with root package name */
    public int f37845d;

    /* renamed from: e, reason: collision with root package name */
    public Date f37846e;

    @Override // x1.AbstractC1675d
    public final boolean d() {
        return false;
    }

    @Override // x1.AbstractC1675d
    public final boolean e() {
        return true;
    }

    public abstract InputStream g();

    public final Date h() {
        if (!m()) {
            return null;
        }
        return this.f37846e;
    }

    public final int i(int i10) {
        if (!o()) {
            return i10;
        }
        return this.f37845d;
    }

    public final int j() {
        return i(0);
    }

    public abstract String k();

    public final boolean l(String str) {
        if (str == null) {
            return false;
        }
        return k().equalsIgnoreCase(str);
    }

    public final boolean m() {
        if (this.f37846e != null) {
            return true;
        }
        if (n()) {
            return false;
        }
        try {
            this.f37846e = f37843h.parse(k());
            return true;
        } catch (ParseException unused) {
            H7.b.i("ImapString", "getString() can't be parsed as a date.");
            return false;
        }
    }

    public final boolean n() {
        if (k().length() == 0) {
            return true;
        }
        return false;
    }

    public final boolean o() {
        if (this.f37844c) {
            return true;
        }
        try {
            this.f37845d = Integer.parseInt(k());
            this.f37844c = true;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public final boolean p(String str) {
        if (str == null) {
            return false;
        }
        String k10 = k();
        if (k10.length() < str.length()) {
            return false;
        }
        return k10.substring(0, str.length()).equalsIgnoreCase(str);
    }

    /* compiled from: ImapString.java */
    /* loaded from: classes.dex */
    public class a extends i {
        @Override // x1.i
        public InputStream g() {
            return new ByteArrayInputStream(i.f37841f);
        }

        @Override // x1.i
        public String k() {
            return "";
        }

        public String toString() {
            return "";
        }

        @Override // x1.AbstractC1675d
        public void b() {
        }
    }
}
