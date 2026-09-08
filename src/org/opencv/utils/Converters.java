package org.opencv.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.opencv.core.CvType;
import org.opencv.core.DMatch;
import org.opencv.core.KeyPoint;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfDMatch;
import org.opencv.core.MatOfKeyPoint;
import org.opencv.core.MatOfPoint;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.MatOfPoint3f;
import org.opencv.core.Point;
import org.opencv.core.Point3;
import org.opencv.core.Rect;
import org.opencv.core.Rect2d;
import org.opencv.core.RotatedRect;
import org.opencv.core.Size;

/* loaded from: classes4.dex */
public class Converters {
    public static void Mat_to_vector_DMatch(Mat mat, List<DMatch> list) {
        if (list != null) {
            int rows = mat.rows();
            if (CvType.CV_64FC4 == mat.type() && mat.cols() == 1) {
                list.clear();
                double[] dArr = new double[rows * 4];
                mat.get(0, 0, dArr);
                for (int i10 = 0; i10 < rows; i10++) {
                    int i11 = i10 * 4;
                    list.add(new DMatch((int) dArr[i11], (int) dArr[i11 + 1], (int) dArr[i11 + 2], (float) dArr[i11 + 3]));
                }
                return;
            }
            throw new IllegalArgumentException("CvType.CV_64FC4 != m.type() ||  m.cols()!=1\n" + mat);
        }
        throw new IllegalArgumentException("Output List can't be null");
    }

    public static void Mat_to_vector_KeyPoint(Mat mat, List<KeyPoint> list) {
        if (list != null) {
            int rows = mat.rows();
            if (CvType.CV_64FC(7) == mat.type() && mat.cols() == 1) {
                list.clear();
                double[] dArr = new double[rows * 7];
                mat.get(0, 0, dArr);
                for (int i10 = 0; i10 < rows; i10++) {
                    int i11 = i10 * 7;
                    list.add(new KeyPoint((float) dArr[i11], (float) dArr[i11 + 1], (float) dArr[i11 + 2], (float) dArr[i11 + 3], (float) dArr[i11 + 4], (int) dArr[i11 + 5], (int) dArr[i11 + 6]));
                }
                return;
            }
            throw new IllegalArgumentException("CvType.CV_64FC(7) != m.type() ||  m.cols()!=1\n" + mat);
        }
        throw new IllegalArgumentException("Output List can't be null");
    }

    public static void Mat_to_vector_Mat(Mat mat, List<Mat> list) {
        if (list != null) {
            int rows = mat.rows();
            if (CvType.CV_32SC2 == mat.type() && mat.cols() == 1) {
                list.clear();
                mat.get(0, 0, new int[rows * 2]);
                for (int i10 = 0; i10 < rows; i10++) {
                    int i11 = i10 * 2;
                    list.add(new Mat((r1[i11] << 32) | (r1[i11 + 1] & 4294967295L)));
                }
                return;
            }
            throw new IllegalArgumentException("CvType.CV_32SC2 != m.type() ||  m.cols()!=1\n" + mat);
        }
        throw new IllegalArgumentException("mats == null");
    }

    public static void Mat_to_vector_Point(Mat mat, List<Point> list) {
        if (list != null) {
            int rows = mat.rows();
            int type = mat.type();
            if (mat.cols() == 1) {
                list.clear();
                int i10 = 0;
                if (type == CvType.CV_32SC2) {
                    mat.get(0, 0, new int[rows * 2]);
                    while (i10 < rows) {
                        int i11 = i10 * 2;
                        list.add(new Point(r1[i11], r1[i11 + 1]));
                        i10++;
                    }
                    return;
                }
                if (type == CvType.CV_32FC2) {
                    mat.get(0, 0, new float[rows * 2]);
                    while (i10 < rows) {
                        int i12 = i10 * 2;
                        list.add(new Point(r1[i12], r1[i12 + 1]));
                        i10++;
                    }
                    return;
                }
                if (type == CvType.CV_64FC2) {
                    double[] dArr = new double[rows * 2];
                    mat.get(0, 0, dArr);
                    while (i10 < rows) {
                        int i13 = i10 * 2;
                        list.add(new Point(dArr[i13], dArr[i13 + 1]));
                        i10++;
                    }
                    return;
                }
                throw new IllegalArgumentException("Input Mat should be of CV_32SC2, CV_32FC2 or CV_64FC2 type\n" + mat);
            }
            throw new IllegalArgumentException("Input Mat should have one column\n" + mat);
        }
        throw new IllegalArgumentException("Output List can't be null");
    }

