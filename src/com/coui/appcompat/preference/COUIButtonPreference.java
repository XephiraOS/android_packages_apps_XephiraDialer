package com.coui.appcompat.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.preference.l;
import b9.C0532b;
import b9.C0537g;
import b9.k;
import com.coui.appcompat.button.COUIButton;

/* loaded from: classes.dex */
public class COUIButtonPreference extends COUIPreference {
    private int mDrawableColor;
    private View.OnClickListener mListener;
    private OnButtonClickListener mOnButtonClickListener;
    private CharSequence mText;
    private int mTextColor;
    private int mTextSize;

    /* loaded from: classes.dex */
    public interface OnButtonClickListener {
        void onButtonClick();
    }

    public COUIButtonPreference(Context context) {
        this(context, null);
    }

    public CharSequence getBtnText() {
        return this.mText;
    }

    public int getDrawableColor() {
        return this.mDrawableColor;
    }

    public int getTextColor() {
        return this.mTextColor;
    }

    public int getTextSize() {
        return this.mTextSize;
    }

    @Override // com.coui.appcompat.preference.COUIPreference, androidx.preference.Preference
    public void onBindViewHolder(l lVar) {
        super.onBindViewHolder(lVar);
        COUIButton cOUIButton = (COUIButton) lVar.e(C0537g.f12481j);
        if (cOUIButton != null) {
            cOUIButton.setText(getBtnText());
            cOUIButton.setTextSize(getTextSize());
            if (getTextColor() != 0) {
                cOUIButton.setTextColor(getTextColor());
            }
            if (getDrawableColor() != 0) {
                cOUIButton.setDrawableColor(getDrawableColor());
            }
            cOUIButton.setOnClickListener(this.mListener);
        }
    }

    public void setBtnText(CharSequence charSequence) {
        if (!TextUtils.equals(charSequence, this.mText)) {
            this.mText = charSequence;
            notifyChanged();
        }
    }

    public void setDrawableColor(int i10) {
        if (this.mDrawableColor != i10) {
            this.mDrawableColor = i10;
            notifyChanged();
        }
    }

    public void setOnButtonClickListener(OnButtonClickListener onButtonClickListener) {
        this.mOnButtonClickListener = onButtonClickListener;
    }

    public void setTextColor(int i10) {
        if (this.mTextColor != i10) {
            this.mTextColor = i10;
            notifyChanged();
        }
    }

    public void setTextSize(int i10) {
        if (this.mTextSize != i10) {
            this.mTextSize = i10;
            notifyChanged();
        }
    }

    public COUIButtonPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0532b.f12343b);
    }

    public COUIButtonPreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, k.f12524b);
    }

    public COUIButtonPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.mListener = new View.OnClickListener() { // from class: com.coui.appcompat.preference.COUIButtonPreference.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (COUIButtonPreference.this.mOnButtonClickListener != null) {
                    COUIButtonPreference.this.mOnButtonClickListener.onButtonClick();
                }
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b9.l.f12628k, i10, i11);
        this.mText = obtainStyledAttributes.getText(b9.l.f12634m);
        this.mTextSize = obtainStyledAttributes.getInt(b9.l.f12640o, 14);
        this.mTextColor = obtainStyledAttributes.getColor(b9.l.f12637n, 0);
        this.mDrawableColor = obtainStyledAttributes.getColor(b9.l.f12631l, 0);
        obtainStyledAttributes.recycle();
    }
}
