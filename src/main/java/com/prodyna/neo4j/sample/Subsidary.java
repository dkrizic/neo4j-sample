package com.prodyna.neo4j.sample;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Subsidary {

    @GraphId
    private long graphId;
    private Long id;
    private String name;

    public long getGraphId() {
        return graphId;
    }

    public void setGraphId(long graphId) {
        this.graphId = graphId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
