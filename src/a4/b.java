package A4;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.tabs.TabLayout;
import f4.C1001b;

/* compiled from: FadeTabIndicatorInterpolator.java */
/* loaded from: classes3.dex */
public class b extends com.google.android.material.tabs.a {
    @Override // com.google.android.material.tabs.a
    public void d(TabLayout tabLayout, View view, View view2, float f10, Drawable drawable) {
        float b10;
        if (f10 >= 0.5f) {
            view = view2;
        }
        RectF a10 = com.google.android.material.tabs.a.a(tabLayout, view);
        if (f10 < 0.5f) {
            b10 = C1001b.b(1.0f, 0.0f, 0.0f, 0.5f, f10);
        } else {
            b10 = C1001b.b(0.0f, 1.0f, 0.5f, 1.0f, f10);
        }
        drawable.setBounds((int) a10.left, drawable.getBounds().top, (int) a10.right, drawable.getBounds().bottom);
        drawable.setAlpha((int) (b10 * 255.0f));
    }
}
