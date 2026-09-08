package z9;

import kotlin.random.Random;

/* compiled from: PlatformRandom.kt */
/* loaded from: classes4.dex */
public abstract class a extends Random {
    @Override // kotlin.random.Random
    public int b() {
        return d().nextInt();
    }

    @Override // kotlin.random.Random
    public int c(int i10) {
        return d().nextInt(i10);
    }

    public abstract java.util.Random d();
}
