package androidx.window.embedding;

import android.app.Activity;
import android.util.Log;
import androidx.window.core.ConsumerAdapter;
import androidx.window.core.ExperimentalWindowApi;
import androidx.window.core.PredicateAdapter;
import androidx.window.embedding.EmbeddingCompat;
import androidx.window.embedding.EmbeddingInterfaceCompat;
import androidx.window.embedding.ExtensionEmbeddingBackend;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import m9.q;

/* compiled from: ExtensionEmbeddingBackend.kt */
@ExperimentalWindowApi
/* loaded from: classes.dex */
public final class ExtensionEmbeddingBackend implements EmbeddingBackend {

    /* renamed from: f, reason: collision with root package name */
    public static volatile ExtensionEmbeddingBackend f11946f;

    /* renamed from: a, reason: collision with root package name */
    public EmbeddingInterfaceCompat f11948a;

    /* renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<SplitListenerWrapper> f11949b;

    /* renamed from: c, reason: collision with root package name */
    public final EmbeddingCallbackImpl f11950c;

    /* renamed from: d, reason: collision with root package name */
    public final CopyOnWriteArraySet<EmbeddingRule> f11951d;

    /* renamed from: e, reason: collision with root package name */
    public static final Companion f11945e = new Companion(null);

    /* renamed from: g, reason: collision with root package name */
    public static final ReentrantLock f11947g = new ReentrantLock();

    /* compiled from: ExtensionEmbeddingBackend.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public final ExtensionEmbeddingBackend a() {
            if (ExtensionEmbeddingBackend.f11946f == null) {
                ReentrantLock reentrantLock = ExtensionEmbeddingBackend.f11947g;
                reentrantLock.lock();
                try {
                    if (ExtensionEmbeddingBackend.f11946f == null) {
                        ExtensionEmbeddingBackend.f11946f = new ExtensionEmbeddingBackend(ExtensionEmbeddingBackend.f11945e.b());
                    }
                    q qVar = q.f35511a;
                    reentrantLock.unlock();
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    throw th;
                }
            }
            ExtensionEmbeddingBackend extensionEmbeddingBackend = ExtensionEmbeddingBackend.f11946f;
            i.c(extensionEmbeddingBackend);
            return extensionEmbeddingBackend;
        }

        public final EmbeddingInterfaceCompat b() {
            ClassLoader classLoader;
            EmbeddingCompat embeddingCompat = null;
            try {
                EmbeddingCompat.Companion companion = EmbeddingCompat.f11941d;
                if (c(companion.f()) && companion.g() && (classLoader = EmbeddingBackend.class.getClassLoader()) != null) {
                    embeddingCompat = new EmbeddingCompat(companion.c(), new EmbeddingAdapter(new PredicateAdapter(classLoader)), new ConsumerAdapter(classLoader));
                }
            } catch (Throwable th) {
                Log.d("EmbeddingBackend", "Failed to load embedding extension: " + th);
            }
            if (embeddingCompat == null) {
                Log.d("EmbeddingBackend", "No supported embedding extension found");
            }
            return embeddingCompat;
        }

        public final boolean c(Integer num) {
            if (num == null || num.intValue() < 1) {
                return false;
            }
            return true;
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    /* compiled from: ExtensionEmbeddingBackend.kt */
    /* loaded from: classes.dex */
    public final class EmbeddingCallbackImpl implements EmbeddingInterfaceCompat.EmbeddingCallbackInterface {

        /* renamed from: a, reason: collision with root package name */
        public List<SplitInfo> f11952a;

        public EmbeddingCallbackImpl() {
        }

        @Override // androidx.window.embedding.EmbeddingInterfaceCompat.EmbeddingCallbackInterface
        public void a(List<SplitInfo> splitInfo) {
            i.f(splitInfo, "splitInfo");
            this.f11952a = splitInfo;
            Iterator<SplitListenerWrapper> it = ExtensionEmbeddingBackend.this.d().iterator();
            while (it.hasNext()) {
                it.next().b(splitInfo);
            }
        }
    }

    /* compiled from: ExtensionEmbeddingBackend.kt */
    /* loaded from: classes.dex */
    public static final class SplitListenerWrapper {

        /* renamed from: a, reason: collision with root package name */
        public final Activity f11954a;

        /* renamed from: b, reason: collision with root package name */
        public final Executor f11955b;

        /* renamed from: c, reason: collision with root package name */
        public final I.a<List<SplitInfo>> f11956c;

        /* renamed from: d, reason: collision with root package name */
        public List<SplitInfo> f11957d;

        public static final void c(SplitListenerWrapper this$0, List splitsWithActivity) {
            i.f(this$0, "this$0");
            i.f(splitsWithActivity, "$splitsWithActivity");
            this$0.f11956c.accept(splitsWithActivity);
        }

        public final void b(List<SplitInfo> splitInfoList) {
            i.f(splitInfoList, "splitInfoList");
            final ArrayList arrayList = new ArrayList();
            for (Object obj : splitInfoList) {
                if (((SplitInfo) obj).a(this.f11954a)) {
                    arrayList.add(obj);
                }
            }
            if (i.b(arrayList, this.f11957d)) {
                return;
            }
            this.f11957d = arrayList;
            this.f11955b.execute(new Runnable() { // from class: androidx.window.embedding.c
                @Override // java.lang.Runnable
                public final void run() {
                    ExtensionEmbeddingBackend.SplitListenerWrapper.c(ExtensionEmbeddingBackend.SplitListenerWrapper.this, arrayList);
                }
            });
        }
    }

    public ExtensionEmbeddingBackend(EmbeddingInterfaceCompat embeddingInterfaceCompat) {
        this.f11948a = embeddingInterfaceCompat;
        EmbeddingCallbackImpl embeddingCallbackImpl = new EmbeddingCallbackImpl();
        this.f11950c = embeddingCallbackImpl;
        this.f11949b = new CopyOnWriteArrayList<>();
        EmbeddingInterfaceCompat embeddingInterfaceCompat2 = this.f11948a;
        if (embeddingInterfaceCompat2 != null) {
            embeddingInterfaceCompat2.a(embeddingCallbackImpl);
        }
        this.f11951d = new CopyOnWriteArraySet<>();
    }

    public final CopyOnWriteArrayList<SplitListenerWrapper> d() {
        return this.f11949b;
    }
}
