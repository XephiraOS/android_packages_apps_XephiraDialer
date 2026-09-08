package com.google.android.material.datepicker;

import android.content.res.Resources;
import android.icu.text.DateFormat;
import android.icu.text.DisplayContext;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: UtcDates.java */
/* loaded from: classes3.dex */
public class t {

    /* renamed from: a, reason: collision with root package name */
    public static AtomicReference<s> f23287a = new AtomicReference<>();

    public static long a(long j10) {
        Calendar m10 = m();
        m10.setTimeInMillis(j10);
        return e(m10).getTimeInMillis();
    }

    public static DateFormat b(Locale locale) {
        return c("MMMd", locale);
    }

    public static DateFormat c(String str, Locale locale) {
        DateFormat instanceForSkeleton = DateFormat.getInstanceForSkeleton(str, locale);
        instanceForSkeleton.setTimeZone(l());
        instanceForSkeleton.setContext(DisplayContext.CAPITALIZATION_FOR_STANDALONE);
        return instanceForSkeleton;
    }

    public static String d(String str) {
        return str.replaceAll("[^dMy/\\-.]", "").replaceAll("d{1,2}", "dd").replaceAll("M{1,2}", "MM").replaceAll("y{1,4}", "yyyy").replaceAll("\\.$", "").replaceAll("My", "M/y");
    }

    public static Calendar e(Calendar calendar) {
        Calendar n10 = n(calendar);
        Calendar m10 = m();
        m10.set(n10.get(1), n10.get(2), n10.get(5));
        return m10;
    }

    public static SimpleDateFormat f() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(d(((SimpleDateFormat) java.text.DateFormat.getDateInstance(3, Locale.getDefault())).toPattern()), Locale.getDefault());
        simpleDateFormat.setTimeZone(j());
        simpleDateFormat.setLenient(false);
        return simpleDateFormat;
    }

    public static String g(Resources resources, SimpleDateFormat simpleDateFormat) {
        String pattern = simpleDateFormat.toPattern();
        String string = resources.getString(e4.k.f30965R);
        String string2 = resources.getString(e4.k.f30964Q);
        String string3 = resources.getString(e4.k.f30963P);
        if (Locale.getDefault().getLanguage().equals(Locale.KOREAN.getLanguage())) {
            pattern = pattern.replaceAll("d+", com.android.contacts.list.d.f16900U).replaceAll("M+", "M").replaceAll("y+", "y");
        }
        return pattern.replace(com.android.contacts.list.d.f16900U, string3).replace("M", string2).replace("y", string);
    }

    public static DateFormat h(Locale locale) {
        return c("MMMMEEEEd", locale);
    }

    public static s i() {
        s sVar = f23287a.get();
        if (sVar == null) {
            return s.c();
        }
        return sVar;
    }

    public static TimeZone j() {
        return TimeZone.getTimeZone("UTC");
    }

    public static Calendar k() {
        Calendar a10 = i().a();
        a10.set(11, 0);
        a10.set(12, 0);
        a10.set(13, 0);
        a10.set(14, 0);
        a10.setTimeZone(j());
        return a10;
    }

    public static android.icu.util.TimeZone l() {
        return android.icu.util.TimeZone.getTimeZone("UTC");
    }

    public static Calendar m() {
        return n(null);
    }

    public static Calendar n(Calendar calendar) {
        Calendar calendar2 = Calendar.getInstance(j());
        if (calendar == null) {
            calendar2.clear();
        } else {
            calendar2.setTimeInMillis(calendar.getTimeInMillis());
        }
        return calendar2;
    }

    public static DateFormat o(Locale locale) {
        return c("yMMMd", locale);
    }

    public static DateFormat p(Locale locale) {
        return c("yMMMM", locale);
    }

    public static DateFormat q(Locale locale) {
        return c("yMMMMEEEEd", locale);
    }
}
