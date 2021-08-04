package topic4.part2_Aggregation.task5.actions;

import topic4.part2_Aggregation.task5.enums.*;
import topic4.part2_Aggregation.task5.exceptions.DurationException;

/**
 * EPAM Java0Practice. Topic 4. Part 2 (aggregation). Task 5.
 * VALIDATION: check if travel items wright
 *
 * @author Natallia Bialiatskaya
 * @version 1.0
 * @since 03.08.2021
 */

public class TravelValidator {

    //    private static final Logger log = Logger.getLogger(TravelValidator.class);
    private static final int DURATION_FROM = 1;
    private static final int DURATION_TO = 60;

    public TravelValidator() {
    }

    private boolean catchException(String argument, String name, Exception e) {
//        log.error("Argument '" + argument + "' for enum '" + name + "' is of wrong type.");
        e.printStackTrace();
        return false;
    }

    public boolean isExceptionString(String strValue) {
        boolean isException = false;

        if (String.valueOf(strValue) == null) {
            isException = true;
//            log.error("Argument '" + strValue + "' is of wrong type.");
        }
        return isException;
    }

    public boolean isExceptionInt(int quantity, String mes, int num1, int num2) {
        boolean isException = false;

        try {
            if (quantity < num1 || quantity > num2) {
                isException = true;
                throw new DurationException();
            }
        } catch (DurationException e) {
            e.printStackTrace();
        }

        return isException;
    }

    public boolean isTravel(String travel, String transport, String catering, int duration, String departure,
                                   String destination) {
        boolean isTravelOk = true;
        isTravelOk = isTravelTypeOK(travel, isTravelOk);
        isTravelOk = isTransportTypeOK(transport, isTravelOk);
        isTravelOk = isCateringTypeOK(catering, isTravelOk);
        isTravelOk = isDurationOK(duration, isTravelOk);
        isTravelOk = isCityOK(departure, isTravelOk, "departure point");
        isTravelOk = isCityOK(destination, isTravelOk, "destination point");

        return isTravelOk;
    }

    private boolean isCityOK(String city, boolean isTravelOk, String message) {
        try {
            City.valueOf(city);
        } catch (IllegalArgumentException e) {
            isTravelOk = catchException(city, message, e);
        }
        return isTravelOk;
    }

    private boolean isDurationOK(int duration, boolean isTravelOk) {
        if (isExceptionInt(duration, "Duration period", DURATION_FROM, DURATION_TO))
            isTravelOk = false;
        return isTravelOk;
    }

    private boolean isCateringTypeOK(String catering, boolean isTravelOk) {
        try {
            CateringType.valueOf(catering);
        } catch (IllegalArgumentException e) {
            isTravelOk = catchException(catering, "catering", e);
        }
        return isTravelOk;
    }

    private boolean isTransportTypeOK(String transport, boolean isTravelOk) {
        try {
            TransportType.valueOf(transport);
        } catch (IllegalArgumentException e) {
            isTravelOk = catchException(transport, "transport", e);
        }
        return isTravelOk;
    }

    private boolean isTravelTypeOK(String travel, boolean isTravelOk) {
        try {
            TravelType.valueOf(travel);
        } catch (IllegalArgumentException e) {
            isTravelOk = catchException(travel, "travel", e);
        }
        return isTravelOk;
    }
}
