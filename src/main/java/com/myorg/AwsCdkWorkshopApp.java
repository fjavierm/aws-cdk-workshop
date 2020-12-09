package com.myorg;

import software.amazon.awscdk.core.App;

public final class AwsCdkWorkshopApp {
    public static void main(final String[] args) {
        App app = new App();

        new AwsCdkWorkshopStack(app, "AwsCdkWorkshopStack");

        app.synth();
    }
}
