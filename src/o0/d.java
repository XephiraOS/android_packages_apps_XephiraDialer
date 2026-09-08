package o0;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.oned.Code128Writer;
import com.oplus.dialer.R;
import com.oplus.foundation.util.display.DisplayUtil;
import kotlin.jvm.internal.i;

/* compiled from: LinearBarCodeUtil.kt */
/* loaded from: classes.dex */
public final class d {
    public static final Bitmap a(String str, int i10, int i11) {
        if (str != null && !i.b("", str) && str.length() >= 1) {
            return b(str, BarcodeFormat.CODE_128, i10, i11);
        }
        return null;
    }

    public static final Bitmap b(String str, BarcodeFormat barcodeFormat, int i10, int i11) {
        S4.b bVar;
        int i12;
        try {
            bVar = new Code128Writer().b(str, barcodeFormat, i10, i11, null);
        } catch (WriterException e10) {
            H7.b.c("LinearBarCodeUtil", e10.getMessage());
            bVar = null;
        }
        if (bVar == null) {
            return null;
        }
        int j10 = bVar.j();
        int g10 = bVar.g();
        int[] iArr = new int[j10 * g10];
        for (int i13 = 0; i13 < g10; i13++) {
            int i14 = i13 * j10;
            for (int i15 = 0; i15 < j10; i15++) {
                int i16 = i14 + i15;
                if (bVar.d(i15, i13)) {
                    i12 = -16777216;
                } else {
                    i12 = -1;
                }
                iArr[i16] = i12;
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(j10, g10, Bitmap.Config.ARGB_8888);
        i.e(createBitmap, "createBitmap(width, heig… Bitmap.Config.ARGB_8888)");
        createBitmap.setPixels(iArr, 0, j10, 0, 0, j10, g10);
        return createBitmap;
    }

    public static final void c(Context context, String str, androidx.appcompat.app.b bVar, int i10, boolean z10) {
        ImageView imageView;
        if (context == null) {
            return;
        }
        if (bVar != null) {
            imageView = (ImageView) bVar.findViewById(i10);
        } else {
            imageView = null;
        }
        if (imageView != null) {
            if (z10) {
                imageView.setVisibility(0);
                imageView.setImageBitmap(a(str, DisplayUtil.f(context, false), context.getResources().getDimensionPixelSize(R.dimen.liner_bar_code_height)));
            } else {
                imageView.setVisibility(8);
            }
        }
    }
}
