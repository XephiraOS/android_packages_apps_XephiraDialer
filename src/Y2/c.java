package Y2;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.g;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ThumbFetcher.java */
/* loaded from: classes.dex */
public class c implements com.bumptech.glide.load.data.d<InputStream> {

    /* renamed from: a, reason: collision with root package name */
    public final Uri f5526a;

    /* renamed from: b, reason: collision with root package name */
    public final e f5527b;

    /* renamed from: c, reason: collision with root package name */
    public InputStream f5528c;

    /* compiled from: ThumbFetcher.java */
    /* loaded from: classes.dex */
    public static class a implements d {

        /* renamed from: b, reason: collision with root package name */
        public static final String[] f5529b = {"_data"};

        /* renamed from: a, reason: collision with root package name */
        public final ContentResolver f5530a;

        public a(ContentResolver contentResolver) {
            this.f5530a = contentResolver;
        }

        @Override // Y2.d
        public Cursor a(Uri uri) {
            return this.f5530a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, f5529b, "kind = 1 AND image_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    /* compiled from: ThumbFetcher.java */
    /* loaded from: classes.dex */
    public static class b implements d {

        /* renamed from: b, reason: collision with root package name */
        public static final String[] f5531b = {"_data"};

        /* renamed from: a, reason: collision with root package name */
        public final ContentResolver f5532a;

        public b(ContentResolver contentResolver) {
            this.f5532a = contentResolver;
        }

        @Override // Y2.d
        public Cursor a(Uri uri) {
            return this.f5532a.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, f5531b, "kind = 1 AND video_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    public c(Uri uri, e eVar) {
        this.f5526a = uri;
        this.f5527b = eVar;
    }

    public static c c(Context context, Uri uri, d dVar) {
        return new c(uri, new e(com.bumptech.glide.b.c(context).j().g(), dVar, com.bumptech.glide.b.c(context).e(), context.getContentResolver()));
    }

    public static c f(Context context, Uri uri) {
        return c(context, uri, new a(context.getContentResolver()));
    }

    public static c g(Context context, Uri uri) {
        return c(context, uri, new b(context.getContentResolver()));
    }

    @Override // com.bumptech.glide.load.data.d
    public Class<InputStream> a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.d
    public void b() {
        InputStream inputStream = this.f5528c;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public DataSource d() {
        return DataSource.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.d
    public void e(Priority priority, d.a<? super InputStream> aVar) {
        try {
            InputStream h10 = h();
            this.f5528c = h10;
            aVar.f(h10);
        } catch (FileNotFoundException e10) {
            if (Log.isLoggable("MediaStoreThumbFetcher", 3)) {
                Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", e10);
            }
            aVar.c(e10);
        }
    }

    public final InputStream h() {
        int i10;
        InputStream d10 = this.f5527b.d(this.f5526a);
        if (d10 != null) {
            i10 = this.f5527b.a(this.f5526a);
        } else {
            i10 = -1;
        }
        if (i10 != -1) {
            return new g(d10, i10);
        }
        return d10;
    }

    @Override // com.bumptech.glide.load.data.d
    public void cancel() {
    }
}
