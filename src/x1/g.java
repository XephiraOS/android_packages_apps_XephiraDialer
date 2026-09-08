package x1;

/* compiled from: ImapResponse.java */
/* loaded from: classes.dex */
public class g extends e {

    /* renamed from: e, reason: collision with root package name */
    public final String f37837e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f37838f;

    public g(String str, boolean z10) {
        this.f37837e = str;
        this.f37838f = z10;
    }

    public static boolean A(String str) {
        if (!"OK".equalsIgnoreCase(str) && !"NO".equalsIgnoreCase(str) && !"BAD".equalsIgnoreCase(str) && !"PREAUTH".equalsIgnoreCase(str) && !"BYE".equalsIgnoreCase(str)) {
            return false;
        }
        return true;
    }

    public boolean B() {
        if (this.f37837e != null) {
            return true;
        }
        return false;
    }

    public i s() {
        if (!t().l("ALERT")) {
            return i.f37842g;
        }
        return n(2);
    }

    public i t() {
        if (!z()) {
            return i.f37842g;
        }
        return m(1).n(0);
    }

    @Override // x1.e
    public String toString() {
        String str = this.f37837e;
        if (w()) {
            str = "+";
        }
        return "#" + str + "# " + super.toString();
    }

    public i u() {
        if (!z()) {
            return i.f37842g;
        }
        return n(0);
    }

    public i v() {
        if (!z()) {
            return i.f37842g;
        }
        int i10 = 1;
        if (g(1).d()) {
            i10 = 2;
        }
        return n(i10);
    }

    public boolean w() {
        return this.f37838f;
    }

    public final boolean x(int i10, String str) {
        if (!B() && n(i10).l(str)) {
            return true;
        }
        return false;
    }

    public boolean y() {
        return o(0, "OK");
    }

    public boolean z() {
        return A(n(0).k());
    }
}
