package com.oua.ocr.bc;

import com.oua.ocr.ContactInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: libBCREngine.java */
/* loaded from: classes4.dex */
public class BCard {
    static Pattern re_Negative_names = Pattern.compile("(营销|中心|创始人)", 66);
    List<BBox> bboxes;
    String file_path;
    Double rotation_angle;
    int use_gt;
    ArrayList<ArrayList<Integer>> clusters = new ArrayList<>();
    float area_overlapping_ratio = 0.85f;
    String email = "";
    ArrayList<ContactInfo.ContactItem> items = new ArrayList<>();
    int lang = 11;
    HashSet<Integer> Title_idx = new HashSet<>();
    ArrayList<NamePod> name_cn = new ArrayList<>();
    ArrayList<NamePod> name_en = new ArrayList<>();

    public BCard(List<BBox> list, int i10, String str) {
        this.use_gt = 0;
        this.bboxes = new ArrayList();
        this.bboxes = list;
        this.use_gt = i10;
        this.file_path = str;
    }

    public void add_name(int i10, String str, float f10, String str2) {
        if (Regex.find_all(str, re_Negative_names).size() > 0) {
            return;
        }
        if (Regex.which_language0(str) == 11) {
            this.name_en.add(new NamePod(i10, str, f10, str2 + "_en", 11));
        } else {
            this.name_cn.add(new NamePod(i10, str, f10, str2 + "_cn", 5));
        }
        LogUtil.println("Name => idx: " + i10 + "; name: " + str + "; dist: " + f10 + "; condition: " + str2);
    }

    public float get_distance_to_title(int i10, int i11) {
        float[] fArr = this.bboxes.get(i10).centers[1];
        float[] fArr2 = this.bboxes.get(i11).centers[1];
        float f10 = this.bboxes.get(i11).dims[1];
        float f11 = (fArr[0] - fArr2[0]) / f10;
        float f12 = (fArr[1] - fArr2[1]) / f10;
        return ((f11 * f11) / 100.0f) + ((f12 * f12) / 289.0f);
    }

    public void print_file_paths() {
        LogUtil.println("'" + this.file_path + "'");
        String[] split = this.file_path.split("/");
        if (split.length >= 1) {
            String str = split[split.length - 1];
            if (str.length() >= 5) {
                LogUtil.println("'results/clusters/" + str.substring(0, str.length() - 4) + "'");
            }
        }
    }
}
