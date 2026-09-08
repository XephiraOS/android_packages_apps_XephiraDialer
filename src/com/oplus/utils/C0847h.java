package com.oplus.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.incallui.OplusAutoRedialNotificationUI;
import com.android.incallui.OplusNumberMarkUtils;

/* compiled from: BlacklistQueryHelper.java */
/* renamed from: com.oplus.utils.h, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0847h {

    /* renamed from: a, reason: collision with root package name */
    public static final String f29141a;

    /* renamed from: b, reason: collision with root package name */
    public static final Uri f29142b;

    /* compiled from: BlacklistQueryHelper.java */
    /* renamed from: com.oplus.utils.h$a */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f29143a = {BreenoCallContract.BaseColumns._ID, "number", BreenoCallContract.BaseColumns.DATE, "duration", OplusAutoRedialNotificationUI.TYPE, "voicemail_uri", "geocoded_location", "name", "lookup_uri", "matched_number", "photo_id", "formatted_number", "simid", "ring_time", "transcription", "features", "countryiso"};

        /* renamed from: b, reason: collision with root package name */
        public static final Uri f29144b;

        /* renamed from: c, reason: collision with root package name */
        public static final Uri f29145c;

        /* renamed from: d, reason: collision with root package name */
        public static final Uri f29146d;

        static {
            Uri uri = C0847h.f29142b;
            f29144b = Uri.withAppendedPath(uri, F6.d.d());
            f29145c = Uri.withAppendedPath(uri, F6.d.c());
            f29146d = Uri.withAppendedPath(uri, "calls");
        }

        public static String a(int i10, int i11) {
            String str;
            if (i10 == 20) {
                if (l7.b.o()) {
                    str = "(type=" + i10 + " OR type=21 OR type=22 OR type=28 OR type=29 OR type=30 OR type=23 OR type=24 OR type=25 OR type=26 OR type=27 OR type=56 OR type=49 OR type=50 OR type=51 OR type=52 OR type=53 OR type < 0)";
                } else {
                    str = "(type=" + i10 + " OR type=21 OR type=22 OR type=23 OR type=24 OR type=25 OR type=26 OR type=27 OR type=56 OR type=49 OR type=50 OR type=51 OR type=52 OR type=53 OR type < 0)";
                }
            } else {
                str = "type=" + i10;
            }
            if (i11 != -1) {
                if (TextUtils.isEmpty(str)) {
                    return "simid=" + i11;
                }
                return str + " AND simid=" + i11;
            }
            return str;
        }
    }

    /* compiled from: BlacklistQueryHelper.java */
    /* renamed from: com.oplus.utils.h$b */
    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f29147a = {BreenoCallContract.BaseColumns._ID, "display_name", OplusAutoRedialNotificationUI.TYPE, "label", "number", BreenoCallContract.BaseColumns.NORMALIZED_NUMBER, "photo_id", "lookup", "photo_uri"};

        /* renamed from: b, reason: collision with root package name */
        public static final Uri f29148b;

        /* renamed from: c, reason: collision with root package name */
        public static final Uri f29149c;

        /* renamed from: d, reason: collision with root package name */
        public static final Uri f29150d;

        static {
            Uri uri = C0847h.f29142b;
            f29148b = Uri.withAppendedPath(uri, "phone_lookup");
            f29149c = Uri.withAppendedPath(uri, "phone_lookup_enterprise");
            f29150d = Uri.withAppendedPath(uri, "special_contacts");
        }
    }

    /* compiled from: BlacklistQueryHelper.java */
    /* renamed from: com.oplus.utils.h$c */
    /* loaded from: classes3.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public static final String f29151a;

        /* renamed from: b, reason: collision with root package name */
        public static final String f29152b;

        /* renamed from: c, reason: collision with root package name */
        public static final String[] f29153c;

        /* renamed from: d, reason: collision with root package name */
        public static final Uri f29154d;

        /* renamed from: e, reason: collision with root package name */
        public static final Uri f29155e;

        static {
            String j10 = F6.d.j();
            f29151a = j10;
            String i10 = F6.d.i();
            f29152b = i10;
            f29153c = new String[]{BreenoCallContract.BaseColumns._ID, i10, BreenoCallContract.BaseColumns.DATE, "snippet", j10, OplusNumberMarkUtils.OplusBlacklist.BLOCK_TYPE, "service_name", "service_number", "attachment_type", "ted_service_id", "service_logo", "snippet_cs"};
            Uri parse = Uri.parse("content://mms-sms-local//");
            f29154d = parse;
            f29155e = Uri.withAppendedPath(parse, "conversations");
        }
    }

    static {
        String b10 = F6.d.b();
        f29141a = b10;
        f29142b = Uri.parse("content://" + b10);
    }
}
