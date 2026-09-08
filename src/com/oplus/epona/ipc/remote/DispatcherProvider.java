package com.oplus.epona.ipc.remote;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.text.TextUtils;
import com.oplus.epona.d;
import com.oplus.utils.C0864z;
import g7.C1050a;
import i7.b;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

/* loaded from: classes3.dex */
public class DispatcherProvider extends ContentProvider {
    public final Bundle a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            bundle2.putBinder("com.oplus.epona.Dispatcher.TRANSFER_VALUE", b.e().d(bundle.getString("com.oplus.epona.Dispatcher.TRANSFER_KEY")));
        }
        return bundle2;
    }

    public final boolean b() {
        if (getContext().checkCallingPermission("com.oplus.permission.safe.SECURITY") == 0) {
            return true;
        }
        return false;
    }

    public final Bundle c(Bundle bundle, String str) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            bundle2.putBoolean("REGISTER_TRANSFER_RESULT", b.e().i(bundle.getString("com.oplus.epona.Dispatcher.TRANSFER_KEY"), bundle.getBinder("com.oplus.epona.Dispatcher.TRANSFER_VALUE"), str));
        }
        return bundle2;
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        if (!b()) {
            C0864z.d("Epona->DispatcherProvider", "<CALL> Calling package : [" + getCallingPackage() + "] have no permission : com.oplus.permission.safe.SECURITY", new Object[0]);
            return null;
        }
        if (TextUtils.equals(str, "com.oplus.epona.Dispatcher.FIND_TRANSFER")) {
            return a(bundle);
        }
        if (TextUtils.equals(str, "com.oplus.epona.Dispatcher.REGISTER_TRANSFER")) {
            return c(bundle, getCallingPackage());
        }
        if (TextUtils.equals(str, "com.oplus.epona.Dispatcher.UNREGISTER_TRANSFER")) {
            return d(bundle, getCallingPackage());
        }
        return super.call(str, str2, bundle);
    }

    public final Bundle d(Bundle bundle, String str) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            bundle2.putBoolean("REGISTER_TRANSFER_RESULT", b.e().l(bundle.getString("com.oplus.epona.Dispatcher.TRANSFER_KEY"), str));
        }
        return bundle2;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (strArr != null && strArr.length > 0) {
            com.oplus.epona.b h10 = d.h(strArr[0]);
            if (h10 != null) {
                h10.a(fileDescriptor, printWriter, strArr);
                return;
            }
            return;
        }
        super.dump(fileDescriptor, printWriter, strArr);
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
    public Cursor query(Uri uri, String[] strArr, Bundle bundle, CancellationSignal cancellationSignal) {
        if (!b()) {
            C0864z.d("Epona->DispatcherProvider", "<QUERY> Calling package : [" + getCallingPackage() + "] have no permission : com.oplus.permission.safe.SECURITY", new Object[0]);
            return null;
        }
        if (bundle != null) {
            Bundle bundle2 = new Bundle();
            String string = bundle.getString("com.oplus.epona.Dispatcher.QUERY_METHOD");
            Bundle bundle3 = bundle.getBundle("com.oplus.epona.Dispatcher.QUERY_EXTRA");
            if (string != null) {
                if (string.equals("com.oplus.epona.Dispatcher.REGISTER_TRANSFER")) {
                    bundle2 = c(bundle3, getCallingPackage());
                } else if (string.equals("com.oplus.epona.Dispatcher.UNREGISTER_TRANSFER")) {
                    bundle2 = d(bundle3, getCallingPackage());
                }
                return C1050a.a(bundle2);
            }
        }
        return super.query(uri, strArr, bundle, cancellationSignal);
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (!b()) {
            C0864z.d("Epona->DispatcherProvider", "<QUERY> Calling package : [" + getCallingPackage() + "] have no permission : com.oplus.permission.safe.SECURITY", new Object[0]);
            return null;
        }
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments != null && pathSegments.size() > 0) {
            if ("find_transfer".equals(pathSegments.get(0))) {
                Bundle bundle = new Bundle();
                if (pathSegments.size() > 1) {
                    bundle.putBinder("com.oplus.epona.Dispatcher.TRANSFER_VALUE", b.e().d(pathSegments.get(1)));
                    return C1050a.a(bundle);
                }
                C0864z.d("Epona->DispatcherProvider", "Get ComponentName error : " + uri, new Object[0]);
                return null;
            }
            C0864z.d("Epona->DispatcherProvider", "The path is not /find_transfer : " + pathSegments.get(0), new Object[0]);
        } else {
            C0864z.d("Epona->DispatcherProvider", "Could not find the uri : " + uri, new Object[0]);
        }
        return null;
    }
}
