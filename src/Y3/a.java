package Y3;

import H7.b;
import android.content.Context;
import com.android.contacts.framework.baseui.util.A;
import com.android.contacts.framework.baseui.util.NumberIdentifyUtils;
import com.android.contacts.framework.baseui.util.s;
import com.oplus.settingstilelib.application.SwitchController;
import java.util.HashMap;

/* compiled from: SettingSwitchController.java */
/* loaded from: classes3.dex */
public class a extends SwitchController {

    /* renamed from: a, reason: collision with root package name */
    public Context f5539a = null;

    public void a(Context context) {
        this.f5539a = context;
    }

    public String getErrorMessage(boolean z10) {
        return null;
    }

    public SwitchController.MetaData getMetaData() {
        return new SwitchController.MetaData("com.oplus.settings.category.ia.strengthen_service");
    }

    public String getSwitchKey() {
        return "key_com_android_contacts_strengthen_service";
    }

    public boolean isChecked() {
        Context context = this.f5539a;
        if (context == null) {
            return false;
        }
        boolean e10 = NumberIdentifyUtils.e(context);
        b.e("SettingSwitchController", "isChecked(): checked = " + e10);
        return e10;
    }

    public boolean onCheckedChanged(boolean z10) {
        if (this.f5539a == null) {
            return false;
        }
        b.e("SettingSwitchController", "onCheckedChanged checked = " + z10);
        HashMap hashMap = new HashMap();
        hashMap.put("switch", String.valueOf(z10 ? 1 : 0));
        A.d(this.f5539a, 200034405, hashMap);
        s.j(this.f5539a, z10);
        return true;
    }
}
