package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public TypedValue f7656a;

    /* renamed from: b, reason: collision with root package name */
    public TypedValue f7657b;

    /* renamed from: c, reason: collision with root package name */
    public TypedValue f7658c;

    /* renamed from: d, reason: collision with root package name */
    public TypedValue f7659d;

    /* renamed from: e, reason: collision with root package name */
    public TypedValue f7660e;

    /* renamed from: f, reason: collision with root package name */
    public TypedValue f7661f;

    /* renamed from: g, reason: collision with root package name */
    public final Rect f7662g;

    /* renamed from: h, reason: collision with root package name */
    public a f7663h;

    /* loaded from: classes.dex */
    public interface a {
        void a();

        void onDetachedFromWindow();
    }

    public ContentFrameLayout(Context context) {
        this(context, null);
    }

    public void a(int i10, int i11, int i12, int i13) {
        this.f7662g.set(i10, i11, i12, i13);
        if (isLaidOut()) {
            requestLayout();
        }
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f7660e == null) {
            this.f7660e = new TypedValue();
        }
        return this.f7660e;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f7661f == null) {
            this.f7661f = new TypedValue();
        }
        return this.f7661f;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f7658c == null) {
            this.f7658c = new TypedValue();
        }
        return this.f7658c;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f7659d == null) {
            this.f7659d = new TypedValue();
        }
        return this.f7659d;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f7656a == null) {
            this.f7656a = new TypedValue();
        }
        return this.f7656a;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f7657b == null) {
            this.f7657b = new TypedValue();
        }
        return this.f7657b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a aVar = this.f7663h;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.f7663h;
        if (aVar != null) {
            aVar.onDetachedFromWindow();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ae  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r14, int r15) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ContentFrameLayout.onMeasure(int, int):void");
    }

    public void setAttachListener(a aVar) {
        this.f7663h = aVar;
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f7662g = new Rect();
    }
}
