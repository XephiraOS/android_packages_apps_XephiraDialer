package com.coui.appcompat.card;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.preference.Preference;
import androidx.preference.h;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: CardButtonDecoration.kt */
/* loaded from: classes.dex */
public final class CardButtonDecoration extends BaseCardItemDecoration {
    private h adapter;
    private CardMargin cardMargin;
    private final CardPositionPredicate cardPositionPredicate;

    public /* synthetic */ CardButtonDecoration(Context context, CardPositionPredicate cardPositionPredicate, h hVar, int i10, f fVar) {
        this(context, cardPositionPredicate, (i10 & 4) != 0 ? null : hVar);
    }

    private final CardMargin getDefaultCardMargin() {
        int dimenPx = getDimenPx(Z8.c.f6026k);
        int i10 = Z8.c.f6028l;
        return new CardMargin(0, dimenPx, getDimenPx(i10), getDimenPx(i10));
    }

    public final h getAdapter() {
        return this.adapter;
    }

    public final CardMargin getCardMargin() {
        return this.cardMargin;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.y state) {
        Preference preference;
        i.f(outRect, "outRect");
        i.f(view, "view");
        i.f(parent, "parent");
        i.f(state, "state");
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        CardPosition cardPosition = new CardPosition(this.cardPositionPredicate, childAdapterPosition);
        h hVar = this.adapter;
        if (hVar != null) {
            preference = hVar.j(childAdapterPosition);
        } else {
            preference = null;
        }
        if (preference instanceof COUICardButtonPreference) {
            setCardColumnMargin(outRect, this.cardMargin, cardPosition);
        }
    }

    public final void setAdapter(h hVar) {
        this.adapter = hVar;
    }

    public final void setCardMargin(CardMargin cardMargin) {
        i.f(cardMargin, "<set-?>");
        this.cardMargin = cardMargin;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardButtonDecoration(Context appContext, CardPositionPredicate cardPositionPredicate, h hVar) {
        super(appContext);
        i.f(appContext, "appContext");
        i.f(cardPositionPredicate, "cardPositionPredicate");
        this.cardPositionPredicate = cardPositionPredicate;
        this.adapter = hVar;
        this.cardMargin = getDefaultCardMargin();
    }
}
