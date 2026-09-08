package com.customize.contacts.util;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import com.oplus.dialer.R;

/* compiled from: ContactsIntentUtils.java */
/* renamed from: com.customize.contacts.util.s, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0807s {
    public static Intent a(Context context, int i10, int i11) {
        if (((KeyguardManager) context.getSystemService("keyguard")).isDeviceSecure()) {
            String string = context.getString(i10);
            String string2 = context.getString(i11);
            Intent intent = new Intent("android.app.action.CONFIRM_DEVICE_CREDENTIAL");
            intent.putExtra("start_type", "customize_head");
            intent.putExtra("customize_head_str_pattern", string);
            intent.putExtra("customize_head_str_password", string2);
            return intent;
        }
        return null;
    }

    public static Intent b(Context context) {
        return a(context, R.string.oplus_delete_all_calllog_patten_tips, R.string.oplus_delete_all_calllog_password_tips);
    }

    public static Intent c(Context context) {
        return a(context, R.string.oplus_delete_all_patten_tips, R.string.oplus_delete_all_password_tips);
    }

    public static Intent d(Context context) {
        return a(context, R.string.oplus_delete_all_voicemail_patten_tips, R.string.oplus_delete_all_voicemail_password_tips);
    }
}
