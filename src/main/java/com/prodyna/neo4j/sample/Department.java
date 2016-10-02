package com.prodyna.neo4j.sample;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

@NodeEntity
public class Department {

    @GraphId
    private Long graphId;

    private String id;
    private String name;

    @Relationship(type="LOCATED_IN")
    private Set<Subsidary> subsidaries = new HashSet<Subsidary>();

    public Long getGraphId() {
        return graphId;
    }

    public void setGraphId(Long graphId) {
        this.graphId = graphId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Subsidary> getSubsidaries() {
        return subsidaries;
    }

    public void setSubsidaries(Set<Subsidary> subsidaries) {
        this.subsidaries = subsidaries;
    }

}
