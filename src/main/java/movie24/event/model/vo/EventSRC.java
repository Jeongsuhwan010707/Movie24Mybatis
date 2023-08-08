package movie24.event.model.vo;

public class EventSRC {
	
	private String imageSRC;
	private int eventImgNum;

	public EventSRC() {}
	
	public EventSRC(String imageSRC) {
		super();
		this.imageSRC = imageSRC;
	}
	
	public String getImageSRC() {
		return imageSRC;
	}

	public EventSRC(int eventImgNum) {
		super();
		this.eventImgNum = eventImgNum;
	}

	public void setImageSRC(String imageSRC) {
		this.imageSRC = imageSRC;
	}

	public int getEventImgNum() {
		return eventImgNum;
	}

	public void setEventImgNum(int eventImgNum) {
		this.eventImgNum = eventImgNum;
	}
	
}
