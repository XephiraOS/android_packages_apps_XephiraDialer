package com.android.contacts.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.text.TextUtils;
import android.text.format.DateUtils;
import com.heytap.accessory.constant.AFConstants;
import com.oplus.dialer.R;

/* compiled from: DataStatus.java */
/* loaded from: classes.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    public int f17580a = -1;

    /* renamed from: b, reason: collision with root package name */
    public String f17581b = null;

    /* renamed from: c, reason: collision with root package name */
    public long f17582c = -1;

    /* renamed from: d, reason: collision with root package name */
    public String f17583d = null;

    /* renamed from: e, reason: collision with root package name */
    public int f17584e = -1;

    /* renamed from: f, reason: collision with root package name */
    public int f17585f = -1;

    public n() {
    }

    public static int b(Cursor cursor, String str, int i10) {
        int columnIndex = cursor.getColumnIndex(str);
        if (!cursor.isNull(columnIndex)) {
            return cursor.getInt(columnIndex);
        }
        return i10;
    }

    public static long c(Cursor cursor, String str, long j10) {
        int columnIndex = cursor.getColumnIndex(str);
        if (!cursor.isNull(columnIndex)) {
            return cursor.getLong(columnIndex);
        }
        return j10;
    }

    public static String f(Cursor cursor, String str) {
        return cursor.getString(cursor.getColumnIndex(str));
    }

    public final void a(Cursor cursor) {
        this.f17580a = b(cursor, "mode", -1);
        this.f17581b = f(cursor, AFConstants.EXTRA_STATUS);
        this.f17582c = c(cursor, "status_ts", -1L);
        this.f17583d = f(cursor, "status_res_package");
        this.f17584e = b(cursor, "status_icon", -1);
        this.f17585f = b(cursor, "status_label", -1);
    }

    public int d() {
        return this.f17580a;
    }

    public CharSequence e() {
        return this.f17581b;
    }

    public CharSequence g(Context context) {
        boolean z10;
        boolean z11;
        CharSequence charSequence;
        CharSequence charSequence2;
        PackageManager packageManager = context.getPackageManager();
        if (this.f17583d == null) {
            this.f17583d = context.getPackageName();
        }
        long j10 = this.f17582c;
        if (j10 > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (this.f17583d != null && this.f17585f != -1) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10) {
            charSequence = DateUtils.getRelativeTimeSpanString(j10, System.currentTimeMillis(), 60000L, 262144);
        } else {
            charSequence = null;
        }
        if (z11) {
            charSequence2 = packageManager.getText(this.f17583d, this.f17585f, null);
        } else {
            charSequence2 = null;
        }
        if (z10 && z11) {
            return context.getString(R.string.contact_status_update_attribution_with_date, charSequence, charSequence2);
        }
        if (z11) {
            return context.getString(R.string.contact_status_update_attribution, charSequence2);
        }
        if (!z10) {
            return null;
        }
        return charSequence;
    }

    public boolean h() {
        return !TextUtils.isEmpty(this.f17581b);
    }

    public n(Cursor cursor) {
        a(cursor);
    }
}
