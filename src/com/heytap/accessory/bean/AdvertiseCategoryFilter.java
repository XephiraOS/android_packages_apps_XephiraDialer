package com.heytap.accessory.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.heytap.accessory.discovery.IScanFilter;
import com.heytap.accessory.type.AdvAdditionDataType;

/* loaded from: classes3.dex */
public class AdvertiseCategoryFilter implements IScanFilter {
    public static final int ADVERTISE_CATEGORY_ALL = 0;
    public static final int ADVERTISE_CATEGORY_OAF = 1;
    public static final int ADVERTISE_CATEGORY_ONET = 2;
    public static final Parcelable.Creator<AdvertiseCategoryFilter> CREATOR = new Parcelable.Creator<AdvertiseCategoryFilter>() { // from class: com.heytap.accessory.bean.AdvertiseCategoryFilter.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AdvertiseCategoryFilter createFromParcel(Parcel parcel) {
            return new AdvertiseCategoryFilter(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AdvertiseCategoryFilter[] newArray(int i10) {
            return new AdvertiseCategoryFilter[i10];
        }
    };
    public static final String KEY = "AdvertiseCategoryFilter";
    private int mAdvertiseCategory;

    private AdvertiseCategoryFilter() {
        this.mAdvertiseCategory = 0;
    }

    public static AdvertiseCategoryFilter create() {
        return new AdvertiseCategoryFilter();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAdvertiseCategory() {
        return this.mAdvertiseCategory;
    }

    @Override // com.heytap.accessory.discovery.IScanFilter
    public String getKey() {
        return KEY;
    }

    public boolean isFiltered(DeviceInfo deviceInfo) {
        int i10;
        if (this.mAdvertiseCategory == 0) {
            return false;
        }
        byte[] additionData = deviceInfo.getAdditionData(AdvAdditionDataType.ABILITY);
        if (additionData != null && additionData.length > 0) {
            i10 = 2;
        } else {
            i10 = 1;
        }
        if (this.mAdvertiseCategory == i10) {
            return false;
        }
        return true;
    }

    public AdvertiseCategoryFilter setAdvertiseCategory(int i10) {
        if (i10 >= 1 && i10 <= 2) {
            this.mAdvertiseCategory = i10;
            return this;
        }
        throw new IllegalArgumentException("illegal advertise category: " + i10);
    }

    public String toString() {
        return "AdvertiseCategoryFilter{mAdvertiseCategory=" + this.mAdvertiseCategory + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.mAdvertiseCategory);
    }

    public AdvertiseCategoryFilter(Parcel parcel) {
        this.mAdvertiseCategory = 0;
        this.mAdvertiseCategory = parcel.readInt();
    }
}
