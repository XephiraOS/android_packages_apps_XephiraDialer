package androidx.fragment.app;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;

/* compiled from: FragmentAnim.java */
/* renamed from: androidx.fragment.app.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0477h {
    public static int a(Fragment fragment, boolean z10, boolean z11) {
        if (z11) {
            if (z10) {
                return fragment.getPopEnterAnim();
            }
            return fragment.getPopExitAnim();
        }
        if (z10) {
            return fragment.getEnterAnim();
        }
        return fragment.getExitAnim();
    }

    public static a b(Context context, Fragment fragment, boolean z10, boolean z11) {
        int nextTransition = fragment.getNextTransition();
        int a10 = a(fragment, z10, z11);
        fragment.setAnimations(0, 0, 0, 0);
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            int i10 = R.b.f3157c;
            if (viewGroup.getTag(i10) != null) {
                fragment.mContainer.setTag(i10, null);
            }
        }
        ViewGroup viewGroup2 = fragment.mContainer;
        if (viewGroup2 != null && viewGroup2.getLayoutTransition() != null) {
            return null;
        }
        Animation onCreateAnimation = fragment.onCreateAnimation(nextTransition, z10, a10);
        if (onCreateAnimation != null) {
            return new a(onCreateAnimation);
        }
        Animator onCreateAnimator = fragment.onCreateAnimator(nextTransition, z10, a10);
        if (onCreateAnimator != null) {
            return new a(onCreateAnimator);
        }
        if (a10 == 0 && nextTransition != 0) {
            a10 = d(context, nextTransition, z10);
        }
        if (a10 != 0) {
            boolean equals = "anim".equals(context.getResources().getResourceTypeName(a10));
            if (equals) {
                try {
                    Animation loadAnimation = AnimationUtils.loadAnimation(context, a10);
                    if (loadAnimation != null) {
                        return new a(loadAnimation);
                    }
                } catch (Resources.NotFoundException e10) {
                    throw e10;
                } catch (RuntimeException unused) {
                }
            }
            try {
                Animator loadAnimator = AnimatorInflater.loadAnimator(context, a10);
                if (loadAnimator != null) {
                    return new a(loadAnimator);
                }
            } catch (RuntimeException e11) {
                if (!equals) {
                    Animation loadAnimation2 = AnimationUtils.loadAnimation(context, a10);
                    if (loadAnimation2 != null) {
                        return new a(loadAnimation2);
                    }
                } else {
                    throw e11;
                }
            }
        }
        return null;
    }

    public static int c(Context context, int i10) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(R.style.Animation.Activity, new int[]{i10});
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    public static int d(Context context, int i10, boolean z10) {
        if (i10 != 4097) {
            if (i10 != 8194) {
                if (i10 != 8197) {
                    if (i10 != 4099) {
                        if (i10 != 4100) {
                            return -1;
                        }
                        if (z10) {
                            return c(context, R.attr.activityOpenEnterAnimation);
                        }
                        return c(context, R.attr.activityOpenExitAnimation);
                    }
                    if (z10) {
                        return R.a.f3151c;
                    }
                    return R.a.f3152d;
                }
                if (z10) {
                    return c(context, R.attr.activityCloseEnterAnimation);
                }
                return c(context, R.attr.activityCloseExitAnimation);
            }
            if (z10) {
                return R.a.f3149a;
            }
            return R.a.f3150b;
        }
        if (z10) {
            return R.a.f3153e;
        }
        return R.a.f3154f;
    }

    /* compiled from: FragmentAnim.java */
    /* renamed from: androidx.fragment.app.h$a */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final Animation f10164a;

        /* renamed from: b, reason: collision with root package name */
        public final Animator f10165b;

        public a(Animation animation) {
            this.f10164a = animation;
            this.f10165b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        public a(Animator animator) {
            this.f10164a = null;
            this.f10165b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    /* compiled from: FragmentAnim.java */
    /* renamed from: androidx.fragment.app.h$b */
    /* loaded from: classes.dex */
    public static class b extends AnimationSet implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final ViewGroup f10166a;

        /* renamed from: b, reason: collision with root package name */
        public final View f10167b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f10168c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f10169d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f10170e;

        public b(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f10170e = true;
            this.f10166a = viewGroup;
            this.f10167b = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j10, Transformation transformation) {
            this.f10170e = true;
            if (this.f10168c) {
                return !this.f10169d;
            }
            if (!super.getTransformation(j10, transformation)) {
                this.f10168c = true;
                androidx.core.view.B.a(this.f10166a, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f10168c && this.f10170e) {
                this.f10170e = false;
                this.f10166a.post(this);
            } else {
                this.f10166a.endViewTransition(this.f10167b);
                this.f10169d = true;
            }
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j10, Transformation transformation, float f10) {
            this.f10170e = true;
            if (this.f10168c) {
                return !this.f10169d;
            }
            if (!super.getTransformation(j10, transformation, f10)) {
                this.f10168c = true;
                androidx.core.view.B.a(this.f10166a, this);
            }
            return true;
        }
    }
}
