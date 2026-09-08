package androidx.window.embedding;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import androidx.window.core.ExperimentalWindowApi;
import kotlin.jvm.internal.i;

/* compiled from: ActivityFilter.kt */
@ExperimentalWindowApi
/* loaded from: classes.dex */
public final class ActivityFilter {

    /* renamed from: a, reason: collision with root package name */
    public final ComponentName f11934a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11935b;

    public final boolean a(Activity activity) {
        String str;
        i.f(activity, "activity");
        if (MatcherUtils.f11958a.a(activity, this.f11934a)) {
            String str2 = this.f11935b;
            if (str2 != null) {
                Intent intent = activity.getIntent();
                if (intent != null) {
                    str = intent.getAction();
                } else {
                    str = null;
                }
                if (i.b(str2, str)) {
                }
            }
            return true;
        }
        return false;
    }

    public final boolean b(Intent intent) {
        i.f(intent, "intent");
        if (!MatcherUtils.f11958a.b(intent.getComponent(), this.f11934a)) {
            return false;
        }
        String str = this.f11935b;
        if (str != null && !i.b(str, intent.getAction())) {
            return false;
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityFilter)) {
            return false;
        }
        ActivityFilter activityFilter = (ActivityFilter) obj;
        if (i.b(this.f11934a, activityFilter.f11934a) && i.b(this.f11935b, activityFilter.f11935b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i10;
        int hashCode = this.f11934a.hashCode() * 31;
        String str = this.f11935b;
        if (str != null) {
            i10 = str.hashCode();
        } else {
            i10 = 0;
        }
        return hashCode + i10;
    }

    public String toString() {
        return "ActivityFilter(componentName=" + this.f11934a + ", intentAction=" + this.f11935b + ')';
    }
}
