package com.android.contacts.business.calllog.breenocall;

import G0.c;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.net.Uri;
import androidx.lifecycle.InterfaceC0492o;
import androidx.lifecycle.p;
import com.oplus.foundation.util.OsUtils;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Result;
import kotlin.b;
import kotlin.io.a;
import kotlin.jvm.internal.i;
import kotlin.text.j;
import kotlinx.coroutines.C1241e0;
import kotlinx.coroutines.C1244g;
import kotlinx.coroutines.E;
import kotlinx.coroutines.S;
import m9.q;

/* compiled from: BreenoHelper.kt */
/* loaded from: classes.dex */
public final class BreenoHelper {
    private static final String ACCESSIBILITY_USER_NOTICE = "accessibility_user_notice";
    private static final int BATCH_COUNT = 998;
    private static final Uri BREENO_CALL_BASE_URI;
    private static final Uri BREENO_CALL_RECORD_URI;
    private static final Uri CLEAR_BREENO_CALL_FLAG_URI;
    public static final BreenoHelper INSTANCE = new BreenoHelper();
    private static final String JUMP_BREENO_CALL_DATA_URI = "breenovoice://speechassist.heytap.com/openpage?type=aiCallHistoryDetail&source=1&target_id=";
    private static final String JUMP_BREENO_CALL_SETTING_DATA_URI = "breenovoice://speechassist.heytap.com/openpage?type=aiCallSetting&source=2";
    public static final String TAG = "BreenoHelper";

    static {
        Uri parse = Uri.parse("content://com.heytap.speechassist.provider.aiCall");
        BREENO_CALL_BASE_URI = parse;
        BREENO_CALL_RECORD_URI = Uri.withAppendedPath(parse, "record");
        CLEAR_BREENO_CALL_FLAG_URI = Uri.parse("content://call_log/clear_breeno_call");
    }

