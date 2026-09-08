package com.ted.number.entrys;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
public class RequestData implements Parcelable {
    public static final Parcelable.Creator<RequestData> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public String f29658a;

    /* renamed from: b, reason: collision with root package name */
    public int f29659b;

    /* renamed from: c, reason: collision with root package name */
    public int f29660c;

    /* renamed from: d, reason: collision with root package name */
    public int f29661d;

    /* renamed from: e, reason: collision with root package name */
    public String f29662e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f29663f;

    /* renamed from: g, reason: collision with root package name */
    public long f29664g;

    /* renamed from: h, reason: collision with root package name */
    public int f29665h;

    /* renamed from: i, reason: collision with root package name */
    public long f29666i;

    /* renamed from: j, reason: collision with root package name */
    public int f29667j;

    /* renamed from: k, reason: collision with root package name */
    public String f29668k;

    /* renamed from: l, reason: collision with root package name */
    public long f29669l;

    /* renamed from: m, reason: collision with root package name */
    public int f29670m;

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
        public String f29671a;

        /* renamed from: b, reason: collision with root package name */
        public int f29672b;

        /* renamed from: c, reason: collision with root package name */
        public int f29673c;

        /* renamed from: d, reason: collision with root package name */
        public int f29674d;

        /* renamed from: e, reason: collision with root package name */
        public String f29675e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f29676f;

        /* renamed from: g, reason: collision with root package name */
        public long f29677g;

        /* renamed from: h, reason: collision with root package name */
        public int f29678h;

        /* renamed from: i, reason: collision with root package name */
        public long f29679i;

        /* renamed from: j, reason: collision with root package name */
        public int f29680j;

        /* renamed from: k, reason: collision with root package name */
        public String f29681k;

        /* renamed from: l, reason: collision with root package name */
        public long f29682l;

        /* renamed from: m, reason: collision with root package name */
        public int f29683m;

        public RequestData n() {
            return new RequestData(this);
        }

        public b o(int i10) {
            this.f29672b = i10;
            return this;
        }

        public b p(boolean z10) {
            this.f29676f = z10;
            return this;
        }

        public b q(String str) {
            this.f29671a = str;
            return this;
        }

        public b r(int i10) {
            this.f29673c = i10;
            return this;
        }

        public b s(long j10) {
            this.f29679i = j10;
            return this;
        }

        public b t(int i10) {
            this.f29680j = i10;
            return this;
        }

        public b u(long j10) {
            this.f29677g = j10;
            return this;
        }
    }

    public RequestData(b bVar) {
        this.f29658a = bVar.f29671a;
        this.f29659b = bVar.f29672b;
        this.f29660c = bVar.f29673c;
        this.f29661d = bVar.f29674d;
        this.f29662e = bVar.f29675e;
        this.f29663f = bVar.f29676f;
        this.f29664g = bVar.f29677g;
        this.f29665h = bVar.f29678h;
        this.f29666i = bVar.f29679i;
        this.f29667j = bVar.f29680j;
        this.f29668k = bVar.f29681k;
        this.f29669l = bVar.f29682l;
        this.f29670m = bVar.f29683m;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f29658a);
        parcel.writeInt(this.f29659b);
        parcel.writeInt(this.f29660c);
        parcel.writeInt(this.f29661d);
        parcel.writeString(this.f29662e);
        parcel.writeByte(this.f29663f ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f29664g);
        parcel.writeInt(this.f29665h);
        parcel.writeLong(this.f29666i);
        parcel.writeInt(this.f29667j);
        parcel.writeString(this.f29668k);
        parcel.writeLong(this.f29669l);
        parcel.writeInt(this.f29670m);
    }

    public RequestData(Parcel parcel) {
        this.f29658a = parcel.readString();
        this.f29659b = parcel.readInt();
        this.f29660c = parcel.readInt();
        this.f29661d = parcel.readInt();
        this.f29662e = parcel.readString();
        this.f29663f = parcel.readByte() != 0;
        this.f29664g = parcel.readLong();
        this.f29665h = parcel.readInt();
        this.f29666i = parcel.readLong();
        this.f29667j = parcel.readInt();
        this.f29668k = parcel.readString();
        this.f29669l = parcel.readLong();
        this.f29670m = parcel.readInt();
    }
}
