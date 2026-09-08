package com.android.contacts;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.oplus.dialer.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import x0.C1661A;
import x0.C1664b;
import x0.C1666d;
import x0.C1668f;
import x0.C1670h;

/* loaded from: classes.dex */
public class DataBinderMapperImpl extends androidx.databinding.e {

    /* renamed from: a, reason: collision with root package name */
    public static final SparseIntArray f13106a;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final SparseArray<String> f13107a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(23);
            f13107a = sparseArray;
            sparseArray.put(0, "_all");
            sparseArray.put(1, "audioModeInfo");
            sparseArray.put(2, "commandViewModel");
            sparseArray.put(3, "commonViewModel");
            sparseArray.put(4, "contactItem");
            sparseArray.put(5, "dialpadButtonInfo");
            sparseArray.put(6, "editMode");
            sparseArray.put(7, "headerText");
            sparseArray.put(8, "holder");
            sparseArray.put(9, "isFirstItem");
            sparseArray.put(10, "isLastItem");
            sparseArray.put(11, "mBackgroundViewModel");
            sparseArray.put(12, "mCallButtonViewModel");
            sparseArray.put(13, "mCallCardViewModel");
            sparseArray.put(14, "mCommandModel");
            sparseArray.put(15, "mDialpadViewModel");
            sparseArray.put(16, "mFlingUpAnswerMethodModel");
            sparseArray.put(17, "mGlobeCommandModel");
            sparseArray.put(18, "mOplusInCallViewModel");
            sparseArray.put(19, "mRideModeAnswerMethodModel");
            sparseArray.put(20, "mStaticAnswerMethodModel");
            sparseArray.put(21, "mViewModel");
            sparseArray.put(22, "viewModel");
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static final HashMap<String, Integer> f13108a;

        static {
            HashMap<String, Integer> hashMap = new HashMap<>(16);
            f13108a = hashMap;
            hashMap.put("layout/contacts_main_list_collapsing_appbar_layout_0", Integer.valueOf(R.layout.contacts_main_list_collapsing_appbar_layout));
            hashMap.put("layout/contacts_main_list_fragment_layout_0", Integer.valueOf(R.layout.contacts_main_list_fragment_layout));
            hashMap.put("layout/contacts_main_list_fragment_layout_unfold_0", Integer.valueOf(R.layout.contacts_main_list_fragment_layout_unfold));
            hashMap.put("layout/contacts_main_list_header_view_0", Integer.valueOf(R.layout.contacts_main_list_header_view));
            hashMap.put("layout/contacts_main_list_item_0", Integer.valueOf(R.layout.contacts_main_list_item));
            hashMap.put("layout/contacts_main_list_item_with_header_0", Integer.valueOf(R.layout.contacts_main_list_item_with_header));
            hashMap.put("layout/contacts_main_list_item_with_header_star_0", Integer.valueOf(R.layout.contacts_main_list_item_with_header_star));
            hashMap.put("layout/fragment_scene_dialtacts_0", Integer.valueOf(R.layout.fragment_scene_dialtacts));
            hashMap.put("layout/scene_dial_edit_text_container_0", Integer.valueOf(R.layout.scene_dial_edit_text_container));
            hashMap.put("layout/scene_dialpad_0", Integer.valueOf(R.layout.scene_dialpad));
            hashMap.put("layout/scene_dual_sim_layout_0", Integer.valueOf(R.layout.scene_dual_sim_layout));
            hashMap.put("layout/scene_item_call_log_0", Integer.valueOf(R.layout.scene_item_call_log));
            hashMap.put("layout/scene_no_agree_permission_or_statement_0", Integer.valueOf(R.layout.scene_no_agree_permission_or_statement));
            hashMap.put("layout/scene_no_call_log_0", Integer.valueOf(R.layout.scene_no_call_log));
            hashMap.put("layout/scene_single_sim_layout_0", Integer.valueOf(R.layout.scene_single_sim_layout));
            hashMap.put("layout/scene_switch_sim_layout_0", Integer.valueOf(R.layout.scene_switch_sim_layout));
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(16);
        f13106a = sparseIntArray;
        sparseIntArray.put(R.layout.contacts_main_list_collapsing_appbar_layout, 1);
        sparseIntArray.put(R.layout.contacts_main_list_fragment_layout, 2);
        sparseIntArray.put(R.layout.contacts_main_list_fragment_layout_unfold, 3);
        sparseIntArray.put(R.layout.contacts_main_list_header_view, 4);
        sparseIntArray.put(R.layout.contacts_main_list_item, 5);
        sparseIntArray.put(R.layout.contacts_main_list_item_with_header, 6);
        sparseIntArray.put(R.layout.contacts_main_list_item_with_header_star, 7);
        sparseIntArray.put(R.layout.fragment_scene_dialtacts, 8);
        sparseIntArray.put(R.layout.scene_dial_edit_text_container, 9);
        sparseIntArray.put(R.layout.scene_dialpad, 10);
        sparseIntArray.put(R.layout.scene_dual_sim_layout, 11);
        sparseIntArray.put(R.layout.scene_item_call_log, 12);
        sparseIntArray.put(R.layout.scene_no_agree_permission_or_statement, 13);
        sparseIntArray.put(R.layout.scene_no_call_log, 14);
        sparseIntArray.put(R.layout.scene_single_sim_layout, 15);
        sparseIntArray.put(R.layout.scene_switch_sim_layout, 16);
    }

