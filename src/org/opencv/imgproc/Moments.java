package org.opencv.imgproc;

/* loaded from: classes4.dex */
public class Moments {
    public double m00;
    public double m01;
    public double m02;
    public double m03;
    public double m10;
    public double m11;
    public double m12;
    public double m20;
    public double m21;
    public double m30;
    public double mu02;
    public double mu03;
    public double mu11;
    public double mu12;
    public double mu20;
    public double mu21;
    public double mu30;
    public double nu02;
    public double nu03;
    public double nu11;
    public double nu12;
    public double nu20;
    public double nu21;
    public double nu30;

    public Moments(double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17, double d18, double d19) {
        this.m00 = d10;
        this.m10 = d11;
        this.m01 = d12;
        this.m20 = d13;
        this.m11 = d14;
        this.m02 = d15;
        this.m30 = d16;
        this.m21 = d17;
        this.m12 = d18;
        this.m03 = d19;
        completeState();
    }

    public void completeState() {
        double d10;
        double d11;
        double d12;
        if (Math.abs(this.m00) > 1.0E-8d) {
            d10 = 1.0d / this.m00;
            d11 = this.m10 * d10;
            d12 = this.m01 * d10;
        } else {
            d10 = 0.0d;
            d11 = 0.0d;
            d12 = 0.0d;
        }
        double d13 = this.m20;
        double d14 = this.m10;
        double d15 = d13 - (d14 * d11);
        double d16 = this.m11 - (d14 * d12);
        double d17 = this.m02;
        double d18 = d10;
        double d19 = this.m01;
        double d20 = d17 - (d19 * d12);
        this.mu20 = d15;
        this.mu11 = d16;
        this.mu02 = d20;
        this.mu30 = this.m30 - (((d15 * 3.0d) + (d11 * d14)) * d11);
        double d21 = d16 + d16;
        this.mu21 = (this.m21 - ((d21 + (d11 * d19)) * d11)) - (d15 * d12);
        this.mu12 = (this.m12 - ((d21 + (d14 * d12)) * d12)) - (d11 * d20);
        this.mu03 = this.m03 - (d12 * ((d20 * 3.0d) + (d19 * d12)));
        double d22 = d18 * d18;
        double sqrt = Math.sqrt(Math.abs(d18)) * d22;
        this.nu20 = this.mu20 * d22;
        this.nu11 = this.mu11 * d22;
        this.nu02 = this.mu02 * d22;
        this.nu30 = this.mu30 * sqrt;
        this.nu21 = this.mu21 * sqrt;
        this.nu12 = this.mu12 * sqrt;
        this.nu03 = this.mu03 * sqrt;
    }

    public double get_m00() {
        return this.m00;
    }

    public double get_m01() {
        return this.m01;
    }

    public double get_m02() {
        return this.m02;
    }

    public double get_m03() {
        return this.m03;
    }

    public double get_m10() {
        return this.m10;
    }

    public double get_m11() {
        return this.m11;
    }

    public double get_m12() {
        return this.m12;
    }

    public double get_m20() {
        return this.m20;
    }

    public double get_m21() {
        return this.m21;
    }

    public double get_m30() {
        return this.m30;
    }

    public double get_mu02() {
        return this.mu02;
    }

    public double get_mu03() {
        return this.mu03;
    }

    public double get_mu11() {
        return this.mu11;
    }

    public double get_mu12() {
        return this.mu12;
    }

    public double get_mu20() {
        return this.mu20;
    }

    public double get_mu21() {
        return this.mu21;
    }

    public double get_mu30() {
        return this.mu30;
    }

    public double get_nu02() {
        return this.nu02;
    }

    public double get_nu03() {
        return this.nu03;
    }

    public double get_nu11() {
        return this.nu11;
    }

    public double get_nu12() {
        return this.nu12;
    }

    public double get_nu20() {
        return this.nu20;
    }

    public double get_nu21() {
        return this.nu21;
    }

    public double get_nu30() {
        return this.nu30;
    }

