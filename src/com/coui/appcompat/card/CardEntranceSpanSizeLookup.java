package com.coui.appcompat.card;

import androidx.preference.Preference;
import androidx.preference.h;
import androidx.recyclerview.widget.GridLayoutManager;
import kotlin.jvm.internal.f;

/* compiled from: CardEntranceSpanSizeLookup.kt */
/* loaded from: classes.dex */
public final class CardEntranceSpanSizeLookup extends GridLayoutManager.b {
    public static final Companion Companion = new Companion(null);
    public static final int SPAN_COUNT_CARD_TYPE_LARGE = 2;
    public static final int SPAN_COUNT_CARD_TYPE_SMALL = 1;
    private h adapter;

    /* compiled from: CardEntranceSpanSizeLookup.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CardEntranceSpanSizeLookup() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final h getAdapter() {
        return this.adapter;
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager.b
    public int getSpanSize(int i10) {
        Preference preference;
        h hVar = this.adapter;
        if (hVar != null) {
            preference = hVar.j(i10);
        } else {
            preference = null;
        }
        if (!(preference instanceof COUICardEntrancePreference)) {
            return 2;
        }
        int cardType = ((COUICardEntrancePreference) preference).getCardType();
        if (cardType != 1 && cardType == 2) {
            return 2;
        }
        return 1;
    }

    public final void setAdapter(h hVar) {
        this.adapter = hVar;
    }

    public /* synthetic */ CardEntranceSpanSizeLookup(h hVar, int i10, f fVar) {
        this((i10 & 1) != 0 ? null : hVar);
    }

    public CardEntranceSpanSizeLookup(h hVar) {
        this.adapter = hVar;
    }
}
