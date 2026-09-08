package com.juphoon.helper;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import com.juphoon.rcs.tool.RcsServiceManager;
import com.juphoon.service.rcs.IRcsCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class RcsBroadcastHelper extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static Context f25457a;

    /* renamed from: b, reason: collision with root package name */
    public static Boolean f25458b;

    /* renamed from: c, reason: collision with root package name */
    public static Map<String, List<a>> f25459c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public static List<c> f25460d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public static List<a> f25461e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public static Map<String, b> f25462f = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    public static List<d> f25463g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    public static List<String> f25464h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    public static final RcsServiceManager.b f25465i = new RcsServiceManager.b() { // from class: com.juphoon.helper.RcsBroadcastHelper.1
        @Override // com.juphoon.rcs.tool.RcsServiceManager.b
        public void b(boolean z10, String str) {
            super.b(z10, str);
            if (TextUtils.equals("rcs", str) && z10) {
                try {
                    RcsServiceManager.y().m0(new IRcsCallback.Stub() { // from class: com.juphoon.helper.RcsBroadcastHelper.1.1

                        /* renamed from: com.juphoon.helper.RcsBroadcastHelper$1$1$a */
                        /* loaded from: classes3.dex */
                        public class a implements Runnable {

                            /* renamed from: a, reason: collision with root package name */
                            public final /* synthetic */ String f25467a;

                            /* renamed from: b, reason: collision with root package name */
                            public final /* synthetic */ String f25468b;

                            public a(String str, String str2) {
                                this.f25467a = str;
                                this.f25468b = str2;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                RcsBroadcastHelper.c(this.f25467a, this.f25468b);
                            }
                        }

                        @Override // com.juphoon.service.rcs.IRcsCallback
                        public void m1(String str2, String str3) {
                            new Handler(RcsBroadcastHelper.f25457a.getMainLooper()).post(new a(str2, str3));
                        }
                    });
                } catch (RemoteException e10) {
                    e10.printStackTrace();
                }
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void a(String str, boolean z10, String str2, boolean z11);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(boolean z10, String str);
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(String str);

        void b(String str, boolean z10);

        void c(String str);
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a(boolean z10, String str);

        void b(String str);

        void c(boolean z10, String str);

        void d(boolean z10, String str);

        void e(String str);
    }

    public static void b(c cVar) {
        synchronized (f25460d) {
            try {
                if (!f25460d.contains(cVar)) {
                    f25460d.add(cVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void c(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String optString = jSONObject.optString("rcs_json_action");
            if ("rcs_action_cli_notify".equals(str)) {
                if ("rcs_json_action_cli_serv_logout".equals(optString)) {
                    e();
                    return;
                } else {
                    if ("rcs_json_action_cli_card_change".equals(optString)) {
                        h(null);
                        return;
                    }
                    return;
                }
            }
            if ("rcs_action_im_notify".equals(str)) {
                if (!"rcs_json_action_cap_ok".equals(optString) && !"rcs_json_action_cap_update".equals(optString)) {
                    if ("rcs_json_action_cap_failed".equals(optString)) {
                        f(jSONObject.optString("phone"), false, false, jSONObject.optString("cap"), false, jSONObject.optLong("cap_update_time"));
                        return;
                    }
                    if (!"rcs_json_action_confs_sub_list".equals(optString) && !"rcs_json_action_confs_sub_info".equals(optString)) {
                        if (!"rcs_json_action_groupchat_accepted".equals(optString) && !"rcs_json_action_groupchat_partp_update".equals(optString) && !"rcs_json_action_groupchat_subject_chged".equals(optString) && !"rcs_json_action_groupchat_rejected".equals(optString) && !"rcs_json_action_groupchat_released".equals(optString) && !"rcs_json_action_groupchat_canceled".equals(optString) && !"rcs_json_action_groupchat_dissolve_ok".equals(optString) && !"rcs_json_action_groupchat_leave_ok".equals(optString)) {
                            if ("rcs_json_action_groupchat_recv_invite".equals(optString)) {
                                i(jSONObject.optString("group_chat_id", null));
                                return;
                            }
                            if ("rcs_json_action_im_msg_send_ok".equals(optString)) {
                                o(true, jSONObject.optString("imdn_id"));
                                return;
                            }
                            if ("rcs_json_action_im_msg_send_failed".equals(optString)) {
                                o(false, jSONObject.optString("imdn_id"));
                                return;
                            }
                            if (!"rcs_json_action_file_recv_invite".equals(optString) && !"rcs_json_action_gs_recv_done".equals(optString) && !"rcs_json_action_gs_sess_recv".equals(optString)) {
                                if (!"rcs_json_action_im_msg_recv_msg".equals(optString) && !"rcs_json_action_groupchat_recv_msg".equals(optString)) {
                                    if ("rcs_json_action_file_send_failed".equals(optString)) {
                                        m(false, jSONObject.optString("trans_id"));
                                        return;
                                    }
                                    if ("rcs_json_action_file_send_ok".equals(optString)) {
                                        m(true, jSONObject.optString("trans_id"));
                                        return;
                                    } else if ("rcs_json_action_gs_share_ok".equals(optString)) {
                                        n(true, jSONObject.optString("trans_id"));
                                        return;
                                    } else {
                                        if ("rcs_json_action_gs_share_failed".equals(optString)) {
                                            n(false, jSONObject.optString("trans_id"));
                                            return;
                                        }
                                        return;
                                    }
                                }
                                l(jSONObject.optString("imdn_id"));
                                return;
                            }
                            k(jSONObject.optString("trans_id"));
                            return;
                        }
                        String optString2 = jSONObject.optString("group_chat_id", null);
                        h(optString2);
                        if ("rcs_json_action_groupchat_accepted".equals(optString)) {
                            g(true, optString2);
                        } else if ("rcs_json_action_groupchat_rejected".equals(optString) || "rcs_json_action_groupchat_canceled".equals(optString)) {
                            g(false, optString2);
                        }
                        if (!"rcs_json_action_groupchat_partp_update".equals(optString) && !"rcs_json_action_groupchat_subject_chged".equals(optString)) {
                            if ("rcs_json_action_groupchat_accepted".equals(optString)) {
                                j(optString2, true);
                                return;
                            } else {
                                j(optString2, false);
                                return;
                            }
                        }
                        return;
                    }
                    h(jSONObject.optString("group_chat_id", null));
                    return;
                }
                f(jSONObject.optString("phone"), true, jSONObject.optBoolean("isRcs"), jSONObject.optString("cap"), jSONObject.optBoolean("online", false), jSONObject.optLong("cap_update_time"));
            }
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
    }

    public static void d(Context context, Boolean bool) {
        f25457a = context;
        f25458b = bool;
        if (!bool.booleanValue()) {
            RcsServiceManager.q(f25465i);
        }
    }

    public static void e() {
        synchronized (f25459c) {
            try {
                for (String str : f25459c.keySet()) {
                    Iterator<a> it = f25459c.get(str).iterator();
                    while (it.hasNext()) {
                        it.next().a(str, false, null, false);
                    }
                }
                f25459c.clear();
            } finally {
            }
        }
        synchronized (f25462f) {
            try {
                for (String str2 : f25462f.keySet()) {
                    f25462f.get(str2).a(false, str2);
                }
                f25462f.clear();
            } finally {
            }
        }
    }

    public static void f(String str, boolean z10, boolean z11, String str2, boolean z12, long j10) {
        synchronized (f25464h) {
            try {
                if (f25464h.contains(str)) {
                    f25464h.remove(str);
                }
            } finally {
            }
        }
        if (z10) {
            com.juphoon.helper.a.h(str, z11, str2, z12, j10);
        }
        synchronized (f25459c) {
            try {
                if (f25459c.containsKey(str)) {
                    Iterator<a> it = f25459c.get(str).iterator();
                    while (it.hasNext()) {
                        it.next().a(str, z10, str2, z12);
                    }
                    f25459c.remove(str);
                }
            } finally {
            }
        }
        synchronized (f25461e) {
            try {
                Iterator<a> it2 = f25461e.iterator();
                while (it2.hasNext()) {
                    it2.next().a(str, z10, str2, z12);
                }
            } finally {
            }
        }
    }

    public static void g(boolean z10, String str) {
        synchronized (f25462f) {
            try {
                if (f25462f.containsKey(str)) {
                    f25462f.get(str).a(z10, str);
                    f25462f.remove(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void h(String str) {
        synchronized (f25460d) {
            try {
                Iterator<c> it = f25460d.iterator();
                while (it.hasNext()) {
                    it.next().a(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void i(String str) {
        synchronized (f25460d) {
            try {
                Iterator<c> it = f25460d.iterator();
                while (it.hasNext()) {
                    it.next().c(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void j(String str, boolean z10) {
        synchronized (f25460d) {
            try {
                Iterator<c> it = f25460d.iterator();
                while (it.hasNext()) {
                    it.next().b(str, z10);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void k(String str) {
        synchronized (f25463g) {
            try {
                Iterator<d> it = f25463g.iterator();
                while (it.hasNext()) {
                    it.next().b(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void l(String str) {
        synchronized (f25463g) {
            try {
                Iterator<d> it = f25463g.iterator();
                while (it.hasNext()) {
                    it.next().e(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void m(boolean z10, String str) {
        synchronized (f25463g) {
            try {
                Iterator<d> it = f25463g.iterator();
                while (it.hasNext()) {
                    it.next().c(z10, str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void n(boolean z10, String str) {
        synchronized (f25463g) {
            try {
                Iterator<d> it = f25463g.iterator();
                while (it.hasNext()) {
                    it.next().a(z10, str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void o(boolean z10, String str) {
        synchronized (f25463g) {
            try {
                Iterator<d> it = f25463g.iterator();
                while (it.hasNext()) {
                    it.next().d(z10, str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void p(String str, a aVar) {
        String b10 = com.juphoon.rcs.tool.b.b(str);
        if (aVar != null) {
            synchronized (f25459c) {
                try {
                    if (!f25459c.containsKey(b10)) {
                        f25459c.put(b10, new ArrayList());
                    }
                    f25459c.get(b10).add(aVar);
                } finally {
                }
            }
        } else {
            synchronized (f25464h) {
                try {
                    if (f25464h.contains(b10)) {
                        return;
                    } else {
                        f25464h.add(b10);
                    }
                } finally {
                }
            }
        }
        if (!com.juphoon.rcs.tool.a.b(b10)) {
            synchronized (f25459c) {
                try {
                    if (f25459c.containsKey(b10)) {
                        Iterator<a> it = f25459c.get(b10).iterator();
                        while (it.hasNext()) {
                            it.next().a(b10, false, null, false);
                        }
                        f25459c.remove(b10);
                    }
                } finally {
                }
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (f25458b.booleanValue()) {
            c(intent.getAction(), intent.getStringExtra("rcs_json_key"));
        }
    }
}
