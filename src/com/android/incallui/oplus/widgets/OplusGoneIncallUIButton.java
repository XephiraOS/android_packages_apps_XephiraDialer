package com.android.incallui.oplus.widgets;

import android.content.Context;
import android.util.AttributeSet;

/* loaded from: classes.dex */
public class OplusGoneIncallUIButton extends OplusIncallUIButton {
    public OplusGoneIncallUIButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    public int getVisibility() {
        return 8;
    }
}
