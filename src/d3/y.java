package d3;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import d3.o;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import r3.C1508b;

/* compiled from: UriLoader.java */
/* loaded from: classes.dex */
public class y<Data> implements o<Uri, Data> {

    /* renamed from: b, reason: collision with root package name */
    public static final Set<String> f30029b = Collections.unmodifiableSet(new HashSet(Arrays.asList("file", "content", "android.resource")));

    /* renamed from: a, reason: collision with root package name */
    public final c<Data> f30030a;

    /* compiled from: UriLoader.java */
    /* loaded from: classes.dex */
    public static final class a implements p<Uri, AssetFileDescriptor>, c<AssetFileDescriptor> {

        /* renamed from: a, reason: collision with root package name */
        public final ContentResolver f30031a;

        public a(ContentResolver contentResolver) {
            this.f30031a = contentResolver;
        }

        @Override // d3.y.c
        public com.bumptech.glide.load.data.d<AssetFileDescriptor> a(Uri uri) {
            return new com.bumptech.glide.load.data.a(this.f30031a, uri);
        }

        @Override // d3.p
        public o<Uri, AssetFileDescriptor> d(s sVar) {
            return new y(this);
        }
    }

    /* compiled from: UriLoader.java */
    /* loaded from: classes.dex */
    public static class b implements p<Uri, ParcelFileDescriptor>, c<ParcelFileDescriptor> {

        /* renamed from: a, reason: collision with root package name */
        public final ContentResolver f30032a;

        public b(ContentResolver contentResolver) {
            this.f30032a = contentResolver;
        }

        @Override // d3.y.c
        public com.bumptech.glide.load.data.d<ParcelFileDescriptor> a(Uri uri) {
            return new com.bumptech.glide.load.data.i(this.f30032a, uri);
        }

        @Override // d3.p
        public o<Uri, ParcelFileDescriptor> d(s sVar) {
            return new y(this);
        }
    }

    /* compiled from: UriLoader.java */
    /* loaded from: classes.dex */
    public interface c<Data> {
        com.bumptech.glide.load.data.d<Data> a(Uri uri);
    }

    /* compiled from: UriLoader.java */
    /* loaded from: classes.dex */
    public static class d implements p<Uri, InputStream>, c<InputStream> {

        /* renamed from: a, reason: collision with root package name */
        public final ContentResolver f30033a;

        public d(ContentResolver contentResolver) {
            this.f30033a = contentResolver;
        }

        @Override // d3.y.c
        public com.bumptech.glide.load.data.d<InputStream> a(Uri uri) {
            return new com.bumptech.glide.load.data.n(this.f30033a, uri);
        }

        @Override // d3.p
        public o<Uri, InputStream> d(s sVar) {
            return new y(this);
        }
    }

    public y(c<Data> cVar) {
        this.f30030a = cVar;
    }

    @Override // d3.o
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public o.a<Data> b(Uri uri, int i10, int i11, X2.d dVar) {
        return new o.a<>(new C1508b(uri), this.f30030a.a(uri));
    }

    @Override // d3.o
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri) {
        return f30029b.contains(uri.getScheme());
    }
}
