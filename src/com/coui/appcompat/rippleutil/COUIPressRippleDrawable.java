package com.coui.appcompat.rippleutil;

import X8.c;
import X8.f;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.RippleDrawable;

/* loaded from: classes.dex */
public class COUIPressRippleDrawable extends RippleDrawable {
    private static final int TRANSPARENT = Color.parseColor("#00000000");

    /* renamed from: U, reason: collision with root package name */
    public static final int f19869U = 34;

    public COUIPressRippleDrawable(Context context, int i10) {
        this(context, i10, false);
    }

    private void initPadding(Context context) {
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(f.f4572P5);
        int dimensionPixelOffset2 = context.getResources().getDimensionPixelOffset(f.f4579Q5);
        setPadding(dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset, dimensionPixelOffset2);
    }

    private static int parseThemeColor() {
        return c.f4346E;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public COUIPressRippleDrawable(android.content.Context r4, int r5, boolean r6) {
        /*
            r3 = this;
            int r0 = parseThemeColor()
            int r0 = com.coui.appcompat.contextutil.COUIContextUtil.getAttrColor(r4, r0)
            int r1 = com.coui.appcompat.rippleutil.COUIPressRippleDrawable.TRANSPARENT
            android.content.res.ColorStateList r0 = com.coui.appcompat.statelistutil.COUIStateListUtil.createColorStateList(r0, r1)
            android.graphics.drawable.ColorDrawable r2 = new android.graphics.drawable.ColorDrawable
            r2.<init>(r1)
            com.coui.appcompat.rippleutil.COUIPressMaskDrawable r1 = new com.coui.appcompat.rippleutil.COUIPressMaskDrawable
            r1.<init>(r5)
            r3.<init>(r0, r2, r1)
            if (r6 == 0) goto L20
            r3.initPadding(r4)
        L20:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.rippleutil.COUIPressRippleDrawable.<init>(android.content.Context, int, boolean):void");
    }
}
