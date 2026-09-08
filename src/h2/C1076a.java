package h2;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.PathInterpolator;
import kotlin.jvm.internal.i;

/* compiled from: AnswerMethodAnimationUtil.kt */
/* renamed from: h2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1076a {

    /* renamed from: a, reason: collision with root package name */
    public static final C1076a f32047a = new C1076a();

    /* renamed from: b, reason: collision with root package name */
    public static final PathInterpolator f32048b;

    /* renamed from: c, reason: collision with root package name */
    public static final PathInterpolator f32049c;

    /* renamed from: d, reason: collision with root package name */
    public static final PathInterpolator f32050d;

    /* renamed from: e, reason: collision with root package name */
    public static final PathInterpolator f32051e;

    static {
        PathInterpolator pathInterpolator = new PathInterpolator(0.4f, 0.0f, 0.6f, 1.0f);
        f32048b = pathInterpolator;
        f32049c = pathInterpolator;
        f32050d = pathInterpolator;
        f32051e = new PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f);
    }

    public final ViewPropertyAnimator a(View view) {
        i.f(view, "view");
        ViewPropertyAnimator interpolator = view.animate().translationY(0.0f).rotation(0.0f).setInterpolator(f32050d);
        i.e(interpolator, "view.animate().translati…K_ANIMATION_INTERPOLATOR)");
        return interpolator;
    }

    public final ViewPropertyAnimator b(View view) {
        i.f(view, "view");
        ViewPropertyAnimator duration = view.animate().alpha(0.0f).setInterpolator(f32049c).setDuration(250L);
        i.e(duration, "view.animate().alpha(HID…_VIEW_ANIMATION_DURATION)");
        return duration;
    }

    public final ObjectAnimator c(View view) {
        i.f(view, "view");
        ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofKeyframe(View.ROTATION, Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.0625f, -5.0f), Keyframe.ofFloat(0.1875f, 5.0f), Keyframe.ofFloat(0.3125f, -5.0f), Keyframe.ofFloat(0.4375f, 5.0f), Keyframe.ofFloat(0.5625f, -5.0f), Keyframe.ofFloat(0.6875f, 5.0f), Keyframe.ofFloat(0.8125f, -5.0f), Keyframe.ofFloat(0.9375f, 5.0f), Keyframe.ofFloat(1.0f, 0.0f))).setDuration(664L);
        i.e(duration, "ofPropertyValuesHolder(v…_WAVE_ANIMATION_DURATION)");
        return duration;
    }
}
