package com.android.contacts.assisteddialing;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class TransformationInfo implements Parcelable {
    public static final Parcelable.Creator<TransformationInfo> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public String f13671a;

    /* renamed from: b, reason: collision with root package name */
    public String f13672b;

    /* renamed from: c, reason: collision with root package name */
    public String f13673c;

    /* renamed from: d, reason: collision with root package name */
    public String f13674d;

    /* renamed from: e, reason: collision with root package name */
    public int f13675e;

    /* loaded from: classes.dex */
    public class a implements Parcelable.Creator<TransformationInfo> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TransformationInfo createFromParcel(Parcel parcel) {
            return new TransformationInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public TransformationInfo[] newArray(int i10) {
            return new TransformationInfo[i10];
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f13676a;

        /* renamed from: b, reason: collision with root package name */
        public String f13677b;

        /* renamed from: c, reason: collision with root package name */
        public String f13678c;

        /* renamed from: d, reason: collision with root package name */
        public String f13679d;

        /* renamed from: e, reason: collision with root package name */
        public int f13680e;

        public TransformationInfo f() {
            return new TransformationInfo(this);
        }

        public b g(String str) {
            this.f13676a = str;
            return this;
        }

        public b h(String str) {
            this.f13677b = str;
            return this;
        }

        public b i(int i10) {
            this.f13680e = i10;
            return this;
        }

        public b j(String str) {
            this.f13678c = str;
            return this;
        }

        public b k(String str) {
            this.f13679d = str;
            return this;
        }
    }

    public TransformationInfo(Parcel parcel) {
        this.f13671a = parcel.readString();
        this.f13672b = parcel.readString();
        this.f13673c = parcel.readString();
        this.f13674d = parcel.readString();
        this.f13675e = parcel.readInt();
    }

    public String b() {
        return this.f13672b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f13671a);
        parcel.writeString(this.f13672b);
        parcel.writeString(this.f13673c);
        parcel.writeString(this.f13674d);
        parcel.writeInt(this.f13675e);
    }

    public TransformationInfo(b bVar) {
        this.f13671a = bVar.f13676a;
        this.f13672b = bVar.f13677b;
        this.f13673c = bVar.f13678c;
        this.f13674d = bVar.f13679d;
        this.f13675e = bVar.f13680e;
    }
}
