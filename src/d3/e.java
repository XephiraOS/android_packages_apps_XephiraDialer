package d3;

import android.util.Base64;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import d3.o;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import r3.C1508b;

/* compiled from: DataUrlLoader.java */
/* loaded from: classes.dex */
public final class e<Model, Data> implements o<Model, Data> {

    /* renamed from: a, reason: collision with root package name */
    public final a<Data> f29941a;

    /* compiled from: DataUrlLoader.java */
    /* loaded from: classes.dex */
    public interface a<Data> {
        Class<Data> a();

        void b(Data data);

        Data c(String str);
    }

    /* compiled from: DataUrlLoader.java */
    /* loaded from: classes.dex */
    public static final class c<Model> implements p<Model, InputStream> {

        /* renamed from: a, reason: collision with root package name */
        public final a<InputStream> f29945a = new a();

        /* compiled from: DataUrlLoader.java */
        /* loaded from: classes.dex */
        public class a implements a<InputStream> {
            public a() {
            }

            @Override // d3.e.a
            public Class<InputStream> a() {
                return InputStream.class;
            }

            @Override // d3.e.a
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public void b(InputStream inputStream) {
                inputStream.close();
            }

            @Override // d3.e.a
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public InputStream c(String str) {
                if (str.startsWith("data:image")) {
                    int indexOf = str.indexOf(44);
                    if (indexOf != -1) {
                        if (str.substring(0, indexOf).endsWith(";base64")) {
                            return new ByteArrayInputStream(Base64.decode(str.substring(indexOf + 1), 0));
                        }
                        throw new IllegalArgumentException("Not a base64 image data URL.");
                    }
                    throw new IllegalArgumentException("Missing comma in data URL.");
                }
                throw new IllegalArgumentException("Not a valid image data URL.");
            }
        }

        @Override // d3.p
        public o<Model, InputStream> d(s sVar) {
            return new e(this.f29945a);
        }
    }

    public e(a<Data> aVar) {
        this.f29941a = aVar;
    }

    @Override // d3.o
    public boolean a(Model model) {
        return model.toString().startsWith("data:image");
    }

    @Override // d3.o
    public o.a<Data> b(Model model, int i10, int i11, X2.d dVar) {
        return new o.a<>(new C1508b(model), new b(model.toString(), this.f29941a));
    }

    /* compiled from: DataUrlLoader.java */
    /* loaded from: classes.dex */
    public static final class b<Data> implements com.bumptech.glide.load.data.d<Data> {

        /* renamed from: a, reason: collision with root package name */
        public final String f29942a;

        /* renamed from: b, reason: collision with root package name */
        public final a<Data> f29943b;

        /* renamed from: c, reason: collision with root package name */
        public Data f29944c;

        public b(String str, a<Data> aVar) {
            this.f29942a = str;
            this.f29943b = aVar;
        }

        @Override // com.bumptech.glide.load.data.d
        public Class<Data> a() {
            return this.f29943b.a();
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
            try {
                this.f29943b.b(this.f29944c);
            } catch (IOException unused) {
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public DataSource d() {
            return DataSource.LOCAL;
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, Data] */
        @Override // com.bumptech.glide.load.data.d
        public void e(Priority priority, d.a<? super Data> aVar) {
            try {
                Data c10 = this.f29943b.c(this.f29942a);
                this.f29944c = c10;
                aVar.f(c10);
            } catch (IllegalArgumentException e10) {
                aVar.c(e10);
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
        }
    }
}
