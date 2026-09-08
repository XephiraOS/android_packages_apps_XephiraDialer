package com.android.contacts.framework.baseui.calllog;

import android.text.TextUtils;
import com.android.incallui.OplusPhoneCapabilities;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: CallLogItemInfo.kt */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final a f15784a = new a(null);

    /* compiled from: CallLogItemInfo.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public final String a(String str, String str2, String str3) {
            int i10;
            boolean z10;
            if (str != null && str3 != null) {
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                if (!TextUtils.isEmpty(str3)) {
                    int length = str3.length() - 1;
                    int i11 = 0;
                    boolean z11 = false;
                    while (i11 <= length) {
                        if (!z11) {
                            i10 = i11;
                        } else {
                            i10 = length;
                        }
                        if (i.g(str3.charAt(i10), 32) <= 0) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        if (!z11) {
                            if (!z10) {
                                z11 = true;
                            } else {
                                i11++;
                            }
                        } else {
                            if (!z10) {
                                break;
                            }
                            length--;
                        }
                    }
                    if (!TextUtils.isEmpty(str3.subSequence(i11, length + 1).toString())) {
                        return str + "//" + str3;
                    }
                }
                return str + "//";
            }
            return "";
        }

        public final boolean b(int i10, String str) {
            boolean z10;
            if ((i10 & OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE) == 268435456 && !TextUtils.isEmpty(str)) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (H7.a.b()) {
                H7.b.b("CallLogItemInfo", "hasCallSummary: " + str + ", " + i10 + ", " + z10);
            }
            return z10;
        }

        public final boolean c(int i10, String str) {
            if ((i10 & OplusPhoneCapabilities.MTK_CAPABILITY_VIDEO_RINGTONE) == 536870912 && !TextUtils.isEmpty(str)) {
                return true;
            }
            return false;
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public static final String a(String str, String str2, String str3) {
        return f15784a.a(str, str2, str3);
    }

    public static final boolean b(int i10, String str) {
        return f15784a.b(i10, str);
    }

    public static final boolean c(int i10, String str) {
        return f15784a.c(i10, str);
    }
}
