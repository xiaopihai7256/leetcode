package leetcode;

/**
 * date: 2020/10/8
 * description: 字符串版本比较，https://leetcode-cn.com/problems/compare-version-numbers/
 * leetCode: 165
 * @author xiaopihai7256
 */
public class CompareVersion {

    public static void main(String[] args) {
        CompareVersion version = new CompareVersion();
        System.out.println(version.compareVersion("0.000002", "0.0.2"));
    }

    public int compareVersion(String version1, String version2) {
        String[] v1Arr = version1.split("\\.");
        String[] v2Arr = version2.split("\\.");
        int res, i;
        for (i = 0; i < v1Arr.length && i < v2Arr.length; i++) {
            // 迭代分组比较
            res = compareVersionGroup(v1Arr[i], v2Arr[i]);
            if (res != 0) return res;
        }
        // 分组长度相等且未比较出结果，返回0
        if(v2Arr.length == v1Arr.length) {
            return 0;
        }
        // 搜索组数更多的版本的有效内容，如果搜索到则对应的版本更大
        if (v1Arr.length > i ) {
            if (findValidNumber(i, v1Arr)) return 1;
        } else {
            if (findValidNumber(i, v2Arr)) return -1;
        }
        return 0;
    }

    /**
     * 分组比
     * @param v1 组1
     * @param v2 组2
     * @return 结果
     */
    public int compareVersionGroup(String v1, String v2) {
        int v1Count = 0, v2Count = 0;
        // 过滤前缀无效0字符
        for (; v1Count < v1.length(); v1Count++) {
            if (v1.charAt(v1Count) != '0') {
                break;
            }
        }
        for (; v2Count < v2.length(); v2Count++) {
            if (v2.charAt(v2Count) != '0') {
                break;
            }
        }
        // 先比有效字符长度
        if (v1.length() - v1Count > v2.length() - v2Count) {
            return 1;
        } else if (v1.length() - v1Count < v2.length() - v2Count) {
            return -1;
        }
        // 若长度相等，则比较有效字符值
        for (; v1Count < v1.length(); v1Count++, v2Count++) {
            if (v1.charAt(v1Count) > v2.charAt(v2Count)) {
                return 1;
            } else if (v1.charAt(v1Count) < v2.charAt(v2Count)) {
                return -1;
            }
        }
        // 长度和值都相等
        return 0;
    }

    /**
     * 单组寻找后续有效值（非0字符）
     * @param start 起始索引
     * @param arr 数组
     * @return 搜索结果
     */
    public boolean findValidNumber(int start, String[] arr) {
        String iStr;
        for (int i = start; i < arr.length; i++) {
            iStr = arr[i];
            for (int j = 0; j < iStr.length(); j++) {
                if (iStr.charAt(j) != '0') return true;
            }
        }
        return false;
    }
}
