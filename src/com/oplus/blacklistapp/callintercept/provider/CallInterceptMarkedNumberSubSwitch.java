package com.oplus.blacklistapp.callintercept.provider;

import d.InterfaceC0944a;
import kotlin.jvm.internal.i;

/* compiled from: CallInterceptMarkedNumberSettings.kt */
@InterfaceC0944a
/* loaded from: classes3.dex */
public final class CallInterceptMarkedNumberSubSwitch {
    private final boolean isOpen;
    private final String type;

    public CallInterceptMarkedNumberSubSwitch(boolean z10, String type) {
        i.f(type, "type");
        this.isOpen = z10;
        this.type = type;
    }

    public static /* synthetic */ CallInterceptMarkedNumberSubSwitch copy$default(CallInterceptMarkedNumberSubSwitch callInterceptMarkedNumberSubSwitch, boolean z10, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = callInterceptMarkedNumberSubSwitch.isOpen;
        }
        if ((i10 & 2) != 0) {
            str = callInterceptMarkedNumberSubSwitch.type;
        }
        return callInterceptMarkedNumberSubSwitch.copy(z10, str);
    }

    public final boolean component1() {
        return this.isOpen;
    }

    public final String component2() {
        return this.type;
    }

    public final CallInterceptMarkedNumberSubSwitch copy(boolean z10, String type) {
        i.f(type, "type");
        return new CallInterceptMarkedNumberSubSwitch(z10, type);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CallInterceptMarkedNumberSubSwitch)) {
            return false;
        }
        CallInterceptMarkedNumberSubSwitch callInterceptMarkedNumberSubSwitch = (CallInterceptMarkedNumberSubSwitch) obj;
        if (this.isOpen == callInterceptMarkedNumberSubSwitch.isOpen && i.b(this.type, callInterceptMarkedNumberSubSwitch.type)) {
            return true;
        }
        return false;
    }

    public final String getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z10 = this.isOpen;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        return (r02 * 31) + this.type.hashCode();
    }

    public final boolean isOpen() {
        return this.isOpen;
    }

    public String toString() {
        return "CallInterceptMarkedNumberSubSwitch(isOpen=" + this.isOpen + ", type=" + this.type + ")";
    }
}
