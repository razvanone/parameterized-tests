/**
 *
 */
package com.razvanm;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.razvanm.mathutils.ParameterizedTest;
import com.razvanm.romannums.RomanNumsTest;

/**
 * @author rmihailescu
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(value = { ParameterizedTest.class, RomanNumsTest.class })
public class SuiteAll {
}
