package org.opencv.core;

/* loaded from: classes4.dex */
public class Point3 {

    /* renamed from: x, reason: collision with root package name */
    public double f35884x;

    /* renamed from: y, reason: collision with root package name */
    public double f35885y;

    /* renamed from: z, reason: collision with root package name */
    public double f35886z;

    public Point3(double d10, double d11, double d12) {
        this.f35884x = d10;
        this.f35885y = d11;
        this.f35886z = d12;
    }

    public Point3 cross(Point3 point3) {
        double d10 = this.f35885y;
        double d11 = point3.f35886z;
        double d12 = this.f35886z;
        double d13 = point3.f35885y;
        double d14 = (d10 * d11) - (d12 * d13);
        double d15 = point3.f35884x;
        double d16 = this.f35884x;
        return new Point3(d14, (d12 * d15) - (d11 * d16), (d16 * d13) - (d10 * d15));
    }

    public double dot(Point3 point3) {
        return (this.f35884x * point3.f35884x) + (this.f35885y * point3.f35885y) + (this.f35886z * point3.f35886z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Point3)) {
            return false;
        }
        Point3 point3 = (Point3) obj;
        if (this.f35884x == point3.f35884x && this.f35885y == point3.f35885y && this.f35886z == point3.f35886z) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f35884x);
        long doubleToLongBits2 = Double.doubleToLongBits(this.f35885y);
        int i10 = ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
        long doubleToLongBits3 = Double.doubleToLongBits(this.f35886z);
        return (i10 * 31) + ((int) ((doubleToLongBits3 >>> 32) ^ doubleToLongBits3));
    }

    public void set(double[] dArr) {
        double d10;
        double d11;
        double d12 = 0.0d;
        if (dArr != null) {
            if (dArr.length > 0) {
                d10 = dArr[0];
            } else {
                d10 = 0.0d;
            }
            this.f35884x = d10;
            if (dArr.length > 1) {
                d11 = dArr[1];
            } else {
                d11 = 0.0d;
            }
            this.f35885y = d11;
            if (dArr.length > 2) {
                d12 = dArr[2];
            }
            this.f35886z = d12;
            return;
        }
        this.f35884x = 0.0d;
        this.f35885y = 0.0d;
        this.f35886z = 0.0d;
    }

    public String toString() {
        return "{" + this.f35884x + ", " + this.f35885y + ", " + this.f35886z + "}";
    }

    public Point3 clone() {
        return new Point3(this.f35884x, this.f35885y, this.f35886z);
    }

    public Point3() {
        this(0.0d, 0.0d, 0.0d);
    }

    public Point3(Point point) {
        this.f35884x = point.f35882x;
        this.f35885y = point.f35883y;
        this.f35886z = 0.0d;
    }

    public Point3(double[] dArr) {
        this();
        set(dArr);
    }
}
