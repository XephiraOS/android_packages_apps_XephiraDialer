package x8;

import android.os.SystemClock;
import android.util.LruCache;
import java.util.LinkedList;
import java.util.Queue;
import y8.C1714f;
import y8.InterfaceC1715g;

/* compiled from: RequestFireWall.java */
/* renamed from: x8.f, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1693f {

    /* renamed from: a, reason: collision with root package name */
    public final int f38091a;

    /* renamed from: b, reason: collision with root package name */
    public final long f38092b;

    /* renamed from: c, reason: collision with root package name */
    public final LruCache<String, Queue<Long>> f38093c;

    /* compiled from: RequestFireWall.java */
    /* renamed from: x8.f$b */
    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f38094a;

        /* renamed from: b, reason: collision with root package name */
        public final long f38095b;

        public b(int i10, long j10) {
            this.f38094a = Math.max(i10, 0);
            this.f38095b = Math.max(j10, 0L);
        }

        public C1693f c() {
            return new C1693f(this);
        }
    }

    public final long b(Queue<Long> queue, long j10) {
        Long peek = queue.peek();
        while (peek != null && peek.longValue() < j10 - this.f38092b) {
            queue.poll();
            peek = queue.peek();
        }
        return queue.size();
    }

    public final Queue<Long> c(String str) {
        Queue<Long> queue = this.f38093c.get(str);
        if (queue == null) {
            LinkedList linkedList = new LinkedList();
            this.f38093c.put(str, linkedList);
            return linkedList;
        }
        return queue;
    }

    public boolean d(final String str) {
        boolean z10;
        Queue<Long> c10 = c(str);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        c10.add(Long.valueOf(elapsedRealtime));
        final long b10 = b(c10, elapsedRealtime);
        if (b10 <= this.f38091a) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10 && b10 % 10 == 1) {
            C1714f.f("FireWall", new InterfaceC1715g() { // from class: x8.e
                @Override // y8.InterfaceC1715g
                public final Object get() {
                    String e10;
                    e10 = C1693f.this.e(str, b10);
                    return e10;
                }
            });
        }
        return z10;
    }

    public final /* synthetic */ String e(String str, long j10) {
        return "Chatty!!! Allow " + this.f38091a + "/" + this.f38092b + "ms, but " + str + " request " + j10 + " in the recent period.";
    }

    public C1693f(b bVar) {
        this.f38091a = bVar.f38094a;
        this.f38092b = bVar.f38095b;
        this.f38093c = new LruCache<>(100);
    }
}
