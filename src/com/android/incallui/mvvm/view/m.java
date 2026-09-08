package com.android.incallui.mvvm.view;

import O1.I;
import android.content.ContentResolver;
import android.graphics.Matrix;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.B;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.K;
import androidx.lifecycle.w;
import com.android.incallui.InCallPresenter;
import com.android.incallui.Log;
import com.android.incallui.OplusInCallActivity;
import com.android.incallui.OplusInCallApp;
import com.android.incallui.OplusPhoneUtils;
import com.android.incallui.R;
import com.android.incallui.VideoCallPresenter;
import com.android.incallui.mvvm.repository.dynamic.ResponsiveConfigRepository;
import com.android.incallui.mvvm.usecase.FragmentStateUseCase;
import com.android.incallui.mvvm.view_model.BackgroundViewModel;
import com.android.incallui.mvvm.view_model.OplusInCallViewModel;
import com.internal_dependency.SettingsUtils;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: OplusInCallActivityPlugin.kt */
/* loaded from: classes.dex */
public final class m {

    /* compiled from: LiveData.kt */
    /* loaded from: classes.dex */
    public static final class a<T> implements w {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageView f18650a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RenderEffect f18651b;

        public a(ImageView imageView, RenderEffect renderEffect) {
            this.f18650a = imageView;
            this.f18651b = renderEffect;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.w
        public final void onChanged(T t10) {
            Boolean it = (Boolean) t10;
            kotlin.jvm.internal.i.e(it, "it");
            if (it.booleanValue()) {
                this.f18650a.setRenderEffect(this.f18651b);
            } else {
                this.f18650a.setRenderEffect(null);
            }
        }
    }

    /* compiled from: LiveData.kt */
    /* loaded from: classes.dex */
    public static final class b<T> implements w {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageView f18652a;

        public b(ImageView imageView) {
            this.f18652a = imageView;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.w
        public final void onChanged(T t10) {
            Matrix matrix = (Matrix) t10;
            if (matrix != null) {
                this.f18652a.setScaleType(ImageView.ScaleType.MATRIX);
                this.f18652a.setImageMatrix(matrix);
            } else {
                this.f18652a.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
        }
    }

    /* compiled from: LiveData.kt */
    /* loaded from: classes.dex */
    public static final class c<T> implements w {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef f18653a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OplusInCallActivity f18654b;

        public c(Ref$ObjectRef ref$ObjectRef, OplusInCallActivity oplusInCallActivity) {
            this.f18653a = ref$ObjectRef;
            this.f18654b = oplusInCallActivity;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.w
        public final void onChanged(T t10) {
            Boolean actionButtonVisible = (Boolean) t10;
            try {
                Fragment fragment = (Fragment) this.f18653a.element;
                if (fragment != null) {
                    B p10 = this.f18654b.getSupportFragmentManager().p();
                    kotlin.jvm.internal.i.e(actionButtonVisible, "actionButtonVisible");
                    boolean booleanValue = actionButtonVisible.booleanValue();
                    if (booleanValue) {
                        View view = fragment.getView();
                        if (view != null) {
                            view.setVisibility(0);
                        }
                        p10.y(fragment);
                    }
                    if (!booleanValue) {
                        View view2 = fragment.getView();
                        if (view2 != null) {
                            view2.setVisibility(4);
                        }
                        p10.p(fragment);
                    }
                    p10.j();
                }
            } catch (IllegalStateException e10) {
                Log.d("OplusInCallActivityPlugin", "observeFragmentVisible: exception=" + e10.getMessage());
            }
        }
    }

    /* compiled from: LiveData.kt */
    /* loaded from: classes.dex */
    public static final class d<T> implements w {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OplusInCallActivity f18655a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FrameLayout f18656b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ OplusInCallViewModel f18657c;

        public d(OplusInCallActivity oplusInCallActivity, FrameLayout frameLayout, OplusInCallViewModel oplusInCallViewModel) {
            this.f18655a = oplusInCallActivity;
            this.f18656b = frameLayout;
            this.f18657c = oplusInCallViewModel;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.w
        public final void onChanged(T t10) {
            Log.d("OplusInCallActivityPlugin", "observeSideWave change to >>> " + this.f18655a.mCurvedDisplayView);
            E2.d dVar = this.f18655a.mCurvedDisplayView;
            if (dVar != null) {
                this.f18656b.removeView(dVar);
                this.f18655a.mCurvedDisplayView = null;
                com.android.incallui.mvvm.utils.f.a(this.f18657c.r());
            }
        }
    }

    /* compiled from: LiveData.kt */
    /* loaded from: classes.dex */
    public static final class e<T> implements w {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OplusInCallActivity f18658a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FrameLayout f18659b;

        public e(OplusInCallActivity oplusInCallActivity, FrameLayout frameLayout) {
            this.f18658a = oplusInCallActivity;
            this.f18659b = frameLayout;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.w
        public final void onChanged(T t10) {
            String str;
            Boolean visible = (Boolean) t10;
            kotlin.jvm.internal.i.e(visible, "visible");
            if (!visible.booleanValue()) {
                E2.d dVar = this.f18658a.mCurvedDisplayView;
                if (dVar != null) {
                    dVar.setVisibility(8);
                    return;
                }
                return;
            }
            SettingsUtils settingsUtils = SettingsUtils.INSTANCE;
            ContentResolver contentResolver = this.f18658a.getContentResolver();
            kotlin.jvm.internal.i.e(contentResolver, "contentResolver");
            String secureSettingsString = settingsUtils.getSecureSettingsString(contentResolver, "oplus_customize_comm_incallui_curved_display_notification_color", "");
            if (secureSettingsString != null) {
                E2.d dVar2 = this.f18658a.mCurvedDisplayView;
                if (dVar2 != null) {
                    if (dVar2 != null) {
                        str = dVar2.getColor();
                    } else {
                        str = null;
                    }
                    if (kotlin.jvm.internal.i.b(secureSettingsString, str)) {
                        E2.d dVar3 = this.f18658a.mCurvedDisplayView;
                        kotlin.jvm.internal.i.c(dVar3);
                        dVar3.setVisibility(0);
                        return;
                    }
                    this.f18659b.removeView(this.f18658a.mCurvedDisplayView);
                    this.f18658a.mCurvedDisplayView = null;
                }
                this.f18658a.mCurvedDisplayView = new E2.d(OplusInCallApp.getDefaultDisplayUiContext(), secureSettingsString);
                FrameLayout frameLayout = this.f18659b;
                E2.d dVar4 = this.f18658a.mCurvedDisplayView;
                kotlin.jvm.internal.i.c(dVar4);
                frameLayout.addView(dVar4, new FrameLayout.LayoutParams(-1, -1));
            }
        }
    }

    public static final void b(final OplusInCallActivity oplusInCallActivity, BackgroundViewModel backgroundViewModel, View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_default_background);
        backgroundViewModel.k().i(oplusInCallActivity, new a(imageView, RenderEffect.createBlurEffect(120.0f, 120.0f, Shader.TileMode.CLAMP)));
        backgroundViewModel.l().i(oplusInCallActivity, new b(imageView));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.android.incallui.mvvm.view.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                m.c(OplusInCallActivity.this, view2);
            }
        });
    }

