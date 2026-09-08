package org.opencv.core;

/* loaded from: classes4.dex */
public class Point {

    /* renamed from: x, reason: collision with root package name */
    public double f35882x;

    /* renamed from: y, reason: collision with root package name */
    public double f35883y;

    public Point(double d10, double d11) {
        this.f35882x = d10;
        this.f35883y = d11;
    }

    public double dot(Point point) {
        return (this.f35882x * point.f35882x) + (this.f35883y * point.f35883y);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Point)) {
            return false;
        }
        Point point = (Point) obj;
        if (this.f35882x == point.f35882x && this.f35883y == point.f35883y) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f35882x);
        int i10 = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.f35883y);
        return (i10 * 31) + ((int) ((doubleToLongBits2 >>> 32) ^ doubleToLongBits2));
    }

    public boolean inside(Rect rect) {
        return rect.contains(this);
    }

    public void set(double[] dArr) {
        double d10;
        double d11 = 0.0d;
        if (dArr != null) {
            if (dArr.length > 0) {
                d10 = dArr[0];
            } else {
                d10 = 0.0d;
            }
            this.f35882x = d10;
            if (dArr.length > 1) {
                d11 = dArr[1];
            }
            this.f35883y = d11;
            return;
        }
        this.f35882x = 0.0d;
        this.f35883y = 0.0d;
    }

    public String toString() {
        return "{" + this.f35882x + ", " + this.f35883y + "}";
    }

    public Point clone() {
        return new Point(this.f35882x, this.f35883y);
    }

    public Point() {
        this(0.0d, 0.0d);
    }

    public Point(double[] dArr) {
        this();
        set(dArr);
    }
}
