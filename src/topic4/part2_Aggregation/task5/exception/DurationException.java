package topic4.part2_Aggregation.task5.exception;

//import org.apache.log4j.Logger;

/**
 * EPAM Java0Practice. Topic 4. Part 2 (aggregation). Task 5.
 * My own exceptions class for duration period
 *
 * @author Natallia Bialiatskaya
 * @version 1.0
 * @since 03.08.2021
 */

public class DurationException extends Exception {

//    private static final Logger log = Logger.getLogger(DurationException.class);

    public DurationException () {
//            log.info("Exception is constructured: DurationException.");
    }

    public void myOwnExceptionMsg(String mes, int num1, int num2) {
//        log.error(mes + " is out of bounds (" + num1 + ".." + num2 + "). DurationException is thrown.");
    }

}
