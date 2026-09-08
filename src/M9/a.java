package M9;

import com.coui.appcompat.calendar.COUIDateMonthView;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/* compiled from: DateTime.java */
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final Date f1827a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1828b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1829c;

    /* renamed from: d, reason: collision with root package name */
    public final int f1830d;

    /* renamed from: e, reason: collision with root package name */
    public final int f1831e;

    /* renamed from: f, reason: collision with root package name */
    public final int f1832f;

    /* renamed from: g, reason: collision with root package name */
    public final int f1833g;

    /* renamed from: h, reason: collision with root package name */
    public final int f1834h;

    public a(String str, int i10, int i11, int i12, int i13, int i14, int i15) {
        int b10 = b(str);
        this.f1828b = b10;
        this.f1827a = a(b10, i10, i11, i12, i13, i14, i15);
        this.f1829c = i10;
        this.f1830d = i11;
        this.f1831e = i12;
        this.f1832f = i13;
        this.f1833g = i14;
        this.f1834h = i15;
    }

    public static Date a(int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("GMT+0"));
        gregorianCalendar.set(i10, i11 - 1, i12, i13, i14, i15);
        gregorianCalendar.set(14, 0);
        if (i16 != Integer.MIN_VALUE) {
            gregorianCalendar.add(12, (((i16 / 100) * 60) + (i16 % 100)) * (-1));
        }
        return gregorianCalendar.getTime();
    }

    public final int b(String str) {
        int parseInt = Integer.parseInt(str);
        int length = str.length();
        if (length != 1 && length != 2) {
            if (length != 3) {
                return parseInt;
            }
            return parseInt + COUIDateMonthView.MIN_YEAR;
        }
        if (parseInt >= 0 && parseInt < 50) {
            return parseInt + 2000;
        }
        return parseInt + COUIDateMonthView.MIN_YEAR;
    }

    public Date c() {
        return this.f1827a;
    }

    public int d() {
        return this.f1830d;
    }

    public int e() {
        return this.f1831e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        Date date = this.f1827a;
        if (date == null) {
            if (aVar.f1827a != null) {
                return false;
            }
        } else if (!date.equals(aVar.f1827a)) {
            return false;
        }
        if (this.f1830d == aVar.f1830d && this.f1831e == aVar.f1831e && this.f1832f == aVar.f1832f && this.f1829c == aVar.f1829c && this.f1833g == aVar.f1833g && this.f1834h == aVar.f1834h && this.f1828b == aVar.f1828b) {
            return true;
        }
        return false;
    }

    public int f() {
        return this.f1832f;
    }

    public int g() {
        return this.f1829c;
    }

    public int h() {
        return this.f1833g;
    }

    public int hashCode() {
        int hashCode;
        Date date = this.f1827a;
        if (date == null) {
            hashCode = 0;
        } else {
            hashCode = date.hashCode();
        }
        return ((((((((((((((hashCode + 31) * 31) + this.f1830d) * 31) + this.f1831e) * 31) + this.f1832f) * 31) + this.f1829c) * 31) + this.f1833g) * 31) + this.f1834h) * 31) + this.f1828b;
    }

    public int i() {
        return this.f1834h;
    }

    public int j() {
        return this.f1828b;
    }

    public String toString() {
        return j() + " " + g() + " " + d() + "; " + e() + " " + f() + " " + h() + " " + i();
    }
}
