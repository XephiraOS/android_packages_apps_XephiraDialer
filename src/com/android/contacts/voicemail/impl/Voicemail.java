package com.android.contacts.voicemail.impl;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.telecom.PhoneAccountHandle;
import android.text.TextUtils;

/* loaded from: classes.dex */
public class Voicemail implements Parcelable {
    public static final Parcelable.Creator<Voicemail> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final Long f18004a;

    /* renamed from: b, reason: collision with root package name */
    public final String f18005b;

    /* renamed from: c, reason: collision with root package name */
    public final PhoneAccountHandle f18006c;

    /* renamed from: d, reason: collision with root package name */
    public final Long f18007d;

    /* renamed from: e, reason: collision with root package name */
    public final Long f18008e;

    /* renamed from: f, reason: collision with root package name */
    public final String f18009f;

    /* renamed from: g, reason: collision with root package name */
    public final String f18010g;

    /* renamed from: h, reason: collision with root package name */
    public final Uri f18011h;

    /* renamed from: i, reason: collision with root package name */
    public final Boolean f18012i;

    /* renamed from: j, reason: collision with root package name */
    public final Boolean f18013j;

    /* renamed from: k, reason: collision with root package name */
    public final String f18014k;

    /* loaded from: classes.dex */
    public class a implements Parcelable.Creator<Voicemail> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Voicemail createFromParcel(Parcel parcel) {
            return new Voicemail(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Voicemail[] newArray(int i10) {
            return new Voicemail[i10];
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public Long f18015a;

        /* renamed from: b, reason: collision with root package name */
        public String f18016b;

        /* renamed from: c, reason: collision with root package name */
        public PhoneAccountHandle f18017c;

        /* renamed from: d, reason: collision with root package name */
        public Long f18018d;

        /* renamed from: e, reason: collision with root package name */
        public Long f18019e;

        /* renamed from: f, reason: collision with root package name */
        public String f18020f;

        /* renamed from: g, reason: collision with root package name */
        public String f18021g;

        /* renamed from: h, reason: collision with root package name */
        public Uri f18022h;

        /* renamed from: i, reason: collision with root package name */
        public Boolean f18023i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f18024j;

        /* renamed from: k, reason: collision with root package name */
        public String f18025k;

        public b() {
        }

        public Voicemail a() {
            long longValue;
            long longValue2;
            boolean booleanValue;
            Long l10 = this.f18018d;
            if (l10 == null) {
                longValue = -1;
            } else {
                longValue = l10.longValue();
            }
            this.f18018d = Long.valueOf(longValue);
            Long l11 = this.f18015a;
            long j10 = 0;
            if (l11 == null) {
                longValue2 = 0;
            } else {
                longValue2 = l11.longValue();
            }
            this.f18015a = Long.valueOf(longValue2);
            Long l12 = this.f18019e;
            if (l12 != null) {
                j10 = l12.longValue();
            }
            this.f18019e = Long.valueOf(j10);
            Boolean bool = this.f18023i;
            if (bool == null) {
                booleanValue = false;
            } else {
                booleanValue = bool.booleanValue();
            }
            this.f18023i = Boolean.valueOf(booleanValue);
            return new Voicemail(this.f18015a, this.f18016b, this.f18017c, this.f18018d, this.f18019e, this.f18020f, this.f18021g, this.f18022h, this.f18023i, Boolean.valueOf(this.f18024j), this.f18025k);
        }

        public b b(long j10) {
            this.f18019e = Long.valueOf(j10);
            return this;
        }

        public b c(long j10) {
            this.f18018d = Long.valueOf(j10);
            return this;
        }

        public b d(boolean z10) {
            this.f18023i = Boolean.valueOf(z10);
            return this;
        }

        public b e(String str) {
            this.f18016b = str;
            return this;
        }

        public b f(PhoneAccountHandle phoneAccountHandle) {
            this.f18017c = phoneAccountHandle;
            return this;
        }

        public b g(String str) {
            this.f18021g = str;
            return this;
        }

        public b h(String str) {
            this.f18020f = str;
            return this;
        }

        public b i(long j10) {
            this.f18015a = Long.valueOf(j10);
            return this;
        }

        public b j(String str) {
            this.f18025k = str;
            return this;
        }

        public b k(Uri uri) {
            this.f18022h = uri;
            return this;
        }
    }

    public static b b(long j10, String str) {
        return new b().e(str).i(j10);
    }

    public static b d(long j10, String str) {
        return new b().c(j10).g(str);
    }

    public static CharSequence v(Parcel parcel) {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
    }

    public static void w(Parcel parcel, CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, parcel, 0);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long f() {
        return this.f18008e.longValue();
    }

    public long h() {
        return this.f18007d.longValue();
    }

    public String i() {
        return this.f18005b;
    }

    public PhoneAccountHandle j() {
        return this.f18006c;
    }

    public String k() {
        return this.f18010g;
    }

    public String m() {
        return this.f18009f;
    }

    public long n() {
        return this.f18004a.longValue();
    }

    public String p() {
        return this.f18014k;
    }

    public Uri q() {
        return this.f18011h;
    }

    public boolean t() {
        return this.f18012i.booleanValue();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.f18004a.longValue());
        w(parcel, this.f18005b);
        if (this.f18006c == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            this.f18006c.writeToParcel(parcel, i10);
        }
        parcel.writeLong(this.f18007d.longValue());
        parcel.writeLong(this.f18008e.longValue());
        w(parcel, this.f18009f);
        w(parcel, this.f18010g);
        if (this.f18011h == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            this.f18011h.writeToParcel(parcel, i10);
        }
        if (this.f18012i.booleanValue()) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
        }
        if (this.f18013j.booleanValue()) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
        }
        w(parcel, this.f18014k);
    }

    public Voicemail(Long l10, String str, PhoneAccountHandle phoneAccountHandle, Long l11, Long l12, String str2, String str3, Uri uri, Boolean bool, Boolean bool2, String str4) {
        this.f18004a = l10;
        this.f18005b = str;
        this.f18006c = phoneAccountHandle;
        this.f18007d = l11;
        this.f18008e = l12;
        this.f18009f = str2;
        this.f18010g = str3;
        this.f18011h = uri;
        this.f18012i = bool;
        this.f18013j = bool2;
        this.f18014k = str4;
    }

    public Voicemail(Parcel parcel) {
        this.f18004a = Long.valueOf(parcel.readLong());
        this.f18005b = (String) v(parcel);
        if (parcel.readInt() > 0) {
            this.f18006c = (PhoneAccountHandle) PhoneAccountHandle.CREATOR.createFromParcel(parcel);
        } else {
            this.f18006c = null;
        }
        this.f18007d = Long.valueOf(parcel.readLong());
        this.f18008e = Long.valueOf(parcel.readLong());
        this.f18009f = (String) v(parcel);
        this.f18010g = (String) v(parcel);
        if (parcel.readInt() > 0) {
            this.f18011h = (Uri) Uri.CREATOR.createFromParcel(parcel);
        } else {
            this.f18011h = null;
        }
        this.f18012i = Boolean.valueOf(parcel.readInt() > 0);
        this.f18013j = Boolean.valueOf(parcel.readInt() > 0);
        this.f18014k = (String) v(parcel);
    }
}
