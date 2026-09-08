package com.oplus.blacklistapp.callintercept.provider;

import d.InterfaceC0944a;
import java.util.HashSet;
import kotlin.jvm.internal.i;

/* compiled from: CallInterceptMarkedNumberSettings.kt */
@InterfaceC0944a
/* loaded from: classes3.dex */
public final class CallBlockRegionNumbersSimSwitch {
    private final HashSet<Long> areaList;
    private final boolean isOpen;
    private final int slotId;
    private final String type;

    public CallBlockRegionNumbersSimSwitch(boolean z10, int i10, String type, HashSet<Long> hashSet) {
        i.f(type, "type");
        this.isOpen = z10;
        this.slotId = i10;
        this.type = type;
        this.areaList = hashSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CallBlockRegionNumbersSimSwitch copy$default(CallBlockRegionNumbersSimSwitch callBlockRegionNumbersSimSwitch, boolean z10, int i10, String str, HashSet hashSet, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = callBlockRegionNumbersSimSwitch.isOpen;
        }
        if ((i11 & 2) != 0) {
            i10 = callBlockRegionNumbersSimSwitch.slotId;
        }
        if ((i11 & 4) != 0) {
            str = callBlockRegionNumbersSimSwitch.type;
        }
        if ((i11 & 8) != 0) {
            hashSet = callBlockRegionNumbersSimSwitch.areaList;
        }
        return callBlockRegionNumbersSimSwitch.copy(z10, i10, str, hashSet);
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

    public final HashSet<Long> component4() {
        return this.areaList;
    }

    public final CallBlockRegionNumbersSimSwitch copy(boolean z10, int i10, String type, HashSet<Long> hashSet) {
        i.f(type, "type");
        return new CallBlockRegionNumbersSimSwitch(z10, i10, type, hashSet);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CallBlockRegionNumbersSimSwitch)) {
            return false;
        }
        CallBlockRegionNumbersSimSwitch callBlockRegionNumbersSimSwitch = (CallBlockRegionNumbersSimSwitch) obj;
        if (this.isOpen == callBlockRegionNumbersSimSwitch.isOpen && this.slotId == callBlockRegionNumbersSimSwitch.slotId && i.b(this.type, callBlockRegionNumbersSimSwitch.type) && i.b(this.areaList, callBlockRegionNumbersSimSwitch.areaList)) {
            return true;
        }
        return false;
    }

    public final HashSet<Long> getAreaList() {
        return this.areaList;
    }

    public final int getSlotId() {
        return this.slotId;
    }

    public final String getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        int hashCode;
        boolean z10 = this.isOpen;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        int hashCode2 = ((((r02 * 31) + Integer.hashCode(this.slotId)) * 31) + this.type.hashCode()) * 31;
        HashSet<Long> hashSet = this.areaList;
        if (hashSet == null) {
            hashCode = 0;
        } else {
            hashCode = hashSet.hashCode();
        }
        return hashCode2 + hashCode;
    }

    public final boolean isOpen() {
        return this.isOpen;
    }

    public String toString() {
        return "CallBlockRegionNumbersSimSwitch(isOpen=" + this.isOpen + ", slotId=" + this.slotId + ", type=" + this.type + ", areaList=" + this.areaList + ")";
    }
}
