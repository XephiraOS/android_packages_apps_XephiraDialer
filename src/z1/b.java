package Z1;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.o;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.H;
import com.android.incallui.Log;
import com.android.incallui.foldscreen.presentation.view.FlingUpAnswerMethodFoldLayout;
import com.android.incallui.oplus.answerview.view.AnswerMethodLayout;
import com.oplus.anim.EffectiveAnimationView;
import g2.InterfaceC1034a;
import g2.InterfaceC1037d;
import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.internal.i;

/* compiled from: FoldScreenBindingAdapterUtils.kt */
/* loaded from: classes.dex */
public final class b {

    /* compiled from: FoldScreenBindingAdapterUtils.kt */
    /* loaded from: classes.dex */
    public static final class a implements InterfaceC1037d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f5861a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ InterfaceC1034a f5862b;

        public a(View view, InterfaceC1034a interfaceC1034a) {
            this.f5861a = view;
            this.f5862b = interfaceC1034a;
        }

        @Override // g2.InterfaceC1037d
        public void Q0(com.android.incallui.oplus.answerview.protocol.a aVar, int i10) {
            if (aVar != null) {
                Context context = ((FlingUpAnswerMethodFoldLayout) this.f5861a).getContext();
                i.e(context, "view.context");
                aVar.a(context, this.f5862b, i10);
            }
        }
    }

    public static final void b(FragmentManager fragmentManager, int i10, Class<? extends Fragment> fragmentClass) {
        i.f(fragmentManager, "<this>");
        i.f(fragmentClass, "fragmentClass");
        Fragment m02 = fragmentManager.m0(fragmentClass.getName());
        if ((m02 == null && (m02 = (Fragment) f(fragmentClass)) == null) || m02.isAdded()) {
            return;
        }
        fragmentManager.p().t(i10, m02, fragmentClass.getName()).j();
    }

    public static final void c(TextView view, H1.b bVar) {
        i.f(view, "view");
        Log.d("FoldScreenBindingAdapterUtils", "bindCallStateChange");
        c.d(view);
    }

    public static final void d(TextView view, Integer num) {
        i.f(view, "view");
        Log.d("FoldScreenBindingAdapterUtils", "changeAnswerView textRes:" + num);
        if (num != null) {
            view.setText(num.intValue());
        }
    }

    public static final void e(AnswerMethodLayout view, Boolean bool) {
        i.f(view, "view");
        Log.d("FoldScreenBindingAdapterUtils", "changeAnswerView isUiShowing:" + bool);
        if (i.b(bool, Boolean.TRUE)) {
            view.v0();
        } else if (i.b(bool, Boolean.FALSE)) {
            view.m();
        }
        c.d(view);
    }

    public static final <T> T f(Class<? extends T> cls) {
        i.f(cls, "<this>");
        try {
            return cls.getDeclaredConstructor(null).newInstance(null);
        } catch (IllegalAccessException e10) {
            Log.w(cls, "createClassInstance failed: " + e10.getMessage());
            return null;
        } catch (IllegalArgumentException e11) {
            Log.w(cls, "createClassInstance failed: " + e11.getMessage());
            return null;
        } catch (InstantiationException e12) {
            Log.w(cls, "createClassInstance failed: " + e12.getMessage());
            return null;
        } catch (NoSuchMethodException e13) {
            Log.w(cls, "createClassInstance failed: " + e13.getMessage());
            return null;
        } catch (SecurityException e14) {
            Log.w(cls, "createClassInstance failed: " + e14.getMessage());
            return null;
        } catch (InvocationTargetException e15) {
            Log.w(cls, "createClassInstance failed: " + e15.getMessage());
            return null;
        }
    }

    public static final void g(EffectiveAnimationView view, Boolean bool) {
        i.f(view, "view");
        if (i.b(bool, Boolean.TRUE)) {
            view.playAnimation();
        } else if (view.isAnimating()) {
            view.cancelAnimation();
        }
    }

    public static final void h(View view, Integer num) {
        i.f(view, "view");
        if (num != null) {
            View findViewById = view.findViewById(P1.d.f2842a);
            if ((findViewById == null || findViewById.getVisibility() != 4 || num.intValue() != 0) && findViewById != null) {
                findViewById.setVisibility(num.intValue());
            }
        }
    }

    public static final void i(View view, Integer num) {
        View findViewById;
        i.f(view, "view");
        if (num != null && (findViewById = view.findViewById(P1.d.f2843b)) != null) {
            findViewById.setVisibility(num.intValue());
        }
    }

    public static final void j(final o viewStubProxy, ViewStub.OnInflateListener onInflateListener) {
        i.f(viewStubProxy, "viewStubProxy");
        if (onInflateListener != null) {
            viewStubProxy.l(onInflateListener);
            return;
        }
        if (viewStubProxy.j()) {
            ViewDataBinding g10 = viewStubProxy.g();
            if (g10 != null) {
                View h10 = viewStubProxy.h();
                i.e(h10, "viewStubProxy.root");
                g10.b1(H.a(h10));
                return;
            }
            return;
        }
        viewStubProxy.l(new ViewStub.OnInflateListener() { // from class: Z1.a
            @Override // android.view.ViewStub.OnInflateListener
            public final void onInflate(ViewStub viewStub, View view) {
                b.k(o.this, viewStub, view);
            }
        });
    }

    public static final void k(o viewStubProxy, ViewStub viewStub, View view) {
        i.f(viewStubProxy, "$viewStubProxy");
        ViewDataBinding g10 = viewStubProxy.g();
        if (g10 != null) {
            i.e(view, "view");
            g10.b1(H.a(view));
        }
    }

    public static final void l(View view, InterfaceC1034a interfaceC1034a) {
        i.f(view, "view");
        if (interfaceC1034a != null) {
            ((FlingUpAnswerMethodFoldLayout) view).setTriggerEventListener(new a(view, interfaceC1034a));
        }
    }

    public static final void m(View view, Integer num) {
        View findViewById;
        i.f(view, "view");
        if (num != null && (findViewById = view.findViewById(P1.d.f2863v)) != null) {
            findViewById.setVisibility(num.intValue());
        }
    }
}
