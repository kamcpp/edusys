package org.labcrypto.edusys.ejb.membership;

import java.util.UUID;

public class EdusysToken implements Token {

    private boolean expired;
    private boolean disabled;
    private int duration;
    private long issueDate;
    private String value;

    public EdusysToken() {
        value = UUID.randomUUID() + "-" + UUID.randomUUID();
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean expired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    @Override
    public long issueDate() {
        return issueDate;
    }

    public void setIssueDate(long issueDate) {
        this.issueDate = issueDate;
    }

    @Override
    public int duration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public boolean disabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof EdusysToken) {
            return value.equals(((EdusysToken) obj).value);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
