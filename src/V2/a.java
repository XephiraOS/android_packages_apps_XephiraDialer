package V2;

import android.os.StrictMode;
import com.android.incallui.OplusPhoneUtils;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: DiskLruCache.java */
/* loaded from: classes.dex */
public final class a implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public final File f3965a;

    /* renamed from: b, reason: collision with root package name */
    public final File f3966b;

    /* renamed from: c, reason: collision with root package name */
    public final File f3967c;

    /* renamed from: d, reason: collision with root package name */
    public final File f3968d;

    /* renamed from: e, reason: collision with root package name */
    public final int f3969e;

    /* renamed from: f, reason: collision with root package name */
    public long f3970f;

    /* renamed from: g, reason: collision with root package name */
    public final int f3971g;

    /* renamed from: i, reason: collision with root package name */
    public Writer f3973i;

    /* renamed from: k, reason: collision with root package name */
    public int f3975k;

    /* renamed from: h, reason: collision with root package name */
    public long f3972h = 0;

    /* renamed from: j, reason: collision with root package name */
    public final LinkedHashMap<String, d> f3974j = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: l, reason: collision with root package name */
    public long f3976l = 0;

    /* renamed from: m, reason: collision with root package name */
    public final ThreadPoolExecutor f3977m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b(null));

    /* renamed from: n, reason: collision with root package name */
    public final Callable<Void> f3978n = new CallableC0075a();

    /* compiled from: DiskLruCache.java */
    /* renamed from: V2.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class CallableC0075a implements Callable<Void> {
        public CallableC0075a() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            synchronized (a.this) {
                try {
                    if (a.this.f3973i != null) {
                        a.this.g0();
                        if (a.this.T()) {
                            a.this.a0();
                            a.this.f3975k = 0;
                        }
                        return null;
                    }
                    return null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* compiled from: DiskLruCache.java */
    /* loaded from: classes.dex */
    public static final class b implements ThreadFactory {
        public b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }

        public /* synthetic */ b(CallableC0075a callableC0075a) {
            this();
        }
    }

    /* compiled from: DiskLruCache.java */
    /* loaded from: classes.dex */
    public final class c {

        /* renamed from: a, reason: collision with root package name */
        public final d f3980a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean[] f3981b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f3982c;

        public /* synthetic */ c(a aVar, d dVar, CallableC0075a callableC0075a) {
            this(dVar);
        }

        public void a() {
            a.this.y(this, false);
        }

        public void b() {
            if (!this.f3982c) {
                try {
                    a();
                } catch (IOException unused) {
                }
            }
        }

        public void e() {
            a.this.y(this, true);
            this.f3982c = true;
        }

        public File f(int i10) {
            File k10;
            synchronized (a.this) {
                try {
                    if (this.f3980a.f3989f == this) {
                        if (!this.f3980a.f3988e) {
                            this.f3981b[i10] = true;
                        }
                        k10 = this.f3980a.k(i10);
                        a.this.f3965a.mkdirs();
                    } else {
                        throw new IllegalStateException();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return k10;
        }

        public c(d dVar) {
            this.f3980a = dVar;
            this.f3981b = dVar.f3988e ? null : new boolean[a.this.f3971g];
        }
    }

    /* compiled from: DiskLruCache.java */
    /* loaded from: classes.dex */
    public final class d {

        /* renamed from: a, reason: collision with root package name */
        public final String f3984a;

        /* renamed from: b, reason: collision with root package name */
        public final long[] f3985b;

        /* renamed from: c, reason: collision with root package name */
        public File[] f3986c;

        /* renamed from: d, reason: collision with root package name */
        public File[] f3987d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f3988e;

        /* renamed from: f, reason: collision with root package name */
        public c f3989f;

        /* renamed from: g, reason: collision with root package name */
        public long f3990g;

        public /* synthetic */ d(a aVar, String str, CallableC0075a callableC0075a) {
            this(str);
        }

        public File j(int i10) {
            return this.f3986c[i10];
        }

        public File k(int i10) {
            return this.f3987d[i10];
        }

        public String l() {
            StringBuilder sb = new StringBuilder();
            for (long j10 : this.f3985b) {
                sb.append(' ');
                sb.append(j10);
            }
            return sb.toString();
        }

        public final IOException m(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public final void n(String[] strArr) {
            if (strArr.length == a.this.f3971g) {
                for (int i10 = 0; i10 < strArr.length; i10++) {
                    try {
                        this.f3985b[i10] = Long.parseLong(strArr[i10]);
                    } catch (NumberFormatException unused) {
                        throw m(strArr);
                    }
                }
                return;
            }
            throw m(strArr);
        }

        public d(String str) {
            this.f3984a = str;
            this.f3985b = new long[a.this.f3971g];
            this.f3986c = new File[a.this.f3971g];
            this.f3987d = new File[a.this.f3971g];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i10 = 0; i10 < a.this.f3971g; i10++) {
                sb.append(i10);
                this.f3986c[i10] = new File(a.this.f3965a, sb.toString());
                sb.append(".tmp");
                this.f3987d[i10] = new File(a.this.f3965a, sb.toString());
                sb.setLength(length);
            }
        }
    }

    /* compiled from: DiskLruCache.java */
    /* loaded from: classes.dex */
    public final class e {

        /* renamed from: a, reason: collision with root package name */
        public final String f3992a;

        /* renamed from: b, reason: collision with root package name */
        public final long f3993b;

        /* renamed from: c, reason: collision with root package name */
        public final long[] f3994c;

        /* renamed from: d, reason: collision with root package name */
        public final File[] f3995d;

        public /* synthetic */ e(a aVar, String str, long j10, File[] fileArr, long[] jArr, CallableC0075a callableC0075a) {
            this(str, j10, fileArr, jArr);
        }

        public File a(int i10) {
            return this.f3995d[i10];
        }

        public e(String str, long j10, File[] fileArr, long[] jArr) {
            this.f3992a = str;
            this.f3993b = j10;
            this.f3995d = fileArr;
            this.f3994c = jArr;
        }
    }

    public a(File file, int i10, int i11, long j10) {
        this.f3965a = file;
        this.f3969e = i10;
        this.f3966b = new File(file, "journal");
        this.f3967c = new File(file, "journal.tmp");
        this.f3968d = new File(file, "journal.bkp");
        this.f3971g = i11;
        this.f3970f = j10;
    }

    public static void G(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public static void O(Writer writer) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public static a U(File file, int i10, int i11, long j10) {
        if (j10 > 0) {
            if (i11 > 0) {
                File file2 = new File(file, "journal.bkp");
                if (file2.exists()) {
                    File file3 = new File(file, "journal");
                    if (file3.exists()) {
                        file2.delete();
                    } else {
                        f0(file2, file3, false);
                    }
                }
                a aVar = new a(file, i10, i11, j10);
                if (aVar.f3966b.exists()) {
                    try {
                        aVar.X();
                        aVar.V();
                        return aVar;
                    } catch (IOException e10) {
                        System.out.println("DiskLruCache " + file + " is corrupt: " + e10.getMessage() + ", removing");
                        aVar.B();
                    }
                }
                file.mkdirs();
                a aVar2 = new a(file, i10, i11, j10);
                aVar2.a0();
                return aVar2;
            }
            throw new IllegalArgumentException("valueCount <= 0");
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public static void f0(File file, File file2, boolean z10) {
        if (z10) {
            G(file2);
        }
        if (file.renameTo(file2)) {
        } else {
            throw new IOException();
        }
    }

    public static void u(Writer writer) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public void B() {
        close();
        V2.c.b(this.f3965a);
    }

    public c I(String str) {
        return L(str, -1L);
    }

    public final synchronized c L(String str, long j10) {
        s();
        d dVar = this.f3974j.get(str);
        CallableC0075a callableC0075a = null;
        if (j10 != -1 && (dVar == null || dVar.f3990g != j10)) {
            return null;
        }
        if (dVar == null) {
            dVar = new d(this, str, callableC0075a);
            this.f3974j.put(str, dVar);
        } else if (dVar.f3989f != null) {
            return null;
        }
        c cVar = new c(this, dVar, callableC0075a);
        dVar.f3989f = cVar;
        this.f3973i.append((CharSequence) "DIRTY");
        this.f3973i.append(' ');
        this.f3973i.append((CharSequence) str);
        this.f3973i.append('\n');
        O(this.f3973i);
        return cVar;
    }

    public synchronized e S(String str) {
        s();
        d dVar = this.f3974j.get(str);
        if (dVar == null) {
            return null;
        }
        if (!dVar.f3988e) {
            return null;
        }
        for (File file : dVar.f3986c) {
            if (!file.exists()) {
                return null;
            }
        }
        this.f3975k++;
        this.f3973i.append((CharSequence) "READ");
        this.f3973i.append(' ');
        this.f3973i.append((CharSequence) str);
        this.f3973i.append('\n');
        if (T()) {
            this.f3977m.submit(this.f3978n);
        }
        return new e(this, str, dVar.f3990g, dVar.f3986c, dVar.f3985b, null);
    }

    public final boolean T() {
        int i10 = this.f3975k;
        if (i10 >= 2000 && i10 >= this.f3974j.size()) {
            return true;
        }
        return false;
    }

    public final void V() {
        G(this.f3967c);
        Iterator<d> it = this.f3974j.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            int i10 = 0;
            if (next.f3989f != null) {
                next.f3989f = null;
                while (i10 < this.f3971g) {
                    G(next.j(i10));
                    G(next.k(i10));
                    i10++;
                }
                it.remove();
            } else {
                while (i10 < this.f3971g) {
                    this.f3972h += next.f3985b[i10];
                    i10++;
                }
            }
        }
    }

    public final void X() {
        V2.b bVar = new V2.b(new FileInputStream(this.f3966b), V2.c.f4003a);
        try {
            String f10 = bVar.f();
            String f11 = bVar.f();
            String f12 = bVar.f();
            String f13 = bVar.f();
            String f14 = bVar.f();
            if ("libcore.io.DiskLruCache".equals(f10) && OplusPhoneUtils.DeviceState.LOCK_DEVICE.equals(f11) && Integer.toString(this.f3969e).equals(f12) && Integer.toString(this.f3971g).equals(f13) && "".equals(f14)) {
                int i10 = 0;
                while (true) {
                    try {
                        Z(bVar.f());
                        i10++;
                    } catch (EOFException unused) {
                        this.f3975k = i10 - this.f3974j.size();
                        if (bVar.e()) {
                            a0();
                        } else {
                            this.f3973i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f3966b, true), V2.c.f4003a));
                        }
                        V2.c.a(bVar);
                        return;
                    }
                }
            } else {
                throw new IOException("unexpected journal header: [" + f10 + ", " + f11 + ", " + f13 + ", " + f14 + "]");
            }
        } catch (Throwable th) {
            V2.c.a(bVar);
            throw th;
        }
    }

    public final void Z(String str) {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i10 = indexOf + 1;
            int indexOf2 = str.indexOf(32, i10);
            if (indexOf2 == -1) {
                substring = str.substring(i10);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.f3974j.remove(substring);
                    return;
                }
            } else {
                substring = str.substring(i10, indexOf2);
            }
            d dVar = this.f3974j.get(substring);
            CallableC0075a callableC0075a = null;
            if (dVar == null) {
                dVar = new d(this, substring, callableC0075a);
                this.f3974j.put(substring, dVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                dVar.f3988e = true;
                dVar.f3989f = null;
                dVar.n(split);
                return;
            }
            if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                dVar.f3989f = new c(this, dVar, callableC0075a);
                return;
            }
            if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
                return;
            }
            throw new IOException("unexpected journal line: " + str);
        }
        throw new IOException("unexpected journal line: " + str);
    }

    public final synchronized void a0() {
        try {
            Writer writer = this.f3973i;
            if (writer != null) {
                u(writer);
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f3967c), V2.c.f4003a));
            try {
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write("\n");
                bufferedWriter.write(OplusPhoneUtils.DeviceState.LOCK_DEVICE);
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.f3969e));
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.f3971g));
                bufferedWriter.write("\n");
                bufferedWriter.write("\n");
                for (d dVar : this.f3974j.values()) {
                    if (dVar.f3989f != null) {
                        bufferedWriter.write("DIRTY " + dVar.f3984a + '\n');
                    } else {
                        bufferedWriter.write("CLEAN " + dVar.f3984a + dVar.l() + '\n');
                    }
                }
                u(bufferedWriter);
                if (this.f3966b.exists()) {
                    f0(this.f3966b, this.f3968d, true);
                }
                f0(this.f3967c, this.f3966b, false);
                this.f3968d.delete();
                this.f3973i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f3966b, true), V2.c.f4003a));
            } catch (Throwable th) {
                u(bufferedWriter);
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized boolean c0(String str) {
        try {
            s();
            d dVar = this.f3974j.get(str);
            if (dVar != null && dVar.f3989f == null) {
                for (int i10 = 0; i10 < this.f3971g; i10++) {
                    File j10 = dVar.j(i10);
                    if (j10.exists() && !j10.delete()) {
                        throw new IOException("failed to delete " + j10);
                    }
                    this.f3972h -= dVar.f3985b[i10];
                    dVar.f3985b[i10] = 0;
                }
                this.f3975k++;
                this.f3973i.append((CharSequence) "REMOVE");
                this.f3973i.append(' ');
                this.f3973i.append((CharSequence) str);
                this.f3973i.append('\n');
                this.f3974j.remove(str);
                if (T()) {
                    this.f3977m.submit(this.f3978n);
                }
                return true;
            }
            return false;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        try {
            if (this.f3973i == null) {
                return;
            }
            Iterator it = new ArrayList(this.f3974j.values()).iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar.f3989f != null) {
                    dVar.f3989f.a();
                }
            }
            g0();
            u(this.f3973i);
            this.f3973i = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void g0() {
        while (this.f3972h > this.f3970f) {
            c0(this.f3974j.entrySet().iterator().next().getKey());
        }
    }

    public final void s() {
        if (this.f3973i != null) {
        } else {
            throw new IllegalStateException("cache is closed");
        }
    }

    public final synchronized void y(c cVar, boolean z10) {
        d dVar = cVar.f3980a;
        if (dVar.f3989f == cVar) {
            if (z10 && !dVar.f3988e) {
                for (int i10 = 0; i10 < this.f3971g; i10++) {
                    if (cVar.f3981b[i10]) {
                        if (!dVar.k(i10).exists()) {
                            cVar.a();
                            return;
                        }
                    } else {
                        cVar.a();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i10);
                    }
                }
            }
            for (int i11 = 0; i11 < this.f3971g; i11++) {
                File k10 = dVar.k(i11);
                if (z10) {
                    if (k10.exists()) {
                        File j10 = dVar.j(i11);
                        k10.renameTo(j10);
                        long j11 = dVar.f3985b[i11];
                        long length = j10.length();
                        dVar.f3985b[i11] = length;
                        this.f3972h = (this.f3972h - j11) + length;
                    }
                } else {
                    G(k10);
                }
            }
            this.f3975k++;
            dVar.f3989f = null;
            if (dVar.f3988e | z10) {
                dVar.f3988e = true;
                this.f3973i.append((CharSequence) "CLEAN");
                this.f3973i.append(' ');
                this.f3973i.append((CharSequence) dVar.f3984a);
                this.f3973i.append((CharSequence) dVar.l());
                this.f3973i.append('\n');
                if (z10) {
                    long j12 = this.f3976l;
                    this.f3976l = 1 + j12;
                    dVar.f3990g = j12;
                }
            } else {
                this.f3974j.remove(dVar.f3984a);
                this.f3973i.append((CharSequence) "REMOVE");
                this.f3973i.append(' ');
                this.f3973i.append((CharSequence) dVar.f3984a);
                this.f3973i.append('\n');
            }
            O(this.f3973i);
            if (this.f3972h > this.f3970f || T()) {
                this.f3977m.submit(this.f3978n);
            }
            return;
        }
        throw new IllegalStateException();
    }
}
