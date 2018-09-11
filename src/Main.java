import calendar.EDT;
import parser.ICSParser;

import java.io.IOException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws IOException {

        ICSParser parser = new ICSParser("https://edt.inp-toulouse.fr/jsp/custom/modules/plannings/anonymous_cal.jsp?resources=3397,185&projectId=42&calType=ical&firstDate=2018-08-01&lastDate=2019-07-15");

        EDT edt = new EDT();
        edt.buildCalendarFromICSFile(parser);
        System.out.println(edt.toString());


    }

}
