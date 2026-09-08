package x4;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

/* compiled from: ShapeableDelegateV33.java */
/* loaded from: classes3.dex */
public class t extends s {

    /* compiled from: ShapeableDelegateV33.java */
    /* loaded from: classes3.dex */
    public class a extends ViewOutlineProvider {
        public a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            if (!t.this.f37997e.isEmpty()) {
                outline.setPath(t.this.f37997e);
            }
        }
    }

    public t(View view) {
        l(view);
    }

    private void l(View view) {
        view.setOutlineProvider(new a());
    }

    @Override // x4.s
    public void b(View view) {
        view.setClipToOutline(!j());
        if (j()) {
            view.invalidate();
        } else {
            view.invalidateOutline();
        }
    }

    @Override // x4.s
    public boolean j() {
        return this.f37993a;
    }
}
