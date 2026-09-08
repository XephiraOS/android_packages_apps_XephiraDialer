package com.ted.phonenumber.entrys;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
public class RequestData implements Parcelable {
    public static final Parcelable.Creator<RequestData> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public String f29888a;

    /* renamed from: b, reason: collision with root package name */
    public int f29889b;

    /* renamed from: c, reason: collision with root package name */
    public int f29890c;

    /* renamed from: d, reason: collision with root package name */
    public int f29891d;

    /* renamed from: e, reason: collision with root package name */
    public String f29892e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f29893f;

    /* renamed from: g, reason: collision with root package name */
    public long f29894g;

    /* renamed from: h, reason: collision with root package name */
    public int f29895h;

    /* renamed from: i, reason: collision with root package name */
    public long f29896i;

    /* renamed from: j, reason: collision with root package name */
    public int f29897j;

    /* renamed from: k, reason: collision with root package name */
    public String f29898k;

    /* renamed from: l, reason: collision with root package name */
    public long f29899l;

    /* renamed from: m, reason: collision with root package name */
    public int f29900m;

    /* loaded from: classes4.dex */
    public class a implements Parcelable.Creator<RequestData> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RequestData createFromParcel(Parcel parcel) {
            return new RequestData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public RequestData[] newArray(int i10) {
            return new RequestData[i10];
        }
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f29901a;

        /* renamed from: b, reason: collision with root package name */
        public int f29902b;

        /* renamed from: c, reason: collision with root package name */
        public int f29903c;

        /* renamed from: d, reason: collision with root package name */
        public int f29904d;

        /* renamed from: e, reason: collision with root package name */
        public String f29905e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f29906f;

        /* renamed from: g, reason: collision with root package name */
        public long f29907g;

        /* renamed from: h, reason: collision with root package name */
        public int f29908h;

        /* renamed from: i, reason: collision with root package name */
        public long f29909i;

        /* renamed from: j, reason: collision with root package name */
        public int f29910j;

        /* renamed from: k, reason: collision with root package name */
        public String f29911k;

        /* renamed from: l, reason: collision with root package name */
        public long f29912l;

        /* renamed from: m, reason: collision with root package name */
        public int f29913m;

        public RequestData n() {
            return new RequestData(this);
        }

        public b o(int i10) {
            this.f29902b = i10;
            return this;
        }

        public b p(String str) {
            this.f29905e = str;
            return this;
        }

        public b q(boolean z10) {
            this.f29906f = z10;
            return this;
        }

        public b r(String str) {
            this.f29901a = str;
            return this;
        }

        public b s(int i10) {
            this.f29903c = i10;
            return this;
        }

        public b t(long j10) {
            this.f29907g = j10;
            return this;
        }
    }

    public RequestData(b bVar) {
        this.f29888a = bVar.f29901a;
        this.f29889b = bVar.f29902b;
        this.f29890c = bVar.f29903c;
        this.f29891d = bVar.f29904d;
        this.f29892e = bVar.f29905e;
        this.f29893f = bVar.f29906f;
        this.f29894g = bVar.f29907g;
        this.f29895h = bVar.f29908h;
        this.f29896i = bVar.f29909i;
        this.f29897j = bVar.f29910j;
        this.f29898k = bVar.f29911k;
        this.f29899l = bVar.f29912l;
        this.f29900m = bVar.f29913m;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f29888a);
        parcel.writeInt(this.f29889b);
        parcel.writeInt(this.f29890c);
        parcel.writeInt(this.f29891d);
        parcel.writeString(this.f29892e);
        parcel.writeByte(this.f29893f ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f29894g);
        parcel.writeInt(this.f29895h);
        parcel.writeLong(this.f29896i);
        parcel.writeInt(this.f29897j);
        parcel.writeString(this.f29898k);
        parcel.writeLong(this.f29899l);
        parcel.writeInt(this.f29900m);
    }

    public RequestData(Parcel parcel) {
        this.f29888a = parcel.readString();
        this.f29889b = parcel.readInt();
        this.f29890c = parcel.readInt();
        this.f29891d = parcel.readInt();
        this.f29892e = parcel.readString();
        this.f29893f = parcel.readByte() != 0;
        this.f29894g = parcel.readLong();
        this.f29895h = parcel.readInt();
        this.f29896i = parcel.readLong();
        this.f29897j = parcel.readInt();
        this.f29898k = parcel.readString();
        this.f29899l = parcel.readLong();
        this.f29900m = parcel.readInt();
    }
}
