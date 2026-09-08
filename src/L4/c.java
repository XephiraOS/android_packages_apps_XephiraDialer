package L4;

import com.google.i18n.phonenumbers.Phonenumber$PhoneNumber;
import java.util.Arrays;

/* compiled from: PhoneNumberMatch.java */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final int f1717a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1718b;

    /* renamed from: c, reason: collision with root package name */
    public final Phonenumber$PhoneNumber f1719c;

    public c(int i10, String str, Phonenumber$PhoneNumber phonenumber$PhoneNumber) {
        if (i10 >= 0) {
            if (str != null && phonenumber$PhoneNumber != null) {
                this.f1717a = i10;
                this.f1718b = str;
                this.f1719c = phonenumber$PhoneNumber;
                return;
            }
            throw null;
        }
        throw new IllegalArgumentException("Start index must be >= 0.");
    }

    public int a() {
        return this.f1717a + this.f1718b.length();
    }

    public String b() {
        return this.f1718b;
    }

    public int c() {
        return this.f1717a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f1718b.equals(cVar.f1718b) && this.f1717a == cVar.f1717a && this.f1719c.equals(cVar.f1719c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f1717a), this.f1718b, this.f1719c});
    }

    public String toString() {
        return "PhoneNumberMatch [" + c() + "," + a() + ") " + this.f1718b;
    }
}
