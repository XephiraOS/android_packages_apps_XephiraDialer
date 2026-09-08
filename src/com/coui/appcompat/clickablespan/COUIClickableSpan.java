package com.coui.appcompat.clickablespan;

import X8.e;
import android.content.Context;
import android.content.res.ColorStateList;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import f.C0991a;

/* loaded from: classes.dex */
public class COUIClickableSpan extends ClickableSpan {
    SpannableStrClickListener mClickReference;
    private ColorStateList mTextColor;

    /* loaded from: classes.dex */
    public interface SpannableStrClickListener {
        void onClick();
    }

    public COUIClickableSpan(Context context) {
        this.mTextColor = C0991a.a(context, e.f4439e);
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        SpannableStrClickListener spannableStrClickListener = this.mClickReference;
        if (spannableStrClickListener != null) {
            spannableStrClickListener.onClick();
        }
    }

    public void setClickTextColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.mTextColor = colorStateList;
        }
    }

    public void setStatusBarClickListener(SpannableStrClickListener spannableStrClickListener) {
        this.mClickReference = spannableStrClickListener;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(this.mTextColor.getColorForState(textPaint.drawableState, 0));
    }
}
