package com.coui.appcompat.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.preference.l;
import b9.C0532b;
import b9.C0537g;
import b9.k;

/* loaded from: classes.dex */
public class COUISlideSelectPreference extends COUIPreference {
    public static final int FORCE_CLICK = 1;
    public static final int FORCE_UNCLICK = 2;
    public static final int NORMAL = 0;
    private int mClickStyle;
    Context mContext;
    CharSequence mSelectionText;
    private TextView mStatus1;

    public COUISlideSelectPreference(Context context) {
        this(context, null);
    }

    public CharSequence getSelectionText() {
        CharSequence charSequence = this.mSelectionText;
        if (charSequence != null) {
            return charSequence;
        }
        return "";
    }

    @Override // com.coui.appcompat.preference.COUIPreference, androidx.preference.Preference
    public void onBindViewHolder(l lVar) {
        super.onBindViewHolder(lVar);
        View e10 = lVar.e(C0537g.f12485n);
        if (e10 != null) {
            e10.setTag(new Object());
            int i10 = this.mClickStyle;
            if (i10 != 1) {
                if (i10 == 2) {
                    e10.setClickable(true);
                }
            } else {
                e10.setClickable(false);
            }
        }
        View e11 = lVar.e(C0537g.f12489r);
        if (e11 != null && (e11 instanceof TextView)) {
            this.mStatus1 = (TextView) e11;
            CharSequence charSequence = this.mSelectionText;
            if (!TextUtils.isEmpty(charSequence)) {
                this.mStatus1.setText(charSequence);
                this.mStatus1.setVisibility(0);
            } else {
                this.mStatus1.setVisibility(8);
            }
        }
    }

    public void setSelectionText(CharSequence charSequence) {
        if ((charSequence == null && this.mSelectionText != null) || (charSequence != null && !charSequence.equals(this.mSelectionText))) {
            this.mSelectionText = charSequence;
            notifyChanged();
        }
    }

    public void setStatusText(CharSequence charSequence) {
        if ((charSequence == null && this.mSelectionText != null) || (charSequence != null && !charSequence.equals(this.mSelectionText))) {
            this.mSelectionText = charSequence;
            notifyChanged();
        }
    }

    public COUISlideSelectPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0532b.f12353l);
    }

    public COUISlideSelectPreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, k.f12532j);
    }

    public COUISlideSelectPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10);
        this.mClickStyle = 0;
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b9.l.f12585T0, i10, i11);
        this.mSelectionText = obtainStyledAttributes.getText(b9.l.f12587U0);
        obtainStyledAttributes.recycle();
    }

    public void setBlurView(View view) {
    }
}
