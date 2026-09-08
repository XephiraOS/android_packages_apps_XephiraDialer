package com.coui.appcompat.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.coui.appcompat.cardlist.COUICardListSelectedItemLayout;

/* loaded from: classes.dex */
public class COUICardListWithDividerItemLayout extends COUICardListSelectedItemLayout {
    public COUICardListWithDividerItemLayout(Context context) {
        super(context);
    }

    @Override // com.coui.appcompat.preference.ListSelectedItemLayout, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public COUICardListWithDividerItemLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public COUICardListWithDividerItemLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
