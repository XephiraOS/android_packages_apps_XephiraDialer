package z9;

import java.util.Random;
import kotlin.jvm.internal.i;

/* compiled from: PlatformRandom.kt */
/* loaded from: classes4.dex */
public final class b extends z9.a {

    /* renamed from: c, reason: collision with root package name */
    public final a f38386c = new a();

    /* compiled from: PlatformRandom.kt */
    /* loaded from: classes4.dex */
    public static final class a extends ThreadLocal<Random> {
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Random initialValue() {
            return new Random();
        }
    }

    @Override // z9.a
    public Random d() {
        Random random = this.f38386c.get();
        i.e(random, "get(...)");
        return random;
    }
}
