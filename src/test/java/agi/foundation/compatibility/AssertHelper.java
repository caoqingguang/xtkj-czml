package agi.foundation.compatibility;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.lang.reflect.Array;

import org.junit.Assert;
import org.junit.internal.ArrayComparisonFailure;

/**
 * Extra assert methods.
 */
public final class AssertHelper {
    private AssertHelper() {}

    public static <T> void assertContains(T expected, Iterable<T> actual) {
        assertThat(actual, hasItem(expected));
    }

    public static void assertNotEqual(Object expected, Object actual) {
        assertNotEqual("", expected, actual);
    }

    public static void assertNotEqual(String message, Object expected, Object actual) {
        assertThat(message, actual, not(equalTo(expected)));
    }

    public static void assertIsEmpty(String actual) {
        assertThat(actual, isEmptyString());
    }

    public static <T extends Comparable<T>> void assertLess(T a, T b) {
        assertThat(a, lessThan(b));
    }

    public static <T extends Comparable<T>> void assertGreater(T a, T b) {
        assertThat(a, greaterThan(b));
    }

    public static void assertStringContains(String expected, String actual) {
        assertThat(actual, containsString(expected));
    }

    public static void assertStringContains(String message, String expected, String actual) {
        assertThat(message, actual, containsString(expected));
    }

    public static void assertStringStartsWith(String expected, String actual) {
        assertThat(actual, startsWith(expected));
    }

    public static void assertStringStartsWith(String message, String expected, String actual) {
        assertThat(message, actual, startsWith(expected));
    }

    // NUnit allows comparing two boxed numbers of different type.
    public static void assertEquals(Object expected, Object actual) {
        assertEquals(null, expected, actual);
    }

    public static void assertEquals(String message, Object expected, Object actual) {
        if (expected instanceof Number && actual instanceof Number) {
            assertNumbersAreEqual(message, expected, actual);
        } else if (isArray(expected) && isArray(actual)) {
            assertArraysAreEqual(message, expected, actual);
        } else {
            Assert.assertEquals(message, expected, actual);
        }
    }

    private static boolean isArray(Object obj) {
        return obj != null && obj.getClass().isArray();
    }

    // based on the internal implementation of Assert.assertArrayEquals
    private static void assertArraysAreEqual(String message, Object expecteds, Object actuals) {
        if (expecteds == actuals) {
            return;
        }

        String header = message == null ? "" : message + ": ";

        if (expecteds == null) {
            fail(header + "expected array was null");
        }

        if (actuals == null) {
            fail(header + "actual array was null");
        }

        int actualsLength = Array.getLength(actuals);
        int expectedsLength = Array.getLength(expecteds);
        if (actualsLength != expectedsLength) {
            fail(header + "array lengths differed, expected.length=" + expectedsLength + " actual.length=" + actualsLength);
        }

        for (int i = 0; i < expectedsLength; i++) {
            Object expected = Array.get(expecteds, i);
            Object actual = Array.get(actuals, i);

            if (isArray(expected) && isArray(actual)) {
                try {
                    assertArraysAreEqual(message, expected, actual);
                } catch (ArrayComparisonFailure e) {
                    e.addDimension(i);
                    throw e;
                }
            } else {
                try {
                    Assert.assertEquals(expected, actual);
                } catch (AssertionError e) {
                    throw new ArrayComparisonFailure(header, e, i);
                }
            }
        }
    }

    private static void assertNumbersAreEqual(String message, Object expected, Object actual) {
        // based on the logic in NUnit
        if (expected instanceof Double || actual instanceof Double) {
            Assert.assertEquals(message, ConvertHelper.toDouble(expected), ConvertHelper.toDouble(actual), 0D);
        } else if (expected instanceof Float || actual instanceof Float) {
            Assert.assertEquals(message, ConvertHelper.toSingle(expected), ConvertHelper.toSingle(actual), 0D);
        } else if (expected instanceof Long || actual instanceof Long) {
            Assert.assertEquals(message, ConvertHelper.toInt64(expected), ConvertHelper.toInt64(actual));
        } else {
            Assert.assertEquals(message, ConvertHelper.toInt32(expected), ConvertHelper.toInt32(actual));
        }
    }
}