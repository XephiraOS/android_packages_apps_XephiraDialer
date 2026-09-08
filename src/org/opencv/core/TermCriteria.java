package org.opencv.core;

/* loaded from: classes4.dex */
public class TermCriteria {
    public static final int COUNT = 1;
    public static final int EPS = 2;
    public static final int MAX_ITER = 1;
    public double epsilon;
    public int maxCount;
    public int type;

    public TermCriteria(int i10, int i11, double d10) {
        this.type = i10;
        this.maxCount = i11;
        this.epsilon = d10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TermCriteria)) {
            return false;
        }
        TermCriteria termCriteria = (TermCriteria) obj;
        if (this.type == termCriteria.type && this.maxCount == termCriteria.maxCount && this.epsilon == termCriteria.epsilon) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.type);
        long doubleToLongBits2 = Double.doubleToLongBits(this.maxCount);
        int i10 = ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
        long doubleToLongBits3 = Double.doubleToLongBits(this.epsilon);
        return (i10 * 31) + ((int) ((doubleToLongBits3 >>> 32) ^ doubleToLongBits3));
    }

    public void set(double[] dArr) {
        int i10;
        double d10 = 0.0d;
        int i11 = 0;
        if (dArr != null) {
            if (dArr.length > 0) {
                i10 = (int) dArr[0];
            } else {
                i10 = 0;
            }
            this.type = i10;
            if (dArr.length > 1) {
                i11 = (int) dArr[1];
            }
            this.maxCount = i11;
            if (dArr.length > 2) {
                d10 = dArr[2];
            }
            this.epsilon = d10;
            return;
        }
        this.type = 0;
        this.maxCount = 0;
        this.epsilon = 0.0d;
    }

    public String toString() {
        return "{ type: " + this.type + ", maxCount: " + this.maxCount + ", epsilon: " + this.epsilon + "}";
    }

    public TermCriteria clone() {
        return new TermCriteria(this.type, this.maxCount, this.epsilon);
    }

    public TermCriteria() {
        this(0, 0, 0.0d);
    }

    public TermCriteria(double[] dArr) {
        set(dArr);
    }
}
