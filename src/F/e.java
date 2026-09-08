package F;

import android.os.LocaleList;
import java.util.Locale;

/* compiled from: LocaleListCompat.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: b, reason: collision with root package name */
    public static final e f781b = a(new Locale[0]);

    /* renamed from: a, reason: collision with root package name */
    public final f f782a;

    /* compiled from: LocaleListCompat.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final Locale[] f783a = {new Locale("en", "XA"), new Locale("ar", "XB")};

        public static Locale a(String str) {
            return Locale.forLanguageTag(str);
        }
    }

    /* compiled from: LocaleListCompat.java */
    /* loaded from: classes.dex */
    public static class b {
        public static LocaleList a(Locale... localeArr) {
            return new LocaleList(localeArr);
        }
    }

    public e(f fVar) {
        this.f782a = fVar;
    }

    public static e a(Locale... localeArr) {
        return f(b.a(localeArr));
    }

    public static e b(String str) {
        if (str != null && !str.isEmpty()) {
            String[] split = str.split(",", -1);
            int length = split.length;
            Locale[] localeArr = new Locale[length];
            for (int i10 = 0; i10 < length; i10++) {
                localeArr[i10] = a.a(split[i10]);
            }
            return a(localeArr);
        }
        return c();
    }

    public static e c() {
        return f781b;
    }

    public static e f(LocaleList localeList) {
        return new e(new g(localeList));
    }

    public boolean d() {
        return this.f782a.isEmpty();
    }

    public String e() {
        return this.f782a.a();
    }

    public boolean equals(Object obj) {
        if ((obj instanceof e) && this.f782a.equals(((e) obj).f782a)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f782a.hashCode();
    }

    public String toString() {
        return this.f782a.toString();
    }
}
