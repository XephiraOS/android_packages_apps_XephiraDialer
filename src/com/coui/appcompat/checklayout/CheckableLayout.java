package com.coui.appcompat.checklayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.RelativeLayout;

/* loaded from: classes.dex */
public class CheckableLayout extends RelativeLayout implements Checkable {
    private Checkable mCheckable;

    public CheckableLayout(Context context) {
        super(context);
    }

    private void setCheckbleView(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        if (childCount > 0) {
            for (int i10 = 0; i10 < childCount; i10++) {
                KeyEvent.Callback childAt = viewGroup.getChildAt(i10);
                if (childAt instanceof ViewGroup) {
                    setCheckbleView((ViewGroup) childAt);
                } else if (childAt instanceof Checkable) {
                    this.mCheckable = (Checkable) childAt;
                    return;
                }
            }
        }
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        Checkable checkable = this.mCheckable;
        if (checkable != null && checkable.isChecked()) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        setCheckbleView(this);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z10) {
        Checkable checkable = this.mCheckable;
        if (checkable != null) {
            checkable.setChecked(z10);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        Checkable checkable = this.mCheckable;
        if (checkable != null) {
            checkable.toggle();
        }
    }

    public CheckableLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CheckableLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
