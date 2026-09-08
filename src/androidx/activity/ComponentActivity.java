package androidx.activity;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.IntentSenderRequest;
import androidx.core.view.C0462q;
import androidx.core.view.InterfaceC0459n;
import androidx.core.view.InterfaceC0463s;
import androidx.lifecycle.B;
import androidx.lifecycle.E;
import androidx.lifecycle.InterfaceC0485h;
import androidx.lifecycle.InterfaceC0489l;
import androidx.lifecycle.InterfaceC0492o;
import androidx.lifecycle.K;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.M;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.savedstate.a;
import b.C0512a;
import b.InterfaceC0513b;
import c.AbstractC0540a;
import i0.C1089a;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import v9.InterfaceC1637a;

/* loaded from: classes.dex */
public class ComponentActivity extends androidx.core.app.ComponentActivity implements InterfaceC0492o, N, InterfaceC0485h, d0.d, p, androidx.activity.result.c, androidx.core.content.c, androidx.core.content.d, androidx.core.app.j, androidx.core.app.k, InterfaceC0459n, m {
    private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    private final ActivityResultRegistry mActivityResultRegistry;
    private int mContentLayoutId;
    final C0512a mContextAwareHelper;
    private K.b mDefaultFactory;
    private boolean mDispatchingOnMultiWindowModeChanged;
    private boolean mDispatchingOnPictureInPictureModeChanged;
    final l mFullyDrawnReporter;
    private final androidx.lifecycle.q mLifecycleRegistry;
    private final C0462q mMenuHostHelper;
    private final AtomicInteger mNextLocalRequestCode;
    private OnBackPressedDispatcher mOnBackPressedDispatcher;
    private final CopyOnWriteArrayList<I.a<Configuration>> mOnConfigurationChangedListeners;
    private final CopyOnWriteArrayList<I.a<androidx.core.app.f>> mOnMultiWindowModeChangedListeners;
    private final CopyOnWriteArrayList<I.a<Intent>> mOnNewIntentListeners;
    private final CopyOnWriteArrayList<I.a<androidx.core.app.l>> mOnPictureInPictureModeChangedListeners;
    private final CopyOnWriteArrayList<I.a<Integer>> mOnTrimMemoryListeners;
    final f mReportFullyDrawnExecutor;
    final d0.c mSavedStateRegistryController;
    private M mViewModelStore;

    /* loaded from: classes.dex */
    public class a extends ActivityResultRegistry {

        /* renamed from: androidx.activity.ComponentActivity$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0099a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f7060a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ AbstractC0540a.C0147a f7061b;

            public RunnableC0099a(int i10, AbstractC0540a.C0147a c0147a) {
                this.f7060a = i10;
                this.f7061b = c0147a;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.c(this.f7060a, this.f7061b.a());
            }
        }

        /* loaded from: classes.dex */
        public class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f7063a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ IntentSender.SendIntentException f7064b;

            public b(int i10, IntentSender.SendIntentException sendIntentException) {
                this.f7063a = i10;
                this.f7064b = sendIntentException;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.b(this.f7063a, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", this.f7064b));
            }
        }

        public a() {
        }

