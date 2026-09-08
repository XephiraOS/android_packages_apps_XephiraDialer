package b2;

import android.animation.Animator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.incallui.InCallPresenter;
import com.android.incallui.Log;
import com.android.incallui.OplusAnimationUtils;
import com.android.incallui.OplusCallButtonFragment;
import com.android.incallui.OplusCallCardFragment;
import com.android.incallui.OplusInCallActivity;
import com.android.incallui.R;
import com.android.incallui.mvvm.utils.A;
import com.android.incallui.mvvm.view.OplusDialpadFragment;

/* compiled from: InCallFragmentManagerImpl.java */
/* loaded from: classes.dex */
public class j extends c {
    public j(OplusInCallActivity oplusInCallActivity) {
        super(oplusInCallActivity);
    }

    public final /* synthetic */ void C() {
        d(6, true);
        d(2, false);
        N(R.id.vp_screen_top, true, null);
    }

    public final /* synthetic */ void D() {
        d(3, false);
        N(R.id.vp_screen_center, true, null);
    }

    public final /* synthetic */ void E() {
        A.b(false);
        N(R.id.vp_screen_bottom, true, null);
    }

    public final /* synthetic */ void F() {
        d(6, false);
        d(2, true);
        N(R.id.vp_screen_top, true, null);
    }

    public final /* synthetic */ void G() {
        d(3, true);
        N(R.id.vp_screen_center, true, null);
    }

    public final /* synthetic */ void H() {
        A.b(true);
        J(false);
        v(6);
        N(R.id.vp_screen_bottom, true, null);
    }

    public final boolean I(int i10, int i11) {
        if ((i10 & i11) == i11) {
            return true;
        }
        return false;
    }

    public void J(boolean z10) {
        OplusCallButtonFragment c10 = c();
        if (c10 != null) {
            c10.onConferencePanelVisibilityChanged(z10);
        }
    }

    public final void K(int i10) {
        if (s(i10) != null) {
            s(i10).releaseResources();
        }
    }

    public void L(boolean z10) {
        OplusCallButtonFragment c10 = c();
        if (c10 != null) {
            c10.setCallButtonWithoutAnim(z10);
        }
    }

    public void M(boolean z10) {
        float f10;
        RecyclerView recyclerView;
        GridLayoutManager gridLayoutManager;
        View j10 = j(5);
        if (z10) {
            f10 = 1.0f;
        } else {
            f10 = 0.0f;
        }
        if (j10 != null && (recyclerView = (RecyclerView) j10.findViewById(R.id.rv_dialpad_buttons)) != null && (gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager()) != null) {
            int itemCount = gridLayoutManager.getItemCount();
            for (int i10 = 0; i10 < itemCount; i10++) {
                View findViewByPosition = gridLayoutManager.findViewByPosition(i10);
                if (findViewByPosition != null) {
                    findViewByPosition.setAlpha(f10);
                }
            }
        }
        d(5, z10);
    }

    public void N(int i10, boolean z10, Runnable runnable) {
        View findViewById;
        ViewPropertyAnimator fadeOut;
        Log.d("InCallFragmentManager", "setFragmentVisibleWithFadeAnim: value=" + z10 + ", fragment=" + i10 + ", endAction=" + runnable + ",mOplusInCallActivity=" + this.f12085b);
        OplusInCallActivity oplusInCallActivity = this.f12085b;
        if (oplusInCallActivity != null && (findViewById = oplusInCallActivity.findViewById(i10)) != null) {
            if (z10) {
                fadeOut = OplusAnimationUtils.fadeIn(findViewById);
            } else {
                fadeOut = OplusAnimationUtils.fadeOut(findViewById);
            }
            fadeOut.withEndAction(runnable).setListener(new a(findViewById, runnable));
            fadeOut.start();
        }
    }

    public final String O(int i10) {
        StringBuffer stringBuffer = new StringBuffer("Fragments:");
        if (I(i10, 2)) {
            stringBuffer.append("call card, ");
        }
        if (I(i10, 4)) {
            stringBuffer.append("call button, ");
        }
        if (I(i10, 1)) {
            stringBuffer.append("video call, ");
        }
        if (I(i10, 8)) {
            stringBuffer.append("answer, ");
        }
        if (I(i10, 32)) {
            stringBuffer.append("conference, ");
        }
        return String.valueOf(stringBuffer);
    }

    @Override // b2.InterfaceC0519a
    public void b() {
        b bVar = this.f12088e;
        if (bVar != null) {
            bVar.b();
        }
    }

    @Override // b2.InterfaceC0519a
    public void d(int i10, boolean z10) {
        if (s(i10) != null && s(i10).isAdded()) {
            s(i10).setVisible(z10);
        }
    }

    @Override // b2.InterfaceC0519a
    public void displayDialpad(boolean z10) {
        if (Log.sDebug) {
            Log.d("InCallFragmentManager", "showDialpad = " + z10);
        }
        d(5, z10);
        n(3, z10);
        n(2, z10);
        if (InCallPresenter.getInstance().getProximitySensor() != null) {
            InCallPresenter.getInstance().getProximitySensor().onDialpadVisible(z10);
        }
    }

