package com.coui.appcompat.preference;

import X8.e;
import X8.f;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.preference.l;
import b9.C0532b;
import b9.C0537g;
import b9.k;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.progressbar.COUIInstallLoadProgress;
import com.coui.appcompat.progressbar.COUILoadProgress;
import com.coui.appcompat.statelistutil.COUIStateListUtil;

/* loaded from: classes.dex */
public class COUILoadInstallProgressPreference extends COUIPreference {
    private final int mDisabledColor;
    private ColorStateList mInstallBackgroundColorStateList;
    private int mInstallProgressTextColor;
    private COUILoadProgress.OnStateChangeListener mListener;
    private COUIInstallLoadProgress mLoadProgress;
    private int mMax;
    private OnStateChangeListener mOnStateChangeListener;
    private int mProgress;
    private ColorStateList mProgressBackgroundColorStateList;
    private CharSequence mProgressText;
    private ColorStateList mProgressTextColorStateList;
    private int mProgressTextSize;
    private int mState;

    /* loaded from: classes.dex */
    public interface OnStateChangeListener {
        void onStateChanged(COUILoadProgress cOUILoadProgress, int i10);
    }

    public COUILoadInstallProgressPreference(Context context) {
        this(context, null);
    }

    private int getInstallProgressTextColor() {
        return this.mInstallProgressTextColor;
    }

    public COUIInstallLoadProgress getLoadProgressView() {
        return this.mLoadProgress;
    }

    public int getMax() {
        COUIInstallLoadProgress cOUIInstallLoadProgress = this.mLoadProgress;
        if (cOUIInstallLoadProgress != null) {
            return cOUIInstallLoadProgress.getMax();
        }
        return 0;
    }

    public int getProgress() {
        COUIInstallLoadProgress cOUIInstallLoadProgress = this.mLoadProgress;
        if (cOUIInstallLoadProgress != null) {
            return cOUIInstallLoadProgress.getProgress();
        }
        return 0;
    }

    public CharSequence getProgressText() {
        return this.mProgressText;
    }

    public int getProgressTextSize() {
        return this.mProgressTextSize;
    }

    public int getState() {
        COUIInstallLoadProgress cOUIInstallLoadProgress = this.mLoadProgress;
        if (cOUIInstallLoadProgress != null) {
            return cOUIInstallLoadProgress.getState();
        }
        return 0;
    }

    @Override // com.coui.appcompat.preference.COUIPreference, androidx.preference.Preference
    public void onBindViewHolder(l lVar) {
        super.onBindViewHolder(lVar);
        COUIInstallLoadProgress cOUIInstallLoadProgress = (COUIInstallLoadProgress) lVar.e(C0537g.f12484m);
        this.mLoadProgress = cOUIInstallLoadProgress;
        if (cOUIInstallLoadProgress != null) {
            cOUIInstallLoadProgress.setText(getProgressText().toString());
            this.mLoadProgress.setDefaultTextSize(getProgressTextSize());
            ColorStateList colorStateList = this.mProgressTextColorStateList;
            if (colorStateList != null) {
                this.mLoadProgress.setBtnTextColorStateList(colorStateList);
            }
            ColorStateList colorStateList2 = this.mProgressBackgroundColorStateList;
            if (colorStateList2 != null) {
                this.mLoadProgress.setThemeSecondaryColorStateList(colorStateList2);
            }
            ColorStateList colorStateList3 = this.mInstallBackgroundColorStateList;
            if (colorStateList3 != null) {
                this.mLoadProgress.setThemeColorStateList(colorStateList3);
            }
            if (getInstallProgressTextColor() != 0) {
                this.mLoadProgress.setBtnTextColorBySurpassProgress(getInstallProgressTextColor());
            }
            int i10 = this.mMax;
            if (i10 != 0) {
                this.mLoadProgress.setMax(i10);
            }
            this.mLoadProgress.setProgress(this.mProgress);
            this.mLoadProgress.setState(this.mState);
            this.mLoadProgress.setOnStateChangeListener(this.mListener);
        }
    }

    public void setBackgroundColor(int i10) {
        this.mProgressBackgroundColorStateList = COUIStateListUtil.createColorStateList(i10, this.mDisabledColor);
        notifyChanged();
    }

