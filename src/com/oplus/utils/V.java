package com.oplus.utils;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;
import com.android.incallui.OplusSpecialNumberUtils;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* compiled from: SpecialNumberUtils.java */
/* loaded from: classes3.dex */
public class V {

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f29105d = {"number", OplusSpecialNumberUtils.OplusSpecialNumColumns.CN_NAME, OplusSpecialNumberUtils.OplusSpecialNumColumns.PHOTO_DATA};

    /* renamed from: a, reason: collision with root package name */
    public final Context f29106a;

    /* renamed from: b, reason: collision with root package name */
    public String f29107b = null;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f29108c = null;

    public V(Context context) {
        this.f29106a = context;
    }

    public InputStream a() {
        if (this.f29108c == null) {
            return null;
        }
        return new ByteArrayInputStream(this.f29108c);
    }

    public String b() {
        return this.f29107b;
    }

    public boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String replace = str.replace("-", "").replace(" ", "");
        Cursor cursor = null;
        try {
            try {
                cursor = this.f29106a.getContentResolver().query(C0848i.o(this.f29106a), f29105d, "number='" + replace + "'", null, null);
                if (cursor != null) {
                    if (cursor.moveToFirst()) {
                        this.f29107b = cursor.getString(1);
                        this.f29108c = cursor.getBlob(2);
                        cursor.close();
                        return true;
                    }
                    cursor.close();
                    return false;
                }
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            } catch (Exception e10) {
                Log.e("SpecialNumberUtils", "e = " + e10);
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }
}
