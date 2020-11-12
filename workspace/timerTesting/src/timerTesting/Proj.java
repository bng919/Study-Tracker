package timerTesting;

public class Proj {
	private String label;
	private long time;
	
	public void updateTime(long timeElapsed) {
		this.time += timeElapsed;
	}
	
	public Proj(String label) {
		this.label = label;
		this.time = 0;
	}
	
	public Proj(String label, long time) {
		this.label = label;
		this.time = time;
	}
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}
	
}
