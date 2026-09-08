package com.android.incallui.clean.domain.interactor;

import androidx.databinding.ObservableField;
import androidx.databinding.i;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.w;
import java.io.Closeable;
import v9.l;

/* compiled from: LocalObservableField.kt */
/* loaded from: classes.dex */
public class LocalObservableField<T> extends ObservableField<T> implements Closeable {
    private final w<Object> dependencyLiveDataCallback;
    private final a dependencyObservableCallback;
    private final LiveData<?>[] livedataDependencies;
    private T mValue;
    private final i[] observableDependencies;
    private final l<Boolean, T> onDependencyChanged;

    /* compiled from: LocalObservableField.kt */
    /* loaded from: classes.dex */
    public static final class a extends i.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LocalObservableField<T> f18358a;

        public a(LocalObservableField<T> localObservableField) {
            this.f18358a = localObservableField;
        }

        @Override // androidx.databinding.i.a
        public void d(i iVar, int i10) {
            this.f18358a.w0();
        }
    }

    public LocalObservableField() {
        this(null, null, null, null, 15, null);
    }

    public static final void v0(LocalObservableField this$0, Object obj) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.w0();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        for (LiveData<?> liveData : this.livedataDependencies) {
            liveData.n(this.dependencyLiveDataCallback);
        }
        for (i iVar : this.observableDependencies) {
            iVar.l0(this.dependencyObservableCallback);
        }
    }

    @Override // androidx.databinding.ObservableField
    public T s0() {
        return this.mValue;
    }

    public final void w0() {
        l<Boolean, T> lVar = this.onDependencyChanged;
        if (lVar != null) {
            x0(lVar.invoke(Boolean.FALSE));
        } else {
            q0();
        }
    }

    public void x0(T t10) {
        if (!kotlin.jvm.internal.i.b(t10, this.mValue)) {
            this.mValue = t10;
            q0();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LocalObservableField(T t10, LiveData<?>[] livedataDependencies, i[] observableDependencies, l<? super Boolean, ? extends T> lVar) {
        kotlin.jvm.internal.i.f(livedataDependencies, "livedataDependencies");
        kotlin.jvm.internal.i.f(observableDependencies, "observableDependencies");
        this.livedataDependencies = livedataDependencies;
        this.observableDependencies = observableDependencies;
        this.onDependencyChanged = lVar;
        this.mValue = t10;
        this.dependencyObservableCallback = new a(this);
        this.dependencyLiveDataCallback = new w() { // from class: com.android.incallui.clean.domain.interactor.a
            @Override // androidx.lifecycle.w
            public final void onChanged(Object obj) {
                LocalObservableField.v0(LocalObservableField.this, obj);
            }
        };
        for (i iVar : observableDependencies) {
            iVar.f(this.dependencyObservableCallback);
        }
        for (LiveData<?> liveData : this.livedataDependencies) {
            liveData.j(this.dependencyLiveDataCallback);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LocalObservableField(i[] dependencies, l<? super Boolean, ? extends T> onDependencyChanged) {
        this(onDependencyChanged.invoke(Boolean.TRUE), null, dependencies, onDependencyChanged, 2, null);
        kotlin.jvm.internal.i.f(dependencies, "dependencies");
        kotlin.jvm.internal.i.f(onDependencyChanged, "onDependencyChanged");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LocalObservableField(LiveData<?>[] dependencies, l<? super Boolean, ? extends T> onDependencyChanged) {
        this(onDependencyChanged.invoke(Boolean.TRUE), dependencies, null, onDependencyChanged, 4, null);
        kotlin.jvm.internal.i.f(dependencies, "dependencies");
        kotlin.jvm.internal.i.f(onDependencyChanged, "onDependencyChanged");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LocalObservableField(LiveData<?>[] livedataDependencies, i[] observableDependencies, l<? super Boolean, ? extends T> onDependencyChanged) {
        this(onDependencyChanged.invoke(Boolean.TRUE), livedataDependencies, observableDependencies, onDependencyChanged);
        kotlin.jvm.internal.i.f(livedataDependencies, "livedataDependencies");
        kotlin.jvm.internal.i.f(observableDependencies, "observableDependencies");
        kotlin.jvm.internal.i.f(onDependencyChanged, "onDependencyChanged");
    }

    public /* synthetic */ LocalObservableField(Object obj, LiveData[] liveDataArr, i[] iVarArr, l lVar, int i10, kotlin.jvm.internal.f fVar) {
        this((i10 & 1) != 0 ? null : obj, (i10 & 2) != 0 ? new LiveData[0] : liveDataArr, (i10 & 4) != 0 ? new i[0] : iVarArr, (i10 & 8) != 0 ? null : lVar);
    }
}
