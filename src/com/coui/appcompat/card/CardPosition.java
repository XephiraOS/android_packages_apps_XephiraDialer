package com.coui.appcompat.card;

import kotlin.jvm.internal.i;

/* compiled from: CardPositionPredicate.kt */
/* loaded from: classes.dex */
public final class CardPosition {
    private final boolean isFirstColumn;
    private final boolean isFirstRow;
    private final boolean isLastColumn;
    private final boolean isLastRow;

    public CardPosition(CardPositionPredicate cardPositionPredicate, int i10) {
        i.f(cardPositionPredicate, "cardPositionPredicate");
        this.isFirstRow = cardPositionPredicate.isFirstRow().invoke(Integer.valueOf(i10)).booleanValue();
        this.isLastRow = cardPositionPredicate.isLastRow().invoke(Integer.valueOf(i10)).booleanValue();
        this.isFirstColumn = cardPositionPredicate.isFirstColumn().invoke(Integer.valueOf(i10)).booleanValue();
        this.isLastColumn = cardPositionPredicate.isLastColumn().invoke(Integer.valueOf(i10)).booleanValue();
    }

    public final boolean isFirstColumn() {
        return this.isFirstColumn;
    }

    public final boolean isFirstRow() {
        return this.isFirstRow;
    }

    public final boolean isLastColumn() {
        return this.isLastColumn;
    }

    public final boolean isLastRow() {
        return this.isLastRow;
    }
}
