package com.oplus.ocs.icdf;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public final class FindPeerAgentResult {
    public static final int FIND_PEERAGENT_FAILED = 1;
    public static final int FIND_PEER_DEVICE_NOT_CONNECTED = 10001;
    public static final int FIND_PEER_DUPLICATE_REQUEST = 10003;
    public static final int FIND_PEER_SERVICE_NOT_FOUND = 10002;
    public static final int FIND_PEER_SERVICE_NOT_REGISTERED = 10004;
    public static final int FIND_PEER_TIMEOUT = 10010;
    public static final int PEER_AGENT_FOUND = 0;
    private final a mCode;
    private final String mDescription;
    public static final Map<Integer, FindPeerAgentResult> RESULT_MAP = buildMap();
    public static final FindPeerAgentResult SUCCESS = a.a(a.SUCCESS);
    public static final FindPeerAgentResult FAILURE = a.a(a.FAILURE);
    public static final FindPeerAgentResult SERVICE_NOT_FOUND = a.a(a.SERVICE_NOT_FOUND);
    public static final FindPeerAgentResult SERVICE_NOT_REGISTERED = a.a(a.SERVICE_NOT_REGISTERED);
    public static final FindPeerAgentResult DEVICE_NOT_CONNECTED = a.a(a.DEVICE_NOT_CONNECTED);
    public static final FindPeerAgentResult TIME_OUT = a.a(a.TIME_OUT);
    public static final FindPeerAgentResult TOO_FREQUENTLY = a.a(a.TOO_FREQUENTLY);
    public static final FindPeerAgentResult UNKNOWN = a.a(a.UNKNOWN);

    /* loaded from: classes3.dex */
    public enum a {
        SUCCESS("Find peerAgent success", 0),
        FAILURE("Find peerAgent failed", 1),
        SERVICE_NOT_FOUND("Remote does not provide this service", 10002),
        SERVICE_NOT_REGISTERED("Service not registered, try findPeerAgent later", 10004),
        DEVICE_NOT_CONNECTED("Device not connected", 10001),
        TIME_OUT("Find peerAgent time out", 10010),
        TOO_FREQUENTLY("Send request too frequently", 10003),
        UNKNOWN("Unknown", -1);


        /* renamed from: a, reason: collision with root package name */
        private final String f28447a;

        /* renamed from: b, reason: collision with root package name */
        private final int f28448b;

        a(String str, int i10) {
            this.f28447a = str;
            this.f28448b = i10;
        }

        public static FindPeerAgentResult a(a aVar) {
            return FindPeerAgentResult.RESULT_MAP.get(Integer.valueOf(aVar.f28448b));
        }
    }

    private FindPeerAgentResult(a aVar, String str) {
        this.mDescription = str;
        this.mCode = aVar;
    }

    private static Map<Integer, FindPeerAgentResult> buildMap() {
        HashMap hashMap = new HashMap();
        for (a aVar : a.values()) {
            hashMap.put(Integer.valueOf(aVar.f28448b), new FindPeerAgentResult(aVar, aVar.f28447a));
        }
        return hashMap;
    }

    public static FindPeerAgentResult valueToStatus(int i10) {
        Map<Integer, FindPeerAgentResult> map = RESULT_MAP;
        if (map.containsKey(Integer.valueOf(i10))) {
            return map.get(Integer.valueOf(i10));
        }
        return UNKNOWN;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || FindPeerAgentResult.class != obj.getClass()) {
            return false;
        }
        FindPeerAgentResult findPeerAgentResult = (FindPeerAgentResult) obj;
        if (Objects.equals(this.mCode, findPeerAgentResult.mCode) && Objects.equals(this.mDescription, findPeerAgentResult.mDescription)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.mCode, this.mDescription);
    }

    public String toString() {
        return this.mDescription;
    }
}
