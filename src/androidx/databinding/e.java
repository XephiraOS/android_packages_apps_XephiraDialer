package androidx.databinding;

import android.view.View;
import java.util.Collections;
import java.util.List;

/* compiled from: DataBinderMapper.java */
/* loaded from: classes.dex */
public abstract class e {
    public List<e> collectDependencies() {
        return Collections.emptyList();
    }

    public abstract String convertBrIdToString(int i10);

    public abstract ViewDataBinding getDataBinder(f fVar, View view, int i10);

    public abstract ViewDataBinding getDataBinder(f fVar, View[] viewArr, int i10);

    public abstract int getLayoutId(String str);
}
