package com.oplus.blacklistapp.callintercept.provider;

import d.InterfaceC0944a;
import java.util.List;
import kotlin.jvm.internal.i;

/* compiled from: CallInterceptMarkedNumberSettings.kt */
@InterfaceC0944a
/* loaded from: classes3.dex */
public final class CallInterceptMarkedNumberSimCardSettings {
    private final boolean isEnable;
    private final String settingsAction;
    private final String simCardName;
    private final int slotId;
    private final List<CallInterceptMarkedNumberStrength> strengths;
    private final List<CallInterceptMarkedNumberSubSwitch> switches;
    private final boolean useSim1Rules;

    public CallInterceptMarkedNumberSimCardSettings(boolean z10, int i10, String simCardName, boolean z11, String settingsAction, List<CallInterceptMarkedNumberStrength> strengths, List<CallInterceptMarkedNumberSubSwitch> switches) {
        i.f(simCardName, "simCardName");
        i.f(settingsAction, "settingsAction");
        i.f(strengths, "strengths");
        i.f(switches, "switches");
        this.isEnable = z10;
        this.slotId = i10;
        this.simCardName = simCardName;
        this.useSim1Rules = z11;
        this.settingsAction = settingsAction;
        this.strengths = strengths;
        this.switches = switches;
    }

    public static /* synthetic */ CallInterceptMarkedNumberSimCardSettings copy$default(CallInterceptMarkedNumberSimCardSettings callInterceptMarkedNumberSimCardSettings, boolean z10, int i10, String str, boolean z11, String str2, List list, List list2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = callInterceptMarkedNumberSimCardSettings.isEnable;
        }
        if ((i11 & 2) != 0) {
            i10 = callInterceptMarkedNumberSimCardSettings.slotId;
        }
        int i12 = i10;
        if ((i11 & 4) != 0) {
            str = callInterceptMarkedNumberSimCardSettings.simCardName;
        }
        String str3 = str;
        if ((i11 & 8) != 0) {
            z11 = callInterceptMarkedNumberSimCardSettings.useSim1Rules;
        }
        boolean z12 = z11;
        if ((i11 & 16) != 0) {
            str2 = callInterceptMarkedNumberSimCardSettings.settingsAction;
        }
        String str4 = str2;
        if ((i11 & 32) != 0) {
            list = callInterceptMarkedNumberSimCardSettings.strengths;
        }
        List list3 = list;
        if ((i11 & 64) != 0) {
            list2 = callInterceptMarkedNumberSimCardSettings.switches;
        }
        return callInterceptMarkedNumberSimCardSettings.copy(z10, i12, str3, z12, str4, list3, list2);
    }

    public final boolean component1() {
        return this.isEnable;
    }

    public final int component2() {
        return this.slotId;
    }

    public final String component3() {
        return this.simCardName;
    }

    public final boolean component4() {
        return this.useSim1Rules;
    }

    public final String component5() {
        return this.settingsAction;
    }

    public final List<CallInterceptMarkedNumberStrength> component6() {
        return this.strengths;
    }

    public final List<CallInterceptMarkedNumberSubSwitch> component7() {
        return this.switches;
    }

    public final CallInterceptMarkedNumberSimCardSettings copy(boolean z10, int i10, String simCardName, boolean z11, String settingsAction, List<CallInterceptMarkedNumberStrength> strengths, List<CallInterceptMarkedNumberSubSwitch> switches) {
        i.f(simCardName, "simCardName");
        i.f(settingsAction, "settingsAction");
        i.f(strengths, "strengths");
        i.f(switches, "switches");
        return new CallInterceptMarkedNumberSimCardSettings(z10, i10, simCardName, z11, settingsAction, strengths, switches);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CallInterceptMarkedNumberSimCardSettings)) {
            return false;
        }
        CallInterceptMarkedNumberSimCardSettings callInterceptMarkedNumberSimCardSettings = (CallInterceptMarkedNumberSimCardSettings) obj;
        if (this.isEnable == callInterceptMarkedNumberSimCardSettings.isEnable && this.slotId == callInterceptMarkedNumberSimCardSettings.slotId && i.b(this.simCardName, callInterceptMarkedNumberSimCardSettings.simCardName) && this.useSim1Rules == callInterceptMarkedNumberSimCardSettings.useSim1Rules && i.b(this.settingsAction, callInterceptMarkedNumberSimCardSettings.settingsAction) && i.b(this.strengths, callInterceptMarkedNumberSimCardSettings.strengths) && i.b(this.switches, callInterceptMarkedNumberSimCardSettings.switches)) {
            return true;
        }
        return false;
    }

    public final String getSettingsAction() {
        return this.settingsAction;
    }

    public final String getSimCardName() {
        return this.simCardName;
    }

    public final int getSlotId() {
        return this.slotId;
    }

    public final List<CallInterceptMarkedNumberStrength> getStrengths() {
        return this.strengths;
    }

    public final List<CallInterceptMarkedNumberSubSwitch> getSwitches() {
        return this.switches;
    }

    public final boolean getUseSim1Rules() {
        return this.useSim1Rules;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    public int hashCode() {
        boolean z10 = this.isEnable;
        int i10 = 1;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        int hashCode = ((((r02 * 31) + Integer.hashCode(this.slotId)) * 31) + this.simCardName.hashCode()) * 31;
        boolean z11 = this.useSim1Rules;
        if (!z11) {
            i10 = z11 ? 1 : 0;
        }
        return ((((((hashCode + i10) * 31) + this.settingsAction.hashCode()) * 31) + this.strengths.hashCode()) * 31) + this.switches.hashCode();
    }

    public final boolean isEnable() {
        return this.isEnable;
    }

    public String toString() {
        return "CallInterceptMarkedNumberSimCardSettings(isEnable=" + this.isEnable + ", slotId=" + this.slotId + ", simCardName=" + this.simCardName + ", useSim1Rules=" + this.useSim1Rules + ", settingsAction=" + this.settingsAction + ", strengths=" + this.strengths + ", switches=" + this.switches + ")";
    }
}
