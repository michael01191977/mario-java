import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import main.java.Mario;

public class PyramidTest {
	public static void main(String[] argv) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
		Mario mario1 = (Mario) context.getBean("mario1");
		mario1.assemblePyramid();
	}
}
