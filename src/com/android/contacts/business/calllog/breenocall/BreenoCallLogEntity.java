package com.android.contacts.business.calllog.breenocall;

import J4.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.d;
import java.util.List;
import kotlin.Result;
import kotlin.b;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import m9.q;

/* compiled from: BreenoCallLogEntity.kt */
/* loaded from: classes.dex */
public final class BreenoCallLogEntity implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR(null);
    private final d GSON;
    private final long _id;
    private final long date;
    private final String ext1;
    private final String ext2;
    private final String ext3;
    private final String ext4;
    private List<NameInfo> nameInfoList;
    private final String nameInfoListJson;
    private boolean nomarlized;
    private final String normalized_number;
    private List<NoteInfo> noteInfoList;
    private final String noteInfoListJson;
    private final String number;
    private final String personInfoJson;
    private PersonalInfo personalInfo;

    /* compiled from: BreenoCallLogEntity.kt */
    /* loaded from: classes.dex */
    public static final class CREATOR implements Parcelable.Creator<BreenoCallLogEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(f fVar) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BreenoCallLogEntity createFromParcel(Parcel parcel) {
            i.f(parcel, "parcel");
            return new BreenoCallLogEntity(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BreenoCallLogEntity[] newArray(int i10) {
            return new BreenoCallLogEntity[i10];
        }
    }

    public BreenoCallLogEntity(long j10, String number, String str, String str2, String str3, String str4, long j11, String str5, String str6, String str7, String str8) {
        i.f(number, "number");
        this._id = j10;
        this.number = number;
        this.normalized_number = str;
        this.nameInfoListJson = str2;
        this.personInfoJson = str3;
        this.noteInfoListJson = str4;
        this.date = j11;
        this.ext1 = str5;
        this.ext2 = str6;
        this.ext3 = str7;
        this.ext4 = str8;
        this.GSON = new d();
    }

    public final long component1() {
        return this._id;
    }

    public final String component10() {
        return this.ext3;
    }

    public final String component11() {
        return this.ext4;
    }

    public final String component2() {
        return this.number;
    }

    public final String component3() {
        return this.normalized_number;
    }

    public final String component4() {
        return this.nameInfoListJson;
    }

    public final String component5() {
        return this.personInfoJson;
    }

    public final String component6() {
        return this.noteInfoListJson;
    }

    public final long component7() {
        return this.date;
    }

    public final String component8() {
        return this.ext1;
    }

    public final String component9() {
        return this.ext2;
    }

    public final BreenoCallLogEntity copy(long j10, String number, String str, String str2, String str3, String str4, long j11, String str5, String str6, String str7, String str8) {
        i.f(number, "number");
        return new BreenoCallLogEntity(j10, number, str, str2, str3, str4, j11, str5, str6, str7, str8);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BreenoCallLogEntity)) {
            return false;
        }
        BreenoCallLogEntity breenoCallLogEntity = (BreenoCallLogEntity) obj;
        if (this._id == breenoCallLogEntity._id && i.b(this.number, breenoCallLogEntity.number) && i.b(this.normalized_number, breenoCallLogEntity.normalized_number) && i.b(this.nameInfoListJson, breenoCallLogEntity.nameInfoListJson) && i.b(this.personInfoJson, breenoCallLogEntity.personInfoJson) && i.b(this.noteInfoListJson, breenoCallLogEntity.noteInfoListJson) && this.date == breenoCallLogEntity.date && i.b(this.ext1, breenoCallLogEntity.ext1) && i.b(this.ext2, breenoCallLogEntity.ext2) && i.b(this.ext3, breenoCallLogEntity.ext3) && i.b(this.ext4, breenoCallLogEntity.ext4)) {
            return true;
        }
        return false;
    }

    public final long getDate() {
        return this.date;
    }

    public final String getExt1() {
        return this.ext1;
    }

    public final String getExt2() {
        return this.ext2;
    }

    public final String getExt3() {
        return this.ext3;
    }

    public final String getExt4() {
        return this.ext4;
    }

    public final long getId() {
        return this._id;
    }

    public final List<NameInfo> getNameInfoList() {
        return this.nameInfoList;
    }

    public final String getNameInfoListJson() {
        return this.nameInfoListJson;
    }

    public final String getNormalized_number() {
        return this.normalized_number;
    }

    public final List<NoteInfo> getNoteInfoList() {
        return this.noteInfoList;
    }

    public final String getNoteInfoListJson() {
        return this.noteInfoListJson;
    }

    public final String getNumber() {
        return this.number;
    }

    public final String getPersonInfoJson() {
        return this.personInfoJson;
    }

    public final PersonalInfo getPersonalInfo() {
        return this.personalInfo;
    }

    public final long get_id() {
        return this._id;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        int hashCode7;
        int hashCode8 = ((Long.hashCode(this._id) * 31) + this.number.hashCode()) * 31;
        String str = this.normalized_number;
        int i10 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i11 = (hashCode8 + hashCode) * 31;
        String str2 = this.nameInfoListJson;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        String str3 = this.personInfoJson;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        String str4 = this.noteInfoListJson;
        if (str4 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str4.hashCode();
        }
        int hashCode9 = (((i13 + hashCode4) * 31) + Long.hashCode(this.date)) * 31;
        String str5 = this.ext1;
        if (str5 == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = str5.hashCode();
        }
        int i14 = (hashCode9 + hashCode5) * 31;
        String str6 = this.ext2;
        if (str6 == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = str6.hashCode();
        }
        int i15 = (i14 + hashCode6) * 31;
        String str7 = this.ext3;
        if (str7 == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = str7.hashCode();
        }
        int i16 = (i15 + hashCode7) * 31;
        String str8 = this.ext4;
        if (str8 != null) {
            i10 = str8.hashCode();
        }
        return i16 + i10;
    }

    public final void nomarlize() {
        Object b10;
        Object b11;
        Object b12;
        if (!this.nomarlized) {
            String str = this.nameInfoListJson;
            if (str != null) {
                try {
                    Result.a aVar = Result.f34166a;
                    this.nameInfoList = (List) this.GSON.k(str, new a<List<? extends NameInfo>>() { // from class: com.android.contacts.business.calllog.breenocall.BreenoCallLogEntity$nomarlize$1$1$type$1
                    }.getType());
                    b10 = Result.b(q.f35511a);
                } catch (Throwable th) {
                    Result.a aVar2 = Result.f34166a;
                    b10 = Result.b(b.a(th));
                }
                Result.a(b10);
            }
            String str2 = this.personInfoJson;
            if (str2 != null) {
                try {
                    Result.a aVar3 = Result.f34166a;
                    this.personalInfo = (PersonalInfo) this.GSON.j(str2, PersonalInfo.class);
                    b11 = Result.b(q.f35511a);
                } catch (Throwable th2) {
                    Result.a aVar4 = Result.f34166a;
                    b11 = Result.b(b.a(th2));
                }
                Result.a(b11);
            }
            String str3 = this.noteInfoListJson;
            if (str3 != null) {
                try {
                    Result.a aVar5 = Result.f34166a;
                    this.noteInfoList = (List) this.GSON.k(str3, new a<List<? extends NoteInfo>>() { // from class: com.android.contacts.business.calllog.breenocall.BreenoCallLogEntity$nomarlize$3$1$type$1
                    }.getType());
                    b12 = Result.b(q.f35511a);
                } catch (Throwable th3) {
                    Result.a aVar6 = Result.f34166a;
                    b12 = Result.b(b.a(th3));
                }
                Result.a(b12);
            }
            this.nomarlized = true;
        }
    }

    public String toString() {
        return "BreenoCallLogEntity(_id=" + this._id + ", number=" + this.number + ", normalized_number=" + this.normalized_number + ", nameInfoListJson=" + this.nameInfoListJson + ", personInfoJson=" + this.personInfoJson + ", noteInfoListJson=" + this.noteInfoListJson + ", date=" + this.date + ", ext1=" + this.ext1 + ", ext2=" + this.ext2 + ", ext3=" + this.ext3 + ", ext4=" + this.ext4 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        i.f(parcel, "parcel");
        parcel.writeLong(this._id);
        parcel.writeString(this.number);
        parcel.writeString(this.normalized_number);
        parcel.writeString(this.nameInfoListJson);
        parcel.writeString(this.personInfoJson);
        parcel.writeString(this.noteInfoListJson);
        parcel.writeLong(this.date);
        parcel.writeString(this.ext1);
        parcel.writeString(this.ext2);
        parcel.writeString(this.ext3);
        parcel.writeString(this.ext4);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public BreenoCallLogEntity(android.os.Parcel r16) {
        /*
            r15 = this;
            java.lang.String r0 = "parcel"
            r1 = r16
            kotlin.jvm.internal.i.f(r1, r0)
            long r2 = r16.readLong()
            java.lang.String r4 = r16.readString()
            kotlin.jvm.internal.i.c(r4)
            java.lang.String r5 = r16.readString()
            java.lang.String r6 = r16.readString()
            java.lang.String r7 = r16.readString()
            java.lang.String r8 = r16.readString()
            long r9 = r16.readLong()
            java.lang.String r11 = r16.readString()
            java.lang.String r12 = r16.readString()
            java.lang.String r13 = r16.readString()
            java.lang.String r14 = r16.readString()
            r1 = r15
            r1.<init>(r2, r4, r5, r6, r7, r8, r9, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.business.calllog.breenocall.BreenoCallLogEntity.<init>(android.os.Parcel):void");
    }
}
