package com.formacion.pr5WebSocket.domains;

public class InboundMessage {
	private String content;

	public InboundMessage() {
	}

	public InboundMessage(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
