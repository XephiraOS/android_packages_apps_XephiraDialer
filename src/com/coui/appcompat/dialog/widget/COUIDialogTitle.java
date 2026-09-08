package com.coui.appcompat.dialog.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Layout;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import e.j;

/* loaded from: classes.dex */
public class COUIDialogTitle extends AppCompatTextView {
    public COUIDialogTitle(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i10, int i11) {
        int lineCount;
        super.onMeasure(i10, i11);
        Layout layout = getLayout();
        if (layout != null && (lineCount = layout.getLineCount()) > 0 && layout.getEllipsisCount(lineCount - 1) > 0) {
            setSingleLine(false);
            setMaxLines(3);
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, j.f30428c3, R.attr.textAppearanceMedium, R.style.TextAppearance.Medium);
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(j.f30434d3, 0);
            if (dimensionPixelSize != 0) {
                setTextSize(0, dimensionPixelSize);
            }
            obtainStyledAttributes.recycle();
            super.onMeasure(i10, i11);
        }
    }

    public COUIDialogTitle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public COUIDialogTitle(Context context) {
        super(context);
    }
}
