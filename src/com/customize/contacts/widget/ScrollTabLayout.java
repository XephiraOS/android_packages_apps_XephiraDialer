package com.customize.contacts.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

/* loaded from: classes3.dex */
public class ScrollTabLayout extends HorizontalScrollView {

    /* renamed from: a, reason: collision with root package name */
    public LinearLayout f22416a;

    public ScrollTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public final void a() {
        this.f22416a = new LinearLayout(getContext());
        this.f22416a.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        this.f22416a.setLayoutDirection(0);
        this.f22416a.setOrientation(0);
        addView(this.f22416a);
    }

    public ViewGroup getContainerView() {
        return this.f22416a;
    }
}
