package b2;

import android.util.SparseArray;
import android.view.View;
import b2.l;
import com.android.incallui.OplusAnswerFragment;
import com.android.incallui.OplusCallButtonFragment;
import com.android.incallui.OplusCallCardFragment;
import com.android.incallui.OplusConferenceManagerFragment;
import com.android.incallui.VideoCallFragment;
import com.android.incallui.mvvm.view.OplusDialpadFragment;

/* compiled from: IInCallFragmentManager.java */
/* renamed from: b2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC0519a extends l.a {

    /* renamed from: a, reason: collision with root package name */
    public static final SparseArray<Class> f12084a = new C0144a();

    /* compiled from: IInCallFragmentManager.java */
    /* renamed from: b2.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0144a extends SparseArray<Class> {
        public C0144a() {
            put(1, VideoCallFragment.class);
            put(2, OplusCallCardFragment.class);
            put(3, OplusCallButtonFragment.class);
            put(4, OplusAnswerFragment.class);
            put(5, OplusDialpadFragment.class);
            put(6, OplusConferenceManagerFragment.class);
        }

        @Override // android.util.SparseArray
        public /* bridge */ /* synthetic */ SparseArray<Class> clone() {
            return super.clone();
        }
    }

    void a();

    void b();

    OplusCallButtonFragment c();

    void d(int i10, boolean z10);

    void displayDialpad(boolean z10);

    void displayManageConferencePanel(boolean z10);

    void e(int i10);

    boolean f();

    void g(boolean z10);

    OplusCallCardFragment h();

    OplusAnswerFragment i();

    boolean isDialpadVisible();

    View j(int i10);

    void k(boolean z10);

    OplusDialpadFragment l();

    boolean m(int i10);

    void n(int i10, boolean z10);

    void o();

    void p(boolean z10);

    void refreshCallButtonsVisibility();
}
