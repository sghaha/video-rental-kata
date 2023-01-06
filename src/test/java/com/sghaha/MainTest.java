package com.sghaha;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    @DisplayName("초기 테스트")
    void name() {
        Assertions.assertThat(10).isEqualTo(10);
    }
}