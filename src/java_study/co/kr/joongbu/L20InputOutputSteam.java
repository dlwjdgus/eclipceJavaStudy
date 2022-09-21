package java_study.co.kr.joongbu;

import java.io.IOException;

public class L20InputOutputSteam {

	public static void main(String[] args) {
		//입출력(IO) 장치와 스크립
		//입력(input)과 출력(output) : 컴퓨터 내부(cpu,memory), 외부(장치)에서 프로그램간에 데이터를 주고 받는 것
		//파일을 입력받거나 출력하는 행위
		//소리를 출력, 키보드 or 마우스 입력
		//모니터에 출력
		try {
			int i=System.in.read();
			System.out.println("입력한 값: "+i);
			//아스키코드(1byte):최초로 만들어진 문자표, 유니코드(2byte):모든 문자를 사용하기 위해 만들어지 문자표
			//입출력능 기본 1byte를 기준으로 data를 입력하거나 출력한다.
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
