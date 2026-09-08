package kotlin.collections;

import q9.InterfaceC1496a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: AbstractIterator.kt */
/* loaded from: classes4.dex */
final class State {

    /* renamed from: a, reason: collision with root package name */
    public static final State f34180a = new State("Ready", 0);

    /* renamed from: b, reason: collision with root package name */
    public static final State f34181b = new State("NotReady", 1);

    /* renamed from: c, reason: collision with root package name */
    public static final State f34182c = new State("Done", 2);

    /* renamed from: d, reason: collision with root package name */
    public static final State f34183d = new State("Failed", 3);

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ State[] f34184e;

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC1496a f34185f;

    static {
        State[] a10 = a();
        f34184e = a10;
        f34185f = kotlin.enums.a.a(a10);
    }

    public State(String str, int i10) {
    }

    public static final /* synthetic */ State[] a() {
        return new State[]{f34180a, f34181b, f34182c, f34183d};
    }

    public static State valueOf(String str) {
        return (State) Enum.valueOf(State.class, str);
    }

    public static State[] values() {
        return (State[]) f34184e.clone();
    }
}
