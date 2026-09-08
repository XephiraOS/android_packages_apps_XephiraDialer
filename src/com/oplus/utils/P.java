package com.oplus.utils;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.android.incallui.OplusAutoRedialNotificationUI;
import com.android.incallui.OplusPhoneUtils;
import com.heytap.accessory.constant.FastPairConstants;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: PseudoUtils.java */
/* loaded from: classes3.dex */
public class P {

    /* renamed from: a, reason: collision with root package name */
    public static final Uri f29078a = Uri.parse(F6.d.f());

    /* renamed from: b, reason: collision with root package name */
    public static final Uri f29079b = Uri.parse(F6.d.g());

    /* renamed from: c, reason: collision with root package name */
    public static ThreadPoolExecutor f29080c;

    /* renamed from: d, reason: collision with root package name */
    public static LinkedBlockingQueue<Runnable> f29081d;

    /* compiled from: PseudoUtils.java */
    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ double f29082a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ double f29083b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f29084c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f29085d;

        public a(double d10, double d11, Context context, int i10) {
            this.f29082a = d10;
            this.f29083b = d11;
            this.f29084c = context;
            this.f29085d = i10;
        }

        /* JADX WARN: Can't wrap try/catch for region: R(27:1|(3:2|3|4)|(3:95|96|(24:100|101|7|9|10|11|(3:80|81|(4:83|(1:85)|86|(14:88|22|23|(1:25)|47|48|(1:50)(1:65)|51|(6:56|(1:58)(1:63)|(1:60)|(1:62)|34|35)|64|(0)|(0)|34|35)(15:89|21|22|23|(0)|47|48|(0)(0)|51|(7:53|56|(0)(0)|(0)|(0)|34|35)|64|(0)|(0)|34|35)))|(19:16|17|18|19|20|21|22|23|(0)|47|48|(0)(0)|51|(0)|64|(0)|(0)|34|35)|79|20|21|22|23|(0)|47|48|(0)(0)|51|(0)|64|(0)|(0)|34|35))|6|7|9|10|11|(0)|(20:14|16|17|18|19|20|21|22|23|(0)|47|48|(0)(0)|51|(0)|64|(0)|(0)|34|35)|79|20|21|22|23|(0)|47|48|(0)(0)|51|(0)|64|(0)|(0)|34|35|(1:(0))) */
        /* JADX WARN: Can't wrap try/catch for region: R(29:1|2|3|4|(3:95|96|(24:100|101|7|9|10|11|(3:80|81|(4:83|(1:85)|86|(14:88|22|23|(1:25)|47|48|(1:50)(1:65)|51|(6:56|(1:58)(1:63)|(1:60)|(1:62)|34|35)|64|(0)|(0)|34|35)(15:89|21|22|23|(0)|47|48|(0)(0)|51|(7:53|56|(0)(0)|(0)|(0)|34|35)|64|(0)|(0)|34|35)))|(19:16|17|18|19|20|21|22|23|(0)|47|48|(0)(0)|51|(0)|64|(0)|(0)|34|35)|79|20|21|22|23|(0)|47|48|(0)(0)|51|(0)|64|(0)|(0)|34|35))|6|7|9|10|11|(0)|(20:14|16|17|18|19|20|21|22|23|(0)|47|48|(0)(0)|51|(0)|64|(0)|(0)|34|35)|79|20|21|22|23|(0)|47|48|(0)(0)|51|(0)|64|(0)|(0)|34|35|(1:(0))) */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x0163, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x0164, code lost:
        
            r3 = r20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x015e, code lost:
        
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x015f, code lost:
        
            r3 = r20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:71:0x0227, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:72:0x0228, code lost:
        
