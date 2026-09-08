package v8;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import java.util.Map;
import y8.C1714f;
import y8.InterfaceC1715g;

/* compiled from: ContentProviderRecorder.java */
/* loaded from: classes3.dex */
public class f implements g {
    public static boolean g(Context context, String str, ContentValues contentValues) {
        Uri parse = Uri.parse(str);
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver == null) {
            C1714f.a("ContentProviderRecorder", new InterfaceC1715g() { // from class: v8.c
                @Override // y8.InterfaceC1715g
                public final Object get() {
                    String i10;
                    i10 = f.i();
                    return i10;
                }
            });
            return false;
        }
        ContentProviderClient contentProviderClient = null;
        try {
            try {
                ContentProviderClient acquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(parse);
                if (acquireUnstableContentProviderClient == null) {
                    C1714f.a("ContentProviderRecorder", new InterfaceC1715g() { // from class: v8.d
                        @Override // y8.InterfaceC1715g
                        public final Object get() {
                            String j10;
                            j10 = f.j();
                            return j10;
                        }
                    });
                    if (acquireUnstableContentProviderClient != null) {
                        acquireUnstableContentProviderClient.close();
                    }
                    return false;
                }
                acquireUnstableContentProviderClient.insert(parse, contentValues);
                acquireUnstableContentProviderClient.close();
                return true;
            } catch (Exception e10) {
                C1714f.b("ContentProviderRecorder", new InterfaceC1715g() { // from class: v8.e
                    @Override // y8.InterfaceC1715g
                    public final Object get() {
                        String k10;
                        k10 = f.k(e10);
                        return k10;
                    }
                });
                if (0 != 0) {
                    contentProviderClient.close();
                }
                return false;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                contentProviderClient.close();
            }
            throw th;
        }
    }

    public static boolean h(Context context) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("", "");
        boolean g10 = g(context, "content://com.oplus.statistics.provider/support", contentValues);
        if (!g10) {
            C1714f.f("ContentProviderRecorder", new InterfaceC1715g() { // from class: v8.b
                @Override // y8.InterfaceC1715g
                public final Object get() {
                    String l10;
                    l10 = f.l();
                    return l10;
                }
            });
        }
        return g10;
    }

    public static /* synthetic */ String i() {
        return "get resolver failed.";
    }

    public static /* synthetic */ String j() {
        return "get provider client failed.";
    }

    public static /* synthetic */ String k(Exception exc) {
        return "insert exception:" + exc;
    }

    public static /* synthetic */ String l() {
        return "not support content provider";
    }

    @Override // v8.g
    public void a(Context context, u8.f fVar) {
        g(context, "content://com.oplus.statistics.provider/track_event", f(fVar));
    }

    public final ContentValues f(u8.f fVar) {
        ContentValues contentValues = new ContentValues();
        for (Map.Entry<String, Object> entry : fVar.h().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                contentValues.put(key, (String) value);
            } else if (value instanceof Integer) {
                contentValues.put(key, (Integer) value);
            } else if (value instanceof Long) {
                contentValues.put(key, (Long) value);
            } else if (value instanceof Boolean) {
                contentValues.put(key, (Boolean) value);
            }
        }
        return contentValues;
    }
}
