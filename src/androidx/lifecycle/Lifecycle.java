package androidx.lifecycle;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: Lifecycle.kt */
/* loaded from: classes.dex */
public abstract class Lifecycle {

    /* renamed from: a, reason: collision with root package name */
    public AtomicReference<Object> f10280a = new AtomicReference<>();

    /* compiled from: Lifecycle.kt */
    /* loaded from: classes.dex */
    public enum Event {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY;

        public static final a Companion = new a(null);

        /* compiled from: Lifecycle.kt */
        /* loaded from: classes.dex */
        public static final class a {

            /* compiled from: Lifecycle.kt */
            /* renamed from: androidx.lifecycle.Lifecycle$Event$a$a, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public /* synthetic */ class C0127a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f10281a;

                static {
                    int[] iArr = new int[State.values().length];
                    try {
                        iArr[State.CREATED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[State.STARTED.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[State.RESUMED.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[State.DESTROYED.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[State.INITIALIZED.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    f10281a = iArr;
                }
            }

            public a() {
            }

            public final Event a(State state) {
                kotlin.jvm.internal.i.f(state, "state");
                int i10 = C0127a.f10281a[state.ordinal()];
                if (i10 != 1) {
                    if (i10 != 2) {
                        if (i10 != 3) {
                            return null;
                        }
                        return Event.ON_PAUSE;
                    }
                    return Event.ON_STOP;
                }
                return Event.ON_DESTROY;
            }

            public final Event b(State state) {
                kotlin.jvm.internal.i.f(state, "state");
                int i10 = C0127a.f10281a[state.ordinal()];
                if (i10 != 1) {
                    if (i10 != 2) {
                        if (i10 != 5) {
                            return null;
                        }
                        return Event.ON_CREATE;
                    }
                    return Event.ON_RESUME;
                }
                return Event.ON_START;
            }

            public final Event c(State state) {
                kotlin.jvm.internal.i.f(state, "state");
                int i10 = C0127a.f10281a[state.ordinal()];
                if (i10 != 1) {
                    if (i10 != 2) {
                        if (i10 != 3) {
                            return null;
                        }
                        return Event.ON_RESUME;
                    }
                    return Event.ON_START;
                }
                return Event.ON_CREATE;
            }

            public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
                this();
            }
        }

        /* compiled from: Lifecycle.kt */
        /* loaded from: classes.dex */
        public /* synthetic */ class b {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f10282a;

            static {
                int[] iArr = new int[Event.values().length];
                try {
                    iArr[Event.ON_CREATE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Event.ON_STOP.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Event.ON_START.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[Event.ON_PAUSE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[Event.ON_RESUME.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[Event.ON_DESTROY.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[Event.ON_ANY.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                f10282a = iArr;
            }
        }

        public static final Event b(State state) {
            return Companion.a(state);
        }

        public static final Event d(State state) {
            return Companion.c(state);
        }

        public final State c() {
            switch (b.f10282a[ordinal()]) {
                case 1:
                case 2:
                    return State.CREATED;
                case 3:
                case 4:
                    return State.STARTED;
                case 5:
                    return State.RESUMED;
                case 6:
                    return State.DESTROYED;
                default:
                    throw new IllegalArgumentException(this + " has no target state");
            }
        }
    }

    /* compiled from: Lifecycle.kt */
    /* loaded from: classes.dex */
    public enum State {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public final boolean b(State state) {
            kotlin.jvm.internal.i.f(state, "state");
            if (compareTo(state) >= 0) {
                return true;
            }
            return false;
        }
    }

    public abstract void a(InterfaceC0491n interfaceC0491n);

    public abstract State b();

    public final AtomicReference<Object> c() {
        return this.f10280a;
    }

    public abstract void d(InterfaceC0491n interfaceC0491n);
}
