package e3;

import android.content.Context;
import android.net.Uri;
import d3.o;
import d3.p;
import d3.s;
import java.io.InputStream;
import r3.C1508b;

/* compiled from: MediaStoreImageThumbLoader.java */
/* renamed from: e3.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0971b implements o<Uri, InputStream> {

    /* renamed from: a, reason: collision with root package name */
    public final Context f30590a;

    /* compiled from: MediaStoreImageThumbLoader.java */
    /* renamed from: e3.b$a */
    /* loaded from: classes.dex */
    public static class a implements p<Uri, InputStream> {

        /* renamed from: a, reason: collision with root package name */
        public final Context f30591a;

        public a(Context context) {
            this.f30591a = context;
        }

        @Override // d3.p
        public o<Uri, InputStream> d(s sVar) {
            return new C0971b(this.f30591a);
        }
    }

    public C0971b(Context context) {
        this.f30590a = context.getApplicationContext();
    }

    @Override // d3.o
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public o.a<InputStream> b(Uri uri, int i10, int i11, X2.d dVar) {
        if (Y2.b.e(i10, i11)) {
            return new o.a<>(new C1508b(uri), Y2.c.f(this.f30590a, uri));
        }
        return null;
    }

    @Override // d3.o
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri) {
        return Y2.b.b(uri);
    }
}
