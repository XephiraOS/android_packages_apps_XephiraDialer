package org.opencv.imgproc;

import java.util.List;
import org.opencv.core.Mat;
import org.opencv.core.MatOfFloat4;
import org.opencv.core.MatOfFloat6;
import org.opencv.core.MatOfInt;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.utils.Converters;

/* loaded from: classes4.dex */
public class Subdiv2D {
    public static final int NEXT_AROUND_DST = 34;
    public static final int NEXT_AROUND_LEFT = 19;
    public static final int NEXT_AROUND_ORG = 0;
    public static final int NEXT_AROUND_RIGHT = 49;
    public static final int PREV_AROUND_DST = 51;
    public static final int PREV_AROUND_LEFT = 32;
    public static final int PREV_AROUND_ORG = 17;
    public static final int PREV_AROUND_RIGHT = 2;
    public static final int PTLOC_ERROR = -2;
    public static final int PTLOC_INSIDE = 0;
    public static final int PTLOC_ON_EDGE = 2;
    public static final int PTLOC_OUTSIDE_RECT = -1;
    public static final int PTLOC_VERTEX = 1;
    protected final long nativeObj;

    public Subdiv2D(long j10) {
        this.nativeObj = j10;
    }

    private static native long Subdiv2D_0(int i10, int i11, int i12, int i13);

    private static native long Subdiv2D_1();

    public static Subdiv2D __fromPtr__(long j10) {
        return new Subdiv2D(j10);
    }

    private static native void delete(long j10);

    private static native int edgeDst_0(long j10, int i10, double[] dArr);

    private static native int edgeDst_1(long j10, int i10);

    private static native int edgeOrg_0(long j10, int i10, double[] dArr);

    private static native int edgeOrg_1(long j10, int i10);

    private static native int findNearest_0(long j10, double d10, double d11, double[] dArr);

    private static native int findNearest_1(long j10, double d10, double d11);

    private static native void getEdgeList_0(long j10, long j11);

    private static native int getEdge_0(long j10, int i10, int i11);

    private static native void getLeadingEdgeList_0(long j10, long j11);

    private static native void getTriangleList_0(long j10, long j11);

    private static native double[] getVertex_0(long j10, int i10, double[] dArr);

    private static native double[] getVertex_1(long j10, int i10);

    private static native void getVoronoiFacetList_0(long j10, long j11, long j12, long j13);

    private static native void initDelaunay_0(long j10, int i10, int i11, int i12, int i13);

    private static native int insert_0(long j10, double d10, double d11);

    private static native void insert_1(long j10, long j11);

    private static native int locate_0(long j10, double d10, double d11, double[] dArr, double[] dArr2);

    private static native int nextEdge_0(long j10, int i10);

    private static native int rotateEdge_0(long j10, int i10, int i11);

    private static native int symEdge_0(long j10, int i10);

    public int edgeDst(int i10, Point point) {
        double[] dArr = new double[2];
        int edgeDst_0 = edgeDst_0(this.nativeObj, i10, dArr);
        if (point != null) {
            point.f35882x = dArr[0];
            point.f35883y = dArr[1];
        }
        return edgeDst_0;
    }

    public int edgeOrg(int i10, Point point) {
        double[] dArr = new double[2];
        int edgeOrg_0 = edgeOrg_0(this.nativeObj, i10, dArr);
        if (point != null) {
            point.f35882x = dArr[0];
            point.f35883y = dArr[1];
        }
        return edgeOrg_0;
    }

    public void finalize() {
        delete(this.nativeObj);
    }

    public int findNearest(Point point, Point point2) {
        double[] dArr = new double[2];
        int findNearest_0 = findNearest_0(this.nativeObj, point.f35882x, point.f35883y, dArr);
        if (point2 != null) {
            point2.f35882x = dArr[0];
            point2.f35883y = dArr[1];
        }
        return findNearest_0;
    }

    public int getEdge(int i10, int i11) {
        return getEdge_0(this.nativeObj, i10, i11);
    }

    public void getEdgeList(MatOfFloat4 matOfFloat4) {
        getEdgeList_0(this.nativeObj, matOfFloat4.nativeObj);
    }

    public void getLeadingEdgeList(MatOfInt matOfInt) {
        getLeadingEdgeList_0(this.nativeObj, matOfInt.nativeObj);
    }

    public long getNativeObjAddr() {
        return this.nativeObj;
    }

    public void getTriangleList(MatOfFloat6 matOfFloat6) {
        getTriangleList_0(this.nativeObj, matOfFloat6.nativeObj);
    }

    public Point getVertex(int i10, int[] iArr) {
        double[] dArr = new double[1];
        Point point = new Point(getVertex_0(this.nativeObj, i10, dArr));
        if (iArr != null) {
            iArr[0] = (int) dArr[0];
        }
        return point;
    }

    public void getVoronoiFacetList(MatOfInt matOfInt, List<MatOfPoint2f> list, MatOfPoint2f matOfPoint2f) {
        Mat mat = new Mat();
        getVoronoiFacetList_0(this.nativeObj, matOfInt.nativeObj, mat.nativeObj, matOfPoint2f.nativeObj);
        Converters.Mat_to_vector_vector_Point2f(mat, list);
        mat.release();
    }

    public void initDelaunay(Rect rect) {
        initDelaunay_0(this.nativeObj, rect.f35887x, rect.f35888y, rect.width, rect.height);
    }

    public int insert(Point point) {
        return insert_0(this.nativeObj, point.f35882x, point.f35883y);
    }

    public int locate(Point point, int[] iArr, int[] iArr2) {
        double[] dArr = new double[1];
        double[] dArr2 = new double[1];
        int locate_0 = locate_0(this.nativeObj, point.f35882x, point.f35883y, dArr, dArr2);
        if (iArr != null) {
            iArr[0] = (int) dArr[0];
        }
        if (iArr2 != null) {
            iArr2[0] = (int) dArr2[0];
        }
        return locate_0;
    }

    public int nextEdge(int i10) {
        return nextEdge_0(this.nativeObj, i10);
    }

    public int rotateEdge(int i10, int i11) {
        return rotateEdge_0(this.nativeObj, i10, i11);
    }

    public int symEdge(int i10) {
        return symEdge_0(this.nativeObj, i10);
    }

    public Subdiv2D(Rect rect) {
        this.nativeObj = Subdiv2D_0(rect.f35887x, rect.f35888y, rect.width, rect.height);
    }

    public void insert(MatOfPoint2f matOfPoint2f) {
        insert_1(this.nativeObj, matOfPoint2f.nativeObj);
    }

    public Subdiv2D() {
        this.nativeObj = Subdiv2D_1();
    }

    public int edgeDst(int i10) {
        return edgeDst_1(this.nativeObj, i10);
    }

    public int edgeOrg(int i10) {
        return edgeOrg_1(this.nativeObj, i10);
    }

    public int findNearest(Point point) {
        return findNearest_1(this.nativeObj, point.f35882x, point.f35883y);
    }

    public Point getVertex(int i10) {
        return new Point(getVertex_1(this.nativeObj, i10));
    }
}
