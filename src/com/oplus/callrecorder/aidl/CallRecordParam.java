package com.oplus.callrecorder.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: CallRecordParam.kt */
/* loaded from: classes3.dex */
public final class CallRecordParam implements Parcelable {
    public static final a CREATOR = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public String f27743a;

    /* renamed from: b, reason: collision with root package name */
    public String f27744b;

    /* renamed from: c, reason: collision with root package name */
    public String f27745c;

    /* renamed from: d, reason: collision with root package name */
    public int f27746d = 2;

    /* renamed from: e, reason: collision with root package name */
    public int f27747e = 148000;

    /* renamed from: f, reason: collision with root package name */
    public int f27748f = 48000;

    /* renamed from: g, reason: collision with root package name */
    public String f27749g;

    /* compiled from: CallRecordParam.kt */
    /* loaded from: classes3.dex */
    public static final class a implements Parcelable.Creator<CallRecordParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CallRecordParam createFromParcel(Parcel parcel) {
            i.f(parcel, "parcel");
            CallRecordParam callRecordParam = new CallRecordParam();
            String readString = parcel.readString();
            i.e(readString, "parcel.readString()");
            callRecordParam.m(readString);
            String readString2 = parcel.readString();
            i.e(readString2, "parcel.readString()");
            callRecordParam.k(readString2);
            callRecordParam.n(parcel.readString());
            callRecordParam.h(parcel.readInt());
            callRecordParam.i(parcel.readInt());
            callRecordParam.j(parcel.readInt());
            String readString3 = parcel.readString();
            i.e(readString3, "parcel.readString()");
            callRecordParam.p(readString3);
            return callRecordParam;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CallRecordParam[] newArray(int i10) {
            return new CallRecordParam[i10];
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public final String b() {
        String str = this.f27744b;
        if (str != null) {
            return str;
        }
        i.q("recordDir");
        return null;
    }

    public final String d() {
        String str = this.f27743a;
        if (str != null) {
            return str;
        }
        i.q("recordName");
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String f() {
        String str = this.f27749g;
        if (str != null) {
            return str;
        }
        i.q("recordPostfix");
        return null;
    }

    public final void h(int i10) {
        this.f27746d = i10;
    }

    public final void i(int i10) {
        this.f27747e = i10;
    }

    public final void j(int i10) {
        this.f27748f = i10;
    }

    public final void k(String str) {
        i.f(str, "<set-?>");
        this.f27744b = str;
    }

    public final void m(String str) {
        i.f(str, "<set-?>");
        this.f27743a = str;
    }

    public final void n(String str) {
        this.f27745c = str;
    }

    public final void p(String str) {
        i.f(str, "<set-?>");
        this.f27749g = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        i.f(parcel, "parcel");
        parcel.writeString(d());
        parcel.writeString(b());
        parcel.writeString(this.f27745c);
        parcel.writeInt(this.f27746d);
        parcel.writeInt(this.f27747e);
        parcel.writeInt(this.f27748f);
        parcel.writeString(f());
    }
}
