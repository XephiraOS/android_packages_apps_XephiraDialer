package com.coui.appcompat.tips.def;

import android.graphics.drawable.Drawable;
import android.view.View;

/* loaded from: classes3.dex */
public interface IDefaultTopTips {
    void setCloseBtnListener(View.OnClickListener onClickListener);

    void setCloseDrawable(Drawable drawable);

    void setNegativeButton(CharSequence charSequence);

    void setNegativeButtonColor(int i10);

    void setNegativeButtonListener(View.OnClickListener onClickListener);

    void setPositiveButton(CharSequence charSequence);

    void setPositiveButtonColor(int i10);

    void setPositiveButtonListener(View.OnClickListener onClickListener);

    void setStartIcon(Drawable drawable);

    void setTipsText(CharSequence charSequence);

    void setTipsTextColor(int i10);
}
