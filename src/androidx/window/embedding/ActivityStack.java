package androidx.window.embedding;

import android.app.Activity;
import androidx.window.core.ExperimentalWindowApi;
import java.util.List;
import kotlin.jvm.internal.i;

/* compiled from: ActivityStack.kt */
@ExperimentalWindowApi
/* loaded from: classes.dex */
public final class ActivityStack {

    /* renamed from: a, reason: collision with root package name */
    public final List<Activity> f11938a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f11939b;

    /* JADX WARN: Multi-variable type inference failed */
    public ActivityStack(List<? extends Activity> activities, boolean z10) {
        i.f(activities, "activities");
        this.f11938a = activities;
        this.f11939b = z10;
    }

    public final boolean a(Activity activity) {
        i.f(activity, "activity");
        return this.f11938a.contains(activity);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityStack)) {
            return false;
        }
        ActivityStack activityStack = (ActivityStack) obj;
        if (!i.b(this.f11938a, activityStack.f11938a) && this.f11939b != activityStack.f11939b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.f11939b ? 1 : 0) * 31) + this.f11938a.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ActivityStack{");
        sb.append("activities=" + this.f11938a);
        sb.append("isEmpty=" + this.f11939b + '}');
        String sb2 = sb.toString();
        i.e(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
