package Z7;

import android.location.Address;

/* compiled from: AddressReverseGeoCode.java */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public Address f5964a;

    public a(Address address) {
        this.f5964a = address;
    }

    public String a() {
        Address address = this.f5964a;
        if (address != null) {
            return address.getLocality();
        }
        return null;
    }

    public String b() {
        Address address = this.f5964a;
        if (address != null) {
            return address.getCountryName();
        }
        return null;
    }

    public String c() {
        if (this.f5964a == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i10 = 0;
        if (l7.b.f34735c) {
            String[] strArr = {e(), a(), d(), f()};
            while (i10 < 4) {
                String str = strArr[i10];
                if (str != null && !str.isEmpty()) {
                    sb.append(strArr[i10]);
                }
                i10++;
            }
            return sb.toString();
        }
        String[] strArr2 = {f(), d(), a(), e(), b()};
        while (i10 < 5) {
            String str2 = strArr2[i10];
            if (str2 != null && !str2.isEmpty()) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(strArr2[i10]);
            }
            i10++;
        }
        return sb.toString();
    }

    public String d() {
        Address address = this.f5964a;
        if (address != null) {
            return address.getSubLocality();
        }
        return null;
    }

    public String e() {
        Address address = this.f5964a;
        if (address != null) {
            return address.getAdminArea();
        }
        return null;
    }

    public String f() {
        Address address = this.f5964a;
        if (address != null) {
            if (address.getThoroughfare() != null) {
                return this.f5964a.getThoroughfare();
            }
            return this.f5964a.getFeatureName();
        }
        return null;
    }
}
