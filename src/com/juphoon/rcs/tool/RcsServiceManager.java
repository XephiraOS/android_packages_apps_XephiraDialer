package com.juphoon.rcs.tool;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.juphoon.service.cap.IRcsCapService;
import com.juphoon.service.im.IRcsImService;
import com.juphoon.service.rcs.IRcsCallback;
import com.juphoon.service.rcs.IRcsService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class RcsServiceManager {

    /* renamed from: A, reason: collision with root package name */
    public static int f25521A = 0;

    /* renamed from: B, reason: collision with root package name */
    public static int f25522B = 0;

    /* renamed from: C, reason: collision with root package name */
    public static long f25523C = 0;

    /* renamed from: D, reason: collision with root package name */
    public static long f25524D = 0;

    /* renamed from: E, reason: collision with root package name */
    public static int f25525E = 0;

    /* renamed from: F, reason: collision with root package name */
    public static boolean f25526F = false;

    /* renamed from: G, reason: collision with root package name */
    public static int f25527G = 0;

    /* renamed from: H, reason: collision with root package name */
    public static int f25528H = 0;

    /* renamed from: I, reason: collision with root package name */
    public static int f25529I = 0;

    /* renamed from: J, reason: collision with root package name */
    public static int f25530J = 0;

    /* renamed from: K, reason: collision with root package name */
    public static int f25531K = 0;

    /* renamed from: L, reason: collision with root package name */
    public static int f25532L = 0;

    /* renamed from: M, reason: collision with root package name */
    public static int f25533M = 0;

    /* renamed from: N, reason: collision with root package name */
    public static int f25534N = 0;

    /* renamed from: O, reason: collision with root package name */
    public static boolean f25535O = false;

    /* renamed from: Q, reason: collision with root package name */
    public static boolean f25537Q = false;

    /* renamed from: R, reason: collision with root package name */
    public static int f25538R = 0;

    /* renamed from: a, reason: collision with root package name */
    public static String f25539a = "com.juphoon.service";

    /* renamed from: c, reason: collision with root package name */
    public static IRcsService f25541c = null;

    /* renamed from: d, reason: collision with root package name */
    public static IRcsImService f25542d = null;

    /* renamed from: e, reason: collision with root package name */
    public static IRcsCapService f25543e = null;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f25544f = false;

    /* renamed from: g, reason: collision with root package name */
    public static String f25545g = null;

    /* renamed from: h, reason: collision with root package name */
    public static String f25546h = null;

    /* renamed from: i, reason: collision with root package name */
    public static Context f25547i = null;

    /* renamed from: j, reason: collision with root package name */
    public static int f25548j = 0;

    /* renamed from: k, reason: collision with root package name */
    public static int f25549k = 0;

    /* renamed from: l, reason: collision with root package name */
    public static int f25550l = 0;

    /* renamed from: m, reason: collision with root package name */
    public static boolean f25551m = false;

    /* renamed from: p, reason: collision with root package name */
    public static String f25554p;

    /* renamed from: t, reason: collision with root package name */
    public static boolean f25558t;

    /* renamed from: u, reason: collision with root package name */
    public static int f25559u;

    /* renamed from: v, reason: collision with root package name */
    public static int f25560v;

    /* renamed from: w, reason: collision with root package name */
    public static int f25561w;

    /* renamed from: x, reason: collision with root package name */
    public static int f25562x;

    /* renamed from: y, reason: collision with root package name */
    public static boolean f25563y;

    /* renamed from: z, reason: collision with root package name */
    public static boolean f25564z;

    /* renamed from: b, reason: collision with root package name */
    public static Object f25540b = new Object();

    /* renamed from: n, reason: collision with root package name */
    public static List<b> f25552n = new ArrayList();

    /* renamed from: o, reason: collision with root package name */
    public static final ServiceConnection f25553o = new ServiceConnection() { // from class: com.juphoon.rcs.tool.RcsServiceManager.3
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            String str = "";
            String className = componentName.getClassName();
            synchronized (RcsServiceManager.f25540b) {
                if (className.equals("com.juphoon.service.rcs.RcsService")) {
                    str = "rcs";
                    IRcsService unused = RcsServiceManager.f25541c = IRcsService.Stub.N7(iBinder);
                    RcsServiceManager.H();
                    RcsServiceManager.J();
                    try {
                        RcsServiceManager.f25541c.m0(new IRcsCallback.Stub() { // from class: com.juphoon.rcs.tool.RcsServiceManager.3.1

                            /* renamed from: com.juphoon.rcs.tool.RcsServiceManager$3$1$a */
                            /* loaded from: classes3.dex */
                            public class a implements Runnable {

                                /* renamed from: a, reason: collision with root package name */
                                public final /* synthetic */ String f25566a;

                                /* renamed from: b, reason: collision with root package name */
                                public final /* synthetic */ String f25567b;

                                public a(String str, String str2) {
                                    this.f25566a = str;
                                    this.f25567b = str2;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    if (TextUtils.equals("rcs_action_cli_notify", this.f25566a)) {
                                        try {
                                            JSONObject jSONObject = new JSONObject(this.f25567b);
                                            String optString = jSONObject.optString("rcs_json_action");
                                            if (optString.equals("rcs_json_action_cli_serv_login_ok")) {
                                                RcsServiceManager.H();
                                            } else if (optString.equals("rcs_json_action_cli_serv_login_failed")) {
                                                RcsServiceManager.H();
                                            } else if (optString.equals("rcs_json_action_cli_cmcc_token")) {
                                                RcsServiceManager.F(jSONObject.optString("cookie"), jSONObject.optBoolean("result"), jSONObject.optString("token"));
                                            } else if (optString.equals("rcs_json_action_cli_use_rcs")) {
                                                RcsServiceManager.J();
                                            } else if (optString.equals("rcs_json_action_cli_serv_logout")) {
                                                RcsServiceManager.I();
                                            }
                                        } catch (JSONException e10) {
                                            e10.printStackTrace();
                                        }
                                    }
                                }
                            }

                            @Override // com.juphoon.service.rcs.IRcsCallback
                            public void m1(String str2, String str3) {
                                new Handler(RcsServiceManager.f25547i.getMainLooper()).post(new a(str2, str3));
                            }
                        });
                    } catch (RemoteException e10) {
                        e10.printStackTrace();
                    }
                } else if (className.equals("com.juphoon.service.im.RcsImService")) {
                    str = "im";
                    IRcsImService unused2 = RcsServiceManager.f25542d = IRcsImService.Stub.N7(iBinder);
                } else if (className.equals("com.juphoon.service.cap.RcsCapService")) {
                    str = "cap";
                    IRcsCapService unused3 = RcsServiceManager.f25543e = IRcsCapService.Stub.N7(iBinder);
                }
            }
            Log.d("RcsServiceManager", className + " onServiceConnected");
            RcsServiceManager.G(true, str);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            String str = "";
            String className = componentName.getClassName();
            synchronized (RcsServiceManager.f25540b) {
                try {
                    if (className.equals("com.juphoon.service.rcs.RcsService")) {
                        str = "rcs";
                        IRcsService unused = RcsServiceManager.f25541c = null;
                        boolean unused2 = RcsServiceManager.f25544f = false;
                        RcsServiceManager.H();
                    } else if (className.equals("com.juphoon.service.im.RcsImService")) {
                        str = "im";
                        IRcsImService unused3 = RcsServiceManager.f25542d = null;
                        RcsGroupChatManager.f();
                    } else if (className.equals("com.juphoon.service.cap.RcsCapService")) {
                        str = "cap";
                        IRcsCapService unused4 = RcsServiceManager.f25543e = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            Log.d("RcsServiceManager", className + " onServiceDisconnected");
            RcsServiceManager.G(false, str);
            RcsServiceManager.r();
        }
    };

    /* renamed from: q, reason: collision with root package name */
    public static int f25555q = 2592000;

    /* renamed from: r, reason: collision with root package name */
    public static int f25556r = 2592000;

    /* renamed from: s, reason: collision with root package name */
    public static boolean f25557s = true;

    /* renamed from: P, reason: collision with root package name */
    public static int f25536P = 65535;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f25569a;

        public a(b bVar) {
            this.f25569a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!RcsServiceManager.f25552n.contains(this.f25569a)) {
                Log.d("RcsServiceManager", "addCallBack");
                RcsServiceManager.f25552n.add(this.f25569a);
                if (RcsServiceManager.f25544f) {
                    this.f25569a.c(true);
                }
                this.f25569a.e(RcsServiceManager.f25551m);
                if (RcsServiceManager.E("rcs")) {
                    this.f25569a.b(true, "rcs");
                }
                if (RcsServiceManager.E("im")) {
                    this.f25569a.b(true, "im");
                }
                if (RcsServiceManager.E("cprof")) {
                    this.f25569a.b(true, "cprof");
                }
                if (RcsServiceManager.E("pa")) {
                    this.f25569a.b(true, "pa");
                }
                if (RcsServiceManager.E("cap")) {
                    this.f25569a.b(true, "cap");
                }
            }
        }
    }

    public static String A() {
        return f25554p;
    }

    public static String B() {
        String str = f25545g;
        if (str == null) {
            return "";
        }
        return str;
    }

    public static void C(Context context, String str) {
        Log.d("RcsServiceManager", "init");
        if (f25547i == null) {
            f25547i = context.getApplicationContext();
            f25539a = str;
            r();
        }
    }

    public static boolean D() {
        return f25544f;
    }

    public static boolean E(String str) {
        synchronized (f25540b) {
            try {
                boolean z10 = true;
                if (TextUtils.equals(str, "rcs")) {
                    if (f25541c == null) {
                        z10 = false;
                    }
                    return z10;
                }
                if (TextUtils.equals(str, "im")) {
                    if (f25542d == null) {
                        z10 = false;
                    }
                    return z10;
                }
                if (!TextUtils.equals(str, "cap")) {
                    return false;
                }
                if (f25543e == null) {
                    z10 = false;
                }
                return z10;
            } finally {
            }
        }
    }

    public static void F(String str, boolean z10, String str2) {
        Iterator<b> it = f25552n.iterator();
        while (it.hasNext()) {
            it.next().a(str, z10, str2);
        }
    }

    public static void G(boolean z10, String str) {
        Iterator<b> it = f25552n.iterator();
        while (it.hasNext()) {
            it.next().b(z10, str);
        }
    }

    public static void H() {
        boolean i10 = com.juphoon.rcs.tool.a.i();
        f25544f = i10;
        if (i10) {
            t();
        }
        Iterator<b> it = f25552n.iterator();
        while (it.hasNext()) {
            it.next().c(f25544f);
        }
    }

    public static void I() {
        f25544f = com.juphoon.rcs.tool.a.i();
        Iterator<b> it = f25552n.iterator();
        while (it.hasNext()) {
            it.next().d();
        }
    }

    public static void J() {
        f25551m = com.juphoon.rcs.tool.a.g();
        Iterator<b> it = f25552n.iterator();
        while (it.hasNext()) {
            it.next().e(f25551m);
        }
    }

    public static void q(b bVar) {
        new Handler(f25547i.getMainLooper()).post(new a(bVar));
    }

    public static void r() {
        Log.d("RcsServiceManager", "connectService");
        synchronized (f25540b) {
            try {
                if (f25541c == null) {
                    Intent intent = new Intent("com.juphoon.service.rcsservice.action");
                    intent.setComponent(new ComponentName(f25539a, "com.juphoon.service.rcs.RcsService"));
                    f25547i.bindService(intent, f25553o, 1);
                }
                if (f25542d == null) {
                    Intent intent2 = new Intent("com.juphoon.service.imservice.action");
                    intent2.setComponent(new ComponentName(f25539a, "com.juphoon.service.im.RcsImService"));
                    f25547i.bindService(intent2, f25553o, 1);
                }
                if (f25543e == null) {
                    Intent intent3 = new Intent("com.juphoon.service.capservice.action");
                    intent3.setComponent(new ComponentName(f25539a, "com.juphoon.service.cap.RcsCapService"));
                    f25547i.bindService(intent3, f25553o, 1);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static int s() {
        return f25532L;
    }

    public static void t() {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        f25545g = com.juphoon.rcs.tool.a.h();
        f25546h = com.juphoon.rcs.tool.a.a();
        f25548j = com.juphoon.rcs.tool.a.c();
        f25549k = com.juphoon.rcs.tool.a.d();
        f25550l = com.juphoon.rcs.tool.a.f();
        f25554p = com.juphoon.rcs.tool.b.e(f25545g);
        f25555q = com.juphoon.rcs.tool.a.e("cap_expire_rcs");
        f25556r = com.juphoon.rcs.tool.a.e("cap_expire_non_rcs");
        boolean z16 = false;
        if (com.juphoon.rcs.tool.a.e("ui_seamless") > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        f25557s = z10;
        if (com.juphoon.rcs.tool.a.e("display_notification_switch") > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        f25558t = z11;
        f25559u = com.juphoon.rcs.tool.a.e("max_1_to_many_recipients");
        f25560v = com.juphoon.rcs.tool.a.e("one_to_many_selected_technology");
        f25561w = com.juphoon.rcs.tool.a.e("standalone_msg_auth");
        f25562x = com.juphoon.rcs.tool.a.e("chat_msg_auth");
        f25521A = com.juphoon.rcs.tool.a.e("messaging_fallback_default");
        f25522B = com.juphoon.rcs.tool.a.e("ft_fallback_default");
        f25523C = com.juphoon.rcs.tool.a.e("chat_revoke_timer");
        f25524D = com.juphoon.rcs.tool.a.e("reconnect_guard_timer");
        f25525E = com.juphoon.rcs.tool.a.e("cfs_trigger");
        if (com.juphoon.rcs.tool.a.e("composing_enable") > 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        f25526F = z12;
        f25527G = com.juphoon.rcs.tool.a.e("max_file_size_incoming");
        f25528H = com.juphoon.rcs.tool.a.e("warn_file_size");
        f25529I = com.juphoon.rcs.tool.a.e("ft_max_1_to_many_recipients");
        f25530J = com.juphoon.rcs.tool.a.e("ft_one_to_many_selected_technology");
        f25531K = com.juphoon.rcs.tool.a.e("file_transfer_method");
        f25532L = com.juphoon.rcs.tool.a.e("capability_discovery_mechanism");
        f25533M = com.juphoon.rcs.tool.a.e("service_mode");
        f25534N = com.juphoon.rcs.tool.a.e("ft_http_fallback");
        if (com.juphoon.rcs.tool.a.e("nfs_enable") > 0) {
            z13 = true;
        } else {
            z13 = false;
        }
        f25535O = z13;
        f25536P = com.juphoon.rcs.tool.a.e("message_limit_length");
        if (com.juphoon.rcs.tool.a.e("group_restart") > 0) {
            z14 = true;
        } else {
            z14 = false;
        }
        f25537Q = z14;
        f25538R = com.juphoon.rcs.tool.a.e("max_number_of_subscription_presence_list");
        if (com.juphoon.rcs.tool.a.e("file_auto_accept") > 0) {
            z15 = true;
        } else {
            z15 = false;
        }
        f25563y = z15;
        if (com.juphoon.rcs.tool.a.e("file_auto_accept_roaming") > 0) {
            z16 = true;
        }
        f25564z = z16;
    }

    public static int u() {
        return f25556r;
    }

    public static int v() {
        return f25555q;
    }

    public static IRcsCapService w() {
        IRcsCapService iRcsCapService;
        synchronized (f25540b) {
            iRcsCapService = f25543e;
        }
        return iRcsCapService;
    }

    public static IRcsImService x() {
        IRcsImService iRcsImService;
        synchronized (f25540b) {
            iRcsImService = f25542d;
        }
        return iRcsImService;
    }

    public static IRcsService y() {
        IRcsService iRcsService;
        synchronized (f25540b) {
            iRcsService = f25541c;
        }
        return iRcsService;
    }

    public static Object z() {
        return f25540b;
    }

    /* loaded from: classes3.dex */
    public static class b {
        public void d() {
        }

        public void c(boolean z10) {
        }

        public void e(boolean z10) {
        }

        public void b(boolean z10, String str) {
        }

        public void a(String str, boolean z10, String str2) {
        }
    }
}
