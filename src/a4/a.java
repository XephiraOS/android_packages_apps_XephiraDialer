package A4;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.tabs.TabLayout;
import f4.C1001b;

/* compiled from: ElasticTabIndicatorInterpolator.java */
/* loaded from: classes3.dex */
public class a extends com.google.android.material.tabs.a {
    public static float e(float f10) {
        return (float) (1.0d - Math.cos((f10 * 3.141592653589793d) / 2.0d));
    }

    public static float f(float f10) {
        return (float) Math.sin((f10 * 3.141592653589793d) / 2.0d);
    }

    @Override // com.google.android.material.tabs.a
    public void d(TabLayout tabLayout, View view, View view2, float f10, Drawable drawable) {
        float f11;
        float e10;
        RectF a10 = com.google.android.material.tabs.a.a(tabLayout, view);
        RectF a11 = com.google.android.material.tabs.a.a(tabLayout, view2);
        if (a10.left < a11.left) {
            f11 = e(f10);
            e10 = f(f10);
        } else {
            f11 = f(f10);
            e10 = e(f10);
        }
        drawable.setBounds(C1001b.c((int) a10.left, (int) a11.left, f11), drawable.getBounds().top, C1001b.c((int) a10.right, (int) a11.right, e10), drawable.getBounds().bottom);
    }
}
