package java_study.co.kr.joongbu;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.AutoCloseable; //try()에서 생성한 객체를 자동으로 close해주는 문법

public class L23FileReader {

	public static void main(String[] args) {
		
		try(
			FileReader fr=new FileReader("src/java_study/co/kr/joongbu/L20InputOutputSteam.java");//문자열로 작성된 파일을 불러오는 객체
			BufferedReader br=new BufferedReader(fr);
				) {
			String line=null;
			while((line=br.readLine())!=null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}
//catch (FileNotFoundException e) {e.printStackTrace();} //자식의 예외보다 부모의 예외가 먼저있으면 절대로 실행되지 않는다.(컴파일 오류)
//Exception > IOException > FileNotFoundException