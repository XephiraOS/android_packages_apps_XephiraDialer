package com.coui.appcompat.theme;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.app.k;
import androidx.appcompat.widget.AppCompatTextView;
import com.coui.appcompat.textview.COUITextView;

/* loaded from: classes3.dex */
public class COUIComponentsViewInflater extends k {
    @Override // androidx.appcompat.app.k
    public AppCompatTextView createTextView(Context context, AttributeSet attributeSet) {
        return new COUITextView(context, attributeSet);
    }
}
