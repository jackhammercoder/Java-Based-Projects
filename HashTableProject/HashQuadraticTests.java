/**
 * Junit Tests for HashQuadratic class
 * @author Jonathan Kisch
 * version 2/24/2016
 */

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class HashQuadraticTests {

	@Test
	public void test_01_IntgerHash() { // if this test passes you are in good
										// standing
		HashQuadratic<Integer> testhash = new HashQuadratic<Integer>(40);

		testhash.insert(1);
		assertTrue(testhash.size() == 1);
		Double loadfactor = testhash.loadFactor();
		double actualLF = 1.0 / 41.0;
		assertTrue(loadfactor.equals(actualLF));
		long collisions = testhash.collisions();
		int lastop = testhash.lastOpCollisions();
		int maxCollisions = testhash.maxCollisions();
		Double avgcoll = testhash.avgCollisions();
		assertTrue(collisions == 0 && lastop == 0 && maxCollisions == 0 && avgcoll.equals(0.0));

		testhash.insert(1);
		assertTrue(testhash.size() == 1);
		loadfactor = testhash.loadFactor();
		actualLF = 1.0 / 41.0;
		assertTrue(loadfactor.equals(actualLF));
		collisions = testhash.collisions();
		lastop = testhash.lastOpCollisions();
		maxCollisions = testhash.maxCollisions();
		avgcoll = testhash.avgCollisions();
		assertTrue(collisions == 0 && lastop == 0 && maxCollisions == 0 && avgcoll.equals(0.0));

		testhash.insert(42);
		assertTrue(testhash.size() == 2);
		loadfactor = testhash.loadFactor();
		actualLF = 2.0 / 41.0;
		assertTrue(loadfactor.equals(actualLF));
		collisions = testhash.collisions();
		lastop = testhash.lastOpCollisions();
		maxCollisions = testhash.maxCollisions();
		avgcoll = testhash.avgCollisions();
		assertTrue(collisions == 1);
		assertTrue(lastop == 1);
		assertTrue(maxCollisions == 1);
		assertTrue(avgcoll.equals((1.0 / 3.0)));

		testhash.insert(42);
		assertTrue(testhash.size() == 2);
		loadfactor = testhash.loadFactor();
		actualLF = 2.0 / 41.0;
		assertTrue(loadfactor.equals(actualLF));
		collisions = testhash.collisions();
		lastop = testhash.lastOpCollisions();
		maxCollisions = testhash.maxCollisions();
		avgcoll = testhash.avgCollisions();
		assertTrue(collisions == 2 && lastop == 1 && maxCollisions == 1 && avgcoll.equals(.5));

		testhash.insert(83);
		assertTrue(testhash.size() == 3);
		loadfactor = testhash.loadFactor();
		actualLF = 3.0 / 41.0;
		assertTrue(loadfactor.equals(actualLF));
		collisions = testhash.collisions();
		lastop = testhash.lastOpCollisions();
		maxCollisions = testhash.maxCollisions();
		avgcoll = testhash.avgCollisions();
		assertTrue(collisions == 4);
		assertTrue(lastop == 2);
		assertTrue(maxCollisions == 2);
		assertTrue(avgcoll.equals(4.0 / 5.0));

		testhash.insert(42);
		assertTrue(testhash.size() == 3);
		loadfactor = testhash.loadFactor();
		actualLF = 3.0 / 41.0;
		assertTrue(loadfactor.equals(actualLF));
		collisions = testhash.collisions();
		lastop = testhash.lastOpCollisions();
		maxCollisions = testhash.maxCollisions();
		avgcoll = testhash.avgCollisions();
		assertTrue(collisions == 5);
		assertTrue(lastop == 1);
		assertTrue(maxCollisions == 2);
		assertTrue(avgcoll.equals(5.0 / 6.0));

		testhash.insert(1);
		assertTrue(testhash.size() == 3);
		loadfactor = testhash.loadFactor();
		actualLF = 3.0 / 41.0;
		assertTrue(loadfactor.equals(actualLF));
		collisions = testhash.collisions();
		lastop = testhash.lastOpCollisions();
		maxCollisions = testhash.maxCollisions();
		avgcoll = testhash.avgCollisions();
		assertTrue(collisions == 5);
		assertTrue(lastop == 0);
		assertTrue(maxCollisions == 2);
		assertTrue(avgcoll.equals(5.0 / 7.0));

		testhash.remove(1);
		assertTrue(testhash.size() == 2);
		loadfactor = testhash.loadFactor();
		actualLF = 2.0 / 41.0;
		assertTrue(loadfactor.equals(actualLF));
		collisions = testhash.collisions();
		lastop = testhash.lastOpCollisions();
		maxCollisions = testhash.maxCollisions();
		avgcoll = testhash.avgCollisions();
		assertFalse(testhash.contains(1));
		assertTrue(testhash.contains(42));
		assertTrue(testhash.contains(83));
		assertTrue(collisions == 5);
		assertTrue(lastop == 0); // last for remove
		assertTrue(maxCollisions == 2);
		assertTrue(avgcoll.equals(5.0 / 7.0));

		testhash.remove(1); // shouldn't throw an error
		assertTrue(testhash.size() == 2);
		loadfactor = testhash.loadFactor();
		actualLF = 2.0 / 41.0;
		assertTrue(loadfactor.equals(actualLF));
		collisions = testhash.collisions();
		lastop = testhash.lastOpCollisions();
		maxCollisions = testhash.maxCollisions();
		avgcoll = testhash.avgCollisions();
		assertFalse(testhash.contains(1));
		assertTrue(testhash.contains(42));
		assertTrue(testhash.contains(83));
		assertTrue(collisions == 5);
		assertTrue(lastop == 0); // still tried to search for the node
									// containing 1;
		assertTrue(maxCollisions == 2);
		assertTrue(avgcoll.equals(5.0 / 7.0));

		testhash.remove(83);
		assertTrue(testhash.size() == 1);
		loadfactor = testhash.loadFactor();
		actualLF = 1.0 / 41.0;
		assertTrue(loadfactor.equals(actualLF));
		collisions = testhash.collisions();
		lastop = testhash.lastOpCollisions();
		maxCollisions = testhash.maxCollisions();
		avgcoll = testhash.avgCollisions();
		assertFalse(testhash.contains(1));
		assertTrue(testhash.contains(42));
		assertFalse(testhash.contains(83));
		assertTrue(collisions == 5);
		assertTrue(lastop == 2); // still tried to search for the node
									// containing 1;
		assertTrue(maxCollisions == 2);
		assertTrue(avgcoll.equals(5.0 / 7.0));

		testhash.remove(83);
		assertTrue(testhash.size() == 1);
		loadfactor = testhash.loadFactor();
		actualLF = 1.0 / 41.0;
		assertTrue(loadfactor.equals(actualLF));
		collisions = testhash.collisions();
		lastop = testhash.lastOpCollisions();
		maxCollisions = testhash.maxCollisions();
		avgcoll = testhash.avgCollisions();
		assertFalse(testhash.contains(1));
		assertTrue(testhash.contains(42));
		assertFalse(testhash.contains(83));
		assertTrue(collisions == 5);
		assertTrue(lastop == 2); // still tried to search for the node
									// containing 83;
		assertTrue(maxCollisions == 2);
		assertTrue(avgcoll.equals(5.0 / 7.0));

		testhash.remove(42);
		assertTrue(testhash.size() == 0);
		loadfactor = testhash.loadFactor();
		actualLF = 0.0 / 41.0;
		assertTrue(loadfactor.equals(actualLF));
		collisions = testhash.collisions();
		lastop = testhash.lastOpCollisions();
		maxCollisions = testhash.maxCollisions();
		avgcoll = testhash.avgCollisions();
		assertFalse(testhash.contains(1));
		assertFalse(testhash.contains(42));
		assertFalse(testhash.contains(83));
		assertTrue(collisions == 5);
		assertTrue(lastop == 1); // still tried to search for the node
									// containing 83;
		assertTrue(maxCollisions == 2);
		assertTrue(avgcoll.equals(5.0 / 7.0));

		testhash.remove(42);
		assertTrue(testhash.size() == 0);
		loadfactor = testhash.loadFactor();
		actualLF = 0.0 / 41.0;
		assertTrue(loadfactor.equals(actualLF));
		collisions = testhash.collisions();
		lastop = testhash.lastOpCollisions();
		maxCollisions = testhash.maxCollisions();
		avgcoll = testhash.avgCollisions();
		assertFalse(testhash.contains(1));
		assertFalse(testhash.contains(42));
		assertFalse(testhash.contains(83));
		assertTrue(collisions == 5);
		assertTrue(lastop == 0); // still tried to search for the node
									// containing 83;
		assertTrue(maxCollisions == 2);
		assertTrue(avgcoll.equals(5.0 / 7.0));

	}

	@Test(expected = HashLoadFactorException.class)
	public void test_2_ExceptionThrown() {
		HashQuadratic<Integer> testhash = new HashQuadratic<Integer>(40);
		for (int i = 0; i < 21; i++) {
			testhash.insert(i);
		}
		testhash.insert(1); // this should make it throw the exception

	}

	@Test
	public void test_3_ContainsandRemoveandinsert() {
		HashQuadratic<Integer> testhash = new HashQuadratic<Integer>(10);
		testhash.insert(0);
		testhash.insert(11);
		testhash.insert(22);
		testhash.insert(33);
		testhash.insert(44);

		assertTrue(testhash.contains(0));
		assertTrue(testhash.lastOpCollisions() == 0);

		assertTrue(testhash.contains(11));
		assertTrue(testhash.lastOpCollisions() == 1);

		assertTrue(testhash.contains(22));
		assertTrue(testhash.lastOpCollisions() == 2);

		assertTrue(testhash.contains(33));
		assertTrue(testhash.lastOpCollisions() == 3);

		assertTrue(testhash.contains(44));
		assertTrue(testhash.lastOpCollisions() == 4);

		testhash.remove(0);
		assertTrue(testhash.lastOpCollisions() == 0);
		assertFalse(testhash.contains(0));

		testhash.insert(0);
		assertTrue(testhash.lastOpCollisions() == 0);
		assertTrue(testhash.contains(0));
		assertTrue(testhash.lastOpCollisions() == 0);

		testhash.remove(22);
		assertTrue(testhash.lastOpCollisions() == 2);
		testhash.remove(33);
		assertTrue(testhash.lastOpCollisions() == 3);

		testhash.insert(5);
		assertTrue(testhash.lastOpCollisions() == 1);

		testhash.insert(3);
		assertTrue(testhash.lastOpCollisions() == 0);

		assertTrue(testhash.collisions() == 11);
		assertTrue(testhash.maxCollisions() == 4);
		assertTrue(testhash.avgCollisions() == (11.0 / 8.0));

	}

}
