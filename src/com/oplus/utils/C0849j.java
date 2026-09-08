package com.oplus.utils;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.ContentProviderOperation;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.OperationApplicationException;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.RemoteException;
import android.telephony.PhoneNumberUtils;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import com.android.incallui.OplusNumberMarkUtils;
import com.android.incallui.OplusPhoneUtils;
import com.oplus.blacklistapp.d;
import com.oplus.utils.C0855p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import v6.C1629c;

/* compiled from: BlockUtils.java */
/* renamed from: com.oplus.utils.j, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0849j {

    /* renamed from: a, reason: collision with root package name */
    public static final String f29159a = F6.a.e();

    /* renamed from: b, reason: collision with root package name */
    public static boolean f29160b = false;

    public static void A(Context context, Intent intent) {
        if (context == null) {
            return;
        }
        try {
            f29160b = true;
            context.startActivity(intent);
        } catch (ActivityNotFoundException e10) {
            Log.e("BlockUtils", "e = " + e10);
        } catch (Exception e11) {
            Log.e("BlockUtils", "e = " + e11);
        }
    }

    public static String B(String str) {
        int length = str.length();
        while (true) {
            int i10 = length - 1;
            if (str.charAt(i10) != ',' && str.charAt(i10) != ';') {
                break;
            }
            length--;
        }
        if (length < str.length()) {
            return str.substring(0, length);
        }
        return str;
    }

    public static int C(Context context, String str, int i10, String str2, int i11, d.e eVar) {
        if (i10 == 1) {
            V6.a g10 = g(context, str, 0L);
            if (g10 != null && g10.f4024o) {
                return 1;
            }
            if (r(context, str)) {
                return 3;
            }
        }
        Uri withAppendedPath = Uri.withAppendedPath(C0855p.a.f29171a, String.valueOf(eVar.f27062e));
        ContentValues contentValues = new ContentValues(4);
        contentValues.put("number", str);
        if (str2 == null) {
            contentValues.putNull("note");
        } else {
            contentValues.put("note", str2);
        }
        contentValues.put("function_type", Integer.valueOf(i11));
        try {
            if (context.getContentResolver().update(withAppendedPath, contentValues, null, null) > 0 && i10 == 1) {
                if (str.equals(eVar.f27058a)) {
                    if (eVar.f27061d != i11) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(eVar.f27058a);
                        if (i11 == 0) {
                            if (eVar.f27061d == 2) {
                                x(context, arrayList, true, false, false, 1);
                            }
                            if (eVar.f27061d == 1) {
                                x(context, arrayList, true, false, false, 2);
                                return 0;
                            }
                            return 0;
                        }
                        if (i11 == 1) {
                            x(context, arrayList, false, false, true, 2);
                            if (eVar.f27061d == 2) {
                                x(context, arrayList, true, false, false, 1);
                                return 0;
                            }
                            return 0;
                        }
                        if (i11 == 2) {
                            x(context, arrayList, false, false, true, 1);
                            if (eVar.f27061d == 1) {
                                x(context, arrayList, true, false, false, 2);
                                return 0;
                            }
                            return 0;
                        }
                        return 0;
                    }
                    return 0;
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(eVar.f27058a);
                x(context, arrayList2, false, false, true, 0);
                arrayList2.clear();
                arrayList2.add(str);
                x(context, arrayList2, true, false, false, i11);
                return 0;
            }
            return 0;
        } catch (Exception e10) {
            Log.e("BlockUtils", "e = " + e10);
            return 0;
        }
    }

    public static void D(Context context, String str, int i10, long j10) {
        v("updatePrefixBlackNumber number = " + C0846g.f(str));
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        ContentProviderOperation.Builder newUpdate = ContentProviderOperation.newUpdate(Uri.withAppendedPath(C0855p.c.f29177a, String.valueOf(j10)));
        ContentValues contentValues = new ContentValues(4);
        contentValues.put("number", str);
        contentValues.put("function_type", Integer.valueOf(i10));
        newUpdate.withValues(contentValues);
        arrayList.add(newUpdate.build());
        try {
            context.getContentResolver().applyBatch(com.oplus.blacklist.database.a.f26232a, arrayList);
        } catch (Exception e10) {
            Log.e("BlockUtils", "e = " + e10);
        }
    }

    public static List<SubscriptionInfo> a(Context context) {
        SubscriptionManager subscriptionManager = (SubscriptionManager) context.getSystemService("telephony_subscription_service");
        List<SubscriptionInfo> list = null;
        if (subscriptionManager != null) {
            try {
                list = subscriptionManager.getActiveSubscriptionInfoList();
            } catch (Throwable th) {
                Log.e("BlockUtils", "" + th);
            }
        }
        if (list != null) {
            for (SubscriptionInfo subscriptionInfo : list) {
                if (u(context, subscriptionInfo.getSimSlotIndex())) {
                    list.remove(subscriptionInfo);
                    return list;
                }
            }
        }
        if (list == null) {
            return new ArrayList();
        }
        return list;
    }

    public static int b(Context context, float f10) {
        return (int) ((f10 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static void c(Context context) {
        try {
            ArrayList arrayList = new ArrayList();
            String packageName = context.getPackageName();
            arrayList.add(packageName);
            F6.b.c(packageName, arrayList);
        } catch (Throwable th) {
            Log.e("BlockUtils", "e = " + th);
        }
    }

    public static String d(int i10) {
        return String.format(Locale.getDefault(), "%d", Integer.valueOf(i10));
    }

    public static Intent e(ArrayList<String> arrayList, boolean z10, boolean z11, boolean z12) {
        Intent intent = new Intent(f29159a);
        intent.putStringArrayListExtra("number_list", arrayList);
        intent.putExtra("is_insert_blacklist", z10);
        intent.putExtra("need_restore_intercept_record", z11);
        intent.putExtra("restore_blacklist_number_record", z12);
        return intent;
    }

    public static List<ComponentName> f(Context context, String str) {
        Intent intent = new Intent(str);
        ArrayList arrayList = new ArrayList();
        Iterator<ResolveInfo> it = context.getPackageManager().queryBroadcastReceivers(intent, 0).iterator();
        while (it.hasNext()) {
            ActivityInfo activityInfo = it.next().activityInfo;
            arrayList.add(new ComponentName(activityInfo.packageName, activityInfo.name));
        }
        return arrayList;
    }

    public static V6.a g(Context context, String str, long j10) {
        V6.a aVar;
        Object valueOf;
        Cursor cursor = null;
        r0 = null;
        r0 = null;
        V6.a aVar2 = null;
        cursor = null;
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            try {
                String B10 = B(str);
                if (TextUtils.isEmpty(B10)) {
                    I9.a.a(null);
                    return null;
                }
                Uri build = C0848i.j(context, B10).buildUpon().appendQueryParameter("query_vip", "true").build();
                if (j10 > 0) {
                    build = Uri.withAppendedPath(build, Long.toString(j10));
                }
                Cursor query = context.getContentResolver().query(build, C0855p.b.f29176b, null, null, null);
                if (query != null) {
                    try {
                        try {
                            if (query.moveToFirst()) {
                                aVar = new V6.a();
                                boolean z10 = false;
                                try {
                                    aVar.f4010a = query.getLong(0);
                                    aVar.f4012c = query.getString(1);
                                    if (query.getInt(2) > 0) {
                                        z10 = true;
                                    }
                                    aVar.f4024o = z10;
                                    aVar2 = aVar;
                                } catch (Exception e10) {
                                    e = e10;
                                    cursor = query;
                                    e = e;
                                    Log.e("BlockUtils", "Exception:" + e);
                                    I9.a.a(cursor);
                                    return aVar;
                                }
                            }
                        } catch (Exception e11) {
                            e = e11;
                            aVar = aVar2;
                        }
                    } catch (Throwable th) {
                        cursor = query;
                        th = th;
                        I9.a.a(cursor);
                        throw th;
                    }
                }
                StringBuilder sb = new StringBuilder();
                sb.append("getContactInfo isVipContact = ");
                if (aVar2 == null) {
                    valueOf = "false";
                } else {
                    valueOf = Boolean.valueOf(aVar2.f4024o);
                }
                sb.append(valueOf);
                sb.append(" ,number = ");
                sb.append(C0846g.f(B10));
                v(sb.toString());
                I9.a.a(query);
                return aVar2;
            } catch (Exception e12) {
                e = e12;
                aVar = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static int h(Context context) {
        int identifier;
        if (context == null || (identifier = context.getResources().getIdentifier("navigation_bar_height", "dimen", "android")) <= 0) {
            return 0;
        }
        return context.getResources().getDimensionPixelSize(identifier);
    }

    public static int i(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static Intent j(ArrayList<String> arrayList, boolean z10) {
        Intent intent = new Intent(f29159a);
        intent.putStringArrayListExtra("shop_id_list", arrayList);
        intent.putExtra("is_shop_type", true);
        intent.putExtra("is_insert_blacklist", z10);
        return intent;
    }

    public static int k(Context context) {
        List<SubscriptionInfo> a10 = a(context);
        if (a10.isEmpty()) {
            return 0;
        }
        return a10.size();
    }

    public static int l(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return context.getResources().getDimensionPixelOffset(C6.f.f387a);
    }

    public static boolean m(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null || !telephonyManager.hasIccCard() || n(context)) {
            return false;
        }
        return true;
    }

    public static boolean n(Context context) {
        if (context == null) {
            Log.e("BlockUtils", "hasSoftSimCard false, context is null");
            return false;
        }
        boolean e10 = F6.b.e(context);
        C0846g.i("BlockUtils", "hasSoftSimCard " + e10);
        return e10;
    }

    public static int o(Context context, String str, int i10, String str2, int i11) {
        long j10;
        V6.a g10 = g(context, str, 0L);
        if (i10 == 1) {
            if (g10 != null && g10.f4024o) {
                return 1;
            }
            if (r(context, str)) {
                return 3;
            }
        }
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(C0855p.a.f29171a);
        ContentValues contentValues = new ContentValues(4);
        if (g10 != null) {
            if (!TextUtils.isEmpty(g10.f4012c)) {
                contentValues.put("name", g10.f4012c);
            }
            j10 = g10.f4010a;
        } else {
            j10 = -1;
        }
        contentValues.put(OplusNumberMarkUtils.OplusBlacklist.CONTACTID, Long.valueOf(j10));
        contentValues.put("number", str);
        if (!TextUtils.isEmpty(str2)) {
            contentValues.put("note", str2);
        }
        contentValues.put("function_type", Integer.valueOf(i11));
        if (i10 == 1) {
            contentValues.put(OplusNumberMarkUtils.OplusBlacklist.BLOCK_TYPE, (Integer) 3);
        } else {
            contentValues.put(OplusNumberMarkUtils.OplusBlacklist.BLOCK_TYPE, (Integer) 0);
        }
        contentValues.put(OplusNumberMarkUtils.OplusBlacklist.LIST_TYPE, Integer.valueOf(i10));
        newInsert.withValues(contentValues);
        arrayList2.add(str);
        arrayList.add(newInsert.build());
        try {
            context.getContentResolver().applyBatch(com.oplus.blacklist.database.a.f26232a, arrayList);
            if (i10 == 1) {
                x(context, arrayList2, true, false, false, i11);
            } else {
                x(context, arrayList2, false, true, false, 0);
            }
        } catch (OperationApplicationException e10) {
            Log.e("BlockUtils", "e = " + e10);
        } catch (RemoteException e11) {
            Log.e("BlockUtils", "e = " + e11);
        } catch (Exception e12) {
            Log.e("BlockUtils", "e = " + e12);
        }
        return 0;
    }

    public static void p(Context context, String str, int i10) {
        v("insertPrefixBlackNumber number = " + C0846g.f(str));
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(C0855p.c.f29177a);
        ContentValues contentValues = new ContentValues(4);
        contentValues.put(OplusNumberMarkUtils.OplusBlacklist.CONTACTID, (Long) (-1L));
        contentValues.put("number", str);
        contentValues.put(OplusNumberMarkUtils.OplusBlacklist.BLOCK_TYPE, (Integer) 3);
        contentValues.put(OplusNumberMarkUtils.OplusBlacklist.LIST_TYPE, (Integer) 3);
        contentValues.put("function_type", Integer.valueOf(i10));
        newInsert.withValues(contentValues);
        arrayList.add(newInsert.build());
        try {
            context.getContentResolver().applyBatch(com.oplus.blacklist.database.a.f26232a, arrayList);
        } catch (Exception e10) {
            Log.e("BlockUtils", "e = " + e10);
        }
    }

    public static boolean q(Context context, String str) {
        boolean z10 = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            try {
                Cursor query = context.getContentResolver().query(Uri.withAppendedPath(C0855p.a.f29172b, str), null, "block_type=? AND list_type=?", new String[]{String.valueOf(3), String.valueOf(1)}, null);
                if (query == null) {
                    I9.a.a(query);
                    return false;
                }
                int count = query.getCount();
                C0846g.i("BlockUtils", "isInBlackList(), i = " + count);
                if (count > 0) {
                    z10 = true;
                }
                I9.a.a(query);
                return z10;
            } catch (Exception e10) {
                Log.e("BlockUtils", "Exception:" + e10);
                I9.a.a(null);
                return false;
            }
        } catch (Throwable th) {
            I9.a.a(null);
            throw th;
        }
    }

    public static boolean r(Context context, String str) {
        boolean z10 = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            try {
                Cursor query = context.getContentResolver().query(Uri.withAppendedPath(C0855p.a.f29172b, str), null, "list_type=?", new String[]{"2"}, null);
                if (query == null) {
                    I9.a.a(query);
                    return false;
                }
                int count = query.getCount();
                Log.i("BlockUtils", "isInWhiteList(), i = " + count);
                if (count > 0) {
                    z10 = true;
                }
                I9.a.a(query);
                return z10;
            } catch (Exception e10) {
                Log.e("BlockUtils", "Exception:" + e10);
                I9.a.a(null);
                return false;
            }
        } catch (Throwable th) {
            I9.a.a(null);
            throw th;
        }
    }

    public static boolean s(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable() || !activeNetworkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    public static boolean t(String str) {
        int length;
        if (str == null) {
            length = 0;
        } else {
            length = str.length();
        }
        if (length <= 0) {
            return true;
        }
        for (int i10 = 0; i10 < length; i10++) {
            if (!PhoneNumberUtils.isNonSeparator(Character.toUpperCase(str.charAt(i10)))) {
                return false;
            }
        }
        return true;
    }

    public static boolean u(Context context, int i10) {
        if (context == null) {
            Log.e("BlockUtils", "isSoftSimCard false, context is null");
            return false;
        }
        if (i10 != F6.b.f(context)) {
            return false;
        }
        C0846g.i("BlockUtils", "isSoftSimCard true, slot " + i10);
        return true;
    }

    public static void v(String str) {
        if (C0846g.c()) {
            Log.d("BlockUtils", "info:" + str);
        }
    }

    public static void w(Context context) {
        if (C0846g.c()) {
            Log.d("BlockUtils", "sauCheckUpdate");
        }
        com.oplus.blacklistapp.framework.api.appstore.sau.a.a(context);
    }

    public static void x(Context context, ArrayList<String> arrayList, boolean z10, boolean z11, boolean z12, int i10) {
        if (context == null) {
            return;
        }
        for (ComponentName componentName : f(context, f29159a)) {
            if (i10 != 1 || "com.android.providers.contacts".equals(componentName.getPackageName())) {
                if (i10 != 2 || C1629c.f37420f.contains(componentName.getPackageName())) {
                    Intent e10 = e(arrayList, z10, z11, z12);
                    e10.setComponent(componentName);
                    v("componentName = " + componentName);
                    context.sendBroadcast(e10, OplusPhoneUtils.PERMISSION_OPLUS_COMPONENT_SAFE);
                }
            }
        }
        if (!l7.b.h(context)) {
            context.sendBroadcast(e(arrayList, z10, z11, z12), OplusPhoneUtils.PERMISSION_OPLUS_COMPONENT_SAFE);
        }
    }

    public static void y(Context context, ArrayList<String> arrayList, boolean z10) {
        if (context == null) {
            return;
        }
        for (ComponentName componentName : f(context, f29159a)) {
            Intent j10 = j(arrayList, z10);
            j10.setComponent(componentName);
            v("componentName = " + componentName);
            context.sendBroadcast(j10, OplusPhoneUtils.PERMISSION_OPLUS_COMPONENT_SAFE);
        }
        context.sendBroadcast(j(arrayList, z10), OplusPhoneUtils.PERMISSION_OPLUS_COMPONENT_SAFE);
    }

    public static void z(Context context) {
        if (context != null && !C0844e.f29134b) {
            Intent intent = new Intent("oppo.intent.action.BLACKLIST_SHARED_PREFERENCE_CHANGE");
            intent.setPackage("com.heytap.health");
            context.sendBroadcast(intent, OplusPhoneUtils.PERMISSION_OPLUS_COMPONENT_SAFE);
        }
    }
}
