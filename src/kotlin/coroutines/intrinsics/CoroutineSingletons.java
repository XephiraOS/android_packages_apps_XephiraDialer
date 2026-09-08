package kotlin.coroutines.intrinsics;

import q9.InterfaceC1496a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: Intrinsics.kt */
/* loaded from: classes4.dex */
public final class CoroutineSingletons {

    /* renamed from: a, reason: collision with root package name */
    public static final CoroutineSingletons f34219a = new CoroutineSingletons("COROUTINE_SUSPENDED", 0);

    /* renamed from: b, reason: collision with root package name */
    public static final CoroutineSingletons f34220b = new CoroutineSingletons("UNDECIDED", 1);

    /* renamed from: c, reason: collision with root package name */
    public static final CoroutineSingletons f34221c = new CoroutineSingletons("RESUMED", 2);

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ CoroutineSingletons[] f34222d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC1496a f34223e;

    static {
        CoroutineSingletons[] a10 = a();
        f34222d = a10;
        f34223e = kotlin.enums.a.a(a10);
    }

    public CoroutineSingletons(String str, int i10) {
    }

    public static final /* synthetic */ CoroutineSingletons[] a() {
        return new CoroutineSingletons[]{f34219a, f34220b, f34221c};
    }

    public static CoroutineSingletons valueOf(String str) {
        return (CoroutineSingletons) Enum.valueOf(CoroutineSingletons.class, str);
    }

    public static CoroutineSingletons[] values() {
        return (CoroutineSingletons[]) f34222d.clone();
    }
}
