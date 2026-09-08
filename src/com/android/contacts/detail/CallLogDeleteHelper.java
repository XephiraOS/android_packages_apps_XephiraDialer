package com.android.contacts.detail;

import android.app.Dialog;
import android.content.Context;
import android.provider.CallLog;
import android.text.TextUtils;
import androidx.activity.ComponentActivity;
import com.oplus.dialer.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlinx.coroutines.C1248i;

/* compiled from: CallLogDeleteHelper.kt */
/* loaded from: classes.dex */
public final class CallLogDeleteHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final CallLogDeleteHelper f14366a = new CallLogDeleteHelper();

    /* compiled from: CallLogDeleteHelper.kt */
    /* loaded from: classes.dex */
    public interface a {
        void a(Dialog dialog);

        void onClick(int i10, boolean z10);
    }

    public static final String c(Context context, boolean z10, boolean z11, boolean z12, int i10) {
        String e10 = e(context, z10, z11, z12);
        if (!TextUtils.isEmpty(e10)) {
            kotlin.jvm.internal.m mVar = kotlin.jvm.internal.m.f34245a;
            String quantityString = context.getResources().getQuantityString(R.plurals.calllogs_have_associated_files_2, i10);
            kotlin.jvm.internal.i.e(quantityString, "context.resources.getQua…ssociated_files_2, count)");
            String format = String.format(quantityString, Arrays.copyOf(new Object[]{e10}, 1));
            kotlin.jvm.internal.i.e(format, "format(...)");
            return format;
        }
        return null;
    }

    public static final String d(Context context, int i10, int i11) {
        if (i10 == 1) {
            String string = context.getString(R.string.delete_this_calllog);
            kotlin.jvm.internal.i.e(string, "context.getString(R.string.delete_this_calllog)");
            return string;
        }
        if (i10 == i11) {
            String string2 = context.getString(R.string.delete_all_calllogs);
            kotlin.jvm.internal.i.e(string2, "context.getString(R.string.delete_all_calllogs)");
            return string2;
        }
        kotlin.jvm.internal.m mVar = kotlin.jvm.internal.m.f34245a;
        String quantityString = context.getResources().getQuantityString(R.plurals.delete_selected_calllogs, i10);
        kotlin.jvm.internal.i.e(quantityString, "context.resources.getQua…ected_calllogs, selected)");
        String format = String.format(quantityString, Arrays.copyOf(new Object[]{Integer.valueOf(i10)}, 1));
        kotlin.jvm.internal.i.e(format, "format(...)");
        return format;
    }

    public static final String e(Context context, boolean z10, boolean z11, boolean z12) {
        String string = context.getString(R.string.call_recording_2);
        kotlin.jvm.internal.i.e(string, "context.getString(R.string.call_recording_2)");
        String string2 = context.getString(R.string.breeno_call_summary_v4);
        kotlin.jvm.internal.i.e(string2, "context.getString(R.string.breeno_call_summary_v4)");
        String string3 = context.getString(R.string.breeno_calllog);
        kotlin.jvm.internal.i.e(string3, "context.getString(R.string.breeno_calllog)");
        String string4 = context.getString(R.string.punctuation_cn_comma);
        kotlin.jvm.internal.i.e(string4, "context.getString(R.string.punctuation_cn_comma)");
        StringBuilder sb = new StringBuilder();
        if (z10) {
            sb.append(string);
        }
        if (z11) {
            if (sb.length() > 0) {
                sb.append(string4);
            }
            sb.append(string2);
        }
        if (z12) {
            if (sb.length() > 0) {
                sb.append(string4);
            }
            sb.append(string3);
        }
        String sb2 = sb.toString();
        kotlin.jvm.internal.i.e(sb2, "sb.toString()");
        return sb2;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x0177  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final int f(final androidx.activity.ComponentActivity r19, java.util.ArrayList<Q0.b> r20, boolean r21, com.android.contacts.detail.D r22, final com.android.contacts.framework.baseui.util.t r23) {
        /*
            Method dump skipped, instructions count: 408
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.detail.CallLogDeleteHelper.f(androidx.activity.ComponentActivity, java.util.ArrayList, boolean, com.android.contacts.detail.D, com.android.contacts.framework.baseui.util.t):int");
    }

    public static final int g(Context context, ArrayList<Long> callIds) {
        int i10;
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(callIds, "callIds");
        if (callIds.size() < 500) {
            i10 = G7.c.c(context.getContentResolver(), CallLog.Calls.CONTENT_URI, "_id IN " + G7.a.d(callIds), null);
        } else {
            int i11 = 0;
            for (List list : com.google.common.collect.n.j(callIds, 500)) {
                if (list != null) {
                    i11 += G7.c.c(context.getContentResolver(), CallLog.Calls.CONTENT_URI, "_id IN " + G7.a.d(list), null);
                }
            }
            i10 = i11;
        }
        H7.b.e("CallLogDeleteHelper", "deleteCallLogs: input count: " + callIds.size() + ", delete count: " + i10);
        return i10;
    }

    public static final void h(ComponentActivity activity, ArrayList<Q0.b> callLogs, int i10, int i11, a callback) {
        kotlin.jvm.internal.i.f(activity, "activity");
        kotlin.jvm.internal.i.f(callLogs, "callLogs");
        kotlin.jvm.internal.i.f(callback, "callback");
        C1248i.d(kotlinx.coroutines.F.a(kotlinx.coroutines.S.b()), null, null, new CallLogDeleteHelper$showCallLogsDeleteWarningDialog$1(activity, i10, i11, callLogs, callback, null), 3, null);
    }

    public static final void i(ComponentActivity activity, String number, ArrayList<Q0.d> calls, int i10, int i11, a callback) {
        kotlin.jvm.internal.i.f(activity, "activity");
        kotlin.jvm.internal.i.f(number, "number");
        kotlin.jvm.internal.i.f(calls, "calls");
        kotlin.jvm.internal.i.f(callback, "callback");
        Q0.b bVar = new Q0.b(number, null, null, null, null, null, 62, null);
        bVar.a().addAll(calls);
        ArrayList arrayList = new ArrayList();
        arrayList.add(bVar);
        h(activity, arrayList, i10, i11, callback);
    }
}