    @Override // androidx.databinding.e
    public List<androidx.databinding.e> collectDependencies() {
        ArrayList arrayList = new ArrayList(24);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.android.contacts.business.calllog.DataBinderMapperImpl());
        arrayList.add(new com.android.contacts.cust.mapper.DataBinderMapperImpl());
        arrayList.add(new com.android.contacts.cust.shell.DataBinderMapperImpl());
        arrayList.add(new com.android.contacts.framework.accountmanager.DataBinderMapperImpl());
        arrayList.add(new com.android.contacts.framework.api.DataBinderMapperImpl());
        arrayList.add(new com.android.contacts.framework.appstore.DataBinderMapperImpl());
        arrayList.add(new com.android.contacts.framework.baseui.DataBinderMapperImpl());
        arrayList.add(new com.android.contacts.framework.bttransmission.DataBinderMapperImpl());
        arrayList.add(new com.android.contacts.framework.omoji.DataBinderMapperImpl());
        arrayList.add(new com.android.contacts.framework.phonenumber.DataBinderMapperImpl());
        arrayList.add(new com.android.contacts.framework.rcs.DataBinderMapperImpl());
        arrayList.add(new com.android.contacts.framework.repository.DataBinderMapperImpl());
        arrayList.add(new com.android.contacts.framework.router.DataBinderMapperImpl());
        arrayList.add(new com.android.contacts.framework.vcard.DataBinderMapperImpl());
        arrayList.add(new com.android.contacts.framework.virtualsupport.DataBinderMapperImpl());
        arrayList.add(new com.android.contacts.resource.DataBinderMapperImpl());
        arrayList.add(new com.android.contacts.sdkcompat.DataBinderMapperImpl());
        arrayList.add(new com.oplus.contacts.googlecontacts.DataBinderMapperImpl());
        arrayList.add(new com.oplus.foundation.appsupport.DataBinderMapperImpl());
        arrayList.add(new com.oplus.foundation.dict.DataBinderMapperImpl());
        arrayList.add(new com.oplus.foundation.globaltheme.DataBinderMapperImpl());
        arrayList.add(new com.oplus.foundation.libutil.DataBinderMapperImpl());
        arrayList.add(new com.support.component.DataBinderMapperImpl());
        return arrayList;
    }

    @Override // androidx.databinding.e
    public String convertBrIdToString(int i10) {
        return a.f13107a.get(i10);
    }

    @Override // androidx.databinding.e
    public ViewDataBinding getDataBinder(androidx.databinding.f fVar, View view, int i10) {
        int i11 = f13106a.get(i10);
        if (i11 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag != null) {
            switch (i11) {
                case 1:
                    if ("layout/contacts_main_list_collapsing_appbar_layout_0".equals(tag)) {
                        return new C1664b(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for contacts_main_list_collapsing_appbar_layout is invalid. Received: " + tag);
                case 2:
                    if ("layout/contacts_main_list_fragment_layout_0".equals(tag)) {
                        return new C1666d(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for contacts_main_list_fragment_layout is invalid. Received: " + tag);
                case 3:
                    if ("layout/contacts_main_list_fragment_layout_unfold_0".equals(tag)) {
                        return new C1668f(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for contacts_main_list_fragment_layout_unfold is invalid. Received: " + tag);
                case 4:
                    if ("layout/contacts_main_list_header_view_0".equals(tag)) {
                        return new C1670h(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for contacts_main_list_header_view is invalid. Received: " + tag);
                case 5:
                    if ("layout/contacts_main_list_item_0".equals(tag)) {
                        return new x0.j(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for contacts_main_list_item is invalid. Received: " + tag);
                case 6:
                    if ("layout/contacts_main_list_item_with_header_0".equals(tag)) {
                        return new x0.l(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for contacts_main_list_item_with_header is invalid. Received: " + tag);
                case 7:
                    if ("layout/contacts_main_list_item_with_header_star_0".equals(tag)) {
                        return new x0.n(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for contacts_main_list_item_with_header_star is invalid. Received: " + tag);
                case 8:
                    if ("layout/fragment_scene_dialtacts_0".equals(tag)) {
                        return new x0.p(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_scene_dialtacts is invalid. Received: " + tag);
                case 9:
                    if ("layout/scene_dial_edit_text_container_0".equals(tag)) {
                        return new x0.u(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for scene_dial_edit_text_container is invalid. Received: " + tag);
                case 10:
                    if ("layout/scene_dialpad_0".equals(tag)) {
                        return new x0.w(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for scene_dialpad is invalid. Received: " + tag);
                case 11:
                    if ("layout/scene_dual_sim_layout_0".equals(tag)) {
                        return new x0.y(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for scene_dual_sim_layout is invalid. Received: " + tag);
                case 12:
                    if ("layout/scene_item_call_log_0".equals(tag)) {
                        return new C1661A(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for scene_item_call_log is invalid. Received: " + tag);
                case 13:
                    if ("layout/scene_no_agree_permission_or_statement_0".equals(tag)) {
                        return new x0.C(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for scene_no_agree_permission_or_statement is invalid. Received: " + tag);
                case 14:
                    if ("layout/scene_no_call_log_0".equals(tag)) {
                        return new x0.E(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for scene_no_call_log is invalid. Received: " + tag);
                case 15:
                    if ("layout/scene_single_sim_layout_0".equals(tag)) {
                        return new x0.G(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for scene_single_sim_layout is invalid. Received: " + tag);
                case 16:
                    if ("layout/scene_switch_sim_layout_0".equals(tag)) {
                        return new x0.I(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for scene_switch_sim_layout is invalid. Received: " + tag);
                default:
                    return null;
            }
        }
        throw new RuntimeException("view must have a tag");
    }

    @Override // androidx.databinding.e
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = b.f13108a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.e
    public ViewDataBinding getDataBinder(androidx.databinding.f fVar, View[] viewArr, int i10) {
        if (viewArr == null || viewArr.length == 0 || f13106a.get(i10) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
