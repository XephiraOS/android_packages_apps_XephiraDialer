package com.oplus.contacts.googlecontacts;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
public class DataBinderMapperImpl extends e {

    /* renamed from: a, reason: collision with root package name */
    public static final SparseIntArray f27810a = new SparseIntArray(0);

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final SparseArray<String> f27811a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(1);
            f27811a = sparseArray;
            sparseArray.put(0, "_all");
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static final HashMap<String, Integer> f27812a = new HashMap<>(0);
    }

    @Override // androidx.databinding.e
    public List<e> collectDependencies() {
        ArrayList arrayList = new ArrayList(6);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.android.contacts.framework.accountmanager.DataBinderMapperImpl());
        arrayList.add(new com.android.contacts.framework.api.DataBinderMapperImpl());
        arrayList.add(new com.android.contacts.framework.baseui.DataBinderMapperImpl());
        arrayList.add(new com.android.contacts.resource.DataBinderMapperImpl());
        arrayList.add(new com.oplus.foundation.libutil.DataBinderMapperImpl());
        return arrayList;
    }

    @Override // androidx.databinding.e
    public String convertBrIdToString(int i10) {
        return a.f27811a.get(i10);
    }

    @Override // androidx.databinding.e
    public ViewDataBinding getDataBinder(f fVar, View view, int i10) {
        if (f27810a.get(i10) <= 0 || view.getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    @Override // androidx.databinding.e
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = b.f27812a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.e
    public ViewDataBinding getDataBinder(f fVar, View[] viewArr, int i10) {
        if (viewArr == null || viewArr.length == 0 || f27810a.get(i10) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
