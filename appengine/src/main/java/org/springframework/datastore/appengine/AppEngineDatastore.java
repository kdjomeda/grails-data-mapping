package org.springframework.datastore.appengine;

import org.springframework.datastore.core.AbstractDatastore;
import org.springframework.datastore.core.Connection;
import org.springframework.datastore.keyvalue.mapping.KeyValueMappingContext;

import java.util.Map;

/**
 *
 * @author Graeme Rocher
 * @author Guillaume Laforge
 * 
 * @since 1.0
 */
public class AppEngineDatastore extends AbstractDatastore {

    
    // hard coded value of "gae" used for the keyspace since GAE manages spaces automatically
    public AppEngineDatastore() {
        super(new KeyValueMappingContext("gae"));
    }

    @Override
    protected Connection createConnection(Map<String, String> connectionDetails) {
        return new AppEngineConnection(connectionDetails, getMappingContext());
    }

}