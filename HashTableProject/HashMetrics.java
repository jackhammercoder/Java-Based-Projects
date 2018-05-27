/**
 * HashMetrics class
 * @author Jonathan Kisch
 * version 2/24/2016
 */

public interface HashMetrics {

	long collisions();

	int lastOpCollisions();

	int maxCollisions();

	double avgCollisions();

}
