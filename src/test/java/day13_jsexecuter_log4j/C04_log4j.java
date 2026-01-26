package day13_jsexecuter_log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

public class C04_log4j {

    @Test
    void test01() {

        Logger logger = LogManager.getLogger(C04_log4j.class);

        logger.info("Amazon web sitesine gidildi");
        logger.info("Arama kutuss locate edildi");
        logger.info("Arama kutusunda selenium aratıldı");

    }
}
