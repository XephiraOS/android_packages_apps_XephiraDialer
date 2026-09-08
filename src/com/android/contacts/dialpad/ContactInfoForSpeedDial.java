package com.android.contacts.dialpad;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;

/* compiled from: ContactInfoForSpeedDial.kt */
/* loaded from: classes.dex */
public final class ContactInfoForSpeedDial implements Parcelable {

    /* renamed from: a, reason: collision with root package name */
    public final String f14856a;

    /* renamed from: b, reason: collision with root package name */
    public final String f14857b;

    /* renamed from: c, reason: collision with root package name */
    public final String f14858c;

    /* renamed from: d, reason: collision with root package name */
    public final long f14859d;

    /* renamed from: e, reason: collision with root package name */
    public final Uri f14860e;

    /* renamed from: f, reason: collision with root package name */
    public final String f14861f;

    /* renamed from: g, reason: collision with root package name */
    public final long f14862g;

    /* renamed from: h, reason: collision with root package name */
    public static final b f14855h = new b(null);
    public static final Parcelable.Creator<ContactInfoForSpeedDial> CREATOR = new a();

    /* compiled from: ContactInfoForSpeedDial.kt */
    /* loaded from: classes.dex */
    public static final class a implements Parcelable.Creator<ContactInfoForSpeedDial> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ContactInfoForSpeedDial createFromParcel(Parcel source) {
            kotlin.jvm.internal.i.f(source, "source");
            return new ContactInfoForSpeedDial(source);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ContactInfoForSpeedDial[] newArray(int i10) {
            return new ContactInfoForSpeedDial[i10];
        }
    }

    /* compiled from: ContactInfoForSpeedDial.kt */
    /* loaded from: classes.dex */
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: ContactInfoForSpeedDial.kt */
    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: b, reason: collision with root package name */
        public static final int f14864b = 0;

        /* renamed from: a, reason: collision with root package name */
        public static final c f14863a = new c();

        /* renamed from: c, reason: collision with root package name */
        public static final int f14865c = 1;

        /* renamed from: d, reason: collision with root package name */
        public static final int f14866d = 2;

        /* renamed from: e, reason: collision with root package name */
        public static final int f14867e = 3;

        /* renamed from: f, reason: collision with root package name */
        public static final int f14868f = 4;

        /* renamed from: g, reason: collision with root package name */
        public static final int f14869g = 5;

        /* renamed from: h, reason: collision with root package name */
        public static final int f14870h = 6;

        /* renamed from: i, reason: collision with root package name */
        public static final String[] f14871i = {"display_name", "data1", "photo_id", "photo_uri", "lookup", BreenoCallContract.BaseColumns._ID, "contact_id"};

        public final int a() {
            return f14870h;
        }

        public final int b() {
            return f14865c;
        }

        public final int c() {
            return f14869g;
        }

        public final int d() {
            return f14864b;
        }

        public final int e() {
            return f14868f;
        }

        public final int f() {
            return f14866d;
        }

        public final int g() {
            return f14867e;
        }

        public final String[] h() {
            return f14871i;
        }
    }

    public ContactInfoForSpeedDial() {
        this(null, null, null, 0L, null, null, 0L, 127, null);
    }

    public final long b() {
        return this.f14862g;
    }

    public final String d() {
        return this.f14856a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String f() {
        return this.f14857b;
    }

    public final String h() {
        return this.f14858c;
    }

    public final long i() {
        return this.f14859d;
    }

    public final Uri j() {
        return this.f14860e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i10) {
        kotlin.jvm.internal.i.f(dest, "dest");
        dest.writeString(this.f14856a);
        dest.writeString(this.f14857b);
        dest.writeString(this.f14858c);
        dest.writeLong(this.f14859d);
        dest.writeString(String.valueOf(this.f14860e));
        dest.writeString(this.f14861f);
        dest.writeLong(this.f14862g);
    }

    public ContactInfoForSpeedDial(String mDataId, String mDisplayName, String mNumber, long j10, Uri uri, String mLookup, long j11) {
        kotlin.jvm.internal.i.f(mDataId, "mDataId");
        kotlin.jvm.internal.i.f(mDisplayName, "mDisplayName");
        kotlin.jvm.internal.i.f(mNumber, "mNumber");
        kotlin.jvm.internal.i.f(mLookup, "mLookup");
        this.f14856a = mDataId;
        this.f14857b = mDisplayName;
        this.f14858c = mNumber;
        this.f14859d = j10;
        this.f14860e = uri;
        this.f14861f = mLookup;
        this.f14862g = j11;
    }

    public /* synthetic */ ContactInfoForSpeedDial(String str, String str2, String str3, long j10, Uri uri, String str4, long j11, int i10, kotlin.jvm.internal.f fVar) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? "" : str2, (i10 & 4) != 0 ? "" : str3, (i10 & 8) != 0 ? -1L : j10, (i10 & 16) != 0 ? null : uri, (i10 & 32) != 0 ? "" : str4, (i10 & 64) != 0 ? -1L : j11);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ContactInfoForSpeedDial(android.os.Parcel r13) {
        /*
            r12 = this;
            java.lang.String r0 = "source"
            kotlin.jvm.internal.i.f(r13, r0)
            java.lang.String r0 = r13.readString()
            java.lang.String r1 = ""
            if (r0 != 0) goto Lf
            r3 = r1
            goto L10
        Lf:
            r3 = r0
        L10:
            java.lang.String r0 = r13.readString()
            if (r0 != 0) goto L18
            r4 = r1
            goto L19
        L18:
            r4 = r0
        L19:
            java.lang.String r0 = r13.readString()
            if (r0 != 0) goto L21
            r5 = r1
            goto L22
        L21:
            r5 = r0
        L22:
            long r6 = r13.readLong()
            java.lang.String r0 = r13.readString()
            java.lang.String r2 = "null"
            boolean r0 = kotlin.jvm.internal.i.b(r0, r2)
            if (r0 == 0) goto L35
            r0 = 0
        L33:
            r8 = r0
            goto L3e
        L35:
            java.lang.String r0 = r13.readString()
            android.net.Uri r0 = android.net.Uri.parse(r0)
            goto L33
        L3e:
            java.lang.String r0 = r13.readString()
            if (r0 != 0) goto L46
            r9 = r1
            goto L47
        L46:
            r9 = r0
        L47:
            long r10 = r13.readLong()
            r2 = r12
            r2.<init>(r3, r4, r5, r6, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.dialpad.ContactInfoForSpeedDial.<init>(android.os.Parcel):void");
    }
}
