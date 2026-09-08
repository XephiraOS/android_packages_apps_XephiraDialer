package com.oplus.ocs.icdf;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public final class CreateChannelResult {
    public static final int CREATE_CHANNEL_ALREADY_EXIST = 10005;
    public static final int CREATE_CHANNEL_DUPLICATE_REQUEST = 10009;
    public static final int CREATE_CHANNEL_FAILED = 1;
    public static final int CREATE_CHANNEL_FAILURE_ACC_DORMANT = 10018;
    public static final int CREATE_CHANNEL_FAILURE_CHANNELID_MISMATCH = 10011;
    public static final int CREATE_CHANNEL_FAILURE_DEVICE_UNREACHABLE = 10004;
    public static final int CREATE_CHANNEL_FAILURE_FATAL_ERROR = 3;
    public static final int CREATE_CHANNEL_FAILURE_INVALID_PEERAGENT = 10008;
    public static final int CREATE_CHANNEL_FAILURE_NETWORK = 10012;
    public static final int CREATE_CHANNEL_FAILURE_PEERAGENT_NO_RESPONSE = 10006;
    public static final int CREATE_CHANNEL_FAILURE_PEERAGENT_REJECTED = 10007;
    public static final int CREATE_CHANNEL_FAILURE_SERVICE_LIMIT_REACHED = 10010;
    public static final int CREATE_CHANNEL_SUCCESS = 0;
    public static final int CREATE_CHANNEL_SUCCESS_PROTOCOL_DEFAULT = 2;
    private final a mCode;
    private final String mDescription;
    public static final Map<Integer, CreateChannelResult> RESULT_MAP = buildMap();
    public static final CreateChannelResult SUCCESS = a.a(a.SUCCESS);
    public static final CreateChannelResult SUCCESS_PROTOCOL_DEFAULT = a.a(a.SUCCESS_PROTOCOL_DEFAULT);
    public static final CreateChannelResult FAILURE = a.a(a.FAILURE);
    public static final CreateChannelResult FATAL_ERROR = a.a(a.FATAL_ERROR);
    public static final CreateChannelResult DEVICE_UNREACHABLE = a.a(a.DEVICE_UNREACHABLE);
    public static final CreateChannelResult CHANNEL_ALREADY_EXIST = a.a(a.CHANNEL_ALREADY_EXIST);
    public static final CreateChannelResult PEERAGENT_NO_RESPONSE = a.a(a.PEERAGENT_NO_RESPONSE);
    public static final CreateChannelResult PEERAGENT_REJECTED = a.a(a.PEERAGENT_REJECTED);
    public static final CreateChannelResult INVALID_PEERAGENT = a.a(a.INVALID_PEERAGENT);
    public static final CreateChannelResult TOO_FREQUENTLY = a.a(a.TOO_FREQUENTLY);
    public static final CreateChannelResult SERVICE_LIMIT_REACHED = a.a(a.SERVICE_LIMIT_REACHED);
    public static final CreateChannelResult CHANNELID_MISMATCH = a.a(a.CHANNELID_MISMATCH);
    public static final CreateChannelResult NETWORK_FAILURE = a.a(a.NETWORK_FAILURE);
    public static final CreateChannelResult ACC_DORMANT_FAILURE = a.a(a.ACC_DORMANT_FAILURE);
    public static final CreateChannelResult UNKNOWN = a.a(a.UNKNOWN);

    /* loaded from: classes3.dex */
    public enum a {
        SUCCESS("Create channel success", 0),
        SUCCESS_PROTOCOL_DEFAULT("Create channel success with default protocol", 2),
        FAILURE("Create channel failed", 1),
        FATAL_ERROR("Common channel reused or OAF fatal error", 3),
        DEVICE_UNREACHABLE("Device unreachable", 10004),
        CHANNEL_ALREADY_EXIST("Channel already exist", 10005),
        PEERAGENT_NO_RESPONSE("PeerAgent no response", 10006),
        PEERAGENT_REJECTED("PeerAgent rejected", 10007),
        INVALID_PEERAGENT("Invalid peerAgent", 10008),
        TOO_FREQUENTLY("Send create channel request too frequently", 10009),
        SERVICE_LIMIT_REACHED("Service limit reached", 10010),
        CHANNELID_MISMATCH("Channel ID not matched", 10011),
        NETWORK_FAILURE("Network failure", 10012),
        ACC_DORMANT_FAILURE("Acc dormant failure", 10018),
        UNKNOWN("Unknown", -1);


        /* renamed from: a, reason: collision with root package name */
        private final String f28436a;

        /* renamed from: b, reason: collision with root package name */
        private final int f28437b;

        a(String str, int i10) {
            this.f28436a = str;
            this.f28437b = i10;
        }

        public static CreateChannelResult a(a aVar) {
            return CreateChannelResult.RESULT_MAP.get(Integer.valueOf(aVar.f28437b));
        }

        public static int b(a aVar) {
            return aVar.f28437b;
        }
    }

    private CreateChannelResult(a aVar, String str) {
        this.mCode = aVar;
        this.mDescription = str;
    }

    private static Map<Integer, CreateChannelResult> buildMap() {
        HashMap hashMap = new HashMap();
        for (a aVar : a.values()) {
            hashMap.put(Integer.valueOf(aVar.f28437b), new CreateChannelResult(aVar, aVar.f28436a));
        }
        return hashMap;
    }

    public static CreateChannelResult valueToStatus(int i10) {
        Map<Integer, CreateChannelResult> map = RESULT_MAP;
        if (map.containsKey(Integer.valueOf(i10))) {
            return map.get(Integer.valueOf(i10));
        }
        return UNKNOWN;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || CreateChannelResult.class != obj.getClass()) {
            return false;
        }
        CreateChannelResult createChannelResult = (CreateChannelResult) obj;
        if (Objects.equals(this.mCode, createChannelResult.mCode) && Objects.equals(this.mDescription, createChannelResult.mDescription)) {
            return true;
        }
        return false;
    }

    public int getValue() {
        return a.b(this.mCode);
    }

    public int hashCode() {
        return Objects.hash(this.mCode, this.mDescription);
    }

    public String toString() {
        return this.mDescription;
    }
}
