package com.android.contacts.business.calllog.breenocall.statistics;

import android.content.Context;
import android.text.TextUtils;
import com.android.contacts.business.calllog.breenocall.BreenoCallLogEntity;
import com.android.contacts.business.calllog.breenocall.NameInfo;
import com.android.contacts.business.calllog.breenocall.NoteInfo;
import com.android.contacts.business.calllog.breenocall.OrgInfo;
import com.android.contacts.business.calllog.breenocall.PersonalInfo;
import com.android.contacts.business.calllog.breenocall.TitleInfo;
import com.android.contacts.framework.baseui.util.A;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: BreenoCallStatistics.kt */
/* loaded from: classes.dex */
public final class BreenoCallStatistics {
    public static final Companion Companion = new Companion(null);
    private static final boolean DEBUG = false;
    private static final int EVENT_ID_CREATE_CONTACT = 200032813;
    public static final int EVENT_ID_SUMMARY_TIP_CLICK = 200032614;
    private static final int EVENT_ID_TIP_CLICK = 200032613;
    public static final String KEY_CLICK_MODIFY_DATA = "click_modify_data";
    public static final String KEY_FILL_DATA = "fill_data";
    public static final String KEY_PERSONAL_MODIFY_DATA = "personal_modify_data";
    private static final String KEY_SAVE_OR_NOT = "save_or_not";
    private static final String KEY_TIP_CLICK = "click_item";
    private static final String LABEL_NAME = "name";
    private static final String LABEL_NOTE = "note";
    private static final String LABEL_ORG = "company";
    private static final String LABEL_TITLE = "position";
    private static final int LOG_TAG_CREATE_CONTACT = 2000310;
    private static final int LOG_TAG_TIP_CLICK = 2000309;
    private static final String SEPERATOR = ",";
    private static final String TAG = "BreenoCallStatistics";
    private static final String TIP_CLICK_CREATE = "create";
    private static final String TIP_CLICK_IGNORE = "ignore";
    private static final String VALUE_NO = "no";
    private static final String VALUE_YES = "yes";

