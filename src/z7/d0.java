package z7;

import com.android.incallui.OplusPhoneUtils;
import java.util.HashMap;

/* compiled from: PinyinToZhuyin.java */
/* loaded from: classes3.dex */
public class d0 {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f38347a = {"a", "ai", "an", "ang", "ao", "ba", "bai", "ban", "bang", "bao", "bei", "ben", "beng", "bi", "bian", "biao", "bie", "bin", "bing", "bo", "bu", "ca", "cai", "can", "cang", "cao", "ce", "cen", "ceng", "cha", "chai", "chan", "chang", "chao", "che", "chen", "cheng", "chi", "chong", "chou", "chu", "chua", "chuai", "chuan", "chuang", "chui", "chun", "chuo", "ci", "cong", "cou", "cu", "cuan", "cui", "cun", "cuo", "da", "dai", "dan", "dang", "dao", "de", "dei", "den", "deng", "di", "dia", "dian", "diao", "die", "ding", "diu", "dong", "dou", "du", "duan", "dui", "dun", "duo", "e", "ei", "en", "eng", "er", "fa", "fan", "fang", "fei", "fen", "feng", "fiao", "fo", "fou", "fu", "ga", "gai", "gan", "gang", "gao", "ge", "gei", "gen", "geng", "gong", "gou", "gu", "gua", "guai", "guan", "guang", "gui", "gun", "guo"};

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f38348b = {"7", "8", "9", "9", "8", "17", "18", "19", "19", "18", "18", "19", "19", "10", "109", "108", "107", "19", "19", "17", "10", "67", "68", "69", "69", "68", "67", "69", "69", "57", "58", "59", "59", "58", "57", "59", "59", "5", "509", "58", "50", "507", "508", "509", "509", "508", "509", "507", "6", "609", "68", "60", "609", "608", "609", "607", "27", "28", "29", "29", "28", "27", "28", "29", "29", "20", "207", "209", "208", "207", "209", "208", "209", "28", "20", "209", "208", "209", "207", "7", "8", "9", "9", "9", "17", "19", "19", "18", "19", "19", "108", "17", "18", "10", "37", "38", "39", "39", "38", "37", "38", "39", "39", "309", "38", "30", "307", "308", "309", "309", "308", "309", "307"};

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f38349c = {"ha", "hai", "han", "hang", "hao", "he", "hei", "hen", "heng", "hm", "hong", "hou", "hu", "hua", "huai", "huan", "huang", "hui", "hun", "huo", "ji", "jia", "jian", "jiang", "jiao", "jie", "jin", "jing", "jiong", "jiu", "ju", "juan", "jue", "jun", "ka", "kai", "kan", "kang", "kao", "ke", "kei", "ken", "keng", "kong", "kou", "ku", "kua", "kuai", "kuan", "kuang", "kui", "kun", "kuo", "la", "lai", "lan", "lang", "lao", "le", "lei", "leng", "li", "lia", "lian", "liang", "liao", "lie", "lin", "ling", "liu", "long", "lou", "lu", "luan", "lue", "lun", "luo", "m", "ma", "mai", "man", "mang", "mao", "me", "mei", "men", "meng", "mi", "mian", "miao", "mie", "min", "ming", "miu", "mo", "mou", "mu", "na", "nai", "nan", "nang", "nao", "ne", "nei", "nen", "neng", "ni", "nian", "niang", "niao", "nie", "nin", "ning", "niu", "nong", "nou", "nu", "nuan", "nue", "nuo", "lve", "lv", "lvn", "lvan", "nia", "nv", "nve"};

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f38350d = {com.android.contacts.util.o.f17586f, "ou", "pa", "pai", "pan", "pang", "pao", "pei", "pen", "peng", "pi", "pian", "piao", "pie", "pin", "ping", "po", "pou", "pu", "qi", "qia", "qian", "qiang", "qiao", "qie", "qin", "qing", "qiong", "qiu", "qu", "quan", "que", "qun", "ran", "rang", "rao", "re", "ren", "reng", "ri", "rong", "rou", "ru", "ruan", "rui", "run", "ruo", "sa", "sai", "san", "sang", "sao", "se", "sen", "seng", "sha", "shai", "shan", "shang", "shao", "she", "shen", "sheng", "shi", "shou", "shu", "shua", "shuai", "shuan", "shuang", "shui", "shun", "shuo", "si", "song", "sou", "su", "suan", "sui", "sun", "suo", "ta", "tai", "tan", "tang", "tao", "te", "teng", "ti", "tian", "tiao", "tie", "ting", "tong", "tou", "tu", "tuan", "tui", "tun", "tuo", "sei", "shong", "shei"};

