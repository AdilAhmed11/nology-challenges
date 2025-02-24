package j6_unit_testing;

import org.junit.jupiter.api.Test;

import static jdk.vm.ci.code.CodeUtil.isEven;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ChallengeTest {

    // Naming convention: methodName_StateUnderTest_ExpectedBehaviour

    // isEven method

    @Test
    void isEven_WithEvenNumber_ReturnsTrue() {
        assertTrue( isEven(2));
        assertTrue(isEven(0)); // Edge case: zero is even
        assertTrue(isEven(-4)); // Negative even number
    }

    @Test
    void isEven_WithOddNumber_ReturnsFalse() {
        assertFalse(isEven(1));
        assertFalse(isEven(-7)); // Negative odd number
    }

    //
}
