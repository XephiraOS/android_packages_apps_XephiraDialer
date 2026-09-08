package com.android.contacts.business.calllog.breenocall;

import kotlin.jvm.internal.i;

/* compiled from: BreenoCallLogEntity.kt */
/* loaded from: classes.dex */
public final class NameInfo {
    private final String name;

    public NameInfo(String name) {
        i.f(name, "name");
        this.name = name;
    }

    public static /* synthetic */ NameInfo copy$default(NameInfo nameInfo, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = nameInfo.name;
        }
        return nameInfo.copy(str);
    }

    public final String component1() {
        return this.name;
    }

    public final NameInfo copy(String name) {
        i.f(name, "name");
        return new NameInfo(name);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof NameInfo) && i.b(this.name, ((NameInfo) obj).name)) {
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
        return "NameInfo(name=" + this.name + ")";
    }
}
