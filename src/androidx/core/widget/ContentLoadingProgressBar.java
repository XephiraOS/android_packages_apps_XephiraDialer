package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/* loaded from: classes.dex */
public class ContentLoadingProgressBar extends ProgressBar {

    /* renamed from: a, reason: collision with root package name */
    public long f9525a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f9526b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f9527c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f9528d;

    /* renamed from: e, reason: collision with root package name */
    public final Runnable f9529e;

    /* renamed from: f, reason: collision with root package name */
    public final Runnable f9530f;

    public ContentLoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f9525a = -1L;
        this.f9526b = false;
        this.f9527c = false;
        this.f9528d = false;
        this.f9529e = new Runnable() { // from class: androidx.core.widget.d
            @Override // java.lang.Runnable
            public final void run() {
                ContentLoadingProgressBar.this.c();
            }
        };
        this.f9530f = new Runnable() { // from class: androidx.core.widget.e
            @Override // java.lang.Runnable
            public final void run() {
                ContentLoadingProgressBar.this.d();
            }
        };
    }

    public final /* synthetic */ void c() {
        this.f9526b = false;
        this.f9525a = -1L;
        setVisibility(8);
    }

    public final /* synthetic */ void d() {
        this.f9527c = false;
        if (!this.f9528d) {
            this.f9525a = System.currentTimeMillis();
            setVisibility(0);
        }
    }

    public final void e() {
        removeCallbacks(this.f9529e);
        removeCallbacks(this.f9530f);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        e();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
    }
}
