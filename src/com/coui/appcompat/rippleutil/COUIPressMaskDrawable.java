package com.coui.appcompat.rippleutil;

import android.graphics.Canvas;
import com.coui.appcompat.roundRect.COUIRoundDrawable;

/* loaded from: classes.dex */
public class COUIPressMaskDrawable extends COUIRoundDrawable {
    private int mCornerRadius;

    public COUIPressMaskDrawable(int i10) {
        this.mCornerRadius = i10;
    }

    @Override // com.coui.appcompat.roundRect.COUIRoundDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        setRadius(this.mCornerRadius);
        super.draw(canvas);
    }
}
