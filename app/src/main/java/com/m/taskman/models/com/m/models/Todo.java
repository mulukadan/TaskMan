
package com.m.taskman.models.com.m.models;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "todo_id",
    "todo_group_id",
    "usr_id",
    "description",
    "note",
    "item_order",
    "status",
    "is_important",
    "is_today",
    "estimated_time",
    "date_created",
    "last_updated"
})
public class Todo {

    @JsonProperty("todo_id")
    private String todoId;
    @JsonProperty("todo_group_id")
    private Object todoGroupId;
    @JsonProperty("usr_id")
    private String usrId;
    @JsonProperty("description")
    private String description;
    @JsonProperty("note")
    private String note;
    @JsonProperty("item_order")
    private String itemOrder;
    @JsonProperty("status")
    private String status;
    @JsonProperty("is_important")
    private String isImportant;
    @JsonProperty("is_today")
    private String isToday;
    @JsonProperty("estimated_time")
    private String estimatedTime;
    @JsonProperty("date_created")
    private String dateCreated;
    @JsonProperty("last_updated")
    private String lastUpdated;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("todo_id")
    public String getTodoId() {
        return todoId;
    }

    @JsonProperty("todo_id")
    public void setTodoId(String todoId) {
        this.todoId = todoId;
    }

    @JsonProperty("todo_group_id")
    public Object getTodoGroupId() {
        return todoGroupId;
    }

    @JsonProperty("todo_group_id")
    public void setTodoGroupId(Object todoGroupId) {
        this.todoGroupId = todoGroupId;
    }

    @JsonProperty("usr_id")
    public String getUsrId() {
        return usrId;
    }

    @JsonProperty("usr_id")
    public void setUsrId(String usrId) {
        this.usrId = usrId;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("note")
    public String getNote() {
        return note;
    }

    @JsonProperty("note")
    public void setNote(String note) {
        this.note = note;
    }

    @JsonProperty("item_order")
    public String getItemOrder() {
        return itemOrder;
    }

    @JsonProperty("item_order")
    public void setItemOrder(String itemOrder) {
        this.itemOrder = itemOrder;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("is_important")
    public String getIsImportant() {
        return isImportant;
    }

    @JsonProperty("is_important")
    public void setIsImportant(String isImportant) {
        this.isImportant = isImportant;
    }

    @JsonProperty("is_today")
    public String getIsToday() {
        return isToday;
    }

    @JsonProperty("is_today")
    public void setIsToday(String isToday) {
        this.isToday = isToday;
    }

    @JsonProperty("estimated_time")
    public String getEstimatedTime() {
        return estimatedTime;
    }

    @JsonProperty("estimated_time")
    public void setEstimatedTime(String estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    @JsonProperty("date_created")
    public String getDateCreated() {
        return dateCreated;
    }

    @JsonProperty("date_created")
    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    @JsonProperty("last_updated")
    public String getLastUpdated() {
        return lastUpdated;
    }

    @JsonProperty("last_updated")
    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
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
