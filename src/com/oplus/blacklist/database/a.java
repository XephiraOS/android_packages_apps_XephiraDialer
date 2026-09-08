package com.oplus.blacklist.database;

import android.net.Uri;
import android.provider.BaseColumns;

/* compiled from: DatabaseConstants.java */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f26232a;

    /* renamed from: b, reason: collision with root package name */
    public static final Uri f26233b;

    /* renamed from: c, reason: collision with root package name */
    public static final Uri f26234c;

    /* compiled from: DatabaseConstants.java */
    /* renamed from: com.oplus.blacklist.database.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0236a implements BaseColumns {

        /* renamed from: a, reason: collision with root package name */
        public static final Uri f26235a = Uri.withAppendedPath(a.f26233b, "area_list");
    }

    /* compiled from: DatabaseConstants.java */
    /* loaded from: classes3.dex */
    public static final class b implements BaseColumns {

        /* renamed from: a, reason: collision with root package name */
        public static final Uri f26236a = Uri.withAppendedPath(a.f26233b, "bl_area_for_country");
    }

    /* compiled from: DatabaseConstants.java */
    /* loaded from: classes3.dex */
    public static class c implements BaseColumns {
    }

    /* compiled from: DatabaseConstants.java */
    /* loaded from: classes3.dex */
    public static final class d implements BaseColumns {

        /* renamed from: a, reason: collision with root package name */
        public static final Uri f26237a = Uri.withAppendedPath(a.f26233b, "kw_list");
    }

    /* compiled from: DatabaseConstants.java */
    /* loaded from: classes3.dex */
    public static final class e implements BaseColumns {

        /* renamed from: a, reason: collision with root package name */
        public static final Uri f26238a = Uri.withAppendedPath(a.f26233b, "pseudo_base_station");
    }

    static {
        String a10 = com.oplus.blacklistapp.framework.api.appstore.appinfo.a.a();
        f26232a = a10;
        Uri parse = Uri.parse("content://" + a10);
        f26233b = parse;
        f26234c = Uri.withAppendedPath(parse, "pseudo_base_station");
    }
}
