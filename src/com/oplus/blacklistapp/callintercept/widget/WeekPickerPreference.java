package com.oplus.blacklistapp.callintercept.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.preference.Preference;
import androidx.preference.l;
import androidx.recyclerview.widget.COUIRecyclerView;
import com.coui.appcompat.cardlist.COUICardListHelper;
import com.coui.appcompat.cardlist.COUICardListSelectedItemLayout;
import com.oplus.blacklistapp.callintercept.widget.WeekPicker;
import com.oplus.blacklistapp.p;
import com.oplus.blacklistapp.r;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: WeekPickerPreference.kt */
/* loaded from: classes3.dex */
public final class WeekPickerPreference extends Preference implements COUIRecyclerView.b {

    /* renamed from: a, reason: collision with root package name */
    public WeekPicker.b f27009a;

    /* renamed from: b, reason: collision with root package name */
    public WeekPicker f27010b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList<Integer> f27011c;

    /* renamed from: d, reason: collision with root package name */
    public View f27012d;

    /* renamed from: e, reason: collision with root package name */
    public View f27013e;

    public WeekPickerPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
    }

    public final WeekPicker a() {
        return this.f27010b;
    }

    public final void b(l lVar) {
        View view;
        WeekPicker weekPicker;
        COUICardListHelper.setItemCardBackground(lVar.itemView, 2);
        View e10 = lVar.e(p.f27373Y0);
        i.d(e10, "null cannot be cast to non-null type com.oplus.blacklistapp.callintercept.widget.WeekPicker");
        WeekPicker weekPicker2 = (WeekPicker) e10;
        this.f27010b = weekPicker2;
        if (weekPicker2 != null) {
            view = weekPicker2.findViewById(p.f27425y0);
        } else {
            view = null;
        }
        this.f27013e = view;
        WeekPicker.b bVar = this.f27009a;
        if (bVar != null && (weekPicker = this.f27010b) != null) {
            weekPicker.setOnWeekPickerClickListener(bVar);
        }
        ArrayList<Integer> arrayList = this.f27011c;
        if (arrayList != null) {
            if (arrayList == null || arrayList.size() != 0) {
                WeekPicker weekPicker3 = this.f27010b;
                if (weekPicker3 != null) {
                    weekPicker3.setAllChecked(false);
                }
                ArrayList<Integer> arrayList2 = this.f27011c;
                if (arrayList2 != null) {
                    Iterator<T> it = arrayList2.iterator();
                    while (it.hasNext()) {
                        int intValue = ((Number) it.next()).intValue();
                        WeekPicker weekPicker4 = this.f27010b;
                        if (weekPicker4 != null) {
                            weekPicker4.f(intValue, true);
                        }
                    }
                }
            }
        }
    }

    public final void c(WeekPicker.b bVar) {
        this.f27009a = bVar;
    }

    public final void d(ArrayList<Integer> arrayList) {
        ArrayList<Integer> arrayList2;
        if (arrayList != null) {
            arrayList2 = new ArrayList<>(arrayList);
        } else {
            arrayList2 = null;
        }
        this.f27011c = arrayList2;
        notifyChanged();
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public boolean drawDivider() {
        if (!(this.f27012d instanceof COUICardListSelectedItemLayout)) {
            return false;
        }
        int positionInGroup = COUICardListHelper.getPositionInGroup(this);
        if (positionInGroup != 1 && positionInGroup != 2) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public View getDividerEndAlignView() {
        return this.f27013e;
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public View getDividerStartAlignView() {
        return this.f27013e;
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(l holder) {
        i.f(holder, "holder");
        super.onBindViewHolder(holder);
        this.f27012d = holder.itemView;
        b(holder);
    }

    public WeekPickerPreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0, 8, null);
    }

    public /* synthetic */ WeekPickerPreference(Context context, AttributeSet attributeSet, int i10, int i11, int i12, f fVar) {
        this(context, attributeSet, (i12 & 4) != 0 ? 0 : i10, (i12 & 8) != 0 ? 0 : i11);
    }

    public WeekPickerPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        setLayoutResource(r.f27445Q);
    }
}
