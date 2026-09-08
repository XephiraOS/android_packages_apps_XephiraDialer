package b2;

import android.util.SparseArray;
import android.view.View;
import androidx.fragment.app.B;
import androidx.fragment.app.FragmentManager;
import b2.l;
import com.android.incallui.BaseFragment;
import com.android.incallui.InCallPresenter;
import com.android.incallui.Log;
import com.android.incallui.OplusAnswerFragment;
import com.android.incallui.OplusCallButtonFragment;
import com.android.incallui.OplusCallCardFragment;
import com.android.incallui.OplusInCallActivity;
import com.android.incallui.R;
import com.android.incallui.VideoCallFragment;
import com.android.incallui.mvvm.view.OplusDialpadFragment;

/* compiled from: InCallFragmentManager.java */
/* loaded from: classes.dex */
public abstract class c<T extends BaseFragment> implements InterfaceC0519a, l.a {

    /* renamed from: b, reason: collision with root package name */
    public OplusInCallActivity f12085b;

    /* renamed from: c, reason: collision with root package name */
    public FragmentManager f12086c;

    /* renamed from: d, reason: collision with root package name */
    public B f12087d;

    /* renamed from: e, reason: collision with root package name */
    public b f12088e = InCallPresenter.getInstance().realInstance().getInCallFragmentPresenter();

    /* renamed from: f, reason: collision with root package name */
    public int f12089f;

    public c(OplusInCallActivity oplusInCallActivity) {
        this.f12085b = oplusInCallActivity;
        this.f12086c = oplusInCallActivity.getSupportFragmentManager();
    }

    @Override // b2.InterfaceC0519a
    public void a() {
        b bVar = this.f12088e;
        if (bVar != null) {
            bVar.a(null);
        }
        this.f12088e = null;
        this.f12085b = null;
        this.f12087d = null;
    }

    @Override // b2.InterfaceC0519a
    public OplusCallButtonFragment c() {
        return (OplusCallButtonFragment) s(3);
    }

    @Override // b2.InterfaceC0519a
    public OplusCallCardFragment h() {
        return (OplusCallCardFragment) s(2);
    }

    @Override // b2.InterfaceC0519a
    public OplusAnswerFragment i() {
        return (OplusAnswerFragment) s(4);
    }

    @Override // b2.InterfaceC0519a
    public View j(int i10) {
        if (s(i10) != null) {
            return s(i10).getView();
        }
        return null;
    }

    @Override // b2.InterfaceC0519a
    public OplusDialpadFragment l() {
        T s10 = s(3);
        if (s10 != null && s10.isAdded()) {
            return (OplusDialpadFragment) s10.getChildFragmentManager().l0(R.id.oplusDialpadFragment);
        }
        return null;
    }

    @Override // b2.InterfaceC0519a
    public boolean m(int i10) {
        if (s(i10) != null && s(i10).isVisible()) {
            return true;
        }
        return false;
    }

    public void r(int i10, int i11) {
        String str;
        T s10 = s(i11);
        if (s10 == null && (s10 = u(i11)) == null) {
            Log.w("InCallFragmentManager", "addFragment: null return ");
            return;
        }
        if (s10.isAdded()) {
            Log.w("InCallFragmentManager", "addFragment:isAdded  return ");
            return;
        }
        SparseArray<Class> sparseArray = InterfaceC0519a.f12084a;
        if (sparseArray.get(i11) != null) {
            str = sparseArray.get(i11).getName();
        } else {
            str = null;
        }
        B p10 = this.f12086c.p();
        this.f12087d = p10;
        p10.c(i10, s10, str).j();
    }

    public T s(int i10) {
        if (5 == i10) {
            return l();
        }
        Class cls = InterfaceC0519a.f12084a.get(i10);
        if (cls == null) {
            return null;
        }
        String name = cls.getName();
        FragmentManager fragmentManager = this.f12086c;
        if (fragmentManager == null) {
            return null;
        }
        return (T) fragmentManager.m0(name);
    }

    public VideoCallFragment t() {
        return (VideoCallFragment) s(1);
    }

    public final T u(int i10) {
        Class cls = InterfaceC0519a.f12084a.get(i10);
        if (cls == null) {
            return null;
        }
        try {
            return (T) cls.getDeclaredConstructor(null).newInstance(null);
        } catch (IllegalAccessException | InstantiationException e10) {
            Log.w("InCallFragmentManager", "newInstanceFragmentById failed:" + e10.getMessage());
            return null;
        } catch (Exception e11) {
            Log.e("InCallFragmentManager", "newInstanceFragmentById exception caught : " + e11.getMessage());
            return null;
        }
    }

    public void v(int i10) {
        Class cls = InterfaceC0519a.f12084a.get(i10);
        if (cls == null) {
            return;
        }
        BaseFragment baseFragment = (BaseFragment) this.f12086c.m0(cls.getName());
        if (baseFragment == null) {
            return;
        }
        this.f12086c.p().r(baseFragment);
    }
}
