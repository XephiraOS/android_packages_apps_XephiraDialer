package com.oplus.blacklistapp.callintercept.provider;

import d.InterfaceC0944a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: CallInterceptMarkedNumberSettings.kt */
@InterfaceC0944a
/* loaded from: classes3.dex */
public final class CallReleaseRulesSettings {
    private final boolean isSupport;
    private final List<CallReleaseRulesSimSettings> simCardSettings;
    private final HashSet<String> specialNumbers;

    public CallReleaseRulesSettings(boolean z10, HashSet<String> hashSet, List<CallReleaseRulesSimSettings> simCardSettings) {
        i.f(simCardSettings, "simCardSettings");
        this.isSupport = z10;
        this.specialNumbers = hashSet;
        this.simCardSettings = simCardSettings;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CallReleaseRulesSettings copy$default(CallReleaseRulesSettings callReleaseRulesSettings, boolean z10, HashSet hashSet, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = callReleaseRulesSettings.isSupport;
        }
        if ((i10 & 2) != 0) {
            hashSet = callReleaseRulesSettings.specialNumbers;
        }
        if ((i10 & 4) != 0) {
            list = callReleaseRulesSettings.simCardSettings;
        }
        return callReleaseRulesSettings.copy(z10, hashSet, list);
    }

    public final boolean component1() {
        return this.isSupport;
    }

    public final HashSet<String> component2() {
        return this.specialNumbers;
    }

    public final List<CallReleaseRulesSimSettings> component3() {
        return this.simCardSettings;
    }

    public final CallReleaseRulesSettings copy(boolean z10, HashSet<String> hashSet, List<CallReleaseRulesSimSettings> simCardSettings) {
        i.f(simCardSettings, "simCardSettings");
        return new CallReleaseRulesSettings(z10, hashSet, simCardSettings);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CallReleaseRulesSettings)) {
            return false;
        }
        CallReleaseRulesSettings callReleaseRulesSettings = (CallReleaseRulesSettings) obj;
        if (this.isSupport == callReleaseRulesSettings.isSupport && i.b(this.specialNumbers, callReleaseRulesSettings.specialNumbers) && i.b(this.simCardSettings, callReleaseRulesSettings.simCardSettings)) {
            return true;
        }
        return false;
    }

    public final List<CallReleaseRulesSimSettings> getSimCardSettings() {
        return this.simCardSettings;
    }

    public final HashSet<String> getSpecialNumbers() {
        return this.specialNumbers;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        int hashCode;
        boolean z10 = this.isSupport;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        int i10 = r02 * 31;
        HashSet<String> hashSet = this.specialNumbers;
        if (hashSet == null) {
            hashCode = 0;
        } else {
            hashCode = hashSet.hashCode();
        }
        return ((i10 + hashCode) * 31) + this.simCardSettings.hashCode();
    }

    public final boolean isSupport() {
        return this.isSupport;
    }

    public String toString() {
        return "CallReleaseRulesSettings(isSupport=" + this.isSupport + ", specialNumbers=" + this.specialNumbers + ", simCardSettings=" + this.simCardSettings + ")";
    }

    public /* synthetic */ CallReleaseRulesSettings(boolean z10, HashSet hashSet, List list, int i10, f fVar) {
        this(z10, hashSet, (i10 & 4) != 0 ? new ArrayList() : list);
    }
}
