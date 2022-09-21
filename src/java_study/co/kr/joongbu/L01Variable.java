package java_study.co.kr.joongbu;

import java.util.ArrayList;
import java.util.Spliterators.AbstractDoubleSpliterator;

//클래스 이름 규칙: 파스칼 표기법(이름 표기할 때 사용), 숫자로 시작하면 안된다. 


public class L01Variable {
	//메소드 이름 규칙: 카멜 표기법 사용, 숫자로 시작하면 안된다.
	//public void 11print(){} 안됨
	//main 메소드 규칙: public(어디서든 접근 가능), static(정적인 jvm(main) < jre 스택에서 참조됨), void(반환되는 것이 없음), args(main이 실행될때 지정되는 기본값)
	public static void main(String[] args) { //파라미터(매개변수)
		for(String a: args) { //foreach or 향상된 for
			System.out.println(a);
		}
		String[] arr={"a","b","c","d"}; //Array 배열
		System.out.println(arr.length);
		System.out.println(arr.toString()); //Object.toString(): 객체의 주소(객체의 대한 정보를 재정의 하기를 기대하는 함수)
		//java.lang.Object: 모든 객체의 부모(모든 타입이 객체가 될 수있는 정보를 포함 => class의 생성자를 new 연산자로 호출해서 객체를 생성할 수 있게 해준다.)
		
		ArrayList<String> list=new ArrayList<>(); //List 배열
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		System.out.println(list.toString());
		System.out.println(list.size());
		System.out.println(list.contains("c")); //Object.toString() > List.toString(): 객체의 설명
		
		L01Variable L01Variable = new L01Variable();
		System.out.println(L01Variable); //toString은 생략 가능
		System.out.println(L01Variable.toString());
		
		//@Override: 부모의 필드를 재정의하는 것을 오버라이드(다형성: 한개의 이름이 역할을 많이 갖는 것)
		//자식은 부모의 모든 필드를 물려받지만 재정의 된 필드가 우선순위를 갖는다.
		//타입의 다형성: 한개의 객체가 여러 타입에 참조 가능(다형성)
		String hello="안녕";
		Object o =hello; //o 변수는 Object타입의 객체만 참조 가능, 부모가 Object인 객체를 참조가능(타입의 다형성 => 형변환)
		
		
		byte b; //1byte(8bit)로 참조할 수 있는 정수
		short s; //2byte로 참조할 수 있는 정수
		//변수 i가 선언됨(참조할 객체의 타입을 명시)
		int i;  //4byte로 참조할 수 있는 정수
		long l; //8byte 정수 
		char c; //문자표(아스키코드, 유니코드)의 번호를 참조
		
		//실수를 참조하는 타입
		float f; //4byte로 표기하는 실수: float 0.00314 =. 3.14 * 10-4(부동소수)
		double d; //8byte 실수 
		System.out.println(13.33); //double
		System.out.println(13); //int
		
		//부동소수점으로 표기하는 실수
		//0.005(고정소수점 표기)=> 5.0 * 10-3(부동소수점)
		//가수부: 5.0 => 첫번째 비트에 전기적 신호를 준다.
		//지수부: 10-3
		
		//float로 참조하기에 큰 수는 infinity로 반환
		
		//javascript의 number는 java double과 같다.
		
		boolean bool = true;//true:1, false:0 => 1bit data => 자바에서 8bit를 사용함(메모리를 1byte로 구성하고 있기 때문)
		
		//상수
		final int I=20;
//		I=30; 최초 선언된 값 외의 데이터를 참조할 수 없다.(기본형 데이터를 값이라 부른다. 객체라 불러도 큰 문제는 없으나 객체를 참조형 데이터로 구분하는 사람들이 있음)
		System.out.println(I);
		
		Integer objI=new Integer(20); //java는 기본형을 참조형으로 선언하는 것을 권장하지 않는다.
		System.out.println(I==objI); //false
		
		String objStr =new String("안녕");
		String literalStr="안녕";
		String literalStr2="안녕";
		System.out.println(objStr==literalStr); //false
		System.out.println(objStr==literalStr2);//true (문자열은 참조형 date (객체)는 동등 비교를 할 수 없다.)
		
		// == 동등비교가 비교하는 것
		//1. 객체가 같은 것인지 비교(주소 비교)(참조형은 선언할 때마다 새로운 객체를 만들기 때문에 무조건 false)
		//2. 값이 같은지 비교(값은 기본형 => 수 => 수가 같은지)
		
		System.out.println("20==20.0 :"+(20==20.0)); //기본형: 값을 비교
		System.out.println("new String(\"안녕\")==new String(\"안녕\"):"+(new String("안녕")==new String("안녕"))); //참조형: 주소를 비교(완전히 같은 객체인지 비교)
		
		//참조형 중에 String만 예외: 문자열을 리터럴하게 선언시 기본형처럼 새로운 data를 만들지 ㅇㄶ고 기존의 객체를 찯아서 참조한다. 리터럴하게 선언한 두 문자열은 완전히 같은 객체다.
		System.out.println(("\"안녕\"==\"안녕\":")+("안녕"=="안녕"));
		
		//참조형을 비교연산하는 방법: Object.equals(obj) 서로 다른 두 객체가 같으려면 필드가 완전히 같아야 한다.(주관적으로 필드의 범위를 지정가능) => 재정의해야 가능
		//String은 equals를 재정의하고 있다.
		//리터럴하게 선언된 문자자열도 참조형 데이터이다.
		//문자열의 동등비교를 권장하지 않는다. (참조형을 동등비교할 수 있나요? 안됩니다. )
		System.out.println(new String("안녕").equals(new String("안녕")));
		
		
		
	}
	//오버로드: 메소드 이름이 같지만 매개변수가 다른것 (다형성: 한개의 이름이 역할을 많이 갖는 것)
	public void print() {}
	public void print(int i) {}
	public void print(String s) {}
	public void print(String s, String s2) {}
	public void print(double d) {}
	public void print(char c) {}
	public void print(Object o) {}
	public void print(float f) {}
	
	
	@Override//모든 class는 object를 자동으로 상속하기때문에 toString을 제정의할 수 있다.
	public String toString() {
		return"변수에 대한 수업입니다.";
	}
}
