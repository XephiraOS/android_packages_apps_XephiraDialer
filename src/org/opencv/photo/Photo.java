package org.opencv.photo;

import java.util.List;
import org.opencv.core.Mat;
import org.opencv.core.MatOfFloat;
import org.opencv.core.Point;
import org.opencv.utils.Converters;

/* loaded from: classes4.dex */
public class Photo {
    public static final int INPAINT_NS = 0;
    public static final int INPAINT_TELEA = 1;
    public static final int LDR_SIZE = 256;
    public static final int MIXED_CLONE = 2;
    public static final int MONOCHROME_TRANSFER = 3;
    public static final int NORMAL_CLONE = 1;
    public static final int NORMCONV_FILTER = 2;
    public static final int RECURS_FILTER = 1;

    public static void colorChange(Mat mat, Mat mat2, Mat mat3, float f10, float f11, float f12) {
        colorChange_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, f10, f11, f12);
    }

    private static native void colorChange_0(long j10, long j11, long j12, float f10, float f11, float f12);

    private static native void colorChange_1(long j10, long j11, long j12, float f10, float f11);

    private static native void colorChange_2(long j10, long j11, long j12, float f10);

    private static native void colorChange_3(long j10, long j11, long j12);

    public static AlignMTB createAlignMTB(int i10, int i11, boolean z10) {
        return AlignMTB.__fromPtr__(createAlignMTB_0(i10, i11, z10));
    }

    private static native long createAlignMTB_0(int i10, int i11, boolean z10);

    private static native long createAlignMTB_1(int i10, int i11);

    private static native long createAlignMTB_2(int i10);

    private static native long createAlignMTB_3();

    public static CalibrateDebevec createCalibrateDebevec(int i10, float f10, boolean z10) {
        return CalibrateDebevec.__fromPtr__(createCalibrateDebevec_0(i10, f10, z10));
    }

    private static native long createCalibrateDebevec_0(int i10, float f10, boolean z10);

    private static native long createCalibrateDebevec_1(int i10, float f10);

    private static native long createCalibrateDebevec_2(int i10);

    private static native long createCalibrateDebevec_3();

    public static CalibrateRobertson createCalibrateRobertson(int i10, float f10) {
        return CalibrateRobertson.__fromPtr__(createCalibrateRobertson_0(i10, f10));
    }

    private static native long createCalibrateRobertson_0(int i10, float f10);

    private static native long createCalibrateRobertson_1(int i10);

    private static native long createCalibrateRobertson_2();

    public static MergeDebevec createMergeDebevec() {
        return MergeDebevec.__fromPtr__(createMergeDebevec_0());
    }

    private static native long createMergeDebevec_0();

    public static MergeMertens createMergeMertens(float f10, float f11, float f12) {
        return MergeMertens.__fromPtr__(createMergeMertens_0(f10, f11, f12));
    }

    private static native long createMergeMertens_0(float f10, float f11, float f12);

    private static native long createMergeMertens_1(float f10, float f11);

    private static native long createMergeMertens_2(float f10);

    private static native long createMergeMertens_3();

    public static MergeRobertson createMergeRobertson() {
        return MergeRobertson.__fromPtr__(createMergeRobertson_0());
    }

    private static native long createMergeRobertson_0();

    public static Tonemap createTonemap(float f10) {
        return Tonemap.__fromPtr__(createTonemap_0(f10));
    }

    public static TonemapDrago createTonemapDrago(float f10, float f11, float f12) {
        return TonemapDrago.__fromPtr__(createTonemapDrago_0(f10, f11, f12));
    }

    private static native long createTonemapDrago_0(float f10, float f11, float f12);

    private static native long createTonemapDrago_1(float f10, float f11);

    private static native long createTonemapDrago_2(float f10);

    private static native long createTonemapDrago_3();

    public static TonemapMantiuk createTonemapMantiuk(float f10, float f11, float f12) {
        return TonemapMantiuk.__fromPtr__(createTonemapMantiuk_0(f10, f11, f12));
    }

    private static native long createTonemapMantiuk_0(float f10, float f11, float f12);

    private static native long createTonemapMantiuk_1(float f10, float f11);

    private static native long createTonemapMantiuk_2(float f10);

    private static native long createTonemapMantiuk_3();

    public static TonemapReinhard createTonemapReinhard(float f10, float f11, float f12, float f13) {
        return TonemapReinhard.__fromPtr__(createTonemapReinhard_0(f10, f11, f12, f13));
    }

    private static native long createTonemapReinhard_0(float f10, float f11, float f12, float f13);

    private static native long createTonemapReinhard_1(float f10, float f11, float f12);

    private static native long createTonemapReinhard_2(float f10, float f11);

    private static native long createTonemapReinhard_3(float f10);

    private static native long createTonemapReinhard_4();

    private static native long createTonemap_0(float f10);

    private static native long createTonemap_1();

    public static void decolor(Mat mat, Mat mat2, Mat mat3) {
        decolor_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    private static native void decolor_0(long j10, long j11, long j12);

    public static void denoise_TVL1(List<Mat> list, Mat mat, double d10, int i10) {
        denoise_TVL1_0(Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj, d10, i10);
    }

    private static native void denoise_TVL1_0(long j10, long j11, double d10, int i10);

    private static native void denoise_TVL1_1(long j10, long j11, double d10);

    private static native void denoise_TVL1_2(long j10, long j11);

    public static void detailEnhance(Mat mat, Mat mat2, float f10, float f11) {
        detailEnhance_0(mat.nativeObj, mat2.nativeObj, f10, f11);
    }

    private static native void detailEnhance_0(long j10, long j11, float f10, float f11);

    private static native void detailEnhance_1(long j10, long j11, float f10);

    private static native void detailEnhance_2(long j10, long j11);

    public static void edgePreservingFilter(Mat mat, Mat mat2, int i10, float f10, float f11) {
        edgePreservingFilter_0(mat.nativeObj, mat2.nativeObj, i10, f10, f11);
    }

    private static native void edgePreservingFilter_0(long j10, long j11, int i10, float f10, float f11);

    private static native void edgePreservingFilter_1(long j10, long j11, int i10, float f10);

    private static native void edgePreservingFilter_2(long j10, long j11, int i10);

    private static native void edgePreservingFilter_3(long j10, long j11);

    public static void fastNlMeansDenoising(Mat mat, Mat mat2, float f10, int i10, int i11) {
        fastNlMeansDenoising_0(mat.nativeObj, mat2.nativeObj, f10, i10, i11);
    }

    public static void fastNlMeansDenoisingColored(Mat mat, Mat mat2, float f10, float f11, int i10, int i11) {
        fastNlMeansDenoisingColored_0(mat.nativeObj, mat2.nativeObj, f10, f11, i10, i11);
    }

    public static void fastNlMeansDenoisingColoredMulti(List<Mat> list, Mat mat, int i10, int i11, float f10, float f11, int i12, int i13) {
        fastNlMeansDenoisingColoredMulti_0(Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj, i10, i11, f10, f11, i12, i13);
    }

    private static native void fastNlMeansDenoisingColoredMulti_0(long j10, long j11, int i10, int i11, float f10, float f11, int i12, int i13);

    private static native void fastNlMeansDenoisingColoredMulti_1(long j10, long j11, int i10, int i11, float f10, float f11, int i12);

    private static native void fastNlMeansDenoisingColoredMulti_2(long j10, long j11, int i10, int i11, float f10, float f11);

    private static native void fastNlMeansDenoisingColoredMulti_3(long j10, long j11, int i10, int i11, float f10);

    private static native void fastNlMeansDenoisingColoredMulti_4(long j10, long j11, int i10, int i11);

    private static native void fastNlMeansDenoisingColored_0(long j10, long j11, float f10, float f11, int i10, int i11);

    private static native void fastNlMeansDenoisingColored_1(long j10, long j11, float f10, float f11, int i10);

    private static native void fastNlMeansDenoisingColored_2(long j10, long j11, float f10, float f11);

    private static native void fastNlMeansDenoisingColored_3(long j10, long j11, float f10);

    private static native void fastNlMeansDenoisingColored_4(long j10, long j11);

    public static void fastNlMeansDenoisingMulti(List<Mat> list, Mat mat, int i10, int i11, float f10, int i12, int i13) {
        fastNlMeansDenoisingMulti_0(Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj, i10, i11, f10, i12, i13);
    }

    private static native void fastNlMeansDenoisingMulti_0(long j10, long j11, int i10, int i11, float f10, int i12, int i13);

    private static native void fastNlMeansDenoisingMulti_1(long j10, long j11, int i10, int i11, float f10, int i12);

    private static native void fastNlMeansDenoisingMulti_2(long j10, long j11, int i10, int i11, float f10);

    private static native void fastNlMeansDenoisingMulti_3(long j10, long j11, int i10, int i11);

    private static native void fastNlMeansDenoisingMulti_4(long j10, long j11, int i10, int i11, long j12, int i12, int i13, int i14);

    private static native void fastNlMeansDenoisingMulti_5(long j10, long j11, int i10, int i11, long j12, int i12, int i13);

    private static native void fastNlMeansDenoisingMulti_6(long j10, long j11, int i10, int i11, long j12, int i12);

    private static native void fastNlMeansDenoisingMulti_7(long j10, long j11, int i10, int i11, long j12);

    private static native void fastNlMeansDenoising_0(long j10, long j11, float f10, int i10, int i11);

    private static native void fastNlMeansDenoising_1(long j10, long j11, float f10, int i10);

    private static native void fastNlMeansDenoising_2(long j10, long j11, float f10);

    private static native void fastNlMeansDenoising_3(long j10, long j11);

    private static native void fastNlMeansDenoising_4(long j10, long j11, long j12, int i10, int i11, int i12);

    private static native void fastNlMeansDenoising_5(long j10, long j11, long j12, int i10, int i11);

    private static native void fastNlMeansDenoising_6(long j10, long j11, long j12, int i10);

    private static native void fastNlMeansDenoising_7(long j10, long j11, long j12);

    public static void illuminationChange(Mat mat, Mat mat2, Mat mat3, float f10, float f11) {
        illuminationChange_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, f10, f11);
    }

    private static native void illuminationChange_0(long j10, long j11, long j12, float f10, float f11);

    private static native void illuminationChange_1(long j10, long j11, long j12, float f10);

    private static native void illuminationChange_2(long j10, long j11, long j12);

    public static void inpaint(Mat mat, Mat mat2, Mat mat3, double d10, int i10) {
        inpaint_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, d10, i10);
    }

    private static native void inpaint_0(long j10, long j11, long j12, double d10, int i10);

    public static void pencilSketch(Mat mat, Mat mat2, Mat mat3, float f10, float f11, float f12) {
        pencilSketch_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, f10, f11, f12);
    }

    private static native void pencilSketch_0(long j10, long j11, long j12, float f10, float f11, float f12);

    private static native void pencilSketch_1(long j10, long j11, long j12, float f10, float f11);

    private static native void pencilSketch_2(long j10, long j11, long j12, float f10);

    private static native void pencilSketch_3(long j10, long j11, long j12);

    public static void seamlessClone(Mat mat, Mat mat2, Mat mat3, Point point, Mat mat4, int i10) {
        seamlessClone_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, point.f35882x, point.f35883y, mat4.nativeObj, i10);
    }

    private static native void seamlessClone_0(long j10, long j11, long j12, double d10, double d11, long j13, int i10);

    public static void stylization(Mat mat, Mat mat2, float f10, float f11) {
        stylization_0(mat.nativeObj, mat2.nativeObj, f10, f11);
    }

    private static native void stylization_0(long j10, long j11, float f10, float f11);

    private static native void stylization_1(long j10, long j11, float f10);

    private static native void stylization_2(long j10, long j11);

    public static void textureFlattening(Mat mat, Mat mat2, Mat mat3, float f10, float f11, int i10) {
        textureFlattening_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, f10, f11, i10);
    }

    private static native void textureFlattening_0(long j10, long j11, long j12, float f10, float f11, int i10);

    private static native void textureFlattening_1(long j10, long j11, long j12, float f10, float f11);

    private static native void textureFlattening_2(long j10, long j11, long j12, float f10);

    private static native void textureFlattening_3(long j10, long j11, long j12);

    public static void colorChange(Mat mat, Mat mat2, Mat mat3, float f10, float f11) {
        colorChange_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, f10, f11);
    }

    public static AlignMTB createAlignMTB(int i10, int i11) {
        return AlignMTB.__fromPtr__(createAlignMTB_1(i10, i11));
    }

    public static CalibrateDebevec createCalibrateDebevec(int i10, float f10) {
        return CalibrateDebevec.__fromPtr__(createCalibrateDebevec_1(i10, f10));
    }

    public static CalibrateRobertson createCalibrateRobertson(int i10) {
        return CalibrateRobertson.__fromPtr__(createCalibrateRobertson_1(i10));
    }

    public static MergeMertens createMergeMertens(float f10, float f11) {
        return MergeMertens.__fromPtr__(createMergeMertens_1(f10, f11));
    }

    public static Tonemap createTonemap() {
        return Tonemap.__fromPtr__(createTonemap_1());
    }

    public static TonemapDrago createTonemapDrago(float f10, float f11) {
        return TonemapDrago.__fromPtr__(createTonemapDrago_1(f10, f11));
    }

    public static TonemapMantiuk createTonemapMantiuk(float f10, float f11) {
        return TonemapMantiuk.__fromPtr__(createTonemapMantiuk_1(f10, f11));
    }

    public static TonemapReinhard createTonemapReinhard(float f10, float f11, float f12) {
        return TonemapReinhard.__fromPtr__(createTonemapReinhard_1(f10, f11, f12));
    }

    public static void detailEnhance(Mat mat, Mat mat2, float f10) {
        detailEnhance_1(mat.nativeObj, mat2.nativeObj, f10);
    }

    public static void edgePreservingFilter(Mat mat, Mat mat2, int i10, float f10) {
        edgePreservingFilter_1(mat.nativeObj, mat2.nativeObj, i10, f10);
    }

    public static void fastNlMeansDenoising(Mat mat, Mat mat2, float f10, int i10) {
        fastNlMeansDenoising_1(mat.nativeObj, mat2.nativeObj, f10, i10);
    }

    public static void fastNlMeansDenoisingColored(Mat mat, Mat mat2, float f10, float f11, int i10) {
        fastNlMeansDenoisingColored_1(mat.nativeObj, mat2.nativeObj, f10, f11, i10);
    }

    public static void illuminationChange(Mat mat, Mat mat2, Mat mat3, float f10) {
        illuminationChange_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, f10);
    }

    public static void pencilSketch(Mat mat, Mat mat2, Mat mat3, float f10, float f11) {
        pencilSketch_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, f10, f11);
    }

    public static void stylization(Mat mat, Mat mat2, float f10) {
        stylization_1(mat.nativeObj, mat2.nativeObj, f10);
    }

    public static void textureFlattening(Mat mat, Mat mat2, Mat mat3, float f10, float f11) {
        textureFlattening_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, f10, f11);
    }

    public static void colorChange(Mat mat, Mat mat2, Mat mat3, float f10) {
        colorChange_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, f10);
    }

    public static AlignMTB createAlignMTB(int i10) {
        return AlignMTB.__fromPtr__(createAlignMTB_2(i10));
    }

    public static CalibrateDebevec createCalibrateDebevec(int i10) {
        return CalibrateDebevec.__fromPtr__(createCalibrateDebevec_2(i10));
    }

    public static CalibrateRobertson createCalibrateRobertson() {
        return CalibrateRobertson.__fromPtr__(createCalibrateRobertson_2());
    }

    public static MergeMertens createMergeMertens(float f10) {
        return MergeMertens.__fromPtr__(createMergeMertens_2(f10));
    }

    public static TonemapDrago createTonemapDrago(float f10) {
        return TonemapDrago.__fromPtr__(createTonemapDrago_2(f10));
    }

    public static TonemapMantiuk createTonemapMantiuk(float f10) {
        return TonemapMantiuk.__fromPtr__(createTonemapMantiuk_2(f10));
    }

    public static TonemapReinhard createTonemapReinhard(float f10, float f11) {
        return TonemapReinhard.__fromPtr__(createTonemapReinhard_2(f10, f11));
    }

    public static void denoise_TVL1(List<Mat> list, Mat mat, double d10) {
        denoise_TVL1_1(Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj, d10);
    }

    public static void detailEnhance(Mat mat, Mat mat2) {
        detailEnhance_2(mat.nativeObj, mat2.nativeObj);
    }

    public static void edgePreservingFilter(Mat mat, Mat mat2, int i10) {
        edgePreservingFilter_2(mat.nativeObj, mat2.nativeObj, i10);
    }

    public static void fastNlMeansDenoising(Mat mat, Mat mat2, float f10) {
        fastNlMeansDenoising_2(mat.nativeObj, mat2.nativeObj, f10);
    }

    public static void fastNlMeansDenoisingColored(Mat mat, Mat mat2, float f10, float f11) {
        fastNlMeansDenoisingColored_2(mat.nativeObj, mat2.nativeObj, f10, f11);
    }

    public static void fastNlMeansDenoisingColoredMulti(List<Mat> list, Mat mat, int i10, int i11, float f10, float f11, int i12) {
        fastNlMeansDenoisingColoredMulti_1(Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj, i10, i11, f10, f11, i12);
    }

    public static void fastNlMeansDenoisingMulti(List<Mat> list, Mat mat, int i10, int i11, float f10, int i12) {
        fastNlMeansDenoisingMulti_1(Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj, i10, i11, f10, i12);
    }

    public static void illuminationChange(Mat mat, Mat mat2, Mat mat3) {
        illuminationChange_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static void pencilSketch(Mat mat, Mat mat2, Mat mat3, float f10) {
        pencilSketch_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, f10);
    }

    public static void stylization(Mat mat, Mat mat2) {
        stylization_2(mat.nativeObj, mat2.nativeObj);
    }

    public static void textureFlattening(Mat mat, Mat mat2, Mat mat3, float f10) {
        textureFlattening_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, f10);
    }

    public static void colorChange(Mat mat, Mat mat2, Mat mat3) {
        colorChange_3(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static AlignMTB createAlignMTB() {
        return AlignMTB.__fromPtr__(createAlignMTB_3());
    }

    public static CalibrateDebevec createCalibrateDebevec() {
        return CalibrateDebevec.__fromPtr__(createCalibrateDebevec_3());
    }

    public static MergeMertens createMergeMertens() {
        return MergeMertens.__fromPtr__(createMergeMertens_3());
    }

    public static TonemapDrago createTonemapDrago() {
        return TonemapDrago.__fromPtr__(createTonemapDrago_3());
    }

    public static TonemapMantiuk createTonemapMantiuk() {
        return TonemapMantiuk.__fromPtr__(createTonemapMantiuk_3());
    }

    public static TonemapReinhard createTonemapReinhard(float f10) {
        return TonemapReinhard.__fromPtr__(createTonemapReinhard_3(f10));
    }

    public static void edgePreservingFilter(Mat mat, Mat mat2) {
        edgePreservingFilter_3(mat.nativeObj, mat2.nativeObj);
    }

    public static void fastNlMeansDenoising(Mat mat, Mat mat2) {
        fastNlMeansDenoising_3(mat.nativeObj, mat2.nativeObj);
    }

    public static void fastNlMeansDenoisingColored(Mat mat, Mat mat2, float f10) {
        fastNlMeansDenoisingColored_3(mat.nativeObj, mat2.nativeObj, f10);
    }

    public static void pencilSketch(Mat mat, Mat mat2, Mat mat3) {
        pencilSketch_3(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static void textureFlattening(Mat mat, Mat mat2, Mat mat3) {
        textureFlattening_3(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static TonemapReinhard createTonemapReinhard() {
        return TonemapReinhard.__fromPtr__(createTonemapReinhard_4());
    }

    public static void denoise_TVL1(List<Mat> list, Mat mat) {
        denoise_TVL1_2(Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj);
    }

    public static void fastNlMeansDenoising(Mat mat, Mat mat2, MatOfFloat matOfFloat, int i10, int i11, int i12) {
        fastNlMeansDenoising_4(mat.nativeObj, mat2.nativeObj, matOfFloat.nativeObj, i10, i11, i12);
    }

    public static void fastNlMeansDenoisingColored(Mat mat, Mat mat2) {
        fastNlMeansDenoisingColored_4(mat.nativeObj, mat2.nativeObj);
    }

    public static void fastNlMeansDenoisingColoredMulti(List<Mat> list, Mat mat, int i10, int i11, float f10, float f11) {
        fastNlMeansDenoisingColoredMulti_2(Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj, i10, i11, f10, f11);
    }

    public static void fastNlMeansDenoisingMulti(List<Mat> list, Mat mat, int i10, int i11, float f10) {
        fastNlMeansDenoisingMulti_2(Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj, i10, i11, f10);
    }

    public static void fastNlMeansDenoising(Mat mat, Mat mat2, MatOfFloat matOfFloat, int i10, int i11) {
        fastNlMeansDenoising_5(mat.nativeObj, mat2.nativeObj, matOfFloat.nativeObj, i10, i11);
    }

    public static void fastNlMeansDenoising(Mat mat, Mat mat2, MatOfFloat matOfFloat, int i10) {
        fastNlMeansDenoising_6(mat.nativeObj, mat2.nativeObj, matOfFloat.nativeObj, i10);
    }

    public static void fastNlMeansDenoisingColoredMulti(List<Mat> list, Mat mat, int i10, int i11, float f10) {
        fastNlMeansDenoisingColoredMulti_3(Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj, i10, i11, f10);
    }

    public static void fastNlMeansDenoisingMulti(List<Mat> list, Mat mat, int i10, int i11) {
        fastNlMeansDenoisingMulti_3(Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj, i10, i11);
    }

    public static void fastNlMeansDenoising(Mat mat, Mat mat2, MatOfFloat matOfFloat) {
        fastNlMeansDenoising_7(mat.nativeObj, mat2.nativeObj, matOfFloat.nativeObj);
    }

    public static void fastNlMeansDenoisingColoredMulti(List<Mat> list, Mat mat, int i10, int i11) {
        fastNlMeansDenoisingColoredMulti_4(Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj, i10, i11);
    }

    public static void fastNlMeansDenoisingMulti(List<Mat> list, Mat mat, int i10, int i11, MatOfFloat matOfFloat, int i12, int i13, int i14) {
        fastNlMeansDenoisingMulti_4(Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj, i10, i11, matOfFloat.nativeObj, i12, i13, i14);
    }

    public static void fastNlMeansDenoisingMulti(List<Mat> list, Mat mat, int i10, int i11, MatOfFloat matOfFloat, int i12, int i13) {
        fastNlMeansDenoisingMulti_5(Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj, i10, i11, matOfFloat.nativeObj, i12, i13);
    }

    public static void fastNlMeansDenoisingMulti(List<Mat> list, Mat mat, int i10, int i11, MatOfFloat matOfFloat, int i12) {
        fastNlMeansDenoisingMulti_6(Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj, i10, i11, matOfFloat.nativeObj, i12);
    }

    public static void fastNlMeansDenoisingMulti(List<Mat> list, Mat mat, int i10, int i11, MatOfFloat matOfFloat) {
        fastNlMeansDenoisingMulti_7(Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj, i10, i11, matOfFloat.nativeObj);
    }
}
