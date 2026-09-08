package com.oplus.anim;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import f.C0991a;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import m6.C1335a;
import m6.C1336b;
import m6.InterfaceC1339e;

/* loaded from: classes3.dex */
public class EffectiveAnimationView extends AppCompatImageView {
    private static final String TAG = "EffectiveAnimationView";
    private final InterfaceC0836q<Throwable> DEFAULT_FAILURE_LISTENER;
    private String animationName;
    private int animationResId;
    private boolean autoPlay;
    private boolean cacheComposition;
    private C0820a composition;
    private u<C0820a> compositionTask;
    private final EffectiveAnimationDrawable effectiveDrawable;
    private final Set<K> effectiveOnCompositionLoadedListeners;
    private InterfaceC0836q<Throwable> failureListener;
    private int fallbackResource;
    private boolean ignoreUnschedule;
    private final InterfaceC0836q<C0820a> loadedListener;
    private final Set<UserActionTaken> userActionsTaken;
    private final InterfaceC0836q<Throwable> wrappedFailureListener;

    /* loaded from: classes3.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public String f25787a;

        /* renamed from: b, reason: collision with root package name */
        public int f25788b;

        /* renamed from: c, reason: collision with root package name */
        public float f25789c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f25790d;

        /* renamed from: e, reason: collision with root package name */
        public String f25791e;

        /* renamed from: f, reason: collision with root package name */
        public int f25792f;

        /* renamed from: g, reason: collision with root package name */
        public int f25793g;

