package androidx.window.embedding;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import androidx.window.core.ExperimentalWindowApi;
import kotlin.jvm.internal.i;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.n;

/* compiled from: MatcherUtils.kt */
@ExperimentalWindowApi
/* loaded from: classes.dex */
public final class MatcherUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final MatcherUtils f11958a = new MatcherUtils();

    private MatcherUtils() {
    }

    public final boolean a(Activity activity, ComponentName ruleComponent) {
        ComponentName component;
        i.f(activity, "activity");
        i.f(ruleComponent, "ruleComponent");
        if (b(activity.getComponentName(), ruleComponent)) {
            return true;
        }
        Intent intent = activity.getIntent();
        if (intent != null && (component = intent.getComponent()) != null) {
            return f11958a.b(component, ruleComponent);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0089 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(android.content.ComponentName r7, android.content.ComponentName r8) {
        /*
            r6 = this;
            java.lang.String r0 = "ruleComponent"
            kotlin.jvm.internal.i.f(r8, r0)
            java.lang.String r0 = "*"
            r1 = 0
            r2 = 1
            if (r7 != 0) goto L21
            java.lang.String r6 = r8.getPackageName()
            boolean r6 = kotlin.jvm.internal.i.b(r6, r0)
            if (r6 == 0) goto L20
            java.lang.String r6 = r8.getClassName()
            boolean r6 = kotlin.jvm.internal.i.b(r6, r0)
            if (r6 == 0) goto L20
            r1 = r2
        L20:
            return r1
        L21:
            java.lang.String r3 = r7.toString()
            java.lang.String r4 = "activityComponent.toString()"
            kotlin.jvm.internal.i.e(r3, r4)
            r4 = 2
            r5 = 0
            boolean r0 = kotlin.text.f.y(r3, r0, r1, r4, r5)
            r0 = r0 ^ r2
            if (r0 == 0) goto L8d
            java.lang.String r0 = r7.getPackageName()
            java.lang.String r3 = r8.getPackageName()
            boolean r0 = kotlin.jvm.internal.i.b(r0, r3)
            if (r0 != 0) goto L5c
            java.lang.String r0 = r7.getPackageName()
            java.lang.String r3 = "activityComponent.packageName"
            kotlin.jvm.internal.i.e(r0, r3)
            java.lang.String r3 = r8.getPackageName()
            java.lang.String r4 = "ruleComponent.packageName"
            kotlin.jvm.internal.i.e(r3, r4)
            boolean r0 = r6.c(r0, r3)
            if (r0 == 0) goto L5a
            goto L5c
        L5a:
            r0 = r1
            goto L5d
        L5c:
            r0 = r2
        L5d:
            java.lang.String r3 = r7.getClassName()
            java.lang.String r4 = r8.getClassName()
            boolean r3 = kotlin.jvm.internal.i.b(r3, r4)
            if (r3 != 0) goto L86
            java.lang.String r7 = r7.getClassName()
            java.lang.String r3 = "activityComponent.className"
            kotlin.jvm.internal.i.e(r7, r3)
            java.lang.String r8 = r8.getClassName()
            java.lang.String r3 = "ruleComponent.className"
            kotlin.jvm.internal.i.e(r8, r3)
            boolean r6 = r6.c(r7, r8)
            if (r6 == 0) goto L84
            goto L86
        L84:
            r6 = r1
            goto L87
        L86:
            r6 = r2
        L87:
            if (r0 == 0) goto L8c
            if (r6 == 0) goto L8c
            r1 = r2
        L8c:
            return r1
        L8d:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r7 = "Wildcard can only be part of the rule."
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.window.embedding.MatcherUtils.b(android.content.ComponentName, android.content.ComponentName):boolean");
    }

    public final boolean c(String str, String str2) {
        boolean y10;
        int J10;
        int O10;
        boolean o10;
        boolean v10;
        y10 = StringsKt__StringsKt.y(str2, "*", false, 2, null);
        if (!y10) {
            return false;
        }
        if (!i.b(str2, "*")) {
            J10 = StringsKt__StringsKt.J(str2, "*", 0, false, 6, null);
            O10 = StringsKt__StringsKt.O(str2, "*", 0, false, 6, null);
            if (J10 == O10) {
                o10 = n.o(str2, "*", false, 2, null);
                if (o10) {
                    String substring = str2.substring(0, str2.length() - 1);
                    i.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    v10 = n.v(str, substring, false, 2, null);
                    return v10;
                }
            }
            throw new IllegalArgumentException("Name pattern with a wildcard must only contain a single wildcard in the end".toString());
        }
        return true;
    }
}
