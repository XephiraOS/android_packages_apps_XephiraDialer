package com.oplus.blacklistapp.callintercept.provider;

import d.InterfaceC0944a;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: CallInterceptMarkedNumberCalls.kt */
@InterfaceC0944a
/* loaded from: classes3.dex */
public final class SimCardCalls {
    private final List<CallsCount> markedNumberCalls;
    private final CallsCount otherCalls;
    private final int slotId;
    private int totalCount;

    public SimCardCalls(int i10, CallsCount otherCalls, List<CallsCount> markedNumberCalls, int i11) {
        i.f(otherCalls, "otherCalls");
        i.f(markedNumberCalls, "markedNumberCalls");
        this.slotId = i10;
        this.otherCalls = otherCalls;
        this.markedNumberCalls = markedNumberCalls;
        this.totalCount = i11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SimCardCalls copy$default(SimCardCalls simCardCalls, int i10, CallsCount callsCount, List list, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = simCardCalls.slotId;
        }
        if ((i12 & 2) != 0) {
            callsCount = simCardCalls.otherCalls;
        }
        if ((i12 & 4) != 0) {
            list = simCardCalls.markedNumberCalls;
        }
        if ((i12 & 8) != 0) {
            i11 = simCardCalls.totalCount;
        }
        return simCardCalls.copy(i10, callsCount, list, i11);
    }

    public final int component1() {
        return this.slotId;
    }

    public final CallsCount component2() {
        return this.otherCalls;
    }

    public final List<CallsCount> component3() {
        return this.markedNumberCalls;
    }

    public final int component4() {
        return this.totalCount;
    }

    public final SimCardCalls copy(int i10, CallsCount otherCalls, List<CallsCount> markedNumberCalls, int i11) {
        i.f(otherCalls, "otherCalls");
        i.f(markedNumberCalls, "markedNumberCalls");
        return new SimCardCalls(i10, otherCalls, markedNumberCalls, i11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SimCardCalls)) {
            return false;
        }
        SimCardCalls simCardCalls = (SimCardCalls) obj;
        if (this.slotId == simCardCalls.slotId && i.b(this.otherCalls, simCardCalls.otherCalls) && i.b(this.markedNumberCalls, simCardCalls.markedNumberCalls) && this.totalCount == simCardCalls.totalCount) {
            return true;
        }
        return false;
    }

    public final List<CallsCount> getMarkedNumberCalls() {
        return this.markedNumberCalls;
    }

    public final CallsCount getOtherCalls() {
        return this.otherCalls;
    }

    public final int getSlotId() {
        return this.slotId;
    }

    public final int getTotalCount() {
        return this.totalCount;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.slotId) * 31) + this.otherCalls.hashCode()) * 31) + this.markedNumberCalls.hashCode()) * 31) + Integer.hashCode(this.totalCount);
    }

    public final void setTotalCount(int i10) {
        this.totalCount = i10;
    }

    public String toString() {
        return "SimCardCalls(slotId=" + this.slotId + ", otherCalls=" + this.otherCalls + ", markedNumberCalls=" + this.markedNumberCalls + ", totalCount=" + this.totalCount + ")";
    }

    public /* synthetic */ SimCardCalls(int i10, CallsCount callsCount, List list, int i11, int i12, f fVar) {
        this(i10, callsCount, list, (i12 & 8) != 0 ? 0 : i11);
    }
}
