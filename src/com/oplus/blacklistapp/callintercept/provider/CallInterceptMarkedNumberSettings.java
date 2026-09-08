package com.oplus.blacklistapp.callintercept.provider;

import d.InterfaceC0944a;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: CallInterceptMarkedNumberSettings.kt */
@InterfaceC0944a
/* loaded from: classes3.dex */
public final class CallInterceptMarkedNumberSettings {
    private final boolean isSupport;
    private final List<CallInterceptMarkedNumberSimCardSettings> simCardSettings;

    public CallInterceptMarkedNumberSettings(boolean z10, List<CallInterceptMarkedNumberSimCardSettings> simCardSettings) {
        i.f(simCardSettings, "simCardSettings");
        this.isSupport = z10;
        this.simCardSettings = simCardSettings;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CallInterceptMarkedNumberSettings copy$default(CallInterceptMarkedNumberSettings callInterceptMarkedNumberSettings, boolean z10, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = callInterceptMarkedNumberSettings.isSupport;
        }
        if ((i10 & 2) != 0) {
            list = callInterceptMarkedNumberSettings.simCardSettings;
        }
        return callInterceptMarkedNumberSettings.copy(z10, list);
    }

    public final boolean component1() {
        return this.isSupport;
    }

    public final List<CallInterceptMarkedNumberSimCardSettings> component2() {
        return this.simCardSettings;
    }

    public final CallInterceptMarkedNumberSettings copy(boolean z10, List<CallInterceptMarkedNumberSimCardSettings> simCardSettings) {
        i.f(simCardSettings, "simCardSettings");
        return new CallInterceptMarkedNumberSettings(z10, simCardSettings);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CallInterceptMarkedNumberSettings)) {
            return false;
        }
        CallInterceptMarkedNumberSettings callInterceptMarkedNumberSettings = (CallInterceptMarkedNumberSettings) obj;
        if (this.isSupport == callInterceptMarkedNumberSettings.isSupport && i.b(this.simCardSettings, callInterceptMarkedNumberSettings.simCardSettings)) {
            return true;
        }
        return false;
    }

    public final List<CallInterceptMarkedNumberSimCardSettings> getSimCardSettings() {
        return this.simCardSettings;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z10 = this.isSupport;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        return (r02 * 31) + this.simCardSettings.hashCode();
    }

    public final boolean isSupport() {
        return this.isSupport;
    }

    public String toString() {
        return "CallInterceptMarkedNumberSettings(isSupport=" + this.isSupport + ", simCardSettings=" + this.simCardSettings + ")";
    }

    public /* synthetic */ CallInterceptMarkedNumberSettings(boolean z10, List list, int i10, f fVar) {
        this(z10, (i10 & 2) != 0 ? new ArrayList() : list);
    }
}
