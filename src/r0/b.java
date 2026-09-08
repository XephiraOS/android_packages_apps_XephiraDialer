package R0;

import android.net.Uri;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.compat.data.f;
import com.android.incallui.OplusPhoneUtils;
import java.util.regex.Pattern;

/* compiled from: Constants.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final String f3167a = "6001";

    /* renamed from: b, reason: collision with root package name */
    public static final String f3168b = f.b("oplus_set_starred");

    /* renamed from: c, reason: collision with root package name */
    public static final String f3169c = f.a("oplus_customize_volte_change");

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f3170d = Pattern.compile("[A-Z*#]");

    /* renamed from: e, reason: collision with root package name */
    public static final Pattern f3171e = Pattern.compile("[A-Z\\u3105-\\u3129]");

    /* renamed from: f, reason: collision with root package name */
    public static final String f3172f = com.android.contacts.framework.api.appstore.appinfo.a.f();

    /* renamed from: g, reason: collision with root package name */
    public static final Pattern f3173g = Pattern.compile("([^0-9*#+;,N])+");

    /* renamed from: h, reason: collision with root package name */
    public static final String[] f3174h = {"TW"};

    /* renamed from: i, reason: collision with root package name */
    public static final String f3175i = f.b(OplusPhoneUtils.PERMISSION_OPLUS_COMPONENT_SAFE);

    /* renamed from: j, reason: collision with root package name */
    public static final Uri f3176j = Uri.parse("content://call_log/call_log_with_recording");

    /* renamed from: k, reason: collision with root package name */
    public static final Uri f3177k = Uri.parse("content://com.oplus.chaken");

    /* renamed from: l, reason: collision with root package name */
    public static final String[] f3178l = {"contact_id", "display_name", "data1", "phonebook_bucket", "data6", "photo_id"};

    /* renamed from: m, reason: collision with root package name */
    public static final String[] f3179m = {BreenoCallContract.BaseColumns._ID, "display_name", "photo_id", "account_name", "account_type", "lookup", "phonebook_bucket"};

    /* renamed from: n, reason: collision with root package name */
    public static final String[] f3180n = {BreenoCallContract.BaseColumns._ID, "display_name_alt", "photo_id", "account_name", "account_type", "lookup", "phonebook_bucket_alt"};

    /* compiled from: Constants.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final String f3181a = f.b("persist.sys.oplus.region");

        /* renamed from: b, reason: collision with root package name */
        public static final String f3182b = f.b("ro.vendor.oplus.regionmark");
    }

    public static String[] a() {
        return f3178l;
    }

    public static String[] b() {
        return f3179m;
    }

    public static String[] c() {
        return f3180n;
    }

    public static String[] d() {
        return f3174h;
    }
}
