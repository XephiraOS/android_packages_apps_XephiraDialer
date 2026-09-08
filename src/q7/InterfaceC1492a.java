package q7;

import android.app.Activity;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: IStatusBarClickController.kt */
/* renamed from: q7.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public interface InterfaceC1492a {

    /* compiled from: IStatusBarClickController.kt */
    /* renamed from: q7.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0345a {
        public static boolean a(InterfaceC1492a interfaceC1492a) {
            return true;
        }

        public static /* synthetic */ void b(InterfaceC1492a interfaceC1492a, Activity activity, RecyclerView recyclerView, InterfaceC1494c interfaceC1494c, int i10, Object obj) {
            if (obj == null) {
                if ((i10 & 4) != 0) {
                    interfaceC1494c = null;
                }
                interfaceC1492a.T0(activity, recyclerView, interfaceC1494c);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initStatusBarClickController");
        }
    }

    void F();

    void H0();

    void T0(Activity activity, RecyclerView recyclerView, InterfaceC1494c interfaceC1494c);

    void p();
}
