package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.K;
import e4.g;
import e4.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import x4.i;
import x4.l;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class RadialViewGroup extends ConstraintLayout {

    /* renamed from: a, reason: collision with root package name */
    public final Runnable f24225a;

    /* renamed from: b, reason: collision with root package name */
    public int f24226b;

    /* renamed from: c, reason: collision with root package name */
    public i f24227c;

    public RadialViewGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static boolean l(View view) {
        return "skip".equals(view.getTag());
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i10, layoutParams);
        if (view.getId() == -1) {
            view.setId(K.i());
        }
        o();
    }

    public final void g(List<View> list, androidx.constraintlayout.widget.b bVar, int i10) {
        Iterator<View> it = list.iterator();
        float f10 = 0.0f;
        while (it.hasNext()) {
            bVar.l(it.next().getId(), g.f30868c, i10, f10);
            f10 += 360.0f / list.size();
        }
    }

    public final Drawable h() {
        i iVar = new i();
        this.f24227c = iVar;
        iVar.setCornerSize(new l(0.5f));
        this.f24227c.setFillColor(ColorStateList.valueOf(-1));
        return this.f24227c;
    }

    public int i(int i10) {
        int i11 = this.f24226b;
        if (i10 == 2) {
            return Math.round(i11 * 0.66f);
        }
        return i11;
    }

    public int j() {
        return this.f24226b;
    }

    public void k(int i10) {
        this.f24226b = i10;
        n();
    }

    public void n() {
        androidx.constraintlayout.widget.b bVar = new androidx.constraintlayout.widget.b();
        bVar.i(this);
        HashMap hashMap = new HashMap();
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getId() != g.f30868c && !l(childAt)) {
                int i11 = (Integer) childAt.getTag(g.f30888m);
                if (i11 == null) {
                    i11 = 1;
                }
                if (!hashMap.containsKey(i11)) {
                    hashMap.put(i11, new ArrayList());
                }
                ((List) hashMap.get(i11)).add(childAt);
            }
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            g((List) entry.getValue(), bVar, i(((Integer) entry.getKey()).intValue()));
        }
        bVar.d(this);
    }

    public final void o() {
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.f24225a);
            handler.post(this.f24225a);
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        n();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        o();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        this.f24227c.setFillColor(ColorStateList.valueOf(i10));
    }

    public RadialViewGroup(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        LayoutInflater.from(context).inflate(e4.i.f30935o, this);
        K.n0(this, h());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.f31381e8, i10, 0);
        this.f24226b = obtainStyledAttributes.getDimensionPixelSize(m.f31392f8, 0);
        this.f24225a = new Runnable() { // from class: com.google.android.material.timepicker.c
            @Override // java.lang.Runnable
            public final void run() {
                RadialViewGroup.this.n();
            }
        };
        obtainStyledAttributes.recycle();
    }
}
