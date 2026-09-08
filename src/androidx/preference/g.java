package androidx.preference;

import android.R;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC0472c;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.preference.DialogPreference;
import androidx.preference.PreferenceGroup;
import androidx.preference.j;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: PreferenceFragmentCompat.java */
/* loaded from: classes.dex */
public abstract class g extends Fragment implements j.c, j.a, j.b, DialogPreference.a {
    public static final String ARG_PREFERENCE_ROOT = "androidx.preference.PreferenceFragmentCompat.PREFERENCE_ROOT";
    private static final String DIALOG_FRAGMENT_TAG = "androidx.preference.PreferenceFragment.DIALOG";
    private static final int MSG_BIND_PREFERENCES = 1;
    private static final String PREFERENCES_TAG = "android:preferences";
    private static final String TAG = "PreferenceFragment";
    private boolean mHavePrefs;
    private boolean mInitDone;
    RecyclerView mList;
    private j mPreferenceManager;
    private Runnable mSelectPreferenceRunnable;
    private final d mDividerDecoration = new d();
    private int mLayoutResId = p.f10650c;
    private final Handler mHandler = new a(Looper.getMainLooper());
    private final Runnable mRequestFocus = new b();

    /* compiled from: PreferenceFragmentCompat.java */
    /* loaded from: classes.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                g.this.bindPreferences();
            }
        }
    }

    /* compiled from: PreferenceFragmentCompat.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = g.this.mList;
            recyclerView.focusableViewAvailable(recyclerView);
        }
    }

    /* compiled from: PreferenceFragmentCompat.java */
    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Preference f10577a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f10578b;

