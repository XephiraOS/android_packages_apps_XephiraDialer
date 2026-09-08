package kotlin.enums;

import kotlin.jvm.internal.i;
import q9.InterfaceC1496a;

/* compiled from: EnumEntries.kt */
/* loaded from: classes4.dex */
public final class a {
    public static final <E extends Enum<E>> InterfaceC1496a<E> a(E[] entries) {
        i.f(entries, "entries");
        return new EnumEntriesList(entries);
    }
}
