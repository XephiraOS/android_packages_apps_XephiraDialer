package com.android.contacts.framework.omoji.utils;

import H7.b;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import androidx.lifecycle.J;
import androidx.preference.j;
import com.android.contacts.framework.omoji.viewmodel.OmojiViewModule;
import com.customize.contacts.backupandrestore.plugin.BRConstant;
import e1.C0964a;
import f1.InterfaceC0995a;
import java.util.List;
import java.util.UUID;
import kotlin.a;
import kotlin.jvm.internal.i;
import kotlin.text.n;
import kotlinx.coroutines.C1241e0;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.S;
import m9.d;
import org.json.JSONObject;
import v9.InterfaceC1637a;

/* compiled from: OmojiUtils.kt */
/* loaded from: classes.dex */
public final class OmojiUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final OmojiUtils f16197a = new OmojiUtils();

    /* renamed from: b, reason: collision with root package name */
    public static final Uri f16198b = Uri.parse("content://com.oplus.omoji.provider");

    /* renamed from: c, reason: collision with root package name */
    public static final d f16199c;

    static {
        d b10;
        b10 = a.b(new InterfaceC1637a<Boolean>() { // from class: com.android.contacts.framework.omoji.utils.OmojiUtils$noCompressPhotoSupport$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                return Boolean.valueOf(M7.a.h(P7.a.f2961a.a(), "com.android.providers.contacts", "no_compress_photo_support", "true"));
            }
        });
        f16199c = b10;
    }

    public static final void a(Context context, f1.d callback) {
        i.f(callback, "callback");
        if (context != null) {
            C1248i.d(C1241e0.f34422a, S.a(), null, new OmojiUtils$checkIfOmojiSupported$1$1(context, callback, null), 2, null);
        }
    }

    public static final boolean b() {
        return ((Boolean) f16199c.getValue()).booleanValue();
    }

    public static final Bundle d(String str, String str2, String str3) {
        String t10;
        Uri build;
        if (str != null && str.length() != 0) {
            build = Uri.parse(str);
        } else {
            Uri.Builder appendPath = ContactsContract.AUTHORITY_URI.buildUpon().appendPath("image").appendPath(BRConstant.FOLDER_OMOJI_PHOTO);
            String uuid = UUID.randomUUID().toString();
            i.e(uuid, "randomUUID().toString()");
            t10 = n.t(uuid, "-", "", false, 4, null);
            build = appendPath.appendPath(t10).build();
        }
        Bundle bundle = new Bundle();
        if (str2 != null && str2.length() != 0) {
            bundle.putParcelable("input_uri", Uri.parse(str2));
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("backgroundColor", str3);
        bundle.putParcelable("output_uri", build);
        bundle.putString("extra_data", jSONObject.toString());
        return bundle;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Pair<java.lang.Integer, java.lang.Boolean> e(android.content.Context r6, java.lang.String r7) {
        /*
            r0 = 0
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            r3 = 0
            kotlin.Result$a r4 = kotlin.Result.f34166a     // Catch: java.lang.Throwable -> L21
            android.net.Uri r4 = com.android.contacts.framework.omoji.utils.OmojiUtils.f16198b     // Catch: java.lang.Throwable -> L21
            if (r4 == 0) goto L33
            java.lang.String r5 = r4.getAuthority()     // Catch: java.lang.Throwable -> L21
            if (r5 == 0) goto L33
            if (r6 == 0) goto L23
            android.content.ContentResolver r6 = r6.getContentResolver()     // Catch: java.lang.Throwable -> L21
            if (r6 == 0) goto L23
            android.content.ContentProviderClient r6 = r6.acquireUnstableContentProviderClient(r4)     // Catch: java.lang.Throwable -> L21
            goto L24
        L21:
            r6 = move-exception
            goto L5a
        L23:
            r6 = r3
        L24:
            if (r6 == 0) goto L31
            java.lang.String r4 = "getHeadStatus"
            android.os.Bundle r7 = r6.call(r5, r4, r7, r3)     // Catch: java.lang.Throwable -> L2d
            goto L35
        L2d:
            r7 = move-exception
            r3 = r6
            r6 = r7
            goto L5a
        L31:
            r7 = r3
            goto L35
        L33:
            r6 = r3
            r7 = r6
        L35:
            if (r7 == 0) goto L43
            java.lang.String r4 = "current_head_status"
            r5 = -1
            int r4 = r7.getInt(r4, r5)     // Catch: java.lang.Throwable -> L2d
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> L2d
            goto L44
        L43:
            r1 = r3
        L44:
            if (r7 == 0) goto L52
            java.lang.String r3 = "is_download"
            boolean r7 = r7.getBoolean(r3, r0)     // Catch: java.lang.Throwable -> L2d
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)     // Catch: java.lang.Throwable -> L2d
            r2 = r7
            goto L53
        L52:
            r2 = r3
        L53:
            m9.q r7 = m9.q.f35511a     // Catch: java.lang.Throwable -> L2d
            java.lang.Object r7 = kotlin.Result.b(r7)     // Catch: java.lang.Throwable -> L2d
            goto L65
        L5a:
            kotlin.Result$a r7 = kotlin.Result.f34166a
            java.lang.Object r6 = kotlin.b.a(r6)
            java.lang.Object r7 = kotlin.Result.b(r6)
            r6 = r3
        L65:
            java.lang.Throwable r7 = kotlin.Result.d(r7)
            java.lang.String r0 = "OmojiUtils"
            if (r7 == 0) goto L81
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "getOmojiMaterialsStatus: e ="
            r3.append(r4)
            r3.append(r7)
            java.lang.String r7 = r3.toString()
            H7.b.c(r0, r7)
        L81:
            java.lang.AutoCloseable[] r6 = new java.lang.AutoCloseable[]{r6}
            com.oplus.foundation.util.io.CloseableUtils.a(r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "status = "
            r6.append(r7)
            r6.append(r1)
            java.lang.String r7 = ", isDownload= "
            r6.append(r7)
            r6.append(r2)
            java.lang.String r6 = r6.toString()
            H7.b.e(r0, r6)
            kotlin.Pair r6 = new kotlin.Pair
            r6.<init>(r1, r2)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.framework.omoji.utils.OmojiUtils.e(android.content.Context, java.lang.String):kotlin.Pair");
    }

    public static final void f(Context context, String str, InterfaceC0995a callback) {
        i.f(callback, "callback");
        C1248i.d(C1241e0.f34422a, S.a(), null, new OmojiUtils$getOmojiMaterialsStatus$1(context, str, callback, null), 2, null);
    }

    public static final Intent g() {
        Intent intent = new Intent("com.oplus.omoji.main");
        intent.putExtra("actionType", 4);
        intent.putExtra("contactAction", 3);
        return intent;
    }

    public static final int h(Context context) {
        if (context != null) {
            int i10 = j.b(context.getApplicationContext()).getInt("create_contact_times", 0);
            b.e("OmojiUtils", "getCreateContactTimes: times = " + i10);
            return i10;
        }
        return -1;
    }

    public static final Intent i(int i10, String str) {
        Intent intent = new Intent("com.oplus.omoji.main");
        intent.putExtra("actionType", 4);
        b.e("OmojiUtils", "type = " + i10);
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 == 2) {
                    intent.putExtra("currentHead", str);
                    intent.putExtra("contactAction", 2);
                }
            } else {
                intent.putExtra("contactAction", 1);
            }
        } else {
            intent.putExtra("currentHead", str);
            intent.putExtra("contactAction", 0);
        }
        b.e("OmojiUtils", "getSetOmojiPhotoIntent-------------type = " + i10);
        return intent;
    }

    public static final boolean j(com.android.contacts.framework.omoji.viewmodel.a data, com.android.contacts.framework.omoji.viewmodel.a cacheData) {
        List<C0964a.C0293a> list;
        String str;
        String str2;
        String str3;
        i.f(data, "data");
        i.f(cacheData, "cacheData");
        if (data.b() != cacheData.b()) {
            return false;
        }
        List<C0964a.C0293a> a10 = data.a();
        List<C0964a.C0293a> a11 = cacheData.a();
        List<C0964a.C0293a> list2 = a10;
        if (list2 == null || list2.isEmpty() || (list = a11) == null || list.isEmpty() || a10.size() != a11.size()) {
            return false;
        }
        int size = a10.size();
        for (int i10 = 0; i10 < size; i10++) {
            C0964a.C0293a c0293a = a10.get(i10);
            C0964a.C0293a c0293a2 = a11.get(i10);
            String str4 = null;
            if (c0293a != null) {
                str = c0293a.a();
            } else {
                str = null;
            }
            if (c0293a2 != null) {
                str2 = c0293a2.a();
            } else {
                str2 = null;
            }
            if (!i.b(str, str2)) {
                return false;
            }
            if (c0293a != null) {
                str3 = c0293a.b();
            } else {
                str3 = null;
            }
            if (c0293a2 != null) {
                str4 = c0293a2.b();
            }
            if (!i.b(str3, str4)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean k(android.content.Context r6) {
        /*
            r0 = 0
            r1 = 0
            kotlin.Result$a r2 = kotlin.Result.f34166a     // Catch: java.lang.Throwable -> L1b
            android.net.Uri r2 = com.android.contacts.framework.omoji.utils.OmojiUtils.f16198b     // Catch: java.lang.Throwable -> L1b
            if (r2 == 0) goto L2c
            java.lang.String r3 = r2.getAuthority()     // Catch: java.lang.Throwable -> L1b
            if (r3 == 0) goto L2c
            if (r6 == 0) goto L1d
            android.content.ContentResolver r6 = r6.getContentResolver()     // Catch: java.lang.Throwable -> L1b
            if (r6 == 0) goto L1d
            android.content.ContentProviderClient r6 = r6.acquireUnstableContentProviderClient(r2)     // Catch: java.lang.Throwable -> L1b
            goto L1e
        L1b:
            r6 = move-exception
            goto L40
        L1d:
            r6 = r1
        L1e:
            if (r6 == 0) goto L2d
            java.lang.String r2 = "isFirstEnter"
            android.os.Bundle r1 = r6.call(r3, r2, r1, r1)     // Catch: java.lang.Throwable -> L27
            goto L2d
        L27:
            r1 = move-exception
            r5 = r1
            r1 = r6
            r6 = r5
            goto L40
        L2c:
            r6 = r1
        L2d:
            if (r1 == 0) goto L39
            java.lang.String r2 = "first_enter"
            r3 = 1
            boolean r1 = r1.getBoolean(r2, r3)     // Catch: java.lang.Throwable -> L27
            if (r1 != r3) goto L39
            r0 = r3
        L39:
            m9.q r1 = m9.q.f35511a     // Catch: java.lang.Throwable -> L27
            java.lang.Object r1 = kotlin.Result.b(r1)     // Catch: java.lang.Throwable -> L27
            goto L4d
        L40:
            kotlin.Result$a r2 = kotlin.Result.f34166a
            java.lang.Object r6 = kotlin.b.a(r6)
            java.lang.Object r6 = kotlin.Result.b(r6)
            r5 = r1
            r1 = r6
            r6 = r5
        L4d:
            java.lang.Throwable r1 = kotlin.Result.d(r1)
            java.lang.String r2 = "OmojiUtils"
            if (r1 == 0) goto L69
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "isFirstUseEmoji e = "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            H7.b.c(r2, r1)
        L69:
            java.lang.AutoCloseable[] r6 = new java.lang.AutoCloseable[]{r6}
            com.oplus.foundation.util.io.CloseableUtils.a(r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r1 = "isFirstUseEmoji: firstEnter = "
            r6.append(r1)
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            H7.b.e(r2, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.framework.omoji.utils.OmojiUtils.k(android.content.Context):boolean");
    }

    public static final boolean l() {
        return M7.a.h(P7.a.f2961a.a(), "com.oplus.omoji", "isSupportContact", "true");
    }

    public static final void m(Context context) {
        if (!com.android.contacts.framework.api.appstore.appinfo.a.k() && context != null) {
            OmojiViewModule omojiViewModule = new OmojiViewModule();
            C1248i.d(J.a(omojiViewModule), S.b(), null, new OmojiUtils$preGetOmojiList$1$1(context, omojiViewModule, null), 2, null);
        }
    }

    public static final void n(Context context) {
        if (context != null) {
            SharedPreferences b10 = j.b(context.getApplicationContext());
            int h10 = h(context) + 1;
            b.e("OmojiUtils", "saveCreateContactTimes: times = " + h10);
            b10.edit().putInt("create_contact_times", h10).apply();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void o(android.content.Context r5) {
        /*
            java.lang.String r0 = "startMaterialsDownload-------------"
            java.lang.String r1 = "OmojiUtils"
            H7.b.e(r1, r0)
            r0 = 0
            kotlin.Result$a r2 = kotlin.Result.f34166a     // Catch: java.lang.Throwable -> L21
            android.net.Uri r2 = com.android.contacts.framework.omoji.utils.OmojiUtils.f16198b     // Catch: java.lang.Throwable -> L21
            if (r2 == 0) goto L33
            java.lang.String r3 = r2.getAuthority()     // Catch: java.lang.Throwable -> L21
            if (r3 == 0) goto L33
            if (r5 == 0) goto L23
            android.content.ContentResolver r5 = r5.getContentResolver()     // Catch: java.lang.Throwable -> L21
            if (r5 == 0) goto L23
            android.content.ContentProviderClient r5 = r5.acquireUnstableContentProviderClient(r2)     // Catch: java.lang.Throwable -> L21
            goto L24
        L21:
            r5 = move-exception
            goto L39
        L23:
            r5 = r0
        L24:
            if (r5 == 0) goto L34
            java.lang.String r2 = "updateOmoji"
            android.os.Bundle r0 = r5.call(r3, r2, r0, r0)     // Catch: java.lang.Throwable -> L2e
            goto L34
        L2e:
            r0 = move-exception
            r4 = r0
            r0 = r5
            r5 = r4
            goto L39
        L33:
            r5 = r0
        L34:
            java.lang.Object r0 = kotlin.Result.b(r0)     // Catch: java.lang.Throwable -> L2e
            goto L46
        L39:
            kotlin.Result$a r2 = kotlin.Result.f34166a
            java.lang.Object r5 = kotlin.b.a(r5)
            java.lang.Object r5 = kotlin.Result.b(r5)
            r4 = r0
            r0 = r5
            r5 = r4
        L46:
            java.lang.Throwable r0 = kotlin.Result.d(r0)
            if (r0 == 0) goto L60
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "startMaterialsDownload: e ="
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            H7.b.c(r1, r0)
        L60:
            java.lang.AutoCloseable[] r5 = new java.lang.AutoCloseable[]{r5}
            com.oplus.foundation.util.io.CloseableUtils.a(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.framework.omoji.utils.OmojiUtils.o(android.content.Context):void");
    }

    public final Uri c() {
        return f16198b;
    }
}
