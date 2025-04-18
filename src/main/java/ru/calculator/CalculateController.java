package ru.calculator;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
@RequestMapping("/calculate")
public class CalculateController {

    @GetMapping
    public BaseResponse calculate(
            @RequestParam BigDecimal salary,
            @RequestParam int days,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        HolidaysServiceRu holidaysForThatYear = new HolidaysServiceRu(date);
        VacationPayment calculator = new VacationPayment(salary, days - holidaysForThatYear.getHolidaysCount(date, days));
        return new BaseResponse(
                calculator.getVacationPay(),
                holidaysForThatYear.getHolidaysCount(date, days),
                days - holidaysForThatYear.getHolidaysCount(date, days)
        );
    }
}
