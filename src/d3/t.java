package d3;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
import d3.o;
import java.io.InputStream;

/* compiled from: ResourceLoader.java */
/* loaded from: classes.dex */
public class t<Data> implements o<Integer, Data> {

    /* renamed from: a, reason: collision with root package name */
    public final o<Uri, Data> f30015a;

    /* renamed from: b, reason: collision with root package name */
    public final Resources f30016b;

    /* compiled from: ResourceLoader.java */
    /* loaded from: classes.dex */
    public static final class a implements p<Integer, AssetFileDescriptor> {

        /* renamed from: a, reason: collision with root package name */
        public final Resources f30017a;

        public a(Resources resources) {
            this.f30017a = resources;
        }

        @Override // d3.p
        public o<Integer, AssetFileDescriptor> d(s sVar) {
            return new t(this.f30017a, sVar.d(Uri.class, AssetFileDescriptor.class));
        }
    }

    /* compiled from: ResourceLoader.java */
    /* loaded from: classes.dex */
    public static class b implements p<Integer, InputStream> {

        /* renamed from: a, reason: collision with root package name */
        public final Resources f30018a;

        public b(Resources resources) {
            this.f30018a = resources;
        }

        @Override // d3.p
        public o<Integer, InputStream> d(s sVar) {
            return new t(this.f30018a, sVar.d(Uri.class, InputStream.class));
        }
    }

    /* compiled from: ResourceLoader.java */
    /* loaded from: classes.dex */
    public static class c implements p<Integer, Uri> {

        /* renamed from: a, reason: collision with root package name */
        public final Resources f30019a;

        public c(Resources resources) {
            this.f30019a = resources;
        }

        @Override // d3.p
        public o<Integer, Uri> d(s sVar) {
            return new t(this.f30019a, x.c());
        }
    }

    public t(Resources resources, o<Uri, Data> oVar) {
        this.f30016b = resources;
        this.f30015a = oVar;
    }

    @Override // d3.o
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public o.a<Data> b(Integer num, int i10, int i11, X2.d dVar) {
        Uri d10 = d(num);
        if (d10 == null) {
            return null;
        }
        return this.f30015a.b(d10, i10, i11, dVar);
    }

    public final Uri d(Integer num) {
        try {
            return Uri.parse("android.resource://" + this.f30016b.getResourcePackageName(num.intValue()) + '/' + this.f30016b.getResourceTypeName(num.intValue()) + '/' + this.f30016b.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException e10) {
            if (Log.isLoggable("ResourceLoader", 5)) {
                Log.w("ResourceLoader", "Received invalid resource id: " + num, e10);
                return null;
            }
            return null;
        }
    }

    @Override // d3.o
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean a(Integer num) {
        return true;
    }
}
