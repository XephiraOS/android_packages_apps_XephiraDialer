package com.coui.component.responsiveui;

import android.util.Log;
import kotlin.jvm.internal.i;
import kotlin.text.StringsKt__IndentKt;

/* compiled from: ResponsiveUILog.kt */
/* loaded from: classes3.dex */
public final class ResponsiveUILog {
    public static final ResponsiveUILog INSTANCE = new ResponsiveUILog();

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f19990a;

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f19991b;

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f19992c;

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f19993d;

    /* renamed from: e, reason: collision with root package name */
    public static final boolean f19994e;

    /* renamed from: f, reason: collision with root package name */
    public static final boolean f19995f;

    /* renamed from: g, reason: collision with root package name */
    public static final boolean f19996g;

    static {
        boolean z10;
        boolean isLoggable = Log.isLoggable("COUI", 2);
        f19990a = isLoggable;
        boolean isLoggable2 = Log.isLoggable("COUI", 3);
        f19991b = isLoggable2;
        boolean isLoggable3 = Log.isLoggable("COUI", 4);
        f19992c = isLoggable3;
        boolean isLoggable4 = Log.isLoggable("COUI", 5);
        f19993d = isLoggable4;
        boolean isLoggable5 = Log.isLoggable("COUI", 6);
        f19994e = isLoggable5;
        boolean isLoggable6 = Log.isLoggable("COUI", 7);
        f19995f = isLoggable6;
        if (!isLoggable && !isLoggable2 && !isLoggable3 && !isLoggable4 && !isLoggable5 && !isLoggable6) {
            z10 = true;
        } else {
            z10 = false;
        }
        f19996g = z10;
    }

    public final boolean getLOG_ASSERT() {
        return f19995f;
    }

    public final boolean getLOG_DEBUG() {
        return f19991b;
    }

    public final boolean getLOG_ERROR() {
        return f19994e;
    }

    public final boolean getLOG_INFO() {
        return f19992c;
    }

    public final boolean getLOG_SILENT() {
        return f19996g;
    }

    public final boolean getLOG_VERBOSE() {
        return f19990a;
    }

    public final boolean getLOG_WARN() {
        return f19993d;
    }

    public final boolean isLoggable(String str, int i10) {
        return Log.isLoggable(str, i10);
    }

    public final void logStatus(String tag) {
        String e10;
        i.f(tag, "tag");
        boolean isLoggable = i.b(tag, "COUI") ? f19990a : Log.isLoggable(tag, 2);
        boolean isLoggable2 = i.b(tag, "COUI") ? f19991b : Log.isLoggable(tag, 3);
        boolean isLoggable3 = i.b(tag, "COUI") ? f19992c : Log.isLoggable(tag, 2);
        boolean isLoggable4 = i.b(tag, "COUI") ? f19993d : Log.isLoggable(tag, 2);
        boolean isLoggable5 = i.b(tag, "COUI") ? f19994e : Log.isLoggable(tag, 2);
        boolean isLoggable6 = i.b(tag, "COUI") ? f19995f : Log.isLoggable(tag, 2);
        e10 = StringsKt__IndentKt.e("\n            Log status for tag: " + tag + "\n            VERBOSE: " + isLoggable + "\n            DEBUG: " + isLoggable2 + "\n            INFO: " + isLoggable3 + "\n            WARN: " + isLoggable4 + "\n            ERROR: " + isLoggable5 + "\n            ASSERT: " + isLoggable6 + "\n            SILENT: " + (i.b(tag, "COUI") ? f19996g : (isLoggable || isLoggable2 || isLoggable3 || isLoggable4 || isLoggable5 || isLoggable6) ? false : true) + "\n            ");
        Log.println(7, "COUI", e10);
    }

    public final void logStatus() {
        logStatus("COUI");
    }
}
