package com.oua.ocr.bc;

import com.oua.ocr.ContactInfo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

/* loaded from: classes4.dex */
public class libBCREngine {
    static Blacklist blacklist = new Blacklist();
    static Phone phone = new Phone();
    static Website website = new Website();
    static Email email = new Email();
    static Title title = new Title();
    static Company company = new Company();
    static Address address = new Address();
    static Name name = new Name();
    static HashSet<Integer> langSet = new HashSet<>();
    static com.google.gson.d gson = new com.google.gson.e().b();
    public static HashMap<String, Score> scores = new HashMap<>();

    @FunctionalInterface
    /* loaded from: classes4.dex */
    public interface FileLoader {
        String read(String str);
    }

    public static void calibrate_bcard(BCard bCard) {
        final ArrayList arrayList = new ArrayList();
        bCard.bboxes.forEach(new Consumer() { // from class: com.oua.ocr.bc.T
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                libBCREngine.lambda$calibrate_bcard$3(arrayList, (BBox) obj);
            }
        });
        arrayList.sort(Comparator.naturalOrder());
        Double valueOf = Double.valueOf(-Math.atan(((Double) arrayList.get(arrayList.size() / 2)).doubleValue()));
        bCard.rotation_angle = valueOf;
        final Double valueOf2 = Double.valueOf(Math.cos(valueOf.doubleValue()));
        final Double valueOf3 = Double.valueOf(Math.sin(bCard.rotation_angle.doubleValue()));
        bCard.bboxes.forEach(new Consumer() { // from class: com.oua.ocr.bc.U
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                libBCREngine.lambda$calibrate_bcard$4(valueOf2, valueOf3, (BBox) obj);
            }
        });
    }

    public static Boolean check_borders(int[][] iArr, int[][] iArr2, int i10) {
        float f10;
        int[] iArr3 = iArr2[0];
        int[] iArr4 = {iArr3[0], iArr3[1]};
        int[] iArr5 = iArr2[1];
        int[][] iArr6 = {iArr4, new int[]{iArr5[0], iArr5[1]}};
        if (i10 <= 2) {
            int[] iArr7 = iArr6[1];
            int i11 = iArr7[1];
            int[] iArr8 = iArr6[0];
            int i12 = iArr8[1];
            int i13 = (i11 - i12) / i10;
            iArr8[1] = i12 - i13;
            iArr7[1] = iArr7[1] + i13;
        }
        int max = Math.max(iArr[0][0], iArr6[0][0]);
        int max2 = Math.max(iArr[0][1], iArr6[0][1]);
        int min = Math.min(iArr[1][0], iArr6[1][0]);
        int min2 = Math.min(iArr[1][1], iArr6[1][1]);
        if (min >= max && min2 >= max2) {
            int i14 = (min - max) * (min2 - max2);
            int[] iArr9 = iArr[1];
            int i15 = iArr9[0];
            int[] iArr10 = iArr[0];
            int i16 = (i15 - iArr10[0]) * (iArr9[1] - iArr10[1]);
            int[] iArr11 = iArr6[1];
            int i17 = iArr11[0];
            int[] iArr12 = iArr6[0];
            int i18 = (i17 - iArr12[0]) * (iArr11[1] - iArr12[1]);
            if (i10 == 1) {
                f10 = 0.05f;
            } else if (i10 == 2) {
                f10 = 0.1f;
            } else {
                f10 = 0.7f;
            }
            if (i14 > f10 * Math.min(i16, i18)) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }
        return Boolean.FALSE;
    }

    public static void cluster_bcard(BCard bCard) {
        if (!langSet.contains(5) && !langSet.contains(6)) {
            if (langSet.contains(22)) {
                bCard.area_overlapping_ratio = 0.05f;
            } else {
                bCard.area_overlapping_ratio = 0.2f;
            }
        } else {
            bCard.area_overlapping_ratio = 0.85f;
        }
        calibrate_bcard(bCard);
        order_clusters(bCard);
        int i10 = 0;
        merge_and_split_bcard(bCard, 0);
        merge_and_split_bcard(bCard, 1);
        merge_and_split_bcard(bCard, 2);
        deduplication_clusters(bCard);
        insert_clusters(bCard);
        print_bcard(bCard);
        LogUtil.print2dInteger(bCard.clusters, "order_clusters");
        order_clusters(bCard);
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        Iterator<ArrayList<Integer>> it = bCard.clusters.iterator();
        while (it.hasNext()) {
            ArrayList<Integer> next = it.next();
            arrayList.add(new ArrayList<>());
            Iterator<Integer> it2 = next.iterator();
            while (it2.hasNext()) {
                bCard.bboxes.get(it2.next().intValue()).idx = i10;
                arrayList.get(arrayList.size() - 1).add(Integer.valueOf(i10));
                i10++;
            }
        }
        bCard.clusters = arrayList;
        bCard.bboxes.sort(new Comparator() { // from class: com.oua.ocr.bc.V
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int lambda$cluster_bcard$17;
                lambda$cluster_bcard$17 = libBCREngine.lambda$cluster_bcard$17((BBox) obj, (BBox) obj2);
                return lambda$cluster_bcard$17;
            }
        });
    }

    public static void deduplication_clusters(final BCard bCard) {
        ArrayList<ArrayList<Integer>> arrayList = bCard.clusters;
        final ArrayList<ArrayList<Integer>> arrayList2 = new ArrayList<>();
        arrayList.sort(new Comparator() { // from class: com.oua.ocr.bc.N
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int lambda$deduplication_clusters$8;
                lambda$deduplication_clusters$8 = libBCREngine.lambda$deduplication_clusters$8((ArrayList) obj, (ArrayList) obj2);
                return lambda$deduplication_clusters$8;
            }
        });
        final HashSet hashSet = new HashSet();
        arrayList.forEach(new Consumer() { // from class: com.oua.ocr.bc.O
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                libBCREngine.lambda$deduplication_clusters$9(arrayList2, hashSet, (ArrayList) obj);
            }
        });
        arrayList2.sort(new Comparator() { // from class: com.oua.ocr.bc.P
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int lambda$deduplication_clusters$10;
                lambda$deduplication_clusters$10 = libBCREngine.lambda$deduplication_clusters$10(BCard.this, (ArrayList) obj, (ArrayList) obj2);
                return lambda$deduplication_clusters$10;
            }
        });
        bCard.clusters = arrayList2;
    }

    private static void extractContactItems(final BCard bCard) {
        if (bCard.bboxes.size() == 0) {
            return;
        }
        cluster_bcard(bCard);
        bCard.bboxes.forEach(new Consumer() { // from class: com.oua.ocr.bc.E
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                libBCREngine.lambda$extractContactItems$20(BCard.this, (BBox) obj);
            }
        });
        phone.contains(bCard);
        email.contains(bCard);
        website.contains(bCard);
        title.contains(bCard);
        blacklist.contains(bCard);
        company.contains(bCard);
        address.contains(bCard);
        name.contains(bCard);
    }

    public static BCard getContactInfo(List<BBox> list) {
        return getContactInfo(list, 0, "");
    }

    public static String getLabel(int i10) {
        switch (i10) {
            case 1:
                return "Name\t:";
            case 2:
                return "Email\t:";
            case 3:
                return "Phone\t:";
            case 4:
                return "Company\t:";
            case 5:
                return "Address\t:";
            case 6:
                return "Website\t:";
            case 7:
                return "IM\t:";
            case 8:
                return "Event\t:";
            case 9:
                return "SNS\t:";
            case 10:
            default:
                return "";
            case 11:
                return "NickName\t:";
        }
    }

    public static int[][] get_border(ArrayList<Integer> arrayList, final BCard bCard) {
        final int[][] iArr = {new int[]{100000, 100000}, new int[]{0, 0}};
        arrayList.forEach(new Consumer() { // from class: com.oua.ocr.bc.G
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                libBCREngine.lambda$get_border$11(iArr, bCard, (Integer) obj);
            }
        });
        return iArr;
    }

    public static int get_element(ArrayList<ArrayList<Integer>> arrayList, int i10) {
        ArrayList<Integer> arrayList2 = arrayList.get(arrayList.size() - 1);
        if (i10 == 0) {
            return arrayList2.get(0).intValue();
        }
        return arrayList2.get(arrayList2.size() - 1).intValue();
    }

    public static void init(List<Integer> list) {
        init(list, new FileLoader() { // from class: com.oua.ocr.bc.A
            @Override // com.oua.ocr.bc.libBCREngine.FileLoader
            public final String read(String str) {
                String lambda$init$19;
                lambda$init$19 = libBCREngine.lambda$init$19(str);
                return lambda$init$19;
            }
        });
    }

    public static void insert_clusters(final BCard bCard) {
        final ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> arrayList2 = bCard.clusters;
        final ArrayList arrayList3 = new ArrayList();
        arrayList2.forEach(new Consumer() { // from class: com.oua.ocr.bc.M
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                libBCREngine.lambda$insert_clusters$12(BCard.this, arrayList, arrayList3, (ArrayList) obj);
            }
        });
        bCard.clusters = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$calibrate_bcard$3(ArrayList arrayList, BBox bBox) {
        int[][] iArr = bBox.f29375c;
        Double d10 = new Double(iArr[1][0] - iArr[0][0]);
        int[][] iArr2 = bBox.f29375c;
        arrayList.add(new Double(new Double(iArr2[1][1] - iArr2[0][1]).doubleValue() / (d10.doubleValue() + 1.0E-7d)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$calibrate_bcard$4(Double d10, Double d11, BBox bBox) {
        for (int i10 = 0; i10 < 4; i10++) {
            int[] iArr = bBox.f29375c[i10];
            double d12 = iArr[0];
            double d13 = iArr[1];
            iArr[0] = (int) ((d10.doubleValue() * d12) - (d11.doubleValue() * d13));
            bBox.f29375c[i10][1] = (int) ((d11.doubleValue() * d12) + (d10.doubleValue() * d13));
        }
        bBox.get_parameters();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$cluster_bcard$17(BBox bBox, BBox bBox2) {
        return bBox.idx - bBox2.idx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$deduplication_clusters$10(BCard bCard, ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList.size() != arrayList2.size()) {
            return arrayList2.size() - arrayList.size();
        }
        return bCard.bboxes.get(((Integer) arrayList.get(0)).intValue()).f29375c[0][0] - bCard.bboxes.get(((Integer) arrayList2.get(0)).intValue()).f29375c[0][0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$deduplication_clusters$8(ArrayList arrayList, ArrayList arrayList2) {
        return arrayList2.size() - arrayList.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$deduplication_clusters$9(ArrayList arrayList, HashSet hashSet, ArrayList arrayList2) {
        if (arrayList.size() == 0) {
            arrayList.add(arrayList2);
            hashSet.addAll(arrayList2);
            return;
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            if (!hashSet.contains(num)) {
                arrayList3.add(num);
            }
        }
        if (arrayList3.size() > 0) {
            arrayList.add(arrayList3);
            hashSet.addAll(arrayList3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$extractContactItems$20(BCard bCard, BBox bBox) {
        boolean z10;
        String str;
        String replace = bBox.text.replace("（", "(");
        bBox.text = replace;
        String replace2 = replace.replace("）", ")");
        bBox.text = replace2;
        String replace3 = replace2.replace("：", ":");
        bBox.text = replace3;
        String replace4 = replace3.replace("，", ",");
        bBox.text = replace4;
        bBox.text = replace4.replace("。", ".");
        bBox.lang = 11;
        Boolean bool = Boolean.TRUE;
        Boolean bool2 = Boolean.FALSE;
        String str2 = "";
        for (int i10 = 0; i10 < bBox.text.length(); i10++) {
            char charAt = bBox.text.charAt(i10);
            if (Regex.which_char(charAt) != 5 && Regex.which_char(charAt) != 22) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                bCard.lang = 5;
                bBox.lang = 5;
            }
            if (charAt < '0' || '9' < charAt) {
                bool = Boolean.FALSE;
            }
            if (charAt != ' ' || !bool2.booleanValue()) {
                if (charAt == ' ') {
                    bool2 = Boolean.TRUE;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    if (z10 || !bool2.booleanValue()) {
                        str = "";
                    } else {
                        str = " ";
                    }
                    sb.append(str);
                    sb.append(charAt);
                    str2 = sb.toString();
                    bool2 = Boolean.FALSE;
                }
            }
        }
        bBox.text = str2;
        if (bool.booleanValue()) {
            bBox.lang = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$get_border$11(int[][] iArr, BCard bCard, Integer num) {
        for (int i10 = 0; i10 < 4; i10++) {
            int[] iArr2 = iArr[0];
            iArr2[0] = Math.min(iArr2[0], bCard.bboxes.get(num.intValue()).f29375c[i10][0]);
            int[] iArr3 = iArr[0];
            iArr3[1] = Math.min(iArr3[1], bCard.bboxes.get(num.intValue()).f29375c[i10][1]);
            int[] iArr4 = iArr[1];
            iArr4[0] = Math.max(iArr4[0], bCard.bboxes.get(num.intValue()).f29375c[i10][0]);
            int[] iArr5 = iArr[1];
            iArr5[1] = Math.max(iArr5[1], bCard.bboxes.get(num.intValue()).f29375c[i10][1]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$init$19(String str) {
        return read_file("results/Database/" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$insert_clusters$12(BCard bCard, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3) {
        int[][] iArr = get_border(arrayList3, bCard);
        if (arrayList.size() == 0) {
            arrayList.add(arrayList3);
            arrayList2.add(iArr);
            return;
        }
        Boolean bool = Boolean.FALSE;
        int i10 = 0;
        while (true) {
            if (i10 >= arrayList.size()) {
                break;
            }
            if (check_borders((int[][]) arrayList2.get(i10), iArr, arrayList3.size()).booleanValue()) {
                ((ArrayList) arrayList.get(i10)).addAll(arrayList3);
                arrayList2.set(i10, get_border((ArrayList) arrayList.get(i10), bCard));
                bool = Boolean.TRUE;
                break;
            }
            i10++;
        }
        if (!bool.booleanValue()) {
            arrayList.add(arrayList3);
            arrayList2.add(iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$load_bcard$2(String str, int i10) {
        if (str.charAt(i10) == ',') {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$merge_and_split_bcard$7(BCard bCard, int i10, Integer num, Integer num2) {
        return (int) (bCard.bboxes.get(num.intValue()).centers[i10][0] - bCard.bboxes.get(num2.intValue()).centers[i10][0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$metrics$18(String str, BBox bBox) {
        HashSet hashSet = new HashSet();
        Iterator<String[]> it = bBox.fields.iterator();
        String str2 = "";
        while (it.hasNext()) {
            String[] next = it.next();
            if (next[0].indexOf("gt") == 0) {
                str2 = next[0].substring(2);
                if (str2.equals("Fax")) {
                    str2 = "Phone";
                }
                if (!str2.equals("")) {
                    if (!scores.containsKey(str2)) {
                        scores.put(str2, new Score(str2));
                    }
                    scores.get(str2).positive += 1.0f;
                }
                if (bBox.fields.size() == 1 && str2.equals(str)) {
                    Utils.FileWriter("results/false.txt", str2.substring(0, 2) + " -- " + bBox.text + "\n", Boolean.TRUE);
                }
            } else {
                String str3 = (next[0] + ".").split("\\.")[0];
                if (!hashSet.contains(str3)) {
                    hashSet.add(str3);
                    if (!scores.containsKey(str3)) {
                        scores.put(str3, new Score(str3));
                    }
                    if (str3.equals(str2)) {
                        scores.get(str3).tp += 1.0f;
                    } else {
                        scores.get(str3).fp += 1.0f;
                        if (str2.equals(str) || str3.equals(str)) {
                            Utils.FileWriter("results/false.txt", str2.substring(0, 2) + " " + str3.substring(0, 2) + " " + bBox.text + "\n", Boolean.TRUE);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$order_clusters$13(BCard bCard, Integer num, Integer num2) {
        return bCard.bboxes.get(num.intValue()).f29375c[0][1] - bCard.bboxes.get(num2.intValue()).f29375c[0][1];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$order_clusters$14(BCard bCard, Integer num, Integer num2) {
        return bCard.bboxes.get(num.intValue()).f29375c[0][0] - bCard.bboxes.get(num2.intValue()).f29375c[0][0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$order_clusters$15(BCard bCard, Integer num, Integer num2) {
        return bCard.bboxes.get(num.intValue()).f29375c[0][0] - bCard.bboxes.get(num2.intValue()).f29375c[0][0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$order_clusters$16(BCard bCard, ArrayList arrayList, ArrayList arrayList2) {
        return ((bCard.bboxes.get(((Integer) arrayList.get(0)).intValue()).f29375c[0][0] + bCard.bboxes.get(((Integer) arrayList.get(0)).intValue()).f29375c[0][1]) - bCard.bboxes.get(((Integer) arrayList2.get(0)).intValue()).f29375c[0][0]) - bCard.bboxes.get(((Integer) arrayList2.get(0)).intValue()).f29375c[0][1];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$print_bcard$0(String str, String[] strArr) {
        LogUtil.print(str + "[" + strArr[0] + ":" + strArr[1] + "]");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$print_bcard_results$1(String str, String[] strArr) {
        LogUtil.print(str + "[" + strArr[0] + ":" + strArr[1] + "]");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$split_bcard$5(BCard bCard, int i10, Integer num, Integer num2) {
        return (int) (bCard.bboxes.get(num.intValue()).centers[i10][1] - bCard.bboxes.get(num2.intValue()).centers[i10][1]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$split_bcard$6(final BCard bCard, final int i10, ArrayList arrayList, ArrayList arrayList2) {
        arrayList2.sort(new Comparator() { // from class: com.oua.ocr.bc.C
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int lambda$split_bcard$5;
                lambda$split_bcard$5 = libBCREngine.lambda$split_bcard$5(BCard.this, i10, (Integer) obj, (Integer) obj2);
                return lambda$split_bcard$5;
            }
        });
        for (int i11 = 0; i11 < arrayList2.size(); i11++) {
            Integer num = (Integer) arrayList2.get(i11);
            if (i11 == 0) {
                arrayList.add(new ArrayList(Arrays.asList(num)));
            } else {
                int i12 = get_element(arrayList, -1);
                if (Math.abs(bCard.bboxes.get(num.intValue()).centers[i10][1] - bCard.bboxes.get(i12).centers[i10][1]) > bCard.bboxes.get(i12).dims[1] * 1.5d) {
                    arrayList.add(new ArrayList(Arrays.asList(num)));
                } else {
                    ((ArrayList) arrayList.get(arrayList.size() - 1)).add(num);
                }
            }
        }
    }

    public static BCard load_bcard(String str) {
        Scanner scanner;
        int i10;
        try {
            scanner = new Scanner(new File(str));
        } catch (FileNotFoundException e10) {
            e10.printStackTrace();
            scanner = null;
        }
        String substring = str.substring(str.lastIndexOf(47) + 1);
        if (substring.indexOf("Danish") == 0) {
            init(new ArrayList(Arrays.asList(46)));
        } else if (substring.indexOf("Dutch") == 0) {
            init(new ArrayList(Arrays.asList(47)));
        } else if (substring.indexOf("Finnish") == 0) {
            init(new ArrayList(Arrays.asList(48)));
        } else if (substring.indexOf("French") == 0) {
            init(new ArrayList(Arrays.asList(49)));
        } else if (substring.indexOf("German") == 0) {
            init(new ArrayList(Arrays.asList(50)));
        } else if (substring.indexOf("Hungarian") == 0) {
            init(new ArrayList(Arrays.asList(61)));
        } else if (substring.indexOf("Italian") == 0) {
            init(new ArrayList(Arrays.asList(52)));
        } else if (substring.indexOf("Japan") == 0) {
            init(new ArrayList(Arrays.asList(22)));
        } else if (substring.indexOf("Korea") == 0) {
            init(new ArrayList(Arrays.asList(23)));
        } else if (substring.indexOf("Norwegian") == 0) {
            init(new ArrayList(Arrays.asList(53)));
        } else if (substring.indexOf("Portug") == 0) {
            init(new ArrayList(Arrays.asList(54)));
        } else if (substring.indexOf("Russian") == 0) {
            init(new ArrayList(Arrays.asList(59)));
        } else if (substring.indexOf("Spanish") == 0) {
            init(new ArrayList(Arrays.asList(55)));
        } else if (substring.indexOf("Swedish") == 0) {
            init(new ArrayList(Arrays.asList(56)));
        }
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        while (scanner.hasNextLine()) {
            final String nextLine = scanner.nextLine();
            if (2 > nextLine.length() || nextLine.length() >= 10) {
                if (langSet.size() == 0) {
                    init(new ArrayList(Arrays.asList(5, 6, 11)));
                }
                int[] array = IntStream.range(0, nextLine.length()).filter(new IntPredicate() { // from class: com.oua.ocr.bc.L
                    @Override // java.util.function.IntPredicate
                    public final boolean test(int i12) {
                        boolean lambda$load_bcard$2;
                        lambda$load_bcard$2 = libBCREngine.lambda$load_bcard$2(nextLine, i12);
                        return lambda$load_bcard$2;
                    }
                }).toArray();
                if (array.length < 9) {
                    LogUtil.println("Error: " + nextLine);
                    System.exit(0);
                }
                BBox bBox = new BBox();
                for (int i12 = 0; i12 < 4; i12++) {
                    for (int i13 = 0; i13 < 2; i13++) {
                        if (i12 == 0 && i13 == 0) {
                            i10 = 0;
                        } else {
                            i10 = array[((i12 * 2) + i13) - 1] + 1;
                        }
                        bBox.f29375c[i12][i13] = Integer.parseInt(nextLine.substring(i10, array[(i12 * 2) + i13]));
                    }
                }
                bBox.text = nextLine.substring(array[8] + 1);
                String substring2 = nextLine.substring(array[7] + 1, array[8]);
                if ('0' <= substring2.charAt(0) && substring2.charAt(0) <= '9') {
                    bBox.prop = Float.parseFloat(nextLine.substring(array[7] + 1, array[8]));
                } else {
                    bBox.prop = 1.0f;
                    if (substring2.equals("Nickname")) {
                        substring2 = "Name";
                    }
                    bBox.fields.add(new String[]{"gt" + substring2, bBox.text});
                }
                bBox.idx = i11;
                arrayList.add(bBox);
                i11++;
            }
        }
        return new BCard(arrayList, 0, str);
    }

    public static void main(String[] strArr) {
        if (strArr.length == 0) {
            test_gt("chinese");
        } else if (strArr[0].indexOf(".txt") == -1) {
            test_gt(strArr[0].toLowerCase());
        } else {
            new File("results/results_java_.txt").delete();
            print_bcard_results(process_bcard("results/results_java_.txt", strArr[0]));
        }
    }

    public static void merge_and_split_bcard(final BCard bCard, final int i10) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < bCard.bboxes.size(); i11++) {
            arrayList.add(new Integer(i11));
        }
        arrayList.sort(new Comparator() { // from class: com.oua.ocr.bc.D
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int lambda$merge_and_split_bcard$7;
                lambda$merge_and_split_bcard$7 = libBCREngine.lambda$merge_and_split_bcard$7(BCard.this, i10, (Integer) obj, (Integer) obj2);
                return lambda$merge_and_split_bcard$7;
            }
        });
        ArrayList<ArrayList<Integer>> arrayList2 = bCard.clusters;
        Iterator it = arrayList.iterator();
        char c10 = 65535;
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            if (arrayList2.size() != 0 && c10 != 65535) {
                int i12 = get_element(arrayList2, 0);
                if (Math.abs(bCard.bboxes.get(num.intValue()).centers[i10][0] - bCard.bboxes.get(i12).centers[i10][0]) > bCard.bboxes.get(i12).dims[1] * 0.8d) {
                    arrayList2.add(new ArrayList<>(Arrays.asList(num)));
                } else {
                    arrayList2.get(arrayList2.size() - 1).add(num);
                }
            } else {
                arrayList2.add(new ArrayList<>(Arrays.asList(num)));
                c10 = 0;
            }
        }
        split_bcard(bCard, i10);
    }

    public static void metrics(BCard bCard) {
        if (bCard.use_gt == 0) {
            return;
        }
        final String str = "Name";
        bCard.bboxes.forEach(new Consumer() { // from class: com.oua.ocr.bc.B
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                libBCREngine.lambda$metrics$18(str, (BBox) obj);
            }
        });
    }

    public static void order_clusters(final BCard bCard) {
        ArrayList<Integer> arrayList;
        float[][] fArr;
        ArrayList<Integer> arrayList2;
        float[][] fArr2;
        ArrayList<ArrayList<Integer>> arrayList3 = new ArrayList<>();
        ArrayList arrayList4 = new ArrayList();
        ArrayList<ArrayList<Integer>> arrayList5 = bCard.clusters;
        Boolean bool = Boolean.FALSE;
        int i10 = 0;
        if (arrayList5.size() == 0) {
            bool = Boolean.TRUE;
            arrayList5.add(new ArrayList<>());
            for (int i11 = 0; i11 < bCard.bboxes.size(); i11++) {
                arrayList5.get(0).add(Integer.valueOf(i11));
            }
        }
        int i12 = 0;
        while (i12 < arrayList5.size()) {
            ArrayList<Integer> arrayList6 = arrayList5.get(i12);
            arrayList6.sort(new Comparator() { // from class: com.oua.ocr.bc.H
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int lambda$order_clusters$13;
                    lambda$order_clusters$13 = libBCREngine.lambda$order_clusters$13(BCard.this, (Integer) obj, (Integer) obj2);
                    return lambda$order_clusters$13;
                }
            });
            int size = arrayList5.get(i12).size();
            int[] iArr = new int[2];
            char c10 = 1;
            iArr[1] = 2;
            iArr[i10] = size;
            float[][] fArr3 = (float[][]) Array.newInstance((Class<?>) Float.TYPE, iArr);
            float f10 = 100000.0f;
            int i13 = i10;
            float f11 = 0.0f;
            while (i13 < size) {
                int intValue = arrayList6.get(i13).intValue();
                fArr3[i13][i10] = bCard.bboxes.get(intValue).f29375c[i10][1];
                fArr3[i13][1] = bCard.bboxes.get(intValue).f29375c[3][1];
                f10 = Math.min(f10, fArr3[i13][0]);
                f11 = Math.max(f11, fArr3[i13][1]);
                i13++;
                i10 = 0;
            }
            int i14 = i10;
            while (i10 < size) {
                float[] fArr4 = fArr3[i10];
                float f12 = f11 - f10;
                fArr4[i14] = (fArr4[i14] - f10) / f12;
                fArr4[1] = (fArr4[1] - f10) / f12;
                i10++;
                i14 = 0;
            }
            ArrayList arrayList7 = new ArrayList();
            arrayList3.add(new ArrayList<>());
            float f13 = 0.0f;
            int i15 = 0;
            while (i15 < size) {
                float[] fArr5 = fArr3[i15];
                float f14 = fArr5[c10];
                float f15 = fArr5[0];
                int i16 = i15;
                float f16 = (float) ((f14 + f15) / 2.0d);
                float f17 = ((float) ((f14 - f15) / 2.0d)) * 0.6f;
                float f18 = f16 - f17;
                float f19 = f16 + f17;
                LogUtil.println("order_clusters: " + arrayList6.get(i16) + " | " + f18 + " | " + f19);
                if (arrayList7.size() == 0 || f18 <= f13) {
                    arrayList = arrayList6;
                    fArr = fArr3;
                    arrayList7.add(arrayList5.get(i12).get(i16));
                    f13 = Math.max(f13, f19);
                } else {
                    LogUtil.println("order_clusters: clist=" + arrayList7);
                    arrayList7.sort(new Comparator() { // from class: com.oua.ocr.bc.I
                        @Override // java.util.Comparator
                        public final int compare(Object obj, Object obj2) {
                            int lambda$order_clusters$14;
                            lambda$order_clusters$14 = libBCREngine.lambda$order_clusters$14(BCard.this, (Integer) obj, (Integer) obj2);
                            return lambda$order_clusters$14;
                        }
                    });
                    LogUtil.println("order_clusters: clist=" + arrayList7);
                    int i17 = 0;
                    int i18 = 0;
                    while (i17 < arrayList7.size()) {
                        int intValue2 = ((Integer) arrayList7.get(i17)).intValue();
                        if (i17 != 0) {
                            arrayList2 = arrayList6;
                            fArr2 = fArr3;
                            if (((BBox) arrayList4.get(i18)).addBack(bCard.bboxes.get(intValue2), bCard.area_overlapping_ratio).booleanValue()) {
                                i17++;
                                arrayList6 = arrayList2;
                                fArr3 = fArr2;
                            }
                        } else {
                            arrayList2 = arrayList6;
                            fArr2 = fArr3;
                        }
                        arrayList4.add(new BBox(bCard.bboxes.get(intValue2)));
                        arrayList3.get(i12).add(Integer.valueOf(arrayList4.size() - 1));
                        i18 = arrayList4.size() - 1;
                        i17++;
                        arrayList6 = arrayList2;
                        fArr3 = fArr2;
                    }
                    arrayList = arrayList6;
                    fArr = fArr3;
                    arrayList7.clear();
                    arrayList7.add(arrayList5.get(i12).get(i16));
                    f13 = f19;
                }
                if (i16 == size - 1) {
                    arrayList7.sort(new Comparator() { // from class: com.oua.ocr.bc.J
                        @Override // java.util.Comparator
                        public final int compare(Object obj, Object obj2) {
                            int lambda$order_clusters$15;
                            lambda$order_clusters$15 = libBCREngine.lambda$order_clusters$15(BCard.this, (Integer) obj, (Integer) obj2);
                            return lambda$order_clusters$15;
                        }
                    });
                    int i19 = 0;
                    for (int i20 = 0; i20 < arrayList7.size(); i20++) {
                        int intValue3 = ((Integer) arrayList7.get(i20)).intValue();
                        if (i20 == 0 || !((BBox) arrayList4.get(i19)).addBack(bCard.bboxes.get(intValue3), bCard.area_overlapping_ratio).booleanValue()) {
                            arrayList4.add(new BBox(bCard.bboxes.get(intValue3)));
                            arrayList3.get(i12).add(Integer.valueOf(arrayList4.size() - 1));
                            i19 = arrayList4.size() - 1;
                        }
                    }
                }
                c10 = 1;
                fArr3 = fArr;
                i15 = i16 + 1;
                arrayList6 = arrayList;
            }
            i12++;
            i10 = 0;
        }
        bCard.bboxes = arrayList4;
        arrayList3.sort(new Comparator() { // from class: com.oua.ocr.bc.K
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int lambda$order_clusters$16;
                lambda$order_clusters$16 = libBCREngine.lambda$order_clusters$16(BCard.this, (ArrayList) obj, (ArrayList) obj2);
                return lambda$order_clusters$16;
            }
        });
        if (bool.booleanValue()) {
            bCard.clusters = new ArrayList<>();
        } else {
            bCard.clusters = arrayList3;
        }
    }

    public static void print_bcard(BCard bCard) {
        final String str;
        LogUtil.println("\n\n>>>>>>>>>>>>>>>>>>>>>>> card.use_gt: " + bCard.use_gt);
        bCard.print_file_paths();
        LogUtil.println("Rotation_angle: " + bCard.rotation_angle);
        int i10 = 0;
        for (BBox bBox : bCard.bboxes) {
            LogUtil.print(i10 + "/" + bBox.idx + ": ");
            int i11 = 0;
            while (true) {
                str = "|";
                if (i11 >= 4) {
                    break;
                }
                for (int i12 = 0; i12 < 2; i12++) {
                    LogUtil.print("|" + bBox.f29375c[i11][i12]);
                }
                i11++;
            }
            LogUtil.print("|" + bBox.prop + "|" + bBox.dims[0] + "|" + bBox.dims[1] + "|");
            for (int i13 = 0; i13 < 3; i13++) {
                for (int i14 = 0; i14 < 2; i14++) {
                    LogUtil.print("|" + bBox.centers[i13][i14]);
                }
            }
            LogUtil.print("|" + bBox.text);
            bBox.fields.forEach(new Consumer() { // from class: com.oua.ocr.bc.F
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    libBCREngine.lambda$print_bcard$0(str, (String[]) obj);
                }
            });
            LogUtil.println("");
            i10++;
        }
        LogUtil.println("<<<<<<<<<<<<<<<<<<<<<<<");
    }

    public static void print_bcard_results(BCard bCard) {
        LogUtil.println("\n\n>>>>>>>>>>>>>>>>>>>>>>> card.use_gt: " + bCard.use_gt);
        bCard.print_file_paths();
        LogUtil.println("Rotation_angle: " + bCard.rotation_angle);
        int i10 = 0;
        for (BBox bBox : bCard.bboxes) {
            LogUtil.print(i10 + "/" + bBox.idx + ": ");
            StringBuilder sb = new StringBuilder();
            final String str = "";
            sb.append("");
            sb.append(bBox.text);
            sb.append(" ==> ");
            LogUtil.print(sb.toString());
            bBox.fields.forEach(new Consumer() { // from class: com.oua.ocr.bc.S
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    libBCREngine.lambda$print_bcard_results$1(str, (String[]) obj);
                }
            });
            LogUtil.println("");
            i10++;
        }
        LogUtil.println("<<<<<<<<<<<<<<<<<<<<<<<");
    }

    public static BCard process_bcard(String str, String str2) {
        BCard load_bcard = load_bcard(str2);
        BCard contactInfo = getContactInfo(load_bcard.bboxes, load_bcard.use_gt, load_bcard.file_path);
        save_ContactItem(str, contactInfo);
        return contactInfo;
    }

    public static String read_file(String str) {
        Scanner scanner;
        LogUtil.println("Loading from: " + str);
        try {
            scanner = new Scanner(new File(str));
        } catch (FileNotFoundException e10) {
            e10.printStackTrace();
            scanner = null;
        }
        String str2 = "";
        while (scanner.hasNextLine()) {
            str2 = str2 + scanner.nextLine();
        }
        return str2;
    }

    public static void save_ContactItem(String str, BCard bCard) {
        ArrayList<ContactInfo.ContactItem> arrayList = bCard.items;
        int size = arrayList.size();
        StringBuilder sb = new StringBuilder();
        sb.append("ImageName: \"" + bCard.file_path + "\"\n");
        if (size > 0) {
            Iterator<ContactInfo.ContactItem> it = arrayList.iterator();
            while (it.hasNext()) {
                ContactInfo.ContactItem next = it.next();
                int i10 = next.type;
                if (i10 == 4) {
                    ContactInfo.CompanyItem companyItem = (ContactInfo.CompanyItem) next;
                    sb.append(getLabel(next.type) + companyItem.getCompany() + "$" + companyItem.getDepartment() + "$" + companyItem.getTitle() + "\n");
                } else if (i10 == 1) {
                    ContactInfo.NameItem nameItem = (ContactInfo.NameItem) next;
                    sb.append(getLabel(next.type) + nameItem.getFirstName() + "$" + nameItem.getMiddleName() + "$" + nameItem.getLastName() + "\n");
                } else if (i10 == 5) {
                    ContactInfo.AddressItem addressItem = (ContactInfo.AddressItem) next;
                    sb.append(getLabel(next.type) + addressItem.getValue() + "$" + addressItem.getCountry() + "$" + addressItem.getProvince() + "$" + addressItem.getCity() + "$" + addressItem.getStreet() + "$" + addressItem.getPostCode() + "\n");
                } else {
                    sb.append(getLabel(next.type) + "$" + next.getSubType() + "$" + next.getValue() + "\n");
                }
            }
        }
        try {
            FileWriter fileWriter = new FileWriter(str, true);
            fileWriter.write(String.join("", sb));
            fileWriter.close();
        } catch (IOException e10) {
            LogUtil.println("An error occurred.");
            e10.printStackTrace();
        }
    }

    public static void split_bcard(final BCard bCard, final int i10) {
        ArrayList<ArrayList<Integer>> arrayList = bCard.clusters;
        final ArrayList<ArrayList<Integer>> arrayList2 = new ArrayList<>();
        arrayList.forEach(new Consumer() { // from class: com.oua.ocr.bc.Q
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                libBCREngine.lambda$split_bcard$6(BCard.this, i10, arrayList2, (ArrayList) obj);
            }
        });
        bCard.clusters = arrayList2;
    }

    public static void test_gt(String str) {
        int i10;
        long nanoTime = System.nanoTime();
        int i11 = 0;
        if (str.indexOf("chinese") >= 0) {
            new File("results/results_java.txt").delete();
            init(new ArrayList(Arrays.asList(5, 6, 11)));
            File[] listFiles = new File("/mnt/Data02/yuanlin/OCR/FieldExtraction/data/submit_lite").listFiles();
            int length = listFiles.length;
            i10 = 0;
            while (i11 < length) {
                String absolutePath = listFiles[i11].getAbsolutePath();
                if (absolutePath.indexOf("jpg.txt") != -1) {
                    metrics(process_bcard("results/results_java.txt", absolutePath));
                }
                i10--;
                if (i10 == 0) {
                    break;
                } else {
                    i11++;
                }
            }
            Score.get_score(scores);
        } else {
            new File("results/results_java_ml.txt").delete();
            File[] listFiles2 = new File("images/submit_lite/").listFiles();
            int length2 = listFiles2.length;
            int i12 = 0;
            while (i11 < length2) {
                String absolutePath2 = listFiles2[i11].getAbsolutePath();
                if (absolutePath2.indexOf(".txt") != -1 && absolutePath2.toLowerCase().indexOf(str) != -1) {
                    LogUtil.println(absolutePath2);
                    metrics(process_bcard("results/results_java_ml.txt", absolutePath2));
                    i12--;
                    if (i12 == 0) {
                        break;
                    }
                }
                i11++;
            }
            i10 = i12;
        }
        long nanoTime2 = ((System.nanoTime() - nanoTime) / 1000000) / Math.abs(i10);
        LogUtil.println("Total: " + Math.abs(i10));
        LogUtil.println("Duration: " + nanoTime2 + " ms");
    }

    public static BCard getContactInfo(List<BBox> list, int i10, String str) {
        BCard bCard = new BCard(list, i10, str);
        extractContactItems(bCard);
        return bCard;
    }

    public static void init(List<Integer> list, FileLoader fileLoader) {
        for (Integer num : list) {
            num.intValue();
            if (!langSet.contains(num)) {
                langSet.clear();
            }
        }
        if (langSet.size() > 0) {
            return;
        }
        list.add(11);
        Phone.init();
        Website.init();
        Email.init();
        Title.init();
        Company.init();
        Address.init();
        Name.init();
        LogUtil.println("langs => " + list);
        for (Integer num2 : list) {
            int intValue = num2.intValue();
            if (!langSet.contains(num2)) {
                if (intValue != 5 && intValue != 6) {
                    langSet.add(num2);
                } else {
                    langSet.add(6);
                    langSet.add(5);
                }
                String str = intValue == 5 ? "Database_Chinese.json" : "Database_";
                if (intValue == 6) {
                    str = str + "Chinese.json";
                }
                if (intValue == 11) {
                    str = str + "English.json";
                }
                if (intValue == 22) {
                    str = str + "Japanese.json";
                }
                if (intValue == 23) {
                    str = str + "Korean.json";
                }
                if (intValue == 46) {
                    str = str + "Danish.json";
                }
                if (intValue == 47) {
                    str = str + "Dutch.json";
                }
                if (intValue == 48) {
                    str = str + "Finnish.json";
                }
                if (intValue == 49) {
                    str = str + "French.json";
                }
                if (intValue == 50) {
                    str = str + "German.json";
                }
                if (intValue == 52) {
                    str = str + "Italian.json";
                }
                if (intValue == 53) {
                    str = str + "Norwegian.json";
                }
                if (intValue == 54) {
                    str = str + "Portuguese.json";
                }
                if (intValue == 55) {
                    str = str + "Spanish.json";
                }
                if (intValue == 56) {
                    str = str + "Swedish.json";
                }
                if (intValue == 59) {
                    str = str + "Russian.json";
                }
                if (intValue == 61) {
                    str = str + "Hungarian.json";
                }
                Info info = (Info) gson.j(fileLoader.read(str), Info.class);
                info.lang = intValue;
                Phone.update(info);
                Email.update(info);
                Website.update(info);
                Title.update(info);
                Company.update(info);
                Address.update(info);
                Name.update(info);
            }
        }
        Phone.compile(langSet);
        Email.compile(langSet);
        Website.compile(langSet);
        Title.compile(langSet);
        Company.compile(langSet);
        Address.compile(langSet);
        Name.compile(langSet);
        LogUtil.println("langSet => " + langSet);
    }
}
