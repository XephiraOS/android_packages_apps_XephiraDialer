package kotlin.enums;

import java.io.Serializable;
import java.lang.Enum;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: EnumEntriesSerializationProxy.kt */
/* loaded from: classes4.dex */
public final class EnumEntriesSerializationProxy<E extends Enum<E>> implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public static final a f34224a = new a(null);
    private static final long serialVersionUID = 0;

    /* renamed from: c, reason: collision with root package name */
    private final Class<E> f34225c;

    /* compiled from: EnumEntriesSerializationProxy.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public EnumEntriesSerializationProxy(E[] entries) {
        i.f(entries, "entries");
        Class<E> cls = (Class<E>) entries.getClass().getComponentType();
        i.c(cls);
        this.f34225c = cls;
    }

    private final Object readResolve() {
        E[] enumConstants = this.f34225c.getEnumConstants();
        i.e(enumConstants, "getEnumConstants(...)");
        return kotlin.enums.a.a(enumConstants);
    }
}
