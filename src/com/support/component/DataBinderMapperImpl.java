package com.support.component;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes4.dex */
public class DataBinderMapperImpl extends e {

    /* renamed from: a, reason: collision with root package name */
    public static final SparseIntArray f29550a = new SparseIntArray(0);

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final SparseArray<String> f29551a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(1);
            f29551a = sparseArray;
            sparseArray.put(0, "_all");
        }
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static final HashMap<String, Integer> f29552a = new HashMap<>(0);
    }

    @Override // androidx.databinding.e
    public List<e> collectDependencies() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        return arrayList;
    }

    @Override // androidx.databinding.e
    public String convertBrIdToString(int i10) {
        return a.f29551a.get(i10);
    }

    @Override // androidx.databinding.e
    public ViewDataBinding getDataBinder(f fVar, View view, int i10) {
        if (f29550a.get(i10) <= 0 || view.getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    @Override // androidx.databinding.e
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = b.f29552a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.e
    public ViewDataBinding getDataBinder(f fVar, View[] viewArr, int i10) {
        if (viewArr == null || viewArr.length == 0 || f29550a.get(i10) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
