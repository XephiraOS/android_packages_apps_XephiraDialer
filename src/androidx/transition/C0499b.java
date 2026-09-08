package androidx.transition;

import android.graphics.Rect;
import android.view.ViewGroup;

/* compiled from: CircularPropagation.java */
/* renamed from: androidx.transition.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0499b extends N {

    /* renamed from: b, reason: collision with root package name */
    public float f11694b = 3.0f;

    public static float h(float f10, float f11, float f12, float f13) {
        float f14 = f12 - f10;
        float f15 = f13 - f11;
        return (float) Math.sqrt((f14 * f14) + (f15 * f15));
    }

    @Override // androidx.transition.z
    public long c(ViewGroup viewGroup, Transition transition, C c10, C c11) {
        int i10;
        int round;
        int i11;
        if (c10 == null && c11 == null) {
            return 0L;
        }
        if (c11 != null && e(c10) != 0) {
            c10 = c11;
            i10 = 1;
        } else {
            i10 = -1;
        }
        int f10 = f(c10);
        int g10 = g(c10);
        Rect epicenter = transition.getEpicenter();
        if (epicenter != null) {
            i11 = epicenter.centerX();
            round = epicenter.centerY();
        } else {
            viewGroup.getLocationOnScreen(new int[2]);
            int round2 = Math.round(r5[0] + (viewGroup.getWidth() / 2) + viewGroup.getTranslationX());
            round = Math.round(r5[1] + (viewGroup.getHeight() / 2) + viewGroup.getTranslationY());
            i11 = round2;
        }
        float h10 = h(f10, g10, i11, round) / h(0.0f, 0.0f, viewGroup.getWidth(), viewGroup.getHeight());
        long duration = transition.getDuration();
        if (duration < 0) {
            duration = 300;
        }
        return Math.round((((float) (duration * i10)) / this.f11694b) * h10);
    }
}
