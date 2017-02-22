package stu;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * author: zf
 * Date: 2017/2/22  14:38
 * Description:
 */
public class T1 {
	public static void main(String[] args) {
		List<Integer> integers = new ArrayList<Integer>();
		int size = 80;
		for (int i = 0;i< size;i++){
			integers.add(i);
		}
		Random random = new Random();
		int i = random.nextInt(size);
		for ( ;i>0;i--){
			while (true){
				int thisIndex = random.nextInt(integers.size());
				integers.remove(thisIndex);//移出操作，重新移动数组位置
				System.out.println("移出index"+thisIndex+"值为："+integers.get(thisIndex));
				break;
			}
		}
		System.out.println("移出操作结束后size"+integers.size());
	}
}
