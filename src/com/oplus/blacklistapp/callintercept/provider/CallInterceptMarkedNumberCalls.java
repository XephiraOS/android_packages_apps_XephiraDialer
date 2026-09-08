package com.oplus.blacklistapp.callintercept.provider;

import d.InterfaceC0944a;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: CallInterceptMarkedNumberCalls.kt */
@InterfaceC0944a
/* loaded from: classes3.dex */
public final class CallInterceptMarkedNumberCalls {
    private final int maxCountPerSimCard;
    private final List<SimCardCalls> simCardCalls;

    public CallInterceptMarkedNumberCalls(int i10, List<SimCardCalls> simCardCalls) {
        i.f(simCardCalls, "simCardCalls");
        this.maxCountPerSimCard = i10;
        this.simCardCalls = simCardCalls;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CallInterceptMarkedNumberCalls copy$default(CallInterceptMarkedNumberCalls callInterceptMarkedNumberCalls, int i10, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = callInterceptMarkedNumberCalls.maxCountPerSimCard;
        }
        if ((i11 & 2) != 0) {
            list = callInterceptMarkedNumberCalls.simCardCalls;
        }
        return callInterceptMarkedNumberCalls.copy(i10, list);
    }

    public final int component1() {
        return this.maxCountPerSimCard;
    }

    public final List<SimCardCalls> component2() {
        return this.simCardCalls;
    }

    public final CallInterceptMarkedNumberCalls copy(int i10, List<SimCardCalls> simCardCalls) {
        i.f(simCardCalls, "simCardCalls");
        return new CallInterceptMarkedNumberCalls(i10, simCardCalls);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CallInterceptMarkedNumberCalls)) {
            return false;
        }
        CallInterceptMarkedNumberCalls callInterceptMarkedNumberCalls = (CallInterceptMarkedNumberCalls) obj;
        if (this.maxCountPerSimCard == callInterceptMarkedNumberCalls.maxCountPerSimCard && i.b(this.simCardCalls, callInterceptMarkedNumberCalls.simCardCalls)) {
            return true;
        }
        return false;
    }

    public final int getMaxCountPerSimCard() {
        return this.maxCountPerSimCard;
    }

    public final List<SimCardCalls> getSimCardCalls() {
        return this.simCardCalls;
    }

    public int hashCode() {
        return (Integer.hashCode(this.maxCountPerSimCard) * 31) + this.simCardCalls.hashCode();
    }

    public String toString() {
        return "CallInterceptMarkedNumberCalls(maxCountPerSimCard=" + this.maxCountPerSimCard + ", simCardCalls=" + this.simCardCalls + ")";
    }

    public /* synthetic */ CallInterceptMarkedNumberCalls(int i10, List list, int i11, f fVar) {
        this(i10, (i11 & 2) != 0 ? new ArrayList() : list);
    }
}
