package kotlin.enums;

import java.io.Serializable;
import java.lang.Enum;
import kotlin.collections.AbstractC1221b;
import kotlin.collections.C1229j;
import kotlin.jvm.internal.i;
import q9.InterfaceC1496a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EnumEntries.kt */
/* loaded from: classes4.dex */
public final class EnumEntriesList<T extends Enum<T>> extends AbstractC1221b<T> implements InterfaceC1496a<T>, Serializable {
    private final T[] entries;

    public EnumEntriesList(T[] entries) {
        i.f(entries, "entries");
        this.entries = entries;
    }

    private final Object writeReplace() {
        return new EnumEntriesSerializationProxy(this.entries);
    }

    @Override // kotlin.collections.AbstractCollection
    public int a() {
        return this.entries.length;
    }

    public boolean c(T element) {
        Object A10;
        i.f(element, "element");
        A10 = C1229j.A(this.entries, element.ordinal());
        if (((Enum) A10) == element) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof Enum)) {
            return false;
        }
        return c((Enum) obj);
    }

    @Override // kotlin.collections.AbstractC1221b, java.util.List
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public T get(int i10) {
        AbstractC1221b.f34189a.a(i10, this.entries.length);
        return this.entries[i10];
    }

    public int g(T element) {
        Object A10;
        i.f(element, "element");
        int ordinal = element.ordinal();
        A10 = C1229j.A(this.entries, ordinal);
        if (((Enum) A10) != element) {
            return -1;
        }
        return ordinal;
    }

    public int h(T element) {
        i.f(element, "element");
        return indexOf(element);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.AbstractC1221b, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        return g((Enum) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.AbstractC1221b, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        return h((Enum) obj);
    }
}
