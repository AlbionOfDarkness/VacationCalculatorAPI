package ru.calculator;

import lombok.Getter;

import java.math.BigDecimal;


@Getter
public class BaseResponse {
    private final BigDecimal vacationPayment;
    private final int holidayDays;
    private final int paymentVacationDays;

    public BaseResponse(BigDecimal vacationPayment, int holidayDays, int paymentVacationDays) {
        this.vacationPayment = vacationPayment;
        this.holidayDays = holidayDays;
        this.paymentVacationDays = paymentVacationDays;
    }

}
