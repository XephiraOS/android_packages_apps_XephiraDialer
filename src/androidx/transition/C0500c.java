package androidx.transition;

import android.animation.TypeEvaluator;

/* compiled from: FloatArrayEvaluator.java */
/* renamed from: androidx.transition.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0500c implements TypeEvaluator<float[]> {

    /* renamed from: a, reason: collision with root package name */
    public float[] f11695a;

    public C0500c(float[] fArr) {
        this.f11695a = fArr;
    }

    @Override // android.animation.TypeEvaluator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public float[] evaluate(float f10, float[] fArr, float[] fArr2) {
        float[] fArr3 = this.f11695a;
        if (fArr3 == null) {
            fArr3 = new float[fArr.length];
        }
        for (int i10 = 0; i10 < fArr3.length; i10++) {
            float f11 = fArr[i10];
            fArr3[i10] = f11 + ((fArr2[i10] - f11) * f10);
        }
        return fArr3;
    }
}
