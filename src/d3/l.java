package d3;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import d3.o;
import java.io.File;
import java.io.FileNotFoundException;
import r3.C1508b;

/* compiled from: MediaStoreFileLoader.java */
/* loaded from: classes.dex */
public final class l implements o<Uri, File> {

    /* renamed from: a, reason: collision with root package name */
    public final Context f29979a;

    /* compiled from: MediaStoreFileLoader.java */
    /* loaded from: classes.dex */
    public static final class a implements p<Uri, File> {

        /* renamed from: a, reason: collision with root package name */
        public final Context f29980a;

        public a(Context context) {
            this.f29980a = context;
        }

        @Override // d3.p
        public o<Uri, File> d(s sVar) {
            return new l(this.f29980a);
        }
    }

    public l(Context context) {
        this.f29979a = context;
    }

    @Override // d3.o
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public o.a<File> b(Uri uri, int i10, int i11, X2.d dVar) {
        return new o.a<>(new C1508b(uri), new b(this.f29979a, uri));
    }

    @Override // d3.o
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri) {
        return Y2.b.c(uri);
    }

    /* compiled from: MediaStoreFileLoader.java */
    /* loaded from: classes.dex */
    public static class b implements com.bumptech.glide.load.data.d<File> {

        /* renamed from: c, reason: collision with root package name */
        public static final String[] f29981c = {"_data"};

        /* renamed from: a, reason: collision with root package name */
        public final Context f29982a;

        /* renamed from: b, reason: collision with root package name */
        public final Uri f29983b;

        public b(Context context, Uri uri) {
            this.f29982a = context;
            this.f29983b = uri;
        }

        @Override // com.bumptech.glide.load.data.d
        public Class<File> a() {
            return File.class;
        }

        @Override // com.bumptech.glide.load.data.d
        public DataSource d() {
            return DataSource.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.d
        public void e(Priority priority, d.a<? super File> aVar) {
            Cursor query = this.f29982a.getContentResolver().query(this.f29983b, f29981c, null, null, null);
            String str = null;
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        str = query.getString(query.getColumnIndexOrThrow("_data"));
                    }
                } finally {
                    query.close();
                }
            }
            if (TextUtils.isEmpty(str)) {
                aVar.c(new FileNotFoundException("Failed to find file path for: " + this.f29983b));
                return;
            }
            aVar.f(new File(str));
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
        }
    }
}
