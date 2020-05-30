package ru.home.test.component;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("application")
public class Properties {

    private boolean customProperty;

    public boolean isCustomProperty() {
        return customProperty;
    }

    public void setCustomProperty(boolean customProperty) {
        this.customProperty = customProperty;
    }
}
