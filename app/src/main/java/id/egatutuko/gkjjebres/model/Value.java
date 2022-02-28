package id.egatutuko.gkjjebres.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Value {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("value")
    @Expose
    private String value;
    @SerializedName("result")
    @Expose
    private List<RenunganModel> result = null;
    @SerializedName("resuts")
    @Expose
    private  List<WartaModel> resuts = null;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<WartaModel> getResuts() {
        return resuts;
    }

    public void setResuts(List<WartaModel> resuts) {
        this.resuts = resuts;
    }

    public List<RenunganModel> getResult() {
        return result;
    }

    public void setResult(List<RenunganModel> result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}