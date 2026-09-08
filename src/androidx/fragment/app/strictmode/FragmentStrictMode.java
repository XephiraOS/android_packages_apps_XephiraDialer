package androidx.fragment.app.strictmode;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.E;
import kotlin.collections.K;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: FragmentStrictMode.kt */
/* loaded from: classes.dex */
public final class FragmentStrictMode {

    /* renamed from: a, reason: collision with root package name */
    public static final FragmentStrictMode f10189a = new FragmentStrictMode();

    /* renamed from: b, reason: collision with root package name */
    public static b f10190b = b.f10201d;

    /* compiled from: FragmentStrictMode.kt */
    /* loaded from: classes.dex */
    public enum Flag {
        PENALTY_LOG,
        PENALTY_DEATH,
        DETECT_FRAGMENT_REUSE,
        DETECT_FRAGMENT_TAG_USAGE,
        DETECT_RETAIN_INSTANCE_USAGE,
        DETECT_SET_USER_VISIBLE_HINT,
        DETECT_TARGET_FRAGMENT_USAGE,
        DETECT_WRONG_FRAGMENT_CONTAINER
    }

    /* compiled from: FragmentStrictMode.kt */
    /* loaded from: classes.dex */
    public interface a {
    }

    /* compiled from: FragmentStrictMode.kt */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: c, reason: collision with root package name */
        public static final a f10200c = new a(null);

        /* renamed from: d, reason: collision with root package name */
        public static final b f10201d;

        /* renamed from: a, reason: collision with root package name */
        public final Set<Flag> f10202a;

        /* renamed from: b, reason: collision with root package name */
        public final Map<String, Set<Class<? extends Violation>>> f10203b;

        /* compiled from: FragmentStrictMode.kt */
        /* loaded from: classes.dex */
        public static final class a {
            public a() {
            }

            public /* synthetic */ a(f fVar) {
                this();
            }
        }

