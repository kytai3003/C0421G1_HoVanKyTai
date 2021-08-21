package model.bean;

public class Catelogy {
    private int idCatelogy;
    private String nameCatelogy;

    public Catelogy(int idCatelogy, String nameCatelogy) {
        this.idCatelogy = idCatelogy;
        this.nameCatelogy = nameCatelogy;
    }

    public Catelogy() {
    }

    public int getIdCatelogy() {
        return idCatelogy;
    }

    public void setIdCatelogy(int idCatelogy) {
        this.idCatelogy = idCatelogy;
    }

    public String getNameCatelogy() {
        return nameCatelogy;
    }

    public void setNameCatelogy(String nameCatelogy) {
        this.nameCatelogy = nameCatelogy;
    }
}
