package com.heytap.accessory.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.android.incallui.OplusPhoneUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class PeerAgent implements Parcelable {
    public static final Parcelable.Creator<PeerAgent> CREATOR = new Parcelable.Creator<PeerAgent>() { // from class: com.heytap.accessory.bean.PeerAgent.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PeerAgent createFromParcel(Parcel parcel) {
            return new PeerAgent(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PeerAgent[] newArray(int i10) {
            return new PeerAgent[i10];
        }
    };
    private static final String TAG = "PeerAgent";
    private String mAgentId;
    private final String mAppHash;
    private final String mAppName;
    private final int mMexSupport;
    private final PeerAccessory mPeerAccessory;
    private final String mProfileVersion;
    private final int mSocketSupport;
    private long mTransactionId;

    public PeerAgent(String str, String str2, String str3, String str4, PeerAccessory peerAccessory, int i10, int i11) {
        this.mProfileVersion = str4;
        this.mPeerAccessory = peerAccessory;
        this.mAgentId = str;
        this.mAppName = str2;
        this.mAppHash = str3;
        this.mMexSupport = i10;
        this.mSocketSupport = i11;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof PeerAgent)) {
            return false;
        }
        PeerAgent peerAgent = (PeerAgent) obj;
        if (getAgentId() == null) {
            Log.w(TAG, "Invalid peerAgent instance.Peer ID - this:null PeerAgent:" + peerAgent.getAgentId());
            return false;
        }
        if (!this.mAgentId.equals(peerAgent.getAgentId())) {
            Log.w(TAG, "Invalid peerAgent instance.Peer ID - this:" + this.mAgentId + " PeerAgent:" + peerAgent.getAgentId());
            return false;
        }
        if (getAppName() == null) {
            if (peerAgent.getAppName() != null) {
                Log.w(TAG, "Invalid peerAgent instance.Container ID - this:null PeerAgent:" + peerAgent.getAppName());
                return false;
            }
        } else if (!this.mAppName.equals(peerAgent.getAppName())) {
            Log.w(TAG, "Invalid peerAgent instance.Container ID - this:" + this.mAppName + " PeerAgent:" + peerAgent.getAppName());
            return false;
        }
        if (peerAgent.getAccessory().getId() != getAccessory().getId()) {
            Log.w(TAG, "Invalid peerAgent instance.Accessory ID - this:" + getAccessory().getPeerId() + " PeerAgent:" + peerAgent.getAccessory().getPeerId());
            return false;
        }
        return true;
    }

    public PeerAccessory getAccessory() {
        return this.mPeerAccessory;
    }

    public long getAccessoryId() {
        return this.mPeerAccessory.getId();
    }

    public String getAgentId() {
        return this.mAgentId;
    }

    public String getAppHash() {
        return this.mAppHash;
    }

    public String getAppName() {
        return this.mAppName;
    }

    public List<String> getContent() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.mAgentId);
        arrayList.add(this.mAppName);
        arrayList.add(this.mAppHash);
        arrayList.add(this.mProfileVersion);
        arrayList.add(Integer.toString(this.mMexSupport));
        arrayList.add(Integer.toString(this.mSocketSupport));
        arrayList.addAll(this.mPeerAccessory.getContent());
        return arrayList;
    }

    public int getEncryptionPaddingLength() {
        return this.mPeerAccessory.getEncryptionPaddingLength();
    }

    public int getMaxAllowedDataSize() {
        PeerAccessory peerAccessory = this.mPeerAccessory;
        if (peerAccessory != null) {
            return peerAccessory.getApduSize();
        }
        return OplusPhoneUtils.PROPERTY_HIGH_DEF_AUDIO_EVS;
    }

    public int getMaxAllowedMessageSize() {
        PeerAccessory peerAccessory = this.mPeerAccessory;
        if (peerAccessory != null) {
            return peerAccessory.getApduSize();
        }
        return OplusPhoneUtils.PROPERTY_HIGH_DEF_AUDIO_EVS;
    }

    public int getMxduSize() {
        PeerAccessory peerAccessory = this.mPeerAccessory;
        if (peerAccessory != null) {
            return peerAccessory.getMxduSize();
        }
        return 65524;
    }

    public String getProfileVersion() {
        return this.mProfileVersion;
    }

    public int getSsduSize() {
        PeerAccessory peerAccessory = this.mPeerAccessory;
        if (peerAccessory != null) {
            return peerAccessory.getSsduSize();
        }
        return 65530;
    }

    public long getTransactionId() {
        return this.mTransactionId;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = (this.mAgentId.hashCode() + 527) * 31;
        String str = this.mAppName;
        int i10 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i11 = (hashCode2 + hashCode) * 31;
        PeerAccessory peerAccessory = this.mPeerAccessory;
        if (peerAccessory != null) {
            i10 = (int) (peerAccessory.getId() ^ (this.mPeerAccessory.getId() >>> 32));
        }
        return i11 + i10;
    }

    public void setAgentId(String str) {
        this.mAgentId = str;
    }

    public void setTransactionId(long j10) {
        this.mTransactionId = j10;
    }

    public String toString() {
        return "PeerAgent - id:" + this.mAgentId + ", containerId:" + this.mAppName + ", Profile Version:" + this.mProfileVersion + ", " + this.mPeerAccessory.toString() + ", MexSupport:" + this.mMexSupport + ", SocketSupport:" + this.mSocketSupport;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(1);
        parcel.writeString(this.mAgentId);
        parcel.writeString(this.mAppName);
        parcel.writeString(this.mAppHash);
        parcel.writeString(this.mProfileVersion);
        parcel.writeParcelable(this.mPeerAccessory, i10);
        parcel.writeInt(this.mMexSupport);
        parcel.writeInt(this.mSocketSupport);
    }

    public PeerAgent(Parcel parcel) {
        int readInt = parcel.readInt();
        Log.v(TAG, "Peeragent:Framework version:" + readInt);
        this.mAgentId = parcel.readString();
        this.mAppName = parcel.readString();
        String readString = parcel.readString();
        this.mAppHash = readString == null ? "" : readString;
        this.mProfileVersion = parcel.readString();
        this.mPeerAccessory = (PeerAccessory) parcel.readParcelable(PeerAccessory.class.getClassLoader());
        this.mMexSupport = parcel.readInt();
        this.mSocketSupport = parcel.readInt();
    }

    public PeerAgent(List<String> list) {
        this.mAgentId = list.get(0);
        this.mAppName = list.get(1);
        this.mAppHash = list.get(2);
        this.mProfileVersion = list.get(3);
        this.mMexSupport = Integer.parseInt(list.get(4));
        this.mSocketSupport = Integer.parseInt(list.get(5));
        this.mPeerAccessory = new PeerAccessory(list.subList(6, list.size()));
    }
}