    /* renamed from: e, reason: collision with root package name */
    public static final String[] f38351e = {"wa", "wai", "wan", "wang", "wei", "wen", "weng", "wo", "wu", "xi", "xia", "xian", "xiang", "xiao", "xie", "xin", "xing", "xiong", "xiu", "xu", "xuan", "xue", "xun", "ya", "yan", "yang", "yao", "ye", "yi", "yin", "ying", "yo", "yong", "you", "yu", "yuan", "yue", "yun", "za", "zai", "zan", "zang", "zao", "ze", "zei", "zen", "zeng", "zha", "zhai", "zhan", "zhang", "zhao", "zhe", "zhen", "zheng", "zhi", "zhong", "zhou", "zhu", "zhua", "zhuai", "zhuan", "zhuang", "zhui", "zhun", "zhuo", "zi", "zong", "zou", "zu", "zuan", "zui", "zun", "zuo", "yai", "zhei"};

    /* renamed from: f, reason: collision with root package name */
    public static final String[] f38352f = {"07", "08", "09", "09", "08", "09", "09", "07", OplusPhoneUtils.DeviceState.UNLOCK_DEVICE, "40", "407", "409", "409", "408", "407", "409", "409", "409", "408", "40", "409", "407", "409", "07", "09", "09", "08", "07", OplusPhoneUtils.DeviceState.UNLOCK_DEVICE, "09", "09", "07", "09", "08", OplusPhoneUtils.DeviceState.UNLOCK_DEVICE, "09", "07", "09", "67", "68", "69", "69", "68", "67", "68", "69", "69", "57", "58", "59", "59", "58", "57", "59", "59", "5", "509", "58", "50", "507", "508", "509", "509", "508", "509", "507", "60", "609", "68", "60", "609", "608", "609", "607", "08", "58"};

    /* renamed from: g, reason: collision with root package name */
    public static final String[] f38353g = {"37", "38", "39", "39", "38", "37", "38", "39", "39", "31", "309", "38", "30", "307", "308", "309", "309", "308", "309", "307", "40", "407", "409", "409", "408", "407", "409", "409", "409", "408", "40", "409", "407", "409", "37", "38", "39", "39", "38", "37", ",38", "39", "39", "309", "38", "30", "307", "308", "309", "309", "308", "309", "307", "27", "28", "29", "29", "28", "27", "28", "29", "20", "207", "209", "209", "208", "207", "209", "209", "208", "209", "28", "20", "209", "207", "209", "207", OplusPhoneUtils.DeviceState.LOCK_DEVICE, "17", "18", "19", "19", "18", "17", "18", "19", "19", "10", "109", "108", "107", "109", "109", "108", "17", "18", "10", "27", "28", "29", "29", "28", "27", "28", "29", "29", "20", "209", "209", "208", "207", "209", "209", "208", "209", "28", "20", "209", "207", "207", "207", "20", "209", "209", "207", "20", "207"};

    /* renamed from: h, reason: collision with root package name */
    public static final String[] f38354h = {"7", "8", "17", "18", "19", "19", "18", "18", "19", "19", "10", "109", "108", "107", "109", "109", "17", "18", "10", "40", "407", "409", "409", "408", "407", "409", "409", "409", "408", "40", "409", "407", "409", "59", "59", "58", "57", "59", "59", "50", "509", "58", "50", "509", "508", "509", "507", "67", "68", "69", "69", "68", "67", "69", "69", "57", "58", "59", "59", "58", "57", "59", "59", "5", "58", "50", "507", "508", "509", "509", "508", "509", "507", "6", "609", "68", "60", "609", "608", "609", "607", "27", "28", "29", "29", "28", "27", "29", "20", "209", "208", "207", "209", "209", "28", "20", "209", "208", "209", "207", "68", "509", "58"};

