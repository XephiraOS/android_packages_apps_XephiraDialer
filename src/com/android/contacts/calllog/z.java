package com.android.contacts.calllog;

import C7.d;
import F0.c;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.CallLog;
import android.telephony.PhoneNumberUtils;
import android.telephony.SubscriptionManager;
import android.text.TextUtils;
import com.android.contacts.framework.api.numberidentify.interfaces.IRecognitionNumber;
import com.android.incallui.OplusAutoRedialNotificationUI;
import com.android.incallui.OplusPhoneUtils;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.util.BlackListUtils;
import com.customize.contacts.util.C0801l;
import com.customize.contacts.util.C0811w;
import com.oplus.foundation.util.feature.CommonOSPublicFeature;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Set;
import w0.C1641a;

/* compiled from: ContactInfoCache.java */
/* loaded from: classes.dex */
public class z {

    /* renamed from: d, reason: collision with root package name */
    public final A f14085d;

    /* renamed from: e, reason: collision with root package name */
    public c f14086e;

    /* renamed from: f, reason: collision with root package name */
    public final b f14087f;

    /* renamed from: i, reason: collision with root package name */
    public final Context f14090i;

    /* renamed from: h, reason: collision with root package name */
    public com.android.contacts.framework.baseui.util.w f14089h = null;

    /* renamed from: j, reason: collision with root package name */
    public boolean f14091j = false;

    /* renamed from: k, reason: collision with root package name */
    public volatile boolean f14092k = false;

    /* renamed from: l, reason: collision with root package name */
    public boolean f14093l = true;

    /* renamed from: m, reason: collision with root package name */
    public boolean f14094m = false;

    /* renamed from: n, reason: collision with root package name */
    public final Handler f14095n = new a(Looper.getMainLooper());

    /* renamed from: a, reason: collision with root package name */
    public final LinkedList<B> f14082a = new LinkedList<>();

    /* renamed from: b, reason: collision with root package name */
    public final LinkedList<B> f14083b = new LinkedList<>();

    /* renamed from: c, reason: collision with root package name */
    public final C7.d<H, y> f14084c = C7.d.c(500);

    /* renamed from: g, reason: collision with root package name */
    public final Set<Integer> f14088g = Collections.synchronizedSet(new HashSet());

    /* compiled from: ContactInfoCache.java */
    /* loaded from: classes.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 != 1) {
                if (i10 == 2) {
                    z.this.x();
                    return;
                } else {
                    if (i10 == 3) {
                        z.this.f14087f.i();
                        return;
                    }
                    return;
                }
            }
            z.this.f14087f.a();
        }
    }

    /* compiled from: ContactInfoCache.java */
    /* loaded from: classes.dex */
    public interface b {
        void a();

        void i();
    }

    /* compiled from: ContactInfoCache.java */
    /* loaded from: classes.dex */
    public class c extends Thread {

        /* renamed from: a, reason: collision with root package name */
        public volatile boolean f14097a;

        public c() {
            super("ContactInfoCache.QueryThread");
            this.f14097a = false;
        }

        public void a() {
            this.f14097a = true;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            B b10;
            B b11;
            if (H7.a.b()) {
                H7.b.b("ContactInfoCache", "run()");
            }
            boolean z10 = false;
            while (!this.f14097a) {
                synchronized (z.this.f14082a) {
                    try {
                        b10 = null;
                        if (!z.this.f14082a.isEmpty() && !z.this.f14094m) {
                            b11 = (B) z.this.f14082a.removeFirst();
                        } else {
                            if (!z.this.f14094m && z10) {
                                z.this.f14095n.removeMessages(1);
                                z.this.f14095n.sendEmptyMessageDelayed(1, 1000L);
                                z10 = false;
                            }
                            do {
                                try {
                                    if (!z.this.f14092k || z.this.f14083b.isEmpty()) {
                                        z.this.f14082a.wait(1000L);
                                    }
                                } catch (InterruptedException unused) {
                                    Thread.currentThread().interrupt();
                                }
                            } while (z.this.f14094m);
                            b11 = null;
                        }
                    } finally {
                    }
                }
                if (!z.this.f14094m && !this.f14097a && b11 != null && z.this.q(b11)) {
                    z10 = true;
                }
                if (!z.this.f14094m && z.this.f14092k) {
                    synchronized (z.this.f14083b) {
                        try {
                            if (!z.this.f14083b.isEmpty()) {
                                b10 = (B) z.this.f14083b.removeFirst();
                            } else {
                                z.this.s(false);
                            }
                        } finally {
                        }
                    }
                    if (!this.f14097a && b10 != null && z.this.q(b10)) {
                        z10 = true;
                    }
                }
            }
        }
    }

