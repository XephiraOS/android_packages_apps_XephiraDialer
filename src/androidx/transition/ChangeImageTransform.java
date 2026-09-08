package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.transition.B;
import androidx.transition.Transition;
import java.util.Map;

/* loaded from: classes.dex */
public class ChangeImageTransform extends Transition {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f11568a = {"android:changeImageTransform:matrix", "android:changeImageTransform:bounds"};

    /* renamed from: b, reason: collision with root package name */
    public static final TypeEvaluator<Matrix> f11569b = new a();

    /* renamed from: c, reason: collision with root package name */
    public static final Property<ImageView, Matrix> f11570c = new b(Matrix.class, "animatedTransform");

    /* loaded from: classes.dex */
    public class a implements TypeEvaluator<Matrix> {
        @Override // android.animation.TypeEvaluator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Matrix evaluate(float f10, Matrix matrix, Matrix matrix2) {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public class b extends Property<ImageView, Matrix> {
        public b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Matrix get(ImageView imageView) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(ImageView imageView, Matrix matrix) {
            C0507j.a(imageView, matrix);
        }
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11571a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f11571a = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_XY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11571a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d extends AnimatorListenerAdapter implements Transition.i {

        /* renamed from: a, reason: collision with root package name */
        public final ImageView f11572a;

        /* renamed from: b, reason: collision with root package name */
        public final Matrix f11573b;

        /* renamed from: c, reason: collision with root package name */
        public final Matrix f11574c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f11575d = true;

        public d(ImageView imageView, Matrix matrix, Matrix matrix2) {
            this.f11572a = imageView;
            this.f11573b = matrix;
            this.f11574c = matrix2;
        }

        @Override // androidx.transition.Transition.i
        public void b(Transition transition) {
            if (this.f11575d) {
                i(this.f11573b);
            }
        }

        @Override // androidx.transition.Transition.i
        public void g(Transition transition) {
            h();
        }

        public final void h() {
            ImageView imageView = this.f11572a;
            int i10 = C0511n.f11731g;
            Matrix matrix = (Matrix) imageView.getTag(i10);
            if (matrix != null) {
                C0507j.a(this.f11572a, matrix);
                this.f11572a.setTag(i10, null);
            }
        }

        public final void i(Matrix matrix) {
            this.f11572a.setTag(C0511n.f11731g, matrix);
            C0507j.a(this.f11572a, this.f11574c);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z10) {
            this.f11575d = z10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            i((Matrix) ((ObjectAnimator) animator).getAnimatedValue());
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            h();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator, boolean z10) {
            this.f11575d = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f11575d = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f11575d = false;
        }

        @Override // androidx.transition.Transition.i
        public void a(Transition transition) {
        }

        @Override // androidx.transition.Transition.i
        public void d(Transition transition) {
        }

        @Override // androidx.transition.Transition.i
        public void e(Transition transition) {
        }
    }

    public ChangeImageTransform() {
    }

    private void a(C c10, boolean z10) {
        Matrix matrix;
        View view = c10.f11528b;
        if ((view instanceof ImageView) && view.getVisibility() == 0) {
            ImageView imageView = (ImageView) view;
            if (imageView.getDrawable() == null) {
                return;
            }
            Map<String, Object> map = c10.f11527a;
            map.put("android:changeImageTransform:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            if (z10) {
                matrix = (Matrix) imageView.getTag(C0511n.f11731g);
            } else {
                matrix = null;
            }
            if (matrix == null) {
                matrix = c(imageView);
            }
            map.put("android:changeImageTransform:matrix", matrix);
        }
    }

    public static Matrix b(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        float width = imageView.getWidth();
        float f10 = intrinsicWidth;
        int intrinsicHeight = drawable.getIntrinsicHeight();
        float height = imageView.getHeight();
        float f11 = intrinsicHeight;
        float max = Math.max(width / f10, height / f11);
        int round = Math.round((width - (f10 * max)) / 2.0f);
        int round2 = Math.round((height - (f11 * max)) / 2.0f);
        Matrix matrix = new Matrix();
        matrix.postScale(max, max);
        matrix.postTranslate(round, round2);
        return matrix;
    }

    public static Matrix c(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        if (drawable.getIntrinsicWidth() > 0 && drawable.getIntrinsicHeight() > 0) {
            int i10 = c.f11571a[imageView.getScaleType().ordinal()];
            if (i10 != 1) {
                if (i10 != 2) {
                    return new Matrix(imageView.getImageMatrix());
                }
                return b(imageView);
            }
            return f(imageView);
        }
        return new Matrix(imageView.getImageMatrix());
    }

    public static Matrix f(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        Matrix matrix = new Matrix();
        matrix.postScale(imageView.getWidth() / drawable.getIntrinsicWidth(), imageView.getHeight() / drawable.getIntrinsicHeight());
        return matrix;
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(C c10) {
        a(c10, false);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(C c10) {
        a(c10, true);
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(ViewGroup viewGroup, C c10, C c11) {
        boolean z10;
        if (c10 != null && c11 != null) {
            Rect rect = (Rect) c10.f11527a.get("android:changeImageTransform:bounds");
            Rect rect2 = (Rect) c11.f11527a.get("android:changeImageTransform:bounds");
            if (rect != null && rect2 != null) {
                Matrix matrix = (Matrix) c10.f11527a.get("android:changeImageTransform:matrix");
                Matrix matrix2 = (Matrix) c11.f11527a.get("android:changeImageTransform:matrix");
                if ((matrix == null && matrix2 == null) || (matrix != null && matrix.equals(matrix2))) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (rect.equals(rect2) && z10) {
                    return null;
                }
                ImageView imageView = (ImageView) c11.f11528b;
                Drawable drawable = imageView.getDrawable();
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                    if (matrix == null) {
                        matrix = C0508k.f11724a;
                    }
                    if (matrix2 == null) {
                        matrix2 = C0508k.f11724a;
                    }
                    f11570c.set(imageView, matrix);
                    ObjectAnimator d10 = d(imageView, matrix, matrix2);
                    d dVar = new d(imageView, matrix, matrix2);
                    d10.addListener(dVar);
                    d10.addPauseListener(dVar);
                    addListener(dVar);
                    return d10;
                }
                return e(imageView);
            }
        }
        return null;
    }

    public final ObjectAnimator d(ImageView imageView, Matrix matrix, Matrix matrix2) {
        return ObjectAnimator.ofObject(imageView, (Property<ImageView, V>) f11570c, (TypeEvaluator) new B.b(), (Object[]) new Matrix[]{matrix, matrix2});
    }

    public final ObjectAnimator e(ImageView imageView) {
        Property<ImageView, Matrix> property = f11570c;
        TypeEvaluator<Matrix> typeEvaluator = f11569b;
        Matrix matrix = C0508k.f11724a;
        return ObjectAnimator.ofObject(imageView, (Property<ImageView, V>) property, (TypeEvaluator) typeEvaluator, (Object[]) new Matrix[]{matrix, matrix});
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return f11568a;
    }

    @Override // androidx.transition.Transition
    public boolean isSeekingSupported() {
        return true;
    }

    public ChangeImageTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
