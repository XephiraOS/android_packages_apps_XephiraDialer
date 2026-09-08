package com.coui.appcompat.cardview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.coui.appcompat.cardview.RoundRectDrawableWithShadow;
import com.coui.appcompat.roundRect.COUIRoundRectUtil;

/* loaded from: classes.dex */
class CardViewBaseImpl implements CardViewImpl {
    private final RectF mCornerRect = new RectF();

    private RoundRectDrawableWithShadow createBackground(Context context, ColorStateList colorStateList, float f10, float f11, float f12) {
        return new RoundRectDrawableWithShadow(context.getResources(), colorStateList, f10, f11, f12);
    }

    private RoundRectDrawableWithShadow getShadowBackground(CardViewDelegate cardViewDelegate) {
        return (RoundRectDrawableWithShadow) cardViewDelegate.getCardBackground();
    }

    @Override // com.coui.appcompat.cardview.CardViewImpl
    public ColorStateList getBackgroundColor(CardViewDelegate cardViewDelegate) {
        return getShadowBackground(cardViewDelegate).getColor();
    }

    @Override // com.coui.appcompat.cardview.CardViewImpl
    public float getElevation(CardViewDelegate cardViewDelegate) {
        return getShadowBackground(cardViewDelegate).getShadowSize();
    }

    @Override // com.coui.appcompat.cardview.CardViewImpl
    public float getMaxElevation(CardViewDelegate cardViewDelegate) {
        return getShadowBackground(cardViewDelegate).getMaxShadowSize();
    }

    @Override // com.coui.appcompat.cardview.CardViewImpl
    public float getMinHeight(CardViewDelegate cardViewDelegate) {
        return getShadowBackground(cardViewDelegate).getMinHeight();
    }

    @Override // com.coui.appcompat.cardview.CardViewImpl
    public float getMinWidth(CardViewDelegate cardViewDelegate) {
        return getShadowBackground(cardViewDelegate).getMinWidth();
    }

    @Override // com.coui.appcompat.cardview.CardViewImpl
    public float getRadius(CardViewDelegate cardViewDelegate) {
        return getShadowBackground(cardViewDelegate).getCornerRadius();
    }

    @Override // com.coui.appcompat.cardview.CardViewImpl
    public float getWeight(CardViewDelegate cardViewDelegate) {
        return 0.0f;
    }

    @Override // com.coui.appcompat.cardview.CardViewImpl
    public void initStatic() {
        RoundRectDrawableWithShadow.setRoundRectHelper(new RoundRectDrawableWithShadow.RoundRectHelper() { // from class: com.coui.appcompat.cardview.CardViewBaseImpl.1
            @Override // com.coui.appcompat.cardview.RoundRectDrawableWithShadow.RoundRectHelper
            public void drawRoundRect(Canvas canvas, RectF rectF, float f10, Paint paint) {
                canvas.drawPath(COUIRoundRectUtil.getInstance().getPath(rectF, f10), paint);
            }
        });
    }

    @Override // com.coui.appcompat.cardview.CardViewImpl
    public void initialize(CardViewDelegate cardViewDelegate, Context context, ColorStateList colorStateList, float f10, float f11, float f12, float f13) {
        RoundRectDrawableWithShadow createBackground = createBackground(context, colorStateList, f10, f11, f12);
        createBackground.setAddPaddingForCorners(cardViewDelegate.getPreventCornerOverlap());
        cardViewDelegate.setCardBackground(createBackground);
        updatePadding(cardViewDelegate);
    }

    @Override // com.coui.appcompat.cardview.CardViewImpl
    public void onPreventCornerOverlapChanged(CardViewDelegate cardViewDelegate) {
        getShadowBackground(cardViewDelegate).setAddPaddingForCorners(cardViewDelegate.getPreventCornerOverlap());
        updatePadding(cardViewDelegate);
    }

    @Override // com.coui.appcompat.cardview.CardViewImpl
    public void setBackgroundColor(CardViewDelegate cardViewDelegate, ColorStateList colorStateList) {
        getShadowBackground(cardViewDelegate).setColor(colorStateList);
    }

    @Override // com.coui.appcompat.cardview.CardViewImpl
    public void setElevation(CardViewDelegate cardViewDelegate, float f10) {
        getShadowBackground(cardViewDelegate).setShadowSize(f10);
    }

    @Override // com.coui.appcompat.cardview.CardViewImpl
    public void setMaxElevation(CardViewDelegate cardViewDelegate, float f10) {
        getShadowBackground(cardViewDelegate).setMaxShadowSize(f10);
        updatePadding(cardViewDelegate);
    }

    @Override // com.coui.appcompat.cardview.CardViewImpl
    public void setRadius(CardViewDelegate cardViewDelegate, float f10) {
        getShadowBackground(cardViewDelegate).setCornerRadius(f10);
        updatePadding(cardViewDelegate);
    }

    @Override // com.coui.appcompat.cardview.CardViewImpl
    public void updatePadding(CardViewDelegate cardViewDelegate) {
        Rect rect = new Rect();
        getShadowBackground(cardViewDelegate).getMaxShadowAndCornerPadding(rect);
        cardViewDelegate.setMinWidthHeightInternal((int) Math.ceil(getMinWidth(cardViewDelegate)), (int) Math.ceil(getMinHeight(cardViewDelegate)));
        cardViewDelegate.setShadowPadding(rect.left, rect.top, rect.right, rect.bottom);
    }

    @Override // com.coui.appcompat.cardview.CardViewImpl
    public void onCompatPaddingChanged(CardViewDelegate cardViewDelegate) {
    }

    @Override // com.coui.appcompat.cardview.CardViewImpl
    public void setWeight(CardViewDelegate cardViewDelegate, float f10) {
    }
}
