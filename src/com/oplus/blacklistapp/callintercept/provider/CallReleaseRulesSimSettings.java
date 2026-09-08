package com.oplus.blacklistapp.callintercept.provider;

import d.InterfaceC0944a;
import kotlin.jvm.internal.i;

/* compiled from: CallInterceptMarkedNumberSettings.kt */
@InterfaceC0944a
/* loaded from: classes3.dex */
public final class CallReleaseRulesSimSettings {
    private final CallCommonSwitch releaseRepeatCallSwitch;
    private final CallCommonSwitch releaseSpecialNumbersSwitch;
    private final ScheduleBlockSwitch scheduleBlockSwitch;

    public CallReleaseRulesSimSettings(ScheduleBlockSwitch scheduleBlockSwitch, CallCommonSwitch releaseRepeatCallSwitch, CallCommonSwitch releaseSpecialNumbersSwitch) {
        i.f(scheduleBlockSwitch, "scheduleBlockSwitch");
        i.f(releaseRepeatCallSwitch, "releaseRepeatCallSwitch");
        i.f(releaseSpecialNumbersSwitch, "releaseSpecialNumbersSwitch");
        this.scheduleBlockSwitch = scheduleBlockSwitch;
        this.releaseRepeatCallSwitch = releaseRepeatCallSwitch;
        this.releaseSpecialNumbersSwitch = releaseSpecialNumbersSwitch;
    }

    public static /* synthetic */ CallReleaseRulesSimSettings copy$default(CallReleaseRulesSimSettings callReleaseRulesSimSettings, ScheduleBlockSwitch scheduleBlockSwitch, CallCommonSwitch callCommonSwitch, CallCommonSwitch callCommonSwitch2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            scheduleBlockSwitch = callReleaseRulesSimSettings.scheduleBlockSwitch;
        }
        if ((i10 & 2) != 0) {
            callCommonSwitch = callReleaseRulesSimSettings.releaseRepeatCallSwitch;
        }
        if ((i10 & 4) != 0) {
            callCommonSwitch2 = callReleaseRulesSimSettings.releaseSpecialNumbersSwitch;
        }
        return callReleaseRulesSimSettings.copy(scheduleBlockSwitch, callCommonSwitch, callCommonSwitch2);
    }

    public final ScheduleBlockSwitch component1() {
        return this.scheduleBlockSwitch;
    }

    public final CallCommonSwitch component2() {
        return this.releaseRepeatCallSwitch;
    }

    public final CallCommonSwitch component3() {
        return this.releaseSpecialNumbersSwitch;
    }

    public final CallReleaseRulesSimSettings copy(ScheduleBlockSwitch scheduleBlockSwitch, CallCommonSwitch releaseRepeatCallSwitch, CallCommonSwitch releaseSpecialNumbersSwitch) {
        i.f(scheduleBlockSwitch, "scheduleBlockSwitch");
        i.f(releaseRepeatCallSwitch, "releaseRepeatCallSwitch");
        i.f(releaseSpecialNumbersSwitch, "releaseSpecialNumbersSwitch");
        return new CallReleaseRulesSimSettings(scheduleBlockSwitch, releaseRepeatCallSwitch, releaseSpecialNumbersSwitch);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CallReleaseRulesSimSettings)) {
            return false;
        }
        CallReleaseRulesSimSettings callReleaseRulesSimSettings = (CallReleaseRulesSimSettings) obj;
        if (i.b(this.scheduleBlockSwitch, callReleaseRulesSimSettings.scheduleBlockSwitch) && i.b(this.releaseRepeatCallSwitch, callReleaseRulesSimSettings.releaseRepeatCallSwitch) && i.b(this.releaseSpecialNumbersSwitch, callReleaseRulesSimSettings.releaseSpecialNumbersSwitch)) {
            return true;
        }
        return false;
    }

    public final CallCommonSwitch getReleaseRepeatCallSwitch() {
        return this.releaseRepeatCallSwitch;
    }

    public final CallCommonSwitch getReleaseSpecialNumbersSwitch() {
        return this.releaseSpecialNumbersSwitch;
    }

    public final ScheduleBlockSwitch getScheduleBlockSwitch() {
        return this.scheduleBlockSwitch;
    }

    public int hashCode() {
        return (((this.scheduleBlockSwitch.hashCode() * 31) + this.releaseRepeatCallSwitch.hashCode()) * 31) + this.releaseSpecialNumbersSwitch.hashCode();
    }

    public String toString() {
        return "CallReleaseRulesSimSettings(scheduleBlockSwitch=" + this.scheduleBlockSwitch + ", releaseRepeatCallSwitch=" + this.releaseRepeatCallSwitch + ", releaseSpecialNumbersSwitch=" + this.releaseSpecialNumbersSwitch + ")";
    }
}
