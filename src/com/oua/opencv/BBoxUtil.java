package com.oua.opencv;

import com.oua.opencv.BBoxUtil;
import com.oua.util.Transform;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Size;

/* loaded from: classes4.dex */
public class BBoxUtil {
    public static List<Point> addDelta(List<Point> list, int i10) {
        return Arrays.asList(addDelta((Point[]) list.toArray(new Point[0]), i10));
    }

    public static Point addDeltaForP(Point[] pointArr, int i10, int i11) {
        Point point = pointArr[i10];
        Point calcDeltaVec = calcDeltaVec(point, pointArr[(i10 + 1) % pointArr.length], i11);
        Point calcDeltaVec2 = calcDeltaVec(point, pointArr[(i10 + 3) % pointArr.length], i11);
        return new Point(point.f35882x + calcDeltaVec.f35882x + calcDeltaVec2.f35882x, point.f35883y + calcDeltaVec.f35883y + calcDeltaVec2.f35883y);
    }

    public static Point calcDeltaVec(Point point, Point point2, int i10) {
        Point point3 = new Point(point.f35882x - point2.f35882x, point.f35883y - point2.f35883y);
        double norm = norm(point3);
        if (norm != 0.0d) {
            double d10 = i10;
            return new Point((point3.f35882x / norm) * d10, (point3.f35883y / norm) * d10);
        }
        return point;
    }

    public static double calcRatio(List<Point> list) {
        Size normBoxSize = normBoxSize(list);
        double d10 = normBoxSize.height;
        double d11 = normBoxSize.width;
        return Math.max(d10 / d11, d11 / d10);
    }

    public static Rect crop(Rect rect, Size size) {
        return crop(rect, new Rect(new Point(0.0d, 0.0d), size));
    }

    public static Rect externRect(Rect rect, int i10, Rect rect2) {
        int i11 = rect.f35887x - i10;
        int i12 = rect.f35888y - i10;
        int i13 = i10 * 2;
        return crop(new Rect(i11, i12, rect.width + i13 + 1, rect.height + i13 + 1), rect2);
    }

    public static Point getBottomRight(List<Point> list) {
        Point clone = list.get(0).clone();
        for (int i10 = 1; i10 < list.size(); i10++) {
            clone.f35882x = Math.max(clone.f35882x, list.get(i10).f35882x);
            clone.f35883y = Math.max(clone.f35883y, list.get(i10).f35883y);
        }
        return clone;
    }

    public static Rect getOutterBox(List<Point> list) {
        Point topLeft = getTopLeft(list);
        Point bottomRight = getBottomRight(list);
        return new Rect(topLeft, new Size(bottomRight.f35882x - topLeft.f35882x, bottomRight.f35883y - topLeft.f35883y));
    }

