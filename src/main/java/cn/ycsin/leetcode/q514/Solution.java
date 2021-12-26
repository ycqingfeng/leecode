package cn.ycsin.leetcode.q514;

import com.sun.javafx.binding.StringFormatter;

public class Solution {
    static char[] rings;
    static char[] keys;

    static int ringsLen;
    static int keysLen;

//    static int minStep = 9999999;

    static int[] memories;

//    static int[] memeryRing;

    public static void _log(int step, char target, char direct, int cost) {
        System.out.println(String.format("%3d: 花了%3d步， %c方向找到了%c", step, cost, direct, target));
//        try {
//            Thread.sleep(100);
//        } catch (Exception e) {
//
//        }
    }

    public int findRotateSteps(String ring, String key) {
        rings = ring.toCharArray();
        keys = key.toCharArray();

        ringsLen = rings.length;
        keysLen = keys.length;

        memories = new int[keysLen + 1];
        for (int i = 0; i < keysLen; i++) {
            memories[i] = 999999;
        }
//        minStep = 9999999;

//        memeryRing = new int[ringsLen];
//        int[] memery_pointAt = new int[ringsLen];


//        search(0, 0, 'r', 0);
//        System.out.println("--");
        search(0, 0, 'l', 0);
        return memories[keysLen - 1];
    }

    public static final String[] search(int index, int pointAt, char direct, int memoryTotal) {
        int steps = 1;
        String tempRtn = "";

        if (direct == 'r') {
            for (int pt = pointAt; pt < ringsLen && (memoryTotal + steps) < memories[index] && steps < ringsLen; pt++) {
                if (keys[index] == rings[pt]) {
                    _log(index, keys[index], direct, steps);
                    tempRtn += steps + "," + pt + "_";
                    if (index < keysLen - 1) {
                        String[] tempSteps = search(index + 1, pt, 'r', memoryTotal + steps);
                        for(String tempStep: tempSteps) {
                            int _step = Integer.parseInt(tempStep.split(",")[0]);
                            int _pt = Integer.parseInt(tempStep.split(",")[1]);
                            if (_step + memoryTotal < memories[index + 1]) {
                                memories[index + 1] = _step + memoryTotal;
                                tempSteps = search(index + 1, _pt, 'l', memoryTotal + steps);
                                for(String tempStep2: tempSteps) {
                                    _step = Integer.parseInt(tempStep2.split(",")[0]);
                                    _pt = Integer.parseInt(tempStep2.split(",")[1]);
                                    if (_step + memoryTotal < memories[index + 1]) {
                                        memories[index + 1] = _step + memoryTotal;
                                    }
                                }
                            }
                        }
                    }
                }
                steps++;
                if ((pt + 1) == ringsLen) {
                    pt = -1;
                }
            }

            return tempRtn.split("_");
        } else {
            for (int pt = pointAt; pt >= 0 && (memoryTotal + steps) < memories[index] && steps < ringsLen; pt--) {
                if (keys[index] == rings[pt]) {
                    _log(index, keys[index], direct, steps);
                    tempRtn += steps + "," + pt + "_";
                    if (index < keysLen - 1) {
                        String[] tempSteps = search(index + 1, pt, 'r', memoryTotal + steps);
                        for(String tempStep: tempSteps) {
                            int _step = Integer.parseInt(tempStep.split(",")[0]);
                            int _pt = Integer.parseInt(tempStep.split(",")[1]);
                            if (_step + memoryTotal < memories[index + 1]) {
                                memories[index + 1] = _step + memoryTotal;
                                tempSteps = search(index + 1, pt, 'l', memoryTotal + steps);
                                for(String tempStep2: tempSteps) {
                                    _step = Integer.parseInt(tempStep2.split(",")[0]);
                                    _pt = Integer.parseInt(tempStep2.split(",")[1]);
                                    if (_step + memoryTotal < memories[index + 1]) {
                                        memories[index + 1] = _step + memoryTotal;
                                    }
                                }
                            }
                        }
                    }
                    steps = 1;

                }
                steps++;
                if (pt == 0) {
                    pt = ringsLen;
                }
            }

            return tempRtn.split("_");
        }

    }

//    public static final void search(int pointAt, char direct) {
//        int steps = 0;
//        labelKey:
//        for (int i = 0; i < keysLen; i++) {
//            steps = 0;
//            if (keys[i] == rings[pointAt]) {
//                steps++;
//                memeryRing[i] = (i == 0 ? 0 : memeryRing[i - 1]) + steps;   //记录第一次滚的成绩
//                _log(i, keys[i], 'r', steps);
//                continue;
//            }
//            if (direct == 'r') {
//                int pointAtOri = pointAt;
//                for (int pt = pointAt; pt < ringsLen; pt++) {  //只考虑往右转
//                    steps++;
//                    if (keys[i] == rings[pt]) {
//                        memeryRing[i] = (i == 0 ? 0 : memeryRing[i - 1]) + steps;   //记录第一次滚的成绩
//                        pointAt = pt;
//                        _log(i, keys[i], 'r', steps);
//                        continue labelKey;
//                    }
//                    if ((pt + 1) == ringsLen) {
//                        pt = 0;
//                    }
//                }
//                search(pointAt, 'l');
//            } else {
//                for (int pt = pointAt; pt < ringsLen; pt++) {  //只考虑往右转
//                    steps++;
//                    if (keys[i] == rings[pt]) {
//                        memeryRing[i] = (i == 0 ? 0 : memeryRing[i - 1]) + steps;   //记录第一次滚的成绩
//                        pointAt = pt;
//                        _log(i, keys[i], 'r', steps);
//                        continue labelKey;
//                    }
//                    if ((pt + 1) == ringsLen) {
//                        pt = 0;
//                    }
//                }
//            }
//        }
//    }

    public static void main(String[] args) {
        int result = new Solution().findRotateSteps("godding","gd");
//        int result = new Solution().findRotateSteps("xrrakuulnczywjs","jrlucwzakzussrlckyjjsuwkuarnaluxnyzcnrxxwruyr");
        System.out.println(result);
    }
}
