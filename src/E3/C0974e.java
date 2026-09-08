package e3;

import d3.h;
import d3.o;
import d3.p;
import d3.s;
import java.io.InputStream;
import java.net.URL;

/* compiled from: UrlLoader.java */
/* renamed from: e3.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0974e implements o<URL, InputStream> {

    /* renamed from: a, reason: collision with root package name */
    public final o<h, InputStream> f30611a;

    /* compiled from: UrlLoader.java */
    /* renamed from: e3.e$a */
    /* loaded from: classes.dex */
    public static class a implements p<URL, InputStream> {
        @Override // d3.p
        public o<URL, InputStream> d(s sVar) {
            return new C0974e(sVar.d(h.class, InputStream.class));
        }
    }

    public C0974e(o<h, InputStream> oVar) {
        this.f30611a = oVar;
    }

    @Override // d3.o
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public o.a<InputStream> b(URL url, int i10, int i11, X2.d dVar) {
        return this.f30611a.b(new h(url), i10, i11, dVar);
    }

    @Override // d3.o
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(URL url) {
        return true;
    }
}
