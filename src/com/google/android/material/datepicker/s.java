package com.google.android.material.datepicker;

import java.util.Calendar;
import java.util.TimeZone;

/* compiled from: TimeSource.java */
/* loaded from: classes3.dex */
public class s {

    /* renamed from: c, reason: collision with root package name */
    public static final s f23284c = new s(null, null);

    /* renamed from: a, reason: collision with root package name */
    public final Long f23285a;

    /* renamed from: b, reason: collision with root package name */
    public final TimeZone f23286b;

    public s(Long l10, TimeZone timeZone) {
        this.f23285a = l10;
        this.f23286b = timeZone;
    }

    public static s c() {
        return f23284c;
    }

    public Calendar a() {
        return b(this.f23286b);
    }

    public Calendar b(TimeZone timeZone) {
        Calendar calendar;
        if (timeZone == null) {
            calendar = Calendar.getInstance();
        } else {
            calendar = Calendar.getInstance(timeZone);
        }
        Long l10 = this.f23285a;
        if (l10 != null) {
            calendar.setTimeInMillis(l10.longValue());
        }
        return calendar;
    }
}
