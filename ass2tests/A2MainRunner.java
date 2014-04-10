package se701;

import java.io.File;
import java.io.FileNotFoundException;

import japa.parser.ParseException;

public class A2MainRunner {

	public static void main(String[] args) {
		
		System.out.println("Pass\n====");
		/* Pass
		 * These tests will be testing correctness of your Semantic Analysis visitors. The marker will be using their own files here. 
		 */
		for (int i = 1; i <= 8; i++) { 
			String file = "tests/Pass"+i+".javax";
			try {
				A2Compiler.compile(new File(file));
				System.out.println(file+" ... OK");
			} catch (ParseException e) {
				System.err.println(file+" Parser exception... "+e.getMessage());
			} catch (A2SemanticsException e) {
				System.err.println(file+" Semantics exception... "+e.getMessage());
			}  catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("\nFails\n=====");
		/* Fails
		 * These tests will be testing correctness of your Semantic Analysis visitors. The marker will be using their own files here. 
		 */
		for (int i = 1; i <= 13; i++) { 
			String file = "tests/Fail"+i+".javax";
			try {
				A2Compiler.compile(new File(file));
				throw new TestFailExecption();
			} catch (ParseException e) {
				System.out.println(file+" Parser exception... "+e.getMessage());
			} catch (A2SemanticsException e) {
				System.out.println(file+" Semantics exception... "+e.getMessage());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (TestFailExecption e) {
				System.err.println(file + " should have failed");
			}
		}
		
		System.out.println("\nStudent Sample\n==============");
		/*
		 * This is to compile YOUR supplied sample, make sure it compiles (i.e. should not throw a ParseException or anything). It should compile, and the marker
		 * should be able to run it (so it needs to have a main() file inside it!)
		 */
		try {
			A2Compiler.compile(new File("src"+System.getProperty("file.separator")+"se701"+System.getProperty("file.separator")+"StudentSample.javax"));
			System.out.println("src/se701.StudentSample compiled correctly");
		} catch (ParseException e) {
			System.err.println("Student file should not have any errors! ");
			//e.printStackTrace();
		} catch (A2SemanticsException e) {
			System.err.println("Student file should not have any errors! ");
			e.printStackTrace();
		}  catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}

class TestFailExecption extends Exception {
	
}