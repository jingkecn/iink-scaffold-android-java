/*
 * Copyright (c) MyScript. All rights reserved.
 */

package com.myscript.iink.app;

import com.myscript.iink.Engine;

/**
 * Defines a MyScript Interactive Ink application.
 */
public interface IInteractiveInkApplication {

    /**
     * Gets MyScript Interactive Ink runtime [Engine].
     *
     * @return MyScript Interactive Ink runtime.
     */
    Engine getEngine();
}
