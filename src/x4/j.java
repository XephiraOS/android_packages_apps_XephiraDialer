package x4;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.internal.ViewUtils;

/* compiled from: MaterialShapeUtils.java */
/* loaded from: classes3.dex */
public class j {
    public static e a(int i10) {
        if (i10 != 0) {
            if (i10 != 1) {
                return b();
            }
            return new f();
        }
        return new m();
    }

    public static e b() {
        return new m();
    }

    public static g c() {
        return new g();
    }

    public static void d(View view, float f10) {
        Drawable background = view.getBackground();
        if (background instanceof i) {
            ((i) background).setElevation(f10);
        }
    }

    public static void e(View view) {
        Drawable background = view.getBackground();
        if (background instanceof i) {
            f(view, (i) background);
        }
    }

    public static void f(View view, i iVar) {
        if (iVar.isElevationOverlayEnabled()) {
            iVar.setParentAbsoluteElevation(ViewUtils.getParentAbsoluteElevation(view));
        }
    }
}
