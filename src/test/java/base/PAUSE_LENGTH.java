package base;

/**
 * Created by yanusovaaa on 11/30/2015.
 */
public enum PAUSE_LENGTH {

    MAX(60),
    MIN(5),
    AJAX(10),
    AVG(30);


    private Integer value;

    private PAUSE_LENGTH(Integer value) {
        this.value = value;
    }

    public Integer value() {
        return this.value;
    }
}
