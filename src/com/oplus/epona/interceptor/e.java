package com.oplus.epona.interceptor;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import com.oplus.epona.Call$Callback;
import com.oplus.epona.Response;
import com.oplus.epona.f;
import com.oplus.utils.C0864z;
import f7.C1020b;

/* compiled from: LaunchComponentInterceptor.java */
/* loaded from: classes3.dex */
public class e implements f {
    @Override // com.oplus.epona.f
    public void a(f.a aVar) {
        String componentName = aVar.d().getComponentName();
        if (c(componentName)) {
            aVar.b();
            return;
        }
        Call$Callback a10 = aVar.a();
        ApplicationInfo a11 = new C1020b().a(componentName);
        if (a11 == null) {
            C0864z.c("Epona->LaunchComponentInterceptor", "find component:%s failed", componentName);
            a10.onReceive(Response.b());
        } else if (d(b(a11.packageName), componentName)) {
            aVar.b();
        } else {
            C0864z.c("Epona->LaunchComponentInterceptor", "launch component:%s failed", componentName);
            a10.onReceive(Response.b());
        }
    }

    public final Uri b(String str) {
        return Uri.parse("content://" + str + ".oplus.epona");
    }

    public final boolean c(String str) {
        if (com.oplus.epona.d.m().a(str) != null) {
            return true;
        }
        return false;
    }

    public boolean d(Uri uri, String str) {
        Context g10 = com.oplus.epona.d.g();
        if (g10 == null) {
            return false;
        }
        try {
            Bundle call = g10.getContentResolver().call(uri, "launchComponent", (String) null, (Bundle) null);
            boolean z10 = call.getBoolean("KEY_LAUNCH_SUCCESS");
            IBinder binder = call.getBinder("KEY_REMOTE_TRANSFER");
            if (z10 && binder != null) {
                f7.d.c().e(str, binder);
            }
            return z10;
        } catch (Exception unused) {
            return false;
        }
    }
}
