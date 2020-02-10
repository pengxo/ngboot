package com.pengxo.jms;

import java.util.Objects;

public class JmsMessage {

	private long id;

	private String content;

	private String level;

	public JmsMessage() {

	}

	public JmsMessage(final long id, final String content, final String level) {
		this.id = id;
		this.content = content;
		this.level = level;
	}

	public long getId() {
		return id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(final String content) {
		this.content = content;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(final String level) {
		this.level = level;
	}

	@Override
	public int hashCode() {
		return Objects.hash(content, id, level);
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final JmsMessage other = (JmsMessage) obj;
		return Objects.equals(content, other.content) && id == other.id && Objects.equals(level, other.level);
	}

	@Override
	public String toString() {
		return "JmsMessage [id=" + id + ", content=" + content + ", level=" + level + "]";
	}

}
