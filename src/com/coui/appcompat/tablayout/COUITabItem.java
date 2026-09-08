package com.coui.appcompat.tablayout;

import Y8.i;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.K;

/* loaded from: classes3.dex */
public final class COUITabItem extends View {
    final int mCustomLayout;
    final Drawable mIcon;
    final CharSequence mText;

    public COUITabItem(Context context) {
        this(context, null);
    }

    public COUITabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        K v10 = K.v(context, attributeSet, i.f5740u);
        this.mText = v10.p(i.f5743x);
        this.mIcon = v10.g(i.f5741v);
        this.mCustomLayout = v10.n(i.f5742w, 0);
        v10.y();
    }
}
