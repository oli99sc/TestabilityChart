package ca.charland.bgm.graph;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * Tests for Bubble Series.
 * 
 * @author mcharland
 * 
 */
public class BubbleSeriesTest {

	/**
	 * Simple constructor test.
	 */
	@Test
	public void test() {
		assertNotNull(new BubbleSeries(3, "author"));
	}

	/**
	 * Testing to string.
	 */
	@Test
	public void testToString() {
		// Setup
		BubbleSeries bs = new BubbleSeries(2, "mcharland");

		// Exercise
		String string = bs.toString();

		// Verify
		StringBuffer actual = new StringBuffer();
		String tabs = "\t\t\t\t";
		actual.append(tabs).append("<mx:BubbleSeries\r\n");
		actual.append(tabs).append('\t').append("dataProvider=\"{s2}\"\r\n");
		actual.append(tabs).append('\t').append("displayName=\"mcharland\"\r\n");
		actual.append(tabs).append('\t').append("xField=\"Date\"\r\n");
		actual.append(tabs).append('\t').append("yField=\"Coverage\"\r\n");
		actual.append(tabs).append('\t').append("radiusField=\"Size\"\r\n");
		actual.append(tabs).append("/>\r\n");
		assertEquals(actual.toString(), string);
	}
}
