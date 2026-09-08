package kotlin;

import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import m9.d;
import v9.InterfaceC1637a;

/* compiled from: LazyJVM.kt */
/* loaded from: classes4.dex */
public class a {

    /* compiled from: LazyJVM.kt */
    /* renamed from: kotlin.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public /* synthetic */ class C0323a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f34169a;

        static {
            int[] iArr = new int[LazyThreadSafetyMode.values().length];
            try {
                iArr[LazyThreadSafetyMode.f34161a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LazyThreadSafetyMode.f34162b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LazyThreadSafetyMode.f34163c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f34169a = iArr;
        }
    }

    public static <T> d<T> a(LazyThreadSafetyMode mode, InterfaceC1637a<? extends T> initializer) {
        i.f(mode, "mode");
        i.f(initializer, "initializer");
        int i10 = C0323a.f34169a[mode.ordinal()];
        int i11 = 2;
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 == 3) {
                    return new UnsafeLazyImpl(initializer);
                }
                throw new NoWhenBranchMatchedException();
            }
            return new SafePublicationLazyImpl(initializer);
        }
        f fVar = null;
        return new SynchronizedLazyImpl(initializer, fVar, i11, fVar);
    }

    public static <T> d<T> b(InterfaceC1637a<? extends T> initializer) {
        i.f(initializer, "initializer");
        f fVar = null;
        return new SynchronizedLazyImpl(initializer, fVar, 2, fVar);
    }
}