        public c(Preference preference, String str) {
            this.f10577a = preference;
            this.f10578b = str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            int f10;
            RecyclerView.Adapter adapter = g.this.mList.getAdapter();
            if (!(adapter instanceof PreferenceGroup.c)) {
                if (adapter == 0) {
                    return;
                } else {
                    throw new IllegalStateException("Adapter must implement PreferencePositionCallback");
                }
            }
            Preference preference = this.f10577a;
            if (preference != null) {
                f10 = ((PreferenceGroup.c) adapter).d(preference);
            } else {
                f10 = ((PreferenceGroup.c) adapter).f(this.f10578b);
            }
            if (f10 != -1) {
                g.this.mList.scrollToPosition(f10);
            } else {
                adapter.registerAdapterDataObserver(new h(adapter, g.this.mList, this.f10577a, this.f10578b));
            }
        }
    }

    /* compiled from: PreferenceFragmentCompat.java */
    /* loaded from: classes.dex */
    public class d extends RecyclerView.n {

        /* renamed from: a, reason: collision with root package name */
        public Drawable f10580a;

        /* renamed from: b, reason: collision with root package name */
        public int f10581b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f10582c = true;

        public d() {
        }

        public void d(boolean z10) {
            this.f10582c = z10;
        }

        public void e(Drawable drawable) {
            if (drawable != null) {
                this.f10581b = drawable.getIntrinsicHeight();
            } else {
                this.f10581b = 0;
            }
            this.f10580a = drawable;
            g.this.mList.invalidateItemDecorations();
        }

        public void f(int i10) {
            this.f10581b = i10;
            g.this.mList.invalidateItemDecorations();
        }

        public final boolean g(View view, RecyclerView recyclerView) {
            RecyclerView.B childViewHolder = recyclerView.getChildViewHolder(view);
            boolean z10 = false;
            if (!(childViewHolder instanceof l) || !((l) childViewHolder).g()) {
                return false;
            }
            boolean z11 = this.f10582c;
            int indexOfChild = recyclerView.indexOfChild(view);
            if (indexOfChild < recyclerView.getChildCount() - 1) {
                RecyclerView.B childViewHolder2 = recyclerView.getChildViewHolder(recyclerView.getChildAt(indexOfChild + 1));
                if ((childViewHolder2 instanceof l) && ((l) childViewHolder2).f()) {
                    z10 = true;
                }
                return z10;
            }
            return z11;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.n
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.y yVar) {
            if (g(view, recyclerView)) {
                rect.bottom = this.f10581b;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.n
        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.y yVar) {
            if (this.f10580a == null) {
                return;
            }
            int childCount = recyclerView.getChildCount();
            int width = recyclerView.getWidth();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = recyclerView.getChildAt(i10);
                if (g(childAt, recyclerView)) {
                    int y10 = ((int) childAt.getY()) + childAt.getHeight();
                    this.f10580a.setBounds(0, y10, width, this.f10581b + y10);
                    this.f10580a.draw(canvas);
                }
            }
        }
    }

    /* compiled from: PreferenceFragmentCompat.java */
    /* loaded from: classes.dex */
    public interface e {
        boolean a(g gVar, Preference preference);
    }

    /* compiled from: PreferenceFragmentCompat.java */
    /* loaded from: classes.dex */
    public interface f {
        boolean a(g gVar, Preference preference);
    }

    /* compiled from: PreferenceFragmentCompat.java */
    /* renamed from: androidx.preference.g$g, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0132g {
        boolean a(g gVar, PreferenceScreen preferenceScreen);
    }

    /* compiled from: PreferenceFragmentCompat.java */
    /* loaded from: classes.dex */
    public static class h extends RecyclerView.i {

        /* renamed from: a, reason: collision with root package name */
        public final RecyclerView.Adapter<?> f10584a;

        /* renamed from: b, reason: collision with root package name */
        public final RecyclerView f10585b;

        /* renamed from: c, reason: collision with root package name */
        public final Preference f10586c;

        /* renamed from: d, reason: collision with root package name */
        public final String f10587d;

        public h(RecyclerView.Adapter<?> adapter, RecyclerView recyclerView, Preference preference, String str) {
            this.f10584a = adapter;
            this.f10585b = recyclerView;
            this.f10586c = preference;
            this.f10587d = str;
        }

        public final void a() {
            int f10;
            this.f10584a.unregisterAdapterDataObserver(this);
            Preference preference = this.f10586c;
            if (preference != null) {
                f10 = ((PreferenceGroup.c) this.f10584a).d(preference);
            } else {
                f10 = ((PreferenceGroup.c) this.f10584a).f(this.f10587d);
            }
            if (f10 != -1) {
                this.f10585b.scrollToPosition(f10);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void onChanged() {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void onItemRangeChanged(int i10, int i11) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void onItemRangeInserted(int i10, int i11) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void onItemRangeMoved(int i10, int i11, int i12) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void onItemRangeRemoved(int i10, int i11) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void onItemRangeChanged(int i10, int i11, Object obj) {
            a();
        }
    }

    private void postBindPreferences() {
        if (this.mHandler.hasMessages(1)) {
            return;
        }
        this.mHandler.obtainMessage(1).sendToTarget();
    }

    private void requirePreferenceManager() {
        if (this.mPreferenceManager != null) {
        } else {
            throw new RuntimeException("This should be called after super.onCreate.");
        }
    }

    private void scrollToPreferenceInternal(Preference preference, String str) {
        c cVar = new c(preference, str);
        if (this.mList == null) {
            this.mSelectPreferenceRunnable = cVar;
        } else {
            cVar.run();
        }
    }

    private void unbindPreferences() {
        getListView().setAdapter(null);
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        if (preferenceScreen != null) {
            preferenceScreen.onDetached();
        }
        onUnbindPreferences();
    }

    public void addPreferencesFromResource(int i10) {
        requirePreferenceManager();
        setPreferenceScreen(this.mPreferenceManager.m(requireContext(), i10, getPreferenceScreen()));
    }

    public void bindPreferences() {
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        if (preferenceScreen != null) {
            getListView().setAdapter(onCreateAdapter(preferenceScreen));
            preferenceScreen.onAttached();
        }
        onBindPreferences();
    }

    @Override // androidx.preference.DialogPreference.a
    public <T extends Preference> T findPreference(CharSequence charSequence) {
        j jVar = this.mPreferenceManager;
        if (jVar == null) {
            return null;
        }
        return (T) jVar.a(charSequence);
    }

    public Fragment getCallbackFragment() {
        return null;
    }

    public final RecyclerView getListView() {
        return this.mList;
    }

    public j getPreferenceManager() {
        return this.mPreferenceManager;
    }

    public PreferenceScreen getPreferenceScreen() {
        return this.mPreferenceManager.k();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        TypedValue typedValue = new TypedValue();
        requireContext().getTheme().resolveAttribute(m.f10637i, typedValue, true);
        int i10 = typedValue.resourceId;
        if (i10 == 0) {
            i10 = r.f10657a;
        }
        requireContext().getTheme().applyStyle(i10, false);
        j jVar = new j(requireContext());
        this.mPreferenceManager = jVar;
        jVar.p(this);
        if (getArguments() != null) {
            str = getArguments().getString(ARG_PREFERENCE_ROOT);
        } else {
            str = null;
        }
        onCreatePreferences(bundle, str);
    }

    public RecyclerView.Adapter onCreateAdapter(PreferenceScreen preferenceScreen) {
        return new androidx.preference.h(preferenceScreen);
    }

    public RecyclerView.o onCreateLayoutManager() {
        return new LinearLayoutManager(requireContext());
    }

    public abstract void onCreatePreferences(Bundle bundle, String str);

    public RecyclerView onCreateRecyclerView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RecyclerView recyclerView;
        if (requireContext().getPackageManager().hasSystemFeature("android.hardware.type.automotive") && (recyclerView = (RecyclerView) viewGroup.findViewById(o.f10643b)) != null) {
            return recyclerView;
        }
        RecyclerView recyclerView2 = (RecyclerView) layoutInflater.inflate(p.f10651d, viewGroup, false);
        recyclerView2.setLayoutManager(onCreateLayoutManager());
        recyclerView2.setAccessibilityDelegateCompat(new k(recyclerView2));
        return recyclerView2;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        TypedArray obtainStyledAttributes = requireContext().obtainStyledAttributes(null, s.f10763v0, m.f10634f, 0);
        this.mLayoutResId = obtainStyledAttributes.getResourceId(s.f10765w0, this.mLayoutResId);
        Drawable drawable = obtainStyledAttributes.getDrawable(s.f10767x0);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(s.f10769y0, -1);
        boolean z10 = obtainStyledAttributes.getBoolean(s.f10771z0, true);
        obtainStyledAttributes.recycle();
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(requireContext());
        View inflate = cloneInContext.inflate(this.mLayoutResId, viewGroup, false);
        View findViewById = inflate.findViewById(R.id.list_container);
        if (findViewById instanceof ViewGroup) {
            ViewGroup viewGroup2 = (ViewGroup) findViewById;
            RecyclerView onCreateRecyclerView = onCreateRecyclerView(cloneInContext, viewGroup2, bundle);
            if (onCreateRecyclerView != null) {
                this.mList = onCreateRecyclerView;
                onCreateRecyclerView.addItemDecoration(this.mDividerDecoration);
                setDivider(drawable);
                if (dimensionPixelSize != -1) {
                    setDividerHeight(dimensionPixelSize);
                }
                this.mDividerDecoration.d(z10);
                if (this.mList.getParent() == null) {
                    viewGroup2.addView(this.mList);
                }
                this.mHandler.post(this.mRequestFocus);
                return inflate;
            }
            throw new RuntimeException("Could not create RecyclerView");
        }
        throw new IllegalStateException("Content has view with id attribute 'android.R.id.list_container' that is not a ViewGroup class");
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.mHandler.removeCallbacks(this.mRequestFocus);
        this.mHandler.removeMessages(1);
        if (this.mHavePrefs) {
            unbindPreferences();
        }
        this.mList = null;
        super.onDestroyView();
    }

    @Override // androidx.preference.j.a
    public void onDisplayPreferenceDialog(Preference preference) {
        boolean z10;
        DialogInterfaceOnCancelListenerC0472c newInstance;
        if (getCallbackFragment() instanceof e) {
            z10 = ((e) getCallbackFragment()).a(this, preference);
        } else {
            z10 = false;
        }
        for (Fragment fragment = this; !z10 && fragment != null; fragment = fragment.getParentFragment()) {
            if (fragment instanceof e) {
                z10 = ((e) fragment).a(this, preference);
            }
        }
        if (!z10 && (getContext() instanceof e)) {
            z10 = ((e) getContext()).a(this, preference);
        }
        if (!z10 && (getActivity() instanceof e)) {
            z10 = ((e) getActivity()).a(this, preference);
        }
        if (z10 || getParentFragmentManager().m0(DIALOG_FRAGMENT_TAG) != null) {
            return;
        }
        if (preference instanceof EditTextPreference) {
            newInstance = androidx.preference.a.newInstance(preference.getKey());
        } else if (preference instanceof ListPreference) {
            newInstance = androidx.preference.c.newInstance(preference.getKey());
        } else if (preference instanceof MultiSelectListPreference) {
            newInstance = androidx.preference.d.newInstance(preference.getKey());
        } else {
            throw new IllegalArgumentException("Cannot display dialog for an unknown Preference type: " + preference.getClass().getSimpleName() + ". Make sure to implement onPreferenceDisplayDialog() to handle displaying a custom dialog for this Preference.");
        }
        newInstance.setTargetFragment(this, 0);
        newInstance.show(getParentFragmentManager(), DIALOG_FRAGMENT_TAG);
    }

    @Override // androidx.preference.j.b
    public void onNavigateToScreen(PreferenceScreen preferenceScreen) {
        boolean z10;
        if (getCallbackFragment() instanceof InterfaceC0132g) {
            z10 = ((InterfaceC0132g) getCallbackFragment()).a(this, preferenceScreen);
        } else {
            z10 = false;
        }
        for (Fragment fragment = this; !z10 && fragment != null; fragment = fragment.getParentFragment()) {
            if (fragment instanceof InterfaceC0132g) {
                z10 = ((InterfaceC0132g) fragment).a(this, preferenceScreen);
            }
        }
        if (!z10 && (getContext() instanceof InterfaceC0132g)) {
            z10 = ((InterfaceC0132g) getContext()).a(this, preferenceScreen);
        }
        if (!z10 && (getActivity() instanceof InterfaceC0132g)) {
            ((InterfaceC0132g) getActivity()).a(this, preferenceScreen);
        }
    }

    @Override // androidx.preference.j.c
    public boolean onPreferenceTreeClick(Preference preference) {
        boolean z10;
        if (preference.getFragment() == null) {
            return false;
        }
        if (getCallbackFragment() instanceof f) {
            z10 = ((f) getCallbackFragment()).a(this, preference);
        } else {
            z10 = false;
        }
        for (Fragment fragment = this; !z10 && fragment != null; fragment = fragment.getParentFragment()) {
            if (fragment instanceof f) {
                z10 = ((f) fragment).a(this, preference);
            }
        }
        if (!z10 && (getContext() instanceof f)) {
            z10 = ((f) getContext()).a(this, preference);
        }
        if (!z10 && (getActivity() instanceof f)) {
            z10 = ((f) getActivity()).a(this, preference);
        }
        if (!z10) {
            Log.w(TAG, "onPreferenceStartFragment is not implemented in the parent activity - attempting to use a fallback implementation. You should implement this method so that you can configure the new fragment that will be displayed, and set a transition between the fragments.");
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Bundle extras = preference.getExtras();
            Fragment a10 = parentFragmentManager.x0().a(requireActivity().getClassLoader(), preference.getFragment());
            a10.setArguments(extras);
            a10.setTargetFragment(this, 0);
            parentFragmentManager.p().s(((View) requireView().getParent()).getId(), a10).g(null).i();
            return true;
        }
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        if (preferenceScreen != null) {
            Bundle bundle2 = new Bundle();
            preferenceScreen.saveHierarchyState(bundle2);
            bundle.putBundle(PREFERENCES_TAG, bundle2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.mPreferenceManager.q(this);
        this.mPreferenceManager.o(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.mPreferenceManager.q(null);
        this.mPreferenceManager.o(null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Bundle bundle2;
        PreferenceScreen preferenceScreen;
        super.onViewCreated(view, bundle);
        if (bundle != null && (bundle2 = bundle.getBundle(PREFERENCES_TAG)) != null && (preferenceScreen = getPreferenceScreen()) != null) {
            preferenceScreen.restoreHierarchyState(bundle2);
        }
        if (this.mHavePrefs) {
            bindPreferences();
            Runnable runnable = this.mSelectPreferenceRunnable;
            if (runnable != null) {
                runnable.run();
                this.mSelectPreferenceRunnable = null;
            }
        }
        this.mInitDone = true;
    }

    public void scrollToPreference(String str) {
        scrollToPreferenceInternal(null, str);
    }

    public void setDivider(Drawable drawable) {
        this.mDividerDecoration.e(drawable);
    }

    public void setDividerHeight(int i10) {
        this.mDividerDecoration.f(i10);
    }

    public void setPreferenceScreen(PreferenceScreen preferenceScreen) {
        if (this.mPreferenceManager.r(preferenceScreen) && preferenceScreen != null) {
            onUnbindPreferences();
            this.mHavePrefs = true;
            if (this.mInitDone) {
                postBindPreferences();
            }
        }
    }

    public void setPreferencesFromResource(int i10, String str) {
        requirePreferenceManager();
        PreferenceScreen m10 = this.mPreferenceManager.m(requireContext(), i10, null);
        Object obj = m10;
        if (str != null) {
            Object findPreference = m10.findPreference(str);
            boolean z10 = findPreference instanceof PreferenceScreen;
            obj = findPreference;
            if (!z10) {
                throw new IllegalArgumentException("Preference object with key " + str + " is not a PreferenceScreen");
            }
        }
        setPreferenceScreen((PreferenceScreen) obj);
    }

    public void scrollToPreference(Preference preference) {
        scrollToPreferenceInternal(preference, null);
    }

    public void onBindPreferences() {
    }

    public void onUnbindPreferences() {
    }
}
