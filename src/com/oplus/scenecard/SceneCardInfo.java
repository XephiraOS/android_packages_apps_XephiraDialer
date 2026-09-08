package com.oplus.scenecard;

import android.content.ComponentName;
import android.graphics.drawable.Icon;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class SceneCardInfo implements Parcelable {
    public static final Parcelable.Creator<SceneCardInfo> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public int f28923a;

    /* renamed from: b, reason: collision with root package name */
    public String f28924b;

    /* renamed from: c, reason: collision with root package name */
    public Icon f28925c;

    /* renamed from: d, reason: collision with root package name */
    public Icon f28926d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f28927e;

    /* renamed from: f, reason: collision with root package name */
    public int f28928f;

    /* renamed from: g, reason: collision with root package name */
    public ComponentName f28929g;

    /* renamed from: h, reason: collision with root package name */
    public Icon f28930h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f28931i = false;

    /* renamed from: j, reason: collision with root package name */
    public boolean f28932j = false;

    /* loaded from: classes3.dex */
    public class a implements Parcelable.Creator<SceneCardInfo> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SceneCardInfo createFromParcel(Parcel parcel) {
            return new SceneCardInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public SceneCardInfo[] newArray(int i10) {
            return new SceneCardInfo[i10];
        }
    }

    public SceneCardInfo(Parcel parcel) {
        this.f28923a = parcel.readInt();
        this.f28924b = parcel.readString();
        this.f28925c = (Icon) parcel.readParcelable(Icon.class.getClassLoader());
        this.f28926d = (Icon) parcel.readParcelable(Icon.class.getClassLoader());
        this.f28927e = parcel.readByte() != 0;
        this.f28928f = parcel.readInt();
        this.f28929g = (ComponentName) parcel.readParcelable(ComponentName.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "[mCardId = " + this.f28923a + ", mName = " + this.f28924b + ", mIcon = " + this.f28925c + ", mPreview = " + this.f28926d + ", mSecure = " + this.f28927e + ", mType = " + this.f28928f + ", mComponentName = " + this.f28929g + ", mMiniAppIcon = " + this.f28930h + ", mIsDarkStyle = " + this.f28931i + ", mShowWhenLocked = " + this.f28932j + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f28923a);
        parcel.writeString(this.f28924b);
        parcel.writeParcelable(this.f28925c, i10);
        parcel.writeParcelable(this.f28926d, i10);
        parcel.writeByte(this.f28927e ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f28928f);
        parcel.writeParcelable(this.f28929g, i10);
    }
}
