package ru.calculator;


import java.math.BigDecimal;
import java.math.MathContext;

public class VacationPayment {
    private final BigDecimal salary;
    private final int days;

    public VacationPayment(BigDecimal salary, int days) {
        if (salary.compareTo(BigDecimal.ZERO) < 0) throw new IllegalArgumentException("Salary can't be negative");

        if (days < 0) days = 0;
        if (days > 365) throw new IllegalArgumentException("Vacation days can't be greater than 365");

        this.salary = salary;
        this.days = days;
    }

    public VacationPayment(BigDecimal salary) {
        this(salary, 14);
    }

    public BigDecimal getSalary() {
        return salary;
    }

    private static final double DAY_IN_MONTH_RU = 29.3;
    private static final int MONTHS_IN_YEAR = 12;

    public BigDecimal getVacationPay() {
        if (days == 0) return BigDecimal.ZERO;
        BigDecimal vacationPayPerDay = getSalary()
                .divide(new BigDecimal(DAY_IN_MONTH_RU), MathContext.DECIMAL64)
                .divide(new BigDecimal(MONTHS_IN_YEAR), MathContext.DECIMAL64);
        return vacationPayPerDay.multiply(BigDecimal.valueOf(this.days));
    }
}
