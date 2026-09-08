package androidx.window.embedding;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import androidx.window.core.ExperimentalWindowApi;
import kotlin.jvm.internal.i;

/* compiled from: SplitPairFilter.kt */
@ExperimentalWindowApi
/* loaded from: classes.dex */
public final class SplitPairFilter {

    /* renamed from: a, reason: collision with root package name */
    public final ComponentName f11966a;

    /* renamed from: b, reason: collision with root package name */
    public final ComponentName f11967b;

    /* renamed from: c, reason: collision with root package name */
    public final String f11968c;

    public final boolean a(Activity primaryActivity, Intent secondaryActivityIntent) {
        i.f(primaryActivity, "primaryActivity");
        i.f(secondaryActivityIntent, "secondaryActivityIntent");
        ComponentName componentName = primaryActivity.getComponentName();
        MatcherUtils matcherUtils = MatcherUtils.f11958a;
        if (!matcherUtils.b(componentName, this.f11966a) || !matcherUtils.b(secondaryActivityIntent.getComponent(), this.f11967b)) {
            return false;
        }
        String str = this.f11968c;
        if (str != null && !i.b(str, secondaryActivityIntent.getAction())) {
            return false;
        }
        return true;
    }

    public final boolean b(Activity primaryActivity, Activity secondaryActivity) {
        boolean z10;
        i.f(primaryActivity, "primaryActivity");
        i.f(secondaryActivity, "secondaryActivity");
        MatcherUtils matcherUtils = MatcherUtils.f11958a;
        boolean z11 = false;
        if (matcherUtils.b(primaryActivity.getComponentName(), this.f11966a) && matcherUtils.b(secondaryActivity.getComponentName(), this.f11967b)) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (secondaryActivity.getIntent() != null) {
            if (z10) {
                Intent intent = secondaryActivity.getIntent();
                i.e(intent, "secondaryActivity.intent");
                if (a(primaryActivity, intent)) {
                    z11 = true;
                }
            }
            return z11;
        }
        return z10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SplitPairFilter)) {
            return false;
        }
        SplitPairFilter splitPairFilter = (SplitPairFilter) obj;
        if (i.b(this.f11966a, splitPairFilter.f11966a) && i.b(this.f11967b, splitPairFilter.f11967b) && i.b(this.f11968c, splitPairFilter.f11968c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i10;
        int hashCode = ((this.f11966a.hashCode() * 31) + this.f11967b.hashCode()) * 31;
        String str = this.f11968c;
        if (str != null) {
            i10 = str.hashCode();
        } else {
            i10 = 0;
        }
        return hashCode + i10;
    }

    public String toString() {
        return "SplitPairFilter{primaryActivityName=" + this.f11966a + ", secondaryActivityName=" + this.f11967b + ", secondaryActivityAction=" + this.f11968c + '}';
    }
}
