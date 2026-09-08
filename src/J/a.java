package J;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* compiled from: AccessibilityClickableSpanCompat.java */
/* loaded from: classes.dex */
public final class a extends ClickableSpan {

    /* renamed from: a, reason: collision with root package name */
    public final int f1361a;

    /* renamed from: b, reason: collision with root package name */
    public final d f1362b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1363c;

    public a(int i10, d dVar, int i11) {
        this.f1361a = i10;
        this.f1362b = dVar;
        this.f1363c = i11;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f1361a);
        this.f1362b.Y(this.f1363c, bundle);
    }
}
