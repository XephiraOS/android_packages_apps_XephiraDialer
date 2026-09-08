package com.coui.appcompat.card;

import kotlin.jvm.internal.i;
import v9.l;

/* compiled from: CardPositionPredicate.kt */
/* loaded from: classes.dex */
public final class CardPositionPredicate {
    private final l<Integer, Boolean> isFirstColumn;
    private final l<Integer, Boolean> isFirstRow;
    private final l<Integer, Boolean> isLastColumn;
    private final l<Integer, Boolean> isLastRow;

    /* JADX WARN: Multi-variable type inference failed */
    public CardPositionPredicate(l<? super Integer, Boolean> isFirstRow, l<? super Integer, Boolean> isLastRow, l<? super Integer, Boolean> isFirstColumn, l<? super Integer, Boolean> isLastColumn) {
        i.f(isFirstRow, "isFirstRow");
        i.f(isLastRow, "isLastRow");
        i.f(isFirstColumn, "isFirstColumn");
        i.f(isLastColumn, "isLastColumn");
        this.isFirstRow = isFirstRow;
        this.isLastRow = isLastRow;
        this.isFirstColumn = isFirstColumn;
        this.isLastColumn = isLastColumn;
    }

    public final l<Integer, Boolean> isFirstColumn() {
        return this.isFirstColumn;
    }

    public final l<Integer, Boolean> isFirstRow() {
        return this.isFirstRow;
    }

    public final l<Integer, Boolean> isLastColumn() {
        return this.isLastColumn;
    }

    public final l<Integer, Boolean> isLastRow() {
        return this.isLastRow;
    }
}
