package i2;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.text.TextUtils;
import com.android.incallui.Log;
import com.android.incallui.OplusPhoneUtils;
import com.android.incallui.R;
import com.android.incallui.oplus.audiorecord.OplusAutoClearRecordJobIntentService;
import com.android.oplus.brand.BrandCenter;
import com.internal_dependency.AddOnSdkDepends;
import com.internal_dependency.SettingsUtils;
import java.io.File;

/* compiled from: OplusAudioRecordUtil.java */
/* loaded from: classes.dex */
public class b {
    public static void a(Context context) {
        if (context == null || !h(context)) {
            return;
        }
        OplusAutoClearRecordJobIntentService.k(context, new Intent(context, (Class<?>) OplusAutoClearRecordJobIntentService.class));
    }

    public static boolean b(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            File file = new File(str);
            context.getContentResolver().delete(C1091a.f32145d, "_data=?", new String[]{str});
            if (Log.sDebug) {
                Log.d("OplusAudioRecordUtil", "deleteCurrentCursor begin...file.exists() = " + file.exists());
            }
            if (file.exists() && file.delete()) {
                if (Log.sDebug) {
                    Log.d("OplusAudioRecordUtil", "deleteCurrentCursor begin...file.delete() = true");
                    return true;
                }
                return true;
            }
        }
        return false;
    }

    public static String c(Context context) {
        if (context == null) {
            return null;
        }
        return "(mime_type in (?,?,?,?)) AND (_data LIKE '" + (AddOnSdkDepends.getSInstance().getInternalSdDirectory(context).getPath() + context.getString(R.string.oplus_call_record_dir) + File.separator) + "%') AND (_size!=0)";
    }

    public static int d(Context context) {
        if (context == null) {
            Log.w("OplusAudioRecordUtil", "getMaxRecordSetting context null!");
            return 0;
        }
        return SettingsUtils.INSTANCE.getGlobalSettingsInt(context.getContentResolver(), "oplus_customize_max_record_setting", 0);
    }

    public static String e(Context context) {
        if (context == null) {
            return null;
        }
        return "(mime_type in (?,?,?)) AND (_data LIKE '" + (AddOnSdkDepends.getSInstance().getInternalSdDirectory(context).getPath() + context.getString(R.string.oplus_call_record_dir) + File.separator) + "%') AND (_size!=0)";
    }

    public static boolean f(Context context) {
        boolean z10 = false;
        if (context == null) {
            Log.w("OplusAudioRecordUtil", "isAllRecordOn context null!");
            return false;
        }
        if (SettingsUtils.INSTANCE.getGlobalSettingsInt(context.getContentResolver(), "oplus_customize_all_call_audio_record", 0) == 1) {
            z10 = true;
        }
        Log.d("OplusAudioRecordUtil", "isAllRecordOn: isOn = " + z10);
        return z10;
    }

    public static boolean g(Context context) {
        if (context == null) {
            Log.w("OplusAudioRecordUtil", "isAllStrangerRecordOn context null!");
            return false;
        }
        if (SettingsUtils.INSTANCE.getGlobalSettingsInt(context.getContentResolver(), "oplus_customize_all_stranger_call_audio_record", 0) != 1) {
            return false;
        }
        return true;
    }

    public static boolean h(Context context) {
        if (context == null) {
            Log.w("OplusAudioRecordUtil", "isNeedCheckAutoClear context null!");
            return false;
        }
        if (d(context) == 0) {
            return false;
        }
        return true;
    }

    public static Cursor i(Context context) {
        if (context == null) {
            return null;
        }
        if (BrandCenter.f19187a.a().d() != null) {
            return context.getContentResolver().query(C1091a.f32145d, C1091a.f32146e, c(context), C1091a.f32148g, "date_modified ASC,title ASC");
        }
        return context.getContentResolver().query(C1091a.f32145d, C1091a.f32146e, e(context), C1091a.f32147f, "date_modified ASC,title ASC");
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0074, code lost:
    
        if (r2 != null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0076, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0098, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0095, code lost:
    
        if (r2 == null) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean j(android.content.Context r10, java.lang.String r11) {
        /*
            java.lang.String r0 = "OplusAudioRecordUtil"
            r1 = 0
            if (r10 != 0) goto Lf
            boolean r10 = com.android.incallui.Log.sDebug
            if (r10 == 0) goto Le
            java.lang.String r10 = "context is null, do nothing and return."
            com.android.incallui.Log.d(r0, r10)
        Le:
            return r1
        Lf:
            boolean r2 = android.text.TextUtils.isEmpty(r11)
            if (r2 == 0) goto L1a
            boolean r10 = g(r10)
            return r10
        L1a:
            if (r11 == 0) goto L2a
            java.lang.String r2 = " "
            java.lang.String r3 = ""
            java.lang.String r11 = r11.replaceAll(r2, r3)
            java.lang.String r2 = "-"
            java.lang.String r11 = r11.replaceAll(r2, r3)
        L2a:
            java.lang.String r11 = com.android.incallui.OplusPhoneUtils.removeNumberPrefix(r11)
            boolean r2 = com.android.incallui.Log.sDebug
            if (r2 == 0) goto L4a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "queryNumberAutoRecord begin...number = "
            r2.append(r3)
            java.lang.String r3 = D2.g.l(r11)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.android.incallui.Log.d(r0, r2)
        L4a:
            r2 = 0
            android.net.Uri r3 = i2.C1091a.f32144c     // Catch: java.lang.Throwable -> L7a java.lang.Exception -> L7c
            android.net.Uri r5 = android.net.Uri.withAppendedPath(r3, r11)     // Catch: java.lang.Throwable -> L7a java.lang.Exception -> L7c
            android.content.ContentResolver r4 = r10.getContentResolver()     // Catch: java.lang.Throwable -> L7a java.lang.Exception -> L7c
            r8 = 0
            r9 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r10 = r4.query(r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L7a java.lang.Exception -> L7c
            if (r10 == 0) goto L73
            int r11 = r10.getCount()     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L70
            if (r11 <= 0) goto L67
            r11 = 1
            goto L68
        L67:
            r11 = r1
        L68:
            r10.close()     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L70
            r1 = r11
            goto L74
        L6d:
            r11 = move-exception
            r2 = r10
            goto L99
        L70:
            r11 = move-exception
            r2 = r10
            goto L7d
        L73:
            r2 = r10
        L74:
            if (r2 == 0) goto L98
        L76:
            r2.close()
            goto L98
        L7a:
            r11 = move-exception
            goto L99
        L7c:
            r11 = move-exception
        L7d:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7a
            r10.<init>()     // Catch: java.lang.Throwable -> L7a
            java.lang.String r3 = "Exception: "
            r10.append(r3)     // Catch: java.lang.Throwable -> L7a
            java.lang.String r11 = r11.getMessage()     // Catch: java.lang.Throwable -> L7a
            r10.append(r11)     // Catch: java.lang.Throwable -> L7a
            java.lang.String r10 = r10.toString()     // Catch: java.lang.Throwable -> L7a
            com.android.incallui.Log.d(r0, r10)     // Catch: java.lang.Throwable -> L7a
            if (r2 == 0) goto L98
            goto L76
        L98:
            return r1
        L99:
            if (r2 == 0) goto L9e
            r2.close()
        L9e:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.b.j(android.content.Context, java.lang.String):boolean");
    }

    public static boolean k(Context context) {
        if (!OplusPhoneUtils.isNeedHideRecord(context) && !f(context)) {
            return true;
        }
        return false;
    }
}
