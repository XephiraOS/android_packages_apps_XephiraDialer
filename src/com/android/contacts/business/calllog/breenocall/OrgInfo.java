package com.android.contacts.business.calllog.breenocall;

import E4.c;
import kotlin.jvm.internal.i;

/* compiled from: BreenoCallLogEntity.kt */
/* loaded from: classes.dex */
public final class OrgInfo {

    @c("org")
    private final String name;

    public OrgInfo(String name) {
        i.f(name, "name");
        this.name = name;
    }

    public static /* synthetic */ OrgInfo copy$default(OrgInfo orgInfo, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = orgInfo.name;
        }
        return orgInfo.copy(str);
    }

    public final String component1() {
        return this.name;
    }

    public final OrgInfo copy(String name) {
        i.f(name, "name");
        return new OrgInfo(name);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof OrgInfo) && i.b(this.name, ((OrgInfo) obj).name)) {
            return true;
        }
        return false;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public String toString() {
        return "OrgInfo(name=" + this.name + ")";
    }
}
