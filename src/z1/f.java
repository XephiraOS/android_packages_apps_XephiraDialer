package z1;

import android.content.Context;
import android.telecom.PhoneAccountHandle;
import com.android.contacts.voicemail.impl.OmtpEvents;
import com.android.contacts.voicemail.impl.c;
import t1.k;

/* compiled from: Vvm3EventHandler.java */
/* loaded from: classes.dex */
public class f {

    /* compiled from: Vvm3EventHandler.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f38268a;

        static {
            int[] iArr = new int[OmtpEvents.values().length];
            f38268a = iArr;
            try {
                iArr[OmtpEvents.CONFIG_REQUEST_STATUS_SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f38268a[OmtpEvents.CONFIG_ACTIVATING_SUBSEQUENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f38268a[OmtpEvents.CONFIG_DEFAULT_PIN_REPLACED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f38268a[OmtpEvents.CONFIG_STATUS_SMS_TIME_OUT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f38268a[OmtpEvents.DATA_NO_CONNECTION.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f38268a[OmtpEvents.DATA_NO_CONNECTION_CELLULAR_REQUIRED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f38268a[OmtpEvents.DATA_ALL_SOCKET_CONNECTION_FAILED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f38268a[OmtpEvents.DATA_SSL_INVALID_HOST_NAME.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f38268a[OmtpEvents.DATA_CANNOT_ESTABLISH_SSL_SESSION.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f38268a[OmtpEvents.DATA_IOE_ON_OPEN.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f38268a[OmtpEvents.DATA_CANNOT_RESOLVE_HOST_ON_NETWORK.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f38268a[OmtpEvents.DATA_BAD_IMAP_CREDENTIAL.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f38268a[OmtpEvents.DATA_AUTH_UNKNOWN_USER.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f38268a[OmtpEvents.DATA_AUTH_UNKNOWN_DEVICE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f38268a[OmtpEvents.DATA_AUTH_INVALID_PASSWORD.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f38268a[OmtpEvents.DATA_AUTH_MAILBOX_NOT_INITIALIZED.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f38268a[OmtpEvents.DATA_AUTH_SERVICE_NOT_PROVISIONED.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f38268a[OmtpEvents.DATA_AUTH_SERVICE_NOT_ACTIVATED.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f38268a[OmtpEvents.DATA_AUTH_USER_IS_BLOCKED.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f38268a[OmtpEvents.DATA_REJECTED_SERVER_RESPONSE.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f38268a[OmtpEvents.DATA_INVALID_INITIAL_SERVER_RESPONSE.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f38268a[OmtpEvents.DATA_SSL_EXCEPTION.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f38268a[OmtpEvents.VVM3_NEW_USER_SETUP_FAILED.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f38268a[OmtpEvents.VVM3_VMG_DNS_FAILURE.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f38268a[OmtpEvents.VVM3_SPG_DNS_FAILURE.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f38268a[OmtpEvents.VVM3_VMG_CONNECTION_FAILED.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f38268a[OmtpEvents.VVM3_SPG_CONNECTION_FAILED.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                f38268a[OmtpEvents.VVM3_VMG_TIMEOUT.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                f38268a[OmtpEvents.VVM3_SUBSCRIBER_PROVISIONED.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                f38268a[OmtpEvents.VVM3_SUBSCRIBER_BLOCKED.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                f38268a[OmtpEvents.VVM3_SUBSCRIBER_UNKNOWN.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
        }
    }

    public static boolean a(Context context, c.b bVar, OmtpEvents omtpEvents) {
        int i10 = a.f38268a[omtpEvents.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    if (i10 != 4) {
                        return false;
                    }
                    g(bVar, -9009);
                } else {
                    g(bVar, -100);
                }
            } else {
                if (f(context, bVar.b())) {
                    bVar.d(-100);
                } else {
                    bVar.d(0);
                }
                bVar.f(0).e(0).a();
            }
        } else {
            if (!f(context, bVar.b())) {
                return false;
            }
            g(bVar, -100);
        }
        return true;
    }

    public static boolean b(c.b bVar, OmtpEvents omtpEvents) {
        switch (a.f38268a[omtpEvents.ordinal()]) {
            case 5:
            case 6:
            case 7:
                g(bVar, -9004);
                return true;
            case 8:
            case 9:
            case 10:
                g(bVar, -9007);
                return true;
            case 11:
                g(bVar, -9001);
                return true;
            case 12:
                g(bVar, -9999);
                return true;
            case 13:
                g(bVar, -9991);
                return true;
            case 14:
                g(bVar, -9992);
                return true;
            case 15:
                g(bVar, -9993);
                return true;
            case 16:
                g(bVar, -9994);
                return true;
            case 17:
                g(bVar, -9995);
                return true;
            case 18:
                g(bVar, -9996);
                return true;
            case 19:
                g(bVar, -9998);
                return true;
            case 20:
            case 21:
            case 22:
                g(bVar, -9999);
                return true;
            default:
                return false;
        }
    }

    public static void c(Context context, com.android.contacts.voicemail.impl.b bVar, c.b bVar2, OmtpEvents omtpEvents) {
        boolean a10;
        int b10 = omtpEvents.b();
        if (b10 != 1) {
            if (b10 != 2) {
                if (b10 != 3) {
                    if (b10 != 4) {
                        k.d("Vvm3EventHandler", "invalid event type " + omtpEvents.b() + " for " + omtpEvents);
                        com.android.contacts.voicemail.impl.a.c(context, bVar, bVar2, omtpEvents);
                    }
                    a10 = e(bVar2, omtpEvents);
                } else {
                    a10 = d(bVar2, omtpEvents);
                }
            } else {
                a10 = b(bVar2, omtpEvents);
            }
        } else {
            a10 = a(context, bVar2, omtpEvents);
        }
        if (a10) {
            return;
        }
        com.android.contacts.voicemail.impl.a.c(context, bVar, bVar2, omtpEvents);
    }

    public static boolean d(c.b bVar, OmtpEvents omtpEvents) {
        return false;
    }

    public static boolean e(c.b bVar, OmtpEvents omtpEvents) {
        switch (a.f38268a[omtpEvents.ordinal()]) {
            case 23:
                g(bVar, -9994);
                return true;
            case 24:
                g(bVar, -9002);
                return true;
            case 25:
                g(bVar, -9003);
                return true;
            case 26:
                g(bVar, -9005);
                return true;
            case 27:
                g(bVar, -9006);
                return true;
            case 28:
                g(bVar, -9008);
                return true;
            case 29:
                g(bVar, -9996);
                return true;
            case 30:
                g(bVar, -9990);
                return true;
            case 31:
                g(bVar, -99);
                return true;
            default:
                return false;
        }
    }

    public static boolean f(Context context, PhoneAccountHandle phoneAccountHandle) {
        if (phoneAccountHandle == null) {
            H7.b.c("Vvm3EventHandler", "status editor has null phone account handle");
            return false;
        }
        if (g.k(context, phoneAccountHandle) == null) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void g(com.android.contacts.voicemail.impl.c.b r2, int r3) {
        /*
            r0 = -301(0xfffffffffffffed3, float:NaN)
            if (r3 == r0) goto L30
            r0 = -1
            if (r3 == r0) goto L30
            switch(r3) {
                case -9999: goto L2c;
                case -9998: goto L30;
                case -9997: goto L2c;
                case -9996: goto L30;
                case -9995: goto L30;
                case -9994: goto L30;
                case -9993: goto L30;
                case -9992: goto L30;
                case -9991: goto L30;
                case -9990: goto L30;
                case -9989: goto L2c;
                default: goto La;
            }
        La:
            switch(r3) {
                case -9009: goto L28;
                case -9008: goto L30;
                case -9007: goto L2c;
                case -9006: goto L30;
                case -9005: goto L30;
                case -9004: goto L2c;
                case -9003: goto L30;
                case -9002: goto L30;
                case -9001: goto L2c;
                default: goto Ld;
            }
        Ld:
            switch(r3) {
                case -103: goto L30;
                case -102: goto L30;
                case -101: goto L30;
                case -100: goto L30;
                case -99: goto L30;
                default: goto L10;
            }
        L10:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "unknown error code: "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            java.lang.String r0 = "Vvm3EventHandler"
            t1.k.d(r0, r3)
            goto L33
        L28:
            r2.f(r3)
            goto L33
        L2c:
            r2.e(r3)
            goto L33
        L30:
            r2.d(r3)
        L33:
            r2.a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: z1.f.g(com.android.contacts.voicemail.impl.c$b, int):void");
    }
}
