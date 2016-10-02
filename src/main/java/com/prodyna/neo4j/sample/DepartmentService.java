package com.prodyna.neo4j.sample;

// import org.neo4j.driver.v1.Values;

import org.neo4j.ogm.session.Session;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DepartmentService {

    private final Session session;

    public DepartmentService( Session session ) {
        this.session = session;
    }

    Collection<Department> findAllDepartments() {
        return session.loadAll( Department.class );
    }

    Department findByName(String name ) {
        Map<String,String> props = new HashMap<>();
        props.put("name", name );
        return session.query( Department.class,
                "match (d:Department {name:{name}))-[:LOCATED_IN]->(s:Subsidary)", props ).iterator().next();
    }

}
