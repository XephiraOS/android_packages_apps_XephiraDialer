package s1;

import android.database.Cursor;
import android.widget.CheckBox;
import com.android.contacts.voicemail.VisualVoicemailCallLogFragment;
import java.util.HashSet;
import s1.k;

/* compiled from: VoicemailActionModeHandler.java */
/* loaded from: classes.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    public VisualVoicemailCallLogFragment f36653a;

    /* renamed from: b, reason: collision with root package name */
    public Cursor f36654b;

    /* renamed from: f, reason: collision with root package name */
    public Z3.h f36658f;

    /* renamed from: c, reason: collision with root package name */
    public boolean f36655c = false;

    /* renamed from: g, reason: collision with root package name */
    public boolean f36659g = false;

    /* renamed from: d, reason: collision with root package name */
    public HashSet<String> f36656d = new HashSet<>();

    /* renamed from: e, reason: collision with root package name */
    public HashSet<String> f36657e = new HashSet<>();

    public m(VisualVoicemailCallLogFragment visualVoicemailCallLogFragment, Z3.h hVar) {
        this.f36653a = visualVoicemailCallLogFragment;
        this.f36658f = hVar;
    }

    public void a() {
        this.f36659g = true;
        this.f36658f.b();
        n();
    }

    public int b() {
        return this.f36656d.size();
    }

    public int c() {
        return this.f36653a.M1();
    }

    public HashSet<String> d() {
        return this.f36656d;
    }

    public HashSet<String> e() {
        return this.f36657e;
    }

    public final void f() {
        Cursor cursor = this.f36654b;
        if (cursor != null && !cursor.isClosed()) {
            try {
                int position = cursor.getPosition();
                cursor.moveToPosition(-1);
                while (cursor.moveToNext()) {
                    String string = cursor.getString(9);
                    if (string == null) {
                        string = cursor.getString(1);
                    }
                    int i10 = cursor.getInt(17);
                    this.f36656d.add(string);
                    if (i10 > 0) {
                        this.f36657e.add(string);
                    } else {
                        this.f36657e.remove(string);
                    }
                }
                cursor.moveToPosition(position);
            } catch (Exception e10) {
                H7.b.c("VoicemailActionModeHandler", "initMarkAllSelectedNumbers error " + e10);
            }
        }
    }

    public boolean g(String str) {
        return this.f36656d.contains(str);
    }

    public boolean h() {
        return this.f36659g;
    }

    public boolean i() {
        return this.f36655c;
    }

    public void j(CheckBox checkBox) {
        checkBox.setChecked(!checkBox.isChecked());
        k.d dVar = (k.d) checkBox.getTag();
        if (checkBox.isChecked()) {
            this.f36656d.add(dVar.f36645a);
            if (dVar.f36646b > 0) {
                this.f36657e.add(dVar.f36645a);
            }
        } else {
            this.f36656d.remove(dVar.f36645a);
            if (dVar.f36646b > 0) {
                this.f36657e.remove(dVar.f36645a);
            }
        }
        n();
    }

    public void k() {
        boolean z10 = !this.f36655c;
        this.f36655c = z10;
        if (z10) {
            f();
        } else {
            this.f36656d.clear();
            this.f36657e.clear();
        }
        n();
    }

    public void l() {
        this.f36659g = false;
        this.f36656d.clear();
        this.f36657e.clear();
        this.f36655c = false;
        this.f36658f.c();
    }

    public void m(Cursor cursor) {
        this.f36654b = cursor;
    }

    public final void n() {
        boolean z10;
        if (b() == c() && c() != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f36655c = z10;
        this.f36658f.d();
    }
}