    public static Point getTopLeft(List<Point> list) {
        Point clone = list.get(0).clone();
        for (int i10 = 1; i10 < list.size(); i10++) {
            clone.f35882x = Math.min(clone.f35882x, list.get(i10).f35882x);
            clone.f35883y = Math.min(clone.f35883y, list.get(i10).f35883y);
        }
        return clone;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Point lambda$crop$0(Rect rect, Point point) {
        return new Point(Math.min(rect.br().f35882x, Math.max(rect.tl().f35882x, point.f35882x)), Math.min(rect.br().f35883y, Math.max(rect.tl().f35883y, point.f35883y)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Point lambda$reverseTransform$4(Transform transform, Point point) {
        return new Point(transform.reverseTransform(point.f35882x, point.f35883y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Point lambda$rotate$2(List list, int i10, int i11) {
        return (Point) list.get(((i11 + i10) + list.size()) % list.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Point lambda$toRelativeBox$1(Point point, Point point2) {
        return new Point(point2.f35882x - point.f35882x, point2.f35883y - point.f35883y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Point lambda$transform$3(Transform transform, Point point) {
        return new Point(transform.transform(point.f35882x, point.f35883y));
    }

    public static double norm(Point point) {
        return Math.sqrt(Math.pow(point.f35882x, 2.0d) + Math.pow(point.f35883y, 2.0d));
    }

    public static Size normBoxSize(List<Point> list) {
        Point point = list.get(0);
        Point point2 = list.get(1);
        Point point3 = list.get(3);
        return new Size((int) Math.sqrt(Math.pow(point2.f35882x - point.f35882x, 2.0d) + Math.pow(point2.f35883y - point.f35883y, 2.0d)), (int) Math.sqrt(Math.pow(point3.f35882x - point.f35882x, 2.0d) + Math.pow(point3.f35883y - point.f35883y, 2.0d)));
    }

    public static List<Point> rect2Points(double d10, double d11, double d12, double d13) {
        return Arrays.asList(new Point(d10, d11), new Point(d12, d11), new Point(d12, d13), new Point(d10, d13));
    }

    public static List<Point> reverseTransform(List<Point> list, final Transform transform) {
        int i10;
        List list2 = (List) list.stream().map(new Function() { // from class: W8.a
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Point lambda$reverseTransform$4;
                lambda$reverseTransform$4 = BBoxUtil.lambda$reverseTransform$4(Transform.this, (Point) obj);
                return lambda$reverseTransform$4;
            }
        }).collect(Collectors.toList());
        if (transform instanceof Transform.TransformRotate) {
            i10 = ((Transform.TransformRotate) transform).degree;
        } else if (transform instanceof Transform.TransformGroup) {
            i10 = ((Transform.TransformGroup) transform).calcRotation();
        } else {
            i10 = 0;
        }
        return rotate(list2, Transform.TransformRotate.reverseDegree(i10));
    }

    public static List<Point> rotate(final List<Point> list, int i10) {
        int i11;
        if (i10 != -90) {
            if (i10 != 90) {
                if (i10 != 180) {
                    i11 = 0;
                } else {
                    i11 = -2;
                }
            } else {
                i11 = 1;
            }
        } else {
            i11 = -1;
        }
        final int i12 = -i11;
        return (List) IntStream.range(0, list.size()).mapToObj(new IntFunction() { // from class: W8.e
            @Override // java.util.function.IntFunction
            public final Object apply(int i13) {
                Point lambda$rotate$2;
                lambda$rotate$2 = BBoxUtil.lambda$rotate$2(list, i12, i13);
                return lambda$rotate$2;
            }
        }).collect(Collectors.toList());
    }

    public static List<Point> toRelativeBox(List<Point> list) {
        return toRelativeBox(list, getTopLeft(list));
    }

    public static List<Point> transform(List<Point> list, final Transform transform) {
        int i10;
        List list2 = (List) list.stream().map(new Function() { // from class: W8.d
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Point lambda$transform$3;
                lambda$transform$3 = BBoxUtil.lambda$transform$3(Transform.this, (Point) obj);
                return lambda$transform$3;
            }
        }).collect(Collectors.toList());
        if (transform instanceof Transform.TransformRotate) {
            i10 = ((Transform.TransformRotate) transform).degree;
        } else if (transform instanceof Transform.TransformGroup) {
            i10 = ((Transform.TransformGroup) transform).calcRotation();
        } else {
            i10 = 0;
        }
        return rotate(list2, i10);
    }

    public static Point[] addDelta(Point[] pointArr, int i10) {
        return new Point[]{addDeltaForP(pointArr, 0, i10), addDeltaForP(pointArr, 1, i10), addDeltaForP(pointArr, 2, i10), addDeltaForP(pointArr, 3, i10)};
    }

    public static Rect crop(Rect rect, Rect rect2) {
        Point tl = rect.tl();
        Point br = rect.br();
        Point tl2 = rect2.tl();
        Point br2 = rect2.br();
        tl.f35882x = (int) Math.min(Math.max(tl.f35882x, tl2.f35882x), br2.f35882x);
        br.f35882x = (int) Math.min(Math.max(br.f35882x, tl2.f35882x), br2.f35882x);
        tl.f35883y = (int) Math.min(Math.max(tl.f35883y, tl2.f35883y), br2.f35883y);
        double min = (int) Math.min(Math.max(br.f35883y, tl2.f35883y), br2.f35883y);
        br.f35883y = min;
        return new Rect(tl, new Size(br.f35882x - tl.f35882x, min - tl.f35883y));
    }

    public static double norm(Point point, Point point2) {
        return Math.sqrt(Math.pow(point.f35882x - point2.f35882x, 2.0d) + Math.pow(point.f35883y - point2.f35883y, 2.0d));
    }

    public static List<Point> toRelativeBox(List<Point> list, final Point point) {
        return (List) list.stream().map(new Function() { // from class: W8.b
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Point lambda$toRelativeBox$1;
                lambda$toRelativeBox$1 = BBoxUtil.lambda$toRelativeBox$1(Point.this, (Point) obj);
                return lambda$toRelativeBox$1;
            }
        }).collect(Collectors.toList());
    }

    public static double calcRatio(List<Point> list, boolean z10) {
        return calcRatio((Point[]) list.toArray(new Point[0]), z10);
    }

    public static double calcRatio(Point[] pointArr, boolean z10) {
        double d10;
        double d11;
        Size normBoxSize = normBoxSize(pointArr);
        if (z10) {
            d10 = normBoxSize.height;
            d11 = normBoxSize.width;
        } else {
            d10 = normBoxSize.width;
            d11 = normBoxSize.height;
        }
        return d10 / d11;
    }

    public static Size normBoxSize(Point[] pointArr) {
        return normBoxSize((List<Point>) Arrays.asList(pointArr));
    }

    public static List<Point> crop(List<Point> list, final Rect rect) {
        return (List) list.stream().map(new Function() { // from class: W8.c
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Point lambda$crop$0;
                lambda$crop$0 = BBoxUtil.lambda$crop$0(Rect.this, (Point) obj);
                return lambda$crop$0;
            }
        }).collect(Collectors.toList());
    }
}
