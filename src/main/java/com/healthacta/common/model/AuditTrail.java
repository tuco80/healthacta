package com.healthacta.common.model;

import java.time.LocalDateTime;
import java.util.UUID;

import com.healthacta.common.model.enums.TableOperation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "audit_trail")
public class AuditTrail {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long id;

    @Column(name = "entity_id")
    private String entityId;

    @Column(name = "old_value")
    private String oldValue;

    @Column(name = "transaction_id")
    private UUID transactionId;

    @Column(name = "operation_id_fk")
    @Enumerated(EnumType.ORDINAL)
    private TableOperation operation;

    @Column(name = "table_id_fk")
    private int tableId;

    @Column(name = "last_updated_date")
    private LocalDateTime updatedDate;

    @Column(name = "last_updated_by")
    private String updatedBy;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(UUID transactionId) {
        this.transactionId = transactionId;
    }

    public TableOperation getOperation() {
        return operation;
    }

    public void setOperation(TableOperation operation) {
        this.operation = operation;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((entityId == null) ? 0 : entityId.hashCode());
        result = prime * result + ((oldValue == null) ? 0 : oldValue.hashCode());
        result = prime * result + ((transactionId == null) ? 0 : transactionId.hashCode());
        result = prime * result + ((operation == null) ? 0 : operation.hashCode());
        result = prime * result + tableId;
        result = prime * result + ((updatedDate == null) ? 0 : updatedDate.hashCode());
        result = prime * result + ((updatedBy == null) ? 0 : updatedBy.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AuditTrail other = (AuditTrail) obj;
        if (id != other.id)
            return false;
        if (entityId == null) {
            if (other.entityId != null)
                return false;
        } else if (!entityId.equals(other.entityId))
            return false;
        if (oldValue == null) {
            if (other.oldValue != null)
                return false;
        } else if (!oldValue.equals(other.oldValue))
            return false;
        if (transactionId == null) {
            if (other.transactionId != null)
                return false;
        } else if (!transactionId.equals(other.transactionId))
            return false;
        if (operation != other.operation)
            return false;
        if (tableId != other.tableId)
            return false;
        if (updatedDate == null) {
            if (other.updatedDate != null)
                return false;
        } else if (!updatedDate.equals(other.updatedDate))
            return false;
        if (updatedBy == null) {
            if (other.updatedBy != null)
                return false;
        } else if (!updatedBy.equals(other.updatedBy))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "AuditTrail [id=" + id + ", entityId=" + entityId + 
        ", oldValue=" + oldValue + ", transactionId=" + transactionId + 
        ", operation=" + operation + ", tableId=" + tableId + 
        ", updatedDate=" + updatedDate + ", updatedBy=" + updatedBy + "]";
    }

}
