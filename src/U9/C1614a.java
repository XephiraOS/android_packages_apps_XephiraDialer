package u9;

import C9.c;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.k;

/* compiled from: JvmClassMapping.kt */
/* renamed from: u9.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1614a {
    public static final <T> Class<T> a(c<T> cVar) {
        i.f(cVar, "<this>");
        Class<T> cls = (Class<T>) ((kotlin.jvm.internal.c) cVar).d();
        i.d(cls, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        return cls;
    }

    public static final <T> Class<T> b(c<T> cVar) {
        i.f(cVar, "<this>");
        Class<T> cls = (Class<T>) ((kotlin.jvm.internal.c) cVar).d();
        if (!cls.isPrimitive()) {
            i.d(cls, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
            return cls;
        }
        String name = cls.getName();
        switch (name.hashCode()) {
            case -1325958191:
                if (name.equals("double")) {
                    cls = (Class<T>) Double.class;
                    break;
                }
                break;
            case 104431:
                if (name.equals("int")) {
                    cls = (Class<T>) Integer.class;
                    break;
                }
                break;
            case 3039496:
                if (name.equals("byte")) {
                    cls = (Class<T>) Byte.class;
                    break;
                }
                break;
            case 3052374:
                if (name.equals("char")) {
                    cls = (Class<T>) Character.class;
                    break;
                }
                break;
            case 3327612:
                if (name.equals("long")) {
                    cls = (Class<T>) Long.class;
                    break;
                }
                break;
            case 3625364:
                if (name.equals("void")) {
                    cls = (Class<T>) Void.class;
                    break;
                }
                break;
            case 64711720:
                if (name.equals("boolean")) {
                    cls = (Class<T>) Boolean.class;
                    break;
                }
                break;
            case 97526364:
                if (name.equals("float")) {
                    cls = (Class<T>) Float.class;
                    break;
                }
                break;
            case 109413500:
                if (name.equals("short")) {
                    cls = (Class<T>) Short.class;
                    break;
                }
                break;
        }
        i.d(cls, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
        return cls;
    }

    public static final <T> c<T> c(Class<T> cls) {
        i.f(cls, "<this>");
        return k.b(cls);
    }
}
