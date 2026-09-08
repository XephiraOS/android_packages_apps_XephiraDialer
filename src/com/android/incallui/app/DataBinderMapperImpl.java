package com.android.incallui.app;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public class DataBinderMapperImpl extends e {

    /* renamed from: a, reason: collision with root package name */
    public static final SparseIntArray f18292a = new SparseIntArray(0);

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final SparseArray<String> f18293a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(20);
            f18293a = sparseArray;
            sparseArray.put(0, "_all");
            sparseArray.put(1, "audioModeInfo");
            sparseArray.put(2, "commandViewModel");
            sparseArray.put(3, "commonViewModel");
            sparseArray.put(4, "dialpadButtonInfo");
            sparseArray.put(5, "holder");
            sparseArray.put(6, "isFirstItem");
            sparseArray.put(7, "isLastItem");
            sparseArray.put(8, "mBackgroundViewModel");
            sparseArray.put(9, "mCallButtonViewModel");
            sparseArray.put(10, "mCallCardViewModel");
            sparseArray.put(11, "mCommandModel");
            sparseArray.put(12, "mDialpadViewModel");
            sparseArray.put(13, "mFlingUpAnswerMethodModel");
            sparseArray.put(14, "mGlobeCommandModel");
            sparseArray.put(15, "mOplusInCallViewModel");
            sparseArray.put(16, "mRideModeAnswerMethodModel");
            sparseArray.put(17, "mStaticAnswerMethodModel");
            sparseArray.put(18, "mViewModel");
            sparseArray.put(19, "viewModel");
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static final HashMap<String, Integer> f18294a = new HashMap<>(0);
    }

    @Override // androidx.databinding.e
    public List<e> collectDependencies() {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.android.incallui.DataBinderMapperImpl());
        arrayList.add(new com.android.incallui.foldscreen.DataBinderMapperImpl());
        return arrayList;
    }

    @Override // androidx.databinding.e
    public String convertBrIdToString(int i10) {
        return a.f18293a.get(i10);
    }

    @Override // androidx.databinding.e
    public ViewDataBinding getDataBinder(f fVar, View view, int i10) {
        if (f18292a.get(i10) <= 0 || view.getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    @Override // androidx.databinding.e
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = b.f18294a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.e
    public ViewDataBinding getDataBinder(f fVar, View[] viewArr, int i10) {
        if (viewArr == null || viewArr.length == 0 || f18292a.get(i10) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