    @Override // b2.InterfaceC0519a
    public void displayManageConferencePanel(boolean z10) {
        if (Log.sDebug) {
            Log.d("InCallFragmentManager", "displayManageConferencePanel vis = " + z10);
        }
        if (z10) {
            int i10 = R.id.vp_screen_top;
            r(i10, 6);
            N(i10, false, new Runnable() { // from class: b2.d
                @Override // java.lang.Runnable
                public final void run() {
                    j.this.C();
                }
            });
            N(R.id.vp_screen_center, false, new Runnable() { // from class: b2.e
                @Override // java.lang.Runnable
                public final void run() {
                    j.this.D();
                }
            });
            N(R.id.vp_screen_bottom, false, new Runnable() { // from class: b2.f
                @Override // java.lang.Runnable
                public final void run() {
                    j.this.E();
                }
            });
            return;
        }
        N(R.id.vp_screen_top, false, new Runnable() { // from class: b2.g
            @Override // java.lang.Runnable
            public final void run() {
                j.this.F();
            }
        });
        N(R.id.vp_screen_center, false, new Runnable() { // from class: b2.h
            @Override // java.lang.Runnable
            public final void run() {
                j.this.G();
            }
        });
        N(R.id.vp_screen_bottom, false, new Runnable() { // from class: b2.i
            @Override // java.lang.Runnable
            public final void run() {
                j.this.H();
            }
        });
    }

    @Override // b2.InterfaceC0519a
    public boolean f() {
        boolean m10 = m(6);
        if (Log.sDebug) {
            Log.d(this, "getManageConferencePanelVisible = " + m10);
        }
        return m10;
    }

    @Override // b2.InterfaceC0519a
    public void g(boolean z10) {
        if (Log.sDebug) {
            Log.d("InCallFragmentManager", "displayDialpadWithoutAnim : " + z10);
        }
        M(z10);
        n(2, z10);
        L(z10);
        if (InCallPresenter.getInstance().getProximitySensor() != null) {
            InCallPresenter.getInstance().getProximitySensor().onDialpadVisible(z10);
        }
    }

    @Override // b2.InterfaceC0519a
    public boolean isDialpadVisible() {
        boolean m10 = m(5);
        Log.d(this, "isDialpadVisible  = " + m10);
        return m10;
    }

    @Override // b2.InterfaceC0519a
    public void k(boolean z10) {
        OplusDialpadFragment l10 = l();
        if (l10 != null) {
            l10.l1(z10);
        }
    }

    @Override // b2.InterfaceC0519a
    public void n(int i10, boolean z10) {
        OplusCallButtonFragment c10;
        if (i10 == 2) {
            OplusCallCardFragment h10 = h();
            if (h10 != null) {
                h10.setDialpad(z10);
                return;
            }
            return;
        }
        if (i10 == 3 && (c10 = c()) != null) {
            c10.setDialpad(z10);
        }
    }

    @Override // b2.InterfaceC0519a
    public void o() {
        if (Log.sDebug) {
            Log.d("InCallFragmentManager", "releaseFragmentResources");
        }
        K(2);
        K(3);
        K(5);
        K(4);
    }

    @Override // b2.InterfaceC0519a
    public void p(boolean z10) {
        if (t() != null && t().isVideoCallUIVisible() && z10 != m(1)) {
            t().setVideoCallUIVisible(z10);
        }
    }

    @Override // b2.l.a
    public void q(int i10) {
        Log.d("InCallFragmentManager", "onFragmentStateChange newState:" + O(i10));
        int i11 = this.f12089f;
        if (i10 != i11) {
            int i12 = (~i11) & i10;
            this.f12089f = i10;
            if (I(i12, 2)) {
                r(R.id.vp_screen_top, 2);
            }
            if (I(i12, 4)) {
                r(R.id.vp_screen_center, 3);
            }
            if (I(i12, 1)) {
                r(R.id.fl_screen_background, 1);
            }
            if (I(i12, 8)) {
                r(R.id.vp_screen_bottom, 4);
            }
            if (I(i12, 32)) {
                r(R.id.vp_screen_top, 6);
            }
        }
    }

    @Override // b2.InterfaceC0519a
    public void refreshCallButtonsVisibility() {
        OplusCallButtonFragment c10 = c();
        if (c10 != null) {
            c10.refreshCallButtonsVisibility();
        }
    }

    /* compiled from: InCallFragmentManagerImpl.java */
    /* loaded from: classes.dex */
    public class a implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f12096a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Runnable f12097b;

        public a(View view, Runnable runnable) {
            this.f12096a = view;
            this.f12097b = runnable;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Log.d("InCallFragmentManager", "setFragmentVisibleWithFadeAnim:  cancel");
            View view = this.f12096a;
            if (view != null) {
                view.setAlpha(1.0f);
            }
            Runnable runnable = this.f12097b;
            if (runnable != null) {
                runnable.run();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    @Override // b2.InterfaceC0519a
    public void e(int i10) {
    }
}
