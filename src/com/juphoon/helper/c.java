package com.juphoon.helper;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.heytap.accessory.constant.AFConstants;
import com.juphoon.helper.RcsBroadcastHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: RcsGroupHelper.java */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: d, reason: collision with root package name */
    public static Context f25485d;

    /* renamed from: a, reason: collision with root package name */
    public static final Map<String, e> f25482a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public static final Set<String> f25483b = new HashSet();

    /* renamed from: c, reason: collision with root package name */
    public static final ExecutorService f25484c = Executors.newSingleThreadExecutor();

    /* renamed from: e, reason: collision with root package name */
    public static List<d> f25486e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public static final String[] f25487f = {"group_chat_id", "session_identity", "name", "chairman", "nick_name", "state", "recv_type", "icon"};

    /* renamed from: g, reason: collision with root package name */
    public static final String[] f25488g = {"number", "name", "protrait", AFConstants.EXTRA_STATUS, "etype"};

    /* renamed from: h, reason: collision with root package name */
    public static final RcsBroadcastHelper.c f25489h = new b();

    /* compiled from: RcsGroupHelper.java */
    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f25490a;

        public a(String str) {
            this.f25490a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = c.f25486e.iterator();
            while (it.hasNext()) {
                ((d) it.next()).a(this.f25490a);
            }
        }
    }

    /* compiled from: RcsGroupHelper.java */
    /* renamed from: com.juphoon.helper.c$c, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC0231c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public String f25491a;

        public RunnableC0231c(String str) {
            this.f25491a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TextUtils.isEmpty(this.f25491a)) {
                c.h(true);
                c.j(null);
            } else {
                c.i(this.f25491a);
                c.j(this.f25491a);
            }
        }
    }

    /* compiled from: RcsGroupHelper.java */
    /* loaded from: classes3.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public String f25492a;

        /* renamed from: b, reason: collision with root package name */
        public String f25493b;

        /* renamed from: c, reason: collision with root package name */
        public String f25494c;

        /* renamed from: d, reason: collision with root package name */
        public String f25495d;

        /* renamed from: e, reason: collision with root package name */
        public String f25496e;

        /* renamed from: f, reason: collision with root package name */
        public String f25497f;

        /* renamed from: g, reason: collision with root package name */
        public int f25498g;

        /* renamed from: h, reason: collision with root package name */
        public int f25499h;

        /* renamed from: i, reason: collision with root package name */
        public List<f> f25500i;
    }

    /* compiled from: RcsGroupHelper.java */
    /* loaded from: classes3.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public String f25501a;

        /* renamed from: b, reason: collision with root package name */
        public String f25502b;

        /* renamed from: c, reason: collision with root package name */
        public String f25503c;

        /* renamed from: d, reason: collision with root package name */
        public int f25504d;

        /* renamed from: e, reason: collision with root package name */
        public int f25505e;
    }

    public static void f(Context context) {
        f25485d = context;
        RcsBroadcastHelper.b(f25489h);
        g();
        f25484c.execute(new RunnableC0231c(null));
    }

    public static void g() {
        Log.d("RcsGroupHelper", "loadAllGroupChatIds");
        HashSet hashSet = new HashSet();
        Cursor query = f25485d.getContentResolver().query(P5.c.f2960a, new String[]{"group_chat_id"}, null, null, null);
        if (query != null) {
            while (query.moveToNext()) {
                try {
                    hashSet.add(query.getString(0));
                } catch (Exception unused) {
                } catch (Throwable th) {
                    query.close();
                    throw th;
                }
            }
            query.close();
        }
        Set<String> set = f25483b;
        synchronized (set) {
            set.clear();
            set.addAll(hashSet);
        }
    }

    public static List<e> h(boolean z10) {
        String str;
        Log.d("RcsGroupHelper", "loadAllGroupInfos");
        ArrayList arrayList = new ArrayList();
        ContentResolver contentResolver = f25485d.getContentResolver();
        Uri uri = P5.c.f2960a;
        String[] strArr = f25487f;
        if (z10) {
            str = null;
        } else {
            str = "state=3";
        }
        Cursor query = contentResolver.query(uri, strArr, str, null, null);
        if (query != null) {
            try {
                query.moveToFirst();
                while (!query.isAfterLast()) {
                    e eVar = new e();
                    eVar.f25492a = query.getString(0);
                    eVar.f25493b = query.getString(1);
                    eVar.f25494c = query.getString(2);
                    eVar.f25495d = query.getString(3);
                    eVar.f25496e = query.getString(4);
                    eVar.f25498g = query.getInt(5);
                    eVar.f25499h = query.getInt(6);
                    eVar.f25497f = query.getString(7);
                    eVar.f25500i = new ArrayList();
                    Cursor query2 = f25485d.getContentResolver().query(P5.b.f2959a, f25488g, "group_chat_id=?", new String[]{eVar.f25492a}, null);
                    if (query2 != null) {
                        query2.moveToFirst();
                        while (!query2.isAfterLast()) {
                            f fVar = new f();
                            fVar.f25501a = query2.getString(0);
                            fVar.f25502b = query2.getString(1);
                            fVar.f25503c = query2.getString(2);
                            fVar.f25504d = query2.getInt(3);
                            fVar.f25505e = query2.getInt(4);
                            eVar.f25500i.add(fVar);
                            query2.moveToNext();
                        }
                        query2.close();
                    }
                    arrayList.add(eVar);
                    Map<String, e> map = f25482a;
                    synchronized (map) {
                        map.put(eVar.f25492a, eVar);
                    }
                    query.moveToNext();
                }
                query.close();
            } catch (Throwable th) {
                query.close();
                throw th;
            }
        }
        return arrayList;
    }

    public static e i(String str) {
        Log.d("RcsGroupHelper", "loadGroupInfo " + str);
        Cursor query = f25485d.getContentResolver().query(P5.c.f2960a, f25487f, "group_chat_id=?", new String[]{str}, null);
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    e eVar = new e();
                    eVar.f25492a = query.getString(0);
                    eVar.f25493b = query.getString(1);
                    eVar.f25494c = query.getString(2);
                    eVar.f25495d = query.getString(3);
                    eVar.f25496e = query.getString(4);
                    eVar.f25498g = query.getInt(5);
                    eVar.f25499h = query.getInt(6);
                    eVar.f25497f = query.getString(7);
                    eVar.f25500i = new ArrayList();
                    Cursor query2 = f25485d.getContentResolver().query(P5.b.f2959a, f25488g, "group_chat_id=?", new String[]{str}, null);
                    if (query2 != null) {
                        query2.moveToFirst();
                        while (!query2.isAfterLast()) {
                            f fVar = new f();
                            fVar.f25501a = query2.getString(0);
                            fVar.f25502b = query2.getString(1);
                            fVar.f25503c = query2.getString(2);
                            fVar.f25504d = query2.getInt(3);
                            fVar.f25505e = query2.getInt(4);
                            eVar.f25500i.add(fVar);
                            query2.moveToNext();
                        }
                        query2.close();
                    }
                    Map<String, e> map = f25482a;
                    synchronized (map) {
                        map.put(str, eVar);
                    }
                    query.close();
                    return eVar;
                }
                query.close();
                return null;
            } catch (Throwable th) {
                query.close();
                throw th;
            }
        }
        return null;
    }

    public static void j(String str) {
        new Handler(f25485d.getMainLooper()).post(new a(str));
    }

    /* compiled from: RcsGroupHelper.java */
    /* loaded from: classes3.dex */
    public static class b implements RcsBroadcastHelper.c {
        @Override // com.juphoon.helper.RcsBroadcastHelper.c
        public void a(String str) {
            if (TextUtils.isEmpty(str)) {
                c.g();
            } else {
                synchronized (c.f25483b) {
                    c.f25483b.add(str);
                }
            }
            c.f25484c.execute(new RunnableC0231c(str));
        }

        @Override // com.juphoon.helper.RcsBroadcastHelper.c
        public void c(String str) {
        }

        @Override // com.juphoon.helper.RcsBroadcastHelper.c
        public void b(String str, boolean z10) {
        }
    }

    /* compiled from: RcsGroupHelper.java */
    /* loaded from: classes3.dex */
    public static class d {
        public void a(String str) {
        }
    }
}
