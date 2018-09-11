package calendar;

import parser.ICSParser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class EDT {

    private ArrayList<Event> events;

    public EDT() {
        events = new ArrayList<>();
    }

    public void buildCalendarFromICSFile(ICSParser icsParser) {

        while (!icsParser.searchNextKey("BEGIN").equals("")) {
            Date eventDateStart = ICSParser.parseICSTimestamp(icsParser.searchNextKey("DTSTART"));
            Date eventDateEnd = ICSParser.parseICSTimestamp(icsParser.searchNextKey("DTEND"));
            String eventMatiere = icsParser.searchNextKey("SUMMARY");
            String eventSalle = icsParser.searchNextKey("LOCATION");
            String eventDescription = icsParser.searchNextKey("DESCRIPTION");

            if(eventDateStart != null && eventDateEnd != null) {
                eventDateStart.setTime(eventDateStart.getTime() + 7200000);
                eventDateEnd.setTime(eventDateEnd.getTime() + 7200000);
            }
            addEvent(new Event(
                    eventDateStart,
                    eventDateEnd,
                    eventMatiere,
                    eventSalle,
                    eventDescription
            ));

        }
        Collections.sort(events);
    }

    public boolean addEvent(Event newEvent) {
        return newEvent.getDateDebut() != null && events.add(newEvent);
    }

    @Override
    public String toString() {
        return "Calendar{" +
                "events=" + events +
                '}';
    }
}
