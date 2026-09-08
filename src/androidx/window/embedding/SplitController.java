package androidx.window.embedding;

import androidx.window.core.ExperimentalWindowApi;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.collections.K;
import kotlin.jvm.internal.f;

/* compiled from: SplitController.kt */
@ExperimentalWindowApi
/* loaded from: classes.dex */
public final class SplitController {

    /* renamed from: c, reason: collision with root package name */
    public static final Companion f11959c = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    public static final ReentrantLock f11960d = new ReentrantLock();

    /* renamed from: a, reason: collision with root package name */
    public final EmbeddingBackend f11961a = ExtensionEmbeddingBackend.f11945e.a();

    /* renamed from: b, reason: collision with root package name */
    public Set<? extends EmbeddingRule> f11962b;

    /* compiled from: SplitController.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    private SplitController() {
        Set<? extends EmbeddingRule> b10;
        b10 = K.b();
        this.f11962b = b10;
    }
}
