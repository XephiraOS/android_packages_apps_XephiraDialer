package com.juphoon.rcs.tool;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import com.juphoon.rcs.tool.RcsServiceManager;
import com.juphoon.service.rcs.IRcsCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class RcsGroupChatManager {

    /* renamed from: b, reason: collision with root package name */
    public static Context f25507b;

    /* renamed from: a, reason: collision with root package name */
    public static RcsServiceManager.b f25506a = new RcsServiceManager.b() { // from class: com.juphoon.rcs.tool.RcsGroupChatManager.1
        @Override // com.juphoon.rcs.tool.RcsServiceManager.b
        public void b(boolean z10, String str) {
            super.b(z10, str);
            if (TextUtils.equals("rcs", str) && z10) {
                try {
                    RcsServiceManager.y().m0(new IRcsCallback.Stub() { // from class: com.juphoon.rcs.tool.RcsGroupChatManager.1.1

                        /* renamed from: com.juphoon.rcs.tool.RcsGroupChatManager$1$1$a */
                        /* loaded from: classes3.dex */
                        public class a implements Runnable {

                            /* renamed from: a, reason: collision with root package name */
                            public final /* synthetic */ String f25511a;

                            public a(String str) {
                                this.f25511a = str;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                RcsGroupChatManager.c(this.f25511a);
                            }
                        }

                        @Override // com.juphoon.service.rcs.IRcsCallback
                        public void m1(String str2, String str3) {
                            if (TextUtils.equals("rcs_action_im_notify", str2)) {
                                new Handler(RcsGroupChatManager.f25507b.getMainLooper()).post(new a(str3));
                            }
                        }
                    });
                } catch (RemoteException e10) {
                    e10.printStackTrace();
                }
            }
        }

        @Override // com.juphoon.rcs.tool.RcsServiceManager.b
        public void c(boolean z10) {
            if (!z10) {
                RcsGroupChatManager.f();
            }
        }
    };

    /* renamed from: c, reason: collision with root package name */
    public static List<String> f25508c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public static List<a> f25509d = new ArrayList();

    public static void c(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("rcs_json_action");
            if (optString.equals("rcs_json_action_groupchat_accepted")) {
                String optString2 = jSONObject.optString("group_chat_id");
                e(optString2);
                g(optString2, true);
            } else {
                if (!optString.equals("rcs_json_action_groupchat_rejected") && !optString.equals("rcs_json_action_groupchat_released") && !optString.equals("rcs_json_action_groupchat_canceled")) {
                    if (optString.equals("rcs_json_action_groupchat_partp_update")) {
                        k(jSONObject.optString("group_chat_id"));
                    } else if (optString.equals("rcs_json_action_groupchat_leave_ok")) {
                        j(jSONObject.optString("group_chat_id"));
                    } else if (optString.equals("rcs_json_action_groupchat_dissolve_ok")) {
                        i(jSONObject.optString("group_chat_id"));
                    }
                }
                String optString3 = jSONObject.optString("group_chat_id");
                h(optString3);
                g(optString3, false);
            }
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
    }

    public static void d(Context context) {
        if (f25507b == null) {
            f25507b = context.getApplicationContext();
            RcsServiceManager.q(f25506a);
        }
    }

    public static void e(String str) {
        Iterator<a> it = f25509d.iterator();
        while (it.hasNext()) {
            it.next().a(str);
        }
    }

    public static void f() {
        for (String str : f25508c) {
            Iterator<a> it = f25509d.iterator();
            while (it.hasNext()) {
                it.next().f(str, false);
            }
        }
        f25508c.clear();
    }

    public static void g(String str, boolean z10) {
        if (f25508c.contains(str)) {
            Iterator<a> it = f25509d.iterator();
            while (it.hasNext()) {
                it.next().f(str, z10);
            }
            f25508c.remove(str);
        }
    }

    public static void h(String str) {
        Iterator<a> it = f25509d.iterator();
        while (it.hasNext()) {
            it.next().b(str);
        }
    }

    public static void i(String str) {
        Iterator<a> it = f25509d.iterator();
        while (it.hasNext()) {
            it.next().c(str);
        }
    }

    public static void j(String str) {
        Iterator<a> it = f25509d.iterator();
        while (it.hasNext()) {
            it.next().d(str);
        }
    }

    public static void k(String str) {
        Iterator<a> it = f25509d.iterator();
        while (it.hasNext()) {
            it.next().e(str);
        }
    }

    /* loaded from: classes3.dex */
    public static class a {
        public void a(String str) {
        }

        public void b(String str) {
        }

        public void c(String str) {
        }

        public void d(String str) {
        }

        public void e(String str) {
        }

        public void f(String str, boolean z10) {
        }
    }
}
