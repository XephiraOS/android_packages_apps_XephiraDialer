package com.heytap.epona.ipc.remote;

import F5.b;
import H5.a;
import N5.c;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import java.util.List;

/* loaded from: classes3.dex */
public class DispatcherProvider extends ContentProvider {
    public final Bundle a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            bundle2.putBinder("com.heytap.epona.Dispatcher.TRANSFER_VALUE", b.c().b(bundle.getString("com.heytap.epona.Dispatcher.TRANSFER_KEY")));
        }
        return bundle2;
    }

    public final boolean b() {
        if (c.e().g() || getContext().checkCallingPermission("com.oppo.permission.safe.SECURITY") == 0) {
            return true;
        }
        return false;
    }

    public final Bundle c(Bundle bundle, String str) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            bundle2.putBoolean("REGISTER_TRANSFER_RESULT", b.c().e(bundle.getString("com.heytap.epona.Dispatcher.TRANSFER_KEY"), bundle.getBinder("com.heytap.epona.Dispatcher.TRANSFER_VALUE"), str));
        }
        return bundle2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0058, code lost:
    
        if (r4.equals("com.heytap.epona.Dispatcher.REGISTER_TRANSFER") == false) goto L8;
     */
    @Override // android.content.ContentProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.os.Bundle call(java.lang.String r4, java.lang.String r5, android.os.Bundle r6) {
        /*
            r3 = this;
            boolean r0 = r3.b()
            r1 = 0
            if (r0 != 0) goto L2f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "<CALL> Calling package : ["
            r4.append(r5)
            java.lang.String r3 = r3.getCallingPackage()
            r4.append(r3)
            java.lang.String r3 = "] have no permission : "
            r4.append(r3)
            java.lang.String r3 = "com.oppo.permission.safe.SECURITY"
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            java.lang.Object[] r4 = new java.lang.Object[r1]
            java.lang.String r5 = "DispatcherProvider"
            H5.a.c(r5, r3, r4)
            r3 = 0
            return r3
        L2f:
            r4.hashCode()
            int r0 = r4.hashCode()
            r2 = -1
            switch(r0) {
                case -388087951: goto L52;
                case 272846363: goto L47;
                case 581077383: goto L3c;
                default: goto L3a;
            }
        L3a:
            r1 = r2
            goto L5b
        L3c:
            java.lang.String r0 = "com.heytap.epona.Dispatcher.REMOTE_SNAPSHOT"
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto L45
            goto L3a
        L45:
            r1 = 2
            goto L5b
        L47:
            java.lang.String r0 = "com.heytap.epona.Dispatcher.FIND_TRANSFER"
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto L50
            goto L3a
        L50:
            r1 = 1
            goto L5b
        L52:
            java.lang.String r0 = "com.heytap.epona.Dispatcher.REGISTER_TRANSFER"
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto L5b
            goto L3a
        L5b:
            switch(r1) {
                case 0: goto L6d;
                case 1: goto L68;
                case 2: goto L63;
                default: goto L5e;
            }
        L5e:
            android.os.Bundle r3 = super.call(r4, r5, r6)
            return r3
        L63:
            android.os.Bundle r3 = r3.d()
            return r3
        L68:
            android.os.Bundle r3 = r3.a(r6)
            return r3
        L6d:
            java.lang.String r4 = r3.getCallingPackage()
            android.os.Bundle r3 = r3.c(r6, r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.heytap.epona.ipc.remote.DispatcherProvider.call(java.lang.String, java.lang.String, android.os.Bundle):android.os.Bundle");
    }

    public final Bundle d() {
        Bundle bundle = new Bundle();
        bundle.putString("REMOTE_SNAPSHOT", b.c().f());
        return bundle;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (!b()) {
            a.c("DispatcherProvider", "<QUERY> Calling package : [" + getCallingPackage() + "] have no permission : com.oppo.permission.safe.SECURITY", new Object[0]);
            return null;
        }
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments != null && pathSegments.size() > 0) {
            if ("find_transfer".equals(pathSegments.get(0))) {
                Bundle bundle = new Bundle();
                if (pathSegments.size() > 1) {
                    bundle.putBinder("com.heytap.epona.Dispatcher.TRANSFER_VALUE", b.c().b(pathSegments.get(1)));
                    return D5.a.a(bundle);
                }
                a.c("DispatcherProvider", "Get ComponentName error : " + uri, new Object[0]);
                return null;
            }
            a.c("DispatcherProvider", "The path is not /find_transfer : " + pathSegments.get(0), new Object[0]);
        } else {
            a.c("DispatcherProvider", "Could not find the uri : " + uri, new Object[0]);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
