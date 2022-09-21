package java_study.co.kr.joongbu;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class L16StreamAPIEx2 {
//자바의 경우: 안심각한 오류:컴파일시(런타임 시) 발견되는 오류(이클립스 빨간줄) // 심각한 오류:컴파일시(런타임 시) 발견 안되는 오류
//파이썬, 자바스크립트 : 인터프리터 언어 - 소스코드 바로 실행. 편집기가 발견하는 오류.(편집기 성능에 오류를 의존) / 오류를 발견하기 어렵다.
//컴파일: 소스코드를 바이너리코드로 변환.
   
   //각필드가 고유한 값을 갖는 상수. 다른 상수와 섞어쓰지않음.
   interface Cate{
      public static int 식품=0;
      public static int 의류 =1;
      public static int 가구 =2;
      public static int 문구 =3;
      public static int 침구 =4;
   }
   
   //쇼핑몰에서 판매하는 상품자료 type = Variable Object(VO), Data Transfer Object(DTO)
   class ProductDTO{
      //Class의 전역에 선언된 변수: 전역변수, 객채의 필드로 생성됨(속성)
      String name=null;
      int price=0;
      int category; //0:식품류 1:의류 2:가구 3:문구류 4:침구류
      int quantity=10;
      
      //생성자로 필드를 초기화. : 생성자는 객체를 반환하는 함수
      public int sum(int a, int b) {
         return a+b;
      }
      public ProductDTO(String name,int price,int category) {
         this.name=name;
         this.price=price;
         this.category=category;
      }
      public ProductDTO(String name,int price,int category,int quantity) {
         this.name=name;
         this.price=price;
         this.category=category;
         this.quantity=quantity;
      }
      
      @Override
      public String toString() {
         return "ProductDTO:{name=" + name + ", price=" + price + ", category=" + category + ", quantity=" + quantity
               + "}";
      }
         
   }
   public static void main(String[] args) {
//      System.out.println("정수를 입력하면 제곱 수를 반환");
//      Scanner sc=new Scanner(System.in);
//      int num = sc.nextInt();
//      System.out.println(num*num);
      
      L16StreamAPIEx2 ex2 = new L16StreamAPIEx2();
      List<ProductDTO> products = new ArrayList<ProductDTO>();
      
      products.add(ex2.new ProductDTO("생귤탱귤감귤", 500, Cate.식품,10));
      products.add(ex2.new ProductDTO("하겐다즈바닐라", 12000, Cate.식품,5));
      products.add(ex2.new ProductDTO("허쉬 초콜릿", 2000, Cate.식품,3));
      
      products.add(ex2.new ProductDTO("지우개", 500, Cate.문구,50));
      products.add(ex2.new ProductDTO("볼펜", 1000, Cate.문구,100));
      products.add(ex2.new ProductDTO("화이트 지우개", 2500, Cate.문구,3));
      
      products.add(ex2.new ProductDTO("흰색 셔츠", 10000, Cate.의류,0));
      products.add(ex2.new ProductDTO("나이키 반팔 티", 25000, Cate.의류,5));
      products.add(ex2.new ProductDTO("나이키 신발", 110000, Cate.의류,2));
      products.add(ex2.new ProductDTO("아디다스 신발", 95000, Cate.의류,2));
      
      products.add(ex2.new ProductDTO("여름용 이불", 25000, Cate.침구,1));
      products.add(ex2.new ProductDTO("솜 베게", 2000, Cate.침구,10));
      products.add(ex2.new ProductDTO("대나무 베게", 2000, Cate.침구,0));
      products.add(ex2.new ProductDTO("침대 커버 퀸", 15000, Cate.침구,3));
      
      products.add(ex2.new ProductDTO("행거", 60000, Cate.가구,1));
      products.add(ex2.new ProductDTO("책상", 45000, Cate.가구,1));
      products.add(ex2.new ProductDTO("듀오백의자", 145000, Cate.가구,3));
      
      System.out.println(products.toString());
      //편의점 관리 프로그램
      //편의점의 상품 분류, 재고 확인, 분류별 상품의 가격 평균.
      List<ProductDTO> foods = new ArrayList<ProductDTO>();
      for(ProductDTO p : products) {
         if(p.category == Cate.식품) {
            if(p.price>=2000) {
               foods.add(p);
            }
         }
      }//외부 반복문 검사식
      System.out.println(foods);
      
      Optional<String> namesOpt= products.stream()
         .filter((p)->p.category==Cate.식품)//중간연산(Stream을 다시 반환, 이어서 중간연산 가능)
         .filter((p)->p.price>=2000) //중간연산을 수정 삭제하기 편하고 재사용할 수 있다.
         .map((p)->p.name) //반환하는 것으로 자료를 변환
         .reduce((s,s1)->s+", "+s1); //최종연산 BiOperator : (s1,s2)->{return s3}
//       .forEach((p)->{System.out.println(p);}); //최종연산
      
      //reduce 동작원리는??
      
      System.out.println(namesOpt.get());
      
      Optional<Integer>sumOpt=products.stream()
      	.filter(p->p.category==Cate.가구)
      	.map(p->p.price*p.quantity) //중간연산이 IntStream을 반환(기본형 스트림의 장점 1.null없음 2.연산하는 함수를 제공)
      	.reduce((p1,p2)->p1+p2);
//      	.reduce((i1,i2)->i1+i2);
   
      System.out.println("가구의 가격 총합: "+sumOpt.get());
      
      //내부반복문을 사용하면 Stream 자료를 query처럼 제어할 수 있다.
      
      Integer i=null;
//      System.out.println(i+10); //오류 null.intValue()
      i=30;
      System.out.println(i+10);
      
      //Optional : 데이터가 null일 수 있으니 처리하도록 명시하는 타입
      Optional<Integer> i_opt=Optional.empty(); //Optional 선언법
      i_opt=Optional.ofNullable(99); //Optional data를 참조하는 방법
//      System.out.println(i_opt+20);
//      System.out.println(i_opt.get()+20);
      if(i_opt.isPresent()) {
    	  System.out.println(i_opt.get()+20);
      }else {
    	  System.out.println("isPresnt()는 값이 있을 때만 true를 반환, isEmpty()는 null일 때만 ture 반환");
      }
      //반환되는 데이터가 null일 수 있음을 type으로 명시하는 것
      i_opt.ifPresent((num)->{
    	  System.out.println("값이 있을 때만 실행되는 함수");
      });
   }
}
