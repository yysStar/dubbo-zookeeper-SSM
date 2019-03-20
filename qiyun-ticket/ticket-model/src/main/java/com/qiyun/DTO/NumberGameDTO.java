package com.qiyun.DTO;

public class NumberGameDTO {
    private IssueForNumberGameDTO issue;
    private TicketForNumberGameDTO[] ticket;

    public IssueForNumberGameDTO getIssue() {
        return issue;
    }

    public void setIssue(IssueForNumberGameDTO issue) {
        this.issue = issue;
    }

    public TicketForNumberGameDTO[] getTicket() {
        return ticket;
    }

    public void setTicket(TicketForNumberGameDTO[] ticket) {
        this.ticket = ticket;
    }
}
