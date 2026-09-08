package com.coui.appcompat.cardview;

import android.graphics.drawable.Drawable;
import android.view.View;

/* loaded from: classes.dex */
interface CardViewDelegate {
    Drawable getCardBackground();

    View getCardView();

    boolean getPreventCornerOverlap();

    boolean getUseCompatPadding();

    void setCardBackground(Drawable drawable);

    void setMinWidthHeightInternal(int i10, int i11);

    void setShadowPadding(int i10, int i11, int i12, int i13);
}
