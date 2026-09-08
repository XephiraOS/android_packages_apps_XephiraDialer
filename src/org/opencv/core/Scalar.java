package org.opencv.core;

import java.util.Arrays;

/* loaded from: classes4.dex */
public class Scalar {
    public double[] val;

    public Scalar(double d10, double d11, double d12, double d13) {
        this.val = new double[]{d10, d11, d12, d13};
    }

    public static Scalar all(double d10) {
        return new Scalar(d10, d10, d10, d10);
    }

    public Scalar conj() {
        double[] dArr = this.val;
        return new Scalar(dArr[0], -dArr[1], -dArr[2], -dArr[3]);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof Scalar) && Arrays.equals(this.val, ((Scalar) obj).val)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return 31 + Arrays.hashCode(this.val);
    }

    public boolean isReal() {
        double[] dArr = this.val;
        if (dArr[1] == 0.0d && dArr[2] == 0.0d && dArr[3] == 0.0d) {
            return true;
        }
        return false;
    }

    public Scalar mul(Scalar scalar, double d10) {
        double[] dArr = this.val;
        double d11 = dArr[0];
        double[] dArr2 = scalar.val;
        return new Scalar(d11 * dArr2[0] * d10, dArr[1] * dArr2[1] * d10, dArr[2] * dArr2[2] * d10, dArr[3] * dArr2[3] * d10);
    }

    public void set(double[] dArr) {
        double d10;
        double d11;
        double d12;
        double d13 = 0.0d;
        if (dArr != null) {
            double[] dArr2 = this.val;
            if (dArr.length > 0) {
                d10 = dArr[0];
            } else {
                d10 = 0.0d;
            }
            dArr2[0] = d10;
            if (dArr.length > 1) {
                d11 = dArr[1];
            } else {
                d11 = 0.0d;
            }
            dArr2[1] = d11;
            if (dArr.length > 2) {
                d12 = dArr[2];
            } else {
                d12 = 0.0d;
            }
            dArr2[2] = d12;
            if (dArr.length > 3) {
                d13 = dArr[3];
            }
            dArr2[3] = d13;
            return;
        }
        double[] dArr3 = this.val;
        dArr3[3] = 0.0d;
        dArr3[2] = 0.0d;
        dArr3[1] = 0.0d;
        dArr3[0] = 0.0d;
    }

    public String toString() {
        return "[" + this.val[0] + ", " + this.val[1] + ", " + this.val[2] + ", " + this.val[3] + "]";
    }

    public Scalar clone() {
        return new Scalar(this.val);
    }

    public Scalar mul(Scalar scalar) {
        return mul(scalar, 1.0d);
    }

    public Scalar(double d10, double d11, double d12) {
        this.val = new double[]{d10, d11, d12, 0.0d};
    }

    public Scalar(double d10, double d11) {
        this.val = new double[]{d10, d11, 0.0d, 0.0d};
    }

    public Scalar(double d10) {
        this.val = new double[]{d10, 0.0d, 0.0d, 0.0d};
    }

    public Scalar(double[] dArr) {
        if (dArr != null && dArr.length == 4) {
            this.val = (double[]) dArr.clone();
        } else {
            this.val = new double[4];
            set(dArr);
        }
    }
}
