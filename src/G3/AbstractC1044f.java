package g3;

import android.content.Context;
import android.graphics.Bitmap;
import s3.C1541l;

/* compiled from: BitmapTransformation.java */
/* renamed from: g3.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1044f implements X2.g<Bitmap> {
    @Override // X2.g
    public final Z2.j<Bitmap> b(Context context, Z2.j<Bitmap> jVar, int i10, int i11) {
        if (C1541l.t(i10, i11)) {
            a3.d f10 = com.bumptech.glide.b.c(context).f();
            Bitmap bitmap = jVar.get();
            if (i10 == Integer.MIN_VALUE) {
                i10 = bitmap.getWidth();
            }
            if (i11 == Integer.MIN_VALUE) {
                i11 = bitmap.getHeight();
            }
            Bitmap c10 = c(f10, bitmap, i10, i11);
            if (!bitmap.equals(c10)) {
                return C1043e.f(c10, f10);
            }
            return jVar;
        }
        throw new IllegalArgumentException("Cannot apply transformation on width: " + i10 + " or height: " + i11 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }

    public abstract Bitmap c(a3.d dVar, Bitmap bitmap, int i10, int i11);
}
