package kotlinx.coroutines.selects;

import kotlinx.coroutines.InterfaceC1266m;
import kotlinx.coroutines.internal.C;
import v9.l;
import v9.q;

/* compiled from: Select.kt */
/* loaded from: classes4.dex */
public final class SelectKt {

    /* renamed from: a, reason: collision with root package name */
    public static final q<Object, Object, Object, Object> f34599a = new q() { // from class: kotlinx.coroutines.selects.SelectKt$DUMMY_PROCESS_RESULT_FUNCTION$1
        @Override // v9.q
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Void d(Object obj, Object obj2, Object obj3) {
            return null;
        }
    };

    /* renamed from: b, reason: collision with root package name */
    public static final C f34600b = new C("STATE_REG");

    /* renamed from: c, reason: collision with root package name */
    public static final C f34601c = new C("STATE_COMPLETED");

    /* renamed from: d, reason: collision with root package name */
    public static final C f34602d = new C("STATE_CANCELLED");

    /* renamed from: e, reason: collision with root package name */
    public static final C f34603e = new C("NO_RESULT");

    /* renamed from: f, reason: collision with root package name */
    public static final C f34604f = new C("PARAM_CLAUSE_0");

    public static final TrySelectDetailedResult a(int i10) {
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 == 3) {
                        return TrySelectDetailedResult.ALREADY_SELECTED;
                    }
                    throw new IllegalStateException(("Unexpected internal result: " + i10).toString());
                }
                return TrySelectDetailedResult.CANCELLED;
            }
            return TrySelectDetailedResult.REREGISTER;
        }
        return TrySelectDetailedResult.SUCCESSFUL;
    }

    public static final boolean h(InterfaceC1266m<? super m9.q> interfaceC1266m, l<? super Throwable, m9.q> lVar) {
        Object f10 = interfaceC1266m.f(m9.q.f35511a, null, lVar);
        if (f10 == null) {
            return false;
        }
        interfaceC1266m.m(f10);
        return true;
    }
}
