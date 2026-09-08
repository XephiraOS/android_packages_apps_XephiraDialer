package com.oplus.ocs.icdf;

/* loaded from: classes3.dex */
public class BaseAgentConsists {
    public static final int CHANNEL_TYPE_COMMON = 3;
    public static final int CHANNEL_TYPE_GRPC = 1;
    public static final int CHANNEL_TYPE_GRPC_OVER_COMMON = 2;
    public static final int ICDF_CHANNEL_BYTES = 1;
    public static final int ICDF_CHANNEL_STREAM = 2;
    public static final int PROTOCOL_AVUDT = 3;
    public static final int PROTOCOL_DEFAULT = 0;
    public static final int PROTOCOL_TCP = 1;
    public static final int PROTOCOL_UDP = 2;
    public static final int ROLE_CONSUMER = 1;
    public static final int ROLE_PROVIDER = 0;
    public static final int ROLE_UNKNOWN = -1;

    public String toString() {
        return "Consist fields in BaseAgent/BaseJobAgent";
    }
}
