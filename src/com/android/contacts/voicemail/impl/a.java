package com.android.contacts.voicemail.impl;

import android.content.Context;
import com.android.contacts.voicemail.impl.c;
import t1.k;

/* compiled from: DefaultOmtpEventHandler.java */
/* loaded from: classes.dex */
public class a {

    /* compiled from: DefaultOmtpEventHandler.java */
    /* renamed from: com.android.contacts.voicemail.impl.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0176a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18026a;

        static {
            int[] iArr = new int[OmtpEvents.values().length];
            f18026a = iArr;
            try {
                iArr[OmtpEvents.CONFIG_DEFAULT_PIN_REPLACED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18026a[OmtpEvents.CONFIG_REQUEST_STATUS_SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18026a[OmtpEvents.CONFIG_PIN_SET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f18026a[OmtpEvents.CONFIG_ACTIVATING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f18026a[OmtpEvents.CONFIG_ACTIVATING_SUBSEQUENT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f18026a[OmtpEvents.CONFIG_SERVICE_NOT_AVAILABLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f18026a[OmtpEvents.CONFIG_STATUS_SMS_TIME_OUT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f18026a[OmtpEvents.DATA_IMAP_OPERATION_STARTED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f18026a[OmtpEvents.DATA_IMAP_OPERATION_COMPLETED.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f18026a[OmtpEvents.DATA_NO_CONNECTION.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f18026a[OmtpEvents.DATA_NO_CONNECTION_CELLULAR_REQUIRED.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f18026a[OmtpEvents.DATA_INVALID_PORT.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f18026a[OmtpEvents.DATA_CANNOT_RESOLVE_HOST_ON_NETWORK.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f18026a[OmtpEvents.DATA_SSL_INVALID_HOST_NAME.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f18026a[OmtpEvents.DATA_CANNOT_ESTABLISH_SSL_SESSION.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f18026a[OmtpEvents.DATA_IOE_ON_OPEN.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f18026a[OmtpEvents.DATA_GENERIC_IMAP_IOE.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f18026a[OmtpEvents.DATA_BAD_IMAP_CREDENTIAL.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f18026a[OmtpEvents.DATA_AUTH_UNKNOWN_USER.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f18026a[OmtpEvents.DATA_AUTH_UNKNOWN_DEVICE.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f18026a[OmtpEvents.DATA_AUTH_INVALID_PASSWORD.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f18026a[OmtpEvents.DATA_AUTH_MAILBOX_NOT_INITIALIZED.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f18026a[OmtpEvents.DATA_AUTH_SERVICE_NOT_PROVISIONED.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f18026a[OmtpEvents.DATA_AUTH_SERVICE_NOT_ACTIVATED.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f18026a[OmtpEvents.DATA_AUTH_USER_IS_BLOCKED.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f18026a[OmtpEvents.DATA_REJECTED_SERVER_RESPONSE.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f18026a[OmtpEvents.DATA_INVALID_INITIAL_SERVER_RESPONSE.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                f18026a[OmtpEvents.DATA_MAILBOX_OPEN_FAILED.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                f18026a[OmtpEvents.DATA_SSL_EXCEPTION.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                f18026a[OmtpEvents.DATA_ALL_SOCKET_CONNECTION_FAILED.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                f18026a[OmtpEvents.NOTIFICATION_IN_SERVICE.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                f18026a[OmtpEvents.NOTIFICATION_SERVICE_LOST.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                f18026a[OmtpEvents.OTHER_SOURCE_REMOVED.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
        }
    }

    public static void a(Context context, c.b bVar, OmtpEvents omtpEvents) {
        switch (C0176a.f18026a[omtpEvents.ordinal()]) {
            case 1:
            case 2:
            case 3:
                bVar.d(0).f(0).a();
                return;
            case 4:
                bVar.d(3).f(0).e(0).a();
                return;
            case 5:
                bVar.d(0).f(0).e(0).a();
                return;
            case 6:
                bVar.d(4).a();
                return;
            case 7:
                bVar.d(4).a();
                return;
            default:
                k.d("DefErrorCodeHandler", "invalid configuration event " + omtpEvents);
                return;
        }
    }

    public static void b(Context context, c.b bVar, OmtpEvents omtpEvents) {
        switch (C0176a.f18026a[omtpEvents.ordinal()]) {
            case 8:
            case 9:
                bVar.e(0).a();
                return;
            case 10:
                bVar.e(1).a();
                return;
            case 11:
                bVar.e(2).a();
                return;
            case 12:
                bVar.e(3).a();
                return;
            case 13:
                bVar.e(6).a();
                return;
            case 14:
            case 15:
            case 16:
            case 17:
                bVar.e(4).a();
                return;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
                bVar.e(3).a();
                return;
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
                bVar.e(5).a();
                return;
            default:
                k.d("DefErrorCodeHandler", "invalid data channel event " + omtpEvents);
                return;
        }
    }

    public static void c(Context context, b bVar, c.b bVar2, OmtpEvents omtpEvents) {
        int b10 = omtpEvents.b();
        if (b10 != 1) {
            if (b10 != 2) {
                if (b10 != 3) {
                    if (b10 != 4) {
                        k.d("DefErrorCodeHandler", "invalid event type " + omtpEvents.b() + " for " + omtpEvents);
                        return;
                    }
                    e(context, bVar2, omtpEvents);
                    return;
                }
                d(context, bVar, bVar2, omtpEvents);
                return;
            }
            b(context, bVar2, omtpEvents);
            return;
        }
        a(context, bVar2, omtpEvents);
    }

    public static void d(Context context, b bVar, c.b bVar2, OmtpEvents omtpEvents) {
        int i10 = C0176a.f18026a[omtpEvents.ordinal()];
        if (i10 != 31) {
            if (i10 != 32) {
                k.d("DefErrorCodeHandler", "invalid notification channel event " + omtpEvents);
                return;
            }
            bVar2.f(1);
            if (bVar.s()) {
                bVar2.e(2);
            }
            bVar2.a();
            return;
        }
        bVar2.f(0).e(0).a();
    }

    public static void e(Context context, c.b bVar, OmtpEvents omtpEvents) {
        if (C0176a.f18026a[omtpEvents.ordinal()] != 33) {
            k.d("DefErrorCodeHandler", "invalid other event " + omtpEvents);
            return;
        }
        bVar.d(1).f(1).e(1).a();
    }
}
