package ru.calculator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class HolidaysServiceRu {
    private final Set<LocalDate> holidays = new HashSet<>();

    HolidaysServiceRu(LocalDate date) {
        loadHolidays(date);
    }

    public Set<LocalDate> getHolidays() {
        return new HashSet<>(this.holidays);
    }

    private void loadHolidays(LocalDate date) {
        List<String> dataStrings;
        try (InputStream inputStream = HolidaysServiceRu.class.getResourceAsStream("/holidaysRu.json")) {
            ObjectMapper mapper = new ObjectMapper();
            dataStrings = mapper.readValue(inputStream, new TypeReference<List<String>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException("Can't read file holidaysRu.json", e);
        }


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd");
        for (String dateString : dataStrings) {
            MonthDay monthDayDate = MonthDay.parse(dateString, formatter);
            LocalDate localDate = monthDayDate.atYear(date.getYear());
            if (date.isAfter(localDate)) {
                localDate = localDate.plusYears(1);
            }
            holidays.add(localDate);
        }
    }

    public int getHolidaysCount(LocalDate date, int days) {
        if (holidays.isEmpty()) throw new EmptyHolidaysRuntimeException("Holidays list is empty");

        int count = 0;
        for (int i = 0; i < days; i++) {
            LocalDate currentDate = date.plusDays(i);
            if (holidays.contains(currentDate)) {
                count++;
            }
        }
        return count;
    }

}
