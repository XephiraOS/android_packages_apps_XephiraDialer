package com.oplus.blacklistapp.callintercept.provider;

import d.InterfaceC0944a;
import kotlin.jvm.internal.i;

/* compiled from: CallInterceptMarkedNumberSettings.kt */
@InterfaceC0944a
/* loaded from: classes3.dex */
public final class CallInterceptMarkedNumberStrength {
    private final int threshold;
    private final String type;

    public CallInterceptMarkedNumberStrength(int i10, String type) {
        i.f(type, "type");
        this.threshold = i10;
        this.type = type;
    }

    public static /* synthetic */ CallInterceptMarkedNumberStrength copy$default(CallInterceptMarkedNumberStrength callInterceptMarkedNumberStrength, int i10, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = callInterceptMarkedNumberStrength.threshold;
        }
        if ((i11 & 2) != 0) {
            str = callInterceptMarkedNumberStrength.type;
        }
        return callInterceptMarkedNumberStrength.copy(i10, str);
    }

    public final int component1() {
        return this.threshold;
    }

    public final String component2() {
        return this.type;
    }

    public final CallInterceptMarkedNumberStrength copy(int i10, String type) {
        i.f(type, "type");
        return new CallInterceptMarkedNumberStrength(i10, type);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CallInterceptMarkedNumberStrength)) {
            return false;
        }
        CallInterceptMarkedNumberStrength callInterceptMarkedNumberStrength = (CallInterceptMarkedNumberStrength) obj;
        if (this.threshold == callInterceptMarkedNumberStrength.threshold && i.b(this.type, callInterceptMarkedNumberStrength.type)) {
            return true;
        }
        return false;
    }

    public final int getThreshold() {
        return this.threshold;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return (Integer.hashCode(this.threshold) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "CallInterceptMarkedNumberStrength(threshold=" + this.threshold + ", type=" + this.type + ")";
    }
}
