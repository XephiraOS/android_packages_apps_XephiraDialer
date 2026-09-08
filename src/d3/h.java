package d3;

import android.net.Uri;
import android.text.TextUtils;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;
import s3.C1540k;

/* compiled from: GlideUrl.java */
/* loaded from: classes.dex */
public class h implements X2.b {

    /* renamed from: b, reason: collision with root package name */
    public final i f29962b;

    /* renamed from: c, reason: collision with root package name */
    public final URL f29963c;

    /* renamed from: d, reason: collision with root package name */
    public final String f29964d;

    /* renamed from: e, reason: collision with root package name */
    public String f29965e;

    /* renamed from: f, reason: collision with root package name */
    public URL f29966f;

    /* renamed from: g, reason: collision with root package name */
    public volatile byte[] f29967g;

    /* renamed from: h, reason: collision with root package name */
    public int f29968h;

    public h(URL url) {
        this(url, i.f29970b);
    }

    @Override // X2.b
    public void a(MessageDigest messageDigest) {
        messageDigest.update(d());
    }

    public String c() {
        String str = this.f29964d;
        if (str == null) {
            return ((URL) C1540k.d(this.f29963c)).toString();
        }
        return str;
    }

    public final byte[] d() {
        if (this.f29967g == null) {
            this.f29967g = c().getBytes(X2.b.f4277a);
        }
        return this.f29967g;
    }

    public Map<String, String> e() {
        return this.f29962b.a();
    }

    @Override // X2.b
    public boolean equals(Object obj) {
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (!c().equals(hVar.c()) || !this.f29962b.equals(hVar.f29962b)) {
            return false;
        }
        return true;
    }

    public final String f() {
        if (TextUtils.isEmpty(this.f29965e)) {
            String str = this.f29964d;
            if (TextUtils.isEmpty(str)) {
                str = ((URL) C1540k.d(this.f29963c)).toString();
            }
            this.f29965e = Uri.encode(str, "@#&=*+-_.,:!?()/~'%;$");
        }
        return this.f29965e;
    }

    public final URL g() {
        if (this.f29966f == null) {
            this.f29966f = new URL(f());
        }
        return this.f29966f;
    }

    public URL h() {
        return g();
    }

    @Override // X2.b
    public int hashCode() {
        if (this.f29968h == 0) {
            int hashCode = c().hashCode();
            this.f29968h = hashCode;
            this.f29968h = (hashCode * 31) + this.f29962b.hashCode();
        }
        return this.f29968h;
    }

    public String toString() {
        return c();
    }

    public h(String str) {
        this(str, i.f29970b);
    }

    public h(URL url, i iVar) {
        this.f29963c = (URL) C1540k.d(url);
        this.f29964d = null;
        this.f29962b = (i) C1540k.d(iVar);
    }

    public h(String str, i iVar) {
        this.f29963c = null;
        this.f29964d = C1540k.b(str);
        this.f29962b = (i) C1540k.d(iVar);
    }
}
