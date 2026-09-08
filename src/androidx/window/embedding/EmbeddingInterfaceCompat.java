package androidx.window.embedding;

import androidx.window.core.ExperimentalWindowApi;
import java.util.List;

/* compiled from: EmbeddingInterfaceCompat.kt */
@ExperimentalWindowApi
/* loaded from: classes.dex */
public interface EmbeddingInterfaceCompat {

    /* compiled from: EmbeddingInterfaceCompat.kt */
    /* loaded from: classes.dex */
    public interface EmbeddingCallbackInterface {
        void a(List<SplitInfo> list);
    }

    void a(EmbeddingCallbackInterface embeddingCallbackInterface);
}
