package com.coui.appcompat.springchain.api;

import android.view.View;

/* compiled from: IChainItem.kt */
/* loaded from: classes.dex */
public interface IChainItem {
    int getItemHeight();

    int getItemWidth();

    int getItemX();

    int getItemY();

    boolean getSkipSpringChainCalc();

    void setItemHeight(int i10);

    void setItemSize(int i10, int i11);

    void setItemWidth(int i10);

    void setItemX(int i10);

    void setItemXY(int i10, int i11);

    void setItemY(int i10);

    void setProxyView(View view);

    void setSkipSpringChainCalc(boolean z10);

    void updateSpringX(float f10);

    void updateSpringY(float f10);
}
