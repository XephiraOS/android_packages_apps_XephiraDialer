package com.android.contacts.business.calllog;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public class DataBinderMapperImpl extends androidx.databinding.e {

    /* renamed from: a, reason: collision with root package name */
    public static final SparseIntArray f13691a = new SparseIntArray(0);

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final SparseArray<String> f13692a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(1);
            f13692a = sparseArray;
            sparseArray.put(0, "_all");
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static final HashMap<String, Integer> f13693a = new HashMap<>(0);
    }

    @Override // androidx.databinding.e
    public List<androidx.databinding.e> collectDependencies() {
        ArrayList arrayList = new ArrayList(5);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.android.contacts.framework.api.DataBinderMapperImpl());
        arrayList.add(new com.android.contacts.framework.baseui.DataBinderMapperImpl());
        arrayList.add(new com.android.contacts.framework.virtualsupport.DataBinderMapperImpl());
        arrayList.add(new com.oplus.foundation.libutil.DataBinderMapperImpl());
        return arrayList;
    }

    @Override // androidx.databinding.e
    public String convertBrIdToString(int i10) {
        return a.f13692a.get(i10);
    }

    @Override // androidx.databinding.e
    public ViewDataBinding getDataBinder(androidx.databinding.f fVar, View view, int i10) {
        if (f13691a.get(i10) <= 0 || view.getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    @Override // androidx.databinding.e
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = b.f13693a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.e
    public ViewDataBinding getDataBinder(androidx.databinding.f fVar, View[] viewArr, int i10) {
        if (viewArr == null || viewArr.length == 0 || f13691a.get(i10) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
