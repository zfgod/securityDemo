package stu;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * author: zf
 * Date: 2017/2/16  11:42
 * Description:
 */
public class T {
	public static void main(String[] args) {
		//我想从80张订单（一个list集合）里面随机抽取6次，每次数量不一致，但是6次要全部抽取完毕，有什么好的方法么？
		//todo 1,2,3,4,5步的取值 每次抽取还需满足后续的结果不重复，且有最低取1的数量限制。。且需排除当前已有的数字
		//比如 第一次取了1-5直接一个,此时判断后5步时应保证 剩余数>= 最小可能5个数之和,取的次数小还行，取的次数大计算就复杂了。。。
		// 如第一步取完剩余数量保证>=(1+5)*5/2
		// 如第二步取完剩余数量保证>=(1+5)*5/2
		List<Integer> list =  initList(80);
		Integer  remainCount= list.size();
		Random r = new Random();
		List<Integer> out = new ArrayList<Integer>();
		for (int j=0 ;j<=5 ; j++){
			int now = 0;
			while (j == 4){//第5次
				now = r.nextInt(remainCount);
				int last = remainCount - now;
				if(now == 0 ||out.contains(now) || out.contains(last)){
					continue;
				}
				out.add(now);//记录已经取出的计数值
				remainCount = remainCount - now;//将此次取出的移出
				break;
			}
			while (j<4){//1-4次
				now = r.nextInt(remainCount);
				if(now == 0 || out.contains(now)|| !checkFollows(out,remainCount,now,j,5)){
					continue;
				}
				out.add(now);
				remainCount = remainCount - now;//将此次取出的移出
				break;
			}
			while(j==5){
				now = remainCount;//最后一次直接取出
				break;
			}
			System.out.println("第" + j + "次取出："+now);
		}
	}

	private static boolean checkFollows(List<Integer> out, Integer remainCount, int now, int j, int all) {
        //校验 当前值取出后，后续步骤的最小组合是否满足
		int times = all - j;//剩余抽取次数
		int count = remainCount - now;//剩余数量
		//重新new 一个 out数组来做计数值唯一性判断
		List<Integer> newOut = new ArrayList<Integer>();
		for (Integer integer : out) {
			newOut.add(integer);
		}
		int total = 0;
		for (int i = 0; i < times; i++) {
			int may = 1;//当前可能的最小值
			for (; may < remainCount; may++) {
				if (newOut.contains(may)) {
					continue;
				}
				break;
			}
			newOut.add(may);
			total += may ;
		}
		return total <= count;
	}

	private static List<Integer> initList(int size) {
	    List<Integer> integers = new ArrayList<Integer>();
		for (int i = 0;i< size;i++){
			integers.add(i);
		}
		return integers;
	}

	public int getRemainedPossible(){
		//todo
		return  1;
	}

}
