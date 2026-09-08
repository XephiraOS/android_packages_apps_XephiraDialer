package androidx.window.embedding;

import androidx.window.core.ExperimentalWindowApi;
import java.util.Set;
import kotlin.jvm.internal.i;

/* compiled from: ActivityRule.kt */
@ExperimentalWindowApi
/* loaded from: classes.dex */
public final class ActivityRule extends EmbeddingRule {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f11936a;

    /* renamed from: b, reason: collision with root package name */
    public final Set<ActivityFilter> f11937b;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityRule)) {
            return false;
        }
        ActivityRule activityRule = (ActivityRule) obj;
        if (i.b(this.f11937b, activityRule.f11937b) && this.f11936a == activityRule.f11936a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.f11937b.hashCode() * 31) + Boolean.hashCode(this.f11936a);
    }
}
