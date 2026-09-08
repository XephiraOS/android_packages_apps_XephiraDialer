package T1;

import android.app.Application;
import com.android.incallui.OplusInCallPresenter;
import com.internal_dependency.AddOnSdkDepends;
import d2.InterfaceC0949b;

/* compiled from: IFoldConfigRepository.kt */
/* loaded from: classes.dex */
public interface a extends InterfaceC0949b {

    /* compiled from: IFoldConfigRepository.kt */
    /* renamed from: T1.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0066a {
        public static AddOnSdkDepends a(a aVar) {
            return InterfaceC0949b.a.a(aVar);
        }

        public static Application b(a aVar) {
            return InterfaceC0949b.a.b(aVar);
        }

        public static OplusInCallPresenter c(a aVar) {
            return InterfaceC0949b.a.j(aVar);
        }

        public static void d(a aVar) {
            InterfaceC0949b.a.m(aVar);
        }
    }

    boolean R0();

    void collapseDragonflyPanels();

    boolean m1();
}
