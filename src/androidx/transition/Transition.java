package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowId;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import androidx.dynamicanimation.animation.c;
import androidx.transition.Transition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import p.C1415a;
import p.C1420f;

/* loaded from: classes.dex */
public abstract class Transition implements Cloneable {
    static final boolean DBG = false;
    private static final String LOG_TAG = "Transition";
    private static final int MATCH_FIRST = 1;
    public static final int MATCH_ID = 3;
    private static final String MATCH_ID_STR = "id";
    public static final int MATCH_INSTANCE = 1;
    private static final String MATCH_INSTANCE_STR = "instance";
    public static final int MATCH_ITEM_ID = 4;
    private static final String MATCH_ITEM_ID_STR = "itemId";
    private static final int MATCH_LAST = 4;
    public static final int MATCH_NAME = 2;
    private static final String MATCH_NAME_STR = "name";
    private ArrayList<C> mEndValuesList;
    private f mEpicenterCallback;
    private i[] mListenersCache;
    private C1415a<String, String> mNameOverrides;
    z mPropagation;
    h mSeekController;
    long mSeekOffsetInParent;
    private ArrayList<C> mStartValuesList;
    long mTotalDuration;
    private static final Animator[] EMPTY_ANIMATOR_ARRAY = new Animator[0];
    private static final int[] DEFAULT_MATCH_ORDER = {2, 1, 3, 4};
    private static final PathMotion STRAIGHT_PATH_MOTION = new a();
    private static ThreadLocal<C1415a<Animator, d>> sRunningAnimators = new ThreadLocal<>();
    private String mName = getClass().getName();
    private long mStartDelay = -1;
    long mDuration = -1;
    private TimeInterpolator mInterpolator = null;
    ArrayList<Integer> mTargetIds = new ArrayList<>();
    ArrayList<View> mTargets = new ArrayList<>();
    private ArrayList<String> mTargetNames = null;
    private ArrayList<Class<?>> mTargetTypes = null;
    private ArrayList<Integer> mTargetIdExcludes = null;
    private ArrayList<View> mTargetExcludes = null;
    private ArrayList<Class<?>> mTargetTypeExcludes = null;
    private ArrayList<String> mTargetNameExcludes = null;
    private ArrayList<Integer> mTargetIdChildExcludes = null;
    private ArrayList<View> mTargetChildExcludes = null;
    private ArrayList<Class<?>> mTargetTypeChildExcludes = null;
    private D mStartValues = new D();
    private D mEndValues = new D();
    TransitionSet mParent = null;
    private int[] mMatchOrder = DEFAULT_MATCH_ORDER;
    boolean mCanRemoveViews = false;
    ArrayList<Animator> mCurrentAnimators = new ArrayList<>();
    private Animator[] mAnimatorCache = EMPTY_ANIMATOR_ARRAY;
    int mNumInstances = 0;
    private boolean mPaused = false;
    boolean mEnded = false;
    private Transition mCloneParent = null;
    private ArrayList<i> mListeners = null;
    ArrayList<Animator> mAnimators = new ArrayList<>();
    private PathMotion mPathMotion = STRAIGHT_PATH_MOTION;

    /* loaded from: classes.dex */
    public class a extends PathMotion {
        @Override // androidx.transition.PathMotion
        public Path a(float f10, float f11, float f12, float f13) {
            Path path = new Path();
            path.moveTo(f10, f11);
            path.lineTo(f12, f13);
            return path;
        }
    }

    /* loaded from: classes.dex */
    public class b extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ C1415a f11644a;

        public b(C1415a c1415a) {
            this.f11644a = c1415a;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f11644a.remove(animator);
            Transition.this.mCurrentAnimators.remove(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Transition.this.mCurrentAnimators.add(animator);
        }
    }

