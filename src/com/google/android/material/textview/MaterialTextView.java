package com.google.android.material.textview;

import B4.a;
import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import e4.C0977c;
import e4.m;
import u4.C1606b;
import u4.C1607c;

/* loaded from: classes3.dex */
public class MaterialTextView extends AppCompatTextView {
    public MaterialTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    public static boolean b(Context context) {
        return C1606b.b(context, C0977c.f30706z0, true);
    }

    public static int d(Context context, TypedArray typedArray, int... iArr) {
        int i10 = -1;
        for (int i11 = 0; i11 < iArr.length && i10 < 0; i11++) {
            i10 = C1607c.d(context, typedArray, iArr[i11], -1);
        }
        return i10;
    }

    public static boolean e(Context context, Resources.Theme theme, AttributeSet attributeSet, int i10, int i11) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, m.f31544t6, i10, i11);
        int d10 = d(context, obtainStyledAttributes, m.f31566v6, m.f31577w6);
        obtainStyledAttributes.recycle();
        if (d10 != -1) {
            return true;
        }
        return false;
    }

    public static int findViewAppearanceResourceId(Resources.Theme theme, AttributeSet attributeSet, int i10, int i11) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, m.f31544t6, i10, i11);
        int resourceId = obtainStyledAttributes.getResourceId(m.f31555u6, -1);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    public final void a(Resources.Theme theme, int i10) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(i10, m.f31500p6);
        int d10 = d(getContext(), obtainStyledAttributes, m.f31522r6, m.f31533s6);
        obtainStyledAttributes.recycle();
        if (d10 >= 0) {
            setLineHeight(d10);
        }
    }

    public final void c(AttributeSet attributeSet, int i10, int i11) {
        int findViewAppearanceResourceId;
        Context context = getContext();
        if (b(context)) {
            Resources.Theme theme = context.getTheme();
            if (!e(context, theme, attributeSet, i10, i11) && (findViewAppearanceResourceId = findViewAppearanceResourceId(theme, attributeSet, i10, i11)) != -1) {
                a(theme, findViewAppearanceResourceId);
            }
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        if (b(context)) {
            a(context.getTheme(), i10);
        }
    }

    public MaterialTextView(Context context, AttributeSet attributeSet, int i10) {
        super(a.c(context, attributeSet, i10, 0), attributeSet, i10);
        c(attributeSet, i10, 0);
    }
}