        static {
            Set b10;
            Map d10;
            b10 = K.b();
            d10 = E.d();
            f10201d = new b(b10, null, d10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(Set<? extends Flag> flags, a aVar, Map<String, ? extends Set<Class<? extends Violation>>> allowedViolations) {
            i.f(flags, "flags");
            i.f(allowedViolations, "allowedViolations");
            this.f10202a = flags;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, ? extends Set<Class<? extends Violation>>> entry : allowedViolations.entrySet()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
            this.f10203b = linkedHashMap;
        }

        public final Set<Flag> a() {
            return this.f10202a;
        }

        public final a b() {
            return null;
        }

        public final Map<String, Set<Class<? extends Violation>>> c() {
            return this.f10203b;
        }
    }

    public static final void d(String str, Violation violation) {
        i.f(violation, "$violation");
        Log.e("FragmentStrictMode", "Policy violation with PENALTY_DEATH in " + str, violation);
        throw violation;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void f(Fragment fragment, String previousFragmentId) {
        i.f(fragment, "fragment");
        i.f(previousFragmentId, "previousFragmentId");
        FragmentReuseViolation fragmentReuseViolation = new FragmentReuseViolation(fragment, previousFragmentId);
        FragmentStrictMode fragmentStrictMode = f10189a;
        fragmentStrictMode.e(fragmentReuseViolation);
        b b10 = fragmentStrictMode.b(fragment);
        if (b10.a().contains(Flag.DETECT_FRAGMENT_REUSE) && fragmentStrictMode.p(b10, fragment.getClass(), fragmentReuseViolation.getClass())) {
            fragmentStrictMode.c(b10, fragmentReuseViolation);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void g(Fragment fragment, ViewGroup viewGroup) {
        i.f(fragment, "fragment");
        FragmentTagUsageViolation fragmentTagUsageViolation = new FragmentTagUsageViolation(fragment, viewGroup);
        FragmentStrictMode fragmentStrictMode = f10189a;
        fragmentStrictMode.e(fragmentTagUsageViolation);
        b b10 = fragmentStrictMode.b(fragment);
        if (b10.a().contains(Flag.DETECT_FRAGMENT_TAG_USAGE) && fragmentStrictMode.p(b10, fragment.getClass(), fragmentTagUsageViolation.getClass())) {
            fragmentStrictMode.c(b10, fragmentTagUsageViolation);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void h(Fragment fragment) {
        i.f(fragment, "fragment");
        GetRetainInstanceUsageViolation getRetainInstanceUsageViolation = new GetRetainInstanceUsageViolation(fragment);
        FragmentStrictMode fragmentStrictMode = f10189a;
        fragmentStrictMode.e(getRetainInstanceUsageViolation);
        b b10 = fragmentStrictMode.b(fragment);
        if (b10.a().contains(Flag.DETECT_RETAIN_INSTANCE_USAGE) && fragmentStrictMode.p(b10, fragment.getClass(), getRetainInstanceUsageViolation.getClass())) {
            fragmentStrictMode.c(b10, getRetainInstanceUsageViolation);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void i(Fragment fragment) {
        i.f(fragment, "fragment");
        GetTargetFragmentRequestCodeUsageViolation getTargetFragmentRequestCodeUsageViolation = new GetTargetFragmentRequestCodeUsageViolation(fragment);
        FragmentStrictMode fragmentStrictMode = f10189a;
        fragmentStrictMode.e(getTargetFragmentRequestCodeUsageViolation);
        b b10 = fragmentStrictMode.b(fragment);
        if (b10.a().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) && fragmentStrictMode.p(b10, fragment.getClass(), getTargetFragmentRequestCodeUsageViolation.getClass())) {
            fragmentStrictMode.c(b10, getTargetFragmentRequestCodeUsageViolation);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void j(Fragment fragment) {
        i.f(fragment, "fragment");
        GetTargetFragmentUsageViolation getTargetFragmentUsageViolation = new GetTargetFragmentUsageViolation(fragment);
        FragmentStrictMode fragmentStrictMode = f10189a;
        fragmentStrictMode.e(getTargetFragmentUsageViolation);
        b b10 = fragmentStrictMode.b(fragment);
        if (b10.a().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) && fragmentStrictMode.p(b10, fragment.getClass(), getTargetFragmentUsageViolation.getClass())) {
            fragmentStrictMode.c(b10, getTargetFragmentUsageViolation);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void k(Fragment fragment) {
        i.f(fragment, "fragment");
        SetRetainInstanceUsageViolation setRetainInstanceUsageViolation = new SetRetainInstanceUsageViolation(fragment);
        FragmentStrictMode fragmentStrictMode = f10189a;
        fragmentStrictMode.e(setRetainInstanceUsageViolation);
        b b10 = fragmentStrictMode.b(fragment);
        if (b10.a().contains(Flag.DETECT_RETAIN_INSTANCE_USAGE) && fragmentStrictMode.p(b10, fragment.getClass(), setRetainInstanceUsageViolation.getClass())) {
            fragmentStrictMode.c(b10, setRetainInstanceUsageViolation);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void l(Fragment violatingFragment, Fragment targetFragment, int i10) {
        i.f(violatingFragment, "violatingFragment");
        i.f(targetFragment, "targetFragment");
        SetTargetFragmentUsageViolation setTargetFragmentUsageViolation = new SetTargetFragmentUsageViolation(violatingFragment, targetFragment, i10);
        FragmentStrictMode fragmentStrictMode = f10189a;
        fragmentStrictMode.e(setTargetFragmentUsageViolation);
        b b10 = fragmentStrictMode.b(violatingFragment);
        if (b10.a().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) && fragmentStrictMode.p(b10, violatingFragment.getClass(), setTargetFragmentUsageViolation.getClass())) {
            fragmentStrictMode.c(b10, setTargetFragmentUsageViolation);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void m(Fragment fragment, boolean z10) {
        i.f(fragment, "fragment");
        SetUserVisibleHintViolation setUserVisibleHintViolation = new SetUserVisibleHintViolation(fragment, z10);
        FragmentStrictMode fragmentStrictMode = f10189a;
        fragmentStrictMode.e(setUserVisibleHintViolation);
        b b10 = fragmentStrictMode.b(fragment);
        if (b10.a().contains(Flag.DETECT_SET_USER_VISIBLE_HINT) && fragmentStrictMode.p(b10, fragment.getClass(), setUserVisibleHintViolation.getClass())) {
            fragmentStrictMode.c(b10, setUserVisibleHintViolation);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void n(Fragment fragment, ViewGroup container) {
        i.f(fragment, "fragment");
        i.f(container, "container");
        WrongFragmentContainerViolation wrongFragmentContainerViolation = new WrongFragmentContainerViolation(fragment, container);
        FragmentStrictMode fragmentStrictMode = f10189a;
        fragmentStrictMode.e(wrongFragmentContainerViolation);
        b b10 = fragmentStrictMode.b(fragment);
        if (b10.a().contains(Flag.DETECT_WRONG_FRAGMENT_CONTAINER) && fragmentStrictMode.p(b10, fragment.getClass(), wrongFragmentContainerViolation.getClass())) {
            fragmentStrictMode.c(b10, wrongFragmentContainerViolation);
        }
    }

    public final b b(Fragment fragment) {
        while (fragment != null) {
            if (fragment.isAdded()) {
                FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
                i.e(parentFragmentManager, "declaringFragment.parentFragmentManager");
                if (parentFragmentManager.F0() != null) {
                    b F02 = parentFragmentManager.F0();
                    i.c(F02);
                    return F02;
                }
            }
            fragment = fragment.getParentFragment();
        }
        return f10190b;
    }

    public final void c(b bVar, final Violation violation) {
        Fragment a10 = violation.a();
        final String name = a10.getClass().getName();
        if (bVar.a().contains(Flag.PENALTY_LOG)) {
            Log.d("FragmentStrictMode", "Policy violation in " + name, violation);
        }
        bVar.b();
        if (bVar.a().contains(Flag.PENALTY_DEATH)) {
            o(a10, new Runnable() { // from class: S.a
                @Override // java.lang.Runnable
                public final void run() {
                    FragmentStrictMode.d(name, violation);
                }
            });
        }
    }

    public final void e(Violation violation) {
        if (FragmentManager.M0(3)) {
            Log.d("FragmentManager", "StrictMode violation in " + violation.a().getClass().getName(), violation);
        }
    }

    public final void o(Fragment fragment, Runnable runnable) {
        if (fragment.isAdded()) {
            Handler g10 = fragment.getParentFragmentManager().z0().g();
            i.e(g10, "fragment.parentFragmentManager.host.handler");
            if (i.b(g10.getLooper(), Looper.myLooper())) {
                runnable.run();
                return;
            } else {
                g10.post(runnable);
                return;
            }
        }
        runnable.run();
    }

    public final boolean p(b bVar, Class<? extends Fragment> cls, Class<? extends Violation> cls2) {
        boolean u10;
        Set<Class<? extends Violation>> set = bVar.c().get(cls.getName());
        if (set == null) {
            return true;
        }
        if (!i.b(cls2.getSuperclass(), Violation.class)) {
            u10 = CollectionsKt___CollectionsKt.u(set, cls2.getSuperclass());
            if (u10) {
                return false;
            }
        }
        return !set.contains(cls2);
    }
}
