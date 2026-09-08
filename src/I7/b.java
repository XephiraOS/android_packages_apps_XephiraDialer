package i7;

import android.os.IBinder;
import com.oplus.utils.C0864z;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Dispatcher.java */
/* loaded from: classes3.dex */
public class b implements com.oplus.epona.b {

    /* renamed from: c, reason: collision with root package name */
    public static volatile b f32196c;

    /* renamed from: a, reason: collision with root package name */
    public final Map<String, IBinder> f32197a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    public final Map<String, List<String>> f32198b = new ConcurrentHashMap();

    public static b e() {
        if (f32196c == null) {
            synchronized (b.class) {
                try {
                    if (f32196c == null) {
                        f32196c = new b();
                    }
                } finally {
                }
            }
        }
        return f32196c;
    }

    @Override // com.oplus.epona.b
    public void a(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.println("--- dump package register components info ---");
        for (Map.Entry<String, List<String>> entry : this.f32198b.entrySet()) {
            String key = entry.getKey();
            if (key != null) {
                printWriter.println(key);
                h(printWriter, entry.getValue());
            }
        }
        printWriter.println("------------------- end ---------------------");
    }

    @Override // com.oplus.epona.b
    public String b() {
        return "oplus_epona";
    }

    public IBinder d(String str) {
        return this.f32197a.get(str);
    }

    public final boolean f(String str) {
        if (str != null && !str.isEmpty()) {
            return true;
        }
        return false;
    }

    public final /* synthetic */ void g(String str, String str2) {
        k(str, str2);
        C0864z.d("Epona->Dispatcher", "unregister cached binder: " + str, new Object[0]);
    }

    public final void h(PrintWriter printWriter, List<String> list) {
        if (list == null) {
            return;
        }
        for (String str : list) {
            if (f(str)) {
                printWriter.println("    -> " + str);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0032, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
    
        if (r5.f32197a.containsKey(r6) != false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0033, code lost:
    
        com.oplus.utils.C0864z.c("Epona->Dispatcher", "register RemoteTransfer Success: " + r1, new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0049, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean i(final java.lang.String r6, android.os.IBinder r7, final java.lang.String r8) {
        /*
            r5 = this;
            java.lang.String r0 = "Epona->Dispatcher"
            r1 = 1
            r2 = 0
            i7.a r3 = new i7.a     // Catch: java.lang.Throwable -> L1d android.os.RemoteException -> L1f
            r3.<init>()     // Catch: java.lang.Throwable -> L1d android.os.RemoteException -> L1f
            r7.linkToDeath(r3, r2)     // Catch: java.lang.Throwable -> L1d android.os.RemoteException -> L1f
            java.util.Map<java.lang.String, android.os.IBinder> r3 = r5.f32197a
            boolean r3 = r3.containsKey(r6)
            if (r3 != 0) goto L32
        L14:
            java.util.Map<java.lang.String, android.os.IBinder> r3 = r5.f32197a
            r3.put(r6, r7)
            r5.m(r6, r8)
            goto L33
        L1d:
            r0 = move-exception
            goto L4a
        L1f:
            r3 = move-exception
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L1d
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L1d
            com.oplus.utils.C0864z.i(r0, r3, r4)     // Catch: java.lang.Throwable -> L1d
            java.util.Map<java.lang.String, android.os.IBinder> r3 = r5.f32197a
            boolean r3 = r3.containsKey(r6)
            if (r3 != 0) goto L32
            goto L14
        L32:
            r1 = r2
        L33:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "register RemoteTransfer Success: "
            r5.append(r6)
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r6 = new java.lang.Object[r2]
            com.oplus.utils.C0864z.c(r0, r5, r6)
            return r1
        L4a:
            java.util.Map<java.lang.String, android.os.IBinder> r1 = r5.f32197a
            boolean r1 = r1.containsKey(r6)
            if (r1 != 0) goto L5a
            java.util.Map<java.lang.String, android.os.IBinder> r1 = r5.f32197a
            r1.put(r6, r7)
            r5.m(r6, r8)
        L5a:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: i7.b.i(java.lang.String, android.os.IBinder, java.lang.String):boolean");
    }

    public final void j(String str, String str2) {
        List<String> list = this.f32198b.get(str2);
        if (list != null) {
            list.remove(str);
        }
    }

    public final void k(String str, String str2) {
        this.f32197a.remove(str);
        this.f32198b.remove(str2);
    }

    public boolean l(String str, String str2) {
        boolean z10;
        if (this.f32197a.containsKey(str)) {
            this.f32197a.remove(str);
            j(str, str2);
            z10 = true;
        } else {
            z10 = false;
        }
        C0864z.c("Epona->Dispatcher", "packageName:" + str2 + "unRegister RemoteTransfer component:" + str + "unRegister Success:" + z10, new Object[0]);
        return z10;
    }

    public final void m(String str, String str2) {
        List<String> list = this.f32198b.get(str2);
        if (list == null) {
            list = new ArrayList<>();
            this.f32198b.put(str2, list);
        }
        list.add(str);
    }
}
