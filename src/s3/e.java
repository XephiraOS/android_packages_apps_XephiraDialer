package S3;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/* compiled from: ImageResizer.java */
/* loaded from: classes3.dex */
public class e {
    public final int a(BitmapFactory.Options options, int i10, int i11) {
        int i12 = 1;
        if (i10 != 0 && i11 != 0) {
            int i13 = options.outHeight;
            int i14 = options.outWidth;
            H7.b.b("ImageResizer", "origin, w= " + i14 + " h=" + i13);
            if (i13 > i11 || i14 > i10) {
                int i15 = i13 / 2;
                int i16 = i14 / 2;
                while (i15 / i12 >= i11 && i16 / i12 >= i10) {
                    i12 *= 2;
                }
            }
            H7.b.b("ImageResizer", "sampleSize:" + i12);
        }
        return i12;
    }

    public Bitmap b(String str, int i10, int i11) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = a(options, i10, i11);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }
}
