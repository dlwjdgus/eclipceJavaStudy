package java_study.co.kr.joongbu;

import java.util.Objects;

class PersonTest{ 
	//필드
	String name;
	int age;
	public PersonTest(String naem, int age) {
		this.name=name; //this 필드 접근자
		this.age=age;
		
	}
	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) //동인한 객체인지
			return true;
		if (obj == null) //객체 != null
			return false;
		if (getClass() != obj.getClass()) //타입이 같은지 여부
			return false; //메소드의 return이 실행되면 종료된다.
		PersonTest other = (PersonTest) obj;//부모의 타입을 참조하는 변수를 자식의 타입으로 형변환 
		return age == other.age && Objects.equals(name, other.name); //필드가 같은지
	}
}

public class L02Equals {
	public static void main(String[] args) {
		PersonTest 천러=new PersonTest("천러",22);
		PersonTest 천러2=new PersonTest("천러",22);
		System.out.println(천러==천러2);
		System.out.println(천러.equals(천러2));
	}
}
