package z7;

import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: PolyphoneUtils.java */
/* loaded from: classes3.dex */
public class e0 {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f38358a = {19975, 20048, 20056, 20094, 20102, 20127, 20136, 20146, 20160, 20167, 20250, 20256, 20271, 20282, 20284, 20285, 20315, 20391, 20415, 20447, 20457, 20504, 20603, 20882, 20985, 21010, 21032, 21049, 21066, 21093, 21202, 21273, 21306, 21333, 21340, 21345, 21414, 21442, 21480, 21494, 21505, 21523, 21542, 21549, 21617, 21644, 21693, 22066, 22244, 22280, 22313, 22475, 22534, 22561, 22622, 22771, 22823, 22831, 23068, 23409, 23487, 23561, 23614, 23631, 23646, 24046, 24055, 24162, 24178, 24230, 24324, 24377, 24378, 24439, 24458, 24471, 24554, 24683, 24694, 25153, 25166, 25170, 25203, 25240, 25273, 25286, 25299, 25303, 25321, 25394, 25419, 25530, 25552, 25705, 25774, 25874, 25968, 26080, 26207, 26292, 26333, 26366, 26397, 26399, 26415, 26420, 26441, 26526, 26575, 26590, 26597, 26646, 26657, 26727, 26865, 27036, 27169, 27542, 27575, 27667, 27748, 27795, 27809, 27850, 27852, 27966, 27973, 28291, 28518, 28548, 28689, 28846, 28889, 29096, 29279, 29575, 30044, 30058, 30111, 30340, 30431, 30465, 30528, 30707, 30860, 31109, 31181, 31192, 31216, 31293, 31896, 31964, 32321, 32420, 32438, 32476, 32496, 32508, 32511, 32553, 32554, 32793, 32907, 32982, 33011, 33033, 33152, 33218, 33261, 33324, 33394, 33406, 33492, 33509, 33564, 33632, 33636, 33640, 33688, 33853, 33882, 33945, 34067, 34074, 34180, 34255, 34425, 34430, 34444, 34503, 34532, 34731, 34880, 34892, 34928, 35048, 35203, 35299, 35782, 35828, 35835, 35843, 35895, 35977, 36158, 36228, 36426, 36710, 36711, 36767, 36824, 36843, 37117, 37325, 38053, 38079, 38085, 38271, 38383, 38463, 38466, 38592, 38706, 38808, 39039, 39076, 39135, 39534, 39584, 39748, 40863};

