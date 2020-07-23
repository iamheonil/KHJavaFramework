package test04;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class BeanTest {

	private MyClass myClass;

	public BeanTest() {
		System.out.println("Bean-Test Call");
	}

	public BeanTest(Date date) {
		System.out.println("날씨 생성자 (date : " + date + " )");
	}

	public void setMyClass(MyClass myClass) {
		this.myClass = myClass;
		System.out.println("setMyClass Call : " + myClass);
	}

	public void setNumber(int num) {
		System.out.println("setNumber Call " + num);
	}

	// 배열
	public void setArray(String[] arr) {
		System.out.println("setArr Call : " + Arrays.deepToString(arr));
	}

	// 리스트
	public void setList(List<String> list) {
		System.out.println("setList Call : " + list);
	}

	// set
	public void setSet(Set<String> set) {
		System.out.println("setSet Call : " + set);
	}

	// map
	public void setMap(Map<String, String> map) {
		System.out.println("setMap Call : " + map);
	}

	// properties
	public void setProperties(Properties properties) {
		System.out.println("setProPerties Call : " + properties);
	}

	// Collection
	public void setScore(List<Score> list) {
		System.out.println("setScore Call!");

		for(Score sc : list) {
			System.out.println(list);
		}
	}
}
