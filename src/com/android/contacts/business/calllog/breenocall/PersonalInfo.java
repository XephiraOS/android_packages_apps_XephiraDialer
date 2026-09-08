package com.android.contacts.business.calllog.breenocall;

import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: BreenoCallLogEntity.kt */
/* loaded from: classes.dex */
public final class PersonalInfo {
    private List<OrgInfo> orgs;
    private List<TitleInfo> titles;

    /* JADX WARN: Multi-variable type inference failed */
    public PersonalInfo() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PersonalInfo copy$default(PersonalInfo personalInfo, List list, List list2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = personalInfo.orgs;
        }
        if ((i10 & 2) != 0) {
            list2 = personalInfo.titles;
        }
        return personalInfo.copy(list, list2);
    }

    public final List<OrgInfo> component1() {
        return this.orgs;
    }

    public final List<TitleInfo> component2() {
        return this.titles;
    }

    public final PersonalInfo copy(List<OrgInfo> list, List<TitleInfo> list2) {
        return new PersonalInfo(list, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PersonalInfo)) {
            return false;
        }
        PersonalInfo personalInfo = (PersonalInfo) obj;
        if (i.b(this.orgs, personalInfo.orgs) && i.b(this.titles, personalInfo.titles)) {
            return true;
        }
        return false;
    }

    public final List<OrgInfo> getOrgs() {
        return this.orgs;
    }

    public final List<TitleInfo> getTitles() {
        return this.titles;
    }

    public int hashCode() {
        int hashCode;
        List<OrgInfo> list = this.orgs;
        int i10 = 0;
        if (list == null) {
            hashCode = 0;
        } else {
            hashCode = list.hashCode();
        }
        int i11 = hashCode * 31;
        List<TitleInfo> list2 = this.titles;
        if (list2 != null) {
            i10 = list2.hashCode();
        }
        return i11 + i10;
    }

    public final void setOrgs(List<OrgInfo> list) {
        this.orgs = list;
    }

    public final void setTitles(List<TitleInfo> list) {
        this.titles = list;
    }

    public String toString() {
        return "PersonalInfo(orgs=" + this.orgs + ", titles=" + this.titles + ")";
    }

    public PersonalInfo(List<OrgInfo> list, List<TitleInfo> list2) {
        this.orgs = list;
        this.titles = list2;
    }

    public /* synthetic */ PersonalInfo(List list, List list2, int i10, f fVar) {
        this((i10 & 1) != 0 ? null : list, (i10 & 2) != 0 ? null : list2);
    }
}
