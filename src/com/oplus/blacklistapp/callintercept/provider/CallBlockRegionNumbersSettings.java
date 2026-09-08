package com.oplus.blacklistapp.callintercept.provider;

import d.InterfaceC0944a;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: CallInterceptMarkedNumberSettings.kt */
@InterfaceC0944a
/* loaded from: classes3.dex */
public final class CallBlockRegionNumbersSettings {
    private final boolean isSupport;
    private final List<CallBlockRegionNumbersSimSwitch> simCardSettings;

    public CallBlockRegionNumbersSettings(boolean z10, List<CallBlockRegionNumbersSimSwitch> simCardSettings) {
        i.f(simCardSettings, "simCardSettings");
        this.isSupport = z10;
        this.simCardSettings = simCardSettings;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CallBlockRegionNumbersSettings copy$default(CallBlockRegionNumbersSettings callBlockRegionNumbersSettings, boolean z10, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = callBlockRegionNumbersSettings.isSupport;
        }
        if ((i10 & 2) != 0) {
            list = callBlockRegionNumbersSettings.simCardSettings;
        }
        return callBlockRegionNumbersSettings.copy(z10, list);
    }

    public final boolean component1() {
        return this.isSupport;
    }

    public final List<CallBlockRegionNumbersSimSwitch> component2() {
        return this.simCardSettings;
    }

    public final CallBlockRegionNumbersSettings copy(boolean z10, List<CallBlockRegionNumbersSimSwitch> simCardSettings) {
        i.f(simCardSettings, "simCardSettings");
        return new CallBlockRegionNumbersSettings(z10, simCardSettings);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CallBlockRegionNumbersSettings)) {
            return false;
        }
        CallBlockRegionNumbersSettings callBlockRegionNumbersSettings = (CallBlockRegionNumbersSettings) obj;
        if (this.isSupport == callBlockRegionNumbersSettings.isSupport && i.b(this.simCardSettings, callBlockRegionNumbersSettings.simCardSettings)) {
            return true;
        }
        return false;
    }

    public final List<CallBlockRegionNumbersSimSwitch> getSimCardSettings() {
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
        return "CallBlockRegionNumbersSettings(isSupport=" + this.isSupport + ", simCardSettings=" + this.simCardSettings + ")";
    }

    public /* synthetic */ CallBlockRegionNumbersSettings(boolean z10, List list, int i10, f fVar) {
        this(z10, (i10 & 2) != 0 ? new ArrayList() : list);
    }
}
