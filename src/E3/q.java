package E3;

import E3.q;
import android.content.ContentProviderOperation;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.provider.CallLog;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.TextView;
import com.android.contacts.framework.baseui.util.C0637b;
import com.android.contacts.framework.baseui.util.LocationUtils;
import com.customize.contacts.util.b0;
import com.oplus.dialer.R;
import com.oplus.foundation.util.feature.CommonOSPublicFeature;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: CallLogNumberPlaceLoader.java */
/* loaded from: classes3.dex */
public class q implements Handler.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final String f651a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f652b;

    /* renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, b> f653c = new ConcurrentHashMap<>();

    /* renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap<TextView, String> f654d = new ConcurrentHashMap<>();

    /* renamed from: e, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f655e = new ConcurrentHashMap<>();

    /* renamed from: f, reason: collision with root package name */
    public final ConcurrentHashMap<String, Pair<Integer, Integer>> f656f;

    /* renamed from: g, reason: collision with root package name */
    public final HashMap<String, String> f657g;

    /* renamed from: h, reason: collision with root package name */
    public final HashMap<String, String> f658h;

    /* renamed from: i, reason: collision with root package name */
    public final Handler f659i;

    /* renamed from: j, reason: collision with root package name */
    public final String f660j;

    /* renamed from: k, reason: collision with root package name */
    public final String f661k;

    /* renamed from: l, reason: collision with root package name */
    public a f662l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f663m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f664n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f665o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f666p;

    /* compiled from: CallLogNumberPlaceLoader.java */
    /* loaded from: classes3.dex */
    public class a extends HandlerThread implements Handler.Callback {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList<String> f667a;

        /* renamed from: b, reason: collision with root package name */
        public Handler f668b;

        public a() {
            super("LocationLoader");
            this.f667a = com.google.common.collect.n.f();
        }

        public final void a(String str, String str2) {
            String str3 = (String) q.this.f655e.get(str);
            b bVar = (b) q.this.f653c.get(str + str3);
            if (bVar == null) {
                return;
            }
            if (bVar.f672c == null) {
                bVar.f672c = "";
            }
            String str4 = bVar.f672c;
            if (!TextUtils.isEmpty(str4) ? !(TextUtils.isEmpty(str2) || !str4.equals(str2)) : TextUtils.isEmpty(str2)) {
                if (bVar.f674e && bVar.f673d == null) {
                    q.this.f658h.put(str, str2);
                    return;
                }
                return;
            }
            q.this.f658h.put(str, str2);
        }

        public final void b() {
            int i10;
            int i11;
            boolean z10;
            String str;
            q.this.r(this.f667a);
            int size = this.f667a.size();
            if (size == 0) {
                return;
            }
            for (int i12 = 0; i12 < size; i12++) {
                String str2 = this.f667a.get(i12);
                String str3 = (String) q.this.f655e.get(str2);
                if (q.this.f657g.containsKey(str2 + str3)) {
                    str = (String) q.this.f657g.get(str2 + str3);
                    z10 = false;
                } else {
                    if (q.this.f656f.containsKey(str2)) {
                        Pair pair = (Pair) q.this.f656f.get(str2);
                        Objects.requireNonNull(pair);
                        i10 = ((Integer) pair.first).intValue();
                        Pair pair2 = (Pair) q.this.f656f.get(str2);
                        Objects.requireNonNull(pair2);
                        i11 = ((Integer) pair2.second).intValue();
                    } else {
                        i10 = -1;
                        i11 = 0;
                    }
                    if (H7.a.b()) {
                        H7.b.b("NumberPlaceLoader", "subId = " + i10 + ", roamType = " + i11 + ", countryIso = " + str3 + ", num = " + H7.a.d(str2));
                    }
                    String j10 = LocationUtils.j(q.this.f652b, str2, str3, i11, b0.e0(q.this.f652b, i10));
                    if (TextUtils.isEmpty(j10)) {
                        if (!q.this.f666p) {
                            z10 = true;
                            if (q.this.f665o) {
                                j10 = q.this.f660j;
                            } else {
                                j10 = q.this.f652b.getResources().getString(R.string.oplus_unknow_city);
                            }
                        } else {
                            z10 = false;
                            j10 = "";
                        }
                    } else {
                        z10 = false;
                    }
                    if (q.this.f665o) {
                        a(str2, j10);
                    }
                    if (z10) {
                        q.this.f657g.put(str2 + str3, "");
                    } else {
                        q.this.f657g.put(str2 + str3, j10);
                    }
                    str = j10;
                }
                if (z10) {
                    q.this.n(str2, "");
                } else {
                    q.this.n(str2, str);
                }
            }
            this.f667a.clear();
        }

        public void c() {
            if (this.f668b == null) {
                this.f668b = new Handler(getLooper(), this);
            }
            this.f668b.sendEmptyMessage(1);
        }

        public void d() {
            Handler handler = this.f668b;
            if (handler == null) {
                this.f668b = new Handler(getLooper(), this);
            } else {
                handler.removeCallbacksAndMessages(null);
            }
            Handler handler2 = this.f668b;
            handler2.sendMessage(Message.obtain(handler2, 2));
        }

        public final void e() {
            if (q.this.f658h.isEmpty()) {
                return;
            }
            Iterator it = q.this.f658h.keySet().iterator();
            try {
                try {
                    ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
                    while (it.hasNext()) {
                        try {
                            String str = (String) it.next();
                            if (!TextUtils.isEmpty(str)) {
                                ContentProviderOperation.Builder newUpdate = ContentProviderOperation.newUpdate(CallLog.Calls.CONTENT_URI_WITH_VOICEMAIL);
                                newUpdate.withValue(com.android.contacts.framework.baseui.calllog.d.a()[6], q.this.f658h.get(str));
                                if (LocationUtils.l() && CommonOSPublicFeature.e()) {
                                    newUpdate.withValue("oplus_data1", new Q0.a(q.this.f661k).c());
                                }
                                if (str.charAt(0) == '1' && str.length() >= 7) {
                                    newUpdate.withSelection("number LIKE ?", new String[]{str.substring(0, 7) + "%"});
                                } else {
                                    newUpdate.withSelection("normalized_number = ?", new String[]{str});
                                }
                                arrayList.add(newUpdate.build());
                            }
                        } catch (ConcurrentModificationException unused) {
                            it = q.this.f658h.keySet().iterator();
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        q.this.f652b.getContentResolver().applyBatch("call_log", arrayList);
                    }
                } catch (Exception e10) {
                    H7.b.c("NumberPlaceLoader", "updateLocationToCallsTable error：" + e10);
                }
                q.this.f658h.clear();
            } catch (Throwable th) {
                q.this.f658h.clear();
                throw th;
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 != 1) {
                if (i10 == 2) {
                    e();
                }
            } else {
                b();
                q.this.f659i.sendEmptyMessage(2);
            }
            return true;
        }
    }

    /* compiled from: CallLogNumberPlaceLoader.java */
    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f670a;

        /* renamed from: b, reason: collision with root package name */
        public String f671b;

        /* renamed from: c, reason: collision with root package name */
        public String f672c;

        /* renamed from: d, reason: collision with root package name */
        public Q0.a f673d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f674e;

        public b() {
        }
    }

    public q(Context context, String str) {
        ConcurrentHashMap<String, Pair<Integer, Integer>> concurrentHashMap = new ConcurrentHashMap<>();
        this.f656f = concurrentHashMap;
        HashMap<String, String> hashMap = new HashMap<>();
        this.f657g = hashMap;
        this.f658h = new HashMap<>();
        this.f659i = new Handler(Looper.getMainLooper(), this);
        this.f661k = LocationUtils.g();
        this.f651a = str;
        this.f652b = context;
        this.f660j = context.getResources().getString(R.string.oplus_unknow_city);
        hashMap.clear();
        concurrentHashMap.clear();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i10 = message.what;
        if (i10 != 1) {
            if (i10 != 2) {
                return false;
            }
            if (!this.f664n) {
                t();
            }
            return true;
        }
        this.f663m = false;
        if (!this.f664n) {
            if (this.f662l == null) {
                a aVar = new a();
                this.f662l = aVar;
                aVar.start();
            }
            this.f662l.c();
        }
        return true;
    }

    public final void n(String str, String str2) {
        if (this.f664n) {
            return;
        }
        String str3 = this.f655e.get(str);
        b bVar = this.f653c.get(str + str3);
        if (bVar == null) {
            bVar = new b();
        }
        bVar.f670a = 2;
        bVar.f671b = str2;
        this.f653c.put(str + str3, bVar);
    }

    public void o() {
        this.f653c.clear();
        this.f657g.clear();
        this.f655e.clear();
        this.f656f.clear();
    }

    public final boolean p(TextView textView, String str, String str2, Q0.a aVar, boolean z10) {
        String str3 = this.f655e.get(str);
        b bVar = this.f653c.get(str + str3);
        if (bVar == null) {
            bVar = new b();
            bVar.f672c = str2;
            bVar.f673d = aVar;
            bVar.f674e = z10;
            this.f653c.putIfAbsent(str + str3, bVar);
        } else if (bVar.f670a == 2) {
            bVar.f672c = str2;
            bVar.f673d = aVar;
            bVar.f674e = z10;
            if (bVar.f671b != null && !TextUtils.isEmpty(bVar.f671b)) {
                String str4 = bVar.f671b;
                if (!TextUtils.isEmpty(str4)) {
                    if (this.f665o) {
                        x(textView, str4, str);
                    } else if (!str4.equals("-")) {
                        x(textView, str4, str);
                    } else {
                        x(textView, "", str);
                    }
                    return true;
                }
                w(textView, str);
                bVar.f671b = null;
                return true;
            }
            if (w(textView, str)) {
                return true;
            }
            textView.setText(this.f651a);
            return true;
        }
        if (H7.a.b()) {
            H7.b.b("NumberPlaceLoader", "loadCachedLocation holder state:" + bVar.f670a);
        }
        if (C0637b.h()) {
            textView.setText("");
        } else {
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            textView.setText(str2);
        }
        bVar.f670a = 0;
        return false;
    }

    public void q(s sVar) {
        this.f665o = sVar.f683i;
        this.f666p = sVar.f676b;
        String str = sVar.f684j;
        if (str != null && !str.isEmpty()) {
            String str2 = sVar.f681g;
            if (str2 != null) {
                this.f655e.put(sVar.f684j, str2);
            }
            this.f656f.put(sVar.f684j, new Pair<>(Integer.valueOf(sVar.f680f), Integer.valueOf(sVar.f679e)));
            if (p(sVar.a(), sVar.f684j, sVar.f682h, sVar.f678d, sVar.f677c)) {
                this.f654d.remove(sVar.a());
                return;
            }
            this.f654d.put(sVar.a(), sVar.f684j);
            if (!this.f664n) {
                u();
                return;
            }
            return;
        }
        sVar.a().setText(this.f651a);
        if (H7.a.b()) {
            H7.b.b("NumberPlaceLoader", "number = " + H7.a.d(sVar.f684j) + "mDefaultPlace = " + this.f651a);
        }
    }

    public final void r(ArrayList<String> arrayList) {
        arrayList.clear();
        for (String str : this.f654d.values()) {
            String str2 = this.f655e.get(str);
            b bVar = this.f653c.get(str + str2);
            if (bVar != null && bVar.f670a == 0) {
                bVar.f670a = 1;
                arrayList.add(str);
            }
        }
    }

    public void s() {
        this.f664n = true;
    }

    public final void t() {
        Iterator<TextView> it = this.f654d.keySet().iterator();
        while (it.hasNext()) {
            TextView next = it.next();
            if (p(next, this.f654d.get(next), null, null, false)) {
                it.remove();
            }
        }
        if (!this.f654d.isEmpty()) {
            u();
        }
    }

    public final void u() {
        if (!this.f663m) {
            this.f663m = true;
            this.f659i.sendEmptyMessage(1);
        }
    }

    public void v() {
        this.f664n = false;
        if (!this.f654d.isEmpty()) {
            u();
        }
    }

    public final boolean w(TextView textView, String str) {
        long j10;
        if (!this.f666p) {
            Object tag = textView.getTag();
            if (tag instanceof v) {
                j10 = ((v) tag).a();
            } else {
                j10 = -9999;
            }
            String str2 = "";
            if (!this.f665o && j10 != 0) {
                if (!C0637b.h()) {
                    str2 = this.f652b.getResources().getString(R.string.oplus_unknow_city);
                }
                x(textView, str2, str);
                return true;
            }
            if (!C0637b.h()) {
                str2 = this.f660j;
            }
            x(textView, str2, str);
            return true;
        }
        return false;
    }

    public final void x(TextView textView, String str, String str2) {
        String str3;
        long j10;
        Object tag = textView.getTag();
        if (tag instanceof v) {
            v vVar = (v) tag;
            str3 = vVar.b();
            j10 = vVar.a();
        } else {
            str3 = null;
            j10 = 0;
        }
        if (!TextUtils.isEmpty(str3) && !TextUtils.equals(str3, str2)) {
            if (H7.a.b()) {
                H7.b.b("NumberPlaceLoader", "currentNum = " + H7.a.d(str3) + " ,number = " + H7.a.d(str2) + " ,contact_id = " + j10);
            }
            if (j10 < 0) {
                textView.setText(this.f652b.getString(R.string.oplus_special_number));
                return;
            }
            return;
        }
        CharSequence text = textView.getText();
        if (C0637b.h()) {
            textView.setText("");
        } else if (text == null || !text.equals(str)) {
            textView.setText(str);
        }
    }

    public void y() {
        s();
        a aVar = this.f662l;
        if (aVar != null) {
            aVar.d();
            final a aVar2 = this.f662l;
            new Handler(aVar2.getLooper()).post(new Runnable() { // from class: E3.p
                @Override // java.lang.Runnable
                public final void run() {
                    q.a.this.quitSafely();
                }
            });
            this.f662l = null;
        }
        this.f654d.clear();
    }
}