    public static void Mat_to_vector_Point2d(Mat mat, List<Point> list) {
        Mat_to_vector_Point(mat, list);
    }

    public static void Mat_to_vector_Point2f(Mat mat, List<Point> list) {
        Mat_to_vector_Point(mat, list);
    }

    public static void Mat_to_vector_Point3(Mat mat, List<Point3> list) {
        if (list != null) {
            int rows = mat.rows();
            int type = mat.type();
            if (mat.cols() == 1) {
                list.clear();
                int i10 = 0;
                if (type == CvType.CV_32SC3) {
                    mat.get(0, 0, new int[rows * 3]);
                    while (i10 < rows) {
                        int i11 = i10 * 3;
                        list.add(new Point3(r1[i11], r1[i11 + 1], r1[i11 + 2]));
                        i10++;
                    }
                    return;
                }
                if (type == CvType.CV_32FC3) {
                    mat.get(0, 0, new float[rows * 3]);
                    while (i10 < rows) {
                        int i12 = i10 * 3;
                        list.add(new Point3(r1[i12], r1[i12 + 1], r1[i12 + 2]));
                        i10++;
                    }
                    return;
                }
                if (type == CvType.CV_64FC3) {
                    double[] dArr = new double[rows * 3];
                    mat.get(0, 0, dArr);
                    while (i10 < rows) {
                        int i13 = i10 * 3;
                        list.add(new Point3(dArr[i13], dArr[i13 + 1], dArr[i13 + 2]));
                        i10++;
                    }
                    return;
                }
                throw new IllegalArgumentException("Input Mat should be of CV_32SC3, CV_32FC3 or CV_64FC3 type\n" + mat);
            }
            throw new IllegalArgumentException("Input Mat should have one column\n" + mat);
        }
        throw new IllegalArgumentException("Output List can't be null");
    }

    public static void Mat_to_vector_Point3d(Mat mat, List<Point3> list) {
        Mat_to_vector_Point3(mat, list);
    }

    public static void Mat_to_vector_Point3f(Mat mat, List<Point3> list) {
        Mat_to_vector_Point3(mat, list);
    }

    public static void Mat_to_vector_Point3i(Mat mat, List<Point3> list) {
        Mat_to_vector_Point3(mat, list);
    }

    public static void Mat_to_vector_Rect(Mat mat, List<Rect> list) {
        if (list != null) {
            int rows = mat.rows();
            if (CvType.CV_32SC4 == mat.type() && mat.cols() == 1) {
                list.clear();
                int[] iArr = new int[rows * 4];
                mat.get(0, 0, iArr);
                for (int i10 = 0; i10 < rows; i10++) {
                    int i11 = i10 * 4;
                    list.add(new Rect(iArr[i11], iArr[i11 + 1], iArr[i11 + 2], iArr[i11 + 3]));
                }
                return;
            }
            throw new IllegalArgumentException("CvType.CV_32SC4 != m.type() ||  m.rows()!=1\n" + mat);
        }
        throw new IllegalArgumentException("rs == null");
    }

    public static void Mat_to_vector_Rect2d(Mat mat, List<Rect2d> list) {
        if (list != null) {
            int rows = mat.rows();
            if (CvType.CV_64FC4 == mat.type() && mat.cols() == 1) {
                list.clear();
                double[] dArr = new double[rows * 4];
                mat.get(0, 0, dArr);
                for (int i10 = 0; i10 < rows; i10++) {
                    int i11 = i10 * 4;
                    list.add(new Rect2d(dArr[i11], dArr[i11 + 1], dArr[i11 + 2], dArr[i11 + 3]));
                }
                return;
            }
            throw new IllegalArgumentException("CvType.CV_64FC4 != m.type() ||  m.rows()!=1\n" + mat);
        }
        throw new IllegalArgumentException("rs == null");
    }

