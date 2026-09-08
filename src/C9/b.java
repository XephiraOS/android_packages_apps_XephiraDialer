package C9;

import java.util.List;
import java.util.Map;
import kotlin.reflect.KVisibility;

/* compiled from: KCallable.kt */
/* loaded from: classes4.dex */
public interface b<R> extends a {
    R call(Object... objArr);

    R callBy(Map<Object, ? extends Object> map);

    String getName();

    List<Object> getParameters();

    k getReturnType();

    List<Object> getTypeParameters();

    KVisibility getVisibility();

    boolean isAbstract();

    boolean isFinal();

    boolean isOpen();

    boolean isSuspend();
}