    /* renamed from: i, reason: collision with root package name */
    public static final String[][] f38355i = {new String[]{"a", "ㄚ"}, new String[]{"ai", "ㄞ"}, new String[]{"an", "ㄢ"}, new String[]{"ang", "ㄤ"}, new String[]{"ao", "ㄠ"}, new String[]{"au", "ㄠ"}, new String[]{"ba", "ㄅㄚ"}, new String[]{"bai", "ㄅㄞ"}, new String[]{"ban", "ㄅㄢ"}, new String[]{"bang", "ㄅㄤ"}, new String[]{"bao", "ㄅㄠ"}, new String[]{"bei", "ㄅㄟ"}, new String[]{"ben", "ㄅㄣ"}, new String[]{"beng", "ㄅㄥ"}, new String[]{"bi", "ㄅㄧ"}, new String[]{"bian", "ㄅㄧㄢ"}, new String[]{"biao", "ㄅㄧㄠ"}, new String[]{"bie", "ㄅㄧㄝ"}, new String[]{"bin", "ㄅㄧㄣ"}, new String[]{"bing", "ㄅㄧㄥ"}, new String[]{"bo", "ㄅㄛ"}, new String[]{"bu", "ㄅㄨ"}, new String[]{"bun", "ㄅㄨㄣ"}, new String[]{"ca", "ㄘㄚ"}, new String[]{"cai", "ㄘㄞ"}, new String[]{"can", "ㄘㄢ"}, new String[]{"cang", "ㄘㄤ"}, new String[]{"cao", "ㄘㄠ"}, new String[]{"ce", "ㄘㄜ"}, new String[]{"cen", "ㄘㄣ"}, new String[]{"ceng", "ㄘㄥ"}, new String[]{"cha", "ㄔㄚ"}, new String[]{"chai", "ㄔㄞ"}, new String[]{"chan", "ㄔㄢ"}, new String[]{"chang", "ㄔㄤ"}, new String[]{"chao", "ㄔㄠ"}, new String[]{"che", "ㄔㄜ"}, new String[]{"chen", "ㄔㄣ"}, new String[]{"cheng", "ㄔㄥ"}, new String[]{"chi", "ㄔ"}, new String[]{"chong", "ㄔㄨㄥ"}, new String[]{"chou", "ㄔㄡ"}, new String[]{"chu", "ㄔㄨ"}, new String[]{"chua", "ㄔㄨㄚ"}, new String[]{"chuai", "ㄔㄨㄞ"}, new String[]{"chuan", "ㄔㄨㄢ"}, new String[]{"chuang", "ㄔㄨㄤ"}, new String[]{"chui", "ㄔㄨㄟ"}, new String[]{"chun", "ㄔㄨㄣ"}, new String[]{"chuo", "ㄔㄨㄛ"}, new String[]{"ci", "ㄘ"}, new String[]{"cong", "ㄘㄨㄥ"}, new String[]{"cou", "ㄘㄡ"}, new String[]{"cu", "ㄘㄨ"}, new String[]{"cuan", "ㄘㄨㄢ"}, new String[]{"cui", "ㄘㄨㄟ"}, new String[]{"cun", "ㄘㄨㄣ"}, new String[]{"cuo", "ㄘㄨㄛ"}, new String[]{"da", "ㄉㄚ"}, new String[]{"dai", "ㄉㄞ"}, new String[]{"dan", "ㄉㄢ"}, new String[]{"dang", "ㄉㄤ"}, new String[]{"dao", "ㄉㄠ"}, new String[]{"de", "ㄉㄜ"}, new String[]{"dei", "ㄉㄟ"}, new String[]{"den", "ㄉㄣ"}, new String[]{"deng", "ㄉㄥ"}, new String[]{"di", "ㄉㄧ"}, new String[]{"dia", "ㄉㄧㄚ"}, new String[]{"dian", "ㄉㄧㄢ"}, new String[]{"diang", "ㄉㄧㄤ"}, new String[]{"diao", "ㄉㄧㄠ"}, new String[]{"die", "ㄉㄧㄝ"}, new String[]{"din", "ㄉㄧㄣ"}, new String[]{"ding", "ㄉㄧㄥ"}, new String[]{"diu", "ㄉㄧㄡ"}, new String[]{"dong", "ㄉㄨㄥ"}, new String[]{"dou", "ㄉㄡ"}, new String[]{"du", "ㄉㄨ"}, new String[]{"duan", "ㄉㄨㄢ"}, new String[]{"dui", "ㄉㄨㄟ"}, new String[]{"dun", "ㄉㄨㄣ"}, new String[]{"duo", "ㄉㄨㄛ"}, new String[]{"e", "ㄜ"}, new String[]{"ea", "ㄝ"}, new String[]{"eh", "ㄝ"}, new String[]{"ei", "ㄟ"}, new String[]{"en", "ㄣ"}, new String[]{"eng", "ㄥ"}, new String[]{"er", "ㄦ"}, new String[]{"fa", "ㄈㄚ"}, new String[]{"fan", "ㄈㄢ"}, new String[]{"fang", "ㄈㄤ"}, new String[]{"fei", "ㄈㄟ"}, new String[]{"fen", "ㄈㄣ"}, new String[]{"feng", "ㄈㄥ"}, new String[]{"fiao", "ㄈㄧㄠ"}, new String[]{"fo", "ㄈㄛ"}, new String[]{"fou", "ㄈㄡ"}, new String[]{"fu", "ㄈㄨ"}, new String[]{"ga", "ㄍㄚ"}, new String[]{"gai", "ㄍㄞ"}, new String[]{"gan", "ㄍㄢ"}, new String[]{"gang", "ㄍㄤ"}, new String[]{"gao", "ㄍㄠ"}, new String[]{"ge", "ㄍㄜ"}, new String[]{"gei", "ㄍㄟ"}, new String[]{"gen", "ㄍㄣ"}, new String[]{"geng", "ㄍㄥ"}, new String[]{"gi", "ㄍㄧ"}, new String[]{"gong", "ㄍㄨㄥ"}, new String[]{"gou", "ㄍㄡ"}, new String[]{"gu", "ㄍㄨ"}, new String[]{"gua", "ㄍㄨㄚ"}, new String[]{"guai", "ㄍㄨㄞ"}, new String[]{"guan", "ㄍㄨㄢ"}, new String[]{"guang", "ㄍㄨㄤ"}, new String[]{"gui", "ㄍㄨㄟ"}, new String[]{"gun", "ㄍㄨㄣ"}, new String[]{"guo", "ㄍㄨㄛ"}, new String[]{"ha", "ㄏㄚ"}, new String[]{"hai", "ㄏㄞ"}, new String[]{"han", "ㄏㄢ"}, new String[]{"hang", "ㄏㄤ"}, new String[]{"hao", "ㄏㄠ"}, new String[]{"he", "ㄏㄜ"}, new String[]{"hei", "ㄏㄟ"}, new String[]{"hen", "ㄏㄣ"}, new String[]{"heng", "ㄏㄥ"}, new String[]{"hm", "ㄏㄇ"}, new String[]{"ho", "ㄏㄛ"}, new String[]{"hong", "ㄏㄨㄥ"}, new String[]{"hou", "ㄏㄡ"}, new String[]{"hu", "ㄏㄨ"}, new String[]{"hua", "ㄏㄨㄚ"}, new String[]{"huai", "ㄏㄨㄞ"}, new String[]{"huan", "ㄏㄨㄢ"}, new String[]{"huang", "ㄏㄨㄤ"}, new String[]{"hui", "ㄏㄨㄟ"}, new String[]{"hun", "ㄏㄨㄣ"}, new String[]{"huo", "ㄏㄨㄛ"}, new String[]{"i", "ㄧ"}, new String[]{"iu", "ㄩ"}, new String[]{"ji", "ㄐㄧ"}, new String[]{"jia", "ㄐㄧㄚ"}, new String[]{"jian", "ㄐㄧㄢ"}, new String[]{"jiang", "ㄐㄧㄤ"}, new String[]{"jiao", "ㄐㄧㄠ"}, new String[]{"jie", "ㄐㄧㄝ"}, new String[]{"jin", "ㄐㄧㄣ"}, new String[]{"jing", "ㄐㄧㄥ"}, new String[]{"jiong", "ㄐㄩㄥ"}, new String[]{"jiu", "ㄐㄧㄡ"}, new String[]{"ju", "ㄐㄩ"}, new String[]{"juan", "ㄐㄩㄢ"}, new String[]{"jue", "ㄐㄩㄝ"}, new String[]{"jun", "ㄐㄩㄣ"}, new String[]{"ka", "ㄎㄚ"}, new String[]{"kai", "ㄎㄞ"}, new String[]{"kan", "ㄎㄢ"}, new String[]{"kang", "ㄎㄤ"}, new String[]{"kao", "ㄎㄠ"}, new String[]{"ke", "ㄎㄜ"}, new String[]{"ken", "ㄎㄣ"}, new String[]{"keng", "ㄎㄥ"}, new String[]{"kong", "ㄎㄨㄥ"}, new String[]{"kou", "ㄎㄡ"}, new String[]{"ku", "ㄎㄨ"}, new String[]{"kua", "ㄎㄨㄚ"}, new String[]{"kuai", "ㄎㄨㄞ"}, new String[]{"kuan", "ㄎㄨㄢ"}, new String[]{"kuang", "ㄎㄨㄤ"}, new String[]{"kui", "ㄎㄨㄟ"}, new String[]{"kun", "ㄎㄨㄣ"}, new String[]{"kuo", "ㄎㄨㄛ"}, new String[]{"la", "ㄌㄚ"}, new String[]{"lai", "ㄌㄞ"}, new String[]{"lan", "ㄌㄢ"}, new String[]{"lang", "ㄌㄤ"}, new String[]{"lao", "ㄌㄠ"}, new String[]{"le", "ㄌㄜ"}, new String[]{"lei", "ㄌㄟ"}, new String[]{"leng", "ㄌㄥ"}, new String[]{"li", "ㄌㄧ"}, new String[]{"lia", "ㄌㄧㄚ"}, new String[]{"lian", "ㄌㄧㄢ"}, new String[]{"liang", "ㄌㄧㄤ"}, new String[]{"liao", "ㄌㄧㄠ"}, new String[]{"lie", "ㄌㄧㄝ"}, new String[]{"lin", "ㄌㄧㄣ"}, new String[]{"ling", "ㄌㄧㄥ"}, new String[]{"liu", "ㄌㄧㄡ"}, new String[]{"lo", "ㄌㄛ"}, new String[]{"long", "ㄌㄨㄥ"}, new String[]{"lou", "ㄌㄡ"}, new String[]{"lu", "ㄌㄨ"}, new String[]{"luan", "ㄌㄨㄢ"}, new String[]{"lue", "ㄌㄩㄝ"}, new String[]{"lun", "ㄌㄨㄣ"}, new String[]{"luo", "ㄌㄨㄛ"}, new String[]{"lv", "ㄌㄩ"}, new String[]{"lvan", "ㄌㄩㄢ"}, new String[]{"lve", "ㄌㄩㄝ"}, new String[]{"m", "ㄇ"}, new String[]{"ma", "ㄇㄚ"}, new String[]{"mai", "ㄇㄞ"}, new String[]{"man", "ㄇㄢ"}, new String[]{"mang", "ㄇㄤ"}, new String[]{"mao", "ㄇㄠ"}, new String[]{"me", "ㄇㄜ"}, new String[]{"mei", "ㄇㄟ"}, new String[]{"men", "ㄇㄣ"}, new String[]{"meng", "ㄇㄥ"}, new String[]{"mi", "ㄇㄧ"}, new String[]{"mian", "ㄇㄧㄢ"}, new String[]{"miao", "ㄇㄧㄠ"}, new String[]{"mie", "ㄇㄧㄝ"}, new String[]{"min", "ㄇㄧㄣ"}, new String[]{"ming", "ㄇㄧㄥ"}, new String[]{"miu", "ㄇㄧㄡ"}, new String[]{"mo", "ㄇㄛ"}, new String[]{"mou", "ㄇㄡ"}, new String[]{"mu", "ㄇㄨ"}, new String[]{"n", "ㄋ"}, new String[]{"na", "ㄋㄚ"}, new String[]{"nai", "ㄋㄞ"}, new String[]{"nan", "ㄋㄢ"}, new String[]{"nang", "ㄋㄤ"}, new String[]{"nao", "ㄋㄠ"}, new String[]{"ne", "ㄋㄜ"}, new String[]{"nei", "ㄋㄟ"}, new String[]{"nen", "ㄋㄣ"}, new String[]{"neng", "ㄋㄥ"}, new String[]{"ni", "ㄋㄧ"}, new String[]{"nia", "ㄋㄧㄚ"}, new String[]{"nian", "ㄋㄧㄢ"}, new String[]{"niang", "ㄋㄧㄤ"}, new String[]{"niao", "ㄋㄧㄠ"}, new String[]{"nie", "ㄋㄧㄝ"}, new String[]{"nin", "ㄋㄧㄣ"}, new String[]{"ning", "ㄋㄧㄥ"}, new String[]{"niu", "ㄋㄧㄡ"}, new String[]{"nong", "ㄋㄨㄥ"}, new String[]{"nou", "ㄋㄡ"}, new String[]{"nu", "ㄋㄨ"}, new String[]{"nuan", "ㄋㄨㄢ"}, new String[]{"nue", "ㄋㄩㄝ"}, new String[]{"nun", "ㄋㄨㄣ"}, new String[]{"nuo", "ㄋㄨㄛ"}, new String[]{"nv", "ㄋㄩ"}, new String[]{"nve", "ㄋㄩㄝ"}, new String[]{com.android.contacts.util.o.f17586f, "ㄛ"}, new String[]{"ou", "ㄡ"}, new String[]{"pa", "ㄆㄚ"}, new String[]{"pai", "ㄆㄞ"}, new String[]{"pan", "ㄆㄢ"}, new String[]{"pang", "ㄆㄤ"}, new String[]{"pao", "ㄆㄠ"}, new String[]{"pei", "ㄆㄟ"}, new String[]{"pen", "ㄆㄣ"}, new String[]{"peng", "ㄆㄥ"}, new String[]{"pi", "ㄆㄧ"}, new String[]{"pian", "ㄆㄧㄢ"}, new String[]{"piao", "ㄆㄧㄠ"}, new String[]{"pie", "ㄆㄧㄝ"}, new String[]{"pin", "ㄆㄧㄣ"}, new String[]{"ping", "ㄆㄧㄥ"}, new String[]{"po", "ㄆㄛ"}, new String[]{"pou", "ㄆㄡ"}, new String[]{"pu", "ㄆㄨ"}, new String[]{"qi", "ㄑㄧ"}, new String[]{"qia", "ㄑㄧㄚ"}, new String[]{"qian", "ㄑㄧㄢ"}, new String[]{"qiang", "ㄑㄧㄤ"}, new String[]{"qiao", "ㄑㄧㄠ"}, new String[]{"qie", "ㄑㄧㄝ"}, new String[]{"qin", "ㄑㄧㄣ"}, new String[]{"qing", "ㄑㄧㄥ"}, new String[]{"qiong", "ㄑㄩㄥ"}, new String[]{"qiu", "ㄑㄧㄡ"}, new String[]{"qu", "ㄑㄩ"}, new String[]{"quan", "ㄑㄩㄢ"}, new String[]{"que", "ㄑㄩㄝ"}, new String[]{"qun", "ㄑㄩㄣ"}, new String[]{"ra", "ㄖㄚ"}, new String[]{"ran", "ㄖㄢ"}, new String[]{"rang", "ㄖㄤ"}, new String[]{"rao", "ㄖㄠ"}, new String[]{"re", "ㄖㄜ"}, new String[]{"ren", "ㄖㄣ"}, new String[]{"reng", "ㄖㄥ"}, new String[]{"ri", "ㄖ"}, new String[]{"rong", "ㄖㄨㄥ"}, new String[]{"rou", "ㄖㄡ"}, new String[]{"ru", "ㄖㄨ"}, new String[]{"ruan", "ㄖㄨㄢ"}, new String[]{"rui", "ㄖㄨㄟ"}, new String[]{"run", "ㄖㄨㄣ"}, new String[]{"ruo", "ㄖㄨㄛ"}, new String[]{"sa", "ㄙㄚ"}, new String[]{"sai", "ㄙㄞ"}, new String[]{"san", "ㄙㄢ"}, new String[]{"sang", "ㄙㄤ"}, new String[]{"sao", "ㄙㄠ"}, new String[]{"se", "ㄙㄜ"}, new String[]{"sei", "ㄙㄟ"}, new String[]{"sen", "ㄙㄣ"}, new String[]{"seng", "ㄙㄥ"}, new String[]{"sha", "ㄕㄚ"}, new String[]{"shai", "ㄕㄞ"}, new String[]{"shan", "ㄕㄢ"}, new String[]{"shang", "ㄕㄤ"}, new String[]{"shao", "ㄕㄠ"}, new String[]{"she", "ㄕㄜ"}, new String[]{"shei", "ㄕㄟ"}, new String[]{"shen", "ㄕㄣ"}, new String[]{"sheng", "ㄕㄥ"}, new String[]{"shi", "ㄕ"}, new String[]{"shong", "ㄕㄡㄥ"}, new String[]{"shou", "ㄕㄡ"}, new String[]{"shu", "ㄕㄨ"}, new String[]{"shua", "ㄕㄨㄚ"}, new String[]{"shuai", "ㄕㄨㄞ"}, new String[]{"shuan", "ㄕㄨㄢ"}, new String[]{"shuang", "ㄕㄨㄤ"}, new String[]{"shui", "ㄕㄨㄟ"}, new String[]{"shun", "ㄕㄨㄣ"}, new String[]{"shuo", "ㄕㄨㄛ"}, new String[]{"si", "ㄙ"}, new String[]{"song", "ㄙㄨㄥ"}, new String[]{"sou", "ㄙㄡ"}, new String[]{"su", "ㄙㄨ"}, new String[]{"suan", "ㄙㄨㄢ"}, new String[]{"sui", "ㄙㄨㄟ"}, new String[]{"sun", "ㄙㄨㄣ"}, new String[]{"suo", "ㄙㄨㄛ"}, new String[]{"ta", "ㄊㄚ"}, new String[]{"tai", "ㄊㄞ"}, new String[]{"tan", "ㄊㄢ"}, new String[]{"tang", "ㄊㄤ"}, new String[]{"tao", "ㄊㄠ"}, new String[]{"te", "ㄊㄜ"}, new String[]{"teng", "ㄊㄥ"}, new String[]{"ti", "ㄊㄧ"}, new String[]{"tian", "ㄊㄧㄢ"}, new String[]{"tiao", "ㄊㄧㄠ"}, new String[]{"tie", "ㄊㄧㄝ"}, new String[]{"ting", "ㄊㄧㄥ"}, new String[]{"tong", "ㄊㄨㄥ"}, new String[]{"tou", "ㄊㄡ"}, new String[]{"tu", "ㄊㄨ"}, new String[]{"tuan", "ㄊㄨㄢ"}, new String[]{"tui", "ㄊㄨㄟ"}, new String[]{"tun", "ㄊㄨㄣ"}, new String[]{"tuo", "ㄊㄨㄛ"}, new String[]{"u", "ㄨ"}, new String[]{"wa", "ㄨㄚ"}, new String[]{"wai", "ㄨㄞ"}, new String[]{"wan", "ㄨㄢ"}, new String[]{"wang", "ㄨㄤ"}, new String[]{"wei", "ㄨㄟ"}, new String[]{"wen", "ㄨㄣ"}, new String[]{"weng", "ㄨㄥ"}, new String[]{"wo", "ㄨㄛ"}, new String[]{"wong", "ㄨㄨㄥ"}, new String[]{"wu", "ㄨ"}, new String[]{"xi", "ㄒㄧ"}, new String[]{"xia", "ㄒㄧㄚ"}, new String[]{"xian", "ㄒㄧㄢ"}, new String[]{"xiang", "ㄒㄧㄤ"}, new String[]{"xiao", "ㄒㄧㄠ"}, new String[]{"xie", "ㄒㄧㄝ"}, new String[]{"xin", "ㄒㄧㄣ"}, new String[]{"xing", "ㄒㄧㄥ"}, new String[]{"xiong", "ㄒㄩㄥ"}, new String[]{"xiu", "ㄒㄧㄡ"}, new String[]{"xu", "ㄒㄩ"}, new String[]{"xuan", "ㄒㄩㄢ"}, new String[]{"xue", "ㄒㄩㄝ"}, new String[]{"xun", "ㄒㄩㄣ"}, new String[]{"ya", "ㄧㄚ"}, new String[]{"yai", "ㄧㄞ"}, new String[]{"yan", "ㄧㄢ"}, new String[]{"yang", "ㄧㄤ"}, new String[]{"yao", "ㄧㄠ"}, new String[]{"ye", "ㄧㄝ"}, new String[]{"yi", "ㄧ"}, new String[]{"yin", "ㄧㄣ"}, new String[]{"ying", "ㄧㄥ"}, new String[]{"yo", "ㄧㄛ"}, new String[]{"yong", "ㄩㄥ"}, new String[]{"you", "ㄧㄡ"}, new String[]{"yu", "ㄩ"}, new String[]{"yuan", "ㄩㄢ"}, new String[]{"yue", "ㄩㄝ"}, new String[]{"yun", "ㄩㄣ"}, new String[]{"za", "ㄗㄚ"}, new String[]{"zai", "ㄗㄞ"}, new String[]{"zan", "ㄗㄢ"}, new String[]{"zang", "ㄗㄤ"}, new String[]{"zao", "ㄗㄠ"}, new String[]{"ze", "ㄗㄜ"}, new String[]{"zei", "ㄗㄟ"}, new String[]{"zen", "ㄗㄣ"}, new String[]{"zeng", "ㄗㄥ"}, new String[]{"zha", "ㄓㄚ"}, new String[]{"zhai", "ㄓㄞ"}, new String[]{"zhan", "ㄓㄢ"}, new String[]{"zhang", "ㄓㄤ"}, new String[]{"zhao", "ㄓㄠ"}, new String[]{"zhe", "ㄓㄜ"}, new String[]{"zhei", "ㄓㄟ"}, new String[]{"zhen", "ㄓㄣ"}, new String[]{"zheng", "ㄓㄥ"}, new String[]{"zhi", "ㄓ"}, new String[]{"zhong", "ㄓㄨㄥ"}, new String[]{"zhou", "ㄓㄡ"}, new String[]{"zhu", "ㄓㄨ"}, new String[]{"zhua", "ㄓㄨㄚ"}, new String[]{"zhuai", "ㄓㄨㄞ"}, new String[]{"zhuan", "ㄓㄨㄢ"}, new String[]{"zhuang", "ㄓㄨㄤ"}, new String[]{"zhui", "ㄓㄨㄟ"}, new String[]{"zhun", "ㄓㄨㄣ"}, new String[]{"zhuo", "ㄓㄨㄛ"}, new String[]{"zi", "ㄗ"}, new String[]{"zong", "ㄗㄨㄥ"}, new String[]{"zou", "ㄗㄡ"}, new String[]{"zu", "ㄗㄨ"}, new String[]{"zuan", "ㄗㄨㄢ"}, new String[]{"zui", "ㄗㄨㄟ"}, new String[]{"zun", "ㄗㄨㄣ"}, new String[]{"zuo", "ㄗㄨㄛ"}};

