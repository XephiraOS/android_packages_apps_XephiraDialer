package com.android.contacts.business.calllog.breenocall.detail.widget;

import X0.b;
import android.text.TextUtils;
import com.google.android.material.chip.ChipGroup;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class FieldEditListener implements b.a, ChipGroup.d {
    private final ChipGroupView mChipGroupView;
    private final List<String> mColumnTags;
    private String mCurrentFocusViewTag;
    private final b mEditor;

    public FieldEditListener(b bVar, ChipGroupView chipGroupView, List<String> list) {
        ArrayList arrayList = new ArrayList();
        this.mColumnTags = arrayList;
        this.mEditor = bVar;
        this.mChipGroupView = chipGroupView;
        arrayList.addAll(list);
    }

    private void updateChipGroupCheckState(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mChipGroupView.clearCheck();
        } else {
            this.mChipGroupView.setChecked(str, true);
        }
    }

    @Override // com.google.android.material.chip.ChipGroup.d
    public void onCheckedChanged(ChipGroup chipGroup, List<Integer> list) {
        String str;
        if (!list.isEmpty()) {
            List<String> checkedDatas = this.mChipGroupView.getCheckedDatas(list);
            if (!checkedDatas.isEmpty()) {
                str = checkedDatas.get(0);
            } else {
                str = null;
            }
            String str2 = this.mCurrentFocusViewTag;
            if (str2 != null) {
                this.mEditor.e(str2, str);
            }
        }
    }

    @Override // X0.b.a
    public void onFieldContentChanged(String str, String str2) {
        if (this.mColumnTags.contains(str)) {
            updateChipGroupCheckState(str2);
        }
    }

    @Override // X0.b.a
    public void onFocusStateChanged(String str, boolean z10, String str2) {
        this.mCurrentFocusViewTag = null;
        int i10 = 8;
        if (this.mColumnTags.contains(str)) {
            ChipGroupView chipGroupView = this.mChipGroupView;
            if (z10) {
                i10 = 0;
            }
            chipGroupView.setVisibility(i10);
            if (z10) {
                this.mCurrentFocusViewTag = str;
                updateChipGroupCheckState(str2);
                return;
            }
            return;
        }
        this.mChipGroupView.setVisibility(8);
    }
}
