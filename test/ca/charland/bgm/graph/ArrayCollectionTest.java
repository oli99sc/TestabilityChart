package ca.charland.bgm.graph;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

/**
 * Tests for ArrayCollection.
 * 
 * @author mcharland
 */
public class ArrayCollectionTest {

	/**
	 * Test.
	 */
	@Test
	public void test() {
		assertNotNull(new ArrayCollection(0));
	}

	/**
	 * Test add.
	 */
	@Test
	public void testAdd() {
		ArrayCollection ac = new ArrayCollection(2);
		Bubble b = new Bubble(null, 0, 0, "");

		ac.add(b);

		List<Bubble> element = ac.getElements();

		assertNotNull(element);
		assertEquals(1, element.size());
	}

	/**
	 * Test to string.
	 */
	@Test
	public void testToString() {
		ArrayCollection ac = new ArrayCollection(134);
		Bubble b = new Bubble(null, 0, 0, "");
		ac.add(b);

		String out = ac.toString();

		StringBuffer expected = new StringBuffer();
		String tabs = "\t\t\t";
		expected.append(tabs).append("[Bindable]\r\n");
		expected.append(tabs).append("private var s134:ArrayCollection = new ArrayCollection( [\r\n");
		expected.append(tabs).append('\t').append(b.toString()).append("\r\n");
		expected.append(tabs).append("]);\r\n");
		assertEquals(expected.toString(), out);
	}

	/**
	 * Test to string.
	 */
	@Test
	public void testToStringTwoLines() {
		ArrayCollection ac = new ArrayCollection(3);
		Bubble b = new Bubble(null, 0, 0, "");
		ac.add(b);
		Bubble b2 = new Bubble(null, 0, 0, "");
		ac.add(b2);

		String out = ac.toString();

		StringBuffer expected = new StringBuffer();
		String tabs = "\t\t\t";
		expected.append(tabs).append("[Bindable]\r\n");
		expected.append(tabs).append("private var s3:ArrayCollection = new ArrayCollection( [\r\n");
		expected.append(tabs).append('\t').append(b.toString()).append(",\r\n");
		expected.append(tabs).append('\t').append(b2.toString()).append("\r\n");
		expected.append(tabs).append("]);\r\n");
		assertEquals(expected.toString(), out);
	}

}