    /* renamed from: j, reason: collision with root package name */
    public static HashMap<String, String> f38356j = new HashMap<>();

    /* JADX WARN: Removed duplicated region for block: B:13:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(java.lang.String r7) {
        /*
            java.lang.String r0 = "0"
            if (r7 == 0) goto L7e
            int r1 = r7.length()
            if (r1 != 0) goto Lc
            goto L7e
        Lc:
            r1 = 0
            char r2 = r7.charAt(r1)
            java.lang.String[] r3 = z7.d0.f38347a
            java.lang.String[] r4 = z7.d0.f38348b
            int r5 = r3.length
            int r5 = r5 + (-1)
            r6 = 65
            if (r2 < r6) goto L20
            r6 = 71
            if (r2 <= r6) goto L28
        L20:
            r6 = 97
            if (r2 < r6) goto L2c
            r6 = 103(0x67, float:1.44E-43)
            if (r2 > r6) goto L2c
        L28:
            int r2 = r3.length
        L29:
            int r5 = r2 + (-1)
            goto L6e
        L2c:
            r6 = 72
            if (r2 < r6) goto L34
            r6 = 78
            if (r2 <= r6) goto L3c
        L34:
            r6 = 104(0x68, float:1.46E-43)
            if (r2 < r6) goto L42
            r6 = 110(0x6e, float:1.54E-43)
            if (r2 > r6) goto L42
        L3c:
            java.lang.String[] r3 = z7.d0.f38349c
            java.lang.String[] r4 = z7.d0.f38353g
            int r2 = r3.length
            goto L29
        L42:
            r6 = 79
            if (r2 < r6) goto L4a
            r6 = 84
            if (r2 <= r6) goto L52
        L4a:
            r6 = 111(0x6f, float:1.56E-43)
            if (r2 < r6) goto L58
            r6 = 116(0x74, float:1.63E-43)
            if (r2 > r6) goto L58
        L52:
            java.lang.String[] r3 = z7.d0.f38350d
            java.lang.String[] r4 = z7.d0.f38354h
            int r2 = r3.length
            goto L29
        L58:
            r6 = 85
            if (r2 < r6) goto L60
            r6 = 90
            if (r2 <= r6) goto L68
        L60:
            r6 = 117(0x75, float:1.64E-43)
            if (r2 < r6) goto L6e
            r6 = 122(0x7a, float:1.71E-43)
            if (r2 > r6) goto L6e
        L68:
            java.lang.String[] r3 = z7.d0.f38351e
            java.lang.String[] r4 = z7.d0.f38352f
            int r2 = r3.length
            goto L29
        L6e:
            if (r1 > r5) goto L7e
            r2 = r3[r1]
            int r2 = r2.compareToIgnoreCase(r7)
            if (r2 != 0) goto L7b
            r7 = r4[r1]
            return r7
        L7b:
            int r1 = r1 + 1
            goto L6e
        L7e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: z7.d0.a(java.lang.String):java.lang.String");
    }

    public static String b(String str) {
        String str2;
        if (str == null) {
            return str;
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder();
        boolean z10 = false;
        for (int i10 = 0; i10 < length; i10++) {
            char charAt = str.charAt(i10);
            if (charAt >= 19968 && charAt <= 40869) {
                try {
                    str2 = c0.d(Character.toString(charAt));
                    if (charAt == 33865) {
                        str2 = "ye";
                    }
                } catch (Exception unused) {
                    str2 = null;
                }
                String str3 = f38356j.get(str2);
                if (str3 == null) {
                    int length2 = f38355i.length - 1;
                    int i11 = 0;
                    while (true) {
                        if (i11 > length2) {
                            break;
                        }
                        int i12 = (i11 + length2) / 2;
                        String[][] strArr = f38355i;
                        int compareTo = strArr[i12][0].compareTo(str2);
                        if (compareTo == 0) {
                            String[] strArr2 = strArr[i12];
                            str2 = strArr2[1];
                            f38356j.put(strArr2[0], str2);
                            z10 = true;
                            break;
                        }
                        if (compareTo > 0) {
                            length2 = i12 - 1;
                        } else {
                            i11 = i12 + 1;
                        }
                    }
                    str3 = str2;
                } else {
                    z10 = true;
                }
                sb.append(str3);
            } else {
                sb.append(charAt);
            }
        }
        if (z10) {
            return sb.toString().replaceAll("#", "");
        }
        return sb.toString();
    }
}