    /* loaded from: classes.dex */
    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Transition.this.end();
            animator.removeListener(this);
        }
    }

    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public View f11647a;

        /* renamed from: b, reason: collision with root package name */
        public String f11648b;

        /* renamed from: c, reason: collision with root package name */
        public C f11649c;

        /* renamed from: d, reason: collision with root package name */
        public WindowId f11650d;

        /* renamed from: e, reason: collision with root package name */
        public Transition f11651e;

        /* renamed from: f, reason: collision with root package name */
        public Animator f11652f;

        public d(View view, String str, Transition transition, WindowId windowId, C c10, Animator animator) {
            this.f11647a = view;
            this.f11648b = str;
            this.f11649c = c10;
            this.f11650d = windowId;
            this.f11651e = transition;
            this.f11652f = animator;
        }
    }

    /* loaded from: classes.dex */
    public static class e {
        public static <T> ArrayList<T> a(ArrayList<T> arrayList, T t10) {
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            if (!arrayList.contains(t10)) {
                arrayList.add(t10);
            }
            return arrayList;
        }

        public static <T> ArrayList<T> b(ArrayList<T> arrayList, T t10) {
            if (arrayList != null) {
                arrayList.remove(t10);
                if (arrayList.isEmpty()) {
                    return null;
                }
                return arrayList;
            }
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class f {
        public abstract Rect a(Transition transition);
    }

    /* loaded from: classes.dex */
    public static class g {
        public static long a(Animator animator) {
            return animator.getTotalDuration();
        }

        public static void b(Animator animator, long j10) {
            ((AnimatorSet) animator).setCurrentPlayTime(j10);
        }
    }

    /* loaded from: classes.dex */
    public class h extends x implements A, c.r {

        /* renamed from: d, reason: collision with root package name */
        public boolean f11656d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f11657e;

        /* renamed from: a, reason: collision with root package name */
        public long f11653a = -1;

        /* renamed from: b, reason: collision with root package name */
        public ArrayList<I.a<A>> f11654b = null;

        /* renamed from: c, reason: collision with root package name */
        public ArrayList<I.a<A>> f11655c = null;

        /* renamed from: f, reason: collision with root package name */
        public I.a<A>[] f11658f = null;

        /* renamed from: g, reason: collision with root package name */
        public final F f11659g = new F();

        public h() {
        }

        @Override // androidx.transition.x, androidx.transition.Transition.i
        public void e(Transition transition) {
            this.f11657e = true;
        }

        public final void h() {
            ArrayList<I.a<A>> arrayList = this.f11655c;
            if (arrayList != null && !arrayList.isEmpty()) {
                int size = this.f11655c.size();
                if (this.f11658f == null) {
                    this.f11658f = new I.a[size];
                }
                I.a<A>[] aVarArr = (I.a[]) this.f11655c.toArray(this.f11658f);
                this.f11658f = null;
                for (int i10 = 0; i10 < size; i10++) {
                    aVarArr[i10].accept(this);
                    aVarArr[i10] = null;
                }
                this.f11658f = aVarArr;
            }
        }

        public long i() {
            return Transition.this.getTotalDurationMillis();
        }

        public void j() {
            long j10 = 0;
            if (i() == 0) {
                j10 = 1;
            }
            Transition.this.setCurrentPlayTimeMillis(j10, this.f11653a);
            this.f11653a = j10;
        }

        public void k() {
            this.f11656d = true;
            ArrayList<I.a<A>> arrayList = this.f11654b;
            if (arrayList != null) {
                this.f11654b = null;
                for (int i10 = 0; i10 < arrayList.size(); i10++) {
                    arrayList.get(i10).accept(this);
                }
            }
            h();
        }

        @Override // androidx.dynamicanimation.animation.c.r
        public void onAnimationUpdate(androidx.dynamicanimation.animation.c cVar, float f10, float f11) {
            long max = Math.max(-1L, Math.min(i() + 1, Math.round(f10)));
            Transition.this.setCurrentPlayTimeMillis(max, this.f11653a);
            this.f11653a = max;
            h();
        }
    }

    /* loaded from: classes.dex */
    public interface i {
        void a(Transition transition);

        void b(Transition transition);

        default void c(Transition transition, boolean z10) {
            d(transition);
        }

        void d(Transition transition);

        void e(Transition transition);

        default void f(Transition transition, boolean z10) {
            a(transition);
        }

        void g(Transition transition);
    }

    /* loaded from: classes.dex */
    public interface j {

        /* renamed from: a, reason: collision with root package name */
        public static final j f11661a = new j() { // from class: androidx.transition.s
            @Override // androidx.transition.Transition.j
            public final void a(Transition.i iVar, Transition transition, boolean z10) {
                iVar.f(transition, z10);
            }
        };

        /* renamed from: b, reason: collision with root package name */
        public static final j f11662b = new j() { // from class: androidx.transition.t
            @Override // androidx.transition.Transition.j
            public final void a(Transition.i iVar, Transition transition, boolean z10) {
                iVar.c(transition, z10);
            }
        };

        /* renamed from: c, reason: collision with root package name */
        public static final j f11663c = new j() { // from class: androidx.transition.u
            @Override // androidx.transition.Transition.j
            public final void a(Transition.i iVar, Transition transition, boolean z10) {
                iVar.e(transition);
            }
        };

        /* renamed from: d, reason: collision with root package name */
        public static final j f11664d = new j() { // from class: androidx.transition.v
            @Override // androidx.transition.Transition.j
            public final void a(Transition.i iVar, Transition transition, boolean z10) {
                iVar.b(transition);
            }
        };

        /* renamed from: e, reason: collision with root package name */
        public static final j f11665e = new j() { // from class: androidx.transition.w
            @Override // androidx.transition.Transition.j
            public final void a(Transition.i iVar, Transition transition, boolean z10) {
                iVar.g(transition);
            }
        };

        void a(i iVar, Transition transition, boolean z10);
    }

    public Transition() {
    }

    private void addUnmatched(C1415a<View, C> c1415a, C1415a<View, C> c1415a2) {
        for (int i10 = 0; i10 < c1415a.size(); i10++) {
            C l10 = c1415a.l(i10);
            if (isValidTarget(l10.f11528b)) {
                this.mStartValuesList.add(l10);
                this.mEndValuesList.add(null);
            }
        }
        for (int i11 = 0; i11 < c1415a2.size(); i11++) {
            C l11 = c1415a2.l(i11);
            if (isValidTarget(l11.f11528b)) {
                this.mEndValuesList.add(l11);
                this.mStartValuesList.add(null);
            }
        }
    }

    private static void addViewValues(D d10, View view, C c10) {
        d10.f11607a.put(view, c10);
        int id = view.getId();
        if (id >= 0) {
            if (d10.f11608b.indexOfKey(id) >= 0) {
                d10.f11608b.put(id, null);
            } else {
                d10.f11608b.put(id, view);
            }
        }
        String E10 = androidx.core.view.K.E(view);
        if (E10 != null) {
            if (d10.f11610d.containsKey(E10)) {
                d10.f11610d.put(E10, null);
            } else {
                d10.f11610d.put(E10, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (d10.f11609c.e(itemIdAtPosition) >= 0) {
                    View d11 = d10.f11609c.d(itemIdAtPosition);
                    if (d11 != null) {
                        d11.setHasTransientState(false);
                        d10.f11609c.h(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                view.setHasTransientState(true);
                d10.f11609c.h(itemIdAtPosition, view);
            }
        }
    }

    private static boolean alreadyContains(int[] iArr, int i10) {
        int i11 = iArr[i10];
        for (int i12 = 0; i12 < i10; i12++) {
            if (iArr[i12] == i11) {
                return true;
            }
        }
        return false;
    }

    private void captureHierarchy(View view, boolean z10) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        ArrayList<Integer> arrayList = this.mTargetIdExcludes;
        if (arrayList != null && arrayList.contains(Integer.valueOf(id))) {
            return;
        }
        ArrayList<View> arrayList2 = this.mTargetExcludes;
        if (arrayList2 != null && arrayList2.contains(view)) {
            return;
        }
        ArrayList<Class<?>> arrayList3 = this.mTargetTypeExcludes;
        if (arrayList3 != null) {
            int size = arrayList3.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (this.mTargetTypeExcludes.get(i10).isInstance(view)) {
                    return;
                }
            }
        }
        if (view.getParent() instanceof ViewGroup) {
            C c10 = new C(view);
            if (z10) {
                captureStartValues(c10);
            } else {
                captureEndValues(c10);
            }
            c10.f11529c.add(this);
            capturePropagationValues(c10);
            if (z10) {
                addViewValues(this.mStartValues, view, c10);
            } else {
                addViewValues(this.mEndValues, view, c10);
            }
        }
        if (view instanceof ViewGroup) {
            ArrayList<Integer> arrayList4 = this.mTargetIdChildExcludes;
            if (arrayList4 != null && arrayList4.contains(Integer.valueOf(id))) {
                return;
            }
            ArrayList<View> arrayList5 = this.mTargetChildExcludes;
            if (arrayList5 != null && arrayList5.contains(view)) {
                return;
            }
            ArrayList<Class<?>> arrayList6 = this.mTargetTypeChildExcludes;
            if (arrayList6 != null) {
                int size2 = arrayList6.size();
                for (int i11 = 0; i11 < size2; i11++) {
                    if (this.mTargetTypeChildExcludes.get(i11).isInstance(view)) {
                        return;
                    }
                }
            }
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i12 = 0; i12 < viewGroup.getChildCount(); i12++) {
                captureHierarchy(viewGroup.getChildAt(i12), z10);
            }
        }
    }

    private ArrayList<Integer> excludeId(ArrayList<Integer> arrayList, int i10, boolean z10) {
        if (i10 > 0) {
            if (z10) {
                return e.a(arrayList, Integer.valueOf(i10));
            }
            return e.b(arrayList, Integer.valueOf(i10));
        }
        return arrayList;
    }

    private static <T> ArrayList<T> excludeObject(ArrayList<T> arrayList, T t10, boolean z10) {
        if (t10 != null) {
            if (z10) {
                return e.a(arrayList, t10);
            }
            return e.b(arrayList, t10);
        }
        return arrayList;
    }

    private ArrayList<Class<?>> excludeType(ArrayList<Class<?>> arrayList, Class<?> cls, boolean z10) {
        if (cls != null) {
            if (z10) {
                return e.a(arrayList, cls);
            }
            return e.b(arrayList, cls);
        }
        return arrayList;
    }

    private ArrayList<View> excludeView(ArrayList<View> arrayList, View view, boolean z10) {
        if (view != null) {
            if (z10) {
                return e.a(arrayList, view);
            }
            return e.b(arrayList, view);
        }
        return arrayList;
    }

    private static C1415a<Animator, d> getRunningAnimators() {
        C1415a<Animator, d> c1415a = sRunningAnimators.get();
        if (c1415a == null) {
            C1415a<Animator, d> c1415a2 = new C1415a<>();
            sRunningAnimators.set(c1415a2);
            return c1415a2;
        }
        return c1415a;
    }

    private static boolean isValidMatch(int i10) {
        if (i10 >= 1 && i10 <= 4) {
            return true;
        }
        return false;
    }

    private static boolean isValueChanged(C c10, C c11, String str) {
        Object obj = c10.f11527a.get(str);
        Object obj2 = c11.f11527a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return !obj.equals(obj2);
    }

    private void matchIds(C1415a<View, C> c1415a, C1415a<View, C> c1415a2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            View valueAt = sparseArray.valueAt(i10);
            if (valueAt != null && isValidTarget(valueAt) && (view = sparseArray2.get(sparseArray.keyAt(i10))) != null && isValidTarget(view)) {
                C c10 = c1415a.get(valueAt);
                C c11 = c1415a2.get(view);
                if (c10 != null && c11 != null) {
                    this.mStartValuesList.add(c10);
                    this.mEndValuesList.add(c11);
                    c1415a.remove(valueAt);
                    c1415a2.remove(view);
                }
            }
        }
    }

    private void matchInstances(C1415a<View, C> c1415a, C1415a<View, C> c1415a2) {
        C remove;
        for (int size = c1415a.size() - 1; size >= 0; size--) {
            View h10 = c1415a.h(size);
            if (h10 != null && isValidTarget(h10) && (remove = c1415a2.remove(h10)) != null && isValidTarget(remove.f11528b)) {
                this.mStartValuesList.add(c1415a.j(size));
                this.mEndValuesList.add(remove);
            }
        }
    }

    private void matchItemIds(C1415a<View, C> c1415a, C1415a<View, C> c1415a2, C1420f<View> c1420f, C1420f<View> c1420f2) {
        View d10;
        int k10 = c1420f.k();
        for (int i10 = 0; i10 < k10; i10++) {
            View l10 = c1420f.l(i10);
            if (l10 != null && isValidTarget(l10) && (d10 = c1420f2.d(c1420f.g(i10))) != null && isValidTarget(d10)) {
                C c10 = c1415a.get(l10);
                C c11 = c1415a2.get(d10);
                if (c10 != null && c11 != null) {
                    this.mStartValuesList.add(c10);
                    this.mEndValuesList.add(c11);
                    c1415a.remove(l10);
                    c1415a2.remove(d10);
                }
            }
        }
    }

    private void matchNames(C1415a<View, C> c1415a, C1415a<View, C> c1415a2, C1415a<String, View> c1415a3, C1415a<String, View> c1415a4) {
        View view;
        int size = c1415a3.size();
        for (int i10 = 0; i10 < size; i10++) {
            View l10 = c1415a3.l(i10);
            if (l10 != null && isValidTarget(l10) && (view = c1415a4.get(c1415a3.h(i10))) != null && isValidTarget(view)) {
                C c10 = c1415a.get(l10);
                C c11 = c1415a2.get(view);
                if (c10 != null && c11 != null) {
                    this.mStartValuesList.add(c10);
                    this.mEndValuesList.add(c11);
                    c1415a.remove(l10);
                    c1415a2.remove(view);
                }
            }
        }
    }

    private void matchStartAndEnd(D d10, D d11) {
        C1415a<View, C> c1415a = new C1415a<>(d10.f11607a);
        C1415a<View, C> c1415a2 = new C1415a<>(d11.f11607a);
        int i10 = 0;
        while (true) {
            int[] iArr = this.mMatchOrder;
            if (i10 < iArr.length) {
                int i11 = iArr[i10];
                if (i11 != 1) {
                    if (i11 != 2) {
                        if (i11 != 3) {
                            if (i11 == 4) {
                                matchItemIds(c1415a, c1415a2, d10.f11609c, d11.f11609c);
                            }
                        } else {
                            matchIds(c1415a, c1415a2, d10.f11608b, d11.f11608b);
                        }
                    } else {
                        matchNames(c1415a, c1415a2, d10.f11610d, d11.f11610d);
                    }
                } else {
                    matchInstances(c1415a, c1415a2);
                }
                i10++;
            } else {
                addUnmatched(c1415a, c1415a2);
                return;
            }
        }
    }

    private void notifyFromTransition(Transition transition, j jVar, boolean z10) {
        Transition transition2 = this.mCloneParent;
        if (transition2 != null) {
            transition2.notifyFromTransition(transition, jVar, z10);
        }
        ArrayList<i> arrayList = this.mListeners;
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = this.mListeners.size();
            i[] iVarArr = this.mListenersCache;
            if (iVarArr == null) {
                iVarArr = new i[size];
            }
            this.mListenersCache = null;
            i[] iVarArr2 = (i[]) this.mListeners.toArray(iVarArr);
            for (int i10 = 0; i10 < size; i10++) {
                jVar.a(iVarArr2[i10], transition, z10);
                iVarArr2[i10] = null;
            }
            this.mListenersCache = iVarArr2;
        }
    }

    private static int[] parseMatchOrder(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        int[] iArr = new int[stringTokenizer.countTokens()];
        int i10 = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String trim = stringTokenizer.nextToken().trim();
            if (MATCH_ID_STR.equalsIgnoreCase(trim)) {
                iArr[i10] = 3;
            } else if (MATCH_INSTANCE_STR.equalsIgnoreCase(trim)) {
                iArr[i10] = 1;
            } else if ("name".equalsIgnoreCase(trim)) {
                iArr[i10] = 2;
            } else if (MATCH_ITEM_ID_STR.equalsIgnoreCase(trim)) {
                iArr[i10] = 4;
            } else if (trim.isEmpty()) {
                int[] iArr2 = new int[iArr.length - 1];
                System.arraycopy(iArr, 0, iArr2, 0, i10);
                i10--;
                iArr = iArr2;
            } else {
                throw new InflateException("Unknown match type in matchOrder: '" + trim + "'");
            }
            i10++;
        }
        return iArr;
    }

    private void runAnimator(Animator animator, C1415a<Animator, d> c1415a) {
        if (animator != null) {
            animator.addListener(new b(c1415a));
            animate(animator);
        }
    }

    public Transition addListener(i iVar) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList<>();
        }
        this.mListeners.add(iVar);
        return this;
    }

    public Transition addTarget(View view) {
        this.mTargets.add(view);
        return this;
    }

    public void animate(Animator animator) {
        if (animator == null) {
            end();
            return;
        }
        if (getDuration() >= 0) {
            animator.setDuration(getDuration());
        }
        if (getStartDelay() >= 0) {
            animator.setStartDelay(getStartDelay() + animator.getStartDelay());
        }
        if (getInterpolator() != null) {
            animator.setInterpolator(getInterpolator());
        }
        animator.addListener(new c());
        animator.start();
    }

    public void cancel() {
        int size = this.mCurrentAnimators.size();
        Animator[] animatorArr = (Animator[]) this.mCurrentAnimators.toArray(this.mAnimatorCache);
        this.mAnimatorCache = EMPTY_ANIMATOR_ARRAY;
        for (int i10 = size - 1; i10 >= 0; i10--) {
            Animator animator = animatorArr[i10];
            animatorArr[i10] = null;
            animator.cancel();
        }
        this.mAnimatorCache = animatorArr;
        notifyListeners(j.f11663c, false);
    }

    public abstract void captureEndValues(C c10);

    public void capturePropagationValues(C c10) {
        String[] b10;
        if (this.mPropagation == null || c10.f11527a.isEmpty() || (b10 = this.mPropagation.b()) == null) {
            return;
        }
        for (String str : b10) {
            if (!c10.f11527a.containsKey(str)) {
                this.mPropagation.a(c10);
                return;
            }
        }
    }

    public abstract void captureStartValues(C c10);

    public void captureValues(ViewGroup viewGroup, boolean z10) {
        ArrayList<String> arrayList;
        ArrayList<Class<?>> arrayList2;
        C1415a<String, String> c1415a;
        clearValues(z10);
        if ((this.mTargetIds.size() <= 0 && this.mTargets.size() <= 0) || (((arrayList = this.mTargetNames) != null && !arrayList.isEmpty()) || ((arrayList2 = this.mTargetTypes) != null && !arrayList2.isEmpty()))) {
            captureHierarchy(viewGroup, z10);
        } else {
            for (int i10 = 0; i10 < this.mTargetIds.size(); i10++) {
                View findViewById = viewGroup.findViewById(this.mTargetIds.get(i10).intValue());
                if (findViewById != null) {
                    C c10 = new C(findViewById);
                    if (z10) {
                        captureStartValues(c10);
                    } else {
                        captureEndValues(c10);
                    }
                    c10.f11529c.add(this);
                    capturePropagationValues(c10);
                    if (z10) {
                        addViewValues(this.mStartValues, findViewById, c10);
                    } else {
                        addViewValues(this.mEndValues, findViewById, c10);
                    }
                }
            }
            for (int i11 = 0; i11 < this.mTargets.size(); i11++) {
                View view = this.mTargets.get(i11);
                C c11 = new C(view);
                if (z10) {
                    captureStartValues(c11);
                } else {
                    captureEndValues(c11);
                }
                c11.f11529c.add(this);
                capturePropagationValues(c11);
                if (z10) {
                    addViewValues(this.mStartValues, view, c11);
                } else {
                    addViewValues(this.mEndValues, view, c11);
                }
            }
        }
        if (!z10 && (c1415a = this.mNameOverrides) != null) {
            int size = c1415a.size();
            ArrayList arrayList3 = new ArrayList(size);
            for (int i12 = 0; i12 < size; i12++) {
                arrayList3.add(this.mStartValues.f11610d.remove(this.mNameOverrides.h(i12)));
            }
            for (int i13 = 0; i13 < size; i13++) {
                View view2 = (View) arrayList3.get(i13);
                if (view2 != null) {
                    this.mStartValues.f11610d.put(this.mNameOverrides.l(i13), view2);
                }
            }
        }
    }

    public void clearValues(boolean z10) {
        if (z10) {
            this.mStartValues.f11607a.clear();
            this.mStartValues.f11608b.clear();
            this.mStartValues.f11609c.a();
        } else {
            this.mEndValues.f11607a.clear();
            this.mEndValues.f11608b.clear();
            this.mEndValues.f11609c.a();
        }
    }

    public Animator createAnimator(ViewGroup viewGroup, C c10, C c11) {
        return null;
    }

    public void createAnimators(ViewGroup viewGroup, D d10, D d11, ArrayList<C> arrayList, ArrayList<C> arrayList2) {
        boolean z10;
        Animator createAnimator;
        int i10;
        int i11;
        View view;
        Animator animator;
        C c10;
        C1415a<Animator, d> runningAnimators = getRunningAnimators();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        if (getRootTransition().mSeekController != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        long j10 = Long.MAX_VALUE;
        int i12 = 0;
        while (i12 < size) {
            C c11 = arrayList.get(i12);
            C c12 = arrayList2.get(i12);
            if (c11 != null && !c11.f11529c.contains(this)) {
                c11 = null;
            }
            if (c12 != null && !c12.f11529c.contains(this)) {
                c12 = null;
            }
            if ((c11 == null && c12 == null) || ((c11 != null && c12 != null && !isTransitionRequired(c11, c12)) || (createAnimator = createAnimator(viewGroup, c11, c12)) == null)) {
                i10 = size;
                i11 = i12;
            } else {
                if (c12 != null) {
                    view = c12.f11528b;
                    String[] transitionProperties = getTransitionProperties();
                    Animator animator2 = createAnimator;
                    if (transitionProperties != null && transitionProperties.length > 0) {
                        c10 = new C(view);
                        i10 = size;
                        C c13 = d11.f11607a.get(view);
                        if (c13 != null) {
                            int i13 = 0;
                            while (i13 < transitionProperties.length) {
                                Map<String, Object> map = c10.f11527a;
                                int i14 = i12;
                                String str = transitionProperties[i13];
                                map.put(str, c13.f11527a.get(str));
                                i13++;
                                i12 = i14;
                                transitionProperties = transitionProperties;
                            }
                        }
                        i11 = i12;
                        int size2 = runningAnimators.size();
                        int i15 = 0;
                        while (true) {
                            if (i15 >= size2) {
                                break;
                            }
                            d dVar = runningAnimators.get(runningAnimators.h(i15));
                            if (dVar.f11649c != null && dVar.f11647a == view && dVar.f11648b.equals(getName()) && dVar.f11649c.equals(c10)) {
                                animator2 = null;
                                break;
                            }
                            i15++;
                        }
                    } else {
                        i10 = size;
                        i11 = i12;
                        c10 = null;
                    }
                    animator = animator2;
                } else {
                    i10 = size;
                    i11 = i12;
                    view = c11.f11528b;
                    animator = createAnimator;
                    c10 = null;
                }
                if (animator != null) {
                    z zVar = this.mPropagation;
                    if (zVar != null) {
                        long c14 = zVar.c(viewGroup, this, c11, c12);
                        sparseIntArray.put(this.mAnimators.size(), (int) c14);
                        j10 = Math.min(c14, j10);
                    }
                    long j11 = j10;
                    d dVar2 = new d(view, getName(), this, viewGroup.getWindowId(), c10, animator);
                    if (z10) {
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.play(animator);
                        animator = animatorSet;
                    }
                    runningAnimators.put(animator, dVar2);
                    this.mAnimators.add(animator);
                    j10 = j11;
                }
            }
            i12 = i11 + 1;
            size = i10;
        }
        if (sparseIntArray.size() != 0) {
            for (int i16 = 0; i16 < sparseIntArray.size(); i16++) {
                d dVar3 = runningAnimators.get(this.mAnimators.get(sparseIntArray.keyAt(i16)));
                dVar3.f11652f.setStartDelay((sparseIntArray.valueAt(i16) - j10) + dVar3.f11652f.getStartDelay());
            }
        }
    }

    public A createSeekController() {
        h hVar = new h();
        this.mSeekController = hVar;
        addListener(hVar);
        return this.mSeekController;
    }

    public void end() {
        int i10 = this.mNumInstances - 1;
        this.mNumInstances = i10;
        if (i10 == 0) {
            notifyListeners(j.f11662b, false);
            for (int i11 = 0; i11 < this.mStartValues.f11609c.k(); i11++) {
                View l10 = this.mStartValues.f11609c.l(i11);
                if (l10 != null) {
                    l10.setHasTransientState(false);
                }
            }
            for (int i12 = 0; i12 < this.mEndValues.f11609c.k(); i12++) {
                View l11 = this.mEndValues.f11609c.l(i12);
                if (l11 != null) {
                    l11.setHasTransientState(false);
                }
            }
            this.mEnded = true;
        }
    }

    public Transition excludeChildren(View view, boolean z10) {
        this.mTargetChildExcludes = excludeView(this.mTargetChildExcludes, view, z10);
        return this;
    }

    public Transition excludeTarget(View view, boolean z10) {
        this.mTargetExcludes = excludeView(this.mTargetExcludes, view, z10);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void forceToEnd(ViewGroup viewGroup) {
        C1415a<Animator, d> runningAnimators = getRunningAnimators();
        int size = runningAnimators.size();
        if (viewGroup != null && size != 0) {
            WindowId windowId = viewGroup.getWindowId();
            C1415a c1415a = new C1415a(runningAnimators);
            runningAnimators.clear();
            for (int i10 = size - 1; i10 >= 0; i10--) {
                d dVar = (d) c1415a.l(i10);
                if (dVar.f11647a != null && windowId.equals(dVar.f11650d)) {
                    ((Animator) c1415a.h(i10)).end();
                }
            }
        }
    }

    public long getDuration() {
        return this.mDuration;
    }

    public Rect getEpicenter() {
        f fVar = this.mEpicenterCallback;
        if (fVar == null) {
            return null;
        }
        return fVar.a(this);
    }

    public f getEpicenterCallback() {
        return this.mEpicenterCallback;
    }

    public TimeInterpolator getInterpolator() {
        return this.mInterpolator;
    }

    public C getMatchedTransitionValues(View view, boolean z10) {
        ArrayList<C> arrayList;
        ArrayList<C> arrayList2;
        TransitionSet transitionSet = this.mParent;
        if (transitionSet != null) {
            return transitionSet.getMatchedTransitionValues(view, z10);
        }
        if (z10) {
            arrayList = this.mStartValuesList;
        } else {
            arrayList = this.mEndValuesList;
        }
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i10 = 0;
        while (true) {
            if (i10 < size) {
                C c10 = arrayList.get(i10);
                if (c10 == null) {
                    return null;
                }
                if (c10.f11528b == view) {
                    break;
                }
                i10++;
            } else {
                i10 = -1;
                break;
            }
        }
        if (i10 < 0) {
            return null;
        }
        if (z10) {
            arrayList2 = this.mEndValuesList;
        } else {
            arrayList2 = this.mStartValuesList;
        }
        return arrayList2.get(i10);
    }

    public String getName() {
        return this.mName;
    }

    public PathMotion getPathMotion() {
        return this.mPathMotion;
    }

    public z getPropagation() {
        return this.mPropagation;
    }

    public final Transition getRootTransition() {
        TransitionSet transitionSet = this.mParent;
        if (transitionSet != null) {
            return transitionSet.getRootTransition();
        }
        return this;
    }

    public long getStartDelay() {
        return this.mStartDelay;
    }

    public List<Integer> getTargetIds() {
        return this.mTargetIds;
    }

    public List<String> getTargetNames() {
        return this.mTargetNames;
    }

    public List<Class<?>> getTargetTypes() {
        return this.mTargetTypes;
    }

    public List<View> getTargets() {
        return this.mTargets;
    }

    public final long getTotalDurationMillis() {
        return this.mTotalDuration;
    }

    public String[] getTransitionProperties() {
        return null;
    }

    public C getTransitionValues(View view, boolean z10) {
        D d10;
        TransitionSet transitionSet = this.mParent;
        if (transitionSet != null) {
            return transitionSet.getTransitionValues(view, z10);
        }
        if (z10) {
            d10 = this.mStartValues;
        } else {
            d10 = this.mEndValues;
        }
        return d10.f11607a.get(view);
    }

    public boolean hasAnimators() {
        return !this.mCurrentAnimators.isEmpty();
    }

    public boolean isSeekingSupported() {
        return false;
    }

    public boolean isTransitionRequired(C c10, C c11) {
        if (c10 == null || c11 == null) {
            return false;
        }
        String[] transitionProperties = getTransitionProperties();
        if (transitionProperties != null) {
            for (String str : transitionProperties) {
                if (!isValueChanged(c10, c11, str)) {
                }
            }
            return false;
        }
        Iterator<String> it = c10.f11527a.keySet().iterator();
        while (it.hasNext()) {
            if (isValueChanged(c10, c11, it.next())) {
            }
        }
        return false;
        return true;
    }

    public boolean isValidTarget(View view) {
        ArrayList<Class<?>> arrayList;
        ArrayList<String> arrayList2;
        int id = view.getId();
        ArrayList<Integer> arrayList3 = this.mTargetIdExcludes;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id))) {
            return false;
        }
        ArrayList<View> arrayList4 = this.mTargetExcludes;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList<Class<?>> arrayList5 = this.mTargetTypeExcludes;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (this.mTargetTypeExcludes.get(i10).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.mTargetNameExcludes != null && androidx.core.view.K.E(view) != null && this.mTargetNameExcludes.contains(androidx.core.view.K.E(view))) {
            return false;
        }
        if ((this.mTargetIds.size() == 0 && this.mTargets.size() == 0 && (((arrayList = this.mTargetTypes) == null || arrayList.isEmpty()) && ((arrayList2 = this.mTargetNames) == null || arrayList2.isEmpty()))) || this.mTargetIds.contains(Integer.valueOf(id)) || this.mTargets.contains(view)) {
            return true;
        }
        ArrayList<String> arrayList6 = this.mTargetNames;
        if (arrayList6 != null && arrayList6.contains(androidx.core.view.K.E(view))) {
            return true;
        }
        if (this.mTargetTypes != null) {
            for (int i11 = 0; i11 < this.mTargetTypes.size(); i11++) {
                if (this.mTargetTypes.get(i11).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void notifyListeners(j jVar, boolean z10) {
        notifyFromTransition(this, jVar, z10);
    }

    public void pause(View view) {
        if (!this.mEnded) {
            int size = this.mCurrentAnimators.size();
            Animator[] animatorArr = (Animator[]) this.mCurrentAnimators.toArray(this.mAnimatorCache);
            this.mAnimatorCache = EMPTY_ANIMATOR_ARRAY;
            for (int i10 = size - 1; i10 >= 0; i10--) {
                Animator animator = animatorArr[i10];
                animatorArr[i10] = null;
                animator.pause();
            }
            this.mAnimatorCache = animatorArr;
            notifyListeners(j.f11664d, false);
            this.mPaused = true;
        }
    }

    public void playTransition(ViewGroup viewGroup) {
        d dVar;
        this.mStartValuesList = new ArrayList<>();
        this.mEndValuesList = new ArrayList<>();
        matchStartAndEnd(this.mStartValues, this.mEndValues);
        C1415a<Animator, d> runningAnimators = getRunningAnimators();
        int size = runningAnimators.size();
        WindowId windowId = viewGroup.getWindowId();
        for (int i10 = size - 1; i10 >= 0; i10--) {
            Animator h10 = runningAnimators.h(i10);
            if (h10 != null && (dVar = runningAnimators.get(h10)) != null && dVar.f11647a != null && windowId.equals(dVar.f11650d)) {
                C c10 = dVar.f11649c;
                View view = dVar.f11647a;
                C transitionValues = getTransitionValues(view, true);
                C matchedTransitionValues = getMatchedTransitionValues(view, true);
                if (transitionValues == null && matchedTransitionValues == null) {
                    matchedTransitionValues = this.mEndValues.f11607a.get(view);
                }
                if ((transitionValues != null || matchedTransitionValues != null) && dVar.f11651e.isTransitionRequired(c10, matchedTransitionValues)) {
                    Transition transition = dVar.f11651e;
                    if (transition.getRootTransition().mSeekController != null) {
                        h10.cancel();
                        transition.mCurrentAnimators.remove(h10);
                        runningAnimators.remove(h10);
                        if (transition.mCurrentAnimators.size() == 0) {
                            transition.notifyListeners(j.f11663c, false);
                            if (!transition.mEnded) {
                                transition.mEnded = true;
                                transition.notifyListeners(j.f11662b, false);
                            }
                        }
                    } else if (!h10.isRunning() && !h10.isStarted()) {
                        runningAnimators.remove(h10);
                    } else {
                        h10.cancel();
                    }
                }
            }
        }
        createAnimators(viewGroup, this.mStartValues, this.mEndValues, this.mStartValuesList, this.mEndValuesList);
        if (this.mSeekController == null) {
            runAnimators();
            return;
        }
        prepareAnimatorsForSeeking();
        this.mSeekController.j();
        this.mSeekController.k();
    }

    public void prepareAnimatorsForSeeking() {
        C1415a<Animator, d> runningAnimators = getRunningAnimators();
        this.mTotalDuration = 0L;
        for (int i10 = 0; i10 < this.mAnimators.size(); i10++) {
            Animator animator = this.mAnimators.get(i10);
            d dVar = runningAnimators.get(animator);
            if (animator != null && dVar != null) {
                if (getDuration() >= 0) {
                    dVar.f11652f.setDuration(getDuration());
                }
                if (getStartDelay() >= 0) {
                    dVar.f11652f.setStartDelay(getStartDelay() + dVar.f11652f.getStartDelay());
                }
                if (getInterpolator() != null) {
                    dVar.f11652f.setInterpolator(getInterpolator());
                }
                this.mCurrentAnimators.add(animator);
                this.mTotalDuration = Math.max(this.mTotalDuration, g.a(animator));
            }
        }
        this.mAnimators.clear();
    }

    public Transition removeListener(i iVar) {
        Transition transition;
        ArrayList<i> arrayList = this.mListeners;
        if (arrayList == null) {
            return this;
        }
        if (!arrayList.remove(iVar) && (transition = this.mCloneParent) != null) {
            transition.removeListener(iVar);
        }
        if (this.mListeners.size() == 0) {
            this.mListeners = null;
        }
        return this;
    }

    public Transition removeTarget(View view) {
        this.mTargets.remove(view);
        return this;
    }

    public void resume(View view) {
        if (this.mPaused) {
            if (!this.mEnded) {
                int size = this.mCurrentAnimators.size();
                Animator[] animatorArr = (Animator[]) this.mCurrentAnimators.toArray(this.mAnimatorCache);
                this.mAnimatorCache = EMPTY_ANIMATOR_ARRAY;
                for (int i10 = size - 1; i10 >= 0; i10--) {
                    Animator animator = animatorArr[i10];
                    animatorArr[i10] = null;
                    animator.resume();
                }
                this.mAnimatorCache = animatorArr;
                notifyListeners(j.f11665e, false);
            }
            this.mPaused = false;
        }
    }

    public void runAnimators() {
        start();
        C1415a<Animator, d> runningAnimators = getRunningAnimators();
        Iterator<Animator> it = this.mAnimators.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (runningAnimators.containsKey(next)) {
                start();
                runAnimator(next, runningAnimators);
            }
        }
        this.mAnimators.clear();
        end();
    }

    public void setCanRemoveViews(boolean z10) {
        this.mCanRemoveViews = z10;
    }

    public void setCurrentPlayTimeMillis(long j10, long j11) {
        boolean z10;
        long totalDurationMillis = getTotalDurationMillis();
        int i10 = 0;
        if (j10 < j11) {
            z10 = true;
        } else {
            z10 = false;
        }
        int i11 = (j11 > 0L ? 1 : (j11 == 0L ? 0 : -1));
        if ((i11 < 0 && j10 >= 0) || (j11 > totalDurationMillis && j10 <= totalDurationMillis)) {
            this.mEnded = false;
            notifyListeners(j.f11661a, z10);
        }
        Animator[] animatorArr = (Animator[]) this.mCurrentAnimators.toArray(this.mAnimatorCache);
        this.mAnimatorCache = EMPTY_ANIMATOR_ARRAY;
        for (int size = this.mCurrentAnimators.size(); i10 < size; size = size) {
            Animator animator = animatorArr[i10];
            animatorArr[i10] = null;
            g.b(animator, Math.min(Math.max(0L, j10), g.a(animator)));
            i10++;
            i11 = i11;
        }
        int i12 = i11;
        this.mAnimatorCache = animatorArr;
        if ((j10 > totalDurationMillis && j11 <= totalDurationMillis) || (j10 < 0 && i12 >= 0)) {
            if (j10 > totalDurationMillis) {
                this.mEnded = true;
            }
            notifyListeners(j.f11662b, z10);
        }
    }

    public Transition setDuration(long j10) {
        this.mDuration = j10;
        return this;
    }

    public void setEpicenterCallback(f fVar) {
        this.mEpicenterCallback = fVar;
    }

    public Transition setInterpolator(TimeInterpolator timeInterpolator) {
        this.mInterpolator = timeInterpolator;
        return this;
    }

    public void setMatchOrder(int... iArr) {
        if (iArr != null && iArr.length != 0) {
            for (int i10 = 0; i10 < iArr.length; i10++) {
                if (isValidMatch(iArr[i10])) {
                    if (alreadyContains(iArr, i10)) {
                        throw new IllegalArgumentException("matches contains a duplicate value");
                    }
                } else {
                    throw new IllegalArgumentException("matches contains invalid value");
                }
            }
            this.mMatchOrder = (int[]) iArr.clone();
            return;
        }
        this.mMatchOrder = DEFAULT_MATCH_ORDER;
    }

    public void setPathMotion(PathMotion pathMotion) {
        if (pathMotion == null) {
            this.mPathMotion = STRAIGHT_PATH_MOTION;
        } else {
            this.mPathMotion = pathMotion;
        }
    }

    public void setPropagation(z zVar) {
        this.mPropagation = zVar;
    }

    public Transition setStartDelay(long j10) {
        this.mStartDelay = j10;
        return this;
    }

    public void start() {
        if (this.mNumInstances == 0) {
            notifyListeners(j.f11661a, false);
            this.mEnded = false;
        }
        this.mNumInstances++;
    }

    public String toString() {
        return toString("");
    }

    public Transition addTarget(int i10) {
        if (i10 != 0) {
            this.mTargetIds.add(Integer.valueOf(i10));
        }
        return this;
    }

    @Override // 
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Transition mo0clone() {
        try {
            Transition transition = (Transition) super.clone();
            transition.mAnimators = new ArrayList<>();
            transition.mStartValues = new D();
            transition.mEndValues = new D();
            transition.mStartValuesList = null;
            transition.mEndValuesList = null;
            transition.mSeekController = null;
            transition.mCloneParent = this;
            transition.mListeners = null;
            return transition;
        } catch (CloneNotSupportedException e10) {
            throw new RuntimeException(e10);
        }
    }

    public Transition excludeChildren(int i10, boolean z10) {
        this.mTargetIdChildExcludes = excludeId(this.mTargetIdChildExcludes, i10, z10);
        return this;
    }

    public Transition excludeTarget(int i10, boolean z10) {
        this.mTargetIdExcludes = excludeId(this.mTargetIdExcludes, i10, z10);
        return this;
    }

    public Transition removeTarget(int i10) {
        if (i10 != 0) {
            this.mTargetIds.remove(Integer.valueOf(i10));
        }
        return this;
    }

    public String toString(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(getClass().getSimpleName());
        sb.append("@");
        sb.append(Integer.toHexString(hashCode()));
        sb.append(": ");
        if (this.mDuration != -1) {
            sb.append("dur(");
            sb.append(this.mDuration);
            sb.append(") ");
        }
        if (this.mStartDelay != -1) {
            sb.append("dly(");
            sb.append(this.mStartDelay);
            sb.append(") ");
        }
        if (this.mInterpolator != null) {
            sb.append("interp(");
            sb.append(this.mInterpolator);
            sb.append(") ");
        }
        if (this.mTargetIds.size() > 0 || this.mTargets.size() > 0) {
            sb.append("tgts(");
            if (this.mTargetIds.size() > 0) {
                for (int i10 = 0; i10 < this.mTargetIds.size(); i10++) {
                    if (i10 > 0) {
                        sb.append(", ");
                    }
                    sb.append(this.mTargetIds.get(i10));
                }
            }
            if (this.mTargets.size() > 0) {
                for (int i11 = 0; i11 < this.mTargets.size(); i11++) {
                    if (i11 > 0) {
                        sb.append(", ");
                    }
                    sb.append(this.mTargets.get(i11));
                }
            }
            sb.append(")");
        }
        return sb.toString();
    }

    public Transition addTarget(String str) {
        if (this.mTargetNames == null) {
            this.mTargetNames = new ArrayList<>();
        }
        this.mTargetNames.add(str);
        return this;
    }

    public Transition excludeChildren(Class<?> cls, boolean z10) {
        this.mTargetTypeChildExcludes = excludeType(this.mTargetTypeChildExcludes, cls, z10);
        return this;
    }

    public Transition excludeTarget(String str, boolean z10) {
        this.mTargetNameExcludes = excludeObject(this.mTargetNameExcludes, str, z10);
        return this;
    }

    public Transition removeTarget(String str) {
        ArrayList<String> arrayList = this.mTargetNames;
        if (arrayList != null) {
            arrayList.remove(str);
        }
        return this;
    }

    public Transition excludeTarget(Class<?> cls, boolean z10) {
        this.mTargetTypeExcludes = excludeType(this.mTargetTypeExcludes, cls, z10);
        return this;
    }

    public Transition removeTarget(Class<?> cls) {
        ArrayList<Class<?>> arrayList = this.mTargetTypes;
        if (arrayList != null) {
            arrayList.remove(cls);
        }
        return this;
    }

    public Transition addTarget(Class<?> cls) {
        if (this.mTargetTypes == null) {
            this.mTargetTypes = new ArrayList<>();
        }
        this.mTargetTypes.add(cls);
        return this;
    }

    public Transition(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.f11742c);
        XmlResourceParser xmlResourceParser = (XmlResourceParser) attributeSet;
        long k10 = A.k.k(obtainStyledAttributes, xmlResourceParser, "duration", 1, -1);
        if (k10 >= 0) {
            setDuration(k10);
        }
        long k11 = A.k.k(obtainStyledAttributes, xmlResourceParser, "startDelay", 2, -1);
        if (k11 > 0) {
            setStartDelay(k11);
        }
        int l10 = A.k.l(obtainStyledAttributes, xmlResourceParser, "interpolator", 0, 0);
        if (l10 > 0) {
            setInterpolator(AnimationUtils.loadInterpolator(context, l10));
        }
        String m10 = A.k.m(obtainStyledAttributes, xmlResourceParser, "matchOrder", 3);
        if (m10 != null) {
            setMatchOrder(parseMatchOrder(m10));
        }
        obtainStyledAttributes.recycle();
    }
}
