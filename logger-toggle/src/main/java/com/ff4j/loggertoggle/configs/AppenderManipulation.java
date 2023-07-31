package com.ff4j.loggertoggle.configs;



import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Appender;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class AppenderManipulation {

    private LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
    private Logger rootLogger= loggerContext.getLogger(Logger.ROOT_LOGGER_NAME);
    private List<Appender<ILoggingEvent>> lsAppender= new ArrayList<>();

    public void saveAllAppenders() {
        System.out.println("ENTERED saveAllAppenders");
        loggerContext.getLoggerList().stream().forEach(logger -> {
            logger.iteratorForAppenders().forEachRemaining(iLoggingEventAppender ->
                    lsAppender.add(iLoggingEventAppender));
        });
        lsAppender.stream().forEach(iLoggingEventAppender ->
                System.out.println("In list of appenders :: "+iLoggingEventAppender.getName()+" :: isStarted :: "+iLoggingEventAppender.isStarted())
        );
        System.out.println("EXIT saveAllAppenders");
    }

    public void removeAppender(String appenderName)
    {
        System.out.println("ENTERED removeAppender");
        Appender<ILoggingEvent> appenderToRemove=rootLogger.getAppender(appenderName);
        if(appenderToRemove != null)
        {
            System.out.println(appenderToRemove.getName()+" :: isStarted :: "+appenderToRemove.isStarted());
            appenderToRemove.stop();
            System.out.println(appenderToRemove.getName()+" :: isStarted :: "+appenderToRemove.isStarted());
            rootLogger.detachAppender(appenderName);
        }
        lsAppender.stream().forEach(iLoggingEventAppender ->
                System.out.println("In list of appenders :: "+iLoggingEventAppender.getName()+" :: isStarted :: "+iLoggingEventAppender.isStarted())
        );
        System.out.println("EXIT removeAppender");
    }

    public void addAppender(String appenderName)
    {
        System.out.println("ENTERED addAppender");
        AtomicReference<Appender<ILoggingEvent>> appender = new AtomicReference<>();
        lsAppender.stream().forEach(iLoggingEventAppender -> {
            if (iLoggingEventAppender.getName().equalsIgnoreCase(appenderName)) {
                System.out.println(iLoggingEventAppender.getName()+ " :: isStarted :: "+iLoggingEventAppender.isStarted());
                appender.set(iLoggingEventAppender);
            }
        });
        if(appender.get()!=null) {
            appender.get().start();
            System.out.println(appender.get().getName() + " :: isStarted :: " + appender.get().isStarted());
            rootLogger.addAppender(appender.get());
        }

        lsAppender.stream().forEach(iLoggingEventAppender ->
                System.out.println("In list of appenders :: "+iLoggingEventAppender.getName()+" :: isStarted :: "+iLoggingEventAppender.isStarted())
        );

        System.out.println("EXIT addAppender");
    }
}

