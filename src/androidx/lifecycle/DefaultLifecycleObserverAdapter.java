package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

/* compiled from: DefaultLifecycleObserverAdapter.kt */
/* loaded from: classes.dex */
public final class DefaultLifecycleObserverAdapter implements InterfaceC0489l {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0480c f10244a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC0489l f10245b;

    /* compiled from: DefaultLifecycleObserverAdapter.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10246a;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Lifecycle.Event.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[Lifecycle.Event.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f10246a = iArr;
        }
    }

    public DefaultLifecycleObserverAdapter(InterfaceC0480c defaultLifecycleObserver, InterfaceC0489l interfaceC0489l) {
        kotlin.jvm.internal.i.f(defaultLifecycleObserver, "defaultLifecycleObserver");
        this.f10244a = defaultLifecycleObserver;
        this.f10245b = interfaceC0489l;
    }

    @Override // androidx.lifecycle.InterfaceC0489l
    public void onStateChanged(InterfaceC0492o source, Lifecycle.Event event) {
        kotlin.jvm.internal.i.f(source, "source");
        kotlin.jvm.internal.i.f(event, "event");
        switch (a.f10246a[event.ordinal()]) {
            case 1:
                this.f10244a.onCreate(source);
                break;
            case 2:
                this.f10244a.onStart(source);
                break;
            case 3:
                this.f10244a.onResume(source);
                break;
            case 4:
                this.f10244a.onPause(source);
                break;
            case 5:
                this.f10244a.onStop(source);
                break;
            case 6:
                this.f10244a.onDestroy(source);
                break;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        InterfaceC0489l interfaceC0489l = this.f10245b;
        if (interfaceC0489l != null) {
            interfaceC0489l.onStateChanged(source, event);
        }
    }
}
