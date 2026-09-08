package A9;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.jvm.internal.i;

/* compiled from: PlatformThreadLocalRandom.kt */
/* loaded from: classes4.dex */
public final class a extends z9.a {
    @Override // z9.a
    public Random d() {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        i.e(current, "current(...)");
        return current;
    }
}
