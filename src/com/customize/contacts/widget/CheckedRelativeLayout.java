package com.customize.contacts.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.RelativeLayout;
import com.oplus.dialer.R;
import java.util.Stack;

/* loaded from: classes3.dex */
public class CheckedRelativeLayout extends RelativeLayout implements Checkable {

    /* renamed from: a, reason: collision with root package name */
    public boolean f22278a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f22279b;

    public CheckedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22278a = false;
        this.f22279b = new int[]{R.attr.state_list_checked};
        setBackgroundResource(R.drawable.select_list_item_background_seletor);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f22278a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i10) {
        if (this.f22278a) {
            int[] onCreateDrawableState = super.onCreateDrawableState(i10 + 1);
            View.mergeDrawableStates(onCreateDrawableState, this.f22279b);
            return onCreateDrawableState;
        }
        return super.onCreateDrawableState(i10);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z10) {
        if (this.f22278a != z10) {
            this.f22278a = z10;
            refreshDrawableState();
            Stack stack = new Stack();
            int childCount = getChildCount();
            int i10 = 0;
            while (true) {
                if (i10 >= childCount) {
                    break;
                }
                KeyEvent.Callback childAt = getChildAt(i10);
                if (childAt instanceof Checkable) {
                    ((Checkable) childAt).setChecked(z10);
                    break;
                } else {
                    if (childAt instanceof ViewGroup) {
                        stack.push(childAt);
                    }
                    i10++;
                }
            }
            while (!stack.isEmpty()) {
                KeyEvent.Callback callback = (View) stack.pop();
                if (callback instanceof Checkable) {
                    ((Checkable) callback).setChecked(z10);
                    return;
                } else if (callback instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) callback;
                    int childCount2 = viewGroup.getChildCount();
                    for (int i11 = 0; i11 < childCount2; i11++) {
                        stack.push(viewGroup.getChildAt(i11));
                    }
                }
            }
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f22278a);
    }
}
