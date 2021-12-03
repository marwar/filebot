package pl.marwar.filebot.scripts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode
@AllArgsConstructor
public class Action implements Serializable {

    private final static long serialVersionUID = 5321685044186852023L;
    @SerializedName("actionName")
    @Expose
    private String actionName;
    @SerializedName("actionParam")
    @Expose
    private String actionParam;


}