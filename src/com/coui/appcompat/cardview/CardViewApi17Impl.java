package com.coui.appcompat.cardview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.coui.appcompat.cardview.RoundRectDrawableWithShadow;
import com.coui.appcompat.roundRect.COUIRoundRectUtil;

/* loaded from: classes.dex */
class CardViewApi17Impl extends CardViewBaseImpl {
    @Override // com.coui.appcompat.cardview.CardViewBaseImpl, com.coui.appcompat.cardview.CardViewImpl
    public void initStatic() {
        RoundRectDrawableWithShadow.setRoundRectHelper(new RoundRectDrawableWithShadow.RoundRectHelper() { // from class: com.coui.appcompat.cardview.CardViewApi17Impl.1
            @Override // com.coui.appcompat.cardview.RoundRectDrawableWithShadow.RoundRectHelper
            public void drawRoundRect(Canvas canvas, RectF rectF, float f10, Paint paint) {
                canvas.drawPath(COUIRoundRectUtil.getInstance().getPath(rectF, f10), paint);
            }
        });
    }
}
