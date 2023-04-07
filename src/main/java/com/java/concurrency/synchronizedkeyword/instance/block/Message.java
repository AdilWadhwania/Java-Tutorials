package com.java.concurrency.synchronizedkeyword.instance.block;

class Message
{
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Message(String message) {
        this.message = message;

    }
}
