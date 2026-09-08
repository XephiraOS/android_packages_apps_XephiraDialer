package com.android.incallui.foldscreen;

import R1.d;
import R1.h;
import R1.j;
import R1.l;
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
    public static final SparseIntArray f18391a;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final SparseArray<String> f18392a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(20);
            f18392a = sparseArray;
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
        public static final HashMap<String, Integer> f18393a;

        static {
            HashMap<String, Integer> hashMap = new HashMap<>(6);
            f18393a = hashMap;
            hashMap.put("layout/fold_answer_button_layout_0", Integer.valueOf(P1.e.f2864a));
            hashMap.put("layout/fold_call_button_layout_0", Integer.valueOf(P1.e.f2865b));
            hashMap.put("layout/fold_screen_video_anim_layout_0", Integer.valueOf(P1.e.f2868e));
            hashMap.put("layout/fragment_fold_screen_call_button_0", Integer.valueOf(P1.e.f2870g));
            hashMap.put("layout/fragment_fold_screen_call_card_0", Integer.valueOf(P1.e.f2871h));
            hashMap.put("layout/fragment_fold_screen_call_card_secondary_0", Integer.valueOf(P1.e.f2872i));
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(6);
        f18391a = sparseIntArray;
        sparseIntArray.put(P1.e.f2864a, 1);
        sparseIntArray.put(P1.e.f2865b, 2);
        sparseIntArray.put(P1.e.f2868e, 3);
        sparseIntArray.put(P1.e.f2870g, 4);
        sparseIntArray.put(P1.e.f2871h, 5);
        sparseIntArray.put(P1.e.f2872i, 6);
    }

    @Override // androidx.databinding.e
    public List<e> collectDependencies() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.android.incallui.DataBinderMapperImpl());
        return arrayList;
    }

    @Override // androidx.databinding.e
    public String convertBrIdToString(int i10) {
        return a.f18392a.get(i10);
    }

    @Override // androidx.databinding.e
    public ViewDataBinding getDataBinder(f fVar, View view, int i10) {
        int i11 = f18391a.get(i10);
        if (i11 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag != null) {
            switch (i11) {
                case 1:
                    if ("layout/fold_answer_button_layout_0".equals(tag)) {
                        return new R1.b(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for fold_answer_button_layout is invalid. Received: " + tag);
                case 2:
                    if ("layout/fold_call_button_layout_0".equals(tag)) {
                        return new d(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for fold_call_button_layout is invalid. Received: " + tag);
                case 3:
                    if ("layout/fold_screen_video_anim_layout_0".equals(tag)) {
                        return new R1.f(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for fold_screen_video_anim_layout is invalid. Received: " + tag);
                case 4:
                    if ("layout/fragment_fold_screen_call_button_0".equals(tag)) {
                        return new h(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_fold_screen_call_button is invalid. Received: " + tag);
                case 5:
                    if ("layout/fragment_fold_screen_call_card_0".equals(tag)) {
                        return new j(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_fold_screen_call_card is invalid. Received: " + tag);
                case 6:
                    if ("layout/fragment_fold_screen_call_card_secondary_0".equals(tag)) {
                        return new l(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_fold_screen_call_card_secondary is invalid. Received: " + tag);
                default:
                    return null;
            }
        }
        throw new RuntimeException("view must have a tag");
    }

    @Override // androidx.databinding.e
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = b.f18393a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.e
    public ViewDataBinding getDataBinder(f fVar, View[] viewArr, int i10) {
        if (viewArr == null || viewArr.length == 0 || f18391a.get(i10) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
