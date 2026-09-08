package com.heytap.epona.interceptor;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;
import com.heytap.epona.Response;
import com.heytap.epona.d;
import com.heytap.epona.ipc.local.RemoteTransfer;

/* compiled from: LaunchComponentInterceptor.java */
/* loaded from: classes3.dex */
public class e implements com.heytap.epona.d {
    @Override // com.heytap.epona.d
    public void a(d.a aVar) {
        String d10 = aVar.d().d();
        if (c(d10)) {
            H5.a.b("LaunchComponentInterceptor", "RemoteTransfer with componentName = %s found. Proceed", d10);
            aVar.b();
            return;
        }
        com.heytap.epona.a a10 = aVar.a();
        ApplicationInfo a11 = new C5.b().a(d10);
        if (a11 == null) {
            H5.a.b("LaunchComponentInterceptor", "find component:%s failed", d10);
            a10.O(Response.d());
        } else if (d(b(a11.packageName))) {
            aVar.b();
        } else {
            H5.a.b("LaunchComponentInterceptor", "launch component:%s failed", d10);
            a10.O(Response.d());
        }
    }

    public final Uri b(String str) {
        return Uri.parse("content://" + str + ".epona");
    }

    public final boolean c(String str) {
        if (RemoteTransfer.U7().T7(str) != null) {
            return true;
        }
        return false;
    }

    public final boolean d(Uri uri) {
        Context f10 = com.heytap.epona.c.f();
        if (f10 == null) {
            return false;
        }
        try {
            return f10.getContentResolver().call(uri, "launchComponent", (String) null, (Bundle) null).getBoolean("KEY_LAUNCH_SUCCESS");
        } catch (Exception unused) {
            return false;
        }
    }
}