    public void set(double[] dArr) {
        double d10;
        double d11;
        double d12;
        double d13;
        double d14;
        double d15;
        double d16;
        double d17;
        double d18;
        double d19 = 0.0d;
        if (dArr != null) {
            if (dArr.length > 0) {
                d10 = dArr[0];
            } else {
                d10 = 0.0d;
            }
            this.m00 = d10;
            if (dArr.length > 1) {
                d11 = dArr[1];
            } else {
                d11 = 0.0d;
            }
            this.m10 = d11;
            if (dArr.length > 2) {
                d12 = dArr[2];
            } else {
                d12 = 0.0d;
            }
            this.m01 = d12;
            if (dArr.length > 3) {
                d13 = dArr[3];
            } else {
                d13 = 0.0d;
            }
            this.m20 = d13;
            if (dArr.length > 4) {
                d14 = dArr[4];
            } else {
                d14 = 0.0d;
            }
            this.m11 = d14;
            if (dArr.length > 5) {
                d15 = dArr[5];
            } else {
                d15 = 0.0d;
            }
            this.m02 = d15;
            if (dArr.length > 6) {
                d16 = dArr[6];
            } else {
                d16 = 0.0d;
            }
            this.m30 = d16;
            if (dArr.length > 7) {
                d17 = dArr[7];
            } else {
                d17 = 0.0d;
            }
            this.m21 = d17;
            if (dArr.length > 8) {
                d18 = dArr[8];
            } else {
                d18 = 0.0d;
            }
            this.m12 = d18;
            if (dArr.length > 9) {
                d19 = dArr[9];
            }
            this.m03 = d19;
            completeState();
            return;
        }
        this.m00 = 0.0d;
        this.m10 = 0.0d;
        this.m01 = 0.0d;
        this.m20 = 0.0d;
        this.m11 = 0.0d;
        this.m02 = 0.0d;
        this.m30 = 0.0d;
        this.m21 = 0.0d;
        this.m12 = 0.0d;
        this.m03 = 0.0d;
        this.mu20 = 0.0d;
        this.mu11 = 0.0d;
        this.mu02 = 0.0d;
        this.mu30 = 0.0d;
        this.mu21 = 0.0d;
        this.mu12 = 0.0d;
        this.mu03 = 0.0d;
        this.nu20 = 0.0d;
        this.nu11 = 0.0d;
        this.nu02 = 0.0d;
        this.nu30 = 0.0d;
        this.nu21 = 0.0d;
        this.nu12 = 0.0d;
        this.nu03 = 0.0d;
    }

    public void set_m00(double d10) {
        this.m00 = d10;
    }

    public void set_m01(double d10) {
        this.m01 = d10;
    }

    public void set_m02(double d10) {
        this.m02 = d10;
    }

    public void set_m03(double d10) {
        this.m03 = d10;
    }

    public void set_m10(double d10) {
        this.m10 = d10;
    }

    public void set_m11(double d10) {
        this.m11 = d10;
    }

    public void set_m12(double d10) {
        this.m12 = d10;
    }

    public void set_m20(double d10) {
        this.m20 = d10;
    }

    public void set_m21(double d10) {
        this.m21 = d10;
    }

    public void set_m30(double d10) {
        this.m30 = d10;
    }

    public void set_mu02(double d10) {
        this.mu02 = d10;
    }

    public void set_mu03(double d10) {
        this.mu03 = d10;
    }

    public void set_mu11(double d10) {
        this.mu11 = d10;
    }

    public void set_mu12(double d10) {
        this.mu12 = d10;
    }

    public void set_mu20(double d10) {
        this.mu20 = d10;
    }

    public void set_mu21(double d10) {
        this.mu21 = d10;
    }

    public void set_mu30(double d10) {
        this.mu30 = d10;
    }

    public void set_nu02(double d10) {
        this.nu02 = d10;
    }

    public void set_nu03(double d10) {
        this.nu03 = d10;
    }

    public void set_nu11(double d10) {
        this.nu11 = d10;
    }

    public void set_nu12(double d10) {
        this.nu12 = d10;
    }

    public void set_nu20(double d10) {
        this.nu20 = d10;
    }

    public void set_nu21(double d10) {
        this.nu21 = d10;
    }

    public void set_nu30(double d10) {
        this.nu30 = d10;
    }

    public String toString() {
        return "Moments [ \nm00=" + this.m00 + ", \nm10=" + this.m10 + ", m01=" + this.m01 + ", \nm20=" + this.m20 + ", m11=" + this.m11 + ", m02=" + this.m02 + ", \nm30=" + this.m30 + ", m21=" + this.m21 + ", m12=" + this.m12 + ", m03=" + this.m03 + ", \nmu20=" + this.mu20 + ", mu11=" + this.mu11 + ", mu02=" + this.mu02 + ", \nmu30=" + this.mu30 + ", mu21=" + this.mu21 + ", mu12=" + this.mu12 + ", mu03=" + this.mu03 + ", \nnu20=" + this.nu20 + ", nu11=" + this.nu11 + ", nu02=" + this.nu02 + ", \nnu30=" + this.nu30 + ", nu21=" + this.nu21 + ", nu12=" + this.nu12 + ", nu03=" + this.nu03 + ", \n]";
    }

    public Moments() {
        this(0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d);
    }

    public Moments(double[] dArr) {
        set(dArr);
    }
}
