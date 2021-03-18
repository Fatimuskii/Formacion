package com.formacion.pr5WebSocket.domains;

public class OutboundMessage {
	private String content;

	public OutboundMessage() {
	    }

	public OutboundMessage(String content) {
	      this.content = content;
	    }

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
