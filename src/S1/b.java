package S1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: CallInfoType.kt */
@Target({ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface b {

    /* renamed from: a, reason: collision with root package name */
    public static final a f3376a = a.f3377a;

    /* compiled from: CallInfoType.kt */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f3377a = new a();

        public final String a(int i10) {
            switch (i10) {
                case 0:
                    return "CONTACT";
                case 1:
                    return "SERVICE";
                case 2:
                    return "MARK";
                case 3:
                    return "FRAUD";
                case 4:
                    return "STRANGE";
                case 5:
                    return "CONFERENCE";
                case 6:
                    return "EMERGENCY";
                case 7:
                    return "FDN";
                case 8:
                    return "CORNET";
                default:
                    return "";
            }
        }
    }
}
