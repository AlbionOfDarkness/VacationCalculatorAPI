package ru.calculator;


import java.math.BigDecimal;



public class BaseResponse {
    private final BigDecimal vacationPayment;
    private final int holidayDays;
    private final int paymentVacationDays;

    public BaseResponse(BigDecimal vacationPayment, int holidayDays, int paymentVacationDays) {
        this.vacationPayment = vacationPayment;
        this.holidayDays = holidayDays;
        this.paymentVacationDays = paymentVacationDays;
    }

    public BigDecimal getVacationPayment() {
        return vacationPayment;
    }

    public int getHolidayDays() {
        return holidayDays;
    }

    public int getPaymentVacationDays() {
        return paymentVacationDays;
    }
}
