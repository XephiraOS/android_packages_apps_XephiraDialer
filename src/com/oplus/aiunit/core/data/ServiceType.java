package com.oplus.aiunit.core.data;

import q9.InterfaceC1496a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public final class ServiceType {

    /* renamed from: a, reason: collision with root package name */
    public static final ServiceType f25583a = new ServiceType("NONE", 0, "");

    /* renamed from: b, reason: collision with root package name */
    public static final ServiceType f25584b = new ServiceType("AIUNIT", 1, "com.oplus.aiunit");

    /* renamed from: c, reason: collision with root package name */
    public static final ServiceType f25585c = new ServiceType("OCRSERVICE", 2, "com.coloros.ocrservice");

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ ServiceType[] f25586d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC1496a f25587e;
    private final String pkgName;

    static {
        ServiceType[] a10 = a();
        f25586d = a10;
        f25587e = kotlin.enums.a.a(a10);
    }

    public ServiceType(String str, int i10, String str2) {
        this.pkgName = str2;
    }

    public static final /* synthetic */ ServiceType[] a() {
        return new ServiceType[]{f25583a, f25584b, f25585c};
    }

    public static ServiceType valueOf(String str) {
        return (ServiceType) Enum.valueOf(ServiceType.class, str);
    }

    public static ServiceType[] values() {
        return (ServiceType[]) f25586d.clone();
    }

    public final String b() {
        return this.pkgName;
    }
}
