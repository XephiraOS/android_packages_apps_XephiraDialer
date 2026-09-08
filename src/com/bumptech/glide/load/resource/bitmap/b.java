package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.data.k;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import s3.C1530a;
import s3.C1540k;

/* compiled from: ImageReader.java */
/* loaded from: classes.dex */
public interface b {

    /* compiled from: ImageReader.java */
    /* renamed from: com.bumptech.glide.load.resource.bitmap.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0194b implements b {

        /* renamed from: a, reason: collision with root package name */
        public final k f19679a;

        /* renamed from: b, reason: collision with root package name */
        public final a3.b f19680b;

        /* renamed from: c, reason: collision with root package name */
        public final List<ImageHeaderParser> f19681c;

        public C0194b(InputStream inputStream, List<ImageHeaderParser> list, a3.b bVar) {
            this.f19680b = (a3.b) C1540k.d(bVar);
            this.f19681c = (List) C1540k.d(list);
            this.f19679a = new k(inputStream, bVar);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.b
        public int a() {
            return com.bumptech.glide.load.a.b(this.f19681c, this.f19679a.a(), this.f19680b);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.b
        public Bitmap b(BitmapFactory.Options options) {
            return BitmapFactory.decodeStream(this.f19679a.a(), null, options);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.b
        public void c() {
            this.f19679a.c();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.b
        public ImageHeaderParser.ImageType d() {
            return com.bumptech.glide.load.a.f(this.f19681c, this.f19679a.a(), this.f19680b);
        }
    }

    int a();

    Bitmap b(BitmapFactory.Options options);

    void c();

    ImageHeaderParser.ImageType d();

    /* compiled from: ImageReader.java */
    /* loaded from: classes.dex */
    public static final class a implements b {

        /* renamed from: a, reason: collision with root package name */
        public final ByteBuffer f19676a;

        /* renamed from: b, reason: collision with root package name */
        public final List<ImageHeaderParser> f19677b;

        /* renamed from: c, reason: collision with root package name */
        public final a3.b f19678c;

        public a(ByteBuffer byteBuffer, List<ImageHeaderParser> list, a3.b bVar) {
            this.f19676a = byteBuffer;
            this.f19677b = list;
            this.f19678c = bVar;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.b
        public int a() {
            return com.bumptech.glide.load.a.c(this.f19677b, C1530a.d(this.f19676a), this.f19678c);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.b
        public Bitmap b(BitmapFactory.Options options) {
            return BitmapFactory.decodeStream(e(), null, options);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.b
        public ImageHeaderParser.ImageType d() {
            return com.bumptech.glide.load.a.g(this.f19677b, C1530a.d(this.f19676a));
        }

        public final InputStream e() {
            return C1530a.g(C1530a.d(this.f19676a));
        }

        @Override // com.bumptech.glide.load.resource.bitmap.b
        public void c() {
        }
    }

    /* compiled from: ImageReader.java */
    /* loaded from: classes.dex */
    public static final class c implements b {

        /* renamed from: a, reason: collision with root package name */
        public final a3.b f19682a;

        /* renamed from: b, reason: collision with root package name */
        public final List<ImageHeaderParser> f19683b;

        /* renamed from: c, reason: collision with root package name */
        public final ParcelFileDescriptorRewinder f19684c;

        public c(ParcelFileDescriptor parcelFileDescriptor, List<ImageHeaderParser> list, a3.b bVar) {
            this.f19682a = (a3.b) C1540k.d(bVar);
            this.f19683b = (List) C1540k.d(list);
            this.f19684c = new ParcelFileDescriptorRewinder(parcelFileDescriptor);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.b
        public int a() {
            return com.bumptech.glide.load.a.a(this.f19683b, this.f19684c, this.f19682a);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.b
        public Bitmap b(BitmapFactory.Options options) {
            return BitmapFactory.decodeFileDescriptor(this.f19684c.a().getFileDescriptor(), null, options);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.b
        public ImageHeaderParser.ImageType d() {
            return com.bumptech.glide.load.a.e(this.f19683b, this.f19684c, this.f19682a);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.b
        public void c() {
        }
    }
}
