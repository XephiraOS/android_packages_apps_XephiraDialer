package com.coui.appcompat.card;

import android.content.Context;
import android.graphics.Rect;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.i;

/* compiled from: BaseCardItemDecoration.kt */
/* loaded from: classes.dex */
public class BaseCardItemDecoration extends RecyclerView.n {
    private final Context appContext;

    public BaseCardItemDecoration(Context appContext) {
        i.f(appContext, "appContext");
        this.appContext = appContext;
    }

    public final int getDimenPx(int i10) {
        return getDimenPx(this.appContext, i10);
    }

    public final void setCardColumnMargin(Rect outRect, CardMargin cardMargin, CardPosition cardPosition) {
        i.f(outRect, "outRect");
        i.f(cardMargin, "cardMargin");
        i.f(cardPosition, "cardPosition");
        outRect.top = cardMargin.getOtherRowTop();
        outRect.left = cardMargin.getFirstColumnInner();
        outRect.right = cardMargin.getFirstColumnInner();
        if (cardPosition.isFirstColumn()) {
            outRect.left = cardMargin.getFirstColumnOuter();
        }
        if (cardPosition.isLastColumn()) {
            outRect.right = cardMargin.getFirstColumnOuter();
        }
        if (cardPosition.isFirstRow()) {
            outRect.top = cardMargin.getFirstRowTop();
        }
    }

    private final int getDimenPx(Context context, int i10) {
        return context.getResources().getDimensionPixelSize(i10);
    }
}
