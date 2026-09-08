package androidx.window.layout;

import android.graphics.Rect;
import androidx.window.core.Bounds;
import androidx.window.layout.FoldingFeature;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: HardwareFoldingFeature.kt */
/* loaded from: classes.dex */
public final class HardwareFoldingFeature implements FoldingFeature {

    /* renamed from: d, reason: collision with root package name */
    public static final Companion f12013d = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    public final Bounds f12014a;

    /* renamed from: b, reason: collision with root package name */
    public final Type f12015b;

    /* renamed from: c, reason: collision with root package name */
    public final FoldingFeature.State f12016c;

    /* compiled from: HardwareFoldingFeature.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public final void a(Bounds bounds) {
            i.f(bounds, "bounds");
            if (bounds.d() == 0 && bounds.a() == 0) {
                throw new IllegalArgumentException("Bounds must be non zero".toString());
            }
            if (bounds.b() != 0 && bounds.c() != 0) {
                throw new IllegalArgumentException("Bounding rectangle must start at the top or left window edge for folding features".toString());
            }
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    /* compiled from: HardwareFoldingFeature.kt */
    /* loaded from: classes.dex */
    public static final class Type {

        /* renamed from: b, reason: collision with root package name */
        public static final Companion f12017b = new Companion(null);

        /* renamed from: c, reason: collision with root package name */
        public static final Type f12018c = new Type("FOLD");

        /* renamed from: d, reason: collision with root package name */
        public static final Type f12019d = new Type("HINGE");

        /* renamed from: a, reason: collision with root package name */
        public final String f12020a;

        /* compiled from: HardwareFoldingFeature.kt */
        /* loaded from: classes.dex */
        public static final class Companion {
            private Companion() {
            }

            public final Type a() {
                return Type.f12018c;
            }

            public final Type b() {
                return Type.f12019d;
            }

            public /* synthetic */ Companion(f fVar) {
                this();
            }
        }

        public Type(String str) {
            this.f12020a = str;
        }

        public String toString() {
            return this.f12020a;
        }
    }

    public HardwareFoldingFeature(Bounds featureBounds, Type type, FoldingFeature.State state) {
        i.f(featureBounds, "featureBounds");
        i.f(type, "type");
        i.f(state, "state");
        this.f12014a = featureBounds;
        this.f12015b = type;
        this.f12016c = state;
        f12013d.a(featureBounds);
    }

    @Override // androidx.window.layout.DisplayFeature
    public Rect a() {
        return this.f12014a.f();
    }

    @Override // androidx.window.layout.FoldingFeature
    public boolean b() {
        Type type = this.f12015b;
        Type.Companion companion = Type.f12017b;
        if (i.b(type, companion.b())) {
            return true;
        }
        if (i.b(this.f12015b, companion.a()) && i.b(getState(), FoldingFeature.State.f12011d)) {
            return true;
        }
        return false;
    }

    @Override // androidx.window.layout.FoldingFeature
    public FoldingFeature.Orientation c() {
        if (this.f12014a.d() > this.f12014a.a()) {
            return FoldingFeature.Orientation.f12007d;
        }
        return FoldingFeature.Orientation.f12006c;
    }

    public boolean equals(Object obj) {
        Class<?> cls;
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            cls = obj.getClass();
        } else {
            cls = null;
        }
        if (!i.b(HardwareFoldingFeature.class, cls)) {
            return false;
        }
        if (obj != null) {
            HardwareFoldingFeature hardwareFoldingFeature = (HardwareFoldingFeature) obj;
            if (i.b(this.f12014a, hardwareFoldingFeature.f12014a) && i.b(this.f12015b, hardwareFoldingFeature.f12015b) && i.b(getState(), hardwareFoldingFeature.getState())) {
                return true;
            }
            return false;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.window.layout.HardwareFoldingFeature");
    }

    @Override // androidx.window.layout.FoldingFeature
    public FoldingFeature.State getState() {
        return this.f12016c;
    }

    public int hashCode() {
        return (((this.f12014a.hashCode() * 31) + this.f12015b.hashCode()) * 31) + getState().hashCode();
    }

    public String toString() {
        return HardwareFoldingFeature.class.getSimpleName() + " { " + this.f12014a + ", type=" + this.f12015b + ", state=" + getState() + " }";
    }
}
