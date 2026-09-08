package d3;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import d3.o;
import i3.C1093b;
import i3.C1096e;
import java.io.IOException;
import java.io.InputStream;
import r3.C1508b;

/* compiled from: DirectResourceLoader.java */
/* loaded from: classes.dex */
public final class f<DataT> implements o<Integer, DataT> {

    /* renamed from: a, reason: collision with root package name */
    public final Context f29947a;

    /* renamed from: b, reason: collision with root package name */
    public final e<DataT> f29948b;

    /* compiled from: DirectResourceLoader.java */
    /* loaded from: classes.dex */
    public static final class a implements p<Integer, AssetFileDescriptor>, e<AssetFileDescriptor> {

        /* renamed from: a, reason: collision with root package name */
        public final Context f29949a;

        public a(Context context) {
            this.f29949a = context;
        }

        @Override // d3.f.e
        public Class<AssetFileDescriptor> a() {
            return AssetFileDescriptor.class;
        }

        @Override // d3.p
        public o<Integer, AssetFileDescriptor> d(s sVar) {
            return new f(this.f29949a, this);
        }

        @Override // d3.f.e
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void b(AssetFileDescriptor assetFileDescriptor) {
            assetFileDescriptor.close();
        }

        @Override // d3.f.e
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public AssetFileDescriptor c(Resources.Theme theme, Resources resources, int i10) {
            return resources.openRawResourceFd(i10);
        }
    }

    /* compiled from: DirectResourceLoader.java */
    /* loaded from: classes.dex */
    public static final class c implements p<Integer, InputStream>, e<InputStream> {

        /* renamed from: a, reason: collision with root package name */
        public final Context f29951a;

        public c(Context context) {
            this.f29951a = context;
        }

        @Override // d3.f.e
        public Class<InputStream> a() {
            return InputStream.class;
        }

        @Override // d3.p
        public o<Integer, InputStream> d(s sVar) {
            return new f(this.f29951a, this);
        }

        @Override // d3.f.e
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void b(InputStream inputStream) {
            inputStream.close();
        }

        @Override // d3.f.e
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public InputStream c(Resources.Theme theme, Resources resources, int i10) {
            return resources.openRawResource(i10);
        }
    }

    /* compiled from: DirectResourceLoader.java */
    /* loaded from: classes.dex */
    public interface e<DataT> {
        Class<DataT> a();

        void b(DataT datat);

        DataT c(Resources.Theme theme, Resources resources, int i10);
    }

    public f(Context context, e<DataT> eVar) {
        this.f29947a = context.getApplicationContext();
        this.f29948b = eVar;
    }

    public static p<Integer, AssetFileDescriptor> c(Context context) {
        return new a(context);
    }

    public static p<Integer, Drawable> e(Context context) {
        return new b(context);
    }

    public static p<Integer, InputStream> g(Context context) {
        return new c(context);
    }

    @Override // d3.o
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public o.a<DataT> b(Integer num, int i10, int i11, X2.d dVar) {
        Resources resources;
        Resources.Theme theme = (Resources.Theme) dVar.c(C1096e.f32156b);
        if (theme != null) {
            resources = theme.getResources();
        } else {
            resources = this.f29947a.getResources();
        }
        return new o.a<>(new C1508b(num), new d(theme, resources, this.f29948b, num.intValue()));
    }

    @Override // d3.o
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public boolean a(Integer num) {
        return true;
    }

    /* compiled from: DirectResourceLoader.java */
    /* loaded from: classes.dex */
    public static final class b implements p<Integer, Drawable>, e<Drawable> {

        /* renamed from: a, reason: collision with root package name */
        public final Context f29950a;

        public b(Context context) {
            this.f29950a = context;
        }

        @Override // d3.f.e
        public Class<Drawable> a() {
            return Drawable.class;
        }

        @Override // d3.p
        public o<Integer, Drawable> d(s sVar) {
            return new f(this.f29950a, this);
        }

        @Override // d3.f.e
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public Drawable c(Resources.Theme theme, Resources resources, int i10) {
            return C1093b.a(this.f29950a, i10, theme);
        }

        @Override // d3.f.e
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void b(Drawable drawable) {
        }
    }

    /* compiled from: DirectResourceLoader.java */
    /* loaded from: classes.dex */
    public static final class d<DataT> implements com.bumptech.glide.load.data.d<DataT> {

        /* renamed from: a, reason: collision with root package name */
        public final Resources.Theme f29952a;

        /* renamed from: b, reason: collision with root package name */
        public final Resources f29953b;

        /* renamed from: c, reason: collision with root package name */
        public final e<DataT> f29954c;

        /* renamed from: d, reason: collision with root package name */
        public final int f29955d;

        /* renamed from: e, reason: collision with root package name */
        public DataT f29956e;

        public d(Resources.Theme theme, Resources resources, e<DataT> eVar, int i10) {
            this.f29952a = theme;
            this.f29953b = resources;
            this.f29954c = eVar;
            this.f29955d = i10;
        }

        @Override // com.bumptech.glide.load.data.d
        public Class<DataT> a() {
            return this.f29954c.a();
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
            DataT datat = this.f29956e;
            if (datat != null) {
                try {
                    this.f29954c.b(datat);
                } catch (IOException unused) {
                }
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public DataSource d() {
            return DataSource.LOCAL;
        }

        /* JADX WARN: Type inference failed for: r4v2, types: [DataT, java.lang.Object] */
        @Override // com.bumptech.glide.load.data.d
        public void e(Priority priority, d.a<? super DataT> aVar) {
            try {
                DataT c10 = this.f29954c.c(this.f29952a, this.f29953b, this.f29955d);
                this.f29956e = c10;
                aVar.f(c10);
            } catch (Resources.NotFoundException e10) {
                aVar.c(e10);
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
        }
    }
}
