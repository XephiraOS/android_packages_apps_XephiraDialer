package org.opencv.core;

/* loaded from: classes4.dex */
public class Rect {
    public int height;
    public int width;

    /* renamed from: x, reason: collision with root package name */
    public int f35887x;

    /* renamed from: y, reason: collision with root package name */
    public int f35888y;

    public Rect(int i10, int i11, int i12, int i13) {
        this.f35887x = i10;
        this.f35888y = i11;
        this.width = i12;
        this.height = i13;
    }

    public double area() {
        return this.width * this.height;
    }

    public Point br() {
        return new Point(this.f35887x + this.width, this.f35888y + this.height);
    }

    public boolean contains(Point point) {
        double d10 = this.f35887x;
        double d11 = point.f35882x;
        if (d10 <= d11 && d11 < r0 + this.width) {
            double d12 = this.f35888y;
            double d13 = point.f35883y;
            if (d12 <= d13 && d13 < r0 + this.height) {
                return true;
            }
        }
        return false;
    }

    public boolean empty() {
        if (this.width > 0 && this.height > 0) {
            return false;
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Rect)) {
            return false;
        }
        Rect rect = (Rect) obj;
        if (this.f35887x == rect.f35887x && this.f35888y == rect.f35888y && this.width == rect.width && this.height == rect.height) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.height);
        long doubleToLongBits2 = Double.doubleToLongBits(this.width);
        int i10 = ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
        long doubleToLongBits3 = Double.doubleToLongBits(this.f35887x);
        int i11 = (i10 * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)));
        long doubleToLongBits4 = Double.doubleToLongBits(this.f35888y);
        return (i11 * 31) + ((int) ((doubleToLongBits4 >>> 32) ^ doubleToLongBits4));
    }

    public void set(double[] dArr) {
        int i10;
        int i11;
        int i12;
        int i13 = 0;
        if (dArr != null) {
            if (dArr.length > 0) {
                i10 = (int) dArr[0];
            } else {
                i10 = 0;
            }
            this.f35887x = i10;
            if (dArr.length > 1) {
                i11 = (int) dArr[1];
            } else {
                i11 = 0;
            }
            this.f35888y = i11;
            if (dArr.length > 2) {
                i12 = (int) dArr[2];
            } else {
                i12 = 0;
            }
            this.width = i12;
            if (dArr.length > 3) {
                i13 = (int) dArr[3];
            }
            this.height = i13;
            return;
        }
        this.f35887x = 0;
        this.f35888y = 0;
        this.width = 0;
        this.height = 0;
    }

    public Size size() {
        return new Size(this.width, this.height);
    }

    public Point tl() {
        return new Point(this.f35887x, this.f35888y);
    }

    public String toString() {
        return "{" + this.f35887x + ", " + this.f35888y + ", " + this.width + "x" + this.height + "}";
    }

    public Rect clone() {
        return new Rect(this.f35887x, this.f35888y, this.width, this.height);
    }

    public Rect() {
        this(0, 0, 0, 0);
    }

    public Rect(Point point, Point point2) {
        double d10 = point.f35882x;
        double d11 = point2.f35882x;
        int i10 = (int) (d10 < d11 ? d10 : d11);
        this.f35887x = i10;
        double d12 = point.f35883y;
        double d13 = point2.f35883y;
        int i11 = (int) (d12 < d13 ? d12 : d13);
        this.f35888y = i11;
        this.width = ((int) (d10 <= d11 ? d11 : d10)) - i10;
        this.height = ((int) (d12 <= d13 ? d13 : d12)) - i11;
    }

    public Rect(Point point, Size size) {
        this((int) point.f35882x, (int) point.f35883y, (int) size.width, (int) size.height);
    }

    public Rect(double[] dArr) {
        set(dArr);
    }
}
