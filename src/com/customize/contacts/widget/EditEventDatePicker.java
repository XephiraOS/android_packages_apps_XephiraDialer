package com.customize.contacts.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* loaded from: classes3.dex */
public class EditEventDatePicker extends CustomLinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public LinearLayout.LayoutParams f22295a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f22296b;

    public EditEventDatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22295a = new LinearLayout.LayoutParams(-1, -2);
    }

    public boolean a() {
        return this.f22296b;
    }

    public void setExpanded(boolean z10) {
        this.f22296b = z10;
    }

    public void setHeight(int i10) {
        LinearLayout.LayoutParams layoutParams = this.f22295a;
        layoutParams.height = i10;
        setLayoutParams(layoutParams);
    }
}
