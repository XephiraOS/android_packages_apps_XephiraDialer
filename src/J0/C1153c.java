package j0;

import A.h;
import A.k;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import p.C1415a;

/* compiled from: AnimatedVectorDrawableCompat.java */
/* renamed from: j0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1153c extends AbstractC1156f implements Animatable {

    /* renamed from: b, reason: collision with root package name */
    public C0318c f33758b;

    /* renamed from: c, reason: collision with root package name */
    public Context f33759c;

    /* renamed from: d, reason: collision with root package name */
    public ArgbEvaluator f33760d;

    /* renamed from: e, reason: collision with root package name */
    public d f33761e;

    /* renamed from: f, reason: collision with root package name */
    public Animator.AnimatorListener f33762f;

    /* renamed from: g, reason: collision with root package name */
    public ArrayList<AbstractC1152b> f33763g;

    /* renamed from: h, reason: collision with root package name */
    public final Drawable.Callback f33764h;

    /* compiled from: AnimatedVectorDrawableCompat.java */
    /* renamed from: j0.c$a */
    /* loaded from: classes.dex */
    public class a implements Drawable.Callback {
        public a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            C1153c.this.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
            C1153c.this.scheduleSelf(runnable, j10);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            C1153c.this.unscheduleSelf(runnable);
        }
    }

    /* compiled from: AnimatedVectorDrawableCompat.java */
    /* renamed from: j0.c$b */
    /* loaded from: classes.dex */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ArrayList arrayList = new ArrayList(C1153c.this.f33763g);
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((AbstractC1152b) arrayList.get(i10)).b(C1153c.this);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            ArrayList arrayList = new ArrayList(C1153c.this.f33763g);
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((AbstractC1152b) arrayList.get(i10)).c(C1153c.this);
            }
        }
    }

    /* compiled from: AnimatedVectorDrawableCompat.java */
    /* renamed from: j0.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0318c extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        public int f33767a;

        /* renamed from: b, reason: collision with root package name */
        public C1157g f33768b;

        /* renamed from: c, reason: collision with root package name */
        public AnimatorSet f33769c;

        /* renamed from: d, reason: collision with root package name */
        public ArrayList<Animator> f33770d;

        /* renamed from: e, reason: collision with root package name */
        public C1415a<Animator, String> f33771e;

        public C0318c(Context context, C0318c c0318c, Drawable.Callback callback, Resources resources) {
            if (c0318c != null) {
                this.f33767a = c0318c.f33767a;
                C1157g c1157g = c0318c.f33768b;
                if (c1157g != null) {
                    Drawable.ConstantState constantState = c1157g.getConstantState();
                    if (resources != null) {
                        this.f33768b = (C1157g) constantState.newDrawable(resources);
                    } else {
                        this.f33768b = (C1157g) constantState.newDrawable();
                    }
                    C1157g c1157g2 = (C1157g) this.f33768b.mutate();
                    this.f33768b = c1157g2;
                    c1157g2.setCallback(callback);
                    this.f33768b.setBounds(c0318c.f33768b.getBounds());
                    this.f33768b.g(false);
                }
                ArrayList<Animator> arrayList = c0318c.f33770d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.f33770d = new ArrayList<>(size);
                    this.f33771e = new C1415a<>(size);
                    for (int i10 = 0; i10 < size; i10++) {
                        Animator animator = c0318c.f33770d.get(i10);
                        Animator clone = animator.clone();
                        String str = c0318c.f33771e.get(animator);
                        clone.setTarget(this.f33768b.c(str));
                        this.f33770d.add(clone);
                        this.f33771e.put(clone, str);
                    }
                    a();
                }
            }
        }

        public void a() {
            if (this.f33769c == null) {
                this.f33769c = new AnimatorSet();
            }
            this.f33769c.playTogether(this.f33770d);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f33767a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    public C1153c() {
        this(null, null, null);
    }

    public static C1153c a(Context context, int i10) {
        C1153c c1153c = new C1153c(context);
        Drawable f10 = h.f(context.getResources(), i10, context.getTheme());
        c1153c.f33773a = f10;
        f10.setCallback(c1153c.f33764h);
        c1153c.f33761e = new d(c1153c.f33773a.getConstantState());
        return c1153c;
    }

    public static void c(AnimatedVectorDrawable animatedVectorDrawable, AbstractC1152b abstractC1152b) {
        animatedVectorDrawable.registerAnimationCallback(abstractC1152b.a());
    }

    public static boolean g(AnimatedVectorDrawable animatedVectorDrawable, AbstractC1152b abstractC1152b) {
        return animatedVectorDrawable.unregisterAnimationCallback(abstractC1152b.a());
    }

    @Override // j0.AbstractC1156f, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f33773a;
        if (drawable != null) {
            C.a.a(drawable, theme);
        }
    }

    public void b(AbstractC1152b abstractC1152b) {
        Drawable drawable = this.f33773a;
        if (drawable != null) {
            c((AnimatedVectorDrawable) drawable, abstractC1152b);
            return;
        }
        if (abstractC1152b == null) {
            return;
        }
        if (this.f33763g == null) {
            this.f33763g = new ArrayList<>();
        }
        if (this.f33763g.contains(abstractC1152b)) {
            return;
        }
        this.f33763g.add(abstractC1152b);
        if (this.f33762f == null) {
            this.f33762f = new b();
        }
        this.f33758b.f33769c.addListener(this.f33762f);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f33773a;
        if (drawable != null) {
            return C.a.b(drawable);
        }
        return false;
    }

    @Override // j0.AbstractC1156f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public final void d() {
        Animator.AnimatorListener animatorListener = this.f33762f;
        if (animatorListener != null) {
            this.f33758b.f33769c.removeListener(animatorListener);
            this.f33762f = null;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f33773a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.f33758b.f33768b.draw(canvas);
        if (this.f33758b.f33769c.isStarted()) {
            invalidateSelf();
        }
    }

    public final void e(String str, Animator animator) {
        animator.setTarget(this.f33758b.f33768b.c(str));
        C0318c c0318c = this.f33758b;
        if (c0318c.f33770d == null) {
            c0318c.f33770d = new ArrayList<>();
            this.f33758b.f33771e = new C1415a<>();
        }
        this.f33758b.f33770d.add(animator);
        this.f33758b.f33771e.put(animator, str);
    }

    public boolean f(AbstractC1152b abstractC1152b) {
        Drawable drawable = this.f33773a;
        if (drawable != null) {
            g((AnimatedVectorDrawable) drawable, abstractC1152b);
        }
        ArrayList<AbstractC1152b> arrayList = this.f33763g;
        if (arrayList != null && abstractC1152b != null) {
            boolean remove = arrayList.remove(abstractC1152b);
            if (this.f33763g.size() == 0) {
                d();
            }
            return remove;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f33773a;
        if (drawable != null) {
            return C.a.d(drawable);
        }
        return this.f33758b.f33768b.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f33773a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return this.f33758b.f33767a | super.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f33773a;
        if (drawable != null) {
            return C.a.e(drawable);
        }
        return this.f33758b.f33768b.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f33773a != null) {
            return new d(this.f33773a.getConstantState());
        }
        return null;
    }

    @Override // j0.AbstractC1156f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f33773a;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return this.f33758b.f33768b.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f33773a;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return this.f33758b.f33768b.getIntrinsicWidth();
    }

    @Override // j0.AbstractC1156f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // j0.AbstractC1156f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f33773a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return this.f33758b.f33768b.getOpacity();
    }

    @Override // j0.AbstractC1156f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // j0.AbstractC1156f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // j0.AbstractC1156f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        Drawable drawable = this.f33773a;
        if (drawable != null) {
            C.a.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray s10 = k.s(resources, theme, attributeSet, C1151a.f33748e);
                    int resourceId = s10.getResourceId(0, 0);
                    if (resourceId != 0) {
                        C1157g b10 = C1157g.b(resources, resourceId, theme);
                        b10.g(false);
                        b10.setCallback(this.f33764h);
                        C1157g c1157g = this.f33758b.f33768b;
                        if (c1157g != null) {
                            c1157g.setCallback(null);
                        }
                        this.f33758b.f33768b = b10;
                    }
                    s10.recycle();
                } else if ("target".equals(name)) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, C1151a.f33749f);
                    String string = obtainAttributes.getString(0);
                    int resourceId2 = obtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.f33759c;
                        if (context != null) {
                            e(string, C1155e.a(context, resourceId2));
                        } else {
                            obtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    obtainAttributes.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        this.f33758b.a();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f33773a;
        if (drawable != null) {
            return C.a.h(drawable);
        }
        return this.f33758b.f33768b.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        Drawable drawable = this.f33773a;
        if (drawable != null) {
            return ((AnimatedVectorDrawable) drawable).isRunning();
        }
        return this.f33758b.f33769c.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = this.f33773a;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return this.f33758b.f33768b.isStateful();
    }

    @Override // j0.AbstractC1156f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f33773a;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f33773a;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f33758b.f33768b.setBounds(rect);
        }
    }

    @Override // j0.AbstractC1156f, android.graphics.drawable.Drawable
    public boolean onLevelChange(int i10) {
        Drawable drawable = this.f33773a;
        if (drawable != null) {
            return drawable.setLevel(i10);
        }
        return this.f33758b.f33768b.setLevel(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f33773a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        return this.f33758b.f33768b.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        Drawable drawable = this.f33773a;
        if (drawable != null) {
            drawable.setAlpha(i10);
        } else {
            this.f33758b.f33768b.setAlpha(i10);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z10) {
        Drawable drawable = this.f33773a;
        if (drawable != null) {
            C.a.j(drawable, z10);
        } else {
            this.f33758b.f33768b.setAutoMirrored(z10);
        }
    }

    @Override // j0.AbstractC1156f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i10) {
        super.setChangingConfigurations(i10);
    }

    @Override // j0.AbstractC1156f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i10, PorterDuff.Mode mode) {
        super.setColorFilter(i10, mode);
    }

    @Override // j0.AbstractC1156f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z10) {
        super.setFilterBitmap(z10);
    }

    @Override // j0.AbstractC1156f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f10, float f11) {
        super.setHotspot(f10, f11);
    }

    @Override // j0.AbstractC1156f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i10, int i11, int i12, int i13) {
        super.setHotspotBounds(i10, i11, i12, i13);
    }

    @Override // j0.AbstractC1156f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i10) {
        Drawable drawable = this.f33773a;
        if (drawable != null) {
            C.a.n(drawable, i10);
        } else {
            this.f33758b.f33768b.setTint(i10);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f33773a;
        if (drawable != null) {
            C.a.o(drawable, colorStateList);
        } else {
            this.f33758b.f33768b.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f33773a;
        if (drawable != null) {
            C.a.p(drawable, mode);
        } else {
            this.f33758b.f33768b.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        Drawable drawable = this.f33773a;
        if (drawable != null) {
            return drawable.setVisible(z10, z11);
        }
        this.f33758b.f33768b.setVisible(z10, z11);
        return super.setVisible(z10, z11);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable drawable = this.f33773a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else {
            if (this.f33758b.f33769c.isStarted()) {
                return;
            }
            this.f33758b.f33769c.start();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Drawable drawable = this.f33773a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f33758b.f33769c.end();
        }
    }

    public C1153c(Context context) {
        this(context, null, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f33773a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f33758b.f33768b.setColorFilter(colorFilter);
        }
    }

    /* compiled from: AnimatedVectorDrawableCompat.java */
    /* renamed from: j0.c$d */
    /* loaded from: classes.dex */
    public static class d extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        public final Drawable.ConstantState f33772a;

        public d(Drawable.ConstantState constantState) {
            this.f33772a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f33772a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f33772a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            C1153c c1153c = new C1153c();
            Drawable newDrawable = this.f33772a.newDrawable();
            c1153c.f33773a = newDrawable;
            newDrawable.setCallback(c1153c.f33764h);
            return c1153c;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            C1153c c1153c = new C1153c();
            Drawable newDrawable = this.f33772a.newDrawable(resources);
            c1153c.f33773a = newDrawable;
            newDrawable.setCallback(c1153c.f33764h);
            return c1153c;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            C1153c c1153c = new C1153c();
            Drawable newDrawable = this.f33772a.newDrawable(resources, theme);
            c1153c.f33773a = newDrawable;
            newDrawable.setCallback(c1153c.f33764h);
            return c1153c;
        }
    }

    public C1153c(Context context, C0318c c0318c, Resources resources) {
        this.f33760d = null;
        this.f33762f = null;
        this.f33763g = null;
        a aVar = new a();
        this.f33764h = aVar;
        this.f33759c = context;
        if (c0318c != null) {
            this.f33758b = c0318c;
        } else {
            this.f33758b = new C0318c(context, c0318c, aVar, resources);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflate(resources, xmlPullParser, attributeSet, null);
    }
}
