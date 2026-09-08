package s6;

import android.content.Context;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.oplus.backup.sdk.common.utils.ModuleType;
import com.oplus.blacklistapp.l;
import com.oplus.blacklistapp.u;
import com.oplus.utils.C0846g;
import com.oplus.utils.C0848i;
import com.oplus.utils.O;
import v6.C1627a;

/* compiled from: CallerInfo.java */
/* renamed from: s6.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1552a {

    /* renamed from: a, reason: collision with root package name */
    public String f36837a;

    /* renamed from: b, reason: collision with root package name */
    public String f36838b;

    /* renamed from: c, reason: collision with root package name */
    public String f36839c;

    /* renamed from: d, reason: collision with root package name */
    public String f36840d;

    /* renamed from: e, reason: collision with root package name */
    public String f36841e;

    /* renamed from: f, reason: collision with root package name */
    public String f36842f;

    /* renamed from: g, reason: collision with root package name */
    public int f36843g;

    /* renamed from: h, reason: collision with root package name */
    public int f36844h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f36845i;

    /* renamed from: j, reason: collision with root package name */
    public String f36846j;

    /* renamed from: k, reason: collision with root package name */
    public String f36847k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f36848l;

    /* renamed from: m, reason: collision with root package name */
    public String f36849m;

    /* renamed from: n, reason: collision with root package name */
    public int f36850n;

    /* renamed from: o, reason: collision with root package name */
    public String f36851o;

    /* renamed from: p, reason: collision with root package name */
    public int f36852p;

    /* renamed from: q, reason: collision with root package name */
    public long f36853q;

    /* renamed from: r, reason: collision with root package name */
    public String f36854r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f36855s;

    /* renamed from: t, reason: collision with root package name */
    public Uri f36856t;

    /* renamed from: u, reason: collision with root package name */
    public Uri f36857u;

    /* renamed from: v, reason: collision with root package name */
    public Uri f36858v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f36859w;

    /* renamed from: x, reason: collision with root package name */
    public Drawable f36860x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f36861y;

    /* renamed from: B, reason: collision with root package name */
    public boolean f36836B = false;

    /* renamed from: z, reason: collision with root package name */
    public boolean f36862z = false;

    /* renamed from: A, reason: collision with root package name */
    public boolean f36835A = false;

    public static C1552a a(Context context, String str, C1552a c1552a) {
        if (!c1552a.f36845i && O.b(str)) {
            String a10 = O.a(str);
            if (PhoneNumberUtils.isGlobalPhoneNumber(a10)) {
                return b(context, C0848i.i(context, a10));
            }
            return c1552a;
        }
        return c1552a;
    }

    public static C1552a b(Context context, Uri uri) {
        return c(context, uri, context.getContentResolver().query(uri, null, null, null, null));
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x01db, code lost:
    
        if (r13.isClosed() == false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01c5, code lost:
    
        if (r13.isClosed() != false) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x01c7, code lost:
    
        r13.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static s6.C1552a c(android.content.Context r11, android.net.Uri r12, android.database.Cursor r13) {
        /*
            Method dump skipped, instructions count: 491
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s6.C1552a.c(android.content.Context, android.net.Uri, android.database.Cursor):s6.a");
    }

    public static int d(Uri uri, Cursor cursor) {
        int i10;
        C1627a.o("CallerInfo", "- getColumnIndexForPersonId: contactRef URI = '" + C0846g.h(uri) + "'...");
        String uri2 = uri.toString();
        String str = "contact_id";
        if (uri2.startsWith("content://com.android.contacts/data/phones")) {
            C1627a.o("CallerInfo", "'data/phones' URI; using RawContacts.CONTACT_ID");
        } else if (uri2.startsWith("content://com.android.contacts/data")) {
            C1627a.o("CallerInfo", "'data' URI; using Data.CONTACT_ID");
        } else {
            boolean startsWith = uri2.startsWith("content://com.android.contacts/phone_lookup");
            str = BreenoCallContract.BaseColumns._ID;
            if (!startsWith) {
                if (!uri2.startsWith("content://" + F6.d.b() + "/phone_lookup")) {
                    if (!uri2.startsWith("content://" + F6.d.b() + "/phone_lookup_enterprise")) {
                        C1627a.o("CallerInfo", "Unexpected prefix for contactRef '" + C0846g.h(uri) + "'");
                        str = null;
                    }
                }
            }
            C1627a.o("CallerInfo", "'phone_lookup' URI; using PhoneLookup._ID");
        }
        if (str != null) {
            i10 = cursor.getColumnIndex(str);
        } else {
            i10 = -1;
        }
        C1627a.o("CallerInfo", "==> Using column '" + str + "' (columnIndex = " + i10 + ") for person_id lookup...");
        return i10;
    }

    public static String e(Context context, String str) {
        C1627a.o("CallerInfo", "getGeoDescription('" + C0846g.f(str) + "')...");
        TextUtils.isEmpty(str);
        return null;
    }

    public static String j(String str) {
        if (str != null && str.length() <= 0) {
            return null;
        }
        return str;
    }

    public boolean f() {
        return this.f36835A;
    }

    public C1552a g(Context context) {
        this.f36838b = context.getString(u.f27597a1);
        this.f36862z = true;
        return this;
    }

    public C1552a h(Context context, String str) {
        String normalizeNumber = PhoneNumberUtils.normalizeNumber(str);
        if (context.getResources().getBoolean(l.f27271a)) {
            this.f36837a = context.getString(u.f27602b1);
        } else {
            this.f36837a = context.getString(u.f27597a1) + " " + normalizeNumber;
        }
        this.f36838b = null;
        this.f36862z = true;
        return this;
    }

    public C1552a i(Context context) {
        this.f36835A = true;
        try {
            this.f36838b = context.getResources().getString(u.f27679q3);
        } catch (SecurityException e10) {
            C1627a.i("CallerInfo", "Cannot access VoiceMail.", e10);
        }
        return this;
    }

    public void k(Context context, String str) {
        if (!TextUtils.isEmpty(this.f36838b)) {
            str = this.f36838b;
        }
        this.f36841e = e(context, str);
    }

    public String toString() {
        String str;
        if (C1627a.f37411c) {
            StringBuilder sb = new StringBuilder(ModuleType.TYPE_SYSTEM_SETTING);
            sb.append(super.toString() + " { ");
            sb.append("\nname: ***");
            sb.append("\nphoneNumber: " + C0846g.f(this.f36838b));
            sb.append("\ncompany: ***");
            sb.append("\ntitle: " + this.f36847k);
            sb.append("\nnormalizedNumber: " + C0846g.f(this.f36839c));
            sb.append("\forwardingNumber: " + C0846g.f(this.f36840d));
            sb.append("\ngeoDescription: " + this.f36841e);
            sb.append("\ncnapName: " + this.f36842f);
            sb.append("\nnumberPresentation: " + this.f36843g);
            sb.append("\nnamePresentation: " + this.f36844h);
            sb.append("\ncontactExists: " + this.f36845i);
            sb.append("\nphoneLabel: " + this.f36849m);
            sb.append("\nnumberType: " + this.f36850n);
            sb.append("\nnumberLabel: " + this.f36851o);
            sb.append("\nphotoResource: " + this.f36852p);
            sb.append("\ncontactIdOrZero: " + this.f36853q);
            sb.append("\nneedUpdate: " + this.f36855s);
            sb.append("\ncontactRefUri: " + C0846g.h(this.f36856t));
            sb.append("\ncontactRingtoneUri: " + C0846g.h(this.f36858v));
            sb.append("\ncontactDisplayPhotoUri: " + C0846g.h(this.f36857u));
            sb.append("\nshouldSendToVoicemail: " + this.f36859w);
            sb.append("\ncachedPhoto: " + this.f36860x);
            sb.append("\nisCachedPhotoCurrent: " + this.f36861y);
            sb.append("\nemergency: " + this.f36862z);
            sb.append("\nvoicemail " + this.f36835A);
            sb.append(" }");
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append(super.toString() + " { ");
        StringBuilder sb3 = new StringBuilder();
        sb3.append("name ");
        String str2 = "non-null";
        if (this.f36837a != null) {
            str = "non-null";
        } else {
            str = "null";
        }
        sb3.append(str);
        sb2.append(sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append(", phoneNumber ");
        if (this.f36838b == null) {
            str2 = "null";
        }
        sb4.append(str2);
        sb2.append(sb4.toString());
        sb2.append(" }");
        return sb2.toString();
    }
}
