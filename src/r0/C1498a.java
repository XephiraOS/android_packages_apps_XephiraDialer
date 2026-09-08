package r0;

import android.content.Intent;
import com.android.incallui.OplusNumberMarkUtils;
import com.oplus.foundation.util.OsUtils;

/* compiled from: Actions.kt */
/* renamed from: r0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1498a {

    /* renamed from: A, reason: collision with root package name */
    public static String f36238A;

    /* renamed from: B, reason: collision with root package name */
    public static String f36239B;

    /* renamed from: C, reason: collision with root package name */
    public static final String f36240C;

    /* renamed from: D, reason: collision with root package name */
    public static final String f36241D;

    /* renamed from: a, reason: collision with root package name */
    public static final C1498a f36242a = new C1498a();

    /* renamed from: b, reason: collision with root package name */
    public static final String f36243b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f36244c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f36245d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f36246e;

    /* renamed from: f, reason: collision with root package name */
    public static final String f36247f;

    /* renamed from: g, reason: collision with root package name */
    public static final String f36248g;

    /* renamed from: h, reason: collision with root package name */
    public static final String f36249h;

    /* renamed from: i, reason: collision with root package name */
    public static final String f36250i;

    /* renamed from: j, reason: collision with root package name */
    public static final String f36251j;

    /* renamed from: k, reason: collision with root package name */
    public static final String f36252k;

    /* renamed from: l, reason: collision with root package name */
    public static final String f36253l;

    /* renamed from: m, reason: collision with root package name */
    public static final String f36254m;

    /* renamed from: n, reason: collision with root package name */
    public static final String f36255n;

    /* renamed from: o, reason: collision with root package name */
    public static final String f36256o;

    /* renamed from: p, reason: collision with root package name */
    public static String f36257p;

    /* renamed from: q, reason: collision with root package name */
    public static String f36258q;

    /* renamed from: r, reason: collision with root package name */
    public static String f36259r;

    /* renamed from: s, reason: collision with root package name */
    public static String f36260s;

    /* renamed from: t, reason: collision with root package name */
    public static String f36261t;

    /* renamed from: u, reason: collision with root package name */
    public static String f36262u;

    /* renamed from: v, reason: collision with root package name */
    public static String f36263v;

    /* renamed from: w, reason: collision with root package name */
    public static String f36264w;

    /* renamed from: x, reason: collision with root package name */
    public static String f36265x;

    /* renamed from: y, reason: collision with root package name */
    public static String f36266y;

    /* renamed from: z, reason: collision with root package name */
    public static String f36267z;

    static {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        String str21;
        String str22;
        String str23;
        String str24;
        String str25;
        String str26;
        String str27;
        String str28;
        OsUtils osUtils = OsUtils.f28275a;
        if (osUtils.j()) {
            str = "oplus.intent.action.FIRST_AID_INFORMATION_DISPLAY";
        } else {
            str = "oppo.intent.action.FIRST_AID_INFORMATION_DISPLAY";
        }
        f36243b = str;
        if (osUtils.j()) {
            str2 = "oplus.intent.action.EMERGENCY_CONTACTS_SETTING";
        } else {
            str2 = "oppo.intent.action.EMERGENCY_CONTACTS_SETTING";
        }
        f36244c = str2;
        if (osUtils.j()) {
            str3 = "oplus.intent.action.NEW_BLOCK_CALL_LOG";
        } else {
            str3 = "oppo.intent.action.NEW_BLOCK_CALL_LOG";
        }
        f36245d = str3;
        String str29 = "";
        if (osUtils.j()) {
            str4 = "";
        } else {
            str4 = "com.oppo.setupwizard.DIRECT_TO_LAUNCHER";
        }
        f36246e = str4;
        if (osUtils.j()) {
            str5 = "oplus.intent.action.ROM_UPDATE_CONFIG_TEST";
        } else {
            str5 = "oppo.intent.action.ROM_UPDATE_CONFIG_TEST";
        }
        f36247f = str5;
        if (osUtils.j()) {
            str6 = "oplus.intent.action.ROM_UPDATE_CONFIG_SUCCESS";
        } else {
            str6 = "oppo.intent.action.ROM_UPDATE_CONFIG_SUCCESS";
        }
        f36248g = str6;
        if (osUtils.j()) {
            str7 = "oplus.intent.action.BLACKLIST_DATA_CHANGE";
        } else {
            str7 = "oppo.intent.action.BLACKLIST_DATA_CHANGE";
        }
        f36249h = str7;
        if (!osUtils.j()) {
            str29 = "com.coloros.lockassistant";
        }
        f36250i = str29;
        if (osUtils.j()) {
            str8 = "oplus.intent.action.blacklist.view_keyword_list";
        } else {
            str8 = "oppo.intent.action.blacklist.view_keyword_list";
        }
        f36251j = str8;
        if (osUtils.j()) {
            str9 = "oplus.intent.action.anti.harassment.call";
        } else {
            str9 = "oppo.intent.action.anti.harassment.call";
        }
        f36252k = str9;
        if (osUtils.j()) {
            str10 = "oplus.intent.action.blacklist.blocked_calllog_sms_list";
        } else {
            str10 = "oppo.intent.action.blacklist.blocked_calllog_sms_list";
        }
        f36253l = str10;
        if (osUtils.j()) {
            str11 = "com.oplus.agenda.contacts.DATA_CHANGE";
        } else {
            str11 = "com.oppo.agenda.contacts.DATA_CHANGE";
        }
        f36254m = str11;
        if (osUtils.j()) {
            str12 = "com.oplus.contacts.INSERT_CONTACTS";
        } else {
            str12 = OplusNumberMarkUtils.OplusContact.OPLUS_INSERT_CONTACTS_ACTION;
        }
        f36255n = str12;
        if (osUtils.j()) {
            str13 = "oplus.intent.insertcontact_resolver";
        } else {
            str13 = "oppo.intent.insertcontact_resolver";
        }
        f36256o = str13;
        if (OsUtils.m()) {
            str14 = "oplus.intent.action.OPLUS_OTA_UPDATE_SUCCESSED";
        } else {
            str14 = "oppo.intent.action.OPPO_OTA_UPDATE_SUCCESSED";
        }
        f36257p = str14;
        if (OsUtils.m()) {
            str15 = "oplus.intent.action.OPLUS_RECOVER_UPDATE_SUCCESSED";
        } else {
            str15 = "oppo.intent.action.OPPO_RECOVER_UPDATE_SUCCESSED";
        }
        f36258q = str15;
        if (OsUtils.m()) {
            str16 = "oplus.intent.action.BOOT_COMPLETED";
        } else {
            str16 = "oppo.intent.action.BOOT_COMPLETED";
        }
        f36259r = str16;
        if (OsUtils.m()) {
            str17 = "com.oplus.otaui.action.enterprise.entry";
        } else {
            str17 = "com.oppo.otaui.action.enterprise.entry";
        }
        f36260s = str17;
        if (OsUtils.m()) {
            str18 = "com.oplus.engineer.OpenHideApp";
        } else {
            str18 = "com.oppo.engineer.OpenHideApp";
        }
        f36261t = str18;
        if (OsUtils.m()) {
            str19 = "oplus.intent.action.SET_DEFAULT_APP";
        } else {
            str19 = "oppo.intent.action.SET_DEFAULT_APP";
        }
        f36262u = str19;
        if (OsUtils.m()) {
            str20 = "oplus.intent.action.CANCEL_MASSIVE_HARASSING_CALLS";
        } else {
            str20 = "oppo.intent.action.CANCEL_MASSIVE_HARASSING_CALLS";
        }
        f36263v = str20;
        if (OsUtils.m()) {
            str21 = "oplus.intent.action.SUBINFO_STATE_CHANGE";
        } else {
            str21 = "oppo.intent.action.SUBINFO_STATE_CHANGE";
        }
        f36264w = str21;
        if (OsUtils.m()) {
            str22 = "oplus.intent.action.SIM_HOTSWAP_STATE_CHANGE";
        } else {
            str22 = "oppo.intent.action.SIM_HOTSWAP_STATE_CHANGE";
        }
        f36265x = str22;
        if (OsUtils.m()) {
            str23 = "oplus.intent.action.VOLTE_STATUS_CHANGE";
        } else {
            str23 = "oppo.intent.action.VOLTE_STATUS_CHANGE";
        }
        f36266y = str23;
        if (OsUtils.m()) {
            str24 = "android.settings.OPLUS_REGION_CHANGED";
        } else {
            str24 = "android.settings.OPPO_REGION_CHANGED";
        }
        f36267z = str24;
        if (OsUtils.m()) {
            str25 = "com.oplus.engineermode.EngineerModeMain";
        } else {
            str25 = "com.oppo.engineermode.EngineerModeMain";
        }
        f36238A = str25;
        if (OsUtils.m()) {
            str26 = "oplus.bluetooth.pbapclient.SELECT_DEVICE";
        } else {
            str26 = "oppo.bluetooth.pbapclient.SELECT_DEVICE";
        }
        f36239B = str26;
        if (OsUtils.m()) {
            str27 = "oplus.intent.action.SHOW_DEEP_PROTECT_APPS";
        } else {
            str27 = "oppo.intent.action.SHOW_DEEP_PROTECT_APPS";
        }
        f36240C = str27;
        if (OsUtils.m()) {
            str28 = "android.intent.action.RINGTONE_PICKER";
        } else {
            str28 = "oppo.intent.action.ACTION_MUSIC_SELECT";
        }
        f36241D = str28;
    }

    public static final Intent a(CharSequence charSequence, long j10, long j11) {
        if (OsUtils.f28275a.j()) {
            return new Intent();
        }
        Intent intent = new Intent("coloros.intent.action.aicall.ASSISTANT_HISTORY");
        intent.putExtra("number", charSequence);
        intent.putExtra("timestamp", j10);
        intent.putExtra("duration", j11);
        return intent;
    }
}
