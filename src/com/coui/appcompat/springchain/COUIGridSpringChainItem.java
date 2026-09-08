package com.coui.appcompat.springchain;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.coui.appcompat.springchain.api.IChainItem;
import kotlin.jvm.internal.i;

/* compiled from: COUIGridSpringChainItem.kt */
/* loaded from: classes.dex */
public class COUIGridSpringChainItem extends FrameLayout implements IChainItem {
    private int itemHeight;
    private int itemWidth;
    private int itemX;
    private int itemY;
    private View proxyView;
    private boolean skipSpringChainCalc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public COUIGridSpringChainItem(Context context) {
        super(context);
        i.c(context);
        this.itemWidth = 1;
        this.itemHeight = 1;
        this.proxyView = this;
    }

    @Override // com.coui.appcompat.springchain.api.IChainItem
    public int getItemHeight() {
        return this.itemHeight;
    }

    @Override // com.coui.appcompat.springchain.api.IChainItem
    public int getItemWidth() {
        return this.itemWidth;
    }

    @Override // com.coui.appcompat.springchain.api.IChainItem
    public int getItemX() {
        return this.itemX;
    }

    @Override // com.coui.appcompat.springchain.api.IChainItem
    public int getItemY() {
        return this.itemY;
    }

    @Override // com.coui.appcompat.springchain.api.IChainItem
    public boolean getSkipSpringChainCalc() {
        return this.skipSpringChainCalc;
    }

    @Override // com.coui.appcompat.springchain.api.IChainItem
    public void setItemHeight(int i10) {
        this.itemHeight = i10;
    }

    @Override // com.coui.appcompat.springchain.api.IChainItem
    public void setItemSize(int i10, int i11) {
        setItemWidth(i10);
        setItemHeight(i11);
    }

    @Override // com.coui.appcompat.springchain.api.IChainItem
    public void setItemWidth(int i10) {
        this.itemWidth = i10;
    }

    @Override // com.coui.appcompat.springchain.api.IChainItem
    public void setItemX(int i10) {
        this.itemX = i10;
    }

    @Override // com.coui.appcompat.springchain.api.IChainItem
    public void setItemXY(int i10, int i11) {
        setItemX(i10);
        setItemY(i11);
    }

    @Override // com.coui.appcompat.springchain.api.IChainItem
    public void setItemY(int i10) {
        this.itemY = i10;
    }

    @Override // com.coui.appcompat.springchain.api.IChainItem
    public void setProxyView(View proxyView) {
        i.f(proxyView, "proxyView");
        this.proxyView = proxyView;
    }

    @Override // com.coui.appcompat.springchain.api.IChainItem
    public void setSkipSpringChainCalc(boolean z10) {
        this.skipSpringChainCalc = z10;
    }

    @Override // com.coui.appcompat.springchain.api.IChainItem
    public void updateSpringX(float f10) {
        setTranslationX(f10);
    }

    @Override // com.coui.appcompat.springchain.api.IChainItem
    public void updateSpringY(float f10) {
        setTranslationY(f10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public COUIGridSpringChainItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        i.c(context);
        this.itemWidth = 1;
        this.itemHeight = 1;
        this.proxyView = this;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public COUIGridSpringChainItem(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i.c(context);
        this.itemWidth = 1;
        this.itemHeight = 1;
        this.proxyView = this;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public COUIGridSpringChainItem(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        i.c(context);
        this.itemWidth = 1;
        this.itemHeight = 1;
        this.proxyView = this;
    }
}
