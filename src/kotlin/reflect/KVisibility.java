package kotlin.reflect;

import kotlin.enums.a;
import q9.InterfaceC1496a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: KVisibility.kt */
/* loaded from: classes4.dex */
public final class KVisibility {

    /* renamed from: a, reason: collision with root package name */
    public static final KVisibility f34249a = new KVisibility("PUBLIC", 0);

    /* renamed from: b, reason: collision with root package name */
    public static final KVisibility f34250b = new KVisibility("PROTECTED", 1);

    /* renamed from: c, reason: collision with root package name */
    public static final KVisibility f34251c = new KVisibility("INTERNAL", 2);

    /* renamed from: d, reason: collision with root package name */
    public static final KVisibility f34252d = new KVisibility("PRIVATE", 3);

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ KVisibility[] f34253e;

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC1496a f34254f;

    static {
        KVisibility[] a10 = a();
        f34253e = a10;
        f34254f = a.a(a10);
    }

    public KVisibility(String str, int i10) {
    }

    public static final /* synthetic */ KVisibility[] a() {
        return new KVisibility[]{f34249a, f34250b, f34251c, f34252d};
    }

    public static KVisibility valueOf(String str) {
        return (KVisibility) Enum.valueOf(KVisibility.class, str);
    }

    public static KVisibility[] values() {
        return (KVisibility[]) f34253e.clone();
    }
}
