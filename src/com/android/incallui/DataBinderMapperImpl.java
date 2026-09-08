package com.android.incallui;

import O1.C0396b;
import O1.C0398d;
import O1.C0400f;
import O1.C0402h;
import O1.C0404j;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public class DataBinderMapperImpl extends androidx.databinding.e {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP;
    private static final int LAYOUT_CALLCARDINFO = 1;
    private static final int LAYOUT_CALLCARDNOTICETEXTVIEW = 2;
    private static final int LAYOUT_CALLCARDSECONDARYINFOLAYOUT = 3;
    private static final int LAYOUT_FRAGMENTACTIONBUTTON = 4;
    private static final int LAYOUT_INCALLCALLCARDLAYOUT = 5;
    private static final int LAYOUT_INCALLFLINGUPANSWERMETHOD = 6;
    private static final int LAYOUT_INCALLRIDEMODEANSWERMETHOD = 7;
    private static final int LAYOUT_INCALLSTATICANSWERMETHOD = 8;
    private static final int LAYOUT_ITEMAUDIOMODEDIALOG = 9;
    private static final int LAYOUT_ITEMDIALPADBUTTON = 10;
    private static final int LAYOUT_OPLUSCALLBUTTONFRAGMENT = 11;
    private static final int LAYOUT_OPLUSDIALPADFRAGMENT = 12;
    private static final int LAYOUT_OPLUSINCALLFLOATINGDEFAULTVIEW = 13;
    private static final int LAYOUT_OPLUSINCALLFLOATINGDRIVERMODEVIEW = 14;
    private static final int LAYOUT_OPLUSINCALLFLOATINGNAVILANDSCAPEVIEW = 15;
    private static final int LAYOUT_OPLUSINCALLFLOATINGNAVIPORTRAITVIEW = 16;
    private static final int LAYOUT_OPLUSINCALLFLOATINGVIEW = 17;
    private static final int LAYOUT_OPLUSINCALLSCREEN = 18;

    /* loaded from: classes.dex */
    public static class InnerBrLookup {
        static final SparseArray<String> sKeys;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(19);
            sKeys = sparseArray;
            sparseArray.put(0, "_all");
            sparseArray.put(1, "audioModeInfo");
            sparseArray.put(2, "commandViewModel");
            sparseArray.put(3, "commonViewModel");
            sparseArray.put(4, "dialpadButtonInfo");
            sparseArray.put(5, "isFirstItem");
            sparseArray.put(6, "isLastItem");
            sparseArray.put(7, "mBackgroundViewModel");
            sparseArray.put(8, "mCallButtonViewModel");
            sparseArray.put(9, "mCallCardViewModel");
            sparseArray.put(10, "mCommandModel");
            sparseArray.put(11, "mDialpadViewModel");
            sparseArray.put(12, "mFlingUpAnswerMethodModel");
            sparseArray.put(13, "mGlobeCommandModel");
            sparseArray.put(14, "mOplusInCallViewModel");
            sparseArray.put(15, "mRideModeAnswerMethodModel");
            sparseArray.put(16, "mStaticAnswerMethodModel");
            sparseArray.put(17, "mViewModel");
            sparseArray.put(18, "viewModel");
        }

        private InnerBrLookup() {
        }
    }

    /* loaded from: classes.dex */
    public static class InnerLayoutIdLookup {
        static final HashMap<String, Integer> sKeys;

        static {
            HashMap<String, Integer> hashMap = new HashMap<>(18);
            sKeys = hashMap;
            hashMap.put("layout/call_card_info_0", Integer.valueOf(R.layout.call_card_info));
            hashMap.put("layout/call_card_notice_text_view_0", Integer.valueOf(R.layout.call_card_notice_text_view));
            hashMap.put("layout/call_card_secondary_info_layout_0", Integer.valueOf(R.layout.call_card_secondary_info_layout));
            hashMap.put("layout/fragment_action_button_0", Integer.valueOf(R.layout.fragment_action_button));
            hashMap.put("layout/incall_call_card_layout_0", Integer.valueOf(R.layout.incall_call_card_layout));
            hashMap.put("layout/incall_fling_up_answer_method_0", Integer.valueOf(R.layout.incall_fling_up_answer_method));
            hashMap.put("layout/incall_ride_mode_answer_method_0", Integer.valueOf(R.layout.incall_ride_mode_answer_method));
            hashMap.put("layout/incall_static_answer_method_0", Integer.valueOf(R.layout.incall_static_answer_method));
            hashMap.put("layout/item_audio_mode_dialog_0", Integer.valueOf(R.layout.item_audio_mode_dialog));
            hashMap.put("layout/item_dialpad_button_0", Integer.valueOf(R.layout.item_dialpad_button));
            hashMap.put("layout/oplus_call_button_fragment_0", Integer.valueOf(R.layout.oplus_call_button_fragment));
            hashMap.put("layout/oplus_dialpad_fragment_0", Integer.valueOf(R.layout.oplus_dialpad_fragment));
            hashMap.put("layout/oplus_incall_floating_default_view_0", Integer.valueOf(R.layout.oplus_incall_floating_default_view));
            hashMap.put("layout/oplus_incall_floating_driver_mode_view_0", Integer.valueOf(R.layout.oplus_incall_floating_driver_mode_view));
            hashMap.put("layout/oplus_incall_floating_navi_landscape_view_0", Integer.valueOf(R.layout.oplus_incall_floating_navi_landscape_view));
            hashMap.put("layout/oplus_incall_floating_navi_portrait_view_0", Integer.valueOf(R.layout.oplus_incall_floating_navi_portrait_view));
            hashMap.put("layout/oplus_incall_floating_view_0", Integer.valueOf(R.layout.oplus_incall_floating_view));
            hashMap.put("layout/oplus_incall_screen_0", Integer.valueOf(R.layout.oplus_incall_screen));
        }

        private InnerLayoutIdLookup() {
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(18);
        INTERNAL_LAYOUT_ID_LOOKUP = sparseIntArray;
        sparseIntArray.put(R.layout.call_card_info, 1);
        sparseIntArray.put(R.layout.call_card_notice_text_view, 2);
        sparseIntArray.put(R.layout.call_card_secondary_info_layout, 3);
        sparseIntArray.put(R.layout.fragment_action_button, 4);
        sparseIntArray.put(R.layout.incall_call_card_layout, 5);
        sparseIntArray.put(R.layout.incall_fling_up_answer_method, 6);
        sparseIntArray.put(R.layout.incall_ride_mode_answer_method, 7);
        sparseIntArray.put(R.layout.incall_static_answer_method, 8);
        sparseIntArray.put(R.layout.item_audio_mode_dialog, 9);
        sparseIntArray.put(R.layout.item_dialpad_button, 10);
        sparseIntArray.put(R.layout.oplus_call_button_fragment, 11);
        sparseIntArray.put(R.layout.oplus_dialpad_fragment, 12);
        sparseIntArray.put(R.layout.oplus_incall_floating_default_view, 13);
        sparseIntArray.put(R.layout.oplus_incall_floating_driver_mode_view, 14);
        sparseIntArray.put(R.layout.oplus_incall_floating_navi_landscape_view, 15);
        sparseIntArray.put(R.layout.oplus_incall_floating_navi_portrait_view, 16);
        sparseIntArray.put(R.layout.oplus_incall_floating_view, 17);
        sparseIntArray.put(R.layout.oplus_incall_screen, 18);
    }

    @Override // androidx.databinding.e
    public List<androidx.databinding.e> collectDependencies() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        return arrayList;
    }

    @Override // androidx.databinding.e
    public String convertBrIdToString(int i10) {
        return InnerBrLookup.sKeys.get(i10);
    }

    @Override // androidx.databinding.e
    public ViewDataBinding getDataBinder(androidx.databinding.f fVar, View view, int i10) {
        int i11 = INTERNAL_LAYOUT_ID_LOOKUP.get(i10);
        if (i11 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag != null) {
            switch (i11) {
                case 1:
                    if ("layout/call_card_info_0".equals(tag)) {
                        return new C0396b(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for call_card_info is invalid. Received: " + tag);
                case 2:
                    if ("layout/call_card_notice_text_view_0".equals(tag)) {
                        return new C0398d(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for call_card_notice_text_view is invalid. Received: " + tag);
                case 3:
                    if ("layout/call_card_secondary_info_layout_0".equals(tag)) {
                        return new C0400f(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for call_card_secondary_info_layout is invalid. Received: " + tag);
                case 4:
                    if ("layout/fragment_action_button_0".equals(tag)) {
                        return new C0402h(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_action_button is invalid. Received: " + tag);
                case 5:
                    if ("layout/incall_call_card_layout_0".equals(tag)) {
                        return new C0404j(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for incall_call_card_layout is invalid. Received: " + tag);
                case 6:
                    if ("layout/incall_fling_up_answer_method_0".equals(tag)) {
                        return new O1.l(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for incall_fling_up_answer_method is invalid. Received: " + tag);
                case 7:
                    if ("layout/incall_ride_mode_answer_method_0".equals(tag)) {
                        return new O1.n(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for incall_ride_mode_answer_method is invalid. Received: " + tag);
                case 8:
                    if ("layout/incall_static_answer_method_0".equals(tag)) {
                        return new O1.p(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for incall_static_answer_method is invalid. Received: " + tag);
                case 9:
                    if ("layout/item_audio_mode_dialog_0".equals(tag)) {
                        return new O1.r(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for item_audio_mode_dialog is invalid. Received: " + tag);
                case 10:
                    if ("layout/item_dialpad_button_0".equals(tag)) {
                        return new O1.t(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for item_dialpad_button is invalid. Received: " + tag);
                case 11:
                    if ("layout/oplus_call_button_fragment_0".equals(tag)) {
                        return new O1.v(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for oplus_call_button_fragment is invalid. Received: " + tag);
                case 12:
                    if ("layout/oplus_dialpad_fragment_0".equals(tag)) {
                        return new O1.x(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for oplus_dialpad_fragment is invalid. Received: " + tag);
                case 13:
                    if ("layout/oplus_incall_floating_default_view_0".equals(tag)) {
                        return new O1.z(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for oplus_incall_floating_default_view is invalid. Received: " + tag);
                case 14:
                    if ("layout/oplus_incall_floating_driver_mode_view_0".equals(tag)) {
                        return new O1.B(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for oplus_incall_floating_driver_mode_view is invalid. Received: " + tag);
                case 15:
                    if ("layout/oplus_incall_floating_navi_landscape_view_0".equals(tag)) {
                        return new O1.D(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for oplus_incall_floating_navi_landscape_view is invalid. Received: " + tag);
                case 16:
                    if ("layout/oplus_incall_floating_navi_portrait_view_0".equals(tag)) {
                        return new O1.F(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for oplus_incall_floating_navi_portrait_view is invalid. Received: " + tag);
                case 17:
                    if ("layout/oplus_incall_floating_view_0".equals(tag)) {
                        return new O1.H(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for oplus_incall_floating_view is invalid. Received: " + tag);
                case 18:
                    if ("layout/oplus_incall_screen_0".equals(tag)) {
                        return new O1.J(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for oplus_incall_screen is invalid. Received: " + tag);
                default:
                    return null;
            }
        }
        throw new RuntimeException("view must have a tag");
    }

    @Override // androidx.databinding.e
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = InnerLayoutIdLookup.sKeys.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.e
    public ViewDataBinding getDataBinder(androidx.databinding.f fVar, View[] viewArr, int i10) {
        if (viewArr == null || viewArr.length == 0 || INTERNAL_LAYOUT_ID_LOOKUP.get(i10) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
