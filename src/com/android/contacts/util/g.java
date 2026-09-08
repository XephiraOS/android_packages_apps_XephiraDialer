package com.android.contacts.util;

import android.content.Context;
import com.oplus.dialer.R;
import java.util.Arrays;

/* compiled from: ContactListFilterUtil.kt */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f17567a = new g();

    public static final String a(Context context, int i10, int i11, boolean z10, boolean z11) {
        if (context != null && i10 != -1) {
            if (i10 == 0) {
                return context.getString(R.string.no_contacts_warnning);
            }
            if (z10) {
                if (z11) {
                    kotlin.jvm.internal.m mVar = kotlin.jvm.internal.m.f34245a;
                    String string = context.getString(R.string.oplus_contacts_merge_customcount);
                    kotlin.jvm.internal.i.e(string, "context.getString(R.stri…ntacts_merge_customcount)");
                    String format = String.format(string, Arrays.copyOf(new Object[]{U7.a.b(i10), U7.a.b(i11)}, 2));
                    kotlin.jvm.internal.i.e(format, "format(...)");
                    return format;
                }
                kotlin.jvm.internal.m mVar2 = kotlin.jvm.internal.m.f34245a;
                String string2 = context.getString(R.string.oplus_contacts_customcount);
                kotlin.jvm.internal.i.e(string2, "context.getString(R.stri…lus_contacts_customcount)");
                String format2 = String.format(string2, Arrays.copyOf(new Object[]{U7.a.b(i10)}, 1));
                kotlin.jvm.internal.i.e(format2, "format(...)");
                return format2;
            }
            if (z11) {
                kotlin.jvm.internal.m mVar3 = kotlin.jvm.internal.m.f34245a;
                String string3 = context.getString(R.string.oplus_contacts_merge_count);
                kotlin.jvm.internal.i.e(string3, "context.getString(R.stri…lus_contacts_merge_count)");
                String format3 = String.format(string3, Arrays.copyOf(new Object[]{U7.a.b(i10), U7.a.b(i11)}, 2));
                kotlin.jvm.internal.i.e(format3, "format(...)");
                return format3;
            }
            kotlin.jvm.internal.m mVar4 = kotlin.jvm.internal.m.f34245a;
            String string4 = context.getString(R.string.oplus_contacts_totalcount);
            kotlin.jvm.internal.i.e(string4, "context.getString(R.stri…plus_contacts_totalcount)");
            String format4 = String.format(string4, Arrays.copyOf(new Object[]{U7.a.b(i10)}, 1));
            kotlin.jvm.internal.i.e(format4, "format(...)");
            return format4;
        }
        return null;
    }
}
