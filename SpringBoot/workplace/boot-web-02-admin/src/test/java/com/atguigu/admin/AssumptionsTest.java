package com.atguigu.admin;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assumptions.*;

@DisplayName("前置条件")
public class AssumptionsTest {
    private final String environment = "DEV";

    @Test
    @DisplayName("assumptions1")
    public void simpleAssume() {
        assumeTrue(Objects.equals(this.environment, "DE3V"));
        assumeFalse(() -> Objects.equals(this.environment, "PROD"));
    }

    @Test
    @DisplayName("assumptions2")
    public void assumeThenDo() {
        assumingThat(
                Objects.equals(this.environment, "D3EV"),
                () -> System.out.println("In DEV")
        );
    }
}
