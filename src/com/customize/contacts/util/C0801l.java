package com.customize.contacts.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.provider.CallLog;
import android.provider.Settings;
import android.text.TextUtils;
import android.widget.ImageView;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.incallui.OplusPhoneUtils;
import com.customize.contacts.FeatureOption;
import com.oplus.dialer.R;
import h1.C1074c;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import w0.C1641a;

/* compiled from: CallLogUtils.java */
/* renamed from: com.customize.contacts.util.l, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0801l {

    /* compiled from: CallLogUtils.java */
    /* renamed from: com.customize.contacts.util.l$a */
    /* loaded from: classes3.dex */
    public class a implements Callable<Integer> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f22143a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f22144b;

        public a(String str, Context context) {
            this.f22143a = str;
            this.f22144b = context;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer call() {
            int i10;
            Cursor cursor = null;
            try {
                Uri parse = Uri.parse("content://call_log/calls");
                String str = this.f22143a;
                cursor = G7.c.e(this.f22144b.getContentResolver(), parse, new String[]{BreenoCallContract.BaseColumns._ID, "simid"}, "(number=? OR matched_number=?)", new String[]{str, str}, "date DESC");
                if (cursor != null) {
                    cursor.moveToFirst();
                    i10 = D7.c.q(this.f22144b, Integer.valueOf(cursor.getInt(1)));
                } else {
                    i10 = -1;
                }
                return Integer.valueOf(i10);
            } catch (Throwable th) {
                try {
                    H7.b.c("CallLogUtils", " e = " + th);
                    return -1;
                } finally {
                    com.oplus.foundation.util.io.e.a(cursor);
                }
            }
        }
    }

    public static String b(int i10) {
        if (o(i10)) {
            return c();
        }
        return h();
    }

    public static String c() {
        if (B3.a.f0()) {
            return " and (type=20 OR type=21 OR type=22 OR type=28 OR type=29 OR type=30 OR type=23 OR type=19 OR type=24 OR type=25 OR type=26 OR type=27 OR type=49 OR type=50 OR type=56 OR type=51 OR type=52 OR type=53 OR type < 0)";
        }
        return " and (type=20 OR type=21 OR type=22 OR type=23 OR type=19 OR type=24 OR type=25 OR type=26 OR type=27 OR type=49 OR type=50 OR type=56 OR type=51 OR type=52 OR type=53 OR type < 0)";
    }

    public static void d(Context context) {
        String f10 = f();
        Uri build = Uri.parse("content://call_log/" + com.android.contacts.compat.data.f.c("calls_with_normalized")).buildUpon().appendQueryParameter("limit", R0.b.f3167a).build();
        if (H7.a.b()) {
            H7.b.b("CallLogUtils", "deleteExceededCallLog: where: " + f10);
            H7.b.b("CallLogUtils", "deleteExceededCallLog: uri: " + build);
        }
        try {
            Cursor query = context.getContentResolver().query(build, new String[]{BreenoCallContract.BaseColumns.DATE}, f10, null, "date DESC");
            if (query != null) {
                try {
                    int count = query.getCount();
                    H7.b.e("CallLogUtils", "deleteExceededCallLog: current count: " + count);
                    if (count > 6000 && query.moveToLast()) {
                        long j10 = query.getLong(0);
                        H7.b.e("CallLogUtils", "deleteExceededCallLog: offsetDate: " + j10 + ", count: " + G7.c.c(context.getContentResolver(), CallLog.Calls.CONTENT_URI, "date<=" + j10, null));
                    }
                } finally {
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e10) {
            H7.b.c("CallLogUtils", "deleteExceededCallLog: exception: " + e10);
        }
    }

    public static String e(int i10) {
        int i11 = i10 / 1000;
        int i12 = i11 / 60;
        int i13 = i11 - (i12 * 60);
        if (i12 > 99) {
            i12 = 99;
        }
        return String.format("%02d:%02d", Integer.valueOf(i12), Integer.valueOf(i13));
    }

    public static String f() {
        if (B3.a.f0()) {
            return "(type !=20 AND type !=21 AND type !=22 AND type !=28 AND type !=29 AND type !=30 AND type !=23 AND type !=19 AND type !=24 AND type !=25 AND type !=26 AND type !=27 AND type !=49 AND type !=50 AND type !=56 AND type !=51 AND type !=52 AND type !=53 AND type !=6 AND type > 0)";
        }
        return "(type !=20 AND type !=21 AND type !=22 AND type !=23 AND type !=19 AND type !=24 AND type !=25 AND type !=26 AND type !=27 AND type !=49 AND type !=50 AND type !=56 AND type !=51 AND type !=52 AND type !=53 AND type !=6 AND type > 0)";
    }

    public static int g(Context context, String str) {
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(1);
        a aVar = new a(str, context);
        Integer num = -1;
        try {
            try {
                try {
                    try {
                        Integer num2 = (Integer) newFixedThreadPool.submit(aVar).get(1000L, TimeUnit.MILLISECONDS);
                        newFixedThreadPool.shutdown();
                        num = num2;
                    } catch (TimeoutException unused) {
                        H7.b.c("CallLogUtils", "getCallLogSlotId is time out.");
                        return num.intValue();
                    }
                } catch (InterruptedException unused2) {
                    H7.b.c("CallLogUtils", "getCallLogSlotId is interrupted.");
                    return num.intValue();
                }
            } catch (Exception unused3) {
                H7.b.c("CallLogUtils", "getCallLogSlotId has an error.");
                return num.intValue();
            }
            return num.intValue();
        } finally {
            newFixedThreadPool.shutdown();
        }
    }

    public static String h() {
        if (B3.a.f0()) {
            return " and (type !=20 AND type !=21 AND type !=22 AND type !=28 AND type !=29 AND type !=30 AND type !=23 AND type !=19 AND type !=24 AND type !=25 AND type !=26 AND type !=27 AND type !=49 AND type !=50 AND type !=56 AND type !=51 AND type !=52 AND type !=53 AND type > 0)";
        }
        return " and (type !=20 AND type !=21 AND type !=22 AND type !=23 AND type !=19 AND type !=24 AND type !=25 AND type !=26 AND type !=27 AND type !=49 AND type !=50 AND type !=56 AND type !=51 AND type !=52 AND type !=53 AND type > 0)";
    }

    public static int i(Context context) {
        int i10 = Settings.Secure.getInt(context.getContentResolver(), "ota_check_state", 0);
        H7.b.b("CallLogUtils", "needOTACallRecordingFiles = " + i10);
        return i10;
    }

    public static boolean j(Context context) {
        boolean z10 = PreferenceManager.getDefaultSharedPreferences(context).getBoolean("backup_or_cloud_check_state", false);
        H7.b.b("CallLogUtils", "getNeedRefresCallRecordingFiles = " + z10);
        return z10;
    }

    public static boolean k(Context context) {
        boolean z10 = PreferenceManager.getDefaultSharedPreferences(context).getBoolean("need_show_tips", true);
        H7.b.b("CallLogUtils", "getNeedShowTips = " + z10);
        return z10;
    }

    public static String l(String str, String str2, int i10, String str3) {
        if (!TextUtils.isEmpty(str)) {
            if (i10 != 1 || !TextUtils.equals(str3, "US") || str.length() <= 1 || !str.startsWith("+") || !TextUtils.equals(str.substring(1), str2)) {
                if (!FeatureOption.o()) {
                    str = str2;
                }
                return str;
            }
            return str2;
        }
        return str2;
    }

    public static String m() {
        if (B3.a.D()) {
            return "(number != -1 AND number != -2 AND number != -3) ";
        }
        return "(number != -1)";
    }

    public static boolean n(int i10) {
        if (!B3.a.G() || !Z.b() || 1073741824 != (i10 & 1073741824)) {
            return false;
        }
        return true;
    }

    public static boolean o(int i10) {
        if (B3.a.f0()) {
            if (i10 != 20 && i10 != 21 && i10 != 22 && i10 != 28 && i10 != 29 && i10 != 30 && i10 != 23 && i10 != 19 && i10 != 24 && i10 != 25 && i10 != 26 && i10 != 27 && i10 != 49 && i10 != 50 && i10 != 56 && i10 != 51 && i10 != 52 && i10 != 53 && i10 >= 0) {
                return false;
            }
            return true;
        }
        if (i10 != 20 && i10 != 21 && i10 != 22 && i10 != 23 && i10 != 19 && i10 != 24 && i10 != 25 && i10 != 26 && i10 != 27 && i10 != 49 && i10 != 50 && i10 != 56 && i10 != 51 && i10 != 52 && i10 != 53 && i10 >= 0) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ void p(Context context, String str) {
        try {
            String c10 = C1074c.c(context, str, null, null);
            ContentValues contentValues = new ContentValues();
            contentValues.put("hasRecog", OplusPhoneUtils.DeviceState.LOCK_DEVICE);
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(c10)) {
                sb.append(BreenoCallContract.BaseColumns.NORMALIZED_NUMBER);
                sb.append(" = ");
                DatabaseUtils.appendEscapedSQLString(sb, c10);
            } else {
                sb.append("number = ");
                DatabaseUtils.appendEscapedSQLString(sb, str);
            }
            context.getContentResolver().update(CallLog.Calls.CONTENT_URI_WITH_VOICEMAIL, contentValues, sb.toString(), null);
        } catch (Exception e10) {
            H7.b.c("CallLogUtils", "Exception e: " + e10);
        }
    }

    public static boolean q(int i10) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        if ((i10 & OplusPhoneUtils.PROPERTY_HIGH_DEF_AUDIO_EVS) != 1048576 && (i10 & 64) != 64) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (FeatureOption.o() && z10) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (4 != i10 && 4 != (i10 & 4)) {
            z12 = false;
        } else {
            z12 = true;
        }
        if (B3.a.e() && z12) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z11 || z13) {
            return true;
        }
        return false;
    }

    public static void r(ImageView imageView, int i10, boolean z10) {
        if (imageView != null && FeatureOption.o() && !C1641a.j()) {
            x(imageView, i10, z10);
        }
    }

    public static void s(ImageView imageView, int i10, boolean z10, boolean z11) {
        boolean z12;
        boolean z13;
        if (imageView == null) {
            return;
        }
        if (H7.a.b()) {
            H7.b.b("CallLogUtils", "setHDIcon: callFeatures: " + i10 + ", " + z11);
        }
        boolean z14 = true;
        if (z11) {
            if (134217728 == (i10 & 134217728)) {
                z13 = true;
            } else {
                z13 = false;
            }
            if (H7.a.b()) {
                H7.b.b("CallLogUtils", "setHDIcon: satelliteCall: " + z13);
            }
            if (z13) {
                imageView.setVisibility(0);
                imageView.setImageResource(R.drawable.pb_ic_satellite_call);
                return;
            }
        }
        if (4 != i10 && 4 != (i10 & 4)) {
            z12 = false;
        } else {
            z12 = true;
        }
        if (!FeatureOption.o() || (i10 & 67108864) != 67108864) {
            z14 = false;
        }
        if (B3.a.e() && z12) {
            if (z10) {
                imageView.setVisibility(8);
                return;
            } else {
                imageView.setVisibility(0);
                imageView.setImageResource(R.drawable.pb_ic_call_log_hd);
                return;
            }
        }
        if (z14) {
            if (z10) {
                imageView.setVisibility(8);
                return;
            } else {
                imageView.setVisibility(0);
                imageView.setImageResource(R.drawable.pb_ic_call_log_hd_plus);
                return;
            }
        }
        imageView.setVisibility(8);
    }

    public static void t(Context context) {
        int i10 = Settings.Secure.getInt(context.getContentResolver(), "ota_check_state", 0);
        H7.b.b("CallLogUtils", "setNeedOTACallRecordingFiles = " + i10);
        if (i10 == 0) {
            Settings.Secure.putInt(context.getContentResolver(), "ota_check_state", 1);
        }
    }

    public static void u(Context context, boolean z10) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("backup_or_cloud_check_state", z10).apply();
        H7.b.b("CallLogUtils", "setNeedRefreshCallRecordingFiles");
    }

    public static void v(Context context) {
        Settings.Secure.putInt(context.getContentResolver(), "ota_check_state", 2);
        H7.b.b("CallLogUtils", "setNoNeedOTACallRecordingFiles");
    }

    public static void w(Context context) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("need_show_tips", false).apply();
        H7.b.b("CallLogUtils", "setNoNeedShowTips");
    }

    public static void x(ImageView imageView, int i10, boolean z10) {
        boolean z11;
        boolean z12;
        boolean z13 = true;
        if ((i10 & OplusPhoneUtils.PROPERTY_HIGH_DEF_AUDIO_EVS) != 1048576 && (i10 & 64) != 64) {
            z11 = false;
        } else {
            z11 = true;
        }
        if ((i10 & 524288) != 524288 && (i10 & 8) != 8) {
            z12 = false;
        } else {
            z12 = true;
        }
        if ((i10 & 1) != 1) {
            z13 = false;
        }
        boolean C10 = B3.a.C();
        int i11 = R.drawable.pb_ic_call_vowifi;
        int i12 = R.drawable.pb_ic_call_volte;
        if (C10 && C0811w.f()) {
            if (z11) {
                imageView.setVisibility(0);
                if (z13) {
                    i12 = R.drawable.pb_ic_call_vilte;
                }
                imageView.setImageResource(i12);
                return;
            }
            if (z12) {
                imageView.setVisibility(0);
                if (z13) {
                    i11 = R.drawable.pb_ic_call_viwifi;
                }
                imageView.setImageResource(i11);
                return;
            }
            imageView.setVisibility(8);
            return;
        }
        if (z11) {
            if (z10) {
                imageView.setVisibility(8);
                return;
            } else {
                imageView.setVisibility(0);
                imageView.setImageResource(R.drawable.pb_ic_call_volte);
                return;
            }
        }
        if (z12) {
            imageView.setVisibility(0);
            imageView.setImageResource(R.drawable.pb_ic_call_vowifi);
        } else {
            imageView.setVisibility(8);
        }
    }

    public static void y(final String str, final Context context) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        N7.a.b().execute(new Runnable() { // from class: com.customize.contacts.util.k
            @Override // java.lang.Runnable
            public final void run() {
                C0801l.p(context, str);
            }
        });
    }
}
