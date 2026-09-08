package r6;

import android.content.Context;
import android.util.Log;
import b9.C0534d;

/* compiled from: CallTypeHelper.java */
/* loaded from: classes3.dex */
public class w {

    /* renamed from: a, reason: collision with root package name */
    public final int f36496a;

    public w(Context context) {
        this.f36496a = context.getColor(C0534d.f12363a);
    }

    public static boolean b(int i10) {
        if (i10 != 20 && i10 != 21 && i10 != 22 && i10 != 23 && i10 != 24 && i10 != 25 && i10 != 26 && i10 != 27 && i10 != 28 && i10 != 29 && i10 != 30 && i10 != 49 && i10 != 50 && i10 != 51 && i10 != 52 && i10 != 53 && i10 != 54 && i10 != 56) {
            return false;
        }
        return true;
    }

    public Integer a(int i10) {
        int abs;
        int abs2;
        if ((l7.b.o() && ((abs2 = Math.abs(i10)) == 28 || abs2 == 29 || abs2 == 30)) || (abs = Math.abs(i10)) == 1 || abs == 2) {
            return null;
        }
        if (abs != 3) {
            if (abs != 10 && abs != 56) {
                switch (abs) {
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                        break;
                    default:
                        switch (abs) {
                            case 50:
                            case 51:
                            case 52:
                            case 53:
                            case 54:
                                break;
                            default:
                                Log.w("CallTypeHelper", "invalid call type: " + i10);
                                break;
                        }
                }
            }
            return null;
        }
        return Integer.valueOf(this.f36496a);
    }
}