    public z(Context context, A a10, b bVar) {
        this.f14090i = context;
        this.f14085d = a10;
        this.f14087f = bVar;
    }

    public final void A(String str, y yVar, y yVar2, boolean z10, int i10) {
        boolean z11;
        int i11;
        String str2;
        boolean z12;
        boolean z13;
        String str3;
        ContentValues contentValues = new ContentValues();
        if (FeatureOption.o() && C1641a.n(yVar.f14057b)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (yVar2 != null) {
            if (!TextUtils.equals(m(yVar.f14058c), m(yVar2.f14058c))) {
                contentValues.put("name", yVar.f14058c);
                z12 = true;
            } else {
                z12 = false;
            }
            if (z11) {
                if (yVar2.f14057b != null) {
                    contentValues.putNull("lookup_uri");
                    str3 = "photo_id";
                    z12 = true;
                }
                str3 = "photo_id";
            } else {
                if (!U7.g.a(yVar.f14057b, yVar2.f14057b)) {
                    contentValues.put("lookup_uri", U7.g.c(yVar.f14057b));
                    str3 = "photo_id";
                    z12 = true;
                }
                str3 = "photo_id";
            }
            long j10 = yVar.f14066k;
            if (j10 != yVar2.f14066k) {
                contentValues.put(str3, Long.valueOf(j10));
                z12 = true;
            }
            if (!U7.g.a(yVar.f14067l, yVar2.f14067l)) {
                Uri uri = yVar.f14067l;
                if (uri != null) {
                    contentValues.put("transcription", uri.toString());
                } else {
                    contentValues.put("transcription", "");
                }
                z12 = true;
            }
            if (CommonOSPublicFeature.e()) {
                F0.a aVar = yVar2.f14055A;
                if (aVar == null) {
                    F0.a aVar2 = yVar.f14055A;
                    if (aVar2 != null) {
                        contentValues.put("identify_name", E0.b.l(aVar2));
                        z12 = true;
                    }
                } else {
                    F0.a aVar3 = yVar.f14055A;
                    if (aVar3 != null && !aVar.equals(aVar3)) {
                        contentValues.put("identify_name", E0.b.l(yVar.f14055A));
                    } else if (yVar.f14055A == null && yVar2.f14055A != null) {
                        contentValues.putNull("identify_name");
                    }
                    z12 = true;
                }
            }
            if (!this.f14091j && !C0801l.o(i10) && i10 != 2 && TextUtils.isEmpty(yVar.f14058c) && yVar.f14057b == null) {
                int o10 = E0.b.o(str);
                int h10 = com.customize.contacts.util.J.h(this.f14090i, SubscriptionManager.getSlotIndex(yVar2.f14071p), o10, E0.b.m(str));
                i11 = -1;
                if (h10 != -1 && OplusPhoneUtils.DeviceState.LOCK_DEVICE.equals(yVar2.f14075t)) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(str);
                    if (!Boolean.TRUE.equals(BlackListUtils.d(this.f14090i, arrayList).get("isWhiteList"))) {
                        Integer valueOf = Integer.valueOf(h10);
                        str2 = OplusAutoRedialNotificationUI.TYPE;
                        contentValues.put(str2, valueOf);
                        int i12 = yVar2.f14071p;
                        if (yVar2.f14070o > k.f13898t0) {
                            if (com.customize.contacts.util.J.m(yVar2.f14075t, o10, i10)) {
                                z13 = true;
                                G0.c.n(this.f14090i, 1, R0.c.f3189g, 1);
                                G0.c.t(this.f14090i, 1, R0.c.f3190h, str);
                                G0.c.t(this.f14090i, 1, R0.c.f3191i, String.valueOf(yVar2.f14070o));
                                G0.c.q(this.f14090i, 1, "last_ted_recog_time", -1L);
                            } else {
                                z13 = true;
                            }
                            k.f13898t0 = yVar2.f14070o;
                        } else {
                            z13 = true;
                        }
                        i11 = i12;
                        z12 = z13;
                        contentValues.put("hasRecog", yVar2.f14075t);
                    }
                }
                str2 = OplusAutoRedialNotificationUI.TYPE;
            } else {
                str2 = OplusAutoRedialNotificationUI.TYPE;
                i11 = -1;
            }
            z13 = false;
            contentValues.put("hasRecog", yVar2.f14075t);
        } else {
            i11 = -1;
            str2 = OplusAutoRedialNotificationUI.TYPE;
            contentValues.put("name", yVar.f14058c);
            if (z11) {
                contentValues.putNull("lookup_uri");
            } else {
                contentValues.put("lookup_uri", U7.g.c(yVar.f14057b));
            }
            contentValues.put("photo_id", Long.valueOf(yVar.f14066k));
            if (yVar.f14055A != null && CommonOSPublicFeature.e()) {
                contentValues.put("identify_name", E0.b.l(yVar.f14055A));
            }
            z12 = true;
            z13 = false;
        }
        if (!z12) {
            return;
        }
        contentValues.put("is_special_number", Integer.valueOf(z10 ? 1 : 0));
        try {
            StringBuilder sb = new StringBuilder();
            if (z13) {
                sb.append("number");
                sb.append(" = ?");
                sb.append(" AND ");
                sb.append(str2);
                sb.append(" != ?");
                sb.append(C0801l.b(i10));
                sb.append(" AND ");
                sb.append("simid");
                sb.append(" = ?");
                this.f14090i.getContentResolver().update(CallLog.Calls.CONTENT_URI_WITH_VOICEMAIL, contentValues, sb.toString(), new String[]{str, Integer.toString(2), Integer.toString(i11)});
            } else {
                sb.append("number");
                sb.append(" = ?");
                this.f14090i.getContentResolver().update(CallLog.Calls.CONTENT_URI_WITH_VOICEMAIL, contentValues, sb.toString(), new String[]{str});
            }
            this.f14095n.sendEmptyMessage(3);
        } catch (Exception e10) {
            H7.b.c("ContactInfoCache", "Exception e: " + e10);
        }
    }

