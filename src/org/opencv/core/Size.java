package org.opencv.core;

/* loaded from: classes4.dex */
public class Size {
    public double height;
    public double width;

    public Size(double d10, double d11) {
        this.width = d10;
        this.height = d11;
    }

    public double area() {
        return this.width * this.height;
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
        if (!(obj instanceof Size)) {
            return false;
        }
        Size size = (Size) obj;
        if (this.width == size.width && this.height == size.height) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.height);
        int i10 = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.width);
        return (i10 * 31) + ((int) ((doubleToLongBits2 >>> 32) ^ doubleToLongBits2));
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
            this.width = d10;
            if (dArr.length > 1) {
                d11 = dArr[1];
            }
            this.height = d11;
            return;
        }
        this.width = 0.0d;
        this.height = 0.0d;
    }

    public String toString() {
        return ((int) this.width) + "x" + ((int) this.height);
    }

    public Size clone() {
        return new Size(this.width, this.height);
    }

    public Size() {
        this(0.0d, 0.0d);
    }

    public Size(Point point) {
        this.width = point.f35882x;
        this.height = point.f35883y;
    }

    public Size(double[] dArr) {
        set(dArr);
    }
}
