package com.google.android.material.tabs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.K;
import e4.m;

/* loaded from: classes3.dex */
public class TabItem extends View {

    /* renamed from: a, reason: collision with root package name */
    public final CharSequence f23865a;

    /* renamed from: b, reason: collision with root package name */
    public final Drawable f23866b;

    /* renamed from: c, reason: collision with root package name */
    public final int f23867c;

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        K v10 = K.v(context, attributeSet, m.qa);
        this.f23865a = v10.p(m.ta);
        this.f23866b = v10.g(m.ra);
        this.f23867c = v10.n(m.sa, 0);
        v10.y();
    }
}
