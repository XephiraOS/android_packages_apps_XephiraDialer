package j8;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.provider.BaseColumns;
import android.provider.Settings;
import android.util.Log;
import java.util.concurrent.ConcurrentHashMap;
import k8.C1218a;

/* compiled from: AppSettings.java */
/* renamed from: j8.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1188a implements BaseColumns {

    /* renamed from: a, reason: collision with root package name */
    public static final String f33957a = (String) b();

    /* renamed from: b, reason: collision with root package name */
    public static final Uri f33958b = Settings.System.getUriFor("video_call");

    /* renamed from: c, reason: collision with root package name */
    public static final Uri f33959c = Settings.System.getUriFor("sip_call");

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f33960d = {"user_preferred_sub1", "user_preferred_sub2"};

    /* renamed from: e, reason: collision with root package name */
    public static final Uri f33961e = Settings.System.getUriFor("mms_notification");

    /* renamed from: f, reason: collision with root package name */
    public static final Uri f33962f = Settings.System.getUriFor("ringtone_sim2");

    /* renamed from: g, reason: collision with root package name */
    public static final Uri f33963g = Settings.System.getUriFor("notification_sim2");

    /* renamed from: h, reason: collision with root package name */
    public static final Uri f33964h = Settings.System.getUriFor("calendar_sound");

    /* renamed from: i, reason: collision with root package name */
    public static final String[] f33965i = {"user_preferred_sub1", "user_preferred_sub2", "user_preferred_sub3"};

    /* compiled from: AppSettings.java */
    /* renamed from: j8.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0320a {

        /* renamed from: b, reason: collision with root package name */
        public final Uri f33967b;

        /* renamed from: a, reason: collision with root package name */
        public final Object f33966a = new Object();

        /* renamed from: c, reason: collision with root package name */
        public final ConcurrentHashMap<Integer, ContentProviderClient> f33968c = new ConcurrentHashMap<>();

        public C0320a(Uri uri) {
            this.f33967b = uri;
        }

        public ContentProviderClient a(ContentResolver contentResolver, int i10) {
            if (i10 != -100 && i10 < 0) {
                Log.e("AppSettings", "Cannot support user id (below zero) : " + i10 + " . Please use @link [ActivityManager.getCurrentUser] instead.");
                return null;
            }
            synchronized (this.f33966a) {
                try {
                    ContentProviderClient contentProviderClient = this.f33968c.get(Integer.valueOf(i10));
                    if (contentProviderClient == null) {
                        contentProviderClient = contentResolver.acquireUnstableContentProviderClient(b(i10).getAuthority());
                        if (contentProviderClient == null) {
                            Log.e("AppSettings", "getProviderForUser contentProvider == null,uid:" + i10 + " ,uri: " + b(i10).getAuthority());
                            return null;
                        }
                        this.f33968c.put(Integer.valueOf(i10), contentProviderClient);
                    }
                    return contentProviderClient;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final Uri b(int i10) {
            if (i10 == -100) {
                return this.f33967b;
            }
            Uri.Builder buildUpon = this.f33967b.buildUpon();
            buildUpon.encodedAuthority("" + i10 + "@" + this.f33967b.getEncodedAuthority());
            return buildUpon.build();
        }

        public ContentProviderClient c(ContentResolver contentResolver, int i10) {
            synchronized (this.f33966a) {
                try {
                    if (this.f33968c.containsKey(Integer.valueOf(i10))) {
                        this.f33968c.remove(Integer.valueOf(i10));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return a(contentResolver, i10);
        }
    }

    /* compiled from: AppSettings.java */
    /* renamed from: j8.a$b */
    /* loaded from: classes3.dex */
    public static final class b extends d {

        /* renamed from: a, reason: collision with root package name */
        public static final String f33969a;

        /* renamed from: b, reason: collision with root package name */
        public static final Uri f33970b;

        /* renamed from: c, reason: collision with root package name */
        public static final C0320a f33971c;

        /* renamed from: d, reason: collision with root package name */
        public static final c f33972d;

        static {
            String str = "content://" + C1188a.f33957a + "/global";
            f33969a = str;
            Uri parse = Uri.parse(str);
            f33970b = parse;
            C0320a c0320a = new C0320a(parse);
            f33971c = c0320a;
            f33972d = new c(parse, "GET_global", "PUT_global", c0320a);
        }

        public static float b(ContentResolver contentResolver, String str, float f10) {
            String f11 = f(contentResolver, str);
            if (f11 != null) {
                try {
                    return Float.parseFloat(f11);
                } catch (NumberFormatException e10) {
                    Log.e("AppSettings", "Global getFloat has Exception: " + e10.getMessage());
                    return f10;
                }
            }
            return f10;
        }

        public static int c(ContentResolver contentResolver, String str) {
            try {
                return Integer.parseInt(f(contentResolver, str));
            } catch (NumberFormatException unused) {
                throw new Settings.SettingNotFoundException(str);
            }
        }

        public static int d(ContentResolver contentResolver, String str, int i10) {
            String f10 = f(contentResolver, str);
            if (f10 != null) {
                try {
                    return Integer.parseInt(f10);
                } catch (NumberFormatException e10) {
                    Log.e("AppSettings", "Global getInt has Exception: " + e10.getMessage());
                    return i10;
                }
            }
            return i10;
        }

        public static long e(ContentResolver contentResolver, String str, long j10) {
            String f10 = f(contentResolver, str);
            if (f10 != null) {
                try {
                    return Long.parseLong(f10);
                } catch (NumberFormatException e10) {
                    Log.e("AppSettings", "Global getLong has Exception: " + e10.getMessage());
                    return j10;
                }
            }
            return j10;
        }

        public static String f(ContentResolver contentResolver, String str) {
            return g(contentResolver, str, -100);
        }

        public static String g(ContentResolver contentResolver, String str, int i10) {
            return f33972d.a(contentResolver, str, i10);
        }

        public static Uri h(String str) {
            return d.a(f33970b, str);
        }

        public static boolean i(ContentResolver contentResolver, String str, int i10) {
            return k(contentResolver, str, Integer.toString(i10));
        }

        public static boolean j(ContentResolver contentResolver, String str, long j10) {
            return k(contentResolver, str, Long.toString(j10));
        }

        public static boolean k(ContentResolver contentResolver, String str, String str2) {
            return f33972d.b(contentResolver, str, str2, null, false, -100);
        }
    }

    /* compiled from: AppSettings.java */
    /* renamed from: j8.a$c */
    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: e, reason: collision with root package name */
        public static final String[] f33973e = {"value"};

        /* renamed from: a, reason: collision with root package name */
        public final Uri f33974a;

        /* renamed from: b, reason: collision with root package name */
        public final C0320a f33975b;

        /* renamed from: c, reason: collision with root package name */
        public final String f33976c;

        /* renamed from: d, reason: collision with root package name */
        public final String f33977d;

        public c(Uri uri, String str, String str2, C0320a c0320a) {
            this.f33974a = uri;
            this.f33976c = str;
            this.f33977d = str2;
            this.f33975b = c0320a;
        }

        public String a(ContentResolver contentResolver, String str, int i10) {
            int i11;
            Cursor query;
            String str2;
            String str3;
            ContentProviderClient a10 = this.f33975b.a(contentResolver, i10);
            try {
                if (a10 == null) {
                    Log.w("AppSettings", "Can't get provider for " + this.f33974a + " ,due to ContentProviderClient == null");
                    if (a10 != null) {
                        a10.close();
                    }
                    return null;
                }
                try {
                    i11 = 0;
                    try {
                        query = a10.query(this.f33974a, f33973e, "name=?", new String[]{str}, null);
                        try {
                            if (query == null) {
                                Log.w("AppSettings", "Can't get key " + str + " from " + this.f33974a + " ,due to cursor is null");
                                if (query != null) {
                                    query.close();
                                }
                                a10.close();
                                return null;
                            }
                            if (query.moveToNext()) {
                                str3 = query.getString(0);
                            } else {
                                str3 = null;
                            }
                            query.close();
                            a10.close();
                            return str3;
                        } finally {
                        }
                    } catch (RemoteException unused) {
                        Log.w("AppSettings", "query RemoteException Can't get key " + str + " from " + this.f33974a);
                        try {
                            int i12 = i11;
                            ContentProviderClient c10 = this.f33975b.c(contentResolver, i10);
                            if (c10 == null) {
                                Log.w("AppSettings", "retry reacquireProviderForUser failed");
                                if (c10 != null) {
                                    c10.close();
                                }
                                return null;
                            }
                            query = c10.query(this.f33974a, f33973e, "name=?", new String[]{str}, null);
                            try {
                                if (query == null) {
                                    Log.w("AppSettings", "Can't get key " + str + " from " + this.f33974a + " ,due to cursor is null");
                                    if (query != null) {
                                        query.close();
                                    }
                                    c10.close();
                                    return null;
                                }
                                if (query.moveToNext()) {
                                    str2 = query.getString(i12);
                                } else {
                                    str2 = null;
                                }
                                query.close();
                                c10.close();
                                return str2;
                            } finally {
                            }
                        } catch (RemoteException unused2) {
                            if (this.f33976c != null) {
                                try {
                                    Bundle call = a10.call(this.f33976c, str, new Bundle());
                                    if (call != null) {
                                        String string = call.getString("value");
                                        a10.close();
                                        return string;
                                    }
                                } catch (RemoteException e10) {
                                    Log.e("AppSettings", "call RemoteException Can't get key " + str + " from " + this.f33974a, e10);
                                }
                            }
                            if (a10 != null) {
                                a10.close();
                            }
                            return null;
                        }
                    }
                } catch (RemoteException unused3) {
                    i11 = 0;
                }
            } catch (Throwable th) {
                if (a10 != null) {
                    a10.close();
                }
                throw th;
            }
        }

        public boolean b(ContentResolver contentResolver, String str, String str2, String str3, boolean z10, int i10) {
            ContentProviderClient a10 = this.f33975b.a(contentResolver, i10);
            if (a10 == null) {
                Log.w("AppSettings", "Can't get provider for " + this.f33974a + " ,due to ContentProviderClient == null");
                return false;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", str);
            contentValues.put("value", str2);
            try {
                a10.insert(this.f33974a, contentValues);
                return true;
            } catch (RemoteException unused) {
                Log.w("AppSettings", "insert Can't set key " + str + " in " + this.f33974a);
                try {
                    try {
                        ContentProviderClient c10 = this.f33975b.c(contentResolver, i10);
                        if (c10 == null) {
                            Log.w("AppSettings", "retry reacquireProviderForUser failed");
                            return false;
                        }
                        c10.insert(this.f33974a, contentValues);
                        return true;
                    } catch (RemoteException unused2) {
                        Bundle bundle = new Bundle();
                        bundle.putString("value", str2);
                        if (str3 != null) {
                            bundle.putString("_tag", str3);
                        }
                        if (z10) {
                            bundle.putBoolean("_make_default", true);
                        }
                        a10.call(this.f33977d, str, bundle);
                        return true;
                    }
                } catch (RemoteException unused3) {
                    Log.w("AppSettings", "RemoteException call Can't set key " + str + " in " + this.f33974a);
                    return false;
                }
            }
        }
    }

    /* compiled from: AppSettings.java */
    /* renamed from: j8.a$d */
    /* loaded from: classes3.dex */
    public static class d implements BaseColumns {
        public static Uri a(Uri uri, String str) {
            return Uri.withAppendedPath(uri, str);
        }
    }

    /* compiled from: AppSettings.java */
    /* renamed from: j8.a$e */
    /* loaded from: classes3.dex */
    public static final class e extends d {

        /* renamed from: a, reason: collision with root package name */
        public static final String f33978a;

        /* renamed from: b, reason: collision with root package name */
        public static final Uri f33979b;

        /* renamed from: c, reason: collision with root package name */
        public static final C0320a f33980c;

        /* renamed from: d, reason: collision with root package name */
        public static final c f33981d;

        static {
            String str = "content://" + C1188a.f33957a + "/secure";
            f33978a = str;
            Uri parse = Uri.parse(str);
            f33979b = parse;
            C0320a c0320a = new C0320a(parse);
            f33980c = c0320a;
            f33981d = new c(parse, "GET_secure", "PUT_secure", c0320a);
        }

        public static float b(ContentResolver contentResolver, String str, float f10) {
            String f11 = f(contentResolver, str);
            if (f11 != null) {
                try {
                    return Float.parseFloat(f11);
                } catch (NumberFormatException e10) {
                    Log.e("AppSettings", "Secure getFloat has Exception: " + e10.getMessage());
                    return f10;
                }
            }
            return f10;
        }

        public static int c(ContentResolver contentResolver, String str) {
            try {
                return Integer.parseInt(f(contentResolver, str));
            } catch (NumberFormatException unused) {
                throw new Settings.SettingNotFoundException(str);
            }
        }

        public static int d(ContentResolver contentResolver, String str, int i10) {
            String f10 = f(contentResolver, str);
            if (f10 != null) {
                try {
                    return Integer.parseInt(f10);
                } catch (NumberFormatException e10) {
                    Log.e("AppSettings", "Secure getInt has Exception: " + e10.getMessage());
                    return i10;
                }
            }
            return i10;
        }

        public static long e(ContentResolver contentResolver, String str, long j10) {
            String f10 = f(contentResolver, str);
            if (f10 != null) {
                try {
                    return Long.parseLong(f10);
                } catch (NumberFormatException e10) {
                    Log.e("AppSettings", "Secure getLong has Exception: " + e10.getMessage());
                    return j10;
                }
            }
            return j10;
        }

        public static String f(ContentResolver contentResolver, String str) {
            return g(contentResolver, str, -100);
        }

        public static String g(ContentResolver contentResolver, String str, int i10) {
            return f33981d.a(contentResolver, str, i10);
        }

        public static Uri h(String str) {
            return d.a(f33979b, str);
        }

        public static boolean i(ContentResolver contentResolver, String str, int i10) {
            return k(contentResolver, str, Integer.toString(i10));
        }

        public static boolean j(ContentResolver contentResolver, String str, long j10) {
            return k(contentResolver, str, Long.toString(j10));
        }

        public static boolean k(ContentResolver contentResolver, String str, String str2) {
            return f33981d.b(contentResolver, str, str2, null, false, -100);
        }
    }

    /* compiled from: AppSettings.java */
    /* renamed from: j8.a$f */
    /* loaded from: classes3.dex */
    public static final class f extends d {

        /* renamed from: a, reason: collision with root package name */
        public static final String f33982a;

        /* renamed from: b, reason: collision with root package name */
        public static final Uri f33983b;

        /* renamed from: c, reason: collision with root package name */
        public static final C0320a f33984c;

        /* renamed from: d, reason: collision with root package name */
        public static final c f33985d;

        static {
            String str = "content://" + C1188a.f33957a + "/system";
            f33982a = str;
            Uri parse = Uri.parse(str);
            f33983b = parse;
            C0320a c0320a = new C0320a(parse);
            f33984c = c0320a;
            f33985d = new c(parse, "GET_system", "PUT_system", c0320a);
        }

        public static float b(ContentResolver contentResolver, String str, float f10) {
            String f11 = f(contentResolver, str);
            if (f11 != null) {
                try {
                    return Float.parseFloat(f11);
                } catch (NumberFormatException e10) {
                    Log.e("AppSettings", "System getFloat has Exception: " + e10.getMessage());
                    return f10;
                }
            }
            return f10;
        }

        public static int c(ContentResolver contentResolver, String str) {
            try {
                return Integer.parseInt(f(contentResolver, str));
            } catch (NumberFormatException unused) {
                throw new Settings.SettingNotFoundException(str);
            }
        }

        public static int d(ContentResolver contentResolver, String str, int i10) {
            String f10 = f(contentResolver, str);
            if (f10 != null) {
                try {
                    return Integer.parseInt(f10);
                } catch (NumberFormatException e10) {
                    Log.e("AppSettings", "System getInt has Exception: " + e10.getMessage());
                    return i10;
                }
            }
            return i10;
        }

        public static long e(ContentResolver contentResolver, String str, long j10) {
            String f10 = f(contentResolver, str);
            if (f10 != null) {
                try {
                    return Long.parseLong(f10);
                } catch (NumberFormatException e10) {
                    Log.e("AppSettings", "System getLong has Exception: " + e10.toString());
                    return j10;
                }
            }
            return j10;
        }

        public static String f(ContentResolver contentResolver, String str) {
            return g(contentResolver, str, -100);
        }

        public static String g(ContentResolver contentResolver, String str, int i10) {
            return f33985d.a(contentResolver, str, i10);
        }

        public static Uri h(String str) {
            return d.a(f33983b, str);
        }

        public static boolean i(ContentResolver contentResolver, String str, int i10) {
            return k(contentResolver, str, Integer.toString(i10));
        }

        public static boolean j(ContentResolver contentResolver, String str, long j10) {
            return k(contentResolver, str, Long.toString(j10));
        }

        public static boolean k(ContentResolver contentResolver, String str, String str2) {
            return f33985d.b(contentResolver, str, str2, null, false, -100);
        }
    }

    public static Object b() {
        if (C1218a.f34160a) {
            return "com.oplus.appplatform.settings";
        }
        return j8.b.a();
    }
}
