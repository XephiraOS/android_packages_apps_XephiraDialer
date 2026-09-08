package c0;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: CopyLock.java */
/* renamed from: c0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0545a {

    /* renamed from: e, reason: collision with root package name */
    public static final Map<String, Lock> f12680e = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public final File f12681a;

    /* renamed from: b, reason: collision with root package name */
    public final Lock f12682b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f12683c;

    /* renamed from: d, reason: collision with root package name */
    public FileChannel f12684d;

    public C0545a(String str, File file, boolean z10) {
        File file2 = new File(file, str + ".lck");
        this.f12681a = file2;
        this.f12682b = a(file2.getAbsolutePath());
        this.f12683c = z10;
    }

    public static Lock a(String str) {
        Lock lock;
        Map<String, Lock> map = f12680e;
        synchronized (map) {
            try {
                lock = map.get(str);
                if (lock == null) {
                    lock = new ReentrantLock();
                    map.put(str, lock);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return lock;
    }

    public void b() {
        this.f12682b.lock();
        if (this.f12683c) {
            try {
                FileChannel channel = new FileOutputStream(this.f12681a).getChannel();
                this.f12684d = channel;
                channel.lock();
            } catch (IOException e10) {
                throw new IllegalStateException("Unable to grab copy lock.", e10);
            }
        }
    }

    public void c() {
        FileChannel fileChannel = this.f12684d;
        if (fileChannel != null) {
            try {
                fileChannel.close();
            } catch (IOException unused) {
            }
        }
        this.f12682b.unlock();
    }
}
