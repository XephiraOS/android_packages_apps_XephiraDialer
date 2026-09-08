package com.android.contacts.Engineer;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import kotlin.Result;
import kotlin.a;
import kotlin.b;
import kotlin.text.n;
import m9.d;
import m9.q;
import v9.InterfaceC1637a;

/* compiled from: NetworkEngineerModeUtil.kt */
/* loaded from: classes.dex */
public final class NetworkEngineerModeUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final NetworkEngineerModeUtil f13131a = new NetworkEngineerModeUtil();

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f13132b = {"", ""};

    /* renamed from: c, reason: collision with root package name */
    public static final d f13133c;

    static {
        d b10;
        b10 = a.b(new InterfaceC1637a<Boolean>() { // from class: com.android.contacts.Engineer.NetworkEngineerModeUtil$engineerNetworkSupport$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                Boolean bool;
                try {
                    Result.a aVar = Result.f34166a;
                    bool = Boolean.valueOf(P7.a.f2961a.a().getPackageManager().getApplicationInfo("com.oplus.engineernetwork", 128).metaData.getBoolean("network_engineer_mode", false));
                } catch (Throwable th) {
                    Result.a aVar2 = Result.f34166a;
                    Throwable d10 = Result.d(Result.b(b.a(th)));
                    if (d10 != null) {
                        StackTraceElement stackTraceElement = d10.getStackTrace()[0];
                        int lineNumber = stackTraceElement.getLineNumber();
                        String methodName = stackTraceElement.getMethodName();
                        H7.b.c(stackTraceElement.getClassName(), "line:" + lineNumber + " " + methodName + " " + d10.getMessage());
                    }
                    bool = null;
                }
                return Boolean.valueOf(bool != null ? bool.booleanValue() : false);
            }
        });
        f13133c = b10;
    }

    public final Intent a(String str, int i10) {
        Intent intent = new Intent();
        intent.putExtra("order", str);
        intent.putExtra("displayId", i10);
        return intent;
    }

    public final boolean b() {
        return ((Boolean) f13133c.getValue()).booleanValue();
    }

    public final void c(String str, int i10) {
        Object b10;
        boolean v10;
        boolean o10;
        try {
            Result.a aVar = Result.f34166a;
            if (str != null) {
                v10 = n.v(str, "*#", false, 2, null);
                if (v10) {
                    o10 = n.o(str, "#", false, 2, null);
                    if (o10 && str.length() > 3) {
                        if (TextUtils.equals(f13132b[i10], str)) {
                            if (H7.a.b()) {
                                H7.b.b("NetworkEngineerModeUtil", "EngineerModeMain number last equals");
                            }
                        } else {
                            H7.b.e("NetworkEngineerModeUtil", "EngineerModeMain number matched " + b());
                            if (b()) {
                                Context a10 = P7.a.f2961a.a();
                                Intent a11 = a(str, i10);
                                a11.setAction("com.oplus.engineernetwork.EngineerNetworkMain");
                                a11.setPackage("com.oplus.engineernetwork");
                                a10.sendBroadcast(a11);
                            }
                        }
                    }
                }
            }
            f13132b[i10] = str;
            b10 = Result.b(q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("NetworkEngineerModeUtil", "processInputNumIfNeed error : " + d10);
        }
    }
}
