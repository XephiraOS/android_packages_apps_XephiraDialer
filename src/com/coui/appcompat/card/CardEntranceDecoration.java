package com.coui.appcompat.card;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.preference.Preference;
import androidx.preference.h;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: CardEntranceDecoration.kt */
/* loaded from: classes.dex */
public final class CardEntranceDecoration extends BaseCardItemDecoration {
    private h adapter;
    private final CardPositionPredicate cardPositionPredicate;
    private CardMargin largeCardMargin;
    private CardMargin smallCardMargin;

    public /* synthetic */ CardEntranceDecoration(Context context, CardPositionPredicate cardPositionPredicate, h hVar, int i10, f fVar) {
        this(context, cardPositionPredicate, (i10 & 4) != 0 ? null : hVar);
    }

    private final CardMargin getDefaultLargeCardMargin() {
        int i10 = Z8.c.f6032n;
        int dimenPx = getDimenPx(i10);
        int dimenPx2 = getDimenPx(i10);
        int i11 = Z8.c.f6030m;
        return new CardMargin(dimenPx, dimenPx2, getDimenPx(i11), getDimenPx(i11));
    }

    private final CardMargin getDefaultSmallCardMargin() {
        return new CardMargin(getDimenPx(Z8.c.f6038q), getDimenPx(Z8.c.f6040r), getDimenPx(Z8.c.f6036p), getDimenPx(Z8.c.f6034o));
    }

    public final h getAdapter() {
        return this.adapter;
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
        if (preference instanceof COUICardEntrancePreference) {
            int cardType = ((COUICardEntrancePreference) preference).getCardType();
            if (cardType != 1) {
                if (cardType == 2) {
                    setCardColumnMargin(outRect, this.largeCardMargin, cardPosition);
                    return;
                }
                return;
            }
            setCardColumnMargin(outRect, this.smallCardMargin, cardPosition);
        }
    }

    public final CardMargin getLargeCardMargin() {
        return this.largeCardMargin;
    }

    public final CardMargin getSmallCardMargin() {
        return this.smallCardMargin;
    }

    public final void setAdapter(h hVar) {
        this.adapter = hVar;
    }

    public final void setLargeCardMargin(CardMargin cardMargin) {
        i.f(cardMargin, "<set-?>");
        this.largeCardMargin = cardMargin;
    }

    public final void setSmallCardMargin(CardMargin cardMargin) {
        i.f(cardMargin, "<set-?>");
        this.smallCardMargin = cardMargin;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardEntranceDecoration(Context appContext, CardPositionPredicate cardPositionPredicate, h hVar) {
        super(appContext);
        i.f(appContext, "appContext");
        i.f(cardPositionPredicate, "cardPositionPredicate");
        this.cardPositionPredicate = cardPositionPredicate;
        this.adapter = hVar;
        this.largeCardMargin = getDefaultLargeCardMargin();
        this.smallCardMargin = getDefaultSmallCardMargin();
    }
}
