package j0;

import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;

/* compiled from: Animatable2Compat.java */
/* renamed from: j0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1152b {

    /* renamed from: a, reason: collision with root package name */
    public Animatable2.AnimationCallback f33756a;

    /* compiled from: Animatable2Compat.java */
    /* renamed from: j0.b$a */
    /* loaded from: classes.dex */
    public class a extends Animatable2.AnimationCallback {
        public a() {
        }

        @Override // android.graphics.drawable.Animatable2.AnimationCallback
        public void onAnimationEnd(Drawable drawable) {
            AbstractC1152b.this.b(drawable);
        }

        @Override // android.graphics.drawable.Animatable2.AnimationCallback
        public void onAnimationStart(Drawable drawable) {
            AbstractC1152b.this.c(drawable);
        }
    }

    public Animatable2.AnimationCallback a() {
        if (this.f33756a == null) {
            this.f33756a = new a();
        }
        return this.f33756a;
    }

    public void b(Drawable drawable) {
    }

    public void c(Drawable drawable) {
    }
}
