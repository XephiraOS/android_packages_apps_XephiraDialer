package androidx.window.core;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.a;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.text.n;
import m9.d;
import v9.InterfaceC1637a;

/* compiled from: Version.kt */
/* loaded from: classes.dex */
public final class Version implements Comparable<Version> {

    /* renamed from: f, reason: collision with root package name */
    public static final Companion f11924f = new Companion(null);

    /* renamed from: g, reason: collision with root package name */
    public static final Version f11925g = new Version(0, 0, 0, "");

    /* renamed from: h, reason: collision with root package name */
    public static final Version f11926h = new Version(0, 1, 0, "");

    /* renamed from: i, reason: collision with root package name */
    public static final Version f11927i;

    /* renamed from: j, reason: collision with root package name */
    public static final Version f11928j;

    /* renamed from: a, reason: collision with root package name */
    public final int f11929a;

    /* renamed from: b, reason: collision with root package name */
    public final int f11930b;

    /* renamed from: c, reason: collision with root package name */
    public final int f11931c;

    /* renamed from: d, reason: collision with root package name */
    public final String f11932d;

    /* renamed from: e, reason: collision with root package name */
    public final d f11933e;

    /* compiled from: Version.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public final Version a() {
            return Version.f11926h;
        }

        public final Version b(String str) {
            boolean q10;
            String group;
            String str2;
            if (str != null) {
                q10 = n.q(str);
                if (q10) {
                    return null;
                }
                Matcher matcher = Pattern.compile("(\\d+)(?:\\.(\\d+))(?:\\.(\\d+))(?:-(.+))?").matcher(str);
                if (!matcher.matches() || (group = matcher.group(1)) == null) {
                    return null;
                }
                int parseInt = Integer.parseInt(group);
                String group2 = matcher.group(2);
                if (group2 == null) {
                    return null;
                }
                int parseInt2 = Integer.parseInt(group2);
                String group3 = matcher.group(3);
                if (group3 == null) {
                    return null;
                }
                int parseInt3 = Integer.parseInt(group3);
                if (matcher.group(4) != null) {
                    str2 = matcher.group(4);
                } else {
                    str2 = "";
                }
                String description = str2;
                i.e(description, "description");
                return new Version(parseInt, parseInt2, parseInt3, description, null);
            }
            return null;
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    static {
        Version version = new Version(1, 0, 0, "");
        f11927i = version;
        f11928j = version;
    }

    public /* synthetic */ Version(int i10, int i11, int i12, String str, f fVar) {
        this(i10, i11, i12, str);
    }

    @Override // java.lang.Comparable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(Version other) {
        i.f(other, "other");
        return c().compareTo(other.c());
    }

    public final BigInteger c() {
        Object value = this.f11933e.getValue();
        i.e(value, "<get-bigInteger>(...)");
        return (BigInteger) value;
    }

    public final int d() {
        return this.f11929a;
    }

    public final int e() {
        return this.f11930b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Version)) {
            return false;
        }
        Version version = (Version) obj;
        if (this.f11929a != version.f11929a || this.f11930b != version.f11930b || this.f11931c != version.f11931c) {
            return false;
        }
        return true;
    }

    public final int f() {
        return this.f11931c;
    }

    public int hashCode() {
        return ((((527 + this.f11929a) * 31) + this.f11930b) * 31) + this.f11931c;
    }

    public String toString() {
        boolean q10;
        String str;
        q10 = n.q(this.f11932d);
        if (!q10) {
            str = '-' + this.f11932d;
        } else {
            str = "";
        }
        return this.f11929a + '.' + this.f11930b + '.' + this.f11931c + str;
    }

    public Version(int i10, int i11, int i12, String str) {
        d b10;
        this.f11929a = i10;
        this.f11930b = i11;
        this.f11931c = i12;
        this.f11932d = str;
        b10 = a.b(new InterfaceC1637a<BigInteger>() { // from class: androidx.window.core.Version$bigInteger$2
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final BigInteger invoke() {
                return BigInteger.valueOf(Version.this.d()).shiftLeft(32).or(BigInteger.valueOf(Version.this.e())).shiftLeft(32).or(BigInteger.valueOf(Version.this.f()));
            }
        });
        this.f11933e = b10;
    }
}
