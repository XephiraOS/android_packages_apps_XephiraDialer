package com.customize.contacts.manager;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import com.customize.contacts.activities.CommonTopTitlebarActivity;
import com.customize.contacts.model.IdRecord;

/* compiled from: ContactsNumberSelectListener.java */
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public g f21538a;

    /* renamed from: b, reason: collision with root package name */
    public Context f21539b;

    public f(g gVar, Context context) {
        this.f21538a = gVar;
        this.f21539b = context;
    }

    public void a(View view) {
        if (H7.a.b()) {
            H7.b.b("ContactsNumberSelect", "v = " + view);
        }
        if (view != null && (view instanceof CheckBox)) {
            Object tag = view.getTag();
            if (H7.a.b()) {
                H7.b.b("ContactsNumberSelect", "obj = " + tag);
            }
            if (tag instanceof IdRecord) {
                IdRecord idRecord = (IdRecord) tag;
                long b10 = idRecord.b();
                if (H7.a.b()) {
                    H7.b.b("ContactsNumberSelect", "id = " + b10);
                }
                CheckBox checkBox = (CheckBox) view;
                boolean isChecked = checkBox.isChecked();
                checkBox.setChecked(!isChecked);
                g gVar = this.f21538a;
                if (gVar != null) {
                    gVar.k(b10, idRecord.getName(), idRecord.h(), !isChecked);
                    if (this.f21539b instanceof CommonTopTitlebarActivity) {
                        if (this.f21538a.e() == this.f21538a.c() && !((CommonTopTitlebarActivity) this.f21539b).Z1()) {
                            ((CommonTopTitlebarActivity) this.f21539b).f2(true);
                            ((CommonTopTitlebarActivity) this.f21539b).invalidateOptionsMenu();
                        }
                        if (this.f21538a.e() > this.f21538a.c() && ((CommonTopTitlebarActivity) this.f21539b).Z1()) {
                            ((CommonTopTitlebarActivity) this.f21539b).f2(false);
                            ((CommonTopTitlebarActivity) this.f21539b).invalidateOptionsMenu();
                            return;
                        }
                        return;
                    }
                    this.f21538a.o(!isChecked);
                }
            }
        }
    }

    public void b(View view) {
        if (H7.a.b()) {
            H7.b.b("ContactsNumberSelect", "v = " + view);
        }
        if (view != null && (view instanceof CheckBox)) {
            Object tag = view.getTag();
            if (H7.a.b()) {
                H7.b.b("ContactsNumberSelect", "obj = " + tag);
            }
            if (tag instanceof IdRecord) {
                IdRecord idRecord = (IdRecord) tag;
                long b10 = idRecord.b();
                if (H7.a.b()) {
                    H7.b.b("ContactsNumberSelect", "id = " + b10);
                }
                boolean isChecked = ((CheckBox) view).isChecked();
                g gVar = this.f21538a;
                if (gVar != null) {
                    gVar.m(b10, idRecord.getName(), idRecord.h(), isChecked);
                    if (this.f21539b instanceof CommonTopTitlebarActivity) {
                        if (this.f21538a.e() == this.f21538a.c() && !((CommonTopTitlebarActivity) this.f21539b).Z1()) {
                            ((CommonTopTitlebarActivity) this.f21539b).f2(true);
                            ((CommonTopTitlebarActivity) this.f21539b).invalidateOptionsMenu();
                        }
                        if (this.f21538a.e() > this.f21538a.c() && ((CommonTopTitlebarActivity) this.f21539b).Z1()) {
                            ((CommonTopTitlebarActivity) this.f21539b).f2(false);
                            ((CommonTopTitlebarActivity) this.f21539b).invalidateOptionsMenu();
                        }
                    }
                }
            }
        }
    }
}