    /* compiled from: BreenoCallStatistics.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public final void fillEditDataInfo(ArrayList<String> nameList, ArrayList<String> orgList, ArrayList<String> titleList, ArrayList<String> noteList, BreenoCallLogEntity breenoCallLogEntity, HashMap<String, String> map) {
            String str;
            String str2;
            String str3;
            List<OrgInfo> list;
            List<TitleInfo> list2;
            boolean A10;
            boolean A11;
            boolean A12;
            i.f(nameList, "nameList");
            i.f(orgList, "orgList");
            i.f(titleList, "titleList");
            i.f(noteList, "noteList");
            i.f(breenoCallLogEntity, "breenoCallLogEntity");
            i.f(map, "map");
            if (nameList.isEmpty()) {
                str = null;
            } else {
                str = nameList.get(0);
            }
            if (orgList.isEmpty()) {
                str2 = null;
            } else {
                str2 = orgList.get(0);
            }
            if (titleList.isEmpty()) {
                str3 = null;
            } else {
                str3 = titleList.get(0);
            }
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            List<NameInfo> nameInfoList = breenoCallLogEntity.getNameInfoList();
            List<NameInfo> list3 = nameInfoList;
            if (list3 != null && !list3.isEmpty()) {
                sb.append("name");
                sb.append(BreenoCallStatistics.SEPERATOR);
                if (TextUtils.isEmpty(str)) {
                    sb3.append("name");
                    sb3.append(BreenoCallStatistics.SEPERATOR);
                } else {
                    Iterator<NameInfo> it = nameInfoList.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (i.b(it.next().getName(), str)) {
                                sb2.append("name");
                                sb2.append(BreenoCallStatistics.SEPERATOR);
                                break;
                            }
                        } else {
                            sb3.append("name");
                            sb3.append(BreenoCallStatistics.SEPERATOR);
                            break;
                        }
                    }
                }
            } else if (!TextUtils.isEmpty(str)) {
                sb3.append("name");
                sb3.append(BreenoCallStatistics.SEPERATOR);
            }
            PersonalInfo personalInfo = breenoCallLogEntity.getPersonalInfo();
            if (personalInfo != null) {
                list = personalInfo.getOrgs();
            } else {
                list = null;
            }
            List<OrgInfo> list4 = list;
            if (list4 != null && !list4.isEmpty()) {
                sb.append(BreenoCallStatistics.LABEL_ORG);
                sb.append(BreenoCallStatistics.SEPERATOR);
                if (TextUtils.isEmpty(str2)) {
                    sb3.append(BreenoCallStatistics.LABEL_ORG);
                    sb3.append(BreenoCallStatistics.SEPERATOR);
                } else {
                    Iterator<OrgInfo> it2 = list.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (i.b(it2.next().getName(), str2)) {
                                sb2.append(BreenoCallStatistics.LABEL_ORG);
                                sb2.append(BreenoCallStatistics.SEPERATOR);
                                break;
                            }
                        } else {
                            sb3.append(BreenoCallStatistics.LABEL_ORG);
                            sb3.append(BreenoCallStatistics.SEPERATOR);
                            break;
                        }
                    }
                }
            } else if (!TextUtils.isEmpty(str2)) {
                sb3.append(BreenoCallStatistics.LABEL_ORG);
                sb3.append(BreenoCallStatistics.SEPERATOR);
            }
            PersonalInfo personalInfo2 = breenoCallLogEntity.getPersonalInfo();
            if (personalInfo2 != null) {
                list2 = personalInfo2.getTitles();
            } else {
                list2 = null;
            }
            List<TitleInfo> list5 = list2;
            if (list5 != null && !list5.isEmpty()) {
                sb.append(BreenoCallStatistics.LABEL_TITLE);
                sb.append(BreenoCallStatistics.SEPERATOR);
                if (TextUtils.isEmpty(str3)) {
                    sb3.append(BreenoCallStatistics.LABEL_TITLE);
                    sb3.append(BreenoCallStatistics.SEPERATOR);
                } else {
                    Iterator<TitleInfo> it3 = list2.iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            if (i.b(it3.next().getName(), str3)) {
                                sb2.append(BreenoCallStatistics.LABEL_TITLE);
                                sb2.append(BreenoCallStatistics.SEPERATOR);
                                break;
                            }
                        } else {
                            sb3.append(BreenoCallStatistics.LABEL_TITLE);
                            sb3.append(BreenoCallStatistics.SEPERATOR);
                            break;
                        }
                    }
                }
            } else if (!TextUtils.isEmpty(str3)) {
                sb3.append(BreenoCallStatistics.LABEL_TITLE);
                sb3.append(BreenoCallStatistics.SEPERATOR);
            }
            List<NoteInfo> noteInfoList = breenoCallLogEntity.getNoteInfoList();
            List<NoteInfo> list6 = noteInfoList;
            if (list6 != null && !list6.isEmpty()) {
                sb.append(BreenoCallStatistics.LABEL_NOTE);
                if (noteList.isEmpty()) {
                    sb3.append(BreenoCallStatistics.LABEL_NOTE);
                    sb3.append(BreenoCallStatistics.SEPERATOR);
                } else if (noteList.size() != noteInfoList.size()) {
                    sb3.append(BreenoCallStatistics.LABEL_NOTE);
                    sb3.append(BreenoCallStatistics.SEPERATOR);
                } else {
                    int size = noteList.size();
                    int i10 = 0;
                    while (true) {
                        if (i10 >= size) {
                            break;
                        }
                        if (!i.b(noteList.get(i10), noteInfoList.get(i10).getContent())) {
                            sb3.append(BreenoCallStatistics.LABEL_NOTE);
                            sb3.append(BreenoCallStatistics.SEPERATOR);
                            break;
                        }
                        i10++;
                    }
                }
            } else if (!noteList.isEmpty()) {
                sb3.append(BreenoCallStatistics.LABEL_NOTE);
                sb3.append(BreenoCallStatistics.SEPERATOR);
            }
            A10 = StringsKt__StringsKt.A(sb, BreenoCallStatistics.SEPERATOR, false, 2, null);
            if (A10) {
                sb.deleteCharAt(sb.length() - 1);
            }
            A11 = StringsKt__StringsKt.A(sb2, BreenoCallStatistics.SEPERATOR, false, 2, null);
            if (A11) {
                sb2.deleteCharAt(sb2.length() - 1);
            }
            A12 = StringsKt__StringsKt.A(sb3, BreenoCallStatistics.SEPERATOR, false, 2, null);
            if (A12) {
                sb3.deleteCharAt(sb3.length() - 1);
            }
            if (sb.length() > 0) {
                String sb4 = sb.toString();
                i.e(sb4, "fillData.toString()");
                map.put(BreenoCallStatistics.KEY_FILL_DATA, sb4);
            }
            if (sb2.length() > 0) {
                String sb5 = sb2.toString();
                i.e(sb5, "clickModifyData.toString()");
                map.put(BreenoCallStatistics.KEY_CLICK_MODIFY_DATA, sb5);
            }
            if (sb3.length() > 0) {
                String sb6 = sb3.toString();
                i.e(sb6, "personalModifyData.toString()");
                map.put(BreenoCallStatistics.KEY_PERSONAL_MODIFY_DATA, sb6);
            }
        }

        public final void trackEditorAction(Context context, boolean z10, ArrayList<String> names, ArrayList<String> orgs, ArrayList<String> titles, ArrayList<String> notes, BreenoCallLogEntity breenoCallLogEntity) {
            String str;
            i.f(context, "context");
            i.f(names, "names");
            i.f(orgs, "orgs");
            i.f(titles, "titles");
            i.f(notes, "notes");
            i.f(breenoCallLogEntity, "breenoCallLogEntity");
            if (z10) {
                str = BreenoCallStatistics.VALUE_YES;
            } else {
                str = BreenoCallStatistics.VALUE_NO;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(BreenoCallStatistics.KEY_SAVE_OR_NOT, str);
            fillEditDataInfo(names, orgs, titles, notes, breenoCallLogEntity, hashMap);
            A.a(context, BreenoCallStatistics.LOG_TAG_CREATE_CONTACT, BreenoCallStatistics.EVENT_ID_CREATE_CONTACT, hashMap, false);
        }

        public final void trackTipAction(Context context, boolean z10) {
            i.f(context, "context");
            trackTipAction(context, BreenoCallStatistics.EVENT_ID_TIP_CLICK, z10);
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final void trackTipAction(Context context, int i10, boolean z10) {
            i.f(context, "context");
            String str = z10 ? BreenoCallStatistics.TIP_CLICK_CREATE : BreenoCallStatistics.TIP_CLICK_IGNORE;
            HashMap hashMap = new HashMap();
            hashMap.put(BreenoCallStatistics.KEY_TIP_CLICK, str);
            A.a(context, BreenoCallStatistics.LOG_TAG_TIP_CLICK, i10, hashMap, false);
        }
    }

    public static final void fillEditDataInfo(ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3, ArrayList<String> arrayList4, BreenoCallLogEntity breenoCallLogEntity, HashMap<String, String> hashMap) {
        Companion.fillEditDataInfo(arrayList, arrayList2, arrayList3, arrayList4, breenoCallLogEntity, hashMap);
    }

    public static final void trackEditorAction(Context context, boolean z10, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3, ArrayList<String> arrayList4, BreenoCallLogEntity breenoCallLogEntity) {
        Companion.trackEditorAction(context, z10, arrayList, arrayList2, arrayList3, arrayList4, breenoCallLogEntity);
    }

    public static final void trackTipAction(Context context, int i10, boolean z10) {
        Companion.trackTipAction(context, i10, z10);
    }

    public static final void trackTipAction(Context context, boolean z10) {
        Companion.trackTipAction(context, z10);
    }
}