    /* renamed from: b, reason: collision with root package name */
    public static final String[][] f38359b = {new String[]{"WAN", "MO"}, new String[]{"LE", "YUE"}, new String[]{"CHENG", "SHENG"}, new String[]{"GAN", "QIAN"}, new String[]{"LE", "LIAO"}, new String[]{"QI", "JI"}, new String[]{"HENG", "PENG"}, new String[]{"QIN", "QING"}, new String[]{"SHEN", "SHI"}, new String[]{"QIU", "CHOU"}, new String[]{"HUI", "KUAI"}, new String[]{"CHUAN", "ZHUAN"}, new String[]{"BO", "BAI"}, new String[]{"CI", "SI"}, new String[]{"SHI", "SI"}, new String[]{"QIE", "JIA", "GA"}, new String[]{"FO", "FU"}, new String[]{"CE", "ZE", "ZHAI"}, new String[]{"BIAN", "PIAN"}, new String[]{"QI", "SI"}, new String[]{"LIA", "LIANG"}, new String[]{"TANG", "CHANG"}, new String[]{"LO", "LV"}, new String[]{"MAO", "MO"}, new String[]{"AO", "WA"}, new String[]{"HUA", "HUAI"}, new String[]{"BAO", "PAO"}, new String[]{"CHA", "SHA"}, new String[]{"XUE", "XIAO"}, new String[]{"BO", "BAO"}, new String[]{"LE", "LEI"}, new String[]{"CHI", "SHI"}, new String[]{"OU", "QU"}, new String[]{"SHAN", "DAN", "CHAN"}, new String[]{"BO", "BU"}, new String[]{"KA", "QIA"}, new String[]{"SHA", "XIA"}, new String[]{"CAN", "SHEN", "CEN"}, new String[]{"DAO", "TAO"}, new String[]{"YE", "XIE"}, new String[]{"YU", "XU"}, new String[]{"XIA", "HE"}, new String[]{"FOU", "PI"}, new String[]{"HANG", "KENG"}, new String[]{"GUA", "GU"}, new String[]{"HE", "HUO"}, new String[]{"YAN", "YE"}, new String[]{"CHAO", "ZHAO"}, new String[]{"DUN", "TUN"}, new String[]{"QUAN", "JUAN"}, new String[]{"WEI", "XU"}, new String[]{"MAI", "MAN"}, new String[]{"DUI", "ZUI"}, new String[]{"BAO", "PU", "BU"}, new String[]{"SE", "SAI"}, new String[]{"KE", "QIAO"}, new String[]{"DA", "DAI"}, new String[]{"HANG", "BEN"}, new String[]{"NUO", "NA"}, new String[]{"CHAN", "CAN"}, new String[]{"XIU", "SU"}, new String[]{"WEI", "YU"}, new String[]{"WEI", "YI"}, new String[]{"BING", "PING"}, new String[]{"ZHU", "SHU"}, new String[]{"CHA", "CHAI"}, new String[]{"HANG", "XIANG"}, new String[]{"ZHUANG", "CHUANG"}, new String[]{"GAN", "QIAN"}, new String[]{"DUO", "DU"}, new String[]{"NONG", "LONG"}, new String[]{"DAN", "TAN"}, new String[]{"QIANG", "JIANG"}, new String[]{"FANG", "PANG"}, new String[]{"HUI", "HUAI"}, new String[]{"DE", "DEI"}, new String[]{"SONG", "ZHONG"}, new String[]{"DONG", "TONG"}, new String[]{"E", "WU"}, new String[]{"BIAN", "PIAN"}, new String[]{"ZHA", "ZA"}, new String[]{"BA", "PA"}, new String[]{"BAN", "PAN"}, new String[]{"ZHE", "SHE"}, new String[]{"MA", "MO"}, new String[]{"CHAI", "CA"}, new String[]{"TUO", "TA"}, new String[]{"AO", "NIU"}, new String[]{"ZE", "ZHAI"}, new String[]{"SUO", "SA", "SHA"}, new String[]{"LV", "LUO"}, new String[]{"CHAN", "CAN", "SHAN"}, new String[]{"DI", "TI"}, new String[]{"MO", "MA"}, new String[]{"CUO", "ZUO"}, new String[]{"CUAN", "ZAN"}, new String[]{"SHUO", "SHU"}, new String[]{"WU", "MO"}, new String[]{"CHENG", "SHENG"}, new String[]{"BAO", "PU"}, new String[]{"PU", "BAO"}, new String[]{"ZENG", "CENG"}, new String[]{"CHAO", "ZHAO"}, new String[]{"QI", "JI"}, new String[]{"SHU", "ZHU"}, new String[]{"PU", "PIAO", "PO"}, new String[]{"SHAN", "SHA"}, new String[]{"CONG", "ZONG"}, new String[]{"BAI", "BO"}, new String[]{"ZUO", "ZHA"}, new String[]{"ZHA", "CHA"}, new String[]{"QI", "XI"}, new String[]{"XIAO", "JIAO"}, new String[]{"GUI", "HUI"}, new String[]{"LENG", "LING"}, new String[]{"BANG", "PANG"}, new String[]{"MO", "MU"}, new String[]{"ZHI", "SHI"}, new String[]{"YAN", "YIN"}, new String[]{"MANG", "MENG"}, new String[]{"TANG", "SHANG"}, new String[]{"TA", "DA"}, new String[]{"MEI", "MO"}, new String[]{"PO", "BO"}, new String[]{"BI", "MI"}, new String[]{"PA", "PAI"}, new String[]{"QIAN", "JIAN"}, new String[]{"KUI", "HUI"}, new String[]{"LIAO", "LAO"}, new String[]{"CHENG", "DENG"}, new String[]{"PU", "BAO"}, new String[]{"PAO", "BAO"}, new String[]{"LAO", "LUO"}, new String[]{"YU", "YUN"}, new String[]{"MOU", "MU"}, new String[]{"SHUAI", "LV"}, new String[]{"CHU", "XU"}, new String[]{"FAN", "PAN"}, new String[]{"NVE", "YAO"}, new String[]{"DI", "DE"}, new String[]{"MENG", "MING"}, new String[]{"XING", "SHENG"}, new String[]{"ZHAO", "ZHUO"}, new String[]{"SHI", "DAN"}, new String[]{"LIU", "LU"}, new String[]{"CHAN", "SHAN"}, new String[]{"ZHONG", "CHONG"}, new String[]{"BI", "MI"}, new String[]{"CHEN", "CHENG"}, new String[]{"QI", "JI"}, new String[]{"ZHAN", "NIAN"}, new String[]{"MI", "MEI"}, new String[]{"FAN", "PO"}, new String[]{"XIAN", "QIAN"}, new String[]{"LUN", "GUAN"}, new String[]{"LUO", "LAO"}, new String[]{"CHAO", "CHUO"}, new String[]{"ZENG", "ZONG"}, new String[]{"LV", "LU"}, new String[]{"SUO", "SU"}, new String[]{"MOU", "MIU", "MIAO"}, new String[]{"BA", "PA"}, new String[]{"LEI", "LE"}, new String[]{"PANG", "PAN"}, new String[]{"GE", "GA"}, new String[]{"MAI", "MO"}, new String[]{"BANG", "PANG"}, new String[]{"BI", "BEI"}, new String[]{"CHOU", "XIU"}, new String[]{"BAN", "PAN", "BO"}, new String[]{"SE", "SHAI"}, new String[]{"AI", "YI"}, new String[]{"TAI", "TA"}, new String[]{"RUO", "RE"}, new String[]{"XI", "QIAN"}, new String[]{"QI", "JI"}, new String[]{"HUN", "XUN"}, new String[]{"QIAN", "XUN"}, new String[]{"SHEN", "XIN"}, new String[]{"LUO", "LA", "LAO"}, new String[]{"SHEN", "REN"}, new String[]{"MENG", "MIU"}, new String[]{"MAN", "WAN"}, new String[]{"YU", "WEI"}, new String[]{"BAO", "BO"}, new String[]{"CANG", "ZANG"}, new String[]{"HONG", "JIANG"}, new String[]{"HA", "XIA"}, new String[]{"BANG", "BENG"}, new String[]{"SHE", "YI"}, new String[]{"GE", "HA"}, new String[]{"SHI", "ZHE"}, new String[]{"XUE", "XIE"}, new String[]{"XING", "HANG", "HENG"}, new String[]{"SHUAI", "CUI"}, new String[]{"BI", "PI"}, new String[]{"QIN", "TAN", "XUN"}, new String[]{"XIE", "JIE"}, new String[]{"SHI", "ZHI"}, new String[]{"SHUO", "YUE", "SHUI", "TUO"}, new String[]{"DU", "DOU"}, new String[]{"DIAO", "TIAO"}, new String[]{"GU", "YU"}, new String[]{"HE", "HAO"}, new String[]{"GU", "JIA"}, new String[]{"QIE", "JU"}, new String[]{"QI", "XI"}, new String[]{"CHE", "JU"}, new String[]{"ZHA", "YA"}, new String[]{"BI", "PI"}, new String[]{"HAI", "HUAN"}, new String[]{"PAI", "PO"}, new String[]{"DOU", "DU"}, new String[]{"CHONG", "ZHONG"}, new String[]{"YAO", "YUE"}, new String[]{"DIAN", "TIAN"}, new String[]{"QIAN", "YAN"}, new String[]{"CHANG", "ZHANG"}, new String[]{"CHUANG"}, new String[]{"A", "E"}, new String[]{"BEI", "PI", "PO"}, new String[]{"QUE", "QIAO"}, new String[]{"LU", "LOU"}, new String[]{"QIAO", "SHAO"}, new String[]{"DUN", "DU"}, new String[]{"CHAN", "ZHAN"}, new String[]{"SHI", "SI", "YI"}, new String[]{"TUO", "DUO"}, new String[]{"BIAO", "PIAO"}, new String[]{"PO", "TUO", "BO"}, new String[]{"GUI", "JUN", "QIU"}};

