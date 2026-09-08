package com.heytap.accessory.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.heytap.accessory.discovery.IScanFilter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes3.dex */
public class CharacterScanFilter implements IScanFilter {
    public static final Parcelable.Creator<CharacterScanFilter> CREATOR = new Parcelable.Creator<CharacterScanFilter>() { // from class: com.heytap.accessory.bean.CharacterScanFilter.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CharacterScanFilter createFromParcel(Parcel parcel) {
            return new CharacterScanFilter(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CharacterScanFilter[] newArray(int i10) {
            return new CharacterScanFilter[i10];
        }
    };
    public static final String KEY = "CharaScanFilter";
    private static final int LIMITED_DEVICEID_LENGTH = 6;
    private Set<byte[]> mDeviceIdSet = new HashSet();

    private CharacterScanFilter() {
    }

    public static CharacterScanFilter create() {
        return new CharacterScanFilter();
    }

    public CharacterScanFilter addDeviceId(byte[] bArr) {
        if (bArr != null && bArr.length == 6) {
            this.mDeviceIdSet.add(bArr);
            return this;
        }
        throw new IllegalArgumentException("device id invalid (length must be 6 byte)");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Set<byte[]> getDeviceIdSet() {
        return this.mDeviceIdSet;
    }

    @Override // com.heytap.accessory.discovery.IScanFilter
    public String getKey() {
        return KEY;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.mDeviceIdSet.size());
        Iterator<byte[]> it = this.mDeviceIdSet.iterator();
        while (it.hasNext()) {
            parcel.writeByteArray(it.next());
        }
    }

    public CharacterScanFilter(Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt > 0) {
            for (int i10 = 0; i10 < readInt; i10++) {
                this.mDeviceIdSet.add(parcel.createByteArray());
            }
        }
    }
}
