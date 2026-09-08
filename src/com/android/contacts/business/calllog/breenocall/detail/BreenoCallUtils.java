package com.android.contacts.business.calllog.breenocall.detail;

import android.os.Bundle;
import android.os.Parcelable;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.business.calllog.breenocall.BreenoCallLogEntity;
import com.android.contacts.business.calllog.breenocall.NameInfo;
import com.android.contacts.business.calllog.breenocall.NoteInfo;
import com.android.contacts.business.calllog.breenocall.OrgInfo;
import com.android.contacts.business.calllog.breenocall.PersonalInfo;
import com.android.contacts.business.calllog.breenocall.TitleInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class BreenoCallUtils {
    private static final int MAX_NOTES_COUNT = 3;
    private static final String TAG = "BreenoCallUtils";

    public static void parseBreenoCallInfoForEditor(Bundle bundle, String str) {
        Parcelable parcelable;
        BreenoCallLogEntity breenoCallLogEntity;
        String str2;
        String str3 = null;
        try {
            parcelable = bundle.getParcelable(BreenoCallContract.IntentExtras.BREENO_CALL_INFO);
        } catch (Exception e10) {
            H7.b.c(TAG, "parseBreenoCallInfoForEditor: exception: " + e10);
            parcelable = null;
        }
        if (parcelable instanceof BreenoCallLogEntity) {
            breenoCallLogEntity = (BreenoCallLogEntity) parcelable;
        } else {
            breenoCallLogEntity = null;
        }
        if (breenoCallLogEntity != null) {
            breenoCallLogEntity.nomarlize();
            bundle.putString("phone", breenoCallLogEntity.getNumber());
            List<NameInfo> nameInfoList = breenoCallLogEntity.getNameInfoList();
            if (nameInfoList != null && !nameInfoList.isEmpty()) {
                bundle.putString("name", nameInfoList.get(0).getName());
            }
            PersonalInfo personalInfo = breenoCallLogEntity.getPersonalInfo();
            if (personalInfo != null) {
                List<OrgInfo> orgs = personalInfo.getOrgs();
                if (orgs != null && !orgs.isEmpty()) {
                    if (orgs.get(0) != null) {
                        str2 = orgs.get(0).getName();
                    } else {
                        str2 = null;
                    }
                    bundle.putString("company", str2);
                }
                List<TitleInfo> titles = personalInfo.getTitles();
                if (titles != null && !titles.isEmpty()) {
                    if (titles.get(0) != null) {
                        str3 = titles.get(0).getName();
                    }
                    bundle.putString("job_title", str3);
                }
            }
            List<NoteInfo> noteInfoList = breenoCallLogEntity.getNoteInfoList();
            if (noteInfoList != null && !noteInfoList.isEmpty()) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<NoteInfo> it = noteInfoList.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().getContent());
                    if (arrayList.size() >= 3) {
                        break;
                    }
                }
                bundle.putStringArrayList(str, arrayList);
            }
        }
    }
}
