package com.oplus.blacklistapp.callintercept.widget;

import V6.j;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import com.coui.appcompat.preference.COUIJumpPreference;
import com.coui.appcompat.preference.COUIPreferenceCategory;
import com.coui.appcompat.preference.COUISwitchPreference;
import com.oplus.blacklistapp.callintercept.settings.u;
import com.oplus.blacklistapp.callintercept.widget.ScheduleTimePreference;
import com.oplus.blacklistapp.callintercept.widget.WeekPicker;
import com.oplus.utils.C0846g;
import com.oplus.utils.StatisticsUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import v6.C1632f;

/* compiled from: TimeSettingsWidget.java */
/* loaded from: classes3.dex */
public class a implements ScheduleTimePreference.h, WeekPicker.b {

    /* renamed from: m, reason: collision with root package name */
    public static int f27014m;

    /* renamed from: a, reason: collision with root package name */
    public String[] f27015a;

    /* renamed from: b, reason: collision with root package name */
    public Activity f27016b;

    /* renamed from: c, reason: collision with root package name */
    public Context f27017c;

    /* renamed from: f, reason: collision with root package name */
    public PreferenceScreen f27020f;

    /* renamed from: g, reason: collision with root package name */
    public COUIPreferenceCategory f27021g;

    /* renamed from: h, reason: collision with root package name */
    public COUISwitchPreference f27022h;

    /* renamed from: i, reason: collision with root package name */
    public COUIJumpPreference f27023i;

    /* renamed from: j, reason: collision with root package name */
    public ScheduleTimePreference f27024j;

    /* renamed from: k, reason: collision with root package name */
    public WeekPickerPreference f27025k;

    /* renamed from: d, reason: collision with root package name */
    public int f27018d = -1;

    /* renamed from: e, reason: collision with root package name */
    public boolean f27019e = false;

    /* renamed from: l, reason: collision with root package name */
    public j.a f27026l = new j.a();

    public a(Activity activity, PreferenceScreen preferenceScreen, Preference.c cVar) {
        this.f27016b = activity;
        this.f27017c = activity.getApplicationContext();
        this.f27020f = preferenceScreen;
        this.f27021g = (COUIPreferenceCategory) preferenceScreen.findPreference("non_blocked_rules_category");
        this.f27015a = activity.getResources().getStringArray(com.oplus.blacklistapp.j.f27267c);
        if (C0846g.c()) {
            Log.d("TimeSettingsWidget", "mTimeSettingCategory = " + this.f27021g);
        }
        int i10 = 1;
        int firstDayOfWeek = Calendar.getInstance().getFirstDayOfWeek() - 1;
        String languageTag = Locale.getDefault().toLanguageTag();
        if (languageTag != null && languageTag.startsWith("bn")) {
            i10 = 5;
        } else if (languageTag == null || !languageTag.startsWith("pt")) {
            i10 = firstDayOfWeek;
        }
        if (C0846g.c()) {
            Log.d("TimeSettingsWidget", "languageTag = " + languageTag + ", startDay = " + i10);
        }
        if (f27014m != i10) {
            f27014m = i10;
            g(i10);
        }
        COUISwitchPreference cOUISwitchPreference = (COUISwitchPreference) this.f27020f.findPreference("auto_open_and_close_key");
        this.f27022h = cOUISwitchPreference;
        if (cOUISwitchPreference != null) {
            cOUISwitchPreference.setOnPreferenceChangeListener(cVar);
        }
        COUIJumpPreference cOUIJumpPreference = (COUIJumpPreference) this.f27020f.findPreference("days_setting");
        this.f27023i = cOUIJumpPreference;
        if (cOUIJumpPreference != null) {
            cOUIJumpPreference.setOnPreferenceChangeListener(cVar);
        }
        WeekPickerPreference weekPickerPreference = (WeekPickerPreference) this.f27020f.findPreference("week_picker");
        this.f27025k = weekPickerPreference;
        if (weekPickerPreference != null) {
            weekPickerPreference.setOnPreferenceChangeListener(cVar);
            this.f27025k.c(this);
        }
        this.f27024j = (ScheduleTimePreference) this.f27020f.findPreference("schedule_time_settings");
        l(65, 23, 0, 8, 0);
        ScheduleTimePreference scheduleTimePreference = this.f27024j;
        if (scheduleTimePreference != null) {
            scheduleTimePreference.s(this);
            this.f27024j.t(this.f27026l);
        }
    }

    @Override // com.oplus.blacklistapp.callintercept.widget.ScheduleTimePreference.h
    public void a(int i10, int i11) {
        m(i10, i11);
        d("change_schedule", "start");
    }

    @Override // com.oplus.blacklistapp.callintercept.widget.ScheduleTimePreference.h
    public void b(int i10, int i11) {
        k(i10, i11);
        d("change_schedule", "end");
    }

