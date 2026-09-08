package com.heytap.accessory.constant;

import n5.C1371a;
import r5.f;

/* loaded from: classes3.dex */
public class FastPairConstants {
    public static final int CONNECT_TYPE_BLE = 4;
    public static final int CONNECT_TYPE_BT = 1;
    public static final int CONNECT_TYPE_BT_INSECURE = 32;
    public static final int CONNECT_TYPE_LAN = 16;
    public static final int CONNECT_TYPE_MAX = 63;
    public static final int CONNECT_TYPE_MINI = 1;
    public static final int CONNECT_TYPE_NETWORK_CONNECT = 8;
    public static final int CONNECT_TYPE_P2P = 2;
    public static final int CONNECT_TYPE_UNKNOWN = 0;
    public static final byte GO_INTENT_MAX = 15;
    public static final byte GO_INTENT_MIN = 0;
    public static final byte GO_INTENT_NOT_SET = -1;
    public static final byte GO_INTENT_PHONE_DEFAULT = 8;
    public static final int PAIR_TYPE_BLE_IN_ADV = 128;
    public static final int PAIR_TYPE_BLE_IN_PAIR = 32768;
    public static final int PAIR_TYPE_BR_EDR_IN_ADV = 64;
    public static final int PAIR_TYPE_BR_EDR_IN_PAIR = 16384;
    public static final int PAIR_TYPE_BT_INSECURE_IN_ADV = 4;
    public static final int PAIR_TYPE_BT_INSECURE_IN_PAIR = 512;
    public static final int PAIR_TYPE_LAN_IN_ADV = 8;
    public static final int PAIR_TYPE_LAN_IN_PAIR = 1024;
    public static final int PAIR_TYPE_NETWORK_CONNECT_IN_PAIR = 2048;
    public static final int PAIR_TYPE_NETWORK_IN_ADV = 16;
    public static final int PAIR_TYPE_P2P_FOR_PC_IN_PAIR = 4096;
    public static final int PAIR_TYPE_P2P_IN_ADV = 32;
    public static final int PAIR_TYPE_P2P_IN_PAIR = 8192;
    public static final int PAIR_TYPE_UNKNOWN_IN_PAIR = 0;
    public static final int RELO_P2P_GC = 4;
    public static final int ROLE_P2P_GO = 3;
    public static final int SCAN_TYPE_BLE = 1;
    public static final int SCAN_TYPE_BT = 2;
    public static final int SCAN_TYPE_MAX = 15;
    public static final int SCAN_TYPE_MINI = 1;
    public static final int SCAN_TYPE_NSD = 4;
    public static final int SCAN_TYPE_OUTOFBAND = 8;
    public static final int SCAN_TYPE_UNKNOWN = 0;
    public static final int STATUS_BLE_CONNECT_COMPLETE = 34;
    public static final int STATUS_BLE_CONNECT_DISCONNECT = 36;
    public static final int STATUS_BLE_CONNECT_FAILED = 35;
    public static final int STATUS_BLE_CONNECT_START = 33;
    public static final int STATUS_BLE_DISCOVER_START = 31;
    public static final int STATUS_BLE_DISCOVER_STOP = 32;
    public static final int STATUS_BLE_UNKNOWN = 30;
    public static final int STATUS_BT_CONNECT_COMPLETE = 14;
    public static final int STATUS_BT_CONNECT_DISCONNECT = 16;
    public static final int STATUS_BT_CONNECT_FAILED = 15;
    public static final int STATUS_BT_CONNECT_START = 13;
    public static final String STATUS_BT_DISCONNECT_NORMAL = "003";
    public static final int STATUS_BT_DISCOVER_START = 11;
    public static final int STATUS_BT_DISCOVER_STOP = 12;
    public static final int STATUS_BT_UNKNOWN = 10;
    public static final int STATUS_CAST_CONNECTED = 98;
    public static final int STATUS_CAST_DISCONNECTED = 99;
    public static final String STATUS_CAST_DISCONNECT_NORMAL = "012";
    public static final String STATUS_CAST_DISCONNECT_UNKNOWN = "013";
    public static final String STATUS_CAST_RESULT_FAIL = "011";
    public static final String STATUS_CAST_RESULT_SUCCESS = "010";
    public static final int STATUS_CAST_START = 97;
    public static final String STATUS_CONNECT_RESULT_CANCEL = "002";
    public static final String STATUS_CONNECT_RESULT_FAIL = "001";
    public static final String STATUS_CONNECT_RESULT_SUCCESS = "000";
    public static final int STATUS_P2P_CONNECT_COMPLETE = 4;
    public static final int STATUS_P2P_CONNECT_DISCONNECT = 6;
    public static final int STATUS_P2P_CONNECT_FAILED = 5;
    public static final int STATUS_P2P_CONNECT_START = 3;
    public static final int STATUS_P2P_DISCOVER_START = 1;
    public static final int STATUS_P2P_DISCOVER_STOP = 2;
    public static final int STATUS_P2P_UNKNOWN = 0;
    public static final int STATUS_ROLE_PROVIDER = 12;
    public static final int STATUS_ROLE_SEEKER = 11;
    public static final int STATUS_RTSP_CONNECT_COMPLETE = 24;
    public static final int STATUS_RTSP_CONNECT_START = 23;
    public static final int STATUS_RTSP_DISCOVER_START = 21;
    public static final int STATUS_RTSP_DISCOVER_STOP = 22;
    public static final int STATUS_RTSP_UNKNOWN = 20;
    private static final String TAG = "FastPairConstants";
    public static final int TYPE_CAST_OCAR = 4;
    public static final int TYPE_CAST_OPPOTV = 2;
    public static final int TYPE_CAST_PAD = 5;
    public static final int TYPE_CAST_PCCONNECT = 3;
    public static final int TYPE_CAST_UNKNOWN = 0;
    public static final int TYPE_CAST_WFD = 1;
    public static final int TYPE_OSHARE = 8;
    public static final int TYPE_RESERVE = 9;

