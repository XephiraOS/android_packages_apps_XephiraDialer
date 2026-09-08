package M2;

import com.android.incallui.InCallPresenter;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: OplusLogAssistant.kt */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final C0042a f1744a = new C0042a(null);

    /* renamed from: b, reason: collision with root package name */
    public static final a f1745b = new a();

    /* compiled from: OplusLogAssistant.kt */
    /* renamed from: M2.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0042a {
        public C0042a() {
        }

        public final a a() {
            return a.f1745b;
        }

        public /* synthetic */ C0042a(f fVar) {
            this();
        }
    }

    public static final a c() {
        return f1744a.a();
    }

    public final InCallPresenter.InCallState b() {
        InCallPresenter.InCallState inCallState = InCallPresenter.getInstance().getInCallState();
        i.e(inCallState, "getInstance().inCallState");
        return inCallState;
    }
}