    public final void c(String str, int i10) {
        StatisticsUtils.a(this.f27017c, 2010804, 201082006, StatisticsUtils.f(str, i10, this.f27019e, this.f27018d), false);
    }

    public final void d(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(str, str2);
        StatisticsUtils.a(this.f27017c, 2010804, 201082006, hashMap, false);
    }

    public void e() {
        if (this.f27017c == null) {
            return;
        }
        String str = "open_days_" + this.f27018d;
        String str2 = "open_start_hour_" + this.f27018d;
        String str3 = "open_start_minute_" + this.f27018d;
        String str4 = "open_end_hour_" + this.f27018d;
        String str5 = "open_end_minute_" + this.f27018d;
        SharedPreferences b10 = androidx.preference.j.b(this.f27017c);
        boolean C10 = C1632f.C(b10, "auto_open_and_close", 0, this.f27018d);
        COUISwitchPreference cOUISwitchPreference = this.f27022h;
        if (cOUISwitchPreference != null) {
            cOUISwitchPreference.setChecked(C10);
        }
        n(C10);
        int i10 = b10.getInt(str, 65);
        int i11 = b10.getInt(str2, 23);
        int i12 = b10.getInt(str3, 0);
        int i13 = b10.getInt(str4, 8);
        int i14 = b10.getInt(str5, 0);
        if (C0846g.c()) {
            Log.d("TimeSettingsWidget", "initScheduleData daysFlag = " + i10 + " startHour = " + i11 + " startMinute = " + i12 + " endHour = " + i13 + " endMinute = " + i14);
        }
        l(i10, i11, i12, i13, i14);
        this.f27025k.d(this.f27026l.f4086a);
    }

