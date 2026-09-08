package com.android.incallui;

import android.graphics.Typeface;
import com.android.incallui.InCallUIAide;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public class InCallUIFontTypeFace implements InCallUIAide.FontChangeListener {
    private int mFontTypeFace;
    private final InCallUIAide.FontChangeListener mTargetFontChangeListener;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface FontTypeFace {
        public static final int MEDIUM = 1;
        public static final int REGULAR = 2;
        public static final int UNKNOWN = 0;
    }

    public InCallUIFontTypeFace(InCallUIAide.FontChangeListener fontChangeListener) {
        setListenTypeface(1);
        this.mTargetFontChangeListener = fontChangeListener;
    }

    @Override // com.android.incallui.InCallUIAide.FontChangeListener
    public void onFontChanged(Typeface typeface) {
        InCallUIAide.FontChangeListener fontChangeListener;
        int i10 = this.mFontTypeFace;
        if (i10 != 1) {
            if (i10 == 2 && (fontChangeListener = this.mTargetFontChangeListener) != null) {
                fontChangeListener.onFontChanged(InCallUIAide.getInstance().getRegularType());
                return;
            }
            return;
        }
        InCallUIAide.FontChangeListener fontChangeListener2 = this.mTargetFontChangeListener;
        if (fontChangeListener2 != null) {
            fontChangeListener2.onFontChanged(InCallUIAide.getInstance().getMediumType());
        }
    }

    public void setListenTypeface(int i10) {
        if (i10 != 0) {
            if (i10 == 1 || i10 == 2) {
                InCallUIAide.getInstance().addFontChangeListener(this);
            }
        } else {
            InCallUIAide.getInstance().removeFontChangeListener(this);
        }
        this.mFontTypeFace = i10;
    }
}
