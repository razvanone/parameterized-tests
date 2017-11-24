/**
 * 
 */
package com.razvanm.romannums;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.googlecode.junittoolbox.ParallelParameterized;
import com.razvanm.Repeat;
import com.razvanm.RepeatRule;
import com.razvanm.romannums.RomanArabicPair;
import com.razvanm.romannums.RomanNums;

/**
 * @author rmihailescu
 *
 */
@RunWith(value = ParallelParameterized.class)
// @RunWith(value = Parameterized.class)
public class RomanNumsTest {
	@Rule
	public RepeatRule repeatRule = new RepeatRule();

	@Parameter(0)
	public /* NOT private */ int fInput;
	@Parameter(1)
	public /* NOT private */ String fExpected;

	/**
	 * I II III IV V VI VII VIII IX
	 * X XX XXX XL L LX LXX LXXX XC
	 * C CC CCC CD D DC DCC DCCC CM
	 * M MM
	 */
	@Parameters(name = "{index}: testConvertFromArabic({0}) => {1}")
	public static Collection<Object[]> data() {
		Collection<Object[]> testData = new ArrayList<>();

		for (int i = 0; i < 1; i++) {
			testData.addAll(Arrays.asList(new Object[][] { { 1, "I" }, { 744, "DCCXLIV" }, { 9, "IX" }, { 10, "X" },
					{ 14, "XIV" }, { 99, "XCIX" }, { 5, "V" }, { 8, "VIII" } }));
		}

		return testData;
	}

	@Test
	@Repeat(value = 50000000)
	public void testConvertFromArabic() {
		RomanArabicPair romanArabicPair = new RomanArabicPair(fInput, "");
		RomanNums.convertFromArabic(romanArabicPair);
		assertThat(romanArabicPair.getRomanNum(), is(fExpected));
	}
}
