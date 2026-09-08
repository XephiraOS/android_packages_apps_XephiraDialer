package I7;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;
import com.oplus.foundation.util.io.e;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/* compiled from: BitmapUtil.java */
/* loaded from: classes3.dex */
public class a {
    public static byte[] a(Bitmap bitmap, int i10) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bitmap.getWidth() * bitmap.getHeight() * 4);
            Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
            bitmap.compress(compressFormat, 100, byteArrayOutputStream);
            if (byteArrayOutputStream.toByteArray().length > i10) {
                float sqrt = (float) Math.sqrt(i10 / byteArrayOutputStream.toByteArray().length);
                Matrix matrix = new Matrix();
                matrix.setScale(sqrt, sqrt);
                Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                byteArrayOutputStream.reset();
                createBitmap.compress(compressFormat, 100, byteArrayOutputStream);
                Bitmap bitmap2 = createBitmap;
                while (byteArrayOutputStream.toByteArray().length > i10) {
                    matrix.setScale(0.9f, 0.9f);
                    bitmap2 = Bitmap.createBitmap(bitmap2, 0, 0, bitmap2.getWidth(), bitmap2.getHeight(), matrix, true);
                    byteArrayOutputStream.reset();
                    bitmap2.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                }
            }
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e10) {
            Log.e("BitmapUtil", "compressBitmap: exception: " + e10);
            return null;
        }
    }

    public static Bitmap b(byte[] bArr, int i10) {
        BitmapFactory.Options options;
        if (i10 <= 1) {
            options = null;
        } else {
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inSampleSize = i10;
            options = options2;
        }
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
    }

    public static Bitmap c(Drawable drawable, int i10) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        Bitmap createBitmap = Bitmap.createBitmap(i10, i10, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    public static int d(int i10, int i11) {
        if (i11 < 1 || i10 < 1) {
            return 1;
        }
        int i12 = 1;
        while (true) {
            i10 >>= 1;
            if (i10 >= i11 * 0.8f) {
                i12 <<= 1;
            } else {
                return i12;
            }
        }
    }

    public static Bitmap e(Context context, Uri uri) {
        InputStream openInputStream = context.getContentResolver().openInputStream(uri);
        try {
            return BitmapFactory.decodeStream(openInputStream);
        } finally {
            e.b(openInputStream);
        }
    }

    public static int f(byte[] bArr) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        return Math.min(options.outWidth, options.outHeight);
    }
}
