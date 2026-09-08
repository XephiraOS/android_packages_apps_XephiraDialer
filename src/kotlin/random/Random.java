package kotlin.random;

import java.io.Serializable;
import kotlin.jvm.internal.f;
import r9.C1519b;

/* compiled from: Random.kt */
/* loaded from: classes4.dex */
public abstract class Random {

    /* renamed from: a, reason: collision with root package name */
    public static final Default f34246a = new Default(null);

    /* renamed from: b, reason: collision with root package name */
    public static final Random f34247b = C1519b.f36557a.b();

    /* compiled from: Random.kt */
    /* loaded from: classes4.dex */
    public static final class Default extends Random implements Serializable {

        /* compiled from: Random.kt */
        /* loaded from: classes4.dex */
        public static final class Serialized implements Serializable {

            /* renamed from: a, reason: collision with root package name */
            public static final Serialized f34248a = new Serialized();
            private static final long serialVersionUID = 0;

            private Serialized() {
            }

            private final Object readResolve() {
                return Random.f34246a;
            }
        }

        public /* synthetic */ Default(f fVar) {
            this();
        }

        private final Object writeReplace() {
            return Serialized.f34248a;
        }

        @Override // kotlin.random.Random
        public int b() {
            return Random.f34247b.b();
        }

        @Override // kotlin.random.Random
        public int c(int i10) {
            return Random.f34247b.c(i10);
        }

        private Default() {
        }
    }

    public abstract int b();

    public abstract int c(int i10);
}