    public static void Mat_to_vector_RotatedRect(Mat mat, List<RotatedRect> list) {
        if (list != null) {
            int rows = mat.rows();
            if (CvType.CV_32FC(5) == mat.type() && mat.cols() == 1) {
                list.clear();
                mat.get(0, 0, new float[rows * 5]);
                for (int i10 = 0; i10 < rows; i10++) {
                    int i11 = i10 * 5;
                    list.add(new RotatedRect(new Point(r1[i11], r1[i11 + 1]), new Size(r1[i11 + 2], r1[i11 + 3]), r1[i11 + 4]));
                }
                return;
            }
            throw new IllegalArgumentException("CvType.CV_32FC5 != m.type() ||  m.rows()!=1\n" + mat);
        }
        throw new IllegalArgumentException("rs == null");
    }

    public static void Mat_to_vector_char(Mat mat, List<Byte> list) {
        if (list != null) {
            int rows = mat.rows();
            if (CvType.CV_8SC1 == mat.type() && mat.cols() == 1) {
                list.clear();
                byte[] bArr = new byte[rows];
                mat.get(0, 0, bArr);
                for (int i10 = 0; i10 < rows; i10++) {
                    list.add(Byte.valueOf(bArr[i10]));
                }
                return;
            }
            throw new IllegalArgumentException("CvType.CV_8SC1 != m.type() ||  m.cols()!=1\n" + mat);
        }
        throw new IllegalArgumentException("Output List can't be null");
    }

    public static void Mat_to_vector_double(Mat mat, List<Double> list) {
        if (list != null) {
            int rows = mat.rows();
            if (CvType.CV_64FC1 == mat.type() && mat.cols() == 1) {
                list.clear();
                double[] dArr = new double[rows];
                mat.get(0, 0, dArr);
                for (int i10 = 0; i10 < rows; i10++) {
                    list.add(Double.valueOf(dArr[i10]));
                }
                return;
            }
            throw new IllegalArgumentException("CvType.CV_64FC1 != m.type() ||  m.cols()!=1\n" + mat);
        }
        throw new IllegalArgumentException("ds == null");
    }

    public static void Mat_to_vector_float(Mat mat, List<Float> list) {
        if (list != null) {
            int rows = mat.rows();
            if (CvType.CV_32FC1 == mat.type() && mat.cols() == 1) {
                list.clear();
                float[] fArr = new float[rows];
                mat.get(0, 0, fArr);
                for (int i10 = 0; i10 < rows; i10++) {
                    list.add(Float.valueOf(fArr[i10]));
                }
                return;
            }
            throw new IllegalArgumentException("CvType.CV_32FC1 != m.type() ||  m.cols()!=1\n" + mat);
        }
        throw new IllegalArgumentException("fs == null");
    }

    public static void Mat_to_vector_int(Mat mat, List<Integer> list) {
        if (list != null) {
            int rows = mat.rows();
            if (CvType.CV_32SC1 == mat.type() && mat.cols() == 1) {
                list.clear();
                int[] iArr = new int[rows];
                mat.get(0, 0, iArr);
                for (int i10 = 0; i10 < rows; i10++) {
                    list.add(Integer.valueOf(iArr[i10]));
                }
                return;
            }
            throw new IllegalArgumentException("CvType.CV_32SC1 != m.type() ||  m.cols()!=1\n" + mat);
        }
        throw new IllegalArgumentException("is == null");
    }

    public static void Mat_to_vector_uchar(Mat mat, List<Byte> list) {
        if (list != null) {
            int rows = mat.rows();
            if (CvType.CV_8UC1 == mat.type() && mat.cols() == 1) {
                list.clear();
                byte[] bArr = new byte[rows];
                mat.get(0, 0, bArr);
                for (int i10 = 0; i10 < rows; i10++) {
                    list.add(Byte.valueOf(bArr[i10]));
                }
                return;
            }
            throw new IllegalArgumentException("CvType.CV_8UC1 != m.type() ||  m.cols()!=1\n" + mat);
        }
        throw new IllegalArgumentException("Output List can't be null");
    }

    public static void Mat_to_vector_vector_DMatch(Mat mat, List<MatOfDMatch> list) {
        if (list != null) {
            if (mat != null) {
                ArrayList<Mat> arrayList = new ArrayList(mat.rows());
                Mat_to_vector_Mat(mat, arrayList);
                list.clear();
                for (Mat mat2 : arrayList) {
                    list.add(new MatOfDMatch(mat2));
                    mat2.release();
                }
                arrayList.clear();
                return;
            }
            throw new IllegalArgumentException("Input Mat can't be null");
        }
        throw new IllegalArgumentException("Output List can't be null");
    }

