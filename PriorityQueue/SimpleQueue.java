/**
 * Simple Queue interface.
 *
 * @author Paul Hatalksy And Jonathan Kisch
 * @version 2/5/2016 Developed for CPE 103 project 3
 */
public interface SimpleQueue<E> {
    public E dequeue();

    public void enqueue(E element);

    public E peek();

    public int size();

}