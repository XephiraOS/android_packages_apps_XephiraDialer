package androidx.window.layout;

import kotlin.jvm.internal.f;

/* compiled from: FoldingFeature.kt */
/* loaded from: classes.dex */
public interface FoldingFeature extends DisplayFeature {

    /* compiled from: FoldingFeature.kt */
    /* loaded from: classes.dex */
    public static final class OcclusionType {

        /* renamed from: b, reason: collision with root package name */
        public static final Companion f12001b = new Companion(null);

        /* renamed from: c, reason: collision with root package name */
        public static final OcclusionType f12002c = new OcclusionType("NONE");

        /* renamed from: d, reason: collision with root package name */
        public static final OcclusionType f12003d = new OcclusionType("FULL");

        /* renamed from: a, reason: collision with root package name */
        public final String f12004a;

        /* compiled from: FoldingFeature.kt */
        /* loaded from: classes.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(f fVar) {
                this();
            }
        }

        public OcclusionType(String str) {
            this.f12004a = str;
        }

        public String toString() {
            return this.f12004a;
        }
    }

    /* compiled from: FoldingFeature.kt */
    /* loaded from: classes.dex */
    public static final class Orientation {

        /* renamed from: b, reason: collision with root package name */
        public static final Companion f12005b = new Companion(null);

        /* renamed from: c, reason: collision with root package name */
        public static final Orientation f12006c = new Orientation("VERTICAL");

        /* renamed from: d, reason: collision with root package name */
        public static final Orientation f12007d = new Orientation("HORIZONTAL");

        /* renamed from: a, reason: collision with root package name */
        public final String f12008a;

        /* compiled from: FoldingFeature.kt */
        /* loaded from: classes.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(f fVar) {
                this();
            }
        }

        public Orientation(String str) {
            this.f12008a = str;
        }

        public String toString() {
            return this.f12008a;
        }
    }

    /* compiled from: FoldingFeature.kt */
    /* loaded from: classes.dex */
    public static final class State {

        /* renamed from: b, reason: collision with root package name */
        public static final Companion f12009b = new Companion(null);

        /* renamed from: c, reason: collision with root package name */
        public static final State f12010c = new State("FLAT");

        /* renamed from: d, reason: collision with root package name */
        public static final State f12011d = new State("HALF_OPENED");

        /* renamed from: a, reason: collision with root package name */
        public final String f12012a;

        /* compiled from: FoldingFeature.kt */
        /* loaded from: classes.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(f fVar) {
                this();
            }
        }

        public State(String str) {
            this.f12012a = str;
        }

        public String toString() {
            return this.f12012a;
        }
    }

    boolean b();

    Orientation c();

    State getState();
}
