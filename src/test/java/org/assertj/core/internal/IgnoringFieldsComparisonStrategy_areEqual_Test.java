package org.assertj.core.internal;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class IgnoringFieldsComparisonStrategy_areEqual_Test {

    private IgnoringFieldsComparisonStrategy onFieldsComparisonStrategy;

    @Before
    public void setUp() {
        onFieldsComparisonStrategy = new IgnoringFieldsComparisonStrategy("thinking");
    }

    @Test
    public void should_return_true_if_both_Objects_are_null() {
        assertTrue(onFieldsComparisonStrategy.areEqual(null, null));
    }

    @Test
    public void should_return_are_not_equal_if_first_Object_is_null_and_second_is_not() {
        assertFalse(onFieldsComparisonStrategy.areEqual(null, new DarthVader("I like you", "I'll kill you")));
    }

    @Test
    public void should_return_are_not_equal_if_second_Object_is_null_and_first_is_not() {
        assertFalse(onFieldsComparisonStrategy.areEqual(new DarthVader("I like you", "I'll kill you"), null));
    }

    @Test
    public void should_return_true_if_all_but_ignored_fields_are_equal() {
        assertTrue(onFieldsComparisonStrategy.areEqual(new DarthVader("I like you", "I'll kill you"), new DarthVader("I like you", "I like you")));
    }

    @Test
    public void should_return_false_if_all_but_ignored_fields_are_not_equal() {
        assertFalse(onFieldsComparisonStrategy.areEqual(new DarthVader("I like you", "I'll kill you"), new DarthVader("I'll kill you", "I'll kill you")));
    }

    @Test
    public void should_return_are_not_equal_if_Objects_are_not_equal() {
        assertFalse(onFieldsComparisonStrategy.areEqual(new DarthVader("I like you", "I'll kill you"), 2));
    }

    public static class DarthVader {

        public final String telling;
        public final String thinking;

        public DarthVader(String telling, String thinking) {
            this.telling = telling;
            this.thinking = thinking;
        }

    }


}