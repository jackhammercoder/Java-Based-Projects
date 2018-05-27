
/**
 * JUnit tests for RPN.
 *
 * @author  Jonathan Kisch 
 * @version 1/25/2016 Developed for CPE 103 project 2
 */
import static org.junit.Assert.*;
import org.junit.*;


public class RPNTests {

	@Test
	public void test_01_Evaluating_SimpleRPN() {
		String RPNtest = "3 7 2 * +";
		Double test = RPN.evaluateRPN(RPNtest);
		assertTrue(17 == test);
	}

	@Test
	public void test_02_Evaluating_SimpleRPN() {
		String RPNtest = "3 4 +";
		Double test = RPN.evaluateRPN(RPNtest);
		assertTrue(7 == test);
	}

	@Test
	public void test_03_Evaluating_SimpleRPN() {
		String RPNtest = "3 5 6 + *";
		Double test = RPN.evaluateRPN(RPNtest);
		assertTrue(33 == test);
	}

	@Test
	public void test_04_Evaluating_SimpleRPN() {
		String RPNtest = "2 4 / 5 6 - *";
		Double test = RPN.evaluateRPN(RPNtest);
		assertTrue(-0.5 == test);
	}

	@Test
	public void test_05_Evaluating_withnegativeSimpleRPN() {
		String RPNtest = "-2 4 / 5 6 - *";
		Double test = RPN.evaluateRPN(RPNtest);
		assertTrue(0.5 == test);
	}

	@Test
	public void test_06_NegativeEvaluating_SimpleRPN() {
		String RPNtest = "-3 5 6 + *";
		Double test = RPN.evaluateRPN(RPNtest);
		assertTrue(-33 == test);

	}

	@Test
	public void test_07_withtwonegativeEvaluating_SimpleRPN() {
		String RPNtest = "-3 5 -6 + *";
		Double test = RPN.evaluateRPN(RPNtest);
		assertTrue(3 == test);
	}

	@Test
	public void test_08_withtwonegativeEvaluating_SimpleRPN() {
		String RPNtest = "-3         5          -6      +      *       ";
		Double test = RPN.evaluateRPN(RPNtest);
		assertTrue(3 == test);
	}

	@Test
	public void test_09_NegativeEvaluating_SimpleRPN() {
		String RPNtest = "   -3                            5                 6         +        *                     ";
		Double test = RPN.evaluateRPN(RPNtest);
		assertTrue(-33 == test);

	}

	@Test
	public void test_10_converttoRPNlabexample() {
		String infix = "3 + ( 7 * 2 )";
		String RPNres = RPN.toRPN(infix);
		assertTrue(RPNres.equals("3 7 2 * +"));
	}

	@Test
	public void test_11_converttoRPNexample2() {
		String infix = "3 + 7 * 2";
		String RPNres = RPN.toRPN(infix);
		assertTrue(RPNres.equals("3 7 2 * +"));
	}

	@Test
	public void test_12_converttoRPNexample3() {
		String infix = "( 7 * 2 ) + 3";
		String RPNres = RPN.toRPN(infix);
		assertTrue(RPNres.equals("7 2 * 3 +"));
	}

	@Test
	public void test_13_converttoRPNexample4() {
		String infix = "7 * 2 + 3";
		String RPNres = RPN.toRPN(infix);
		assertTrue(RPNres.equals("7 2 * 3 +"));
	}

	@Test
	public void test_14_ComplicatedInfix() {
		String infix = "( 4 * 5 ) / 32 + ( 82 / 33 ) * ( ( 87 / 3.4 ) - ( 99 * 30 ) )";
		String RPNres = RPN.toRPN(infix);
		assertTrue(RPNres.equals("4 5 * 32 / 82 33 / 87 3.4 / 99 30 * - * +"));
	}
	
	@Test
	public void test_15_ComplicatedInfix2() { 				// This is the true test, fingers crossed
		String infix = "( ( 4 * 5 ) / 32 + ( 82 / 33 ) * ( ( 87 / 3.4 ) - ( 99 * 30 ) ) ) / ( 33.4 / 2.38 + 44.67 - ( 1 * 2349 ) + ( ( 1 * 88 ) + 0 ) ) ";
		String RPNres = RPN.toRPN(infix);
		assertTrue(RPNres.equals("4 5 * 32 / 82 33 / 87 3.4 / 99 30 * - * + 33.4 2.38 / 44.67 + 1 2349 * - 1 88 * 0 + + /"));
	}
	
	@Test
	public void test_16_ComplicatedInfix3() { 				// This is the true test, fingers crossed
		String infix = "4 * 5 / 32 + 82 / 33 * 87 / 3.4 - 99 * 30 / 33.4 / 2.38 + 44.67 - 1 * 2349 + 1 * 88 + 0";
		String RPNres = RPN.toRPN(infix);
		assertTrue(RPNres.equals("4 5 * 32 / 82 33 / 87 * 3.4 / + 99 30 * 33.4 / 2.38 / - 44.67 + 1 2349 * - 1 88 * + 0 +"));
	}
	
	@Test
	public void test_17_test_with_negatives() { 				// This is the true test, fingers crossed
		String infix = "( -4 * 5 ) / -32 + ( 82 / -33 ) * ( ( 87 / -3.4 ) - ( 99 * -30 ) )";
		String RPNres = RPN.toRPN(infix);
		assertTrue(RPNres.equals("-4 5 * -32 / 82 -33 / 87 -3.4 / 99 -30 * - * +"));
	}
	
	@Test
	public void test_18_testingEvaluateInfix() { 				
		String infix = "3 + ( 7 * 2 )";
		Double RPNres = RPN.evaluateInfix(infix);
		assertTrue(17 == RPNres);
	}
	
	@Test
	public void test_19_testingEvaluateInfix() { 				
		String infix = "7 * 2 + 3";
		Double RPNres = RPN.evaluateInfix(infix);
		assertTrue(17 == RPNres);
	}
	
	@Test
	public void test_20_testingEvaluateInfix() { 				
		String infix = "( -4 * 5 ) / -32 + ( 82 / -33 ) * ( ( 87 / -3.4 ) - ( 99 * -30 ) )";
		Double RPNres = RPN.evaluateInfix(infix);
		assertTrue(Math.abs(Math.abs(RPNres) - Math.abs(7315.7921123)) < .00000001);  // checks if two doubles are the same, this is an epsilon definition. 
	}
	
	@Test
	public void test_21_testingEvaluateInfix() { 				
		String infix = "4 * 5 / 32 + 82 / 33 * 87 / 3.4 - 99 * 30 / 33.4 / 2.38 + 44.67 - 1 * 2349 + 1 * 88 + 0";
		Double RPNres = RPN.evaluateInfix(infix);
		assertTrue(Math.abs(Math.abs(RPNres) - Math.abs(-2189.48436259)) < .00000001);  // checks if two doubles are the same, this is an epsilon definition. 
	}
	
}
	

