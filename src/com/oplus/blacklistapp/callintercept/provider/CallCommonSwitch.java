package com.oplus.blacklistapp.callintercept.provider;

import d.InterfaceC0944a;
import kotlin.jvm.internal.i;

/* compiled from: CallInterceptMarkedNumberSettings.kt */
@InterfaceC0944a
/* loaded from: classes3.dex */
public final class CallCommonSwitch {
    private final boolean isOpen;
    private final int slotId;
    private final String type;

    public CallCommonSwitch(boolean z10, int i10, String type) {
        i.f(type, "type");
        this.isOpen = z10;
        this.slotId = i10;
        this.type = type;
    }

    public static /* synthetic */ CallCommonSwitch copy$default(CallCommonSwitch callCommonSwitch, boolean z10, int i10, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = callCommonSwitch.isOpen;
        }
        if ((i11 & 2) != 0) {
            i10 = callCommonSwitch.slotId;
        }
        if ((i11 & 4) != 0) {
            str = callCommonSwitch.type;
        }
        return callCommonSwitch.copy(z10, i10, str);
    }

    public final boolean component1() {
        return this.isOpen;
    }

    public final int component2() {
        return this.slotId;
    }

    public final String component3() {
        return this.type;
    }

    public final CallCommonSwitch copy(boolean z10, int i10, String type) {
        i.f(type, "type");
        return new CallCommonSwitch(z10, i10, type);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CallCommonSwitch)) {
            return false;
        }
        CallCommonSwitch callCommonSwitch = (CallCommonSwitch) obj;
        if (this.isOpen == callCommonSwitch.isOpen && this.slotId == callCommonSwitch.slotId && i.b(this.type, callCommonSwitch.type)) {
            return true;
        }
        return false;
    }

    public final int getSlotId() {
        return this.slotId;
    }

    public final String getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z10 = this.isOpen;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        return (((r02 * 31) + Integer.hashCode(this.slotId)) * 31) + this.type.hashCode();
    }

    public final boolean isOpen() {
        return this.isOpen;
    }

    public String toString() {
        return "CallCommonSwitch(isOpen=" + this.isOpen + ", slotId=" + this.slotId + ", type=" + this.type + ")";
    }
}