    public static void Mat_to_vector_vector_KeyPoint(Mat mat, List<MatOfKeyPoint> list) {
        if (list != null) {
            if (mat != null) {
                ArrayList<Mat> arrayList = new ArrayList(mat.rows());
                Mat_to_vector_Mat(mat, arrayList);
                for (Mat mat2 : arrayList) {
                    list.add(new MatOfKeyPoint(mat2));
                    mat2.release();
                }
                arrayList.clear();
                return;
            }
            throw new IllegalArgumentException("Input Mat can't be null");
        }
        throw new IllegalArgumentException("Output List can't be null");
    }

    public static void Mat_to_vector_vector_Point(Mat mat, List<MatOfPoint> list) {
        if (list != null) {
            if (mat != null) {
                ArrayList<Mat> arrayList = new ArrayList(mat.rows());
                Mat_to_vector_Mat(mat, arrayList);
                for (Mat mat2 : arrayList) {
                    list.add(new MatOfPoint(mat2));
                    mat2.release();
                }
                arrayList.clear();
                return;
            }
            throw new IllegalArgumentException("Input Mat can't be null");
        }
        throw new IllegalArgumentException("Output List can't be null");
    }

    public static void Mat_to_vector_vector_Point2f(Mat mat, List<MatOfPoint2f> list) {
        if (list != null) {
            if (mat != null) {
                ArrayList<Mat> arrayList = new ArrayList(mat.rows());
                Mat_to_vector_Mat(mat, arrayList);
                for (Mat mat2 : arrayList) {
                    list.add(new MatOfPoint2f(mat2));
                    mat2.release();
                }
                arrayList.clear();
                return;
            }
            throw new IllegalArgumentException("Input Mat can't be null");
        }
        throw new IllegalArgumentException("Output List can't be null");
    }

    public static void Mat_to_vector_vector_Point3f(Mat mat, List<MatOfPoint3f> list) {
        if (list != null) {
            if (mat != null) {
                ArrayList<Mat> arrayList = new ArrayList(mat.rows());
                Mat_to_vector_Mat(mat, arrayList);
                for (Mat mat2 : arrayList) {
                    list.add(new MatOfPoint3f(mat2));
                    mat2.release();
                }
                arrayList.clear();
                return;
            }
            throw new IllegalArgumentException("Input Mat can't be null");
        }
        throw new IllegalArgumentException("Output List can't be null");
    }

    public static void Mat_to_vector_vector_char(Mat mat, List<List<Byte>> list) {
        if (list != null) {
            if (mat != null) {
                ArrayList<Mat> arrayList = new ArrayList(mat.rows());
                Mat_to_vector_Mat(mat, arrayList);
                for (Mat mat2 : arrayList) {
                    ArrayList arrayList2 = new ArrayList();
                    Mat_to_vector_char(mat2, arrayList2);
                    list.add(arrayList2);
                    mat2.release();
                }
                arrayList.clear();
                return;
            }
            throw new IllegalArgumentException("Input Mat can't be null");
        }
        throw new IllegalArgumentException("Output List can't be null");
    }

    public static Mat vector_DMatch_to_Mat(List<DMatch> list) {
        int i10;
        if (list != null) {
            i10 = list.size();
        } else {
            i10 = 0;
        }
        if (i10 > 0) {
            Mat mat = new Mat(i10, 1, CvType.CV_64FC4);
            double[] dArr = new double[i10 * 4];
            for (int i11 = 0; i11 < i10; i11++) {
                DMatch dMatch = list.get(i11);
                int i12 = i11 * 4;
                dArr[i12] = dMatch.queryIdx;
                dArr[i12 + 1] = dMatch.trainIdx;
                dArr[i12 + 2] = dMatch.imgIdx;
                dArr[i12 + 3] = dMatch.distance;
            }
            mat.put(0, 0, dArr);
            return mat;
        }
        return new Mat();
    }

