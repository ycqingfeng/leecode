import cn.ycsin.leetcode.lcp48.Solution;
import org.junit.Test;

public class Lcp48Tester {

    @Test
    public void test1(){
        int[][] pieces = new int[][]{{1,2,1},{1,4,1},{1,5,1},{2,1,0},{2,3,0},{2,4,0},{3,2,1},{3,4,0},{4,2,1},{5,2,1}};
        String solution = new Solution().gobang(pieces);
    }

}
