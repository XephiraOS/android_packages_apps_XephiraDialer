package F5;

import android.os.IBinder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Dispatcher.java */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: c, reason: collision with root package name */
    public static volatile b f994c;

    /* renamed from: a, reason: collision with root package name */
    public Map<String, IBinder> f995a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    public Map<String, List<String>> f996b = new ConcurrentHashMap();

    public static b c() {
        if (f994c == null) {
            synchronized (b.class) {
                try {
                    if (f994c == null) {
                        f994c = new b();
                    }
                } finally {
                }
            }
        }
        return f994c;
    }

    public IBinder b(String str) {
        return this.f995a.get(str);
    }

    public final /* synthetic */ void d(String str) {
        this.f995a.remove(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0032, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
    
        if (r5.f995a.containsKey(r6) != false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0033, code lost:
    
        H5.a.b("Dispatcher", "registerRemoteTransfer: registerSuccess:" + r1, new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0049, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean e(final java.lang.String r6, android.os.IBinder r7, java.lang.String r8) {
        /*
            r5 = this;
            java.lang.String r0 = "Dispatcher"
            r1 = 1
            r2 = 0
            F5.a r3 = new F5.a     // Catch: java.lang.Throwable -> L1d android.os.RemoteException -> L1f
            r3.<init>()     // Catch: java.lang.Throwable -> L1d android.os.RemoteException -> L1f
            r7.linkToDeath(r3, r2)     // Catch: java.lang.Throwable -> L1d android.os.RemoteException -> L1f
            java.util.Map<java.lang.String, android.os.IBinder> r3 = r5.f995a
            boolean r3 = r3.containsKey(r6)
            if (r3 != 0) goto L32
        L14:
            java.util.Map<java.lang.String, android.os.IBinder> r3 = r5.f995a
            r3.put(r6, r7)
            r5.g(r6, r8)
            goto L33
        L1d:
            r0 = move-exception
            goto L4a
        L1f:
            r3 = move-exception
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L1d
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L1d
            H5.a.f(r0, r3, r4)     // Catch: java.lang.Throwable -> L1d
            java.util.Map<java.lang.String, android.os.IBinder> r3 = r5.f995a
            boolean r3 = r3.containsKey(r6)
            if (r3 != 0) goto L32
            goto L14
        L32:
            r1 = r2
        L33:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "registerRemoteTransfer: registerSuccess:"
            r5.append(r6)
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r6 = new java.lang.Object[r2]
            H5.a.b(r0, r5, r6)
            return r1
        L4a:
            java.util.Map<java.lang.String, android.os.IBinder> r1 = r5.f995a
            boolean r1 = r1.containsKey(r6)
            if (r1 != 0) goto L5a
            java.util.Map<java.lang.String, android.os.IBinder> r1 = r5.f995a
            r1.put(r6, r7)
            r5.g(r6, r8)
        L5a:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: F5.b.e(java.lang.String, android.os.IBinder, java.lang.String):boolean");
    }

    public String f() {
        return this.f996b.toString();
    }

    public final void g(String str, String str2) {
        List<String> list = this.f996b.get(str2);
        if (list == null) {
            list = new ArrayList<>();
            this.f996b.put(str2, list);
        }
        list.add(str);
    }
}
