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
		//各位大神，我想从80张订单（一个list集合）里面随机抽取6次，每次数量不一致，但是6次要全部抽取完毕，有什么好的方法么？
		//todo 1,2,3,4,5步的取值 每次抽取还需满足后续的结果不重复，且有最低取1的数量限制。。且需排除当前已有的数字
		// todo list中抽取，还应根据下标标记那些被抽出的元素
		//比如 第一次取了1-5直接一个,此时判断后5步时应保证 剩余数>= 最小可能5个数之和
		// 如第一步取完剩余数量保证>=(1+5)*5/2
		// 如第二步取完剩余数量保证>=(1+5)*5/2


		Integer  remainCount= 80;
		Random r = new Random();
		List<Integer> out = new ArrayList<Integer>();
		for (int j=0 ;j<=5 ; j++){
			int now = 0;
			while (j == 4){//第5次
				now = r.nextInt(remainCount);
				int last = remainCount - now;
				if(out.contains(now) || out.contains(last)){
					continue;
				}
				out.add(now);//记录已经取出的计数值
				remainCount = remainCount - now;//将此次取出的移出
				break;
			}
			while (j<4){//1-4次
				now = r.nextInt(remainCount);
				if(out.contains(now)){
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
	public int getRemainedPossible(){
		//todo
		return  1;
	}

}
