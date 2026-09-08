package com.coui.appcompat.tintimageview;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.K;

/* loaded from: classes3.dex */
public class COUITintImageView extends AppCompatImageView {
    private static final int[] TINT_ATTRS = {R.attr.background, R.attr.src};
    private final COUITintManager mTintManager;

    public COUITintImageView(Context context) {
        this(context, null);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i10) {
        setImageDrawable(this.mTintManager.getDrawable(i10));
    }

    public COUITintImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public COUITintImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        K w10 = K.w(getContext(), attributeSet, TINT_ATTRS, i10, 0);
        if (w10.t() > 0) {
            if (w10.s(0)) {
                setBackgroundDrawable(w10.g(0));
            }
            if (w10.s(1)) {
                setImageDrawable(w10.g(1));
            }
        }
        w10.y();
        this.mTintManager = COUITintManager.get(context);
    }
}
