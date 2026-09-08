package org.opencv.core;

/* loaded from: classes4.dex */
public class RotatedRect {
    public double angle;
    public Point center;
    public Size size;

    public RotatedRect() {
        this.center = new Point();
        this.size = new Size();
        this.angle = 0.0d;
    }

    public Rect boundingRect() {
        Point[] pointArr = new Point[4];
        points(pointArr);
        Rect rect = new Rect((int) Math.floor(Math.min(Math.min(Math.min(pointArr[0].f35882x, pointArr[1].f35882x), pointArr[2].f35882x), pointArr[3].f35882x)), (int) Math.floor(Math.min(Math.min(Math.min(pointArr[0].f35883y, pointArr[1].f35883y), pointArr[2].f35883y), pointArr[3].f35883y)), (int) Math.ceil(Math.max(Math.max(Math.max(pointArr[0].f35882x, pointArr[1].f35882x), pointArr[2].f35882x), pointArr[3].f35882x)), (int) Math.ceil(Math.max(Math.max(Math.max(pointArr[0].f35883y, pointArr[1].f35883y), pointArr[2].f35883y), pointArr[3].f35883y)));
        rect.width -= rect.f35887x - 1;
        rect.height -= rect.f35888y - 1;
        return rect;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RotatedRect)) {
            return false;
        }
        RotatedRect rotatedRect = (RotatedRect) obj;
        if (this.center.equals(rotatedRect.center) && this.size.equals(rotatedRect.size) && this.angle == rotatedRect.angle) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.center.f35882x);
        long doubleToLongBits2 = Double.doubleToLongBits(this.center.f35883y);
        int i10 = ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
        long doubleToLongBits3 = Double.doubleToLongBits(this.size.width);
        int i11 = (i10 * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)));
        long doubleToLongBits4 = Double.doubleToLongBits(this.size.height);
        int i12 = (i11 * 31) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)));
        long doubleToLongBits5 = Double.doubleToLongBits(this.angle);
        return (i12 * 31) + ((int) ((doubleToLongBits5 >>> 32) ^ doubleToLongBits5));
    }

    public void points(Point[] pointArr) {
        double d10 = (this.angle * 3.141592653589793d) / 180.0d;
        double cos = Math.cos(d10) * 0.5d;
        double sin = Math.sin(d10) * 0.5d;
        Point point = this.center;
        double d11 = point.f35882x;
        Size size = this.size;
        double d12 = size.height;
        double d13 = size.width;
        pointArr[0] = new Point((d11 - (sin * d12)) - (cos * d13), (point.f35883y + (d12 * cos)) - (d13 * sin));
        Point point2 = this.center;
        double d14 = point2.f35882x;
        Size size2 = this.size;
        double d15 = size2.height;
        double d16 = size2.width;
        pointArr[1] = new Point((d14 + (sin * d15)) - (cos * d16), (point2.f35883y - (cos * d15)) - (sin * d16));
        Point point3 = this.center;
        double d17 = point3.f35882x * 2.0d;
        Point point4 = pointArr[0];
        pointArr[2] = new Point(d17 - point4.f35882x, (point3.f35883y * 2.0d) - point4.f35883y);
        Point point5 = this.center;
        double d18 = point5.f35882x * 2.0d;
        Point point6 = pointArr[1];
        pointArr[3] = new Point(d18 - point6.f35882x, (point5.f35883y * 2.0d) - point6.f35883y);
    }

    public void set(double[] dArr) {
        double d10;
        double d11;
        double d12;
        double d13;
        double d14 = 0.0d;
        if (dArr != null) {
            Point point = this.center;
            if (dArr.length > 0) {
                d10 = dArr[0];
            } else {
                d10 = 0.0d;
            }
            point.f35882x = d10;
            if (dArr.length > 1) {
                d11 = dArr[1];
            } else {
                d11 = 0.0d;
            }
            point.f35883y = d11;
            Size size = this.size;
            if (dArr.length > 2) {
                d12 = dArr[2];
            } else {
                d12 = 0.0d;
            }
            size.width = d12;
            if (dArr.length > 3) {
                d13 = dArr[3];
            } else {
                d13 = 0.0d;
            }
            size.height = d13;
            if (dArr.length > 4) {
                d14 = dArr[4];
            }
            this.angle = d14;
            return;
        }
        Point point2 = this.center;
        point2.f35882x = 0.0d;
        point2.f35883y = 0.0d;
        Size size2 = this.size;
        size2.width = 0.0d;
        size2.height = 0.0d;
        this.angle = 0.0d;
    }

    public String toString() {
        return "{ " + this.center + " " + this.size + " * " + this.angle + " }";
    }

    public RotatedRect clone() {
        return new RotatedRect(this.center, this.size, this.angle);
    }

    public RotatedRect(Point point, Size size, double d10) {
        this.center = point.clone();
        this.size = size.clone();
        this.angle = d10;
    }

    public RotatedRect(double[] dArr) {
        this();
        set(dArr);
    }
}
