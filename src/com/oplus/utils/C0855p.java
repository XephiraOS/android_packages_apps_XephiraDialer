package com.oplus.utils;

import android.net.Uri;
import android.provider.BaseColumns;
import android.provider.ContactsContract;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.incallui.OplusAutoRedialNotificationUI;
import com.android.incallui.OplusNumberMarkUtils;
import com.oplus.blacklist.database.a;

/* compiled from: Const.java */
/* renamed from: com.oplus.utils.p, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0855p {

    /* renamed from: a, reason: collision with root package name */
    public static final String f29166a = F6.a.d();

    /* renamed from: b, reason: collision with root package name */
    public static final Uri f29167b = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "special_contacts");

    /* renamed from: c, reason: collision with root package name */
    public static final String f29168c = F6.e.k();

    /* renamed from: d, reason: collision with root package name */
    public static final String f29169d = F6.e.l();

    /* renamed from: e, reason: collision with root package name */
    public static final String f29170e = F6.e.m();

    /* compiled from: Const.java */
    /* renamed from: com.oplus.utils.p$a */
    /* loaded from: classes3.dex */
    public static final class a extends a.c {

        /* renamed from: a, reason: collision with root package name */
        public static final Uri f29171a;

        /* renamed from: b, reason: collision with root package name */
        public static final Uri f29172b;

        /* renamed from: c, reason: collision with root package name */
        public static final String[] f29173c;

        /* renamed from: d, reason: collision with root package name */
        public static final String[] f29174d;

        static {
            Uri withAppendedPath = Uri.withAppendedPath(com.oplus.blacklist.database.a.f26233b, OplusNumberMarkUtils.OplusBlacklist.BLACKLIST_TABLE);
            f29171a = withAppendedPath;
            f29172b = Uri.withAppendedPath(withAppendedPath, "sms_and_call_block");
            f29173c = new String[]{BreenoCallContract.BaseColumns._ID, "name", "number", "reverse_number", OplusNumberMarkUtils.OplusBlacklist.BLOCK_TYPE, "photo_id", OplusNumberMarkUtils.OplusBlacklist.CONTACTID, OplusNumberMarkUtils.OplusBlacklist.LIST_TYPE, "note", "function_type"};
            f29174d = new String[]{BreenoCallContract.BaseColumns._ID, "name", "number", "reverse_number", OplusNumberMarkUtils.OplusBlacklist.BLOCK_TYPE, "photo_id", OplusNumberMarkUtils.OplusBlacklist.CONTACTID, OplusNumberMarkUtils.OplusBlacklist.LIST_TYPE, "note", "function_type"};
        }
    }

    /* compiled from: Const.java */
    /* renamed from: com.oplus.utils.p$b */
    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f29175a = {BreenoCallContract.BaseColumns._ID, "display_name", OplusAutoRedialNotificationUI.TYPE, "label", "number", "photo_id"};

        /* renamed from: b, reason: collision with root package name */
        public static final String[] f29176b = {BreenoCallContract.BaseColumns._ID, "display_name", "is_vip", "number"};
    }

    /* compiled from: Const.java */
    /* renamed from: com.oplus.utils.p$c */
    /* loaded from: classes3.dex */
    public static final class c implements BaseColumns {

        /* renamed from: a, reason: collision with root package name */
        public static final Uri f29177a = Uri.withAppendedPath(com.oplus.blacklist.database.a.f26233b, "bl_list/prefixblacknumber");
    }

    /* compiled from: Const.java */
    /* renamed from: com.oplus.utils.p$d */
    /* loaded from: classes3.dex */
    public static final class d implements BaseColumns {

        /* renamed from: a, reason: collision with root package name */
        public static final Uri f29178a = Uri.parse("content://com.suntek.mway.rcs.app.service.chatbots");

        /* renamed from: b, reason: collision with root package name */
        public static final String[] f29179b = {BreenoCallContract.BaseColumns._ID, "name", "number", "shop_id", "shop_icon", "is_in_black", "source", "logo"};
    }
}
