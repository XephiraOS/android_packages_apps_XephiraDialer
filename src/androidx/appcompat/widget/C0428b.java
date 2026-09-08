package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

/* compiled from: ActionBarBackgroundDrawable.java */
/* renamed from: androidx.appcompat.widget.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0428b extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    public final ActionBarContainer f7837a;

    /* compiled from: ActionBarBackgroundDrawable.java */
    /* renamed from: androidx.appcompat.widget.b$a */
    /* loaded from: classes.dex */
    public static class a {
        public static void a(Drawable drawable, Outline outline) {
            drawable.getOutline(outline);
        }
    }

    public C0428b(ActionBarContainer actionBarContainer) {
        this.f7837a = actionBarContainer;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        ActionBarContainer actionBarContainer = this.f7837a;
        if (actionBarContainer.f7472h) {
            Drawable drawable = actionBarContainer.f7471g;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.f7469e;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        ActionBarContainer actionBarContainer2 = this.f7837a;
        Drawable drawable3 = actionBarContainer2.f7470f;
        if (drawable3 != null && actionBarContainer2.f7473i) {
            drawable3.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        ActionBarContainer actionBarContainer = this.f7837a;
        if (actionBarContainer.f7472h) {
            if (actionBarContainer.f7471g != null) {
                a.a(actionBarContainer.f7469e, outline);
            }
        } else {
            Drawable drawable = actionBarContainer.f7469e;
            if (drawable != null) {
                a.a(drawable, outline);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
