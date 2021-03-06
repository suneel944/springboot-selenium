package com.auto.spring.springselenium.framework.scope;

import java.util.Objects;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.SimpleThreadScope;

public class BrowserScope extends SimpleThreadScope
{
    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        Object obj = super.get(name, objectFactory);
        SessionId sessionId = ((RemoteWebDriver)obj).getSessionId();
        if (Objects.isNull(sessionId))
        {
            super.remove(name);
            super.get(name, objectFactory);
        }
        return obj;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
        /*The parent implementation provides a log which is not
        required in this project context. Hence overridden*/
    }
}
