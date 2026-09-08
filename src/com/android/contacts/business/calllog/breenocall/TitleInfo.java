package com.android.contacts.business.calllog.breenocall;

import E4.c;
import kotlin.jvm.internal.i;

/* compiled from: BreenoCallLogEntity.kt */
/* loaded from: classes.dex */
public final class TitleInfo {

    @c("title")
    private final String name;

    public TitleInfo(String name) {
        i.f(name, "name");
        this.name = name;
    }

    public static /* synthetic */ TitleInfo copy$default(TitleInfo titleInfo, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = titleInfo.name;
        }
        return titleInfo.copy(str);
    }

    public final String component1() {
        return this.name;
    }

    public final TitleInfo copy(String name) {
        i.f(name, "name");
        return new TitleInfo(name);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof TitleInfo) && i.b(this.name, ((TitleInfo) obj).name)) {
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
        return "TitleInfo(name=" + this.name + ")";
    }
}
