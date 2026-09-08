package com.coui.appcompat.opensource;

import androidx.recyclerview.widget.j;
import kotlin.jvm.internal.i;

/* compiled from: COUIOpenSourceStatementAdapter.kt */
/* loaded from: classes.dex */
public final class DiffCallback extends j.f<StatementSegment> {
    @Override // androidx.recyclerview.widget.j.f
    public boolean areContentsTheSame(StatementSegment oldItem, StatementSegment newItem) {
        i.f(oldItem, "oldItem");
        i.f(newItem, "newItem");
        return i.b(oldItem.getContent(), newItem.getContent());
    }

    @Override // androidx.recyclerview.widget.j.f
    public boolean areItemsTheSame(StatementSegment oldItem, StatementSegment newItem) {
        i.f(oldItem, "oldItem");
        i.f(newItem, "newItem");
        return i.b(oldItem, newItem);
    }
}
