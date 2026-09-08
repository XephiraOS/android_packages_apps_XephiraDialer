package d3;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.android.incallui.OplusPhoneCapabilities;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import d3.o;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import r3.C1508b;

/* compiled from: FileLoader.java */
/* loaded from: classes.dex */
public class g<Data> implements o<File, Data> {

    /* renamed from: a, reason: collision with root package name */
    public final d<Data> f29957a;

    /* compiled from: FileLoader.java */
    /* loaded from: classes.dex */
    public static class a<Data> implements p<File, Data> {

        /* renamed from: a, reason: collision with root package name */
        public final d<Data> f29958a;

        public a(d<Data> dVar) {
            this.f29958a = dVar;
        }

        @Override // d3.p
        public final o<File, Data> d(s sVar) {
            return new g(this.f29958a);
        }
    }

    /* compiled from: FileLoader.java */
    /* loaded from: classes.dex */
    public static class b extends a<ParcelFileDescriptor> {

        /* compiled from: FileLoader.java */
        /* loaded from: classes.dex */
        public class a implements d<ParcelFileDescriptor> {
            @Override // d3.g.d
            public Class<ParcelFileDescriptor> a() {
                return ParcelFileDescriptor.class;
            }

            @Override // d3.g.d
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public void b(ParcelFileDescriptor parcelFileDescriptor) {
                parcelFileDescriptor.close();
            }

            @Override // d3.g.d
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public ParcelFileDescriptor c(File file) {
                return ParcelFileDescriptor.open(file, OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE);
            }
        }

        public b() {
            super(new a());
        }
    }

    /* compiled from: FileLoader.java */
    /* loaded from: classes.dex */
    public interface d<Data> {
        Class<Data> a();

        void b(Data data);

        Data c(File file);
    }

    /* compiled from: FileLoader.java */
    /* loaded from: classes.dex */
    public static class e extends a<InputStream> {

        /* compiled from: FileLoader.java */
        /* loaded from: classes.dex */
        public class a implements d<InputStream> {
            @Override // d3.g.d
            public Class<InputStream> a() {
                return InputStream.class;
            }

            @Override // d3.g.d
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public void b(InputStream inputStream) {
                inputStream.close();
            }

            @Override // d3.g.d
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public InputStream c(File file) {
                return new FileInputStream(file);
            }
        }

        public e() {
            super(new a());
        }
    }

    public g(d<Data> dVar) {
        this.f29957a = dVar;
    }

    @Override // d3.o
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public o.a<Data> b(File file, int i10, int i11, X2.d dVar) {
        return new o.a<>(new C1508b(file), new c(file, this.f29957a));
    }

    @Override // d3.o
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(File file) {
        return true;
    }

    /* compiled from: FileLoader.java */
    /* loaded from: classes.dex */
    public static final class c<Data> implements com.bumptech.glide.load.data.d<Data> {

        /* renamed from: a, reason: collision with root package name */
        public final File f29959a;

        /* renamed from: b, reason: collision with root package name */
        public final d<Data> f29960b;

        /* renamed from: c, reason: collision with root package name */
        public Data f29961c;

        public c(File file, d<Data> dVar) {
            this.f29959a = file;
            this.f29960b = dVar;
        }

        @Override // com.bumptech.glide.load.data.d
        public Class<Data> a() {
            return this.f29960b.a();
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
            Data data = this.f29961c;
            if (data != null) {
                try {
                    this.f29960b.b(data);
                } catch (IOException unused) {
                }
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public DataSource d() {
            return DataSource.LOCAL;
        }

        /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object, Data] */
        @Override // com.bumptech.glide.load.data.d
        public void e(Priority priority, d.a<? super Data> aVar) {
            try {
                Data c10 = this.f29960b.c(this.f29959a);
                this.f29961c = c10;
                aVar.f(c10);
            } catch (FileNotFoundException e10) {
                if (Log.isLoggable("FileLoader", 3)) {
                    Log.d("FileLoader", "Failed to open file", e10);
                }
                aVar.c(e10);
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
        }
    }
}
