package com.customize.contacts.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageButton;

/* compiled from: DialDeleteImageButton.kt */
/* loaded from: classes3.dex */
public final class DialDeleteImageButton extends ImageButton {
    public DialDeleteImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }
}
