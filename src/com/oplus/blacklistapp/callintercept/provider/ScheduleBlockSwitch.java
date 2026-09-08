package com.oplus.blacklistapp.callintercept.provider;

import d.InterfaceC0944a;
import kotlin.jvm.internal.i;

/* compiled from: CallInterceptMarkedNumberSettings.kt */
@InterfaceC0944a
/* loaded from: classes3.dex */
public final class ScheduleBlockSwitch {
    private final int days;
    private final int endHour;
    private final int endMinute;
    private final boolean isOpen;
    private final int slotId;
    private final int startHour;
    private final int startMinute;
    private final String type;

    public ScheduleBlockSwitch(boolean z10, int i10, String type, int i11, int i12, int i13, int i14, int i15) {
        i.f(type, "type");
        this.isOpen = z10;
        this.slotId = i10;
        this.type = type;
        this.days = i11;
        this.startHour = i12;
        this.endHour = i13;
        this.startMinute = i14;
        this.endMinute = i15;
    }

    public static /* synthetic */ ScheduleBlockSwitch copy$default(ScheduleBlockSwitch scheduleBlockSwitch, boolean z10, int i10, String str, int i11, int i12, int i13, int i14, int i15, int i16, Object obj) {
        boolean z11;
        int i17;
        String str2;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        if ((i16 & 1) != 0) {
            z11 = scheduleBlockSwitch.isOpen;
        } else {
            z11 = z10;
        }
        if ((i16 & 2) != 0) {
            i17 = scheduleBlockSwitch.slotId;
        } else {
            i17 = i10;
        }
        if ((i16 & 4) != 0) {
            str2 = scheduleBlockSwitch.type;
        } else {
            str2 = str;
        }
        if ((i16 & 8) != 0) {
            i18 = scheduleBlockSwitch.days;
        } else {
            i18 = i11;
        }
        if ((i16 & 16) != 0) {
            i19 = scheduleBlockSwitch.startHour;
        } else {
            i19 = i12;
        }
        if ((i16 & 32) != 0) {
            i20 = scheduleBlockSwitch.endHour;
        } else {
            i20 = i13;
        }
        if ((i16 & 64) != 0) {
            i21 = scheduleBlockSwitch.startMinute;
        } else {
            i21 = i14;
        }
        if ((i16 & 128) != 0) {
            i22 = scheduleBlockSwitch.endMinute;
        } else {
            i22 = i15;
        }
        return scheduleBlockSwitch.copy(z11, i17, str2, i18, i19, i20, i21, i22);
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

    public final int component4() {
        return this.days;
    }

    public final int component5() {
        return this.startHour;
    }

    public final int component6() {
        return this.endHour;
    }

    public final int component7() {
        return this.startMinute;
    }

    public final int component8() {
        return this.endMinute;
    }

    public final ScheduleBlockSwitch copy(boolean z10, int i10, String type, int i11, int i12, int i13, int i14, int i15) {
        i.f(type, "type");
        return new ScheduleBlockSwitch(z10, i10, type, i11, i12, i13, i14, i15);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScheduleBlockSwitch)) {
            return false;
        }
        ScheduleBlockSwitch scheduleBlockSwitch = (ScheduleBlockSwitch) obj;
        if (this.isOpen == scheduleBlockSwitch.isOpen && this.slotId == scheduleBlockSwitch.slotId && i.b(this.type, scheduleBlockSwitch.type) && this.days == scheduleBlockSwitch.days && this.startHour == scheduleBlockSwitch.startHour && this.endHour == scheduleBlockSwitch.endHour && this.startMinute == scheduleBlockSwitch.startMinute && this.endMinute == scheduleBlockSwitch.endMinute) {
            return true;
        }
        return false;
    }

    public final int getDays() {
        return this.days;
    }

    public final int getEndHour() {
        return this.endHour;
    }

    public final int getEndMinute() {
        return this.endMinute;
    }

    public final int getSlotId() {
        return this.slotId;
    }

    public final int getStartHour() {
        return this.startHour;
    }

    public final int getStartMinute() {
        return this.startMinute;
    }

    public final String getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    public int hashCode() {
        boolean z10 = this.isOpen;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        return (((((((((((((r02 * 31) + Integer.hashCode(this.slotId)) * 31) + this.type.hashCode()) * 31) + Integer.hashCode(this.days)) * 31) + Integer.hashCode(this.startHour)) * 31) + Integer.hashCode(this.endHour)) * 31) + Integer.hashCode(this.startMinute)) * 31) + Integer.hashCode(this.endMinute);
    }

    public final boolean isOpen() {
        return this.isOpen;
    }

    public String toString() {
        return "ScheduleBlockSwitch(isOpen=" + this.isOpen + ", slotId=" + this.slotId + ", type=" + this.type + ", days=" + this.days + ", startHour=" + this.startHour + ", endHour=" + this.endHour + ", startMinute=" + this.startMinute + ", endMinute=" + this.endMinute + ")";
    }
}