    public static final void c(OplusInCallActivity this_observeBackground, View view) {
        kotlin.jvm.internal.i.f(this_observeBackground, "$this_observeBackground");
        if (Log.sOplusDebug) {
            Log.d(this_observeBackground, "mBackground  onclick ...");
        }
        VideoCallPresenter videoCallPresenter = InCallPresenter.getInstance().getVideoCallPresenter();
        if (videoCallPresenter != null && !this_observeBackground.mInCallFragmentManager.m(6) && !OplusPhoneUtils.noNeedHandleClickForCMCC()) {
            videoCallPresenter.toggleFullScreen();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [T, androidx.fragment.app.Fragment] */
    /* JADX WARN: Type inference failed for: r1v4, types: [T, com.android.incallui.mvvm.view.OplusActionButtonFragment] */
    public static final void d(OplusInCallActivity oplusInCallActivity) {
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ?? m02 = oplusInCallActivity.getSupportFragmentManager().m0(OplusActionButtonFragment.class.getName());
        ref$ObjectRef.element = m02;
        if (m02 == 0) {
            ref$ObjectRef.element = new OplusActionButtonFragment();
            oplusInCallActivity.getSupportFragmentManager().p().c(R.id.vp_screen_bottom, (Fragment) ref$ObjectRef.element, OplusActionButtonFragment.class.getName()).l();
        }
        FragmentStateUseCase.f18563a.c().i(oplusInCallActivity, new c(ref$ObjectRef, oplusInCallActivity));
    }

    public static final void e(OplusInCallActivity oplusInCallActivity, OplusInCallViewModel oplusInCallViewModel, View view) {
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_screen_background);
        ResponsiveConfigRepository.f18540a.c0().i(oplusInCallActivity, new d(oplusInCallActivity, frameLayout, oplusInCallViewModel));
        oplusInCallViewModel.r().i(oplusInCallActivity, new e(oplusInCallActivity, frameLayout));
    }

    public static final void f(OplusInCallActivity oplusInCallActivity, View rootView) {
        kotlin.jvm.internal.i.f(oplusInCallActivity, "<this>");
        kotlin.jvm.internal.i.f(rootView, "rootView");
        OplusInCallViewModel oplusInCallViewModel = (OplusInCallViewModel) new K(oplusInCallActivity).a(OplusInCallViewModel.class);
        BackgroundViewModel backgroundViewModel = (BackgroundViewModel) new K(oplusInCallActivity).a(BackgroundViewModel.class);
        I i12 = I.i1(rootView);
        i12.l1(oplusInCallViewModel);
        i12.k1(backgroundViewModel);
        i12.b1(oplusInCallActivity);
        b(oplusInCallActivity, backgroundViewModel, rootView);
        d(oplusInCallActivity);
        e(oplusInCallActivity, oplusInCallViewModel, rootView);
    }
}
