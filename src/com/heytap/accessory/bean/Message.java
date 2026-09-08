package com.heytap.accessory.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class Message implements Parcelable {
    public static final Parcelable.Creator<Message> CREATOR = new Parcelable.Creator<Message>() { // from class: com.heytap.accessory.bean.Message.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Message createFromParcel(Parcel parcel) {
            return new Message(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Message[] newArray(int i10) {
            return new Message[i10];
        }
    };
    public static final String INTENT_EXTRA_ADVERTISE_DATA = "extra_advertise_data";
    public static final String INTENT_EXTRA_CONNECT_TYPE = "extra_connect_type";
    public static final String INTENT_EXTRA_DEVICE_ADDRESS = "extra_device_address";
    public static final String INTENT_EXTRA_DEVICE_ID = "extra_device_id";
    public static final String INTENT_EXTRA_DEVICE_NAME = "extra_device_name";
    public static final String INTENT_EXTRA_KSC_ALIAS = "extra_ksc_alias";
    public static final String INTENT_EXTRA_LAUNCH_TYPE = "extra_launch_type";
    public static final String INTENT_EXTRA_LOCAL_DEVICE_ID = "extra_local_device_id";
    public static final String INTENT_EXTRA_MAJOR_TYPE = "extra_major_type";
    public static final String INTENT_EXTRA_MODEL_ID = "extra_model_id";
    public static final String INTENT_EXTRA_NICK_NAME = "extra_nick_name";
    public static final String INTENT_EXTRA_PRODUCT_ACTION = "extra_product_action";
    public static final String INTENT_EXTRA_PRODUCT_COMPONENT = "extra_product_component";
    public static final String INTENT_EXTRA_PRODUCT_TARGET = "extra_product_target";
    public static final String INTENT_EXTRA_PRODUCT_VERSION = "extra_product_version";
    public static final String INTENT_EXTRA_PROVIDER_IP = "extra_provider_ip";
    public static final String INTENT_EXTRA_PROVIDER_MAC = "extra_provider_mac";
    public static final String INTENT_EXTRA_PROVIDER_PORT = "extra_provider_port";
    public static final String INTENT_EXTRA_RSSI = "extra_rssi";
    public static final String INTENT_EXTRA_SEEKER_AS_GO = "extra_seeker_as_go";
    public static final String INTENT_EXTRA_SSID = "extra_ssid";
    public static final String INTENT_EXTRA_SUB_TYPE = "extra_sub_type";
    public static final String KEY_MSG_AUTH_DATA = "key_msg_auth_data";
    public static final String KEY_MSG_AUTH_LIMIT_LENGTH = "key_msg_auth_limit_length";
    public static final String KEY_MSG_AUTH_MODE = "key_msg_auth_mode";
    public static final String KEY_MSG_CONNECT_DATA = "key_msg_connect_data";
    public static final String KEY_MSG_ERROR_CODE = "key_msg_error_code";
    public static final String KEY_MSG_PAIR_INFO = "key_msg_pair_info";
    public static final String KEY_MSG_RDI = "key_msg_rdi";
    public static final String KEY_MSG_SCAN_TYPE = "key_msg_scan_type";
    public static final String KEY_MSG_TYPE_PAIR_TYPE_RECEIVED = "key_msg_type_pair_type_received";
    public static final String SDK_VERSION = "sdk_version";
    private Bundle mBundle;

    public Message() {
        this.mBundle = new Bundle();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Bundle getBundle() {
        return this.mBundle;
    }

    public void readFromParcel(Parcel parcel) {
        this.mBundle = parcel.readBundle(getClass().getClassLoader());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeBundle(this.mBundle);
    }

    public Message(Bundle bundle) {
        this.mBundle = bundle == null ? new Bundle() : bundle;
    }

    public Message(Parcel parcel) {
        readFromParcel(parcel);
    }
}
