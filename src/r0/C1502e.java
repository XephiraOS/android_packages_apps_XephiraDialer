package r0;

import android.content.Context;
import kotlin.Result;
import m9.q;

/* compiled from: RingToneListHelper.kt */
/* renamed from: r0.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1502e {

    /* renamed from: a, reason: collision with root package name */
    public static final C1502e f36277a = new C1502e();

    public static final String[] b(Context context) {
        kotlin.jvm.internal.i.f(context, "context");
        return f36277a.a(context, "aquatic_ringtone_natural_vitality");
    }

    public static final String[] c(Context context) {
        kotlin.jvm.internal.i.f(context, "context");
        return f36277a.a(context, "aquatic_ringtone_peace_voice");
    }

    public static final String[] d(Context context) {
        kotlin.jvm.internal.i.f(context, "context");
        return f36277a.h(context, "oppo_select_ringtone_new", "brand_select_ringtone_names");
    }

    public static final String[] e(Context context) {
        kotlin.jvm.internal.i.f(context, "context");
        return f36277a.a(context, "aquatic_ringtone_natural_vitality_files");
    }

    public static final String[] f(Context context) {
        kotlin.jvm.internal.i.f(context, "context");
        return f36277a.a(context, "aquatic_ringtone_peace_voice_files");
    }

    public static final String[] g(Context context) {
        kotlin.jvm.internal.i.f(context, "context");
        return f36277a.h(context, "oppo_select_ringtone_old", "brand_select_ringtone_files");
    }

    public final String[] a(Context context, String str) {
        try {
            Result.a aVar = Result.f34166a;
            return context.getResources().getStringArray(context.getResources().getIdentifier(str, "array", "oplus"));
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            Throwable d10 = Result.d(Result.b(kotlin.b.a(th)));
            if (d10 != null) {
                StackTraceElement stackTraceElement = d10.getStackTrace()[0];
                int lineNumber = stackTraceElement.getLineNumber();
                String methodName = stackTraceElement.getMethodName();
                H7.b.c(stackTraceElement.getClassName(), "line:" + lineNumber + " " + methodName + " " + d10.getMessage());
            }
            return null;
        }
    }

    public final String[] h(Context context, String str, String str2) {
        Object b10;
        Object b11;
        Object b12;
        String[] strArr = null;
        try {
            Result.a aVar = Result.f34166a;
            strArr = context.getResources().getStringArray(context.getResources().getIdentifier(str2, "array", "oplus"));
            b10 = Result.b(q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        if (Result.d(b10) != null) {
            try {
                strArr = context.getResources().getStringArray(context.getResources().getIdentifier(str, "array", "oplus"));
                b11 = Result.b(q.f35511a);
            } catch (Throwable th2) {
                Result.a aVar3 = Result.f34166a;
                b11 = Result.b(kotlin.b.a(th2));
            }
            if (Result.d(b11) != null) {
                try {
                    strArr = context.getResources().getStringArray(context.getResources().getIdentifier(str, "array", "oppo"));
                    b12 = Result.b(q.f35511a);
                } catch (Throwable th3) {
                    Result.a aVar4 = Result.f34166a;
                    b12 = Result.b(kotlin.b.a(th3));
                }
                if (Result.d(b12) != null) {
                    H7.b.c("RingToneListHelper", "getRingToneResources null");
                }
            }
        }
        return strArr;
    }
}
