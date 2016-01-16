package com.wujh.test;

import java.util.Date;

import org.apache.log4j.Logger;

public class LogTest {

	public static Logger logger = Logger.getLogger(LogTest.class);
    public static void main(String[] args) {
        // TODO Auto-generated method stub    
        String log="log4»’÷æ≤‚ ‘";
        logger.info(log+" @@@ "+new Date());   
        logger.error(log+" @@@ "+new Date());
        logger.warn(log+" @@@ "+new Date());
    }
}
