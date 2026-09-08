package com.heytap.accessory.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.oplus.backup.sdk.common.plugin.BRPluginConfig;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ServiceProfile implements Parcelable {
    public static final Parcelable.Creator<ServiceProfile> CREATOR = new Parcelable.Creator<ServiceProfile>() { // from class: com.heytap.accessory.bean.ServiceProfile.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ServiceProfile createFromParcel(Parcel parcel) {
            return new ServiceProfile(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ServiceProfile[] newArray(int i10) {
            return new ServiceProfile[i10];
        }
    };
    public static final int FEATURE_DISABLED = 0;
    public static final int FEATURE_ENABLED = 1;
    public static final int ROLE_CONSUMER = 1;
    public static final int ROLE_PROVIDER = 0;
    public static final int SERVICE_LIMIT_ANY = 0;
    public static final int SERVICE_LIMIT_ONE_ACCESSORY = 1;
    public static final int SERVICE_LIMIT_ONE_PEERAGENT = 2;
    private int mAwakenable;
    private String mId;
    private int mIsMexSupported;
    private int mIsSocketSupported;
    private String mName;
    private int mRole;
    private List<ServiceChannel> mServiceChannelList;
    private String mServiceImpl;
    private int mServiceLimit;
    private int mServiceTimeout;
    private int mTransportType;
    private String mVersion;

    public ServiceProfile() {
        this.mServiceChannelList = new ArrayList();
    }

    public static Bundle createBundle(ServiceProfile serviceProfile) {
        Bundle bundle = new Bundle();
        bundle.putString("id", serviceProfile.getId());
        bundle.putString("name", serviceProfile.getName());
        bundle.putInt("role", serviceProfile.getRole());
        bundle.putString("serviceImpl", serviceProfile.getServiceImpl());
        bundle.putString(BRPluginConfig.VERSION, serviceProfile.getVersion());
        bundle.putInt("serviceLimit", serviceProfile.getServiceLimit());
        bundle.putInt("serviceTimeout", serviceProfile.getServiceTimeout());
        bundle.putInt("transportType", serviceProfile.getTransportType());
        bundle.putInt("mexSupport", serviceProfile.isMexSupported());
        bundle.putInt("socketSupport", serviceProfile.isSocketSupported());
        bundle.putInt("awakenable", serviceProfile.isAwakenable());
        return bundle;
    }

    public static ServiceProfile createFromBundle(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        String string = bundle.getString("id", "");
        String string2 = bundle.getString("name", "");
        int i10 = bundle.getInt("role", 0);
        String string3 = bundle.getString("serviceImpl", "");
        String string4 = bundle.getString(BRPluginConfig.VERSION, "");
        int i11 = bundle.getInt("serviceLimit", 0);
        int i12 = bundle.getInt("serviceTimeout", 10);
        int i13 = bundle.getInt("transportType", 0);
        int i14 = bundle.getInt("mexSupport", 0);
        int i15 = bundle.getInt("socketSupport", 1);
        int i16 = bundle.getInt("awakenable", 1);
        ServiceChannel serviceChannel = new ServiceChannel(104, 0, 4, 1);
        ServiceChannel serviceChannel2 = new ServiceChannel(110, 0, 4, 1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(serviceChannel);
        arrayList.add(serviceChannel2);
        return new ServiceProfile(string, string2, i10, string3, string4, i11, i12, i13, arrayList, i14, i15, i16);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public int getRole() {
        return this.mRole;
    }

    public List<ServiceChannel> getServiceChannelList() {
        return this.mServiceChannelList;
    }

    public String getServiceImpl() {
        return this.mServiceImpl;
    }

    public int getServiceLimit() {
        return this.mServiceLimit;
    }

    public int getServiceTimeout() {
        return this.mServiceTimeout;
    }

    public int getTransportType() {
        return this.mTransportType;
    }

    public String getVersion() {
        return this.mVersion;
    }

    public int isAwakenable() {
        return this.mAwakenable;
    }

    public int isMexSupported() {
        return this.mIsMexSupported;
    }

    public int isSocketSupported() {
        return this.mIsSocketSupported;
    }

    public void setAwakenable(int i10) {
        this.mAwakenable = i10;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void setIsMexSupported(int i10) {
        this.mIsMexSupported = i10;
    }

    public void setIsSocketSupported(int i10) {
        this.mIsSocketSupported = i10;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setRole(int i10) {
        this.mRole = i10;
    }

    public void setServiceChannelList(List<ServiceChannel> list) {
        this.mServiceChannelList = list;
    }

    public void setServiceImpl(String str) {
        this.mServiceImpl = str;
    }

    public void setServiceLimit(int i10) {
        this.mServiceLimit = i10;
    }

    public void setServiceTimeout(int i10) {
        this.mServiceTimeout = i10;
    }

    public void setTransportType(int i10) {
        this.mTransportType = i10;
    }

    public void setVersion(String str) {
        this.mVersion = str;
    }

    public String toString() {
        return "ServiceProfile{mId='" + this.mId + "', mName='" + this.mName + "', mServiceImpl='" + this.mServiceImpl + "', mVersion='" + this.mVersion + "', mRole='" + this.mRole + "', mServiceLimit=" + this.mServiceLimit + ", mServiceTimeout=" + this.mServiceTimeout + ", mTransportType=" + this.mTransportType + ", isMexSupported=" + this.mIsMexSupported + ", isSocketSupported=" + this.mIsSocketSupported + ", mServiceChannelList=" + this.mServiceChannelList + ", Awakenable=" + this.mAwakenable + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.mId);
        parcel.writeString(this.mName);
        parcel.writeString(this.mServiceImpl);
        parcel.writeString(this.mVersion);
        parcel.writeInt(this.mRole);
        parcel.writeInt(this.mServiceLimit);
        parcel.writeInt(this.mServiceTimeout);
        parcel.writeInt(this.mTransportType);
        parcel.writeInt(this.mIsMexSupported);
        parcel.writeInt(this.mIsSocketSupported);
    }

    public ServiceProfile(String str, String str2, int i10, String str3, String str4, int i11, int i12, int i13, List<ServiceChannel> list, int i14, int i15, int i16) {
        new ArrayList();
        this.mId = str;
        this.mName = str2;
        this.mRole = i10;
        this.mServiceImpl = str3;
        this.mVersion = str4;
        this.mServiceLimit = i11;
        this.mServiceTimeout = i12;
        this.mTransportType = i13;
        this.mServiceChannelList = list;
        this.mIsMexSupported = i14;
        this.mIsSocketSupported = i15;
        this.mAwakenable = i16;
    }

    public ServiceProfile(Parcel parcel) {
        this.mServiceChannelList = new ArrayList();
        this.mId = parcel.readString();
        this.mName = parcel.readString();
        this.mServiceImpl = parcel.readString();
        this.mVersion = parcel.readString();
        this.mRole = parcel.readInt();
        this.mServiceLimit = parcel.readInt();
        this.mServiceTimeout = parcel.readInt();
        this.mTransportType = parcel.readInt();
        this.mIsMexSupported = parcel.readInt();
        this.mIsSocketSupported = parcel.readInt();
    }
}
