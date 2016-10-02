package com.prodyna.neo4j.sample;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.neo4j.harness.junit.Neo4jRule;
import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DepartmentServiceTest {

    private DepartmentService departmentService;

    @Rule
    public Neo4jRule neo4jRule = new Neo4jRule()
            .withConfig("dbms.security.auth_enabled", "false")
            .copyFrom( new File("src/test/resources/data") );

    @Before
    public void prepareSession() {
        departmentService = new DepartmentService( createSession() );
    }

    @Test
    public void readDepartmentsWithSubsidaries() {
        Collection<Department> departments = departmentService.findAllDepartments();
        Assert.assertNotNull( departments );
        Assert.assertEquals( 6, departments.size() );
        departments.forEach( department -> {
            if (department.getName().equals("Sales")) {
                List<String> subNames = new ArrayList<>();
                for (Subsidary sub : department.getSubsidaries()) {
                    subNames.add(sub.getName());
                    System.out.println(sub.getName());
                }
                Assert.assertTrue(subNames.contains("New York"));
                Assert.assertTrue(subNames.contains("Los Angeles"));
            }
        });
    }

    private Session createSession() {
        Configuration configuration = new Configuration();
        configuration
                .driverConfiguration()
                .setDriverClassName("org.neo4j.ogm.drivers.bolt.driver.BoltDriver")
                .setEncryptionLevel( "NONE" )
                .setURI("bolt://localhost:5001");
        return new SessionFactory( configuration, "com.prodyna.neo4j.sample").openSession();
    }

}
