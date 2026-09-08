package S3;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.io.OutputStream;
import java.util.HashMap;

/* compiled from: QrCodeGenerator.java */
/* loaded from: classes3.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    public static RectF f3469a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Bitmap a(android.content.Context r7, java.lang.String r8, int r9, int r10) {
        /*
            java.lang.String r0 = "qr_code"
            java.lang.String r1 = "outputStream close failed: "
            boolean r2 = android.text.TextUtils.isEmpty(r8)
            java.lang.String r3 = "QrCodeGenerator"
            r4 = 0
            if (r2 == 0) goto L13
            java.lang.String r7 = "createQRImage, content is null, create failed!"
            H7.b.c(r3, r7)
            return r4
        L13:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "createQRImage: size = "
            r2.append(r5)
            r2.append(r9)
            java.lang.String r2 = r2.toString()
            H7.b.b(r3, r2)
            r2 = 0
            java.lang.String r5 = ""
            java.io.File r5 = r7.getDir(r5, r2)     // Catch: java.lang.Throwable -> L45 java.io.IOException -> L47
            java.io.File r6 = new java.io.File     // Catch: java.lang.Throwable -> L45 java.io.IOException -> L47
            r6.<init>(r5, r0)     // Catch: java.lang.Throwable -> L45 java.io.IOException -> L47
            boolean r5 = r6.exists()     // Catch: java.lang.Throwable -> L45 java.io.IOException -> L47
            if (r5 == 0) goto L49
            boolean r5 = r6.delete()     // Catch: java.lang.Throwable -> L45 java.io.IOException -> L47
            if (r5 != 0) goto L49
            java.lang.String r5 = "createQRImage, img.delete failed!"
            H7.b.c(r3, r5)     // Catch: java.lang.Throwable -> L45 java.io.IOException -> L47
            goto L49
        L45:
            r7 = move-exception
            goto La0
        L47:
            r7 = r4
            goto L74
        L49:
            java.io.FileOutputStream r7 = r7.openFileOutput(r0, r2)     // Catch: java.lang.Throwable -> L45 java.io.IOException -> L47
            android.graphics.Bitmap r8 = b(r8, r9, r9, r7, r10)     // Catch: java.lang.Throwable -> L70 java.io.IOException -> L74
            if (r7 == 0) goto L6e
            r7.close()     // Catch: java.lang.Exception -> L57
            goto L6e
        L57:
            r7 = move-exception
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r1)
            java.lang.String r7 = r7.getMessage()
            r9.append(r7)
            java.lang.String r7 = r9.toString()
            H7.b.b(r3, r7)
        L6e:
            r2 = 1
            goto L97
        L70:
            r8 = move-exception
            r4 = r7
            r7 = r8
            goto La0
        L74:
            java.lang.String r8 = "open file failed."
            H7.b.b(r3, r8)     // Catch: java.lang.Throwable -> L70
            if (r7 == 0) goto L96
            r7.close()     // Catch: java.lang.Exception -> L7f
            goto L96
        L7f:
            r7 = move-exception
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r1)
            java.lang.String r7 = r7.getMessage()
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            H7.b.b(r3, r7)
        L96:
            r8 = r4
        L97:
            if (r2 != 0) goto L9f
            java.lang.String r7 = "createQRImage, create QR image failed"
            H7.b.c(r3, r7)
            return r4
        L9f:
            return r8
        La0:
            if (r4 == 0) goto Lbd
            r4.close()     // Catch: java.lang.Exception -> La6
            goto Lbd
        La6:
            r8 = move-exception
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r1)
            java.lang.String r8 = r8.getMessage()
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            H7.b.b(r3, r8)
        Lbd:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: S3.l.a(android.content.Context, java.lang.String, int, int):android.graphics.Bitmap");
    }

    public static Bitmap b(String str, int i10, int i11, OutputStream outputStream, int i12) {
        if (str != null) {
            try {
                if (!"".equals(str)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");
                    hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.Q);
                    hashMap.put(EncodeHintType.MARGIN, 0);
                    k kVar = new k();
                    S4.b a10 = kVar.a(str, BarcodeFormat.QR_CODE, i10, i11, hashMap);
                    int j10 = a10.j();
                    int g10 = a10.g();
                    int[] iArr = new int[j10 * g10];
                    for (int i13 = 0; i13 < g10; i13++) {
                        for (int i14 = 0; i14 < j10; i14++) {
                            if (a10.d(i14, i13)) {
                                iArr[(i13 * j10) + i14] = i12;
                            } else {
                                iArr[(i13 * j10) + i14] = -1;
                            }
                        }
                    }
                    Bitmap createBitmap = Bitmap.createBitmap(j10, g10, Bitmap.Config.ARGB_8888);
                    if (createBitmap != null) {
                        createBitmap.setPixels(iArr, 0, j10, 0, 0, j10, g10);
                        createBitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
                    }
                    return c(createBitmap, kVar.b(), 3, i12);
                }
            } catch (WriterException e10) {
                H7.b.b("QrCodeGenerator", "createQRImage WriterException: " + e10.getMessage());
            }
        }
        return null;
    }

    public static Bitmap c(Bitmap bitmap, int i10, int i11, int i12) {
        int width;
        int i13;
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 != 3) {
                    return null;
                }
                i13 = 0;
            } else {
                i13 = bitmap.getWidth() - (i10 * 7);
            }
            width = 0;
        } else {
            width = bitmap.getWidth() - (i10 * 7);
            i13 = 0;
        }
        int i14 = i10 * 7;
        int i15 = i13 + i14;
        int i16 = i14 + width;
        int i17 = i13 + i10;
        int i18 = width + i10;
        int i19 = i10 * 5;
        int i20 = i17 + i19;
        int i21 = i19 + i18;
        int i22 = i10 * 2;
        int i23 = i13 + i22;
        int i24 = i22 + width;
        int i25 = i10 * 3;
        int i26 = i23 + i25;
        int i27 = i24 + i25;
        float f10 = i10;
        int i28 = (int) (f10 * 2.3100002f);
        int i29 = i28 * 2;
        int i30 = (int) (f10 * 1.4499999f);
        int i31 = i30 * 2;
        int i32 = (int) (f10 * 0.6f);
        int i33 = i32 * 2;
        int i34 = i13;
        while (i34 < i15) {
            int i35 = i24;
            for (int i36 = width; i36 < i16; i36++) {
                bitmap.setPixel(i34, i36, -1);
            }
            i34++;
            i24 = i35;
        }
        int i37 = i24;
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        Path path = new Path();
        paint.setColor(i12);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        float f11 = i13;
        float f12 = width + i28;
        path.moveTo(f11, f12);
        int i38 = i13 + i29;
        int i39 = width + i29;
        path.arcTo(d(i13, width, i38, i39), 180.0f, 90.0f, false);
        path.lineTo(i15 - i28, width);
        int i40 = i15 - i29;
        path.arcTo(d(i40, width, i15, i39), 270.0f, 90.0f, false);
        path.lineTo(i15, i16 - i28);
        int i41 = i16 - i29;
        path.arcTo(d(i40, i41, i15, i16), 0.0f, 90.0f, false);
        path.lineTo(i28 + i13, i16);
        path.arcTo(d(i13, i41, i38, i16), 90.0f, 90.0f, false);
        path.lineTo(f11, f12);
        path.close();
        canvas.drawPath(path, paint);
        paint.setColor(-1);
        path.reset();
        float f13 = i17;
        float f14 = i18 + i30;
        path.moveTo(f13, f14);
        int i42 = i17 + i31;
        int i43 = i18 + i31;
        path.arcTo(d(i17, i18, i42, i43), 180.0f, 90.0f, false);
        path.lineTo(i20 - i30, i18);
        int i44 = i20 - i31;
        path.arcTo(d(i44, i18, i20, i43), 270.0f, 90.0f, false);
        path.lineTo(i20, i21 - i30);
        int i45 = i21 - i31;
        path.arcTo(d(i44, i45, i20, i21), 0.0f, 90.0f, false);
        path.lineTo(i17 + i30, i21);
        path.arcTo(d(i17, i45, i42, i21), 90.0f, 90.0f, false);
        path.lineTo(f13, f14);
        path.close();
        canvas.drawPath(path, paint);
        paint.setColor(i12);
        path.reset();
        float f15 = i23;
        float f16 = i37 + i32;
        path.moveTo(f15, f16);
        int i46 = i23 + i33;
        int i47 = i37 + i33;
        path.arcTo(d(i23, i37, i46, i47), 180.0f, 90.0f, false);
        path.lineTo(i26 - i32, i37);
        int i48 = i26 - i33;
        path.arcTo(d(i48, i37, i26, i47), 270.0f, 90.0f, false);
        path.lineTo(i26, i27 - i32);
        int i49 = i27 - i33;
        path.arcTo(d(i48, i49, i26, i27), 0.0f, 90.0f, false);
        path.lineTo(i23 + i32, i27);
        path.arcTo(d(i23, i49, i46, i27), 90.0f, 90.0f, false);
        path.lineTo(f15, f16);
        path.close();
        canvas.drawPath(path, paint);
        int i50 = i11 - 1;
        if (i50 > 0 && i50 < 3) {
            return c(bitmap, i10, i50, i12);
        }
        return bitmap;
    }

    public static RectF d(int i10, int i11, int i12, int i13) {
        if (f3469a == null) {
            f3469a = new RectF();
        }
        RectF rectF = f3469a;
        rectF.left = i10;
        rectF.right = i12;
        rectF.top = i11;
        rectF.bottom = i13;
        return rectF;
    }
}
