package com.oua.opencv;

import android.graphics.Bitmap;
import com.android.incallui.OplusPhoneUtils;
import com.heytap.accessory.constant.FastPairConstants;
import com.oua.opencv.OpenCVUtil;
import com.oua.util.BufferUtil;
import com.oua.util.DebugConfig;
import com.oua.util.SimpleTrace;
import com.oua.util.StringUtil;
import com.oua.util.Transform;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.IntToDoubleFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.opencv.android.Utils;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.RotatedRect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

/* loaded from: classes4.dex */
public class OpenCVUtil {
    private static final String TAG = "com.oua.opencv.OpenCVUtil";

    public static ByteBuffer addAll(ByteBuffer byteBuffer, Mat mat) {
        int depth = CvType.depth(mat.type());
        if (depth != 0) {
            if (depth != 2 && depth != 3) {
                if (depth != 4) {
                    if (depth == 5) {
                        BufferUtil.addFloat(byteBuffer, (float[]) toArray(mat));
                    } else {
                        throw new UnsupportedOperationException("Unknown Mat data type" + mat.type());
                    }
                } else {
                    byteBuffer.asIntBuffer().put(toIntArray(mat));
                }
            } else {
                byteBuffer.asShortBuffer().put(toShortArray(mat));
            }
        } else {
            BufferUtil.addByte(byteBuffer, (byte[]) toArray(mat));
        }
        if (CvType.depth(mat.type()) != 0) {
            byteBuffer.position(byteBuffer.position() + ((int) (mat.total() * mat.elemSize())));
        }
        return byteBuffer;
    }

