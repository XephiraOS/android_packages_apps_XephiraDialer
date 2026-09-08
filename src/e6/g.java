package e6;

/* compiled from: Marker.java */
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public final String f31648a;

    /* renamed from: b, reason: collision with root package name */
    public final float f31649b;

    /* renamed from: c, reason: collision with root package name */
    public final float f31650c;

    public g(String str, float f10, float f11) {
        this.f31648a = str;
        this.f31650c = f11;
        this.f31649b = f10;
    }

    public boolean a(String str) {
        if (this.f31648a.equalsIgnoreCase(str)) {
            return true;
        }
        if (l6.h.m(this.f31648a, "\r")) {
            String str2 = this.f31648a;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