        @Override // androidx.activity.result.ActivityResultRegistry
        public <I, O> void f(int i10, AbstractC0540a<I, O> abstractC0540a, I i11, androidx.core.app.b bVar) {
            Bundle bundle;
            ComponentActivity componentActivity = ComponentActivity.this;
            AbstractC0540a.C0147a<O> b10 = abstractC0540a.b(componentActivity, i11);
            if (b10 != null) {
                new Handler(Looper.getMainLooper()).post(new RunnableC0099a(i10, b10));
                return;
            }
            Intent a10 = abstractC0540a.a(componentActivity, i11);
            if (a10.getExtras() != null && a10.getExtras().getClassLoader() == null) {
                a10.setExtrasClassLoader(componentActivity.getClassLoader());
            }
            if (a10.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
                Bundle bundleExtra = a10.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                a10.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                bundle = bundleExtra;
            } else {
                bundle = null;
            }
            if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(a10.getAction())) {
                String[] stringArrayExtra = a10.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                if (stringArrayExtra == null) {
                    stringArrayExtra = new String[0];
                }
                androidx.core.app.a.q(componentActivity, stringArrayExtra, i10);
                return;
            }
            if ("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(a10.getAction())) {
                IntentSenderRequest intentSenderRequest = (IntentSenderRequest) a10.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
                try {
                    androidx.core.app.a.v(componentActivity, intentSenderRequest.h(), i10, intentSenderRequest.b(), intentSenderRequest.d(), intentSenderRequest.f(), 0, bundle);
                    return;
                } catch (IntentSender.SendIntentException e10) {
                    new Handler(Looper.getMainLooper()).post(new b(i10, e10));
                    return;
                }
            }
            androidx.core.app.a.u(componentActivity, a10, i10, bundle);
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ComponentActivity.super.onBackPressed();
            } catch (IllegalStateException e10) {
                if (TextUtils.equals(e10.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                } else {
                    throw e10;
                }
            } catch (NullPointerException e11) {
                if (!TextUtils.equals(e11.getMessage(), "Attempt to invoke virtual method 'android.os.Handler android.app.FragmentHostCallback.getHandler()' on a null object reference")) {
                    throw e11;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        public static void a(View view) {
            view.cancelPendingInputEvents();
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        public static OnBackInvokedDispatcher a(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }
    }

    /* loaded from: classes.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public Object f7067a;

        /* renamed from: b, reason: collision with root package name */
        public M f7068b;
    }

    /* loaded from: classes.dex */
    public interface f extends Executor {
        void T(View view);

        void f();
    }

    /* loaded from: classes.dex */
    public class g implements f, ViewTreeObserver.OnDrawListener, Runnable {

        /* renamed from: b, reason: collision with root package name */
        public Runnable f7070b;

        /* renamed from: a, reason: collision with root package name */
        public final long f7069a = SystemClock.uptimeMillis() + 10000;

        /* renamed from: c, reason: collision with root package name */
        public boolean f7071c = false;

        public g() {
        }

        @Override // androidx.activity.ComponentActivity.f
        public void T(View view) {
            if (!this.f7071c) {
                this.f7071c = true;
                view.getViewTreeObserver().addOnDrawListener(this);
            }
        }

        public final /* synthetic */ void b() {
            Runnable runnable = this.f7070b;
            if (runnable != null) {
                runnable.run();
                this.f7070b = null;
            }
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f7070b = runnable;
            View decorView = ComponentActivity.this.getWindow().getDecorView();
            if (this.f7071c) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    decorView.invalidate();
                    return;
                } else {
                    decorView.postInvalidate();
                    return;
                }
            }
            decorView.postOnAnimation(new Runnable() { // from class: androidx.activity.h
                @Override // java.lang.Runnable
                public final void run() {
                    ComponentActivity.g.this.b();
                }
            });
        }

        @Override // androidx.activity.ComponentActivity.f
        public void f() {
            ComponentActivity.this.getWindow().getDecorView().removeCallbacks(this);
            ComponentActivity.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            Runnable runnable = this.f7070b;
            if (runnable != null) {
                runnable.run();
                this.f7070b = null;
                if (ComponentActivity.this.mFullyDrawnReporter.c()) {
                    this.f7071c = false;
                    ComponentActivity.this.getWindow().getDecorView().post(this);
                    return;
                }
                return;
            }
            if (SystemClock.uptimeMillis() > this.f7069a) {
                this.f7071c = false;
                ComponentActivity.this.getWindow().getDecorView().post(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            ComponentActivity.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }
    }

    public ComponentActivity() {
        this.mContextAwareHelper = new C0512a();
        this.mMenuHostHelper = new C0462q(new Runnable() { // from class: androidx.activity.d
            @Override // java.lang.Runnable
            public final void run() {
                ComponentActivity.this.invalidateMenu();
            }
        });
        this.mLifecycleRegistry = new androidx.lifecycle.q(this);
        d0.c a10 = d0.c.a(this);
        this.mSavedStateRegistryController = a10;
        this.mOnBackPressedDispatcher = null;
        f createFullyDrawnExecutor = createFullyDrawnExecutor();
        this.mReportFullyDrawnExecutor = createFullyDrawnExecutor;
        this.mFullyDrawnReporter = new l(createFullyDrawnExecutor, new InterfaceC1637a() { // from class: androidx.activity.e
            @Override // v9.InterfaceC1637a
            public final Object invoke() {
                m9.q lambda$new$0;
                lambda$new$0 = ComponentActivity.this.lambda$new$0();
                return lambda$new$0;
            }
        });
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mActivityResultRegistry = new a();
        this.mOnConfigurationChangedListeners = new CopyOnWriteArrayList<>();
        this.mOnTrimMemoryListeners = new CopyOnWriteArrayList<>();
        this.mOnNewIntentListeners = new CopyOnWriteArrayList<>();
        this.mOnMultiWindowModeChangedListeners = new CopyOnWriteArrayList<>();
        this.mOnPictureInPictureModeChangedListeners = new CopyOnWriteArrayList<>();
        this.mDispatchingOnMultiWindowModeChanged = false;
        this.mDispatchingOnPictureInPictureModeChanged = false;
        if (getLifecycle() != null) {
            getLifecycle().a(new InterfaceC0489l() { // from class: androidx.activity.ComponentActivity.2
                @Override // androidx.lifecycle.InterfaceC0489l
                public void onStateChanged(InterfaceC0492o interfaceC0492o, Lifecycle.Event event) {
                    View view;
                    if (event == Lifecycle.Event.ON_STOP) {
                        Window window = ComponentActivity.this.getWindow();
                        if (window != null) {
                            view = window.peekDecorView();
                        } else {
                            view = null;
                        }
                        if (view != null) {
                            c.a(view);
                        }
                    }
                }
            });
            getLifecycle().a(new InterfaceC0489l() { // from class: androidx.activity.ComponentActivity.3
                @Override // androidx.lifecycle.InterfaceC0489l
                public void onStateChanged(InterfaceC0492o interfaceC0492o, Lifecycle.Event event) {
                    if (event == Lifecycle.Event.ON_DESTROY) {
                        ComponentActivity.this.mContextAwareHelper.b();
                        if (!ComponentActivity.this.isChangingConfigurations()) {
                            ComponentActivity.this.getViewModelStore().a();
                        }
                        ComponentActivity.this.mReportFullyDrawnExecutor.f();
                    }
                }
            });
            getLifecycle().a(new InterfaceC0489l() { // from class: androidx.activity.ComponentActivity.4
                @Override // androidx.lifecycle.InterfaceC0489l
                public void onStateChanged(InterfaceC0492o interfaceC0492o, Lifecycle.Event event) {
                    ComponentActivity.this.ensureViewModelStore();
                    ComponentActivity.this.getLifecycle().d(this);
                }
            });
            a10.c();
            SavedStateHandleSupport.c(this);
            getSavedStateRegistry().h(ACTIVITY_RESULT_TAG, new a.c() { // from class: androidx.activity.f
                @Override // androidx.savedstate.a.c
                public final Bundle saveState() {
                    Bundle lambda$new$1;
                    lambda$new$1 = ComponentActivity.this.lambda$new$1();
                    return lambda$new$1;
                }
            });
            addOnContextAvailableListener(new InterfaceC0513b() { // from class: androidx.activity.g
                @Override // b.InterfaceC0513b
                public final void a(Context context) {
                    ComponentActivity.this.lambda$new$2(context);
                }
            });
            return;
        }
        throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
    }

    private f createFullyDrawnExecutor() {
        return new g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ m9.q lambda$new$0() {
        reportFullyDrawn();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Bundle lambda$new$1() {
        Bundle bundle = new Bundle();
        this.mActivityResultRegistry.h(bundle);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2(Context context) {
        Bundle b10 = getSavedStateRegistry().b(ACTIVITY_RESULT_TAG);
        if (b10 != null) {
            this.mActivityResultRegistry.g(b10);
        }
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.T(getWindow().getDecorView());
        super.addContentView(view, layoutParams);
    }

    @Override // androidx.core.view.InterfaceC0459n
    public void addMenuProvider(InterfaceC0463s interfaceC0463s) {
        this.mMenuHostHelper.c(interfaceC0463s);
    }

    @Override // androidx.core.content.c
    public final void addOnConfigurationChangedListener(I.a<Configuration> aVar) {
        this.mOnConfigurationChangedListeners.add(aVar);
    }

    public final void addOnContextAvailableListener(InterfaceC0513b interfaceC0513b) {
        this.mContextAwareHelper.a(interfaceC0513b);
    }

    @Override // androidx.core.app.j
    public final void addOnMultiWindowModeChangedListener(I.a<androidx.core.app.f> aVar) {
        this.mOnMultiWindowModeChangedListeners.add(aVar);
    }

    public final void addOnNewIntentListener(I.a<Intent> aVar) {
        this.mOnNewIntentListeners.add(aVar);
    }

    @Override // androidx.core.app.k
    public final void addOnPictureInPictureModeChangedListener(I.a<androidx.core.app.l> aVar) {
        this.mOnPictureInPictureModeChangedListeners.add(aVar);
    }

    @Override // androidx.core.content.d
    public final void addOnTrimMemoryListener(I.a<Integer> aVar) {
        this.mOnTrimMemoryListeners.add(aVar);
    }

    public void ensureViewModelStore() {
        if (this.mViewModelStore == null) {
            e eVar = (e) getLastNonConfigurationInstance();
            if (eVar != null) {
                this.mViewModelStore = eVar.f7068b;
            }
            if (this.mViewModelStore == null) {
                this.mViewModelStore = new M();
            }
        }
    }

    @Override // androidx.activity.result.c
    public final ActivityResultRegistry getActivityResultRegistry() {
        return this.mActivityResultRegistry;
    }

    @Override // androidx.lifecycle.InterfaceC0485h
    public V.a getDefaultViewModelCreationExtras() {
        V.d dVar = new V.d();
        if (getApplication() != null) {
            dVar.c(K.a.f10268h, getApplication());
        }
        dVar.c(SavedStateHandleSupport.f10325a, this);
        dVar.c(SavedStateHandleSupport.f10326b, this);
        if (getIntent() != null && getIntent().getExtras() != null) {
            dVar.c(SavedStateHandleSupport.f10327c, getIntent().getExtras());
        }
        return dVar;
    }

    @Override // androidx.lifecycle.InterfaceC0485h
    public K.b getDefaultViewModelProviderFactory() {
        Bundle bundle;
        if (this.mDefaultFactory == null) {
            Application application = getApplication();
            if (getIntent() != null) {
                bundle = getIntent().getExtras();
            } else {
                bundle = null;
            }
            this.mDefaultFactory = new E(application, this, bundle);
        }
        return this.mDefaultFactory;
    }

    public l getFullyDrawnReporter() {
        return this.mFullyDrawnReporter;
    }

    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        e eVar = (e) getLastNonConfigurationInstance();
        if (eVar != null) {
            return eVar.f7067a;
        }
        return null;
    }

    @Override // androidx.core.app.ComponentActivity, androidx.lifecycle.InterfaceC0492o
    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // androidx.activity.p
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        if (this.mOnBackPressedDispatcher == null) {
            this.mOnBackPressedDispatcher = new OnBackPressedDispatcher(new b());
            getLifecycle().a(new InterfaceC0489l() { // from class: androidx.activity.ComponentActivity.6
                @Override // androidx.lifecycle.InterfaceC0489l
                public void onStateChanged(InterfaceC0492o interfaceC0492o, Lifecycle.Event event) {
                    if (event == Lifecycle.Event.ON_CREATE) {
                        ComponentActivity.this.mOnBackPressedDispatcher.o(d.a((ComponentActivity) interfaceC0492o));
                    }
                }
            });
        }
        return this.mOnBackPressedDispatcher;
    }

    @Override // d0.d
    public final androidx.savedstate.a getSavedStateRegistry() {
        return this.mSavedStateRegistryController.b();
    }

    @Override // androidx.lifecycle.N
    public M getViewModelStore() {
        if (getApplication() != null) {
            ensureViewModelStore();
            return this.mViewModelStore;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    public void initializeViewTreeOwners() {
        ViewTreeLifecycleOwner.b(getWindow().getDecorView(), this);
        O.a(getWindow().getDecorView(), this);
        d0.e.a(getWindow().getDecorView(), this);
        s.a(getWindow().getDecorView(), this);
        r.a(getWindow().getDecorView(), this);
    }

    public void invalidateMenu() {
        invalidateOptionsMenu();
    }

    @Override // android.app.Activity
    @Deprecated
    public void onActivityResult(int i10, int i11, Intent intent) {
        if (!this.mActivityResultRegistry.b(i10, i11, intent)) {
            super.onActivityResult(i10, i11, intent);
        }
    }

    @Override // android.app.Activity
    @Deprecated
    public void onBackPressed() {
        getOnBackPressedDispatcher().l();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Iterator<I.a<Configuration>> it = this.mOnConfigurationChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(configuration);
        }
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.mSavedStateRegistryController.d(bundle);
        this.mContextAwareHelper.c(this);
        super.onCreate(bundle);
        B.e(this);
        int i10 = this.mContentLayoutId;
        if (i10 != 0) {
            setContentView(i10);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i10, Menu menu) {
        if (i10 == 0) {
            super.onCreatePanelMenu(i10, menu);
            this.mMenuHostHelper.h(menu, getMenuInflater());
            return true;
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i10, MenuItem menuItem) {
        if (super.onMenuItemSelected(i10, menuItem)) {
            return true;
        }
        if (i10 == 0) {
            return this.mMenuHostHelper.j(menuItem);
        }
        return false;
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z10) {
        if (this.mDispatchingOnMultiWindowModeChanged) {
            return;
        }
        Iterator<I.a<androidx.core.app.f>> it = this.mOnMultiWindowModeChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(new androidx.core.app.f(z10));
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Iterator<I.a<Intent>> it = this.mOnNewIntentListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i10, Menu menu) {
        this.mMenuHostHelper.i(menu);
        super.onPanelClosed(i10, menu);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z10) {
        if (this.mDispatchingOnPictureInPictureModeChanged) {
            return;
        }
        Iterator<I.a<androidx.core.app.l>> it = this.mOnPictureInPictureModeChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(new androidx.core.app.l(z10));
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i10, View view, Menu menu) {
        if (i10 == 0) {
            super.onPreparePanel(i10, view, menu);
            this.mMenuHostHelper.k(menu);
            return true;
        }
        return true;
    }

    @Override // android.app.Activity
    @Deprecated
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        if (!this.mActivityResultRegistry.b(i10, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr))) {
            super.onRequestPermissionsResult(i10, strArr, iArr);
        }
    }

    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        e eVar;
        Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        M m10 = this.mViewModelStore;
        if (m10 == null && (eVar = (e) getLastNonConfigurationInstance()) != null) {
            m10 = eVar.f7068b;
        }
        if (m10 == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        e eVar2 = new e();
        eVar2.f7067a = onRetainCustomNonConfigurationInstance;
        eVar2.f7068b = m10;
        return eVar2;
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Lifecycle lifecycle = getLifecycle();
        if (lifecycle instanceof androidx.lifecycle.q) {
            ((androidx.lifecycle.q) lifecycle).n(Lifecycle.State.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.e(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i10) {
        super.onTrimMemory(i10);
        Iterator<I.a<Integer>> it = this.mOnTrimMemoryListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(Integer.valueOf(i10));
        }
    }

    public Context peekAvailableContext() {
        return this.mContextAwareHelper.d();
    }

    public final <I, O> androidx.activity.result.b<I> registerForActivityResult(AbstractC0540a<I, O> abstractC0540a, ActivityResultRegistry activityResultRegistry, androidx.activity.result.a<O> aVar) {
        return activityResultRegistry.i("activity_rq#" + this.mNextLocalRequestCode.getAndIncrement(), this, abstractC0540a, aVar);
    }

    @Override // androidx.core.view.InterfaceC0459n
    public void removeMenuProvider(InterfaceC0463s interfaceC0463s) {
        this.mMenuHostHelper.l(interfaceC0463s);
    }

    @Override // androidx.core.content.c
    public final void removeOnConfigurationChangedListener(I.a<Configuration> aVar) {
        this.mOnConfigurationChangedListeners.remove(aVar);
    }

    public final void removeOnContextAvailableListener(InterfaceC0513b interfaceC0513b) {
        this.mContextAwareHelper.e(interfaceC0513b);
    }

    @Override // androidx.core.app.j
    public final void removeOnMultiWindowModeChangedListener(I.a<androidx.core.app.f> aVar) {
        this.mOnMultiWindowModeChangedListeners.remove(aVar);
    }

    public final void removeOnNewIntentListener(I.a<Intent> aVar) {
        this.mOnNewIntentListeners.remove(aVar);
    }

    @Override // androidx.core.app.k
    public final void removeOnPictureInPictureModeChangedListener(I.a<androidx.core.app.l> aVar) {
        this.mOnPictureInPictureModeChangedListeners.remove(aVar);
    }

    @Override // androidx.core.content.d
    public final void removeOnTrimMemoryListener(I.a<Integer> aVar) {
        this.mOnTrimMemoryListeners.remove(aVar);
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        try {
            if (C1089a.c()) {
                C1089a.a("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
            this.mFullyDrawnReporter.b();
            C1089a.b();
        } catch (Throwable th) {
            C1089a.b();
            throw th;
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i10) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.T(getWindow().getDecorView());
        super.setContentView(i10);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(Intent intent, int i10) {
        super.startActivityForResult(intent, i10);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i10, Intent intent, int i11, int i12, int i13) {
        super.startIntentSenderForResult(intentSender, i10, intent, i11, i12, i13);
    }

    public void addMenuProvider(InterfaceC0463s interfaceC0463s, InterfaceC0492o interfaceC0492o) {
        this.mMenuHostHelper.d(interfaceC0463s, interfaceC0492o);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(Intent intent, int i10, Bundle bundle) {
        super.startActivityForResult(intent, i10, bundle);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i10, Intent intent, int i11, int i12, int i13, Bundle bundle) {
        super.startIntentSenderForResult(intentSender, i10, intent, i11, i12, i13, bundle);
    }

    public void addMenuProvider(InterfaceC0463s interfaceC0463s, InterfaceC0492o interfaceC0492o, Lifecycle.State state) {
        this.mMenuHostHelper.e(interfaceC0463s, interfaceC0492o, state);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z10, Configuration configuration) {
        this.mDispatchingOnMultiWindowModeChanged = true;
        try {
            super.onMultiWindowModeChanged(z10, configuration);
            this.mDispatchingOnMultiWindowModeChanged = false;
            Iterator<I.a<androidx.core.app.f>> it = this.mOnMultiWindowModeChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().accept(new androidx.core.app.f(z10, configuration));
            }
        } catch (Throwable th) {
            this.mDispatchingOnMultiWindowModeChanged = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z10, Configuration configuration) {
        this.mDispatchingOnPictureInPictureModeChanged = true;
        try {
            super.onPictureInPictureModeChanged(z10, configuration);
            this.mDispatchingOnPictureInPictureModeChanged = false;
            Iterator<I.a<androidx.core.app.l>> it = this.mOnPictureInPictureModeChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().accept(new androidx.core.app.l(z10, configuration));
            }
        } catch (Throwable th) {
            this.mDispatchingOnPictureInPictureModeChanged = false;
            throw th;
        }
    }

    public final <I, O> androidx.activity.result.b<I> registerForActivityResult(AbstractC0540a<I, O> abstractC0540a, androidx.activity.result.a<O> aVar) {
        return registerForActivityResult(abstractC0540a, this.mActivityResultRegistry, aVar);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.T(getWindow().getDecorView());
        super.setContentView(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.T(getWindow().getDecorView());
        super.setContentView(view, layoutParams);
    }

    public ComponentActivity(int i10) {
        this();
        this.mContentLayoutId = i10;
    }
}
