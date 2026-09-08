package com.heytap.epona;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class ExceptionInfo implements Parcelable {
    public static final Parcelable.Creator<ExceptionInfo> CREATOR = new a();
    private String mMessage;
    private String mName;

    /* loaded from: classes3.dex */
    public static class a implements Parcelable.Creator<ExceptionInfo> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ExceptionInfo createFromParcel(Parcel parcel) {
            return new ExceptionInfo(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ExceptionInfo[] newArray(int i10) {
            return new ExceptionInfo[i10];
        }
    }

    public /* synthetic */ ExceptionInfo(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public String getName() {
        return this.mName;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.mName);
        parcel.writeString(this.mMessage);
    }

    public ExceptionInfo(Throwable th) {
        this.mName = th.getClass().getName();
        this.mMessage = th.getMessage();
    }

    private ExceptionInfo(Parcel parcel) {
        this.mName = parcel.readString();
        this.mMessage = parcel.readString();
    }
}