    public boolean f(Preference preference, Object obj) {
        if (!"auto_open_and_close_key".equals(preference.getKey())) {
            return false;
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        n(booleanValue);
        SharedPreferences b10 = androidx.preference.j.b(this.f27017c);
        u.d(b10, this.f27018d, "auto_open_and_close", booleanValue, 0);
        c("schedule_blocking", b10.getInt("auto_open_and_close", 0));
        return true;
    }

    public final void g(int i10) {
        int i11 = 0;
        int i12 = i10;
        while (true) {
            int[] iArr = com.oplus.blacklistapp.callintercept.a.f26581p;
            if (i12 >= iArr.length) {
                break;
            }
            com.oplus.blacklistapp.callintercept.a.f26578m[i11] = com.oplus.blacklistapp.callintercept.a.f26579n[i12];
            com.oplus.blacklistapp.callintercept.a.f26580o[i11] = iArr[i12];
            i11++;
            i12++;
        }
        for (int i13 = 0; i13 < i10; i13++) {
            com.oplus.blacklistapp.callintercept.a.f26578m[i11] = com.oplus.blacklistapp.callintercept.a.f26579n[i13];
            com.oplus.blacklistapp.callintercept.a.f26580o[i11] = com.oplus.blacklistapp.callintercept.a.f26581p[i13];
            i11++;
        }
    }

    public void h(int i10, boolean z10) {
        if (C0846g.c()) {
            Log.d("TimeSettingsWidget", "setSlotId = " + i10);
        }
        this.f27018d = i10;
        this.f27019e = z10;
        e();
    }

    public void i() {
        j.a aVar = this.f27026l;
        if (aVar == null) {
            return;
        }
        int c10 = com.oplus.blacklistapp.callintercept.a.c(aVar.f4086a);
        if (C0846g.c()) {
            Log.d("TimeSettingsWidget", "updateDayRule newKeyValue = " + c10);
        }
        Context context = this.f27017c;
        if (context != null) {
            androidx.preference.j.b(context).edit().putInt("open_days_" + this.f27018d, c10).apply();
        }
    }

    public final void j() {
        j.a aVar;
        COUIJumpPreference cOUIJumpPreference;
        if (this.f27016b != null && (aVar = this.f27026l) != null) {
            ArrayList<Integer> arrayList = aVar.f4086a;
            if (arrayList != null && arrayList.size() > 0) {
                if (arrayList.size() == 7) {
                    this.f27023i.setAssignment(this.f27016b.getString(com.oplus.blacklistapp.u.f27714x3));
                    this.f27023i.notifyDependencyChange(false);
                    return;
                }
                StringBuilder sb = new StringBuilder();
                int i10 = 0;
                while (true) {
                    int[] iArr = com.oplus.blacklistapp.callintercept.a.f26580o;
                    if (i10 >= iArr.length) {
                        break;
                    }
                    int i11 = iArr[i10];
                    int i12 = 0;
                    while (true) {
                        if (i12 >= arrayList.size()) {
                            break;
                        }
                        if (i11 == arrayList.get(i12).intValue()) {
                            if (sb.length() > 0) {
                                sb.append(this.f27016b.getString(com.oplus.blacklistapp.u.f27619e3));
                            }
                            sb.append(this.f27015a[i11 - 1]);
                        } else {
                            i12++;
                        }
                    }
                    i10++;
                }
                if (sb.length() > 0 && (cOUIJumpPreference = this.f27023i) != null) {
                    cOUIJumpPreference.setAssignment(sb);
                    this.f27023i.notifyDependencyChange(false);
                    return;
                }
            }
            COUIJumpPreference cOUIJumpPreference2 = this.f27023i;
            if (cOUIJumpPreference2 != null) {
                cOUIJumpPreference2.setAssignment(this.f27016b.getString(com.oplus.blacklistapp.u.f27719y3));
                this.f27023i.notifyDependencyChange(true);
            }
        }
    }

    public void k(int i10, int i11) {
        j.a aVar = this.f27026l;
        if (aVar == null) {
            return;
        }
        aVar.f4089d = i10;
        aVar.f4090e = i11;
        String str = "open_end_hour_" + this.f27018d;
        String str2 = "open_end_minute_" + this.f27018d;
        if (C0846g.c()) {
            Log.d("TimeSettingsWidget", "updateStartTime endHourkey " + str + "  hour = " + i10 + "  endMinutekey " + str2 + " minute = " + i11);
        }
        Context context = this.f27017c;
        if (context != null) {
            androidx.preference.j.b(context).edit().putInt(str, i10).putInt(str2, i11).apply();
        }
    }

    public void l(int i10, int i11, int i12, int i13, int i14) {
        if (this.f27026l == null) {
            this.f27026l = new j.a();
        }
        j.a aVar = this.f27026l;
        aVar.f4087b = i11;
        aVar.f4088c = i12;
        aVar.f4089d = i13;
        aVar.f4090e = i14;
        aVar.f4086a = com.oplus.blacklistapp.callintercept.a.e(i10);
        ScheduleTimePreference scheduleTimePreference = this.f27024j;
        if (scheduleTimePreference != null) {
            scheduleTimePreference.t(this.f27026l);
        }
        j();
        if (C0846g.c()) {
            Log.d("TimeSettingsWidget", "updateSchedule = " + this.f27026l);
        }
    }

    public void m(int i10, int i11) {
        j.a aVar = this.f27026l;
        if (aVar == null) {
            return;
        }
        aVar.f4087b = i10;
        aVar.f4088c = i11;
        String str = "open_start_hour_" + this.f27018d;
        String str2 = "open_start_minute_" + this.f27018d;
        if (C0846g.c()) {
            Log.d("TimeSettingsWidget", "updateStartTime startHourkey " + str + "  hour = " + i10 + "  startMinutekey " + str2 + " minute = " + i11);
        }
        Context context = this.f27017c;
        if (context != null) {
            androidx.preference.j.b(context).edit().putInt(str, i10).putInt(str2, i11).apply();
        }
    }

    public void n(boolean z10) {
        COUIPreferenceCategory cOUIPreferenceCategory = this.f27021g;
        if (cOUIPreferenceCategory == null) {
            return;
        }
        if (z10) {
            cOUIPreferenceCategory.addPreference(this.f27023i);
            this.f27021g.addPreference(this.f27024j);
            this.f27021g.addPreference(this.f27025k);
            this.f27025k.d(this.f27026l.f4086a);
            return;
        }
        cOUIPreferenceCategory.removePreference(this.f27023i);
        this.f27021g.removePreference(this.f27024j);
        this.f27021g.removePreference(this.f27025k);
    }

    public final void o() {
        j.a aVar;
        if (this.f27016b != null && (aVar = this.f27026l) != null) {
            ArrayList<Integer> arrayList = aVar.f4086a;
            WeekPicker a10 = this.f27025k.a();
            if (a10 != null) {
                a10.setAllChecked(false);
                if (arrayList != null && arrayList.size() > 0) {
                    if (arrayList.size() == 7) {
                        a10.setAllChecked(true);
                        return;
                    }
                    Iterator<Integer> it = arrayList.iterator();
                    while (it.hasNext()) {
                        a10.f(it.next().intValue(), true);
                    }
                }
            }
        }
    }

    @Override // com.oplus.blacklistapp.callintercept.widget.WeekPicker.b
    public void onClick(View view) {
        Integer num = (Integer) view.getTag();
        num.intValue();
        j.a aVar = this.f27026l;
        ArrayList<Integer> arrayList = aVar.f4086a;
        if (arrayList == null) {
            aVar.f4086a = new ArrayList<>();
            this.f27026l.f4086a.add(num);
        } else if (arrayList.contains(num)) {
            this.f27026l.f4086a.remove(num);
        } else {
            this.f27026l.f4086a.add(num);
        }
        j();
        i();
        o();
    }
}
