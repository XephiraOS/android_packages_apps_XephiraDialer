package com.coui.appcompat.textviewcompatutil;

import android.graphics.Canvas;
import android.graphics.Rect;
import com.coui.appcompat.roundRect.COUIRoundDrawable;

/* loaded from: classes3.dex */
public class COUITextPressMaskDrawable extends COUIRoundDrawable {
    @Override // com.coui.appcompat.roundRect.COUIRoundDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        setRadius(Math.min(bounds.right - bounds.left, bounds.bottom - bounds.top) / 2.0f);
        super.draw(canvas);
    }
}
