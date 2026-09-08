package com.google.android.material.datepicker;

import android.content.Context;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* compiled from: DateStrings.java */
/* loaded from: classes3.dex */
public class h {
    public static I.d<String, String> a(Long l10, Long l11) {
        return b(l10, l11, null);
    }

    public static I.d<String, String> b(Long l10, Long l11, SimpleDateFormat simpleDateFormat) {
        if (l10 == null && l11 == null) {
            return I.d.a(null, null);
        }
        if (l10 == null) {
            return I.d.a(null, d(l11.longValue(), simpleDateFormat));
        }
        if (l11 == null) {
            return I.d.a(d(l10.longValue(), simpleDateFormat), null);
        }
        Calendar k10 = t.k();
        Calendar m10 = t.m();
        m10.setTimeInMillis(l10.longValue());
        Calendar m11 = t.m();
        m11.setTimeInMillis(l11.longValue());
        if (simpleDateFormat != null) {
            return I.d.a(simpleDateFormat.format(new Date(l10.longValue())), simpleDateFormat.format(new Date(l11.longValue())));
        }
        if (m10.get(1) == m11.get(1)) {
            if (m10.get(1) == k10.get(1)) {
                return I.d.a(g(l10.longValue(), Locale.getDefault()), g(l11.longValue(), Locale.getDefault()));
            }
            return I.d.a(g(l10.longValue(), Locale.getDefault()), n(l11.longValue(), Locale.getDefault()));
        }
        return I.d.a(n(l10.longValue(), Locale.getDefault()), n(l11.longValue(), Locale.getDefault()));
    }

    public static String c(long j10) {
        return d(j10, null);
    }

    public static String d(long j10, SimpleDateFormat simpleDateFormat) {
        if (simpleDateFormat != null) {
            return simpleDateFormat.format(new Date(j10));
        }
        if (q(j10)) {
            return f(j10);
        }
        return m(j10);
    }

    public static String e(Context context, long j10, boolean z10, boolean z11, boolean z12) {
        String j11 = j(j10);
        if (z10) {
            j11 = String.format(context.getString(e4.k.f30966S), j11);
        }
        if (z11) {
            return String.format(context.getString(e4.k.f30962O), j11);
        }
        if (z12) {
            return String.format(context.getString(e4.k.f30950C), j11);
        }
        return j11;
    }

    public static String f(long j10) {
        return g(j10, Locale.getDefault());
    }

    public static String g(long j10, Locale locale) {
        return t.b(locale).format(new Date(j10));
    }

    public static String h(long j10) {
        return i(j10, Locale.getDefault());
    }

    public static String i(long j10, Locale locale) {
        return t.h(locale).format(new Date(j10));
    }

    public static String j(long j10) {
        if (q(j10)) {
            return h(j10);
        }
        return o(j10);
    }

    public static String k(Context context, int i10) {
        if (t.k().get(1) == i10) {
            return String.format(context.getString(e4.k.f30955H), Integer.valueOf(i10));
        }
        return String.format(context.getString(e4.k.f30956I), Integer.valueOf(i10));
    }

    public static String l(long j10) {
        return t.p(Locale.getDefault()).format(new Date(j10));
    }

    public static String m(long j10) {
        return n(j10, Locale.getDefault());
    }

    public static String n(long j10, Locale locale) {
        return t.o(locale).format(new Date(j10));
    }

    public static String o(long j10) {
        return p(j10, Locale.getDefault());
    }

    public static String p(long j10, Locale locale) {
        return t.q(locale).format(new Date(j10));
    }

    public static boolean q(long j10) {
        Calendar k10 = t.k();
        Calendar m10 = t.m();
        m10.setTimeInMillis(j10);
        if (k10.get(1) == m10.get(1)) {
            return true;
        }
        return false;
    }
}
