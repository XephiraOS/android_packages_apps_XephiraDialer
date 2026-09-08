package com.coui.appcompat.textswitcher;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;

/* loaded from: classes3.dex */
public class SpacingTextView extends AppCompatTextView {
    public SpacingTextView(Context context) {
        super(context);
    }

    private void applySpacing(CharSequence charSequence, TextView.BufferType bufferType) {
        if (charSequence == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            sb.append("" + charSequence.charAt(i10));
        }
        sb.append(" ");
        super.setText(sb, bufferType);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        applySpacing(charSequence, bufferType);
    }

    public SpacingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SpacingTextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
