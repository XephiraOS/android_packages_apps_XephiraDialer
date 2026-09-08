package com.android.contacts;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import com.android.incallui.OplusPhoneUtils;
import com.oplus.dialer.R;

/* compiled from: HighLightUtils.java */
/* loaded from: classes.dex */
public class P0 {
    public static SpannableStringBuilder a(Context context) {
        String string = context.getString(R.string.dialpad_query_contacts_text);
        if (com.customize.contacts.util.K.a().startsWith("tr")) {
            string = "\"" + string.replaceAll("\u200b", "");
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) string);
        int a10 = com.android.contacts.framework.baseui.util.r.a(context);
        int indexOf = string.indexOf(34);
        int indexOf2 = string.indexOf("(");
        int indexOf3 = string.indexOf(OplusPhoneUtils.DeviceState.LOCK_DEVICE);
        int indexOf4 = string.indexOf("C");
        int indexOf5 = string.indexOf("c");
        if (H7.a.b()) {
            H7.b.b("HighLightUtils", "start1=" + indexOf + "  start2=" + indexOf2 + ", start4 = " + indexOf4 + ", start5 = " + indexOf5);
        }
        try {
            if (indexOf != -1) {
                int i10 = indexOf + 4;
                if (string.contains("\u200f")) {
                    i10 = indexOf + 5;
                }
                spannableStringBuilder.setSpan(new ForegroundColorSpan(a10), indexOf + 1, i10, 33);
            } else if (indexOf4 != -1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(a10), indexOf4, indexOf4 + 3, 33);
            } else if (indexOf5 != -1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(a10), indexOf5, indexOf5 + 3, 33);
            }
            if (indexOf2 != -1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(a10), indexOf2 + 1, indexOf2 + 4, 33);
            } else if (indexOf3 != -1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(a10), indexOf3, indexOf3 + 3, 33);
            }
        } catch (Exception e10) {
            H7.b.c("HighLightUtils", "Exception e: " + e10);
        }
        return spannableStringBuilder;
    }
}
