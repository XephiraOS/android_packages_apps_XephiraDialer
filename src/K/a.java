package K;

import android.graphics.Path;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

/* compiled from: PathInterpolatorCompat.java */
/* loaded from: classes.dex */
public final class a {

    /* compiled from: PathInterpolatorCompat.java */
    /* renamed from: K.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0034a {
        public static Interpolator a(float f10, float f11, float f12, float f13) {
            return new PathInterpolator(f10, f11, f12, f13);
        }

        public static Interpolator b(Path path) {
            return new PathInterpolator(path);
        }
    }

    public static Interpolator a(float f10, float f11, float f12, float f13) {
        return C0034a.a(f10, f11, f12, f13);
    }

    public static Interpolator b(Path path) {
        return C0034a.b(path);
    }
}
