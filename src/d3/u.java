package d3;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.util.Log;
import d3.o;
import java.io.InputStream;
import java.util.List;

/* compiled from: ResourceUriLoader.java */
/* loaded from: classes.dex */
public final class u<DataT> implements o<Uri, DataT> {

    /* renamed from: a, reason: collision with root package name */
    public final Context f30020a;

    /* renamed from: b, reason: collision with root package name */
    public final o<Integer, DataT> f30021b;

    /* compiled from: ResourceUriLoader.java */
    /* loaded from: classes.dex */
    public static final class a implements p<Uri, AssetFileDescriptor> {

        /* renamed from: a, reason: collision with root package name */
        public final Context f30022a;

        public a(Context context) {
            this.f30022a = context;
        }

        @Override // d3.p
        public o<Uri, AssetFileDescriptor> d(s sVar) {
            return new u(this.f30022a, sVar.d(Integer.class, AssetFileDescriptor.class));
        }
    }

    /* compiled from: ResourceUriLoader.java */
    /* loaded from: classes.dex */
    public static final class b implements p<Uri, InputStream> {

        /* renamed from: a, reason: collision with root package name */
        public final Context f30023a;

        public b(Context context) {
            this.f30023a = context;
        }

        @Override // d3.p
        public o<Uri, InputStream> d(s sVar) {
            return new u(this.f30023a, sVar.d(Integer.class, InputStream.class));
        }
    }

    public u(Context context, o<Integer, DataT> oVar) {
        this.f30020a = context.getApplicationContext();
        this.f30021b = oVar;
    }

    public static p<Uri, AssetFileDescriptor> e(Context context) {
        return new a(context);
    }

    public static p<Uri, InputStream> f(Context context) {
        return new b(context);
    }

    @Override // d3.o
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public o.a<DataT> b(Uri uri, int i10, int i11, X2.d dVar) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 1) {
            return g(uri, i10, i11, dVar);
        }
        if (pathSegments.size() == 2) {
            return h(uri, i10, i11, dVar);
        }
        if (Log.isLoggable("ResourceUriLoader", 5)) {
            Log.w("ResourceUriLoader", "Failed to parse resource uri: " + uri);
            return null;
        }
        return null;
    }

    @Override // d3.o
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri) {
        if ("android.resource".equals(uri.getScheme()) && this.f30020a.getPackageName().equals(uri.getAuthority())) {
            return true;
        }
        return false;
    }

    public final o.a<DataT> g(Uri uri, int i10, int i11, X2.d dVar) {
        try {
            int parseInt = Integer.parseInt(uri.getPathSegments().get(0));
            if (parseInt == 0) {
                if (Log.isLoggable("ResourceUriLoader", 5)) {
                    Log.w("ResourceUriLoader", "Failed to parse a valid non-0 resource id from: " + uri);
                }
                return null;
            }
            return this.f30021b.b(Integer.valueOf(parseInt), i10, i11, dVar);
        } catch (NumberFormatException e10) {
            if (Log.isLoggable("ResourceUriLoader", 5)) {
                Log.w("ResourceUriLoader", "Failed to parse resource id from: " + uri, e10);
            }
            return null;
        }
    }

    public final o.a<DataT> h(Uri uri, int i10, int i11, X2.d dVar) {
        List<String> pathSegments = uri.getPathSegments();
        int identifier = this.f30020a.getResources().getIdentifier(pathSegments.get(1), pathSegments.get(0), this.f30020a.getPackageName());
        if (identifier == 0) {
            if (Log.isLoggable("ResourceUriLoader", 5)) {
                Log.w("ResourceUriLoader", "Failed to find resource id for: " + uri);
                return null;
            }
            return null;
        }
        return this.f30021b.b(Integer.valueOf(identifier), i10, i11, dVar);
    }
}
