package F6;

import android.content.UriMatcher;
import com.android.incallui.OplusNumberMarkUtils;
import com.coui.appcompat.hapticfeedback.COUIHapticFeedbackConstants;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: SdkProviderUtils.kt */
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final a f1001a = new a(null);

    /* compiled from: SdkProviderUtils.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public final void a(UriMatcher matcher) {
            i.f(matcher, "matcher");
            matcher.addURI("com.coloros.provider.BlackListProvider", OplusNumberMarkUtils.OplusBlacklist.BLACKLIST_TABLE, 300);
            matcher.addURI("com.coloros.provider.BlackListProvider", "bl_list/prefixblacknumber", 613);
            matcher.addURI("com.coloros.provider.BlackListProvider", "bl_list/sms_and_call_block/*", COUIHapticFeedbackConstants.KEYBOARD_TOUCH_FEEDBACK);
            matcher.addURI("com.coloros.provider.BlackListProvider", "bl_list/black_or_area/*", 603);
            matcher.addURI("com.coloros.provider.BlackListProvider", "bl_list/list_type_white", COUIHapticFeedbackConstants.GRANULAR_SHORT_VIBRATE);
            matcher.addURI("com.coloros.provider.BlackListProvider", "bl_list/number/*", COUIHapticFeedbackConstants.SHORT_VIBRATE);
            matcher.addURI("com.coloros.provider.BlackListProvider", "bl_list/defaultnumber/*", 304);
            matcher.addURI("com.coloros.provider.BlackListProvider", "bl_list/*", 311);
            matcher.addURI("com.coloros.provider.BlackListProvider", "oppo_query_blacklist_as_selelction", 314);
            matcher.addURI("com.coloros.provider.BlackListProvider", "oppo_query_whitelist_as_selelction", 607);
            matcher.addURI("com.coloros.provider.BlackListProvider", "kw_list", 601);
            matcher.addURI("com.coloros.provider.BlackListProvider", "area_list", 602);
            matcher.addURI("com.coloros.provider.BlackListProvider", "bl_area_for_country", 612);
            matcher.addURI("com.coloros.provider.BlackListProvider", "call_record_custom_list", 604);
            matcher.addURI("com.coloros.provider.BlackListProvider", "call_record_custom_list/number/*", 605);
            matcher.addURI("com.coloros.provider.BlackListProvider", "pseudo_base_station", 606);
            matcher.addURI("com.coloros.provider.BlackListProvider", "romupdate_bl_list", 609);
            matcher.addURI("com.coloros.provider.BlackListProvider", "romupdate_kw_list", 611);
            matcher.addURI("com.coloros.provider.BlackListProvider", "call_filter", 615);
        }

        public final String b() {
            return "com.oplus.contacts.blacklistcontactsprovider";
        }

        public final String c() {
            return "customize_calls";
        }

        public final String d() {
            return "customize_dual_calls";
        }

        public final String e() {
            return "content://com.oplus.smartdrive.data.DataProvider/ride_mode_settings";
        }

        public final String f() {
            return "content://com.color.provider.SafeProvider";
        }

        public final String g() {
            return "content://com.coloros.securityguard.SecurityEventProvider";
        }

        public final String h() {
            return "content://com.oplus.smartdrive.data.DataProvider/smart_drive_settings";
        }

        public final String i() {
            return "oppo_recipient";
        }

        public final String j() {
            return "oppo_unread_count";
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public static final void a(UriMatcher uriMatcher) {
        f1001a.a(uriMatcher);
    }

    public static final String b() {
        return f1001a.b();
    }

    public static final String c() {
        return f1001a.c();
    }

    public static final String d() {
        return f1001a.d();
    }

    public static final String e() {
        return f1001a.e();
    }

    public static final String f() {
        return f1001a.f();
    }

    public static final String g() {
        return f1001a.g();
    }

    public static final String h() {
        return f1001a.h();
    }

    public static final String i() {
        return f1001a.i();
    }

    public static final String j() {
        return f1001a.j();
    }
}
