package com.bumptech.glide.load;

import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import s3.C1530a;

/* compiled from: ImageHeaderParserUtils.java */
/* loaded from: classes.dex */
public final class a {

    /* compiled from: ImageHeaderParserUtils.java */
    /* renamed from: com.bumptech.glide.load.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0189a implements h {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InputStream f19398a;

        public C0189a(InputStream inputStream) {
            this.f19398a = inputStream;
        }

        @Override // com.bumptech.glide.load.a.h
        public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) {
            try {
                return imageHeaderParser.b(this.f19398a);
            } finally {
                this.f19398a.reset();
            }
        }
    }

    /* compiled from: ImageHeaderParserUtils.java */
    /* loaded from: classes.dex */
    public class b implements h {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ByteBuffer f19399a;

        public b(ByteBuffer byteBuffer) {
            this.f19399a = byteBuffer;
        }

        @Override // com.bumptech.glide.load.a.h
        public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) {
            try {
                return imageHeaderParser.a(this.f19399a);
            } finally {
                C1530a.d(this.f19399a);
            }
        }
    }

    /* compiled from: ImageHeaderParserUtils.java */
    /* loaded from: classes.dex */
    public class c implements h {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ParcelFileDescriptorRewinder f19400a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a3.b f19401b;

        public c(ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, a3.b bVar) {
            this.f19400a = parcelFileDescriptorRewinder;
            this.f19401b = bVar;
        }

        @Override // com.bumptech.glide.load.a.h
        public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) {
            RecyclableBufferedInputStream recyclableBufferedInputStream = null;
            try {
                RecyclableBufferedInputStream recyclableBufferedInputStream2 = new RecyclableBufferedInputStream(new FileInputStream(this.f19400a.a().getFileDescriptor()), this.f19401b);
                try {
                    ImageHeaderParser.ImageType b10 = imageHeaderParser.b(recyclableBufferedInputStream2);
                    recyclableBufferedInputStream2.e();
                    this.f19400a.a();
                    return b10;
                } catch (Throwable th) {
                    th = th;
                    recyclableBufferedInputStream = recyclableBufferedInputStream2;
                    if (recyclableBufferedInputStream != null) {
                        recyclableBufferedInputStream.e();
                    }
                    this.f19400a.a();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* compiled from: ImageHeaderParserUtils.java */
    /* loaded from: classes.dex */
    public class d implements g {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ByteBuffer f19402a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a3.b f19403b;

        public d(ByteBuffer byteBuffer, a3.b bVar) {
            this.f19402a = byteBuffer;
            this.f19403b = bVar;
        }

        @Override // com.bumptech.glide.load.a.g
        public int a(ImageHeaderParser imageHeaderParser) {
            try {
                return imageHeaderParser.c(this.f19402a, this.f19403b);
            } finally {
                C1530a.d(this.f19402a);
            }
        }
    }

    /* compiled from: ImageHeaderParserUtils.java */
    /* loaded from: classes.dex */
    public class e implements g {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InputStream f19404a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a3.b f19405b;

        public e(InputStream inputStream, a3.b bVar) {
            this.f19404a = inputStream;
            this.f19405b = bVar;
        }

        @Override // com.bumptech.glide.load.a.g
        public int a(ImageHeaderParser imageHeaderParser) {
            try {
                return imageHeaderParser.d(this.f19404a, this.f19405b);
            } finally {
                this.f19404a.reset();
            }
        }
    }

    /* compiled from: ImageHeaderParserUtils.java */
    /* loaded from: classes.dex */
    public class f implements g {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ParcelFileDescriptorRewinder f19406a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a3.b f19407b;

        public f(ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, a3.b bVar) {
            this.f19406a = parcelFileDescriptorRewinder;
            this.f19407b = bVar;
        }

        @Override // com.bumptech.glide.load.a.g
        public int a(ImageHeaderParser imageHeaderParser) {
            RecyclableBufferedInputStream recyclableBufferedInputStream = null;
            try {
                RecyclableBufferedInputStream recyclableBufferedInputStream2 = new RecyclableBufferedInputStream(new FileInputStream(this.f19406a.a().getFileDescriptor()), this.f19407b);
                try {
                    int d10 = imageHeaderParser.d(recyclableBufferedInputStream2, this.f19407b);
                    recyclableBufferedInputStream2.e();
                    this.f19406a.a();
                    return d10;
                } catch (Throwable th) {
                    th = th;
                    recyclableBufferedInputStream = recyclableBufferedInputStream2;
                    if (recyclableBufferedInputStream != null) {
                        recyclableBufferedInputStream.e();
                    }
                    this.f19406a.a();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* compiled from: ImageHeaderParserUtils.java */
    /* loaded from: classes.dex */
    public interface g {
        int a(ImageHeaderParser imageHeaderParser);
    }

    /* compiled from: ImageHeaderParserUtils.java */
    /* loaded from: classes.dex */
    public interface h {
        ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser);
    }

    public static int a(List<ImageHeaderParser> list, ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, a3.b bVar) {
        return d(list, new f(parcelFileDescriptorRewinder, bVar));
    }

    public static int b(List<ImageHeaderParser> list, InputStream inputStream, a3.b bVar) {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, bVar);
        }
        inputStream.mark(5242880);
        return d(list, new e(inputStream, bVar));
    }

    public static int c(List<ImageHeaderParser> list, ByteBuffer byteBuffer, a3.b bVar) {
        if (byteBuffer == null) {
            return -1;
        }
        return d(list, new d(byteBuffer, bVar));
    }

    public static int d(List<ImageHeaderParser> list, g gVar) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            int a10 = gVar.a(list.get(i10));
            if (a10 != -1) {
                return a10;
            }
        }
        return -1;
    }

    public static ImageHeaderParser.ImageType e(List<ImageHeaderParser> list, ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, a3.b bVar) {
        return h(list, new c(parcelFileDescriptorRewinder, bVar));
    }

    public static ImageHeaderParser.ImageType f(List<ImageHeaderParser> list, InputStream inputStream, a3.b bVar) {
        if (inputStream == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, bVar);
        }
        inputStream.mark(5242880);
        return h(list, new C0189a(inputStream));
    }

    public static ImageHeaderParser.ImageType g(List<ImageHeaderParser> list, ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        return h(list, new b(byteBuffer));
    }

    public static ImageHeaderParser.ImageType h(List<ImageHeaderParser> list, h hVar) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            ImageHeaderParser.ImageType a10 = hVar.a(list.get(i10));
            if (a10 != ImageHeaderParser.ImageType.UNKNOWN) {
                return a10;
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }
}
