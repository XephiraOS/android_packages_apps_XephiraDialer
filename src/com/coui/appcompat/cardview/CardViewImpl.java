package com.coui.appcompat.cardview;

import android.content.Context;
import android.content.res.ColorStateList;

/* loaded from: classes.dex */
interface CardViewImpl {
    ColorStateList getBackgroundColor(CardViewDelegate cardViewDelegate);

    float getElevation(CardViewDelegate cardViewDelegate);

    float getMaxElevation(CardViewDelegate cardViewDelegate);

    float getMinHeight(CardViewDelegate cardViewDelegate);

    float getMinWidth(CardViewDelegate cardViewDelegate);

    float getRadius(CardViewDelegate cardViewDelegate);

    float getWeight(CardViewDelegate cardViewDelegate);

    void initStatic();

    void initialize(CardViewDelegate cardViewDelegate, Context context, ColorStateList colorStateList, float f10, float f11, float f12, float f13);

    void onCompatPaddingChanged(CardViewDelegate cardViewDelegate);

    void onPreventCornerOverlapChanged(CardViewDelegate cardViewDelegate);

    void setBackgroundColor(CardViewDelegate cardViewDelegate, ColorStateList colorStateList);

    void setElevation(CardViewDelegate cardViewDelegate, float f10);

    void setMaxElevation(CardViewDelegate cardViewDelegate, float f10);

    void setRadius(CardViewDelegate cardViewDelegate, float f10);

    void setWeight(CardViewDelegate cardViewDelegate, float f10);

    void updatePadding(CardViewDelegate cardViewDelegate);
}
