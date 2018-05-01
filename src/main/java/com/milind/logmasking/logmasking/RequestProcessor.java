package com.milind.logmasking.logmasking;

import com.milind.logmasking.logmasking.logging.MyLogFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class RequestProcessor {

    private static Logger logger = MyLogFactory.getLogger(RequestProcessor.class);


    public String processRequest(String json){

        logger.debug("Starting Process the request in service");
        logger.debug("Actual Request",json);
        logger.debug(json);
        return "SUCCESS";
    }
}
