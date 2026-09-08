package R0;

import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.android.contacts.compat.data.f;
import com.android.incallui.OplusNumberMarkUtils;
import com.oplus.backup.sdk.common.utils.Constants;

/* compiled from: ContactsUris.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static final Uri f3214a;

    /* renamed from: b, reason: collision with root package name */
    public static final Uri f3215b;

    /* renamed from: c, reason: collision with root package name */
    public static final Uri f3216c;

    /* renamed from: d, reason: collision with root package name */
    public static final Uri f3217d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f3218e;

    /* renamed from: f, reason: collision with root package name */
    public static final Uri f3219f;

    /* renamed from: g, reason: collision with root package name */
    public static final Uri f3220g;

    /* renamed from: h, reason: collision with root package name */
    public static final Uri f3221h;

    /* renamed from: i, reason: collision with root package name */
    public static final Uri f3222i;

    /* renamed from: j, reason: collision with root package name */
    public static final Uri f3223j;

    /* renamed from: k, reason: collision with root package name */
    public static final String f3224k;

    /* renamed from: l, reason: collision with root package name */
    public static final Uri f3225l;

    /* renamed from: m, reason: collision with root package name */
    public static final Uri f3226m;

    /* renamed from: n, reason: collision with root package name */
    public static final Uri f3227n;

    /* renamed from: o, reason: collision with root package name */
    public static final Uri f3228o;

    /* renamed from: p, reason: collision with root package name */
    public static final Uri f3229p;

    /* renamed from: q, reason: collision with root package name */
    public static final Uri f3230q;

    /* renamed from: r, reason: collision with root package name */
    public static final Uri f3231r;

    /* compiled from: ContactsUris.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final Uri f3232a;

        /* renamed from: b, reason: collision with root package name */
        public static final Uri f3233b;

        /* renamed from: c, reason: collision with root package name */
        public static final Uri f3234c;

        /* renamed from: d, reason: collision with root package name */
        public static final Uri f3235d;

        /* renamed from: e, reason: collision with root package name */
        public static final Uri f3236e;

        /* renamed from: f, reason: collision with root package name */
        public static final Uri f3237f;

        /* renamed from: g, reason: collision with root package name */
        public static final Uri f3238g;

        /* renamed from: h, reason: collision with root package name */
        public static final Uri f3239h;

        /* renamed from: i, reason: collision with root package name */
        public static final Uri f3240i;

        /* renamed from: j, reason: collision with root package name */
        public static final Uri f3241j;

        /* renamed from: k, reason: collision with root package name */
        public static final Uri f3242k;

        static {
            Uri uri = ContactsContract.AUTHORITY_URI;
            f3232a = Uri.withAppendedPath(uri, f.c("dial_contacts") + "/pyandnumber");
            f3233b = Uri.withAppendedPath(uri, f.c("dial_contacts") + "/strokeandnumber");
            f3234c = Uri.withAppendedPath(uri, f.c("dial_contacts") + "/special_contacts_py");
            f3235d = Uri.withAppendedPath(uri, f.c("dial_contacts") + "/special_contacts_stroke");
            f3236e = Uri.parse("content://call_log/" + f.c("dial_contacts") + "/call_log/");
            StringBuilder sb = new StringBuilder();
            sb.append(f.c("dial_contacts"));
            sb.append("/unite_taven_all");
            f3237f = Uri.withAppendedPath(uri, sb.toString());
            f3238g = Uri.withAppendedPath(uri, f.c("dial_contacts") + "/unite_vietnamese_all");
            f3239h = Uri.withAppendedPath(uri, f.c("dial_contacts") + "/unite_indonesian_all");
            f3240i = Uri.withAppendedPath(uri, f.c("dial_contacts") + "/unite_russian_all");
            f3241j = Uri.withAppendedPath(uri, f.c("dial_contacts") + "/unite_taiwan_all");
            f3242k = Uri.withAppendedPath(uri, f.c("dial_contacts") + "/unite_ukrainian_all");
        }
    }

    /* compiled from: ContactsUris.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static final Uri f3243a = Uri.parse("content://icc/sdn/");

        /* renamed from: b, reason: collision with root package name */
        public static final Uri f3244b = Uri.parse("content://icc/sdn/subId");

        /* renamed from: c, reason: collision with root package name */
        public static final Uri f3245c = Uri.parse("content://icc/adn");

        /* renamed from: d, reason: collision with root package name */
        public static final Uri f3246d = Uri.parse("content://icc/adn/subId/");

        /* renamed from: e, reason: collision with root package name */
        public static final Uri f3247e = Uri.parse("content://icc/pbr");

        /* renamed from: f, reason: collision with root package name */
        public static final Uri f3248f = Uri.parse("content://icc/pbr/subId/");

        /* renamed from: g, reason: collision with root package name */
        public static final Uri f3249g = Uri.parse("content://icc/all_space");

        /* renamed from: h, reason: collision with root package name */
        public static final Uri f3250h = Uri.parse("content://icc/used_space");

        /* renamed from: i, reason: collision with root package name */
        public static final Uri f3251i = Uri.parse("content://icc/sim_name_length");

        /* renamed from: j, reason: collision with root package name */
        public static final Uri f3252j = Uri.parse("content://icc/adn_capacity/subId/");
    }

    static {
        Uri uri = ContactsContract.AUTHORITY_URI;
        f3214a = Uri.withAppendedPath(uri, f.c("all_contacts"));
        f3215b = Uri.withAppendedPath(uri, f.c("contact_uri_query"));
        f3216c = Uri.withAppendedPath(uri, f.c("ringtone_update"));
        f3217d = Uri.withAppendedPath(uri, f.c("query_vip_by_contact_id"));
        String b10 = com.android.contacts.framework.api.appstore.appinfo.a.b();
        f3218e = b10;
        Uri parse = Uri.parse("content://" + b10);
        f3219f = parse;
        Uri withAppendedPath = Uri.withAppendedPath(parse, OplusNumberMarkUtils.OplusBlacklist.BLACKLIST_TABLE);
        f3220g = withAppendedPath;
        f3221h = Uri.withAppendedPath(parse, "sn_list");
        f3222i = Uri.withAppendedPath(withAppendedPath, "sms_and_call_block");
        f3223j = Uri.withAppendedPath(uri, f.c("favorites_contacts"));
        String i10 = com.android.contacts.framework.api.appstore.appinfo.a.i();
        f3224k = i10;
        f3225l = Uri.withAppendedPath(uri, f.c("smart_company_group"));
        f3226m = ContactsContract.CommonDataKinds.Phone.CONTENT_URI.buildUpon().appendQueryParameter("directory", String.valueOf(0L)).appendQueryParameter("remove_duplicate_entries", "true").build();
        f3227n = Uri.parse("content://" + i10 + "/" + f.c("location_groups"));
        f3228o = Uri.withAppendedPath(uri, f.c("fix_contacts"));
        f3229p = Uri.withAppendedPath(uri, f.c("group_member_count_by_title"));
        f3230q = Uri.withAppendedPath(uri, "special_contacts");
        f3231r = Uri.parse("content://" + i10 + "/country_list/");
    }

    public static Uri a(Uri uri) {
        return uri.buildUpon().appendQueryParameter(f.c("from_customize_app"), "true").build();
    }

    public static Uri b(Uri uri) {
        return uri.buildUpon().appendQueryParameter(c.f3184b, "true").build();
    }

    public static Uri c(String str) {
        if (TextUtils.isEmpty(str)) {
            return ContactsContract.PhoneLookup.CONTENT_FILTER_URI;
        }
        int length = str.length();
        if (length > 1 && (str.endsWith(Constants.DataMigration.SPLIT_TAG) || str.endsWith(","))) {
            str = str.substring(0, length - 1);
        }
        if (H7.a.b()) {
            H7.b.e("ContactsUris", "number = " + H7.a.d(str));
        }
        return Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(str));
    }
}
