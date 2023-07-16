public class Cell  {

	private Object value;
    private Color color;
    private Type type; 

    public Cell() {

    	this.value = null;
    	this.color = Color.WHITE;
    	this.type = Type.STRING;
    }

    public void setValue(Object value) {
    	this.value = value;
    }

    public Object getValue() {
    	return value;
    }

    public Type getType() {
    	return type;
    }

    public void setColor(Color color) {
    	this.color = color;
    }


    public Color getColor() {
        return color;
    }


    public void reset() {
        this.value = null;
        this.color = Color.WHITE;
    }

}