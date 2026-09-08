package androidx.databinding;

import java.util.ArrayList;
import java.util.List;

/* compiled from: CallbackRegistry.java */
/* loaded from: classes.dex */
public class c<C, T, A> implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public List<C> f9649a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public long f9650b = 0;

    /* renamed from: c, reason: collision with root package name */
    public long[] f9651c;

    /* renamed from: d, reason: collision with root package name */
    public int f9652d;

    /* renamed from: e, reason: collision with root package name */
    public final a<C, T, A> f9653e;

    /* compiled from: CallbackRegistry.java */
    /* loaded from: classes.dex */
    public static abstract class a<C, T, A> {
        public abstract void a(C c10, T t10, int i10, A a10);
    }

    public c(a<C, T, A> aVar) {
        this.f9653e = aVar;
    }

    public synchronized void a(C c10) {
        try {
            if (c10 != null) {
                int lastIndexOf = this.f9649a.lastIndexOf(c10);
                if (lastIndexOf >= 0) {
                    if (c(lastIndexOf)) {
                    }
                }
                this.f9649a.add(c10);
            } else {
                throw new IllegalArgumentException("callback cannot be null");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public synchronized c<C, T, A> clone() {
        c<C, T, A> cVar;
        CloneNotSupportedException e10;
        try {
            cVar = (c) super.clone();
        } catch (CloneNotSupportedException e11) {
            cVar = null;
            e10 = e11;
        }
        try {
            cVar.f9650b = 0L;
            cVar.f9651c = null;
            cVar.f9652d = 0;
            cVar.f9649a = new ArrayList();
            int size = this.f9649a.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (!c(i10)) {
                    cVar.f9649a.add(this.f9649a.get(i10));
                }
            }
        } catch (CloneNotSupportedException e12) {
            e10 = e12;
            e10.printStackTrace();
            return cVar;
        }
        return cVar;
    }

    public final boolean c(int i10) {
        int i11;
        if (i10 < 64) {
            if ((this.f9650b & (1 << i10)) != 0) {
                return true;
            }
            return false;
        }
        long[] jArr = this.f9651c;
        if (jArr == null || (i11 = (i10 / 64) - 1) >= jArr.length) {
            return false;
        }
        if (((1 << (i10 % 64)) & jArr[i11]) != 0) {
            return true;
        }
        return false;
    }

    public synchronized void d(T t10, int i10, A a10) {
        try {
            this.f9652d++;
            g(t10, i10, a10);
            int i11 = this.f9652d - 1;
            this.f9652d = i11;
            if (i11 == 0) {
                long[] jArr = this.f9651c;
                if (jArr != null) {
                    for (int length = jArr.length - 1; length >= 0; length--) {
                        long j10 = this.f9651c[length];
                        if (j10 != 0) {
                            j((length + 1) * 64, j10);
                            this.f9651c[length] = 0;
                        }
                    }
                }
                long j11 = this.f9650b;
                if (j11 != 0) {
                    j(0, j11);
                    this.f9650b = 0L;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void e(T t10, int i10, A a10, int i11, int i12, long j10) {
        long j11 = 1;
        while (i11 < i12) {
            if ((j10 & j11) == 0) {
                this.f9653e.a(this.f9649a.get(i11), t10, i10, a10);
            }
            j11 <<= 1;
            i11++;
        }
    }

    public final void f(T t10, int i10, A a10) {
        e(t10, i10, a10, 0, Math.min(64, this.f9649a.size()), this.f9650b);
    }

    public final void g(T t10, int i10, A a10) {
        int length;
        int size = this.f9649a.size();
        long[] jArr = this.f9651c;
        if (jArr == null) {
            length = -1;
        } else {
            length = jArr.length - 1;
        }
        h(t10, i10, a10, length);
        e(t10, i10, a10, (length + 2) * 64, size, 0L);
    }

    public final void h(T t10, int i10, A a10, int i11) {
        if (i11 < 0) {
            f(t10, i10, a10);
            return;
        }
        long j10 = this.f9651c[i11];
        int i12 = (i11 + 1) * 64;
        int min = Math.min(this.f9649a.size(), i12 + 64);
        h(t10, i10, a10, i11 - 1);
        e(t10, i10, a10, i12, min, j10);
    }

    public synchronized void i(C c10) {
        try {
            if (this.f9652d == 0) {
                this.f9649a.remove(c10);
            } else {
                int lastIndexOf = this.f9649a.lastIndexOf(c10);
                if (lastIndexOf >= 0) {
                    k(lastIndexOf);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void j(int i10, long j10) {
        long j11 = Long.MIN_VALUE;
        for (int i11 = i10 + 63; i11 >= i10; i11--) {
            if ((j10 & j11) != 0) {
                this.f9649a.remove(i11);
            }
            j11 >>>= 1;
        }
    }

    public final void k(int i10) {
        if (i10 < 64) {
            this.f9650b = (1 << i10) | this.f9650b;
            return;
        }
        int i11 = (i10 / 64) - 1;
        long[] jArr = this.f9651c;
        if (jArr == null) {
            this.f9651c = new long[this.f9649a.size() / 64];
        } else if (jArr.length <= i11) {
            long[] jArr2 = new long[this.f9649a.size() / 64];
            long[] jArr3 = this.f9651c;
            System.arraycopy(jArr3, 0, jArr2, 0, jArr3.length);
            this.f9651c = jArr2;
        }
        long[] jArr4 = this.f9651c;
        jArr4[i11] = (1 << (i10 % 64)) | jArr4[i11];
    }
}
