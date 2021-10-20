package com.dgarg20.test1.models;

/**
 * Created by Deepanshu Garg on 01/02/21.
 */
public class TicketStatusResponse {
    int id;
    String status;
    String comment;
    String resolvedBy;
    String verifiedBy;

    public TicketStatusResponse(int id, String status, String comment, String resolvedBy, String verifiedBy) {
        this.id = id;
        this.status = status;
        this.comment = comment;
        this.resolvedBy = resolvedBy;
        this.verifiedBy = verifiedBy;
    }

    public String getStatus() {
        return status;
    }

    public String getResolvedBy() {
        return resolvedBy;
    }
}
