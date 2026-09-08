package com.customize.contacts.util;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.hardware.display.DisplayManager;
import android.text.TextUtils;
import com.android.contacts.framework.baseui.activity.BasicActivity;
import com.android.contacts.model.EntityDelta;
import com.android.incallui.OplusPhoneUtils;
import com.heytap.accessory.constant.AFConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;

/* compiled from: StatisticsActionUtils.kt */
/* loaded from: classes3.dex */
public final class h0 {

    /* renamed from: a, reason: collision with root package name */
    public static final h0 f22127a = new h0();

    public static final void A(Context context, String value) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(value, "value");
        HashMap hashMap = new HashMap();
        hashMap.put("enter_page", value);
        com.android.contacts.framework.baseui.util.A.a(context, 2000325, 200035801, hashMap, false);
    }

    public static final void B(Context context, String value) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(value, "value");
        HashMap hashMap = new HashMap();
        hashMap.put("double_check", value);
        com.android.contacts.framework.baseui.util.A.a(context, 2000325, 200035802, hashMap, false);
    }

    public static final void C(Context context, String value) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(value, "value");
        HashMap hashMap = new HashMap();
        hashMap.put("other", value);
        com.android.contacts.framework.baseui.util.A.a(context, 2000325, 200035804, hashMap, false);
    }

    public static final void D(Context context, String value) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(value, "value");
        HashMap hashMap = new HashMap();
        hashMap.put("click_item", value);
        com.android.contacts.framework.baseui.util.A.a(context, 2000325, 200035802, hashMap, false);
    }

    public static final void E(Context context, String value) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(value, "value");
        HashMap hashMap = new HashMap();
        hashMap.put("add_way", value);
        com.android.contacts.framework.baseui.util.A.a(context, 2000310, 200032804, hashMap, false);
    }

    public static final void F(Context context, String value) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(value, "value");
        HashMap hashMap = new HashMap();
        hashMap.put("double_check", value);
        com.android.contacts.framework.baseui.util.A.a(context, 2000310, 200032804, hashMap, false);
    }

    public static final void G(Context context, String value) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(value, "value");
        HashMap hashMap = new HashMap();
        hashMap.put("change_after", value);
        com.android.contacts.framework.baseui.util.A.a(context, 2000310, 200032801, hashMap, false);
    }

    public static final void H(Context context, String value) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(value, "value");
        HashMap hashMap = new HashMap();
        hashMap.put("change_before", value);
        com.android.contacts.framework.baseui.util.A.a(context, 2000310, 200032801, hashMap, false);
    }

    public static final void I(Context context, String value) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(value, "value");
        HashMap hashMap = new HashMap();
        hashMap.put("abnormal", value);
        com.android.contacts.framework.baseui.util.A.a(context, 2000310, 200032802, hashMap, false);
    }

    public static final void J(Context context, String value) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(value, "value");
        HashMap hashMap = new HashMap();
        hashMap.put("change_result", value);
        com.android.contacts.framework.baseui.util.A.a(context, 2000310, 200032802, hashMap, false);
    }

    public static final void K(Context context, boolean z10, String value) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(value, "value");
        HashMap hashMap = new HashMap();
        hashMap.put("delete_field", f22127a.h0(z10) + value);
        com.android.contacts.framework.baseui.util.A.a(context, 2000310, 200032806, hashMap, false);
    }

    public static final void L(Context context, boolean z10, String value) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(value, "value");
        HashMap hashMap = new HashMap();
        hashMap.put("input_field", f22127a.h0(z10) + value);
        com.android.contacts.framework.baseui.util.A.a(context, 2000310, 200032806, hashMap, false);
    }

    public static final void M(Context context, boolean z10, String value) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(value, "value");
        HashMap hashMap = new HashMap();
        hashMap.put("click_entrance", f22127a.h0(z10) + value);
        com.android.contacts.framework.baseui.util.A.a(context, 2000310, 200032806, hashMap, false);
    }

    public static final void N(Context context, boolean z10, String value) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(value, "value");
        HashMap hashMap = new HashMap();
        hashMap.put("tag", f22127a.h0(z10) + value);
        com.android.contacts.framework.baseui.util.A.a(context, 2000310, 200032806, hashMap, false);
    }

    public static final void O(Context context, String value) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(value, "value");
        HashMap hashMap = new HashMap();
        hashMap.put("double_check", value);
        com.android.contacts.framework.baseui.util.A.a(context, 2000310, 200032803, hashMap, false);
    }

    public static final void P(Context context, boolean z10, String value) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(value, "value");
        HashMap hashMap = new HashMap();
        hashMap.put("click_item", f22127a.h0(z10) + value);
        com.android.contacts.framework.baseui.util.A.a(context, 2000310, 200032803, hashMap, false);
    }

    public static final void Q(Context context, String network, String clickAction) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(network, "network");
        kotlin.jvm.internal.i.f(clickAction, "clickAction");
        HashMap hashMap = new HashMap();
        hashMap.put(network, clickAction);
        com.android.contacts.framework.baseui.util.A.a(context, 2000303, 200031412, hashMap, false);
    }

    public static final void R(Context context, int i10, String key, String value) {
        kotlin.jvm.internal.i.f(key, "key");
        kotlin.jvm.internal.i.f(value, "value");
        HashMap hashMap = new HashMap();
        hashMap.put(key, value);
        com.android.contacts.framework.baseui.util.A.a(context, k0(i10), f0(i10), hashMap, false);
    }

    public static final void S(Context context, int i10, String key, String value) {
        kotlin.jvm.internal.i.f(key, "key");
        kotlin.jvm.internal.i.f(value, "value");
        HashMap hashMap = new HashMap();
        hashMap.put(key, value);
        int k02 = k0(i10);
        int g02 = g0(i10);
        H7.b.e("StatisticsActionUtils", "tag = " + k02 + ", userAction =" + g02 + ", key =" + key + ", value = " + value);
        com.android.contacts.framework.baseui.util.A.a(context, k02, g02, hashMap, false);
    }

    public static final void T(Context context, int i10, String key, String value) {
        kotlin.jvm.internal.i.f(key, "key");
        kotlin.jvm.internal.i.f(value, "value");
        HashMap hashMap = new HashMap();
        hashMap.put(key, value);
        com.android.contacts.framework.baseui.util.A.a(context, k0(i10), j0(i10), hashMap, false);
    }

    public static final void U(HashMap<String, Integer> map, boolean z10, Context context) {
        kotlin.jvm.internal.i.f(map, "map");
        map.put("state", 1);
        if (z10) {
            map.put("view_position", 1);
        } else {
            map.put("view_position", 2);
        }
        com.android.contacts.framework.baseui.util.A.a(context, 2000311, 200030179, map, false);
    }

    public static final void V(Context context, String notificationId, String clickAction, int i10) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(notificationId, "notificationId");
        kotlin.jvm.internal.i.f(clickAction, "clickAction");
        HashMap hashMap = new HashMap();
        if (TextUtils.equals(clickAction, "ignore")) {
            hashMap.put("card_click", clickAction);
        }
        int hashCode = notificationId.hashCode();
        if (hashCode != -437939055) {
            if (hashCode != -373373530) {
                if (hashCode == 1229549512 && notificationId.equals("duplicate contacts")) {
                    if (TextUtils.equals(clickAction, AFConstants.EXTRA_INTENT_ACTION)) {
                        hashMap.put("card_click", "merge");
                    }
                    hashMap.put("ignore_time", String.valueOf(i10));
                    com.android.contacts.framework.baseui.util.A.a(context, 2000306, 200032004, hashMap, false);
                    return;
                }
                return;
            }
            if (!notificationId.equals("cloud sync")) {
                return;
            }
        } else if (!notificationId.equals("cloud recommend")) {
            return;
        }
        if (TextUtils.equals(clickAction, AFConstants.EXTRA_INTENT_ACTION)) {
            hashMap.put("card_click", "open");
        }
        hashMap.put("ignore_time", String.valueOf(i10));
        com.android.contacts.framework.baseui.util.A.a(context, 2000306, 200032003, hashMap, false);
    }

    public static final void W(Context context, int i10, String isMeetCondition) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(isMeetCondition, "isMeetCondition");
        HashMap hashMap = new HashMap();
        hashMap.put("duplicate_contact_count", String.valueOf(i10));
        hashMap.put("recommended", isMeetCondition);
        com.android.contacts.framework.baseui.util.A.a(context, 2000302, 200031202, hashMap, false);
    }

    public static final void X(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("state", 0);
        com.android.contacts.framework.baseui.util.A.a(context, 2000311, 200030179, hashMap, false);
    }

    public static final void Y(int i10) {
        HashMap hashMap = new HashMap();
        hashMap.put("insert_special_name_entry", Integer.valueOf(i10));
        com.android.contacts.framework.baseui.util.A.a(P7.a.f2961a.a(), 2000304, 200031605, hashMap, false);
    }

    public static final void Z(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            HashMap hashMap = new HashMap();
            hashMap.put(str, str2);
            com.android.contacts.framework.baseui.util.A.a(context, 2000312, 200033201, hashMap, false);
        }
    }

    public static final void a(boolean z10) {
        String str;
        HashMap hashMap = new HashMap();
        if (z10) {
            str = "agree";
        } else {
            str = "disagree";
        }
        hashMap.put("identification_of_unknown_numbers", str);
        com.android.contacts.framework.baseui.util.A.a(P7.a.f2961a.a(), 2000323, 200035414, hashMap, false);
    }

    public static final void a0(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("service_partner", str);
        com.android.contacts.framework.baseui.util.A.a(P7.a.f2961a.a(), 2000318, 200034406, hashMap, false);
    }

    public static final void b(Context context, int i10, String clickAction) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(clickAction, "clickAction");
        HashMap hashMap = new HashMap();
        hashMap.put(AFConstants.EXTRA_INTENT_ACTION, clickAction);
        com.android.contacts.framework.baseui.util.A.a(context, 2000303, i10, hashMap, false);
    }

    public static final Map<String, String> b0(Context context) {
        boolean z10;
        CharSequence charSequence;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (context == null) {
            H7.b.c("StatisticsActionUtils", "activityContext is null");
            return linkedHashMap;
        }
        Boolean bool = null;
        if (context instanceof BasicActivity) {
            String r02 = ((BasicActivity) context).r0();
            if (r02 == null) {
                r02 = "unknown";
            }
            if (!TextUtils.isEmpty(r02)) {
                linkedHashMap.put("calling_package_name", r02);
                try {
                    PackageManager packageManager = ((BasicActivity) context).getPackageManager();
                    ApplicationInfo applicationInfo = packageManager.getPackageInfo(r02, 0).applicationInfo;
                    if (applicationInfo != null) {
                        charSequence = applicationInfo.loadLabel(packageManager);
                    } else {
                        charSequence = null;
                    }
                    linkedHashMap.put("calling_app_name", String.valueOf(charSequence));
                } catch (PackageManager.NameNotFoundException e10) {
                    H7.b.c("StatisticsActionUtils", "e = " + e10);
                }
            }
        }
        try {
            Result.a aVar = Result.f34166a;
            Object systemService = context.getSystemService("display");
            kotlin.jvm.internal.i.d(systemService, "null cannot be cast to non-null type android.hardware.display.DisplayManager");
            if (((DisplayManager) systemService).getDisplay(0).getState() == 2) {
                z10 = true;
            } else {
                z10 = false;
            }
            bool = Boolean.valueOf(z10);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            Throwable d10 = Result.d(Result.b(kotlin.b.a(th)));
            if (d10 != null) {
                StackTraceElement stackTraceElement = d10.getStackTrace()[0];
                int lineNumber = stackTraceElement.getLineNumber();
                String methodName = stackTraceElement.getMethodName();
                H7.b.c(stackTraceElement.getClassName(), "line:" + lineNumber + " " + methodName + " " + d10.getMessage());
            }
        }
        linkedHashMap.put("screen_on", String.valueOf(bool));
        return linkedHashMap;
    }

    public static final void c(Context context, int i10, String clickAction) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(clickAction, "clickAction");
        HashMap hashMap = new HashMap();
        hashMap.put(AFConstants.EXTRA_INTENT_ACTION, clickAction);
        com.android.contacts.framework.baseui.util.A.a(context, 2000303, i10, hashMap, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.util.HashMap<java.lang.String, java.lang.String> c0(java.lang.String r3, boolean r4, boolean r5, int r6) {
        /*
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            if (r3 == 0) goto L3e
            int r1 = r3.hashCode()
            r2 = -1569536764(0xffffffffa272c504, float:-3.2901415E-18)
            if (r1 == r2) goto L32
            r2 = -1079224304(0xffffffffbfac5810, float:-1.3464375)
            if (r1 == r2) goto L27
            r2 = 684173810(0x28c7a9f2, float:2.216714E-14)
            if (r1 == r2) goto L1b
            goto L3e
        L1b:
            java.lang.String r1 = "vnd.android.cursor.item/phone_v2"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L24
            goto L3e
        L24:
            java.lang.String r3 = "phone"
            goto L40
        L27:
            java.lang.String r1 = "vnd.android.cursor.item/name"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L3e
            java.lang.String r3 = "name"
            goto L40
        L32:
            java.lang.String r1 = "vnd.android.cursor.item/email_v2"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L3b
            goto L3e
        L3b:
            java.lang.String r3 = "email"
            goto L40
        L3e:
            java.lang.String r3 = "known"
        L40:
            if (r4 == 0) goto L45
            java.lang.String r4 = "2-"
            goto L47
        L45:
            java.lang.String r4 = "1-"
        L47:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            if (r5 == 0) goto L5b
            java.lang.String r4 = "cancel"
            goto L5d
        L5b:
            java.lang.String r4 = "confirm"
        L5d:
            java.lang.String r5 = "click_type"
            r0.put(r5, r3)
            java.lang.String r3 = "associate_number"
            java.lang.String r5 = java.lang.String.valueOf(r6)
            r0.put(r3, r5)
            java.lang.String r3 = "double_check"
            r0.put(r3, r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.util.h0.c0(java.lang.String, boolean, boolean, int):java.util.HashMap");
    }

    public static final void d(Context context, String key, String value) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(key, "key");
        kotlin.jvm.internal.i.f(value, "value");
        HashMap hashMap = new HashMap();
        hashMap.put(key, value);
        com.android.contacts.framework.baseui.util.A.a(context, 2000309, 200032609, hashMap, false);
    }

    public static final String d0(int i10, int i11, String str, String str2, boolean z10) {
        int i12;
        if (z10) {
            i12 = 1000;
        } else {
            i12 = 3;
        }
        if (i10 == i12) {
            if (str != null) {
                return str;
            }
        } else if (i10 == -1 && i11 == i12) {
            if (str != null) {
                return str;
            }
        } else {
            return null;
        }
        return str2;
    }

    public static final void e(Context context, int i10, String clickAction) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(clickAction, "clickAction");
        HashMap hashMap = new HashMap();
        hashMap.put("click_item", clickAction);
        com.android.contacts.framework.baseui.util.A.a(context, 2000303, i10, hashMap, false);
    }

    public static final String e0(String str, String str2) {
        if (str != null && str2 != null) {
            if (F7.b.l(str) && !F7.b.l(str2)) {
                return "2";
            }
            if (F7.b.l(str2) && !F7.b.l(str)) {
                return "3";
            }
            if (!F7.b.l(str) && !F7.b.l(str2)) {
                return OplusPhoneUtils.DeviceState.LOCK_DEVICE;
            }
        }
        return null;
    }

    public static final void f(Context context, int i10, String clickAction, boolean z10) {
        String str;
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(clickAction, "clickAction");
        HashMap hashMap = new HashMap();
        hashMap.put("click_item", clickAction);
        if (z10) {
            str = "yes";
        } else {
            str = "no";
        }
        hashMap.put("super_power_saving", str);
        com.android.contacts.framework.baseui.util.A.a(context, 2000303, i10, hashMap, false);
    }

    public static final int f0(int i10) {
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 == 3) {
                    return 200035808;
                }
                return i10;
            }
            return 200032811;
        }
        return 200032612;
    }

    public static final void g(boolean z10) {
        String str;
        HashMap hashMap = new HashMap();
        if (z10) {
            str = "missed";
        } else {
            str = "all";
        }
        hashMap.put("click_filter", str);
        com.android.contacts.framework.baseui.util.A.a(P7.a.f2961a.a(), 2000303, 200031410, hashMap, false);
    }

    public static final int g0(int i10) {
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 == 3) {
                    return 200035806;
                }
                return i10;
            }
            return 200032809;
        }
        return 200032610;
    }

    public static final void h(int i10) {
        HashMap hashMap = new HashMap();
        hashMap.put("new_call_tips_click", Integer.valueOf(i10));
        com.android.contacts.framework.baseui.util.A.a(P7.a.f2961a.a(), 2000312, 200030323, hashMap, false);
    }

    public static final void i(boolean z10) {
        String str;
        HashMap hashMap = new HashMap();
        if (z10) {
            str = "ON";
        } else {
            str = "ignore";
        }
        hashMap.put("click_item", str);
        com.android.contacts.framework.baseui.util.A.a(P7.a.f2961a.a(), 2000303, 200031415, hashMap, false);
    }

    public static final String i0(int i10) {
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    if (i10 != 1000) {
                        return "custom";
                    }
                    return "lunar";
                }
                return "solar";
            }
            return "other";
        }
        return "anniversary";
    }

    public static final void j(Context context, ArrayList<EntityDelta.ValuesDelta> arrayList) {
        String e02;
        int i10;
        String str;
        int i11;
        String str2;
        String str3;
        int i12;
        Integer asInteger;
        kotlin.jvm.internal.i.f(context, "context");
        if (arrayList != null) {
            Iterator<EntityDelta.ValuesDelta> it = arrayList.iterator();
            String str4 = null;
            String str5 = null;
            String str6 = null;
            String str7 = null;
            while (it.hasNext()) {
                EntityDelta.ValuesDelta next = it.next();
                ContentValues p10 = next.p();
                ContentValues A10 = next.A();
                if (A10 != null) {
                    str = A10.getAsString("data1");
                    Integer asInteger2 = A10.getAsInteger("data2");
                    if (asInteger2 == null) {
                        i10 = -1;
                    } else {
                        kotlin.jvm.internal.i.e(asInteger2, "before.getAsInteger(Cont…ontract.Data.DATA2) ?: -1");
                        i10 = asInteger2.intValue();
                    }
                } else {
                    i10 = -1;
                    str = null;
                }
                if (p10 != null) {
                    str2 = p10.getAsString("data1");
                    if (p10.containsKey("data2") && (asInteger = p10.getAsInteger("data2")) != null) {
                        kotlin.jvm.internal.i.e(asInteger, "after.getAsInteger(Conta…ontract.Data.DATA2) ?: -1");
                        i11 = asInteger.intValue();
                    } else {
                        i11 = -1;
                    }
                } else {
                    i11 = -1;
                    str2 = null;
                }
                if (A10 == null && p10 != null) {
                    l(context, i0(i11), l0(str2));
                    if (i11 != 3) {
                        if (i11 == 1000) {
                            str4 = str2;
                        }
                    } else {
                        str6 = str2;
                    }
                } else if (p10 != null && p10.size() > 1) {
                    if (str2 == null) {
                        str3 = str;
                    } else {
                        str3 = str2;
                    }
                    String l02 = l0(str3);
                    if (i11 != -1) {
                        i12 = i11;
                    } else {
                        i12 = i10;
                    }
                    l(context, i0(i12), l02);
                    if (str4 == null) {
                        str4 = d0(i11, i10, str2, str, true);
                    }
                    if (str6 == null) {
                        str6 = d0(i11, i10, str2, str, false);
                    }
                } else if (p10 != null && p10.size() == 1) {
                    if (i10 != 3) {
                        if (i10 == 1000) {
                            str5 = str;
                        }
                    } else {
                        str7 = str;
                    }
                }
            }
            if (str4 != null) {
                str5 = str4;
            }
            if (str6 != null) {
                str7 = str6;
            }
            if (str6 == null && str4 == null) {
                e02 = null;
            } else {
                e02 = e0(str5, str7);
            }
            if (e02 != null) {
                k(context, e02);
            }
        }
    }

    public static final int j0(int i10) {
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 == 3) {
                    return 200035807;
                }
                return i10;
            }
            return 200032810;
        }
        return 200032611;
    }

    public static final void k(Context context, String str) {
        kotlin.jvm.internal.i.f(context, "context");
        HashMap hashMap = new HashMap();
        hashMap.put("matching_error", str);
        com.android.contacts.framework.baseui.util.A.a(context, 2000310, 200032808, hashMap, false);
    }

    public static final int k0(int i10) {
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 == 3) {
                    return 2000325;
                }
                return i10;
            }
            return 2000310;
        }
        return 2000309;
    }

    public static final void l(Context context, String str, String str2) {
        kotlin.jvm.internal.i.f(context, "context");
        HashMap hashMap = new HashMap();
        hashMap.put("tag", str);
        hashMap.put("year_choose", str2);
        com.android.contacts.framework.baseui.util.A.a(context, 2000310, 200032808, hashMap, false);
    }

    public static final String l0(String str) {
        if (str == null) {
            return null;
        }
        if (F7.b.l(str)) {
            return "no";
        }
        return "yes";
    }

    public static final void m(Context context, String str, int i10) {
        HashMap hashMap = new HashMap();
        hashMap.put("delete_reason", str);
        hashMap.put("delete_count", String.valueOf(i10));
        com.android.contacts.framework.baseui.util.A.a(context, 2000302, 200031204, hashMap, false);
    }

    public static final void n(int i10, int i11, boolean z10, int i12, int i13, int i14, int i15, int i16, String str) {
        String str2;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("scenarios", String.valueOf(i10));
        linkedHashMap.put("action_type", String.valueOf(i11));
        if (z10) {
            str2 = OplusPhoneUtils.DeviceState.LOCK_DEVICE;
        } else {
            str2 = OplusPhoneUtils.DeviceState.UNLOCK_DEVICE;
        }
        linkedHashMap.put("checkbox", str2);
        linkedHashMap.put("deleted_count", String.valueOf(i12));
        linkedHashMap.put("delete_recording_count", String.valueOf(i13));
        linkedHashMap.put("delete_AInote_count", String.valueOf(i14));
        linkedHashMap.put("delete_breeno_count", String.valueOf(i15));
        linkedHashMap.put("delete_rtt_count", String.valueOf(i16));
        if (str != null) {
            linkedHashMap.put("delete_item_interval", str);
        }
        com.android.contacts.framework.baseui.util.A.a(P7.a.f2961a.a(), 2000303, 200031403, linkedHashMap, false);
    }

    public static final void o(Context context, String value) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(value, "value");
        q(context, value, null, 4, null);
    }

    public static final void p(Context context, String value, Map<String, String> map) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(value, "value");
        kotlin.jvm.internal.i.f(map, "map");
        map.put("click_list", value);
        com.android.contacts.framework.baseui.util.A.a(context, 2000309, 200032606, map, false);
    }

    public static /* synthetic */ void q(Context context, String str, Map map, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            map = new HashMap();
        }
        p(context, str, map);
    }

    public static final void r(Context context, String value) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(value, "value");
        t(context, value, null, 4, null);
    }

    public static final void s(Context context, String value, Map<String, String> map) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(value, "value");
        kotlin.jvm.internal.i.f(map, "map");
        map.put("number_click_bottom", value);
        com.android.contacts.framework.baseui.util.A.a(context, 2000309, 200032606, map, false);
    }

    public static /* synthetic */ void t(Context context, String str, Map map, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            map = new HashMap();
        }
        s(context, str, map);
    }

    public static final void u(Context context, String value) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(value, "value");
        HashMap hashMap = new HashMap();
        hashMap.put("long_press_list", value);
        com.android.contacts.framework.baseui.util.A.a(context, 2000309, 200032606, hashMap, false);
    }

    public static final void v(Context context, String key, String value) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(key, "key");
        kotlin.jvm.internal.i.f(value, "value");
        HashMap hashMap = new HashMap();
        hashMap.put(key, value);
        com.android.contacts.framework.baseui.util.A.a(context, 2000309, 200032607, hashMap, false);
    }

    public static final void w(Context context, String value) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(value, "value");
        HashMap hashMap = new HashMap();
        hashMap.put("click_item", value);
        com.android.contacts.framework.baseui.util.A.a(context, 2000309, 200032604, hashMap, false);
    }

    public static final void x(Context context, String key, String value) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(key, "key");
        kotlin.jvm.internal.i.f(value, "value");
        HashMap hashMap = new HashMap();
        hashMap.put(key, value);
        com.android.contacts.framework.baseui.util.A.a(context, 2000309, 200032604, hashMap, false);
    }

    public static final void y(Context context, String value, boolean z10) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(value, "value");
        HashMap hashMap = new HashMap();
        hashMap.put("profile_photo", value);
        if (z10) {
            com.android.contacts.framework.baseui.util.A.a(context, 2000325, 200035804, hashMap, false);
        } else {
            com.android.contacts.framework.baseui.util.A.a(context, 2000309, 200032608, hashMap, false);
        }
    }

    public static final void z(Context context, String value, boolean z10) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(value, "value");
        HashMap hashMap = new HashMap();
        hashMap.put("share_way", value);
        if (z10) {
            com.android.contacts.framework.baseui.util.A.a(context, 2000325, 200035803, hashMap, false);
        } else {
            com.android.contacts.framework.baseui.util.A.a(context, 2000309, 200032605, hashMap, false);
        }
    }

    public final String h0(boolean z10) {
        if (z10) {
            return "2_";
        }
        return "1_";
    }
}
