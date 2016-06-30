package com.alkimsoft.sandbox.auth;

import java.util.UUID;

/**
 * Created by doğukan on 30.06.2016.
 */
public class TokenGenaretor {
    public static UUID generate() {
        return UUID.randomUUID();
    }
}