    public void setInstallBackgroundColor(int i10) {
        this.mInstallBackgroundColorStateList = COUIStateListUtil.createColorStateList(i10, this.mDisabledColor);
        notifyChanged();
    }

    public void setInstallProgressTextColor(int i10) {
        if (this.mInstallProgressTextColor != i10) {
            this.mInstallProgressTextColor = i10;
            notifyChanged();
        }
    }

    public void setMax(int i10) {
        if (this.mMax != i10) {
            this.mMax = i10;
            notifyChanged();
        }
    }

    public void setOnStateChangeListener(OnStateChangeListener onStateChangeListener) {
        this.mOnStateChangeListener = onStateChangeListener;
    }

    public void setProgress(int i10) {
        this.mProgress = i10;
        COUIInstallLoadProgress cOUIInstallLoadProgress = this.mLoadProgress;
        if (cOUIInstallLoadProgress != null) {
            cOUIInstallLoadProgress.setProgress(i10);
        }
    }

    public void setProgressText(CharSequence charSequence) {
        if (!TextUtils.equals(charSequence, this.mProgressText)) {
            this.mProgressText = charSequence;
            COUIInstallLoadProgress cOUIInstallLoadProgress = this.mLoadProgress;
            if (cOUIInstallLoadProgress != null) {
                cOUIInstallLoadProgress.setText(charSequence.toString());
            }
        }
    }

    public void setProgressTextColor(int i10) {
        this.mProgressTextColorStateList = COUIStateListUtil.createColorStateList(i10, this.mDisabledColor);
        notifyChanged();
    }

    public void setProgressTextSize(int i10) {
        if (this.mProgressTextSize != i10) {
            this.mProgressTextSize = i10;
            notifyChanged();
        }
    }

    public void setState(int i10) {
        this.mState = i10;
        COUIInstallLoadProgress cOUIInstallLoadProgress = this.mLoadProgress;
        if (cOUIInstallLoadProgress != null) {
            cOUIInstallLoadProgress.setState(i10);
        }
    }

    public COUILoadInstallProgressPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0532b.f12348g);
    }

    public COUILoadInstallProgressPreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, k.f12529g);
    }

    public COUILoadInstallProgressPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.mListener = new COUILoadProgress.OnStateChangeListener() { // from class: com.coui.appcompat.preference.COUILoadInstallProgressPreference.1
            @Override // com.coui.appcompat.progressbar.COUILoadProgress.OnStateChangeListener
            public void onStateChanged(COUILoadProgress cOUILoadProgress, int i12) {
                if (COUILoadInstallProgressPreference.this.mOnStateChangeListener != null) {
                    COUILoadInstallProgressPreference.this.mState = i12;
                    COUILoadInstallProgressPreference.this.mOnStateChangeListener.onStateChanged(cOUILoadProgress, i12);
                }
            }
        };
        this.mProgressText = "";
        int color = COUIContextUtil.getColor(getContext(), e.f4441g);
        this.mDisabledColor = color;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b9.l.f12564J, i10, i11);
        this.mProgressText = obtainStyledAttributes.getText(b9.l.f12572N);
        this.mProgressTextSize = obtainStyledAttributes.getDimensionPixelSize(b9.l.f12576P, context.getResources().getDimensionPixelSize(f.f4742m2));
        int color2 = obtainStyledAttributes.getColor(b9.l.f12574O, 0);
        int color3 = obtainStyledAttributes.getColor(b9.l.f12566K, 0);
        int color4 = obtainStyledAttributes.getColor(b9.l.f12568L, 0);
        this.mInstallProgressTextColor = obtainStyledAttributes.getColor(b9.l.f12570M, 0);
        obtainStyledAttributes.recycle();
        if (color2 != 0) {
            this.mProgressTextColorStateList = COUIStateListUtil.createColorStateList(color2, color);
        }
        if (color3 != 0) {
            this.mProgressBackgroundColorStateList = COUIStateListUtil.createColorStateList(color3, color);
        }
        if (color4 != 0) {
            this.mInstallBackgroundColorStateList = COUIStateListUtil.createColorStateList(color4, color);
        }
    }
}
