package com.coui.appcompat.card;

/* compiled from: CardMargin.kt */
/* loaded from: classes.dex */
public final class CardMargin {
    private final int firstColumnInner;
    private final int firstColumnOuter;
    private final int firstRowTop;
    private final int otherRowTop;

    public CardMargin(int i10, int i11, int i12, int i13) {
        this.firstRowTop = i10;
        this.otherRowTop = i11;
        this.firstColumnOuter = i12;
        this.firstColumnInner = i13;
    }

    public static /* synthetic */ CardMargin copy$default(CardMargin cardMargin, int i10, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i10 = cardMargin.firstRowTop;
        }
        if ((i14 & 2) != 0) {
            i11 = cardMargin.otherRowTop;
        }
        if ((i14 & 4) != 0) {
            i12 = cardMargin.firstColumnOuter;
        }
        if ((i14 & 8) != 0) {
            i13 = cardMargin.firstColumnInner;
        }
        return cardMargin.copy(i10, i11, i12, i13);
    }

    public final int component1() {
        return this.firstRowTop;
    }

    public final int component2() {
        return this.otherRowTop;
    }

    public final int component3() {
        return this.firstColumnOuter;
    }

    public final int component4() {
        return this.firstColumnInner;
    }

    public final CardMargin copy(int i10, int i11, int i12, int i13) {
        return new CardMargin(i10, i11, i12, i13);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CardMargin)) {
            return false;
        }
        CardMargin cardMargin = (CardMargin) obj;
        if (this.firstRowTop == cardMargin.firstRowTop && this.otherRowTop == cardMargin.otherRowTop && this.firstColumnOuter == cardMargin.firstColumnOuter && this.firstColumnInner == cardMargin.firstColumnInner) {
            return true;
        }
        return false;
    }

    public final int getFirstColumnInner() {
        return this.firstColumnInner;
    }

    public final int getFirstColumnOuter() {
        return this.firstColumnOuter;
    }

    public final int getFirstRowTop() {
        return this.firstRowTop;
    }

    public final int getOtherRowTop() {
        return this.otherRowTop;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.firstRowTop) * 31) + Integer.hashCode(this.otherRowTop)) * 31) + Integer.hashCode(this.firstColumnOuter)) * 31) + Integer.hashCode(this.firstColumnInner);
    }

    public String toString() {
        return "CardMargin(firstRowTop=" + this.firstRowTop + ", otherRowTop=" + this.otherRowTop + ", firstColumnOuter=" + this.firstColumnOuter + ", firstColumnInner=" + this.firstColumnInner + ')';
    }
}
