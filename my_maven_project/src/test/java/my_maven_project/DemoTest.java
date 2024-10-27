package my_maven_project;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DemoTest {
	@Test
	public void shouldReturnTrue() {
		
		Demo demo = new Demo();
		assertTrue(demo.getBool());
	}
}