    public final boolean i(y yVar, y yVar2) {
        if (yVar.f14057b != null && yVar2.f14057b != null) {
            if (TextUtils.equals(m(yVar.f14058c), m(yVar2.f14058c)) && TextUtils.equals(yVar.f14057b.toString(), yVar2.f14057b.toString())) {
                return true;
            }
            return false;
        }
        return TextUtils.equals(m(yVar.f14058c), m(yVar2.f14058c));
    }

    public void j() {
        C7.d<H, y> dVar = this.f14084c;
        if (dVar != null) {
            dVar.a();
        }
    }

    public void k(ArrayList<String> arrayList) {
        if (C0811w.g(arrayList) || this.f14084c == null) {
            return;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!TextUtils.isEmpty(next)) {
                synchronized (this.f14088g) {
                    try {
                        if (!this.f14088g.isEmpty()) {
                            Iterator<Integer> it2 = this.f14088g.iterator();
                            while (it2.hasNext()) {
                                this.f14084c.b(new H(next, it2.next().intValue()));
                            }
                        } else {
                            this.f14084c.b(new H(next, 0));
                        }
                    } finally {
                    }
                }
            }
        }
    }

    public void l(String str, y yVar, boolean z10, int i10, boolean z11, int i11) {
        B b10 = new B(str, yVar, i10, z11, i11);
        synchronized (this.f14082a) {
            try {
                if (!this.f14082a.contains(b10)) {
                    this.f14082a.add(b10);
                    this.f14082a.notifyAll();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z10) {
            x();
        }
    }

    public final CharSequence m(CharSequence charSequence) {
        if (charSequence == null) {
            return "";
        }
        return charSequence;
    }

    public y n(String str, int i10) {
        d.a<y> f10 = this.f14084c.f(new H(str, i10));
        if (f10 == null) {
            return null;
        }
        return f10.getValue();
    }

    public y o(String str, int i10, int i11, y yVar, boolean z10, boolean z11) {
        y value;
        H h10 = new H(str, i10);
        d.a<y> f10 = this.f14084c.f(h10);
        if (f10 == null) {
            value = null;
        } else {
            value = f10.getValue();
        }
        y yVar2 = value;
        if (f10 == null) {
            this.f14084c.i(h10, y.f14054B);
            this.f14088g.add(Integer.valueOf(i10));
            l(str, yVar, true, i11, z10, z11 ? 1 : 0);
        } else {
            if (!this.f14094m && f10.a()) {
                l(str, yVar, false, i11, z10, z11 ? 1 : 0);
            } else if (!this.f14094m && !i(yVar, yVar2)) {
                l(str, yVar, false, i11, z10, z11 ? 1 : 0);
            }
            if (yVar2 != y.f14054B) {
                return yVar2;
            }
        }
        return yVar;
    }

    public void p() {
        this.f14084c.e();
        this.f14088g.clear();
    }

    public final boolean q(B b10) {
        String str;
        y k10;
        int i10;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        String str2;
        F0.a aVar;
        Uri uri;
        String str3 = b10.f13732a;
        y yVar = b10.f13733b;
        int i11 = b10.f13734c;
        boolean z15 = b10.f13735d;
        String str4 = null;
        if (yVar != null && (uri = yVar.f14057b) != null) {
            str = uri.getLastPathSegment();
        } else {
            str = null;
        }
        if (yVar != null) {
            str4 = yVar.f14074s;
        }
        String str5 = str4;
        if (b10.b()) {
            k10 = this.f14085d.j(str3, str5, str, -1L);
            if (b10.f13736e == 1 && !this.f14085d.g(k10)) {
                l(str3, yVar, true, i11, z15, 2);
                return false;
            }
        } else {
            k10 = this.f14085d.k(str3, str5, str);
        }
        if (k10 != null) {
            k10.f14078w = false;
        }
        if (C1641a.l(this.f14090i, FeatureOption.o())) {
            String t10 = C1641a.t(this.f14090i, str3);
            if (H7.a.b()) {
                H7.b.e("ContactInfoCache", "fdn name:" + t10);
            }
            if (!TextUtils.isEmpty(t10)) {
                if (k10 != null) {
                    k10.f14058c = t10;
                } else {
                    k10 = y.f14054B;
                    k10.f14058c = t10;
                    k10.f14061f = str3;
                }
                k10.f14078w = true;
            }
        }
        y yVar2 = k10;
        if (yVar2 == null) {
            return false;
        }
        if (H7.a.b()) {
            H7.b.b("ContactInfoCache", "queryContactInfo: " + H7.a.d(str3));
        }
        if (yVar != null) {
            i10 = yVar.f14071p;
        } else {
            i10 = -1;
        }
        yVar2.f14071p = i10;
        H h10 = new H(str3, i10);
        y g10 = this.f14084c.g(h10);
        if (this.f14089h.c(str3) && !yVar2.f14078w) {
            if (TextUtils.isEmpty(yVar2.f14058c)) {
                yVar2.f14058c = this.f14089h.d(str3).a();
            }
            z10 = true;
        } else {
            z10 = false;
        }
        if (yVar2.f14064i != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        y yVar3 = y.f14054B;
        if ((!Objects.equals(g10, yVar3) || z11) && !yVar2.equals(g10)) {
            z12 = true;
        } else {
            z12 = false;
        }
        if ((g10 == null || g10 == yVar3) && yVar2.f14078w) {
            z12 = true;
        }
        if (yVar2.f14057b == null && !yVar2.f14078w && B3.a.u() && yVar != null) {
            E0.b.F(new c.a().h(str3).c(Integer.valueOf(i11)).e(Long.valueOf(yVar.f14068m)).j(Integer.valueOf(yVar.f14069n)).i(Long.valueOf(yVar.f14070o)).k(Integer.valueOf(yVar.f14071p)).f(Boolean.valueOf(z15)).b(Boolean.valueOf(C0801l.o(i11))).a());
            if (E0.b.y(str3) && TextUtils.isEmpty(yVar2.f14058c)) {
                str2 = E0.b.u(str3);
                yVar2.f14058c = str2;
            } else {
                str2 = "";
            }
            String str6 = str2;
            String t11 = E0.b.t(this.f14090i, str3);
            int o10 = E0.b.o(str3);
            int m10 = E0.b.m(str3);
            boolean w10 = E0.b.w(str3);
            if (!TextUtils.isEmpty(str6) || !TextUtils.isEmpty(t11)) {
                yVar2.f14055A = new F0.a(str6, t11, o10, m10, w10);
            }
            if (g10 != null && ((aVar = g10.f14055A) != null ? !aVar.equals(yVar2.f14055A) : yVar2.f14055A != null)) {
                z12 = true;
            }
        }
        if (E0.a.d()) {
            if (yVar2.f14057b == null) {
                yVar2.f14079x = E0.a.b(str3);
            } else {
                IRecognitionNumber B10 = E0.b.B(new c.a().h(str3).d(Integer.valueOf(E0.a.a())).a());
                if (B10 != null) {
                    yVar2.f14079x = B10.a();
                }
            }
            if (yVar2.f14079x) {
                z12 = true;
            }
        }
        if (yVar != null) {
            z13 = true;
            if (C1641a.u(this.f14090i, str3, yVar.f14071p, true)) {
                z12 = true;
            }
        } else {
            z13 = true;
        }
        if (str3 != null) {
            yVar2.f14072q = PhoneNumberUtils.isEmergencyNumber(str3);
        } else {
            yVar2.f14072q = false;
        }
        if (yVar2.f14072q) {
            z12 = z13;
        }
        if (B3.a.K() && yVar != null && !TextUtils.equals(yVar2.f14077v, yVar.f14077v)) {
            yVar2.f14077v = yVar.f14077v;
            z14 = z13;
        } else {
            z14 = z12;
        }
        yVar2.f14071p = i10;
        this.f14088g.add(Integer.valueOf(i10));
        this.f14084c.i(h10, yVar2);
        if (this.f14093l && !yVar2.f14078w) {
            A(str3, yVar2, yVar, z10, i11);
        }
        if (H7.a.b()) {
            H7.b.b("ContactInfoCache", "queryContactInfo updated = " + z14 + " ,mIsVip = " + yVar2.f14073r);
        }
        return z14;
    }

    public void r(boolean z10) {
        this.f14094m = z10;
    }

    public void s(boolean z10) {
        this.f14092k = z10;
    }

    public void t(boolean z10) {
        this.f14093l = z10;
    }

    public void u(boolean z10) {
        this.f14091j = z10;
    }

    public void v(com.android.contacts.framework.baseui.util.w wVar) {
        this.f14089h = wVar;
    }

    public void w(boolean z10) {
        if (this.f14086e == null) {
            if (z10) {
                x();
            } else {
                this.f14095n.sendEmptyMessageDelayed(2, 1000L);
            }
        }
    }

    public final synchronized void x() {
        if (this.f14086e != null) {
            return;
        }
        c cVar = new c();
        this.f14086e = cVar;
        cVar.setPriority(1);
        this.f14086e.start();
    }

    public void y() {
        z();
    }

    public final synchronized void z() {
        this.f14095n.removeMessages(2);
        synchronized (this.f14082a) {
            this.f14082a.notifyAll();
        }
        c cVar = this.f14086e;
        if (cVar != null) {
            cVar.a();
            this.f14086e.interrupt();
            this.f14086e = null;
        }
    }
}
