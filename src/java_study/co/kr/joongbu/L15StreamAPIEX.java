package java_study.co.kr.joongbu;

import java.util.ArrayList;
import java.util.List;

public class L15StreamAPIEX {
	static int sum2;
	public static void main(String[] args) {
		
		Integer n=new Integer(500);
		System.out.println(10+n);
		System.out.println(10+n.intValue()); //참조형인 Integer 객체에서 기본형을 반환해서 계산
		
		List<Integer> numList=new ArrayList<Integer>();
		numList.add(500); //new Integer(500)
		numList.add(55);
		numList.add(5);
		numList.add(null);
		numList.add(1);
		numList.add(3);
		numList.add(-300);
		
		//외부반복문은 내부반복문보다 조건을 파악하기 어렵다.
		int sum=0;
		for(Integer num:numList) { //int num=numList.get(i).intValue(); => int num=null.intValu();
			if(num!=null) {
				sum+=num;
			}
		}
		//null의 필드가 없는데 참조해서 오류
		System.out.println(sum);
		
		numList.stream()
			.filter((i)->i!=null) //filter(중간연산):검사식애서 true를 반환하는 값만 stream으로 다시 반환
			.forEach((i)->{sum2+=i;});//forEach(최종연산)
		System.out.println(sum2);
	}
}
