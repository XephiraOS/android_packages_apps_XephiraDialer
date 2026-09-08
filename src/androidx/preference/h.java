package androidx.preference;

import android.R;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.K;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.recyclerview.widget.RecyclerView;
import f.C0991a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: PreferenceGroupAdapter.java */
/* loaded from: classes.dex */
public class h extends RecyclerView.Adapter<l> implements Preference.b, PreferenceGroup.c {

    /* renamed from: a, reason: collision with root package name */
    public final PreferenceGroup f10588a;

    /* renamed from: b, reason: collision with root package name */
    public List<Preference> f10589b;

    /* renamed from: c, reason: collision with root package name */
    public List<Preference> f10590c;

    /* renamed from: d, reason: collision with root package name */
    public final List<c> f10591d;

    /* renamed from: f, reason: collision with root package name */
    public final Runnable f10593f = new a();

    /* renamed from: e, reason: collision with root package name */
    public final Handler f10592e = new Handler(Looper.getMainLooper());

    /* compiled from: PreferenceGroupAdapter.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.n();
        }
    }

    /* compiled from: PreferenceGroupAdapter.java */
    /* loaded from: classes.dex */
    public class b implements Preference.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PreferenceGroup f10595a;

        public b(PreferenceGroup preferenceGroup) {
            this.f10595a = preferenceGroup;
        }

