package B4;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import e4.C0977c;
import j.C1147d;

/* compiled from: MaterialThemeOverlay.java */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f257a = {R.attr.theme, C0977c.f30629C0};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f258b = {C0977c.f30647S};

    public static int a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f257a);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
        obtainStyledAttributes.recycle();
        if (resourceId == 0) {
            return resourceId2;
        }
        return resourceId;
    }

    public static int b(Context context, AttributeSet attributeSet, int i10, int i11) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f258b, i10, i11);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    public static Context c(Context context, AttributeSet attributeSet, int i10, int i11) {
        boolean z10;
        int b10 = b(context, attributeSet, i10, i11);
        if ((context instanceof C1147d) && ((C1147d) context).c() == b10) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (b10 != 0 && !z10) {
            C1147d c1147d = new C1147d(context, b10);
            int a10 = a(context, attributeSet);
            if (a10 != 0) {
                c1147d.getTheme().applyStyle(a10, true);
            }
            return c1147d;
        }
        return context;
    }
}
