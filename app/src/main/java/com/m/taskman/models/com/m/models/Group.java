
package com.m.taskman.models.com.m.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "group_id",
    "group_name",
    "is_today",
    "group_order",
    "total_todos",
    "todos"
})
public class Group {

    @JsonProperty("group_id")
    private Object groupId;
    @JsonProperty("group_name")
    private String groupName;
    @JsonProperty("is_today")
    private Object isToday;
    @JsonProperty("group_order")
    private Object groupOrder;
    @JsonProperty("total_todos")
    private Object totalTodos;
    @JsonProperty("todos")
    private List<com.m.taskman.models.com.m.models.Todo> todos = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("group_id")
    public Object getGroupId() {
        return groupId;
    }

    @JsonProperty("group_id")
    public void setGroupId(Object groupId) {
        this.groupId = groupId;
    }

    @JsonProperty("group_name")
    public String getGroupName() {
        return groupName;
    }

    @JsonProperty("group_name")
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @JsonProperty("is_today")
    public Object getIsToday() {
        return isToday;
    }

    @JsonProperty("is_today")
    public void setIsToday(Object isToday) {
        this.isToday = isToday;
    }

    @JsonProperty("group_order")
    public Object getGroupOrder() {
        return groupOrder;
    }

    @JsonProperty("group_order")
    public void setGroupOrder(Object groupOrder) {
        this.groupOrder = groupOrder;
    }

    @JsonProperty("total_todos")
    public Object getTotalTodos() {
        return totalTodos;
    }

    @JsonProperty("total_todos")
    public void setTotalTodos(Object totalTodos) {
        this.totalTodos = totalTodos;
    }

    @JsonProperty("todos")
    public List<Todo> getTodos() {
        return todos;
    }

    @JsonProperty("todos")
    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
