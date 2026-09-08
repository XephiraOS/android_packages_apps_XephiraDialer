package V6;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.provider.CallLog;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.util.Log;
import com.oplus.utils.C0846g;
import com.oplus.utils.C0860v;
import com.oplus.utils.X;
import h9.C1087a;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/* compiled from: ContactInfoCache.java */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: c, reason: collision with root package name */
    public V6.c f4028c;

    /* renamed from: d, reason: collision with root package name */
    public c f4029d;

    /* renamed from: e, reason: collision with root package name */
    public InterfaceC0076b f4030e;

    /* renamed from: g, reason: collision with root package name */
    public C1087a f4032g;

    /* renamed from: h, reason: collision with root package name */
    public Context f4033h;

    /* renamed from: j, reason: collision with root package name */
    public Handler f4035j = new a();

    /* renamed from: a, reason: collision with root package name */
    public final LinkedList<d> f4026a = new LinkedList<>();

    /* renamed from: b, reason: collision with root package name */
    public C0860v<i, V6.a> f4027b = C0860v.a(500);

    /* renamed from: f, reason: collision with root package name */
    public Set<Integer> f4031f = Collections.synchronizedSet(new HashSet());

    /* renamed from: i, reason: collision with root package name */
    public C0860v<String, V6.a> f4034i = C0860v.a(500);

    /* compiled from: ContactInfoCache.java */
    /* loaded from: classes3.dex */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 != 1) {
                if (i10 == 2) {
                    b.this.n();
                    return;
                }
                return;
            }
            b.this.f4030e.a();
        }
    }

    /* compiled from: ContactInfoCache.java */
    /* renamed from: V6.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0076b {
        void a();
    }

    /* compiled from: ContactInfoCache.java */
    /* loaded from: classes3.dex */
    public class c extends Thread {

        /* renamed from: a, reason: collision with root package name */
        public volatile boolean f4037a;

        public c() {
            super("ContactInfoCache.QueryThread");
            this.f4037a = false;
        }

        public void a() {
            this.f4037a = true;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            d dVar;
            if (C0846g.c()) {
                Log.d("ContactInfoCache", "run()");
            }
            boolean z10 = false;
            while (!this.f4037a) {
                synchronized (b.this.f4026a) {
                    try {
                        if (!b.this.f4026a.isEmpty()) {
                            dVar = (d) b.this.f4026a.removeFirst();
                        } else {
                            if (z10) {
                                b.this.f4035j.removeMessages(1);
                                b.this.f4035j.sendEmptyMessageDelayed(1, 500L);
                                z10 = false;
                            }
                            try {
                                b.this.f4026a.wait(1000L);
                            } catch (InterruptedException unused) {
                                Thread.currentThread().interrupt();
                            }
                            dVar = null;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (!this.f4037a && dVar != null && b.this.l(dVar)) {
                    z10 = true;
                }
            }
        }
    }

    public b(Context context, V6.c cVar, C1087a c1087a, InterfaceC0076b interfaceC0076b) {
        this.f4033h = context;
        this.f4028c = cVar;
        this.f4032g = c1087a;
        this.f4030e = interfaceC0076b;
    }

    public final boolean f(V6.a aVar, V6.a aVar2) {
        if (aVar == null) {
            return false;
        }
        if (aVar.f4011b != null && aVar2.f4011b != null) {
            if (!TextUtils.equals(h(aVar.f4012c), h(aVar2.f4012c)) || !TextUtils.equals(aVar.f4011b.toString(), aVar2.f4011b.toString())) {
                return false;
            }
            return true;
        }
        return TextUtils.equals(h(aVar.f4012c), h(aVar2.f4012c));
    }

    public void g(String str, V6.a aVar, boolean z10, int i10, String str2) {
        d dVar = new d(str, aVar, i10, str2);
        synchronized (this.f4026a) {
            try {
                if (!this.f4026a.contains(dVar)) {
                    this.f4026a.add(dVar);
                    this.f4026a.notifyAll();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z10) {
            n();
        }
    }

    public final CharSequence h(CharSequence charSequence) {
        if (charSequence == null) {
            return "";
        }
        return charSequence;
    }

    public V6.a i(String str, int i10, int i11, V6.a aVar) {
        V6.a value;
        i iVar = new i(str, i10);
        C0860v.a<V6.a> d10 = this.f4027b.d(iVar);
        if (d10 == null) {
            value = null;
        } else {
            value = d10.getValue();
        }
        if (d10 == null) {
            this.f4027b.g(iVar, V6.a.f4009q);
            this.f4031f.add(Integer.valueOf(i10));
            g(str, aVar, true, i11, null);
            return aVar;
        }
        if (d10.a()) {
            g(str, aVar, false, i11, null);
        } else if (!f(aVar, value)) {
            g(str, aVar, false, i11, null);
        }
        if (value != V6.a.f4009q) {
            return value;
        }
        return aVar;
    }

    public V6.a j(String str, String str2) {
        V6.a value;
        C0860v.a<V6.a> d10 = this.f4034i.d(str);
        if (d10 == null) {
            value = null;
        } else {
            value = d10.getValue();
        }
        if (d10 == null) {
            this.f4034i.g(str, V6.a.f4009q);
            g(str, null, true, -1, str2);
        } else if (d10.a()) {
            g(str, null, false, -1, str2);
        }
        return value;
    }

    public void k() {
        this.f4027b.c();
        this.f4034i.c();
        this.f4031f.clear();
    }

    public final boolean l(d dVar) {
        String str;
        boolean z10;
        int i10;
        V6.a e10;
        Uri uri;
        V6.a aVar = dVar.f4041b;
        String str2 = dVar.f4040a;
        int i11 = dVar.f4042c;
        i iVar = null;
        if (aVar != null && (uri = aVar.f4011b) != null) {
            str = uri.getLastPathSegment();
        } else {
            str = null;
        }
        V6.a c10 = this.f4028c.c(str2, str);
        if (c10 == null) {
            return false;
        }
        if (C0846g.c()) {
            Log.d("ContactInfoCache", "queryContactInfo: " + C0846g.f(str2) + " ,info.photoUri = " + c10.f4018i);
        }
        boolean z11 = true;
        if (c10.f4011b == null) {
            if (!TextUtils.isEmpty(dVar.f4043d) ? this.f4032g.t(str2, dVar.f4043d) : this.f4032g.s(str2, i11)) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (this.f4032g.j(str2) && TextUtils.isEmpty(c10.f4012c)) {
                c10.f4012c = this.f4032g.g(str2);
            }
            if (I6.b.d()) {
                if (I6.b.e(this.f4033h, str2)) {
                    z10 = true;
                }
                if (I6.b.b(str2) && TextUtils.isEmpty(c10.f4012c)) {
                    c10.f4012c = I6.b.a(str2);
                }
            }
        } else {
            z10 = false;
        }
        if (aVar == null) {
            e10 = this.f4034i.e(str2);
            i10 = -1;
        } else {
            i10 = aVar.f4022m;
            c10.f4022m = i10;
            iVar = new i(str2, i10);
            e10 = this.f4027b.e(iVar);
        }
        if (e10 == null) {
            z10 = false;
        } else if (!TextUtils.equals(h(c10.f4012c), h(e10.f4012c)) || c10.f4017h != e10.f4017h || !X.a(c10.f4018i, e10.f4018i) || c10.f4010a != e10.f4010a || (!TextUtils.isEmpty(e10.f4016g) && !TextUtils.equals(c10.f4016g, e10.f4016g))) {
            z10 = true;
        }
        if (str2 != null) {
            c10.f4023n = PhoneNumberUtils.isEmergencyNumber(str2);
        } else {
            c10.f4023n = false;
        }
        if (!c10.f4023n) {
            z11 = z10;
        }
        if (iVar == null) {
            this.f4034i.g(str2, c10);
        } else {
            c10.f4022m = i10;
            this.f4031f.add(Integer.valueOf(i10));
            this.f4027b.g(iVar, c10);
            q(str2, c10, aVar);
        }
        if (C0846g.c()) {
            Log.d("ContactInfoCache", "queryContactInfo updated = " + z11);
        }
        return z11;
    }

    public void m(boolean z10) {
        if (this.f4029d == null) {
            if (z10) {
                n();
            } else {
                this.f4035j.sendEmptyMessageDelayed(2, 1000L);
            }
        }
    }

    public final synchronized void n() {
        if (this.f4029d != null) {
            return;
        }
        c cVar = new c();
        this.f4029d = cVar;
        cVar.setPriority(1);
        this.f4029d.start();
    }

    public void o() {
        p();
    }

    public final synchronized void p() {
        this.f4035j.removeMessages(2);
        c cVar = this.f4029d;
        if (cVar != null) {
            cVar.a();
            this.f4029d.interrupt();
            this.f4029d = null;
        }
    }

    public final void q(String str, V6.a aVar, V6.a aVar2) {
        boolean z10;
        ContentValues contentValues = new ContentValues();
        if (aVar2 != null) {
            boolean z11 = true;
            if (!TextUtils.equals(h(aVar.f4012c), h(aVar2.f4012c))) {
                contentValues.put("name", aVar.f4012c);
                z10 = true;
            } else {
                z10 = false;
            }
            if (!X.a(aVar.f4011b, aVar2.f4011b)) {
                contentValues.put("lookup_uri", X.d(aVar.f4011b));
                z10 = true;
            }
            long j10 = aVar.f4017h;
            if (j10 != aVar2.f4017h) {
                contentValues.put("photo_id", Long.valueOf(j10));
            } else {
                z11 = z10;
            }
            if (C0846g.c()) {
                Log.d("ContactInfoCache", "updateCallLogContactInfoCache, updatedInfo.photoUri = " + aVar.f4018i + " ,callLogInfo.photoUri = " + aVar2.f4018i);
            }
            if (!X.a(aVar.f4018i, aVar2.f4018i)) {
                Uri uri = aVar.f4018i;
                if (uri != null) {
                    contentValues.put("transcription", uri.toString());
                } else {
                    contentValues.put("transcription", "");
                }
            } else if (!z11) {
                return;
            }
        } else {
            contentValues.put("name", aVar.f4012c);
            contentValues.put("lookup_uri", X.d(aVar.f4011b));
            contentValues.put("photo_id", Long.valueOf(aVar.f4017h));
        }
        try {
            this.f4033h.getContentResolver().update(CallLog.Calls.CONTENT_URI, contentValues, "number = ?", new String[]{str});
        } catch (Exception e10) {
            Log.e("ContactInfoCache", "e = " + e10);
        }
    }
}
