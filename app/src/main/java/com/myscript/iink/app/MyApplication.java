/*
 * Copyright (c) MyScript. All rights reserved.
 */

package com.myscript.iink.app;

import android.app.Application;
import com.myscript.certificate.MyCertificate;
import com.myscript.iink.Configuration;
import com.myscript.iink.Engine;

public class MyApplication extends Application implements IInteractiveInkApplication {

    private Engine engine;

    @Override
    public void onCreate() {
        super.onCreate();
        // Create MyScript interactive ink engine.
        // Please make sure that you have a valid active certificate.
        // If not, please get one from MyScript Developer:
        // - https://developer.myscript.com/getting-started
        engine = Engine.create(MyCertificate.getBytes());
        // configure MyScript interactive ink engine.
        Configuration configuration = engine.getConfiguration();
        // configure the directories where to find *.conf.
        configuration.setStringArray(
                "configuration-manager.search-path",
                new String[]{"zip://" + getPackageCodePath() + "!/assets/conf"}
        );
        // configure a temporary directory.
        configuration.setString("content-package.temp-folder", "${filesDir.path}${File.separator}tmp");
    }

    @Override
    public void onTerminate() {
        // close MyScript iink runtime to release resources.
        engine.close();
        super.onTerminate();
    }

    @Override
    public Engine getEngine() {
        return engine;
    }
}
