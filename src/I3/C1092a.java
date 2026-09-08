package i3;

import Z2.j;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.ImageHeaderParser;
import f3.C0997a;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import s3.C1530a;
import s3.C1541l;

/* compiled from: AnimatedImageDecoder.java */
/* renamed from: i3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1092a {

    /* renamed from: a, reason: collision with root package name */
    public final List<ImageHeaderParser> f32149a;

    /* renamed from: b, reason: collision with root package name */
    public final a3.b f32150b;

    /* compiled from: AnimatedImageDecoder.java */
    /* renamed from: i3.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0305a implements j<Drawable> {

        /* renamed from: a, reason: collision with root package name */
        public final AnimatedImageDrawable f32151a;

        public C0305a(AnimatedImageDrawable animatedImageDrawable) {
            this.f32151a = animatedImageDrawable;
        }

        @Override // Z2.j
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AnimatedImageDrawable get() {
            return this.f32151a;
        }

        @Override // Z2.j
        public void b() {
            this.f32151a.stop();
            this.f32151a.clearAnimationCallbacks();
        }

        @Override // Z2.j
        public int c() {
            return this.f32151a.getIntrinsicWidth() * this.f32151a.getIntrinsicHeight() * C1541l.i(Bitmap.Config.ARGB_8888) * 2;
        }

        @Override // Z2.j
        public Class<Drawable> d() {
            return Drawable.class;
        }
    }

    /* compiled from: AnimatedImageDecoder.java */
    /* renamed from: i3.a$b */
    /* loaded from: classes.dex */
    public static final class b implements X2.e<ByteBuffer, Drawable> {

        /* renamed from: a, reason: collision with root package name */
        public final C1092a f32152a;

        public b(C1092a c1092a) {
            this.f32152a = c1092a;
        }

        @Override // X2.e
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public j<Drawable> b(ByteBuffer byteBuffer, int i10, int i11, X2.d dVar) {
            return this.f32152a.b(ImageDecoder.createSource(byteBuffer), i10, i11, dVar);
        }

        @Override // X2.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean a(ByteBuffer byteBuffer, X2.d dVar) {
            return this.f32152a.d(byteBuffer);
        }
    }

    /* compiled from: AnimatedImageDecoder.java */
    /* renamed from: i3.a$c */
    /* loaded from: classes.dex */
    public static final class c implements X2.e<InputStream, Drawable> {

        /* renamed from: a, reason: collision with root package name */
        public final C1092a f32153a;

        public c(C1092a c1092a) {
            this.f32153a = c1092a;
        }

        @Override // X2.e
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public j<Drawable> b(InputStream inputStream, int i10, int i11, X2.d dVar) {
            return this.f32153a.b(ImageDecoder.createSource(C1530a.b(inputStream)), i10, i11, dVar);
        }

        @Override // X2.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean a(InputStream inputStream, X2.d dVar) {
            return this.f32153a.c(inputStream);
        }
    }

    public C1092a(List<ImageHeaderParser> list, a3.b bVar) {
        this.f32149a = list;
        this.f32150b = bVar;
    }

    public static X2.e<ByteBuffer, Drawable> a(List<ImageHeaderParser> list, a3.b bVar) {
        return new b(new C1092a(list, bVar));
    }

    public static X2.e<InputStream, Drawable> f(List<ImageHeaderParser> list, a3.b bVar) {
        return new c(new C1092a(list, bVar));
    }

    public j<Drawable> b(ImageDecoder.Source source, int i10, int i11, X2.d dVar) {
        Drawable decodeDrawable = ImageDecoder.decodeDrawable(source, new C0997a(i10, i11, dVar));
        if (decodeDrawable instanceof AnimatedImageDrawable) {
            return new C0305a((AnimatedImageDrawable) decodeDrawable);
        }
        throw new IOException("Received unexpected drawable type for animated image, failing: " + decodeDrawable);
    }

    public boolean c(InputStream inputStream) {
        return e(com.bumptech.glide.load.a.f(this.f32149a, inputStream, this.f32150b));
    }

    public boolean d(ByteBuffer byteBuffer) {
        return e(com.bumptech.glide.load.a.g(this.f32149a, byteBuffer));
    }

    public final boolean e(ImageHeaderParser.ImageType imageType) {
        if (imageType != ImageHeaderParser.ImageType.ANIMATED_WEBP && imageType != ImageHeaderParser.ImageType.ANIMATED_AVIF) {
            return false;
        }
        return true;
    }
}
