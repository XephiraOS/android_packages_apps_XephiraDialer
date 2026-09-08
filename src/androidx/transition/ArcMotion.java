package androidx.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public class ArcMotion extends PathMotion {

    /* renamed from: g, reason: collision with root package name */
    public static final float f11516g = (float) Math.tan(Math.toRadians(35.0d));

    /* renamed from: a, reason: collision with root package name */
    public float f11517a;

    /* renamed from: b, reason: collision with root package name */
    public float f11518b;

    /* renamed from: c, reason: collision with root package name */
    public float f11519c;

    /* renamed from: d, reason: collision with root package name */
    public float f11520d;

    /* renamed from: e, reason: collision with root package name */
    public float f11521e;

    /* renamed from: f, reason: collision with root package name */
    public float f11522f;

    public ArcMotion() {
        this.f11517a = 0.0f;
        this.f11518b = 0.0f;
        this.f11519c = 70.0f;
        this.f11520d = 0.0f;
        this.f11521e = 0.0f;
        this.f11522f = f11516g;
    }

    public static float e(float f10) {
        if (f10 >= 0.0f && f10 <= 90.0f) {
            return (float) Math.tan(Math.toRadians(f10 / 2.0f));
        }
        throw new IllegalArgumentException("Arc must be between 0 and 90 degrees");
    }

    @Override // androidx.transition.PathMotion
    public Path a(float f10, float f11, float f12, float f13) {
        boolean z10;
        float f14;
        float f15;
        float f16;
        Path path = new Path();
        path.moveTo(f10, f11);
        float f17 = f12 - f10;
        float f18 = f13 - f11;
        float f19 = (f17 * f17) + (f18 * f18);
        float f20 = (f10 + f12) / 2.0f;
        float f21 = (f11 + f13) / 2.0f;
        float f22 = 0.25f * f19;
        if (f11 > f13) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (Math.abs(f17) < Math.abs(f18)) {
            float abs = Math.abs(f19 / (f18 * 2.0f));
            if (z10) {
                f15 = abs + f13;
                f14 = f12;
            } else {
                f15 = abs + f11;
                f14 = f10;
            }
            f16 = this.f11521e;
        } else {
            float f23 = f19 / (f17 * 2.0f);
            if (z10) {
                f15 = f11;
                f14 = f23 + f10;
            } else {
                f14 = f12 - f23;
                f15 = f13;
            }
            f16 = this.f11520d;
        }
        float f24 = f22 * f16 * f16;
        float f25 = f20 - f14;
        float f26 = f21 - f15;
        float f27 = (f25 * f25) + (f26 * f26);
        float f28 = this.f11522f;
        float f29 = f22 * f28 * f28;
        if (f27 >= f24) {
            if (f27 > f29) {
                f24 = f29;
            } else {
                f24 = 0.0f;
            }
        }
        if (f24 != 0.0f) {
            float sqrt = (float) Math.sqrt(f24 / f27);
            f14 = ((f14 - f20) * sqrt) + f20;
            f15 = f21 + (sqrt * (f15 - f21));
        }
        path.cubicTo((f10 + f14) / 2.0f, (f11 + f15) / 2.0f, (f14 + f12) / 2.0f, (f15 + f13) / 2.0f, f12, f13);
        return path;
    }

    public void b(float f10) {
        this.f11519c = f10;
        this.f11522f = e(f10);
    }

    public void c(float f10) {
        this.f11517a = f10;
        this.f11520d = e(f10);
    }

    public void d(float f10) {
        this.f11518b = f10;
        this.f11521e = e(f10);
    }

    public ArcMotion(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11517a = 0.0f;
        this.f11518b = 0.0f;
        this.f11519c = 70.0f;
        this.f11520d = 0.0f;
        this.f11521e = 0.0f;
        this.f11522f = f11516g;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.f11749j);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        d(A.k.j(obtainStyledAttributes, xmlPullParser, "minimumVerticalAngle", 1, 0.0f));
        c(A.k.j(obtainStyledAttributes, xmlPullParser, "minimumHorizontalAngle", 0, 0.0f));
        b(A.k.j(obtainStyledAttributes, xmlPullParser, "maximumAngle", 2, 70.0f));
        obtainStyledAttributes.recycle();
    }
}