    public static ArrayList<ArrayList<String>> a(ArrayList<ArrayList<String>> arrayList, ArrayList<String> arrayList2) {
        int size = arrayList.size();
        int size2 = arrayList2.size();
        ArrayList arrayList3 = new ArrayList(size);
        for (int i10 = 0; i10 < size; i10++) {
            arrayList3.add(new ArrayList());
            for (int i11 = 0; i11 < arrayList.get(i10).size(); i11++) {
                ((ArrayList) arrayList3.get(i10)).add(arrayList.get(i10).get(i11));
            }
        }
        int size3 = arrayList3.size();
        for (int i12 = 0; i12 < size2; i12++) {
            for (int i13 = 0; i13 < size3; i13++) {
                if (i12 > 0) {
                    arrayList.add(new ArrayList<>());
                }
                for (int i14 = 0; i12 > 0 && i14 < ((ArrayList) arrayList3.get(i13)).size(); i14++) {
                    arrayList.get((i12 * size3) + i13).add((String) ((ArrayList) arrayList3.get(i13)).get(i14));
                }
                arrayList.get((i12 * size3) + i13).add(arrayList2.get(i12));
            }
        }
        return arrayList;
    }

    public static ArrayList<ArrayList<String>> b(ArrayList<ArrayList<String>> arrayList) {
        int i10;
        if (arrayList != null && !arrayList.isEmpty()) {
            int i11 = 0;
            int i12 = 1;
            while (true) {
                if (i11 >= arrayList.size() || i11 >= 6) {
                    break;
                }
                i12 *= arrayList.get(i11).size();
                i11++;
            }
            ArrayList<ArrayList<String>> arrayList2 = new ArrayList<>(i12);
            for (int i13 = 0; i13 < arrayList.get(0).size(); i13++) {
                arrayList2.add(new ArrayList<>());
            }
            for (int i14 = 0; i14 < arrayList.get(0).size(); i14++) {
                arrayList2.get(i14).add(arrayList.get(0).get(i14));
            }
            for (int i15 = 1; i15 < arrayList.size() && i15 < 6; i15++) {
                arrayList2 = a(arrayList2, arrayList.get(i15));
            }
            if (arrayList.size() > 6) {
                for (i10 = 6; i10 < arrayList.size(); i10++) {
                    for (int i16 = 0; i16 < arrayList2.size(); i16++) {
                        arrayList2.get(i16).add(arrayList.get(i10).get(0));
                    }
                }
            }
            return arrayList2;
        }
        return null;
    }

    public static ArrayList<String> c(char c10) {
        int binarySearch = Arrays.binarySearch(f38358a, c10);
        ArrayList<String> arrayList = new ArrayList<>();
        if (binarySearch <= -1) {
            return null;
        }
        for (String str : f38359b[binarySearch]) {
            arrayList.add(str);
        }
        return arrayList;
    }

    public static ArrayList<String> d(char c10) {
        int binarySearch = Arrays.binarySearch(f38358a, c10);
        ArrayList<String> arrayList = new ArrayList<>();
        if (binarySearch <= -1) {
            return null;
        }
        for (String str : f38359b[binarySearch]) {
            arrayList.add(d0.a(str));
        }
        return arrayList;
    }
}
