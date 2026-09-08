package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public int f7018a;

    /* renamed from: b, reason: collision with root package name */
    public int f7019b;

    /* renamed from: c, reason: collision with root package name */
    public int f7020c;

    /* renamed from: d, reason: collision with root package name */
    public int f7021d;

    /* renamed from: e, reason: collision with root package name */
    public int f7022e;

    /* loaded from: classes.dex */
    public static class a implements Parcelable.Creator<ParcelableVolumeInfo> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelableVolumeInfo createFromParcel(Parcel parcel) {
            return new ParcelableVolumeInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelableVolumeInfo[] newArray(int i10) {
            return new ParcelableVolumeInfo[i10];
        }
    }

    public ParcelableVolumeInfo(Parcel parcel) {
        this.f7018a = parcel.readInt();
        this.f7020c = parcel.readInt();
        this.f7021d = parcel.readInt();
        this.f7022e = parcel.readInt();
        this.f7019b = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f7018a);
        parcel.writeInt(this.f7020c);
        parcel.writeInt(this.f7021d);
        parcel.writeInt(this.f7022e);
        parcel.writeInt(this.f7019b);
    }
}
