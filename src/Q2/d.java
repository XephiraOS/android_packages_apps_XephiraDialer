package q2;

import android.view.WindowManager;
import kotlin.jvm.internal.i;

/* compiled from: WindowLayoutParams.kt */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final WindowManager.LayoutParams f36129a;

    public d(WindowManager.LayoutParams layoutParams) {
        i.f(layoutParams, "layoutParams");
        this.f36129a = layoutParams;
    }

    public final WindowManager.LayoutParams a() {
        return this.f36129a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        if (obj != this) {
            WindowManager.LayoutParams layoutParams = ((d) obj).f36129a;
            int i10 = layoutParams.height;
            WindowManager.LayoutParams layoutParams2 = this.f36129a;
            if (i10 != layoutParams2.height || layoutParams.width != layoutParams2.width || layoutParams.gravity != layoutParams2.gravity || layoutParams.windowAnimations != layoutParams2.windowAnimations) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        WindowManager.LayoutParams layoutParams = this.f36129a;
        return (((((layoutParams.height * 31) + layoutParams.width) * 31) + layoutParams.gravity) * 31) + layoutParams.windowAnimations;
    }

    public String toString() {
        return "WindowLayoutParams(layoutParams=" + this.f36129a + ')';
    }
}
