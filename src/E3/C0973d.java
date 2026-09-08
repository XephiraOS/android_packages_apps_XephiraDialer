package e3;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import d3.o;
import d3.p;
import d3.s;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import r3.C1508b;

/* compiled from: QMediaStoreUriLoader.java */
/* renamed from: e3.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0973d<DataT> implements o<Uri, DataT> {

    /* renamed from: a, reason: collision with root package name */
    public final Context f30594a;

    /* renamed from: b, reason: collision with root package name */
    public final o<File, DataT> f30595b;

    /* renamed from: c, reason: collision with root package name */
    public final o<Uri, DataT> f30596c;

    /* renamed from: d, reason: collision with root package name */
    public final Class<DataT> f30597d;

    /* compiled from: QMediaStoreUriLoader.java */
    /* renamed from: e3.d$a */
    /* loaded from: classes.dex */
    public static abstract class a<DataT> implements p<Uri, DataT> {

        /* renamed from: a, reason: collision with root package name */
        public final Context f30598a;

        /* renamed from: b, reason: collision with root package name */
        public final Class<DataT> f30599b;

        public a(Context context, Class<DataT> cls) {
            this.f30598a = context;
            this.f30599b = cls;
        }

        @Override // d3.p
        public final o<Uri, DataT> d(s sVar) {
            return new C0973d(this.f30598a, sVar.d(File.class, this.f30599b), sVar.d(Uri.class, this.f30599b), this.f30599b);
        }
    }

    /* compiled from: QMediaStoreUriLoader.java */
    /* renamed from: e3.d$b */
    /* loaded from: classes.dex */
    public static final class b extends a<ParcelFileDescriptor> {
        public b(Context context) {
            super(context, ParcelFileDescriptor.class);
        }
    }

    /* compiled from: QMediaStoreUriLoader.java */
    /* renamed from: e3.d$c */
    /* loaded from: classes.dex */
    public static final class c extends a<InputStream> {
        public c(Context context) {
            super(context, InputStream.class);
        }
    }

    /* compiled from: QMediaStoreUriLoader.java */
    /* renamed from: e3.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0295d<DataT> implements com.bumptech.glide.load.data.d<DataT> {

        /* renamed from: k, reason: collision with root package name */
        public static final String[] f30600k = {"_data"};

        /* renamed from: a, reason: collision with root package name */
        public final Context f30601a;

        /* renamed from: b, reason: collision with root package name */
        public final o<File, DataT> f30602b;

        /* renamed from: c, reason: collision with root package name */
        public final o<Uri, DataT> f30603c;

        /* renamed from: d, reason: collision with root package name */
        public final Uri f30604d;

        /* renamed from: e, reason: collision with root package name */
        public final int f30605e;

        /* renamed from: f, reason: collision with root package name */
        public final int f30606f;

        /* renamed from: g, reason: collision with root package name */
        public final X2.d f30607g;

        /* renamed from: h, reason: collision with root package name */
        public final Class<DataT> f30608h;

        /* renamed from: i, reason: collision with root package name */
        public volatile boolean f30609i;

        /* renamed from: j, reason: collision with root package name */
        public volatile com.bumptech.glide.load.data.d<DataT> f30610j;

        public C0295d(Context context, o<File, DataT> oVar, o<Uri, DataT> oVar2, Uri uri, int i10, int i11, X2.d dVar, Class<DataT> cls) {
            this.f30601a = context.getApplicationContext();
            this.f30602b = oVar;
            this.f30603c = oVar2;
            this.f30604d = uri;
            this.f30605e = i10;
            this.f30606f = i11;
            this.f30607g = dVar;
            this.f30608h = cls;
        }

        @Override // com.bumptech.glide.load.data.d
        public Class<DataT> a() {
            return this.f30608h;
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
            com.bumptech.glide.load.data.d<DataT> dVar = this.f30610j;
            if (dVar != null) {
                dVar.b();
            }
        }

        public final o.a<DataT> c() {
            Uri uri;
            if (Environment.isExternalStorageLegacy()) {
                return this.f30602b.b(h(this.f30604d), this.f30605e, this.f30606f, this.f30607g);
            }
            if (Y2.b.a(this.f30604d)) {
                return this.f30603c.b(this.f30604d, this.f30605e, this.f30606f, this.f30607g);
            }
            if (g()) {
                uri = MediaStore.setRequireOriginal(this.f30604d);
            } else {
                uri = this.f30604d;
            }
            return this.f30603c.b(uri, this.f30605e, this.f30606f, this.f30607g);
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
            this.f30609i = true;
            com.bumptech.glide.load.data.d<DataT> dVar = this.f30610j;
            if (dVar != null) {
                dVar.cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public DataSource d() {
            return DataSource.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.d
        public void e(Priority priority, d.a<? super DataT> aVar) {
            try {
                com.bumptech.glide.load.data.d<DataT> f10 = f();
                if (f10 == null) {
                    aVar.c(new IllegalArgumentException("Failed to build fetcher for: " + this.f30604d));
                    return;
                }
                this.f30610j = f10;
                if (this.f30609i) {
                    cancel();
                } else {
                    f10.e(priority, aVar);
                }
            } catch (FileNotFoundException e10) {
                aVar.c(e10);
            }
        }

        public final com.bumptech.glide.load.data.d<DataT> f() {
            o.a<DataT> c10 = c();
            if (c10 != null) {
                return c10.f29992c;
            }
            return null;
        }

        public final boolean g() {
            if (this.f30601a.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION") == 0) {
                return true;
            }
            return false;
        }

        public final File h(Uri uri) {
            Cursor cursor = null;
            try {
                Cursor query = this.f30601a.getContentResolver().query(uri, f30600k, null, null, null);
                if (query != null && query.moveToFirst()) {
                    String string = query.getString(query.getColumnIndexOrThrow("_data"));
                    if (!TextUtils.isEmpty(string)) {
                        File file = new File(string);
                        query.close();
                        return file;
                    }
                    throw new FileNotFoundException("File path was empty in media store for: " + uri);
                }
                throw new FileNotFoundException("Failed to media store entry for: " + uri);
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
        }
    }

    public C0973d(Context context, o<File, DataT> oVar, o<Uri, DataT> oVar2, Class<DataT> cls) {
        this.f30594a = context.getApplicationContext();
        this.f30595b = oVar;
        this.f30596c = oVar2;
        this.f30597d = cls;
    }

    @Override // d3.o
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public o.a<DataT> b(Uri uri, int i10, int i11, X2.d dVar) {
        return new o.a<>(new C1508b(uri), new C0295d(this.f30594a, this.f30595b, this.f30596c, uri, i10, i11, dVar, this.f30597d));
    }

    @Override // d3.o
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri) {
        return Y2.b.c(uri);
    }
}