    public static Mat vector_KeyPoint_to_Mat(List<KeyPoint> list) {
        int i10;
        if (list != null) {
            i10 = list.size();
        } else {
            i10 = 0;
        }
        if (i10 > 0) {
            Mat mat = new Mat(i10, 1, CvType.CV_64FC(7));
            double[] dArr = new double[i10 * 7];
            for (int i11 = 0; i11 < i10; i11++) {
                int i12 = i11 * 7;
                Point point = list.get(i11).pt;
                dArr[i12] = point.f35882x;
                dArr[i12 + 1] = point.f35883y;
                dArr[i12 + 2] = r5.size;
                dArr[i12 + 3] = r5.angle;
                dArr[i12 + 4] = r5.response;
                dArr[i12 + 5] = r5.octave;
                dArr[i12 + 6] = r5.class_id;
            }
            mat.put(0, 0, dArr);
            return mat;
        }
        return new Mat();
    }

    public static Mat vector_Mat_to_Mat(List<Mat> list) {
        int i10;
        if (list != null) {
            i10 = list.size();
        } else {
            i10 = 0;
        }
        if (i10 > 0) {
            Mat mat = new Mat(i10, 1, CvType.CV_32SC2);
            int[] iArr = new int[i10 * 2];
            for (int i11 = 0; i11 < i10; i11++) {
                long j10 = list.get(i11).nativeObj;
                int i12 = i11 * 2;
                iArr[i12] = (int) (j10 >> 32);
                iArr[i12 + 1] = (int) j10;
            }
            mat.put(0, 0, iArr);
            return mat;
        }
        return new Mat();
    }

    public static Mat vector_Point2d_to_Mat(List<Point> list) {
        return vector_Point_to_Mat(list, 6);
    }

    public static Mat vector_Point2f_to_Mat(List<Point> list) {
        return vector_Point_to_Mat(list, 5);
    }

    public static Mat vector_Point3_to_Mat(List<Point3> list, int i10) {
        int i11;
        if (list != null) {
            i11 = list.size();
        } else {
            i11 = 0;
        }
        if (i11 > 0) {
            if (i10 != 4) {
                if (i10 != 5) {
                    if (i10 == 6) {
                        Mat mat = new Mat(i11, 1, CvType.CV_64FC3);
                        double[] dArr = new double[i11 * 3];
                        for (int i12 = 0; i12 < i11; i12++) {
                            Point3 point3 = list.get(i12);
                            int i13 = i12 * 3;
                            dArr[i13] = point3.f35884x;
                            dArr[i13 + 1] = point3.f35885y;
                            dArr[i13 + 2] = point3.f35886z;
                        }
                        mat.put(0, 0, dArr);
                        return mat;
                    }
                    throw new IllegalArgumentException("'typeDepth' can be CV_32S, CV_32F or CV_64F");
                }
                Mat mat2 = new Mat(i11, 1, CvType.CV_32FC3);
                float[] fArr = new float[i11 * 3];
                for (int i14 = 0; i14 < i11; i14++) {
                    Point3 point32 = list.get(i14);
                    int i15 = i14 * 3;
                    fArr[i15] = (float) point32.f35884x;
                    fArr[i15 + 1] = (float) point32.f35885y;
                    fArr[i15 + 2] = (float) point32.f35886z;
                }
                mat2.put(0, 0, fArr);
                return mat2;
            }
            Mat mat3 = new Mat(i11, 1, CvType.CV_32SC3);
            int[] iArr = new int[i11 * 3];
            for (int i16 = 0; i16 < i11; i16++) {
                Point3 point33 = list.get(i16);
                int i17 = i16 * 3;
                iArr[i17] = (int) point33.f35884x;
                iArr[i17 + 1] = (int) point33.f35885y;
                iArr[i17 + 2] = (int) point33.f35886z;
            }
            mat3.put(0, 0, iArr);
            return mat3;
        }
        return new Mat();
    }

    public static Mat vector_Point3d_to_Mat(List<Point3> list) {
        return vector_Point3_to_Mat(list, 6);
    }

    public static Mat vector_Point3f_to_Mat(List<Point3> list) {
        return vector_Point3_to_Mat(list, 5);
    }

    public static Mat vector_Point3i_to_Mat(List<Point3> list) {
        return vector_Point3_to_Mat(list, 4);
    }

    public static Mat vector_Point_to_Mat(List<Point> list) {
        return vector_Point_to_Mat(list, 4);
    }