        @Override // androidx.preference.Preference.d
        public boolean s0(Preference preference) {
            this.f10595a.setInitialExpandedChildrenCount(Integer.MAX_VALUE);
            h.this.a(preference);
            this.f10595a.getOnExpandButtonClickListener();
            return true;
        }
    }

    /* compiled from: PreferenceGroupAdapter.java */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public int f10597a;

        /* renamed from: b, reason: collision with root package name */
        public int f10598b;

        /* renamed from: c, reason: collision with root package name */
        public String f10599c;

        public c(Preference preference) {
            this.f10599c = preference.getClass().getName();
            this.f10597a = preference.getLayoutResource();
            this.f10598b = preference.getWidgetLayoutResource();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (this.f10597a != cVar.f10597a || this.f10598b != cVar.f10598b || !TextUtils.equals(this.f10599c, cVar.f10599c)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return ((((527 + this.f10597a) * 31) + this.f10598b) * 31) + this.f10599c.hashCode();
        }
    }

    public h(PreferenceGroup preferenceGroup) {
        this.f10588a = preferenceGroup;
        preferenceGroup.setOnPreferenceChangeInternalListener(this);
        this.f10589b = new ArrayList();
        this.f10590c = new ArrayList();
        this.f10591d = new ArrayList();
        if (preferenceGroup instanceof PreferenceScreen) {
            setHasStableIds(((PreferenceScreen) preferenceGroup).a());
        } else {
            setHasStableIds(true);
        }
        n();
    }

    @Override // androidx.preference.Preference.b
    public void a(Preference preference) {
        this.f10592e.removeCallbacks(this.f10593f);
        this.f10592e.post(this.f10593f);
    }

    @Override // androidx.preference.Preference.b
    public void c(Preference preference) {
        a(preference);
    }

    @Override // androidx.preference.PreferenceGroup.c
    public int d(Preference preference) {
        int size = this.f10590c.size();
        for (int i10 = 0; i10 < size; i10++) {
            Preference preference2 = this.f10590c.get(i10);
            if (preference2 != null && preference2.equals(preference)) {
                return i10;
            }
        }
        return -1;
    }

    @Override // androidx.preference.Preference.b
    public void e(Preference preference) {
        int indexOf = this.f10590c.indexOf(preference);
        if (indexOf != -1) {
            notifyItemChanged(indexOf, preference);
        }
    }

    @Override // androidx.preference.PreferenceGroup.c
    public int f(String str) {
        int size = this.f10590c.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (TextUtils.equals(str, this.f10590c.get(i10).getKey())) {
                return i10;
            }
        }
        return -1;
    }

    public final androidx.preference.b g(PreferenceGroup preferenceGroup, List<Preference> list) {
        androidx.preference.b bVar = new androidx.preference.b(preferenceGroup.getContext(), list, preferenceGroup.getId());
        bVar.setOnPreferenceClickListener(new b(preferenceGroup));
        return bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f10590c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i10) {
        if (!hasStableIds()) {
            return -1L;
        }
        return j(i10).getId();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i10) {
        c cVar = new c(j(i10));
        int indexOf = this.f10591d.indexOf(cVar);
        if (indexOf != -1) {
            return indexOf;
        }
        int size = this.f10591d.size();
        this.f10591d.add(cVar);
        return size;
    }

    public final List<Preference> h(PreferenceGroup preferenceGroup) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int preferenceCount = preferenceGroup.getPreferenceCount();
        int i10 = 0;
        for (int i11 = 0; i11 < preferenceCount; i11++) {
            Preference preference = preferenceGroup.getPreference(i11);
            if (preference.isVisible()) {
                if (k(preferenceGroup) && i10 >= preferenceGroup.getInitialExpandedChildrenCount()) {
                    arrayList2.add(preference);
                } else {
                    arrayList.add(preference);
                }
                if (!(preference instanceof PreferenceGroup)) {
                    i10++;
                } else {
                    PreferenceGroup preferenceGroup2 = (PreferenceGroup) preference;
                    if (!preferenceGroup2.isOnSameScreenAsChildren()) {
                        continue;
                    } else {
                        if (k(preferenceGroup) && k(preferenceGroup2)) {
                            throw new IllegalStateException("Nesting an expandable group inside of another expandable group is not supported!");
                        }
                        for (Preference preference2 : h(preferenceGroup2)) {
                            if (k(preferenceGroup) && i10 >= preferenceGroup.getInitialExpandedChildrenCount()) {
                                arrayList2.add(preference2);
                            } else {
                                arrayList.add(preference2);
                            }
                            i10++;
                        }
                    }
                }
            }
        }
        if (k(preferenceGroup) && i10 > preferenceGroup.getInitialExpandedChildrenCount()) {
            arrayList.add(g(preferenceGroup, arrayList2));
        }
        return arrayList;
    }

    public final void i(List<Preference> list, PreferenceGroup preferenceGroup) {
        preferenceGroup.sortPreferences();
        int preferenceCount = preferenceGroup.getPreferenceCount();
        for (int i10 = 0; i10 < preferenceCount; i10++) {
            Preference preference = preferenceGroup.getPreference(i10);
            list.add(preference);
            c cVar = new c(preference);
            if (!this.f10591d.contains(cVar)) {
                this.f10591d.add(cVar);
            }
            if (preference instanceof PreferenceGroup) {
                PreferenceGroup preferenceGroup2 = (PreferenceGroup) preference;
                if (preferenceGroup2.isOnSameScreenAsChildren()) {
                    i(list, preferenceGroup2);
                }
            }
            preference.setOnPreferenceChangeInternalListener(this);
        }
    }

    public Preference j(int i10) {
        if (i10 >= 0 && i10 < getItemCount()) {
            return this.f10590c.get(i10);
        }
        return null;
    }

    public final boolean k(PreferenceGroup preferenceGroup) {
        if (preferenceGroup.getInitialExpandedChildrenCount() != Integer.MAX_VALUE) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(l lVar, int i10) {
        Preference j10 = j(i10);
        lVar.h();
        j10.onBindViewHolder(lVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public l onCreateViewHolder(ViewGroup viewGroup, int i10) {
        c cVar = this.f10591d.get(i10);
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        TypedArray obtainStyledAttributes = viewGroup.getContext().obtainStyledAttributes((AttributeSet) null, s.f10710a);
        Drawable drawable = obtainStyledAttributes.getDrawable(s.f10713b);
        if (drawable == null) {
            drawable = C0991a.b(viewGroup.getContext(), R.drawable.list_selector_background);
        }
        obtainStyledAttributes.recycle();
        View inflate = from.inflate(cVar.f10597a, viewGroup, false);
        if (inflate.getBackground() == null) {
            K.n0(inflate, drawable);
        }
        ViewGroup viewGroup2 = (ViewGroup) inflate.findViewById(R.id.widget_frame);
        if (viewGroup2 != null) {
            int i11 = cVar.f10598b;
            if (i11 != 0) {
                from.inflate(i11, viewGroup2);
            } else {
                viewGroup2.setVisibility(8);
            }
        }
        return new l(inflate);
    }

    public void n() {
        Iterator<Preference> it = this.f10589b.iterator();
        while (it.hasNext()) {
            it.next().setOnPreferenceChangeInternalListener(null);
        }
        ArrayList arrayList = new ArrayList(this.f10589b.size());
        this.f10589b = arrayList;
        i(arrayList, this.f10588a);
        this.f10590c = h(this.f10588a);
        j preferenceManager = this.f10588a.getPreferenceManager();
        if (preferenceManager != null) {
            preferenceManager.i();
        }
        notifyDataSetChanged();
        Iterator<Preference> it2 = this.f10589b.iterator();
        while (it2.hasNext()) {
            it2.next().clearWasDetached();
        }
    }
}
