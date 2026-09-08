package F3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import android.text.TextUtils;
import android.view.MotionEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* compiled from: CameraUtils.java */
/* loaded from: classes3.dex */
public class b {
    public static int a(int i10, int i11, int i12) {
        if (i10 > i12) {
            return i12;
        }
        if (i10 < i11) {
            return i11;
        }
        return i10;
    }

    public static Point b(Camera.Parameters parameters, Point point, int i10, int i11) {
        boolean z10;
        int i12;
        List<Camera.Size> supportedPictureSizes = parameters.getSupportedPictureSizes();
        if (supportedPictureSizes == null) {
            H7.b.i("CameraUtils", "Device returned no supported picture sizes; using default");
            Camera.Size pictureSize = parameters.getPictureSize();
            if (pictureSize != null) {
                return new Point(pictureSize.width, pictureSize.height);
            }
            throw new IllegalStateException("Parameters contained no picture size!");
        }
        if (H7.a.b()) {
            StringBuilder sb = new StringBuilder();
            for (Camera.Size size : supportedPictureSizes) {
                sb.append(size.width);
                sb.append('x');
                sb.append(size.height);
                sb.append(' ');
            }
            H7.b.b("CameraUtils", "Supported picture sizes: " + ((Object) sb));
        }
        double f10 = f(i10, i11);
        Iterator<Camera.Size> it = supportedPictureSizes.iterator();
        while (it.hasNext()) {
            Camera.Size next = it.next();
            int i13 = next.width;
            int i14 = next.height;
            if (i13 * i14 < 153600) {
                it.remove();
            } else {
                if (i13 < i14) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    i12 = i13;
                } else {
                    i12 = i14;
                }
                if (z10) {
                    i13 = i14;
                }
                if (Math.abs((i13 / i12) - f10) > 0.01d) {
                    it.remove();
                }
            }
        }
        int i15 = point.x * point.y;
        if (!supportedPictureSizes.isEmpty()) {
            int i16 = Integer.MAX_VALUE;
            Camera.Size size2 = null;
            for (Camera.Size size3 : supportedPictureSizes) {
                int abs = Math.abs((size3.width * size3.height) - i15);
                if (abs < i16) {
                    size2 = size3;
                    i16 = abs;
                }
            }
            if (size2 != null) {
                Point point2 = new Point(size2.width, size2.height);
                if (H7.a.b()) {
                    H7.b.e("CameraUtils", "Using maybe suitable picture size: " + point2);
                }
                return point2;
            }
        }
        Camera.Size pictureSize2 = parameters.getPictureSize();
        if (pictureSize2 != null) {
            Point point3 = new Point(pictureSize2.width, pictureSize2.height);
            H7.b.e("CameraUtils", "No suitable picture sizes, using default: " + point3);
            return point3;
        }
        throw new IllegalStateException("Parameters contained no picture size!");
    }

    public static Point c(Camera.Parameters parameters, Point point) {
        boolean z10;
        int i10;
        int i11;
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedPreviewSizes == null) {
            H7.b.i("CameraUtils", "Device returned no supported preview sizes; using default");
            Camera.Size previewSize = parameters.getPreviewSize();
            if (previewSize != null) {
                return new Point(previewSize.width, previewSize.height);
            }
            throw new IllegalStateException("Parameters contained no preview size!");
        }
        ArrayList<Camera.Size> arrayList = new ArrayList(supportedPreviewSizes);
        if (H7.a.b()) {
            StringBuilder sb = new StringBuilder();
            for (Camera.Size size : arrayList) {
                sb.append(size.width);
                sb.append('x');
                sb.append(size.height);
                sb.append(' ');
            }
            H7.b.e("CameraUtils", "Supported preview sizes: " + ((Object) sb));
        }
        double d10 = point.x / point.y;
        if (H7.a.b()) {
            H7.b.e("CameraUtils", "screenAspectRatio: " + d10);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Camera.Size size2 = (Camera.Size) it.next();
            int i12 = size2.width;
            int i13 = size2.height;
            if (i12 * i13 < 153600) {
                it.remove();
            } else {
                if (i12 > i13) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    i10 = i13;
                } else {
                    i10 = i12;
                }
                if (z10) {
                    i11 = i12;
                } else {
                    i11 = i13;
                }
                if (i10 == point.x && i11 == point.y) {
                    Point point2 = new Point(i12, i13);
                    H7.b.e("CameraUtils", "Found preview size exactly matching screen size: " + point2);
                    return point2;
                }
            }
        }
        if (!arrayList.isEmpty()) {
            int max = Math.max(point.x, point.y);
            int min = Math.min(point.x, point.y);
            int i14 = Integer.MAX_VALUE;
            Camera.Size size3 = null;
            for (Camera.Size size4 : arrayList) {
                int max2 = Math.max(size4.width, size4.height);
                int min2 = Math.min(size4.width, size4.height);
                int abs = Math.abs(max - max2);
                int abs2 = Math.abs(min - min2);
                int i15 = (abs * abs) + (abs2 * abs2);
                if (i15 < i14) {
                    size3 = size4;
                    i14 = i15;
                }
            }
            if (size3 != null) {
                Point point3 = new Point(size3.width, size3.height);
                if (H7.a.b()) {
                    H7.b.e("CameraUtils", "Using maybe suitable preview size: " + point3);
                }
                return point3;
            }
        }
        Camera.Size previewSize2 = parameters.getPreviewSize();
        if (previewSize2 != null) {
            Point point4 = new Point(previewSize2.width, previewSize2.height);
            H7.b.e("CameraUtils", "No suitable preview sizes, using default: " + point4);
            return point4;
        }
        throw new IllegalStateException("Parameters contained no preview size!");
    }

    public static String d() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static float e(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() <= 1) {
            return 0.0f;
        }
        float x10 = motionEvent.getX(0) - motionEvent.getX(1);
        float y10 = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x10 * x10) + (y10 * y10));
    }

    public static double f(int i10, int i11) {
        double d10 = i10 / i11;
        if (Math.abs(d10 - 2.111111111111111d) < 0.01d) {
            return 2.111111111111111d;
        }
        if (Math.abs(d10 - 2.0d) < 0.01d) {
            return 2.0d;
        }
        return 1.7777777777777777d;
    }

    public static void g(Matrix matrix, boolean z10, int i10, int i11, int i12) {
        float f10;
        if (z10) {
            f10 = -1.0f;
        } else {
            f10 = 1.0f;
        }
        matrix.setScale(f10, 1.0f);
        matrix.postRotate(i10);
        float f11 = i11;
        float f12 = i12;
        matrix.postScale(((f11 * 1.0f) / 1000.0f) * 2.0f, ((1.0f * f12) / 1000.0f) * 2.0f);
        matrix.postTranslate(f11 / 2.0f, f12 / 2.0f);
    }

    public static void h(RectF rectF, Rect rect) {
        rect.left = Math.round(rectF.left);
        rect.top = Math.round(rectF.top);
        rect.right = Math.round(rectF.right);
        rect.bottom = Math.round(rectF.bottom);
    }

    public static String i(Context context, byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (bArr == null) {
            return null;
        }
        String b10 = f.g(context.getApplicationContext()).b(d() + ".jpg");
        if (TextUtils.isEmpty(b10)) {
            return null;
        }
        File file = new File(b10);
        if (file.exists() && !file.delete()) {
            H7.b.i("CameraUtils", "savePicture delete fail");
        }
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        try {
            try {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (Exception e10) {
                    e = e10;
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception unused) {
        }
        try {
            File file2 = new File(b10);
            if (decodeByteArray != null && !decodeByteArray.isRecycled()) {
                decodeByteArray.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            }
            try {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
                    try {
                        fileOutputStream.write(byteArrayOutputStream.toByteArray());
                        fileOutputStream.close();
                        byteArrayOutputStream.close();
                    } catch (Throwable th2) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                        throw th2;
                    }
                } catch (IOException unused2) {
                    byteArrayOutputStream.close();
                    return null;
                }
            } catch (Exception unused3) {
                return null;
            }
        } catch (Exception e11) {
            e = e11;
            byteArrayOutputStream2 = byteArrayOutputStream;
            H7.b.e("CameraUtils", e.toString());
            if (byteArrayOutputStream2 != null) {
                byteArrayOutputStream2.close();
            }
            return b10;
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream2 = byteArrayOutputStream;
            if (byteArrayOutputStream2 != null) {
                try {
                    byteArrayOutputStream2.close();
                } catch (Exception unused4) {
                }
            }
            throw th;
        }
        return b10;
    }
}
