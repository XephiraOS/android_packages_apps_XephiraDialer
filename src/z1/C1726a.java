package z1;

import android.content.Context;
import android.telecom.PhoneAccountHandle;
import android.text.TextUtils;

/* compiled from: CvvmProtocol.java */
/* renamed from: z1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1726a extends AbstractC1729d {

    /* renamed from: a, reason: collision with root package name */
    public static String f38265a = "CHANGE_TUI_PWD PWD=%1$s OLD_PWD=%2$s";

    /* renamed from: b, reason: collision with root package name */
    public static String f38266b = "CHANGE_VM_LANG Lang=%1$s";

    /* renamed from: c, reason: collision with root package name */
    public static String f38267c = "CLOSE_NUT";

    @Override // z1.AbstractC1729d
    public A1.c a(Context context, PhoneAccountHandle phoneAccountHandle, short s10, String str) {
        return new A1.b(context, phoneAccountHandle, s10, str);
    }

    @Override // z1.AbstractC1729d
    public String b(String str) {
        if (TextUtils.equals(str, "XCHANGE_TUI_PWD PWD=%1$s OLD_PWD=%2$s")) {
            return f38265a;
        }
        if (TextUtils.equals(str, "XCLOSE_NUT")) {
            return f38267c;
        }
        if (TextUtils.equals(str, "XCHANGE_VM_LANG LANG=%1$s")) {
            return f38266b;
        }
        return super.b(str);
    }
}
