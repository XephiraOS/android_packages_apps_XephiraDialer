package com.android.incallui.clean.domain.interactor;

import androidx.databinding.i;
import androidx.lifecycle.LiveData;
import v9.l;

/* compiled from: LocalObservableField.kt */
/* loaded from: classes.dex */
public final class NonNullObservableField<T> extends LocalObservableField<T> {
    private final T defaultValue;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NonNullObservableField(T defaultValue, LiveData<?>[] livedataDependencies, i[] observableDependencies, l<? super Boolean, ? extends T> lVar) {
        super(defaultValue, livedataDependencies, observableDependencies, lVar);
        kotlin.jvm.internal.i.f(defaultValue, "defaultValue");
        kotlin.jvm.internal.i.f(livedataDependencies, "livedataDependencies");
        kotlin.jvm.internal.i.f(observableDependencies, "observableDependencies");
        this.defaultValue = defaultValue;
    }

    @Override // com.android.incallui.clean.domain.interactor.LocalObservableField, androidx.databinding.ObservableField
    public T s0() {
        T t10 = (T) super.s0();
        if (t10 == null) {
            return this.defaultValue;
        }
        return t10;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NonNullObservableField(i[] dependencies, l<? super Boolean, ? extends T> onDependencyChanged) {
        this(onDependencyChanged.invoke(Boolean.TRUE), null, dependencies, onDependencyChanged, 2, null);
        kotlin.jvm.internal.i.f(dependencies, "dependencies");
        kotlin.jvm.internal.i.f(onDependencyChanged, "onDependencyChanged");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NonNullObservableField(LiveData<?>[] dependencies, l<? super Boolean, ? extends T> onDependencyChanged) {
        this(onDependencyChanged.invoke(Boolean.TRUE), dependencies, null, onDependencyChanged, 4, null);
        kotlin.jvm.internal.i.f(dependencies, "dependencies");
        kotlin.jvm.internal.i.f(onDependencyChanged, "onDependencyChanged");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NonNullObservableField(LiveData<?>[] livedataDependencies, i[] observableDependencies, l<? super Boolean, ? extends T> onDependencyChanged) {
        this(onDependencyChanged.invoke(Boolean.TRUE), livedataDependencies, observableDependencies, onDependencyChanged);
        kotlin.jvm.internal.i.f(livedataDependencies, "livedataDependencies");
        kotlin.jvm.internal.i.f(observableDependencies, "observableDependencies");
        kotlin.jvm.internal.i.f(onDependencyChanged, "onDependencyChanged");
    }

    public /* synthetic */ NonNullObservableField(Object obj, LiveData[] liveDataArr, i[] iVarArr, l lVar, int i10, kotlin.jvm.internal.f fVar) {
        this(obj, (i10 & 2) != 0 ? new LiveData[0] : liveDataArr, (i10 & 4) != 0 ? new i[0] : iVarArr, (i10 & 8) != 0 ? null : lVar);
    }
}
