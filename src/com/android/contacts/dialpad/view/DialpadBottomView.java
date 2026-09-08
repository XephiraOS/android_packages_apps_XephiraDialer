package com.android.contacts.dialpad.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.oplus.dialer.R;

/* loaded from: classes.dex */
public class DialpadBottomView extends LinearLayout {
    public DialpadBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int resolveSize = View.resolveSize(0, i10);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dialpad_content_max_width);
        H7.b.b("DialpadBottomView", "onMeasure: specWidth = " + resolveSize + " maxWidth = " + dimensionPixelSize + " layoutParams.getMarginStart() = " + ((ViewGroup.MarginLayoutParams) getLayoutParams()).getMarginStart());
        if (resolveSize >= dimensionPixelSize) {
            i10 = View.MeasureSpec.makeMeasureSpec(dimensionPixelSize, 1073741824);
        }
        super.onMeasure(i10, i11);
    }
}
