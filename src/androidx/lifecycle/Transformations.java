package androidx.lifecycle;

import kotlin.jvm.internal.Ref$BooleanRef;

/* compiled from: Transformations.kt */
/* loaded from: classes.dex */
public final class Transformations {

    /* compiled from: Transformations.kt */
    /* loaded from: classes.dex */
    public static final class a implements w, kotlin.jvm.internal.g {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v9.l f10335a;

        public a(v9.l function) {
            kotlin.jvm.internal.i.f(function, "function");
            this.f10335a = function;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof w) || !(obj instanceof kotlin.jvm.internal.g)) {
                return false;
            }
            return kotlin.jvm.internal.i.b(getFunctionDelegate(), ((kotlin.jvm.internal.g) obj).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.g
        public final m9.c<?> getFunctionDelegate() {
            return this.f10335a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.w
        public final /* synthetic */ void onChanged(Object obj) {
            this.f10335a.invoke(obj);
        }
    }

    public static final <X> LiveData<X> a(LiveData<X> liveData) {
        kotlin.jvm.internal.i.f(liveData, "<this>");
        final t tVar = new t();
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        ref$BooleanRef.element = true;
        if (liveData.h()) {
            tVar.o(liveData.getValue());
            ref$BooleanRef.element = false;
        }
        tVar.p(liveData, new a(new v9.l<X, m9.q>() { // from class: androidx.lifecycle.Transformations$distinctUntilChanged$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(X x10) {
                X value = tVar.getValue();
                if (ref$BooleanRef.element || ((value == null && x10 != null) || (value != null && !kotlin.jvm.internal.i.b(value, x10)))) {
                    ref$BooleanRef.element = false;
                    tVar.o(x10);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // v9.l
            public /* bridge */ /* synthetic */ m9.q invoke(Object obj) {
                b(obj);
                return m9.q.f35511a;
            }
        }));
        return tVar;
    }
}
