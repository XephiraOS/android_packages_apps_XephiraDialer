package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

/* loaded from: classes.dex */
public class Explode extends Visibility {

    /* renamed from: d, reason: collision with root package name */
    public static final TimeInterpolator f11619d = new DecelerateInterpolator();

    /* renamed from: e, reason: collision with root package name */
    public static final TimeInterpolator f11620e = new AccelerateInterpolator();

    /* renamed from: c, reason: collision with root package name */
    public int[] f11621c;

    public Explode() {
        this.f11621c = new int[2];
        setPropagation(new C0499b());
    }

    private void captureValues(C c10) {
        View view = c10.f11528b;
        view.getLocationOnScreen(this.f11621c);
        int[] iArr = this.f11621c;
        int i10 = iArr[0];
        int i11 = iArr[1];
        c10.f11527a.put("android:explode:screenBounds", new Rect(i10, i11, view.getWidth() + i10, view.getHeight() + i11));
    }

    public static float h(float f10, float f11) {
        return (float) Math.sqrt((f10 * f10) + (f11 * f11));
    }

    public static float i(View view, int i10, int i11) {
        return h(Math.max(i10, view.getWidth() - i10), Math.max(i11, view.getHeight() - i11));
    }

    @Override // androidx.transition.Visibility
    public Animator c(ViewGroup viewGroup, View view, C c10, C c11) {
        if (c11 == null) {
            return null;
        }
        Rect rect = (Rect) c11.f11527a.get("android:explode:screenBounds");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        j(viewGroup, rect, this.f11621c);
        int[] iArr = this.f11621c;
        return E.a(view, c11, rect.left, rect.top, translationX + iArr[0], translationY + iArr[1], translationX, translationY, f11619d, this);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureEndValues(C c10) {
        super.captureEndValues(c10);
        captureValues(c10);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureStartValues(C c10) {
        super.captureStartValues(c10);
        captureValues(c10);
    }

    @Override // androidx.transition.Visibility
    public Animator e(ViewGroup viewGroup, View view, C c10, C c11) {
        float f10;
        float f11;
        if (c10 == null) {
            return null;
        }
        Rect rect = (Rect) c10.f11527a.get("android:explode:screenBounds");
        int i10 = rect.left;
        int i11 = rect.top;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) c10.f11528b.getTag(C0511n.f11733i);
        if (iArr != null) {
            f10 = (r7 - rect.left) + translationX;
            f11 = (r0 - rect.top) + translationY;
            rect.offsetTo(iArr[0], iArr[1]);
        } else {
            f10 = translationX;
            f11 = translationY;
        }
        j(viewGroup, rect, this.f11621c);
        int[] iArr2 = this.f11621c;
        return E.a(view, c10, i10, i11, translationX, translationY, f10 + iArr2[0], f11 + iArr2[1], f11620e, this);
    }

    @Override // androidx.transition.Transition
    public boolean isSeekingSupported() {
        return true;
    }

    public final void j(View view, Rect rect, int[] iArr) {
        int centerY;
        int i10;
        view.getLocationOnScreen(this.f11621c);
        int[] iArr2 = this.f11621c;
        int i11 = iArr2[0];
        int i12 = iArr2[1];
        Rect epicenter = getEpicenter();
        if (epicenter == null) {
            i10 = (view.getWidth() / 2) + i11 + Math.round(view.getTranslationX());
            centerY = (view.getHeight() / 2) + i12 + Math.round(view.getTranslationY());
        } else {
            int centerX = epicenter.centerX();
            centerY = epicenter.centerY();
            i10 = centerX;
        }
        float centerX2 = rect.centerX() - i10;
        float centerY2 = rect.centerY() - centerY;
        if (centerX2 == 0.0f && centerY2 == 0.0f) {
            centerX2 = ((float) (Math.random() * 2.0d)) - 1.0f;
            centerY2 = ((float) (Math.random() * 2.0d)) - 1.0f;
        }
        float h10 = h(centerX2, centerY2);
        float i13 = i(view, i10 - i11, centerY - i12);
        iArr[0] = Math.round((centerX2 / h10) * i13);
        iArr[1] = Math.round(i13 * (centerY2 / h10));
    }

    public Explode(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11621c = new int[2];
        setPropagation(new C0499b());
    }
}
