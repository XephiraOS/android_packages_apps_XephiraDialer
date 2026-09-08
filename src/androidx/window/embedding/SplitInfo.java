package androidx.window.embedding;

import android.app.Activity;
import androidx.window.core.ExperimentalWindowApi;
import kotlin.jvm.internal.i;

/* compiled from: SplitInfo.kt */
@ExperimentalWindowApi
/* loaded from: classes.dex */
public final class SplitInfo {

    /* renamed from: a, reason: collision with root package name */
    public final ActivityStack f11963a;

    /* renamed from: b, reason: collision with root package name */
    public final ActivityStack f11964b;

    /* renamed from: c, reason: collision with root package name */
    public final float f11965c;

    public SplitInfo(ActivityStack primaryActivityStack, ActivityStack secondaryActivityStack, float f10) {
        i.f(primaryActivityStack, "primaryActivityStack");
        i.f(secondaryActivityStack, "secondaryActivityStack");
        this.f11963a = primaryActivityStack;
        this.f11964b = secondaryActivityStack;
        this.f11965c = f10;
    }

    public final boolean a(Activity activity) {
        i.f(activity, "activity");
        if (!this.f11963a.a(activity) && !this.f11964b.a(activity)) {
            return false;
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SplitInfo)) {
            return false;
        }
        SplitInfo splitInfo = (SplitInfo) obj;
        if (i.b(this.f11963a, splitInfo.f11963a) && i.b(this.f11964b, splitInfo.f11964b) && this.f11965c == splitInfo.f11965c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.f11963a.hashCode() * 31) + this.f11964b.hashCode()) * 31) + Float.hashCode(this.f11965c);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SplitInfo:{");
        sb.append("primaryActivityStack=" + this.f11963a + ',');
        sb.append("secondaryActivityStack=" + this.f11964b + ',');
        sb.append("splitRatio=" + this.f11965c + '}');
        String sb2 = sb.toString();
        i.e(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
