package Z1;

import androidx.lifecycle.I;
import androidx.lifecycle.K;
import com.android.incallui.foldscreen.presentation.viewmodel.FoldScreenBaseViewModel;
import kotlin.jvm.internal.i;

/* compiled from: FoldScreenViewModelFactory.kt */
/* loaded from: classes.dex */
public final class d extends K.c {

    /* renamed from: e, reason: collision with root package name */
    public final Y1.a f5864e;

    public d(Y1.a useCaseProvider) {
        i.f(useCaseProvider, "useCaseProvider");
        this.f5864e = useCaseProvider;
    }

    @Override // androidx.lifecycle.K.c, androidx.lifecycle.K.b
    public <T extends I> T a(Class<T> modelClass) {
        i.f(modelClass, "modelClass");
        if (FoldScreenBaseViewModel.class.isAssignableFrom(modelClass)) {
            T newInstance = modelClass.getConstructor(Y1.a.class).newInstance(this.f5864e);
            i.e(newInstance, "{\n            modelClass…seCaseProvider)\n        }");
            return newInstance;
        }
        return (T) super.a(modelClass);
    }
}
