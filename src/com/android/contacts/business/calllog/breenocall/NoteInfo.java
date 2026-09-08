package com.android.contacts.business.calllog.breenocall;

import kotlin.jvm.internal.i;

/* compiled from: BreenoCallLogEntity.kt */
/* loaded from: classes.dex */
public final class NoteInfo {
    private String content;
    private long date;

    public NoteInfo(long j10, String str) {
        this.date = j10;
        this.content = str;
    }

    public static /* synthetic */ NoteInfo copy$default(NoteInfo noteInfo, long j10, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = noteInfo.date;
        }
        if ((i10 & 2) != 0) {
            str = noteInfo.content;
        }
        return noteInfo.copy(j10, str);
    }

    public final long component1() {
        return this.date;
    }

    public final String component2() {
        return this.content;
    }

    public final NoteInfo copy(long j10, String str) {
        return new NoteInfo(j10, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NoteInfo)) {
            return false;
        }
        NoteInfo noteInfo = (NoteInfo) obj;
        if (this.date == noteInfo.date && i.b(this.content, noteInfo.content)) {
            return true;
        }
        return false;
    }

    public final String getContent() {
        return this.content;
    }

    public final long getDate() {
        return this.date;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = Long.hashCode(this.date) * 31;
        String str = this.content;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return hashCode2 + hashCode;
    }

    public final void setContent(String str) {
        this.content = str;
    }

    public final void setDate(long j10) {
        this.date = j10;
    }

    public String toString() {
        return "NoteInfo(date=" + this.date + ", content=" + this.content + ")";
    }
}
