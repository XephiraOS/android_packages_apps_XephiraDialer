package d4;

import android.content.res.Resources;
import android.util.TypedValue;
import android.widget.FrameLayout;

/* compiled from: Util.java */
/* renamed from: d4.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC0953a {
    public static final FrameLayout.LayoutParams a(int i10, int i11) {
        return new FrameLayout.LayoutParams(i10, i11);
    }

    public static final FrameLayout.LayoutParams b() {
        return a(-1, -1);
    }

    public static final FrameLayout.LayoutParams c() {
        return a(-1, -2);
    }

    public static final int d(float f10, Resources resources) {
        return (int) TypedValue.applyDimension(1, f10, resources.getDisplayMetrics());
    }
}
