package com.coui.appcompat.springchain;

import android.view.View;
import com.coui.appcompat.springchain.api.IChainItem;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: COUIChainItem.kt */
/* loaded from: classes.dex */
public final class COUIChainItem implements IChainItem {
    private int itemHeight;
    private int itemWidth;
    private int itemX;
    private int itemY;
    private View proxyView;
    private boolean skipSpringChainCalc;

    public COUIChainItem(View view, int i10, int i11, int i12, int i13, boolean z10) {
        this.proxyView = view;
        this.itemX = i10;
        this.itemY = i11;
        this.itemWidth = i12;
        this.itemHeight = i13;
        this.skipSpringChainCalc = z10;
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
        View view = this.proxyView;
        if (view != null) {
            view.setTranslationX(f10);
        }
    }

    @Override // com.coui.appcompat.springchain.api.IChainItem
    public void updateSpringY(float f10) {
        View view = this.proxyView;
        if (view != null) {
            view.setTranslationY(f10);
        }
    }

    public /* synthetic */ COUIChainItem(View view, int i10, int i11, int i12, int i13, boolean z10, int i14, f fVar) {
        this(view, (i14 & 2) != 0 ? 0 : i10, (i14 & 4) != 0 ? 0 : i11, (i14 & 8) != 0 ? 1 : i12, (i14 & 16) == 0 ? i13 : 1, (i14 & 32) == 0 ? z10 : false);
    }
}
