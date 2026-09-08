package kotlinx.coroutines;

/* compiled from: CancellableContinuationImpl.kt */
/* renamed from: kotlinx.coroutines.w, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1281w {

    /* renamed from: a, reason: collision with root package name */
    public final Object f34644a;

    /* renamed from: b, reason: collision with root package name */
    public final AbstractC1262k f34645b;

    /* renamed from: c, reason: collision with root package name */
    public final v9.l<Throwable, m9.q> f34646c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f34647d;

    /* renamed from: e, reason: collision with root package name */
    public final Throwable f34648e;

    /* JADX WARN: Multi-variable type inference failed */
    public C1281w(Object obj, AbstractC1262k abstractC1262k, v9.l<? super Throwable, m9.q> lVar, Object obj2, Throwable th) {
        this.f34644a = obj;
        this.f34645b = abstractC1262k;
        this.f34646c = lVar;
        this.f34647d = obj2;
        this.f34648e = th;
    }

    public static /* synthetic */ C1281w b(C1281w c1281w, Object obj, AbstractC1262k abstractC1262k, v9.l lVar, Object obj2, Throwable th, int i10, Object obj3) {
        if ((i10 & 1) != 0) {
            obj = c1281w.f34644a;
        }
        if ((i10 & 2) != 0) {
            abstractC1262k = c1281w.f34645b;
        }
        AbstractC1262k abstractC1262k2 = abstractC1262k;
        if ((i10 & 4) != 0) {
            lVar = c1281w.f34646c;
        }
        v9.l lVar2 = lVar;
        if ((i10 & 8) != 0) {
            obj2 = c1281w.f34647d;
        }
        Object obj4 = obj2;
        if ((i10 & 16) != 0) {
            th = c1281w.f34648e;
        }
        return c1281w.a(obj, abstractC1262k2, lVar2, obj4, th);
    }

    public final C1281w a(Object obj, AbstractC1262k abstractC1262k, v9.l<? super Throwable, m9.q> lVar, Object obj2, Throwable th) {
        return new C1281w(obj, abstractC1262k, lVar, obj2, th);
    }

    public final boolean c() {
        if (this.f34648e != null) {
            return true;
        }
        return false;
    }

    public final void d(C1268n<?> c1268n, Throwable th) {
        AbstractC1262k abstractC1262k = this.f34645b;
        if (abstractC1262k != null) {
            c1268n.n(abstractC1262k, th);
        }
        v9.l<Throwable, m9.q> lVar = this.f34646c;
        if (lVar != null) {
            c1268n.o(lVar, th);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1281w)) {
            return false;
        }
        C1281w c1281w = (C1281w) obj;
        if (kotlin.jvm.internal.i.b(this.f34644a, c1281w.f34644a) && kotlin.jvm.internal.i.b(this.f34645b, c1281w.f34645b) && kotlin.jvm.internal.i.b(this.f34646c, c1281w.f34646c) && kotlin.jvm.internal.i.b(this.f34647d, c1281w.f34647d) && kotlin.jvm.internal.i.b(this.f34648e, c1281w.f34648e)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        Object obj = this.f34644a;
        int i10 = 0;
        if (obj == null) {
            hashCode = 0;
        } else {
            hashCode = obj.hashCode();
        }
        int i11 = hashCode * 31;
        AbstractC1262k abstractC1262k = this.f34645b;
        if (abstractC1262k == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = abstractC1262k.hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        v9.l<Throwable, m9.q> lVar = this.f34646c;
        if (lVar == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = lVar.hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        Object obj2 = this.f34647d;
        if (obj2 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = obj2.hashCode();
        }
        int i14 = (i13 + hashCode4) * 31;
        Throwable th = this.f34648e;
        if (th != null) {
            i10 = th.hashCode();
        }
        return i14 + i10;
    }

    public String toString() {
        return "CompletedContinuation(result=" + this.f34644a + ", cancelHandler=" + this.f34645b + ", onCancellation=" + this.f34646c + ", idempotentResume=" + this.f34647d + ", cancelCause=" + this.f34648e + ')';
    }

    public /* synthetic */ C1281w(Object obj, AbstractC1262k abstractC1262k, v9.l lVar, Object obj2, Throwable th, int i10, kotlin.jvm.internal.f fVar) {
        this(obj, (i10 & 2) != 0 ? null : abstractC1262k, (i10 & 4) != 0 ? null : lVar, (i10 & 8) != 0 ? null : obj2, (i10 & 16) != 0 ? null : th);
    }
}
