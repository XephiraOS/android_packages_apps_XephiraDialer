package v0;

import android.content.Context;
import android.text.TextUtils;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import java.util.concurrent.ConcurrentHashMap;
import t0.d;

/* compiled from: SdnManager.java */
/* loaded from: classes.dex */
public class b implements d.b {

    /* renamed from: b, reason: collision with root package name */
    public static Context f37375b;

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f37374a = {BreenoCallContract.BaseColumns._ID, "name", "number"};

    /* renamed from: c, reason: collision with root package name */
    public static volatile b f37376c = null;

    /* renamed from: d, reason: collision with root package name */
    public static ConcurrentHashMap<Integer, ConcurrentHashMap<String, C1618a>> f37377d = new ConcurrentHashMap<>();

    public b(Context context) {
        f37375b = context;
        d c10 = d.c(context);
        if (c10 != null) {
            c10.f(this);
        }
    }

    public static b d(Context context) {
        Context applicationContext;
        if (context == null || (applicationContext = context.getApplicationContext()) == null) {
            return null;
        }
        if (f37376c == null) {
            synchronized (b.class) {
                try {
                    if (f37376c == null) {
                        f37376c = new b(applicationContext);
                    }
                } finally {
                }
            }
        }
        return f37376c;
    }

    @Override // t0.d.b
    public void a(String str, int i10) {
        if (TextUtils.equals(str, "ABSENT")) {
            c(i10);
        }
    }

    public boolean b(String str, int i10) {
        ConcurrentHashMap<String, C1618a> concurrentHashMap;
        int q10 = D7.c.q(f37375b, Integer.valueOf(i10));
        if (H7.a.b()) {
            H7.b.b("SdnManager", "checkIsSdnNumber slotID:" + q10 + " n:" + H7.a.d(str));
        }
        if (q10 == -1) {
            q10 = 0;
        }
        if (TextUtils.isEmpty(str) || (concurrentHashMap = f37377d.get(Integer.valueOf(q10))) == null) {
            return false;
        }
        C1618a c1618a = concurrentHashMap.get(str);
        if (H7.a.b()) {
            H7.b.b("SdnManager", "checkIsSdnNumber sdnEntry:" + c1618a);
        }
        if (c1618a == null) {
            return false;
        }
        return true;
    }

    public void c(int i10) {
        if (i10 == -1) {
            return;
        }
        f37377d.remove(Integer.valueOf(i10));
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x012c, code lost:
    
        if (f(r11, r12) != false) goto L59;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean e(java.lang.String r11, int r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 346
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v0.b.e(java.lang.String, int, boolean):boolean");
    }

    public final boolean f(String str, int i10) {
        ConcurrentHashMap<String, C1618a> concurrentHashMap;
        if (TextUtils.isEmpty(str) || (concurrentHashMap = f37377d.get(Integer.valueOf(i10))) == null || concurrentHashMap.remove(str) == null) {
            return false;
        }
        return true;
    }
}
