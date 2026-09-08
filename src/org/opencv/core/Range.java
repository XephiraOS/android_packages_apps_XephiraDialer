package org.opencv.core;

/* loaded from: classes4.dex */
public class Range {
    public int end;
    public int start;

    public Range(int i10, int i11) {
        this.start = i10;
        this.end = i11;
    }

    public static Range all() {
        return new Range(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean empty() {
        if (this.end <= this.start) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Range)) {
            return false;
        }
        Range range = (Range) obj;
        if (this.start == range.start && this.end == range.end) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.start);
        int i10 = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.end);
        return (i10 * 31) + ((int) ((doubleToLongBits2 >>> 32) ^ doubleToLongBits2));
    }

    public Range intersection(Range range) {
        Range range2 = new Range(Math.max(range.start, this.start), Math.min(range.end, this.end));
        range2.end = Math.max(range2.end, range2.start);
        return range2;
    }

    public void set(double[] dArr) {
        int i10;
        int i11 = 0;
        if (dArr != null) {
            if (dArr.length > 0) {
                i10 = (int) dArr[0];
            } else {
                i10 = 0;
            }
            this.start = i10;
            if (dArr.length > 1) {
                i11 = (int) dArr[1];
            }
            this.end = i11;
            return;
        }
        this.start = 0;
        this.end = 0;
    }

    public Range shift(int i10) {
        return new Range(this.start + i10, this.end + i10);
    }

    public int size() {
        if (empty()) {
            return 0;
        }
        return this.end - this.start;
    }

    public String toString() {
        return "[" + this.start + ", " + this.end + ")";
    }

    public Range clone() {
        return new Range(this.start, this.end);
    }

    public Range() {
        this(0, 0);
    }

    public Range(double[] dArr) {
        set(dArr);
    }
}
