package model;

public class Profession {
	String title;
	Area area;
	Level level;
	
	public Profession(String title, Area area, Level level) {
		this.title = title;
		this.area = area;
		this.level = level;
	}
	
	public String getTitle() {
		return title;
	}
	
	public Area getArea() {
		return area;
	}
	
	public Level getLevel() {
		return level;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setArea(Area area) {
		this.area = area;
	}
	
	public void setLevel(Level level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "Profession [title=" + title + ", area=" + area + ", level=" + level + "]";
	}
}

enum Level{
	JUNIOR,
	MIDDLE,
	SENIOR
}

enum Area {
	TECHNOLOGY,
	HUMAN_RESOURCES,
	MANAGEMENT,
	QUALITY,
	OPERATIONS,
	ENGINEERING
}
