package com.mycompany.app;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@Test
	public void testAppConstructor() {
		try {
			new App();
		} catch (Exception e) {
			fail("Construction failed.");
		}
	}

	@Test
	public void testAppMain() {
		App.main(null);
//		try {
//			assertEquals("Hello World!" + System.getProperty("line.separator"), outContent.toString());
//		} catch (AssertionError e) {
//			fail("\"message\" is not \"Hello World!\"");
//		}
		try {
			testCalculatorAdd(1,2,3);
			testCalculatorMinus(5, 1, 3);
		} catch (AssertionError e) {
			fail("Loi: " + e.getMessage());
		}
	}

	public void testCalculatorAdd(int x, int y, int sum) {
		try {
			assertEquals(x + y, sum);
		} catch (AssertionError e) {
			throw new AssertionError("Tong sai roi nhe: " + x + " + " + y + "=" + sum);
		}
	}

	public void testCalculatorMinus(int x, int y, int minus) {
		try {
			assertEquals(x - y, minus);
		} catch (AssertionError e) {
			throw new AssertionError("Tinh hieu sai roi nhe: " + x + " - " + y + "=" + minus);
		}
	}

	@After
	public void cleanUpStreams() {
		System.setOut(null);
	}

}
