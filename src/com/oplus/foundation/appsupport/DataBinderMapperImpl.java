package com.oplus.foundation.appsupport;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import m7.f;
import n7.C1375b;
import n7.d;

/* loaded from: classes3.dex */
public class DataBinderMapperImpl extends e {

    /* renamed from: a, reason: collision with root package name */
    public static final SparseIntArray f28184a;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final SparseArray<String> f28185a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(1);
            f28185a = sparseArray;
            sparseArray.put(0, "_all");
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static final HashMap<String, Integer> f28186a;

        static {
            HashMap<String, Integer> hashMap = new HashMap<>(2);
            f28186a = hashMap;
            hashMap.put("layout/collapsing_appbar_layout_0", Integer.valueOf(f.f35190a));
            hashMap.put("layout/divider_appbar_layout_0", Integer.valueOf(f.f35191b));
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(2);
        f28184a = sparseIntArray;
        sparseIntArray.put(f.f35190a, 1);
        sparseIntArray.put(f.f35191b, 2);
    }

    @Override // androidx.databinding.e
    public List<e> collectDependencies() {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.oplus.foundation.globaltheme.DataBinderMapperImpl());
        arrayList.add(new com.oplus.foundation.libutil.DataBinderMapperImpl());
        return arrayList;
    }

    @Override // androidx.databinding.e
    public String convertBrIdToString(int i10) {
        return a.f28185a.get(i10);
    }

    @Override // androidx.databinding.e
    public ViewDataBinding getDataBinder(androidx.databinding.f fVar, View view, int i10) {
        int i11 = f28184a.get(i10);
        if (i11 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        }
        if (i11 == 1) {
            if ("layout/collapsing_appbar_layout_0".equals(tag)) {
                return new C1375b(fVar, view);
            }
            throw new IllegalArgumentException("The tag for collapsing_appbar_layout is invalid. Received: " + tag);
        }
        if (i11 != 2) {
            return null;
        }
        if ("layout/divider_appbar_layout_0".equals(tag)) {
            return new d(fVar, view);
        }
        throw new IllegalArgumentException("The tag for divider_appbar_layout is invalid. Received: " + tag);
    }

    @Override // androidx.databinding.e
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = b.f28186a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.e
    public ViewDataBinding getDataBinder(androidx.databinding.f fVar, View[] viewArr, int i10) {
        if (viewArr == null || viewArr.length == 0 || f28184a.get(i10) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
