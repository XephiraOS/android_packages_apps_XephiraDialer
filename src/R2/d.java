package r2;

import android.app.Application;
import com.android.incallui.OplusInCallPresenter;
import d2.InterfaceC0949b;

/* compiled from: IStatisticsRepository.kt */
/* loaded from: classes.dex */
public interface d extends InterfaceC0949b {

    /* compiled from: IStatisticsRepository.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public static Application a(d dVar) {
            return InterfaceC0949b.a.b(dVar);
        }

        public static OplusInCallPresenter b(d dVar) {
            return InterfaceC0949b.a.j(dVar);
        }

        public static void c(d dVar) {
            InterfaceC0949b.a.m(dVar);
        }
    }

    void c1(Integer num);

    void f0(Integer num, boolean z10);

    void n(Integer num, int i10);

    void s(int i10);
}
