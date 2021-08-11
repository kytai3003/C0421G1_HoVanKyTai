package model.bean;

public class EmployeePosition {
    private int positionId;
    private String positionName;

    public EmployeePosition(int positionId, String positionName) {
        this.positionId = positionId;
        this.positionName = positionName;
    }

    public EmployeePosition() {
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }
}
