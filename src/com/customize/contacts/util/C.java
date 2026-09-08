package com.customize.contacts.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.storage.StorageVolume;
import android.text.TextUtils;
import com.oplus.dialer.R;
import com.oplus.wrapper.os.storage.StorageManager;
import java.io.File;

/* compiled from: Environment.java */
/* loaded from: classes3.dex */
public class C {

    /* renamed from: a, reason: collision with root package name */
    public static String f21865a;

    /* renamed from: b, reason: collision with root package name */
    public static String f21866b;

    public static File a(Context context) {
        i(context);
        if (f21866b == null) {
            return null;
        }
        return new File(f21866b);
    }

    public static String b(Context context) {
        i(context);
        if (g()) {
            try {
                if (C7.b.a(30, 1)) {
                    return new StorageManager((android.os.storage.StorageManager) context.getSystemService("storage")).getVolumeState(f21866b);
                }
                return N6.a.b(context, f21866b);
            } catch (Exception e10) {
                H7.b.c("Environment", "Exception = " + e10);
                return null;
            }
        }
        return f(context, f21866b);
    }

    public static String c(Context context) {
        File a10;
        String absolutePath;
        if ("mounted".equals(e(context))) {
            File d10 = d(context);
            if (d10 != null) {
                absolutePath = d10.getAbsolutePath();
            }
            absolutePath = null;
        } else {
            if ("mounted".equals(b(context)) && (a10 = a(context)) != null) {
                absolutePath = a10.getAbsolutePath();
            }
            absolutePath = null;
        }
        if (TextUtils.isEmpty(absolutePath)) {
            return null;
        }
        return absolutePath;
    }

    public static File d(Context context) {
        i(context);
        if (f21865a == null) {
            return null;
        }
        return new File(f21865a);
    }

    public static String e(Context context) {
        i(context);
        if (g()) {
            try {
                if (C7.b.a(30, 1)) {
                    return new StorageManager((android.os.storage.StorageManager) context.getSystemService("storage")).getVolumeState(f21865a);
                }
                return N6.a.b(context, f21865a);
            } catch (Exception e10) {
                H7.b.c("Environment", "Exception = " + e10);
                return null;
            }
        }
        return f(context, f21865a);
    }

    public static String f(Context context, String str) {
        if (str == null) {
            return null;
        }
        try {
            StorageVolume storageVolume = ((android.os.storage.StorageManager) context.getSystemService("storage")).getStorageVolume(new File(str));
            if (storageVolume != null) {
                return storageVolume.getState();
            }
            return "unknown";
        } catch (Exception e10) {
            H7.b.c("Environment", "Exception = " + e10);
            return null;
        }
    }

    public static boolean g() {
        return true;
    }

    public static String h(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String j10 = D7.a.j(context);
        String i10 = D7.a.i(context);
        if (H7.a.b()) {
            H7.b.b("Environment", "interdir = " + j10 + " ,exterdir = " + i10);
        }
        Resources resources = context.getResources();
        StringBuilder sb = new StringBuilder(str);
        if (!TextUtils.isEmpty(j10) && str.indexOf(j10) == 0) {
            return sb.replace(0, j10.length(), resources.getString(R.string.internal_sd_name_tablet)).toString();
        }
        if (!TextUtils.isEmpty(i10) && str.indexOf(i10) == 0) {
            return sb.replace(0, i10.length(), resources.getString(R.string.external_sd_name)).toString();
        }
        return str;
    }

    public static void i(Context context) {
        StorageVolume[] a10;
        try {
            if (C7.b.a(30, 1)) {
                a10 = new StorageManager((android.os.storage.StorageManager) context.getSystemService("storage")).getVolumeList();
            } else {
                a10 = N6.a.a(J3.b.c(), 0);
            }
            if (H7.a.b()) {
                H7.b.b("Environment", "the length of volumes[] is: " + a10.length + " ,expected is 1 or 2 !");
            }
            if (a10 == null) {
                return;
            }
            for (StorageVolume storageVolume : a10) {
                com.oplus.wrapper.os.storage.StorageVolume storageVolume2 = new com.oplus.wrapper.os.storage.StorageVolume(storageVolume);
                if (storageVolume.isRemovable()) {
                    if (C7.b.a(30, 1)) {
                        f21866b = storageVolume2.getPath();
                    } else {
                        f21866b = N6.c.a(storageVolume);
                    }
                } else if (C7.b.a(30, 1)) {
                    f21865a = storageVolume2.getPath();
                } else {
                    f21865a = N6.c.a(storageVolume);
                }
            }
        } catch (Exception e10) {
            H7.b.c("Environment", "Exception = " + e10);
        }
    }
}
