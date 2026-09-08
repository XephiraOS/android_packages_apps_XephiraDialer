package f3;

import X2.d;
import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.util.Log;
import android.util.Size;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import g3.o;

/* compiled from: DefaultOnHeaderDecodedListener.java */
/* renamed from: f3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0997a implements ImageDecoder.OnHeaderDecodedListener {

    /* renamed from: a, reason: collision with root package name */
    public final o f31692a = o.b();

    /* renamed from: b, reason: collision with root package name */
    public final int f31693b;

    /* renamed from: c, reason: collision with root package name */
    public final int f31694c;

    /* renamed from: d, reason: collision with root package name */
    public final DecodeFormat f31695d;

    /* renamed from: e, reason: collision with root package name */
    public final DownsampleStrategy f31696e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f31697f;

    /* renamed from: g, reason: collision with root package name */
    public final PreferredColorSpace f31698g;

    /* compiled from: DefaultOnHeaderDecodedListener.java */
    /* renamed from: f3.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0298a implements ImageDecoder.OnPartialImageListener {
        public C0298a() {
        }

        @Override // android.graphics.ImageDecoder.OnPartialImageListener
        public boolean onPartialImage(ImageDecoder.DecodeException decodeException) {
            return false;
        }
    }

    public C0997a(int i10, int i11, d dVar) {
        boolean z10;
        this.f31693b = i10;
        this.f31694c = i11;
        this.f31695d = (DecodeFormat) dVar.c(com.bumptech.glide.load.resource.bitmap.a.f19662f);
        this.f31696e = (DownsampleStrategy) dVar.c(DownsampleStrategy.f19640h);
        X2.c<Boolean> cVar = com.bumptech.glide.load.resource.bitmap.a.f19666j;
        if (dVar.c(cVar) != null && ((Boolean) dVar.c(cVar)).booleanValue()) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f31697f = z10;
        this.f31698g = (PreferredColorSpace) dVar.c(com.bumptech.glide.load.resource.bitmap.a.f19663g);
    }

    @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
    public void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        ColorSpace.Named named;
        if (this.f31692a.f(this.f31693b, this.f31694c, this.f31697f, false)) {
            imageDecoder.setAllocator(3);
        } else {
            imageDecoder.setAllocator(1);
        }
        if (this.f31695d == DecodeFormat.PREFER_RGB_565) {
            imageDecoder.setMemorySizePolicy(0);
        }
        imageDecoder.setOnPartialImageListener(new C0298a());
        Size size = imageInfo.getSize();
        int i10 = this.f31693b;
        if (i10 == Integer.MIN_VALUE) {
            i10 = size.getWidth();
        }
        int i11 = this.f31694c;
        if (i11 == Integer.MIN_VALUE) {
            i11 = size.getHeight();
        }
        float b10 = this.f31696e.b(size.getWidth(), size.getHeight(), i10, i11);
        int round = Math.round(size.getWidth() * b10);
        int round2 = Math.round(size.getHeight() * b10);
        if (Log.isLoggable("ImageDecoder", 2)) {
            Log.v("ImageDecoder", "Resizing from [" + size.getWidth() + "x" + size.getHeight() + "] to [" + round + "x" + round2 + "] scaleFactor: " + b10);
        }
        imageDecoder.setTargetSize(round, round2);
        PreferredColorSpace preferredColorSpace = this.f31698g;
        if (preferredColorSpace != null) {
            if (preferredColorSpace == PreferredColorSpace.DISPLAY_P3 && imageInfo.getColorSpace() != null && imageInfo.getColorSpace().isWideGamut()) {
                named = ColorSpace.Named.DISPLAY_P3;
            } else {
                named = ColorSpace.Named.SRGB;
            }
            imageDecoder.setTargetColorSpace(ColorSpace.get(named));
        }
    }
}
