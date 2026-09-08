package d3;

import android.net.Uri;
import d3.o;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: UrlUriLoader.java */
/* loaded from: classes.dex */
public class z<Data> implements o<Uri, Data> {

    /* renamed from: b, reason: collision with root package name */
    public static final Set<String> f30034b = Collections.unmodifiableSet(new HashSet(Arrays.asList("http", "https")));

    /* renamed from: a, reason: collision with root package name */
    public final o<h, Data> f30035a;

    /* compiled from: UrlUriLoader.java */
    /* loaded from: classes.dex */
    public static class a implements p<Uri, InputStream> {
        @Override // d3.p
        public o<Uri, InputStream> d(s sVar) {
            return new z(sVar.d(h.class, InputStream.class));
        }
    }

    public z(o<h, Data> oVar) {
        this.f30035a = oVar;
    }

    @Override // d3.o
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public o.a<Data> b(Uri uri, int i10, int i11, X2.d dVar) {
        return this.f30035a.b(new h(uri.toString()), i10, i11, dVar);
    }

    @Override // d3.o
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri) {
        return f30034b.contains(uri.getScheme());
    }
}
