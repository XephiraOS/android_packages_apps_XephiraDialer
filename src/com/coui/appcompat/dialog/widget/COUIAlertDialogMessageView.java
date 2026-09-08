package com.coui.appcompat.dialog.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import androidx.appcompat.widget.AppCompatTextView;

/* loaded from: classes.dex */
public class COUIAlertDialogMessageView extends AppCompatTextView implements ViewTreeObserver.OnGlobalLayoutListener {
    public COUIAlertDialogMessageView(Context context) {
        super(context);
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.view.View
    public void onDetachedFromWindow() {
        getViewTreeObserver().removeOnGlobalLayoutListener(this);
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        int i10;
        if (getLineCount() > 1) {
            i10 = 8388611;
        } else {
            i10 = 17;
        }
        setGravity(i10);
    }

    public COUIAlertDialogMessageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public COUIAlertDialogMessageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
