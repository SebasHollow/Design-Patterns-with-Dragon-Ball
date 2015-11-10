package com.hollow.sebas.dragonballdesignpattern.ExtensionObject;

import java.util.HashMap;

/**
 * Created by Sebastian Hollow on 10/11/2015 Dragon Ball Design Pattern.
 */
public interface Extendable {
    HashMap<String, Extension> m_extensions = new HashMap<>();

    void addExtension(String key, Extension extensionObject);

    void removeExtension(String key);

    Extension getExtension(String key);
}
