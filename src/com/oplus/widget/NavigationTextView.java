package com.oplus.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.coui.appcompat.textutil.COUIChangeTextUtil;
import com.oplus.blacklistapp.n;
import com.oplus.blacklistapp.v;

/* loaded from: classes4.dex */
public class NavigationTextView extends AppCompatTextView {

    /* renamed from: a, reason: collision with root package name */
    public int f29284a;

    /* renamed from: b, reason: collision with root package name */
    public int f29285b;

    /* renamed from: c, reason: collision with root package name */
    public int f29286c;

    public NavigationTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(Context context, AttributeSet attributeSet) {
        Resources resources = getResources();
        this.f29284a = resources.getDimensionPixelSize(n.f27288m);
        this.f29285b = resources.getDimensionPixelSize(n.f27289n);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, v.f27732i);
        this.f29286c = obtainStyledAttributes.getInt(v.f27733j, 5);
        obtainStyledAttributes.recycle();
    }

    public final boolean b() {
        if (getResources().getConfiguration().orientation == 1) {
            return true;
        }
        return false;
    }

    public final void c() {
        int i10;
        int i11;
        int i12;
        int i13;
        setTextSize(0, (int) COUIChangeTextUtil.getSuitableFontSize(this.f29285b, getResources().getConfiguration().fontScale, 2));
        if (b()) {
            int measureText = (int) getPaint().measureText(getText().toString());
            int i14 = this.f29286c;
            if (i14 == 5) {
                setTextAlignment(5);
                if (getLayoutDirection() == 1) {
                    int i15 = this.f29284a;
                    if (measureText >= i15) {
                        i13 = 0;
                    } else {
                        i13 = (i15 - measureText) / 2;
                    }
                    setPadding(0, 0, i13, 0);
                    return;
                }
                int i16 = this.f29284a;
                if (measureText >= i16) {
                    i12 = 0;
                } else {
                    i12 = (i16 - measureText) / 2;
                }
                setPadding(i12, 0, 0, 0);
                return;
            }
            if (i14 == 6) {
                setTextAlignment(6);
                if (getLayoutDirection() == 1) {
                    int i17 = this.f29284a;
                    if (measureText >= i17) {
                        i11 = 0;
                    } else {
                        i11 = (i17 - measureText) / 2;
                    }
                    setPadding(i11, 0, 0, 0);
                    return;
                }
                int i18 = this.f29284a;
                if (measureText >= i18) {
                    i10 = 0;
                } else {
                    i10 = (i18 - measureText) / 2;
                }
                setPadding(0, 0, i10, 0);
                return;
            }
            if (i14 == 4) {
                setTextAlignment(4);
            }
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i10, int i11) {
        c();
        super.onMeasure(i10, i11);
    }

    public NavigationTextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        a(context, attributeSet);
    }
}
