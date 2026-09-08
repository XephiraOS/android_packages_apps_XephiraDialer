package com.oplus.blacklistapp.fragment;

import com.oplus.blacklistapp.fragment.i;
import com.oplus.utils.C0855p;

/* compiled from: ServiceBlackListFragment.java */
/* loaded from: classes3.dex */
public class r extends i {
    @Override // com.oplus.blacklistapp.fragment.i
    public void B2(i.l lVar) {
        if (this.f27141d == 1) {
            lVar.startQuery(51, null, C0855p.d.f29178a, C0855p.d.f29179b, "is_in_black = ? and source = ?", new String[]{String.valueOf(1), "chatbot"}, "list_type DESC ,_id DESC");
        }
    }

    @Override // com.oplus.blacklistapp.fragment.i
    public int Z1() {
        return 1;
    }
}
