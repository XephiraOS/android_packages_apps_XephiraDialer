package com.oplus.utils;

import android.content.ContentProviderClient;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.oplus.utils.C0847h;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: MessageUtils.java */
/* loaded from: classes3.dex */
public class C {

    /* renamed from: a, reason: collision with root package name */
    public static C f29036a;

    /* compiled from: MessageUtils.java */
    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC0862x f29037a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f29038b;

        public a(InterfaceC0862x interfaceC0862x, Context context) {
            this.f29037a = interfaceC0862x;
            this.f29038b = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f29037a.a(C.this.i(this.f29038b));
        }
    }

    public static Intent a(long j10) {
        Intent a10 = F6.a.a(j10);
        if (j10 > 0) {
            a10.setData(g(j10));
            a10.putExtra("sms_view_model", true);
        }
        return a10;
    }

    public static Intent b(String str, String str2, String str3, long j10) {
        Intent c10 = F6.a.c();
        c10.setFlags(67108864);
        c10.putExtra("number", str2);
        c10.putExtra("navigate_title_text", str3);
        c10.putExtra("service_id", str);
        c10.putExtra("thread_id", j10);
        c10.putExtra("is_push_message", true);
        c10.putExtra("is_blocked", true);
        if (C0846g.c()) {
            Log.i("MessageUtils", "threadId = " + j10 + ", serviceId = " + str + ", number = " + C0846g.f(str2));
        }
        if (j10 > 0) {
            c10.setData(g(j10));
        }
        return c10;
    }

    public static C f() {
        if (f29036a == null) {
            f29036a = new C();
        }
        return f29036a;
    }

    public static Uri g(long j10) {
        return ContentUris.withAppendedId(C0847h.c.f29155e, j10);
    }

    public static boolean h(String str) {
        if (TextUtils.isEmpty(str) || !str.toLowerCase().startsWith("sip:") || !str.contains("@")) {
            return false;
        }
        return true;
    }

    public static boolean j(String str) {
        if ("Ussd".equals(str)) {
            return true;
        }
        return false;
    }

    public static boolean m(Context context, String str, String str2, String str3, long j10) {
        if (C0846g.c()) {
            Log.d("MessageUtils", "removeTedPushSmsFromBlacklist serviceId = " + str + " ,threadId = " + j10);
        }
        Uri parse = Uri.parse("content://message-external");
        Bundle bundle = new Bundle();
        bundle.putString("conversation_id", Long.toString(j10));
        bundle.putString("service_id", str);
        bundle.putString("service_name", str3);
        bundle.putString("service_number", str2);
        boolean z10 = false;
        try {
            Bundle call = context.getContentResolver().call(parse, "remove_push_black_list", (String) null, bundle);
            if (call != null) {
                z10 = call.getBoolean("result");
            }
            if (C0846g.c()) {
                Log.d("MessageUtils", "removeTedPushSmsFromBlacklist success = " + z10);
            }
        } catch (Exception e10) {
            Log.e("MessageUtils", "removeTedPushSmsFromBlacklist error:" + e10);
        }
        return z10;
    }

    public boolean c(Context context, HashSet<Long> hashSet) {
        if (C0846g.c()) {
            Log.d("MessageUtils", "deleteBlockedSms selectedThreadIds = " + hashSet);
        }
        Uri parse = Uri.parse("content://message-external");
        long[] n10 = n(hashSet);
        Bundle bundle = new Bundle();
        bundle.putLongArray("conversation_ids", n10);
        boolean z10 = false;
        try {
            Bundle call = context.getContentResolver().call(parse, "delete_blocked_conversations", (String) null, bundle);
            if (call != null) {
                z10 = call.getBoolean("result");
            }
            if (C0846g.c()) {
                Log.d("MessageUtils", "deleteBlockedSms success = " + z10);
            }
        } catch (Exception e10) {
            Log.e("MessageUtils", "deleteBlockedSms error:" + e10);
        }
        return z10;
    }

    public int d(Context context, int i10) {
        ContentProviderClient acquireUnstableContentProviderClient;
        int i11 = 0;
        if (context == null) {
            return 0;
        }
        ContentProviderClient contentProviderClient = null;
        Bundle bundle = null;
        contentProviderClient = null;
        try {
            try {
                acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(Uri.parse("content://message-external"));
            } catch (Exception e10) {
                e = e10;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (acquireUnstableContentProviderClient != null) {
                if (i10 == 22) {
                    bundle = acquireUnstableContentProviderClient.call("get_chatbot_black_list_count", context.getPackageName(), new Bundle());
                } else {
                    bundle = acquireUnstableContentProviderClient.call("get_shop_black_list_count", context.getPackageName(), new Bundle());
                }
            }
            if (bundle != null) {
                i11 = bundle.getInt("result");
            }
            if (C0846g.c()) {
                Log.d("MessageUtils", "getChatbotOrShopBlackListCount count = " + i11);
            }
            if (acquireUnstableContentProviderClient != null) {
                acquireUnstableContentProviderClient.close();
            }
        } catch (Exception e11) {
            e = e11;
            contentProviderClient = acquireUnstableContentProviderClient;
            Log.e("MessageUtils", "getChatbotOrShopBlackListCount error: " + e);
            if (contentProviderClient != null) {
                contentProviderClient.close();
            }
            return i11;
        } catch (Throwable th2) {
            th = th2;
            contentProviderClient = acquireUnstableContentProviderClient;
            if (contentProviderClient != null) {
                contentProviderClient.close();
            }
            throw th;
        }
        return i11;
    }

    public boolean e(Context context) {
        boolean z10 = false;
        try {
            Bundle call = context.getContentResolver().call(Uri.parse("content://message-external"), "is_sms_show_contact_photo", (String) null, (Bundle) null);
            if (call != null) {
                z10 = call.getBoolean("result");
            }
            if (C0846g.c()) {
                Log.d("MessageUtils", "getContactPhotoSwitch isOpen = " + z10);
            }
        } catch (Exception e10) {
            Log.e("MessageUtils", "getContactPhotoSwitch error:" + e10);
        }
        return z10;
    }

    public boolean i(Context context) {
        boolean z10 = false;
        if (context == null) {
            return false;
        }
        try {
            Bundle call = context.getContentResolver().call(Uri.parse("content://message-external"), "is_sms_show_rcs_settings", (String) null, (Bundle) null);
            if (call != null) {
                z10 = call.getBoolean("result");
            }
            if (C0846g.c()) {
                Log.d("MessageUtils", "isShowSmsRcsSettings success = " + z10);
            }
        } catch (Exception e10) {
            Log.e("MessageUtils", "isShowSmsRcsSettings error: " + e10);
        }
        return z10;
    }

    public boolean k(Context context, HashSet<Long> hashSet) {
        if (C0846g.c()) {
            Log.d("MessageUtils", "markConversationsAsRead unReadThreadIds = " + hashSet);
        }
        Uri parse = Uri.parse("content://message-external");
        long[] n10 = n(hashSet);
        Bundle bundle = new Bundle();
        bundle.putLongArray("conversation_ids", n10);
        boolean z10 = false;
        try {
            Bundle call = context.getContentResolver().call(parse, "mark_read_blocked_conversations", (String) null, bundle);
            if (call != null) {
                z10 = call.getBoolean("result");
            }
            if (C0846g.c()) {
                Log.d("MessageUtils", "markConversationsAsRead success = " + z10);
            }
        } catch (Exception e10) {
            Log.e("MessageUtils", "markConversationsAsRead error:" + e10);
        }
        return z10;
    }

    public void l(Context context, InterfaceC0862x interfaceC0862x) {
        new Thread(new a(interfaceC0862x, context)).start();
    }

    public final long[] n(HashSet<Long> hashSet) {
        if (hashSet == null) {
            return null;
        }
        long[] jArr = new long[hashSet.size()];
        Iterator<Long> it = hashSet.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            jArr[i10] = it.next().longValue();
            i10++;
        }
        return jArr;
    }
}
