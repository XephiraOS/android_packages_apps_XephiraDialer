package com.android.contacts.detail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ContextMenu;
import com.coui.appcompat.cardlist.COUICardListSelectedItemLayout;

/* loaded from: classes.dex */
public class ActionsViewContainer extends COUICardListSelectedItemLayout {

    /* renamed from: a, reason: collision with root package name */
    public ContextMenu.ContextMenuInfo f14167a;

    /* renamed from: b, reason: collision with root package name */
    public int f14168b;

    public ActionsViewContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.View
    public ContextMenu.ContextMenuInfo getContextMenuInfo() {
        return this.f14167a;
    }

    public int getPosition() {
        return this.f14168b;
    }

    public void setPosition(int i10) {
        this.f14168b = i10;
    }

    public ActionsViewContainer(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
