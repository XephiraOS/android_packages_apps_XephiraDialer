package androidx.window.embedding;

import androidx.window.core.ExperimentalWindowApi;
import java.util.Set;
import kotlin.jvm.internal.i;

/* compiled from: SplitPairRule.kt */
@ExperimentalWindowApi
/* loaded from: classes.dex */
public final class SplitPairRule extends SplitRule {

    /* renamed from: f, reason: collision with root package name */
    public final int f11969f;

    /* renamed from: g, reason: collision with root package name */
    public final int f11970g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f11971h;

    /* renamed from: i, reason: collision with root package name */
    public final Set<SplitPairFilter> f11972i;

    @Override // androidx.window.embedding.SplitRule
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SplitPairRule) || !super.equals(obj)) {
            return false;
        }
        SplitPairRule splitPairRule = (SplitPairRule) obj;
        if (i.b(this.f11972i, splitPairRule.f11972i) && this.f11969f == splitPairRule.f11969f && this.f11970g == splitPairRule.f11970g && this.f11971h == splitPairRule.f11971h) {
            return true;
        }
        return false;
    }

    @Override // androidx.window.embedding.SplitRule
    public int hashCode() {
        return (((((((super.hashCode() * 31) + this.f11972i.hashCode()) * 31) + Integer.hashCode(this.f11969f)) * 31) + Integer.hashCode(this.f11970g)) * 31) + Boolean.hashCode(this.f11971h);
    }
}
