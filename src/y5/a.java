package Y5;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.oplus.aiunit.core.data.ServiceType;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final C0086a f5542a = new C0086a(null);

    /* renamed from: Y5.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0086a {

        /* renamed from: Y5.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public /* synthetic */ class C0087a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f5543a;

            static {
                int[] iArr = new int[ServiceType.values().length];
                try {
                    iArr[ServiceType.f25584b.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ServiceType.f25585c.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f5543a = iArr;
            }
        }

        public C0086a() {
        }

        public static /* synthetic */ Bundle b(C0086a c0086a, Context context, ServiceType serviceType, String str, Bundle bundle, String str2, int i10, Object obj) {
            if ((i10 & 16) != 0) {
                str2 = "common_call";
            }
            return c0086a.a(context, serviceType, str, bundle, str2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r7v16, types: [long] */
        /* JADX WARN: Type inference failed for: r7v24 */
        /* JADX WARN: Type inference failed for: r7v25 */
        /* JADX WARN: Type inference failed for: r7v7, types: [java.lang.String] */
        public final Bundle a(Context context, ServiceType type, String str, Bundle extras, String method) {
            ContentProviderClient contentProviderClient;
            ContentProviderClient contentProviderClient2;
            long currentTimeMillis;
            StringBuilder sb;
            String str2;
            Bundle bundle;
            Integer num;
            i.f(context, "context");
            i.f(type, "type");
            i.f(extras, "extras");
            i.f(method, "method");
            int i10 = C0087a.f5543a[type.ordinal()];
            if (i10 != 1) {
                if (i10 != 2) {
                    return null;
                }
                contentProviderClient = "content://com.coloros.ocrservice.authority.open";
            } else {
                contentProviderClient = "content://com.oplus.aiunit.authority.open";
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            try {
                try {
                    Uri parse = Uri.parse(contentProviderClient);
                    i.e(parse, "parse(...)");
                    contentProviderClient2 = context.getContentResolver().acquireUnstableContentProviderClient(parse);
                } catch (Throwable th) {
                    if (contentProviderClient != 0) {
                        contentProviderClient.close();
                    }
                    Z5.a.c("ProviderClient", "call " + type + ' ' + extras + ". cost[" + (System.currentTimeMillis() - currentTimeMillis2) + ']');
                    throw th;
                }
            } catch (RemoteException e10) {
                e = e10;
                contentProviderClient2 = null;
            } catch (Throwable th2) {
                th = th2;
                contentProviderClient2 = null;
            }
            try {
                if (type == ServiceType.f25584b) {
                    str2 = "com.oplus.aiunit.authority.open";
                } else {
                    str2 = "com.coloros.ocrservice.authority.open";
                }
                if (contentProviderClient2 != null) {
                    bundle = contentProviderClient2.call(str2, method, str, extras);
                } else {
                    bundle = null;
                }
                StringBuilder sb2 = new StringBuilder("call: code = ");
                if (bundle != null) {
                    num = Integer.valueOf(bundle.getInt("package::error_code", 0));
                } else {
                    num = null;
                }
                sb2.append(num);
                sb2.append(", result = ");
                sb2.append(bundle);
                Z5.a.c("ProviderClient", sb2.toString());
                if (contentProviderClient2 != null) {
                    contentProviderClient2.close();
                }
                Z5.a.c("ProviderClient", "call " + type + ' ' + extras + ". cost[" + (System.currentTimeMillis() - currentTimeMillis2) + ']');
                return bundle;
            } catch (RemoteException e11) {
                e = e11;
                Z5.a.d("ProviderClient", "call " + extras + " remote failed. " + e.getMessage());
                if (contentProviderClient2 != null) {
                    contentProviderClient2.close();
                }
                currentTimeMillis = System.currentTimeMillis();
                sb = new StringBuilder("call ");
                sb.append(type);
                sb.append(' ');
                sb.append(extras);
                sb.append(". cost[");
                contentProviderClient = currentTimeMillis - currentTimeMillis2;
                sb.append((long) contentProviderClient);
                sb.append(']');
                Z5.a.c("ProviderClient", sb.toString());
                return null;
            } catch (Throwable th3) {
                th = th3;
                Z5.a.b("ProviderClient", "call " + extras + " failed. " + th.getMessage());
                if (contentProviderClient2 != null) {
                    contentProviderClient2.close();
                }
                currentTimeMillis = System.currentTimeMillis();
                sb = new StringBuilder("call ");
                sb.append(type);
                sb.append(' ');
                sb.append(extras);
                sb.append(". cost[");
                contentProviderClient = currentTimeMillis - currentTimeMillis2;
                sb.append((long) contentProviderClient);
                sb.append(']');
                Z5.a.c("ProviderClient", sb.toString());
                return null;
            }
        }

        public final boolean c(Context context, String detectName, ServiceType type) {
            String str;
            String str2;
            int i10;
            boolean z10;
            i.f(context, "context");
            i.f(detectName, "detectName");
            i.f(type, "type");
            ContentResolver contentResolver = context.getContentResolver();
            try {
                long currentTimeMillis = System.currentTimeMillis();
                if (type == ServiceType.f25584b) {
                    str = "content://com.oplus.aiunit.authority.open/query/unit";
                } else {
                    str = "content://com.coloros.ocrservice.authority.open/query/unit";
                }
                Cursor query = contentResolver.query(Uri.parse(str + '/' + detectName), null, null, null);
                if (query != null && query.getCount() > 0) {
                    query.moveToNext();
                    int columnIndex = query.getColumnIndex("unitName");
                    int columnIndex2 = query.getColumnIndex("unitId");
                    int columnIndex3 = query.getColumnIndex("enabled");
                    if (columnIndex >= 0) {
                        str2 = query.getString(columnIndex);
                    } else {
                        str2 = detectName;
                    }
                    if (columnIndex2 >= 0) {
                        i10 = query.getInt(columnIndex2);
                    } else {
                        i10 = 0;
                    }
                    if (columnIndex3 >= 0 && query.getInt(columnIndex3) > 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    query.close();
                    Z5.a.c("ProviderClient", "queryUnitSupported " + type + ' ' + detectName + ": [" + str2 + ", " + i10 + ", " + z10 + "]. cost " + (System.currentTimeMillis() - currentTimeMillis));
                    return z10;
                }
                Z5.a.a("ProviderClient", "queryUnitSupported false by cursor is empty!");
                return false;
            } catch (Exception e10) {
                Z5.a.b("ProviderClient", "queryUnitSupported " + type + ' ' + detectName + " err. " + e10.getMessage());
                return false;
            }
        }

        public /* synthetic */ C0086a(f fVar) {
            this();
        }
    }
}
