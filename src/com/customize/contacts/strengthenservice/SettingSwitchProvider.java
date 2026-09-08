package com.customize.contacts.strengthenservice;

import Y3.a;
import com.oplus.settingstilelib.application.SwitchController;
import com.oplus.settingstilelib.application.SwitchesProvider;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class SettingSwitchProvider extends SwitchesProvider {
    /* JADX WARN: Multi-variable type inference failed */
    public List<SwitchController> createSwitchControllers() {
        ArrayList arrayList = new ArrayList();
        a aVar = new a();
        aVar.a(getContext().getApplicationContext());
        arrayList.add(aVar);
        return arrayList;
    }
}
