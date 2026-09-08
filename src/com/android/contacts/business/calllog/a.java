package com.android.contacts.business.calllog;

import R0.c;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.provider.CallLog;
import com.android.contacts.framework.virtualsupport.utils.GrpcUtils;
import com.android.incallui.OplusPhoneUtils;

/* compiled from: CallLogUtils.java */
/* loaded from: classes.dex */
public class a {
    public static void a(Context context) {
        if (context != null) {
            com.oplus.foundation.util.ui.a.a(context, 0);
            G0.c.n(context, 0, c.a.f3195a, 0);
            com.android.contacts.framework.api.appstore.missedcall.a.a(context);
            b(context);
            GrpcUtils.syncClearMissedCallsOperation(context);
        }
    }

    public static void b(Context context) {
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("new", OplusPhoneUtils.DeviceState.UNLOCK_DEVICE);
        Uri a10 = R0.d.a(CallLog.Calls.CONTENT_URI_WITH_VOICEMAIL);
        int g10 = G7.c.g(context.getContentResolver(), a10, contentValues, "new=1", null);
        if (H7.a.b()) {
            H7.b.b("CallLogUtils", "uri: " + a10 + ", " + contentValues + ", " + g10);
        }
    }
}
