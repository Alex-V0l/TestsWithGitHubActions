package TestPropertiesConfig;

import io.qameta.allure.model.StepResult;
import io.qameta.allure.listener.StepLifecycleListener;

public class Listener implements StepLifecycleListener{

    @Override
    public void beforeStepStart(StepResult result) {
        if (result.getName().toLowerCase().contains("password") || result.getName().toLowerCase().contains("login")) {
            result.getParameters().clear();
        }
    }
}
