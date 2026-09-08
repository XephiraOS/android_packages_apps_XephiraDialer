package com.oplus.blacklistapp.fragment;

import android.provider.BlockedNumberContract;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.oplus.blacklistapp.fragment.i;
import com.oplus.utils.C0844e;
import com.oplus.utils.C0855p;

/* compiled from: NormalBlackListFragment.java */
/* loaded from: classes3.dex */
public class q extends i {
    @Override // com.oplus.blacklistapp.fragment.i
    public void B2(i.l lVar) {
        if (this.f27141d == 1) {
            if (C0844e.f29134b) {
                lVar.startQuery(51, null, BlockedNumberContract.BlockedNumbers.CONTENT_URI, new String[]{BreenoCallContract.BaseColumns._ID, "e164_number", "original_number"}, null, null, "_id DESC");
                return;
            } else {
                lVar.startQuery(51, null, C0855p.a.f29171a, C0855p.a.f29174d, "list_type=? OR list_type =? ", new String[]{String.valueOf(1), "3"}, "list_type DESC ,_id DESC");
                return;
            }
        }
        lVar.startQuery(51, null, C0855p.a.f29171a, C0855p.a.f29174d, "list_type=?", new String[]{"2"}, "_id DESC");
    }

    @Override // com.oplus.blacklistapp.fragment.i
    public int Z1() {
        return 0;
    }
}
