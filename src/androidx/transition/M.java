package androidx.transition;

import android.graphics.Matrix;
import android.view.View;

/* compiled from: ViewUtilsApi29.java */
/* loaded from: classes.dex */
public class M extends L {
    @Override // androidx.transition.I
    public float b(View view) {
        return view.getTransitionAlpha();
    }

    @Override // androidx.transition.I
    public void d(View view, Matrix matrix) {
        view.setAnimationMatrix(matrix);
    }

    @Override // androidx.transition.I
    public void e(View view, int i10, int i11, int i12, int i13) {
        view.setLeftTopRightBottom(i10, i11, i12, i13);
    }

    @Override // androidx.transition.I
    public void f(View view, float f10) {
        view.setTransitionAlpha(f10);
    }

    @Override // androidx.transition.I
    public void g(View view, int i10) {
        view.setTransitionVisibility(i10);
    }

    @Override // androidx.transition.I
    public void h(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // androidx.transition.I
    public void i(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
