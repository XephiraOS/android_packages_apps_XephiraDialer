package kotlin;

import q9.InterfaceC1496a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: Lazy.kt */
/* loaded from: classes4.dex */
public final class LazyThreadSafetyMode {

    /* renamed from: a, reason: collision with root package name */
    public static final LazyThreadSafetyMode f34161a = new LazyThreadSafetyMode("SYNCHRONIZED", 0);

    /* renamed from: b, reason: collision with root package name */
    public static final LazyThreadSafetyMode f34162b = new LazyThreadSafetyMode("PUBLICATION", 1);

    /* renamed from: c, reason: collision with root package name */
    public static final LazyThreadSafetyMode f34163c = new LazyThreadSafetyMode("NONE", 2);

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ LazyThreadSafetyMode[] f34164d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC1496a f34165e;

    static {
        LazyThreadSafetyMode[] a10 = a();
        f34164d = a10;
        f34165e = kotlin.enums.a.a(a10);
    }

    public LazyThreadSafetyMode(String str, int i10) {
    }

    public static final /* synthetic */ LazyThreadSafetyMode[] a() {
        return new LazyThreadSafetyMode[]{f34161a, f34162b, f34163c};
    }

    public static LazyThreadSafetyMode valueOf(String str) {
        return (LazyThreadSafetyMode) Enum.valueOf(LazyThreadSafetyMode.class, str);
    }

    public static LazyThreadSafetyMode[] values() {
        return (LazyThreadSafetyMode[]) f34164d.clone();
    }
}
