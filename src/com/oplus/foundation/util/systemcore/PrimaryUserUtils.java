package com.oplus.foundation.util.systemcore;

import android.os.UserManager;
import kotlin.Result;
import kotlin.a;
import kotlin.b;
import m9.d;
import v9.InterfaceC1637a;

/* compiled from: PrimaryUserUtils.kt */
/* loaded from: classes3.dex */
public final class PrimaryUserUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final PrimaryUserUtils f28361a = new PrimaryUserUtils();

    /* renamed from: b, reason: collision with root package name */
    public static final d f28362b;

    static {
        d b10;
        b10 = a.b(new InterfaceC1637a<Boolean>() { // from class: com.oplus.foundation.util.systemcore.PrimaryUserUtils$isPrimaryUser$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                Boolean bool = null;
                try {
                    Result.a aVar = Result.f34166a;
                    Object systemService = P7.a.f2961a.a().getSystemService("user");
                    UserManager userManager = systemService instanceof UserManager ? (UserManager) systemService : null;
                    if (userManager != null) {
                        bool = Boolean.valueOf(userManager.isSystemUser());
                    }
                } catch (Throwable th) {
                    Result.a aVar2 = Result.f34166a;
                    Throwable d10 = Result.d(Result.b(b.a(th)));
                    if (d10 != null) {
                        StackTraceElement stackTraceElement = d10.getStackTrace()[0];
                        int lineNumber = stackTraceElement.getLineNumber();
                        String methodName = stackTraceElement.getMethodName();
                        H7.b.c(stackTraceElement.getClassName(), "line:" + lineNumber + " " + methodName + " " + d10.getMessage());
                    }
                }
                return Boolean.valueOf(bool != null ? bool.booleanValue() : true);
            }
        });
        f28362b = b10;
    }

    public static final boolean a() {
        return ((Boolean) f28362b.getValue()).booleanValue();
    }
}