    private BreenoHelper() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void checkStartBreenoCall(Context context, String callUniqueId, int i10) {
        E e10;
        i.f(context, "context");
        i.f(callUniqueId, "callUniqueId");
        if (context instanceof InterfaceC0492o) {
            e10 = p.a((InterfaceC0492o) context);
        } else {
            e10 = C1241e0.f34422a;
        }
        C1244g.d(e10, S.a(), null, new BreenoHelper$checkStartBreenoCall$1(context, callUniqueId, e10, i10, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearBreenoCall(Context context, String str) {
        Object b10;
        Integer num;
        try {
            Result.a aVar = Result.f34166a;
            ContentResolver contentResolver = context.getContentResolver();
            if (contentResolver != null) {
                num = Integer.valueOf(contentResolver.update(CLEAR_BREENO_CALL_FLAG_URI, new ContentValues(), "virtual_call_id=?", new String[]{str}));
            } else {
                num = null;
            }
            b10 = Result.b(num);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c(TAG, "isBreenoCallExist error: " + d10);
        }
    }

    public static final void deleteBreenoCallLog(Context context, String callUniqueId) {
        Object b10;
        Uri uri;
        ContentProviderClient acquireUnstableContentProviderClient;
        i.f(context, "context");
        i.f(callUniqueId, "callUniqueId");
        try {
            Result.a aVar = Result.f34166a;
            ContentResolver contentResolver = context.getContentResolver();
            b10 = Result.b((contentResolver == null || (acquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient((uri = BREENO_CALL_RECORD_URI))) == null) ? null : Integer.valueOf(acquireUnstableContentProviderClient.delete(uri, "callUniqueId=?", new String[]{callUniqueId})));
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c(TAG, "deleteBreenoCallLog callUniqueId error: " + d10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isBreenoCallExist(Context context, String str) {
        Object b10;
        ContentResolver contentResolver;
        Cursor query;
        boolean z10;
        try {
            Result.a aVar = Result.f34166a;
            contentResolver = context.getContentResolver();
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(b.a(th));
        }
        if (contentResolver != null && (query = contentResolver.query(BREENO_CALL_RECORD_URI, null, "callUniqueId=?", new String[]{str}, null)) != null) {
            try {
                if (query.getCount() > 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                a.a(query, null);
                return z10;
            } finally {
            }
        } else {
            b10 = Result.b(null);
            Throwable d10 = Result.d(b10);
            if (d10 != null) {
                H7.b.c(TAG, "isBreenoCallExist error: " + d10);
            }
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean isBreenoOpen(android.content.Context r5) {
        /*
            java.lang.String r0 = "aiCallStatus"
            java.lang.String r1 = "BreenoHelper"
            java.lang.String r2 = "context"
            kotlin.jvm.internal.i.f(r5, r2)
            kotlin.Result$a r2 = kotlin.Result.f34166a     // Catch: java.lang.Throwable -> L22
            android.content.ContentResolver r5 = r5.getContentResolver()     // Catch: java.lang.Throwable -> L22
            if (r5 == 0) goto L54
            android.net.Uri r2 = com.android.contacts.business.calllog.breenocall.BreenoHelper.BREENO_CALL_BASE_URI     // Catch: java.lang.Throwable -> L22
            android.content.ContentProviderClient r5 = r5.acquireUnstableContentProviderClient(r2)     // Catch: java.lang.Throwable -> L22
            if (r5 == 0) goto L54
            java.lang.String r2 = r2.getAuthority()     // Catch: java.lang.Throwable -> L22
            if (r2 != 0) goto L24
            java.lang.String r2 = ""
            goto L24
        L22:
            r5 = move-exception
            goto L5b
        L24:
            java.lang.String r3 = "setting.getAiCallStatus"
            r4 = 0
            android.os.Bundle r5 = r5.call(r2, r3, r4, r4)     // Catch: java.lang.Throwable -> L22
            if (r5 == 0) goto L54
            boolean r2 = r5.containsKey(r0)     // Catch: java.lang.Throwable -> L22
            if (r2 == 0) goto L4c
            boolean r5 = r5.getBoolean(r0)     // Catch: java.lang.Throwable -> L22
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L22
            r0.<init>()     // Catch: java.lang.Throwable -> L22
            java.lang.String r2 = "containsKey aiCallStatus: "
            r0.append(r2)     // Catch: java.lang.Throwable -> L22
            r0.append(r5)     // Catch: java.lang.Throwable -> L22
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L22
            H7.b.e(r1, r0)     // Catch: java.lang.Throwable -> L22
            return r5
        L4c:
            java.lang.String r5 = "not containsKey aiCallStatus"
            H7.b.e(r1, r5)     // Catch: java.lang.Throwable -> L22
            m9.q r5 = m9.q.f35511a     // Catch: java.lang.Throwable -> L22
            goto L56
        L54:
            com.android.contacts.business.calllog.breenocall.BreenoHelper$isBreenoOpen$1$2 r5 = new v9.InterfaceC1637a<m9.q>() { // from class: com.android.contacts.business.calllog.breenocall.BreenoHelper$isBreenoOpen$1$2
                static {
                    /*
                        com.android.contacts.business.calllog.breenocall.BreenoHelper$isBreenoOpen$1$2 r0 = new com.android.contacts.business.calllog.breenocall.BreenoHelper$isBreenoOpen$1$2
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.android.contacts.business.calllog.breenocall.BreenoHelper$isBreenoOpen$1$2) com.android.contacts.business.calllog.breenocall.BreenoHelper$isBreenoOpen$1$2.INSTANCE com.android.contacts.business.calllog.breenocall.BreenoHelper$isBreenoOpen$1$2
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.business.calllog.breenocall.BreenoHelper$isBreenoOpen$1$2.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.business.calllog.breenocall.BreenoHelper$isBreenoOpen$1$2.<init>():void");
                }

                @Override // v9.InterfaceC1637a
                public /* bridge */ /* synthetic */ m9.q invoke() {
                    /*
                        r0 = this;
                        r0.invoke2()
                        m9.q r0 = m9.q.f35511a
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.business.calllog.breenocall.BreenoHelper$isBreenoOpen$1$2.invoke():java.lang.Object");
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    /*
                        r1 = this;
                        java.lang.String r1 = "BreenoHelper"
                        java.lang.String r0 = "getAiCallStatus null"
                        H7.b.e(r1, r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.business.calllog.breenocall.BreenoHelper$isBreenoOpen$1$2.invoke2():void");
                }
            }     // Catch: java.lang.Throwable -> L22
        L56:
            java.lang.Object r5 = kotlin.Result.b(r5)     // Catch: java.lang.Throwable -> L22
            goto L65
        L5b:
            kotlin.Result$a r0 = kotlin.Result.f34166a
            java.lang.Object r5 = kotlin.b.a(r5)
            java.lang.Object r5 = kotlin.Result.b(r5)
        L65:
            java.lang.Throwable r5 = kotlin.Result.d(r5)
            if (r5 == 0) goto L7f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "isBreenoOpen error: "
            r0.append(r2)
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            H7.b.c(r1, r5)
        L7f:
            r5 = 1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.business.calllog.breenocall.BreenoHelper.isBreenoOpen(android.content.Context):boolean");
    }

    public static final boolean isCallSummaryOpen(Context context) {
        i.f(context, "context");
        int d10 = c.d(context, 0, ACCESSIBILITY_USER_NOTICE, 0);
        H7.b.e(TAG, "isCallSummaryOpen accessibility_user_notice settingsStatus: " + d10);
        if (d10 != 1) {
            return false;
        }
        if (!OsUtils.f28280f) {
            try {
                int f10 = com.oplus.aiunit.toolkits.a.f(context);
                H7.b.e(TAG, "isCallSummaryOpen getLLMQueueStatus: " + f10);
                if (f10 == -1) {
                    return true;
                }
                if (f10 == 0 || f10 == 1 || f10 == 2) {
                    return false;
                }
                try {
                    int g10 = com.oplus.aiunit.toolkits.a.g(context, "aigc_call_summary");
                    H7.b.e(TAG, "isCallSummaryOpen settingsStatus: " + g10);
                    if (-1 == g10) {
                        return true;
                    }
                    if (g10 == 0) {
                        return false;
                    }
                } catch (Exception e10) {
                    H7.b.e(TAG, "isCallSummaryOpen getSettingsStatus e: " + e10);
                    return true;
                }
            } catch (Exception e11) {
                H7.b.e(TAG, "isCallSummaryOpen getLLMQueueStatus e: " + e11);
                return true;
            }
        }
        try {
            int c10 = com.oplus.aiunit.toolkits.a.c(context, "aigc_call_summary");
            H7.b.e(TAG, "isCallSummaryOpen authorizeStatus: " + c10);
            if (-1 != c10 && c10 == 0) {
                return false;
            }
            return true;
        } catch (Exception e12) {
            H7.b.e(TAG, "isCallSummaryOpen getAuthorizeStatus e: " + e12);
            return true;
        }
    }

    public static final Intent jumpToSettingUIIntent() {
        Intent parseUri = Intent.parseUri(JUMP_BREENO_CALL_SETTING_DATA_URI, 1);
        i.e(parseUri, "parseUri(\n            JU…I_INTENT_SCHEME\n        )");
        return parseUri;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showBreenoCall(Context context, String str) {
        R7.b.f(context, Intent.parseUri(JUMP_BREENO_CALL_DATA_URI + str, 1), 0, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void toastNotExist(Context context, int i10) {
        com.oplus.foundation.util.ui.c.d(context, i10);
    }

    public static final void deleteBreenoCallLog(Context context, ArrayList<String> callUniqueIds) {
        Object b10;
        ContentResolver contentResolver;
        Uri uri;
        ContentProviderClient acquireUnstableContentProviderClient;
        Uri uri2;
        ContentProviderClient acquireUnstableContentProviderClient2;
        i.f(context, "context");
        i.f(callUniqueIds, "callUniqueIds");
        try {
            Result.a aVar = Result.f34166a;
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = callUniqueIds.iterator();
            int i10 = 0;
            while (it.hasNext()) {
                String next = it.next();
                if (i10 > BATCH_COUNT) {
                    ContentResolver contentResolver2 = context.getContentResolver();
                    if (contentResolver2 != null && (acquireUnstableContentProviderClient2 = contentResolver2.acquireUnstableContentProviderClient((uri2 = BREENO_CALL_RECORD_URI))) != null) {
                        acquireUnstableContentProviderClient2.delete(uri2, "callUniqueId IN (" + ((Object) sb) + ")", null);
                    }
                    j.f(sb);
                    DatabaseUtils.appendEscapedSQLString(sb, next);
                    i10 = 0;
                } else {
                    if (sb.length() > 0) {
                        sb.append(",");
                    }
                    DatabaseUtils.appendEscapedSQLString(sb, next);
                }
                i10++;
            }
            if (sb.length() > 0 && (contentResolver = context.getContentResolver()) != null && (acquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient((uri = BREENO_CALL_RECORD_URI))) != null) {
                acquireUnstableContentProviderClient.delete(uri, "callUniqueId IN (" + ((Object) sb) + ")", null);
            }
            b10 = Result.b(q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c(TAG, "deleteBreenoCallLog callUniqueIds error: " + d10);
        }
    }
}