        /* loaded from: classes3.dex */
        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public /* synthetic */ SavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeString(this.f25787a);
            parcel.writeFloat(this.f25789c);
            parcel.writeInt(this.f25790d ? 1 : 0);
            parcel.writeString(this.f25791e);
            parcel.writeInt(this.f25792f);
            parcel.writeInt(this.f25793g);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f25787a = parcel.readString();
            this.f25789c = parcel.readFloat();
            this.f25790d = parcel.readInt() == 1;
            this.f25791e = parcel.readString();
            this.f25792f = parcel.readInt();
            this.f25793g = parcel.readInt();
        }
    }

    /* loaded from: classes3.dex */
    public enum UserActionTaken {
        SET_ANIMATION,
        SET_PROGRESS,
        SET_REPEAT_MODE,
        SET_REPEAT_COUNT,
        SET_IMAGE_ASSETS,
        PLAY_OPTION
    }

    /* loaded from: classes3.dex */
    public class a implements InterfaceC0836q<Throwable> {
        public a() {
        }

        @Override // com.oplus.anim.InterfaceC0836q
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Throwable th) {
            if (EffectiveAnimationView.this.fallbackResource != 0) {
                EffectiveAnimationView effectiveAnimationView = EffectiveAnimationView.this;
                effectiveAnimationView.setImageResource(effectiveAnimationView.fallbackResource);
            }
            InterfaceC0836q interfaceC0836q = EffectiveAnimationView.this.failureListener;
            EffectiveAnimationView effectiveAnimationView2 = EffectiveAnimationView.this;
            (interfaceC0836q == null ? effectiveAnimationView2.DEFAULT_FAILURE_LISTENER : effectiveAnimationView2.failureListener).a(th);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes3.dex */
    public class b<T> extends C1336b<T> {
        public b(InterfaceC1339e interfaceC1339e) {
        }

        @Override // m6.C1336b
        public T a(C1335a<T> c1335a) {
            throw null;
        }
    }

    public EffectiveAnimationView(Context context) {
        super(context);
        this.DEFAULT_FAILURE_LISTENER = new InterfaceC0836q() { // from class: com.oplus.anim.w
            @Override // com.oplus.anim.InterfaceC0836q
            public final void a(Object obj) {
                EffectiveAnimationView.lambda$new$0((Throwable) obj);
            }
        };
        this.loadedListener = new InterfaceC0836q() { // from class: com.oplus.anim.x
            @Override // com.oplus.anim.InterfaceC0836q
            public final void a(Object obj) {
                EffectiveAnimationView.this.setComposition((C0820a) obj);
            }
        };
        this.wrappedFailureListener = new a();
        this.fallbackResource = 0;
        this.effectiveDrawable = new EffectiveAnimationDrawable();
        this.ignoreUnschedule = false;
        this.autoPlay = false;
        this.cacheComposition = true;
        this.userActionsTaken = new HashSet();
        this.effectiveOnCompositionLoadedListeners = new HashSet();
        init(null, P.f25832a);
    }

    private void cancelLoaderTask() {
        u<C0820a> uVar = this.compositionTask;
        if (uVar != null) {
            uVar.j(this.loadedListener);
            this.compositionTask.i(this.wrappedFailureListener);
        }
    }

    private void clearComposition() {
        this.composition = null;
        this.effectiveDrawable.y();
    }

    private u<C0820a> fromAssets(final String str) {
        if (isInEditMode()) {
            return new u<>(new Callable() { // from class: com.oplus.anim.y
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    C0837s lambda$fromAssets$2;
                    lambda$fromAssets$2 = EffectiveAnimationView.this.lambda$fromAssets$2(str);
                    return lambda$fromAssets$2;
                }
            }, true);
        }
        if (this.cacheComposition) {
            return H.j(getContext(), str);
        }
        return H.k(getContext(), str, null);
    }

    private u<C0820a> fromRawRes(final int i10) {
        if (isInEditMode()) {
            return new u<>(new Callable() { // from class: com.oplus.anim.z
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    C0837s lambda$fromRawRes$1;
                    lambda$fromRawRes$1 = EffectiveAnimationView.this.lambda$fromRawRes$1(i10);
                    return lambda$fromRawRes$1;
                }
            }, true);
        }
        if (this.cacheComposition) {
            return H.s(getContext(), i10);
        }
        return H.t(getContext(), i10, null);
    }

    private void init(AttributeSet attributeSet, int i10) {
        String string;
        boolean z10 = false;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, Q.f25890t, i10, 0);
        this.cacheComposition = obtainStyledAttributes.getBoolean(Q.f25892v, true);
        int i11 = Q.f25839G;
        boolean hasValue = obtainStyledAttributes.hasValue(i11);
        int i12 = Q.f25834B;
        boolean hasValue2 = obtainStyledAttributes.hasValue(i12);
        int i13 = Q.f25844L;
        boolean hasValue3 = obtainStyledAttributes.hasValue(i13);
        if (hasValue && hasValue2) {
            throw new IllegalArgumentException("anim_rawRes and anim_fileName cannot be used at the same time. Please use only one at once.");
        }
        if (hasValue) {
            int resourceId = obtainStyledAttributes.getResourceId(i11, 0);
            if (resourceId != 0) {
                setAnimation(resourceId);
            }
        } else if (hasValue2) {
            String string2 = obtainStyledAttributes.getString(i12);
            if (string2 != null) {
                setAnimation(string2);
            }
        } else if (hasValue3 && (string = obtainStyledAttributes.getString(i13)) != null) {
            setAnimationFromUrl(string);
        }
        setFallbackResource(obtainStyledAttributes.getResourceId(Q.f25833A, 0));
        if (obtainStyledAttributes.getBoolean(Q.f25891u, false)) {
            this.autoPlay = true;
        }
        if (obtainStyledAttributes.getBoolean(Q.f25837E, false)) {
            this.effectiveDrawable.k1(-1);
        }
        int i14 = Q.f25842J;
        if (obtainStyledAttributes.hasValue(i14)) {
            setRepeatMode(obtainStyledAttributes.getInt(i14, 1));
        }
        int i15 = Q.f25841I;
        if (obtainStyledAttributes.hasValue(i15)) {
            setRepeatCount(obtainStyledAttributes.getInt(i15, -1));
        }
        int i16 = Q.f25843K;
        if (obtainStyledAttributes.hasValue(i16)) {
            setSpeed(obtainStyledAttributes.getFloat(i16, 1.0f));
        }
        int i17 = Q.f25893w;
        if (obtainStyledAttributes.hasValue(i17)) {
            setClipToCompositionBounds(obtainStyledAttributes.getBoolean(i17, true));
        }
        int i18 = Q.f25895y;
        if (obtainStyledAttributes.hasValue(i18)) {
            setDefaultFontFileExtension(obtainStyledAttributes.getString(i18));
        }
        setImageAssetsFolder(obtainStyledAttributes.getString(Q.f25836D));
        int i19 = Q.f25838F;
        setProgressInternal(obtainStyledAttributes.getFloat(i19, 0.0f), obtainStyledAttributes.hasValue(i19));
        enableMergePathsForKitKatAndAbove(obtainStyledAttributes.getBoolean(Q.f25896z, false));
        int i20 = Q.f25894x;
        if (obtainStyledAttributes.hasValue(i20)) {
            addValueCallback(new e6.e("**"), (e6.e) r.f26168K, (C1336b<e6.e>) new C1336b(new S(C0991a.a(getContext(), obtainStyledAttributes.getResourceId(i20, -1)).getDefaultColor())));
        }
        int i21 = Q.f25840H;
        if (obtainStyledAttributes.hasValue(i21)) {
            RenderMode renderMode = RenderMode.AUTOMATIC;
            int i22 = obtainStyledAttributes.getInt(i21, renderMode.ordinal());
            if (i22 >= RenderMode.values().length) {
                i22 = renderMode.ordinal();
            }
            setRenderMode(RenderMode.values()[i22]);
        }
        setIgnoreDisabledSystemAnimations(obtainStyledAttributes.getBoolean(Q.f25835C, false));
        int i23 = Q.f25845M;
        if (obtainStyledAttributes.hasValue(i23)) {
            setUseCompositionFrameRate(obtainStyledAttributes.getBoolean(i23, false));
        }
        obtainStyledAttributes.recycle();
        EffectiveAnimationDrawable effectiveAnimationDrawable = this.effectiveDrawable;
        if (l6.h.f(getContext()) != 0.0f) {
            z10 = true;
        }
        effectiveAnimationDrawable.o1(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C0837s lambda$fromAssets$2(String str) {
        if (this.cacheComposition) {
            return H.l(getContext(), str);
        }
        return H.m(getContext(), str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C0837s lambda$fromRawRes$1(int i10) {
        if (this.cacheComposition) {
            return H.u(getContext(), i10);
        }
        return H.v(getContext(), i10, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$0(Throwable th) {
        if (l6.h.k(th)) {
            l6.e.d("Unable to load composition.", th);
            return;
        }
        throw new IllegalStateException("Unable to parse composition", th);
    }

    private void setCompositionTask(u<C0820a> uVar) {
        this.userActionsTaken.add(UserActionTaken.SET_ANIMATION);
        clearComposition();
        cancelLoaderTask();
        this.compositionTask = uVar.d(this.loadedListener).c(this.wrappedFailureListener);
    }

    private void setEffectiveAnimationDrawable() {
        boolean isAnimating = isAnimating();
        setImageDrawable(null);
        setImageDrawable(this.effectiveDrawable);
        if (isAnimating) {
            this.effectiveDrawable.I0();
        }
    }

    private void setProgressInternal(float f10, boolean z10) {
        if (z10) {
            this.userActionsTaken.add(UserActionTaken.SET_PROGRESS);
        }
        this.effectiveDrawable.i1(f10);
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.effectiveDrawable.r(animatorListener);
    }

    public void addAnimatorPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.effectiveDrawable.s(animatorPauseListener);
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.effectiveDrawable.t(animatorUpdateListener);
    }

    public boolean addEffectiveOnCompositionLoadedListener(K k10) {
        C0820a c0820a = this.composition;
        if (c0820a != null) {
            k10.a(c0820a);
        }
        return this.effectiveOnCompositionLoadedListeners.add(k10);
    }

    public <T> void addValueCallback(e6.e eVar, T t10, C1336b<T> c1336b) {
        this.effectiveDrawable.u(eVar, t10, c1336b);
    }

    public void cancelAnimation() {
        this.userActionsTaken.add(UserActionTaken.PLAY_OPTION);
        this.effectiveDrawable.x();
    }

    @Deprecated
    public void disableExtraScaleModeInFitXY() {
        this.effectiveDrawable.C();
    }

    public void enableMergePathsForKitKatAndAbove(boolean z10) {
        this.effectiveDrawable.E(z10);
    }

    public boolean getClipToCompositionBounds() {
        return this.effectiveDrawable.K();
    }

    public C0820a getComposition() {
        return this.composition;
    }

    public long getDuration() {
        if (this.composition != null) {
            return r2.d();
        }
        return 0L;
    }

    public int getFrame() {
        return this.effectiveDrawable.O();
    }

    public String getImageAssetsFolder() {
        return this.effectiveDrawable.Q();
    }

    public boolean getMaintainOriginalImageBounds() {
        return this.effectiveDrawable.S();
    }

    public float getMaxFrame() {
        return this.effectiveDrawable.T();
    }

    public float getMinFrame() {
        return this.effectiveDrawable.U();
    }

    public O getPerformanceTracker() {
        return this.effectiveDrawable.V();
    }

    public float getProgress() {
        return this.effectiveDrawable.W();
    }

    public RenderMode getRenderMode() {
        return this.effectiveDrawable.X();
    }

    public int getRepeatCount() {
        return this.effectiveDrawable.Y();
    }

    public int getRepeatMode() {
        return this.effectiveDrawable.Z();
    }

    public float getSpeed() {
        return this.effectiveDrawable.a0();
    }

    public boolean hasMasks() {
        return this.effectiveDrawable.d0();
    }

    public boolean hasMatte() {
        return this.effectiveDrawable.e0();
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        Drawable drawable = getDrawable();
        if ((drawable instanceof EffectiveAnimationDrawable) && ((EffectiveAnimationDrawable) drawable).X() == RenderMode.SOFTWARE) {
            this.effectiveDrawable.invalidateSelf();
        }
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        EffectiveAnimationDrawable effectiveAnimationDrawable = this.effectiveDrawable;
        if (drawable2 == effectiveAnimationDrawable) {
            super.invalidateDrawable(effectiveAnimationDrawable);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    public boolean isAnimating() {
        return this.effectiveDrawable.g0();
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.effectiveDrawable.j0();
    }

    @Deprecated
    public void loop(boolean z10) {
        int i10;
        EffectiveAnimationDrawable effectiveAnimationDrawable = this.effectiveDrawable;
        if (z10) {
            i10 = -1;
        } else {
            i10 = 0;
        }
        effectiveAnimationDrawable.k1(i10);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode() && this.autoPlay) {
            this.effectiveDrawable.A0();
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        int i10;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.animationName = savedState.f25787a;
        Set<UserActionTaken> set = this.userActionsTaken;
        UserActionTaken userActionTaken = UserActionTaken.SET_ANIMATION;
        if (!set.contains(userActionTaken) && !TextUtils.isEmpty(this.animationName)) {
            setAnimation(this.animationName);
        }
        this.animationResId = savedState.f25788b;
        if (!this.userActionsTaken.contains(userActionTaken) && (i10 = this.animationResId) != 0) {
            setAnimation(i10);
        }
        if (!this.userActionsTaken.contains(UserActionTaken.SET_PROGRESS)) {
            setProgressInternal(savedState.f25789c, false);
        }
        if (!this.userActionsTaken.contains(UserActionTaken.PLAY_OPTION) && savedState.f25790d) {
            playAnimation();
        }
        if (!this.userActionsTaken.contains(UserActionTaken.SET_IMAGE_ASSETS)) {
            setImageAssetsFolder(savedState.f25791e);
        }
        if (!this.userActionsTaken.contains(UserActionTaken.SET_REPEAT_MODE)) {
            setRepeatMode(savedState.f25792f);
        }
        if (!this.userActionsTaken.contains(UserActionTaken.SET_REPEAT_COUNT)) {
            setRepeatCount(savedState.f25793g);
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f25787a = this.animationName;
        savedState.f25788b = this.animationResId;
        savedState.f25789c = this.effectiveDrawable.W();
        savedState.f25790d = this.effectiveDrawable.h0();
        savedState.f25791e = this.effectiveDrawable.Q();
        savedState.f25792f = this.effectiveDrawable.Z();
        savedState.f25793g = this.effectiveDrawable.Y();
        return savedState;
    }

    public void pauseAnimation() {
        this.autoPlay = false;
        this.effectiveDrawable.z0();
    }

    public void playAnimation() {
        this.userActionsTaken.add(UserActionTaken.PLAY_OPTION);
        this.effectiveDrawable.A0();
    }

    public void removeAllAnimatorListeners() {
        this.effectiveDrawable.B0();
    }

    public void removeAllEffectiveOnCompositionLoadedListener() {
        this.effectiveOnCompositionLoadedListeners.clear();
    }

    public void removeAllUpdateListeners() {
        this.effectiveDrawable.C0();
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.effectiveDrawable.D0(animatorListener);
    }

    public void removeAnimatorPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.effectiveDrawable.E0(animatorPauseListener);
    }

    public boolean removeEffectiveOnCompositionLoadedListener(K k10) {
        return this.effectiveOnCompositionLoadedListeners.remove(k10);
    }

    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.effectiveDrawable.F0(animatorUpdateListener);
    }

    public List<e6.e> resolveKeyPath(e6.e eVar) {
        return this.effectiveDrawable.H0(eVar);
    }

    public void resumeAnimation() {
        this.userActionsTaken.add(UserActionTaken.PLAY_OPTION);
        this.effectiveDrawable.I0();
    }

    public void reverseAnimationSpeed() {
        this.effectiveDrawable.J0();
    }

    public void setAnimation(int i10) {
        this.animationResId = i10;
        this.animationName = null;
        setCompositionTask(fromRawRes(i10));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        setAnimationFromJson(str, null);
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(this.cacheComposition ? H.w(getContext(), str) : H.x(getContext(), str, null));
    }

    public void setApplyingOpacityToLayersEnabled(boolean z10) {
        this.effectiveDrawable.L0(z10);
    }

    public void setCacheComposition(boolean z10) {
        this.cacheComposition = z10;
    }

    public void setClipToCompositionBounds(boolean z10) {
        this.effectiveDrawable.M0(z10);
    }

    public void setComposition(C0820a c0820a) {
        this.effectiveDrawable.setCallback(this);
        this.composition = c0820a;
        this.ignoreUnschedule = true;
        boolean N02 = this.effectiveDrawable.N0(c0820a);
        this.ignoreUnschedule = false;
        if (getDrawable() == this.effectiveDrawable && !N02) {
            return;
        }
        if (!N02) {
            setEffectiveAnimationDrawable();
        }
        onVisibilityChanged(this, getVisibility());
        requestLayout();
        Iterator<K> it = this.effectiveOnCompositionLoadedListeners.iterator();
        while (it.hasNext()) {
            it.next().a(c0820a);
        }
    }

    public void setDefaultFontFileExtension(String str) {
        this.effectiveDrawable.O0(str);
    }

    public void setFailureListener(InterfaceC0836q<Throwable> interfaceC0836q) {
        this.failureListener = interfaceC0836q;
    }

    public void setFallbackResource(int i10) {
        this.fallbackResource = i10;
    }

    public void setFontAssetDelegate(L l10) {
        this.effectiveDrawable.P0(l10);
    }

    public void setFontMap(Map<String, Typeface> map) {
        this.effectiveDrawable.Q0(map);
    }

    public void setFrame(int i10) {
        this.effectiveDrawable.R0(i10);
    }

    public void setIgnoreDisabledSystemAnimations(boolean z10) {
        this.effectiveDrawable.S0(z10);
    }

    public void setImageAssetDelegate(M m10) {
        this.effectiveDrawable.T0(m10);
    }

    public void setImageAssetsFolder(String str) {
        this.effectiveDrawable.U0(str);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        cancelLoaderTask();
        super.setImageBitmap(bitmap);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        cancelLoaderTask();
        super.setImageDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i10) {
        cancelLoaderTask();
        super.setImageResource(i10);
    }

    public void setMaintainOriginalImageBounds(boolean z10) {
        this.effectiveDrawable.V0(z10);
    }

    public void setMaxFrame(int i10) {
        this.effectiveDrawable.W0(i10);
    }

    public void setMaxProgress(float f10) {
        this.effectiveDrawable.Y0(f10);
    }

    public void setMinAndMaxFrame(String str) {
        this.effectiveDrawable.a1(str);
    }

    public void setMinAndMaxProgress(float f10, float f11) {
        this.effectiveDrawable.c1(f10, f11);
    }

    public void setMinFrame(int i10) {
        this.effectiveDrawable.d1(i10);
    }

    public void setMinProgress(float f10) {
        this.effectiveDrawable.f1(f10);
    }

    public void setOutlineMasksAndMattes(boolean z10) {
        this.effectiveDrawable.g1(z10);
    }

    public void setPerformanceTrackingEnabled(boolean z10) {
        this.effectiveDrawable.h1(z10);
    }

    public void setProgress(float f10) {
        setProgressInternal(f10, true);
    }

    public void setRenderMode(RenderMode renderMode) {
        this.effectiveDrawable.j1(renderMode);
    }

    public void setRepeatCount(int i10) {
        this.userActionsTaken.add(UserActionTaken.SET_REPEAT_COUNT);
        this.effectiveDrawable.k1(i10);
    }

    public void setRepeatMode(int i10) {
        this.userActionsTaken.add(UserActionTaken.SET_REPEAT_MODE);
        this.effectiveDrawable.l1(i10);
    }

    public void setSafeMode(boolean z10) {
        this.effectiveDrawable.m1(z10);
    }

    public void setSpeed(float f10) {
        this.effectiveDrawable.n1(f10);
    }

    public void setTextDelegate(T t10) {
        this.effectiveDrawable.p1(t10);
    }

    public void setUseCompositionFrameRate(boolean z10) {
        this.effectiveDrawable.q1(z10);
    }

    @Override // android.view.View
    public void unscheduleDrawable(Drawable drawable) {
        EffectiveAnimationDrawable effectiveAnimationDrawable;
        if (!this.ignoreUnschedule && drawable == (effectiveAnimationDrawable = this.effectiveDrawable) && effectiveAnimationDrawable.g0()) {
            pauseAnimation();
        } else if (!this.ignoreUnschedule && (drawable instanceof EffectiveAnimationDrawable)) {
            EffectiveAnimationDrawable effectiveAnimationDrawable2 = (EffectiveAnimationDrawable) drawable;
            if (effectiveAnimationDrawable2.g0()) {
                effectiveAnimationDrawable2.z0();
            }
        }
        super.unscheduleDrawable(drawable);
    }

    public Bitmap updateBitmap(String str, Bitmap bitmap) {
        return this.effectiveDrawable.r1(str, bitmap);
    }

    public <T> void addValueCallback(e6.e eVar, T t10, InterfaceC1339e<T> interfaceC1339e) {
        this.effectiveDrawable.u(eVar, t10, new b(interfaceC1339e));
    }

    public void setAnimationFromJson(String str, String str2) {
        setAnimation(new ByteArrayInputStream(str.getBytes()), str2);
    }

    public void setMaxFrame(String str) {
        this.effectiveDrawable.X0(str);
    }

    public void setMinAndMaxFrame(String str, String str2, boolean z10) {
        this.effectiveDrawable.b1(str, str2, z10);
    }

    public void setMinFrame(String str) {
        this.effectiveDrawable.e1(str);
    }

    public void setMinAndMaxFrame(int i10, int i11) {
        this.effectiveDrawable.Z0(i10, i11);
    }

    public void setAnimation(String str) {
        this.animationName = str;
        this.animationResId = 0;
        setCompositionTask(fromAssets(str));
    }

    public void setAnimationFromUrl(String str, String str2) {
        setCompositionTask(H.x(getContext(), str, str2));
    }

    public void setAnimation(InputStream inputStream, String str) {
        setCompositionTask(H.n(inputStream, str));
    }

    public EffectiveAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.DEFAULT_FAILURE_LISTENER = new InterfaceC0836q() { // from class: com.oplus.anim.w
            @Override // com.oplus.anim.InterfaceC0836q
            public final void a(Object obj) {
                EffectiveAnimationView.lambda$new$0((Throwable) obj);
            }
        };
        this.loadedListener = new InterfaceC0836q() { // from class: com.oplus.anim.x
            @Override // com.oplus.anim.InterfaceC0836q
            public final void a(Object obj) {
                EffectiveAnimationView.this.setComposition((C0820a) obj);
            }
        };
        this.wrappedFailureListener = new a();
        this.fallbackResource = 0;
        this.effectiveDrawable = new EffectiveAnimationDrawable();
        this.ignoreUnschedule = false;
        this.autoPlay = false;
        this.cacheComposition = true;
        this.userActionsTaken = new HashSet();
        this.effectiveOnCompositionLoadedListeners = new HashSet();
        init(attributeSet, P.f25832a);
    }

    public EffectiveAnimationView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.DEFAULT_FAILURE_LISTENER = new InterfaceC0836q() { // from class: com.oplus.anim.w
            @Override // com.oplus.anim.InterfaceC0836q
            public final void a(Object obj) {
                EffectiveAnimationView.lambda$new$0((Throwable) obj);
            }
        };
        this.loadedListener = new InterfaceC0836q() { // from class: com.oplus.anim.x
            @Override // com.oplus.anim.InterfaceC0836q
            public final void a(Object obj) {
                EffectiveAnimationView.this.setComposition((C0820a) obj);
            }
        };
        this.wrappedFailureListener = new a();
        this.fallbackResource = 0;
        this.effectiveDrawable = new EffectiveAnimationDrawable();
        this.ignoreUnschedule = false;
        this.autoPlay = false;
        this.cacheComposition = true;
        this.userActionsTaken = new HashSet();
        this.effectiveOnCompositionLoadedListeners = new HashSet();
        init(attributeSet, i10);
    }
}
