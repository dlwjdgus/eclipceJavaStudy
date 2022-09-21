package java_study.co.kr.joongbu;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class L19StreamAPIEx5 {
	class Student{
		//public(어디서든) protected(상속하는) default(같은 패키지 내부) private(클래스 내부에서) : 접근지정자
		private String name;
		private boolean isMale;
		private int hak;
		private int ban;
		private int score;
		//내부에서만 접근할 수 있는 필드
		
		public Student(String name,boolean isMale,int hak,int ban,int score) {
			this.name=name;
			this.isMale=isMale;
			this.hak=hak;
			this.ban=ban;
			this.score=score;
		}
		//set : 필드에 값을 지정하는 행위
		//get : 필드에 값을 반환하는 행위
		//캡슐화 : 객체의 필드를 접근지정자와 get함수, set함수 생성자로 접근을 제한하는 행위 
		
		//외부에서 필드를 접근할 수 있게 생성한 함수
		public String getName() {return name;}
		public boolean isMale() {return isMale;}
		public int getHak() {return hak;}
		public int getBan() {return ban;}
		public int getScore() {return score;}
		
		@Override
		public String toString() {
			return "{"+name +","+isMale+","+hak+","+ban+","+ score+"}";
		}
	}

	public static void main(String[] args) {
		List<Student> studentList=new ArrayList<Student>();
		L19StreamAPIEx5 out=new L19StreamAPIEx5();
		studentList.add(out.new Student("나자바", true, 1, 1, 300));
		studentList.add(out.new Student("김지미", false, 1, 1, 250));
		studentList.add(out.new Student("김자바", true, 1, 1, 200));
		studentList.add(out.new Student("이지미", false, 1, 2, 150));
		studentList.add(out.new Student("남자바", true, 1, 2, 100));
		studentList.add(out.new Student("안지미", false, 1, 2, 50));
		studentList.add(out.new Student("황지미", false, 1, 3, 100));
		studentList.add(out.new Student("강지미", false, 1, 3, 150));
		
		studentList.add(out.new Student("나자바", true, 2, 1, 300));
		studentList.add(out.new Student("김지미", false, 2, 1, 250));
		studentList.add(out.new Student("김자바", true, 2, 1, 200));
		studentList.add(out.new Student("이지미", false, 2, 2, 150));
		studentList.add(out.new Student("남자바", true, 2, 2, 100));
		studentList.add(out.new Student("안지미", false, 2, 2, 50));
		studentList.add(out.new Student("황지미", false, 2, 3, 100));
		studentList.add(out.new Student("강지미", false, 2, 3, 150));

		studentList.add(out.new Student("나자바", true, 3, 1, 300));
		studentList.add(out.new Student("김지미", false, 3, 1, 250));
		studentList.add(out.new Student("김자바", true, 3, 1, 200));
		studentList.add(out.new Student("이지미", false, 3, 2, 150));
		studentList.add(out.new Student("남자바", true, 3, 2, 100));
		studentList.add(out.new Student("안지미", false, 3, 2, 50));
		studentList.add(out.new Student("황지미", false, 3, 3, 100));
		studentList.add(out.new Student("강지미", false, 3, 3, 150));
		
		//stream의 중간연산과 최종연산이 모두 반복문이라면 사용한만큼 시간이 걸리지만 연산지연의 의해서 효율적으로 반복문을 작성한다.
		//1학년 남자들의 점수-1
		long start=System.nanoTime();
		Optional <String> boySum=studentList.stream()
				.filter(Student::isMale)
				.filter(p->p.getHak()==1)
				.map(p->p.score+"") //11 => "11"
				.reduce((s1,s2)->s1+","+s2);
		System.out.println(boySum.get());
		long end=System.nanoTime();
		System.out.println("stream 연산 시간: "+(end-start));
		
		//-2 
		start=System.nanoTime();
		String scores="";
		for(Student s:studentList) {
			if(s.getHak()==1 && s.isMale) {
				scores+=s.getScore();
			}
		}
		System.out.println(scores);
		end=System.nanoTime();
		System.out.println("for 연산 시간: "+(end-start));
		
		//2학년 여자들의 점수
		
		//1한년의 남자 여자의 수를 collect로 구현하세요!	
		
		//1한년을 남자 여자의 그룹으로 나누고 다시 통과(score>=150)와 낙제 그룹으로 나누세요. //partitioningBy 사용
		
		//1학년 남자,여자 그룹의 평균 점수를 구하세요
		
		//각학년별 남자 여자 그룹의  접수가 가장 높은 사람을 구하세요 //집계함수 사용
		start=System.nanoTime();
		Map<Integer, Map<Boolean, Optional<Student>>>  map=studentList.stream()
			.collect(Collectors.groupingBy(Student::getHak, 
					Collectors.partitioningBy(Student::isMale, 
							Collectors.maxBy(Comparator.comparingInt(Student::getScore)))));
		System.out.println(map);
		end=System.nanoTime();
		System.out.println("stream 연산 시간 :"+(end-start));

		//2한년을 남자 여자의 그룹으로 나누고 다시 통과한 사람과 낙제 한 사람의 수를 구하세요
		
		//모든 학년을 그룹으로 나누고 학년 마다 남자와 여자 그룹의 수를 구하세요
		
		//모든 학년을 그룹으로 나누고 학년 마다  반 그룹으로 나누세요
	}
}

