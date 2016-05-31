package jaxrs;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Adder {

    String add(String x, String y) {
        BigDecimal addend = new BigDecimal(x);
        BigDecimal augend = new BigDecimal(y);
        return addend.add(augend).toString();
    }
}
