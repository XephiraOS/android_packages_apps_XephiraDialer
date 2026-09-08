package org.opencv.core;

/* loaded from: classes4.dex */
public class KeyPoint {
    public float angle;
    public int class_id;
    public int octave;
    public Point pt;
    public float response;
    public float size;

    public KeyPoint(float f10, float f11, float f12, float f13, float f14, int i10, int i11) {
        this.pt = new Point(f10, f11);
        this.size = f12;
        this.angle = f13;
        this.response = f14;
        this.octave = i10;
        this.class_id = i11;
    }

    public String toString() {
        return "KeyPoint [pt=" + this.pt + ", size=" + this.size + ", angle=" + this.angle + ", response=" + this.response + ", octave=" + this.octave + ", class_id=" + this.class_id + "]";
    }

    public KeyPoint() {
        this(0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0, -1);
    }

    public KeyPoint(float f10, float f11, float f12, float f13, float f14, int i10) {
        this(f10, f11, f12, f13, f14, i10, -1);
    }

    public KeyPoint(float f10, float f11, float f12, float f13, float f14) {
        this(f10, f11, f12, f13, f14, 0, -1);
    }

    public KeyPoint(float f10, float f11, float f12, float f13) {
        this(f10, f11, f12, f13, 0.0f, 0, -1);
    }

    public KeyPoint(float f10, float f11, float f12) {
        this(f10, f11, f12, -1.0f, 0.0f, 0, -1);
    }
}
