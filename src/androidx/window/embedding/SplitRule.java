package androidx.window.embedding;

import android.graphics.Rect;
import android.view.WindowMetrics;
import androidx.window.core.ExperimentalWindowApi;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: SplitRule.kt */
@ExperimentalWindowApi
/* loaded from: classes.dex */
public class SplitRule extends EmbeddingRule {

    /* renamed from: e, reason: collision with root package name */
    public static final Companion f11977e = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    public final int f11978a;

    /* renamed from: b, reason: collision with root package name */
    public final int f11979b;

    /* renamed from: c, reason: collision with root package name */
    public final float f11980c;

    /* renamed from: d, reason: collision with root package name */
    public final int f11981d;

    /* compiled from: SplitRule.kt */
    /* loaded from: classes.dex */
    public static final class Api30Impl {

        /* renamed from: a, reason: collision with root package name */
        public static final Api30Impl f11982a = new Api30Impl();

        private Api30Impl() {
        }

        public final Rect a(WindowMetrics windowMetrics) {
            i.f(windowMetrics, "windowMetrics");
            Rect bounds = windowMetrics.getBounds();
            i.e(bounds, "windowMetrics.bounds");
            return bounds;
        }
    }

    /* compiled from: SplitRule.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    /* compiled from: SplitRule.kt */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface LayoutDir {
    }

    /* compiled from: SplitRule.kt */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface SplitFinishBehavior {
    }

    public SplitRule() {
        this(0, 0, 0.0f, 0, 15, null);
    }

    public final boolean a(WindowMetrics parentMetrics) {
        boolean z10;
        boolean z11;
        i.f(parentMetrics, "parentMetrics");
        Rect a10 = Api30Impl.f11982a.a(parentMetrics);
        if (this.f11978a != 0 && a10.width() < this.f11978a) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (this.f11979b != 0 && Math.min(a10.width(), a10.height()) < this.f11979b) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z10 && z11) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SplitRule)) {
            return false;
        }
        SplitRule splitRule = (SplitRule) obj;
        if (this.f11978a == splitRule.f11978a && this.f11979b == splitRule.f11979b && this.f11980c == splitRule.f11980c && this.f11981d == splitRule.f11981d) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f11978a * 31) + this.f11979b) * 31) + Float.hashCode(this.f11980c)) * 31) + this.f11981d;
    }

    public /* synthetic */ SplitRule(int i10, int i11, float f10, int i12, int i13, f fVar) {
        this((i13 & 1) != 0 ? 0 : i10, (i13 & 2) != 0 ? 0 : i11, (i13 & 4) != 0 ? 0.5f : f10, (i13 & 8) != 0 ? 3 : i12);
    }

    public SplitRule(int i10, int i11, float f10, int i12) {
        this.f11978a = i10;
        this.f11979b = i11;
        this.f11980c = f10;
        this.f11981d = i12;
    }
}
