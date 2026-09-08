package z1;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Network;
import android.os.Bundle;
import android.telecom.PhoneAccountHandle;
import android.text.TextUtils;
import com.android.contacts.voicemail.impl.ActivationTask;
import com.android.contacts.voicemail.impl.OmtpEvents;
import com.android.contacts.voicemail.impl.c;
import com.android.contacts.voicemail.impl.imap.ImapHelper;
import com.android.contacts.voicemail.impl.mail.MessagingException;
import com.android.contacts.voicemail.impl.protocol.Vvm3Subscriber;
import com.android.contacts.voicemail.impl.sync.VvmNetworkRequest;
import com.android.incallui.OplusPhoneUtils;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Locale;

/* compiled from: Vvm3Protocol.java */
/* loaded from: classes.dex */
public class g extends AbstractC1729d {
    public static String j(int i10) {
        return String.format(Locale.US, "%010d", Long.valueOf(Math.abs(new SecureRandom().nextLong()))).substring(0, i10);
    }

    public static String k(Context context, PhoneAccountHandle phoneAccountHandle) {
        return new D1.c(context, phoneAccountHandle).g("default_old_pin");
    }

    public static String l(A1.e eVar) {
        String c10 = eVar.c();
        try {
            String substring = c10.substring(0, c10.indexOf(64));
            if (substring.length() < 4) {
                H7.b.c("Vvm3Protocol", "unable to extract number from IMAP username");
                return null;
            }
            return OplusPhoneUtils.DeviceState.LOCK_DEVICE + substring.substring(substring.length() - 4);
        } catch (StringIndexOutOfBoundsException unused) {
            H7.b.c("Vvm3Protocol", "unable to extract number from IMAP username");
            return null;
        }
    }

    public static int m(Context context, PhoneAccountHandle phoneAccountHandle) {
        String[] split = new D1.c(context, phoneAccountHandle).h("pw_len", "").split("-");
        if (split.length == 2) {
            try {
                return Integer.parseInt(split[0]);
            } catch (NumberFormatException unused) {
            }
        }
        return 6;
    }

    public static boolean n(Context context, PhoneAccountHandle phoneAccountHandle) {
        if (k(context, phoneAccountHandle) != null) {
            return true;
        }
        return false;
    }

    public static void o(Context context, PhoneAccountHandle phoneAccountHandle, String str) {
        new D1.c(context, phoneAccountHandle).d().c("default_old_pin", str).a();
    }

    public static boolean p(Context context, PhoneAccountHandle phoneAccountHandle, ImapHelper imapHelper, A1.e eVar) {
        String l10 = l(eVar);
        if (l10 == null) {
            H7.b.e("Vvm3Protocol", "cannot generate default PIN");
            return false;
        }
        if (n(context, phoneAccountHandle)) {
            H7.b.e("Vvm3Protocol", "PIN already set");
            return true;
        }
        String j10 = j(m(context, phoneAccountHandle));
        if (imapHelper.e(l10, j10) == 0) {
            o(context, phoneAccountHandle, j10);
            imapHelper.U(OmtpEvents.CONFIG_DEFAULT_PIN_REPLACED);
        }
        H7.b.e("Vvm3Protocol", "new user: PIN set");
        return true;
    }

    @Override // z1.AbstractC1729d
    public A1.c a(Context context, PhoneAccountHandle phoneAccountHandle, short s10, String str) {
        return new A1.g(context, phoneAccountHandle, s10, str);
    }

    @Override // z1.AbstractC1729d
    public String b(String str) {
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -2102887634:
                if (str.equals("XCLOSE_NUT")) {
                    c10 = 0;
                    break;
                }
                break;
            case -386920792:
                if (str.equals("XCHANGE_TUI_PWD PWD=%1$s OLD_PWD=%2$s")) {
                    c10 = 1;
                    break;
                }
                break;
            case -203105431:
                if (str.equals("XCHANGE_VM_LANG LANG=%1$s")) {
                    c10 = 2;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                return "CLOSE_NUT";
            case 1:
                return "CHANGE_TUI_PWD PWD=%1$s OLD_PWD=%2$s";
            case 2:
                return "CHANGE_VM_LANG Lang=%1$s";
            default:
                return super.b(str);
        }
    }

    @Override // z1.AbstractC1729d
    public void c(Context context, com.android.contacts.voicemail.impl.b bVar, c.b bVar2, OmtpEvents omtpEvents) {
        f.c(context, bVar, bVar2, omtpEvents);
    }

