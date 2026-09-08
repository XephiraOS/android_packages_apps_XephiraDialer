package com.customize.contacts.util;

import R0.c;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.android.contacts.assisteddialing.TransformationInfo;
import com.android.incallui.OplusAutoRedialNotificationUI;
import com.android.incallui.OplusPhoneUtils;
import com.customize.contacts.FeatureOption;
import com.oplus.dialer.R;
import h1.C1072a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import q0.C1479d;

/* compiled from: AssistedDialingUtils.java */
/* renamed from: com.customize.contacts.util.e, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0794e {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f22086a = true;

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f22087b = Pattern.compile(",");

    /* renamed from: c, reason: collision with root package name */
    public static Comparator<b> f22088c = new a();

    /* compiled from: AssistedDialingUtils.java */
    /* renamed from: com.customize.contacts.util.e$a */
    /* loaded from: classes3.dex */
    public class a implements Comparator<b> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(b bVar, b bVar2) {
            if (H7.a.b()) {
                H7.b.b("AssistedDialingUtils", "compare : arg0.mBucketPrimary = " + bVar.f22093e + ", arg1.mBucketPrimary = " + bVar2.f22093e);
            }
            int i10 = bVar.f22093e;
            int i11 = bVar2.f22093e;
            if (i10 != i11) {
                if (i10 <= i11) {
                    return -1;
                }
                return 1;
            }
            if (bVar.b() == null) {
                return -1;
            }
            if (bVar2.b() == null) {
                return 1;
            }
            int compareTo = bVar.b().compareTo(bVar2.b());
            if (H7.a.b()) {
                H7.b.b("AssistedDialingUtils", "result = " + compareTo);
            }
            return compareTo;
        }
    }

    /* compiled from: AssistedDialingUtils.java */
    /* renamed from: com.customize.contacts.util.e$b */
    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f22089a;

        /* renamed from: b, reason: collision with root package name */
        public char f22090b;

        /* renamed from: c, reason: collision with root package name */
        public int f22091c;

        /* renamed from: d, reason: collision with root package name */
        public String f22092d;

        /* renamed from: e, reason: collision with root package name */
        public int f22093e;

        public final String b() {
            return this.f22089a;
        }
    }

    /* compiled from: AssistedDialingUtils.java */
    /* renamed from: com.customize.contacts.util.e$c */
    /* loaded from: classes3.dex */
    public static class c extends CursorWrapper {

        /* renamed from: a, reason: collision with root package name */
        public final Cursor f22094a;

        /* renamed from: b, reason: collision with root package name */
        public int f22095b;

        /* renamed from: c, reason: collision with root package name */
        public int[] f22096c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f22097d;

        /* renamed from: e, reason: collision with root package name */
        public List<b> f22098e;

        public c(Cursor cursor, int[] iArr, List<b> list) {
            super(cursor);
            this.f22095b = 0;
            this.f22097d = false;
            this.f22094a = cursor;
            this.f22096c = iArr;
            this.f22098e = list;
        }

        public Bundle a() {
            Bundle bundle = new Bundle();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            char c10 = '@';
            String str = null;
            int i10 = 0;
            int i11 = 0;
            for (b bVar : this.f22098e) {
                if (c10 == bVar.f22090b) {
                    i11++;
                    if (TextUtils.equals(str, bVar.f22092d)) {
                        i10++;
                    } else {
                        if (i10 > 0) {
                            arrayList.add(str);
                            arrayList2.add(Integer.valueOf(i10));
                        }
                        i10 = 1;
                    }
                } else {
                    if (i10 > 0) {
                        arrayList.add(str);
                        arrayList2.add(Integer.valueOf(i10));
                    }
                    if (i11 > 0) {
                        arrayList3.add(Character.valueOf(c10));
                        arrayList4.add(Integer.valueOf(i11));
                        String obj = arrayList.toString();
                        bundle.putStringArray(c10 + "titles", C0794e.f22087b.split(U7.f.f(obj.substring(1, obj.length() - 1))));
                        String obj2 = arrayList2.toString();
                        String[] split = C0794e.f22087b.split(U7.f.f(obj2.substring(1, obj2.length() - 1)));
                        int[] iArr = new int[split.length];
                        for (int i12 = 0; i12 < split.length; i12++) {
                            iArr[i12] = Integer.parseInt(split[i12]);
                        }
                        bundle.putIntArray(c10 + "counts", iArr);
                        arrayList.clear();
                        arrayList2.clear();
                    }
                    i10 = 1;
                    i11 = 1;
                }
                c10 = bVar.f22090b;
                str = bVar.f22092d;
            }
            if (i10 > 0) {
                arrayList.add(str);
                arrayList2.add(Integer.valueOf(i10));
            }
            if (i11 > 0) {
                arrayList3.add(Character.valueOf(c10));
                arrayList4.add(Integer.valueOf(i11));
                String obj3 = arrayList.toString();
                bundle.putStringArray(c10 + "titles", C0794e.f22087b.split(U7.f.f(obj3.substring(1, obj3.length() - 1))));
                String obj4 = arrayList2.toString();
                String[] split2 = C0794e.f22087b.split(U7.f.f(obj4.substring(1, obj4.length() - 1)));
                int[] iArr2 = new int[split2.length];
                for (int i13 = 0; i13 < split2.length; i13++) {
                    iArr2[i13] = Integer.parseInt(split2[i13]);
                }
                bundle.putIntArray(c10 + "counts", iArr2);
                arrayList.clear();
                arrayList2.clear();
            }
            String obj5 = arrayList3.toString();
            bundle.putStringArray("extra_address_book_index_title", C0794e.f22087b.split(C0794e.k(obj5.substring(1, obj5.length() - 1))));
            String obj6 = arrayList4.toString();
            String[] split3 = C0794e.f22087b.split(C0794e.k(obj6.substring(1, obj6.length() - 1)));
            int[] iArr3 = new int[split3.length];
            for (int i14 = 0; i14 < split3.length; i14++) {
                iArr3[i14] = Integer.parseInt(split3[i14]);
            }
            bundle.putIntArray("extra_address_book_index_count", iArr3);
            return bundle;
        }

        public int c() {
            int[] iArr;
            int i10 = this.f22095b;
            if (-1 != i10 && (iArr = this.f22096c) != null && i10 < iArr.length) {
                return iArr[i10];
            }
            return i10;
        }

        @Override // android.database.CursorWrapper, android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f22094a.close();
            List<b> list = this.f22098e;
            if (list != null) {
                list.clear();
            }
        }

        @Override // android.database.CursorWrapper, android.database.Cursor
        public int getPosition() {
            return this.f22095b;
        }

        @Override // android.database.CursorWrapper, android.database.Cursor
        public boolean isClosed() {
            if (this.f22097d) {
                return true;
            }
            return super.isClosed();
        }

        @Override // android.database.CursorWrapper, android.database.Cursor
        public boolean move(int i10) {
            int i11 = this.f22095b;
            this.f22095b = i10 + i11;
            try {
                boolean moveToPosition = this.f22094a.moveToPosition(c());
                if (!moveToPosition) {
                    this.f22095b = i11;
                }
                return moveToPosition;
            } catch (Exception e10) {
                H7.b.c("AssistedDialingUtils", "Exception e: " + e10);
                this.f22095b = i11;
                return false;
            }
        }

        @Override // android.database.CursorWrapper, android.database.Cursor
        public boolean moveToFirst() {
            int i10 = this.f22095b;
            this.f22095b = 0;
            try {
                boolean moveToPosition = this.f22094a.moveToPosition(c());
                if (!moveToPosition) {
                    this.f22095b = i10;
                }
                return moveToPosition;
            } catch (Exception e10) {
                H7.b.c("AssistedDialingUtils", "Exception e: " + e10);
                this.f22095b = i10;
                return false;
            }
        }

        @Override // android.database.CursorWrapper, android.database.Cursor
        public boolean moveToLast() {
            int i10 = this.f22095b;
            this.f22095b = getCount() - 1;
            try {
                boolean moveToPosition = this.f22094a.moveToPosition(c());
                if (!moveToPosition) {
                    this.f22095b = i10;
                }
                return moveToPosition;
            } catch (Exception e10) {
                H7.b.c("AssistedDialingUtils", "Exception e: " + e10);
                this.f22095b = i10;
                return false;
            }
        }

        @Override // android.database.CursorWrapper, android.database.Cursor
        public boolean moveToNext() {
            int i10 = this.f22095b;
            this.f22095b = i10 + 1;
            try {
                boolean moveToPosition = this.f22094a.moveToPosition(c());
                if (!moveToPosition) {
                    this.f22095b = i10;
                }
                return moveToPosition;
            } catch (Exception e10) {
                H7.b.c("AssistedDialingUtils", "Exception e: " + e10);
                this.f22095b = i10;
                return false;
            }
        }

        @Override // android.database.CursorWrapper, android.database.Cursor
        public boolean moveToPosition(int i10) {
            int i11 = this.f22095b;
            this.f22095b = i10;
            try {
                boolean moveToPosition = this.f22094a.moveToPosition(c());
                if (!moveToPosition && -1 != this.f22095b) {
                    this.f22095b = i11;
                }
                return moveToPosition;
            } catch (Exception e10) {
                H7.b.c("AssistedDialingUtils", "Exception e: " + e10);
                this.f22095b = i11;
                return false;
            }
        }

        @Override // android.database.CursorWrapper, android.database.Cursor
        public boolean moveToPrevious() {
            int i10 = this.f22095b;
            this.f22095b = i10 - 1;
            try {
                boolean moveToPosition = this.f22094a.moveToPosition(c());
                if (!moveToPosition) {
                    this.f22095b = i10;
                }
                return moveToPosition;
            } catch (Exception e10) {
                H7.b.c("AssistedDialingUtils", "Exception e: " + e10);
                this.f22095b = i10;
                return false;
            }
        }
    }

    public static void b(Context context, Intent intent, String str) {
        int i10;
        if (context != null && h()) {
            int j10 = b0.j();
            if (j10 > 0) {
                if (!b0.B0(context)) {
                    i10 = b0.k(context);
                } else {
                    i10 = -1;
                }
                int i11 = i10;
                c(context, intent, str, j10, D7.a.p(), i11);
                c(context, intent, str, j10, D7.a.q(), i11);
            }
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            HashMap hashMap = new HashMap();
            hashMap.put(OplusAutoRedialNotificationUI.TIME, String.valueOf(System.currentTimeMillis()));
            hashMap.put("sim_one_country_iso", defaultSharedPreferences.getString("sim_one_country_iso", ""));
            hashMap.put("sim_two_country_iso", defaultSharedPreferences.getString("sim_two_country_iso", ""));
            com.android.contacts.framework.baseui.util.A.a(context, 2000303, 200030322, hashMap, false);
        }
    }

    public static void c(Context context, Intent intent, String str, int i10, int i11, int i12) {
        String str2;
        if (b0.m0(context, i11)) {
            String e10 = e(context, i11, str);
            if (i10 > 1) {
                if (!TextUtils.equals(e10, str)) {
                    if (i11 == D7.a.p()) {
                        str2 = "sim_one_assisted_dialing_number";
                    } else {
                        str2 = "sim_two_assisted_dialing_number";
                    }
                    intent.putExtra(str2, e10);
                }
                if (i12 == i11) {
                    m(e10, intent);
                    return;
                }
                return;
            }
            if (i10 == 1) {
                m(e10, intent);
            }
        }
    }

    public static String d(Context context, String str, String str2) {
        if (str2 != null) {
            if (str2.equals("HK")) {
                return context.getResources().getString(R.string.oplus_hongkong);
            }
            if (str2.equals("MO")) {
                return context.getResources().getString(R.string.oplus_macau);
            }
            if (str2.equals("TW")) {
                if (FeatureOption.i()) {
                    return context.getResources().getString(R.string.oplus_taiwan);
                }
                if (TextUtils.equals(str, "台湾") || TextUtils.equals(str, "台灣")) {
                    return "台北";
                }
                return str;
            }
            return str;
        }
        return str;
    }

    public static String e(Context context, int i10, String str) {
        int r10 = D7.c.r(context, Integer.valueOf(i10));
        TelephonyManager createForSubscriptionId = ((TelephonyManager) context.getSystemService(TelephonyManager.class)).createForSubscriptionId(r10);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        j(context, defaultSharedPreferences);
        String string = defaultSharedPreferences.getString("assisted_dialing_" + r10, null);
        i("getTransformedNumber: userProvidedHomeCountry = ");
        Optional<TransformationInfo> a10 = C1479d.a(createForSubscriptionId, context, string).a(str);
        if (a10.isPresent()) {
            i("placeCall: transformedNumber = " + H7.a.d(a10.get().b()));
            return a10.get().b();
        }
        return str;
    }

    public static Cursor f(Cursor cursor, boolean z10, boolean z11) {
        int i10;
        String str;
        int i11;
        if (cursor == null) {
            return cursor;
        }
        int columnIndex = cursor.getColumnIndex("country_iso");
        if (-1 == columnIndex) {
            return new c(cursor, null, null);
        }
        C0805p e10 = C0805p.e();
        ArrayList arrayList = new ArrayList();
        cursor.moveToPosition(-1);
        while (true) {
            i10 = 0;
            if (!cursor.moveToNext()) {
                break;
            }
            b bVar = new b();
            bVar.f22089a = cursor.getString(columnIndex).substring(0, cursor.getString(columnIndex).length() - 3);
            bVar.f22091c = cursor.getPosition();
            if (!TextUtils.isEmpty(bVar.f22089a)) {
                i11 = e10.c(bVar.f22089a, z11);
                str = e10.d(i11);
            } else {
                str = "";
                i11 = 0;
            }
            if (TextUtils.isEmpty(str)) {
                i11 = e10.c(OplusPhoneUtils.DeviceState.UNLOCK_DEVICE, z11);
                str = e10.d(i11);
            }
            char[] charArray = str.toCharArray();
            if (charArray != null && charArray.length > 0) {
                bVar.f22090b = charArray[0];
            }
            if (H7.a.b()) {
                H7.b.b("AssistedDialingUtils", "phonebookBucketPrimary = " + i11 + " countryIso = " + bVar.f22089a);
            }
            bVar.f22093e = i11;
            if (!TextUtils.isEmpty(bVar.f22089a)) {
                bVar.f22092d = bVar.f22089a.substring(0, 1).toUpperCase();
            } else {
                bVar.f22092d = OplusPhoneUtils.DeviceState.UNLOCK_DEVICE;
            }
            arrayList.add(bVar);
        }
        if (z10 || z11) {
            Collections.sort(arrayList, f22088c);
        }
        int[] iArr = new int[cursor.getCount()];
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            iArr[i10] = ((b) it.next()).f22091c;
            i10++;
        }
        return new c(cursor, iArr, arrayList);
    }

    public static void g(Context context) {
        String str = c.a.f3199e;
        if (TextUtils.isEmpty(G0.c.j(context, 0, str))) {
            f22086a = true;
            G0.c.t(context, 0, str, "true");
        } else {
            f22086a = TextUtils.equals(G0.c.j(context, 0, str), "true");
        }
    }

    public static boolean h() {
        if (B3.a.f()) {
            H7.b.e("AssistedDialingUtils", "isAssistedDialingOpen return false because isDisableRoamingAssistant is true");
            return false;
        }
        return f22086a;
    }

    public static void i(String str) {
        if (H7.a.b()) {
            H7.b.b("AssistedDialingUtils", str);
        }
    }

    public static void j(Context context, SharedPreferences sharedPreferences) {
        String string = sharedPreferences.getString("sim_one_imsi", null);
        String string2 = sharedPreferences.getString("sim_two_imsi", null);
        if (!TextUtils.isEmpty(string) || !TextUtils.isEmpty(string2)) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            String b10 = O7.a.b(context, 0);
            int r10 = D7.c.r(context, 0);
            String b11 = O7.a.b(context, 1);
            int r11 = D7.c.r(context, 1);
            if (TextUtils.equals(b10, string)) {
                edit.putString("assisted_dialing_" + r10, sharedPreferences.getString("sim_one_country_iso", null));
            } else if (TextUtils.equals(b10, string2)) {
                edit.putString("assisted_dialing_" + r10, sharedPreferences.getString("sim_two_country_iso", null));
            }
            if (TextUtils.equals(b11, string)) {
                edit.putString("assisted_dialing_" + r11, sharedPreferences.getString("sim_one_country_iso", null));
            } else if (TextUtils.equals(b11, string2)) {
                edit.putString("assisted_dialing_" + r11, sharedPreferences.getString("sim_two_country_iso", null));
            }
            edit.remove("sim_one_imsi");
            edit.remove("sim_two_imsi");
            edit.remove("sim_one_country_iso");
            edit.remove("sim_two_country_iso");
            edit.apply();
        }
    }

    public static String k(String str) {
        return U7.f.f(str);
    }

    public static void l(boolean z10) {
        f22086a = z10;
    }

    public static void m(String str, Intent intent) {
        Uri fromParts;
        if (C1072a.f(str)) {
            fromParts = Uri.fromParts("sip", str, null);
        } else {
            fromParts = Uri.fromParts("tel", str, null);
        }
        intent.setData(fromParts);
    }
}
