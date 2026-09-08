package p9;

import java.lang.reflect.Field;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.jvm.internal.i;

/* compiled from: DebugMetadata.kt */
/* renamed from: p9.e, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1471e {
    public static final void a(int i10, int i11) {
        if (i11 <= i10) {
            return;
        }
        throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + i10 + ", got " + i11 + ". Please update the Kotlin standard library.").toString());
    }

    public static final InterfaceC1470d b(BaseContinuationImpl baseContinuationImpl) {
        return (InterfaceC1470d) baseContinuationImpl.getClass().getAnnotation(InterfaceC1470d.class);
    }

    public static final int c(BaseContinuationImpl baseContinuationImpl) {
        Integer num;
        int i10;
        try {
            Field declaredField = baseContinuationImpl.getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(baseContinuationImpl);
            if (obj instanceof Integer) {
                num = (Integer) obj;
            } else {
                num = null;
            }
            if (num != null) {
                i10 = num.intValue();
            } else {
                i10 = 0;
            }
            return i10 - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static final StackTraceElement d(BaseContinuationImpl baseContinuationImpl) {
        int i10;
        String str;
        i.f(baseContinuationImpl, "<this>");
        InterfaceC1470d b10 = b(baseContinuationImpl);
        if (b10 == null) {
            return null;
        }
        a(1, b10.v());
        int c10 = c(baseContinuationImpl);
        if (c10 < 0) {
            i10 = -1;
        } else {
            i10 = b10.l()[c10];
        }
        String b11 = C1473g.f36110a.b(baseContinuationImpl);
        if (b11 == null) {
            str = b10.c();
        } else {
            str = b11 + '/' + b10.c();
        }
        return new StackTraceElement(str, b10.m(), b10.f(), i10);
    }
}
