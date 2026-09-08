package e3;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import d3.o;
import d3.p;
import d3.s;
import java.io.InputStream;
import r3.C1508b;

/* compiled from: MediaStoreVideoThumbLoader.java */
/* renamed from: e3.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0972c implements o<Uri, InputStream> {

    /* renamed from: a, reason: collision with root package name */
    public final Context f30592a;

    /* compiled from: MediaStoreVideoThumbLoader.java */
    /* renamed from: e3.c$a */
    /* loaded from: classes.dex */
    public static class a implements p<Uri, InputStream> {

        /* renamed from: a, reason: collision with root package name */
        public final Context f30593a;

        public a(Context context) {
            this.f30593a = context;
        }

        @Override // d3.p
        public o<Uri, InputStream> d(s sVar) {
            return new C0972c(this.f30593a);
        }
    }

    public C0972c(Context context) {
        this.f30592a = context.getApplicationContext();
    }

    @Override // d3.o
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public o.a<InputStream> b(Uri uri, int i10, int i11, X2.d dVar) {
        if (Y2.b.e(i10, i11) && e(dVar)) {
            return new o.a<>(new C1508b(uri), Y2.c.g(this.f30592a, uri));
        }
        return null;
    }

    @Override // d3.o
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri) {
        return Y2.b.d(uri);
    }

    public final boolean e(X2.d dVar) {
        Long l10 = (Long) dVar.c(VideoDecoder.f19651d);
        if (l10 != null && l10.longValue() == -1) {
            return true;
        }
        return false;
    }
}
