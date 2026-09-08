package com.android.incallui;

/* loaded from: classes.dex */
public final class OplusPhoneCapabilities {
    public static final int CAPABILITY_ADD_CALL = 131072;
    public static final int CAPABILITY_INVITE_PARTICIPANTS = 2097152;
    public static final int CAPABILITY_SUPPORTS_RTT_REMOTE = 268435456;
    public static final int DISCONNECT_FROM_CONFERENCE = 8192;
    public static final int GENERIC_CONFERENCE = 16384;
    public static final int HOLD = 1;
    public static final int MANAGE_CONFERENCE = 128;
    public static final int MERGE_CONFERENCE = 4;
    public static final int MTK_CAPABILITY_VIDEO_RINGTONE = 536870912;
    public static final int MUTE = 64;
    public static final int RESPOND_VIA_TEXT = 32;
    public static final int SEPARATE_FROM_CONFERENCE = 4096;
    public static final int SUPPORTS_VT_LOCAL = 256;
    public static final int SUPPORTS_VT_REMOTE = 512;
    public static final int SUPPORT_HOLD = 2;
    public static final int SWAP_CONFERENCE = 8;
    public static final int VOICE_PRIVACY = 65536;
    public static final int VoWIFI = 2048;

    private OplusPhoneCapabilities() {
    }

    public static boolean can(int i10, int i11) {
        if ((i10 & i11) != 0) {
            return true;
        }
        return false;
    }

    public static String toString(int i10) {
        StringBuilder sb = new StringBuilder();
        sb.append("[Capabilities:");
        if (can(i10, 1)) {
            sb.append(" HOLD");
        }
        if (can(i10, 2)) {
            sb.append(" SUPPORT_HOLD");
        }
        if (can(i10, 4)) {
            sb.append(" MERGE_CONFERENCE");
        }
        if (can(i10, 8)) {
            sb.append(" SWAP_CONFERENCE");
        }
        if (can(i10, 32)) {
            sb.append(" RESPOND_VIA_TEXT");
        }
        if (can(i10, 64)) {
            sb.append(" MUTE");
        }
        if (can(i10, 128)) {
            sb.append(" MANAGE_CONFERENCE");
        }
        if (can(i10, 256)) {
            sb.append(" SUPPORTS_VT_LOCAL");
        }
        if (can(i10, 512)) {
            sb.append(" SUPPORTS_VT_REMOTE");
        }
        if (can(i10, 2048)) {
            sb.append(" VoWIFI");
        }
        if ((65536 & i10) != 0) {
            sb.append(" VOICE_PRIVACY");
        }
        if (can(i10, 16384)) {
            sb.append(" GENERIC_CONFERENCE");
        }
        if (can(i10, 131072)) {
            sb.append(" CAPABILITY_ADD_CALL");
        }
        if (can(i10, CAPABILITY_INVITE_PARTICIPANTS)) {
            sb.append(" CAPABILITY_INVITE_PARTICIPANTS");
        }
        sb.append("]");
        return sb.toString();
    }
}