    public static Mat vector_Rect2d_to_Mat(List<Rect2d> list) {
        int i10;
        if (list != null) {
            i10 = list.size();
        } else {
            i10 = 0;
        }
        if (i10 > 0) {
            Mat mat = new Mat(i10, 1, CvType.CV_64FC4);
            double[] dArr = new double[i10 * 4];
            for (int i11 = 0; i11 < i10; i11++) {
                Rect2d rect2d = list.get(i11);
                int i12 = i11 * 4;
                dArr[i12] = rect2d.f35889x;
                dArr[i12 + 1] = rect2d.f35890y;
                dArr[i12 + 2] = rect2d.width;
                dArr[i12 + 3] = rect2d.height;
            }
            mat.put(0, 0, dArr);
            return mat;
        }
        return new Mat();
    }

    public static Mat vector_Rect_to_Mat(List<Rect> list) {
        int i10;
        if (list != null) {
            i10 = list.size();
        } else {
            i10 = 0;
        }
        if (i10 > 0) {
            Mat mat = new Mat(i10, 1, CvType.CV_32SC4);
            int[] iArr = new int[i10 * 4];
            for (int i11 = 0; i11 < i10; i11++) {
                Rect rect = list.get(i11);
                int i12 = i11 * 4;
                iArr[i12] = rect.f35887x;
                iArr[i12 + 1] = rect.f35888y;
                iArr[i12 + 2] = rect.width;
                iArr[i12 + 3] = rect.height;
            }
            mat.put(0, 0, iArr);
            return mat;
        }
        return new Mat();
    }

    public static Mat vector_RotatedRect_to_Mat(List<RotatedRect> list) {
        int i10;
        if (list != null) {
            i10 = list.size();
        } else {
            i10 = 0;
        }
        if (i10 > 0) {
            Mat mat = new Mat(i10, 1, CvType.CV_32FC(5));
            float[] fArr = new float[i10 * 5];
            for (int i11 = 0; i11 < i10; i11++) {
                RotatedRect rotatedRect = list.get(i11);
                int i12 = i11 * 5;
                Point point = rotatedRect.center;
                fArr[i12] = (float) point.f35882x;
                fArr[i12 + 1] = (float) point.f35883y;
                Size size = rotatedRect.size;
                fArr[i12 + 2] = (float) size.width;
                fArr[i12 + 3] = (float) size.height;
                fArr[i12 + 4] = (float) rotatedRect.angle;
            }
            mat.put(0, 0, fArr);
            return mat;
        }
        return new Mat();
    }

    public static Mat vector_char_to_Mat(List<Byte> list) {
        int i10;
        if (list != null) {
            i10 = list.size();
        } else {
            i10 = 0;
        }
        if (i10 > 0) {
            Mat mat = new Mat(i10, 1, CvType.CV_8SC1);
            byte[] bArr = new byte[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                bArr[i11] = list.get(i11).byteValue();
            }
            mat.put(0, 0, bArr);
            return mat;
        }
        return new Mat();
    }

    public static Mat vector_double_to_Mat(List<Double> list) {
        int i10;
        if (list != null) {
            i10 = list.size();
        } else {
            i10 = 0;
        }
        if (i10 > 0) {
            Mat mat = new Mat(i10, 1, CvType.CV_64FC1);
            double[] dArr = new double[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                dArr[i11] = list.get(i11).doubleValue();
            }
            mat.put(0, 0, dArr);
            return mat;
        }
        return new Mat();
    }

    public static Mat vector_float_to_Mat(List<Float> list) {
        int i10;
        if (list != null) {
            i10 = list.size();
        } else {
            i10 = 0;
        }
        if (i10 > 0) {
            Mat mat = new Mat(i10, 1, CvType.CV_32FC1);
            float[] fArr = new float[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                fArr[i11] = list.get(i11).floatValue();
            }
            mat.put(0, 0, fArr);
            return mat;
        }
        return new Mat();
    }

    public static Mat vector_int_to_Mat(List<Integer> list) {
        int i10;
        if (list != null) {
            i10 = list.size();
        } else {
            i10 = 0;
        }
        if (i10 > 0) {
            Mat mat = new Mat(i10, 1, CvType.CV_32SC1);
            int[] iArr = new int[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                iArr[i11] = list.get(i11).intValue();
            }
            mat.put(0, 0, iArr);
            return mat;
        }
        return new Mat();
    }