    @Override // z1.AbstractC1729d
    public void e(com.android.contacts.voicemail.impl.b bVar, PendingIntent pendingIntent) {
        H7.b.e("Vvm3Protocol", "Activating");
        bVar.x(pendingIntent);
    }

    @Override // z1.AbstractC1729d
    public void g(ActivationTask activationTask, PhoneAccountHandle phoneAccountHandle, com.android.contacts.voicemail.impl.b bVar, c.b bVar2, A1.e eVar, Bundle bundle) {
        H7.b.e("Vvm3Protocol", "start vvm3 provisioning");
        if ("U".equals(eVar.d())) {
            H7.b.e("Vvm3Protocol", "Provisioning status: Unknown");
            if ("2".equals(eVar.e())) {
                H7.b.e("Vvm3Protocol", "Self provisioning available, subscribing");
                new Vvm3Subscriber(activationTask, phoneAccountHandle, bVar, bVar2, bundle).j();
                return;
            } else {
                bVar.r(bVar2, OmtpEvents.VVM3_SUBSCRIBER_UNKNOWN);
                return;
            }
        }
        if ("N".equals(eVar.d())) {
            H7.b.e("Vvm3Protocol", "setting up new user");
            eVar.i(new D1.c(bVar.g(), phoneAccountHandle).d()).a();
            q(activationTask, phoneAccountHandle, bVar, bVar2, eVar);
        } else if ("P".equals(eVar.d())) {
            H7.b.e("Vvm3Protocol", "User provisioned but not activated, disabling VVM");
            C1.b.d(bVar.g(), phoneAccountHandle, false);
        } else if ("B".equals(eVar.d())) {
            H7.b.e("Vvm3Protocol", "User blocked");
            bVar.r(bVar2, OmtpEvents.VVM3_SUBSCRIBER_BLOCKED);
        }
    }

    @Override // z1.AbstractC1729d
    public boolean h() {
        return true;
    }

    @Override // z1.AbstractC1729d
    public Bundle i(com.android.contacts.voicemail.impl.b bVar, String str, Bundle bundle) {
        if (!"UNRECOGNIZED".equals(str) || !"STATUS".equals(bundle.getString("cmd"))) {
            return null;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("st", "U");
        bundle2.putString("rc", "2");
        String n10 = bVar.n("default_vmg_url");
        if (TextUtils.isEmpty(n10)) {
            H7.b.c("Vvm3Protocol", "Unable to translate STATUS SMS: VMG URL is not set in config");
            return null;
        }
        bundle2.putString("vmg_url", n10);
        H7.b.e("Vvm3Protocol", "UNRECOGNIZED?cmd=STATUS translated into unprovisioned STATUS SMS");
        return bundle2;
    }

    public final void q(ActivationTask activationTask, PhoneAccountHandle phoneAccountHandle, com.android.contacts.voicemail.impl.b bVar, c.b bVar2, A1.e eVar) {
        ImapHelper imapHelper;
        try {
            VvmNetworkRequest.b a10 = VvmNetworkRequest.a(bVar, phoneAccountHandle, bVar2);
            try {
                Network a11 = a10.a();
                H7.b.e("Vvm3Protocol", "new user: network available");
                try {
                    imapHelper = new ImapHelper(bVar.g(), phoneAccountHandle, a11, bVar2);
                } catch (ImapHelper.InitializingException | MessagingException | IOException e10) {
                    bVar.r(bVar2, OmtpEvents.VVM3_NEW_USER_SETUP_FAILED);
                    activationTask.j();
                    H7.b.c("Vvm3Protocol", e10.toString());
                }
                try {
                    if (Locale.getDefault().getLanguage().equals(new Locale("es").getLanguage())) {
                        imapHelper.f("6");
                    } else {
                        imapHelper.f("5");
                    }
                    H7.b.e("Vvm3Protocol", "new user: language set");
                    if (p(bVar.g(), phoneAccountHandle, imapHelper, eVar)) {
                        imapHelper.l();
                        H7.b.e("Vvm3Protocol", "new user: NUT closed");
                        bVar.x(null);
                    }
                    imapHelper.close();
                    a10.close();
                } catch (Throwable th) {
                    try {
                        imapHelper.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } finally {
            }
        } catch (VvmNetworkRequest.RequestFailedException unused) {
            bVar.r(bVar2, OmtpEvents.DATA_NO_CONNECTION_CELLULAR_REQUIRED);
            activationTask.j();
        }
    }

    @Override // z1.AbstractC1729d
    public void f(com.android.contacts.voicemail.impl.b bVar) {
    }
}
