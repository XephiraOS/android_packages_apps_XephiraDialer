package kotlinx.coroutines.flow.internal;

import java.util.Arrays;
import kotlin.Result;
import kotlinx.coroutines.flow.internal.c;
import m9.q;

/* compiled from: AbstractSharedFlow.kt */
/* loaded from: classes4.dex */
public abstract class a<S extends c<?>> {

    /* renamed from: a, reason: collision with root package name */
    public S[] f34455a;

    /* renamed from: b, reason: collision with root package name */
    public int f34456b;

    /* renamed from: c, reason: collision with root package name */
    public int f34457c;

    public final S b() {
        S s10;
        synchronized (this) {
            try {
                S[] sArr = this.f34455a;
                if (sArr == null) {
                    sArr = e(2);
                    this.f34455a = sArr;
                } else if (this.f34456b >= sArr.length) {
                    Object[] copyOf = Arrays.copyOf(sArr, sArr.length * 2);
                    kotlin.jvm.internal.i.e(copyOf, "copyOf(this, newSize)");
                    this.f34455a = (S[]) ((c[]) copyOf);
                    sArr = (S[]) ((c[]) copyOf);
                }
                int i10 = this.f34457c;
                do {
                    s10 = sArr[i10];
                    if (s10 == null) {
                        s10 = d();
                        sArr[i10] = s10;
                    }
                    i10++;
                    if (i10 >= sArr.length) {
                        i10 = 0;
                    }
                    kotlin.jvm.internal.i.d(s10, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                } while (!s10.a(this));
                this.f34457c = i10;
                this.f34456b++;
            } catch (Throwable th) {
                throw th;
            }
        }
        return s10;
    }

    public abstract S d();

    public abstract S[] e(int i10);

    public final void f(S s10) {
        int i10;
        kotlin.coroutines.c<q>[] b10;
        synchronized (this) {
            try {
                int i11 = this.f34456b - 1;
                this.f34456b = i11;
                if (i11 == 0) {
                    this.f34457c = 0;
                }
                kotlin.jvm.internal.i.d(s10, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                b10 = s10.b(this);
            } catch (Throwable th) {
                throw th;
            }
        }
        for (kotlin.coroutines.c<q> cVar : b10) {
            if (cVar != null) {
                Result.a aVar = Result.f34166a;
                cVar.resumeWith(Result.b(q.f35511a));
            }
        }
    }

    public final S[] g() {
        return this.f34455a;
    }
}
