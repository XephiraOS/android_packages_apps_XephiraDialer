package f4;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

/* compiled from: MatrixEvaluator.java */
/* renamed from: f4.h, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1007h implements TypeEvaluator<Matrix> {

    /* renamed from: a, reason: collision with root package name */
    public final float[] f31712a = new float[9];

    /* renamed from: b, reason: collision with root package name */
    public final float[] f31713b = new float[9];

    /* renamed from: c, reason: collision with root package name */
    public final Matrix f31714c = new Matrix();

    public Matrix a(float f10, Matrix matrix, Matrix matrix2) {
        matrix.getValues(this.f31712a);
        matrix2.getValues(this.f31713b);
        for (int i10 = 0; i10 < 9; i10++) {
            float[] fArr = this.f31713b;
            float f11 = fArr[i10];
            float f12 = this.f31712a[i10];
            fArr[i10] = f12 + ((f11 - f12) * f10);
        }
        this.f31714c.setValues(this.f31713b);
        return this.f31714c;
    }
}
