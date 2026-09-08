package T2;

import com.android.volley.Request;
import com.android.volley.d;
import java.io.UnsupportedEncodingException;

/* compiled from: StringRequest.java */
/* loaded from: classes.dex */
public class l extends Request<String> {

    /* renamed from: q, reason: collision with root package name */
    public final Object f3745q;

    /* renamed from: r, reason: collision with root package name */
    public d.b<String> f3746r;

    public l(int i10, String str, d.b<String> bVar, d.a aVar) {
        super(i10, str, aVar);
        this.f3745q = new Object();
        this.f3746r = bVar;
    }

    @Override // com.android.volley.Request
    public com.android.volley.d<String> F(S2.e eVar) {
        String str;
        try {
            str = new String(eVar.f3391b, e.f(eVar.f3392c));
        } catch (UnsupportedEncodingException unused) {
            str = new String(eVar.f3391b);
        }
        return com.android.volley.d.c(str, e.e(eVar));
    }

    @Override // com.android.volley.Request
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public void f(String str) {
        d.b<String> bVar;
        synchronized (this.f3745q) {
            bVar = this.f3746r;
        }
        if (bVar != null) {
            bVar.a(str);
        }
    }

    @Override // com.android.volley.Request
    public void c() {
        super.c();
        synchronized (this.f3745q) {
            this.f3746r = null;
        }
    }
}
