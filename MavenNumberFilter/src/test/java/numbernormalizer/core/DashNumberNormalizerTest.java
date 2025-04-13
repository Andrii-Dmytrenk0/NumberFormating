package numbernormalizer.core;

import org.assertj.core.api.Assertions;
import org.example.numbernormalizer.core.DashNumberNormalizer;
import org.example.numbernormalizer.usecase.NumberNormalizer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DashNumberNormalizerTest {
    private NumberNormalizer normalizer;

    @Test
    @DisplayName("Should normalize valid 11 digit number")
    void test1() {
        //given
        normalizer = new DashNumberNormalizer();
        var numberToNormalize = "12345678901";
        //when
        var normalizedNumber = normalizer.normalize(numberToNormalize);
        //then
        Assertions.assertThat(normalizedNumber).isEqualTo("12-345-678-901");
    }

    @Test
    @DisplayName("Should throw exception when given 12 digit number")
    void test2() {
        //given
        normalizer = new DashNumberNormalizer();
        var numberToNormalize = "123456789012";
        //when
        Assertions.assertThatThrownBy(() -> normalizer.normalize(numberToNormalize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Given input: "  + numberToNormalize + " is incorect, insert 11 digit number");
    }

    @Test
    @DisplayName("Should throw exception when given number contains letters")
    void test3() {
        //given
        normalizer = new DashNumberNormalizer();
        var numberToNormalize = "1234s678901";
        //when
        Assertions.assertThatThrownBy(() -> normalizer.normalize(numberToNormalize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Given input: "  + numberToNormalize + " is incorect, insert 11 digit number");
    }

    @Test
    @DisplayName("Should normalize valid 11 digit number")
    void test4() {
        //given
        normalizer = new DashNumberNormalizer();
        var numberToNormalize = " 1234s678901 ";
        //when
        var normalizedNumber = normalizer.normalize(numberToNormalize);
        //then
        Assertions.assertThat(normalizedNumber).isEqualTo("12-345-678-901");
    }
}



