package org.opencv.core;

import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public class Mat {
    public final long nativeObj;

    public Mat(long j10) {
        if (j10 != 0) {
            this.nativeObj = j10;
            return;
        }
        throw new UnsupportedOperationException("Native object address is NULL");
    }

    public static Mat eye(int i10, int i11, int i12) {
        return new Mat(n_eye(i10, i11, i12));
    }

    private static native void locateROI_0(long j10, double[] dArr, double[] dArr2);

    private static native String nDump(long j10);

    private static native double[] nGet(long j10, int i10, int i11);

    private static native int nGetB(long j10, int i10, int i11, int i12, byte[] bArr);

    private static native int nGetBIdx(long j10, int[] iArr, int i10, byte[] bArr);

    private static native int nGetD(long j10, int i10, int i11, int i12, double[] dArr);

    private static native int nGetDIdx(long j10, int[] iArr, int i10, double[] dArr);

    private static native int nGetF(long j10, int i10, int i11, int i12, float[] fArr);

    private static native int nGetFIdx(long j10, int[] iArr, int i10, float[] fArr);

    private static native int nGetI(long j10, int i10, int i11, int i12, int[] iArr);

    private static native int nGetIIdx(long j10, int[] iArr, int i10, int[] iArr2);

    private static native double[] nGetIdx(long j10, int[] iArr);

    private static native int nGetS(long j10, int i10, int i11, int i12, short[] sArr);

    private static native int nGetSIdx(long j10, int[] iArr, int i10, short[] sArr);

    private static native int nPutB(long j10, int i10, int i11, int i12, byte[] bArr);

    private static native int nPutBIdx(long j10, int[] iArr, int i10, byte[] bArr);

    private static native int nPutBwIdxOffset(long j10, int[] iArr, int i10, int i11, byte[] bArr);

    private static native int nPutBwOffset(long j10, int i10, int i11, int i12, int i13, byte[] bArr);

    private static native int nPutD(long j10, int i10, int i11, int i12, double[] dArr);

    private static native int nPutDIdx(long j10, int[] iArr, int i10, double[] dArr);

    private static native int nPutF(long j10, int i10, int i11, int i12, float[] fArr);

    private static native int nPutFIdx(long j10, int[] iArr, int i10, float[] fArr);

    private static native int nPutI(long j10, int i10, int i11, int i12, int[] iArr);

    private static native int nPutIIdx(long j10, int[] iArr, int i10, int[] iArr2);

    private static native int nPutS(long j10, int i10, int i11, int i12, short[] sArr);

    private static native int nPutSIdx(long j10, int[] iArr, int i10, short[] sArr);

    private static native long n_Mat();

    private static native long n_Mat(double d10, double d11, int i10);

    private static native long n_Mat(double d10, double d11, int i10, double d12, double d13, double d14, double d15);

    private static native long n_Mat(int i10, int i11, int i12);

    private static native long n_Mat(int i10, int i11, int i12, double d10, double d11, double d12, double d13);

    private static native long n_Mat(int i10, int i11, int i12, ByteBuffer byteBuffer);

    private static native long n_Mat(int i10, int i11, int i12, ByteBuffer byteBuffer, long j10);

    private static native long n_Mat(int i10, int[] iArr, int i11);

    private static native long n_Mat(int i10, int[] iArr, int i11, double d10, double d11, double d12, double d13);

    private static native long n_Mat(long j10, int i10, int i11);

    private static native long n_Mat(long j10, int i10, int i11, int i12, int i13);

    private static native long n_Mat(long j10, Range[] rangeArr);

    private static native long n_adjustROI(long j10, int i10, int i11, int i12, int i13);

    private static native void n_assignTo(long j10, long j11);

    private static native void n_assignTo(long j10, long j11, int i10);

    private static native int n_channels(long j10);

    private static native int n_checkVector(long j10, int i10);

    private static native int n_checkVector(long j10, int i10, int i11);

    private static native int n_checkVector(long j10, int i10, int i11, boolean z10);

    private static native long n_clone(long j10);

    private static native long n_col(long j10, int i10);

    private static native long n_colRange(long j10, int i10, int i11);

    private static native int n_cols(long j10);

    private static native void n_convertTo(long j10, long j11, int i10);

    private static native void n_convertTo(long j10, long j11, int i10, double d10);

    private static native void n_convertTo(long j10, long j11, int i10, double d10, double d11);

    private static native void n_copySize(long j10, long j11);

    private static native void n_copyTo(long j10, long j11);

    private static native void n_copyTo(long j10, long j11, long j12);

    private static native void n_create(long j10, double d10, double d11, int i10);

    private static native void n_create(long j10, int i10, int i11, int i12);

    private static native void n_create(long j10, int i10, int[] iArr, int i11);

    private static native long n_cross(long j10, long j11);

    private static native long n_dataAddr(long j10);

    private static native void n_delete(long j10);

    private static native int n_depth(long j10);

    private static native long n_diag(long j10);

    private static native long n_diag(long j10, int i10);

    private static native int n_dims(long j10);

    private static native double n_dot(long j10, long j11);

    private static native long n_elemSize(long j10);

    private static native long n_elemSize1(long j10);

    private static native boolean n_empty(long j10);

    private static native long n_eye(double d10, double d11, int i10);

    private static native long n_eye(int i10, int i11, int i12);

    private static native long n_inv(long j10);

    private static native long n_inv(long j10, int i10);

    private static native boolean n_isContinuous(long j10);

    private static native boolean n_isSubmatrix(long j10);

    private static native long n_mul(long j10, long j11);

    private static native long n_mul(long j10, long j11, double d10);

    private static native long n_ones(double d10, double d11, int i10);

    private static native long n_ones(int i10, int i11, int i12);

    private static native long n_ones(int i10, int[] iArr, int i11);

    private static native void n_push_back(long j10, long j11);

    private static native void n_release(long j10);

    private static native long n_reshape(long j10, int i10);

    private static native long n_reshape(long j10, int i10, int i11);

    private static native long n_reshape_1(long j10, int i10, int i11, int[] iArr);

    private static native long n_row(long j10, int i10);

    private static native long n_rowRange(long j10, int i10, int i11);

    private static native int n_rows(long j10);

    private static native long n_setTo(long j10, double d10, double d11, double d12, double d13);

    private static native long n_setTo(long j10, double d10, double d11, double d12, double d13, long j11);

    private static native long n_setTo(long j10, long j11);

    private static native long n_setTo(long j10, long j11, long j12);

    private static native double[] n_size(long j10);

    private static native int n_size_i(long j10, int i10);

    private static native long n_step1(long j10);

    private static native long n_step1(long j10, int i10);

    private static native long n_submat(long j10, int i10, int i11, int i12, int i13);

    private static native long n_submat_ranges(long j10, Range[] rangeArr);

    private static native long n_submat_rr(long j10, int i10, int i11, int i12, int i13);

    private static native long n_t(long j10);

    private static native long n_total(long j10);

    private static native int n_type(long j10);

    private static native long n_zeros(double d10, double d11, int i10);

    private static native long n_zeros(int i10, int i11, int i12);

    private static native long n_zeros(int i10, int[] iArr, int i11);

    public static Mat ones(int i10, int i11, int i12) {
        return new Mat(n_ones(i10, i11, i12));
    }

    public static Mat zeros(int i10, int i11, int i12) {
        return new Mat(n_zeros(i10, i11, i12));
    }

    public Mat adjustROI(int i10, int i11, int i12, int i13) {
        return new Mat(n_adjustROI(this.nativeObj, i10, i11, i12, i13));
    }

    public void assignTo(Mat mat, int i10) {
        n_assignTo(this.nativeObj, mat.nativeObj, i10);
    }

    public int channels() {
        return n_channels(this.nativeObj);
    }

    public int checkVector(int i10, int i11, boolean z10) {
        return n_checkVector(this.nativeObj, i10, i11, z10);
    }

    public Mat col(int i10) {
        return new Mat(n_col(this.nativeObj, i10));
    }

    public Mat colRange(int i10, int i11) {
        return new Mat(n_colRange(this.nativeObj, i10, i11));
    }

    public int cols() {
        return n_cols(this.nativeObj);
    }

    public void convertTo(Mat mat, int i10, double d10, double d11) {
        n_convertTo(this.nativeObj, mat.nativeObj, i10, d10, d11);
    }

    public void copySize(Mat mat) {
        n_copySize(this.nativeObj, mat.nativeObj);
    }

    public void copyTo(Mat mat) {
        n_copyTo(this.nativeObj, mat.nativeObj);
    }

    public void create(int i10, int i11, int i12) {
        n_create(this.nativeObj, i10, i11, i12);
    }

    public Mat cross(Mat mat) {
        return new Mat(n_cross(this.nativeObj, mat.nativeObj));
    }

    public long dataAddr() {
        return n_dataAddr(this.nativeObj);
    }

    public int depth() {
        return n_depth(this.nativeObj);
    }

    public Mat diag(int i10) {
        return new Mat(n_diag(this.nativeObj, i10));
    }

    public int dims() {
        return n_dims(this.nativeObj);
    }

    public double dot(Mat mat) {
        return n_dot(this.nativeObj, mat.nativeObj);
    }

    public String dump() {
        return nDump(this.nativeObj);
    }

    public long elemSize() {
        return n_elemSize(this.nativeObj);
    }

    public long elemSize1() {
        return n_elemSize1(this.nativeObj);
    }

    public boolean empty() {
        return n_empty(this.nativeObj);
    }

    public void finalize() {
        n_delete(this.nativeObj);
        super.finalize();
    }

    public int get(int i10, int i11, byte[] bArr) {
        int type = type();
        if (bArr != null && bArr.length % CvType.channels(type) == 0) {
            if (CvType.depth(type) != 0 && CvType.depth(type) != 1) {
                throw new UnsupportedOperationException("Mat data type is not compatible: " + type);
            }
            return nGetB(this.nativeObj, i10, i11, bArr.length, bArr);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Provided data element number (");
        sb.append(bArr == null ? 0 : bArr.length);
        sb.append(") should be multiple of the Mat channels count (");
        sb.append(CvType.channels(type));
        sb.append(")");
        throw new UnsupportedOperationException(sb.toString());
    }

    public long getNativeObjAddr() {
        return this.nativeObj;
    }

    public int height() {
        return rows();
    }

    public Mat inv(int i10) {
        return new Mat(n_inv(this.nativeObj, i10));
    }

    public boolean isContinuous() {
        return n_isContinuous(this.nativeObj);
    }

    public boolean isSubmatrix() {
        return n_isSubmatrix(this.nativeObj);
    }

    public void locateROI(Size size, Point point) {
        double[] dArr = new double[2];
        double[] dArr2 = new double[2];
        locateROI_0(this.nativeObj, dArr, dArr2);
        if (size != null) {
            size.width = dArr[0];
            size.height = dArr[1];
        }
        if (point != null) {
            point.f35882x = dArr2[0];
            point.f35883y = dArr2[1];
        }
    }

    public Mat mul(Mat mat, double d10) {
        return new Mat(n_mul(this.nativeObj, mat.nativeObj, d10));
    }

    public void push_back(Mat mat) {
        n_push_back(this.nativeObj, mat.nativeObj);
    }

    public int put(int i10, int i11, double... dArr) {
        int type = type();
        if (dArr != null && dArr.length % CvType.channels(type) == 0) {
            return nPutD(this.nativeObj, i10, i11, dArr.length, dArr);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Provided data element number (");
        sb.append(dArr == null ? 0 : dArr.length);
        sb.append(") should be multiple of the Mat channels count (");
        sb.append(CvType.channels(type));
        sb.append(")");
        throw new UnsupportedOperationException(sb.toString());
    }

    public void release() {
        n_release(this.nativeObj);
    }

    public Mat reshape(int i10, int i11) {
        return new Mat(n_reshape(this.nativeObj, i10, i11));
    }

    public Mat row(int i10) {
        return new Mat(n_row(this.nativeObj, i10));
    }

    public Mat rowRange(int i10, int i11) {
        return new Mat(n_rowRange(this.nativeObj, i10, i11));
    }

    public int rows() {
        return n_rows(this.nativeObj);
    }

    public Mat setTo(Scalar scalar) {
        long j10 = this.nativeObj;
        double[] dArr = scalar.val;
        return new Mat(n_setTo(j10, dArr[0], dArr[1], dArr[2], dArr[3]));
    }

    public Size size() {
        return new Size(n_size(this.nativeObj));
    }

    public long step1(int i10) {
        return n_step1(this.nativeObj, i10);
    }

    public Mat submat(int i10, int i11, int i12, int i13) {
        return new Mat(n_submat_rr(this.nativeObj, i10, i11, i12, i13));
    }

    public Mat t() {
        return new Mat(n_t(this.nativeObj));
    }

    public String toString() {
        String str;
        if (dims() > 0) {
            str = "";
        } else {
            str = "-1*-1*";
        }
        for (int i10 = 0; i10 < dims(); i10++) {
            str = str + size(i10) + "*";
        }
        return "Mat [ " + str + CvType.typeToString(type()) + ", isCont=" + isContinuous() + ", isSubmat=" + isSubmatrix() + ", nativeObj=0x" + Long.toHexString(this.nativeObj) + ", dataAddr=0x" + Long.toHexString(dataAddr()) + " ]";
    }

    public long total() {
        return n_total(this.nativeObj);
    }

    public int type() {
        return n_type(this.nativeObj);
    }

    public int width() {
        return cols();
    }

    public static Mat eye(Size size, int i10) {
        return new Mat(n_eye(size.width, size.height, i10));
    }

    public static Mat ones(Size size, int i10) {
        return new Mat(n_ones(size.width, size.height, i10));
    }

    public static Mat zeros(Size size, int i10) {
        return new Mat(n_zeros(size.width, size.height, i10));
    }

    public void assignTo(Mat mat) {
        n_assignTo(this.nativeObj, mat.nativeObj);
    }

    public int checkVector(int i10, int i11) {
        return n_checkVector(this.nativeObj, i10, i11);
    }

    public Mat clone() {
        return new Mat(n_clone(this.nativeObj));
    }

    public Mat colRange(Range range) {
        return new Mat(n_colRange(this.nativeObj, range.start, range.end));
    }

    public void convertTo(Mat mat, int i10, double d10) {
        n_convertTo(this.nativeObj, mat.nativeObj, i10, d10);
    }

    public void copyTo(Mat mat, Mat mat2) {
        n_copyTo(this.nativeObj, mat.nativeObj, mat2.nativeObj);
    }

    public void create(Size size, int i10) {
        n_create(this.nativeObj, size.width, size.height, i10);
    }

    public Mat diag() {
        return new Mat(n_diag(this.nativeObj, 0));
    }

    public Mat inv() {
        return new Mat(n_inv(this.nativeObj));
    }

    public Mat mul(Mat mat) {
        return new Mat(n_mul(this.nativeObj, mat.nativeObj));
    }

    public Mat reshape(int i10) {
        return new Mat(n_reshape(this.nativeObj, i10));
    }

    public Mat rowRange(Range range) {
        return new Mat(n_rowRange(this.nativeObj, range.start, range.end));
    }

    public Mat setTo(Scalar scalar, Mat mat) {
        long j10 = this.nativeObj;
        double[] dArr = scalar.val;
        return new Mat(n_setTo(j10, dArr[0], dArr[1], dArr[2], dArr[3], mat.nativeObj));
    }

    public int size(int i10) {
        return n_size_i(this.nativeObj, i10);
    }

    public long step1() {
        return n_step1(this.nativeObj);
    }

    public Mat submat(Range range, Range range2) {
        return new Mat(n_submat_rr(this.nativeObj, range.start, range.end, range2.start, range2.end));
    }

    public static Mat diag(Mat mat) {
        return new Mat(n_diag(mat.nativeObj));
    }

    public static Mat ones(int[] iArr, int i10) {
        return new Mat(n_ones(iArr.length, iArr, i10));
    }

    public static Mat zeros(int[] iArr, int i10) {
        return new Mat(n_zeros(iArr.length, iArr, i10));
    }

    public int checkVector(int i10) {
        return n_checkVector(this.nativeObj, i10);
    }

    public void convertTo(Mat mat, int i10) {
        n_convertTo(this.nativeObj, mat.nativeObj, i10);
    }

    public void create(int[] iArr, int i10) {
        n_create(this.nativeObj, iArr.length, iArr, i10);
    }

    public Mat reshape(int i10, int[] iArr) {
        return new Mat(n_reshape_1(this.nativeObj, i10, iArr.length, iArr));
    }

    public Mat setTo(Mat mat, Mat mat2) {
        return new Mat(n_setTo(this.nativeObj, mat.nativeObj, mat2.nativeObj));
    }

    public Mat submat(Range[] rangeArr) {
        return new Mat(n_submat_ranges(this.nativeObj, rangeArr));
    }

    public Mat() {
        this.nativeObj = n_Mat();
    }

    public Mat setTo(Mat mat) {
        return new Mat(n_setTo(this.nativeObj, mat.nativeObj));
    }

    public Mat submat(Rect rect) {
        return new Mat(n_submat(this.nativeObj, rect.f35887x, rect.f35888y, rect.width, rect.height));
    }

    public Mat(int i10, int i11, int i12) {
        this.nativeObj = n_Mat(i10, i11, i12);
    }

    public int put(int[] iArr, double... dArr) {
        int type = type();
        if (dArr != null && dArr.length % CvType.channels(type) == 0) {
            if (iArr.length == dims()) {
                return nPutDIdx(this.nativeObj, iArr, dArr.length, dArr);
            }
            throw new IllegalArgumentException("Incorrect number of indices");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Provided data element number (");
        sb.append(dArr == null ? 0 : dArr.length);
        sb.append(") should be multiple of the Mat channels count (");
        sb.append(CvType.channels(type));
        sb.append(")");
        throw new UnsupportedOperationException(sb.toString());
    }

    public Mat(int i10, int i11, int i12, ByteBuffer byteBuffer) {
        this.nativeObj = n_Mat(i10, i11, i12, byteBuffer);
    }

    public int get(int[] iArr, byte[] bArr) {
        int type = type();
        if (bArr != null && bArr.length % CvType.channels(type) == 0) {
            if (iArr.length == dims()) {
                if (CvType.depth(type) != 0 && CvType.depth(type) != 1) {
                    throw new UnsupportedOperationException("Mat data type is not compatible: " + type);
                }
                return nGetBIdx(this.nativeObj, iArr, bArr.length, bArr);
            }
            throw new IllegalArgumentException("Incorrect number of indices");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Provided data element number (");
        sb.append(bArr == null ? 0 : bArr.length);
        sb.append(") should be multiple of the Mat channels count (");
        sb.append(CvType.channels(type));
        sb.append(")");
        throw new UnsupportedOperationException(sb.toString());
    }

    public Mat(int i10, int i11, int i12, ByteBuffer byteBuffer, long j10) {
        this.nativeObj = n_Mat(i10, i11, i12, byteBuffer, j10);
    }

    public Mat(Size size, int i10) {
        this.nativeObj = n_Mat(size.width, size.height, i10);
    }

    public Mat(int[] iArr, int i10) {
        this.nativeObj = n_Mat(iArr.length, iArr, i10);
    }

    public int put(int i10, int i11, float[] fArr) {
        int type = type();
        if (fArr != null && fArr.length % CvType.channels(type) == 0) {
            if (CvType.depth(type) == 5) {
                return nPutF(this.nativeObj, i10, i11, fArr.length, fArr);
            }
            throw new UnsupportedOperationException("Mat data type is not compatible: " + type);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Provided data element number (");
        sb.append(fArr == null ? 0 : fArr.length);
        sb.append(") should be multiple of the Mat channels count (");
        sb.append(CvType.channels(type));
        sb.append(")");
        throw new UnsupportedOperationException(sb.toString());
    }

    public Mat(int i10, int i11, int i12, Scalar scalar) {
        double[] dArr = scalar.val;
        this.nativeObj = n_Mat(i10, i11, i12, dArr[0], dArr[1], dArr[2], dArr[3]);
    }

    public Mat(Size size, int i10, Scalar scalar) {
        double d10 = size.width;
        double d11 = size.height;
        double[] dArr = scalar.val;
        this.nativeObj = n_Mat(d10, d11, i10, dArr[0], dArr[1], dArr[2], dArr[3]);
    }

    public int get(int i10, int i11, short[] sArr) {
        int type = type();
        if (sArr != null && sArr.length % CvType.channels(type) == 0) {
            if (CvType.depth(type) != 2 && CvType.depth(type) != 3) {
                throw new UnsupportedOperationException("Mat data type is not compatible: " + type);
            }
            return nGetS(this.nativeObj, i10, i11, sArr.length, sArr);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Provided data element number (");
        sb.append(sArr == null ? 0 : sArr.length);
        sb.append(") should be multiple of the Mat channels count (");
        sb.append(CvType.channels(type));
        sb.append(")");
        throw new UnsupportedOperationException(sb.toString());
    }

    public Mat(int[] iArr, int i10, Scalar scalar) {
        int length = iArr.length;
        double[] dArr = scalar.val;
        this.nativeObj = n_Mat(length, iArr, i10, dArr[0], dArr[1], dArr[2], dArr[3]);
    }

    public Mat(Mat mat, Range range, Range range2) {
        this.nativeObj = n_Mat(mat.nativeObj, range.start, range.end, range2.start, range2.end);
    }

    public int put(int[] iArr, float[] fArr) {
        int type = type();
        if (fArr != null && fArr.length % CvType.channels(type) == 0) {
            if (iArr.length == dims()) {
                if (CvType.depth(type) == 5) {
                    return nPutFIdx(this.nativeObj, iArr, fArr.length, fArr);
                }
                throw new UnsupportedOperationException("Mat data type is not compatible: " + type);
            }
            throw new IllegalArgumentException("Incorrect number of indices");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Provided data element number (");
        sb.append(fArr == null ? 0 : fArr.length);
        sb.append(") should be multiple of the Mat channels count (");
        sb.append(CvType.channels(type));
        sb.append(")");
        throw new UnsupportedOperationException(sb.toString());
    }

    public Mat(Mat mat, Range range) {
        this.nativeObj = n_Mat(mat.nativeObj, range.start, range.end);
    }

    public Mat(Mat mat, Range[] rangeArr) {
        this.nativeObj = n_Mat(mat.nativeObj, rangeArr);
    }

    public int get(int[] iArr, short[] sArr) {
        int type = type();
        if (sArr != null && sArr.length % CvType.channels(type) == 0) {
            if (iArr.length == dims()) {
                if (CvType.depth(type) != 2 && CvType.depth(type) != 3) {
                    throw new UnsupportedOperationException("Mat data type is not compatible: " + type);
                }
                return nGetSIdx(this.nativeObj, iArr, sArr.length, sArr);
            }
            throw new IllegalArgumentException("Incorrect number of indices");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Provided data element number (");
        sb.append(sArr == null ? 0 : sArr.length);
        sb.append(") should be multiple of the Mat channels count (");
        sb.append(CvType.channels(type));
        sb.append(")");
        throw new UnsupportedOperationException(sb.toString());
    }

    public Mat(Mat mat, Rect rect) {
        long j10 = mat.nativeObj;
        int i10 = rect.f35888y;
        int i11 = i10 + rect.height;
        int i12 = rect.f35887x;
        this.nativeObj = n_Mat(j10, i10, i11, i12, i12 + rect.width);
    }

    public int put(int i10, int i11, int[] iArr) {
        int type = type();
        if (iArr != null && iArr.length % CvType.channels(type) == 0) {
            if (CvType.depth(type) == 4) {
                return nPutI(this.nativeObj, i10, i11, iArr.length, iArr);
            }
            throw new UnsupportedOperationException("Mat data type is not compatible: " + type);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Provided data element number (");
        sb.append(iArr == null ? 0 : iArr.length);
        sb.append(") should be multiple of the Mat channels count (");
        sb.append(CvType.channels(type));
        sb.append(")");
        throw new UnsupportedOperationException(sb.toString());
    }

    public int get(int i10, int i11, int[] iArr) {
        int type = type();
        if (iArr != null && iArr.length % CvType.channels(type) == 0) {
            if (CvType.depth(type) == 4) {
                return nGetI(this.nativeObj, i10, i11, iArr.length, iArr);
            }
            throw new UnsupportedOperationException("Mat data type is not compatible: " + type);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Provided data element number (");
        sb.append(iArr == null ? 0 : iArr.length);
        sb.append(") should be multiple of the Mat channels count (");
        sb.append(CvType.channels(type));
        sb.append(")");
        throw new UnsupportedOperationException(sb.toString());
    }

    public int put(int[] iArr, int[] iArr2) {
        int type = type();
        if (iArr2 != null && iArr2.length % CvType.channels(type) == 0) {
            if (iArr.length == dims()) {
                if (CvType.depth(type) == 4) {
                    return nPutIIdx(this.nativeObj, iArr, iArr2.length, iArr2);
                }
                throw new UnsupportedOperationException("Mat data type is not compatible: " + type);
            }
            throw new IllegalArgumentException("Incorrect number of indices");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Provided data element number (");
        sb.append(iArr2 == null ? 0 : iArr2.length);
        sb.append(") should be multiple of the Mat channels count (");
        sb.append(CvType.channels(type));
        sb.append(")");
        throw new UnsupportedOperationException(sb.toString());
    }

    public int get(int[] iArr, int[] iArr2) {
        int type = type();
        if (iArr2 != null && iArr2.length % CvType.channels(type) == 0) {
            if (iArr.length == dims()) {
                if (CvType.depth(type) == 4) {
                    return nGetIIdx(this.nativeObj, iArr, iArr2.length, iArr2);
                }
                throw new UnsupportedOperationException("Mat data type is not compatible: " + type);
            }
            throw new IllegalArgumentException("Incorrect number of indices");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Provided data element number (");
        sb.append(iArr2 == null ? 0 : iArr2.length);
        sb.append(") should be multiple of the Mat channels count (");
        sb.append(CvType.channels(type));
        sb.append(")");
        throw new UnsupportedOperationException(sb.toString());
    }

    public int put(int i10, int i11, short[] sArr) {
        int type = type();
        if (sArr != null && sArr.length % CvType.channels(type) == 0) {
            if (CvType.depth(type) != 2 && CvType.depth(type) != 3) {
                throw new UnsupportedOperationException("Mat data type is not compatible: " + type);
            }
            return nPutS(this.nativeObj, i10, i11, sArr.length, sArr);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Provided data element number (");
        sb.append(sArr == null ? 0 : sArr.length);
        sb.append(") should be multiple of the Mat channels count (");
        sb.append(CvType.channels(type));
        sb.append(")");
        throw new UnsupportedOperationException(sb.toString());
    }

    public int get(int i10, int i11, float[] fArr) {
        int type = type();
        if (fArr != null && fArr.length % CvType.channels(type) == 0) {
            if (CvType.depth(type) == 5) {
                return nGetF(this.nativeObj, i10, i11, fArr.length, fArr);
            }
            throw new UnsupportedOperationException("Mat data type is not compatible: " + type);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Provided data element number (");
        sb.append(fArr == null ? 0 : fArr.length);
        sb.append(") should be multiple of the Mat channels count (");
        sb.append(CvType.channels(type));
        sb.append(")");
        throw new UnsupportedOperationException(sb.toString());
    }

    public int put(int[] iArr, short[] sArr) {
        int type = type();
        if (sArr != null && sArr.length % CvType.channels(type) == 0) {
            if (iArr.length == dims()) {
                if (CvType.depth(type) != 2 && CvType.depth(type) != 3) {
                    throw new UnsupportedOperationException("Mat data type is not compatible: " + type);
                }
                return nPutSIdx(this.nativeObj, iArr, sArr.length, sArr);
            }
            throw new IllegalArgumentException("Incorrect number of indices");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Provided data element number (");
        sb.append(sArr == null ? 0 : sArr.length);
        sb.append(") should be multiple of the Mat channels count (");
        sb.append(CvType.channels(type));
        sb.append(")");
        throw new UnsupportedOperationException(sb.toString());
    }

    public int get(int[] iArr, float[] fArr) {
        int type = type();
        if (fArr != null && fArr.length % CvType.channels(type) == 0) {
            if (iArr.length == dims()) {
                if (CvType.depth(type) == 5) {
                    return nGetFIdx(this.nativeObj, iArr, fArr.length, fArr);
                }
                throw new UnsupportedOperationException("Mat data type is not compatible: " + type);
            }
            throw new IllegalArgumentException("Incorrect number of indices");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Provided data element number (");
        sb.append(fArr == null ? 0 : fArr.length);
        sb.append(") should be multiple of the Mat channels count (");
        sb.append(CvType.channels(type));
        sb.append(")");
        throw new UnsupportedOperationException(sb.toString());
    }

    public int put(int i10, int i11, byte[] bArr) {
        int type = type();
        if (bArr != null && bArr.length % CvType.channels(type) == 0) {
            if (CvType.depth(type) != 0 && CvType.depth(type) != 1) {
                throw new UnsupportedOperationException("Mat data type is not compatible: " + type);
            }
            return nPutB(this.nativeObj, i10, i11, bArr.length, bArr);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Provided data element number (");
        sb.append(bArr == null ? 0 : bArr.length);
        sb.append(") should be multiple of the Mat channels count (");
        sb.append(CvType.channels(type));
        sb.append(")");
        throw new UnsupportedOperationException(sb.toString());
    }

    public int get(int i10, int i11, double[] dArr) {
        int type = type();
        if (dArr != null && dArr.length % CvType.channels(type) == 0) {
            if (CvType.depth(type) == 6) {
                return nGetD(this.nativeObj, i10, i11, dArr.length, dArr);
            }
            throw new UnsupportedOperationException("Mat data type is not compatible: " + type);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Provided data element number (");
        sb.append(dArr == null ? 0 : dArr.length);
        sb.append(") should be multiple of the Mat channels count (");
        sb.append(CvType.channels(type));
        sb.append(")");
        throw new UnsupportedOperationException(sb.toString());
    }

    public int put(int[] iArr, byte[] bArr) {
        int type = type();
        if (bArr != null && bArr.length % CvType.channels(type) == 0) {
            if (iArr.length == dims()) {
                if (CvType.depth(type) != 0 && CvType.depth(type) != 1) {
                    throw new UnsupportedOperationException("Mat data type is not compatible: " + type);
                }
                return nPutBIdx(this.nativeObj, iArr, bArr.length, bArr);
            }
            throw new IllegalArgumentException("Incorrect number of indices");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Provided data element number (");
        sb.append(bArr == null ? 0 : bArr.length);
        sb.append(") should be multiple of the Mat channels count (");
        sb.append(CvType.channels(type));
        sb.append(")");
        throw new UnsupportedOperationException(sb.toString());
    }

    public int get(int[] iArr, double[] dArr) {
        int type = type();
        if (dArr != null && dArr.length % CvType.channels(type) == 0) {
            if (iArr.length == dims()) {
                if (CvType.depth(type) == 6) {
                    return nGetDIdx(this.nativeObj, iArr, dArr.length, dArr);
                }
                throw new UnsupportedOperationException("Mat data type is not compatible: " + type);
            }
            throw new IllegalArgumentException("Incorrect number of indices");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Provided data element number (");
        sb.append(dArr == null ? 0 : dArr.length);
        sb.append(") should be multiple of the Mat channels count (");
        sb.append(CvType.channels(type));
        sb.append(")");
        throw new UnsupportedOperationException(sb.toString());
    }

    public int put(int i10, int i11, byte[] bArr, int i12, int i13) {
        int type = type();
        if (bArr != null && i13 % CvType.channels(type) == 0) {
            if (CvType.depth(type) != 0 && CvType.depth(type) != 1) {
                throw new UnsupportedOperationException("Mat data type is not compatible: " + type);
            }
            return nPutBwOffset(this.nativeObj, i10, i11, i13, i12, bArr);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Provided data element number (");
        sb.append(bArr == null ? 0 : bArr.length);
        sb.append(") should be multiple of the Mat channels count (");
        sb.append(CvType.channels(type));
        sb.append(")");
        throw new UnsupportedOperationException(sb.toString());
    }

    public double[] get(int i10, int i11) {
        return nGet(this.nativeObj, i10, i11);
    }

    public double[] get(int[] iArr) {
        if (iArr.length == dims()) {
            return nGetIdx(this.nativeObj, iArr);
        }
        throw new IllegalArgumentException("Incorrect number of indices");
    }

    public int put(int[] iArr, byte[] bArr, int i10, int i11) {
        int type = type();
        if (bArr != null && i11 % CvType.channels(type) == 0) {
            if (iArr.length == dims()) {
                if (CvType.depth(type) != 0 && CvType.depth(type) != 1) {
                    throw new UnsupportedOperationException("Mat data type is not compatible: " + type);
                }
                return nPutBwIdxOffset(this.nativeObj, iArr, i11, i10, bArr);
            }
            throw new IllegalArgumentException("Incorrect number of indices");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Provided data element number (");
        sb.append(bArr == null ? 0 : bArr.length);
        sb.append(") should be multiple of the Mat channels count (");
        sb.append(CvType.channels(type));
        sb.append(")");
        throw new UnsupportedOperationException(sb.toString());
    }
}
