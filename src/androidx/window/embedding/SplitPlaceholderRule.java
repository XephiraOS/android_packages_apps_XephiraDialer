package androidx.window.embedding;

import android.content.Intent;
import androidx.window.core.ExperimentalWindowApi;
import java.util.Set;
import kotlin.jvm.internal.i;

/* compiled from: SplitPlaceholderRule.kt */
@ExperimentalWindowApi
/* loaded from: classes.dex */
public final class SplitPlaceholderRule extends SplitRule {

    /* renamed from: f, reason: collision with root package name */
    public final Intent f11973f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f11974g;

    /* renamed from: h, reason: collision with root package name */
    public final int f11975h;

    /* renamed from: i, reason: collision with root package name */
    public final Set<ActivityFilter> f11976i;

    @Override // androidx.window.embedding.SplitRule
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SplitPlaceholderRule) || !super.equals(obj)) {
            return false;
        }
        SplitPlaceholderRule splitPlaceholderRule = (SplitPlaceholderRule) obj;
        if (i.b(this.f11973f, splitPlaceholderRule.f11973f) && this.f11974g == splitPlaceholderRule.f11974g && this.f11975h == splitPlaceholderRule.f11975h && i.b(this.f11976i, splitPlaceholderRule.f11976i)) {
            return true;
        }
        return false;
    }

    @Override // androidx.window.embedding.SplitRule
    public int hashCode() {
        return (((((((super.hashCode() * 31) + this.f11973f.hashCode()) * 31) + Boolean.hashCode(this.f11974g)) * 31) + Integer.hashCode(this.f11975h)) * 31) + this.f11976i.hashCode();
    }
}
