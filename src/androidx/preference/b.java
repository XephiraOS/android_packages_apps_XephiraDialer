package androidx.preference;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ExpandButton.java */
/* loaded from: classes.dex */
public final class b extends Preference {

    /* renamed from: a, reason: collision with root package name */
    public long f10572a;

    public b(Context context, List<Preference> list, long j10) {
        super(context);
        a();
        b(list);
        this.f10572a = j10 + 1000000;
    }

    public final void a() {
        setLayoutResource(p.f10648a);
        setIcon(n.f10641a);
        setTitle(q.f10653b);
        setOrder(999);
    }

    public final void b(List<Preference> list) {
        ArrayList arrayList = new ArrayList();
        CharSequence charSequence = null;
        for (Preference preference : list) {
            CharSequence title = preference.getTitle();
            boolean z10 = preference instanceof PreferenceGroup;
            if (z10 && !TextUtils.isEmpty(title)) {
                arrayList.add((PreferenceGroup) preference);
            }
            if (arrayList.contains(preference.getParent())) {
                if (z10) {
                    arrayList.add((PreferenceGroup) preference);
                }
            } else if (!TextUtils.isEmpty(title)) {
                if (charSequence == null) {
                    charSequence = title;
                } else {
                    charSequence = getContext().getString(q.f10656e, charSequence, title);
                }
            }
        }
        setSummary(charSequence);
    }

    @Override // androidx.preference.Preference
    public long getId() {
        return this.f10572a;
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(l lVar) {
        super.onBindViewHolder(lVar);
        lVar.i(false);
    }
}
