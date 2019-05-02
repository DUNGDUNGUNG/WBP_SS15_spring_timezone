package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;

@Controller
public class TimeController {

    @GetMapping("/worldclock")
    public String getTimeByTimeZone(ModelMap model, @RequestParam(name = "city", required = false, defaultValue = "Asia/Ho_Chi_Minh") String city) {
        // co duoc thoi gian hien tai tai dia phuong
        Date date = new Date();
        // lay mui gio cua dia phuong
        TimeZone local = TimeZone.getDefault();
        // lay mui gio cua thanh pho duoc chi dinh
        TimeZone locale = TimeZone.getTimeZone(city);

        // tinh thoi gian hien tai trong thanh pho duoc chi dinh
        long locale_time = date.getTime() +
                (locale.getRawOffset() - local.getRawOffset());
        //dat lai ngay theo gio dia phuong
        date.setTime(locale_time);


        // da gui data gui den view
        model.addAttribute("city", city);
        model.addAttribute("date",date);
        return "index";
    }

}
