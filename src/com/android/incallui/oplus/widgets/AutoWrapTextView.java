package com.android.incallui.oplus.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.android.incallui.Log;
import com.android.incallui.R;

/* loaded from: classes.dex */
public class AutoWrapTextView extends TextView {
    public AutoWrapTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        CharSequence text = getText();
        if (TextUtils.isEmpty(text)) {
            super.onDraw(canvas);
            return;
        }
        ViewParent parent = getParent();
        while (true) {
            if (!(parent instanceof ViewGroup)) {
                break;
            }
            TextView textView = (TextView) ((ViewGroup) parent).findViewById(R.id.incoming_call_mark_auto_wrap);
            if (textView != null) {
                int ellipsisCount = getLayout().getEllipsisCount(0);
                if (ellipsisCount != 0) {
                    setVisibility(8);
                    textView.setVisibility(0);
                    textView.setText(text);
                } else {
                    setVisibility(0);
                    textView.setText((CharSequence) null);
                    textView.setVisibility(8);
                }
                Log.d("CusTextView - onDraw", "getText = " + ((Object) text) + " ellipsisCount = " + ellipsisCount);
            } else {
                parent = parent.getParent();
            }
        }
        super.onDraw(canvas);
    }
}
