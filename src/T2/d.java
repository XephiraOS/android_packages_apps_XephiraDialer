package T2;

import android.os.SystemClock;
import android.text.TextUtils;
import com.android.volley.a;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: DiskBasedCache.java */
/* loaded from: classes.dex */
public class d implements com.android.volley.a {

    /* renamed from: a, reason: collision with root package name */
    public final Map<String, a> f3717a;

    /* renamed from: b, reason: collision with root package name */
    public long f3718b;

    /* renamed from: c, reason: collision with root package name */
    public final c f3719c;

    /* renamed from: d, reason: collision with root package name */
    public final int f3720d;

    /* compiled from: DiskBasedCache.java */
    /* loaded from: classes.dex */
    public interface c {
        File get();
    }

    public d(c cVar, int i10) {
        this.f3717a = new LinkedHashMap(16, 0.75f, true);
        this.f3718b = 0L;
        this.f3719c = cVar;
        this.f3720d = i10;
    }

    public static int l(InputStream inputStream) {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    public static List<S2.c> m(b bVar) {
        List<S2.c> arrayList;
        int n10 = n(bVar);
        if (n10 >= 0) {
            if (n10 == 0) {
                arrayList = Collections.emptyList();
            } else {
                arrayList = new ArrayList<>();
            }
            for (int i10 = 0; i10 < n10; i10++) {
                arrayList.add(new S2.c(p(bVar).intern(), p(bVar).intern()));
            }
            return arrayList;
        }
        throw new IOException("readHeaderList size=" + n10);
    }

    public static int n(InputStream inputStream) {
        return (l(inputStream) << 24) | l(inputStream) | (l(inputStream) << 8) | (l(inputStream) << 16);
    }

    public static long o(InputStream inputStream) {
        return (l(inputStream) & 255) | ((l(inputStream) & 255) << 8) | ((l(inputStream) & 255) << 16) | ((l(inputStream) & 255) << 24) | ((l(inputStream) & 255) << 32) | ((l(inputStream) & 255) << 40) | ((l(inputStream) & 255) << 48) | ((255 & l(inputStream)) << 56);
    }

    public static String p(b bVar) {
        return new String(s(bVar, o(bVar)), "UTF-8");
    }

    public static byte[] s(b bVar, long j10) {
        long a10 = bVar.a();
        if (j10 >= 0 && j10 <= a10) {
            int i10 = (int) j10;
            if (i10 == j10) {
                byte[] bArr = new byte[i10];
                new DataInputStream(bVar).readFully(bArr);
                return bArr;
            }
        }
        throw new IOException("streamToBytes length=" + j10 + ", maxLength=" + a10);
    }

    public static void t(List<S2.c> list, OutputStream outputStream) {
        if (list != null) {
            u(outputStream, list.size());
            for (S2.c cVar : list) {
                w(outputStream, cVar.a());
                w(outputStream, cVar.b());
            }
            return;
        }
        u(outputStream, 0);
    }

    public static void u(OutputStream outputStream, int i10) {
        outputStream.write(i10 & 255);
        outputStream.write((i10 >> 8) & 255);
        outputStream.write((i10 >> 16) & 255);
        outputStream.write((i10 >> 24) & 255);
    }

    public static void v(OutputStream outputStream, long j10) {
        outputStream.write((byte) j10);
        outputStream.write((byte) (j10 >>> 8));
        outputStream.write((byte) (j10 >>> 16));
        outputStream.write((byte) (j10 >>> 24));
        outputStream.write((byte) (j10 >>> 32));
        outputStream.write((byte) (j10 >>> 40));
        outputStream.write((byte) (j10 >>> 48));
        outputStream.write((byte) (j10 >>> 56));
    }

    public static void w(OutputStream outputStream, String str) {
        byte[] bytes = str.getBytes("UTF-8");
        v(outputStream, bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    @Override // com.android.volley.a
    public synchronized void a() {
        long length;
        b bVar;
        File file = this.f3719c.get();
        if (!file.exists()) {
            if (!file.mkdirs()) {
                com.android.volley.e.c("Unable to create cache dir %s", file.getAbsolutePath());
            }
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file2 : listFiles) {
            try {
                length = file2.length();
                bVar = new b(new BufferedInputStream(e(file2)), length);
            } catch (IOException unused) {
                file2.delete();
            }
            try {
                a b10 = a.b(bVar);
                b10.f3721a = length;
                k(b10.f3722b, b10);
                bVar.close();
            } catch (Throwable th) {
                bVar.close();
                throw th;
                break;
            }
        }
    }

    @Override // com.android.volley.a
    public synchronized void b(String str, boolean z10) {
        try {
            a.C0186a d10 = d(str);
            if (d10 != null) {
                d10.f19230f = 0L;
                if (z10) {
                    d10.f19229e = 0L;
                }
                c(str, d10);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.android.volley.a
    public synchronized void c(String str, a.C0186a c0186a) {
        BufferedOutputStream bufferedOutputStream;
        a aVar;
        long j10 = this.f3718b;
        byte[] bArr = c0186a.f19225a;
        long length = j10 + bArr.length;
        int i10 = this.f3720d;
        if (length > i10 && bArr.length > i10 * 0.9f) {
            return;
        }
        File g10 = g(str);
        try {
            bufferedOutputStream = new BufferedOutputStream(f(g10));
            aVar = new a(str, c0186a);
        } catch (IOException unused) {
            if (!g10.delete()) {
                com.android.volley.e.b("Could not clean up file %s", g10.getAbsolutePath());
            }
            i();
        }
        if (aVar.d(bufferedOutputStream)) {
            bufferedOutputStream.write(c0186a.f19225a);
            bufferedOutputStream.close();
            aVar.f3721a = g10.length();
            k(str, aVar);
            j();
            return;
        }
        bufferedOutputStream.close();
        com.android.volley.e.b("Failed to write header for %s", g10.getAbsolutePath());
        throw new IOException();
    }

    @Override // com.android.volley.a
    public synchronized a.C0186a d(String str) {
        a aVar = this.f3717a.get(str);
        if (aVar == null) {
            return null;
        }
        File g10 = g(str);
        try {
            b bVar = new b(new BufferedInputStream(e(g10)), g10.length());
            try {
                a b10 = a.b(bVar);
                if (!TextUtils.equals(str, b10.f3722b)) {
                    com.android.volley.e.b("%s: key=%s, found=%s", g10.getAbsolutePath(), str, b10.f3722b);
                    r(str);
                    return null;
                }
                return aVar.c(s(bVar, bVar.a()));
            } finally {
                bVar.close();
            }
        } catch (IOException e10) {
            com.android.volley.e.b("%s: %s", g10.getAbsolutePath(), e10.toString());
            q(str);
            return null;
        }
    }

    public InputStream e(File file) {
        return new FileInputStream(file);
    }

    public OutputStream f(File file) {
        return new FileOutputStream(file);
    }

    public File g(String str) {
        return new File(this.f3719c.get(), h(str));
    }

    public final String h(String str) {
        int length = str.length() / 2;
        return String.valueOf(str.substring(0, length).hashCode()) + String.valueOf(str.substring(length).hashCode());
    }

    public final void i() {
        if (!this.f3719c.get().exists()) {
            com.android.volley.e.b("Re-initializing cache after external clearing.", new Object[0]);
            this.f3717a.clear();
            this.f3718b = 0L;
            a();
        }
    }

    public final void j() {
        if (this.f3718b < this.f3720d) {
            return;
        }
        int i10 = 0;
        if (com.android.volley.e.f19252b) {
            com.android.volley.e.e("Pruning old cache entries.", new Object[0]);
        }
        long j10 = this.f3718b;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Iterator<Map.Entry<String, a>> it = this.f3717a.entrySet().iterator();
        while (it.hasNext()) {
            a value = it.next().getValue();
            if (g(value.f3722b).delete()) {
                this.f3718b -= value.f3721a;
            } else {
                String str = value.f3722b;
                com.android.volley.e.b("Could not delete cache entry for key=%s, filename=%s", str, h(str));
            }
            it.remove();
            i10++;
            if (((float) this.f3718b) < this.f3720d * 0.9f) {
                break;
            }
        }
        if (com.android.volley.e.f19252b) {
            com.android.volley.e.e("pruned %d files, %d bytes, %d ms", Integer.valueOf(i10), Long.valueOf(this.f3718b - j10), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
        }
    }

    public final void k(String str, a aVar) {
        if (!this.f3717a.containsKey(str)) {
            this.f3718b += aVar.f3721a;
        } else {
            this.f3718b += aVar.f3721a - this.f3717a.get(str).f3721a;
        }
        this.f3717a.put(str, aVar);
    }

    public synchronized void q(String str) {
        boolean delete = g(str).delete();
        r(str);
        if (!delete) {
            com.android.volley.e.b("Could not delete cache entry for key=%s, filename=%s", str, h(str));
        }
    }

    public final void r(String str) {
        a remove = this.f3717a.remove(str);
        if (remove != null) {
            this.f3718b -= remove.f3721a;
        }
    }

    /* compiled from: DiskBasedCache.java */
    /* loaded from: classes.dex */
    public static class b extends FilterInputStream {

        /* renamed from: a, reason: collision with root package name */
        public final long f3729a;

        /* renamed from: b, reason: collision with root package name */
        public long f3730b;

        public b(InputStream inputStream, long j10) {
            super(inputStream);
            this.f3729a = j10;
        }

        public long a() {
            return this.f3729a - this.f3730b;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() {
            int read = super.read();
            if (read != -1) {
                this.f3730b++;
            }
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i10, int i11) {
            int read = super.read(bArr, i10, i11);
            if (read != -1) {
                this.f3730b += read;
            }
            return read;
        }
    }

    public d(c cVar) {
        this(cVar, 5242880);
    }

    /* compiled from: DiskBasedCache.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public long f3721a;

        /* renamed from: b, reason: collision with root package name */
        public final String f3722b;

        /* renamed from: c, reason: collision with root package name */
        public final String f3723c;

        /* renamed from: d, reason: collision with root package name */
        public final long f3724d;

        /* renamed from: e, reason: collision with root package name */
        public final long f3725e;

        /* renamed from: f, reason: collision with root package name */
        public final long f3726f;

        /* renamed from: g, reason: collision with root package name */
        public final long f3727g;

        /* renamed from: h, reason: collision with root package name */
        public final List<S2.c> f3728h;

        public a(String str, String str2, long j10, long j11, long j12, long j13, List<S2.c> list) {
            this.f3722b = str;
            this.f3723c = "".equals(str2) ? null : str2;
            this.f3724d = j10;
            this.f3725e = j11;
            this.f3726f = j12;
            this.f3727g = j13;
            this.f3728h = list;
        }

        public static List<S2.c> a(a.C0186a c0186a) {
            List<S2.c> list = c0186a.f19232h;
            if (list != null) {
                return list;
            }
            return e.i(c0186a.f19231g);
        }

        public static a b(b bVar) {
            if (d.n(bVar) == 538247942) {
                return new a(d.p(bVar), d.p(bVar), d.o(bVar), d.o(bVar), d.o(bVar), d.o(bVar), d.m(bVar));
            }
            throw new IOException();
        }

        public a.C0186a c(byte[] bArr) {
            a.C0186a c0186a = new a.C0186a();
            c0186a.f19225a = bArr;
            c0186a.f19226b = this.f3723c;
            c0186a.f19227c = this.f3724d;
            c0186a.f19228d = this.f3725e;
            c0186a.f19229e = this.f3726f;
            c0186a.f19230f = this.f3727g;
            c0186a.f19231g = e.j(this.f3728h);
            c0186a.f19232h = Collections.unmodifiableList(this.f3728h);
            return c0186a;
        }

        public boolean d(OutputStream outputStream) {
            try {
                d.u(outputStream, 538247942);
                d.w(outputStream, this.f3722b);
                String str = this.f3723c;
                if (str == null) {
                    str = "";
                }
                d.w(outputStream, str);
                d.v(outputStream, this.f3724d);
                d.v(outputStream, this.f3725e);
                d.v(outputStream, this.f3726f);
                d.v(outputStream, this.f3727g);
                d.t(this.f3728h, outputStream);
                outputStream.flush();
                return true;
            } catch (IOException e10) {
                com.android.volley.e.b("%s", e10.toString());
                return false;
            }
        }

        public a(String str, a.C0186a c0186a) {
            this(str, c0186a.f19226b, c0186a.f19227c, c0186a.f19228d, c0186a.f19229e, c0186a.f19230f, a(c0186a));
        }
    }
}