    public static Mat vector_uchar_to_Mat(List<Byte> list) {
        int i10;
        if (list != null) {
            i10 = list.size();
        } else {
            i10 = 0;
        }
        if (i10 > 0) {
            Mat mat = new Mat(i10, 1, CvType.CV_8UC1);
            byte[] bArr = new byte[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                bArr[i11] = list.get(i11).byteValue();
            }
            mat.put(0, 0, bArr);
            return mat;
        }
        return new Mat();
    }

    public static Mat vector_vector_DMatch_to_Mat(List<MatOfDMatch> list, List<Mat> list2) {
        if (list != null && list.size() > 0) {
            Iterator<MatOfDMatch> it = list.iterator();
            while (it.hasNext()) {
                list2.add(it.next());
            }
            return vector_Mat_to_Mat(list2);
        }
        return new Mat();
    }

    public static Mat vector_vector_KeyPoint_to_Mat(List<MatOfKeyPoint> list, List<Mat> list2) {
        if (list != null && list.size() > 0) {
            Iterator<MatOfKeyPoint> it = list.iterator();
            while (it.hasNext()) {
                list2.add(it.next());
            }
            return vector_Mat_to_Mat(list2);
        }
        return new Mat();
    }

    public static Mat vector_vector_Point2f_to_Mat(List<MatOfPoint2f> list, List<Mat> list2) {
        if (list != null && list.size() > 0) {
            Iterator<MatOfPoint2f> it = list.iterator();
            while (it.hasNext()) {
                list2.add(it.next());
            }
            return vector_Mat_to_Mat(list2);
        }
        return new Mat();
    }

    public static Mat vector_vector_Point3f_to_Mat(List<MatOfPoint3f> list, List<Mat> list2) {
        if (list != null && list.size() > 0) {
            Iterator<MatOfPoint3f> it = list.iterator();
            while (it.hasNext()) {
                list2.add(it.next());
            }
            return vector_Mat_to_Mat(list2);
        }
        return new Mat();
    }

    public static Mat vector_vector_Point_to_Mat(List<MatOfPoint> list, List<Mat> list2) {
        if (list != null && list.size() > 0) {
            Iterator<MatOfPoint> it = list.iterator();
            while (it.hasNext()) {
                list2.add(it.next());
            }
            return vector_Mat_to_Mat(list2);
        }
        return new Mat();
    }

    public static Mat vector_vector_char_to_Mat(List<MatOfByte> list, List<Mat> list2) {
        if (list != null && list.size() > 0) {
            Iterator<MatOfByte> it = list.iterator();
            while (it.hasNext()) {
                list2.add(it.next());
            }
            return vector_Mat_to_Mat(list2);
        }
        return new Mat();
    }

    public static Mat vector_Point_to_Mat(List<Point> list, int i10) {
        int size = list != null ? list.size() : 0;
        if (size <= 0) {
            return new Mat();
        }
        if (i10 == 4) {
            Mat mat = new Mat(size, 1, CvType.CV_32SC2);
            int[] iArr = new int[size * 2];
            for (int i11 = 0; i11 < size; i11++) {
                Point point = list.get(i11);
                int i12 = i11 * 2;
                iArr[i12] = (int) point.f35882x;
                iArr[i12 + 1] = (int) point.f35883y;
            }
            mat.put(0, 0, iArr);
            return mat;
        }
        if (i10 == 5) {
            Mat mat2 = new Mat(size, 1, CvType.CV_32FC2);
            float[] fArr = new float[size * 2];
            for (int i13 = 0; i13 < size; i13++) {
                Point point2 = list.get(i13);
                int i14 = i13 * 2;
                fArr[i14] = (float) point2.f35882x;
                fArr[i14 + 1] = (float) point2.f35883y;
            }
            mat2.put(0, 0, fArr);
            return mat2;
        }
        if (i10 == 6) {
            Mat mat3 = new Mat(size, 1, CvType.CV_64FC2);
            double[] dArr = new double[size * 2];
            for (int i15 = 0; i15 < size; i15++) {
                Point point3 = list.get(i15);
                int i16 = i15 * 2;
                dArr[i16] = point3.f35882x;
                dArr[i16 + 1] = point3.f35883y;
            }
            mat3.put(0, 0, dArr);
            return mat3;
        }
        throw new IllegalArgumentException("'typeDepth' can be CV_32S, CV_32F or CV_64F");
    }
}
