package P3;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import com.customize.contacts.activities.CommonTopTitlebarActivity;
import com.customize.contacts.model.IdRecord;

/* compiled from: ContactsSelectListener.java */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public c f2887a;

    /* renamed from: b, reason: collision with root package name */
    public Context f2888b;

    public b(c cVar, Context context) {
        this.f2887a = cVar;
        this.f2888b = context;
    }

    public void a(View view) {
        if (H7.a.b()) {
            H7.b.b("ContactsSelectListener", "v = " + view);
        }
        if (view != null && (view instanceof CheckBox)) {
            Object tag = view.getTag();
            if (H7.a.b()) {
                H7.b.b("ContactsSelectListener", "obj = " + tag);
            }
            if (tag instanceof IdRecord) {
                long b10 = ((IdRecord) tag).b();
                if (H7.a.b()) {
                    H7.b.b("ContactsSelectListener", "id = " + b10);
                }
                CheckBox checkBox = (CheckBox) view;
                boolean isChecked = checkBox.isChecked();
                checkBox.setChecked(!isChecked);
                c cVar = this.f2887a;
                if (cVar != null) {
                    cVar.E(b10, !isChecked);
                    if (this.f2888b instanceof CommonTopTitlebarActivity) {
                        if (((this.f2887a.g() == this.f2887a.h() && this.f2887a.h() != 0) || (this.f2887a.i() == this.f2887a.l() && this.f2887a.l() != 0)) && !((CommonTopTitlebarActivity) this.f2888b).Z1()) {
                            ((CommonTopTitlebarActivity) this.f2888b).f2(true);
                            ((CommonTopTitlebarActivity) this.f2888b).invalidateOptionsMenu();
                        }
                        if (this.f2887a.g() < this.f2887a.h() && ((CommonTopTitlebarActivity) this.f2888b).Z1()) {
                            ((CommonTopTitlebarActivity) this.f2888b).f2(false);
                            ((CommonTopTitlebarActivity) this.f2888b).invalidateOptionsMenu();
                        }
                    }
                }
            }
        }
    }

    public void b(View view, int i10) {
        if (H7.a.b()) {
            H7.b.b("ContactsSelectListener", "v = " + view);
        }
        if (view != null && (view instanceof CheckBox)) {
            Object tag = view.getTag();
            if (H7.a.b()) {
                H7.b.b("ContactsSelectListener", "obj = " + tag);
            }
            if (tag instanceof IdRecord) {
                long b10 = ((IdRecord) tag).b();
                if (H7.a.b()) {
                    H7.b.b("ContactsSelectListener", "id = " + b10);
                }
                CheckBox checkBox = (CheckBox) view;
                boolean isChecked = checkBox.isChecked();
                checkBox.setChecked(!isChecked);
                c cVar = this.f2887a;
                if (cVar != null) {
                    cVar.D(b10, i10, !isChecked);
                    if (this.f2888b instanceof CommonTopTitlebarActivity) {
                        if (((this.f2887a.g() == this.f2887a.h() && this.f2887a.h() != 0) || (this.f2887a.i() == this.f2887a.l() && this.f2887a.l() != 0)) && !((CommonTopTitlebarActivity) this.f2888b).Z1()) {
                            ((CommonTopTitlebarActivity) this.f2888b).f2(true);
                            ((CommonTopTitlebarActivity) this.f2888b).invalidateOptionsMenu();
                        }
                        if (this.f2887a.g() < this.f2887a.h() && ((CommonTopTitlebarActivity) this.f2888b).Z1()) {
                            ((CommonTopTitlebarActivity) this.f2888b).f2(false);
                            ((CommonTopTitlebarActivity) this.f2888b).invalidateOptionsMenu();
                        }
                    }
                }
            }
        }
    }

    public void c(View view, int i10) {
        if (H7.a.b()) {
            H7.b.b("ContactsSelectListener", "v = " + view);
        }
        if (view != null && (view instanceof CheckBox)) {
            Object tag = view.getTag();
            if (H7.a.b()) {
                H7.b.b("ContactsSelectListener", "obj = " + tag);
            }
            if (tag instanceof IdRecord) {
                long b10 = ((IdRecord) tag).b();
                if (H7.a.b()) {
                    H7.b.b("ContactsSelectListener", "id = " + b10);
                }
                boolean isChecked = ((CheckBox) view).isChecked();
                c cVar = this.f2887a;
                if (cVar != null) {
                    cVar.K(b10, i10, isChecked);
                    if (this.f2888b instanceof CommonTopTitlebarActivity) {
                        if (((this.f2887a.g() == this.f2887a.h() && this.f2887a.h() != 0) || (this.f2887a.i() == this.f2887a.l() && this.f2887a.l() != 0)) && !((CommonTopTitlebarActivity) this.f2888b).Z1()) {
                            ((CommonTopTitlebarActivity) this.f2888b).f2(true);
                            ((CommonTopTitlebarActivity) this.f2888b).invalidateOptionsMenu();
                        }
                        if (this.f2887a.g() < this.f2887a.h() && ((CommonTopTitlebarActivity) this.f2888b).Z1()) {
                            ((CommonTopTitlebarActivity) this.f2888b).f2(false);
                            ((CommonTopTitlebarActivity) this.f2888b).invalidateOptionsMenu();
                        }
                    }
                }
            }
        }
    }
}
