package G;

import android.util.Base64;
import java.util.List;

/* compiled from: FontRequest.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final String f1045a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1046b;

    /* renamed from: c, reason: collision with root package name */
    public final String f1047c;

    /* renamed from: d, reason: collision with root package name */
    public final List<List<byte[]>> f1048d;

    /* renamed from: e, reason: collision with root package name */
    public final int f1049e = 0;

    /* renamed from: f, reason: collision with root package name */
    public final String f1050f;

    public e(String str, String str2, String str3, List<List<byte[]>> list) {
        this.f1045a = (String) I.h.e(str);
        this.f1046b = (String) I.h.e(str2);
        this.f1047c = (String) I.h.e(str3);
        this.f1048d = (List) I.h.e(list);
        this.f1050f = a(str, str2, str3);
    }

    public final String a(String str, String str2, String str3) {
        return str + "-" + str2 + "-" + str3;
    }

    public List<List<byte[]>> b() {
        return this.f1048d;
    }

    public int c() {
        return this.f1049e;
    }

    public String d() {
        return this.f1050f;
    }

    public String e() {
        return this.f1045a;
    }

    public String f() {
        return this.f1046b;
    }

    public String g() {
        return this.f1047c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f1045a + ", mProviderPackage: " + this.f1046b + ", mQuery: " + this.f1047c + ", mCertificates:");
        for (int i10 = 0; i10 < this.f1048d.size(); i10++) {
            sb.append(" [");
            List<byte[]> list = this.f1048d.get(i10);
            for (int i11 = 0; i11 < list.size(); i11++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString(list.get(i11), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.f1049e);
        return sb.toString();
    }
}
