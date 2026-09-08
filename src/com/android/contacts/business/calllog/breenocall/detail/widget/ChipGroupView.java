package com.android.contacts.business.calllog.breenocall.detail.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.contacts.business.calllog.b;
import com.android.contacts.business.calllog.e;
import com.coui.appcompat.chip.COUIChip;
import com.google.android.material.chip.ChipGroup;
import com.oplus.foundation.util.ui.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.i;

/* compiled from: ChipGroupView.kt */
/* loaded from: classes.dex */
public final class ChipGroupView extends ChipGroup {
    private final Map<Integer, String> idDataMap;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChipGroupView(Context context) {
        super(context);
        i.f(context, "context");
        setSaveFromParentEnabled(false);
        this.idDataMap = new LinkedHashMap();
    }

    public final List<String> getCheckedDatas(List<Integer> checkedIds) {
        i.f(checkedIds, "checkedIds");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = checkedIds.iterator();
        while (it.hasNext()) {
            String str = this.idDataMap.get(Integer.valueOf(((Number) it.next()).intValue()));
            if (str != null) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public final void setChecked(String value, boolean z10) {
        i.f(value, "value");
        Iterator<T> it = this.idDataMap.keySet().iterator();
        boolean z11 = false;
        while (it.hasNext()) {
            int intValue = ((Number) it.next()).intValue();
            if (this.idDataMap.get(Integer.valueOf(intValue)) != null && i.b(this.idDataMap.get(Integer.valueOf(intValue)), value)) {
                check(intValue);
                z11 = true;
            }
        }
        if (!z11 && z10) {
            clearCheck();
        }
    }

    public final void setDatas(List<String> datas, int i10) {
        i.f(datas, "datas");
        if (datas.size() > 1) {
            this.idDataMap.clear();
            removeAllViews();
            int i11 = 0;
            for (String str : datas) {
                View inflate = LayoutInflater.from(getContext()).inflate(e.f13711b, (ViewGroup) null);
                i.d(inflate, "null cannot be cast to non-null type com.coui.appcompat.chip.COUIChip");
                COUIChip cOUIChip = (COUIChip) inflate;
                cOUIChip.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                cOUIChip.setVisibility(0);
                cOUIChip.setText(str);
                d.e(cOUIChip, getContext().getResources().getDimensionPixelSize(b.f13695a), d.f28372a.b());
                addView(cOUIChip);
                this.idDataMap.put(Integer.valueOf(cOUIChip.getId()), str);
                if (i11 == i10) {
                    check(cOUIChip.getId());
                }
                i11++;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChipGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        i.f(context, "context");
        setSaveFromParentEnabled(false);
        this.idDataMap = new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChipGroupView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i.f(context, "context");
        setSaveFromParentEnabled(false);
        this.idDataMap = new LinkedHashMap();
    }
}
