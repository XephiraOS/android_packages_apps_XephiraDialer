package com.oplus.utils;

import android.content.Context;
import android.util.Log;
import v6.C1629c;

/* compiled from: NationalAntiFraudUtil.kt */
/* loaded from: classes3.dex */
public final class D {

    /* renamed from: a, reason: collision with root package name */
    public static final D f29040a = new D();

    public static final boolean a(Context context) {
        Boolean bool;
        kotlin.jvm.internal.i.f(context, "context");
        try {
            boolean z10 = true;
            if (z6.b.d(context, 0, "national_anti_fraud_service_enabled", 0, 1) != 1) {
                z10 = false;
            }
            bool = Boolean.valueOf(z10);
        } catch (Throwable th) {
            StackTraceElement stackTraceElement = th.getStackTrace()[0];
            int lineNumber = stackTraceElement.getLineNumber();
            String methodName = stackTraceElement.getMethodName();
            Log.e(stackTraceElement.getClassName(), "line:" + lineNumber + " " + methodName + " " + th.getMessage());
            bool = null;
        }
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static final void b(Context context, int i10) {
        kotlin.jvm.internal.i.f(context, "context");
        try {
            z6.b.j(context, 0, "national_anti_fraud_service_enabled", i10, 1);
        } catch (Throwable th) {
            StackTraceElement stackTraceElement = th.getStackTrace()[0];
            int lineNumber = stackTraceElement.getLineNumber();
            String methodName = stackTraceElement.getMethodName();
            Log.e(stackTraceElement.getClassName(), "line:" + lineNumber + " " + methodName + " " + th.getMessage());
        }
    }

    public static final boolean c(Context context) {
        if (!l7.b.f34735c) {
            return false;
        }
        boolean c10 = C0844e.c(context, "com.android.phone", "anti_fraud_support");
        boolean c11 = C0844e.c(context, C1629c.f37419e, "anti_fraud_support");
        boolean c12 = C0844e.c(context, "com.ted.number", "anti_fraud_support");
        if (C0846g.c()) {
            Log.d("NationalAntiFraudUtil", "phoneSupport=" + c10 + " incallUiSupport=" + c11 + " numberRecognitionSupport=" + c12);
        }
        if (!c10 || !c11 || !c12) {
            return false;
        }
        return true;
    }

    public static final boolean d(Context context) {
        if (!l7.b.f34735c) {
            return false;
        }
        boolean c10 = C0844e.c(context, "com.android.mms", "anti_fraud_support");
        boolean c11 = C0844e.c(context, "com.ted.number", "anti_fraud_support");
        if (C0846g.c()) {
            Log.d("NationalAntiFraudUtil", "mmsSupport=" + c10 + " numberRecognitionSupport=" + c11);
        }
        if (!c10 || !c11) {
            return false;
        }
        return true;
    }
}
