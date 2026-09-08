package org.opencv.core;

/* loaded from: classes4.dex */
public class Rect2d {
    public double height;
    public double width;

    /* renamed from: x, reason: collision with root package name */
    public double f35889x;

    /* renamed from: y, reason: collision with root package name */
    public double f35890y;

    public Rect2d(double d10, double d11, double d12, double d13) {
        this.f35889x = d10;
        this.f35890y = d11;
        this.width = d12;
        this.height = d13;
    }

    public double area() {
        return this.width * this.height;
    }

    public Point br() {
        return new Point(this.f35889x + this.width, this.f35890y + this.height);
    }

    public boolean contains(Point point) {
        double d10 = this.f35889x;
        double d11 = point.f35882x;
        if (d10 <= d11 && d11 < d10 + this.width) {
            double d12 = this.f35890y;
            double d13 = point.f35883y;
            if (d12 <= d13 && d13 < d12 + this.height) {
                return true;
            }
        }
        return false;
    }

    public boolean empty() {
        if (this.width > 0.0d && this.height > 0.0d) {
            return false;
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Rect2d)) {
            return false;
        }
        Rect2d rect2d = (Rect2d) obj;
        if (this.f35889x == rect2d.f35889x && this.f35890y == rect2d.f35890y && this.width == rect2d.width && this.height == rect2d.height) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.height);
        long doubleToLongBits2 = Double.doubleToLongBits(this.width);
        int i10 = ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
        long doubleToLongBits3 = Double.doubleToLongBits(this.f35889x);
        int i11 = (i10 * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)));
        long doubleToLongBits4 = Double.doubleToLongBits(this.f35890y);
        return (i11 * 31) + ((int) ((doubleToLongBits4 >>> 32) ^ doubleToLongBits4));
    }

    public void set(double[] dArr) {
        double d10;
        double d11;
        double d12;
        double d13 = 0.0d;
        if (dArr != null) {
            if (dArr.length > 0) {
                d10 = dArr[0];
            } else {
                d10 = 0.0d;
            }
            this.f35889x = d10;
            if (dArr.length > 1) {
                d11 = dArr[1];
            } else {
                d11 = 0.0d;
            }
            this.f35890y = d11;
            if (dArr.length > 2) {
                d12 = dArr[2];
            } else {
                d12 = 0.0d;
            }
            this.width = d12;
            if (dArr.length > 3) {
                d13 = dArr[3];
            }
            this.height = d13;
            return;
        }
        this.f35889x = 0.0d;
        this.f35890y = 0.0d;
        this.width = 0.0d;
        this.height = 0.0d;
    }

    public Size size() {
        return new Size(this.width, this.height);
    }

    public Point tl() {
        return new Point(this.f35889x, this.f35890y);
    }

    public String toString() {
        return "{" + this.f35889x + ", " + this.f35890y + ", " + this.width + "x" + this.height + "}";
    }

    public Rect2d clone() {
        return new Rect2d(this.f35889x, this.f35890y, this.width, this.height);
    }

    public Rect2d() {
        this(0.0d, 0.0d, 0.0d, 0.0d);
    }

    public Rect2d(Point point, Point point2) {
        double d10 = point.f35882x;
        double d11 = point2.f35882x;
        double d12 = d10 < d11 ? d10 : d11;
        this.f35889x = d12;
        double d13 = point.f35883y;
        double d14 = point2.f35883y;
        double d15 = d13 < d14 ? d13 : d14;
        this.f35890y = d15;
        this.width = (d10 <= d11 ? d11 : d10) - d12;
        this.height = (d13 <= d14 ? d14 : d13) - d15;
    }

    public Rect2d(Point point, Size size) {
        this(point.f35882x, point.f35883y, size.width, size.height);
    }

    public Rect2d(double[] dArr) {
        set(dArr);
    }
}
