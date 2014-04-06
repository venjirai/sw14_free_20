package com.example.nokiaphonesimulator.test;

import junit.framework.TestCase;

public class SampleJUnitTest extends TestCase {

	public SampleJUnitTest() {
		super();
	}

	public void testAddition() {

	   // trivial test:
	   assertEquals("4 + 5 must be 9", 9, 4+5);
	 } 
}