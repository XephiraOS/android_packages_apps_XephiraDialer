package S9;

import java.io.InputStream;
import org.apache.james.mime4j.stream.EntityState;
import org.apache.james.mime4j.stream.RecursionMode;

/* compiled from: EntityStateMachine.java */
/* loaded from: classes4.dex */
public interface f {
    f a();

    i b();

    b c();

    InputStream d();

    void e(RecursionMode recursionMode);

    InputStream f();

    EntityState getState();
}