    public static Mat cc_createLablesMap(final Mat mat, int i10) {
        final Mat zeros = Mat.zeros(mat.size(), CvType.CV_8UC3);
        final int i11 = OplusPhoneUtils.FLAG_RECEIVER_INCLUDE_BACKGROUND / i10;
        indexStream(mat).forEach(new Consumer() { // from class: W8.n
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                OpenCVUtil.lambda$cc_createLablesMap$7(Mat.this, i11, zeros, (int[]) obj);
            }
        });
        return zeros;
    }

    public static Mat cc_createStatsMap(Mat mat, Size size, Mat mat2) {
        if (mat2 == null) {
            mat2 = Mat.zeros(size, CvType.CV_8UC3);
        }
        cc_drawStats(mat, mat2);
        return mat2;
    }

    public static void cc_drawStats(final Mat mat, final Mat mat2) {
        final Scalar scalar = new Scalar(255.0d, 0.0d, 0.0d);
        IntStream.range(0, mat.rows()).mapToObj(new IntFunction() { // from class: W8.q
            @Override // java.util.function.IntFunction
            public final Object apply(int i10) {
                Rect cc_getStatRect;
                cc_getStatRect = OpenCVUtil.cc_getStatRect(Mat.this, i10);
                return cc_getStatRect;
            }
        }).forEach(new Consumer() { // from class: W8.r
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                Imgproc.rectangle(Mat.this, (Rect) obj, scalar);
            }
        });
    }

    public static Stream<int[]> cc_getIndexStreamForLable(final Mat mat, final int i10) {
        return indexStream(mat).filter(new Predicate() { // from class: W8.s
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean lambda$cc_getIndexStreamForLable$10;
                lambda$cc_getIndexStreamForLable$10 = OpenCVUtil.lambda$cc_getIndexStreamForLable$10(Mat.this, i10, (int[]) obj);
                return lambda$cc_getIndexStreamForLable$10;
            }
        });
    }

    public static Rect cc_getStatRect(Mat mat, int i10) {
        return new Rect((int) mat.get(i10, 0)[0], (int) mat.get(i10, 1)[0], (int) mat.get(i10, 2)[0], (int) mat.get(i10, 3)[0]);
    }

    public static List<List<Mat>> createBatchMats(final List<Mat> list, final int i10) {
        return (List) IntStream.range(0, ((list.size() + i10) - 1) / i10).mapToObj(new IntFunction() { // from class: W8.p
            @Override // java.util.function.IntFunction
            public final Object apply(int i11) {
                List lambda$createBatchMats$13;
                lambda$createBatchMats$13 = OpenCVUtil.lambda$createBatchMats$13(i10, list, i11);
                return lambda$createBatchMats$13;
            }
        }).collect(Collectors.toList());
    }

    public static void cropResizeRotatePad(Mat mat, Mat mat2, Rect rect, Size size, Transform.PaddingOption paddingOption, int i10, Transform.TransformGroup transformGroup) {
        Transform.TransformGroup transformGroup2;
        Mat mat3;
        SimpleTrace.getTrace().startSection("cropResizeRotatePad", TAG);
        List<Transform> createTransforms = Transform.createTransforms(new android.util.Size(mat.cols(), mat.rows()), toAndroidRect(rect), toAndroidSize(size), paddingOption, i10);
        if (transformGroup == null) {
            transformGroup2 = new Transform.TransformGroup();
        } else {
            transformGroup2 = transformGroup;
        }
        transformGroup2.transforms = (List) createTransforms.stream().filter(new Predicate() { // from class: W8.j
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean lambda$cropResizeRotatePad$3;
                lambda$cropResizeRotatePad$3 = OpenCVUtil.lambda$cropResizeRotatePad$3((Transform) obj);
                return lambda$cropResizeRotatePad$3;
            }
        }).collect(Collectors.toList());
        Transform.TransformCrop transformCrop = (Transform.TransformCrop) createTransforms.get(0);
        if (transformCrop != null) {
            mat3 = mat.submat(toOpenCVRect(transformCrop.srcRect));
            SimpleTrace.getTrace().addEvent("crop");
        } else {
            mat3 = mat;
        }
        Transform transform = createTransforms.get(1);
        if (transform != null) {
            Imgproc.resize(mat3, mat2, toOpenCVSize(transform.getDstSize()));
        }
        if (i10 != 0) {
            Core.rotate(mat2, mat2, toOpencvRotate(i10));
        }
        Transform transform2 = createTransforms.get(3);
        if (transform2 != null) {
            android.graphics.Rect calcValidRect = transform2.calcValidRect();
            Core.copyMakeBorder(mat2, mat2, calcValidRect.top, (int) (size.height - calcValidRect.bottom), calcValidRect.left, (int) (size.width - calcValidRect.right), 0, new Scalar(0.0d));
        }
        SimpleTrace.getTrace().endSection("cropResizeRotatePad");
    }

    public static void drawBBoxes(Mat mat, List<List<Point>> list, Scalar scalar, int i10) {
        Imgproc.polylines(mat, (List) list.stream().map(new Function() { // from class: W8.o
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                MatOfPoint matOfPoint;
                matOfPoint = OpenCVUtil.toMatOfPoint((List) obj);
                return matOfPoint;
            }
        }).collect(Collectors.toList()), true, scalar, i10);
    }

    public static Mat floatArrToMat(float[] fArr) {
        Mat mat = new Mat(fArr.length, 1, CvType.CV_32FC1);
        mat.put(0, 0, fArr);
        return mat;
    }

    public static List<Point> getBoundingBox(Mat mat) {
        return getBoundingBox(toPoints(mat));
    }

    public static List<double[]> getColorSample(Mat mat, List<Rect> list, final int i10) {
        final int cols = mat.cols();
        final int channels = mat.channels();
        final byte[] bArr = (byte[]) toArray(mat);
        return (List) list.stream().flatMap(new Function() { // from class: W8.m
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Stream lambda$getColorSample$11;
                lambda$getColorSample$11 = OpenCVUtil.lambda$getColorSample$11(bArr, cols, channels, i10, (Rect) obj);
                return lambda$getColorSample$11;
            }
        }).collect(Collectors.toList());
    }

    public static Stream<int[]> indexStream(final Mat mat) {
        return IntStream.range(0, (int) mat.total()).mapToObj(new IntFunction() { // from class: W8.g
            @Override // java.util.function.IntFunction
            public final Object apply(int i10) {
                int[] lambda$indexStream$0;
                lambda$indexStream$0 = OpenCVUtil.lambda$indexStream$0(Mat.this, i10);
                return lambda$indexStream$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$cc_createLablesMap$7(Mat mat, int i10, Mat mat2, int[] iArr) {
        int i11 = (int) mat.get(iArr)[0];
        byte[] bArr = {-1, -1, -1};
        if (i11 != 0) {
            int i12 = i11 * i10;
            bArr = new byte[]{(byte) (i12 >> 16), (byte) ((65280 & i12) >> 8), (byte) (i12 & 255)};
        }
        mat2.put(iArr, bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$cc_getIndexStreamForLable$10(Mat mat, int i10, int[] iArr) {
        if (mat.get(iArr)[0] != i10) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$createBatchMats$13(int i10, List list, int i11) {
        int i12 = i11 * i10;
        int i13 = i12 + i10;
        if (i13 <= list.size()) {
            return list.subList(i12, i13);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list.subList(i12, list.size()));
        for (int size = arrayList.size(); size < i10; size++) {
            arrayList.add(Mat.zeros(((Mat) list.get(0)).size(), ((Mat) list.get(0)).type()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$cropResizeRotatePad$3(Transform transform) {
        if (transform != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Point lambda$getBoundingBox$6(List list, int i10, int i11) {
        return (Point) list.get((i11 + i10) % list.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Stream lambda$getColorSample$11(byte[] bArr, int i10, int i11, int i12, Rect rect) {
        return Arrays.stream(getColorSample(bArr, i10, i11, rect, i12));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ double lambda$getColorSample$12(byte[] bArr, int i10) {
        return bArr[i10] & FastPairConstants.GO_INTENT_NOT_SET;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int[] lambda$indexStream$0(Mat mat, int i10) {
        return new int[]{i10 / mat.cols(), i10 % mat.cols()};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Point lambda$toListOfPoint$1(Mat mat, int i10) {
        return new Point(mat.get(i10, 0)[0], mat.get(i10, 1)[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$toPoints$4(byte[] bArr, int i10, int[] iArr) {
        if (bArr[(iArr[0] * i10) + iArr[1]] == 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Point lambda$toPoints$5(int[] iArr) {
        return new Point(iArr[1], iArr[0]);
    }

    public static void logAndSave(String str, String str2, Mat mat) {
        String str3;
        DebugConfig.logd(str, String.format("%s: %s %d", str2, mat.toString(), Long.valueOf(mat.total())));
        if (DebugConfig.isLogVerbose() && (str3 = DebugConfig.debugRoot) != null) {
            saveRaw(mat, String.format("%s/%s_%d_%d_%s.raw", str3, str2, Integer.valueOf(mat.rows()), Integer.valueOf(mat.cols()), CvType.typeToString(mat.type())));
        }
    }

    public static void logMat(String str, String str2, Mat mat) {
        DebugConfig.logd(str, String.format("%s: %s", str2, mat.toString()));
    }

    public static byte[] matGetByte(Mat mat, int[] iArr) {
        byte[] bArr = new byte[mat.channels()];
        mat.get(iArr, bArr);
        return bArr;
    }

    public static Mat normalizeRgbMat(Mat mat, float[] fArr, float[] fArr2) {
        Mat mat2 = new Mat();
        ArrayList arrayList = new ArrayList();
        Core.split(mat, arrayList);
        Mat mat3 = new Mat();
        Mat mat4 = (Mat) arrayList.get(0);
        int i10 = CvType.CV_32FC1;
        float f10 = fArr2[0];
        mat4.convertTo(mat3, i10, 1.0f / f10, (-fArr[0]) / f10);
        Mat mat5 = new Mat();
        Mat mat6 = (Mat) arrayList.get(1);
        float f11 = fArr2[1];
        mat6.convertTo(mat5, i10, 1.0f / f11, (-fArr[1]) / f11);
        Mat mat7 = new Mat();
        Mat mat8 = (Mat) arrayList.get(2);
        float f12 = fArr2[2];
        mat8.convertTo(mat7, i10, 1.0f / f12, (-fArr[2]) / f12);
        Core.merge(Arrays.asList(mat3, mat5, mat7), mat2);
        return mat2;
    }

    public static void resizeAndPad(Mat mat, Mat mat2, android.util.Size size, Transform.PaddingOption paddingOption) {
        resizeAndPad(mat, mat2, size, paddingOption, null);
    }

    public static void saveRaw(Mat mat, String str) {
        DebugConfig.logd(TAG, "saveRaw " + str + " : " + mat.toString());
        BufferUtil.saveRawBuffer(toDirectBuffer(mat), str);
    }

    public static android.graphics.Rect toAndroidRect(Rect rect) {
        if (rect != null) {
            return new android.graphics.Rect(rect.f35887x, rect.f35888y, (int) rect.br().f35882x, (int) rect.br().f35883y);
        }
        return null;
    }

    public static android.util.Size toAndroidSize(Size size) {
        if (size != null) {
            return new android.util.Size((int) size.width, (int) size.height);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T toArray(Mat mat) {
        int depth = CvType.depth(mat.type());
        if (depth != 0) {
            if (depth != 2 && depth != 3) {
                if (depth != 4) {
                    if (depth != 5) {
                        if (depth == 6) {
                            return (T) toDoubleArray(mat);
                        }
                        throw new UnsupportedOperationException("Unknown Mat data type" + mat.type());
                    }
                    return (T) toFloatArray(mat);
                }
                return (T) toIntArray(mat);
            }
            return (T) toShortArray(mat);
        }
        return (T) toByteArray(mat);
    }

    public static byte[] toByteArray(Mat mat) {
        byte[] bArr = new byte[(int) (mat.total() * mat.channels())];
        mat.get(0, 0, bArr);
        return bArr;
    }

    public static ByteBuffer toDirectBuffer(Mat... matArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect((int) (matArr.length * matArr[0].total() * matArr[0].elemSize()));
        allocateDirect.order(ByteOrder.nativeOrder());
        for (Mat mat : matArr) {
            addAll(allocateDirect, mat);
        }
        allocateDirect.rewind();
        return allocateDirect;
    }

    public static double[] toDoubleArray(Mat mat) {
        double[] dArr = new double[(int) (mat.total() * mat.channels())];
        mat.get(0, 0, dArr);
        return dArr;
    }

    public static float[] toFloatArray(Mat mat) {
        float[] fArr = new float[(int) (mat.total() * mat.channels())];
        mat.get(0, 0, fArr);
        return fArr;
    }

    public static int[] toIntArray(Mat mat) {
        int[] iArr = new int[(int) (mat.total() * mat.channels())];
        mat.get(0, 0, iArr);
        return iArr;
    }

    public static List<Point> toListOfPoint(final Mat mat) {
        return (List) IntStream.range(0, mat.rows()).mapToObj(new IntFunction() { // from class: W8.f
            @Override // java.util.function.IntFunction
            public final Object apply(int i10) {
                Point lambda$toListOfPoint$1;
                lambda$toListOfPoint$1 = OpenCVUtil.lambda$toListOfPoint$1(Mat.this, i10);
                return lambda$toListOfPoint$1;
            }
        }).collect(Collectors.toList());
    }

    public static MatOfPoint toMatOfPoint(List<Point> list) {
        MatOfPoint matOfPoint = new MatOfPoint();
        matOfPoint.fromList(list);
        return matOfPoint;
    }

    public static Rect toOpenCVRect(android.graphics.Rect rect) {
        if (rect != null) {
            return new Rect(rect.left, rect.top, rect.width(), rect.height());
        }
        return null;
    }

    public static Size toOpenCVSize(android.util.Size size) {
        if (size != null) {
            return new Size(size.getWidth(), size.getHeight());
        }
        return null;
    }

    public static int toOpencvRotate(int i10) {
        if (i10 == -90 || i10 == 90) {
            return 0;
        }
        if (i10 != 180) {
            return -1;
        }
        return 1;
    }

    public static List<Point> toPoints(Mat mat) {
        final byte[] byteArray = toByteArray(mat);
        final int cols = mat.cols();
        return (List) indexStream(mat).filter(new Predicate() { // from class: W8.k
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean lambda$toPoints$4;
                lambda$toPoints$4 = OpenCVUtil.lambda$toPoints$4(byteArray, cols, (int[]) obj);
                return lambda$toPoints$4;
            }
        }).map(new Function() { // from class: W8.l
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Point lambda$toPoints$5;
                lambda$toPoints$5 = OpenCVUtil.lambda$toPoints$5((int[]) obj);
                return lambda$toPoints$5;
            }
        }).collect(Collectors.toList());
    }

    public static short[] toShortArray(Mat mat) {
        short[] sArr = new short[(int) (mat.total() * mat.channels())];
        mat.get(0, 0, sArr);
        return sArr;
    }

    public static Bitmap warpCrop(Bitmap bitmap, List<Point> list, Size size) {
        Mat mat = new Mat();
        Utils.bitmapToMat(bitmap, mat);
        warpCropAndRotate(mat, mat, list, size, 0);
        Bitmap createBitmap = Bitmap.createBitmap(mat.cols(), mat.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(mat, createBitmap);
        mat.release();
        return createBitmap;
    }

    public static Mat warpCropAndRotate(Mat mat, List<Point> list, int i10) {
        Mat mat2 = new Mat();
        warpCropAndRotate(mat, mat2, list, i10);
        return mat2;
    }

    public static void warpImage(Mat mat, Mat mat2, List<Point> list, List<Point> list2, Size size) {
        MatOfPoint2f matOfPoint2f = new MatOfPoint2f();
        matOfPoint2f.fromList(list);
        MatOfPoint2f matOfPoint2f2 = new MatOfPoint2f();
        matOfPoint2f2.fromList(list2);
        Imgproc.warpPerspective(mat, mat2, Imgproc.getPerspectiveTransform(matOfPoint2f, matOfPoint2f2), size);
    }

    public static void warpPaste(Mat mat, Mat mat2, List<Point> list, Size size) {
        int rows = mat.rows();
        double cols = mat.cols();
        double d10 = rows;
        warpImage(mat, mat2, Arrays.asList(new Point(0.0d, 0.0d), new Point(cols, 0.0d), new Point(cols, d10), new Point(0.0d, d10)), list, size);
    }

    public static List<Point> getBoundingBox(List<Point> list) {
        MatOfPoint2f matOfPoint2f = new MatOfPoint2f();
        matOfPoint2f.fromList(list);
        RotatedRect minAreaRect = Imgproc.minAreaRect(matOfPoint2f);
        Mat mat = new Mat();
        Imgproc.boxPoints(minAreaRect, mat);
        final List<Point> listOfPoint = toListOfPoint(mat);
        String str = TAG;
        DebugConfig.logd(str, "bboxes " + StringUtil.toString(listOfPoint));
        final int i10 = ((BBoxUtil.norm(listOfPoint.get(0), listOfPoint.get(1)) <= BBoxUtil.norm(listOfPoint.get(0), listOfPoint.get(3)) ? Math.abs(listOfPoint.get(3).f35882x - listOfPoint.get(0).f35882x) >= Math.abs(listOfPoint.get(3).f35883y - listOfPoint.get(0).f35883y) : Math.abs(listOfPoint.get(1).f35882x - listOfPoint.get(0).f35882x) <= Math.abs(listOfPoint.get(1).f35883y - listOfPoint.get(0).f35883y)) ? 0 : 1) + 1;
        List list2 = (List) IntStream.range(0, listOfPoint.size()).mapToObj(new IntFunction() { // from class: W8.i
            @Override // java.util.function.IntFunction
            public final Object apply(int i11) {
                Point lambda$getBoundingBox$6;
                lambda$getBoundingBox$6 = OpenCVUtil.lambda$getBoundingBox$6(listOfPoint, i10, i11);
                return lambda$getBoundingBox$6;
            }
        }).collect(Collectors.toList());
        DebugConfig.logd(str, "bboxes moved " + StringUtil.toString(list2));
        return alignBoundingBox(list2);
    }

    public static void resizeAndPad(Mat mat, Mat mat2, android.util.Size size, Transform.PaddingOption paddingOption, Transform.TransformGroup transformGroup) {
        String str = TAG;
        DebugConfig.logd(str, String.format("resizeAndPad %s -> %s", mat.size().toString(), size.toString()));
        android.util.Size size2 = new android.util.Size(mat.cols(), mat.rows());
        if (transformGroup == null) {
            transformGroup = new Transform.TransformGroup();
        }
        transformGroup.transforms.addAll(Transform.createResizeAndPadding(size2, size, paddingOption));
        android.graphics.Rect calcValidRect = transformGroup.calcValidRect();
        Imgproc.resize(mat, mat2, new Size(calcValidRect.width(), calcValidRect.height()));
        if (paddingOption != Transform.PaddingOption.NoPadding) {
            Core.copyMakeBorder(mat2, mat2, calcValidRect.top, size.getHeight() - calcValidRect.bottom, calcValidRect.left, size.getWidth() - calcValidRect.right, 0, new Scalar(0.0d));
        }
        DebugConfig.logd(str, String.format("transform %s, %s, %s", calcValidRect, size.toString(), mat.size().toString()));
    }

    public static void warpCropAndRotate(Mat mat, Mat mat2, List<Point> list, int i10) {
        warpCropAndRotate(mat, mat2, list, null, i10);
    }

    public static Mat warpPaste(Mat mat, List<Point> list, Size size) {
        Mat mat2 = new Mat();
        warpPaste(mat, mat2, list, size);
        return mat2;
    }

    public static void warpCropAndRotate(Mat mat, Mat mat2, List<Point> list, Size size, List<Point> list2, int i10) {
        if (i10 == 270) {
            i10 = -90;
        }
        if (size == null) {
            size = BBoxUtil.normBoxSize((Point[]) list.toArray(new Point[list.size()]));
            if (i10 == 90 || i10 == -90) {
                size = new Size(size.height, size.width);
            }
        }
        int i11 = (int) size.height;
        int i12 = (int) size.width;
        if (list2 == null) {
            double d10 = i12;
            double d11 = i11;
            list2 = Arrays.asList(new Point(0.0d, 0.0d), new Point(d10, 0.0d), new Point(d10, d11), new Point(0.0d, d11));
        }
        warpImage(mat, mat2, BBoxUtil.rotate(list, i10), list2, size);
    }

    public static double[][] getColorSample(final byte[] bArr, int i10, int i11, Rect rect, int i12) {
        double[][] dArr = new double[(((rect.width - 1) / i12) + 1) * (((rect.height - 1) / i12) + 1)];
        int i13 = rect.f35888y;
        int i14 = 0;
        while (i13 < rect.f35888y + rect.height) {
            int i15 = rect.f35887x;
            while (i15 < rect.f35887x + rect.width) {
                int i16 = (i13 * i10 * i11) + (i15 * i11);
                dArr[i14] = IntStream.range(i16, i16 + 3).mapToDouble(new IntToDoubleFunction() { // from class: W8.h
                    @Override // java.util.function.IntToDoubleFunction
                    public final double applyAsDouble(int i17) {
                        double lambda$getColorSample$12;
                        lambda$getColorSample$12 = OpenCVUtil.lambda$getColorSample$12(bArr, i17);
                        return lambda$getColorSample$12;
                    }
                }).toArray();
                i15 += i12;
                i14++;
            }
            i13 += i12;
        }
        return dArr;
    }

    public static Mat warpCrop(Mat mat, List<Point> list) {
        Mat mat2 = new Mat();
        warpCrop(mat, mat2, list);
        return mat2;
    }

    public static void warpCrop(Mat mat, Mat mat2, List<Point> list) {
        warpCropAndRotate(mat, mat2, list, 0);
    }

    public static void warpCropAndRotate(Mat mat, Mat mat2, List<Point> list, Size size, int i10) {
        if (size == null) {
            size = BBoxUtil.normBoxSize((Point[]) list.toArray(new Point[list.size()]));
        }
        if (i10 == 270) {
            i10 = -90;
        }
        if (i10 == 90 || i10 == -90) {
            size = new Size(size.height, size.width);
        }
        int i11 = (int) size.height;
        double d10 = (int) size.width;
        double d11 = i11;
        warpImage(mat, mat2, BBoxUtil.rotate(list, i10), Arrays.asList(new Point(0.0d, 0.0d), new Point(d10, 0.0d), new Point(d10, d11), new Point(0.0d, d11)), size);
    }

    public static List<Point> alignBoundingBox(List<Point> list) {
        return list;
    }
}