    public static int convertPairTypeAdvToSdk(int i10) {
        int i11;
        if ((i10 & 32) != 0) {
            i11 = 2;
        } else {
            i11 = 0;
        }
        if ((i10 & 64) != 0) {
            i11 |= 1;
        }
        if ((i10 & 128) != 0) {
            i11 |= 4;
        }
        if ((i10 & 16) != 0) {
            i11 |= 8;
        }
        if ((i10 & 8) != 0) {
            i11 |= 16;
        }
        if ((i10 & 4) != 0) {
            return i11 | 32;
        }
        return i11;
    }

    public static int convertPairTypeSdkToAdv(int i10, String str) {
        int i11;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if ((i10 & 2) != 0) {
            sb.append(", p2p");
            i11 = 32;
        } else {
            i11 = 0;
        }
        if ((i10 & 1) != 0) {
            sb.append(", bt");
            i11 |= 64;
        }
        if ((i10 & 4) != 0) {
            sb.append(", ble");
            i11 |= 128;
        }
        if ((i10 & 8) != 0) {
            sb.append(", network connect");
            i11 |= 16;
        }
        if ((i10 & 16) != 0) {
            sb.append(", lan connect");
            i11 |= 8;
        }
        if ((i10 & 32) != 0) {
            sb.append(", bt insecure connect");
            i11 |= 4;
        }
        sb.append(", ");
        sb.append(f.h(i11));
        C1371a.c(TAG, sb.toString());
        return i11;
    }

    public static int convertPairTypeSdkToPair(int i10, String str) {
        int i11;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if ((i10 & 2) != 0) {
            sb.append(", p2p");
            i11 = 8192;
        } else {
            i11 = 0;
        }
        if ((i10 & 1) != 0) {
            sb.append(", bt");
            i11 |= 16384;
        }
        if ((i10 & 4) != 0) {
            sb.append(", ble");
            i11 |= PAIR_TYPE_BLE_IN_PAIR;
        }
        if ((i10 & 8) != 0) {
            sb.append(", network connect");
            i11 |= 2048;
        }
        if ((i10 & 16) != 0) {
            sb.append(", lan connect");
            i11 |= 1024;
        }
        if ((i10 & 32) != 0) {
            sb.append(", insecureBt connect");
            i11 |= 512;
        }
        sb.append(", ");
        sb.append(f.h(i11));
        sb.append(", settingInSdkType:");
        sb.append(f.h(i10));
        C1371a.c(TAG, sb.toString());
        return i11;
    }
}
