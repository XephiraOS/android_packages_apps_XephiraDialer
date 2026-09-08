package androidx.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public class PatternPathMotion extends PathMotion {

    /* renamed from: a, reason: collision with root package name */
    public Path f11631a;

    /* renamed from: b, reason: collision with root package name */
    public final Path f11632b;

    /* renamed from: c, reason: collision with root package name */
    public final Matrix f11633c;

    public PatternPathMotion() {
        Path path = new Path();
        this.f11632b = path;
        this.f11633c = new Matrix();
        path.lineTo(1.0f, 0.0f);
        this.f11631a = path;
    }

    public static float b(float f10, float f11) {
        return (float) Math.sqrt((f10 * f10) + (f11 * f11));
    }

    @Override // androidx.transition.PathMotion
    public Path a(float f10, float f11, float f12, float f13) {
        float f14 = f12 - f10;
        float f15 = f13 - f11;
        float b10 = b(f14, f15);
        double atan2 = Math.atan2(f15, f14);
        this.f11633c.setScale(b10, b10);
        this.f11633c.postRotate((float) Math.toDegrees(atan2));
        this.f11633c.postTranslate(f10, f11);
        Path path = new Path();
        this.f11632b.transform(this.f11633c, path);
        return path;
    }

    public void c(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float[] fArr = new float[2];
        pathMeasure.getPosTan(pathMeasure.getLength(), fArr, null);
        float f10 = fArr[0];
        float f11 = fArr[1];
        pathMeasure.getPosTan(0.0f, fArr, null);
        float f12 = fArr[0];
        float f13 = fArr[1];
        if (f12 == f10 && f13 == f11) {
            throw new IllegalArgumentException("pattern must not end at the starting point");
        }
        this.f11633c.setTranslate(-f12, -f13);
        float f14 = f10 - f12;
        float f15 = f11 - f13;
        float b10 = 1.0f / b(f14, f15);
        this.f11633c.postScale(b10, b10);
        this.f11633c.postRotate((float) Math.toDegrees(-Math.atan2(f15, f14)));
        path.transform(this.f11633c, this.f11632b);
        this.f11631a = path;
    }

    public PatternPathMotion(Context context, AttributeSet attributeSet) {
        this.f11632b = new Path();
        this.f11633c = new Matrix();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.f11750k);
        try {
            String m10 = A.k.m(obtainStyledAttributes, (XmlPullParser) attributeSet, "patternPathData", 0);
            if (m10 != null) {
                c(B.d.e(m10));
                return;
            }
            throw new RuntimeException("pathData must be supplied for patternPathMotion");
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
