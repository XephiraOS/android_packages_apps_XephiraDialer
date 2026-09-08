package com.coui.appcompat.edittext;

import X8.c;
import X8.f;
import X8.j;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;

/* loaded from: classes.dex */
public class COUICardSingleInputView extends COUIInputView {
    public COUICardSingleInputView(Context context) {
        super(context);
    }

    @Override // com.coui.appcompat.edittext.COUIInputView
    public int getEdittextPaddingBottom() {
        int dimension = (int) getResources().getDimension(f.f4631Y1);
        if (!TextUtils.isEmpty(this.mTitle)) {
            return getResources().getDimensionPixelSize(f.f4662c2);
        }
        return dimension;
    }

    @Override // com.coui.appcompat.edittext.COUIInputView
    public int getLayoutResId() {
        return j.f4985p;
    }

    @Override // com.coui.appcompat.edittext.COUIInputView
    public int getTitlePaddingTop() {
        if (!TextUtils.isEmpty(this.mTitle)) {
            return getResources().getDimensionPixelSize(f.f4670d2);
        }
        return getResources().getDimensionPixelSize(f.f4678e2);
    }

    @Override // com.coui.appcompat.edittext.COUIInputView
    public COUIEditText instanceCOUIEditText(Context context, AttributeSet attributeSet) {
        COUIEditText cOUIEditText = new COUIEditText(context, attributeSet, c.f4372c);
        cOUIEditText.setShowDeleteIcon(false);
        cOUIEditText.setVerticalScrollBarEnabled(false);
        return cOUIEditText;
    }

    @Override // com.coui.appcompat.edittext.COUIInputView
    public boolean isIsCardSingleInput() {
        return true;
    }

    public COUICardSingleInputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public COUICardSingleInputView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
