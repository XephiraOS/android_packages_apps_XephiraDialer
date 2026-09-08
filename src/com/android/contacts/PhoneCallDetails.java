package com.android.contacts;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* loaded from: classes.dex */
public class PhoneCallDetails implements Parcelable {
    public static final Parcelable.Creator<PhoneCallDetails> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final CharSequence f13167a;

    /* renamed from: b, reason: collision with root package name */
    public final CharSequence f13168b;

    /* renamed from: c, reason: collision with root package name */
    public final int f13169c;

    /* renamed from: d, reason: collision with root package name */
    public final long f13170d;

    /* renamed from: e, reason: collision with root package name */
    public final long f13171e;

    /* renamed from: f, reason: collision with root package name */
    public final CharSequence f13172f;

    /* renamed from: g, reason: collision with root package name */
    public final Uri f13173g;

    /* renamed from: h, reason: collision with root package name */
    public final int f13174h;

    /* renamed from: i, reason: collision with root package name */
    public final long f13175i;

    /* renamed from: j, reason: collision with root package name */
    public int f13176j;

    /* renamed from: k, reason: collision with root package name */
    public int f13177k;

    /* renamed from: l, reason: collision with root package name */
    public int f13178l;

    /* renamed from: m, reason: collision with root package name */
    public String f13179m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f13180n;

    /* renamed from: o, reason: collision with root package name */
    public int f13181o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f13182p;

    /* renamed from: q, reason: collision with root package name */
    public String f13183q;

    /* renamed from: r, reason: collision with root package name */
    public String f13184r;

    /* loaded from: classes.dex */
    public class a implements Parcelable.Creator<PhoneCallDetails> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PhoneCallDetails createFromParcel(Parcel parcel) {
            return new PhoneCallDetails(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public PhoneCallDetails[] newArray(int i10) {
            return new PhoneCallDetails[i10];
        }
    }

    public int b() {
        return this.f13176j;
    }

    public void d(int i10) {
        this.f13176j = i10;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass() && this.f13175i == ((PhoneCallDetails) obj).f13175i) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.f13175i));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.f13175i);
        parcel.writeLong(this.f13170d);
    }

    public PhoneCallDetails(CharSequence charSequence, CharSequence charSequence2, int i10, long j10, long j11, CharSequence charSequence3, Uri uri, int i11, long j12, int i12, int i13, int i14, String str, boolean z10) {
        this.f13183q = "";
        this.f13184r = "";
        this.f13167a = charSequence;
        this.f13168b = charSequence2;
        this.f13169c = i10;
        this.f13170d = j10;
        this.f13171e = j11;
        this.f13172f = charSequence3;
        this.f13173g = uri;
        this.f13174h = i11;
        this.f13175i = j12;
        this.f13178l = i12;
        this.f13176j = i13;
        this.f13177k = i14;
        this.f13179m = str;
        this.f13182p = z10;
    }

    public PhoneCallDetails(Parcel parcel) {
        this.f13177k = -1;
        this.f13178l = -1;
        this.f13183q = "";
        this.f13184r = "";
        this.f13175i = parcel.readLong();
        this.f13170d = parcel.readLong();
        this.f13167a = "";
        this.f13168b = "";
        this.f13169c = 0;
        this.f13171e = 0L;
        this.f13172f = "";
        this.f13173g = null;
        this.f13174h = 0;
        this.f13176j = 0;
        this.f13182p = false;
    }
}
