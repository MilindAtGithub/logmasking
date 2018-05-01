package com.milind.logmasking.logmasking.controller;

import com.milind.logmasking.logmasking.RequestProcessor;
import com.milind.logmasking.logmasking.logging.MyLogFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

@RestController
public class Controller {

    private static  Logger logger = MyLogFactory.getLogger(Controller.class);

    @Autowired
    RequestProcessor requestProcessor;

    @RequestMapping(value = "/postjson", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
    public String postjson(@RequestBody String json) throws Exception {

        logger.debug("Start Processing the Request");
        logger.debug("Request Object",json);
        String str = requestProcessor.processRequest(json);
        return  str;
    }
}
