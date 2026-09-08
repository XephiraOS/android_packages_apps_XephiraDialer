package d3;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.net.Uri;
import d3.o;
import java.io.InputStream;
import r3.C1508b;

/* compiled from: AssetUriLoader.java */
/* renamed from: d3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0951a<Data> implements o<Uri, Data> {

    /* renamed from: c, reason: collision with root package name */
    public static final int f29930c = 22;

    /* renamed from: a, reason: collision with root package name */
    public final AssetManager f29931a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC0289a<Data> f29932b;

    /* compiled from: AssetUriLoader.java */
    /* renamed from: d3.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0289a<Data> {
        com.bumptech.glide.load.data.d<Data> a(AssetManager assetManager, String str);
    }

    /* compiled from: AssetUriLoader.java */
    /* renamed from: d3.a$b */
    /* loaded from: classes.dex */
    public static class b implements p<Uri, AssetFileDescriptor>, InterfaceC0289a<AssetFileDescriptor> {

        /* renamed from: a, reason: collision with root package name */
        public final AssetManager f29933a;

        public b(AssetManager assetManager) {
            this.f29933a = assetManager;
        }

        @Override // d3.C0951a.InterfaceC0289a
        public com.bumptech.glide.load.data.d<AssetFileDescriptor> a(AssetManager assetManager, String str) {
            return new com.bumptech.glide.load.data.h(assetManager, str);
        }

        @Override // d3.p
        public o<Uri, AssetFileDescriptor> d(s sVar) {
            return new C0951a(this.f29933a, this);
        }
    }

    /* compiled from: AssetUriLoader.java */
    /* renamed from: d3.a$c */
    /* loaded from: classes.dex */
    public static class c implements p<Uri, InputStream>, InterfaceC0289a<InputStream> {

        /* renamed from: a, reason: collision with root package name */
        public final AssetManager f29934a;

        public c(AssetManager assetManager) {
            this.f29934a = assetManager;
        }

        @Override // d3.C0951a.InterfaceC0289a
        public com.bumptech.glide.load.data.d<InputStream> a(AssetManager assetManager, String str) {
            return new com.bumptech.glide.load.data.m(assetManager, str);
        }

        @Override // d3.p
        public o<Uri, InputStream> d(s sVar) {
            return new C0951a(this.f29934a, this);
        }
    }

    public C0951a(AssetManager assetManager, InterfaceC0289a<Data> interfaceC0289a) {
        this.f29931a = assetManager;
        this.f29932b = interfaceC0289a;
    }

    @Override // d3.o
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public o.a<Data> b(Uri uri, int i10, int i11, X2.d dVar) {
        return new o.a<>(new C1508b(uri), this.f29932b.a(this.f29931a, uri.toString().substring(f29930c)));
    }

    @Override // d3.o
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri) {
        if (!"file".equals(uri.getScheme()) || uri.getPathSegments().isEmpty() || !"android_asset".equals(uri.getPathSegments().get(0))) {
            return false;
        }
        return true;
    }
}
