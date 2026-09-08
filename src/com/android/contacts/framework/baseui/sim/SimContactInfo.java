package com.android.contacts.framework.baseui.sim;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.HashSet;

/* loaded from: classes.dex */
public class SimContactInfo implements Parcelable {
    public static final Parcelable.Creator<SimContactInfo> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public long f15821a;

    /* renamed from: b, reason: collision with root package name */
    public long f15822b;

    /* renamed from: c, reason: collision with root package name */
    public long f15823c;

    /* renamed from: d, reason: collision with root package name */
    public String f15824d;

    /* renamed from: e, reason: collision with root package name */
    public String f15825e;

    /* renamed from: f, reason: collision with root package name */
    public String f15826f;

    /* renamed from: g, reason: collision with root package name */
    public String f15827g;

    /* renamed from: h, reason: collision with root package name */
    public String f15828h;

    /* loaded from: classes.dex */
    public class a implements Parcelable.Creator<SimContactInfo> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SimContactInfo createFromParcel(Parcel parcel) {
            String readString = parcel.readString();
            SimContactInfo simContactInfo = new SimContactInfo(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            simContactInfo.f(readString);
            return simContactInfo;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public SimContactInfo[] newArray(int i10) {
            return null;
        }
    }

    public SimContactInfo() {
    }

    public boolean b(SimContactInfo simContactInfo) {
        if (simContactInfo == null) {
            return true;
        }
        String str = this.f15824d;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        String str3 = simContactInfo.f15824d;
        if (str3 == null) {
            str3 = "";
        }
        if (!TextUtils.equals(str, str3)) {
            return false;
        }
        HashSet hashSet = new HashSet();
        if (!TextUtils.isEmpty(this.f15825e)) {
            hashSet.add(this.f15825e);
        }
        if (!TextUtils.isEmpty(this.f15827g)) {
            hashSet.add(this.f15827g);
        }
        if (!TextUtils.isEmpty(simContactInfo.f15825e) && !hashSet.contains(simContactInfo.f15825e)) {
            return false;
        }
        if (!TextUtils.isEmpty(simContactInfo.f15827g) && !hashSet.contains(simContactInfo.f15827g)) {
            return false;
        }
        String str4 = this.f15828h;
        if (str4 == null) {
            str4 = "";
        }
        String str5 = simContactInfo.f15828h;
        if (str5 != null) {
            str2 = str5;
        }
        if (TextUtils.isEmpty(str2) || TextUtils.equals(str4, str2)) {
            return true;
        }
        return false;
    }

    public String d() {
        return this.f15826f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void f(String str) {
        this.f15826f = str;
    }

    public String getName() {
        return this.f15824d;
    }

    public void h(String str) {
        this.f15824d = str;
    }

    public void i(String str) {
        this.f15825e = str;
    }

    public void j(long j10) {
        this.f15822b = j10;
    }

    public void k(long j10) {
        this.f15823c = j10;
    }

    public String toString() {
        if (H7.a.b()) {
            return "SimContactInfo{mId=" + this.f15821a + ", mName='****', mPhone='" + H7.a.d(this.f15825e) + "', mAddPhone='" + H7.a.d(this.f15827g) + "', mId2=" + this.f15822b + ", mStarred=" + this.f15823c + '}';
        }
        return "SimContactInfo{mId=" + this.f15821a + ", mId2=" + this.f15822b + ", mStarred=" + this.f15823c + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f15826f);
        parcel.writeLong(this.f15821a);
        parcel.writeString(this.f15824d);
        parcel.writeString(this.f15825e);
        parcel.writeString(this.f15827g);
        parcel.writeString(this.f15828h);
    }

    public SimContactInfo(long j10, String str, String str2, String str3, String str4) {
        this.f15821a = j10;
        this.f15824d = str;
        this.f15825e = str2;
        this.f15827g = str3;
        this.f15828h = str4;
        this.f15822b = -1L;
    }
}