            r18 = "PseudoUtils";
            r20 = r7;
            r19 = r9;
         */
        /* JADX WARN: Code restructure failed: missing block: B:73:0x0220, code lost:
        
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:74:0x0221, code lost:
        
            r20 = r7;
            r19 = r9;
         */
        /* JADX WARN: Code restructure failed: missing block: B:91:0x0238, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:92:0x0239, code lost:
        
            r18 = "PseudoUtils";
            r20 = r7;
            r19 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:93:0x0230, code lost:
        
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:94:0x0231, code lost:
        
            r20 = r7;
            r19 = null;
         */
        /* JADX WARN: Removed duplicated region for block: B:25:0x00d4 A[Catch: all -> 0x006d, Exception -> 0x0073, TRY_ENTER, TRY_LEAVE, TryCatch #6 {Exception -> 0x0073, blocks: (B:81:0x005b, B:83:0x0061, B:85:0x0067, B:86:0x007b, B:88:0x0081, B:25:0x00d4, B:14:0x00a3, B:16:0x00a9, B:78:0x00b7), top: B:80:0x005b }] */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0265  */
        /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:41:0x026f  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x0274  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x0106 A[Catch: all -> 0x015e, Exception -> 0x0163, TRY_ENTER, TryCatch #10 {Exception -> 0x0163, all -> 0x015e, blocks: (B:50:0x0106, B:51:0x01c8, B:53:0x01d8, B:56:0x01e3, B:58:0x01ea, B:63:0x0203, B:64:0x020b, B:65:0x0168), top: B:48:0x0104 }] */
        /* JADX WARN: Removed duplicated region for block: B:53:0x01d8 A[Catch: all -> 0x015e, Exception -> 0x0163, TryCatch #10 {Exception -> 0x0163, all -> 0x015e, blocks: (B:50:0x0106, B:51:0x01c8, B:53:0x01d8, B:56:0x01e3, B:58:0x01ea, B:63:0x0203, B:64:0x020b, B:65:0x0168), top: B:48:0x0104 }] */
        /* JADX WARN: Removed duplicated region for block: B:58:0x01ea A[Catch: all -> 0x015e, Exception -> 0x0163, TryCatch #10 {Exception -> 0x0163, all -> 0x015e, blocks: (B:50:0x0106, B:51:0x01c8, B:53:0x01d8, B:56:0x01e3, B:58:0x01ea, B:63:0x0203, B:64:0x020b, B:65:0x0168), top: B:48:0x0104 }] */
        /* JADX WARN: Removed duplicated region for block: B:60:0x0217  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x026b A[ORIG_RETURN, RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:63:0x0203 A[Catch: all -> 0x015e, Exception -> 0x0163, TryCatch #10 {Exception -> 0x0163, all -> 0x015e, blocks: (B:50:0x0106, B:51:0x01c8, B:53:0x01d8, B:56:0x01e3, B:58:0x01ea, B:63:0x0203, B:64:0x020b, B:65:0x0168), top: B:48:0x0104 }] */
        /* JADX WARN: Removed duplicated region for block: B:65:0x0168 A[Catch: all -> 0x015e, Exception -> 0x0163, TryCatch #10 {Exception -> 0x0163, all -> 0x015e, blocks: (B:50:0x0106, B:51:0x01c8, B:53:0x01d8, B:56:0x01e3, B:58:0x01ea, B:63:0x0203, B:64:0x020b, B:65:0x0168), top: B:48:0x0104 }] */
        /* JADX WARN: Removed duplicated region for block: B:80:0x005b A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 632
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.oplus.utils.P.a.run():void");
        }
    }

    public static Cursor b(Context context, String str, int i10) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str.trim())) {
            return context.getContentResolver().query(com.oplus.blacklist.database.a.f26234c, null, "address =?  AND cell_id =? ", new String[]{str, String.valueOf(i10)}, null);
        }
        return null;
    }

    public static Z7.a c(Context context, double d10, double d11) {
        List<Address> list;
        try {
            list = new Geocoder(context, Locale.getDefault()).getFromLocation(d10, d11, 1);
        } catch (Exception e10) {
            Log.e("PseudoUtils", "e = " + e10);
            list = null;
        }
        if (list == null || list.isEmpty()) {
            return null;
        }
        return new Z7.a(list.get(0));
    }

    public static void d(Context context, int i10, double d10, double d11) {
        if (f29080c == null) {
            f29081d = new LinkedBlockingQueue<>();
            f29080c = new ThreadPoolExecutor(1, 1, 100L, TimeUnit.SECONDS, f29081d);
        }
        f29080c.execute(new a(d10, d11, context, i10));
    }

    public static long e() {
        return System.currentTimeMillis();
    }

    public static String f(Context context, int i10) {
        if (C0846g.c()) {
            Log.d("PseudoUtils", "getPseudoBaseStationName cell_id = " + i10);
        }
        if (i10 < 10) {
            return FastPairConstants.STATUS_CONNECT_RESULT_SUCCESS + i10;
        }
        if (i10 >= 10 && i10 < 100) {
            return "00" + i10;
        }
        if (i10 >= 100 && i10 < 1000) {
            return OplusPhoneUtils.DeviceState.UNLOCK_DEVICE + i10;
        }
        return String.valueOf(i10);
    }

    public static void g(Context context, String str, int i10) {
        ContentResolver contentResolver;
        if (context == null) {
            return;
        }
        ContentProviderClient contentProviderClient = null;
        try {
            try {
                contentResolver = context.getContentResolver();
            } catch (Exception e10) {
                Log.e("PseudoUtils", "e = " + e10);
                if (0 == 0) {
                    return;
                }
            }
            if (contentResolver == null) {
                return;
            }
            contentProviderClient = contentResolver.acquireContentProviderClient(f29078a);
            if (contentProviderClient == null) {
                if (contentProviderClient != null) {
                    contentProviderClient.close();
                    return;
                }
                return;
            }
            if (C0846g.c()) {
                Log.d("PseudoUtils", "sendSecureData pseudo base station count is " + i10);
            }
            Bundle bundle = new Bundle();
            bundle.putString(OplusPhoneUtils.EXTRA_SECURE_TYPE, str);
            bundle.putInt(OplusPhoneUtils.EXTRA_ADD_COUNT, i10);
            contentProviderClient.call(context.getPackageName(), OplusPhoneUtils.METHOD_SET_SECURE_ITEM, context.getPackageName(), bundle);
            contentProviderClient.close();
        } catch (Throwable th) {
            if (0 != 0) {
                contentProviderClient.close();
            }
            throw th;
        }
    }

    public static void h(Context context, int i10, String str, String str2, String str3) {
        Intent b10 = F6.a.b();
        b10.putExtra(OplusAutoRedialNotificationUI.TYPE, i10);
        b10.putExtra("identify", str);
        b10.putExtra("detail", str2);
        b10.putExtra("extend", str3);
        context.sendBroadcast(b10);
    }

    public static void i(Context context, int i10, String str, String str2, String str3) {
        ContentResolver contentResolver;
        if (context == null) {
            return;
        }
        ContentProviderClient contentProviderClient = null;
        try {
            try {
                contentResolver = context.getContentResolver();
            } catch (Exception e10) {
                Log.e("PseudoUtils", "call log provider e = " + e10);
                if (0 == 0) {
                    return;
                }
            }
            if (contentResolver == null) {
                Log.d("PseudoUtils", "resolver is null ,sendbroadcast");
                h(context, i10, str, str2, str3);
                return;
            }
            contentProviderClient = contentResolver.acquireContentProviderClient(f29079b);
            if (contentProviderClient == null) {
                Log.d("PseudoUtils", "SecurityEventProvider is null ,sendbroadcast");
                h(context, i10, str, str2, str3);
                if (contentProviderClient != null) {
                    contentProviderClient.close();
                    return;
                }
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putInt(OplusAutoRedialNotificationUI.TYPE, i10);
            bundle.putString("identify", str);
            bundle.putString("detail", str2);
            bundle.putString("extend", str3);
            contentProviderClient.call("insertSecurityEvent", context.getPackageName(), bundle);
            contentProviderClient.close();
        } catch (Throwable th) {
            if (0 != 0) {
                contentProviderClient.close();
            }
            throw th;
        }
    }
}
