package androidx.databinding;

import android.util.Log;
import android.view.View;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class MergedDataBinderMapper extends e {

    /* renamed from: a, reason: collision with root package name */
    public Set<Class<? extends e>> f9608a = new HashSet();

    /* renamed from: b, reason: collision with root package name */
    public List<e> f9609b = new CopyOnWriteArrayList();

    /* renamed from: c, reason: collision with root package name */
    public List<String> f9610c = new CopyOnWriteArrayList();

    /* JADX WARN: Multi-variable type inference failed */
    public void a(e eVar) {
        if (this.f9608a.add(eVar.getClass())) {
            this.f9609b.add(eVar);
            Iterator<e> it = eVar.collectDependencies().iterator();
            while (it.hasNext()) {
                a(it.next());
            }
        }
    }

    public final boolean b() {
        boolean z10 = false;
        for (String str : this.f9610c) {
            try {
                Class<?> cls = Class.forName(str);
                if (e.class.isAssignableFrom(cls)) {
                    a((e) cls.newInstance());
                    this.f9610c.remove(str);
                    z10 = true;
                }
            } catch (ClassNotFoundException unused) {
            } catch (IllegalAccessException e10) {
                Log.e("MergedDataBinderMapper", "unable to add feature mapper for " + str, e10);
            } catch (InstantiationException e11) {
                Log.e("MergedDataBinderMapper", "unable to add feature mapper for " + str, e11);
            }
        }
        return z10;
    }

    @Override // androidx.databinding.e
    public String convertBrIdToString(int i10) {
        Iterator<e> it = this.f9609b.iterator();
        while (it.hasNext()) {
            String convertBrIdToString = it.next().convertBrIdToString(i10);
            if (convertBrIdToString != null) {
                return convertBrIdToString;
            }
        }
        if (b()) {
            return convertBrIdToString(i10);
        }
        return null;
    }

    @Override // androidx.databinding.e
    public ViewDataBinding getDataBinder(f fVar, View view, int i10) {
        Iterator<e> it = this.f9609b.iterator();
        while (it.hasNext()) {
            ViewDataBinding dataBinder = it.next().getDataBinder(fVar, view, i10);
            if (dataBinder != null) {
                return dataBinder;
            }
        }
        if (b()) {
            return getDataBinder(fVar, view, i10);
        }
        return null;
    }

    @Override // androidx.databinding.e
    public int getLayoutId(String str) {
        Iterator<e> it = this.f9609b.iterator();
        while (it.hasNext()) {
            int layoutId = it.next().getLayoutId(str);
            if (layoutId != 0) {
                return layoutId;
            }
        }
        if (b()) {
            return getLayoutId(str);
        }
        return 0;
    }

    @Override // androidx.databinding.e
    public ViewDataBinding getDataBinder(f fVar, View[] viewArr, int i10) {
        Iterator<e> it = this.f9609b.iterator();
        while (it.hasNext()) {
            ViewDataBinding dataBinder = it.next().getDataBinder(fVar, viewArr, i10);
            if (dataBinder != null) {
                return dataBinder;
            }
        }
        if (b()) {
            return getDataBinder(fVar, viewArr, i10);
        }
        return null;
    }
}
