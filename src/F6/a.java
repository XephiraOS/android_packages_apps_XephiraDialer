package F6;

import android.content.ComponentName;
import android.content.Intent;
import java.util.List;
import kotlin.collections.n;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: SdkActionUtils.kt */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final C0017a f997a = new C0017a(null);

    /* compiled from: SdkActionUtils.kt */
    /* renamed from: F6.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0017a {
        public C0017a() {
        }

        public final Intent a(long j10) {
            Intent intent = new Intent("coloros.intent.action.BLOCK_MESSAGE");
            intent.putExtra("oppo_msg_undiscard", false);
            intent.putExtra("block_threads_flag", true);
            intent.setComponent(new ComponentName("com.android.mms", "com.oppo.mms.activity.BlockedMessageActivity"));
            if (j10 == 0) {
                intent.putExtra("oppo_new_message", true);
            }
            return intent;
        }

        public final Intent b() {
            Intent intent = new Intent("com.coloros.security.BROADCAST_SECURITY");
            intent.setComponent(new ComponentName("com.coloros.securityguard", "com.coloros.securityguard.communication.SecurityBroadcastReciever"));
            return intent;
        }

        public final Intent c() {
            Intent intent = new Intent("coloros.intent.action.PUSH_BLOCK_MESSAGE");
            intent.setComponent(new ComponentName("com.android.mms", "com.ted.push.PushBlockedMessageListActivity"));
            return intent;
        }

        public final String d() {
            return "oppo.intent.action.OPPO_FOR_BLACK_LIST";
        }

        public final String e() {
            return "oplus.intent.action.BLACKLIST_DATA_CHANGE";
        }

        public final String f() {
            return "oppo.intent.action.BLOCK_MESSAGE_SETTING";
        }

        public final String g() {
            return "oplus.intent.action.incallui.cancel_intercept_notify";
        }

        public final List<String> h() {
            List<String> b10;
            b10 = n.b("oplus.intent.action.CANCEL_MASSIVE_HARASSING_CALLS");
            return b10;
        }

        public final String i() {
            return "oplus.intent.action.SUBINFO_STATE_CHANGE";
        }

        public final String j() {
            return "android.settings.OPLUS_REGION_CHANGED";
        }

        public final String k() {
            return "oplus.intent.action.SET_DEFAULT_APP";
        }

        public final String l() {
            return "oplus.intent.action.SIM_HOTSWAP_STATE_CHANGE";
        }

        public final String m() {
            return "com.oppo.dialer.VIEW_CALLS";
        }

        public final boolean n(String str) {
            if (!i.b(str, "oppo.intent.action.BLOCK_CALLS") && !i.b(str, "oplus.intent.action.BLOCK_CALLS")) {
                return false;
            }
            return true;
        }

        public final boolean o(String str) {
            if (!i.b(str, "oppo.intent.action.blacklist.blocked_calllog_sms_list") && !i.b(str, "oplus.intent.action.blacklist.blocked_calllog_sms_list")) {
                return false;
            }
            return true;
        }

        public final boolean p(String str) {
            if (!i.b(str, "oplusos.intent.action.change.over.restore.end") && !i.b(str, "oplus.intent.action.change.over.restore.end")) {
                return false;
            }
            return true;
        }

        public final boolean q(String str) {
            return i.b(str, "oplus.intent.action.FAKE_BS_BLOCKED");
        }

        public final boolean r(String str) {
            return i.b(str, "oplus.intent.action.SUBINFO_STATE_CHANGE");
        }

        public final boolean s(String str) {
            return i.b(str, "android.settings.OPLUS_REGION_CHANGED");
        }

        public final boolean t(String str) {
            if (!i.b(str, "oppo.intent.action.blacklist.view_white_list") && !i.b(str, "oplus.intent.action.blacklist.view_white_list")) {
                return false;
            }
            return true;
        }

        public /* synthetic */ C0017a(f fVar) {
            this();
        }
    }

    public static final Intent a(long j10) {
        return f997a.a(j10);
    }

    public static final Intent b() {
        return f997a.b();
    }

    public static final Intent c() {
        return f997a.c();
    }

    public static final String d() {
        return f997a.d();
    }

    public static final String e() {
        return f997a.e();
    }

    public static final String f() {
        return f997a.f();
    }

    public static final String g() {
        return f997a.g();
    }

    public static final List<String> h() {
        return f997a.h();
    }

    public static final String i() {
        return f997a.i();
    }

    public static final String j() {
        return f997a.k();
    }

    public static final String k() {
        return f997a.l();
    }

    public static final String l() {
        return f997a.m();
    }

    public static final boolean m(String str) {
        return f997a.n(str);
    }

    public static final boolean n(String str) {
        return f997a.o(str);
    }

    public static final boolean o(String str) {
        return f997a.q(str);
    }

    public static final boolean p(String str) {
        return f997a.r(str);
    }

    public static final boolean q(String str) {
        return f997a.s(str);
    }

    public static final boolean r(String str) {
        return f997a.t(str);
    }
}
