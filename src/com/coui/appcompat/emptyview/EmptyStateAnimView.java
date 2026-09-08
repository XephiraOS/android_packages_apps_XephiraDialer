package com.coui.appcompat.emptyview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Size;
import android.view.View;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import com.oplus.anim.EffectiveAnimationView;
import kotlin.jvm.internal.i;

/* compiled from: EmptyStateAnimView.kt */
/* loaded from: classes.dex */
public final class EmptyStateAnimView extends EffectiveAnimationView {
    private Size animSize;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmptyStateAnimView(Context context, AttributeSet attrs) {
        super(context, attrs);
        i.f(context, "context");
        i.f(attrs, "attrs");
        COUIDarkModeUtil.setForceDarkAllow(this, false);
        this.animSize = new Size(0, 0);
    }

    public final Size getAnimSize() {
        return this.animSize;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i10, int i11) {
        setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(this.animSize.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.animSize.getHeight(), 1073741824));
    }

    public final void setAnimSize(Size value) {
        boolean z10;
        i.f(value, "value");
        this.animSize = value;
        int i10 = 0;
        if (value.getWidth() != 0 && value.getHeight() != 0) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            i10 = 4;
        }
        setVisibility(i10);
    }
}
