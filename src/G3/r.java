package g3;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.ParcelFileDescriptor;

/* compiled from: ParcelFileDescriptorBitmapDecoder.java */
/* loaded from: classes.dex */
public final class r implements X2.e<ParcelFileDescriptor, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    public final com.bumptech.glide.load.resource.bitmap.a f31868a;

    public r(com.bumptech.glide.load.resource.bitmap.a aVar) {
        this.f31868a = aVar;
    }

    @Override // X2.e
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Z2.j<Bitmap> b(ParcelFileDescriptor parcelFileDescriptor, int i10, int i11, X2.d dVar) {
        return this.f31868a.d(parcelFileDescriptor, i10, i11, dVar);
    }

    @Override // X2.e
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(ParcelFileDescriptor parcelFileDescriptor, X2.d dVar) {
        if (e(parcelFileDescriptor) && this.f31868a.o(parcelFileDescriptor)) {
            return true;
        }
        return false;
    }

    public final boolean e(ParcelFileDescriptor parcelFileDescriptor) {
        String str = Build.MANUFACTURER;
        if ((!"HUAWEI".equalsIgnoreCase(str) && !"HONOR".equalsIgnoreCase(str)) || parcelFileDescriptor.getStatSize() <= 536870912) {
            return true;
        }
        return false;
    }
}
