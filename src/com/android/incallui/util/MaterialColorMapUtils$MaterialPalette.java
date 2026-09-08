package com.android.incallui.util;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class MaterialColorMapUtils$MaterialPalette implements Parcelable {
    public static final Parcelable.Creator<MaterialColorMapUtils$MaterialPalette> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final int f19174a;

    /* renamed from: b, reason: collision with root package name */
    public final int f19175b;

    /* loaded from: classes.dex */
    public class a implements Parcelable.Creator<MaterialColorMapUtils$MaterialPalette> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MaterialColorMapUtils$MaterialPalette createFromParcel(Parcel parcel) {
            return new MaterialColorMapUtils$MaterialPalette(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public MaterialColorMapUtils$MaterialPalette[] newArray(int i10) {
            return new MaterialColorMapUtils$MaterialPalette[i10];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MaterialColorMapUtils$MaterialPalette materialColorMapUtils$MaterialPalette = (MaterialColorMapUtils$MaterialPalette) obj;
        if (this.f19174a == materialColorMapUtils$MaterialPalette.f19174a && this.f19175b == materialColorMapUtils$MaterialPalette.f19175b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.f19174a + 31) * 31) + this.f19175b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f19174a);
        parcel.writeInt(this.f19175b);
    }

    public MaterialColorMapUtils$MaterialPalette(Parcel parcel) {
        this.f19174a = parcel.readInt();
        this.f19175b = parcel.readInt();
    }
}
